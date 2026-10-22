package com.bytedance.android.livesdkapi.depend.model.broadcast;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemBubbleInfo;", "", "()V", "bubble", "", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/CommonBubble;", "getBubble", "()Ljava/util/List;", "setBubble", "(Ljava/util/List;)V", "showItemId", "", "getShowItemId", "()Ljava/lang/String;", "setShowItemId", "(Ljava/lang/String;)V", "showPatch", "getShowPatch", "setShowPatch", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ItemBubbleInfo implements h {

    @SerializedName("bubbles")
    protected List<CommonBubble> bubble;

    @SerializedName("show_item_id")
    protected String showItemId;

    @SerializedName("show_path")
    protected String showPatch;

    public ItemBubbleInfo() {
        this.showPatch = "";
        this.showItemId = "";
        this.bubble = new ArrayList();
    }

    public final List<CommonBubble> getBubble() {
        return this.bubble;
    }

    public final String getShowItemId() {
        return this.showItemId;
    }

    public final String getShowPatch() {
        return this.showPatch;
    }

    public ItemBubbleInfo(g r100) {
        this.bubble = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.showPatch = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.showItemId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.bubble.add(new CommonBubble(r100));
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.showPatch != null) goto L19;
        this.showPatch = "";
    L19:
        if (this.showItemId != null) goto L22;
        this.showItemId = "";
    L22:
        if (this.bubble.isEmpty() == false) goto L37;
        this.bubble = new ArrayList();
        return;
    }

    public final void setBubble(List<CommonBubble> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bubble = r100;
    }

    public final void setShowItemId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.showItemId = r100;
    }

    public final void setShowPatch(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.showPatch = r100;
    }
}
