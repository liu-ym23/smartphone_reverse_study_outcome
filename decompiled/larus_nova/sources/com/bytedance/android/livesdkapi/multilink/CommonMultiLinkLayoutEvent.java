package com.bytedance.android.livesdkapi.multilink;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/multilink/CommonMultiLinkLayoutEvent;", "", "roomId", "", "isFloatWindow", "", "guestSeatXPosition", "", "(Ljava/lang/String;ZI)V", "getGuestSeatXPosition", "()I", "()Z", "getRoomId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonMultiLinkLayoutEvent {
    private final int guestSeatXPosition;
    private final boolean isFloatWindow;
    private final String roomId;

    public static /* synthetic */ CommonMultiLinkLayoutEvent copy$default(CommonMultiLinkLayoutEvent r100, String r101, boolean r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.roomId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.isFloatWindow;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.guestSeatXPosition;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.roomId;
    }

    public final boolean component2() {
        return this.isFloatWindow;
    }

    public final int component3() {
        return this.guestSeatXPosition;
    }

    public final CommonMultiLinkLayoutEvent copy(String r100, boolean r101, int r102) {
        return new CommonMultiLinkLayoutEvent(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonMultiLinkLayoutEvent) == false) goto L12;
        CommonMultiLinkLayoutEvent r101 = (CommonMultiLinkLayoutEvent) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (this.isFloatWindow == r101.isFloatWindow) goto L10;
        return false;
    L10:
        if (this.guestSeatXPosition == r101.guestSeatXPosition) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        String r100 = this.roomId;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.isFloatWindow;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return ((r102 + r104) * 31) + this.guestSeatXPosition;
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "CommonMultiLinkLayoutEvent(roomId=" + this.roomId + ", isFloatWindow=" + this.isFloatWindow + ", guestSeatXPosition=" + this.guestSeatXPosition + ")";
    }

    public final int getGuestSeatXPosition() {
        return this.guestSeatXPosition;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final boolean isFloatWindow() {
        return this.isFloatWindow;
    }

    public CommonMultiLinkLayoutEvent(String r100, boolean r101, int r102) {
        this.roomId = r100;
        this.isFloatWindow = r101;
        this.guestSeatXPosition = r102;
    }
}
