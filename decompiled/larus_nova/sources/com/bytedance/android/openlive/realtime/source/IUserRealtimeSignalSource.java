package com.bytedance.android.openlive.realtime.source;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource;", "", "source", "", "getSource", "()Ljava/lang/String;", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUserRealtimeSignalSource {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource$Companion;", "", "()V", "from", "Lcom/bytedance/android/openlive/realtime/source/IUserRealtimeSignalSource;", "source", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }

        public final IUserRealtimeSignalSource from(String r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return new UserRealtimeSignalSource(r100);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    String getSource();
}
