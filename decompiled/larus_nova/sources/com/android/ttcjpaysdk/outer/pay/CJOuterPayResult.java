package com.android.ttcjpaysdk.outer.pay;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/outer/pay/CJOuterPayResult;", "", "()V", "getResult", "", "code", "msg", "extra", "outer-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOuterPayResult {
    public static final CJOuterPayResult INSTANCE = null;

    static {
        INSTANCE = new CJOuterPayResult();
    }

    private CJOuterPayResult() {
    }

    public final String getResult(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "extra");
        JSONObject r103 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r103, "code", r100);
        KtSafeMethodExtensionKt.safePut(r103, "msg", r101);
        KtSafeMethodExtensionKt.safePut(r103, "extra", r102);
        return r103.toString();
    }

    public static /* synthetic */ String getResult$default(CJOuterPayResult r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = "";
    L9:
        return r100.getResult(r101, r102, r103);
    }
}
