package com.android.server.autofill.ui;

import android.os.Handler;
import android.util.Slog;
import com.android.internal.view.inline.IInlineContentCallback;
import com.android.internal.view.inline.IInlineContentProvider;
import com.android.server.FgThread;
import com.android.server.autofill.Helper;

/* JADX INFO: loaded from: classes.dex */
final class InlineContentProviderImpl extends IInlineContentProvider.Stub {
    private static final String TAG = null;
    private final Handler mHandler;
    private boolean mProvideContentCalled;
    private RemoteInlineSuggestionUi mRemoteInlineSuggestionUi;
    private final RemoteInlineSuggestionViewConnector mRemoteInlineSuggestionViewConnector;

    /* JADX INFO: renamed from: $r8$lambda$6Z-fpAIW5FjBxVFGDrt0DINxKho, reason: not valid java name */
    public static /* synthetic */ void m2443$r8$lambda$6ZfpAIW5FjBxVFGDrt0DINxKho(InlineContentProviderImpl r0, int r1, int r2, IInlineContentCallback r3) {
        r0.lambda$provideContent$0(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$akUQz7EVewQ0DD7ma1KMQAv7q78(InlineContentProviderImpl r0) {
        r0.handleGetSurfacePackage();
    }

    /* JADX INFO: renamed from: $r8$lambda$qYjUTN-E7RJXiJtOQjR_1hjr_KU, reason: not valid java name */
    public static /* synthetic */ void m2444$r8$lambda$qYjUTNE7RJXiJtOQjR_1hjr_KU(InlineContentProviderImpl r0) {
        r0.handleOnSurfacePackageReleased();
    }

    static {
        TAG = InlineContentProviderImpl.class.getSimpleName();
    }

    InlineContentProviderImpl(RemoteInlineSuggestionViewConnector remoteInlineSuggestionViewConnector, RemoteInlineSuggestionUi remoteInlineSuggestionUi) {
        this.mHandler = FgThread.getHandler();
        this.mProvideContentCalled = false;
        this.mRemoteInlineSuggestionViewConnector = remoteInlineSuggestionViewConnector;
        this.mRemoteInlineSuggestionUi = remoteInlineSuggestionUi;
    }

    public InlineContentProviderImpl copy() {
        return new InlineContentProviderImpl(this.mRemoteInlineSuggestionViewConnector, this.mRemoteInlineSuggestionUi);
    }

    private /* synthetic */ void lambda$provideContent$0(int width, int height, IInlineContentCallback callback) {
        handleProvideContent(width, height, callback);
    }

    public void provideContent(final int width, final int height, final IInlineContentCallback callback) {
        this.mHandler.post(new InlineContentProviderImpl$$ExternalSyntheticLambda2(this, width, height, callback));
    }

    public void requestSurfacePackage() {
        this.mHandler.post(new InlineContentProviderImpl$$ExternalSyntheticLambda0(this));
    }

    public void onSurfacePackageReleased() {
        this.mHandler.post(new InlineContentProviderImpl$$ExternalSyntheticLambda1(this));
    }

    private void handleProvideContent(int width, int height, IInlineContentCallback callback) {
        if (Helper.sVerbose == false) goto L6;
        Slog.v(TAG, "handleProvideContent");
    L6:
        if (this.mProvideContentCalled == false) goto L8;
        return;
    L8:
        this.mProvideContentCalled = true;
        if (this.mRemoteInlineSuggestionUi != null) goto L11;
    L12:
        this.mRemoteInlineSuggestionUi = new RemoteInlineSuggestionUi(this.mRemoteInlineSuggestionViewConnector, width, height, this.mHandler);
    L13:
        this.mRemoteInlineSuggestionUi.setInlineContentCallback(callback);
        this.mRemoteInlineSuggestionUi.requestSurfacePackage();
        return;
    L11:
        if (this.mRemoteInlineSuggestionUi.match(width, height) == true) goto L13;
        goto L12
    }

    private void handleGetSurfacePackage() {
        if (Helper.sVerbose == false) goto L6;
        Slog.v(TAG, "handleGetSurfacePackage");
    L6:
        if (this.mProvideContentCalled == true) goto L8;
        return;
    L8:
        if (this.mRemoteInlineSuggestionUi == null) goto L13;
        this.mRemoteInlineSuggestionUi.requestSurfacePackage();
        return;
    }

    private void handleOnSurfacePackageReleased() {
        if (Helper.sVerbose == false) goto L6;
        Slog.v(TAG, "handleOnSurfacePackageReleased");
    L6:
        if (this.mProvideContentCalled == true) goto L8;
        return;
    L8:
        if (this.mRemoteInlineSuggestionUi == null) goto L13;
        this.mRemoteInlineSuggestionUi.surfacePackageReleased();
        return;
    }
}
