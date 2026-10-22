package com.bytedance.android.livesdk.player;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSharedDataManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class p implements ILivePlayerSharedDataManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f156014a;

    public p() {
        this.f156014a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSharedDataManager
    public final Object getSharedData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f156014a.get(r100);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSharedDataManager
    public final void removeSharedData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f156014a.remove(r100);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerSharedDataManager
    public final void putSharedData(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f156014a.put(r100, r101);
    }
}
