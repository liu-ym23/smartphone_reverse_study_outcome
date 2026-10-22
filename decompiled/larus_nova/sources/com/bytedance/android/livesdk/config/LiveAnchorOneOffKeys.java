package com.bytedance.android.livesdk.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/LiveAnchorOneOffKeys;", "", "dot_preview_used", "", "dot_in_room_used", "popup_in_room_used", "(ZZZ)V", "getDot_in_room_used", "()Z", "getDot_preview_used", "getPopup_in_room_used", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnchorOneOffKeys {
    private final boolean dot_in_room_used;
    private final boolean dot_preview_used;
    private final boolean popup_in_room_used;

    public LiveAnchorOneOffKeys() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ LiveAnchorOneOffKeys copy$default(LiveAnchorOneOffKeys r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.dot_preview_used;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.dot_in_room_used;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.popup_in_room_used;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.dot_preview_used;
    }

    public final boolean component2() {
        return this.dot_in_room_used;
    }

    public final boolean component3() {
        return this.popup_in_room_used;
    }

    public final LiveAnchorOneOffKeys copy(boolean r100, boolean r101, boolean r102) {
        return new LiveAnchorOneOffKeys(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveAnchorOneOffKeys) == false) goto L12;
        LiveAnchorOneOffKeys r101 = (LiveAnchorOneOffKeys) r100;
        if (this.dot_preview_used == r101.dot_preview_used) goto L8;
        return false;
    L8:
        if (this.dot_in_room_used == r101.dot_in_room_used) goto L10;
        return false;
    L10:
        if (this.popup_in_room_used == r101.popup_in_room_used) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean r100 = this.dot_preview_used;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.dot_in_room_used;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.popup_in_room_used;
        if (r107 == true) goto L13;
        r101 = r107;
    L13:
        return r106 + r101;
    }

    public String toString() {
        return "LiveAnchorOneOffKeys(dot_preview_used=" + this.dot_preview_used + ", dot_in_room_used=" + this.dot_in_room_used + ", popup_in_room_used=" + this.popup_in_room_used + ")";
    }

    public final boolean getDot_in_room_used() {
        return this.dot_in_room_used;
    }

    public final boolean getDot_preview_used() {
        return this.dot_preview_used;
    }

    public final boolean getPopup_in_room_used() {
        return this.popup_in_room_used;
    }

    public LiveAnchorOneOffKeys(boolean r100, boolean r101, boolean r102) {
        this.dot_preview_used = r100;
        this.dot_in_room_used = r101;
        this.popup_in_room_used = r102;
    }

    public /* synthetic */ LiveAnchorOneOffKeys(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
