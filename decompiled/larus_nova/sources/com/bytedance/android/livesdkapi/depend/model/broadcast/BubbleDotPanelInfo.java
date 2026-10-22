package com.bytedance.android.livesdkapi.depend.model.broadcast;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/BubbleDotPanelInfo;", "", "()V", "itemBubbles", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemBubbleInfo;", "getItemBubbles", "()Ljava/util/Map;", "setItemBubbles", "(Ljava/util/Map;)V", "itemDots", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;", "getItemDots", "setItemDots", "show_path", "getShow_path", "()Ljava/lang/String;", "setShow_path", "(Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BubbleDotPanelInfo implements h {

    @SerializedName("item_bubbles")
    protected Map<String, ItemBubbleInfo> itemBubbles;

    @SerializedName("item_dots")
    protected Map<String, ItemDotInfo> itemDots;

    @SerializedName("show_path")
    protected String show_path;

    public BubbleDotPanelInfo() {
        this.show_path = "";
        this.itemDots = new LinkedHashMap();
        this.itemBubbles = new LinkedHashMap();
    }

    public final Map<String, ItemBubbleInfo> getItemBubbles() {
        return this.itemBubbles;
    }

    public final Map<String, ItemDotInfo> getItemDots() {
        return this.itemDots;
    }

    public final String getShow_path() {
        return this.show_path;
    }

    public BubbleDotPanelInfo(g r110) {
        this.itemDots = new HashMap();
        this.itemBubbles = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L45;
        if (r101 != 1) goto L7;
        this.show_path = am3.h.c(r110);
        goto L3
    L7:
        String r102 = null;
        if (r101 == 2) goto L28;
        if (r101 != 3) goto L11;
        long r103 = r110.c();
        Object r104 = null;
    L13:
        int r111 = r110.f();
        if (r111 == (-1)) goto L20;
        if (r111 != 1) goto L16;
        r102 = am3.h.c(r110);
        goto L13
    L16:
        if (r111 != 2) goto L17;
        r104 = new ItemBubbleInfo(r110);
        goto L13
    L17:
        am3.h.e(r110);
        goto L13
    L20:
        r110.d(r103);
        Map r105 = this.itemBubbles;
        if (r102 == null) goto L27;
        if (r104 == null) goto L25;
    L39:
        r105.put(r102, r104);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L11:
        am3.h.e(r110);
        goto L3
    L28:
        long r106 = r110.c();
        r104 = null;
    L29:
        int r112 = r110.f();
        if (r112 == (-1)) goto L36;
        if (r112 != 1) goto L32;
        r102 = am3.h.c(r110);
        goto L29
    L32:
        if (r112 != 2) goto L33;
        r104 = new ItemDotInfo(r110);
        goto L29
    L33:
        am3.h.e(r110);
        goto L29
    L36:
        r110.d(r106);
        r105 = this.itemDots;
        if (r102 == null) goto L43;
        if (r104 != null) goto L39;
        throw new IllegalStateException("Value must not be null");
    L43:
        throw new IllegalStateException("Key must not be null");
    L45:
        r110.d(r100);
        if (this.show_path != null) goto L49;
        this.show_path = "";
    L49:
        if (this.itemDots != null) goto L52;
        this.itemDots = new LinkedHashMap();
    L52:
        if (this.itemBubbles != null) goto L87;
        this.itemBubbles = new LinkedHashMap();
        return;
    }

    public final void setItemBubbles(Map<String, ItemBubbleInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.itemBubbles = r100;
    }

    public final void setItemDots(Map<String, ItemDotInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.itemDots = r100;
    }

    public final void setShow_path(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.show_path = r100;
    }
}
