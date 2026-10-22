package com.bytedance.android.openlive.realtime;

import com.bytedance.android.openlive.realtime.signal.IUserRealtimeSignal;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017¨\u0006\n"}, d2 = {"Lcom/bytedance/android/openlive/realtime/IUserRealtimeSignalCenter;", "", "handle", "", "realtimeSignal", "Lcom/bytedance/android/openlive/realtime/signal/IUserRealtimeSignal;", "serialize", "", "jsonObject", "Lcom/google/gson/JsonObject;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUserRealtimeSignalCenter {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static boolean handle(IUserRealtimeSignalCenter r100, IUserRealtimeSignal r101) {
            Intrinsics.checkNotNullParameter(r101, "realtimeSignal");
            return false;
        }

        public static void serialize(IUserRealtimeSignalCenter r100, JsonObject r101) {
            Intrinsics.checkNotNullParameter(r101, "jsonObject");
        }
    }

    boolean handle(IUserRealtimeSignal r100);

    void serialize(JsonObject r100);
}
