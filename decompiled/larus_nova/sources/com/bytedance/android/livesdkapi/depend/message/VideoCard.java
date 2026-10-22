package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.VideoCard")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/VideoCard;", "", "()V", "backgroundUrl", "", "cardId", "cardType", "", "coverUrl", "creatorId", "creatorOpenId", "getCreatorOpenId", "()Ljava/lang/String;", "epid", "linkType", "rid", "schema", "size", "Lcom/bytedance/android/livesdkapi/depend/message/VideoSize;", "subTitle", "tag", "title", "uid", "videoResource", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCard implements h {

    @SerializedName("background_url")
    public String backgroundUrl;

    @SerializedName("card_id")
    public String cardId;

    @SerializedName(a.KEY_CARD_TYPE)
    public int cardType;

    @SerializedName("cover_url")
    public String coverUrl;

    @SerializedName("creator_id")
    public String creatorId;

    @SerializedName("creator_open_id")
    protected String creatorOpenId;

    @SerializedName("epid")
    public String epid;

    @SerializedName("link_type")
    public int linkType;

    @SerializedName("rid")
    public String rid;

    @SerializedName("schema")
    public String schema;

    @SerializedName("size")
    public VideoSize size;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    public String subTitle;

    @SerializedName("tag")
    public String tag;

    @SerializedName("title")
    public String title;

    @SerializedName("uid")
    public String uid;

    @SerializedName("video_resource")
    public String videoResource;

    public VideoCard() {
        this.creatorOpenId = "";
    }

    public final String getCreatorOpenId() {
        return this.creatorOpenId;
    }

    public VideoCard(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L25;
        if (r102 != 5001) goto L7;
        this.creatorOpenId = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L9;
            default: goto L8;
        };
    L9:
        this.linkType = r100.i();
        goto L3
    L10:
        this.videoResource = am3.h.c(r100);
        goto L3
    L11:
        this.cardId = am3.h.c(r100);
        goto L3
    L12:
        this.backgroundUrl = am3.h.c(r100);
        goto L3
    L13:
        this.size = new VideoSize(r100);
        goto L3
    L14:
        this.creatorId = am3.h.c(r100);
        goto L3
    L15:
        this.tag = am3.h.c(r100);
        goto L3
    L16:
        this.epid = am3.h.c(r100);
        goto L3
    L17:
        this.rid = am3.h.c(r100);
        goto L3
    L18:
        this.uid = am3.h.c(r100);
        goto L3
    L19:
        this.subTitle = am3.h.c(r100);
        goto L3
    L20:
        this.title = am3.h.c(r100);
        goto L3
    L21:
        this.schema = am3.h.c(r100);
        goto L3
    L22:
        this.coverUrl = am3.h.c(r100);
        goto L3
    L23:
        this.cardType = r100.i();
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L25:
        r100.d(r101);
        if (this.creatorOpenId != null) goto L66;
        this.creatorOpenId = "";
        return;
    }
}
