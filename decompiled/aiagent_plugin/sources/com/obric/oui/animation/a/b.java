package com.obric.oui.animation.a;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b<T extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f33942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.b.a.a.a> f33943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<com.obric.oui.animation.engine.c<? super T>, com.obric.oui.animation.engine.d> f33944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f33945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f33946e;
    private a<T> f;
    private com.obric.oui.animation.engine.b.c g;

    /* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
    public interface a<T extends View> {
        void a(b<T> r1);

        void b(b<T> r1);

        void c(b<T> r1);
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
    static final class C0921b extends p implements d.h.a.b<com.obric.oui.animation.a.a, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0921b f33947a = null;

        static {
            f33947a = new C0921b();
        }

        C0921b() {
            super(1);
        }

        public final void a(com.obric.oui.animation.a.a r1) {
            o.e(r1, "$this$null");
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.a r3) {
            a((com.obric.oui.animation.a.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.a.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
    public static final class c implements com.obric.oui.animation.engine.b.InterfaceC0923b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b<T> f33948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.animation.engine.c<? super T> f33949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f33950c;

        c(b<T> r1, com.obric.oui.animation.engine.c<? super T> r2, d r3) {
            this.f33948a = r1;
            this.f33949b = r2;
            this.f33950c = r3;
        }

        @Override // com.obric.oui.animation.engine.b.InterfaceC0923b
        public void a(com.obric.oui.animation.engine.b<? extends com.obric.oui.animation.engine.b<?>> r2, boolean r3, float r4, float r5) {
            b.b(this.f33948a).remove(this.f33949b);
            if (r2 == null) goto L6;
            r2.b((com.obric.oui.animation.engine.b.InterfaceC0923b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.animation.engine.b.InterfaceC0923b.class, "com.obric.aiagent.plugin"));
        L6:
            if (r2 == null) goto L9;
            r2.b((com.obric.oui.animation.engine.b.c) ZeusTransformUtils.preCheckCast(this.f33950c, com.obric.oui.animation.engine.b.c.class, "com.obric.aiagent.plugin"));
        L9:
            b.a(this.f33948a, null);
            if (b.b(this.f33948a).isEmpty() == false) goto L17;
            if (r3 == true) goto L18;
            a r6 = b.c(this.f33948a);
            if (r6 == null) goto L19;
            r6.c(this.f33948a);
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    /* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
    public static final class d implements com.obric.oui.animation.engine.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b<T> f33951a;

        d(b<T> r1) {
            this.f33951a = r1;
        }

        @Override // com.obric.oui.animation.engine.b.c
        public void onAnimationUpdate(com.obric.oui.animation.engine.b<? extends com.obric.oui.animation.engine.b<?>> r1, float r2, float r3) {
            com.obric.oui.animation.engine.b.c r0 = b.a(this.f33951a);
            if (r0 == null) goto L7;
            r0.onAnimationUpdate(r1, r2, r3);
            return;
        }
    }

    /* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
    static final class e extends p implements d.h.a.b<b<T>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f33952a = null;

        static {
            f33952a = new e();
        }

        e() {
            super(1);
        }

        public final void a(b<T> r1) {
            o.e(r1, "it");
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Object r3) {
            a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
    static final class f extends p implements d.h.a.b<b<T>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f33953a = null;

        static {
            f33953a = new f();
        }

        f() {
            super(1);
        }

        public final void a(b<T> r1) {
            o.e(r1, "it");
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Object r3) {
            a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
    static final class g extends p implements d.h.a.b<b<T>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f33954a = null;

        static {
            f33954a = new g();
        }

        g() {
            super(1);
        }

        public final void a(b<T> r1) {
            o.e(r1, "it");
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Object r3) {
            a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: ViewPropertySpringAnimator.kt */
    public static final class h implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<b<T>, x> f33955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<b<T>, x> f33956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<b<T>, x> f33957c;

        h(d.h.a.b<? super b<T>, x> r3, d.h.a.b<? super b<T>, x> r4, d.h.a.b<? super b<T>, x> r5) {
            d.h.a.b<b<T>, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.a.b<b<T>, x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.a.b<b<T>, x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
            this.f33955a = r6;
            this.f33956b = r7;
            this.f33957c = r8;
        }

        @Override // com.obric.oui.animation.a.b.a
        public void a(b<T> r2) {
            o.e(r2, "animator");
            this.f33955a.invoke(r2);
        }

        @Override // com.obric.oui.animation.a.b.a
        public void b(b<T> r2) {
            o.e(r2, "animator");
            this.f33956b.invoke(r2);
        }

        @Override // com.obric.oui.animation.a.b.a
        public void c(b<T> r2) {
            o.e(r2, "animator");
            this.f33957c.invoke(r2);
        }
    }

    public b(T r3) {
        o.e(r3, "view");
        this.f33942a = r3;
        this.f33943b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.f33944c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f33945d = 0.5f;
        this.f33946e = 1500.0f;
    }

    public static final /* synthetic */ com.obric.oui.animation.engine.b.c a(b r0) {
        return r0.g;
    }

    public static final /* synthetic */ void a(b r2, com.obric.oui.animation.engine.b.c r3) {
        r2.g = (com.obric.oui.animation.engine.b.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.animation.engine.b.c.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ Map b(b r0) {
        return r0.f33944c;
    }

    public static final /* synthetic */ a c(b r0) {
        return r0.f;
    }

    public final boolean a() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.f33944c.values(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if (((com.obric.oui.animation.engine.d) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.oui.animation.engine.d.class, "com.obric.aiagent.plugin")).c() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    public final b<T> a(float r4) {
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f33945d = r4;
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
    }

    public final b<T> b(float r4) {
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f33946e = r4;
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
    }

    public final b<T> a(float r4, d.h.a.b<? super com.obric.oui.animation.a.a, x> r5) {
        d.h.a.b<? super com.obric.oui.animation.a.a, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r6, "config");
        com.obric.oui.animation.engine.b.d r0 = com.obric.oui.animation.engine.b.f33972b;
        o.c(r0, "TRANSLATION_Y");
        return a((com.obric.oui.animation.engine.c) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.animation.engine.c.class, "com.obric.aiagent.plugin"), r4, r6);
    }

    public static /* synthetic */ b a(b r1, com.obric.oui.animation.engine.c r2, float r3, d.h.a.b r4, int r5, Object r6) {
        d.h.a.b<? super com.obric.oui.animation.a.a, x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r7 = (d.h.a.b) ZeusTransformUtils.preCheckCast(C0921b.f33947a, d.h.a.b.class, "com.obric.aiagent.plugin");
    L6:
        return r1.a(r2, r3, r7);
    }

    public final b<T> a(com.obric.oui.animation.engine.c<? super T> r4, float r5, d.h.a.b<? super com.obric.oui.animation.a.a, x> r6) {
        d.h.a.b<? super com.obric.oui.animation.a.a, x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "property");
        o.e(r7, "config");
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).b(r4, r5, r7);
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
    }

    public final b<T> b() {
        b<T> r2 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
        if (r2.f33943b.isEmpty() == true) goto L14;
        List r3 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r2.f33943b, Iterable.class, "com.obric.aiagent.plugin"));
        r2.f33943b.clear();
        a<T> r4 = r2.f;
        if (r4 == null) goto L9;
        r4.a(r2);
    L9:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r5.hasNext() == false) goto L14;
        ((com.b.a.a.a) ZeusTransformUtils.preCheckCast(r5.next(), com.b.a.a.a.class, "com.obric.aiagent.plugin")).a();
    L14:
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
    }

    public final void c() {
        this.f33943b.clear();
        List r0 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f33944c.values(), Iterable.class, "com.obric.aiagent.plugin"));
        this.f33944c.clear();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.obric.oui.animation.engine.d) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.oui.animation.engine.d.class, "com.obric.aiagent.plugin")).b();
        goto L4
    L6:
        a<T> r2 = this.f;
        if (r2 == null) goto L12;
        r2.b(this);
        return;
    }

    public final void d() {
        this.f33943b.clear();
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f33944c.values(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r2 = r5.next();
        if (((com.obric.oui.animation.engine.d) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.animation.engine.d.class, "com.obric.aiagent.plugin")).g() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        ((com.obric.oui.animation.engine.d) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.oui.animation.engine.d.class, "com.obric.aiagent.plugin")).f();
        goto L10
    }

    public static /* synthetic */ b a(b r1, d.h.a.b r2, d.h.a.b r3, d.h.a.b r4, int r5, Object r6) {
        d.h.a.b<? super b<T>, x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super b<T>, x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super b<T>, x> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = (d.h.a.b) ZeusTransformUtils.preCheckCast(e.f33952a, d.h.a.b.class, "com.obric.aiagent.plugin");
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = (d.h.a.b) ZeusTransformUtils.preCheckCast(f.f33953a, d.h.a.b.class, "com.obric.aiagent.plugin");
    L9:
        if ((r5 & 4) == 0) goto L12;
        r9 = (d.h.a.b) ZeusTransformUtils.preCheckCast(g.f33954a, d.h.a.b.class, "com.obric.aiagent.plugin");
    L12:
        return r1.a(r7, r8, r9);
    }

    public final b<T> a(d.h.a.b<? super b<T>, x> r3, d.h.a.b<? super b<T>, x> r4, d.h.a.b<? super b<T>, x> r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r6, "onStart");
        o.e(r7, "onCancel");
        o.e(r8, "onEnd");
        return a((a) ZeusTransformUtils.preCheckCast(new h(r6, r7, r8), a.class, "com.obric.aiagent.plugin"));
    }

    public final b<T> a(a<T> r4) {
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
    }

    public final void a(com.obric.oui.animation.engine.b.c r3) {
        com.obric.oui.animation.engine.b.c r4 = (com.obric.oui.animation.engine.b.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.animation.engine.b.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.g = r4;
    }

    private final void b(com.obric.oui.animation.engine.c<? super T> r4, float r5, d.h.a.b<? super com.obric.oui.animation.a.a, x> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.animation.engine.d r0 = (com.obric.oui.animation.engine.d) ZeusTransformUtils.preCheckCast(this.f33944c.get(r4), com.obric.oui.animation.engine.d.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = new com.obric.oui.animation.engine.d(this.f33942a, r4);
        a(r0, r4);
        this.f33944c.put(r4, r0);
    L5:
        com.obric.oui.animation.a.a r8 = new com.obric.oui.animation.a.a(r5);
        r7.invoke(r8);
        r8.b(this.f33945d);
        r8.d(this.f33946e);
        ((Collection) ZeusTransformUtils.preCheckCast(this.f33943b, Collection.class, "com.obric.aiagent.plugin")).add(new com.b.a.a.a(r0, r8));
    }

    private final void a(com.obric.oui.animation.engine.d r4, com.obric.oui.animation.engine.c<? super T> r5) {
        d r0 = new d(this);
        r4.a((com.obric.oui.animation.engine.b.c) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.animation.engine.b.c.class, "com.obric.aiagent.plugin"));
        r4.a((com.obric.oui.animation.engine.b.InterfaceC0923b) ZeusTransformUtils.preCheckCast(new c(this, r5, r0), com.obric.oui.animation.engine.b.InterfaceC0923b.class, "com.obric.aiagent.plugin"));
    }
}
