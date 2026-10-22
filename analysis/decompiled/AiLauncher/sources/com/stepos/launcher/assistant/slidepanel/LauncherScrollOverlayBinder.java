package com.stepos.launcher.assistant.slidepanel;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.stepos.launcher.assistant.quickstep.RemoteTransitionParams;
import com.stepos.launcher.assistant.utils.XLog;
import com.stepos.launcher.assistant.widgetdrag.IOverlayWidgetComponent;
import com.stepos.launcher.client.libraries.ILauncherOverlay;
import com.stepos.launcher.client.libraries.ILauncherOverlayCallback;
import com.stepos.launcher.client.libraries.ILauncherWidgetDragCallback;

/* loaded from: classes.dex */
public class LauncherScrollOverlayBinder extends ILauncherOverlay.Stub {
    private final Handler mDispatcherHandler;
    private ScrollOverlayComponent mOverlayComponent;

    public LauncherScrollOverlayBinder(Context context, ScrollOverlayComponent scrollOverlayComponent) {
        this.mOverlayComponent = scrollOverlayComponent;
        this.mDispatcherHandler = new Handler(Looper.getMainLooper(), new LauncherOverlayCallback(context, scrollOverlayComponent));
    }

    private void dispatchMessage(Message message) {
        this.mDispatcherHandler.sendMessage(message);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void bindWidgetDragCallbacks(ILauncherWidgetDragCallback iLauncherWidgetDragCallback) throws RemoteException {
        Message messageObtain = Message.obtain(this.mDispatcherHandler, 15);
        messageObtain.obj = iLauncherWidgetDragCallback;
        dispatchMessage(messageObtain);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void closeOverlay(int i10) throws RemoteException {
        XLog.i(XLog.getTag(), "closeOverlay");
        Message messageObtain = Message.obtain(this.mDispatcherHandler, 2);
        messageObtain.obj = Integer.valueOf(i10);
        dispatchMessage(messageObtain);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void endScroll() throws RemoteException {
        dispatchMessage(Message.obtain(this.mDispatcherHandler, 12));
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public boolean isOverlayOpened() throws RemoteException {
        return false;
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void navigateToDefaultPage() throws RemoteException {
        dispatchMessage(Message.obtain(this.mDispatcherHandler, 21));
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void onBackPressed() throws RemoteException {
        dispatchMessage(Message.obtain(this.mDispatcherHandler, 14));
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void onFlingVelocity(float f10) {
        dispatchMessage(Message.obtain(this.mDispatcherHandler, 20, Float.valueOf(f10)));
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void onPause() {
        Message messageObtain = Message.obtain(this.mDispatcherHandler, 7);
        messageObtain.setAsynchronous(true);
        dispatchMessage(messageObtain);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void onProxyTouch(MotionEvent motionEvent) throws RemoteException {
        Message messageObtain = Message.obtain(this.mDispatcherHandler, 19, motionEvent);
        messageObtain.setAsynchronous(true);
        dispatchMessage(messageObtain);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void onRemoteTransitionEnd(Bundle bundle) throws RemoteException {
        RemoteTransitionParams remoteTransitionParamsFrom = RemoteTransitionParams.from(bundle);
        if (remoteTransitionParamsFrom != null) {
            Message messageObtain = Message.obtain(this.mDispatcherHandler, 18, remoteTransitionParamsFrom);
            messageObtain.setAsynchronous(true);
            dispatchMessage(messageObtain);
        } else {
            throw new RemoteException("Bad transition contract from bundle! " + bundle);
        }
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void onRemoteTransitionStart(Bundle bundle) throws RemoteException {
        RemoteTransitionParams remoteTransitionParamsFrom = RemoteTransitionParams.from(bundle);
        if (remoteTransitionParamsFrom != null) {
            Message messageObtain = Message.obtain(this.mDispatcherHandler, 17, remoteTransitionParamsFrom);
            messageObtain.setAsynchronous(true);
            dispatchMessage(messageObtain);
        } else {
            throw new RemoteException("Bad transition contract from bundle! " + bundle);
        }
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void onResume() {
        Message messageObtain = Message.obtain(this.mDispatcherHandler, 8);
        messageObtain.setAsynchronous(true);
        dispatchMessage(messageObtain);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void onScroll(float f10) throws RemoteException {
        Message messageObtain = Message.obtain(this.mDispatcherHandler, 13);
        messageObtain.obj = Float.valueOf(f10);
        dispatchMessage(messageObtain);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void onStart() throws RemoteException {
        Message messageObtain = Message.obtain(this.mDispatcherHandler, 6);
        messageObtain.setAsynchronous(true);
        dispatchMessage(messageObtain);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void onStop() throws RemoteException {
        Message messageObtain = Message.obtain(this.mDispatcherHandler, 9);
        messageObtain.setAsynchronous(true);
        dispatchMessage(messageObtain);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public Bundle onWidgetDragBundle(Bundle bundle) throws RemoteException {
        IBinder.DeathRecipient deathRecipient = this.mOverlayComponent;
        if (deathRecipient == null || !(deathRecipient instanceof IOverlayWidgetComponent)) {
            return null;
        }
        return ((IOverlayWidgetComponent) deathRecipient).onReceiveWidgetDragBundle(bundle);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void openOverlay(int i10) throws RemoteException {
        XLog.i(XLog.getTag(), "openOverlay");
        Message messageObtain = Message.obtain(this.mDispatcherHandler, 1);
        messageObtain.obj = Integer.valueOf(i10);
        dispatchMessage(messageObtain);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void setOverlayViewProperties(Bundle bundle) throws RemoteException {
        Message messageObtain = Message.obtain(this.mDispatcherHandler, 16);
        messageObtain.setData(bundle);
        messageObtain.setAsynchronous(true);
        dispatchMessage(messageObtain);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void startScroll() throws RemoteException {
        dispatchMessage(Message.obtain(this.mDispatcherHandler, 11));
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void stateChange(int i10) throws RemoteException {
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void windowAttached(WindowManager.LayoutParams layoutParams, ILauncherOverlayCallback iLauncherOverlayCallback, int i10) throws RemoteException {
        XLog.i(XLog.getTag(), "windowAttached");
        Message messageObtain = Message.obtain(this.mDispatcherHandler, 3);
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrs", layoutParams);
        messageObtain.setData(bundle);
        messageObtain.obj = iLauncherOverlayCallback;
        messageObtain.setAsynchronous(true);
        dispatchMessage(messageObtain);
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void windowAttached2(Bundle bundle, ILauncherOverlayCallback iLauncherOverlayCallback) throws RemoteException {
    }

    @Override // com.stepos.launcher.client.libraries.ILauncherOverlay
    public void windowDetached(boolean z10) throws RemoteException {
        XLog.i(XLog.getTag(), "windowDetached");
        Message messageObtain = Message.obtain(this.mDispatcherHandler, 4);
        messageObtain.setAsynchronous(true);
        dispatchMessage(messageObtain);
    }
}
