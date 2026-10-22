package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J[\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0003H\u0016R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayQueryGrowthDecisionResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "retCode", "", "retMsg", "growthModelViewList", "", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayGrowthModelView;", "exts", "", "commonParams", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)V", "getCommonParams", "()Ljava/util/Map;", "getExts", "getGrowthModelViewList", "()Ljava/util/List;", "getRetCode", "()Ljava/lang/String;", "getRetMsg", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayQueryGrowthDecisionResponse implements CJPayObject {
    private final Map<String, String> commonParams;
    private final Map<String, String> exts;
    private final List<CJPayGrowthModelView> growthModelViewList;
    private final String retCode;
    private final String retMsg;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CJPayQueryGrowthDecisionResponse copy$default(CJPayQueryGrowthDecisionResponse r100, String r101, String r102, List r103, Map r104, Map r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.retCode;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.retMsg;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.growthModelViewList;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.exts;
    L14:
        Map r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.commonParams;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.retCode;
    }

    public final String component2() {
        return this.retMsg;
    }

    public final List<CJPayGrowthModelView> component3() {
        return this.growthModelViewList;
    }

    public final Map<String, String> component4() {
        return this.exts;
    }

    public final Map<String, String> component5() {
        return this.commonParams;
    }

    public final CJPayQueryGrowthDecisionResponse copy(String r100, String r101, List<CJPayGrowthModelView> r110, Map<String, String> r111, Map<String, String> r112) {
        Intrinsics.checkNotNullParameter(r100, "retCode");
        Intrinsics.checkNotNullParameter(r101, "retMsg");
        Intrinsics.checkNotNullParameter(r111, "exts");
        Intrinsics.checkNotNullParameter(r112, "commonParams");
        return new CJPayQueryGrowthDecisionResponse(r100, r101, r110, r111, r112);
    }

    public int hashCode() {
        int r100 = ((this.retCode.hashCode() * 31) + this.retMsg.hashCode()) * 31;
        List<CJPayGrowthModelView> r101 = this.growthModelViewList;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((((r100 + r102) * 31) + this.exts.hashCode()) * 31) + this.commonParams.hashCode();
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "CJPayQueryGrowthDecisionResponse(retCode='" + this.retCode + "', retMsg='" + this.retMsg + "', growthModelViewList=" + this.growthModelViewList + ", exts=" + this.exts + ", commonParams=" + this.commonParams + ')';
    }

    public final Map<String, String> getCommonParams() {
        return this.commonParams;
    }

    public final Map<String, String> getExts() {
        return this.exts;
    }

    public final List<CJPayGrowthModelView> getGrowthModelViewList() {
        return this.growthModelViewList;
    }

    public final String getRetCode() {
        return this.retCode;
    }

    public final String getRetMsg() {
        return this.retMsg;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(CJPayQueryGrowthDecisionResponse.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean.CJPayQueryGrowthDecisionResponse");
        CJPayQueryGrowthDecisionResponse r102 = (CJPayQueryGrowthDecisionResponse) r100;
        if (Intrinsics.areEqual(this.retCode, r102.retCode) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.retMsg, r102.retMsg) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.growthModelViewList, r102.growthModelViewList) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.exts, r102.exts) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.commonParams, r102.commonParams) == true) goto L27;
        return false;
    L27:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public CJPayQueryGrowthDecisionResponse(String r100, String r101, List<CJPayGrowthModelView> r102, Map<String, String> r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r100, "retCode");
        Intrinsics.checkNotNullParameter(r101, "retMsg");
        Intrinsics.checkNotNullParameter(r103, "exts");
        Intrinsics.checkNotNullParameter(r104, "commonParams");
        this.retCode = r100;
        this.retMsg = r101;
        this.growthModelViewList = r102;
        this.exts = r103;
        this.commonParams = r104;
    }
}
