package com.bytedance.android.livesdk.interactivity.api.barrage.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/l;", "", "", "playType", "I", "getPlayType", "()I", "setPlayType", "(I)V", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/h;", "ecomRedPacket", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/h;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/h;", "setEcomRedPacket", "(Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/h;)V", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l implements vh7.h {

    @SerializedName("ecom_red_packet")
    protected h ecomRedPacket;

    @SerializedName("play_type")
    protected int playType;

    public l() {
    }

    public final h a() {
        return this.ecomRedPacket;
    }

    public l(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.playType = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.ecomRedPacket = new h(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
