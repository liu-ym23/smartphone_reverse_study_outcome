package com.android.server.display;

import android.R;
import android.app.ObricActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.IBrightnessListener;
import android.hardware.display.IVirtualDisplayCallback;
import android.hardware.display.VirtualDisplayConfig;
import android.media.projection.IMediaProjection;
import android.media.projection.IMediaProjectionCallback;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.DisplayShape;
import android.view.Surface;
import android.view.SurfaceControl;
import com.android.server.SysOptBridge;
import com.android.server.am.IAppRecordManagerService;
import com.android.server.display.brightness.BrightnessUtils;
import com.android.server.display.feature.DisplayManagerFlags;
import com.obric.server.display.ObricAutoActionDisplayStateReporter;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class VirtualDisplayAdapter extends DisplayAdapter {
    static final String TAG = "VirtualDisplayAdapter";
    static final String UNIQUE_ID_PREFIX = "virtual:";
    private static final AtomicInteger sNextUniqueIndex = null;
    private final Handler mHandler;
    private final int mMaxDevices;
    private final int mMaxDevicesPerPackage;
    private final SparseIntArray mNoOfDevicesPerPackage;
    private final ArrayMap<IBinder, Integer> mOwnerUids;
    private final SurfaceControlDisplayFactory mSurfaceControlDisplayFactory;
    private final ArrayMap<IBinder, VirtualDisplayDevice> mVirtualDisplayDevices;

    private static class Callback extends Handler {
        private static final int MSG_ON_DISPLAY_PAUSED = 0;
        private static final int MSG_ON_DISPLAY_RESUMED = 1;
        private static final int MSG_ON_DISPLAY_STOPPED = 2;
        private static final int MSG_ON_REQUESTED_BRIGHTNESS_CHANGED = 3;
        private final IBrightnessListener mBrightnessListener;
        private final IVirtualDisplayCallback mCallback;

        Callback(IVirtualDisplayCallback callback, IBrightnessListener brightnessListener, Handler handler) {
            super(handler.getLooper());
            this.mCallback = callback;
            this.mBrightnessListener = brightnessListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
        L8:
            e = move-exception;
            Slog.w(VirtualDisplayAdapter.TAG, "Failed to notify listener of virtual display event.", e);
            return;
        L3:
            switch(msg.what) {
                case 0: goto L12;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L6;
                default: goto L16;
            };     // Catch: RemoteException -> L8
        L10:
            this.mCallback.onStopped();     // Catch: RemoteException -> L8
            goto L16
        L11:
            this.mCallback.onResumed();     // Catch: RemoteException -> L8
            goto L16
        L12:
            this.mCallback.onPaused();     // Catch: RemoteException -> L8
        L16:
            return;
        L6:
            if (this.mBrightnessListener == null) goto L16;
            this.mBrightnessListener.onBrightnessChanged(((Float) msg.obj).floatValue());     // Catch: RemoteException -> L8
            goto L16
        }

        public void dispatchDisplayPaused() {
            sendEmptyMessage(0);
        }

        public void dispatchDisplayResumed() {
            sendEmptyMessage(1);
        }

        public void dispatchRequestedBrightnessChanged(float brightness) {
            Message msg = obtainMessage(3, Float.valueOf(brightness));
            sendMessage(msg);
        }

        public void dispatchDisplayStopped() {
            sendEmptyMessage(2);
        }
    }

    private final class MediaProjectionCallback extends IMediaProjectionCallback.Stub {
        private IBinder mAppToken;
        final /* synthetic */ VirtualDisplayAdapter this$0;

        public MediaProjectionCallback(VirtualDisplayAdapter r1, IBinder appToken) {
            this.this$0 = r1;
            this.mAppToken = appToken;
        }

        public void onStop() {
            DisplayManagerService.SyncRoot r0 = this.this$0.getSyncRoot();
            monitor-enter(r0);
            VirtualDisplayAdapter.m3897$$Nest$mhandleMediaProjectionStoppedLocked(this.this$0, this.mAppToken);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void onCapturedContentResize(int width, int height) {
        }

        public void onCapturedContentVisibilityChanged(boolean isVisible) {
        }
    }

    public interface SurfaceControlDisplayFactory {
        IBinder createDisplay(String r1, boolean r2, boolean r3, String r4, float r5);

        void destroyDisplay(IBinder r1);

        void setDisplayPowerMode(IBinder r1, int r2);
    }

    private final class VirtualDisplayDevice extends DisplayDevice implements IBinder.DeathRecipient {
        private static final int PENDING_RESIZE = 2;
        private static final int PENDING_SURFACE_CHANGE = 1;
        private static final float REFRESH_RATE = 60.0f;
        private final IBinder mAppToken;
        private final IBrightnessListener mBrightnessListener;
        private final Callback mCallback;
        private float mCurrentBrightness;
        private final float mDefaultBrightness;
        private int mDensityDpi;
        private final float mDimBrightness;
        private final DisplayCutout mDisplayCutout;
        private int mDisplayIdToMirror;
        private int mDisplayState;
        private final int mFlags;
        private int mHeight;
        private DisplayDeviceInfo mInfo;
        private boolean mIsWindowManagerMirroring;
        private final IMediaProjectionCallback mMediaProjectionCallback;
        private Display.Mode mMode;
        final String mName;
        private final boolean mNeverBlank;
        final String mOwnerPackageName;
        private final int mOwnerUid;
        private int mPendingChanges;
        private final IMediaProjection mProjection;
        private final float mRequestedRefreshRate;
        private boolean mStopped;
        private Surface mSurface;
        private int mWidth;
        final /* synthetic */ VirtualDisplayAdapter this$0;

        public static /* synthetic */ void $r8$lambda$Nydk6Siy9w0nfqEHE_FsTygOGl0(VirtualDisplayDevice r0, int r1, IBinder r2) {
            r0.lambda$requestDisplayStateLocked$0(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOwnerUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m3900$$Nest$fgetmOwnerUid(VirtualDisplayDevice r0) {
            return r0.mOwnerUid;
        }

        public VirtualDisplayDevice(VirtualDisplayAdapter r13, IBinder displayToken, IBinder appToken, int ownerUid, String ownerPackageName, Surface surface, int flags, Callback callback, IMediaProjection projection, IMediaProjectionCallback mediaProjectionCallback, String uniqueId, VirtualDisplayConfig virtualDisplayConfig) {
            this.this$0 = r13;
            super(r13, displayToken, uniqueId, r13.getContext());
            this.mAppToken = appToken;
            this.mOwnerUid = ownerUid;
            this.mOwnerPackageName = ownerPackageName;
            this.mName = virtualDisplayConfig.getName();
            this.mWidth = virtualDisplayConfig.getWidth();
            this.mHeight = virtualDisplayConfig.getHeight();
            this.mDensityDpi = virtualDisplayConfig.getDensityDpi();
            this.mRequestedRefreshRate = virtualDisplayConfig.getRequestedRefreshRate();
            this.mDisplayCutout = virtualDisplayConfig.getDisplayCutout();
            this.mDefaultBrightness = virtualDisplayConfig.getDefaultBrightness();
            this.mDimBrightness = virtualDisplayConfig.getDimBrightness();
            this.mCurrentBrightness = -1.0f;
            this.mBrightnessListener = virtualDisplayConfig.getBrightnessListener();
            this.mMode = DisplayAdapter.createMode(this.mWidth, this.mHeight, getRefreshRate());
            this.mSurface = surface;
            this.mFlags = flags;
            this.mCallback = callback;
            this.mProjection = projection;
            this.mMediaProjectionCallback = mediaProjectionCallback;
            if (VirtualDisplayAdapter.m3899$$Nest$smisNeverBlank(flags) == false) goto L5;
        L8:
            boolean r2 = true;
        L9:
            this.mNeverBlank = r2;
            if (this.mNeverBlank == true) goto L12;
            this.mDisplayState = 0;
        L13:
            this.mPendingChanges |= 1;
            this.mDisplayIdToMirror = virtualDisplayConfig.getDisplayIdToMirror();
            this.mIsWindowManagerMirroring = virtualDisplayConfig.isWindowManagerMirroringEnabled();
            IAppRecordManagerService appRecordManagerService = SysOptBridge.getFactory().getAppRecordManagerService();
            if (appRecordManagerService == null) goto L17;
            appRecordManagerService.onVirtualDisplayChanged(ownerPackageName, ownerUid, this.mName, displayToken, 1);
            return;
        L17:
            return;
        L12:
            this.mDisplayState = 2;
            goto L13
        L5:
            if (ObricActivityManager.isAutoAction(ownerPackageName) == true) goto L8;
            r2 = false;
            goto L9
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            DisplayManagerService.SyncRoot r0 = this.this$0.getSyncRoot();
            monitor-enter(r0);
            VirtualDisplayAdapter.m3898$$Nest$mremoveVirtualDisplayDeviceLocked(this.this$0, this.mAppToken);     // Catch: Throwable -> L10
            Slog.i(VirtualDisplayAdapter.TAG, "Virtual display device released because application token died: " + this.mOwnerPackageName);     // Catch: Throwable -> L10
            destroyLocked(false);     // Catch: Throwable -> L10
            if (this.mProjection != null) goto L7;
        L14:
            this.this$0.sendDisplayDeviceEventLocked(this, 3);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L7:
            if (this.mMediaProjectionCallback == null) goto L14;
            this.mProjection.unregisterCallback(this.mMediaProjectionCallback);     // Catch: Throwable -> L10 RemoteException -> L12
        L12:
            e = move-exception;
            Slog.w(VirtualDisplayAdapter.TAG, "Failed to unregister callback in binderDied", e);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public void destroyLocked(boolean binderAlive) {
            if (this.mSurface == null) goto L5;
            this.mSurface.release();
            this.mSurface = null;
        L5:
            VirtualDisplayAdapter.m3896$$Nest$fgetmSurfaceControlDisplayFactory(this.this$0).destroyDisplay(getDisplayTokenLocked());
            if (this.mProjection != null) goto L8;
        L13:
            if (binderAlive == false) goto L18;
            this.mCallback.dispatchDisplayStopped();
            return;
        L18:
            return;
        L8:
            if (this.mMediaProjectionCallback == null) goto L13;
            this.mProjection.unregisterCallback(this.mMediaProjectionCallback);     // Catch: RemoteException -> L11
        L11:
            e = move-exception;
            Slog.w(VirtualDisplayAdapter.TAG, "Failed to unregister callback in destroy", e);
            goto L13
        }

        @Override // com.android.server.display.DisplayDevice
        public int getDisplayIdToMirrorLocked() {
            return this.mDisplayIdToMirror;
        }

        void setDisplayIdToMirror(int displayIdToMirror) {
            if (this.mDisplayIdToMirror == displayIdToMirror) goto L6;
            this.mDisplayIdToMirror = displayIdToMirror;
            this.mInfo = null;
            this.this$0.sendDisplayDeviceEventLocked(this, 2);
            this.this$0.sendTraversalRequestLocked();
            return;
        }

        @Override // com.android.server.display.DisplayDevice
        public boolean isWindowManagerMirroringLocked() {
            return this.mIsWindowManagerMirroring;
        }

        @Override // com.android.server.display.DisplayDevice
        public void setWindowManagerMirroringLocked(boolean mirroring) {
            if (this.mIsWindowManagerMirroring == mirroring) goto L6;
            this.mIsWindowManagerMirroring = mirroring;
            this.this$0.sendDisplayDeviceEventLocked(this, 2);
            this.this$0.sendTraversalRequestLocked();
            return;
        }

        @Override // com.android.server.display.DisplayDevice
        public Point getDisplaySurfaceDefaultSizeLocked() {
            if (this.mSurface != null) goto L6;
            return null;
        L6:
            Point surfaceSize = this.mSurface.getDefaultSize();
            if (isRotatedLocked() == false) goto L10;
            return new Point(surfaceSize.y, surfaceSize.x);
        L10:
            return surfaceSize;
        }

        Surface getSurfaceLocked() {
            return this.mSurface;
        }

        @Override // com.android.server.display.DisplayDevice
        public boolean hasStableUniqueId() {
            return false;
        }

        @Override // com.android.server.display.DisplayDevice
        public Runnable requestDisplayStateLocked(final int state, float brightnessState, float sdrBrightnessState, DisplayOffloadSessionImpl displayOffloadSession) {
            Runnable runnable = null;
            if (state == this.mDisplayState) goto L14;
            Slog.d(VirtualDisplayAdapter.TAG, "Changing state of virtual display " + this.mName + " from " + Display.stateToString(this.mDisplayState) + " to " + Display.stateToString(state));
            if (state == 2) goto L8;
            if (state == 1) goto L8;
            Slog.wtf(VirtualDisplayAdapter.TAG, "Unexpected display state for Virtual Display: " + Display.stateToString(state));
        L8:
            this.mDisplayState = state;
            this.mInfo = null;
            this.this$0.sendDisplayDeviceEventLocked(this, 2);
            if (state != 1) goto L11;
            this.mCallback.dispatchDisplayPaused();
        L12:
            final IBinder token = getDisplayTokenLocked();
            runnable = new VirtualDisplayAdapter$VirtualDisplayDevice$$ExternalSyntheticLambda0(this, state, token);
            goto L14
        L11:
            this.mCallback.dispatchDisplayResumed();
        L14:
            if (this.mBrightnessListener != null) goto L16;
        L20:
            return runnable;
        L16:
            if (BrightnessUtils.isValidBrightnessValue(brightnessState) == false) goto L20;
            if (brightnessState == this.mCurrentBrightness) goto L20;
            this.mCurrentBrightness = brightnessState;
            this.mCallback.dispatchRequestedBrightnessChanged(this.mCurrentBrightness);
            goto L20
        }

        private /* synthetic */ void lambda$requestDisplayStateLocked$0(int state, IBinder token) {
            int mode = DisplayAdapter.getPowerModeForState(state);
            Slog.d(VirtualDisplayAdapter.TAG, "Requesting power mode for display " + this.mName + " to " + mode);
            VirtualDisplayAdapter.m3896$$Nest$fgetmSurfaceControlDisplayFactory(this.this$0).setDisplayPowerMode(token, mode);
        }

        @Override // com.android.server.display.DisplayDevice
        public void configureSurfaceLocked(SurfaceControl.Transaction t) {
            if ((this.mPendingChanges & 1) == 0) goto L6;
            setSurfaceLocked(t, this.mSurface);
            this.mPendingChanges &= -2;
            return;
        }

        @Override // com.android.server.display.DisplayDevice
        public void configureDisplaySizeLocked(SurfaceControl.Transaction t) {
            if ((this.mPendingChanges & 2) == 0) goto L6;
            setDisplaySizeLocked(t, this.mWidth, this.mHeight);
            this.mPendingChanges &= -3;
            return;
        }

        @Override // com.android.server.display.DisplayDevice
        public boolean shouldOnlyMirror() {
            if (this.mProjection == null) goto L5;
        L8:
            return true;
        L5:
            if ((this.mFlags & 16) != 0) goto L8;
            return false;
        }

        public void setSurfaceLocked(Surface surface) {
            if (this.mStopped == false) goto L5;
            return;
        L5:
            if (this.mSurface == surface) goto L26;
            String r0 = this.mName;
            String r1 = this.mOwnerPackageName;
            boolean r3 = false;
            if (this.mSurface != null) goto L9;
            boolean r2 = true;
        L10:
            if (surface != null) goto L12;
            boolean r5 = true;
        L13:
            ObricAutoActionDisplayStateReporter.reportSurfaceChanged(r0, r1, r2, r5, this.mDisplayState);
            if (this.mDisplayState == 2) goto L16;
        L23:
            this.this$0.sendTraversalRequestLocked();
            this.mSurface = surface;
            this.mPendingChanges |= 1;
            return;
        L16:
            if (this.mSurface != null) goto L18;
            boolean r4 = true;
        L19:
            if (surface != null) goto L21;
            r3 = true;
        L21:
            if (r4 == r3) goto L23;
            this.mInfo = null;
            this.this$0.sendDisplayDeviceEventLocked(this, 2);
            goto L23
        L18:
            r4 = false;
            goto L19
        L12:
            r5 = false;
            goto L13
        L9:
            r2 = false;
            goto L10
        }

        public void resizeLocked(int width, int height, int densityDpi) {
            if (this.mWidth == width) goto L5;
        L8:
            this.this$0.sendDisplayDeviceEventLocked(this, 2);
            this.this$0.sendTraversalRequestLocked();
            this.mWidth = width;
            this.mHeight = height;
            this.mMode = DisplayAdapter.createMode(width, height, getRefreshRate());
            this.mDensityDpi = densityDpi;
            this.mInfo = null;
            this.mPendingChanges |= 2;
            return;
        L5:
            if (this.mHeight != height) goto L8;
            if (this.mDensityDpi != densityDpi) goto L8;
        }

        public void stopLocked() {
            Slog.d(VirtualDisplayAdapter.TAG, "Virtual Display: stopping device " + this.mName);
            setSurfaceLocked(null);
            this.mStopped = true;
        }

        @Override // com.android.server.display.DisplayDevice
        public void dumpLocked(PrintWriter pw) {
            super.dumpLocked(pw);
            pw.println("mFlags=" + this.mFlags);
            pw.println("mDisplayState=" + Display.stateToString(this.mDisplayState));
            pw.println("mStopped=" + this.mStopped);
            pw.println("mDisplayIdToMirror=" + this.mDisplayIdToMirror);
            pw.println("mWindowManagerMirroring=" + this.mIsWindowManagerMirroring);
            pw.println("mRequestedRefreshRate=" + this.mRequestedRefreshRate);
        }

        @Override // com.android.server.display.DisplayDevice
        public DisplayDeviceInfo getDisplayDeviceInfoLocked() {
            if (this.mInfo != null) goto L69;
            this.mInfo = new DisplayDeviceInfo();
            this.mInfo.name = this.mName;
            this.mInfo.uniqueId = getUniqueId();
            this.mInfo.width = this.mWidth;
            this.mInfo.height = this.mHeight;
            this.mInfo.modeId = this.mMode.getModeId();
            this.mInfo.renderFrameRate = this.mMode.getRefreshRate();
            this.mInfo.defaultModeId = this.mMode.getModeId();
            this.mInfo.supportedModes = new Display.Mode[]{this.mMode};
            this.mInfo.densityDpi = this.mDensityDpi;
            this.mInfo.xDpi = this.mDensityDpi;
            this.mInfo.yDpi = this.mDensityDpi;
            this.mInfo.presentationDeadlineNanos = 1000000000 / ((long) ((int) getRefreshRate()));
            this.mInfo.flags = 0;
            if ((this.mFlags & 1) != 0) goto L8;
            this.mInfo.flags |= 16;
        L8:
            if ((this.mFlags & 16) != 0) goto L11;
            this.mInfo.flags |= 128;
        L11:
            if (this.mNeverBlank == false) goto L14;
            this.mInfo.flags |= 32;
        L14:
            if ((this.mFlags & 2048) == 0) goto L17;
            this.mInfo.flags |= 16384;
        L17:
            if ((this.mFlags & 32768) == 0) goto L20;
            this.mInfo.flags |= 262144;
        L20:
            if ((this.mFlags & 4) == 0) goto L22;
            this.mInfo.flags |= 4;
        L22:
            int r3 = 3;
            if ((this.mFlags & 2) == 0) goto L30;
            this.mInfo.flags |= 64;
            if ((this.mFlags & 1) == 0) goto L30;
            if ("portrait".equals(SystemProperties.get("persist.demo.remoterotation")) == false) goto L30;
            this.mInfo.rotation = 3;
        L30:
            if ((this.mFlags & 32) == 0) goto L33;
            this.mInfo.flags |= 512;
        L33:
            if ((this.mFlags & 128) == 0) goto L36;
            this.mInfo.flags |= 2;
        L36:
            if ((this.mFlags & 256) == 0) goto L39;
            this.mInfo.flags |= 1024;
        L39:
            if ((this.mFlags & 512) == 0) goto L42;
            this.mInfo.flags |= 4096;
        L42:
            if ((this.mFlags & 1024) == 0) goto L45;
            this.mInfo.flags |= 8192;
        L45:
            if ((this.mFlags & 4096) == 0) goto L48;
            DisplayDeviceInfo r0 = this.mInfo;
            r0.flags = 32768 | r0.flags;
        L48:
            if ((this.mFlags & 8192) == 0) goto L51;
            this.mInfo.flags |= 65536;
        L51:
            if ((this.mFlags & 16384) == 0) goto L54;
            this.mInfo.flags |= 131072;
        L54:
            if ((this.mFlags & 65536) == 0) goto L57;
            this.mInfo.flags |= 524288;
        L57:
            if ((this.mFlags & 536870912) == 0) goto L59;
            DisplayDeviceInfo r1 = this.mInfo;
            r1.flags = 536870912 | r1.flags;
        L59:
            this.mInfo.type = 5;
            DisplayDeviceInfo r2 = this.mInfo;
            if ((this.mFlags & 64) != 0) goto L63;
            r3 = 0;
        L63:
            r2.touch = r3;
            if (this.mSurface != null) goto L66;
            this.mInfo.state = 1;
        L67:
            this.mInfo.brightnessMinimum = 0.0f;
            this.mInfo.brightnessMaximum = 1.0f;
            this.mInfo.brightnessDefault = this.mDefaultBrightness;
            this.mInfo.brightnessDim = this.mDimBrightness;
            this.mInfo.ownerUid = this.mOwnerUid;
            this.mInfo.ownerPackageName = this.mOwnerPackageName;
            this.mInfo.displayShape = DisplayShape.createDefaultDisplayShape(this.mInfo.width, this.mInfo.height, false);
            this.mInfo.displayCutout = this.mDisplayCutout;
            goto L69
        L66:
            this.mInfo.state = this.mDisplayState;
        L69:
            return this.mInfo;
        }

        private float getRefreshRate() {
            if (this.mRequestedRefreshRate != 0.0f) goto L7;
            return 60.0f;
        L7:
            return this.mRequestedRefreshRate;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSurfaceControlDisplayFactory, reason: not valid java name */
    static /* bridge */ /* synthetic */ SurfaceControlDisplayFactory m3896$$Nest$fgetmSurfaceControlDisplayFactory(VirtualDisplayAdapter r0) {
        return r0.mSurfaceControlDisplayFactory;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleMediaProjectionStoppedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3897$$Nest$mhandleMediaProjectionStoppedLocked(VirtualDisplayAdapter r0, IBinder r1) {
        r0.handleMediaProjectionStoppedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveVirtualDisplayDeviceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ VirtualDisplayDevice m3898$$Nest$mremoveVirtualDisplayDeviceLocked(VirtualDisplayAdapter r0, IBinder r1) {
        return r0.removeVirtualDisplayDeviceLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smisNeverBlank, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3899$$Nest$smisNeverBlank(int r0) {
        return isNeverBlank(r0);
    }

    @Override // com.android.server.display.DisplayAdapter
    public /* bridge */ /* synthetic */ void dumpLocked(PrintWriter r1) {
        super.dumpLocked(r1);
    }

    @Override // com.android.server.display.DisplayAdapter
    public /* bridge */ /* synthetic */ void registerLocked() {
        super.registerLocked();
    }

    static {
        sNextUniqueIndex = new AtomicInteger(0);
    }

    public VirtualDisplayAdapter(DisplayManagerService.SyncRoot syncRoot, Context context, Handler handler, DisplayAdapter.Listener listener, DisplayManagerFlags featureFlags) {
        this(syncRoot, context, handler, listener, new AnonymousClass1(), featureFlags);
    }

    VirtualDisplayAdapter(DisplayManagerService.SyncRoot syncRoot, Context context, Handler handler, DisplayAdapter.Listener listener, SurfaceControlDisplayFactory surfaceControlDisplayFactory, DisplayManagerFlags featureFlags) {
        super(syncRoot, context, handler, listener, TAG, featureFlags);
        this.mVirtualDisplayDevices = new ArrayMap();
        this.mOwnerUids = new ArrayMap();
        this.mNoOfDevicesPerPackage = new SparseIntArray();
        this.mHandler = handler;
        this.mSurfaceControlDisplayFactory = surfaceControlDisplayFactory;
        this.mMaxDevices = context.getResources().getInteger(R.integer.db_journal_size_limit);
        if (this.mMaxDevices < 1) goto L10;
        this.mMaxDevicesPerPackage = context.getResources().getInteger(R.integer.db_wal_autocheckpoint);
        if (this.mMaxDevicesPerPackage < 1) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("The limit of virtual displays per package must be >= 1");
    L10:
        throw new IllegalArgumentException("The limit of virtual displays must be >= 1");
    }

    public DisplayDevice createVirtualDisplayLocked(IVirtualDisplayCallback callback, IMediaProjection projection, int ownerUid, String ownerPackageName, String uniqueId, Surface surface, int flags, VirtualDisplayConfig virtualDisplayConfig) {
        IBinder appToken = callback.asBinder();
        if (this.mVirtualDisplayDevices.containsKey(appToken) == false) goto L7;
        Slog.wtfStack(TAG, "Can't create virtual display, display with same appToken already exists");
        return null;
    L7:
        if (getFeatureFlags().isVirtualDisplayLimitEnabled() == true) goto L9;
    L12:
        int noOfDevices = this.mNoOfDevicesPerPackage.get(ownerUid, 0);
        if (getFeatureFlags().isVirtualDisplayLimitEnabled() == true) goto L15;
    L18:
        String name = virtualDisplayConfig.getName();
        if ((flags & 4) == 0) goto L21;
        boolean secure = true;
    L22:
        boolean neverBlank = isNeverBlank(flags);
        IBinder displayToken = this.mSurfaceControlDisplayFactory.createDisplay(name, secure, neverBlank | ObricActivityManager.isAutoAction(ownerPackageName), uniqueId, virtualDisplayConfig.getRequestedRefreshRate());
        if (projection == null) goto L25;
        IMediaProjectionCallback r10 = new MediaProjectionCallback(this, appToken);
    L26:
        Callback callbackDelegate = new Callback(callback, virtualDisplayConfig.getBrightnessListener(), this.mHandler);
        VirtualDisplayDevice device = new VirtualDisplayDevice(this, displayToken, appToken, ownerUid, ownerPackageName, surface, flags, callbackDelegate, projection, r10, uniqueId, virtualDisplayConfig);
        this.mVirtualDisplayDevices.put(appToken, device);
        if (getFeatureFlags().isVirtualDisplayLimitEnabled() == false) goto L29;
        this.mNoOfDevicesPerPackage.put(ownerUid, noOfDevices + 1);
        this.mOwnerUids.put(appToken, Integer.valueOf(ownerUid));
    L29:
        if (projection != null) goto L37;
    L33:
        appToken.linkToDeath(device, 0);     // Catch: RemoteException -> L31
        return device;
    L31:
        ex = move-exception;
        Slog.e(TAG, "Virtual Display: error while setting up VirtualDisplayDevice", ex);
        removeVirtualDisplayDeviceLocked(appToken);
        device.destroyLocked(false);
        return null;
    L37:
        projection.registerCallback(r10);     // Catch: RemoteException -> L31
        Slog.d(TAG, "Virtual Display: registered media projection callback for new VirtualDisplayDevice");     // Catch: RemoteException -> L31
        goto L33
    L25:
        r10 = null;
        goto L26
    L21:
        secure = false;
        goto L22
    L15:
        if (noOfDevices < this.mMaxDevicesPerPackage) goto L18;
        Slog.w(TAG, "Rejecting request to create private virtual display because " + this.mMaxDevicesPerPackage + " devices already exist for package " + ownerPackageName + ".");
        return null;
    L9:
        if (this.mVirtualDisplayDevices.size() < this.mMaxDevices) goto L12;
        Slog.w(TAG, "Rejecting request to create private virtual display because " + this.mMaxDevices + " devices already exist.");
        return null;
    }

    public void resizeVirtualDisplayLocked(IBinder appToken, int width, int height, int densityDpi) {
        VirtualDisplayDevice device = this.mVirtualDisplayDevices.get(appToken);
        if (device == null) goto L6;
        Slog.v(TAG, "Resize VirtualDisplay " + device.mName + " to " + width + " " + height);
        device.resizeLocked(width, height, densityDpi);
        return;
    }

    Surface getVirtualDisplaySurfaceLocked(IBinder appToken) {
        VirtualDisplayDevice device = this.mVirtualDisplayDevices.get(appToken);
        if (device != null) goto L5;
        return null;
    L5:
        return device.getSurfaceLocked();
    }

    public void setVirtualDisplaySurfaceLocked(IBinder appToken, Surface surface) {
        VirtualDisplayDevice device = this.mVirtualDisplayDevices.get(appToken);
        if (device == null) goto L6;
        Slog.v(TAG, "Update surface for VirtualDisplay " + device.mName);
        device.setSurfaceLocked(surface);
        return;
    }

    void setDisplayIdToMirror(IBinder appToken, int displayId) {
        VirtualDisplayDevice device = this.mVirtualDisplayDevices.get(appToken);
        if (device == null) goto L6;
        device.setDisplayIdToMirror(displayId);
        return;
    }

    public DisplayDevice releaseVirtualDisplayLocked(IBinder appToken) {
        VirtualDisplayDevice device = removeVirtualDisplayDeviceLocked(appToken);
        if (device == null) goto L5;
        Slog.v(TAG, "Release VirtualDisplay " + device.mName);
        device.destroyLocked(true);
        appToken.unlinkToDeath(device, 0);
    L5:
        return device;
    }

    DisplayDevice getDisplayDevice(IBinder appToken) {
        return this.mVirtualDisplayDevices.get(appToken);
    }

    static String generateDisplayUniqueId(String packageName, int uid, VirtualDisplayConfig config) {
        StringBuilder r0 = new StringBuilder();
        r0.append(UNIQUE_ID_PREFIX);
        r0.append(packageName);
        if (config.getUniqueId() == null) goto L5;
        String r1 = ":" + config.getUniqueId();
    L6:
        r0.append(r1);
        return r0.toString();
    L5:
        r1 = "," + uid + "," + config.getName() + "," + sNextUniqueIndex.getAndIncrement();
        goto L6
    }

    private void handleMediaProjectionStoppedLocked(IBinder appToken) {
        VirtualDisplayDevice device = this.mVirtualDisplayDevices.get(appToken);
        if (device == null) goto L6;
        Slog.i(TAG, "Virtual display device released because media projection stopped: " + device.mName);
        device.stopLocked();
        return;
    }

    private VirtualDisplayDevice removeVirtualDisplayDeviceLocked(IBinder appToken) {
        if (getFeatureFlags().isVirtualDisplayLimitEnabled() == false) goto L10;
        Integer ownerUid = this.mOwnerUids.remove(appToken);
        if (ownerUid == null) goto L10;
        int noOfDevices = this.mNoOfDevicesPerPackage.get(ownerUid.intValue(), 0);
        if (noOfDevices > 1) goto L9;
        this.mNoOfDevicesPerPackage.delete(ownerUid.intValue());
        goto L10
    L9:
        this.mNoOfDevicesPerPackage.put(ownerUid.intValue(), noOfDevices - 1);
    L10:
        IAppRecordManagerService appRecordManagerService = SysOptBridge.getFactory().getAppRecordManagerService();
        if (appRecordManagerService == null) goto L16;
        VirtualDisplayDevice displayDevice = this.mVirtualDisplayDevices.get(appToken);
        if (displayDevice == null) goto L16;
        appRecordManagerService.onVirtualDisplayChanged(displayDevice.mOwnerPackageName, VirtualDisplayDevice.m3900$$Nest$fgetmOwnerUid(displayDevice), displayDevice.mName, displayDevice.getDisplayTokenLocked(), 0);
    L16:
        return this.mVirtualDisplayDevices.remove(appToken);
    }

    private static boolean isNeverBlank(int flags) {
        if ((flags & 16) == 0) goto L5;
    L7:
        return false;
    L5:
        if ((flags & 1) != 0) goto L7;
        return true;
    }
}
