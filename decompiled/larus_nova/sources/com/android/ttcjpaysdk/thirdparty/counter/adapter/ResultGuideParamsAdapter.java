package com.android.ttcjpaysdk.thirdparty.counter.adapter;

import com.android.ttcjpaysdk.base.ui.data.CJPayResultGuideInfo;
import com.android.ttcjpaysdk.thirdparty.counter.data.CJPayCounterTradeQueryResponseBean;
import com.android.ttcjpaysdk.thirdparty.counter.fragment.CJPayFingerprintGuideFragment;
import com.android.ttcjpaysdk.thirdparty.data.CJPayBioOpenGuide;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/adapter/ResultGuideParamsAdapter;", "", "responseBean", "Lcom/android/ttcjpaysdk/thirdparty/counter/data/CJPayCounterTradeQueryResponseBean;", "(Lcom/android/ttcjpaysdk/thirdparty/counter/data/CJPayCounterTradeQueryResponseBean;)V", "guideParams", "Lcom/android/ttcjpaysdk/thirdparty/counter/fragment/CJPayFingerprintGuideFragment$ResultGuideParams;", "getGuideParams", "()Lcom/android/ttcjpaysdk/thirdparty/counter/fragment/CJPayFingerprintGuideFragment$ResultGuideParams;", "setGuideParams", "(Lcom/android/ttcjpaysdk/thirdparty/counter/fragment/CJPayFingerprintGuideFragment$ResultGuideParams;)V", "getResponseBean", "()Lcom/android/ttcjpaysdk/thirdparty/counter/data/CJPayCounterTradeQueryResponseBean;", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ResultGuideParamsAdapter {
    private CJPayFingerprintGuideFragment.ResultGuideParams guideParams;
    private final CJPayCounterTradeQueryResponseBean responseBean;

    public final CJPayFingerprintGuideFragment.ResultGuideParams getGuideParams() {
        return this.guideParams;
    }

    public final CJPayCounterTradeQueryResponseBean getResponseBean() {
        return this.responseBean;
    }

    public ResultGuideParamsAdapter(CJPayCounterTradeQueryResponseBean r100) {
        Intrinsics.checkNotNullParameter(r100, "responseBean");
        this.responseBean = r100;
        CJPayResultGuideInfo r101 = r100.result_guide_info;
        if (r101 == null) goto L5;
        String r102 = r101.guide_type;
    L7:
        if ("bio_guide".equals(r102) == false) goto L9;
        this.guideParams = new AnonymousClass1(this);
        return;
    L9:
        CJPayBioOpenGuide r103 = r100.bio_open_guide;
        boolean r104 = false;
        if (r103 != null) goto L12;
    L14:
        if (r104 == false) goto L18;
        this.guideParams = new AnonymousClass2(this);
        return;
    L18:
        return;
    L12:
        if (r103.show_guide != true) goto L14;
        r104 = true;
        goto L14
    L5:
        r102 = null;
        goto L7
    }

    public final void setGuideParams(CJPayFingerprintGuideFragment.ResultGuideParams r100) {
        this.guideParams = r100;
    }
}
