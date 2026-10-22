package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.ShareAnchorInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u0004\b\t\u0010\u0007R\u001e\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShareAnchorInfo;", "", "()V", "isLatestAnchor", "", "()I", "setLatestAnchor", "(I)V", "isLowFansAnchor", "setLowFansAnchor", "isReflowAnchor", "setReflowAnchor", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareAnchorInfo implements h {

    @SerializedName("is_latest_anchor")
    protected int isLatestAnchor;

    @SerializedName("is_low_fans_anchor")
    protected int isLowFansAnchor;

    @SerializedName("is_reflow_anchor")
    protected int isReflowAnchor;

    public ShareAnchorInfo() {
    }

    public final int isLatestAnchor() {
        return this.isLatestAnchor;
    }

    public final int isLowFansAnchor() {
        return this.isLowFansAnchor;
    }

    public final int isReflowAnchor() {
        return this.isReflowAnchor;
    }

    public ShareAnchorInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.isLatestAnchor = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.isReflowAnchor = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.isLowFansAnchor = (int) r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setLatestAnchor(int r100) {
        this.isLatestAnchor = r100;
    }

    public final void setLowFansAnchor(int r100) {
        this.isLowFansAnchor = r100;
    }

    public final void setReflowAnchor(int r100) {
        this.isReflowAnchor = r100;
    }
}
