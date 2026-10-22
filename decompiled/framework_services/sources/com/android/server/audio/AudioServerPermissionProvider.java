package com.android.server.audio;

import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Log;
import com.android.media.permission.INativePermissionController;
import com.android.media.permission.UidPackageState;
import com.android.server.pm.pkg.PackageState;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class AudioServerPermissionProvider {
    static final byte[] HDS_PERMS = null;
    static final String[] MONITORED_PERMS = null;
    static final String TAG = "AudioServerPermissionProvider";
    private INativePermissionController mDest;
    private int mHdsUid;
    private boolean mIsUpdateDeferred;
    private final Object mLock;
    private final Map<Integer, Set<String>> mPackageMap;
    private final int[][] mPermMap;
    private final BiPredicate<Integer, String> mPermissionPredicate;
    private final Supplier<int[]> mUserIdSupplier;

    public static /* synthetic */ ArraySet $r8$lambda$36jOxDK8aJjqteWDAte26FquJuw() {
        return lambda$generatePackageMappings$3();
    }

    /* JADX INFO: renamed from: $r8$lambda$4h-yQtUTiiXjKIh_Fi_QpFqG33A, reason: not valid java name */
    public static /* synthetic */ String m1967$r8$lambda$4hyQtUTiiXjKIh_Fi_QpFqG33A(PackageState r0) {
        return lambda$generatePackageMappings$2(r0);
    }

    public static /* synthetic */ UidPackageState $r8$lambda$W9ZZjXFn_I5uhi5LWjFkj6BUBlM(Map.Entry r0) {
        return lambda$resetNativePackageState$1(r0);
    }

    public static /* synthetic */ Integer $r8$lambda$f_limh5L9xRzsqmZ6YvRNIOccOo(PackageState r0) {
        return lambda$generatePackageMappings$4(r0);
    }

    public static /* synthetic */ Set $r8$lambda$lU2U26USFxJXvFk9wdz3nKhH97c(Integer r0) {
        return lambda$onModifyPackageState$0(r0);
    }

    static {
        MONITORED_PERMS = new String[16];
        HDS_PERMS = new byte[]{10, 8, 0};
        MONITORED_PERMS[0] = "android.permission.RECORD_AUDIO";
        MONITORED_PERMS[1] = "android.permission.MODIFY_AUDIO_ROUTING";
        MONITORED_PERMS[2] = "android.permission.MODIFY_AUDIO_SETTINGS";
        MONITORED_PERMS[3] = "android.permission.MODIFY_PHONE_STATE";
        MONITORED_PERMS[4] = "android.permission.MODIFY_DEFAULT_AUDIO_EFFECTS";
        MONITORED_PERMS[5] = "android.permission.WRITE_SECURE_SETTINGS";
        MONITORED_PERMS[6] = "android.permission.CALL_AUDIO_INTERCEPTION";
        MONITORED_PERMS[7] = "android.permission.ACCESS_ULTRASOUND";
        MONITORED_PERMS[8] = "android.permission.CAPTURE_AUDIO_OUTPUT";
        MONITORED_PERMS[9] = "android.permission.CAPTURE_MEDIA_OUTPUT";
        MONITORED_PERMS[10] = "android.permission.CAPTURE_AUDIO_HOTWORD";
        MONITORED_PERMS[11] = "android.permission.CAPTURE_TUNER_AUDIO_INPUT";
        MONITORED_PERMS[12] = "android.permission.CAPTURE_VOICE_COMMUNICATION_OUTPUT";
        MONITORED_PERMS[13] = "android.permission.BLUETOOTH_CONNECT";
        MONITORED_PERMS[14] = "android.permission.BYPASS_CONCURRENT_RECORD_AUDIO_RESTRICTION";
        MONITORED_PERMS[15] = "android.permission.MODIFY_AUDIO_SETTINGS_PRIVILEGED";
    }

    public AudioServerPermissionProvider(Collection<PackageState> appInfos, BiPredicate<Integer, String> permissionPredicate, Supplier<int[]> userIdSupplier) {
        this.mLock = new Object();
        this.mPermMap = new int[16][];
        this.mIsUpdateDeferred = true;
        this.mHdsUid = -1;
        int i = 0;
    L3:
        if (i >= 16) goto L5;
        MONITORED_PERMS[i].getClass();
        i = i + 1;
        goto L3
    L5:
        this.mUserIdSupplier = userIdSupplier;
        this.mPermissionPredicate = permissionPredicate;
        this.mPackageMap = generatePackageMappings(appInfos);
    }

    public void onServiceStart(INativePermissionController pc) {
        if (pc != null) goto L4;
        return;
    L4:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDest = pc;     // Catch: Throwable -> L13
        resetNativePackageState();     // Catch: Throwable -> L13
        byte i = 0;
    L9:
        if (i >= 16) goto L18;
        if (this.mIsUpdateDeferred == false) goto L17;
        this.mPermMap[i] = getUidsHoldingPerm(i);     // Catch: Throwable -> L13 RemoteException -> L15
    L17:
        this.mDest.populatePermissionState(i, this.mPermMap[i]);     // Catch: Throwable -> L13 RemoteException -> L15
        i = (byte) (i + 1);     // Catch: Throwable -> L13 RemoteException -> L15
    L21:
        this.mDest = null;     // Catch: Throwable -> L13
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L18:
        this.mIsUpdateDeferred = false;     // Catch: Throwable -> L13 RemoteException -> L15
    L13:
        th = move-exception;
        throw th;
    }

    public void onModifyPackageState(int uid, String packageName, boolean isRemove) {
        int uid2 = UserHandle.getAppId(uid);
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (isRemove == true) goto L8;
        Set<String> packages = this.mPackageMap.computeIfAbsent(Integer.valueOf(uid2), new AudioServerPermissionProvider$$ExternalSyntheticLambda5());     // Catch: Throwable -> L6
        packages.add(packageName);     // Catch: Throwable -> L6
    L14:
        if (this.mDest != null) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L17:
        UidPackageState state = new UidPackageState();     // Catch: Throwable -> L6
        state.uid = uid2;     // Catch: Throwable -> L6
        if (packages == null) goto L20;
        List r3 = List.copyOf(packages);     // Catch: Throwable -> L6
    L21:
        state.packageNames = r3;     // Catch: Throwable -> L6
        this.mDest.updatePackagesForUid(state);     // Catch: Throwable -> L6 RemoteException -> L24
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L26:
        this.mDest = null;     // Catch: Throwable -> L6
        goto L27
    L20:
        r3 = Collections.emptyList();     // Catch: Throwable -> L6
        goto L21
    L8:
        packages = this.mPackageMap.get(Integer.valueOf(uid2));     // Catch: Throwable -> L6
        if (packages == null) goto L14;
        packages.remove(packageName);     // Catch: Throwable -> L6
        if (packages.isEmpty() == false) goto L14;
        this.mPackageMap.remove(Integer.valueOf(uid2));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ Set lambda$onModifyPackageState$0(Integer unused) {
        return new ArraySet(1);
    }

    public void onPermissionStateChanged() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDest != null) goto L11;
        this.mIsUpdateDeferred = true;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        Trace.traceBegin(524288, "audioserver_permission_update");     // Catch: Throwable -> L9
        byte i = 0;
    L14:
        if (i >= 16) goto L30;
        int[] newPerms = getUidsHoldingPerm(i);     // Catch: Throwable -> L19 RemoteException -> L21
        if (Arrays.equals(newPerms, this.mPermMap[i]) == true) goto L23;
        this.mPermMap[i] = newPerms;     // Catch: Throwable -> L19 RemoteException -> L21
        this.mDest.populatePermissionState(i, newPerms);     // Catch: Throwable -> L19 RemoteException -> L21
    L23:
        i = (byte) (i + 1);
    L19:
        th = move-exception;
        Trace.traceEnd(524288);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L25:
        this.mDest = null;     // Catch: Throwable -> L19
        this.mIsUpdateDeferred = true;     // Catch: Throwable -> L19
        Trace.traceEnd(524288);     // Catch: Throwable -> L9
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L30:
        Trace.traceEnd(524288);     // Catch: Throwable -> L9
        goto L31
    }

    public void setIsolatedServiceUid(int uid, int owningUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mHdsUid != uid) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Set<String> packageNameSet = this.mPackageMap.get(Integer.valueOf(UserHandle.getAppId(owningUid)));     // Catch: Throwable -> L8
        if (packageNameSet == null) goto L13;
        String packageName = packageNameSet.iterator().next();     // Catch: Throwable -> L8
        onModifyPackageState(uid, packageName, false);     // Catch: Throwable -> L8
    L14:
        this.mHdsUid = uid;     // Catch: Throwable -> L8
        if (this.mDest != null) goto L32;
        this.mIsUpdateDeferred = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L32:
        byte[] r3 = HDS_PERMS;     // Catch: Throwable -> L8 RemoteException -> L23
        int r5 = r3.length;     // Catch: Throwable -> L8 RemoteException -> L23
        int r6 = 0;
    L20:
        if (r6 >= r5) goto L28;
        byte perm = r3[r6];     // Catch: Throwable -> L8 RemoteException -> L23
        int[] newPerms = new int[this.mPermMap[perm].length + 1];     // Catch: Throwable -> L8 RemoteException -> L23
        System.arraycopy(this.mPermMap[perm], 0, newPerms, 0, this.mPermMap[perm].length);     // Catch: Throwable -> L8 RemoteException -> L23
        newPerms[newPerms.length - 1] = this.mHdsUid;     // Catch: Throwable -> L8 RemoteException -> L23
        Arrays.sort(newPerms);     // Catch: Throwable -> L8 RemoteException -> L23
        this.mPermMap[perm] = newPerms;     // Catch: Throwable -> L8 RemoteException -> L23
        this.mDest.populatePermissionState(perm, newPerms);     // Catch: Throwable -> L8 RemoteException -> L23
        r6 = r6 + 1;
        goto L20
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L27:
        this.mDest = null;     // Catch: Throwable -> L8
        this.mIsUpdateDeferred = true;     // Catch: Throwable -> L8
        goto L28
    L13:
        Log.wtf(TAG, "setIsolatedService owning uid not found");     // Catch: Throwable -> L8
        goto L14
    }

    public void clearIsolatedServiceUid(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Set<String> packageNameSet = this.mPackageMap.get(Integer.valueOf(UserHandle.getAppId(uid)));     // Catch: Throwable -> L9
        if (this.mHdsUid == uid) goto L12;
        Log.wtf(TAG, "Unexpected isolated service uid cleared: " + uid + packageNameSet + ", expected " + this.mHdsUid);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (packageNameSet == null) goto L14;
        String packageName = packageNameSet.iterator().next();     // Catch: Throwable -> L9
        onModifyPackageState(uid, packageName, true);     // Catch: Throwable -> L9
    L16:
        if (this.mDest != null) goto L37;
        this.mIsUpdateDeferred = true;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L37:
        byte[] r3 = HDS_PERMS;     // Catch: Throwable -> L9 RemoteException -> L27
        int r4 = r3.length;     // Catch: Throwable -> L9 RemoteException -> L27
        int r6 = 0;
    L21:
        if (r6 >= r4) goto L32;
        byte perm = r3[r6];     // Catch: Throwable -> L9 RemoteException -> L27
        int[] newPerms = new int[this.mPermMap[perm].length - 1];     // Catch: Throwable -> L9 RemoteException -> L27
        int ind = Arrays.binarySearch(this.mPermMap[perm], uid);     // Catch: Throwable -> L9 RemoteException -> L27
        if (ind < 0) goto L26;
        System.arraycopy(this.mPermMap[perm], 0, newPerms, 0, ind);     // Catch: Throwable -> L9 RemoteException -> L27
        System.arraycopy(this.mPermMap[perm], ind + 1, newPerms, ind, (this.mPermMap[perm].length - ind) - 1);     // Catch: Throwable -> L9 RemoteException -> L27
        this.mPermMap[perm] = newPerms;     // Catch: Throwable -> L9 RemoteException -> L27
        this.mDest.populatePermissionState(perm, newPerms);     // Catch: Throwable -> L9 RemoteException -> L27
    L26:
        r6 = r6 + 1;
    L32:
        this.mHdsUid = -1;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L31:
        this.mDest = null;     // Catch: Throwable -> L9
        this.mIsUpdateDeferred = true;     // Catch: Throwable -> L9
        goto L32
    L14:
        Log.wtf(TAG, "clearIsolatedService uid not found");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private boolean isSpecialHdsPermission(int perm) {
        byte[] r0 = HDS_PERMS;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        byte hdsPerm = r0[r3];
        if (perm == hdsPerm) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void resetNativePackageState() {
        if (this.mDest != null) goto L5;
        return;
    L5:
        List<UidPackageState> states = this.mPackageMap.entrySet().stream().map(new AudioServerPermissionProvider$$ExternalSyntheticLambda4()).toList();
        this.mDest.populatePackagesForUids(states);     // Catch: RemoteException -> L8
        return;
    L9:
        this.mDest = null;
    }

    private static /* synthetic */ UidPackageState lambda$resetNativePackageState$1(Map.Entry entry) {
        UidPackageState state = new UidPackageState();
        state.uid = ((Integer) entry.getKey()).intValue();
        state.packageNames = List.copyOf((Collection) entry.getValue());
        return state;
    }

    private int[] getUidsHoldingPerm(int perm) {
        IntArray acc = new IntArray();
        int[] r1 = this.mUserIdSupplier.get();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L13;
        int userId = r1[r3];
        Iterator<Integer> r5 = this.mPackageMap.keySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L11;
        int appId = r5.next().intValue();
        int uid = UserHandle.getUid(userId, appId);
        if (this.mPermissionPredicate.test(Integer.valueOf(uid), MONITORED_PERMS[perm]) == false) goto L6;
        acc.add(uid);
        goto L6
    L11:
        r3 = r3 + 1;
        goto L3
    L13:
        if (isSpecialHdsPermission(perm) == true) goto L15;
    L17:
        int[] unwrapped = acc.toArray();
        Arrays.sort(unwrapped);
        return unwrapped;
    L15:
        if (this.mHdsUid == (-1)) goto L17;
        acc.add(this.mHdsUid);
        goto L17
    }

    private static Map<Integer, Set<String>> generatePackageMappings(Collection<PackageState> appInfos) {
        Collector<PackageState, Object, Set<String>> reducer = Collectors.mapping(new AudioServerPermissionProvider$$ExternalSyntheticLambda0(), Collectors.toCollection(new AudioServerPermissionProvider$$ExternalSyntheticLambda1()));
        return (Map) appInfos.stream().collect(Collectors.groupingBy(new AudioServerPermissionProvider$$ExternalSyntheticLambda2(), new AudioServerPermissionProvider$$ExternalSyntheticLambda3(), reducer));
    }

    private static /* synthetic */ String lambda$generatePackageMappings$2(PackageState p) {
        return p.getPackageName();
    }

    private static /* synthetic */ ArraySet lambda$generatePackageMappings$3() {
        return new ArraySet(1);
    }

    private static /* synthetic */ Integer lambda$generatePackageMappings$4(PackageState p) {
        return Integer.valueOf(p.getAppId());
    }
}
