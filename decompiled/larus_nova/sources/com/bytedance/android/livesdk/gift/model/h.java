package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/h;", "", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h implements vh7.h {

    @SerializedName("consume_scene")
    protected long _$$consumeScene;

    @SerializedName("extra")
    protected String _$$extra;

    @SerializedName("goods")
    protected u0 _$$goods;

    public h() {
        this._$$goods = new u0();
        this._$$extra = "";
        this._$$consumeScene = 0;
    }

    public final long a() {
        return this._$$consumeScene;
    }

    public final String b() {
        return this._$$extra;
    }

    public final u0 c() {
        return this._$$goods;
    }

    public h(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        if (r103 != 1) goto L7;
        this._$$goods = new u0(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this._$$extra = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L10;
        this._$$consumeScene = r100.j();
        r102 = r102 | true;
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this._$$goods != null) goto L18;
        this._$$goods = new u0();
    L18:
        if (this._$$extra != null) goto L21;
        this._$$extra = "";
    L21:
        if ((r102 & true) == true) goto L36;
        this._$$consumeScene = 0;
        return;
    }
}
