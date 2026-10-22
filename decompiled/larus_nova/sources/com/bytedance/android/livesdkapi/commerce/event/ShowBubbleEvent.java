package com.bytedance.android.livesdkapi.commerce.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/commerce/event/ShowBubbleEvent;", "", "show", "", "(Z)V", "getShow", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowBubbleEvent {
    private final boolean show;

    public ShowBubbleEvent() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public static /* synthetic */ ShowBubbleEvent copy$default(ShowBubbleEvent r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.show;
    L6:
        return r100.copy(r101);
    }

    public final boolean component1() {
        return this.show;
    }

    public final ShowBubbleEvent copy(boolean r100) {
        return new ShowBubbleEvent(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShowBubbleEvent) == true) goto L6;
        return false;
    L6:
        if (this.show == ((ShowBubbleEvent) r100).show) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        boolean r100 = this.show;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public String toString() {
        return "ShowBubbleEvent(show=" + this.show + ")";
    }

    public final boolean getShow() {
        return this.show;
    }

    public ShowBubbleEvent(boolean r100) {
        this.show = r100;
    }

    public /* synthetic */ ShowBubbleEvent(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
