package com.bytedance.android.livesdkapi;

import com.bytedance.android.livesdkapi.service.IGameLiveService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/TTLiveGameService;", "", "()V", "sIGameLiveService", "Lcom/bytedance/android/livesdkapi/service/IGameLiveService;", "getLiveService", "injectImpl", "", "gameLiveService", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TTLiveGameService {
    public static final TTLiveGameService INSTANCE = null;
    private static volatile IGameLiveService sIGameLiveService;

    private TTLiveGameService() {
    }

    static {
        INSTANCE = new TTLiveGameService();
    }

    public final IGameLiveService getLiveService() {
        return sIGameLiveService;
    }

    public final void injectImpl(IGameLiveService r100) {
        Intrinsics.checkNotNullParameter(r100, "gameLiveService");
        sIGameLiveService = r100;
    }
}
