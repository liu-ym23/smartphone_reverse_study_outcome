package com.bytedance.android.live.effect.beauty.presets;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/LivePresetContainer;", "", "presetGroupsByUid", "", "", "Lcom/bytedance/android/live/effect/beauty/presets/RoomPresetContainer;", "(Ljava/util/Map;)V", "getPresetGroupsByUid", "()Ljava/util/Map;", "setPresetGroupsByUid", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePresetContainer {
    private Map<String, RoomPresetContainer> presetGroupsByUid;

    /* JADX WARN: Multi-variable type inference failed */
    public LivePresetContainer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LivePresetContainer copy$default(LivePresetContainer r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.presetGroupsByUid;
    L6:
        return r100.copy(r101);
    }

    public final Map<String, RoomPresetContainer> component1() {
        return this.presetGroupsByUid;
    }

    public final LivePresetContainer copy(Map<String, RoomPresetContainer> r100) {
        Intrinsics.checkNotNullParameter(r100, "presetGroupsByUid");
        return new LivePresetContainer(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LivePresetContainer) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.presetGroupsByUid, ((LivePresetContainer) r100).presetGroupsByUid) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Map<String, RoomPresetContainer> r100 = this.presetGroupsByUid;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "LivePresetContainer(presetGroupsByUid=" + this.presetGroupsByUid + ")";
    }

    public final Map<String, RoomPresetContainer> getPresetGroupsByUid() {
        return this.presetGroupsByUid;
    }

    public LivePresetContainer(Map<String, RoomPresetContainer> r100) {
        Intrinsics.checkNotNullParameter(r100, "presetGroupsByUid");
        this.presetGroupsByUid = r100;
    }

    public final void setPresetGroupsByUid(Map<String, RoomPresetContainer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.presetGroupsByUid = r100;
    }

    public /* synthetic */ LivePresetContainer(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new LinkedHashMap();
    L5:
        this(r100);
    }
}
