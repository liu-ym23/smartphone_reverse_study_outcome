package com.bytedance.android.livesdkapi.ws.host;

import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R%\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR%\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/ws/host/LiveHostWsServiceConfig;", "", "()V", "douyinServices", "", "Lkotlin/Pair;", "", "getDouyinServices", "()[Lkotlin/Pair;", "[Lkotlin/Pair;", "hotsoonServices", "getHotsoonServices", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveHostWsServiceConfig {
    public static final LiveHostWsServiceConfig INSTANCE = null;
    private static final Pair<Integer, Integer>[] douyinServices = null;
    private static final Pair<Integer, Integer>[] hotsoonServices = null;

    private LiveHostWsServiceConfig() {
    }

    static {
        INSTANCE = new LiveHostWsServiceConfig();
        hotsoonServices = new Pair[]{new Pair(20307, 20282), new Pair(33554540, 16778054)};
        douyinServices = new Pair[]{new Pair(20142, 20115), new Pair(33554540, 16778054)};
    }

    public final Pair<Integer, Integer>[] getDouyinServices() {
        return douyinServices;
    }

    public final Pair<Integer, Integer>[] getHotsoonServices() {
        return hotsoonServices;
    }
}
