package com.a.c.a;

import com.a.c.b.b.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: CronDefinitionBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<com.a.c.b.b, com.a.c.b.b.c> f3080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<a> f3081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<e> f3082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3083d;

    /* JADX INFO: renamed from: com.a.c.a.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: CronDefinitionBuilder.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3084a = null;

        static {
            int[] r0 = new int[com.a.c.c.values().length];
            f3084a = r0;
            r0[com.a.c.c.f3138a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f3084a[com.a.c.c.f3139b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f3084a[com.a.c.c.f3140c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f3084a[com.a.c.c.f3141d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f3084a[com.a.c.c.f3142e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private d() {
        this.f3080a = new EnumMap(com.a.c.b.b.class);
        this.f3081b = new HashSet();
        this.f3082c = new HashSet();
    }

    public static d a() {
        return new d();
    }

    public com.a.c.b.b.d b() {
        return new com.a.c.b.b.d(this, com.a.c.b.b.f3104a);
    }

    public com.a.c.b.b.d c() {
        return new com.a.c.b.b.d(this, com.a.c.b.b.f3105b);
    }

    public com.a.c.b.b.d d() {
        return new com.a.c.b.b.d(this, com.a.c.b.b.f3106c);
    }

    public f e() {
        return new f(this, com.a.c.b.b.f3107d);
    }

    public com.a.c.b.b.d f() {
        return new com.a.c.b.b.d(this, com.a.c.b.b.f3108e);
    }

    public com.a.c.b.b.b g() {
        return new com.a.c.b.b.b(this, com.a.c.b.b.f);
    }

    public com.a.c.b.b.d h() {
        return new com.a.c.b.b.d(this, com.a.c.b.b.g);
    }

    public d i() {
        this.f3083d = true;
        return this;
    }

    public d j() {
        this.f3082c.add(e.f3085a);
        return this;
    }

    public d k() {
        this.f3082c.add(e.f3086b);
        return this;
    }

    public d l() {
        this.f3082c.add(e.f3087c);
        return this;
    }

    public d m() {
        this.f3082c.add(e.f3088d);
        return this;
    }

    public d n() {
        this.f3082c.add(e.f3089e);
        return this;
    }

    public d o() {
        this.f3082c.add(e.f);
        return this;
    }

    public d p() {
        this.f3082c.add(e.g);
        return this;
    }

    public d a(a r2) {
        this.f3081b.add(r2);
        return this;
    }

    public void a(com.a.c.b.b.c r5) {
        Iterator<com.a.c.b.b.c> r0 = this.f3080a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((com.a.c.b.b.c) ZeusTransformUtils.preCheckCast(r0.next(), com.a.c.b.b.c.class, "com.obric.aiagent.plugin")).d() == false) goto L4;
        boolean r1 = true;
    L10:
        if (r5.d() == true) goto L15;
        if (r1 == false) goto L15;
        throw new IllegalArgumentException("Can't register mandatory definition after a optional definition.");
    L15:
        this.f3080a.put(r5.b(), r5);
        return;
    L8:
        r1 = false;
        goto L10
    }

    public c q() {
        HashSet r0 = new HashSet();
        r0.addAll(this.f3081b);
        ArrayList r1 = new ArrayList(this.f3080a.values());
        r1.sort(com.a.c.b.b.c.e());
        return new c(r1, r0, this.f3082c, this.f3083d);
    }

    private static c r() {
        return a().c().e(0, 59).b().a().d().e(0, 23).b().a().e().c(0, 31).f().b().a().f().e(1, 12).b().a().g().a(0, 6).a(1).b().a().i().q();
    }

    private static c s() {
        return a().b().e(0, 59).a().c().e(0, 59).a().d().e(0, 23).a().e().c(1, 31).f().g().h().d().a().f().e(1, 12).a().g().a(1, 7).a(2).e().f().d().a().h().e(1970, 2099).b().c().a().a(b.a()).q();
    }

    private static c t() {
        return a().b().e(0, 59).b().a().c().e(0, 59).b().a().d().e(0, 23).b().a().e().c(1, 31).d().a().f().e(1, 12).a().g().a(0, 7).a(1).b(7, 0).e().d().a().q();
    }

    private static c u() {
        return a().b().e(0, 59).b().a().c().e(0, 59).b().a().d().e(0, 23).b().a().e().c(1, 31).f().g().h().d().a().f().e(1, 12).a().g().a(0, 7).a(1).b(7, 0).e().f().d().a().j().k().l().m().n().o().p().q();
    }

    private static c v() {
        return a().c().e(0, 59).b().a().d().e(0, 23).b().a().e().c(1, 31).b().a().f().e(1, 12).b().a().g().a(0, 7).a(1).b(7, 0).b().a().q();
    }

    public static c a(com.a.c.c r3) {
        int r0 = AnonymousClass1.f3084a[r3.ordinal()];
        if (r0 == 1) goto L23;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L17;
        if (r0 != 5) goto L15;
        return u();
    L15:
        throw new IllegalArgumentException(String.format("No cron definition found for %s", new Object[]{r3}));
    L17:
        return t();
    L19:
        return v();
    L21:
        return s();
    L23:
        return r();
    }
}
