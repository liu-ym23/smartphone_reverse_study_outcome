package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/u0;", "", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class u0 implements vh7.h {

    @SerializedName("name")
    protected String _$$goodsName;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_GOODS_TYPE)
    protected long _$$goodsType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_GOODS_ID)
    protected long _$$id;

    public u0() {
        this._$$id = 0;
        this._$$goodsType = 0;
        this._$$goodsName = "";
    }

    public final long a() {
        return this._$$goodsType;
    }

    public final long b() {
        return this._$$id;
    }

    public u0(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        if (r103 != 1) goto L7;
        this._$$id = r100.j();
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this._$$goodsType = r100.j();
        r102 = r102 | 2;
        goto L3
    L9:
        if (r103 != 3) goto L10;
        this._$$goodsName = am3.h.c(r100);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L18;
        this._$$id = 0;
    L18:
        if ((r102 & 2) != 0) goto L21;
        this._$$goodsType = 0;
    L21:
        if (this._$$goodsName != null) goto L36;
        this._$$goodsName = "";
        return;
    }
}
