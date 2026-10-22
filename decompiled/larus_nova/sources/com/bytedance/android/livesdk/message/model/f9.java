package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001b8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/message/model/f9;", "", "", "chestGameId", "J", "getChestGameId", "()J", "", "status", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "Lcom/bytedance/android/livesdk/message/model/ic;", "waitChestOpenInfo", "Lcom/bytedance/android/livesdk/message/model/ic;", "getWaitChestOpenInfo", "()Lcom/bytedance/android/livesdk/message/model/ic;", "Lcom/bytedance/android/livesdk/message/model/w6;", "chestOpenedInfo", "Lcom/bytedance/android/livesdk/message/model/w6;", "getChestOpenedInfo", "()Lcom/bytedance/android/livesdk/message/model/w6;", "Lcom/bytedance/android/livesdk/message/model/p6;", "cardEffectiveInfo", "Lcom/bytedance/android/livesdk/message/model/p6;", "getCardEffectiveInfo", "()Lcom/bytedance/android/livesdk/message/model/p6;", "", "extra", "Ljava/lang/String;", "getExtra", "()Ljava/lang/String;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f9 implements vh7.h {

    @SerializedName("card_effective_info")
    protected p6 cardEffectiveInfo;

    @SerializedName("chest_game_id")
    protected long chestGameId;

    @SerializedName("chest_opened_info")
    protected w6 chestOpenedInfo;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("status")
    protected int status;

    @SerializedName("wait_chest_open_info")
    protected ic waitChestOpenInfo;

    public f9() {
        this.extra = "";
    }

    public final int a() {
        return this.status;
    }

    public f9(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.chestGameId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.status = r100.i();
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this.waitChestOpenInfo = new ic(r100);
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this.chestOpenedInfo = new w6(r100);
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this.cardEffectiveInfo = new p6(r100);
        goto L3
    L16:
        if (r102 != 100) goto L17;
        this.extra = am3.h.c(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this.extra != null) goto L49;
        this.extra = "";
        return;
    }
}
