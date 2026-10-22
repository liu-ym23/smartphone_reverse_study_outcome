package com.bytedance.android.livesdk.performance;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/performance/x0;", "", "", "exitRoomTime", "Ljava/lang/String;", "e", "()Ljava/lang/String;", ce.f26395j, "(Ljava/lang/String;)V", "exitReason", "d", RXScreenCaptureService.KEY_INDEX, "", "Lcom/bytedance/android/livesdk/performance/p0;", "performance", "Ljava/util/List;", "f", "()Ljava/util/List;", "roomId", ce.f26391f, "roomName", "h", "anchorId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anchorName", "b", "enterRoomTime", "c", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f154830a;

    @SerializedName("anchor_id")
    private final String anchorId;

    @SerializedName("anchor_name")
    private final String anchorName;

    @SerializedName("enter_room_time")
    private final String enterRoomTime;

    @SerializedName("exit_reason")
    private String exitReason;

    @SerializedName("exit_room_time")
    private String exitRoomTime;

    @SerializedName("performance")
    private final List<p0> performance;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("room_name")
    private final String roomName;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x0) == false) goto L18;
        x0 r101 = (x0) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomName, r101.roomName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.anchorId, r101.anchorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anchorName, r101.anchorName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.enterRoomTime, r101.enterRoomTime) == true) goto L16;
        return false;
    L16:
        if (this.f154830a == r101.f154830a) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.roomId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.roomName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.anchorId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.anchorName;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.enterRoomTime;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        long r115 = this.f154830a;
        return r114 + ((int) (r115 ^ (r115 >>> 32)));
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RoomInfoLog(roomId=" + this.roomId + ", roomName=" + this.roomName + ", anchorId=" + this.anchorId + ", anchorName=" + this.anchorName + ", enterRoomTime=" + this.enterRoomTime + ", enterRoomMilliSecond=" + this.f154830a + ")";
    }

    public final String a() {
        return this.anchorId;
    }

    public final String b() {
        return this.anchorName;
    }

    public final String c() {
        return this.enterRoomTime;
    }

    public final String d() {
        return this.exitReason;
    }

    public final String e() {
        return this.exitRoomTime;
    }

    public final List<p0> f() {
        return this.performance;
    }

    public final String g() {
        return this.roomId;
    }

    public final String h() {
        return this.roomName;
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.exitReason = r100;
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.exitRoomTime = r100;
    }

    public x0(String r100, String r101, String r102, String r103, String r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "roomName");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        Intrinsics.checkNotNullParameter(r103, "anchorName");
        Intrinsics.checkNotNullParameter(r104, "enterRoomTime");
        this.roomId = r100;
        this.roomName = r101;
        this.anchorId = r102;
        this.anchorName = r103;
        this.enterRoomTime = r104;
        this.f154830a = r105;
        this.exitRoomTime = "";
        this.exitReason = "";
        this.performance = new ArrayList();
    }
}
