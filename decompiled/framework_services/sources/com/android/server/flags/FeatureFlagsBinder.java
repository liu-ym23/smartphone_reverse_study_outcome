package com.android.server.flags;

import android.annotation.SystemApi;
import android.flags.IFeatureFlags;
import android.flags.IFeatureFlagsCallback;
import android.flags.SyncableFlag;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.android.internal.flags.CoreFlags;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class FeatureFlagsBinder extends IFeatureFlags.Stub {
    private final DynamicFlagBinderDelegate mDynamicFlagDelegate;
    private final FlagCache<String> mFlagCache;
    private final FlagOverrideStore mFlagStore;
    private final FeatureFlagsService.PermissionsChecker mPermissionsChecker;
    private final FlagsShellCommand mShellCommand;

    FeatureFlagsBinder(FlagOverrideStore flagStore, FlagsShellCommand shellCommand, FeatureFlagsService.PermissionsChecker permissionsChecker) {
        this.mFlagCache = new FlagCache();
        this.mFlagStore = flagStore;
        this.mShellCommand = shellCommand;
        this.mDynamicFlagDelegate = new DynamicFlagBinderDelegate(flagStore);
        this.mPermissionsChecker = permissionsChecker;
    }

    public void registerCallback(IFeatureFlagsCallback callback) {
        this.mDynamicFlagDelegate.registerCallback(IFeatureFlags.Stub.getCallingPid(), callback);
    }

    public void unregisterCallback(IFeatureFlagsCallback callback) {
        this.mDynamicFlagDelegate.unregisterCallback(IFeatureFlags.Stub.getCallingPid(), callback);
    }

    public List<SyncableFlag> syncFlags(List<SyncableFlag> incomingFlags) {
        int pid = IFeatureFlags.Stub.getCallingPid();
        List<SyncableFlag> outputFlags = new ArrayList();
        boolean hasFullSyncPrivileges = false;
        SecurityException permissionFailureException = null;
        assertSyncPermission();     // Catch: SecurityException -> L5
        hasFullSyncPrivileges = true;
    L7:
        Iterator<SyncableFlag> r4 = incomingFlags.iterator();
    L9:
        if (r4.hasNext() == false) goto L39;
        SyncableFlag sf = r4.next();
        if (hasFullSyncPrivileges == false) goto L13;
    L16:
        String ns = sf.getNamespace();
        String name = sf.getName();
        if (sf.isDynamic() == false) goto L19;
        SyncableFlag outFlag = this.mDynamicFlagDelegate.syncDynamicFlag(pid, sf);
    L36:
        outputFlags.add(outFlag);
        goto L9
    L19:
        FlagCache<String> r8 = this.mFlagCache;
        monitor-enter(r8);
        String value = this.mFlagCache.getOrNull(ns, name);     // Catch: Throwable -> L31
        if (value == null) goto L24;
    L33:
        SyncableFlag outFlag2 = new SyncableFlag(sf.getNamespace(), sf.getName(), value, false);     // Catch: Throwable -> L31
        monitor-exit(r8);     // Catch: Throwable -> L31
        outFlag = outFlag2;
        goto L36
    L24:
        if (Build.IS_USER == false) goto L26;
        String overrideValue = null;
    L27:
        if (overrideValue == null) goto L29;
        String r11 = overrideValue;
    L30:
        value = r11;
        this.mFlagCache.setIfChanged(ns, name, value);     // Catch: Throwable -> L31
        goto L33
    L29:
        r11 = sf.getValue();     // Catch: Throwable -> L31
        goto L30
    L26:
        overrideValue = this.mFlagStore.get(ns, name);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L13:
        if (CoreFlags.isCoreFlag(sf) == true) goto L16;
        throw permissionFailureException;
    L39:
        return outputFlags;
    L5:
        e = move-exception;
        permissionFailureException = e;
        goto L7
    }

    public void overrideFlag(SyncableFlag flag) {
        assertWritePermission();
        this.mFlagStore.set(flag.getNamespace(), flag.getName(), flag.getValue());
    }

    public void resetFlag(SyncableFlag flag) {
        assertWritePermission();
        this.mFlagStore.erase(flag.getNamespace(), flag.getName());
    }

    public List<SyncableFlag> queryFlags(List<SyncableFlag> incomingFlags) {
        assertSyncPermission();
        List<SyncableFlag> outputFlags = new ArrayList();
        Iterator<SyncableFlag> r1 = incomingFlags.iterator();
    L4:
        if (r1.hasNext() == false) goto L24;
        SyncableFlag sf = r1.next();
        String ns = sf.getNamespace();
        String name = sf.getName();
        String storeValue = this.mFlagStore.get(ns, name);
        if (storeValue == null) goto L8;
        boolean r6 = true;
    L9:
        boolean overridden = r6;
        if (sf.isDynamic() == false) goto L12;
        String value = this.mDynamicFlagDelegate.getFlagValue(ns, name, sf.getValue());
    L23:
        String r8 = sf.getNamespace();
        String r9 = sf.getName();
        outputFlags.add(new SyncableFlag(r8, r9, value, sf.isDynamic(), overridden));
        goto L4
    L12:
        value = this.mFlagCache.getOrNull(ns, name);
        if (value != null) goto L23;
        if (Build.IS_USER == false) goto L17;
        String r7 = null;
    L18:
        value = r7;
        if (value != null) goto L23;
        value = sf.getValue();
        goto L23
    L17:
        r7 = storeValue;
        goto L18
    L8:
        r6 = false;
        goto L9
    L24:
        return outputFlags;
    }

    private void assertSyncPermission() {
        this.mPermissionsChecker.assertSyncPermission();
        IFeatureFlags.Stub.clearCallingIdentity();
    }

    private void assertWritePermission() {
        this.mPermissionsChecker.assertWritePermission();
        IFeatureFlags.Stub.clearCallingIdentity();
    }

    @SystemApi
    public int handleShellCommand(ParcelFileDescriptor in, ParcelFileDescriptor out, ParcelFileDescriptor err, String[] args) {
        FileOutputStream fout = new FileOutputStream(out.getFileDescriptor());
        FileOutputStream ferr = new FileOutputStream(err.getFileDescriptor());
        return this.mShellCommand.process(args, fout, ferr);
    }
}
