package com.obric.common.oea.foundation.graphics.smoothcorner;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import bg.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import ob.a;
import pb.d;
import pb.e;
import pb.f;
import pb.g;
import qb.b;
import qb.c;

/* JADX INFO: loaded from: classes3.dex */
public final class SmoothCornerHelper {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List f11740j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f11741k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f11742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f11743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f11744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f11745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f11746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f11750i;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper$Companion$CurveType;", "", "(Ljava/lang/String;I)V", "QUADRATIC", "SKETCH", "FIGMA", "BASIC", "QUADRATIC_CAPSULE", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum CurveType extends Enum<CurveType> {
            private static final /* synthetic */ CurveType[] $VALUES = null;
            public static final CurveType BASIC = null;
            public static final CurveType FIGMA = null;
            public static final CurveType QUADRATIC = null;
            public static final CurveType QUADRATIC_CAPSULE = null;
            public static final CurveType SKETCH = null;

            static {
                CurveType r10 = new CurveType("QUADRATIC", 0);
                QUADRATIC = r10;
                CurveType r11 = new CurveType("SKETCH", 1);
                SKETCH = r11;
                CurveType r12 = new CurveType("FIGMA", 2);
                FIGMA = r12;
                CurveType r13 = new CurveType("BASIC", 3);
                BASIC = r13;
                CurveType r14 = new CurveType("QUADRATIC_CAPSULE", 4);
                QUADRATIC_CAPSULE = r14;
                $VALUES = new CurveType[]{r10, r11, r12, r13, r14};
            }

            private CurveType(String r10, int r11) {
                super(r10, r11);
            }

            public static CurveType valueOf(String r10) {
                return (CurveType) Enum.valueOf(CurveType.class, r10);
            }

            public static CurveType[] values() {
                return (CurveType[]) $VALUES.clone();
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f11741k = new Companion(null);
        f11740j = b0.x0(h.o(new bg.c(8, 48), 2));
    }

    public SmoothCornerHelper() {
        this.f11742a = new c();
        this.f11743b = new g(0.0f, 1, null);
        this.f11744c = -1.0f;
        this.f11745d = -1.0f;
        this.f11746e = -1.0f;
        this.f11747f = true;
        this.f11748g = true;
        this.f11749h = true;
        this.f11750i = true;
    }

    public final Path a(float r10, float r11, float r12, float r13, float r14) {
        return this.f11743b.a(r10, r11, r12, r13, r14);
    }

    public final Path b(Rect r10, float r11) {
        q.g(r10, "rect");
        return a(r10.left, r10.top, r10.right, r10.bottom, r11);
    }

    public final boolean c(float r10, float r11) {
        return this.f11743b.c(r10, r11);
    }

    public final void d(Canvas r19, Paint r20, float r21, float r22, float r23, float r24, float r25) {
        q.g(r19, "canvas");
        q.g(r20, "paint");
        if (r25 >= 0.0f) goto L5;
        b.c(b.f23627c, "SmoothCornerHelper", "invalid radius: " + r25, null, 4, null);
        float r10 = 0.0f;
    L6:
        e r11 = f(r23, r21, r24, r22);
        float r12 = r11.a();
        float r13 = r11.b();
        if (r10 <= (Math.min(r23 - r21, r24 - r22) / 2)) goto L9;
        d.e(this.f11743b, r19, r20, r12, r13, r21, r22, r23, r24, r10, false, false, false, false, 7680, null);
        return;
    L9:
        this.f11743b.f(r19, r20, r21, r22, r23, r24, r10);
        return;
    L5:
        r10 = r25;
        goto L6
    }

    public final void e(Canvas r10, RectF r11, float r12, Paint r13) {
        q.g(r10, "canvas");
        q.g(r11, "rect");
        q.g(r13, "paint");
        if (r11.isEmpty() == false) goto L6;
        b.c(b.f23627c, "SmoothCornerHelper", "empty rect: " + r11, null, 4, null);
        return;
    L6:
        d(r10, r13, r11.left, r11.top, r11.right, r11.bottom, r12);
    }

    public final e f(float r10, float r11, float r12, float r13) {
        float r14 = r10 - r11;
        float r15 = r12 - r13;
        return new e(((r11 + r10) / 2.0f) - (r14 / 2.0f), ((r13 + r12) / 2.0f) - (r15 / 2.0f));
    }

    public final void g(Companion.CurveType r10) {
        q.g(r10, "curveType");
        h(r10, -1.0f);
    }

    public final void h(Companion.CurveType r10, float r11) {
        q.g(r10, "curveType");
        b.f23627c.a("SmoothCornerHelper", "setCurveType: " + r10);
        int r12 = a.f22547a[r10.ordinal()];
        if (r12 != 1) goto L5;
        d r13 = new pb.a();
    L24:
        this.f11743b = r13;
        return;
    L5:
        if (r12 == 2) goto L18;
        if (r12 != 3) goto L9;
        r13 = new pb.h();
        goto L24
    L9:
        if (r12 != 4) goto L11;
        r13 = new pb.c();
        goto L24
    L11:
        if (r12 != 5) goto L14;
        r13 = new f();
        goto L24
    L14:
        throw new NoWhenBranchMatchedException();
    L18:
        if (r11 > 0) goto L20;
    L22:
        r13 = new g(0.0f, 1, null);
        goto L24
    L20:
        if (r11 > 0.5f) goto L22;
        r13 = new g(r11);
        goto L24
    }
}
