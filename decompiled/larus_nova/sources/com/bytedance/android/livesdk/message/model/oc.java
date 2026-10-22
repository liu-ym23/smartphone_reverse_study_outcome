package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/oc;", "", "", "giftId", "J", "getGiftId", "()J", "", "giftName", "Ljava/lang/String;", "getGiftName", "()Ljava/lang/String;", "giftDiamondCount", "getGiftDiamondCount", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class oc implements vh7.h {

    @SerializedName("gift_diamond_count")
    protected long giftDiamondCount;

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    protected long giftId;

    @SerializedName("gift_name")
    protected String giftName;

    @SerializedName("icon")
    protected py.k icon;

    public oc() {
        this.giftName = "";
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public oc(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.giftId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.giftName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.giftDiamondCount = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.icon = vh7.f.a(r100, py.k.class);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.giftName != null) goto L37;
        this.giftName = "";
        return;
    }
}
