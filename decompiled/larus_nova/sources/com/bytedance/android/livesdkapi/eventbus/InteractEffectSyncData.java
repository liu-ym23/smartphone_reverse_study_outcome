package com.bytedance.android.livesdkapi.eventbus;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.InteractEffectSyncData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/eventbus/InteractEffectSyncData;", "", "()V", "anchorID", "", "roomID", "stickerInfoMap", "", "Lcom/bytedance/android/livesdkapi/eventbus/StickerInfoList;", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractEffectSyncData implements h {

    @SerializedName("anchor_id")
    public String anchorID;

    @SerializedName("room_id")
    public String roomID;

    @SerializedName("anchor_stickers")
    public Map<String, StickerInfoList> stickerInfoMap;

    public InteractEffectSyncData() {
        this.anchorID = "";
        this.roomID = "";
        this.stickerInfoMap = MapsKt.emptyMap();
    }

    public InteractEffectSyncData(g r110) {
        this.stickerInfoMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L30;
        if (r101 != 1) goto L8;
        this.anchorID = am3.h.c(r110);
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.roomID = am3.h.c(r110);
        goto L3
    L10:
        if (r101 != 3) goto L11;
        long r102 = r110.c();
        String r103 = null;
        StickerInfoList r104 = null;
    L13:
        int r105 = r110.f();
        if (r105 == (-1)) goto L20;
        if (r105 != 1) goto L16;
        r103 = am3.h.c(r110);
        goto L13
    L16:
        if (r105 != 2) goto L17;
        r104 = new StickerInfoList(r110);
        goto L13
    L17:
        am3.h.e(r110);
        goto L13
    L20:
        r110.d(r102);
        Map<String, StickerInfoList> r106 = this.stickerInfoMap;
        if (r103 == null) goto L27;
        if (r104 == null) goto L25;
        r106.put(r103, r104);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L11:
        am3.h.e(r110);
        goto L3
    L30:
        r110.d(r100);
        if (this.anchorID != null) goto L34;
        this.anchorID = "";
    L34:
        if (this.roomID != null) goto L37;
        this.roomID = "";
    L37:
        if (this.stickerInfoMap != null) goto L63;
        this.stickerInfoMap = MapsKt.emptyMap();
        return;
    }
}
