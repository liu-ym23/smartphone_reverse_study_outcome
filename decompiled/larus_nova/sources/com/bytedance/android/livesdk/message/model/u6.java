package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001a\u0010(\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006R\u001a\u0010*\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0014R\u001a\u0010,\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\rR\u001a\u0010.\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b/\u0010\r¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/u6;", "", "", "cardInstId", "J", "getCardInstId", "()J", "cardId", "getCardId", "", "cardName", "Ljava/lang/String;", "getCardName", "()Ljava/lang/String;", "cardDesc", "getCardDesc", "", "useType", "I", "getUseType", "()I", "effectType", "getEffectType", "Lcom/bytedance/android/livesdk/message/model/t6;", "effectTask", "Lcom/bytedance/android/livesdk/message/model/t6;", "getEffectTask", "()Lcom/bytedance/android/livesdk/message/model/t6;", "Lcom/bytedance/android/livesdk/message/model/v6;", "resource", "Lcom/bytedance/android/livesdk/message/model/v6;", "getResource", "()Lcom/bytedance/android/livesdk/message/model/v6;", "Lcom/bytedance/android/livesdk/message/model/s6;", "bonusInfo", "Lcom/bytedance/android/livesdk/message/model/s6;", "getBonusInfo", "()Lcom/bytedance/android/livesdk/message/model/s6;", "getTime", "getGetTime", "unuseExpireTime", "getUnuseExpireTime", "status", "getStatus", "showContent", "getShowContent", "extra", "getExtra", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class u6 implements vh7.h {

    @SerializedName("bonus_info")
    protected s6 bonusInfo;

    @SerializedName("card_desc")
    protected String cardDesc;

    @SerializedName("card_id")
    protected long cardId;

    @SerializedName("card_inst_id")
    protected long cardInstId;

    @SerializedName("card_name")
    protected String cardName;

    @SerializedName("effect_task")
    protected t6 effectTask;

    @SerializedName("effect_type")
    protected int effectType;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("get_time")
    protected long getTime;

    @SerializedName("resource")
    protected v6 resource;

    @SerializedName("show_content")
    protected String showContent;

    @SerializedName("status")
    protected int status;

    @SerializedName("unuse_expire_time")
    protected long unuseExpireTime;

    @SerializedName("use_type")
    protected int useType;

    public u6() {
        this.showContent = "";
        this.extra = "";
    }

    public u6(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L23;
        if (r102 != 100) goto L7;
        this.extra = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L9;
            default: goto L8;
        };
    L9:
        this.showContent = am3.h.c(r100);
        goto L3
    L10:
        this.status = r100.i();
        goto L3
    L11:
        this.unuseExpireTime = r100.j();
        goto L3
    L12:
        this.getTime = r100.j();
        goto L3
    L13:
        this.bonusInfo = new s6(r100);
        goto L3
    L14:
        this.resource = new v6(r100);
        goto L3
    L15:
        this.effectTask = new t6(r100);
        goto L3
    L16:
        this.effectType = r100.i();
        goto L3
    L17:
        this.useType = r100.i();
        goto L3
    L18:
        this.cardDesc = am3.h.c(r100);
        goto L3
    L19:
        this.cardName = am3.h.c(r100);
        goto L3
    L20:
        this.cardId = r100.j();
        goto L3
    L21:
        this.cardInstId = r100.j();
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L23:
        r100.d(r101);
        if (this.showContent != null) goto L27;
        this.showContent = "";
    L27:
        if (this.extra != null) goto L63;
        this.extra = "";
        return;
    }
}
