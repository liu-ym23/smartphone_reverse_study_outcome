package com.android.server.autofill.ui;

import android.content.IntentSender;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.service.autofill.IInlineSuggestionUi;
import android.service.autofill.IInlineSuggestionUiCallback;
import android.service.autofill.ISurfacePackageResultCallback;
import android.util.Slog;
import android.view.SurfaceControlViewHost;
import com.android.internal.view.inline.IInlineContentCallback;
import com.android.server.autofill.Helper;

/* JADX INFO: loaded from: classes.dex */
final class RemoteInlineSuggestionUi {
    private static final long RELEASE_REMOTE_VIEW_HOST_DELAY_MS = 200;
    private static final String TAG = null;
    private int mActualHeight;
    private int mActualWidth;
    private Runnable mDelayedReleaseViewRunnable;
    private final Handler mHandler;
    private final int mHeight;
    private IInlineContentCallback mInlineContentCallback;
    private IInlineSuggestionUi mInlineSuggestionUi;
    private final InlineSuggestionUiCallbackImpl mInlineSuggestionUiCallback;
    private int mRefCount;
    private final RemoteInlineSuggestionViewConnector mRemoteInlineSuggestionViewConnector;
    private boolean mWaitingForUiCreation;
    private final int mWidth;

    /* JADX INFO: renamed from: com.android.server.autofill.ui.RemoteInlineSuggestionUi$1, reason: invalid class name */
    class AnonymousClass1 extends ISurfacePackageResultCallback.Stub {
        final /* synthetic */ RemoteInlineSuggestionUi this$0;

        public static /* synthetic */ void $r8$lambda$M_qFROwAETQuiidXOETzwtei_Ic(AnonymousClass1 r0, SurfaceControlViewHost.SurfacePackage r1) {
            r0.lambda$onResult$0(r1);
        }

        AnonymousClass1(RemoteInlineSuggestionUi this$0) {
            this.this$0 = this$0;
        }

        public void onResult(final SurfaceControlViewHost.SurfacePackage result) {
            RemoteInlineSuggestionUi.m2451$$Nest$fgetmHandler(this.this$0).post(new RemoteInlineSuggestionUi$1$$ExternalSyntheticLambda0(this, result));
        }

        private /* synthetic */ void lambda$onResult$0(SurfaceControlViewHost.SurfacePackage result) {
            if (Helper.sVerbose == false) goto L10;
            Slog.v(RemoteInlineSuggestionUi.m2460$$Nest$sfgetTAG(), "Sending refreshed SurfacePackage to IME");
        L10:
            RemoteInlineSuggestionUi.m2452$$Nest$fgetmInlineContentCallback(this.this$0).onContent(result, RemoteInlineSuggestionUi.m2450$$Nest$fgetmActualWidth(this.this$0), RemoteInlineSuggestionUi.m2449$$Nest$fgetmActualHeight(this.this$0));     // Catch: RemoteException -> L7
            RemoteInlineSuggestionUi.m2459$$Nest$mhandleUpdateRefCount(this.this$0, 1);     // Catch: RemoteException -> L7
            return;
        L8:
            Slog.w(RemoteInlineSuggestionUi.m2460$$Nest$sfgetTAG(), "RemoteException calling onContent");
        }
    }

    private class InlineSuggestionUiCallbackImpl extends IInlineSuggestionUiCallback.Stub {
        final /* synthetic */ RemoteInlineSuggestionUi this$0;

        public static /* synthetic */ void $r8$lambda$0OUk1YJjJ8KSNLrAT85B6L2vJCk(InlineSuggestionUiCallbackImpl r0, IntentSender r1) {
            r0.lambda$onStartIntentSender$2(r1);
        }

        public static /* synthetic */ void $r8$lambda$7cRpfo_BEENaOTbUXRfALOSUW6w(InlineSuggestionUiCallbackImpl r0, IInlineSuggestionUi r1, SurfaceControlViewHost.SurfacePackage r2, int r3, int r4) {
            r0.lambda$onContent$0(r1, r2, r3, r4);
        }

        public static /* synthetic */ void $r8$lambda$Jy4gyyzRZKfGprEu07xQv2YVA1Q(RemoteInlineSuggestionUi r0) {
            RemoteInlineSuggestionUi.m2454$$Nest$mhandleOnClick(r0);
        }

