package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.AGMatchInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/AGMatchInfo;", "", "()V", "l_country", "", "getL_country", "()Ljava/lang/String;", "setL_country", "(Ljava/lang/String;)V", "l_country_img_url", "getL_country_img_url", "setL_country_img_url", "l_score", "", "getL_score", "()Ljava/lang/Long;", "setL_score", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "r_country", "getR_country", "setR_country", "r_country_img_url", "getR_country_img_url", "setR_country_img_url", "r_score", "getR_score", "setR_score", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AGMatchInfo implements h {

    @SerializedName("l_country")
    protected String l_country;

    @SerializedName("l_country_img_url")
    protected String l_country_img_url;

    @SerializedName("l_score")
    protected Long l_score;

    @SerializedName("r_country")
    protected String r_country;

    @SerializedName("r_country_img_url")
    protected String r_country_img_url;

    @SerializedName("r_score")
    protected Long r_score;

    public AGMatchInfo() {
    }

    public final String getL_country() {
        return this.l_country;
    }

    public final String getL_country_img_url() {
        return this.l_country_img_url;
    }

    public final Long getL_score() {
        return this.l_score;
    }

    public final String getR_country() {
        return this.r_country;
    }

    public final String getR_country_img_url() {
        return this.r_country_img_url;
    }

    public final Long getR_score() {
        return this.r_score;
    }

    public AGMatchInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.r_country_img_url = am3.h.c(r100);
        goto L3
    L8:
        this.l_country_img_url = am3.h.c(r100);
        goto L3
    L9:
        this.r_score = Long.valueOf(r100.j());
        goto L3
    L10:
        this.l_score = Long.valueOf(r100.j());
        goto L3
    L11:
        this.r_country = am3.h.c(r100);
        goto L3
    L12:
        this.l_country = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }

    public final void setL_country(String r100) {
        this.l_country = r100;
    }

    public final void setL_country_img_url(String r100) {
        this.l_country_img_url = r100;
    }

    public final void setL_score(Long r100) {
        this.l_score = r100;
    }

    public final void setR_country(String r100) {
        this.r_country = r100;
    }

    public final void setR_country_img_url(String r100) {
        this.r_country_img_url = r100;
    }

    public final void setR_score(Long r100) {
        this.r_score = r100;
    }
}
