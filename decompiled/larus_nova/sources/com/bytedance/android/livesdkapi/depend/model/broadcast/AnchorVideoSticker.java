package com.bytedance.android.livesdkapi.depend.model.broadcast;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.anchor.VideoSticker")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/AnchorVideoSticker;", "", "()V", RuleConditionBean.BIZ_DATA_KEY, "", "getBizData", "()Ljava/lang/String;", "setBizData", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "metaData", "getMetaData", "setMetaData", "stickerId", "getStickerId", "setStickerId", "stickerTypeId", "", "getStickerTypeId", "()Ljava/lang/Long;", "setStickerTypeId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "title", "getTitle", d.f25925o, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorVideoSticker implements h {

    @SerializedName("biz_data")
    protected String bizData;

    @SerializedName("icon_url")
    protected String iconUrl;

    @SerializedName("meta_data")
    protected String metaData;

    @SerializedName("sticker_id")
    protected String stickerId;

    @SerializedName("sticker_type_id")
    protected Long stickerTypeId;

    @SerializedName("title")
    protected String title;

    public AnchorVideoSticker() {
    }

    public final String getBizData() {
        return this.bizData;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getMetaData() {
        return this.metaData;
    }

    public final String getStickerId() {
        return this.stickerId;
    }

    public final Long getStickerTypeId() {
        return this.stickerTypeId;
    }

    public final String getTitle() {
        return this.title;
    }

    public AnchorVideoSticker(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.stickerTypeId = Long.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.stickerId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.iconUrl = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this.title = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this.bizData = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 9) goto L17;
        this.metaData = am3.h.c(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
    }

    public final void setBizData(String r100) {
        this.bizData = r100;
    }

    public final void setIconUrl(String r100) {
        this.iconUrl = r100;
    }

    public final void setMetaData(String r100) {
        this.metaData = r100;
    }

    public final void setStickerId(String r100) {
        this.stickerId = r100;
    }

    public final void setStickerTypeId(Long r100) {
        this.stickerTypeId = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
