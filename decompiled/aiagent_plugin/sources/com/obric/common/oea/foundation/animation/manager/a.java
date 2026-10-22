package com.obric.common.oea.foundation.animation.manager;

import android.view.Choreographer;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.m;
import d.h.a.q;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AnimatableRunner.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "AnimatableRunner";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0888a f32450a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimatableRunner$frameCallback$1 f32451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f32452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private q<? super String, Object, ? super Float, x> f32453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private m<? super Boolean, ? super Throwable, x> f32454e;

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.manager.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimatableRunner.kt */
    public static final class C0888a {
        private C0888a() {
        }

        public /* synthetic */ C0888a(h r1) {
            this();
        }
    }

    static {
        f32450a = new C0888a(null);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.obric.common.oea.foundation.animation.manager.AnimatableRunner$frameCallback$1] */
    public a(c r3, q<? super String, Object, ? super Float, x> r4, m<? super Boolean, ? super Throwable, x> r5) {
        q<? super String, Object, ? super Float, x> r6 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        m<? super Boolean, ? super Throwable, x> r7 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        o.e(r3, "stateManager");
        this.f32452c = r3;
        this.f32453d = r6;
        this.f32454e = r7;
        this.f32451b = new AnimatableRunner$frameCallback$1(this);
    }

    public static final /* synthetic */ c a(a r0) {
        return r0.f32452c;
    }

    public static final /* synthetic */ void a(a r0, long r1, long r3) {
        r0.a(r1, r3);
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void b(a r0, long r1, long r3) {
        r0.b(r1, r3);
    }

    public static final /* synthetic */ void b(a r0, boolean r1) {
        r0.c(r1);
    }

    private final void a(long r17, long r19) {
        List<com.obric.common.oea.foundation.animation.a<?>> r9 = this.f32452c.j();
        int r1 = 0;
        if (r9.size() <= 1) goto L14;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();
        if (((com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r4, com.obric.common.oea.foundation.animation.a.class, "com.obric.aiagent.plugin")).c() == false) goto L6;
        r2.add(r4);
        goto L6
    L11:
        if (((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")).size() == 1) goto L14;
        boolean r12 = false;
    L15:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r14 = 0;
    L17:
        if (r13.hasNext() == false) goto L27;
        Object r5 = r13.next();
        int r15 = r1 + 1;
        if (r1 >= 0) goto L21;
        p.c();
    L21:
        com.obric.common.oea.foundation.animation.a<?> r6 = (com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r5, com.obric.common.oea.foundation.animation.a.class, "com.obric.aiagent.plugin");
        if (r6.c() == true) goto L24;
    L25:
        r14 = r14 + 1;
    L26:
        r1 = r15;
        goto L17
    L24:
        if (a("runParallelAnimations", r17, r6, r19, r12) == false) goto L26;
    L27:
        if (r12 == false) goto L29;
        return;
    L29:
        if (r14 != r9.size()) goto L43;
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "runParallelAnimations, all finished");
        m<? super Boolean, ? super Throwable, x> r7 = this.f32454e;
        if (r7 == null) goto L44;
        x r8 = (x) ZeusTransformUtils.preCheckCast(r7.invoke(true, null), x.class, "com.obric.aiagent.plugin");
        return;
    L44:
        return;
    L43:
        return;
    L14:
        r12 = true;
        goto L15
    }

    private final void b(long r12, long r14) {
        if (this.f32452c.p() != (-1)) goto L6;
        this.f32452c.a(0);
    L6:
        if (this.f32452c.p() < this.f32452c.j().size()) goto L9;
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "runSequentialAnimations, return case 1");
        return;
    L9:
        long r0 = (long) (r12 * this.f32452c.k());
        com.obric.common.oea.foundation.animation.a<?> r4 = (com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(this.f32452c.j().get(this.f32452c.p()), com.obric.common.oea.foundation.animation.a.class, "com.obric.aiagent.plugin");
        boolean r1 = r4.e(r0);
        r4.a(!r1);
        if (r1 == false) goto L18;
        a("runSequentialAnimations 1", r12, r4, r14, false);
        c r2 = this.f32452c;
        r2.a(r2.p() + 1);
        if (this.f32452c.p() < this.f32452c.j().size()) goto L17;
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "runSequentialAnimations, return case 2");
        m<? super Boolean, ? super Throwable, x> r3 = this.f32454e;
        if (r3 == null) goto L20;
        x r5 = (x) ZeusTransformUtils.preCheckCast(r3.invoke(true, null), x.class, "com.obric.aiagent.plugin");
        return;
    L20:
        return;
    L17:
        this.f32452c.a(0);
        this.f32452c.c(0);
        this.f32452c.d(0);
        this.f32452c.b(0);
        a(this, "runSequentialAnimations 2", 0, (com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(this.f32452c.j().get(this.f32452c.p()), com.obric.common.oea.foundation.animation.a.class, "com.obric.aiagent.plugin"), r14, false, 16, null);
        return;
    L18:
        a(this, "runSequentialAnimations 3", r12, r4, r14, false, 16, null);
    }

    static /* synthetic */ boolean a(a r9, String r10, long r11, com.obric.common.oea.foundation.animation.a r13, long r14, boolean r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        boolean r8 = true;
    L7:
        return r9.a(r10, r11, r13, r14, r8);
    L5:
        r8 = r16;
        goto L7
    }

    private final boolean a(String r7, long r8, com.obric.common.oea.foundation.animation.a<?> r10, long r11, boolean r13) {
        long r9 = (long) (r8 * this.f32452c.k());
        Object r0 = r10.c(r9);
        View r1 = this.f32452c.g();
        if (r10.b() != (-1)) goto L5;
        r10.a(r11);
    L5:
        boolean r2 = r10.e(r9);
        if (r1 == null) goto L12;
        String r3 = r10.e();
        if (r2 == false) goto L10;
        Object r4 = r10.g();
    L11:
        defpackage.c.a(r1, r3, r4);
        goto L12
    L10:
        r4 = r0;
    L12:
        r10.b(r11);
        r10.a(!r2);
        float r12 = r10.d(r9);
        if (r2 == true) goto L15;
        q<? super String, Object, ? super Float, x> r6 = this.f32453d;
        if (r6 == null) goto L26;
        x r14 = (x) ZeusTransformUtils.preCheckCast(r6.invoke(r10.e(), r0, Float.valueOf(r12)), x.class, "com.obric.aiagent.plugin");
    L26:
        return r2;
    L15:
        if (r13 == false) goto L22;
        com.obric.common.oea.foundation.b.c.f32472a.c(TAG, "executeAnimation, " + r7 + ", return case 1, property: " + r10.e() + ", targetValue: " + r10.g());
        q<? super String, Object, ? super Float, x> r15 = this.f32453d;
        if (r15 == null) goto L19;
        x r16 = (x) ZeusTransformUtils.preCheckCast(r15.invoke(r10.e(), r10.g(), Float.valueOf(r12)), x.class, "com.obric.aiagent.plugin");
    L19:
        m<? super Boolean, ? super Throwable, x> r17 = this.f32454e;
        if (r17 == null) goto L26;
        x r18 = (x) ZeusTransformUtils.preCheckCast(r17.invoke(true, null), x.class, "com.obric.aiagent.plugin");
        goto L26
    L22:
        com.obric.common.oea.foundation.b.c.f32472a.c(TAG, "executeAnimation, " + r7 + ", return case 2, property: " + r10.e() + ", targetValue: " + r10.g());
        goto L26
    }

    private final void b(boolean r7) {
        View r0 = this.f32452c.g();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f32452c.j(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        com.obric.common.oea.foundation.animation.a r2 = (com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.common.oea.foundation.animation.a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L12;
        String r4 = r2.e();
        if (r7 == false) goto L10;
        Object r5 = r2.g();
    L11:
        defpackage.c.a(r0, r4, r5);
        goto L12
    L10:
        r5 = r2.f();
    L12:
        r2.a(true, r7, true);
        goto L4
    L13:
        this.f32452c.a(0);
        this.f32452c.c(0);
        this.f32452c.d(0);
        this.f32452c.b(0);
        this.f32452c.a(-1);
    }

    public final void a() {
        Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this.f32451b, Choreographer.FrameCallback.class, "com.obric.aiagent.plugin"));
    }

    private final void c(boolean r5) {
        com.obric.common.oea.foundation.b.c.f32472a.c(TAG, "endAnimationInternal, clearVelocity: " + r5);
        Choreographer.getInstance().removeFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this.f32451b, Choreographer.FrameCallback.class, "com.obric.aiagent.plugin"));
        this.f32452c.a(r5);
        a("endAnimationInternal");
    }

    public final void a(boolean r5) {
        com.obric.common.oea.foundation.b.c.f32472a.c(TAG, "cancelAnimation, clearVelocity: " + r5);
        Choreographer.getInstance().removeFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this.f32451b, Choreographer.FrameCallback.class, "com.obric.aiagent.plugin"));
        this.f32452c.a(r5);
        m<? super Boolean, ? super Throwable, x> r6 = this.f32454e;
        if (r6 == null) goto L5;
        x r7 = (x) ZeusTransformUtils.preCheckCast(r6.invoke(false, null), x.class, "com.obric.aiagent.plugin");
    L5:
        a("cancelAnimation");
    }

    private final void a(String r4) {
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "releaseCallbacks, scene: " + r4);
        this.f32453d = (q) ZeusTransformUtils.preCheckCast(null, q.class, "com.obric.aiagent.plugin");
        this.f32454e = (m) ZeusTransformUtils.preCheckCast(null, m.class, "com.obric.aiagent.plugin");
    }
}
