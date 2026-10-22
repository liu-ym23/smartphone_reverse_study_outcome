package com.android.ttcjpaysdk.thirdparty.payagain.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/data/PayAgainAssetPayState;", "", "bankCardPointSwitch", "", "promotionScene", "", "(ZLjava/lang/String;)V", "getBankCardPointSwitch", "()Z", "setBankCardPointSwitch", "(Z)V", "getPromotionScene", "()Ljava/lang/String;", "setPromotionScene", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayAgainAssetPayState {
    private boolean bankCardPointSwitch;
    private String promotionScene;

    /* JADX WARN: Multi-variable type inference failed */
    public PayAgainAssetPayState() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PayAgainAssetPayState copy$default(PayAgainAssetPayState r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.bankCardPointSwitch;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.promotionScene;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.bankCardPointSwitch;
    }

    public final String component2() {
        return this.promotionScene;
    }

    public final PayAgainAssetPayState copy(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "promotionScene");
        return new PayAgainAssetPayState(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PayAgainAssetPayState) == true) goto L8;
        return false;
    L8:
        PayAgainAssetPayState r101 = (PayAgainAssetPayState) r100;
        if (this.bankCardPointSwitch == r101.bankCardPointSwitch) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.promotionScene, r101.promotionScene) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.bankCardPointSwitch == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.promotionScene.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "PayAgainAssetPayState(bankCardPointSwitch=" + this.bankCardPointSwitch + ", promotionScene=" + this.promotionScene + ')';
    }

    public final boolean getBankCardPointSwitch() {
        return this.bankCardPointSwitch;
    }

    public final String getPromotionScene() {
        return this.promotionScene;
    }

    public final void setBankCardPointSwitch(boolean r100) {
        this.bankCardPointSwitch = r100;
    }

    public final void setPromotionScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.promotionScene = r100;
    }

    public PayAgainAssetPayState(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "promotionScene");
        this.bankCardPointSwitch = r100;
        this.promotionScene = r101;
    }

    public /* synthetic */ PayAgainAssetPayState(boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
