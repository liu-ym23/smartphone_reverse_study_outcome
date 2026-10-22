package com.bytedance.android.live.broadcastgame.opengame.service;

import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/TrackLynxService;", "Lcom/bytedance/android/live/broadcastgame/opengame/service/TrackCommonService;", "", "Ly10/a;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TrackLynxService extends TrackCommonService implements p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PluginContext f60987e;

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r100) {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
        this.f60984a = System.currentTimeMillis();
        e();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        d();
        c();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.TrackCommonService
    public final PluginContext b() {
        return this.f60987e;
    }

    public TrackLynxService(PluginContext r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        super(r100);
        this.f60987e = r100;
    }
}
