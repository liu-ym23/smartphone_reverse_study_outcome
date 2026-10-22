package com.bytedance.android.live.effect.beauty.presets;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J%\u0010\f\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R,\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/RoomPresetContainer;", "", "presetListsByRoom", "", "", "", "Lcom/bytedance/android/live/effect/beauty/presets/BeautifyPreset;", "(Ljava/util/Map;)V", "getPresetListsByRoom", "()Ljava/util/Map;", "setPresetListsByRoom", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomPresetContainer {
    private Map<String, List<BeautifyPreset>> presetListsByRoom;

    /* JADX WARN: Multi-variable type inference failed */
    public RoomPresetContainer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RoomPresetContainer copy$default(RoomPresetContainer r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.presetListsByRoom;
    L6:
        return r100.copy(r101);
    }

    public final Map<String, List<BeautifyPreset>> component1() {
        return this.presetListsByRoom;
    }

    public final RoomPresetContainer copy(Map<String, List<BeautifyPreset>> r100) {
        Intrinsics.checkNotNullParameter(r100, "presetListsByRoom");
        return new RoomPresetContainer(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RoomPresetContainer) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.presetListsByRoom, ((RoomPresetContainer) r100).presetListsByRoom) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Map<String, List<BeautifyPreset>> r100 = this.presetListsByRoom;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "RoomPresetContainer(presetListsByRoom=" + this.presetListsByRoom + ")";
    }

    public final Map<String, List<BeautifyPreset>> getPresetListsByRoom() {
        return this.presetListsByRoom;
    }

    public RoomPresetContainer(Map<String, List<BeautifyPreset>> r100) {
        Intrinsics.checkNotNullParameter(r100, "presetListsByRoom");
        this.presetListsByRoom = r100;
    }

    public final void setPresetListsByRoom(Map<String, List<BeautifyPreset>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.presetListsByRoom = r100;
    }

    public /* synthetic */ RoomPresetContainer(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new LinkedHashMap();
    L5:
        this(r100);
    }
}
