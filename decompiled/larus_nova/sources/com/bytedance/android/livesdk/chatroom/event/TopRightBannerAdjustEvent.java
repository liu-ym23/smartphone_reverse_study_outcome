package com.bytedance.android.livesdk.chatroom.event;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/event/TopRightBannerAdjustEvent;", "", "newWidth", "", "(I)V", "getNewWidth", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopRightBannerAdjustEvent {
    private final int newWidth;

    public static /* synthetic */ TopRightBannerAdjustEvent copy$default(TopRightBannerAdjustEvent r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.newWidth;
    L6:
        return r100.copy(r101);
    }

    public final int component1() {
        return this.newWidth;
    }

    public final TopRightBannerAdjustEvent copy(int r100) {
        return new TopRightBannerAdjustEvent(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TopRightBannerAdjustEvent) == true) goto L6;
        return false;
    L6:
        if (this.newWidth == ((TopRightBannerAdjustEvent) r100).newWidth) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        return this.newWidth;
    }

    public String toString() {
        return "TopRightBannerAdjustEvent(newWidth=" + this.newWidth + ")";
    }

    public final int getNewWidth() {
        return this.newWidth;
    }

    public TopRightBannerAdjustEvent(int r100) {
        this.newWidth = r100;
    }
}
