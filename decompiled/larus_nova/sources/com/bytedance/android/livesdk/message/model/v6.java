package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/v6;", "", "", "cardColor", "Ljava/lang/String;", "getCardColor", "()Ljava/lang/String;", "cardUrl", "getCardUrl", "cardBgUrl", "getCardBgUrl", "cardMiniUrl", "getCardMiniUrl", "extra", "getExtra", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class v6 implements vh7.h {

    @SerializedName("card_bg_url")
    protected String cardBgUrl;

    @SerializedName("card_color")
    protected String cardColor;

    @SerializedName("card_mini_url")
    protected String cardMiniUrl;

    @SerializedName("card_url")
    protected String cardUrl;

    @SerializedName("extra")
    protected String extra;

    public v6() {
        this.extra = "";
    }

    public v6(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.cardColor = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.cardUrl = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.cardBgUrl = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.cardMiniUrl = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 100) goto L15;
        this.extra = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.extra != null) goto L43;
        this.extra = "";
        return;
    }
}
