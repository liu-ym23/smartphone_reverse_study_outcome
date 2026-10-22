package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import android.util.Slog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class HdmiCecFeatureAction {
    protected static final long DELAY_GIVE_AUDIO_STATUS = 500;
    protected static final int MSG_TIMEOUT = 100;
    protected static final int STATE_NONE = 0;
    private static final String TAG = "HdmiCecFeatureAction";
    protected ActionTimer mActionTimer;
    final List<IHdmiControlCallback> mCallbacks;
    private ArrayList<Pair<HdmiCecFeatureAction, Runnable>> mOnFinishedCallbacks;
    private final HdmiControlService mService;
    private final HdmiCecLocalDevice mSource;
    protected int mState;

    interface ActionTimer {
        void clearTimerMessage();

        void sendTimerMessage(int r1, long r2);
    }

    private class ActionTimerHandler extends Handler implements ActionTimer {
        final /* synthetic */ HdmiCecFeatureAction this$0;

        public ActionTimerHandler(HdmiCecFeatureAction r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // com.android.server.hdmi.HdmiCecFeatureAction.ActionTimer
        public void sendTimerMessage(int state, long delayMillis) {
            sendMessageDelayed(obtainMessage(100, state, 0), delayMillis);
        }

        @Override // com.android.server.hdmi.HdmiCecFeatureAction.ActionTimer
        public void clearTimerMessage() {
            removeMessages(100);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 100: goto L5;
                default: goto L4;
            };
        L4:
            Slog.w(HdmiCecFeatureAction.TAG, "Unsupported message:" + msg.what);
            return;
        L5:
            this.this$0.handleTimerEvent(msg.arg1);
        }
    }

    abstract void handleTimerEvent(int r1);

    abstract boolean processCommand(HdmiCecMessage r1);

    abstract boolean start();

    HdmiCecFeatureAction(HdmiCecLocalDevice source) {
        this(source, new ArrayList());
    }

    HdmiCecFeatureAction(HdmiCecLocalDevice source, IHdmiControlCallback callback) {
        this(source, Arrays.asList(new IHdmiControlCallback[]{callback}));
    }

    HdmiCecFeatureAction(HdmiCecLocalDevice source, List<IHdmiControlCallback> callbacks) {
        this.mState = 0;
        this.mCallbacks = new ArrayList();
        Iterator<IHdmiControlCallback> r0 = callbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        IHdmiControlCallback callback = r0.next();
        addCallback(callback);
        goto L4
    L6:
        this.mSource = source;
        this.mService = this.mSource.getService();
        this.mActionTimer = createActionTimer(this.mService.getServiceLooper());
    }

    void setActionTimer(ActionTimer actionTimer) {
        this.mActionTimer = actionTimer;
    }

    private ActionTimer createActionTimer(Looper looper) {
        return new ActionTimerHandler(this, looper);
    }

    protected void addTimer(int state, int delayMillis) {
        this.mActionTimer.sendTimerMessage(state, delayMillis);
    }

    boolean started() {
        if (this.mState == 0) goto L5;
        return true;
    L5:
        return false;
    }

    protected final void sendCommand(HdmiCecMessage cmd) {
        this.mService.sendCecCommand(cmd);
    }

    protected final void sendCommand(HdmiCecMessage cmd, HdmiControlService.SendMessageCallback callback) {
        this.mService.sendCecCommand(cmd, callback);
    }

    protected final void sendCommandWithoutRetries(HdmiCecMessage cmd, HdmiControlService.SendMessageCallback callback) {
        this.mService.sendCecCommandWithoutRetries(cmd, callback);
    }

    protected final void addAndStartAction(HdmiCecFeatureAction action) {
        this.mSource.addAndStartAction(action);
    }

    protected final <T extends HdmiCecFeatureAction> List<T> getActions(Class<T> clazz) {
        return this.mSource.getActions(clazz);
    }

    protected final HdmiCecMessageCache getCecMessageCache() {
        return this.mSource.getCecMessageCache();
    }

    protected final void removeAction(HdmiCecFeatureAction action) {
        this.mSource.removeAction(action);
    }

    protected final <T extends HdmiCecFeatureAction> void removeAction(Class<T> clazz) {
        this.mSource.removeActionExcept(clazz, null);
    }

    protected final <T extends HdmiCecFeatureAction> void removeActionExcept(Class<T> clazz, HdmiCecFeatureAction exception) {
        this.mSource.removeActionExcept(clazz, exception);
    }

    protected final void pollDevices(HdmiControlService.DevicePollingCallback callback, int pickStrategy, int retryCount) {
        pollDevices(callback, pickStrategy, retryCount, 0);
    }

    protected final void pollDevices(HdmiControlService.DevicePollingCallback callback, int pickStrategy, int retryCount, long pollingMessageInterval) {
        this.mService.pollDevices(callback, getSourceAddress(), pickStrategy, retryCount, pollingMessageInterval);
    }

    void clear() {
        this.mState = 0;
        this.mActionTimer.clearTimerMessage();
    }

    protected void finish() {
        finish(true);
    }

    void finish(boolean removeSelf) {
        clear();
        if (removeSelf == false) goto L6;
        removeAction(this);
    L6:
        if (this.mOnFinishedCallbacks == null) goto L21;
        Iterator<Pair<HdmiCecFeatureAction, Runnable>> r0 = this.mOnFinishedCallbacks.iterator();
    L9:
        if (r0.hasNext() == false) goto L14;
        Pair<HdmiCecFeatureAction, Runnable> actionCallbackPair = r0.next();
        if (((HdmiCecFeatureAction) actionCallbackPair.first).mState == 0) goto L9;
        ((Runnable) actionCallbackPair.second).run();
        goto L9
    L14:
        this.mOnFinishedCallbacks = null;
        return;
    }

    protected final HdmiCecLocalDevice localDevice() {
        return this.mSource;
    }

    protected final HdmiCecLocalDevicePlayback playback() {
        return (HdmiCecLocalDevicePlayback) this.mSource;
    }

    protected final HdmiCecLocalDeviceSource source() {
        return (HdmiCecLocalDeviceSource) this.mSource;
    }

    protected final HdmiCecLocalDeviceTv tv() {
        return (HdmiCecLocalDeviceTv) this.mSource;
    }

    protected final HdmiCecLocalDeviceAudioSystem audioSystem() {
        return (HdmiCecLocalDeviceAudioSystem) this.mSource;
    }

    protected final int getSourceAddress() {
        return this.mSource.getDeviceInfo().getLogicalAddress();
    }

    protected final int getSourcePath() {
        return this.mSource.getDeviceInfo().getPhysicalAddress();
    }

    protected final int getServicePath() {
        return this.mService.getPhysicalAddress();
    }

    protected final void sendUserControlPressedAndReleased(int targetAddress, int uiCommand) {
        this.mSource.sendUserControlPressedAndReleased(targetAddress, uiCommand);
    }

    protected final void addOnFinishedCallback(HdmiCecFeatureAction action, Runnable runnable) {
        if (this.mOnFinishedCallbacks != null) goto L5;
        this.mOnFinishedCallbacks = new ArrayList();
    L5:
        this.mOnFinishedCallbacks.add(Pair.create(action, runnable));
    }

    protected void finishWithCallback(int returnCode) {
        invokeCallback(returnCode);
        finish();
    }

    public void addCallback(IHdmiControlCallback callback) {
        this.mCallbacks.add(callback);
    }

    private void invokeCallback(int result) {
        Iterator<IHdmiControlCallback> r0 = this.mCallbacks.iterator();     // Catch: RemoteException -> L10
    L4:
        if (r0.hasNext() == false) goto L23;
        IHdmiControlCallback callback = r0.next();     // Catch: RemoteException -> L10
        if (callback == null) goto L4;
        callback.onComplete(result);     // Catch: RemoteException -> L10
        goto L4
    L23:
        return;
    L10:
        e = move-exception;
        Slog.e(TAG, "Callback failed:" + e);
    }
}
