package com.android.ttcjpaysdk.base.ui.dialog;

import com.android.ttcjpaysdk.integrated.counter.outerpay.IntegratedOuterPayRooter;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/LynxKeepDialogFromScene;", "", "pageName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPageName", "()Ljava/lang/String;", "VERIFY_PASSWORD", "SKIP_PWD", "FACE_VERIFY", "FINGERPRINT_VERIFY", "SMS_VERIFY", "PAY_AGAIN", "HOME_PAGE", "SIGN_AND_PAGE", "OUTER_LOGIN", "OUTER_FULLSCREEN_COUNTER", "OUTER_SIGN_ONLY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum LynxKeepDialogFromScene extends Enum<LynxKeepDialogFromScene> {
    private static final /* synthetic */ LynxKeepDialogFromScene[] $VALUES = null;
    public static final LynxKeepDialogFromScene FACE_VERIFY = null;
    public static final LynxKeepDialogFromScene FINGERPRINT_VERIFY = null;
    public static final LynxKeepDialogFromScene HOME_PAGE = null;
    public static final LynxKeepDialogFromScene OUTER_FULLSCREEN_COUNTER = null;
    public static final LynxKeepDialogFromScene OUTER_LOGIN = null;
    public static final LynxKeepDialogFromScene OUTER_SIGN_ONLY = null;
    public static final LynxKeepDialogFromScene PAY_AGAIN = null;
    public static final LynxKeepDialogFromScene SIGN_AND_PAGE = null;
    public static final LynxKeepDialogFromScene SKIP_PWD = null;
    public static final LynxKeepDialogFromScene SMS_VERIFY = null;
    public static final LynxKeepDialogFromScene VERIFY_PASSWORD = null;
    private final String pageName;

    private static final /* synthetic */ LynxKeepDialogFromScene[] $values() {
        return new LynxKeepDialogFromScene[]{VERIFY_PASSWORD, SKIP_PWD, FACE_VERIFY, FINGERPRINT_VERIFY, SMS_VERIFY, PAY_AGAIN, HOME_PAGE, SIGN_AND_PAGE, OUTER_LOGIN, OUTER_FULLSCREEN_COUNTER, OUTER_SIGN_ONLY};
    }

    public static LynxKeepDialogFromScene valueOf(String r100) {
        return (LynxKeepDialogFromScene) a.a(LynxKeepDialogFromScene.class, r100);
    }

    public static LynxKeepDialogFromScene[] values() {
        return (LynxKeepDialogFromScene[]) $VALUES.clone();
    }

    static {
        VERIFY_PASSWORD = new LynxKeepDialogFromScene("VERIFY_PASSWORD", 0, "verify_password");
        SKIP_PWD = new LynxKeepDialogFromScene("SKIP_PWD", 1, "skip_pwd");
        FACE_VERIFY = new LynxKeepDialogFromScene("FACE_VERIFY", 2, "face_verify");
        FINGERPRINT_VERIFY = new LynxKeepDialogFromScene("FINGERPRINT_VERIFY", 3, "fingerprint_verify");
        SMS_VERIFY = new LynxKeepDialogFromScene("SMS_VERIFY", 4, "sms_verify");
        PAY_AGAIN = new LynxKeepDialogFromScene("PAY_AGAIN", 5, "pay_again");
        HOME_PAGE = new LynxKeepDialogFromScene("HOME_PAGE", 6, "home_page");
        SIGN_AND_PAGE = new LynxKeepDialogFromScene("SIGN_AND_PAGE", 7, IntegratedOuterPayRooter.INTEGRATED_SIGN_AND_PAY);
        OUTER_LOGIN = new LynxKeepDialogFromScene("OUTER_LOGIN", 8, "outer_login");
        OUTER_FULLSCREEN_COUNTER = new LynxKeepDialogFromScene("OUTER_FULLSCREEN_COUNTER", 9, "outer_fullscreen_counter");
        OUTER_SIGN_ONLY = new LynxKeepDialogFromScene("OUTER_SIGN_ONLY", 10, "outer_sign_only");
        $VALUES = $values();
    }

    public final String getPageName() {
        return this.pageName;
    }

    private LynxKeepDialogFromScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.pageName = r102;
    }
}
