package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeBaseInfo;", "", "()V", "delivery", "", "paidLiveType", "viewRight", "hasViewRight", "", "isDelivery", "needDelivery", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PrivilegeBaseInfo implements h {

    @SerializedName("delivery")
    public int delivery;

    @SerializedName(PaidReplayConstants.KEY_PRIVILEGE_TYPE)
    public int paidLiveType;

    @SerializedName("view_right")
    public int viewRight;

    public PrivilegeBaseInfo() {
    }

    public final boolean hasViewRight() {
        if (this.viewRight == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isDelivery() {
        if (this.delivery == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean needDelivery() {
        if (this.viewRight == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.delivery != 0) goto L7;
        return true;
    }

    public PrivilegeBaseInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.paidLiveType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.viewRight = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.delivery = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
