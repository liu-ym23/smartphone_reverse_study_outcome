package com.bytedance.android.live.broadcastgame.api.xplay;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class o implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f59500a = null;

    public o() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void a() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void b(boolean r100) {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void c() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void d() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stopReason");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void f(g10.b r100) {
        Intrinsics.checkNotNullParameter(r100, "extension");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void h(g10.b r100) {
        Intrinsics.checkNotNullParameter(r100, "extension");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void i(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "appId");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void j(p r100) {
        Intrinsics.checkNotNullParameter(r100, "newEnv");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final boolean l() {
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void m(XplayScene r100) {
        Intrinsics.checkNotNullParameter(r100, "newScene");
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final f n() {
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void updateEnableAudioFrame(boolean r100) {
    }

    static {
        f59500a = new o();
    }
}
