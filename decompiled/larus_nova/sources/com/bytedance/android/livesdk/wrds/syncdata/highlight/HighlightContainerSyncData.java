package com.bytedance.android.livesdk.wrds.syncdata.highlight;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.HighlightContainerSyncData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightContainerSyncData;", "", "()V", "carouselInfo", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/CarouselInfo;", "getCarouselInfo", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/CarouselInfo;", "setCarouselInfo", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/CarouselInfo;)V", "highlightItems", "", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightItem;", "getHighlightItems", "()Ljava/util/List;", "setHighlightItems", "(Ljava/util/List;)V", "syncVersion", "", "getSyncVersion", "()J", "setSyncVersion", "(J)V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HighlightContainerSyncData implements h {

    @SerializedName("carousel_info")
    protected CarouselInfo carouselInfo;

    @SerializedName("highlight_items")
    protected List<HighlightItem> highlightItems;

    @SerializedName("sync_version")
    protected long syncVersion;

    public HighlightContainerSyncData() {
    }

    public final CarouselInfo getCarouselInfo() {
        return this.carouselInfo;
    }

    public final List<HighlightItem> getHighlightItems() {
        return this.highlightItems;
    }

    public final long getSyncVersion() {
        return this.syncVersion;
    }

    public HighlightContainerSyncData(g r100) {
        this.highlightItems = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.highlightItems.add(new HighlightItem(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.syncVersion = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.carouselInfo = new CarouselInfo(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setCarouselInfo(CarouselInfo r100) {
        this.carouselInfo = r100;
    }

    public final void setHighlightItems(List<HighlightItem> r100) {
        this.highlightItems = r100;
    }

    public final void setSyncVersion(long r100) {
        this.syncVersion = r100;
    }
}
