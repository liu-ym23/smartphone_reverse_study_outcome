package com.bytedance.android.livesdk.interactivity.pin.business.comment.api;

import am3.g;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.room.ChatHighlightResponse.Response")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/comment/api/ChatHighlightResponseData;", "", "()V", "eventTime", "", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem;", "newId", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatHighlightResponseData implements h {

    @SerializedName("event_time")
    public long eventTime;

    @SerializedName(MapController.ITEM_LAYER_TAG)
    public HighlightItem item;

    @SerializedName("new_id")
    public long newId;

    public ChatHighlightResponseData() {
    }

    public ChatHighlightResponseData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.eventTime = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.newId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.item = new HighlightItem(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
