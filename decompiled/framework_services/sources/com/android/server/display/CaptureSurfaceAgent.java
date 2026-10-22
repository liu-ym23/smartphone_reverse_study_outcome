package com.android.server.display;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.util.Slog;
import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
public class CaptureSurfaceAgent {
    private static final int AGENT_TYPE_CHECK = 1;
    private static final int AGENT_TYPE_SURFACE = 2;
    private static final String CAPTURE_ACTION = "android.intent.action.SCREEN_CAPTURE";
    private static final String CAPTURE_SERVICE = "com.pxr.pxrapi.ScreenCaptureService";
    private static final int MSG_CHECK_CAPTURE = 3;
    private static final int MSG_START_CAPTURE = 1;
    private static final int MSG_STOP_CAPTURE = 2;
    private static final String NEW_CAPTURE_ENABLE = "1";
    private static final String PROP_DISABLE_NEW_CAPTURE = "persist.pxr.new_capture.disable";
    private static final String PROP_NEW_CAPTURE_RUNTIME = "pico.pxr.new_capture.enable";
    private static final String RUNTIME_PACKAGE = "com.pico.xr.openxr_runtime";
    public static final String TAG = "CaptureSurfaceAgent";
    public static boolean mNewCaptureStatus;
    private int mAgentType;
    private int mCaptureType;
    private ServiceConnection mConn;
    private Context mContext;
    private CaptureSurfaceHandler mHandler;
    private int mHeight;
    private boolean mIsConnected;
    private Surface mSurface;
    private int mWidth;

    private class CaptureSurfaceHandler extends Handler {
        final /* synthetic */ CaptureSurfaceAgent this$0;

        public CaptureSurfaceHandler(CaptureSurfaceAgent r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L5;
                default: goto L13;
            };     // Catch: Exception -> L6
        L5:
            CaptureSurfaceAgent.m3608$$Nest$mcheckCaptureImpl(this.this$0);     // Catch: Exception -> L6
            goto L13
        L8:
            CaptureSurfaceAgent.m3610$$Nest$mstopCaptureImpl(this.this$0);     // Catch: Exception -> L6
            goto L13
        L9:
            CaptureSurfaceAgent.m3609$$Nest$mstartCaptureImpl(this.this$0);     // Catch: Exception -> L6
        L13:
            return;
        L11:
            Slog.e(CaptureSurfaceAgent.TAG, "CaptureSurfaceHandler error: " + msg.what);
        }

        public void dispatchStartCapture() {
            sendEmptyMessage(1);
        }

        public void dispatchStopCapture() {
            sendEmptyMessage(2);
        }

        public void dispatchCheckCapture() {
            sendEmptyMessage(3);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3607$$Nest$fputmIsConnected(CaptureSurfaceAgent r0, boolean r1) {
        r0.mIsConnected = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckCaptureImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3608$$Nest$mcheckCaptureImpl(CaptureSurfaceAgent r0) {
        r0.checkCaptureImpl();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartCaptureImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3609$$Nest$mstartCaptureImpl(CaptureSurfaceAgent r0) {
        r0.startCaptureImpl();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopCaptureImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3610$$Nest$mstopCaptureImpl(CaptureSurfaceAgent r0) {
        r0.stopCaptureImpl();
    }

    static {
        mNewCaptureStatus = false;
    }

    public CaptureSurfaceAgent(Context context, Surface surface, int type, int width, int height) {
        this.mIsConnected = false;
        this.mContext = context;
        this.mSurface = surface;
        this.mCaptureType = type;
        this.mWidth = width;
        this.mHeight = height;
        this.mAgentType = 2;
        HandlerThread handlerThread = new HandlerThread("CaptureSurfaceLooper");
        handlerThread.start();
        this.mHandler = new CaptureSurfaceHandler(this, handlerThread.getLooper());
    }

    public CaptureSurfaceAgent(Context context) {
        this.mIsConnected = false;
        this.mContext = context;
        this.mAgentType = 1;
        HandlerThread handlerThread = new HandlerThread("CheckCaptureSurfaceLooper");
        handlerThread.start();
        this.mHandler = new CaptureSurfaceHandler(this, handlerThread.getLooper());
    }

    public void startCapture() {
        if (this.mAgentType != 2) goto L6;
        this.mHandler.dispatchStartCapture();
        return;
    }

    public void stopCapture() {
        if (this.mAgentType != 2) goto L6;
        this.mHandler.dispatchStopCapture();
        return;
    }

    public void checkCapture() {
        if (this.mAgentType != 1) goto L6;
        this.mHandler.dispatchCheckCapture();
        return;
    }

    public static boolean isNewCaptureEnable() {
        return mNewCaptureStatus;
    }

    private void startCaptureImpl() {
        Intent intent = new Intent();     // Catch: Exception -> L7
        intent.setComponent(new ComponentName(RUNTIME_PACKAGE, CAPTURE_SERVICE));     // Catch: Exception -> L7
        intent.setAction(CAPTURE_ACTION);     // Catch: Exception -> L7
        this.mConn = new AnonymousClass1(this);     // Catch: Exception -> L7
        boolean ret = this.mContext.bindServiceAsUser(intent, this.mConn, 1, UserHandle.CURRENT);     // Catch: Exception -> L7
        if (ret == true) goto L14;
        mNewCaptureStatus = false;     // Catch: Exception -> L7
        this.mContext.unbindService(this.mConn);     // Catch: Exception -> L7
        Slog.i(TAG, "startCapture bindService failed, disable new capture...");     // Catch: Exception -> L7
        return;
    L14:
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "error: startCapture exception: " + e);
    }

    private void stopCaptureImpl() {
    }

    private void checkCaptureImpl() {
        if (isNewCaptureDisable() == false) goto L11;
        Slog.i(TAG, "new chapture is disabled...");
        mNewCaptureStatus = false;
        return;
    L11:
        Intent intent = new Intent();     // Catch: Exception -> L8
        intent.setComponent(new ComponentName(RUNTIME_PACKAGE, CAPTURE_SERVICE));     // Catch: Exception -> L8
        intent.setAction(CAPTURE_ACTION);     // Catch: Exception -> L8
        this.mConn = new AnonymousClass2(this);     // Catch: Exception -> L8
        SystemProperties.set(PROP_NEW_CAPTURE_RUNTIME, NEW_CAPTURE_ENABLE);     // Catch: Exception -> L8
        mNewCaptureStatus = this.mContext.bindServiceAsUser(intent, this.mConn, 1, UserHandle.CURRENT);     // Catch: Exception -> L8
        Slog.i(TAG, "checkCapture enable: " + mNewCaptureStatus);     // Catch: Exception -> L8
        this.mContext.unbindService(this.mConn);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "error: checkCapture exception: " + e);
    }

    private boolean isNewCaptureDisable() {
        return SystemProperties.getBoolean(PROP_DISABLE_NEW_CAPTURE, false);
    }
}
