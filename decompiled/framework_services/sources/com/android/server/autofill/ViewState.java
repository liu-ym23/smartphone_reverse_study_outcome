package com.android.server.autofill;

import android.graphics.Rect;
import android.service.autofill.FillResponse;
import android.util.DebugUtils;
import android.util.Slog;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
final class ViewState {
    public static final int STATE_AUTOFILLED = 4;
    public static final int STATE_AUTOFILLED_ONCE = 2048;
    public static final int STATE_AUTOFILL_FAILED = 1024;
    public static final int STATE_CHANGED = 8;
    public static final int STATE_CHAR_REMOVED = 16384;
    public static final int STATE_FILLABLE = 2;
    public static final int STATE_FILL_DIALOG_SHOWN = 131072;
    public static final int STATE_IGNORED = 128;
    public static final int STATE_INITIAL = 1;
    public static final int STATE_INLINE_DISABLED = 32768;
    public static final int STATE_INLINE_SHOWN = 8192;
    public static final int STATE_PENDING_CREATE_INLINE_REQUEST = 65536;
    public static final int STATE_RESTARTED_SESSION = 256;
    public static final int STATE_STARTED_PARTITION = 32;
    public static final int STATE_STARTED_SESSION = 16;
    public static final int STATE_TRIGGERED_AUGMENTED_AUTOFILL = 4096;
    public static final int STATE_URL_BAR = 512;
    public static final int STATE_WAITING_DATASET_AUTH = 64;
    private static final String TAG = "ViewState";
    public final AutofillId id;
    private AutofillValue mAutofilledValue;
    private AutofillValue mCandidateSaveValue;
    private AutofillValue mCurrentValue;
    private String mDatasetId;
    private final boolean mIsPrimaryCredential;
    private final Listener mListener;
    private FillResponse mPrimaryFillResponse;
    private AutofillValue mSanitizedValue;
    private FillResponse mSecondaryFillResponse;
    private int mState;
    private Rect mVirtualBounds;

    interface Listener {
        void onFillReady(FillResponse r1, AutofillId r2, AutofillValue r3, int r4);
    }

    ViewState(AutofillId id, Listener listener, int state, boolean isPrimaryCredential) {
        this.id = id;
        this.mListener = listener;
        this.mState = state;
        this.mIsPrimaryCredential = isPrimaryCredential;
    }

    Rect getVirtualBounds() {
        return this.mVirtualBounds;
    }

    AutofillValue getCurrentValue() {
        return this.mCurrentValue;
    }

    void setCurrentValue(AutofillValue value) {
        this.mCurrentValue = value;
    }

    AutofillValue getCandidateSaveValue() {
        return this.mCandidateSaveValue;
    }

    void setCandidateSaveValue(AutofillValue value) {
        this.mCandidateSaveValue = value;
    }

    AutofillValue getAutofilledValue() {
        return this.mAutofilledValue;
    }

    void setAutofilledValue(AutofillValue value) {
        this.mAutofilledValue = value;
    }

    AutofillValue getSanitizedValue() {
        return this.mSanitizedValue;
    }

    void setSanitizedValue(AutofillValue value) {
        this.mSanitizedValue = value;
    }

    FillResponse getResponse() {
        return this.mPrimaryFillResponse;
    }

    FillResponse getSecondaryResponse() {
        return this.mSecondaryFillResponse;
    }

    void setResponse(FillResponse response) {
        setResponse(response, true);
    }

    void setResponse(FillResponse response, boolean isPrimary) {
        if (isPrimary == false) goto L4;
        this.mPrimaryFillResponse = response;
        return;
    L4:
        this.mSecondaryFillResponse = response;
    }

    int getState() {
        return this.mState;
    }

    String getStateAsString() {
        return getStateAsString(this.mState);
    }

    static String getStateAsString(int state) {
        return DebugUtils.flagsToString(ViewState.class, "STATE_", state);
    }

    void setState(int state) {
        if (this.mState != 1) goto L5;
        this.mState = state;
    L7:
        if (state != 4) goto L10;
        this.mState |= 2048;
        return;
    L10:
        return;
    L5:
        this.mState |= state;
        goto L7
    }

    void resetState(int state) {
        this.mState &= ~state;
    }

    String getDatasetId() {
        return this.mDatasetId;
    }

    void setDatasetId(String datasetId) {
        this.mDatasetId = datasetId;
    }

