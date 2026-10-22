package com.android.server.wm;

import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.projection.IMediaProjectionManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.view.ContentRecordingSession;
import android.view.DisplayInfo;
import android.view.SurfaceControl;
import android.window.DesktopExperienceFlags;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.display.feature.DisplayManagerFlags;

/* JADX INFO: loaded from: classes3.dex */
final class ContentRecorder implements WindowContainerListener {
    private static final float MAX_ANISOTROPY = 0.025f;
    private ContentRecordingSession mContentRecordingSession;
    private final boolean mCorrectForAnisotropicPixels;
    private final DisplayContent mDisplayContent;
    private Point mLastConsumingSurfaceSize;
    private int mLastOrientation;
    private Rect mLastRecordedBounds;
    private int mLastWindowingMode;
    private final MediaProjectionManagerWrapper mMediaProjectionManager;
    private SurfaceControl mRecordedSurface;
    private WindowContainer mRecordedWindowContainer;

    interface MediaProjectionManagerWrapper {
        void notifyActiveProjectionCapturedContentVisibilityChanged(boolean r1);

        void notifyCaptureBoundsChanged(int r1, int r2, Rect r3);

        void notifyWindowingModeChanged(int r1, int r2, int r3);

        void stopActiveProjection(int r1);
    }

    private static final class RemoteMediaProjectionManagerWrapper implements MediaProjectionManagerWrapper {
        private final int mDisplayId;
        private IMediaProjectionManager mIMediaProjectionManager;

        RemoteMediaProjectionManagerWrapper(int displayId) {
            this.mIMediaProjectionManager = null;
            this.mDisplayId = displayId;
        }

