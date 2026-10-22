package com.bytedance.android.livesdk.interactivity.pin.business.common.api;

import am3.g;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.room.CommonPictureTextHighlightResponse.Response")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/common/api/CommonPictureTextHighlightResponse;", "", "()V", "eventTime", "", "getEventTime", "()J", "setEventTime", "(J)V", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem;", "getItem", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem;", "setItem", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem;)V", "skipReview", "", "getSkipReview", "()I", "setSkipReview", "(I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonPictureTextHighlightResponse implements h {

    @SerializedName("event_time")
    protected long eventTime;

    @SerializedName(MapController.ITEM_LAYER_TAG)
    protected HighlightItem item;

    @SerializedName("skip_review")
    protected int skipReview;

    public CommonPictureTextHighlightResponse() {
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public final HighlightItem getItem() {
        return this.item;
    }

    public final int getSkipReview() {
        return this.skipReview;
    }

    public CommonPictureTextHighlightResponse(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.eventTime = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.item = new HighlightItem(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.skipReview = (int) r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setEventTime(long r100) {
        this.eventTime = r100;
    }

    public final void setItem(HighlightItem r100) {
        this.item = r100;
    }

    public final void setSkipReview(int r100) {
        this.skipReview = r100;
    }
}
