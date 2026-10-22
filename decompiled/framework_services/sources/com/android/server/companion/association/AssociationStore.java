package com.android.server.companion.association;

import android.companion.AssociationInfo;
import android.companion.IOnAssociationsChangedListener;
import android.content.Context;
import android.content.pm.UserInfo;
import android.net.MacAddress;
import android.os.Binder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.UserManager;
import android.util.Slog;
import com.android.internal.util.CollectionUtils;
import com.android.server.companion.utils.MetricUtils;
import com.android.server.companion.utils.PermissionsUtils;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class AssociationStore {
    public static final int CHANGE_TYPE_ADDED = 0;
    public static final int CHANGE_TYPE_REMOVED = 1;
    public static final int CHANGE_TYPE_UPDATED_ADDRESS_CHANGED = 2;
    public static final int CHANGE_TYPE_UPDATED_ADDRESS_UNCHANGED = 3;
    private static final String TAG = "CDM_AssociationStore";
    private final Context mContext;
    private final AssociationDiskStore mDiskStore;
    private final ExecutorService mExecutor;
    private final Map<Integer, AssociationInfo> mIdToAssociationMap;
    private final Set<OnChangeListener> mLocalListeners;
    private final Object mLock;
    private int mMaxId;
    private boolean mPersisted;
    private final RemoteCallbackList<IOnAssociationsChangedListener> mRemoteListeners;
    private final UserManager mUserManager;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChangeType {
    }

    public interface OnChangeListener {
        default void onAssociationChanged(int changeType, AssociationInfo association) {
            switch(changeType) {
                case 0: goto L7;
                case 1: goto L6;
                case 2: goto L5;
                case 3: goto L4;
                default: goto L12;
            };
        L4:
            onAssociationUpdated(association, false);
            return;
        L5:
            onAssociationUpdated(association, true);
            return;
        L6:
            onAssociationRemoved(association);
            return;
        L7:
            onAssociationAdded(association);
            return;
        }

        default void onAssociationAdded(AssociationInfo association) {
        }

        default void onAssociationRemoved(AssociationInfo association) {
        }

        default void onAssociationUpdated(AssociationInfo association, boolean addressChanged) {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$3MFCQYAaKw3hW3B_8DXfXy-ypXc, reason: not valid java name */
    public static /* synthetic */ void m2905$r8$lambda$3MFCQYAaKw3hW3B_8DXfXyypXc(AssociationStore r0, int r1) {
        r0.lambda$writeCacheToDisk$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$6UNfG1O_umewJpaaCymv-epvW3M, reason: not valid java name */
    public static /* synthetic */ boolean m2906$r8$lambda$6UNfG1O_umewJpaaCymvepvW3M(int r0, AssociationInfo r1) {
        return lambda$writeCacheToDisk$1(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$BRkrZb8ynhviyAR7u9OmaFg4lm8(String r0, int r1, AssociationInfo r2) {
        return lambda$getRevokedAssociations$9(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$DvwHfwHktxXwlKwUoIDSpFBxppI(String r0, AssociationInfo r1) {
        return lambda$getAssociationsByPackage$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$HF99kZmAfa36vlKVuqVcVO7x-p8, reason: not valid java name */
    public static /* synthetic */ void m2907$r8$lambda$HF99kZmAfa36vlKVuqVcVO7xp8(AssociationStore r0) {
        r0.lambda$refreshCache$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$WqPp7Sx6IUzRAOyWj-ZI9V7ufMc, reason: not valid java name */
    public static /* synthetic */ boolean m2908$r8$lambda$WqPp7Sx6IUzRAOyWjZI9V7ufMc(String r0, AssociationInfo r1) {
        return lambda$getActiveAssociationsByPackage$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$_H3C90k_pJxrsTFh8oQiDM9sZ48(int r0, List r1, IOnAssociationsChangedListener r2, Object r3) {
        lambda$broadcastChange$11(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$iBu2fKpSoYrXZchOsV91MofWIy0(int r0, AssociationInfo r1) {
        return lambda$getActiveAssociationsByUser$4(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$kbDu5Jw53dOi6mwN8QBQl_cBO1I(String r0, AssociationInfo r1) {
        return lambda$getActiveAssociationsByAddress$8(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$mvRyqfUentvYolYg2fq--QGmwRs, reason: not valid java name */
    public static /* synthetic */ boolean m2909$r8$lambda$mvRyqfUentvYolYg2fqQGmwRs(String r0, int r1, AssociationInfo r2) {
        return lambda$getPendingAssociations$10(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$qIFnSrTpyjnN2HFxj9CQjwsoocE(String r0, AssociationInfo r1) {
        return lambda$getFirstAssociationByAddress$7(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$z7yJq3ugyUSUKLz2Va7wt8hF3Fs(int r0, AssociationInfo r1) {
        return lambda$getAssociationsByUser$3(r0, r1);
    }

    public AssociationStore(Context context, UserManager userManager, AssociationDiskStore diskStore) {
        this.mLock = new Object();
        this.mPersisted = false;
        this.mIdToAssociationMap = new HashMap();
        this.mMaxId = 0;
        this.mLocalListeners = new LinkedHashSet();
        this.mRemoteListeners = new RemoteCallbackList();
        this.mContext = context;
        this.mUserManager = userManager;
        this.mDiskStore = diskStore;
        this.mExecutor = Executors.newSingleThreadExecutor();
    }

    public void refreshCache() {
        Binder.withCleanCallingIdentity(new AssociationStore$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$refreshCache$0() throws Exception {
        List<Integer> userIds = new ArrayList();
        Iterator r1 = this.mUserManager.getAliveUsers().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        UserInfo user = (UserInfo) r1.next();
        userIds.add(Integer.valueOf(user.id));
        goto L4
    L6:
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mPersisted = false;     // Catch: Throwable -> L16
        this.mIdToAssociationMap.clear();     // Catch: Throwable -> L16
        this.mMaxId = 0;     // Catch: Throwable -> L16
        Map<Integer, Associations> userToAssociationsMap = this.mDiskStore.readAssociationsByUsers(userIds);     // Catch: Throwable -> L16
        Iterator<Map.Entry<Integer, Associations>> r3 = userToAssociationsMap.entrySet().iterator();     // Catch: Throwable -> L16
    L11:
        if (r3.hasNext() == false) goto L19;
        Map.Entry<Integer, Associations> entry = r3.next();     // Catch: Throwable -> L16
        Iterator<AssociationInfo> r5 = entry.getValue().getAssociations().iterator();     // Catch: Throwable -> L16
    L14:
        if (r5.hasNext() == false) goto L18;
        AssociationInfo association = r5.next();     // Catch: Throwable -> L16
        this.mIdToAssociationMap.put(Integer.valueOf(association.getId()), association);     // Catch: Throwable -> L16
        goto L14
    L18:
        this.mMaxId = Math.max(this.mMaxId, entry.getValue().getMaxId());     // Catch: Throwable -> L16
        goto L11
    L19:
        this.mPersisted = true;     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public int getMaxId() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mMaxId;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getNextId() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = getMaxId() + 1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void addAssociation(AssociationInfo association) {
        Slog.i(TAG, "Adding new association=[" + association + "]...");
        int id = association.getId();
        int userId = association.getUserId();
        Object r2 = this.mLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIdToAssociationMap.containsKey(Integer.valueOf(id)) == false) goto L11;
        Slog.e(TAG, "Association id=[" + id + "] already exists.");     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L11:
        this.mIdToAssociationMap.put(Integer.valueOf(id), association);     // Catch: Throwable -> L9
        this.mMaxId = Math.max(this.mMaxId, id);     // Catch: Throwable -> L9
        writeCacheToDisk(userId);     // Catch: Throwable -> L9
        Slog.i(TAG, "Done adding new association.");     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        MetricUtils.logCreateAssociation(association.getDeviceProfile());
        if (association.isActive() == false) goto L20;
        broadcastChange(0, association);
        return;
    }

    public void updateAssociation(AssociationInfo updated) {
        Slog.i(TAG, "Updating new association=[" + updated + "]...");
        int id = updated.getId();
        Object r1 = this.mLock;
        monitor-enter(r1);
        AssociationInfo current = this.mIdToAssociationMap.get(Integer.valueOf(id));     // Catch: Throwable -> L9
        if (current != null) goto L12;
        Slog.w(TAG, "Can't update association id=[" + id + "]. It does not exist.");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L12:
        if (current.equals(updated) == false) goto L16;
        Slog.w(TAG, "Association is the same.");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L16:
        this.mIdToAssociationMap.put(Integer.valueOf(id), updated);     // Catch: Throwable -> L9
        writeCacheToDisk(updated.getUserId());     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        Slog.i(TAG, "Done updating association.");
        if (current.isActive() == false) goto L25;
        if (updated.isActive() == true) goto L25;
        broadcastChange(1, updated);
        return;
    L25:
        if (updated.isActive() == false) goto L35;
        MacAddress updatedAddress = updated.getDeviceMacAddress();
        MacAddress currentAddress = current.getDeviceMacAddress();
        boolean macAddressChanged = true ^ Objects.equals(currentAddress, updatedAddress);
        if (macAddressChanged == false) goto L29;
        int r5 = 2;
    L30:
        broadcastChange(r5, updated);
        return;
    L29:
        r5 = 3;
        goto L30
    L35:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void removeAssociation(int id, String reason) {
        Slog.i(TAG, "Removing association id=[" + id + "]...");
        Object r0 = this.mLock;
        monitor-enter(r0);
        AssociationInfo association = this.mIdToAssociationMap.remove(Integer.valueOf(id));     // Catch: Throwable -> L9
        if (association != null) goto L11;
        Slog.w(TAG, "Can't remove association id=[" + id + "]. It does not exist.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        writeCacheToDisk(association.getUserId());     // Catch: Throwable -> L9
        this.mDiskStore.writeLastRemovedAssociation(association, reason);     // Catch: Throwable -> L9
        Slog.i(TAG, "Done removing association.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        MetricUtils.logRemoveAssociation(association.getDeviceProfile());
        if (association.isActive() == false) goto L20;
        broadcastChange(1, association);
        return;
    L20:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void writeCacheToDisk(final int userId) {
        this.mExecutor.execute(new AssociationStore$$ExternalSyntheticLambda6(this, userId));
    }

    private /* synthetic */ void lambda$writeCacheToDisk$2(final int userId) {
        Associations associations = new Associations();
        Object r1 = this.mLock;
        monitor-enter(r1);
        associations.setMaxId(this.mMaxId);     // Catch: Throwable -> L8
        associations.setAssociations(CollectionUtils.filter(this.mIdToAssociationMap.values().stream().toList(), new AssociationStore$$ExternalSyntheticLambda10(userId)));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        this.mDiskStore.writeAssociationsForUser(userId, associations);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$writeCacheToDisk$1(int userId, AssociationInfo a) {
        if (a.getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    public List<AssociationInfo> getAssociations() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mPersisted == true) goto L9;
        refreshCache();     // Catch: Throwable -> L7
    L9:
        List<AssociationInfo> r1 = List.copyOf(this.mIdToAssociationMap.values());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    public List<AssociationInfo> getActiveAssociations() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AssociationInfo> r1 = CollectionUtils.filter(getAssociations(), new AssociationStore$$ExternalSyntheticLambda7());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<AssociationInfo> getAssociationsByUser(final int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AssociationInfo> r1 = CollectionUtils.filter(getAssociations(), new AssociationStore$$ExternalSyntheticLambda9(userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$getAssociationsByUser$3(int userId, AssociationInfo a) {
        if (a.getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    public List<AssociationInfo> getActiveAssociationsByUser(final int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AssociationInfo> r1 = CollectionUtils.filter(getActiveAssociations(), new AssociationStore$$ExternalSyntheticLambda8(userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$getActiveAssociationsByUser$4(int userId, AssociationInfo a) {
        if (a.getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    public List<AssociationInfo> getAssociationsByPackage(int userId, final String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AssociationInfo> r1 = CollectionUtils.filter(getAssociationsByUser(userId), new AssociationStore$$ExternalSyntheticLambda11(packageName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$getAssociationsByPackage$5(String packageName, AssociationInfo a) {
        return a.getPackageName().equals(packageName);
    }

    public List<AssociationInfo> getActiveAssociationsByPackage(int userId, final String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AssociationInfo> r1 = CollectionUtils.filter(getActiveAssociationsByUser(userId), new AssociationStore$$ExternalSyntheticLambda1(packageName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$getActiveAssociationsByPackage$6(String packageName, AssociationInfo a) {
        return a.getPackageName().equals(packageName);
    }

    public AssociationInfo getFirstAssociationByAddress(int userId, String packageName, final String macAddress) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AssociationInfo r1 = (AssociationInfo) CollectionUtils.find(getActiveAssociationsByPackage(userId, packageName), new AssociationStore$$ExternalSyntheticLambda2(macAddress));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$getFirstAssociationByAddress$7(String macAddress, AssociationInfo a) {
        if (a.getDeviceMacAddress() != null) goto L5;
    L7:
        return false;
    L5:
        if (a.getDeviceMacAddress().equals(MacAddress.fromString(macAddress)) == false) goto L7;
        return true;
    }

    public AssociationInfo getAssociationById(int id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AssociationInfo r1 = this.mIdToAssociationMap.get(Integer.valueOf(id));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<AssociationInfo> getActiveAssociationsByAddress(final String macAddress) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AssociationInfo> r1 = CollectionUtils.filter(getActiveAssociations(), new AssociationStore$$ExternalSyntheticLambda0(macAddress));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$getActiveAssociationsByAddress$8(String macAddress, AssociationInfo a) {
        if (a.getDeviceMacAddress() != null) goto L5;
    L7:
        return false;
    L5:
        if (a.getDeviceMacAddress().equals(MacAddress.fromString(macAddress)) == false) goto L7;
        return true;
    }

    public List<AssociationInfo> getRevokedAssociations() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AssociationInfo> r1 = CollectionUtils.filter(getAssociations(), new AssociationStore$$ExternalSyntheticLambda13());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<AssociationInfo> getRevokedAssociations(final int userId, final String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AssociationInfo> r1 = CollectionUtils.filter(getAssociations(), new AssociationStore$$ExternalSyntheticLambda5(packageName, userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$getRevokedAssociations$9(String packageName, int userId, AssociationInfo a) {
        if (packageName.equals(a.getPackageName()) == true) goto L5;
    L9:
        return false;
    L5:
        if (a.getUserId() != userId) goto L9;
        if (a.isRevoked() == false) goto L9;
        return true;
    }

    public List<AssociationInfo> getPendingAssociations(final int userId, final String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AssociationInfo> r1 = CollectionUtils.filter(getAssociations(), new AssociationStore$$ExternalSyntheticLambda4(packageName, userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$getPendingAssociations$10(String packageName, int userId, AssociationInfo a) {
        if (packageName.equals(a.getPackageName()) == true) goto L5;
    L9:
        return false;
    L5:
        if (a.getUserId() != userId) goto L9;
        if (a.isPending() == false) goto L9;
        return true;
    }

    public AssociationInfo getAssociationWithCallerChecks(int associationId) {
        AssociationInfo association = getAssociationById(associationId);
        if (association == null) goto L7;
        PermissionsUtils.enforceCallerCanManageAssociationsForPackage(this.mContext, association.getUserId(), association.getPackageName(), null);
        return association;
    L7:
        throw new IllegalArgumentException("getAssociationWithCallerChecks() Association id=[" + associationId + "] doesn't exist.");
    }

    public void registerLocalListener(OnChangeListener listener) {
        Set<OnChangeListener> r0 = this.mLocalListeners;
        monitor-enter(r0);
        this.mLocalListeners.add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterLocalListener(OnChangeListener listener) {
        Set<OnChangeListener> r0 = this.mLocalListeners;
        monitor-enter(r0);
        this.mLocalListeners.remove(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void registerRemoteListener(IOnAssociationsChangedListener listener, int userId) {
        RemoteCallbackList<IOnAssociationsChangedListener> r0 = this.mRemoteListeners;
        monitor-enter(r0);
        this.mRemoteListeners.register(listener, Integer.valueOf(userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterRemoteListener(IOnAssociationsChangedListener listener) {
        RemoteCallbackList<IOnAssociationsChangedListener> r0 = this.mRemoteListeners;
        monitor-enter(r0);
        this.mRemoteListeners.unregister(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter out) {
        out.append("Companion Device Associations: ");
        if (getActiveAssociations().isEmpty() == false) goto L5;
        out.append("<empty>\n");
    L9:
        out.append("Last Removed Association:\n");
        Iterator r0 = this.mUserManager.getAliveUsers().iterator();
    L11:
        if (r0.hasNext() == false) goto L16;
        UserInfo user = (UserInfo) r0.next();
        String lastRemovedAssociation = this.mDiskStore.readLastRemovedAssociation(user.id);
        if (lastRemovedAssociation == null) goto L11;
        out.append("  ").append(lastRemovedAssociation).append('\n');
        goto L11
    L16:
        return;
    L5:
        out.append("\n");
        Iterator<AssociationInfo> r1 = getActiveAssociations().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        AssociationInfo a = r1.next();
        out.append("  ").append(a.toString()).append('\n');
        goto L7
    }

    private void broadcastChange(int changeType, AssociationInfo association) {
        Slog.i(TAG, "Broadcasting association changes - changeType=[" + changeType + "]...");
        Set<OnChangeListener> r0 = this.mLocalListeners;
        monitor-enter(r0);
        Iterator<OnChangeListener> r1 = this.mLocalListeners.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        OnChangeListener listener = r1.next();     // Catch: Throwable -> L8
        listener.onAssociationChanged(changeType, association);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        RemoteCallbackList<IOnAssociationsChangedListener> r2 = this.mRemoteListeners;
        monitor-enter(r2);
        final int userId = association.getUserId();     // Catch: Throwable -> L16
        final List<AssociationInfo> updatedAssociations = getActiveAssociationsByUser(userId);     // Catch: Throwable -> L16
        if (changeType == 3) goto L18;
        this.mRemoteListeners.broadcast(new AssociationStore$$ExternalSyntheticLambda12(userId, updatedAssociations));     // Catch: Throwable -> L16
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$broadcastChange$11(int userId, List updatedAssociations, IOnAssociationsChangedListener listener, Object callbackUserId) {
        int listenerUserId = ((Integer) callbackUserId).intValue();
        if (listenerUserId != userId) goto L5;
    L10:
        listener.onAssociationsChanged(updatedAssociations);     // Catch: RemoteException -> L8
        return;
    L9:
        return;
    L5:
        if (listenerUserId == (-1)) goto L10;
    }
}
