package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/TTPayCode;", "", "", "rawValue", "I", "getRawValue", "()I", "SUCCESS", "TT_CJ_PAY_ANTI_FRAUD_CANCELED", "INSUFFICIENT_BALANCE", "NEW_BANK_CARD_SHARE_SUCCESS", "IS_PAY_PROGRESS", "CANCEL_PAY", "WECHAT_NOT_INSTALLED", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TTPayCode extends Enum<TTPayCode> {
    public static final TTPayCode CANCEL_PAY = null;
    public static final TTPayCode INSUFFICIENT_BALANCE = null;
    public static final TTPayCode IS_PAY_PROGRESS = null;
    public static final TTPayCode NEW_BANK_CARD_SHARE_SUCCESS = null;
    public static final TTPayCode SUCCESS = null;
    public static final TTPayCode TT_CJ_PAY_ANTI_FRAUD_CANCELED = null;
    public static final TTPayCode WECHAT_NOT_INSTALLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TTPayCode[] f164227a = null;
    private final int rawValue;

    static {
        TTPayCode r100 = new TTPayCode("SUCCESS", 0, 0);
        SUCCESS = r100;
        TTPayCode r101 = new TTPayCode("TT_CJ_PAY_ANTI_FRAUD_CANCELED", 1, 116);
        TT_CJ_PAY_ANTI_FRAUD_CANCELED = r101;
        TTPayCode r102 = new TTPayCode("INSUFFICIENT_BALANCE", 2, 113);
        INSUFFICIENT_BALANCE = r102;
        TTPayCode r103 = new TTPayCode("NEW_BANK_CARD_SHARE_SUCCESS", 3, 118);
        NEW_BANK_CARD_SHARE_SUCCESS = r103;
        TTPayCode r104 = new TTPayCode("IS_PAY_PROGRESS", 4, 9);
        IS_PAY_PROGRESS = r104;
        TTPayCode r105 = new TTPayCode("CANCEL_PAY", 5, 4);
        CANCEL_PAY = r105;
        TTPayCode r106 = new TTPayCode("WECHAT_NOT_INSTALLED", 6, 119);
        WECHAT_NOT_INSTALLED = r106;
        f164227a = new TTPayCode[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static TTPayCode valueOf(String r100) {
        return (TTPayCode) a.a(TTPayCode.class, r100);
    }

    public static TTPayCode[] values() {
        return (TTPayCode[]) f164227a.clone();
    }

    public final int getRawValue() {
        return this.rawValue;
    }

    public TTPayCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
