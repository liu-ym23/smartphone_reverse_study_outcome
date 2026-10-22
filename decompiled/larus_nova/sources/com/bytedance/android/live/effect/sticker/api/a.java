package com.bytedance.android.live.effect.sticker.api;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.pchelper.VrTransferMaterialUpdateResp")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/api/a;", "", "", "errCode", "Ljava/lang/Integer;", "getErrCode", "()Ljava/lang/Integer;", "", "errMessage", "Ljava/lang/String;", "getErrMessage", "()Ljava/lang/String;", "<init>", "()V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("err_code")
    protected Integer errCode;

    @SerializedName("err_message")
    protected String errMessage;

    public a() {
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.errCode = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.errMessage = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
