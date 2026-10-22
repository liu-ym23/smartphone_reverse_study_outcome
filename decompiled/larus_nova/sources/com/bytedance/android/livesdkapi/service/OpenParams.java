package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/OpenParams;", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "liveGlobalParams", "", "", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;Ljava/util/Map;)V", "getLiveGlobalParams", "()Ljava/util/Map;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenParams {
    private final Map<String, String> liveGlobalParams;
    private final Room room;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenParams copy$default(OpenParams r100, Room r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.room;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.liveGlobalParams;
    L9:
        return r100.copy(r101, r102);
    }

    public final Room component1() {
        return this.room;
    }

    public final Map<String, String> component2() {
        return this.liveGlobalParams;
    }

    public final OpenParams copy(Room r100, Map<String, String> r101) {
        return new OpenParams(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OpenParams) == false) goto L10;
        OpenParams r101 = (OpenParams) r100;
        if (Intrinsics.areEqual(this.room, r101.room) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveGlobalParams, r101.liveGlobalParams) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Room r100 = this.room;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.liveGlobalParams;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "OpenParams(room=" + this.room + ", liveGlobalParams=" + this.liveGlobalParams + ")";
    }

    public final Map<String, String> getLiveGlobalParams() {
        return this.liveGlobalParams;
    }

    public final Room getRoom() {
        return this.room;
    }

    public OpenParams(Room r100, Map<String, String> r101) {
        this.room = r100;
        this.liveGlobalParams = r101;
    }
}
