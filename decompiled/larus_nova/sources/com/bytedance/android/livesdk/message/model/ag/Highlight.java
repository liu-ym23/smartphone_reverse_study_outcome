package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.Highlight")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/Highlight;", "", "()V", "cover_img_url", "", "getCover_img_url", "()Ljava/lang/String;", "setCover_img_url", "(Ljava/lang/String;)V", "group_name", "getGroup_name", "setGroup_name", "highlight_type", "", "getHighlight_type", "()I", "setHighlight_type", "(I)V", "item_id", "getItem_id", "setItem_id", "play_time_ms", "", "getPlay_time_ms", "()J", "setPlay_time_ms", "(J)V", ShareConstants.REPLAY_ID, "getReplay_id", "setReplay_id", "title", "getTitle", d.f25925o, BdpAppEventConstant.PARAMS_UNIQUEID, "getUnique_id", "setUnique_id", "video_source", "getVideo_source", "setVideo_source", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Highlight implements h {

    @SerializedName("cover_img_url")
    protected String cover_img_url;

    @SerializedName("group_name")
    protected String group_name;

    @SerializedName("highlight_type")
    protected int highlight_type;

    @SerializedName("item_id")
    protected String item_id;

    @SerializedName("play_time_ms")
    protected long play_time_ms;

    @SerializedName(ShareConstants.REPLAY_ID)
    protected String replay_id;

    @SerializedName("title")
    protected String title;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    protected String unique_id;

    @SerializedName("video_source")
    protected String video_source;

    public Highlight() {
    }

    public final String getCover_img_url() {
        return this.cover_img_url;
    }

    public final String getGroup_name() {
        return this.group_name;
    }

    public final int getHighlight_type() {
        return this.highlight_type;
    }

    public final String getItem_id() {
        return this.item_id;
    }

    public final long getPlay_time_ms() {
        return this.play_time_ms;
    }

    public final String getReplay_id() {
        return this.replay_id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUnique_id() {
        return this.unique_id;
    }

    public final String getVideo_source() {
        return this.video_source;
    }

    public Highlight(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.group_name = am3.h.c(r100);
        goto L3
    L8:
        this.title = am3.h.c(r100);
        goto L3
    L9:
        this.play_time_ms = r100.j();
        goto L3
    L10:
        this.cover_img_url = am3.h.c(r100);
        goto L3
    L11:
        this.unique_id = am3.h.c(r100);
        goto L3
    L12:
        this.video_source = am3.h.c(r100);
        goto L3
    L13:
        this.replay_id = am3.h.c(r100);
        goto L3
    L14:
        this.item_id = am3.h.c(r100);
        goto L3
    L15:
        this.highlight_type = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }

    public final void setCover_img_url(String r100) {
        this.cover_img_url = r100;
    }

    public final void setGroup_name(String r100) {
        this.group_name = r100;
    }

    public final void setHighlight_type(int r100) {
        this.highlight_type = r100;
    }

    public final void setItem_id(String r100) {
        this.item_id = r100;
    }

    public final void setPlay_time_ms(long r100) {
        this.play_time_ms = r100;
    }

    public final void setReplay_id(String r100) {
        this.replay_id = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUnique_id(String r100) {
        this.unique_id = r100;
    }

    public final void setVideo_source(String r100) {
        this.video_source = r100;
    }
}
