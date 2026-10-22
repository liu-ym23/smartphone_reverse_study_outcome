package com.obric.oui.material;

import android.content.res.ColorStateList;
import android.os.Parcel;
import com.obric.oui.color.j0;
import com.obric.oui.color.k0;
import com.obric.oui.color.l0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {
    public static final ColorStateList a(ColorStateList r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Parcel r11 = Parcel.obtain();
        kotlin.jvm.internal.q.f(r11, "obtain()");
        r10.writeToParcel(r11, 0);     // Catch: Throwable -> L6
        r11.setDataPosition(0);     // Catch: Throwable -> L6
        Object r12 = ColorStateList.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L6
        kotlin.jvm.internal.q.f(r12, "{\n        writeToParcel(…eFromParcel(parcel)\n    }");     // Catch: Throwable -> L6
        ColorStateList r13 = (ColorStateList) r12;     // Catch: Throwable -> L6
        r11.recycle();
        return r13;
    L6:
        th = move-exception;
        r11.recycle();
        throw th;
    }

    public static final b b(d r12) {
        kotlin.jvm.internal.q.g(r12, "<this>");
        ColorStateList r10 = r12.f();
        ld.b r11 = r12.c();
        if (r11 != null) goto L5;
        ld.a r13 = null;
    L6:
        com.obric.oui.color.b[] r14 = r12.b();
        if (r14 != null) goto L9;
        com.obric.oui.color.a[] r15 = null;
    L10:
        ld.d r16 = r12.k();
        if (r16 != null) goto L13;
        ld.c r17 = null;
    L14:
        k0 r18 = r12.j();
        if (r18 != null) goto L17;
        j0 r19 = null;
    L18:
        ld.b r20 = r12.h();
        if (r20 != null) goto L21;
        ld.a r21 = null;
    L22:
        pc.b r22 = r12.d();
        if (r22 != null) goto L25;
        pc.a r23 = null;
    L26:
        Float r110 = r12.e();
        com.obric.oui.shadow.b[] r24 = r12.i();
        if (r24 != null) goto L29;
        com.obric.oui.shadow.a[] r111 = null;
    L30:
        com.obric.oui.fluid.b r112 = r12.g();
        if (r112 != null) goto L33;
        com.obric.oui.fluid.a r113 = null;
    L35:
        return new b(r10, r13, r15, r17, r19, r21, r23, r110, r111, r113);
    L33:
        r113 = com.obric.oui.fluid.c.a(r112);
        goto L35
    L29:
        r111 = f(r24);
        goto L30
    L25:
        r23 = pc.c.a(r22);
        goto L26
    L21:
        r21 = c(r20);
        goto L22
    L17:
        r19 = l0.a(r18);
        goto L18
    L13:
        r17 = d(r16);
        goto L14
    L9:
        r15 = com.obric.oui.color.c.b(r14);
        goto L10
    L5:
        r13 = c(r11);
        goto L6
    }

    public static final ld.a c(ld.b r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return ld.a.f21932b.a(r10);
    }

    public static final ld.c d(ld.d r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return ld.c.f21939b.a(r10);
    }

    public static final b[] e(d[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(b(r10[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        Object[] r14 = r11.toArray(new b[0]);
        if (r14 == null) goto L10;
        return (b[]) r14;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final com.obric.oui.shadow.a[] f(com.obric.oui.shadow.b[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(com.obric.oui.shadow.c.a(r10[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        Object[] r14 = r11.toArray(new com.obric.oui.shadow.a[0]);
        if (r14 == null) goto L10;
        return (com.obric.oui.shadow.a[]) r14;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final com.obric.oui.shadow.b[] g(com.obric.oui.shadow.a[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(r10[r13].h());
        r13 = r13 + 1;
        goto L3
    L5:
        Object[] r14 = r11.toArray(new com.obric.oui.shadow.b[0]);
        if (r14 == null) goto L10;
        return (com.obric.oui.shadow.b[]) r14;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
