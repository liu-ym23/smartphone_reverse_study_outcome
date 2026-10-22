package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.view.Surface;
import com.bytedance.android.live.broadcastgame.api.model.u;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements com.bytedance.android.live.broadcastgame.api.openplatform.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f61157a = null;

    public g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void c(boolean r100) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void d(String r100, Map<String, String> r101) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void e(u r100) {
        Intrinsics.checkNotNullParameter(r100, "gameItem");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final String h() {
        Intrinsics.checkNotNullParameter("", "appId");
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void i(long r100, String r101, String r102, Map<String, ? extends Object> r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "appId");
        Intrinsics.checkNotNullParameter(r102, "schema");
        Intrinsics.checkNotNullParameter(r103, "params");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter("sei", "name");
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void k() {
        Intrinsics.checkNotNullParameter("", "appId");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void notifyStartLinkCastResult(boolean r100, Surface r101, int r102) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void stopGameCastToAudience() {
    }

    static {
        f61157a = new g();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final String getGameCategory() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
