package com.bytedance.android.openlive.realtime.signal;

import com.bytedance.android.openlive.realtime.source.IUserRealtimeSignalSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/openlive/realtime/signal/DislikeRealtimeSignal;", "Lcom/bytedance/android/openlive/realtime/signal/IUserRealtimeSignal;", "roomId", "", "timestamp", "source", "Lcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource;", "(JJLcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource;)V", "getRoomId", "()J", "getSource", "()Lcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource;", "getTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DislikeRealtimeSignal implements IUserRealtimeSignal {
    private final long roomId;
    private final IUserRealtimeSignalSource source;
    private final long timestamp;

    public static /* synthetic */ DislikeRealtimeSignal copy$default(DislikeRealtimeSignal r100, long r101, long r102, IUserRealtimeSignalSource r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.getRoomId();
    L5:
        long r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.getTimestamp();
    L8:
        long r104 = r102;
        if ((r111 & 4) == 0) goto L12;
        r110 = r100.getSource();
    L12:
        return r100.copy(r103, r104, r110);
    }

    public final long component1() {
        return getRoomId();
    }

    public final long component2() {
        return getTimestamp();
    }

    public final IUserRealtimeSignalSource component3() {
        return getSource();
    }

    public final DislikeRealtimeSignal copy(long r100, long r110, IUserRealtimeSignalSource r111) {
        Intrinsics.checkNotNullParameter(r111, "source");
        return new DislikeRealtimeSignal(r100, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DislikeRealtimeSignal) == false) goto L12;
        DislikeRealtimeSignal r101 = (DislikeRealtimeSignal) r100;
        if (getRoomId() == r101.getRoomId()) goto L8;
        return false;
    L8:
        if (getTimestamp() == r101.getTimestamp()) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(getSource(), r101.getSource()) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        long r100 = getRoomId();
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = getTimestamp();
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        IUserRealtimeSignalSource r104 = getSource();
        if (r104 == null) goto L5;
        int r105 = r104.hashCode();
    L7:
        return r103 + r105;
    L5:
        r105 = 0;
        goto L7
    }

    public String toString() {
        return "DislikeRealtimeSignal(roomId=" + getRoomId() + ", timestamp=" + getTimestamp() + ", source=" + getSource() + ")";
    }

    @Override // com.bytedance.android.openlive.realtime.signal.IUserRealtimeSignal
    public long getRoomId() {
        return this.roomId;
    }

    @Override // com.bytedance.android.openlive.realtime.signal.IUserRealtimeSignal
    public IUserRealtimeSignalSource getSource() {
        return this.source;
    }

    @Override // com.bytedance.android.openlive.realtime.signal.IUserRealtimeSignal
    public long getTimestamp() {
        return this.timestamp;
    }

    public DislikeRealtimeSignal(long r100, long r101, IUserRealtimeSignalSource r102) {
        Intrinsics.checkNotNullParameter(r102, "source");
        this.roomId = r100;
        this.timestamp = r101;
        this.source = r102;
    }

    public /* synthetic */ DislikeRealtimeSignal(long r100, long r110, IUserRealtimeSignalSource r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r112 & 2) == 0) goto L9;
        long r102 = 0;
    L10:
        this(r101, r102, r111);
        return;
    L9:
        r102 = r110;
        goto L10
    L5:
        r101 = r100;
        goto L7
    }
}
