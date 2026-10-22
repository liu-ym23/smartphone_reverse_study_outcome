package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.OfficialRoomInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/OfficialRoomInfo;", "", "()V", "isShowMoreAnchor", "", "()Z", "setShowMoreAnchor", "(Z)V", "isUseServerSubtitle", "setUseServerSubtitle", "serverSubtitle", "", "getServerSubtitle", "()Ljava/lang/String;", "setServerSubtitle", "(Ljava/lang/String;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OfficialRoomInfo implements h {

    @SerializedName("is_show_more_anchor")
    protected boolean isShowMoreAnchor;

    @SerializedName("is_use_server_subtitle")
    protected boolean isUseServerSubtitle;

    @SerializedName("server_subtitle")
    protected String serverSubtitle;

    public OfficialRoomInfo() {
    }

    public OfficialRoomInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.isShowMoreAnchor = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.isUseServerSubtitle = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.serverSubtitle = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final String getServerSubtitle() {
        return this.serverSubtitle;
    }

    public final boolean isShowMoreAnchor() {
        return this.isShowMoreAnchor;
    }

    public final boolean isUseServerSubtitle() {
        return this.isUseServerSubtitle;
    }

    public final void setServerSubtitle(String r100) {
        this.serverSubtitle = r100;
    }

    public final void setShowMoreAnchor(boolean r100) {
        this.isShowMoreAnchor = r100;
    }

    public final void setUseServerSubtitle(boolean r100) {
        this.isUseServerSubtitle = r100;
    }
}
