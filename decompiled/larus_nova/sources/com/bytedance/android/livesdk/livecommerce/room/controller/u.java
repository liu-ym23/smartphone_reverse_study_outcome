package com.bytedance.android.livesdk.livecommerce.room.controller;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class u implements rd.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.room.api.g f151717a;

    @Override // rd.c
    public final void onCreate() {
        this.f151717a.onCreate();
    }

    @Override // rd.c
    public final void onDestroy() {
        this.f151717a.onDestroy();
    }

    @Override // rd.c
    public final void onDestroyView() {
        this.f151717a.onDestroyView();
    }

    @Override // rd.c
    public final void onStart() {
        this.f151717a.onStart();
    }

    @Override // rd.c
    public final void onStop() {
        this.f151717a.onStop();
    }

    @Override // rd.c
    public final void onViewCreated() {
        this.f151717a.onViewCreated();
    }

    public u(RealStartLiveController r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        this.f151717a = r100;
    }

    @Override // rd.c
    public final void a(com.bytedance.android.ec.adapter.api.state.c r100) {
        Intrinsics.checkNotNullParameter(r100, "ECUserState");
        this.f151717a.a(r100);
    }

    @Override // rd.c
    public final void b(td.d r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f151717a.b(new ak2.j(r100));
    }

    @Override // rd.c
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f151717a.onContextAttached(r100);
    }
}
