package com.stepos.launcher.assistant.slidepanel;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.stepos.launcher.client.libraries.ILauncherOverlayCallback;
import com.stepos.launcher.client.libraries.ILauncherWidgetDragCallback;
import io.ktor.util.cio.ByteBufferPoolKt;

/* loaded from: classes.dex */
public class LauncherOverlayCallback implements Handler.Callback {
    public static final int MSG_ATTACH_TO_WINDOW = 3;
    public static final int MSG_BIND_WIDGET_CALLBACK = 15;
    public static final int MSG_CLOSE_OVERLAY = 2;
    public static final int MSG_DETACH_FROM_WINDOW = 4;
    public static final int MSG_END_SCROLL = 12;
    public static final int MSG_NAV_TO_DEFAULT = 21;
    public static final int MSG_ON_CREATE = 5;
    public static final int MSG_ON_DESTROY = 10;
    public static final int MSG_ON_FLING_VELOCITY = 20;
    public static final int MSG_ON_PAUSE = 7;
    public static final int MSG_ON_PROXY_TOUCH = 19;
    public static final int MSG_ON_REMOTE_TRANSITION_END = 18;
    public static final int MSG_ON_REMOTE_TRANSITION_START = 17;
    public static final int MSG_ON_RESUME = 8;
    public static final int MSG_ON_SCROLL = 13;
    public static final int MSG_ON_START = 6;
    public static final int MSG_ON_STOP = 9;
    public static final int MSG_OPEN_OVERLAY = 1;
    public static final int MSG_SET_DECOR_VIEW_PROPERTIES = 16;
    public static final int MSG_START_SCROLL = 11;
    public static final int ON_BACK_PRESS = 14;
    private static final String TAG = "LauncherOverlayCallback";
    private Context mContext;
    private ScrollOverlayComponent mOverlayComponent;
    private ILauncherOverlayCallback mProxyCallbacks;
    private ScrollOverlayComponent mSlidePanelOverlayComponent;
    private ILauncherWidgetDragCallback mWidgetDragProxyCallbacks;

    public LauncherOverlayCallback(Context context, ScrollOverlayComponent scrollOverlayComponent) {
        this.mContext = context;
        this.mSlidePanelOverlayComponent = scrollOverlayComponent;
    }

    public final void dispatchTouchEvent(int i10, int i11, long j10) {
        MotionEvent motionEventObtain = MotionEvent.obtain(SystemClock.uptimeMillis(), j10, i10, i11, 10.0f, 0);
        motionEventObtain.setSource(ByteBufferPoolKt.DEFAULT_BUFFER_SIZE);
        this.mOverlayComponent.getSlidingPanelLayout().dispatchTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01d8 A[Catch: BadTokenException -> 0x01dc, TRY_LEAVE, TryCatch #1 {BadTokenException -> 0x01dc, blocks: (B:96:0x01d4, B:98:0x01d8), top: B:121:0x01d4 }] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean handleMessage(android.os.Message r9) throws java.lang.IllegalAccessException, android.content.pm.PackageManager.NameNotFoundException, java.lang.ClassNotFoundException, android.os.RemoteException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.launcher.assistant.slidepanel.LauncherOverlayCallback.handleMessage(android.os.Message):boolean");
    }
}
