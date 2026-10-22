package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.feed.constant.OpenFeedConstantKt;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.OfChannelShowlistSyncData")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ug;", "", "", "_channelUid", "J", "", "_channelOpenId", "Ljava/lang/String;", "_channelAnchorId", "_channelAnchorOpenId", "showListText", "showListSchema", "showListName", "channelName", "showListId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ug implements vh7.h {

    @SerializedName("channel_anchor_id")
    public long _channelAnchorId;

    @SerializedName("channel_anchor_open_id")
    public String _channelAnchorOpenId;

    @SerializedName("channel_openid")
    public String _channelOpenId;

    @SerializedName("channel_uid")
    public long _channelUid;

    @SerializedName(OpenFeedConstantKt.KEY_CHANNEL_NAME)
    public String channelName;

    @SerializedName("showlist_id")
    public long showListId;

    @SerializedName("showlist_name")
    public String showListName;

    @SerializedName("showlist_schema")
    public String showListSchema;

    @SerializedName("showlist_text")
    public String showListText;

    public ug() {
        this._channelOpenId = "0";
        this._channelAnchorOpenId = "0";
        this.showListText = "";
        this.showListSchema = "";
        this.showListName = "";
        this.channelName = "";
    }

    public ug(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L20;
        if (r102 != 5000) goto L8;
        this._channelOpenId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 5001) goto L9;
        this._channelAnchorOpenId = am3.h.c(r100);
        goto L3
    L9:
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L11:
        this.showListId = r100.j();
        goto L3
    L12:
        this.channelName = am3.h.c(r100);
        goto L3
    L13:
        this.showListName = am3.h.c(r100);
        goto L3
    L14:
        this.showListSchema = am3.h.c(r100);
        goto L3
    L15:
        this.showListText = am3.h.c(r100);
        goto L3
    L16:
        this._channelAnchorId = r100.j();
        goto L3
    L17:
        this._channelUid = r100.j();
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if (this._channelOpenId != null) goto L24;
        this._channelOpenId = "0";
    L24:
        if (this._channelAnchorOpenId != null) goto L27;
        this._channelAnchorOpenId = "0";
    L27:
        if (this.showListText != null) goto L30;
        this.showListText = "";
    L30:
        if (this.showListSchema != null) goto L33;
        this.showListSchema = "";
    L33:
        if (this.showListName != null) goto L36;
        this.showListName = "";
    L36:
        if (this.channelName != null) goto L63;
        this.channelName = "";
        return;
    }
}
