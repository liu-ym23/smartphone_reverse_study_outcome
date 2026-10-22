package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.News")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/News;", "", "()V", "link_info", "Lcom/bytedance/android/livesdk/message/model/ag/LinkInfo;", "getLink_info", "()Lcom/bytedance/android/livesdk/message/model/ag/LinkInfo;", "setLink_info", "(Lcom/bytedance/android/livesdk/message/model/ag/LinkInfo;)V", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", BdpAppEventConstant.PARAMS_UNIQUEID, "getUnique_id", "setUnique_id", "update_time_ms", "", "getUpdate_time_ms", "()J", "setUpdate_time_ms", "(J)V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class News implements h {

    @SerializedName("link_info")
    protected LinkInfo link_info;

    @SerializedName("title")
    protected String title;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    protected String unique_id;

    @SerializedName("update_time_ms")
    protected long update_time_ms;

    public News() {
    }

    public final LinkInfo getLink_info() {
        return this.link_info;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUnique_id() {
        return this.unique_id;
    }

    public final long getUpdate_time_ms() {
        return this.update_time_ms;
    }

    public News(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.title = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.update_time_ms = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.link_info = new LinkInfo(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.unique_id = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setLink_info(LinkInfo r100) {
        this.link_info = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUnique_id(String r100) {
        this.unique_id = r100;
    }

    public final void setUpdate_time_ms(long r100) {
        this.update_time_ms = r100;
    }
}
