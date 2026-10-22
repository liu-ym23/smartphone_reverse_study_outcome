package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/zj;", "", "", "publicAreaLevel", "I", "b", "()I", "setPublicAreaLevel", "(I)V", "giftLevel", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setGiftLevel", "localHotStrategy", "getLocalHotStrategy", "setLocalHotStrategy", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class zj implements vh7.h {

    @SerializedName("gift_level")
    protected int giftLevel;

    @SerializedName("local_hot_strategy")
    protected int localHotStrategy;

    @SerializedName("public_area_level")
    protected int publicAreaLevel;

    public zj() {
    }

    public final int a() {
        return this.giftLevel;
    }

    public final int b() {
        return this.publicAreaLevel;
    }

    public zj(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.localHotStrategy = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.publicAreaLevel = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.giftLevel = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
