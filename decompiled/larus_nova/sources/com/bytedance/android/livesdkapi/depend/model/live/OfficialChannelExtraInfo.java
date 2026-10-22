package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/OfficialChannelExtraInfo;", "", "()V", "channelAnchorId", "", "getChannelAnchorId", "()Ljava/lang/String;", "setChannelAnchorId", "(Ljava/lang/String;)V", "channelName", "getChannelName", "setChannelName", "channelUid", "getChannelUid", "setChannelUid", "showListId", "", "getShowListId", "()J", "setShowListId", "(J)V", "showListName", "getShowListName", "setShowListName", "showListSchema", "getShowListSchema", "setShowListSchema", "showListText", "getShowListText", "setShowListText", "showStartTime", "getShowStartTime", "setShowStartTime", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OfficialChannelExtraInfo implements h {
    private String channelAnchorId;
    private String channelName;
    private String channelUid;

    @SerializedName("showlist_id")
    protected long showListId;

    @SerializedName("showlist_name")
    protected String showListName;

    @SerializedName("showlist_schema")
    protected String showListSchema;
    private String showListText;

    @SerializedName("show_start_ts")
    protected long showStartTime;

    public OfficialChannelExtraInfo() {
    }

    public final String getChannelAnchorId() {
        return this.channelAnchorId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final String getChannelUid() {
        return this.channelUid;
    }

    public final long getShowListId() {
        return this.showListId;
    }

    public final String getShowListName() {
        return this.showListName;
    }

    public final String getShowListSchema() {
        return this.showListSchema;
    }

    public final String getShowListText() {
        return this.showListText;
    }

    public final long getShowStartTime() {
        return this.showStartTime;
    }

    public OfficialChannelExtraInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.showStartTime = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.showListSchema = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.showListId = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.showListName = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setChannelAnchorId(String r100) {
        this.channelAnchorId = r100;
    }

    public final void setChannelName(String r100) {
        this.channelName = r100;
    }

    public final void setChannelUid(String r100) {
        this.channelUid = r100;
    }

    public final void setShowListId(long r100) {
        this.showListId = r100;
    }

    public final void setShowListName(String r100) {
        this.showListName = r100;
    }

    public final void setShowListSchema(String r100) {
        this.showListSchema = r100;
    }

    public final void setShowListText(String r100) {
        this.showListText = r100;
    }

    public final void setShowStartTime(long r100) {
        this.showStartTime = r100;
    }
}
