package com.android.ttcjpaysdk.bindcard.unionpay.applog;

import com.android.ttcjpaysdk.bindcard.unionpay.bean.UnionPaySignBean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/applog/UnionPayAuthLogger;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/applog/BaseUnionPayBindLogger;", "()V", "walletYsfAuthPageClick", "", "button_name", "", "result", "signBean", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPaySignBean;", "walletYsfAuthPagePop", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayAuthLogger extends BaseUnionPayBindLogger {
    public final void walletYsfAuthPagePop() {
        BaseUnionPayBindLogger.logEvent$default(this, "wallet_ysf_auth_page_imp", null, 2, null);
    }

    public UnionPayAuthLogger() {
    }

    public final void walletYsfAuthPageClick(String r110, String r111, UnionPaySignBean r112) {
        Intrinsics.checkNotNullParameter(r110, "button_name");
        Intrinsics.checkNotNullParameter(r111, "result");
        int r100 = r111.hashCode();
        String r101 = "";
        if (r100 == 0) goto L30;
        if (r100 == 49) goto L26;
        if (r100 == 50) goto L10;
        return;
    L10:
        if (r111.equals("2") == false) goto L37;
        Pair[] r102 = new Pair[4];
        r102[0] = TuplesKt.to("button_name", r110);
        r102[1] = TuplesKt.to("result", r111);
        String r113 = null;
        if (r112 == null) goto L15;
        String r114 = r112.code;
    L16:
        if (r114 != null) goto L18;
        r114 = "";
    L18:
        r102[2] = TuplesKt.to("error_code", r114);
        if (r112 == null) goto L21;
        r113 = r112.msg;
    L21:
        if (r113 == null) goto L24;
        r101 = r113;
    L24:
        r102[3] = TuplesKt.to("error_message", r101);
        logEvent("wallet_ysf_auth_page_click", MapsKt.hashMapOf(r102));
        return;
    L15:
        r114 = null;
        goto L16
    L37:
        return;
    L26:
        if (r111.equals("1") == false) goto L38;
        logEvent("wallet_ysf_auth_page_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("button_name", r110), TuplesKt.to("result", r111)}));
        return;
    L38:
        return;
    L30:
        if (r111.equals("") == false) goto L39;
        logEvent("wallet_ysf_auth_page_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("button_name", r110)}));
        return;
    }

    public static /* synthetic */ void walletYsfAuthPageClick$default(UnionPayAuthLogger r100, String r101, String r102, UnionPaySignBean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.walletYsfAuthPageClick(r101, r102, r103);
    }
}
