package com.bytedance.android.openlive.realtime.signal;

import com.bytedance.android.openlive.realtime.source.IUserRealtimeSignalSource;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/openlive/realtime/signal/WatchLiveRealtimeSignal;", "Lcom/bytedance/android/openlive/realtime/signal/IUserRealtimeSignal;", "roomId", "", "timestamp", DyPayConstant.KEY_START_TIME, "duration", "source", "Lcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource;", "(JJJJLcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource;)V", "getDuration", "()J", "getRoomId", "getSource", "()Lcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource;", "getStartTime", "getTimestamp", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WatchLiveRealtimeSignal implements IUserRealtimeSignal {
    private final long duration;
    private final long roomId;
    private final IUserRealtimeSignalSource source;
    private final long startTime;
    private final long timestamp;

    public static /* synthetic */ WatchLiveRealtimeSignal copy$default(WatchLiveRealtimeSignal r110, long r111, long r112, long r113, long r114, IUserRealtimeSignalSource r115, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = r110.getRoomId();
    L7:
        if ((r210 & 2) == 0) goto L9;
        long r101 = r110.getTimestamp();
    L11:
        if ((r210 & 4) == 0) goto L13;
        long r102 = r110.startTime;
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r103 = r110.duration;
    L19:
        if ((r210 & 16) == 0) goto L21;
        IUserRealtimeSignalSource r104 = r110.getSource();
    L23:
        return r110.copy(r100, r101, r102, r103, r104);
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return getRoomId();
    }

    public final long component2() {
        return getTimestamp();
    }

    public final long component3() {
        return this.startTime;
    }

    public final long component4() {
        return this.duration;
    }

    public final IUserRealtimeSignalSource component5() {
        return getSource();
    }

    public final WatchLiveRealtimeSignal copy(long r110, long r111, long r112, long r113, IUserRealtimeSignalSource r210) {
        Intrinsics.checkNotNullParameter(r210, "source");
        return new WatchLiveRealtimeSignal(r110, r111, r112, r113, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WatchLiveRealtimeSignal) == false) goto L16;
        WatchLiveRealtimeSignal r101 = (WatchLiveRealtimeSignal) r100;
        if (getRoomId() == r101.getRoomId()) goto L8;
        return false;
    L8:
        if (getTimestamp() == r101.getTimestamp()) goto L10;
        return false;
    L10:
        if (this.startTime == r101.startTime) goto L12;
        return false;
    L12:
        if (this.duration == r101.duration) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(getSource(), r101.getSource()) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        long r100 = getRoomId();
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = getTimestamp();
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.startTime;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.duration;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        IUserRealtimeSignalSource r108 = getSource();
        if (r108 == null) goto L5;
        int r109 = r108.hashCode();
    L7:
        return r107 + r109;
    L5:
        r109 = 0;
        goto L7
    }

    public String toString() {
        return "WatchLiveRealtimeSignal(roomId=" + getRoomId() + ", timestamp=" + getTimestamp() + ", startTime=" + this.startTime + ", duration=" + this.duration + ", source=" + getSource() + ")";
    }

    public final long getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.android.openlive.realtime.signal.IUserRealtimeSignal
    public long getRoomId() {
        return this.roomId;
    }

    @Override // com.bytedance.android.openlive.realtime.signal.IUserRealtimeSignal
    public IUserRealtimeSignalSource getSource() {
        return this.source;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    @Override // com.bytedance.android.openlive.realtime.signal.IUserRealtimeSignal
    public long getTimestamp() {
        return this.timestamp;
    }

    public WatchLiveRealtimeSignal(long r100, long r101, long r102, long r103, IUserRealtimeSignalSource r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        this.roomId = r100;
        this.timestamp = r101;
        this.startTime = r102;
        this.duration = r103;
        this.source = r110;
    }

    public /* synthetic */ WatchLiveRealtimeSignal(long r110, long r111, long r112, long r210, IUserRealtimeSignalSource r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r212 & 2) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r212 & 8) == 0) goto L17;
        long r113 = 0;
    L18:
        this(r100, r101, r102, r113, r211);
        return;
    L17:
        r113 = r210;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
