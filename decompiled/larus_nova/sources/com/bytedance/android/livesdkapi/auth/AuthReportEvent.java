package com.bytedance.android.livesdkapi.auth;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/auth/AuthReportEvent;", "", "()V", "AUTH_DIALOG_PAGE_NAME", "", "AUTH_RESULT", "BTN_AGREE_PROTO", "BTN_CANCEL", "BTN_CONFIRM", "BTN_DOUYIN", "CANCEL_BTN_NAME", "CONFIRM_BTN_NAME", "DOUYIN_AUTH_PAGE_NAME", "PHONE_NUMBER_AUTH_PAGE_NAME", "USE_DY_AUTH_BTN_NAME", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuthReportEvent {
    public static final String AUTH_DIALOG_PAGE_NAME = "phone_authorization_popup";
    public static final String AUTH_RESULT = "livesdk_aweme_authorization_result_from_host";
    public static final String BTN_AGREE_PROTO = "argee_authorization";
    public static final String BTN_CANCEL = "cancel";
    public static final String BTN_CONFIRM = "immediate_relevance";
    public static final String BTN_DOUYIN = "other_aweme_account";
    public static final String CANCEL_BTN_NAME = "cancel_from_host";
    public static final String CONFIRM_BTN_NAME = "confirm_from_host";
    public static final String DOUYIN_AUTH_PAGE_NAME = "douyin_authorization_popup";
    public static final AuthReportEvent INSTANCE = null;
    public static final String PHONE_NUMBER_AUTH_PAGE_NAME = "phone_oneclick_login_popup";
    public static final String USE_DY_AUTH_BTN_NAME = "douyin_login_from_host";

    private AuthReportEvent() {
    }

    static {
        INSTANCE = new AuthReportEvent();
    }
}
