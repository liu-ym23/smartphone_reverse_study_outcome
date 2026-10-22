package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/CheckStatus;", "", ErrorCode.INIT, "TTPAY", "CHECKING", "SUCCESS", "FAIL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CheckStatus extends Enum<CheckStatus> {
    public static final CheckStatus CHECKING = null;
    public static final CheckStatus FAIL = null;
    public static final CheckStatus INIT = null;
    public static final CheckStatus SUCCESS = null;
    public static final CheckStatus TTPAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckStatus[] f164217a = null;

    static {
        CheckStatus r100 = new CheckStatus(ErrorCode.INIT, 0);
        INIT = r100;
        CheckStatus r101 = new CheckStatus("TTPAY", 1);
        TTPAY = r101;
        CheckStatus r102 = new CheckStatus("CHECKING", 2);
        CHECKING = r102;
        CheckStatus r103 = new CheckStatus("SUCCESS", 3);
        SUCCESS = r103;
        CheckStatus r104 = new CheckStatus("FAIL", 4);
        FAIL = r104;
        f164217a = new CheckStatus[]{r100, r101, r102, r103, r104};
    }

    public static CheckStatus valueOf(String r100) {
        return (CheckStatus) a.a(CheckStatus.class, r100);
    }

    public static CheckStatus[] values() {
        return (CheckStatus[]) f164217a.clone();
    }

    public CheckStatus(String r100, int r101) {
        super(r100, r101);
    }
}
