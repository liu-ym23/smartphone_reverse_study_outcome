package com.stepos.launcher.client;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.view.SurfaceControl;
import android.view.Window;
import android.view.WindowManager;
import com.stepos.launcher.client.libraries.ILauncherOverlayCallback;
import com.stepos.launcher.client.libraries.ILauncherWidgetDragCallback;

/* loaded from: classes.dex */
public class LauncherClient {

    public static class OverlayCallbacks extends ILauncherOverlayCallback.Stub implements Handler.Callback {
        private static final int MSG_QUICKSTEP_INTERACTION = 4;
        private static final int MSG_SCROLL_CHANGED = 1;
        private static final int MSG_STATUS_CHANGED = 2;
        private static final int MSG_SURFACE_CHANGED = 5;
        private static final int MSG_WINDOW_UPDATE = 3;
        private LauncherClient mClient;
        private Window mWindow;
        private WindowManager mWindowManager;
        private int mWindowShift;
        private final Handler mUIHandler = new Handler(Looper.getMainLooper(), this);
        private boolean mWindowHidden = false;
        private float mLastSentProgress = -1.0f;

        private OverlayCallbacks() {
        }

        public final void clear() {
            this.mWindowManager = null;
            this.mWindow = null;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            return true;
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlayCallback
        public void onOverlaySurfaceChanged(SurfaceControl surfaceControl) {
            this.mUIHandler.removeMessages(5);
            Message messageObtain = Message.obtain(this.mUIHandler, 5, surfaceControl);
            messageObtain.setAsynchronous(true);
            messageObtain.sendToTarget();
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlayCallback
        public int onQuickstepInteraction(Bundle bundle) {
            b bVarA = b.a(bundle);
            if (bVarA != null) {
                Message messageObtain = Message.obtain(this.mUIHandler, 4, bVarA);
                messageObtain.setAsynchronous(true);
                messageObtain.sendToTarget();
                return 1;
            }
            throw new IllegalArgumentException("Bad interaction contract from bundle! " + bundle);
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlayCallback
        public void overlayScrollChanged(float f10) throws RemoteException {
            if (this.mLastSentProgress < 0.99f || f10 <= 0.0f || f10 >= 0.99f) {
                this.mUIHandler.removeMessages(1);
            }
            this.mLastSentProgress = f10;
            Message messageObtain = Message.obtain(this.mUIHandler, 1, Float.valueOf(f10));
            messageObtain.setAsynchronous(true);
            messageObtain.sendToTarget();
            if (f10 <= 0.0f || !this.mWindowHidden) {
                return;
            }
            this.mWindowHidden = false;
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherOverlayCallback
        public void overlayStateChanged(int i10) throws RemoteException {
            Message.obtain(this.mUIHandler, 2, i10, 0).sendToTarget();
        }

        public final void setClient(LauncherClient launcherClient) {
            throw null;
        }

        public final void updateOverlayWindow() {
            Message.obtain(this.mUIHandler, 3).sendToTarget();
        }
    }

    public static class WidgetDragCallbacks extends ILauncherWidgetDragCallback.Stub {
        private LauncherClient mClient;

        private WidgetDragCallbacks() {
        }

        public final void clear() {
        }

        @Override // com.stepos.launcher.client.libraries.ILauncherWidgetDragCallback
        public Bundle onGetDragBundle(Bundle bundle) throws RemoteException {
            return null;
        }

        public final void setClient(LauncherClient launcherClient) {
        }
    }
}
