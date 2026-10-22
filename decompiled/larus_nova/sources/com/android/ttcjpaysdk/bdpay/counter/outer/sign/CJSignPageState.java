package com.android.ttcjpaysdk.bdpay.counter.outer.sign;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.AssetInfo;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJPaySignInfoQueryResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/CJSignPageState;", "", "signInfoBean", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse;", "selectedAsset", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/AssetInfo;", "(Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse;Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/AssetInfo;)V", "getSelectedAsset", "()Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/AssetInfo;", "setSelectedAsset", "(Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/AssetInfo;)V", "getSignInfoBean", "()Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse;", "setSignInfoBean", "(Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJSignPageState {
    private AssetInfo selectedAsset;
    private CJPaySignInfoQueryResponse signInfoBean;

    public static /* synthetic */ CJSignPageState copy$default(CJSignPageState r100, CJPaySignInfoQueryResponse r101, AssetInfo r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.signInfoBean;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.selectedAsset;
    L9:
        return r100.copy(r101, r102);
    }

    public final CJPaySignInfoQueryResponse component1() {
        return this.signInfoBean;
    }

    public final AssetInfo component2() {
        return this.selectedAsset;
    }

    public final CJSignPageState copy(CJPaySignInfoQueryResponse r100, AssetInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "signInfoBean");
        return new CJSignPageState(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJSignPageState) == true) goto L8;
        return false;
    L8:
        CJSignPageState r101 = (CJSignPageState) r100;
        if (Intrinsics.areEqual(this.signInfoBean, r101.signInfoBean) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.selectedAsset, r101.selectedAsset) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.signInfoBean.hashCode() * 31;
        AssetInfo r101 = this.selectedAsset;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "CJSignPageState(signInfoBean=" + this.signInfoBean + ", selectedAsset=" + this.selectedAsset + ')';
    }

    public final AssetInfo getSelectedAsset() {
        return this.selectedAsset;
    }

    public final CJPaySignInfoQueryResponse getSignInfoBean() {
        return this.signInfoBean;
    }

    public final void setSelectedAsset(AssetInfo r100) {
        this.selectedAsset = r100;
    }

    public final void setSignInfoBean(CJPaySignInfoQueryResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.signInfoBean = r100;
    }

    public CJSignPageState(CJPaySignInfoQueryResponse r100, AssetInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "signInfoBean");
        this.signInfoBean = r100;
        this.selectedAsset = r101;
    }
}
