package com.android.server.autofill;

import android.os.Bundle;
import android.os.RemoteCallback;
import android.util.Slog;
import android.view.autofill.AutofillId;
import android.view.inputmethod.InlineSuggestionsRequest;
import java.lang.ref.WeakReference;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
final class InlineSuggestionRendorInfoCallbackOnResultListener implements RemoteCallback.OnResultListener {
    private static final String TAG = "InlineSuggestionRendorInfoCallbackOnResultListener";
    private final AutofillId mFocusedId;
    private final Consumer<InlineSuggestionsRequest> mInlineSuggestionsRequestConsumer;
    private final int mRequestIdCopy;
    private final WeakReference<Session> mSessionWeakReference;

    InlineSuggestionRendorInfoCallbackOnResultListener(WeakReference<Session> sessionWeakReference, int requestIdCopy, Consumer<InlineSuggestionsRequest> inlineSuggestionsRequestConsumer, AutofillId focusedId) {
        this.mRequestIdCopy = requestIdCopy;
        this.mInlineSuggestionsRequestConsumer = inlineSuggestionsRequestConsumer;
        this.mSessionWeakReference = sessionWeakReference;
        this.mFocusedId = focusedId;
    }

    public void onResult(Bundle result) {
        Session session = this.mSessionWeakReference.get();
        if (session != null) goto L6;
        Slog.wtf(TAG, "Session is null before trying to call onResult");
        return;
    L6:
        Object r1 = session.mLock;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (session.mDestroyed == false) goto L15;
        Slog.wtf(TAG, "Session is destroyed before trying to call onResult");     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L15:
        session.mInlineSessionController.onCreateInlineSuggestionsRequestLocked(this.mFocusedId, session.inlineSuggestionsRequestCacheDecorator(this.mInlineSuggestionsRequestConsumer, this.mRequestIdCopy), result);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
    }
}
