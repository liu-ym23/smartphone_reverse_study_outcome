package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/LinkInfo;", "", "()V", "link_type", "", "getLink_type", "()I", "setLink_type", "(I)V", "link_url", "", "getLink_url", "()Ljava/lang/String;", "setLink_url", "(Ljava/lang/String;)V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkInfo implements h {

    @SerializedName("link_type")
    protected int link_type;

    @SerializedName("link_url")
    protected String link_url;

    public LinkInfo() {
    }

    public final int getLink_type() {
        return this.link_type;
    }

    public final String getLink_url() {
        return this.link_url;
    }

    public LinkInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.link_type = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.link_url = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setLink_type(int r100) {
        this.link_type = r100;
    }

    public final void setLink_url(String r100) {
        this.link_url = r100;
    }
}
