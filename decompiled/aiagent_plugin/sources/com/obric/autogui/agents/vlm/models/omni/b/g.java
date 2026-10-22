package com.obric.autogui.agents.vlm.models.omni.b;

import d.a.p;
import java.util.List;

/* JADX INFO: compiled from: OmniGuiToolTraceSchema.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f28231a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f28232b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<a> f28233c = null;

    private g() {
    }

    public final a a() {
        return f28232b;
    }

    static {
        g r0 = new g();
        f28231a = r0;
        f28232b = r0.a("core_total_duration_ms", f.f28226a, f.f28230e);
        f28233c = p.b(new a[]{r0.a("core_accept_queue_duration_ms", f.f28226a, f.f28227b), r0.a("core_action_exec_duration_ms", f.f28227b, f.f28228c), r0.a("core_post_action_check_duration_ms", f.f28228c, f.f28229d), r0.a("core_result_prepare_duration_ms", f.f28229d, f.f28230e)});
    }

    public final List<a> b() {
        return f28233c;
    }

    private final a a(String r1, f r2, f r3) {
        return new a(r1, r2, r3);
    }
}
