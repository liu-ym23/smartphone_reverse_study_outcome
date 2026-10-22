package com.android.server.pm;

import android.os.Binder;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.internal.util.XmlUtils;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public class TaskPersistUtil {
    private static final String SETTINGS_TASK_PERSIST_CHANGED = "smt_task_persist_changed";
    protected static final String TAG = "TaskPersistUtil";
    private static final String TAG_TASK_PERSIST_PACKAGE = "task-persist";
    private static final SparseIntArray mAllTaskPersistUids = null;
    private final SparseArray<HashSet<String>> mAllTaskPersistPackages;
    private PermissionManagerServiceInternal mPermissionManager;
    private PackageManagerService mPmService;

    private class InstanceHolder {
        private static final TaskPersistUtil INSTANCE = null;

        /* JADX INFO: renamed from: -$$Nest$sfgetINSTANCE, reason: not valid java name */
        static /* bridge */ /* synthetic */ TaskPersistUtil m6969$$Nest$sfgetINSTANCE() {
            return INSTANCE;
        }

        private InstanceHolder(TaskPersistUtil r1) {
        }

        static {
            INSTANCE = new TaskPersistUtil(null);
        }
    }

    public static /* synthetic */ void $r8$lambda$1cCcWt6sc1n5SUHewt7pTfsHpYY(TaskPersistUtil r0, String r1, boolean r2, int r3) {
        r0.lambda$notifyTaskPersistChanged$0(r1, r2, r3);
    }

    /* synthetic */ TaskPersistUtil(TaskPersistUtilIA r1) {
        this();
    }

    private TaskPersistUtil() {
        this.mAllTaskPersistPackages = new SparseArray();
    }

    public static TaskPersistUtil getInstance() {
        return InstanceHolder.m6969$$Nest$sfgetINSTANCE();
    }

    public void init(PackageManagerService packageManagerService, PermissionManagerServiceInternal permissionManager) {
        this.mPmService = packageManagerService;
        this.mPermissionManager = permissionManager;
    }

    static {
        mAllTaskPersistUids = new SparseIntArray();
    }

    public boolean isTaskPersist(String packagename, int userId) {
        Computer snapshot = this.mPmService.snapshotComputer();
        int callingUid = Binder.getCallingUid();
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "persist task");
        SparseArray<HashSet<String>> r9 = this.mAllTaskPersistPackages;
        monitor-enter(r9);
        HashSet<String> taskperistPackages = this.mAllTaskPersistPackages.get(userId);     // Catch: Throwable -> L9
        if (taskperistPackages == null) goto L12;
        boolean r4 = taskperistPackages.contains(packagename);     // Catch: Throwable -> L9
        monitor-exit(r9);     // Catch: Throwable -> L9
        return r4;
    L12:
        monitor-exit(r9);     // Catch: Throwable -> L9
        return false;
    L9:
        th = move-exception;
        throw th;
    }

    public void setTaskPersist(String packagename, boolean enable, int userId, int uid) {
        if (uid >= 0) goto L4;
        return;
    L4:
        SparseArray<HashSet<String>> r0 = this.mAllTaskPersistPackages;
        monitor-enter(r0);
        HashSet<String> taskperistPackages = this.mAllTaskPersistPackages.get(userId);     // Catch: Throwable -> L9
        if (taskperistPackages != null) goto L11;
        taskperistPackages = new HashSet();     // Catch: Throwable -> L9
        this.mAllTaskPersistPackages.put(userId, taskperistPackages);     // Catch: Throwable -> L9
    L11:
        if (enable == false) goto L13;
        taskperistPackages.add(packagename);     // Catch: Throwable -> L9
        addTaskPersistUid(uid);     // Catch: Throwable -> L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        notifyTaskPersistChanged(packagename, enable, userId);
        return;
    L13:
        taskperistPackages.remove(packagename);     // Catch: Throwable -> L9
        removeTaskPersistUid(uid);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isTaskPersistUid(int uid) {
        SparseIntArray r0 = mAllTaskPersistUids;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mAllTaskPersistUids.get(uid) <= 0) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public void addTaskPersistUid(int uid) {
        SparseIntArray r0 = mAllTaskPersistUids;
        monitor-enter(r0);
        int count = mAllTaskPersistUids.get(uid);     // Catch: Throwable -> L7
        mAllTaskPersistUids.put(uid, count + 1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeTaskPersistUid(int uid) {
        SparseIntArray r0 = mAllTaskPersistUids;
        monitor-enter(r0);
        int count = mAllTaskPersistUids.get(uid);     // Catch: Throwable -> L7
        if (count <= 1) goto L9;
        mAllTaskPersistUids.put(uid, count - 1);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        if (count != 1) goto L11;
        mAllTaskPersistUids.delete(uid);     // Catch: Throwable -> L7
        goto L12
    L11:
        Slog.e(TAG, "Remove TaskPersist Uid error, Uid=" + uid + " count=" + count);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void clearTaskPersistData(String packageName, int uid, int userId) {
        if (TextUtils.isEmpty(packageName) == true) goto L19;
        if (uid < 0) goto L22;
        SparseArray<HashSet<String>> r0 = this.mAllTaskPersistPackages;
        monitor-enter(r0);
        HashSet<String> taskperistPackages = this.mAllTaskPersistPackages.get(userId);     // Catch: Throwable -> L13
        if (taskperistPackages != null) goto L11;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L11:
        if (taskperistPackages.remove(packageName) == false) goto L15;
        removeTaskPersistUid(uid);     // Catch: Throwable -> L13
        Slog.i(TAG, "clearTaskPersistData for package: " + packageName + ", userId: " + userId);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L22:
        return;
    }

    public void persistTaskPackageLPw(Settings settings, String packageName, int userId) {
        if (TextUtils.isEmpty(packageName) == false) goto L5;
        return;
    L5:
        PackageSetting ps = settings.mPackages.get(packageName);
        if (ps != null) goto L8;
        return;
    L8:
        SparseArray<HashSet<String>> r1 = this.mAllTaskPersistPackages;
        monitor-enter(r1);
        HashSet<String> taskperistPackages = this.mAllTaskPersistPackages.get(userId);     // Catch: Throwable -> L13
        if (taskperistPackages != null) goto L15;
        taskperistPackages = new HashSet();     // Catch: Throwable -> L13
        this.mAllTaskPersistPackages.put(userId, taskperistPackages);     // Catch: Throwable -> L13
    L15:
        taskperistPackages.add(packageName);     // Catch: Throwable -> L13
        addTaskPersistUid(UserHandle.getUid(userId, ps.getAppId()));     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void writeTaskPersistPackageLPr(XmlSerializer serializer, int userId) throws IllegalArgumentException, IllegalStateException, IOException {
        serializer.startTag(null, "taskpersist-packages");
        SparseArray<HashSet<String>> r0 = this.mAllTaskPersistPackages;
        monitor-enter(r0);
        HashSet<String> lps = this.mAllTaskPersistPackages.get(userId);     // Catch: Throwable -> L10
        if (lps == null) goto L12;
        Iterator<String> r3 = lps.iterator();     // Catch: Throwable -> L10
    L8:
        if (r3.hasNext() == false) goto L12;
        String lp = r3.next();     // Catch: Throwable -> L10
        serializer.startTag(null, TAG_TASK_PERSIST_PACKAGE);     // Catch: Throwable -> L10
        serializer.attribute(null, "name", lp);     // Catch: Throwable -> L10
        serializer.endTag(null, TAG_TASK_PERSIST_PACKAGE);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        serializer.endTag(null, "taskpersist-packages");
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void readTaskPersistPackageLPr(Settings settings, XmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals(TAG_TASK_PERSIST_PACKAGE) == true) goto L16;
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <taskpersist-packages>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        String packageName = parser.getAttributeValue(null, "name");
        getInstance().persistTaskPackageLPw(settings, packageName, userId);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    public HashMap<Integer, HashSet<String>> getAllTaskPersistPackages() {
        HashMap<Integer, HashSet<String>> result = new HashMap();
        int callingUid = Binder.getCallingUid();
        Computer snapshot = this.mPmService.snapshotComputer();
        SparseArray<HashSet<String>> r8 = this.mAllTaskPersistPackages;     // Catch: Exception -> L21
        monitor-enter(r8);     // Catch: Exception -> L21
        int index = 0;
    L24:
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L21
    L7:
        if (index >= this.mAllTaskPersistPackages.size()) goto L17;
        int userId = this.mAllTaskPersistPackages.keyAt(index);     // Catch: Throwable -> L13
        snapshot.enforceCrossUserPermission(callingUid, userId, true, false, "persist task");     // Catch: Throwable -> L13
        HashSet<String> packages = this.mAllTaskPersistPackages.valueAt(index);     // Catch: Throwable -> L13
        if (packages == null) goto L15;
        if (packages.isEmpty() == true) goto L15;
        result.put(Integer.valueOf(userId), new HashSet(packages));     // Catch: Throwable -> L13
    L15:
        index = index + 1;     // Catch: Throwable -> L13
        goto L24
    L17:
        monitor-exit(r8);     // Catch: Throwable -> L13
    L23:
        return result;
    L21:
        e = move-exception;
        Slog.e(TAG, "Failed to get task persist: ", e);
        goto L23
    }

    private void notifyTaskPersistChanged(final String packageName, final boolean enabled, final int userId) {
        Runnable notifyRunnable = new TaskPersistUtil$$ExternalSyntheticLambda0(this, packageName, enabled, userId);
        if (this.mPmService != null) goto L5;
    L7:
        notifyRunnable.run();
        return;
    L5:
        if (this.mPmService.mHandler == null) goto L7;
        this.mPmService.mHandler.post(notifyRunnable);
    }

    private /* synthetic */ void lambda$notifyTaskPersistChanged$0(String packageName, boolean enabled, int userId) {
        if (this.mPmService != null) goto L5;
        return;
    L5:
        if (this.mPmService.mContext == null) goto L21;
        JSONObject json = new JSONObject();     // Catch: Exception -> L11
        json.put("packageName", packageName);     // Catch: Exception -> L11
        json.put(ServiceConfigAccessor.PROVIDER_MODE_ENABLED, enabled);     // Catch: Exception -> L11
        json.put("userId", userId);     // Catch: Exception -> L11
        boolean wrote = android.provider.Settings.System.putStringForUser(this.mPmService.mContext.getContentResolver(), SETTINGS_TASK_PERSIST_CHANGED, json.toString(), userId);     // Catch: Exception -> L11
        if (wrote == true) goto L19;
        Slog.w(TAG, "putStringForUser failed for smt_task_persist_changed");     // Catch: Exception -> L11
        return;
    L19:
        return;
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to create task persist JSON: ", e);
        return;
    }
}
