package com.bytedance.android.livesdkapi.depend.model.broadcast;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PanelDotInfo")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/BroadcastPanelDotInfo;", "", "()V", "itemDots", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ItemDotInfo;", "getItemDots", "()Ljava/util/Map;", "setItemDots", "(Ljava/util/Map;)V", "path", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BroadcastPanelDotInfo implements h {

    @SerializedName("item_dots")
    protected Map<String, ItemDotInfo> itemDots;

    @SerializedName("show_path")
    protected String path;

    public BroadcastPanelDotInfo() {
        this.path = "";
        this.itemDots = new LinkedHashMap();
    }

    public final Map<String, ItemDotInfo> getItemDots() {
        return this.itemDots;
    }

    public final String getPath() {
        return this.path;
    }

    public BroadcastPanelDotInfo(g r110) {
        this.itemDots = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        if (r101 != 1) goto L8;
        this.path = am3.h.c(r110);
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r102 = r110.c();
        String r103 = null;
        ItemDotInfo r104 = null;
    L11:
        int r105 = r110.f();
        if (r105 == (-1)) goto L18;
        if (r105 != 1) goto L14;
        r103 = am3.h.c(r110);
        goto L11
    L14:
        if (r105 != 2) goto L15;
        r104 = new ItemDotInfo(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r102);
        Map<String, ItemDotInfo> r106 = this.itemDots;
        if (r103 == null) goto L25;
        if (r104 == null) goto L23;
        r106.put(r103, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r110);
        goto L3
    L27:
        r110.d(r100);
        if (this.path != null) goto L31;
        this.path = "";
    L31:
        if (this.itemDots != null) goto L54;
        this.itemDots = new LinkedHashMap();
        return;
    }

    public final void setItemDots(Map<String, ItemDotInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.itemDots = r100;
    }

    public final void setPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.path = r100;
    }
}
