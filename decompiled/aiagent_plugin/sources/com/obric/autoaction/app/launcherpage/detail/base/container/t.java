package com.obric.autoaction.app.launcherpage.detail.base.container;

import com.obric.eventkit.task.model.PeriodicPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: DetailRepeatViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements com.obric.autoaction.app.launcherpage.detail.base.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PeriodicPolicy f23350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f23351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a f23352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<com.obric.autoaction.app.launcherpage.utils.j<Integer>> f23353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f23354e;
    private Integer f;
    private Integer g;

    public t(PeriodicPolicy r3, boolean r4, com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a r5, List<com.obric.autoaction.app.launcherpage.utils.j<Integer>> r6, Integer r7, Integer r8, Integer r9) {
        List<com.obric.autoaction.app.launcherpage.utils.j<Integer>> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "periodicPolicy");
        d.h.b.o.e(r5, "repeatMode");
        this.f23350a = r3;
        this.f23351b = r4;
        this.f23352c = r5;
        this.f23353d = r10;
        this.f23354e = r7;
        this.f = r8;
        this.g = r9;
    }

    public final PeriodicPolicy a() {
        return this.f23350a;
    }

    public final void a(PeriodicPolicy r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.f23350a = r2;
    }

    public final boolean b() {
        return this.f23351b;
    }

    public final void a(com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a r2) {
        d.h.b.o.e(r2, "<set-?>");
        this.f23352c = r2;
    }

    public final com.obric.autoaction.app.launcherpage.condition.a.EnumC0493a c() {
        return this.f23352c;
    }

    public final void a(List<com.obric.autoaction.app.launcherpage.utils.j<Integer>> r3) {
        this.f23353d = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final List<com.obric.autoaction.app.launcherpage.utils.j<Integer>> d() {
        return this.f23353d;
    }

    public final void a(Integer r1) {
        this.f23354e = r1;
    }

    public final Integer e() {
        return this.f23354e;
    }

    public final void b(Integer r1) {
        this.f = r1;
    }

    public final Integer f() {
        return this.f;
    }

    public final void c(Integer r1) {
        this.g = r1;
    }

    public final Integer g() {
        return this.g;
    }
}
