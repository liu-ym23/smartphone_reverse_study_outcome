package com.bytedance.android.live.recharge.panel.context;

import com.bytedance.android.live.revenue.common.t;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class PanelContextManager implements o, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<c> f90157a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.live.recharge.panel.context.e
    public final c i() {
        LinkedHashSet<c> r100 = this.f90157a;
        monitor-enter(r100);
        c r101 = (c) CollectionsKt.lastOrNull(this.f90157a);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public PanelContextManager() {
        this.f90157a = new LinkedHashSet();
    }

    @Override // com.bytedance.android.live.recharge.panel.context.e
    public final void h1(c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinkedHashSet<c> r101 = this.f90157a;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f90157a.add(r100) == false) goto L7;
        jy0.b.a("Recharge/PanelContextManager", "attach recharge panel context: " + r100 + " (" + t.a(r100) + ')');     // Catch: Throwable -> L12
    L8:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
        int r103 = h.f267513a;
        com.bytedance.revenue.platform.api.core.rx.f.a(h.a(new PanelContextManager$attachRechargePanelContext$2(this, r100)), r100.getCd());
        return;
    L7:
        jy0.b.f("Recharge/PanelContextManager", "recharge panel context already attached: " + r100 + " (" + t.a(r100) + ')', null, 4);     // Catch: Throwable -> L12
        goto L8
    }
}
