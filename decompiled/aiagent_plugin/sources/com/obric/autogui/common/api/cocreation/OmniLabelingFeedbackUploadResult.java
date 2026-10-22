package com.obric.autogui.common.api.cocreation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IOmniLabelingFeedbackUploader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OmniLabelingFeedbackUploadResult {
    private final int failedCount;
    private final String message;
    private final int skippedCount;
    private final boolean success;
    private final int uploadedCount;

    public static /* synthetic */ OmniLabelingFeedbackUploadResult copy$default(OmniLabelingFeedbackUploadResult r3, boolean r4, String r5, int r6, int r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.success;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.message;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.uploadedCount;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.failedCount;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.skippedCount;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final boolean component1() {
        return this.success;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.uploadedCount;
    }

    public final int component4() {
        return this.failedCount;
    }

    public final int component5() {
        return this.skippedCount;
    }

    public final OmniLabelingFeedbackUploadResult copy(boolean r7, String r8, int r9, int r10, int r11) {
        o.e(r8, "message");
        return new OmniLabelingFeedbackUploadResult(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OmniLabelingFeedbackUploadResult.class) == true) goto L8;
        return false;
    L8:
        OmniLabelingFeedbackUploadResult r6 = (OmniLabelingFeedbackUploadResult) ZeusTransformUtils.preCheckCast(r5, OmniLabelingFeedbackUploadResult.class, "com.obric.aiagent.plugin");
        if (this.success == r6.success) goto L12;
        return false;
    L12:
        if (o.a(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (this.uploadedCount == r6.uploadedCount) goto L18;
        return false;
    L18:
        if (this.failedCount == r6.failedCount) goto L21;
        return false;
    L21:
        if (this.skippedCount == r6.skippedCount) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.success) * 31) + this.message.hashCode()) * 31) + Integer.hashCode(this.uploadedCount)) * 31) + Integer.hashCode(this.failedCount)) * 31) + Integer.hashCode(this.skippedCount);
    }

    public String toString() {
        return "OmniLabelingFeedbackUploadResult(success=" + this.success + ", message=" + this.message + ", uploadedCount=" + this.uploadedCount + ", failedCount=" + this.failedCount + ", skippedCount=" + this.skippedCount + ')';
    }

    public OmniLabelingFeedbackUploadResult(boolean r2, String r3, int r4, int r5, int r6) {
        o.e(r3, "message");
        this.success = r2;
        this.message = r3;
        this.uploadedCount = r4;
        this.failedCount = r5;
        this.skippedCount = r6;
    }

    public /* synthetic */ OmniLabelingFeedbackUploadResult(boolean r8, String r9, int r10, int r11, int r12, int r13, h r14) {
        if ((r13 & 4) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r13 & 8) == 0) goto L9;
        int r5 = 0;
    L11:
        if ((r13 & 16) == 0) goto L13;
        int r6 = 0;
    L14:
        this(r8, r9, r4, r5, r6);
        return;
    L13:
        r6 = r12;
        goto L14
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getUploadedCount() {
        return this.uploadedCount;
    }

    public final int getFailedCount() {
        return this.failedCount;
    }

    public final int getSkippedCount() {
        return this.skippedCount;
    }
}
