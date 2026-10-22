package com.obric.common.oea.foundation.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.obric.common.oea.foundation.a.a.a.e;
import com.obric.common.oea.foundation.a.a.a.f;
import com.obric.common.oea.foundation.a.a.a.g;
import com.obric.common.oea.foundation.b.c;
import com.obric.common.oea.foundation.b.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.l.j;
import d.l.n;
import java.util.List;

/* JADX INFO: compiled from: SmoothCornerHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "SmoothCornerHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0878a f32252a = null;
    private static final List<Integer> k = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f32253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.common.oea.foundation.a.a.a.d f32254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f32255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f32256e;
    private float f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SmoothCornerHelper.kt */
    public static final class C0878a {

        /* JADX INFO: renamed from: com.obric.common.oea.foundation.a.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SmoothCornerHelper.kt */
        public static final enum EnumC0879a extends Enum<EnumC0879a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0879a f32257a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0879a f32258b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final EnumC0879a f32259c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final EnumC0879a f32260d = null;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final EnumC0879a f32261e = null;
            private static final /* synthetic */ EnumC0879a[] f = null;

            static {
                EnumC0879a r1 = new EnumC0879a("QUADRATIC", 0);
                f32257a = r1;
                EnumC0879a r2 = new EnumC0879a("SKETCH", 1);
                f32258b = r2;
                EnumC0879a r3 = new EnumC0879a("FIGMA", 2);
                f32259c = r3;
                EnumC0879a r4 = new EnumC0879a("BASIC", 3);
                f32260d = r4;
                EnumC0879a r5 = new EnumC0879a("QUADRATIC_CAPSULE", 4);
                f32261e = r5;
                f = new EnumC0879a[]{r1, r2, r3, r4, r5};
            }

            public static EnumC0879a valueOf(String r2) {
                return (EnumC0879a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0879a.class, r2), EnumC0879a.class, "com.obric.aiagent.plugin");
            }

            public static EnumC0879a[] values() {
                return (EnumC0879a[]) ZeusTransformUtils.preCheckCast(f.clone(), EnumC0879a[].class, "com.obric.aiagent.plugin");
            }

            private EnumC0879a(String r1, int r2) {
                super(r1, r2);
            }
        }

        private C0878a() {
        }

        public /* synthetic */ C0878a(h r1) {
            this();
        }
    }

    public a() {
        this.f32253b = new d();
        this.f32254c = (com.obric.common.oea.foundation.a.a.a.d) ZeusTransformUtils.preCheckCast(new g(0.0f, 1, null), com.obric.common.oea.foundation.a.a.a.d.class, "com.obric.aiagent.plugin");
        this.f32255d = -1.0f;
        this.f32256e = -1.0f;
        this.f = -1.0f;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
    }

    public final void a(C0878a.EnumC0879a r2) {
        o.e(r2, "curveType");
        a(r2, -1.0f);
    }

    public final void a(C0878a.EnumC0879a r4, float r5) {
        o.e(r4, "curveType");
        c.f32472a.b(TAG, "setCurveType: " + r4);
        int r6 = b.f32286a[r4.ordinal()];
        if (r6 != 1) goto L5;
        com.obric.common.oea.foundation.a.a.a.d r7 = (com.obric.common.oea.foundation.a.a.a.d) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.a.a.a.a(), com.obric.common.oea.foundation.a.a.a.d.class, "com.obric.aiagent.plugin");
    L25:
        this.f32254c = r7;
        return;
    L5:
        if (r6 == 2) goto L18;
        if (r6 != 3) goto L9;
        r7 = (com.obric.common.oea.foundation.a.a.a.d) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.a.a.a.h(), com.obric.common.oea.foundation.a.a.a.d.class, "com.obric.aiagent.plugin");
        goto L25
    L9:
        if (r6 != 4) goto L11;
        r7 = (com.obric.common.oea.foundation.a.a.a.d) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.a.a.a.c(), com.obric.common.oea.foundation.a.a.a.d.class, "com.obric.aiagent.plugin");
        goto L25
    L11:
        if (r6 != 5) goto L14;
        r7 = (com.obric.common.oea.foundation.a.a.a.d) ZeusTransformUtils.preCheckCast(new f(), com.obric.common.oea.foundation.a.a.a.d.class, "com.obric.aiagent.plugin");
        goto L25
    L14:
        throw new k();
    L18:
        if (r5 > 0) goto L20;
    L22:
        g r8 = new g(0.0f, 1, null);
    L23:
        r7 = (com.obric.common.oea.foundation.a.a.a.d) ZeusTransformUtils.preCheckCast(r8, com.obric.common.oea.foundation.a.a.a.d.class, "com.obric.aiagent.plugin");
        goto L25
    L20:
        if (r5 > 0.5f) goto L22;
        r8 = new g(r5);
        goto L23
    }

    public final void a(Canvas r11, RectF r12, float r13, Paint r14) {
        o.e(r11, "canvas");
        o.e(r12, "rect");
        o.e(r14, "paint");
        if (r12.isEmpty() == false) goto L6;
        c.a(c.f32472a, TAG, "empty rect: " + r12, null, 4, null);
        return;
    L6:
        a(r11, r14, r12.left, r12.top, r12.right, r12.bottom, r13);
    }

    public final void a(Canvas r19, Paint r20, float r21, float r22, float r23, float r24, float r25) {
        o.e(r19, "canvas");
        o.e(r20, "paint");
        if (r25 >= 0.0f) goto L5;
        c.a(c.f32472a, TAG, "invalid radius: " + r25, null, 4, null);
        float r9 = 0.0f;
    L6:
        e r1 = a(r23, r21, r24, r22);
        float r10 = r1.c();
        float r11 = r1.d();
        if (r9 <= (Math.min(r23 - r21, r24 - r22) / 2)) goto L9;
        com.obric.common.oea.foundation.a.a.a.d.a(this.f32254c, r19, r20, r10, r11, r21, r22, r23, r24, r9, false, false, false, false, 7680, null);
        return;
    L9:
        this.f32254c.a(r19, r20, r21, r22, r23, r24, r9);
        return;
    L5:
        r9 = r25;
        goto L6
    }

    public final Path a(Rect r8, float r9) {
        o.e(r8, "rect");
        return a(r8.left, r8.top, r8.right, r8.bottom, r9);
    }

    public final Path a(float r7, float r8, float r9, float r10, float r11) {
        return this.f32254c.a(r7, r8, r9, r10, r11);
    }

    public final boolean a(float r1, float r2) {
        return this.f32254c.a(r1, r2);
    }

    private final e a(float r2, float r3, float r4, float r5) {
        float r1 = r2 - r3;
        float r0 = r4 - r5;
        return new e(((r3 + r2) / 2.0f) - (r1 / 2.0f), ((r5 + r4) / 2.0f) - (r0 / 2.0f));
    }

    static {
        f32252a = new C0878a(null);
        k = p.o((Iterable) ZeusTransformUtils.preCheckCast(n.a((d.l.h) ZeusTransformUtils.preCheckCast(new j(8, 48), d.l.h.class, "com.obric.aiagent.plugin"), 2), Iterable.class, "com.obric.aiagent.plugin"));
    }
}
