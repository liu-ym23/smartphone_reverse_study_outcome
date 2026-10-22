package com.obric.common.oea.foundation.animation.manager;

import android.os.Handler;
import android.os.Looper;
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

/* JADX INFO: compiled from: AnimationManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static final String TAG = "AnimationManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32462a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.obric.common.oea.foundation.b.d f32463e = null;
    private static int f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f32464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.common.oea.foundation.animation.manager.a f32465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f32466d;

    /* JADX INFO: compiled from: AnimationManager.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: AnimationManager.kt */
    static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f32467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f32468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f32469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f32470d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.obric.common.oea.foundation.animation.d.b f32471e;
        final /* synthetic */ float f;
        final /* synthetic */ com.obric.common.oea.foundation.animation.d.a g;
        final /* synthetic */ List h;
        final /* synthetic */ q i;
        final /* synthetic */ m j;

        b(d r3, float r4, boolean r5, View r6, com.obric.common.oea.foundation.animation.d.b r7, float r8, com.obric.common.oea.foundation.animation.d.a r9, List r10, q r11, m r12) {
            List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
            q r14 = (q) ZeusTransformUtils.wrapperContextForParams(r11, q.class, "com.obric.aiagent.plugin");
            m r15 = (m) ZeusTransformUtils.wrapperContextForParams(r12, m.class, "com.obric.aiagent.plugin");
            this.f32467a = r3;
            this.f32468b = r4;
            this.f32469c = r5;
            this.f32470d = r6;
            this.f32471e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r13;
            this.i = r14;
            this.j = r15;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.a(this.f32467a, this.f32468b, this.f32469c, this.f32470d, this.f32471e, this.f, this.g, this.h, this.i, this.j);
        }
    }

    public d() {
        this.f32464b = new c();
        int r0 = f;
        f = r0 + 1;
        this.f32466d = r0;
    }

    public static final /* synthetic */ void a(d r12, float r13, boolean r14, View r15, com.obric.common.oea.foundation.animation.d.b r16, float r17, com.obric.common.oea.foundation.animation.d.a r18, List r19, q r20, m r21) {
        r12.b(r13, r14, r15, r16, r17, r18, (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin"), (q) ZeusTransformUtils.wrapperContextForParams(r20, q.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.wrapperContextForParams(r21, m.class, "com.obric.aiagent.plugin"));
    }

    public final void a(com.obric.common.oea.foundation.animation.a.a r13, View r14, List<? extends com.obric.common.oea.foundation.animation.a<?>> r15, q<? super String, Object, ? super Float, x> r16, m<? super Boolean, ? super Throwable, x> r17) {
        List<? extends com.obric.common.oea.foundation.animation.a<?>> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        q<? super String, Object, ? super Float, x> r10 = (q) ZeusTransformUtils.wrapperContextForParams(r16, q.class, "com.obric.aiagent.plugin");
        m<? super Boolean, ? super Throwable, x> r11 = (m) ZeusTransformUtils.wrapperContextForParams(r17, m.class, "com.obric.aiagent.plugin");
        o.e(r13, "animConfig");
        o.e(r9, "animationInfos");
        a(r13.d(), r13.e(), r14, r13.a(), r13.c(), r13.b(), r9, r10, r11);
    }

    private final void a(float r16, boolean r17, View r18, com.obric.common.oea.foundation.animation.d.b r19, float r20, com.obric.common.oea.foundation.animation.d.a r21, List<? extends com.obric.common.oea.foundation.animation.a<?>> r22, q<? super String, Object, ? super Float, x> r23, m<? super Boolean, ? super Throwable, x> r24) {
        List<? extends com.obric.common.oea.foundation.animation.a<?>> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        q<? super String, Object, ? super Float, x> r11 = (q) ZeusTransformUtils.wrapperContextForParams(r23, q.class, "com.obric.aiagent.plugin");
        m<? super Boolean, ? super Throwable, x> r12 = (m) ZeusTransformUtils.wrapperContextForParams(r24, m.class, "com.obric.aiagent.plugin");
        Looper r2 = Looper.getMainLooper();
        o.c(r2, "Looper.getMainLooper()");
        if ((!o.a(r2.getThread(), Thread.currentThread())) == false) goto L5;
        new Handler(Looper.getMainLooper()).post((Runnable) ZeusTransformUtils.preCheckCast(new b(this, r16, r17, r18, r19, r20, r21, r0, r11, r12), Runnable.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        b(r16, r17, r18, r19, r20, r21, r0, r11, r12);
    }

    private final void b(float r21, boolean r22, View r23, com.obric.common.oea.foundation.animation.d.b r24, float r25, com.obric.common.oea.foundation.animation.d.a r26, List<? extends com.obric.common.oea.foundation.animation.a<?>> r27, q<? super String, Object, ? super Float, x> r28, m<? super Boolean, ? super Throwable, x> r29) {
        List<? extends com.obric.common.oea.foundation.animation.a<?>> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.aiagent.plugin");
        q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r28, q.class, "com.obric.aiagent.plugin");
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r29, m.class, "com.obric.aiagent.plugin");
        com.obric.common.oea.foundation.b.c r8 = com.obric.common.oea.foundation.b.c.f32472a;
        StringBuilder r9 = new StringBuilder().append("start, instanceId: [").append(this.f32466d).append("], runAnimation, mode: ").append(r24).append(", speed: ").append(r25).append(", repeatMode: ").append(r26).append(", animationInfos: ");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r10, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(((com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.common.oea.foundation.animation.a.class, "com.obric.aiagent.plugin")).d());
        goto L4
    L6:
        r8.d(TAG, r9.append(p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null)).toString());
        this.f32464b.a(r21);
        this.f32464b.a(r24);
        this.f32464b.a(r26);
        this.f32464b.a(r4);
        this.f32464b.a(r23);
        this.f32464b.b(r25);
        this.f32464b.b(r22);
        com.obric.common.oea.foundation.animation.manager.a r1 = new com.obric.common.oea.foundation.animation.manager.a(this.f32464b, r6, r7);
        this.f32465c = r1;
        if (r1 == null) goto L11;
        r1.a();
        return;
    }

    public final void a() {
        com.obric.common.oea.foundation.b.c.f32472a.d(TAG, "pause, instanceId: [" + this.f32466d + ']');
        this.f32464b.d();
    }

    public final void b() {
        com.obric.common.oea.foundation.b.c.f32472a.d(TAG, "resume, instanceId: [" + this.f32466d + ']');
        this.f32464b.e();
        com.obric.common.oea.foundation.animation.manager.a r3 = this.f32465c;
        if (r3 == null) goto L6;
        r3.a();
        return;
    }

    public static /* synthetic */ void a(d r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.a(r1);
    }

    public final void a(boolean r4) {
        com.obric.common.oea.foundation.b.c.f32472a.d(TAG, "cancel, instanceId: [" + this.f32466d + "], clearVelocity: " + r4);
        com.obric.common.oea.foundation.animation.manager.a r3 = this.f32465c;
        if (r3 == null) goto L6;
        r3.a(r4);
        return;
    }

    static {
        f32462a = new a(null);
        f32463e = new com.obric.common.oea.foundation.b.d();
    }
}
