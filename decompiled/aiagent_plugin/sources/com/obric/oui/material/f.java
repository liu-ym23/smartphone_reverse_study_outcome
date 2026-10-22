package com.obric.oui.material;

import android.content.res.ColorStateList;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: MaterialConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static final c a(e r12) {
        d.h.b.o.e(r12, "<this>");
        ColorStateList r2 = r12.a();
        com.obric.oui.c.b r1 = r12.b();
        if (r1 != null) goto L5;
        com.obric.oui.c.a r4 = null;
    L6:
        com.obric.oui.color.b[] r3 = r12.c();
        if (r3 != null) goto L9;
        com.obric.oui.color.a[] r5 = null;
    L10:
        com.obric.oui.c.d r6 = r12.d();
        if (r6 != null) goto L13;
        com.obric.oui.c.c r7 = null;
    L14:
        com.obric.oui.color.f r8 = r12.e();
        if (r8 != null) goto L17;
        com.obric.oui.color.e r9 = null;
    L18:
        com.obric.oui.c.b r10 = r12.f();
        if (r10 != null) goto L21;
        com.obric.oui.c.a r11 = null;
    L22:
        com.obric.oui.blur.b r13 = r12.g();
        if (r13 != null) goto L25;
        com.obric.oui.blur.a r14 = null;
    L26:
        Float r15 = r12.h();
        com.obric.oui.shadow.b[] r16 = r12.i();
        if (r16 != null) goto L29;
        com.obric.oui.shadow.a[] r17 = null;
    L30:
        com.obric.oui.fluid.b r18 = r12.j();
        if (r18 != null) goto L33;
        com.obric.oui.fluid.a r19 = null;
    L35:
        return new c(r2, r4, r5, r7, r9, r11, r14, r15, r17, r19);
    L33:
        r19 = com.obric.oui.fluid.c.a(r18);
        goto L35
    L29:
        r17 = a(r16);
        goto L30
    L25:
        r14 = com.obric.oui.blur.c.a(r13);
        goto L26
    L21:
        r11 = a(r10);
        goto L22
    L17:
        r9 = com.obric.oui.color.g.a(r8);
        goto L18
    L13:
        r7 = a(r6);
        goto L14
    L9:
        r5 = com.obric.oui.color.c.a(r3);
        goto L10
    L5:
        r4 = a(r1);
        goto L6
    }

    public static final com.obric.oui.c.a a(com.obric.oui.c.b r1) {
        d.h.b.o.e(r1, "<this>");
        return com.obric.oui.c.a.f34317a.a(r1);
    }

    public static final com.obric.oui.c.c a(com.obric.oui.c.d r1) {
        d.h.b.o.e(r1, "<this>");
        return com.obric.oui.c.c.f34324a.a(r1);
    }

    public static final ColorStateList a(ColorStateList r3) {
        d.h.b.o.e(r3, "<this>");
        Parcel r0 = Parcel.obtain();
        d.h.b.o.c(r0, "obtain()");
        r3.writeToParcel(r0, 0);     // Catch: Throwable -> L6
        r0.setDataPosition(0);     // Catch: Throwable -> L6
        Object r4 = ColorStateList.CREATOR.createFromParcel(r0);     // Catch: Throwable -> L6
        d.h.b.o.c(r4, "{\n        writeToParcel(…eFromParcel(parcel)\n    }");     // Catch: Throwable -> L6
        ColorStateList r5 = (ColorStateList) ZeusTransformUtils.preCheckCast(r4, ColorStateList.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        r0.recycle();
        return r5;
    L6:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public static final c[] a(e[] r6) {
        d.h.b.o.e(r6, "<this>");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.aiagent.plugin");
        int r1 = r6.length;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        r0.add(a(r6[r4]));
        r4 = r4 + 1;
        goto L3
    L5:
        Object[] r7 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new c[0]);
        Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (c[]) ZeusTransformUtils.preCheckCast(r7, c[].class, "com.obric.aiagent.plugin");
    }

    public static final com.obric.oui.shadow.b[] a(com.obric.oui.shadow.a[] r6) {
        d.h.b.o.e(r6, "<this>");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.aiagent.plugin");
        int r1 = r6.length;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        r0.add(r6[r4].f());
        r4 = r4 + 1;
        goto L3
    L5:
        Object[] r7 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new com.obric.oui.shadow.b[0]);
        Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (com.obric.oui.shadow.b[]) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.shadow.b[].class, "com.obric.aiagent.plugin");
    }

    public static final com.obric.oui.shadow.a[] a(com.obric.oui.shadow.b[] r6) {
        d.h.b.o.e(r6, "<this>");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.aiagent.plugin");
        int r1 = r6.length;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L5;
        r0.add(com.obric.oui.shadow.c.a(r6[r4]));
        r4 = r4 + 1;
        goto L3
    L5:
        Object[] r7 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new com.obric.oui.shadow.a[0]);
        Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (com.obric.oui.shadow.a[]) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.shadow.a[].class, "com.obric.aiagent.plugin");
    }
}
