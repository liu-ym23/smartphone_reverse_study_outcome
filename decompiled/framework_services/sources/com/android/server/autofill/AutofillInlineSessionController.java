package com.android.server.autofill;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.view.autofill.AutofillId;
import android.view.inputmethod.InlineSuggestionsRequest;
import com.android.server.autofill.ui.InlineFillUi;
import com.android.server.inputmethod.InputMethodManagerInternal;
import java.util.Optional;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
final class AutofillInlineSessionController {
    private final ComponentName mComponentName;
    private final Handler mHandler;
    private InlineFillUi mInlineFillUi;
    private final InputMethodManagerInternal mInputMethodManagerInternal;
    private final Object mLock;
    private AutofillInlineSuggestionsRequestSession mSession;
    private final InlineFillUi.InlineUiEventCallback mUiCallback;
    private final int mUserId;

    AutofillInlineSessionController(InputMethodManagerInternal inputMethodManagerInternal, int userId, ComponentName componentName, Handler handler, Object lock, InlineFillUi.InlineUiEventCallback callback) {
        this.mInputMethodManagerInternal = inputMethodManagerInternal;
        this.mUserId = userId;
        this.mComponentName = componentName;
        this.mHandler = handler;
        this.mLock = lock;
        this.mUiCallback = callback;
    }

    void onCreateInlineSuggestionsRequestLocked(AutofillId autofillId, Consumer<InlineSuggestionsRequest> requestConsumer, Bundle uiExtras) {
        if (this.mSession == null) goto L5;
        this.mSession.destroySessionLocked();
    L5:
        this.mInlineFillUi = null;
        this.mSession = new AutofillInlineSuggestionsRequestSession(this.mInputMethodManagerInternal, this.mUserId, this.mComponentName, this.mHandler, this.mLock, autofillId, requestConsumer, uiExtras, this.mUiCallback);
        this.mSession.onCreateInlineSuggestionsRequestLocked();
    }

    void destroyLocked(AutofillId autofillId) {
        if (this.mSession == null) goto L5;
        this.mSession.onInlineSuggestionsResponseLocked(InlineFillUi.emptyUi(autofillId));
        this.mSession.destroySessionLocked();
        this.mSession = null;
    L5:
        this.mInlineFillUi = null;
    }

    Optional<InlineSuggestionsRequest> getInlineSuggestionsRequestLocked() {
        if (this.mSession == null) goto L7;
        return this.mSession.getInlineSuggestionsRequestLocked();
    L7:
        return Optional.empty();
    }

    boolean hideInlineSuggestionsUiLocked(AutofillId autofillId) {
        if (this.mSession != null) goto L5;
        return false;
    L5:
        return this.mSession.onInlineSuggestionsResponseLocked(InlineFillUi.emptyUi(autofillId));
    }

    void disableFilterMatching(AutofillId autofillId) {
        if (this.mInlineFillUi != null) goto L5;
        return;
    L5:
        if (this.mInlineFillUi.getAutofillId().equals(autofillId) == false) goto L9;
        this.mInlineFillUi.disableFilterMatching();
        return;
    }

    void resetInlineFillUiLocked() {
        this.mInlineFillUi = null;
        if (this.mSession == null) goto L6;
        this.mSession.resetInlineFillUiLocked();
        return;
    }

    boolean filterInlineFillUiLocked(AutofillId autofillId, String filterText) {
        if (this.mInlineFillUi != null) goto L5;
        return false;
    L5:
        if (this.mInlineFillUi.getAutofillId().equals(autofillId) == false) goto L10;
        this.mInlineFillUi.setFilterText(filterText);
        return requestImeToShowInlineSuggestionsLocked();
    L10:
        return false;
    }

    boolean setInlineFillUiLocked(InlineFillUi inlineFillUi) {
        this.mInlineFillUi = inlineFillUi;
        return requestImeToShowInlineSuggestionsLocked();
    }

    private boolean requestImeToShowInlineSuggestionsLocked() {
        if (this.mSession != null) goto L5;
        return false;
    L5:
        if (this.mInlineFillUi != null) goto L7;
        return false;
    L7:
        return this.mSession.onInlineSuggestionsResponseLocked(this.mInlineFillUi);
    }

    boolean isImeShowing() {
        if (this.mSession != null) goto L5;
        return false;
    L5:
        return this.mSession.isImeShowing();
    }
}
