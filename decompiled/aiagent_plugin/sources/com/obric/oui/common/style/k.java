package com.obric.oui.common.style;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: ShadowAnimator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f34544a = null;

    /* JADX INFO: compiled from: ShadowAnimator.kt */
    static final class a extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<j> f34545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<j> f34546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.common.style.f f34547c;

        a(List<j> r3, List<j> r4, com.obric.oui.common.style.f r5) {
            List<j> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<j> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f34545a = r6;
            this.f34546b = r7;
            this.f34547c = r5;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r2, Object r3, Object r4) {
            o.e(r2, "$noName_0");
            o.e(r3, "value");
            o.e(r4, "velocity");
            float r5 = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue();
            List<j> r6 = j.f34539a.a(r5, this.f34545a, this.f34546b);
            if (r6 == null) goto L7;
            this.f34547c.updateShadows(r6);
            return;
        }
    }

    /* JADX INFO: compiled from: ShadowAnimator.kt */
    static final class b extends p implements d.h.a.m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.common.style.f f34548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<j> f34549b;

        b(com.obric.oui.common.style.f r3, List<j> r4) {
            List<j> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f34548a = r3;
            this.f34549b = r5;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r3, Throwable r4) {
            this.f34548a.a((j) ZeusTransformUtils.preCheckCast(d.a.p.d(this.f34549b, 0), j.class, "com.obric.aiagent.plugin"), (j) ZeusTransformUtils.preCheckCast(d.a.p.d(this.f34549b, 1), j.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShadowAnimator.kt */
    static final class c extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<j> f34550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<j> f34551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.common.style.f f34552c;

        c(List<j> r3, List<j> r4, com.obric.oui.common.style.f r5) {
            List<j> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            List<j> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f34550a = r6;
            this.f34551b = r7;
            this.f34552c = r5;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r2, Object r3, Object r4) {
            o.e(r2, "$noName_0");
            o.e(r3, "value");
            o.e(r4, "velocity");
            float r5 = ((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.aiagent.plugin")).floatValue();
            List<j> r6 = j.f34539a.a(r5, this.f34550a, this.f34551b);
            if (r6 == null) goto L7;
            this.f34552c.updateShadows(r6);
            return;
        }
    }

    /* JADX INFO: compiled from: ShadowAnimator.kt */
    static final class d extends p implements d.h.a.m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.common.style.f f34553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<j> f34554b;

        d(com.obric.oui.common.style.f r3, List<j> r4) {
            List<j> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f34553a = r3;
            this.f34554b = r5;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r3, Throwable r4) {
            this.f34553a.a((j) ZeusTransformUtils.preCheckCast(d.a.p.d(this.f34554b, 0), j.class, "com.obric.aiagent.plugin"), (j) ZeusTransformUtils.preCheckCast(d.a.p.d(this.f34554b, 1), j.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ShadowAnimator.kt */
    static final class e extends p implements q<String, Object, Object, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f34555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f34556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<j> f34557c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<j> f34558d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f34559e;

        e(float r3, float r4, List<j> r5, List<j> r6, View r7) {
            List<j> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            List<j> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            this.f34555a = r3;
            this.f34556b = r4;
            this.f34557c = r8;
            this.f34558d = r9;
            this.f34559e = r7;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(String r3, Object r4, Object r5) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), r4, r5);
            return x.f38692a;
        }

        public final void a(String r7, Object r8, Object r9) {
            o.e(r7, "property");
            o.e(r8, "currentValue");
            o.e(r9, "velocity");
            if (o.a(r7, com.obric.common.oea.foundation.animation.h.a.EnumC0885a.f32414c.a()) == false) goto L10;
            List<j> r10 = j.f34539a.a(((Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.aiagent.plugin")).floatValue(), this.f34555a, this.f34556b, this.f34557c, this.f34558d);
            if (r10 != null) goto L7;
            return;
        L7:
            if (ZeusTransformUtils.instanceOf(this.f34559e, com.obric.oui.common.style.b.class) == false) goto L12;
            ((com.obric.oui.common.style.b) ZeusTransformUtils.preCheckCast(this.f34559e, com.obric.oui.common.style.b.class, "com.obric.aiagent.plugin")).updateShadows(r10);
            return;
        L12:
            return;
        }
    }

    /* JADX INFO: compiled from: ShadowAnimator.kt */
    static final class f extends p implements d.h.a.m<Boolean, Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f34560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<j> f34561b;

        f(View r3, List<j> r4) {
            List<j> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f34560a = r3;
            this.f34561b = r5;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, Throwable r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r4, Throwable r5) {
            if (ZeusTransformUtils.instanceOf(this.f34560a, com.obric.oui.common.style.b.class) == false) goto L14;
            com.obric.oui.common.style.b r6 = (com.obric.oui.common.style.b) ZeusTransformUtils.preCheckCast(this.f34560a, com.obric.oui.common.style.b.class, "com.obric.aiagent.plugin");
            List<j> r7 = this.f34561b;
            j r1 = null;
            if (r7 != null) goto L7;
            j r8 = null;
        L8:
            List<j> r3 = this.f34561b;
            if (r3 == null) goto L12;
            r1 = (j) ZeusTransformUtils.preCheckCast(d.a.p.d(r3, 1), j.class, "com.obric.aiagent.plugin");
        L12:
            r6.a(r8, r1);
            return;
        L7:
            r8 = (j) ZeusTransformUtils.preCheckCast(d.a.p.d(r7, 0), j.class, "com.obric.aiagent.plugin");
            goto L8
        }
    }

    static {
        f34544a = new k();
    }

    private k() {
    }

    public static final void a(com.obric.oui.common.style.f r9, List<j> r10, List<j> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        o.e(r9, "ouiLayout");
        o.e(r12, "oldShadow");
        o.e(r13, "newShadow");
        com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a(), 0.0f, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32428a, com.obric.common.oea.foundation.animation.h.e.c.h, 0, 4, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a((q) ZeusTransformUtils.preCheckCast(new a(r12, r13, r9), q.class, "com.obric.aiagent.plugin")).a((d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r9, r13), d.h.a.m.class, "com.obric.aiagent.plugin")).a().a();
    }

    public static final void b(com.obric.oui.common.style.f r9, List<j> r10, List<j> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        o.e(r9, "ouiLayout");
        o.e(r12, "oldShadow");
        o.e(r13, "newShadow");
        com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a(), 0.0f, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.c.f32439b, com.obric.common.oea.foundation.animation.h.e.b.f32433a, com.obric.common.oea.foundation.animation.h.e.d.k), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a((q) ZeusTransformUtils.preCheckCast(new c(r12, r13, r9), q.class, "com.obric.aiagent.plugin")).a((d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r9, r13), d.h.a.m.class, "com.obric.aiagent.plugin")).a().a();
    }

    public static final com.obric.common.oea.foundation.animation.manager.d a(View r26, float r27, float r28, List<j> r29, List<j> r30) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
        o.e(r26, "view");
        com.obric.common.oea.foundation.animation.a.b.a r10 = com.obric.common.oea.foundation.animation.a.c.a(r26, 0.0f, 1, null);
        com.obric.common.oea.foundation.animation.h.a.EnumC0885a r11 = com.obric.common.oea.foundation.animation.h.a.EnumC0885a.f32414c;
        Float r12 = Float.valueOf(r26.getScaleX());
        com.obric.common.oea.foundation.animation.g.a.b r0 = com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32432e, com.obric.common.oea.foundation.animation.h.e.c.g, 0, 4, null);
        r0.a(0.01f);
        x r5 = x.f38692a;
        com.obric.common.oea.foundation.animation.a.b.a r18 = com.obric.common.oea.foundation.animation.a.b.a.a(r10, r11, r12, r28, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(r0, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null);
        com.obric.common.oea.foundation.animation.h.a.EnumC0885a r19 = com.obric.common.oea.foundation.animation.h.a.EnumC0885a.f32415d;
        Float r20 = Float.valueOf(r26.getScaleY());
        com.obric.common.oea.foundation.animation.g.a.b r1 = com.obric.common.oea.foundation.animation.g.b.a(com.obric.common.oea.foundation.animation.h.e.a.f32432e, com.obric.common.oea.foundation.animation.h.e.c.g, 0, 4, null);
        r1.a(0.01f);
        x r2 = x.f38692a;
        return com.obric.common.oea.foundation.animation.a.b.a(com.obric.common.oea.foundation.animation.a.b.a.a(r18, r19, r20, r28, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(r1, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 16, null).a((q) ZeusTransformUtils.preCheckCast(new e(r27, r28, r3, r8, r26), q.class, "com.obric.aiagent.plugin")).a((d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r26, r8), d.h.a.m.class, "com.obric.aiagent.plugin")).b(), null, null, 3, null);
    }
}
