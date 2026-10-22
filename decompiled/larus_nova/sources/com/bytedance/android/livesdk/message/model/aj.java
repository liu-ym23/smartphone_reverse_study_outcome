package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R$\u0010*\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R$\u0010-\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/aj;", "", "", "chorusId", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "setChorusId", "(Ljava/lang/Long;)V", "dressId", "b", "setDressId", "", "stage", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "d", "(Ljava/lang/Integer;)V", "", "chorusIdStr", "Ljava/lang/String;", "getChorusIdStr", "()Ljava/lang/String;", "setChorusIdStr", "(Ljava/lang/String;)V", "cdnSingerOnly", "J", "getCdnSingerOnly", "()J", "setCdnSingerOnly", "(J)V", "Lcom/bytedance/android/livesdk/message/model/ChorusConcertSong;", "concertSong", "Lcom/bytedance/android/livesdk/message/model/ChorusConcertSong;", "getConcertSong", "()Lcom/bytedance/android/livesdk/message/model/ChorusConcertSong;", "setConcertSong", "(Lcom/bytedance/android/livesdk/message/model/ChorusConcertSong;)V", "mainSingerLinkMicIdStr", "getMainSingerLinkMicIdStr", "setMainSingerLinkMicIdStr", "mainSingerUid", "getMainSingerUid", "setMainSingerUid", "openId", "getOpenId", "setOpenId", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class aj implements vh7.h {

    @SerializedName("cdn_singer_only")
    protected long cdnSingerOnly;

    @SerializedName("chorus_id")
    protected Long chorusId;

    @SerializedName("chorus_id_str")
    protected String chorusIdStr;

    @SerializedName("concert_song")
    protected ChorusConcertSong concertSong;

    @SerializedName("dress_id")
    protected Long dressId;

    @SerializedName("main_singer_linkmic_id_str")
    protected String mainSingerLinkMicIdStr;

    @SerializedName("main_singer_uid")
    protected String mainSingerUid;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openId;

    @SerializedName("stage")
    protected Integer stage;

    public final Long b() {
        Long r100 = this.dressId;
        if (r100 != null) goto L6;
    L7:
        Long r101 = this.dressId;
        if (r101 == null) goto L17;
        if (r101 == null) goto L15;
        if (r101.longValue() == 0) goto L17;
    L15:
        return this.dressId;
    L17:
        return com.bytedance.android.livesdk.n2.f153994a.getValue();
    L6:
        if (r100.longValue() == (-1)) goto L17;
        goto L7
    }

    public final String toString() {
        return "RTChorusInfo(chorusId=" + this.chorusId + ", dressId=" + b() + ", stage=" + this.stage + ", displayList=null)";
    }

    public aj() {
        this.stage = Integer.valueOf(RealTimeChorusStage.RealTimeChorusStage_Normal.getValue());
        this.chorusIdStr = "";
        this.mainSingerLinkMicIdStr = "";
        this.mainSingerUid = "";
        this.openId = "";
    }

    public final Long a() {
        return this.chorusId;
    }

    public final Integer c() {
        return this.stage;
    }

    public aj(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 5000) goto L7;
        this.openId = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        this.mainSingerUid = am3.h.c(r100);
        goto L3
    L10:
        this.mainSingerLinkMicIdStr = am3.h.c(r100);
        goto L3
    L11:
        this.concertSong = new ChorusConcertSong(r100);
        goto L3
    L12:
        this.cdnSingerOnly = r100.j();
        goto L3
    L13:
        this.chorusIdStr = am3.h.c(r100);
        goto L3
    L14:
        this.stage = Integer.valueOf(r100.i());
        goto L3
    L15:
        this.dressId = Long.valueOf(r100.j());
        goto L3
    L16:
        this.chorusId = Long.valueOf(r100.j());
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.stage != null) goto L22;
        this.stage = Integer.valueOf(RealTimeChorusStage.RealTimeChorusStage_Normal.getValue());
    L22:
        if (this.chorusIdStr != null) goto L25;
        this.chorusIdStr = "";
    L25:
        if (this.mainSingerLinkMicIdStr != null) goto L28;
        this.mainSingerLinkMicIdStr = "";
    L28:
        if (this.mainSingerUid != null) goto L31;
        this.mainSingerUid = "";
    L31:
        if (this.openId != null) goto L57;
        this.openId = "";
        return;
    }

    public final void d(Integer r100) {
        this.stage = r100;
    }
}
