package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data;

import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyPayMethodTuple;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003JV\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016¨\u0006'"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayParams;", "", "currentMethod", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "currentAsset", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "response", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayResponseSlice;", "promotionScene", "", "panelViewHeight", "", "teaSource", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayResponseSlice;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCurrentAsset", "()Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "getCurrentMethod", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "getPanelViewHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPromotionScene", "()Ljava/lang/String;", "getResponse", "()Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayResponseSlice;", "getTeaSource", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayResponseSlice;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPrePayParams;", "equals", "", "other", "hashCode", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPrePayParams {
    private final AssetInfoBean currentAsset;
    private final CJUnifyPayMethodTuple currentMethod;
    private final Integer panelViewHeight;
    private final String promotionScene;
    private final CJUnifyPrePayResponseSlice response;
    private final String teaSource;

    public CJUnifyPrePayParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CJUnifyPrePayParams copy$default(CJUnifyPrePayParams r100, CJUnifyPayMethodTuple r101, AssetInfoBean r102, CJUnifyPrePayResponseSlice r103, String r104, Integer r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.currentMethod;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.currentAsset;
    L8:
        AssetInfoBean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.response;
    L11:
        CJUnifyPrePayResponseSlice r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.promotionScene;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.panelViewHeight;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.teaSource;
    L20:
        CJUnifyPayMethodTuple r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final CJUnifyPayMethodTuple component1() {
        return this.currentMethod;
    }

    public final AssetInfoBean component2() {
        return this.currentAsset;
    }

    public final CJUnifyPrePayResponseSlice component3() {
        return this.response;
    }

    public final String component4() {
        return this.promotionScene;
    }

    public final Integer component5() {
        return this.panelViewHeight;
    }

    public final String component6() {
        return this.teaSource;
    }

    public final CJUnifyPrePayParams copy(CJUnifyPayMethodTuple r100, AssetInfoBean r110, CJUnifyPrePayResponseSlice r111, String r112, Integer r113, String r114) {
        return new CJUnifyPrePayParams(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJUnifyPrePayParams) == true) goto L8;
        return false;
    L8:
        CJUnifyPrePayParams r101 = (CJUnifyPrePayParams) r100;
        if (Intrinsics.areEqual(this.currentMethod, r101.currentMethod) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.currentAsset, r101.currentAsset) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.response, r101.response) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.promotionScene, r101.promotionScene) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.panelViewHeight, r101.panelViewHeight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.teaSource, r101.teaSource) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        CJUnifyPayMethodTuple r100 = this.currentMethod;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        AssetInfoBean r104 = this.currentAsset;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CJUnifyPrePayResponseSlice r107 = this.response;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.promotionScene;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.panelViewHeight;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.teaSource;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CJUnifyPrePayParams(currentMethod=" + this.currentMethod + ", currentAsset=" + this.currentAsset + ", response=" + this.response + ", promotionScene=" + this.promotionScene + ", panelViewHeight=" + this.panelViewHeight + ", teaSource=" + this.teaSource + ')';
    }

    public final AssetInfoBean getCurrentAsset() {
        return this.currentAsset;
    }

    public final CJUnifyPayMethodTuple getCurrentMethod() {
        return this.currentMethod;
    }

    public final Integer getPanelViewHeight() {
        return this.panelViewHeight;
    }

    public final String getPromotionScene() {
        return this.promotionScene;
    }

    public final CJUnifyPrePayResponseSlice getResponse() {
        return this.response;
    }

    public final String getTeaSource() {
        return this.teaSource;
    }

    public CJUnifyPrePayParams(CJUnifyPayMethodTuple r100, AssetInfoBean r101, CJUnifyPrePayResponseSlice r102, String r103, Integer r104, String r105) {
        this.currentMethod = r100;
        this.currentAsset = r101;
        this.response = r102;
        this.promotionScene = r103;
        this.panelViewHeight = r104;
        this.teaSource = r105;
    }

    public /* synthetic */ CJUnifyPrePayParams(CJUnifyPayMethodTuple r100, AssetInfoBean r101, CJUnifyPrePayResponseSlice r102, String r103, Integer r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        CJUnifyPayMethodTuple r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        AssetInfoBean r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        CJUnifyPrePayResponseSlice r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Integer r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
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