        @Override // com.android.server.wm.ContentRecorder.MediaProjectionManagerWrapper
        public void stopActiveProjection(int stopReason) {
            fetchMediaProjectionManager();
            if (this.mIMediaProjectionManager != null) goto L17;
            return;
        L17:
        L9:
            e = move-exception;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[4] == false) goto L19;
            long protoLogParam0 = this.mDisplayId;
            String protoLogParam1 = String.valueOf(e);
            ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 4391984931064789228L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
            return;
        L19:
            return;
        L7:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[4] == false) goto L11;
            long protoLogParam2 = this.mDisplayId;     // Catch: RemoteException -> L9
            ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 3197882223327917085L, 1, new Object[]{Long.valueOf(protoLogParam2)});     // Catch: RemoteException -> L9
        L11:
            this.mIMediaProjectionManager.stopActiveProjection(stopReason);     // Catch: RemoteException -> L9
        }

        @Override // com.android.server.wm.ContentRecorder.MediaProjectionManagerWrapper
        public void notifyActiveProjectionCapturedContentVisibilityChanged(boolean isVisible) {
            fetchMediaProjectionManager();
            if (this.mIMediaProjectionManager != null) goto L12;
            return;
        L12:
            this.mIMediaProjectionManager.notifyActiveProjectionCapturedContentVisibilityChanged(isVisible);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[4] == false) goto L14;
            String protoLogParam0 = String.valueOf(e);
            ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 1600318776990120244L, 0, new Object[]{protoLogParam0});
            return;
        }

        @Override // com.android.server.wm.ContentRecorder.MediaProjectionManagerWrapper
        public void notifyWindowingModeChanged(int contentToRecord, int targetUid, int windowingMode) {
            fetchMediaProjectionManager();
            if (this.mIMediaProjectionManager != null) goto L12;
            return;
        L12:
            this.mIMediaProjectionManager.notifyWindowingModeChanged(contentToRecord, targetUid, windowingMode);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[4] == false) goto L14;
            String protoLogParam0 = String.valueOf(e);
            ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -1451477179301743956L, 0, new Object[]{protoLogParam0});
            return;
        }

        @Override // com.android.server.wm.ContentRecorder.MediaProjectionManagerWrapper
        public void notifyCaptureBoundsChanged(int contentToRecord, int targetUid, Rect captureBounds) {
            fetchMediaProjectionManager();
            if (this.mIMediaProjectionManager != null) goto L12;
            return;
        L12:
            this.mIMediaProjectionManager.notifyCaptureBoundsChanged(contentToRecord, targetUid, captureBounds);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[4] == false) goto L14;
            String protoLogParam0 = String.valueOf(e);
            ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 4171721219468376150L, 0, new Object[]{protoLogParam0});
            return;
        }

        private void fetchMediaProjectionManager() {
            if (this.mIMediaProjectionManager == null) goto L5;
            return;
        L5:
            IBinder b = ServiceManager.getService("media_projection");
            if (b != null) goto L8;
            return;
        L8:
            this.mIMediaProjectionManager = IMediaProjectionManager.Stub.asInterface(b);
        }
    }

    ContentRecorder(DisplayContent displayContent) {
        RemoteMediaProjectionManagerWrapper r0 = new RemoteMediaProjectionManagerWrapper(displayContent.mDisplayId);
        if (new DisplayManagerFlags().isPixelAnisotropyCorrectionInLogicalDisplayEnabled() == false) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this(displayContent, r0, r1);
        return;
    L5:
        if (displayContent.getDisplayInfo().type != 2) goto L7;
        r1 = true;
        goto L8
    }

    ContentRecorder(DisplayContent displayContent, MediaProjectionManagerWrapper mediaProjectionManager, boolean correctForAnisotropicPixels) {
        this.mContentRecordingSession = null;
        this.mRecordedWindowContainer = null;
        this.mRecordedSurface = null;
        this.mLastRecordedBounds = null;
        this.mLastConsumingSurfaceSize = new Point(0, 0);
        this.mLastOrientation = 0;
        this.mLastWindowingMode = 0;
        this.mDisplayContent = displayContent;
        this.mMediaProjectionManager = mediaProjectionManager;
        this.mCorrectForAnisotropicPixels = correctForAnisotropicPixels;
    }

    void setContentRecordingSession(ContentRecordingSession session) {
        this.mContentRecordingSession = session;
    }

    boolean isContentRecordingSessionSet() {
        if (this.mContentRecordingSession == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isCurrentlyRecording() {
        if (this.mContentRecordingSession != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mRecordedSurface == null) goto L7;
        return true;
    }

    void updateRecording() {
        if (isCurrentlyRecording() == true) goto L5;
    L9:
        startRecordingIfNeeded();
        return;
    L5:
        if (this.mDisplayContent.getLastHasContent() == false) goto L7;
    L8:
        pauseRecording();
        return;
    L7:
        if (this.mDisplayContent.getDisplayInfo().state != 1) goto L9;
        goto L8
    }

    void onMirrorOutputSurfaceOrientationChanged() {
        onConfigurationChanged(this.mLastOrientation, this.mLastWindowingMode);
    }

    void onConfigurationChanged(int lastOrientation, int lastWindowingMode) {
        if (isCurrentlyRecording() == false) goto L48;
        if (this.mLastRecordedBounds != null) goto L8;
        return;
    L8:
        if (this.mRecordedWindowContainer != null) goto L14;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L49;
        long protoLogParam0 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -6620483833570774987L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        return;
    L49:
        return;
    L14:
        if (this.mContentRecordingSession.getContentToRecord() != 1) goto L22;
        Task capturedTask = this.mRecordedWindowContainer.asTask();
        if (capturedTask.inPinnedWindowingMode() == false) goto L22;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L20;
        long protoLogParam1 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 7226080178642957768L, 1, new Object[]{Long.valueOf(protoLogParam1)});
    L20:
        pauseRecording();
        return;
    L22:
        int recordedContentWindowingMode = this.mRecordedWindowContainer.getWindowingMode();
        if (lastWindowingMode == recordedContentWindowingMode) goto L26;
        this.mMediaProjectionManager.notifyWindowingModeChanged(this.mContentRecordingSession.getContentToRecord(), this.mContentRecordingSession.getTargetUid(), recordedContentWindowingMode);
    L26:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L28;
        long protoLogParam2 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -311001578548807570L, 1, new Object[]{Long.valueOf(protoLogParam2)});
    L28:
        Rect recordedContentBounds = this.mRecordedWindowContainer.getBounds();
        int recordedContentOrientation = this.mRecordedWindowContainer.getConfiguration().orientation;
        Point surfaceSize = fetchSurfaceSizeIfPresent();
        if (this.mLastRecordedBounds.equals(recordedContentBounds) == false) goto L37;
        if (lastOrientation != recordedContentOrientation) goto L37;
        if (this.mLastConsumingSurfaceSize.equals(surfaceSize) == false) goto L37;
        return;
    L37:
        if (surfaceSize == null) goto L44;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L42;
        long protoLogParam3 = this.mDisplayContent.getDisplayId();
        String protoLogParam4 = String.valueOf(recordedContentBounds);
        long protoLogParam5 = recordedContentOrientation;
        String protoLogParam6 = String.valueOf(surfaceSize);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 2350883351096538149L, 17, new Object[]{Long.valueOf(protoLogParam3), protoLogParam4, Long.valueOf(protoLogParam5), protoLogParam6});
    L42:
        updateMirroredSurface(this.mRecordedWindowContainer.getSyncTransaction(), recordedContentBounds, surfaceSize);
        return;
    L44:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L52;
        long protoLogParam7 = this.mDisplayContent.getDisplayId();
        String protoLogParam8 = String.valueOf(recordedContentBounds);
        long protoLogParam9 = recordedContentOrientation;
        String protoLogParam10 = String.valueOf(surfaceSize);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 8446758574558556540L, 17, new Object[]{Long.valueOf(protoLogParam7), protoLogParam8, Long.valueOf(protoLogParam9), protoLogParam10});
        return;
    L52:
        return;
    }

    void resetRecordingDisplay(int displayId) {
        if (isCurrentlyRecording() == true) goto L5;
        return;
    L5:
        if (this.mContentRecordingSession.getDisplayToRecord() == displayId) goto L8;
        return;
    L8:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L10;
        long protoLogParam0 = displayId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -4390594364588411298L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L10:
        this.mDisplayContent.mWmService.mTransactionFactory.get().remove(this.mRecordedSurface).apply();
        this.mRecordedSurface = null;
    }

    void pauseRecording() {
        if (this.mRecordedSurface != null) goto L6;
        return;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L8;
        long protoLogParam0 = this.mDisplayContent.getDisplayId();
        boolean protoLogParam1 = this.mDisplayContent.getLastHasContent();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -4320004054011530388L, 13, new Object[]{Long.valueOf(protoLogParam0), Boolean.valueOf(protoLogParam1)});
    L8:
        this.mDisplayContent.mWmService.mTransactionFactory.get().remove(this.mRecordedSurface).reparent(this.mDisplayContent.getWindowingLayer(), this.mDisplayContent.getSurfaceControl()).reparent(this.mDisplayContent.getOverlayLayer(), this.mDisplayContent.getSurfaceControl()).apply();
        this.mRecordedSurface = null;
    }

    void stopRecording() {
        unregisterListener();
        if (this.mRecordedSurface == null) goto L6;
        this.mDisplayContent.mWmService.mTransactionFactory.get().remove(this.mRecordedSurface).apply();
        this.mRecordedSurface = null;
        clearContentRecordingSession();
        return;
    }

    private boolean isDisplayReadyForMirroring() {
        if (this.mDisplayContent.getDisplayInfo().type == 2) goto L5;
    L8:
        return true;
    L5:
        if (this.mDisplayContent.mWmService.mDisplayManagerInternal.isDisplayReadyForMirroring(this.mDisplayContent.getDisplayId()) == true) goto L8;
        return false;
    }

    private void stopMediaProjection(int stopReason) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L6;
        long protoLogParam0 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 5951434375221687741L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L6:
        if (this.mMediaProjectionManager == null) goto L9;
        this.mMediaProjectionManager.stopActiveProjection(stopReason);
        return;
    }

    private void clearContentRecordingSession() {
        this.mContentRecordingSession = null;
        this.mDisplayContent.mWmService.mContentRecordingController.setContentRecordingSessionLocked(null, this.mDisplayContent.mWmService);
    }

    private void unregisterListener() {
        if (this.mRecordedWindowContainer == null) goto L5;
        Task recordedTask = this.mRecordedWindowContainer.asTask();
    L6:
        if (recordedTask != null) goto L8;
        return;
    L8:
        if (isRecordingContentTask() == false) goto L13;
        recordedTask.unregisterWindowContainerListener(this);
        this.mRecordedWindowContainer = null;
        return;
    L13:
        return;
    L5:
        recordedTask = null;
        goto L6
    }

    private void startRecordingIfNeeded() {
        if (this.mDisplayContent.getLastHasContent() == false) goto L5;
        return;
    L5:
        if (isCurrentlyRecording() == true) goto L69;
        boolean r1 = true;
        if (this.mDisplayContent.getDisplayInfo().state != 1) goto L9;
        return;
    L9:
        if (this.mContentRecordingSession != null) goto L12;
        return;
    L12:
        if (DesktopExperienceFlags.ENABLE_DISPLAY_CONTENT_MODE_MANAGEMENT.isTrue() == false) goto L17;
        if (this.mDisplayContent.mDisplay.canHostTasks() == false) goto L17;
        return;
    L17:
        if (this.mContentRecordingSession.isWaitingForConsent() == true) goto L61;
        if (isDisplayReadyForMirroring() == false) goto L61;
        this.mRecordedWindowContainer = retrieveRecordedWindowContainer();
        if (this.mRecordedWindowContainer != null) goto L24;
        return;
    L24:
        SurfaceControl sourceSurface = this.mRecordedWindowContainer.getSurfaceControl();
        if (sourceSurface == null) goto L57;
        if (sourceSurface.isValid() == false) goto L57;
        int contentToRecord = this.mContentRecordingSession.getContentToRecord();
        if (contentToRecord == 1) goto L32;
    L37:
        Point surfaceSize = fetchSurfaceSizeIfPresent();
        if (surfaceSize != null) goto L44;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L66;
        long protoLogParam0 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 7051210836345306671L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        return;
    L66:
        return;
    L44:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L46;
        long protoLogParam1 = this.mDisplayContent.getDisplayId();
        long protoLogParam2 = this.mDisplayContent.getDisplayInfo().state;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 2255758299558330282L, 5, new Object[]{Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2)});
    L46:
        this.mRecordedSurface = SurfaceControl.mirrorSurface(sourceSurface);
        SurfaceControl.Transaction transaction = this.mDisplayContent.mWmService.mTransactionFactory.get().reparent(this.mRecordedSurface, this.mDisplayContent.getSurfaceControl()).reparent(this.mDisplayContent.getWindowingLayer(), null).reparent(this.mDisplayContent.getOverlayLayer(), null);
        updateMirroredSurface(transaction, this.mRecordedWindowContainer.getBounds(), surfaceSize);
        transaction.apply();
        if (contentToRecord != 1) goto L49;
        this.mMediaProjectionManager.notifyActiveProjectionCapturedContentVisibilityChanged(this.mRecordedWindowContainer.asTask().isVisibleRequested());
    L54:
        this.mMediaProjectionManager.notifyWindowingModeChanged(contentToRecord, this.mContentRecordingSession.getTargetUid(), this.mRecordedWindowContainer.getWindowConfiguration().getWindowingMode());
        return;
    L49:
        int currentDisplayState = this.mRecordedWindowContainer.asDisplayContent().getDisplayInfo().state;
        MediaProjectionManagerWrapper r7 = this.mMediaProjectionManager;
        if (currentDisplayState != 1) goto L53;
        r1 = false;
    L53:
        r7.notifyActiveProjectionCapturedContentVisibilityChanged(r1);
        goto L54
    L32:
        if (this.mRecordedWindowContainer.asTask().inPinnedWindowingMode() == false) goto L37;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L65;
        long protoLogParam3 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 6779858226066635065L, 1, new Object[]{Long.valueOf(protoLogParam3)});
        return;
    L65:
        return;
    L57:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L67;
        long protoLogParam4 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -7587023235027618399L, 1, new Object[]{Long.valueOf(protoLogParam4)});
        return;
    L67:
        return;
    L61:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L68;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -3395581813971405090L, 0, null);
        return;
    L68:
        return;
    }

    private WindowContainer retrieveRecordedWindowContainer() {
        int contentToRecord = this.mContentRecordingSession.getContentToRecord();
        IBinder tokenToRecord = this.mContentRecordingSession.getTokenToRecord();
        switch(contentToRecord) {
            case 0: goto L26;
            case 1: goto L8;
            default: goto L4;
        };
    L4:
        handleStartRecordingFailed();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L7;
        long protoLogParam0 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -3564317873468917405L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L7:
        return null;
    L8:
        if (tokenToRecord == null) goto L10;
        WindowContainer wc = WindowContainer.fromBinder(tokenToRecord);
    L11:
        if (wc != null) goto L16;
        handleStartRecordingFailed();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L15;
        long protoLogParam1 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 5977585536708129221L, 1, new Object[]{Long.valueOf(protoLogParam1)});
    L15:
        return null;
    L16:
        Task taskToRecord = wc.asTask();
        if (taskToRecord != null) goto L19;
    L22:
        handleStartRecordingFailed();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L25;
        long protoLogParam2 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, -928577038848872043L, 1, new Object[]{Long.valueOf(protoLogParam2)});
    L25:
        return taskToRecord;
    L19:
        if (taskToRecord.isAttached() == false) goto L22;
        taskToRecord.registerWindowContainerListener(this);
        goto L25
    L10:
        wc = null;
        goto L11
    L26:
        WindowContainer wc2 = this.mDisplayContent;
        DisplayContent dc = wc2.mWmService.mRoot.getDisplayContent(this.mContentRecordingSession.getDisplayToRecord());
        if (dc != null) goto L32;
        this.mDisplayContent.mWmService.mDisplayManagerInternal.setWindowManagerMirroring(this.mDisplayContent.getDisplayId(), false);
        handleStartRecordingFailed();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L31;
        long protoLogParam3 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 2269158922723670768L, 1, new Object[]{Long.valueOf(protoLogParam3)});
    L31:
        return null;
    L32:
        return dc;
    }

    private void handleStartRecordingFailed() {
        boolean shouldExitTaskRecording = isRecordingContentTask();
        unregisterListener();
        clearContentRecordingSession();
        if (shouldExitTaskRecording == false) goto L6;
        stopMediaProjection(10);
        return;
    }

    private void computeScaling(int inputSizeX, int inputSizeY, float inputDpiX, float inputDpiY, int outputSizeX, int outputSizeY, float outputDpiX, float outputDpiY, PointF scaleOut) {
        float relAnisotropy = (inputDpiY / inputDpiX) / (outputDpiY / outputDpiX);
        if (this.mCorrectForAnisotropicPixels == true) goto L5;
    L11:
        float scaleX = outputSizeX / inputSizeX;
        float scaleY = outputSizeY / inputSizeY;
        float scale = Math.min(scaleX, scaleY);
        scaleOut.x = scale;
        scaleOut.y = scale;
        return;
    L5:
        if (relAnisotropy > 0.975f) goto L7;
    L9:
        float relDpiX = outputDpiX / inputDpiX;
        float relDpiY = outputDpiY / inputDpiY;
        float scale2 = Math.min((outputSizeX / relDpiX) / inputSizeX, (outputSizeY / relDpiY) / inputSizeY);
        scaleOut.x = scale2 * relDpiX;
        scaleOut.y = scale2 * relDpiY;
        return;
    L7:
        if (relAnisotropy >= 1.025f) goto L9;
        goto L9
    }

    void updateMirroredSurface(SurfaceControl.Transaction transaction, Rect recordedContentBounds, Point surfaceSize) {
        DisplayInfo inputDisplayInfo = this.mRecordedWindowContainer.mDisplayContent.getDisplayInfo();
        DisplayInfo outputDisplayInfo = this.mDisplayContent.getDisplayInfo();
        PointF scale = new PointF();
        computeScaling(recordedContentBounds.width(), recordedContentBounds.height(), inputDisplayInfo.physicalXDpi, inputDisplayInfo.physicalYDpi, surfaceSize.x, surfaceSize.y, outputDisplayInfo.physicalXDpi, outputDisplayInfo.physicalYDpi, scale);
        int scaledWidth = Math.round(scale.x * recordedContentBounds.width());
        int scaledHeight = Math.round(scale.y * recordedContentBounds.height());
        int shiftedX = 0;
        if (scaledWidth == surfaceSize.x) goto L5;
        shiftedX = (surfaceSize.x - scaledWidth) / 2;
    L5:
        int shiftedY = 0;
        if (scaledHeight == surfaceSize.y) goto L9;
        shiftedY = (surfaceSize.y - scaledHeight) / 2;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L12;
        long protoLogParam0 = shiftedX;
        long protoLogParam1 = shiftedY;
        double protoLogParam2 = scale.x;
        double protoLogParam3 = scale.y;
        long protoLogParam4 = recordedContentBounds.width();
        long protoLogParam5 = recordedContentBounds.height();
        long protoLogParam6 = this.mDisplayContent.getDisplayId();
        long protoLogParam7 = this.mDisplayContent.getConfiguration().screenWidthDp;
        long protoLogParam8 = this.mDisplayContent.getConfiguration().screenHeightDp;
        long protoLogParam9 = surfaceSize.x;
        long protoLogParam10 = surfaceSize.y;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 1100676037289065396L, 1398181, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1), Double.valueOf(protoLogParam2), Double.valueOf(protoLogParam3), Long.valueOf(protoLogParam4), Long.valueOf(protoLogParam5), Long.valueOf(protoLogParam6), Long.valueOf(protoLogParam7), Long.valueOf(protoLogParam8), Long.valueOf(protoLogParam9), Long.valueOf(protoLogParam10)});
    L12:
        transaction.setWindowCrop(this.mRecordedSurface, recordedContentBounds.width(), recordedContentBounds.height()).setMatrix(this.mRecordedSurface, scale.x, 0.0f, 0.0f, scale.y).setPosition(this.mRecordedSurface, shiftedX, shiftedY);
        this.mLastRecordedBounds = new Rect(recordedContentBounds);
        this.mLastConsumingSurfaceSize.x = surfaceSize.x;
        this.mLastConsumingSurfaceSize.y = surfaceSize.y;
        this.mMediaProjectionManager.notifyCaptureBoundsChanged(this.mContentRecordingSession.getContentToRecord(), this.mContentRecordingSession.getTargetUid(), this.mLastRecordedBounds);
    }

    private Point fetchSurfaceSizeIfPresent() {
        Point surfaceSize = this.mDisplayContent.mWmService.mDisplayManagerInternal.getDisplaySurfaceDefaultSize(this.mDisplayContent.getDisplayId());
        if (surfaceSize == null) goto L5;
        return surfaceSize;
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L10;
        long protoLogParam0 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 2330946591287751995L, 1, new Object[]{Long.valueOf(protoLogParam0)});
        return null;
    L10:
        return null;
    }

    @Override // com.android.server.wm.WindowContainerListener
    public void onRemoved() {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_CONTENT_RECORDING_enabled[1] == false) goto L5;
        long protoLogParam0 = this.mDisplayContent.getDisplayId();
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, 7993045936648632984L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L5:
        unregisterListener();
        clearContentRecordingSession();
        stopMediaProjection(2);
    }

    @Override // com.android.server.wm.ConfigurationContainerListener
    public void onMergedOverrideConfigurationChanged(Configuration mergedOverrideConfiguration) {
        super.onMergedOverrideConfigurationChanged(mergedOverrideConfiguration);
        onConfigurationChanged(this.mLastOrientation, this.mLastWindowingMode);
        this.mLastOrientation = mergedOverrideConfiguration.orientation;
        this.mLastWindowingMode = mergedOverrideConfiguration.windowConfiguration.getWindowingMode();
    }

    @Override // com.android.server.wm.WindowContainerListener
    public void onVisibleRequestedChanged(boolean isVisibleRequested) {
        if (isCurrentlyRecording() == true) goto L5;
        return;
    L5:
        if (this.mLastRecordedBounds == null) goto L11;
        this.mMediaProjectionManager.notifyActiveProjectionCapturedContentVisibilityChanged(isVisibleRequested);
        if (this.mContentRecordingSession.getContentToRecord() != 1) goto L12;
        this.mRecordedWindowContainer.getSyncTransaction().setVisibility(this.mRecordedSurface, isVisibleRequested);
        this.mRecordedWindowContainer.scheduleAnimation();
        return;
    L12:
        return;
    }

    private boolean isRecordingContentTask() {
        if (this.mContentRecordingSession != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mContentRecordingSession.getContentToRecord() != 1) goto L7;
        return true;
    }
}
