package com.android.ttcjpaysdk.base.ui.dialog;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/LynxKeepDialogShowPosition;", "", "positionName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPositionName", "()Ljava/lang/String;", "RETAIN_HOMEPAGE", "RETAIN_VERIFY_PAGE", "RETAIN_BIO_PAYMENT_PAGE", "RETAIN_SKIP_PWD_PAGE", "RETAIN_SIGN_AND_PAY", "RETAIN_PAY_AGAIN_PAGE", "O_FULLSCREEN_COUNTER", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum LynxKeepDialogShowPosition extends Enum<LynxKeepDialogShowPosition> {
    private static final /* synthetic */ LynxKeepDialogShowPosition[] $VALUES = null;
    public static final LynxKeepDialogShowPosition O_FULLSCREEN_COUNTER = null;
    public static final LynxKeepDialogShowPosition RETAIN_BIO_PAYMENT_PAGE = null;
    public static final LynxKeepDialogShowPosition RETAIN_HOMEPAGE = null;
    public static final LynxKeepDialogShowPosition RETAIN_PAY_AGAIN_PAGE = null;
    public static final LynxKeepDialogShowPosition RETAIN_SIGN_AND_PAY = null;
    public static final LynxKeepDialogShowPosition RETAIN_SKIP_PWD_PAGE = null;
    public static final LynxKeepDialogShowPosition RETAIN_VERIFY_PAGE = null;
    private final String positionName;

    private static final /* synthetic */ LynxKeepDialogShowPosition[] $values() {
        return new LynxKeepDialogShowPosition[]{RETAIN_HOMEPAGE, RETAIN_VERIFY_PAGE, RETAIN_BIO_PAYMENT_PAGE, RETAIN_SKIP_PWD_PAGE, RETAIN_SIGN_AND_PAY, RETAIN_PAY_AGAIN_PAGE, O_FULLSCREEN_COUNTER};
    }

    public static LynxKeepDialogShowPosition valueOf(String r100) {
        return (LynxKeepDialogShowPosition) a.a(LynxKeepDialogShowPosition.class, r100);
    }

    public static LynxKeepDialogShowPosition[] values() {
        return (LynxKeepDialogShowPosition[]) $VALUES.clone();
    }

    static {
        RETAIN_HOMEPAGE = new LynxKeepDialogShowPosition("RETAIN_HOMEPAGE", 0, "home_page");
        RETAIN_VERIFY_PAGE = new LynxKeepDialogShowPosition("RETAIN_VERIFY_PAGE", 1, "verify_page");
        RETAIN_BIO_PAYMENT_PAGE = new LynxKeepDialogShowPosition("RETAIN_BIO_PAYMENT_PAGE", 2, "biopayment_page");
        RETAIN_SKIP_PWD_PAGE = new LynxKeepDialogShowPosition("RETAIN_SKIP_PWD_PAGE", 3, "nopwd_page");
        RETAIN_SIGN_AND_PAY = new LynxKeepDialogShowPosition("RETAIN_SIGN_AND_PAY", 4, "sign_and_pay_page");
        RETAIN_PAY_AGAIN_PAGE = new LynxKeepDialogShowPosition("RETAIN_PAY_AGAIN_PAGE", 5, "pay_again_page");
        O_FULLSCREEN_COUNTER = new LynxKeepDialogShowPosition("O_FULLSCREEN_COUNTER", 6, "o_fullscreen_counter");
        $VALUES = $values();
    }

    public final String getPositionName() {
        return this.positionName;
    }

    private LynxKeepDialogShowPosition(String r100, int r101, String r102) {
        super(r100, r101);
        this.positionName = r102;
    }
}
