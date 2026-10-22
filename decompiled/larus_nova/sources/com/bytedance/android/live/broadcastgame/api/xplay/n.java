package com.bytedance.android.live.broadcastgame.api.xplay;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class n implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f59498b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f59499a;

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void a() {
        this.f59499a.a();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void b(boolean r100) {
        this.f59499a.b(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void c() {
        this.f59499a.c();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void d() {
        this.f59499a.d();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stopReason");
        this.f59499a.e(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void f(g10.b r100) {
        Intrinsics.checkNotNullParameter(r100, "extension");
        this.f59499a.f(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void g() {
        this.f59499a.g();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void h(g10.b r100) {
        Intrinsics.checkNotNullParameter(r100, "extension");
        this.f59499a.h(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void i(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "appId");
        this.f59499a.i(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void j(p r100) {
        Intrinsics.checkNotNullParameter(r100, "newEnv");
        this.f59499a.j(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f59499a.k(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final boolean l() {
        return this.f59499a.l();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void m(XplayScene r100) {
        Intrinsics.checkNotNullParameter(r100, "newScene");
        this.f59499a.m(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final f n() {
        return this.f59499a.n();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void updateEnableAudioFrame(boolean r100) {
        this.f59499a.updateEnableAudioFrame(r100);
    }

    static {
        f59498b = new n();
    }

    public n() {
        this.f59499a = (e) XplayGlobalServiceKt.f59436a.getValue();
    }
}
