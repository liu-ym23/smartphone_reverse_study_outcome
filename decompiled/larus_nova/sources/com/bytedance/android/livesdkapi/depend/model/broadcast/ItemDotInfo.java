package com.bytedance.android.livesdkapi.depend.model.broadcast;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;", "", "()V", "dot", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/CommonDot;", "getDot", "()Lcom/bytedance/android/livesdkapi/depend/model/broadcast/CommonDot;", "setDot", "(Lcom/bytedance/android/livesdkapi/depend/model/broadcast/CommonDot;)V", "showItemId", "", "getShowItemId", "()Ljava/lang/String;", "setShowItemId", "(Ljava/lang/String;)V", "showPath", "getShowPath", "setShowPath", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ItemDotInfo implements h {

    @SerializedName("dot")
    protected CommonDot dot;

    @SerializedName("show_item_id")
    protected String showItemId;

    @SerializedName("show_path")
    protected String showPath;

    public ItemDotInfo() {
        this.showPath = "";
        this.showItemId = "";
    }

    public final CommonDot getDot() {
        return this.dot;
    }

    public final String getShowItemId() {
        return this.showItemId;
    }

    public final String getShowPath() {
        return this.showPath;
    }

    public ItemDotInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.showPath = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.showItemId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.dot = new CommonDot(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.showPath != null) goto L19;
        this.showPath = "";
    L19:
        if (this.showItemId != null) goto L34;
        this.showItemId = "";
        return;
    }

    public final void setDot(CommonDot r100) {
        this.dot = r100;
    }

    public final void setShowItemId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.showItemId = r100;
    }

    public final void setShowPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.showPath = r100;
    }
}
