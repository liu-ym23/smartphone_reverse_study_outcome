package com.android.ttcjpaysdk.largeamount.presenter;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.largeamount.LargeAmountContract;
import com.android.ttcjpaysdk.largeamount.LargeAmountModel;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJB\u0010\u000f\u001a\u00020\u00062\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0012`\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/largeamount/presenter/CJPayLargeAmountPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/largeamount/LargeAmountModel;", "Lcom/android/ttcjpaysdk/largeamount/LargeAmountContract$TradeQueryByVerifyIdentity;", "()V", "fetchVerifyIdentityInfo", "", "processId", "", "merchantId", "appId", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "payType", "", "tradeQueryByVerifyIdentity", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "base-pay-largeamount_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayLargeAmountPresenter extends BasePresenter<LargeAmountModel, LargeAmountContract.TradeQueryByVerifyIdentity> {
    public CJPayLargeAmountPresenter() {
    }

    public final void tradeQueryByVerifyIdentity(HashMap<String, Object> r100, String r101, String r110, CJPayHostInfo r111) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "merchantId");
        Intrinsics.checkNotNullParameter(r110, "appId");
        Intrinsics.checkNotNullParameter(r111, "hostInfo");
        LargeAmountModel r102 = getModel();
        if (r102 == null) goto L6;
        r102.tradeQueryByVerifyIdentity(r100, r101, r110, r111, new C92811(this));
        return;
    }

    public final void fetchVerifyIdentityInfo(String r100, String r101, String r110, CJPayHostInfo r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "processId");
        Intrinsics.checkNotNullParameter(r101, "merchantId");
        Intrinsics.checkNotNullParameter(r110, "appId");
        Intrinsics.checkNotNullParameter(r111, "hostInfo");
        HashMap<String, Object> r102 = new HashMap();
        if (r112 != 0) goto L5;
        String r113 = "query_member_identity";
    L6:
        r102.put(e.f25671s, r113);
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(new JSONObject().put(CrashHianalyticsData.PROCESS_ID, r100));     // Catch: Throwable -> L9
    L12:
        if (Result.m9456isSuccessimpl(r103) == false) goto L14;
        r102.put("exts", (JSONObject) r103);
    L14:
        LargeAmountModel r104 = getModel();
        if (r104 == null) goto L20;
        r104.fetchVerifyInfo(r102, r101, r110, r111, new AnonymousClass1(this));
        return;
    L20:
        return;
    L9:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L5:
        r113 = "query_member_face";
        goto L6
    }
}
