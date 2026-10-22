package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/a3;", "", "", "", "sources", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "rooms", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "reason", "getReason", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a3 {

    @SerializedName("reason")
    private final Map<Long, Integer> reason;

    @SerializedName("rooms")
    private final List<IRoom> rooms;

    @SerializedName("sources")
    private final Map<Long, Long> sources;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a3) == false) goto L12;
        a3 r101 = (a3) r100;
        if (Intrinsics.areEqual(this.sources, r101.sources) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.rooms, r101.rooms) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.reason, r101.reason) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<Long, Long> r100 = this.sources;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<IRoom> r104 = this.rooms;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<Long, Integer> r107 = this.reason;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RecommendedRooms(sources=" + this.sources + ", rooms=" + this.rooms + ", reason=" + this.reason + ")";
    }

    public final List<IRoom> a() {
        return this.rooms;
    }

    public final Map<Long, Long> b() {
        return this.sources;
    }
}