        public static /* synthetic */ void $r8$lambda$QDAjX_3__FBA3EZFJjrHMyODhGE(RemoteInlineSuggestionUi r0) {
            RemoteInlineSuggestionUi.m2455$$Nest$mhandleOnError(r0);
        }

        public static /* synthetic */ void $r8$lambda$VI3hoIqKkTCp9rLdE_VoEXJEg8U(RemoteInlineSuggestionUi r0) {
            RemoteInlineSuggestionUi.m2456$$Nest$mhandleOnLongClick(r0);
        }

        public static /* synthetic */ void $r8$lambda$Wi_h0hrR8fYcBD7pLd4ogex1WGY(InlineSuggestionUiCallbackImpl r0, IBinder r1, int r2) {
            r0.lambda$onTransferTouchFocusToImeWindow$1(r1, r2);
        }

        /* synthetic */ InlineSuggestionUiCallbackImpl(RemoteInlineSuggestionUi r1, RemoteInlineSuggestionUiIA r2) {
            this(r1);
        }

        private InlineSuggestionUiCallbackImpl(RemoteInlineSuggestionUi r1) {
            this.this$0 = r1;
        }

        public void onClick() {
            Handler r0 = RemoteInlineSuggestionUi.m2451$$Nest$fgetmHandler(this.this$0);
            final RemoteInlineSuggestionUi r1 = this.this$0;
            r0.post(new RemoteInlineSuggestionUi$InlineSuggestionUiCallbackImpl$$ExternalSyntheticLambda0(r1));
        }

        public void onLongClick() {
            Handler r0 = RemoteInlineSuggestionUi.m2451$$Nest$fgetmHandler(this.this$0);
            final RemoteInlineSuggestionUi r1 = this.this$0;
            r0.post(new RemoteInlineSuggestionUi$InlineSuggestionUiCallbackImpl$$ExternalSyntheticLambda1(r1));
        }

        private /* synthetic */ void lambda$onContent$0(IInlineSuggestionUi content, SurfaceControlViewHost.SurfacePackage surface, int width, int height) {
            RemoteInlineSuggestionUi.m2453$$Nest$mhandleInlineSuggestionUiReady(this.this$0, content, surface, width, height);
        }

        public void onContent(final IInlineSuggestionUi content, final SurfaceControlViewHost.SurfacePackage surface, final int width, final int height) {
            RemoteInlineSuggestionUi.m2451$$Nest$fgetmHandler(this.this$0).post(new RemoteInlineSuggestionUi$InlineSuggestionUiCallbackImpl$$ExternalSyntheticLambda3(this, content, surface, width, height));
        }

        public void onError() {
            Handler r0 = RemoteInlineSuggestionUi.m2451$$Nest$fgetmHandler(this.this$0);
            final RemoteInlineSuggestionUi r1 = this.this$0;
            r0.post(new RemoteInlineSuggestionUi$InlineSuggestionUiCallbackImpl$$ExternalSyntheticLambda4(r1));
        }

        private /* synthetic */ void lambda$onTransferTouchFocusToImeWindow$1(IBinder sourceInputToken, int displayId) {
            RemoteInlineSuggestionUi.m2458$$Nest$mhandleOnTransferTouchFocusToImeWindow(this.this$0, sourceInputToken, displayId);
        }

        public void onTransferTouchFocusToImeWindow(final IBinder sourceInputToken, final int displayId) {
            RemoteInlineSuggestionUi.m2451$$Nest$fgetmHandler(this.this$0).post(new RemoteInlineSuggestionUi$InlineSuggestionUiCallbackImpl$$ExternalSyntheticLambda2(this, sourceInputToken, displayId));
        }

        private /* synthetic */ void lambda$onStartIntentSender$2(IntentSender intentSender) {
            RemoteInlineSuggestionUi.m2457$$Nest$mhandleOnStartIntentSender(this.this$0, intentSender);
        }

        public void onStartIntentSender(final IntentSender intentSender) {
            RemoteInlineSuggestionUi.m2451$$Nest$fgetmHandler(this.this$0).post(new RemoteInlineSuggestionUi$InlineSuggestionUiCallbackImpl$$ExternalSyntheticLambda5(this, intentSender));
        }
    }

