package com.android.server.wm;

import android.os.SystemClock;
import android.util.SmtUidUtil;
import com.android.server.ApplicationFreezerHelperSmt;
import com.android.server.ApplicationFreezerInternalSmt;
import com.android.server.SysOptBridge;
import com.android.server.am.SysMonitorSvcBridge;

/* JADX INFO: loaded from: classes3.dex */
public class WindowStateSmtBase extends WindowContainerSysEx implements ApplicationFreezerInternalSmt.IFrozenCallback {
    protected static final boolean DEBUG = true;
    protected static final String TAG = "WindowStateSmt";
    boolean currentVisible;
    boolean isFrozenCallbackRegisterd;
    boolean isScreenDim;
    boolean lastVisible;
    long mVisibleStartTime;
    protected WindowState mWindowState;
    public int smtUid;

    public WindowStateSmtBase(WindowState windowState) {
        super(windowState);
        this.lastVisible = false;
        this.currentVisible = false;
        this.isScreenDim = false;
        this.isFrozenCallbackRegisterd = false;
        this.smtUid = 1000;
        this.mVisibleStartTime = -1;
        this.mWindowState = windowState;
    }

    void updateCurrentVisibleState(boolean visibleState) {
        this.currentVisible = visibleState;
    }

    void saveLastVisibleState() {
        this.lastVisible = this.currentVisible;
    }

    boolean firstVisible() {
        if (this.currentVisible == true) goto L5;
    L7:
        return false;
    L5:
        if (this.lastVisible == true) goto L7;
        return true;
    }

    void registerFrozenCallbackByPidOnce() {
        if (this.isFrozenCallbackRegisterd == true) goto L6;
        this.isFrozenCallbackRegisterd = true;
        ApplicationFreezerHelperSmt.registerFrozenCallbackByPidOnce(this.mWindowState.mSession.mPid, this.mWindowState.mSession.mUid, this);
        return;
    }

    @Override // com.android.server.ApplicationFreezerInternalSmt.IFrozenCallback
    public void onAppFreeze(int pid, int uid) {
    }

    @Override // com.android.server.ApplicationFreezerInternalSmt.IFrozenCallback
    public void onAppUnfreeze(int pid, int uid) {
    }

    public int getSmtUid(int uid, String packageName) {
        if (uid == 1000) goto L5;
        return uid;
    L5:
        if (this.smtUid != 1000) goto L7;
        this.smtUid = SmtUidUtil.getSystemUidForPackage(packageName);
    L7:
        int result = this.smtUid;
        return result;
    }

    public int getSmtUid() {
        return getSmtUid(this.mWindowState.mOwnerUid, this.mWindowState.mAttrs.packageName);
    }

    public void onWindowVisibleChanged(int currentVisibility) {
        if (SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().isScreenOn() == false) goto L12;
        long current = SystemClock.uptimeMillis();
        if (currentVisibility != 0) goto L8;
        this.mVisibleStartTime = current;
        return;
    L8:
        if (this.mVisibleStartTime == (-1)) goto L10;
        long duration = current - this.mVisibleStartTime;
        SysOptBridge.getFactory().getSmartService().updateWindowVisibleTime(getSmtUid(), this.mWindowState.getWindowTag().toString(), duration, SysOptBridge.getFactory().getSmartService().getCurrentDisplayMode());
    L10:
        this.mVisibleStartTime = -1;
        return;
    }

    public void onDisplayFpsModeChanged(int displayMode) {
        long current = SystemClock.uptimeMillis();
        if (this.mVisibleStartTime == (-1)) goto L7;
        long duration = current - this.mVisibleStartTime;
        SysOptBridge.getFactory().getSmartService().updateWindowVisibleTime(getSmtUid(), this.mWindowState.getWindowTag().toString(), duration, displayMode);
    L7:
        if (this.mWindowState.mViewVisibility != 0) goto L9;
        this.mVisibleStartTime = current;
        return;
    L9:
        this.mVisibleStartTime = -1;
    }

    public void forceUpdateVisibleTime(boolean screenOn) {
        long current = SystemClock.uptimeMillis();
        if (this.mVisibleStartTime == (-1)) goto L5;
        long duration = current - this.mVisibleStartTime;
        SysOptBridge.getFactory().getSmartService().updateWindowVisibleTime(getSmtUid(), this.mWindowState.getWindowTag().toString(), duration, SysOptBridge.getFactory().getSmartService().getCurrentDisplayMode());
    L5:
        if (screenOn == true) goto L7;
        this.mVisibleStartTime = -1;
        return;
    L7:
        if (this.mWindowState.mViewVisibility != 0) goto L9;
        this.mVisibleStartTime = current;
        return;
    L9:
        this.mVisibleStartTime = -1;
    }
}
