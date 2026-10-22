package com.bytedance.android.openlive.realtime.signal;

import com.bytedance.android.openlive.realtime.source.IUserRealtimeSignalSource;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/bytedance/android/openlive/realtime/signal/IUserRealtimeSignal;", "", "roomId", "", "getRoomId", "()J", "source", "Lcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource;", "getSource", "()Lcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource;", "timestamp", "getTimestamp", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUserRealtimeSignal {
    long getRoomId();

    IUserRealtimeSignalSource getSource();

    long getTimestamp();
}
