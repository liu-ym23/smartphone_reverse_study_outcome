package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.VideoBigCard")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001>B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010&\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010,\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR \u0010/\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR \u00102\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR \u00105\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010;\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\b¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/VideoBigCard;", "", "()V", "background_url", "", "getBackground_url", "()Ljava/lang/String;", "setBackground_url", "(Ljava/lang/String;)V", a.KEY_CARD_TYPE, "", "getCard_type", "()I", "setCard_type", "(I)V", "corner_mark", "Lcom/bytedance/android/livesdk/message/model/ag/VideoBigCard$CornerMark;", "getCorner_mark", "()Lcom/bytedance/android/livesdk/message/model/ag/VideoBigCard$CornerMark;", "setCorner_mark", "(Lcom/bytedance/android/livesdk/message/model/ag/VideoBigCard$CornerMark;)V", "cover_url", "getCover_url", "setCover_url", "extra", "getExtra", "setExtra", "is_match", "", "()Z", "set_match", "(Z)V", "link_info", "Lcom/bytedance/android/livesdk/message/model/ag/LinkInfo;", "getLink_info", "()Lcom/bytedance/android/livesdk/message/model/ag/LinkInfo;", "setLink_info", "(Lcom/bytedance/android/livesdk/message/model/ag/LinkInfo;)V", "stats_param", "Lcom/bytedance/android/livesdk/message/model/ag/StatsParam;", "getStats_param", "()Lcom/bytedance/android/livesdk/message/model/ag/StatsParam;", "setStats_param", "(Lcom/bytedance/android/livesdk/message/model/ag/StatsParam;)V", BdpAppEventConstant.PARAMS_SUB_TITLE, "getSub_title", "setSub_title", "title", "getTitle", d.f25925o, BdpAppEventConstant.PARAMS_UNIQUEID, "getUnique_id", "setUnique_id", "video_size", "Lcom/bytedance/android/livesdk/message/model/ag/VideoCardSize;", "getVideo_size", "()Lcom/bytedance/android/livesdk/message/model/ag/VideoCardSize;", "setVideo_size", "(Lcom/bytedance/android/livesdk/message/model/ag/VideoCardSize;)V", "video_source", "getVideo_source", "setVideo_source", "CornerMark", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoBigCard implements h {

    @SerializedName("background_url")
    protected String background_url;

    @SerializedName(a.KEY_CARD_TYPE)
    protected int card_type;

    @SerializedName("corner_mark")
    protected CornerMark corner_mark;

    @SerializedName("cover_url")
    protected String cover_url;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("is_match")
    protected boolean is_match;

    @SerializedName("link_info")
    protected LinkInfo link_info;

    @SerializedName("stats_param")
    protected StatsParam stats_param;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    protected String sub_title;

    @SerializedName("title")
    protected String title;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    protected String unique_id;

    @SerializedName("video_size")
    protected VideoCardSize video_size;

    @SerializedName("video_source")
    protected String video_source;

    @ProtoMessage("webcast.im.VideoBigCard.CornerMark")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/VideoBigCard$CornerMark;", "", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "type", "", "getType", "()I", "setType", "(I)V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CornerMark implements h {

        @SerializedName("show")
        protected boolean show;

        @SerializedName("type")
        protected int type;

        public CornerMark() {
        }

        public final boolean getShow() {
            return this.show;
        }

        public final int getType() {
            return this.type;
        }

        public CornerMark(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.type = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.show = am3.h.a(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final void setShow(boolean r100) {
            this.show = r100;
        }

        public final void setType(int r100) {
            this.type = r100;
        }
    }

    public VideoBigCard() {
    }

    public final String getBackground_url() {
        return this.background_url;
    }

    public final int getCard_type() {
        return this.card_type;
    }

    public final CornerMark getCorner_mark() {
        return this.corner_mark;
    }

    public final String getCover_url() {
        return this.cover_url;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final LinkInfo getLink_info() {
        return this.link_info;
    }

    public final StatsParam getStats_param() {
        return this.stats_param;
    }

    public final String getSub_title() {
        return this.sub_title;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUnique_id() {
        return this.unique_id;
    }

    public final VideoCardSize getVideo_size() {
        return this.video_size;
    }

    public final String getVideo_source() {
        return this.video_source;
    }

    public final boolean is_match() {
        return this.is_match;
    }

    public VideoBigCard(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        if (r102 != 255) goto L7;
        this.extra = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            default: goto L8;
        };
    L9:
        this.link_info = new LinkInfo(r100);
        goto L3
    L10:
        this.is_match = am3.h.a(r100);
        goto L3
    L11:
        this.video_source = am3.h.c(r100);
        goto L3
    L12:
        this.stats_param = new StatsParam(r100);
        goto L3
    L13:
        this.unique_id = am3.h.c(r100);
        goto L3
    L14:
        this.background_url = am3.h.c(r100);
        goto L3
    L15:
        this.video_size = new VideoCardSize(r100);
        goto L3
    L16:
        this.corner_mark = new CornerMark(r100);
        goto L3
    L17:
        this.sub_title = am3.h.c(r100);
        goto L3
    L18:
        this.title = am3.h.c(r100);
        goto L3
    L19:
        this.cover_url = am3.h.c(r100);
        goto L3
    L20:
        this.card_type = r100.i();
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L22:
        r100.d(r101);
    }

    public final void setBackground_url(String r100) {
        this.background_url = r100;
    }

    public final void setCard_type(int r100) {
        this.card_type = r100;
    }

    public final void setCorner_mark(CornerMark r100) {
        this.corner_mark = r100;
    }

    public final void setCover_url(String r100) {
        this.cover_url = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setLink_info(LinkInfo r100) {
        this.link_info = r100;
    }

    public final void setStats_param(StatsParam r100) {
        this.stats_param = r100;
    }

    public final void setSub_title(String r100) {
        this.sub_title = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUnique_id(String r100) {
        this.unique_id = r100;
    }

    public final void setVideo_size(VideoCardSize r100) {
        this.video_size = r100;
    }

    public final void setVideo_source(String r100) {
        this.video_source = r100;
    }

    public final void set_match(boolean r100) {
        this.is_match = r100;
    }
}
