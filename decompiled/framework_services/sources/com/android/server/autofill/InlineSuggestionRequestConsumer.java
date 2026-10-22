package com.android.server.autofill;

import android.util.Slog;
import android.view.inputmethod.InlineSuggestionsRequest;
import java.lang.ref.WeakReference;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
class InlineSuggestionRequestConsumer implements Consumer<InlineSuggestionsRequest> {
    static final String TAG = "InlineSuggestionRequestConsumer";
    private final WeakReference<Session.AssistDataReceiverImpl> mAssistDataReceiverWeakReference;
    private final WeakReference<ViewState> mViewStateWeakReference;

    @Override // java.util.function.Consumer
    public /* bridge */ /* synthetic */ void accept(InlineSuggestionsRequest r1) {
        accept2(r1);
    }

    InlineSuggestionRequestConsumer(WeakReference<Session.AssistDataReceiverImpl> assistDataReceiverWeakReference, WeakReference<ViewState> viewStateWeakReference) {
        this.mAssistDataReceiverWeakReference = assistDataReceiverWeakReference;
        this.mViewStateWeakReference = viewStateWeakReference;
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(InlineSuggestionsRequest inlineSuggestionsRequest) {
        Session.AssistDataReceiverImpl assistDataReceiver = this.mAssistDataReceiverWeakReference.get();
        ViewState viewState = this.mViewStateWeakReference.get();
        if (assistDataReceiver != null) goto L6;
        Slog.wtf(TAG, "assistDataReceiver is null when accepting new inline suggestionrequests");
        return;
    L6:
        if (viewState != null) goto L9;
        Slog.wtf(TAG, "view state is null when accepting new inline suggestion requests");
        return;
    L9:
        assistDataReceiver.handleInlineSuggestionRequest(inlineSuggestionsRequest, viewState);
    }
}
