package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.ItemContentInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/ItemContentInfo;", "", "()V", "episodeRank", "", "itemId", "", "seriesId", "videoType", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemContentInfo implements h {

    @SerializedName("episode_rank")
    public int episodeRank;

    @SerializedName("item_id")
    public String itemId;

    @SerializedName("series_id")
    public String seriesId;

    @SerializedName(a.KEY_VIDEO_TYPE)
    public int videoType;

    public ItemContentInfo() {
    }

    public ItemContentInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.itemId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.seriesId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.episodeRank = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.videoType = r100.i();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
