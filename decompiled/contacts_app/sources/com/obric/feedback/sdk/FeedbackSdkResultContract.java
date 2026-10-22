package com.obric.feedback.sdk;

import kotlin.Metadata;

/* JADX INFO: compiled from: FeedbackSdkResultContract.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/feedback/sdk/FeedbackSdkResultContract;", "", "()V", "ACTION_CUSTOM_FILE_COPY_FINISHED", "", "ACTION_PERMISSION", "EXTRA_FROM_PACKAGE", "EXTRA_REPORT_ID", "EXTRA_TASK_ID", "feedbacksdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FeedbackSdkResultContract {
    public static final String ACTION_CUSTOM_FILE_COPY_FINISHED = "com.obric.feedback.sdk.action.CUSTOM_FILE_COPY_FINISHED";
    public static final String ACTION_PERMISSION = "com.obric.feedback.sdk.action.PERMISSION_BROADCAST";
    public static final String EXTRA_FROM_PACKAGE = "extra.FROM_PACKAGE";
    public static final String EXTRA_REPORT_ID = "extra.REPORT_ID";
    public static final String EXTRA_TASK_ID = "extra.TASK_ID";
    public static final FeedbackSdkResultContract INSTANCE = null;

    static {
        INSTANCE = new FeedbackSdkResultContract();
    }

    private FeedbackSdkResultContract() {
    }
}
