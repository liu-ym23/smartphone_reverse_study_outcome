package com.bytedance.android.livesdk.vipim;

import am3.g;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.api.nabob.NabobCustomerServiceEntranceResult.Data")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/vipim/VipIMResult;", "", "()V", "buttonText", "", SoloKtvContext.SOLO_PAGE_ENTRANCE, "", "schema", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VipIMResult implements h {

    @SerializedName("button_text")
    public String buttonText;

    @SerializedName(SoloKtvContext.SOLO_PAGE_ENTRANCE)
    public boolean entrance;

    @SerializedName("schema")
    public String schema;

    public VipIMResult() {
        this.schema = "";
        this.buttonText = "";
    }

    public VipIMResult(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.entrance = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.schema = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.buttonText = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.schema != null) goto L19;
        this.schema = "";
    L19:
        if (this.buttonText != null) goto L34;
        this.buttonText = "";
        return;
    }
}
