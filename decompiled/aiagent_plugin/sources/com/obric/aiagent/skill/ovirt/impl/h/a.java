package com.obric.aiagent.skill.ovirt.impl.h;

import android.app.Application;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.skill.manager.api.al;
import com.obric.aiagent.skill.ovirt.impl.g.e;
import com.obric.aiagent.skill.ovirt.impl.g.i;
import com.obric.aiagent.skill.virt.api.IVirtService;
import com.obric.aiagent.skill.virt.api.x;
import com.obric.aiagent.skill.virt.api.y;
import com.obric.aiagent.skill.virt.api.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.c.g;
import d.h.a.s;
import d.h.b.l;
import d.h.b.o;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: ActiveTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f21446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final y f21448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.aiagent.skill.ovirt.impl.f.c f21449e;
    private final ca f;
    private final am g;
    private final i h;
    private final com.obric.aiagent.skill.ovirt.impl.g.b i;
    private final com.obric.aiagent.skill.ovirt.impl.a.a j;
    private final ConcurrentHashMap<String, com.obric.aiagent.skill.ovirt.impl.g.a> k;
    private volatile boolean l;

    /* JADX INFO: renamed from: com.obric.aiagent.skill.ovirt.impl.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActiveTask.kt */
    /* synthetic */ class C0450a extends l implements s<x, String, Long, String, d<? super z>, Object> {
        C0450a(Object r8) {
            super(5, r8, e.class, "executeSync", "executeSync(Lcom/obric/aiagent/skill/virt/api/VirtPath;Ljava/lang/String;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object a(x r10, String r11, long r12, String r14, d<? super z> r15) {
            x r3 = (x) ZeusTransformUtils.wrapperContextForParams(r10, x.class, "com.obric.aiagent.plugin");
            d<? super z> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r15, d.class, "com.obric.aiagent.plugin");
            return ((e) ZeusTransformUtils.preCheckCast(this.receiver, e.class, "com.obric.aiagent.plugin")).a(r3, r11, r12, r14, r8);
        }

        @Override // d.h.a.s
        public /* synthetic */ Object a(x r10, String r11, Long r12, String r13, d<? super z> r14) {
            return a((x) ZeusTransformUtils.preCheckCast(r10, x.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).longValue(), (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r14, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ActiveTask.kt */
    /* synthetic */ class b extends l implements s<x, String, Long, String, d<? super z>, Object> {
        b(Object r8) {
            super(5, r8, e.class, "executeSync", "executeSync(Lcom/obric/aiagent/skill/virt/api/VirtPath;Ljava/lang/String;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object a(x r10, String r11, long r12, String r14, d<? super z> r15) {
            x r3 = (x) ZeusTransformUtils.wrapperContextForParams(r10, x.class, "com.obric.aiagent.plugin");
            d<? super z> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r15, d.class, "com.obric.aiagent.plugin");
            return ((e) ZeusTransformUtils.preCheckCast(this.receiver, e.class, "com.obric.aiagent.plugin")).a(r3, r11, r12, r14, r8);
        }

        @Override // d.h.a.s
        public /* synthetic */ Object a(x r10, String r11, Long r12, String r13, d<? super z> r14) {
            return a((x) ZeusTransformUtils.preCheckCast(r10, x.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).longValue(), (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r14, d.class, "com.obric.aiagent.plugin"));
        }
    }

    public a(String r6, Map<String, String> r7, IVirtService r8, e r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        IVirtService r11 = (IVirtService) ZeusTransformUtils.wrapperContextForParams(r8, IVirtService.class, "com.obric.aiagent.plugin");
        o.e(r6, "uniqueId");
        o.e(r10, "env");
        o.e(r11, "virt");
        o.e(r9, "shellCapability");
        this.f21445a = r6;
        this.f21446b = r10;
        String r12 = c.c(r6);
        this.f21447c = r12;
        y r13 = r11.getLifecycle().getPaths();
        this.f21448d = r13;
        this.f21449e = new com.obric.aiagent.skill.ovirt.impl.f.c(r11, r13, (s) ZeusTransformUtils.preCheckCast(new b(r9), s.class, "com.obric.aiagent.plugin"));
        ca r0 = (ca) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), ca.class, "com.obric.aiagent.plugin");
        this.f = r0;
        this.g = an.a(r0.plus((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")));
        this.h = new i(new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir(), "skillruntime/shell-output"), r12, al.f19195a.a().I());
        this.i = new com.obric.aiagent.skill.ovirt.impl.g.b(r11, r13);
        this.j = new com.obric.aiagent.skill.ovirt.impl.a.a(al.f19195a.a().J(), (s) ZeusTransformUtils.preCheckCast(new C0450a(r9), s.class, "com.obric.aiagent.plugin"));
        this.k = new ConcurrentHashMap();
    }

    public final String a() {
        return this.f21445a;
    }

    public final Map<String, String> b() {
        return this.f21446b;
    }

    public final String c() {
        return this.f21447c;
    }

    public final y d() {
        return this.f21448d;
    }

    public final com.obric.aiagent.skill.ovirt.impl.f.c e() {
        return this.f21449e;
    }

    public final ca f() {
        return this.f;
    }

    public final am g() {
        return this.g;
    }

    public final i h() {
        return this.h;
    }

    public final com.obric.aiagent.skill.ovirt.impl.g.b i() {
        return this.i;
    }

    public final com.obric.aiagent.skill.ovirt.impl.a.a j() {
        return this.j;
    }

    public final ConcurrentHashMap<String, com.obric.aiagent.skill.ovirt.impl.g.a> k() {
        return this.k;
    }

    public final void a(boolean r1) {
        this.l = r1;
    }

    public final boolean l() {
        return this.l;
    }

    public final void a(com.obric.aiagent.skill.ovirt.impl.g.a r3) {
        o.e(r3, "execution");
        ((Map) ZeusTransformUtils.preCheckCast(this.k, Map.class, "com.obric.aiagent.plugin")).put(r3.a(), r3);
    }

    public final void b(com.obric.aiagent.skill.ovirt.impl.g.a r2) {
        o.e(r2, "execution");
        this.k.remove(r2.a(), r2);
    }
}