    void update(AutofillValue autofillValue, Rect virtualBounds, int flags) {
        if (autofillValue == null) goto L4;
        this.mCurrentValue = autofillValue;
    L4:
        if (virtualBounds == null) goto L6;
        this.mVirtualBounds = virtualBounds;
    L6:
        maybeCallOnFillReady(flags);
    }

    void maybeCallOnFillReady(int flags) {
        if ((this.mState & 4) == 0) goto L11;
        if ((flags & 1) != 0) goto L11;
        if (Helper.sDebug == false) goto L21;
        Slog.d(TAG, "Ignoring UI for " + this.id + " on " + getStateAsString());
        return;
    L21:
        return;
    L11:
        if (requestingPrimaryResponse(flags) == false) goto L13;
        FillResponse requestedResponse = this.mPrimaryFillResponse;
    L14:
        if (requestedResponse != null) goto L16;
        return;
    L16:
        if (requestedResponse.getDatasets() == null) goto L18;
    L19:
        this.mListener.onFillReady(requestedResponse, this.id, this.mCurrentValue, flags);
        return;
    L18:
        if (requestedResponse.getAuthentication() != null) goto L19;
        return;
    L13:
        requestedResponse = this.mSecondaryFillResponse;
        goto L14
    }

    private boolean requestingPrimaryResponse(int flags) {
        if (this.mIsPrimaryCredential == false) goto L9;
        if ((flags & 2048) != 0) goto L7;
        return false;
    L7:
        return true;
    L9:
        if ((flags & 2048) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("ViewState: [id=").append(this.id);
        if (this.mDatasetId == null) goto L5;
        builder.append(", datasetId:");
        builder.append(this.mDatasetId);
    L5:
        builder.append(", state:");
        builder.append(getStateAsString());
        if (this.mCurrentValue == null) goto L9;
        builder.append(", currentValue:");
        builder.append(this.mCurrentValue);
    L9:
        if (this.mCandidateSaveValue == null) goto L12;
        builder.append(", candidateSaveValue:");
        builder.append(this.mCandidateSaveValue);
    L12:
        if (this.mAutofilledValue == null) goto L15;
        builder.append(", autofilledValue:");
        builder.append(this.mAutofilledValue);
    L15:
        if (this.mSanitizedValue == null) goto L18;
        builder.append(", sanitizedValue:");
        builder.append(this.mSanitizedValue);
    L18:
        if (this.mVirtualBounds == null) goto L20;
        builder.append(", virtualBounds:");
        builder.append(this.mVirtualBounds);
    L20:
        builder.append("]");
        return builder.toString();
    }

    void dump(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("id:");
        pw.println(this.id);
        if (this.mDatasetId == null) goto L5;
        pw.print(prefix);
        pw.print("datasetId:");
        pw.println(this.mDatasetId);
    L5:
        pw.print(prefix);
        pw.print("state:");
        pw.println(getStateAsString());
        pw.print(prefix);
        pw.print("is primary credential:");
        pw.println(this.mIsPrimaryCredential);
        if (this.mPrimaryFillResponse == null) goto L9;
        pw.print(prefix);
        pw.print("primary response id:");
        pw.println(this.mPrimaryFillResponse.getRequestId());
    L9:
        if (this.mSecondaryFillResponse == null) goto L12;
        pw.print(prefix);
        pw.print("secondary response id:");
        pw.println(this.mSecondaryFillResponse.getRequestId());
    L12:
        if (this.mCurrentValue == null) goto L15;
        pw.print(prefix);
        pw.print("currentValue:");
        pw.println(this.mCurrentValue);
    L15:
        if (this.mAutofilledValue == null) goto L18;
        pw.print(prefix);
        pw.print("autofilledValue:");
        pw.println(this.mAutofilledValue);
    L18:
        if (this.mCandidateSaveValue == null) goto L21;
        pw.print(prefix);
        pw.print("candidateSaveValue:");
        pw.println(this.mCandidateSaveValue);
    L21:
        if (this.mSanitizedValue == null) goto L24;
        pw.print(prefix);
        pw.print("sanitizedValue:");
        pw.println(this.mSanitizedValue);
    L24:
        if (this.mVirtualBounds == null) goto L27;
        pw.print(prefix);
        pw.print("virtualBounds:");
        pw.println(this.mVirtualBounds);
        return;
    }
}
