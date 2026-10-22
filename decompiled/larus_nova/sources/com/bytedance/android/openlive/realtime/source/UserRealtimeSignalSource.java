package com.bytedance.android.openlive.realtime.source;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/openlive/realtime/source/UserRealtimeSignalSource;", "Lcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource;", "source", "", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserRealtimeSignalSource implements IUserRealtimeSignalSource {
    private final String source;

    @Override // com.bytedance.android.openlive.realtime.source.IUserRealtimeSignalSource
    public String getSource() {
        return this.source;
    }

    public UserRealtimeSignalSource(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.source = r100;
    }
}
