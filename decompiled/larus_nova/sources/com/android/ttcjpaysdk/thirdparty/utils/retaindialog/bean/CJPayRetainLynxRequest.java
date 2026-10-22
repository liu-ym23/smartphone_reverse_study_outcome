package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainLynxRequest;", "", "apiData", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayLynxDialogApiData;", ControlRule.KEY_EXTRA_DATA, "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayLynxDialogExtraData;", "(Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayLynxDialogApiData;Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayLynxDialogExtraData;)V", "getApiData", "()Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayLynxDialogApiData;", "getExtraData", "()Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayLynxDialogExtraData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRetainLynxRequest {
    private final CJPayLynxDialogApiData apiData;
    private final CJPayLynxDialogExtraData extraData;

    public static /* synthetic */ CJPayRetainLynxRequest copy$default(CJPayRetainLynxRequest r100, CJPayLynxDialogApiData r101, CJPayLynxDialogExtraData r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.apiData;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.extraData;
    L9:
        return r100.copy(r101, r102);
    }

    public final CJPayLynxDialogApiData component1() {
        return this.apiData;
    }

    public final CJPayLynxDialogExtraData component2() {
        return this.extraData;
    }

    public final CJPayRetainLynxRequest copy(CJPayLynxDialogApiData r100, CJPayLynxDialogExtraData r101) {
        Intrinsics.checkNotNullParameter(r100, "apiData");
        Intrinsics.checkNotNullParameter(r101, ControlRule.KEY_EXTRA_DATA);
        return new CJPayRetainLynxRequest(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJPayRetainLynxRequest) == true) goto L8;
        return false;
    L8:
        CJPayRetainLynxRequest r101 = (CJPayRetainLynxRequest) r100;
        if (Intrinsics.areEqual(this.apiData, r101.apiData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraData, r101.extraData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.apiData.hashCode() * 31) + this.extraData.hashCode();
    }

    public String toString() {
        return "CJPayRetainLynxRequest(apiData=" + this.apiData + ", extraData=" + this.extraData + ')';
    }

    public final CJPayLynxDialogApiData getApiData() {
        return this.apiData;
    }

    public final CJPayLynxDialogExtraData getExtraData() {
        return this.extraData;
    }

    public CJPayRetainLynxRequest(CJPayLynxDialogApiData r100, CJPayLynxDialogExtraData r101) {
        Intrinsics.checkNotNullParameter(r100, "apiData");
        Intrinsics.checkNotNullParameter(r101, ControlRule.KEY_EXTRA_DATA);
        this.apiData = r100;
        this.extraData = r101;
    }
}
