package com.bytedance.android.live.effect.beauty.presets;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/RoomPresetSelectContainer;", "", "selectionsByRoom", "", "", "(Ljava/util/Map;)V", "getSelectionsByRoom", "()Ljava/util/Map;", "setSelectionsByRoom", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomPresetSelectContainer {
    private Map<String, String> selectionsByRoom;

    /* JADX WARN: Multi-variable type inference failed */
    public RoomPresetSelectContainer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RoomPresetSelectContainer copy$default(RoomPresetSelectContainer r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.selectionsByRoom;
    L6:
        return r100.copy(r101);
    }

    public final Map<String, String> component1() {
        return this.selectionsByRoom;
    }

    public final RoomPresetSelectContainer copy(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "selectionsByRoom");
        return new RoomPresetSelectContainer(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RoomPresetSelectContainer) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.selectionsByRoom, ((RoomPresetSelectContainer) r100).selectionsByRoom) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Map<String, String> r100 = this.selectionsByRoom;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "RoomPresetSelectContainer(selectionsByRoom=" + this.selectionsByRoom + ")";
    }

    public final Map<String, String> getSelectionsByRoom() {
        return this.selectionsByRoom;
    }

    public RoomPresetSelectContainer(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "selectionsByRoom");
        this.selectionsByRoom = r100;
    }

    public final void setSelectionsByRoom(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.selectionsByRoom = r100;
    }

    public /* synthetic */ RoomPresetSelectContainer(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new LinkedHashMap();
    L5:
        this(r100);
    }
}
