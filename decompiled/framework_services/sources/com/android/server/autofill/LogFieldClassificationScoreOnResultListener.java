package com.android.server.autofill;

import android.os.Bundle;
import android.os.RemoteCallback;
import android.service.autofill.FieldClassification;
import android.util.Slog;
import android.view.autofill.AutofillId;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class LogFieldClassificationScoreOnResultListener implements RemoteCallback.OnResultListener {
    private static final String TAG = "LogFieldClassificationScoreOnResultListener";
    private final AutofillId[] mAutofillIds;
    private final String[] mCategoryIds;
    private final int mCommitReason;
    private final ArrayList<FieldClassification> mDetectedFieldClassifications;
    private final ArrayList<AutofillId> mDetectedFieldIds;
    private final int mSaveDialogNotShowReason;
    private Session mSession;
    private final String[] mUserValues;
    private final int mViewsSize;

    LogFieldClassificationScoreOnResultListener(Session session, int saveDialogNotShowReason, int commitReason, int viewsSize, AutofillId[] autofillIds, String[] userValues, String[] categoryIds, ArrayList<AutofillId> detectedFieldIds, ArrayList<FieldClassification> detectedFieldClassifications) {
        this.mSession = session;
        this.mSaveDialogNotShowReason = saveDialogNotShowReason;
        this.mCommitReason = commitReason;
        this.mViewsSize = viewsSize;
        this.mAutofillIds = autofillIds;
        this.mUserValues = userValues;
        this.mCategoryIds = categoryIds;
        this.mDetectedFieldIds = detectedFieldIds;
        this.mDetectedFieldClassifications = detectedFieldClassifications;
    }

    public void onResult(Bundle result) {
        Session session = this.mSession;
        if (session != null) goto L6;
        Slog.wtf(TAG, "session is null when calling onResult()");
        return;
    L6:
        session.handleLogFieldClassificationScore(result, this.mSaveDialogNotShowReason, this.mCommitReason, this.mViewsSize, this.mAutofillIds, this.mUserValues, this.mCategoryIds, this.mDetectedFieldIds, this.mDetectedFieldClassifications);
        this.mSession = null;
    }
}
