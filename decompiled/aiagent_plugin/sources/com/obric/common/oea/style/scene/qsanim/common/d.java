package com.obric.common.oea.style.scene.qsanim.common;

import com.obric.common.oea.foundation.animation.engine.e;
import com.obric.common.oea.foundation.animation.engine.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SpringAnimUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static final String TAG = "SpringAnimUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f32567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, e> f32568b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.obric.common.oea.foundation.animation.engine.c<a> f32569c = null;

    /* JADX INFO: compiled from: SpringAnimUtils.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f32570a;

        public a(float r1) {
            this.f32570a = r1;
        }

        public final float a() {
            return this.f32570a;
        }

        public final void a(float r1) {
            this.f32570a = r1;
        }
    }

    /* JADX INFO: compiled from: SpringAnimUtils.kt */
    public static final class b extends com.obric.common.oea.foundation.animation.engine.c<a> {
        b(String r1) {
            super(r1);
        }

        @Override // com.obric.common.oea.foundation.animation.engine.c
        public /* synthetic */ float a(a r3) {
            return a2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.common.oea.foundation.animation.engine.c
        public /* synthetic */ void a(a r3, float r4) {
            a2((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), r4);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public float a2(a r1) {
            o.a(r1);
            return r1.a();
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(a r1, float r2) {
            o.a(r1);
            r1.a(r2);
        }
    }

    static {
        f32567a = new d();
        f32568b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        f32569c = (com.obric.common.oea.foundation.animation.engine.c) ZeusTransformUtils.preCheckCast(new b("v"), com.obric.common.oea.foundation.animation.engine.c.class, "com.obric.aiagent.plugin");
    }

    private d() {
    }

    public final void a() {
        f32568b.clear();
    }

    public final <K> void a(K r3, com.obric.common.oea.foundation.animation.engine.c<K> r4) {
        o.e(r3, "$this$cancelSpring");
        o.e(r4, "property");
        String r2 = a(r3, "SPRING_ANIM_" + r4.hashCode());
        Map<String, e> r5 = f32568b;
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5.get(r2), e.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L6;
        r6.b();
        r5.remove(r2);
        return;
    }

    public static /* synthetic */ e a(d r12, Object r13, com.obric.common.oea.foundation.animation.engine.c r14, float r15, float r16, float r17, com.obric.common.oea.foundation.animation.engine.b.c r18, com.obric.common.oea.foundation.animation.engine.b.InterfaceC0883b r19, int r20, Object r21) {
        com.obric.common.oea.foundation.animation.engine.b.c r0 = (com.obric.common.oea.foundation.animation.engine.b.c) ZeusTransformUtils.wrapperContextForParams(r18, com.obric.common.oea.foundation.animation.engine.b.c.class, "com.obric.aiagent.plugin");
        com.obric.common.oea.foundation.animation.engine.b.InterfaceC0883b r2 = (com.obric.common.oea.foundation.animation.engine.b.InterfaceC0883b) ZeusTransformUtils.wrapperContextForParams(r19, com.obric.common.oea.foundation.animation.engine.b.InterfaceC0883b.class, "com.obric.aiagent.plugin");
        if ((r20 & 4) == 0) goto L5;
        float r8 = 0.9f;
    L7:
        if ((r20 & 8) == 0) goto L9;
        float r9 = 250.0f;
    L11:
        if ((r20 & 16) == 0) goto L13;
        r0 = (com.obric.common.oea.foundation.animation.engine.b.c) ZeusTransformUtils.preCheckCast(null, com.obric.common.oea.foundation.animation.engine.b.c.class, "com.obric.aiagent.plugin");
    L13:
        com.obric.common.oea.foundation.animation.engine.b.c r10 = r0;
        if ((r20 & 32) == 0) goto L17;
        r2 = (com.obric.common.oea.foundation.animation.engine.b.InterfaceC0883b) ZeusTransformUtils.preCheckCast(null, com.obric.common.oea.foundation.animation.engine.b.InterfaceC0883b.class, "com.obric.aiagent.plugin");
    L17:
        return r12.a(r13, r14, r15, r8, r9, r10, r2);
    L9:
        r9 = r17;
        goto L11
    L5:
        r8 = r16;
        goto L7
    }

    public final <K> e a(K r4, com.obric.common.oea.foundation.animation.engine.c<K> r5, float r6, float r7, float r8, com.obric.common.oea.foundation.animation.engine.b.c r9, com.obric.common.oea.foundation.animation.engine.b.InterfaceC0883b r10) {
        com.obric.common.oea.foundation.animation.engine.b.c r11 = (com.obric.common.oea.foundation.animation.engine.b.c) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.common.oea.foundation.animation.engine.b.c.class, "com.obric.aiagent.plugin");
        com.obric.common.oea.foundation.animation.engine.b.InterfaceC0883b r12 = (com.obric.common.oea.foundation.animation.engine.b.InterfaceC0883b) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.common.oea.foundation.animation.engine.b.InterfaceC0883b.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$springTo");
        o.e(r5, "property");
        String r3 = a(r4, "SPRING_ANIM_" + r5.hashCode());
        float r0 = r5.a(r4);
        if (r0 != r6) goto L11;
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "springTo, no need! currentValue: " + r0 + ", targetValue: " + r6 + ", this: " + r4);
        e r13 = (e) ZeusTransformUtils.preCheckCast(f32568b.get(r3), e.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L8;
        r13.b();
    L8:
        if (r12 == null) goto L10;
        r12.a(null, true, r6, 0.0f);
    L10:
        return null;
    L11:
        Map<String, e> r1 = f32568b;
        e r2 = r1.get(r3);
        if (r2 != null) goto L14;
        e r14 = new e(r4, r5);
        f r15 = new f(r6);
        r15.b(r7);
        r15.a(r8);
        r2 = r14.a(r15);
        o.c(r2, "springAnim.setSpring(springForce)");
        r1.put(r3, r2);
    L14:
        e r16 = (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.aiagent.plugin");
        if (r16.c() == true) goto L20;
        if (r11 == null) goto L18;
        r16.a(r11);
    L18:
        if (r12 == null) goto L20;
        r16.a(r12);
    L20:
        r16.f(r6);
        return r16;
    }

    public final String a(Object r1, String r2) {
        o.e(r1, "$this$animKey");
        o.e(r2, "tag");
        return r2 + '_' + r1.hashCode();
    }

    public final com.obric.common.oea.foundation.animation.engine.c<a> b() {
        return f32569c;
    }
}
