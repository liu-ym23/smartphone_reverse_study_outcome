package com.obric.common.oea.foundation.animation.f;

import android.view.View;
import com.obric.common.oea.foundation.animation.AnimationLifecycleListener;
import com.obric.common.oea.foundation.animation.manager.d;
import com.obric.common.oea.foundation.b.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AnimatableSubmitter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "AnimatableSubmitter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32384a = null;

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimatableSubmitter.kt */
    static final class C0884a extends p implements m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f32385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f32386b;

        C0884a(m r3, d r4) {
            this.f32385a = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
            this.f32386b = r4;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r2, Throwable r3) {
            m r0 = this.f32385a;
            if (r0 == null) goto L5;
            x r4 = (x) ZeusTransformUtils.preCheckCast(r0.invoke(Boolean.valueOf(r2), r3), x.class, "com.obric.aiagent.plugin");
        L5:
            AnimationLifecycleListener.f32287a.b(this.f32386b);
        }
    }

    static {
        f32384a = new a();
    }

    private a() {
    }

    public final d a(com.obric.common.oea.foundation.animation.a.a r9, View r10, List<? extends com.obric.common.oea.foundation.animation.c.a<?>> r11, q<? super String, Object, ? super Float, x> r12, m<? super Boolean, ? super Throwable, x> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        q<? super String, Object, ? super Float, x> r6 = (q) ZeusTransformUtils.wrapperContextForParams(r12, q.class, "com.obric.aiagent.plugin");
        m<? super Boolean, ? super Throwable, x> r7 = (m) ZeusTransformUtils.wrapperContextForParams(r13, m.class, "com.obric.aiagent.plugin");
        o.e(r9, "animConfig");
        o.e(r14, "animationCommands");
        List<? extends com.obric.common.oea.foundation.animation.a<?>> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r15.hasNext() == false) goto L7;
        com.obric.common.oea.foundation.animation.c.a<?> r16 = (com.obric.common.oea.foundation.animation.c.a) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.common.oea.foundation.animation.c.a.class, "com.obric.aiagent.plugin");
        r5.add(f32384a.a(r16));
        goto L4
    L7:
        return b(r9, r10, r5, r6, r7);
    }

    private final com.obric.common.oea.foundation.animation.a<?> a(com.obric.common.oea.foundation.animation.c.a<?> r1) {
        return r1.a();
    }

    private final d b(com.obric.common.oea.foundation.animation.a.a r8, View r9, List<? extends com.obric.common.oea.foundation.animation.a<?>> r10, q<? super String, Object, ? super Float, x> r11, m<? super Boolean, ? super Throwable, x> r12) {
        List<? extends com.obric.common.oea.foundation.animation.a<?>> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        q<? super String, Object, ? super Float, x> r5 = (q) ZeusTransformUtils.wrapperContextForParams(r11, q.class, "com.obric.aiagent.plugin");
        m r7 = (m) ZeusTransformUtils.wrapperContextForParams(r12, m.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L15;
        com.obric.common.oea.foundation.animation.a<?> r13 = AnimationLifecycleListener.f32287a.a(r9);
        float r14 = 0.0f;
        if (r13 == null) goto L7;
        r14 = r13.i();
    L7:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r15.hasNext() == false) goto L15;
        com.obric.common.oea.foundation.animation.a<?> r16 = (com.obric.common.oea.foundation.animation.a) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.common.oea.foundation.animation.a.class, "com.obric.aiagent.plugin");
        if (r16.h() != null) goto L13;
        c.f32472a.b(TAG, "没指定初始速度，重设velocity " + r14);
        r16.a(Float.valueOf(r14));
    L14:
        AnimationLifecycleListener.f32287a.a(r9, r16);
        goto L9
    L13:
        c.f32472a.b(TAG, "指定了初始速度，" + r16.h());
    L15:
        d r17 = new d();
        AnimationLifecycleListener.f32287a.a(r17);
        r17.a(r8, r9, r4, r5, (m) ZeusTransformUtils.preCheckCast(new C0884a(r7, r17), m.class, "com.obric.aiagent.plugin"));
        return r17;
    }
}
