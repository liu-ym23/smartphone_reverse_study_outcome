package com.android.ttcjpaysdk.verify.data.product;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/product/VerifyUrlParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "is_signed", "", "live_route", "member_biz_order_no", "configuration_params", "source", "risk_source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyUrlParams implements CJPayObject {
    public String configuration_params;
    public String is_signed;
    public String live_route;
    public String member_biz_order_no;
    public String risk_source;
    public String source;

    public VerifyUrlParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public VerifyUrlParams(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "is_signed");
        Intrinsics.checkNotNullParameter(r101, "live_route");
        Intrinsics.checkNotNullParameter(r102, "member_biz_order_no");
        Intrinsics.checkNotNullParameter(r103, "configuration_params");
        Intrinsics.checkNotNullParameter(r104, "source");
        Intrinsics.checkNotNullParameter(r105, "risk_source");
        this.is_signed = r100;
        this.live_route = r101;
        this.member_biz_order_no = r102;
        this.configuration_params = r103;
        this.source = r104;
        this.risk_source = r105;
    }

    public /* synthetic */ VerifyUrlParams(String r100, String r101, String r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = "";
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = "";
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = "";
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = "";
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = "";
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
