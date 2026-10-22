package com.android.server.devicepolicy;

import android.app.admin.DevicePolicyCache;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.SparseIntArray;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DevicePolicyCacheImpl extends DevicePolicyCache {
    private volatile boolean mCanGrantSensorsPermissions;
    private final SparseIntArray mContentProtectionPolicy;
    private ArrayMap<String, String> mLauncherShortcutOverrides;
    private final Object mLock;
    private final SparseIntArray mPasswordQuality;
    private final SparseIntArray mPermissionPolicy;
    private final Set<Integer> mScreenCaptureDisallowedUsers;

    public DevicePolicyCacheImpl() {
        this.mLock = new Object();
        this.mScreenCaptureDisallowedUsers = new HashSet();
        this.mPasswordQuality = new SparseIntArray();
        this.mPermissionPolicy = new SparseIntArray();
        this.mLauncherShortcutOverrides = new ArrayMap();
        this.mCanGrantSensorsPermissions = false;
        this.mContentProtectionPolicy = new SparseIntArray();
    }

    public void onUserRemoved(int userHandle) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPasswordQuality.delete(userHandle);     // Catch: Throwable -> L7
        this.mPermissionPolicy.delete(userHandle);     // Catch: Throwable -> L7
        this.mContentProtectionPolicy.delete(userHandle);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isScreenCaptureAllowed(int userHandle) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mScreenCaptureDisallowedUsers.contains(Integer.valueOf(userHandle)) == false) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mScreenCaptureDisallowedUsers.contains(-1) == true) goto L11;
        r1 = true;
        goto L12
    }

    public void setScreenCaptureDisallowedUser(int userHandle, boolean disallowed) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (disallowed == false) goto L8;
        this.mScreenCaptureDisallowedUsers.add(Integer.valueOf(userHandle));     // Catch: Throwable -> L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        this.mScreenCaptureDisallowedUsers.remove(Integer.valueOf(userHandle));     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public int getPasswordQuality(int userHandle) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mPasswordQuality.get(userHandle, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setPasswordQuality(int userHandle, int quality) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPasswordQuality.put(userHandle, quality);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int getPermissionPolicy(int userHandle) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mPermissionPolicy.get(userHandle, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setPermissionPolicy(int userHandle, int policy) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPermissionPolicy.put(userHandle, policy);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int getContentProtectionPolicy(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mContentProtectionPolicy.get(userId, 1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setContentProtectionPolicy(int userId, Integer value) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (value != null) goto L8;
        this.mContentProtectionPolicy.delete(userId);     // Catch: Throwable -> L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L8:
        this.mContentProtectionPolicy.put(userId, value.intValue());     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public boolean canAdminGrantSensorsPermissions() {
        return this.mCanGrantSensorsPermissions;
    }

    public void setAdminCanGrantSensorsPermissions(boolean canGrant) {
        this.mCanGrantSensorsPermissions = canGrant;
    }

    public Map<String, String> getLauncherShortcutOverrides() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap r1 = new ArrayMap(this.mLauncherShortcutOverrides);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setLauncherShortcutOverrides(ArrayMap<String, String> launcherShortcutOverrides) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLauncherShortcutOverrides = new ArrayMap(launcherShortcutOverrides);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("Device policy cache:");     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        pw.println("Screen capture disallowed users: " + this.mScreenCaptureDisallowedUsers);     // Catch: Throwable -> L7
        pw.println("Password quality: " + this.mPasswordQuality);     // Catch: Throwable -> L7
        pw.println("Permission policy: " + this.mPermissionPolicy);     // Catch: Throwable -> L7
        pw.println("Content protection policy: " + this.mContentProtectionPolicy);     // Catch: Throwable -> L7
        pw.println("Admin can grant sensors permission: " + this.mCanGrantSensorsPermissions);     // Catch: Throwable -> L7
        pw.print("Shortcuts overrides: ");     // Catch: Throwable -> L7
        pw.println(this.mLauncherShortcutOverrides);     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
