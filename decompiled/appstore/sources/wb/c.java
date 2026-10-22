package wb;

import com.obric.common.oea.foundation.animation.engine.DynamicAnimation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f25398a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.obric.common.oea.foundation.animation.engine.a f25399b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f25400c = null;

    public static final class a {
        public abstract float a();

        public abstract void b(float r10);
    }

    public static final class b extends com.obric.common.oea.foundation.animation.engine.a {
        public b(String r10) {
            super(r10);
        }

        @Override // com.obric.common.oea.foundation.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((a) r10);
        }

        @Override // com.obric.common.oea.foundation.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((a) r10, r11);
        }

        public float c(a r10) {
            q.d(r10);
            return r10.a();
        }

        public void d(a r10, float r11) {
            q.d(r10);
            r10.b(r11);
        }
    }

    static {
        f25400c = new c();
        f25398a = new LinkedHashMap();
        f25399b = new b("v");
    }

    public c() {
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.engine.c e(c r10, Object r11, com.obric.common.oea.foundation.animation.engine.a r12, float r13, float r14, float r15, DynamicAnimation.OnAnimationUpdateListener r16, DynamicAnimation.OnAnimationEndListener r17, int r18, Object r19) {
        if ((r18 & 4) == 0) goto L5;
        float r20 = 0.9f;
    L7:
        if ((r18 & 8) == 0) goto L9;
        float r21 = 250.0f;
    L11:
        if ((r18 & 16) == 0) goto L13;
        DynamicAnimation.OnAnimationUpdateListener r22 = null;
    L15:
        if ((r18 & 32) == 0) goto L17;
        DynamicAnimation.OnAnimationEndListener r23 = null;
    L19:
        return r10.d(r11, r12, r13, r20, r21, r22, r23);
    L17:
        r23 = r17;
        goto L19
    L13:
        r22 = r16;
        goto L15
    L9:
        r21 = r15;
        goto L11
    L5:
        r20 = r14;
        goto L7
    }

    public final String a(Object r10, String r11) {
        q.g(r10, "$this$animKey");
        q.g(r11, "tag");
        return r11 + '_' + r10.hashCode();
    }

    public final void b(Object r10, com.obric.common.oea.foundation.animation.engine.a r11) {
        q.g(r10, "$this$cancelSpring");
        q.g(r11, "property");
        String r12 = a(r10, "SPRING_ANIM_" + r11.hashCode());
        Map r13 = f25398a;
        com.obric.common.oea.foundation.animation.engine.c r14 = (com.obric.common.oea.foundation.animation.engine.c) r13.get(r12);
        if (r14 == null) goto L6;
        r14.c();
        r13.remove(r12);
        return;
    }

    public final com.obric.common.oea.foundation.animation.engine.a c() {
        return f25399b;
    }

    public final com.obric.common.oea.foundation.animation.engine.c d(Object r10, com.obric.common.oea.foundation.animation.engine.a r11, float r12, float r13, float r14, DynamicAnimation.OnAnimationUpdateListener r15, DynamicAnimation.OnAnimationEndListener r16) {
        q.g(r10, "$this$springTo");
        q.g(r11, "property");
        String r17 = a(r10, "SPRING_ANIM_" + r11.hashCode());
        float r18 = r11.a(r10);
        if (r18 != r12) goto L11;
        qb.b.f23627c.a("SpringAnimUtils", "springTo, no need! currentValue: " + r18 + ", targetValue: " + r12 + ", this: " + r10);
        com.obric.common.oea.foundation.animation.engine.c r19 = (com.obric.common.oea.foundation.animation.engine.c) f25398a.get(r17);
        if (r19 == null) goto L8;
        r19.c();
    L8:
        if (r16 == null) goto L10;
        r16.onAnimationEnd(null, true, r12, 0.0f);
    L10:
        return null;
    L11:
        Map r20 = f25398a;
        Object r21 = r20.get(r17);
        if (r21 != null) goto L14;
        com.obric.common.oea.foundation.animation.engine.c r22 = new com.obric.common.oea.foundation.animation.engine.c(r10, r11);
        com.obric.common.oea.foundation.animation.engine.d r23 = new com.obric.common.oea.foundation.animation.engine.d(r12);
        r23.c(r13);
        r23.e(r14);
        r21 = r22.q(r23);
        q.f(r21, "springAnim.setSpring(springForce)");
        r20.put(r17, r21);
    L14:
        com.obric.common.oea.foundation.animation.engine.c r24 = (com.obric.common.oea.foundation.animation.engine.c) r21;
        if (r24.g() == true) goto L20;
        if (r15 == null) goto L18;
        r24.b(r15);
    L18:
        if (r16 == null) goto L20;
        r24.a(r16);
    L20:
        r24.n(r12);
        return r24;
    }
}
