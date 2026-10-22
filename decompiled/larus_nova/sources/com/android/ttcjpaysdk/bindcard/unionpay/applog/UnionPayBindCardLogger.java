package com.android.ttcjpaysdk.bindcard.unionpay.applog;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bindcard.base.utils.CJPayBindCardLogUtils;
import com.android.ttcjpaysdk.bindcard.unionpay.bean.UnionPayBankBean;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004JF\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rJ\u001e\u0010\u0011\u001a\u00020\u00042\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/applog/UnionPayBindCardLogger;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/applog/BaseUnionPayBindLogger;", "()V", "walletYsfBcardBack", "", "walletYsfBcardClick", "buttonName", "", "result", "errorCode", "errorMessage", "cardListBean", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayBankBean;", "Lkotlin/collections/ArrayList;", "walletYsfBcardListClick", "selectedItemBean", "walletYsfBcardListShow", "cardList", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayBindCardLogger extends BaseUnionPayBindLogger {
    public final void walletYsfBcardBack() {
        logEvent("wallet_page_back_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("page_name", "wallet_ysf_bcard_list_page")}));
    }

    public UnionPayBindCardLogger() {
    }

    public final void walletYsfBcardListClick(UnionPayBankBean r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedItemBean");
        logEvent("wallet_ysf_bcard_list_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("bank_name", r100.bank_name), TuplesKt.to("bank_type", CJPayBindCardLogUtils.getBankType(r100.card_type))}));
    }

    public final void walletYsfBcardListShow(ArrayList<UnionPayBankBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "cardList");
        StringBuffer r101 = new StringBuffer();     // Catch: Exception -> L14
        Iterator<UnionPayBankBean> r102 = r100.iterator();     // Catch: Exception -> L14
    L5:
        if (r102.hasNext() == false) goto L9;
        UnionPayBankBean r103 = r102.next();     // Catch: Exception -> L14
        if (Intrinsics.areEqual(r103.status, "1") == false) goto L5;
        r101.append(r103.bank_name);     // Catch: Exception -> L14
        r101.append(",");     // Catch: Exception -> L14
        goto L5
    L9:
        String r104 = r101.toString();     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r104) == true) goto L12;
        r104 = r104.substring(0, r104.length() - 1);     // Catch: Exception -> L14
    L12:
        logEvent("wallet_ysf_bcard_list_show", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("ysf_bank_list", r104)}));     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("UnionPayBindCardLogger#walletYsfBcardListShow", e);
        CJBasicCommonUtils.logCatch("CJCatch", "UnionPayBindCardLogger#walletYsfBcardListShow", e);
    }

    public final void walletYsfBcardClick(String r100, String r101, String r102, String r103, ArrayList<UnionPayBankBean> r104) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r102, "errorCode");
        Intrinsics.checkNotNullParameter(r103, "errorMessage");
        Intrinsics.checkNotNullParameter(r104, "cardListBean");
        JSONArray r105 = new JSONArray();
        Iterator<T> r106 = r104.iterator();     // Catch: JSONException -> L8
    L5:
        if (r106.hasNext() == false) goto L10;
        r105.put(((UnionPayBankBean) r106.next()).bank_name);     // Catch: JSONException -> L8
    L10:
        logEvent("wallet_ysf_bcard_click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("button_name", r100), TuplesKt.to("result", r101), TuplesKt.to("error_code", r102), TuplesKt.to("error_message", r103), TuplesKt.to("ysf_card_list", r105)}));
        return;
    L8:
        e = move-exception;
        CJBasicCommonUtils.logCatch("CJCatch", "UnionPayBindCardLogger#walletYsfBcardClick", e);
        CJBasicCommonUtils.reportCatchException("UnionPayBindCardLogger#walletYsfBcardClick", e);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void walletYsfBcardClick$default(UnionPayBindCardLogger r100, String r101, String r102, String r110, String r111, ArrayList r112, int r113, Object r114) {
        if ((r113 & 2) == 0) goto L5;
        String r103 = "";
    L7:
        if ((r113 & 4) == 0) goto L9;
        String r104 = "";
    L11:
        if ((r113 & 8) == 0) goto L13;
        String r105 = "";
    L15:
        if ((r113 & 16) == 0) goto L17;
        r112 = new ArrayList();
    L17:
        r100.walletYsfBcardClick(r101, r103, r104, r105, r112);
        return;
    L13:
        r105 = r111;
        goto L15
    L9:
        r104 = r110;
        goto L11
    L5:
        r103 = r102;
        goto L7
    }
}