    public static /* synthetic */ void $r8$lambda$7wNLwkmC4faE9g67pj5rhF83bLY(RemoteInlineSuggestionUi r0, IInlineContentCallback r1) {
        r0.lambda$setInlineContentCallback$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$FKnve5fRUnnbzm1M-AdNJMw9cG8, reason: not valid java name */
    public static /* synthetic */ void m2446$r8$lambda$FKnve5fRUnnbzm1MAdNJMw9cG8(RemoteInlineSuggestionUi r0) {
        r0.handleRequestSurfacePackage();
    }

    /* JADX INFO: renamed from: $r8$lambda$R-RQwNfu1AEgUBRJ0684G-xUKww, reason: not valid java name */
    public static /* synthetic */ void m2447$r8$lambda$RRQwNfu1AEgUBRJ0684GxUKww(RemoteInlineSuggestionUi r0) {
        r0.lambda$surfacePackageReleased$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$yJBWET-m-IE1CP11LdJihZ5eYqk, reason: not valid java name */
    public static /* synthetic */ void m2448$r8$lambda$yJBWETmIE1CP11LdJihZ5eYqk(RemoteInlineSuggestionUi r0) {
        r0.lambda$handleUpdateRefCount$2();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActualHeight, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2449$$Nest$fgetmActualHeight(RemoteInlineSuggestionUi r0) {
        return r0.mActualHeight;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActualWidth, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2450$$Nest$fgetmActualWidth(RemoteInlineSuggestionUi r0) {
        return r0.mActualWidth;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2451$$Nest$fgetmHandler(RemoteInlineSuggestionUi r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInlineContentCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ IInlineContentCallback m2452$$Nest$fgetmInlineContentCallback(RemoteInlineSuggestionUi r0) {
        return r0.mInlineContentCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleInlineSuggestionUiReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2453$$Nest$mhandleInlineSuggestionUiReady(RemoteInlineSuggestionUi r0, IInlineSuggestionUi r1, SurfaceControlViewHost.SurfacePackage r2, int r3, int r4) {
        r0.handleInlineSuggestionUiReady(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnClick, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2454$$Nest$mhandleOnClick(RemoteInlineSuggestionUi r0) {
        r0.handleOnClick();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnError, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2455$$Nest$mhandleOnError(RemoteInlineSuggestionUi r0) {
        r0.handleOnError();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnLongClick, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2456$$Nest$mhandleOnLongClick(RemoteInlineSuggestionUi r0) {
        r0.handleOnLongClick();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnStartIntentSender, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2457$$Nest$mhandleOnStartIntentSender(RemoteInlineSuggestionUi r0, IntentSender r1) {
        r0.handleOnStartIntentSender(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleOnTransferTouchFocusToImeWindow, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2458$$Nest$mhandleOnTransferTouchFocusToImeWindow(RemoteInlineSuggestionUi r0, IBinder r1, int r2) {
        r0.handleOnTransferTouchFocusToImeWindow(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUpdateRefCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2459$$Nest$mhandleUpdateRefCount(RemoteInlineSuggestionUi r0, int r1) {
        r0.handleUpdateRefCount(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2460$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = RemoteInlineSuggestionUi.class.getSimpleName();
    }

    RemoteInlineSuggestionUi(RemoteInlineSuggestionViewConnector remoteInlineSuggestionViewConnector, int width, int height, Handler handler) {
        this.mRefCount = 0;
        this.mWaitingForUiCreation = false;
        this.mHandler = handler;
        this.mRemoteInlineSuggestionViewConnector = remoteInlineSuggestionViewConnector;
        this.mWidth = width;
        this.mHeight = height;
        this.mInlineSuggestionUiCallback = new InlineSuggestionUiCallbackImpl(this, null);
    }

    void setInlineContentCallback(final IInlineContentCallback inlineContentCallback) {
        this.mHandler.post(new RemoteInlineSuggestionUi$$ExternalSyntheticLambda1(this, inlineContentCallback));
    }

    private /* synthetic */ void lambda$setInlineContentCallback$0(IInlineContentCallback inlineContentCallback) {
        this.mInlineContentCallback = inlineContentCallback;
    }

    void requestSurfacePackage() {
        this.mHandler.post(new RemoteInlineSuggestionUi$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$surfacePackageReleased$1() {
        handleUpdateRefCount(-1);
    }

    void surfacePackageReleased() {
        this.mHandler.post(new RemoteInlineSuggestionUi$$ExternalSyntheticLambda3(this));
    }

    boolean match(int width, int height) {
        if (this.mWidth == width) goto L5;
    L7:
        return false;
    L5:
        if (this.mHeight != height) goto L7;
        return true;
    }

    private void handleRequestSurfacePackage() {
        cancelPendingReleaseViewRequest();
        if (this.mInlineSuggestionUi == null) goto L5;
        this.mInlineSuggestionUi.getSurfacePackage(new AnonymousClass1(this));     // Catch: RemoteException -> L12
        return;
    L13:
        Slog.w(TAG, "RemoteException calling getSurfacePackage.");
        return;
    L5:
        if (this.mWaitingForUiCreation == true) goto L7;
        this.mRemoteInlineSuggestionViewConnector.renderSuggestion(this.mWidth, this.mHeight, this.mInlineSuggestionUiCallback);
        this.mWaitingForUiCreation = true;
        return;
    L7:
        if (Helper.sDebug == false) goto L17;
        Slog.d(TAG, "Inline suggestion ui is not ready");
        return;
    }

    private void handleUpdateRefCount(int delta) {
        cancelPendingReleaseViewRequest();
        this.mRefCount += delta;
        if (this.mRefCount > 0) goto L6;
        this.mDelayedReleaseViewRunnable = new RemoteInlineSuggestionUi$$ExternalSyntheticLambda2(this);
        this.mHandler.postDelayed(this.mDelayedReleaseViewRunnable, RELEASE_REMOTE_VIEW_HOST_DELAY_MS);
        return;
    }

    private /* synthetic */ void lambda$handleUpdateRefCount$2() {
        if (this.mInlineSuggestionUi != null) goto L14;
    L12:
        this.mDelayedReleaseViewRunnable = null;
        return;
    L14:
        if (Helper.sVerbose == false) goto L9;
        Slog.v(TAG, "releasing the host");     // Catch: RemoteException -> L7
    L9:
        this.mInlineSuggestionUi.releaseSurfaceControlViewHost();     // Catch: RemoteException -> L7
        this.mInlineSuggestionUi = null;     // Catch: RemoteException -> L7
    L11:
        Slog.w(TAG, "RemoteException calling releaseSurfaceControlViewHost");
        goto L12
    }

    private void cancelPendingReleaseViewRequest() {
        if (this.mDelayedReleaseViewRunnable == null) goto L6;
        this.mHandler.removeCallbacks(this.mDelayedReleaseViewRunnable);
        this.mDelayedReleaseViewRunnable = null;
        return;
    }

    private void handleInlineSuggestionUiReady(IInlineSuggestionUi content, SurfaceControlViewHost.SurfacePackage surfacePackage, int width, int height) {
        this.mInlineSuggestionUi = content;
        this.mRefCount = 0;
        this.mWaitingForUiCreation = false;
        this.mActualWidth = width;
        this.mActualHeight = height;
        if (this.mInlineContentCallback != null) goto L16;
    L12:
        if (surfacePackage == null) goto L14;
        surfacePackage.release();
    L14:
        this.mRemoteInlineSuggestionViewConnector.onRender();
        return;
    L16:
        if (Helper.sVerbose == false) goto L9;
        Slog.v(TAG, "Sending new UI content to IME");     // Catch: RemoteException -> L7
    L9:
        handleUpdateRefCount(1);     // Catch: RemoteException -> L7
        this.mInlineContentCallback.onContent(surfacePackage, this.mActualWidth, this.mActualHeight);     // Catch: RemoteException -> L7
    L11:
        Slog.w(TAG, "RemoteException calling onContent");
        goto L12
    }

    private void handleOnClick() {
        this.mRemoteInlineSuggestionViewConnector.onClick();
        if (this.mInlineContentCallback == null) goto L11;
        this.mInlineContentCallback.onClick();     // Catch: RemoteException -> L6
        return;
    L7:
        Slog.w(TAG, "RemoteException calling onClick");
        return;
    }

    private void handleOnLongClick() {
        if (this.mInlineContentCallback == null) goto L11;
        this.mInlineContentCallback.onLongClick();     // Catch: RemoteException -> L6
        return;
    L7:
        Slog.w(TAG, "RemoteException calling onLongClick");
        return;
    }

    private void handleOnError() {
        this.mRemoteInlineSuggestionViewConnector.onError();
    }

    private void handleOnTransferTouchFocusToImeWindow(IBinder sourceInputToken, int displayId) {
        this.mRemoteInlineSuggestionViewConnector.onTransferTouchFocusToImeWindow(sourceInputToken, displayId);
    }

    private void handleOnStartIntentSender(IntentSender intentSender) {
        this.mRemoteInlineSuggestionViewConnector.onStartIntentSender(intentSender);
    }
}
