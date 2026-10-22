package jb;

import android.view.Choreographer;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0282a f20949e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f20950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f20951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function3 f20952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2 f20953d;

    /* JADX INFO: renamed from: jb.a$a, reason: collision with other inner class name */
    public static final class C0282a {
        public C0282a() {
        }

        public /* synthetic */ C0282a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f20954a;

        public b(a r10) {
            this.f20954a = r10;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long r12) {
            if (a.b(this.f20954a).p() == false) goto L9;
            if (a.b(this.f20954a).l() != null) goto L9;
            qb.b.f23627c.e("AnimatableRunner", "doFrame, view is null");
            return;
        L9:
            if (a.b(this.f20954a).j() != 0) goto L11;
            a.b(this.f20954a).z(r12);
        L11:
            float r10 = a.b(this.f20954a).k();
            if (a.b(this.f20954a).n() == false) goto L22;
            if (r10 <= 0) goto L22;
            long r11 = ((long) (1.0E9f / r10)) - ((long) 1000000);
            long r13 = a.b(this.f20954a).e();
            if (r13 == 0) goto L22;
            if ((r12 - r13) >= r11) goto L22;
            Choreographer.getInstance().postFrameCallback(this);
            return;
        L22:
            if (a.b(this.f20954a).e() == 0) goto L24;
            float r14 = 1.0f / ((r12 - a.b(this.f20954a).e()) / 1.0E9f);
            qb.b.f23627c.e("AnimatableRunner", "doFrame, 当前刷新率: " + r14 + " Hz");
        L24:
            a.b(this.f20954a).t(r12);
            if (a.b(this.f20954a).o() == false) goto L30;
            if (a.b(this.f20954a).f() != 0) goto L51;
            a.b(this.f20954a).v(r12);
            return;
        L51:
            return;
        L30:
            if (a.b(this.f20954a).f() <= 0) goto L32;
            a.b(this.f20954a).q(a.b(this.f20954a).b() + (r12 - a.b(this.f20954a).f()));
            a.b(this.f20954a).v(0);
        L32:
            long r15 = (r12 - a.b(this.f20954a).j()) - a.b(this.f20954a).b();
            int r16 = jb.b.f20955a[a.b(this.f20954a).h().ordinal()];
            if (r16 == 1) goto L37;
            if (r16 != 2) goto L39;
            a.e(this.f20954a, r15, r12);
        L39:
            if (a.b(this.f20954a).m() == false) goto L41;
            Choreographer.getInstance().postFrameCallback(this);
            return;
        L41:
            Choreographer.getInstance().removeFrameCallback(this);
            int r17 = jb.b.f20956b[a.b(this.f20954a).g().ordinal()];
            if (r17 == 1) goto L49;
            if (r17 != 2) goto L45;
            qb.b.f23627c.e("AnimatableRunner", "doFrame, 触发 reverse");
            a.b(this.f20954a).r(b0.p0(a.b(this.f20954a).c()));
            a.c(this.f20954a, true);
            Choreographer.getInstance().postFrameCallback(this);
            return;
        L45:
            if (r17 != 3) goto L56;
            a.a(this.f20954a, true);
            return;
        L56:
            return;
        L49:
            qb.b.f23627c.e("AnimatableRunner", "doFrame, 触发 loop");
            a.c(this.f20954a, false);
            Choreographer.getInstance().postFrameCallback(this);
            return;
        L37:
            a.d(this.f20954a, r15, r12);
            goto L39
        }
    }

    static {
        f20949e = new C0282a(null);
    }

    public a(c r10, Function3 r11, Function2 r12) {
        q.g(r10, "stateManager");
        this.f20951b = r10;
        this.f20952c = r11;
        this.f20953d = r12;
        this.f20950a = new b(this);
    }

    public static final /* synthetic */ void a(a r10, boolean r11) {
        r10.g(r11);
    }

    public static final /* synthetic */ c b(a r10) {
        return r10.f20951b;
    }

    public static final /* synthetic */ void c(a r10, boolean r11) {
        r10.k(r11);
    }

    public static final /* synthetic */ void d(a r10, long r11, long r12) {
        r10.l(r11, r12);
    }

    public static final /* synthetic */ void e(a r10, long r11, long r12) {
        r10.m(r11, r12);
    }

    public static /* synthetic */ boolean i(a r10, String r11, long r12, gb.a r13, long r14, boolean r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        boolean r15 = true;
    L7:
        return r10.h(r11, r12, r13, r14, r15);
    L5:
        r15 = r16;
        goto L7
    }

    public final void f(boolean r10) {
        qb.b.f23627c.e("AnimatableRunner", "cancelAnimation, clearVelocity: " + r10);
        Choreographer.getInstance().removeFrameCallback(this.f20950a);
        this.f20951b.a(r10);
        Function2 r11 = this.f20953d;
        if (r11 == null) goto L5;
        Unit r12 = (Unit) r11.mo0invoke(Boolean.FALSE, null);
    L5:
        j("cancelAnimation");
    }

    public final void g(boolean r10) {
        qb.b.f23627c.e("AnimatableRunner", "endAnimationInternal, clearVelocity: " + r10);
        Choreographer.getInstance().removeFrameCallback(this.f20950a);
        this.f20951b.a(r10);
        j("endAnimationInternal");
    }

    public final boolean h(String r10, long r11, gb.a r12, long r13, boolean r14) {
        long r15 = (long) (r11 * this.f20951b.i());
        Object r16 = r12.i(r15);
        View r17 = this.f20951b.l();
        if (r12.c() != (-1)) goto L5;
        r12.n(r13);
    L5:
        boolean r18 = r12.k(r15);
        if (r17 == null) goto L12;
        String r19 = r12.f();
        if (r18 == false) goto L10;
        Object r20 = r12.h();
    L11:
        defpackage.d.d(r17, r19, r20);
        goto L12
    L10:
        r20 = r16;
    L12:
        r12.p(r13);
        r12.q(!r18);
        float r21 = r12.j(r15);
        if (r18 == true) goto L15;
        Function3 r22 = this.f20952c;
        if (r22 == null) goto L26;
        Unit r23 = (Unit) r22.invoke(r12.f(), r16, Float.valueOf(r21));
    L26:
        return r18;
    L15:
        if (r14 == false) goto L22;
        qb.b.f23627c.e("AnimatableRunner", "executeAnimation, " + r10 + ", return case 1, property: " + r12.f() + ", targetValue: " + r12.h());
        Function3 r24 = this.f20952c;
        if (r24 == null) goto L19;
        Unit r25 = (Unit) r24.invoke(r12.f(), r12.h(), Float.valueOf(r21));
    L19:
        Function2 r26 = this.f20953d;
        if (r26 == null) goto L26;
        Unit r27 = (Unit) r26.mo0invoke(Boolean.TRUE, null);
        goto L26
    L22:
        qb.b.f23627c.e("AnimatableRunner", "executeAnimation, " + r10 + ", return case 2, property: " + r12.f() + ", targetValue: " + r12.h());
        goto L26
    }

    public final void j(String r10) {
        qb.b.f23627c.a("AnimatableRunner", "releaseCallbacks, scene: " + r10);
        this.f20952c = null;
        this.f20953d = null;
    }

    public final void k(boolean r10) {
        View r11 = this.f20951b.l();
        Iterator r12 = this.f20951b.c().iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        gb.a r13 = (gb.a) r12.next();
        if (r11 == null) goto L12;
        String r14 = r13.f();
        if (r10 == false) goto L10;
        Object r15 = r13.h();
    L11:
        defpackage.d.d(r11, r14, r15);
        goto L12
    L10:
        r15 = r13.d();
    L12:
        r13.m(true, r10, true);
        goto L4
    L13:
        this.f20951b.z(0);
        this.f20951b.v(0);
        this.f20951b.q(0);
        this.f20951b.t(0);
        this.f20951b.s(-1);
    }

    public final void l(long r15, long r17) {
        List r10 = this.f20951b.c();
        int r11 = 0;
        if (r10.size() <= 1) goto L14;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        Object r14 = r13.next();
        if (((gb.a) r14).l() == false) goto L6;
        r12.add(r14);
        goto L6
    L11:
        if (r12.size() == 1) goto L14;
        boolean r16 = false;
    L15:
        Iterator r18 = r10.iterator();
        int r19 = 0;
    L17:
        if (r18.hasNext() == false) goto L27;
        Object r20 = r18.next();
        int r110 = r11 + 1;
        if (r11 >= 0) goto L21;
        t.q();
    L21:
        gb.a r21 = (gb.a) r20;
        if (r21.l() == true) goto L24;
    L25:
        r19 = r19 + 1;
    L26:
        r11 = r110;
        goto L17
    L24:
        if (h("runParallelAnimations", r15, r21, r17, r16) == false) goto L26;
    L27:
        if (r16 == false) goto L29;
        return;
    L29:
        if (r19 != r10.size()) goto L43;
        qb.b.f23627c.a("AnimatableRunner", "runParallelAnimations, all finished");
        Function2 r22 = this.f20953d;
        if (r22 == null) goto L44;
        Unit r23 = (Unit) r22.mo0invoke(Boolean.TRUE, null);
        return;
    L44:
        return;
    L43:
        return;
    L14:
        r16 = true;
        goto L15
    }

    public final void m(long r12, long r14) {
        if (this.f20951b.d() != (-1)) goto L6;
        this.f20951b.s(0);
    L6:
        if (this.f20951b.d() < this.f20951b.c().size()) goto L9;
        qb.b.f23627c.a("AnimatableRunner", "runSequentialAnimations, return case 1");
        return;
    L9:
        long r10 = (long) (r12 * this.f20951b.i());
        gb.a r11 = (gb.a) this.f20951b.c().get(this.f20951b.d());
        boolean r13 = r11.k(r10);
        r11.q(!r13);
        if (r13 == false) goto L18;
        h("runSequentialAnimations 1", r12, r11, r14, false);
        c r15 = this.f20951b;
        r15.s(r15.d() + 1);
        if (this.f20951b.d() < this.f20951b.c().size()) goto L17;
        qb.b.f23627c.a("AnimatableRunner", "runSequentialAnimations, return case 2");
        Function2 r16 = this.f20953d;
        if (r16 == null) goto L20;
        Unit r17 = (Unit) r16.mo0invoke(Boolean.TRUE, null);
        return;
    L20:
        return;
    L17:
        this.f20951b.z(0);
        this.f20951b.v(0);
        this.f20951b.q(0);
        this.f20951b.t(0);
        i(this, "runSequentialAnimations 2", 0, (gb.a) this.f20951b.c().get(this.f20951b.d()), r14, false, 16, null);
        return;
    L18:
        i(this, "runSequentialAnimations 3", r12, r11, r14, false, 16, null);
    }

    public final void n() {
        Choreographer.getInstance().postFrameCallback(this.f20950a);
    }
}
