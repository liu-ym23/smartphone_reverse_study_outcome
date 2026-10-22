package com.android.server.autofill.ui;

import android.content.IntentSender;
import android.os.IBinder;
import android.service.autofill.IInlineSuggestionUiCallback;
import android.service.autofill.InlinePresentation;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.autofill.Helper;
import com.android.server.autofill.RemoteInlineSuggestionRenderService;
import com.android.server.inputmethod.InputMethodManagerInternal;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
final class RemoteInlineSuggestionViewConnector {
    private static final String TAG = null;
    private final int mDisplayId;
    private final IBinder mHostInputToken;
    private final InlinePresentation mInlinePresentation;
    private final Runnable mOnAutofillCallback;
    private final Runnable mOnErrorCallback;
    private final Runnable mOnInflateCallback;
    private final RemoteInlineSuggestionRenderService mRemoteRenderService;
    private final int mSessionId;
    private final Consumer<IntentSender> mStartIntentSenderFromClientApp;
    private final int mUserId;

    static {
        TAG = RemoteInlineSuggestionViewConnector.class.getSimpleName();
    }

    RemoteInlineSuggestionViewConnector(InlineFillUi.InlineFillUiInfo inlineFillUiInfo, InlinePresentation inlinePresentation, Runnable onAutofillCallback, final InlineFillUi.InlineSuggestionUiCallback uiCallback) {
        this.mRemoteRenderService = inlineFillUiInfo.mRemoteRenderService;
        this.mInlinePresentation = inlinePresentation;
        this.mHostInputToken = inlineFillUiInfo.mInlineRequest.getHostInputToken();
        this.mDisplayId = inlineFillUiInfo.mInlineRequest.getHostDisplayId();
        this.mUserId = inlineFillUiInfo.mUserId;
        this.mSessionId = inlineFillUiInfo.mSessionId;
        this.mOnAutofillCallback = onAutofillCallback;
        uiCallback.getClass();
        this.mOnErrorCallback = new RemoteInlineSuggestionViewConnector$$ExternalSyntheticLambda0(uiCallback);
        uiCallback.getClass();
        this.mOnInflateCallback = new RemoteInlineSuggestionViewConnector$$ExternalSyntheticLambda1(uiCallback);
        uiCallback.getClass();
        this.mStartIntentSenderFromClientApp = new RemoteInlineSuggestionViewConnector$$ExternalSyntheticLambda2(uiCallback);
    }

    public boolean renderSuggestion(int width, int height, IInlineSuggestionUiCallback callback) {
        if (Helper.sanitizeSlice(this.mInlinePresentation.getSlice()) != null) goto L9;
        if (Helper.sDebug == false) goto L7;
        Slog.d(TAG, "Skipped rendering inline suggestion.");
    L7:
        return false;
    L9:
        if (this.mRemoteRenderService != null) goto L11;
        return false;
    L11:
        if (Helper.sDebug == false) goto L13;
        Slog.d(TAG, "Request to recreate the UI");
    L13:
        this.mRemoteRenderService.renderSuggestion(callback, this.mInlinePresentation, width, height, this.mHostInputToken, this.mDisplayId, this.mUserId, this.mSessionId);
        return true;
    }

    public void onClick() {
        this.mOnAutofillCallback.run();
    }

    public void onError() {
        this.mOnErrorCallback.run();
    }

    public void onRender() {
        this.mOnInflateCallback.run();
    }

    public void onTransferTouchFocusToImeWindow(IBinder sourceInputToken, int displayId) {
        InputMethodManagerInternal inputMethodManagerInternal = (InputMethodManagerInternal) LocalServices.getService(InputMethodManagerInternal.class);
        if (inputMethodManagerInternal.transferTouchFocusToImeWindow(sourceInputToken, displayId, this.mUserId) == true) goto L6;
        Slog.e(TAG, "Cannot transfer touch focus from suggestion to IME");
        this.mOnErrorCallback.run();
        return;
    }

    public void onStartIntentSender(IntentSender intentSender) {
        this.mStartIntentSenderFromClientApp.accept(intentSender);
    }
}
