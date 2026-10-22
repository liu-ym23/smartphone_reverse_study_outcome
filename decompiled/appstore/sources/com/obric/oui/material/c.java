package com.obric.oui.material;

import android.graphics.Color;
import com.obric.oui.color.i0;
import com.obric.oui.color.j0;
import com.obric.oui.graphic.BlendMode;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f15225a = null;

    static {
        f15225a = new c();
    }

    public c() {
    }

    public final com.obric.oui.color.a[] a(int r10) {
        return new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, BlendMode.SRC_OVER), new com.obric.oui.color.a(-3355444, BlendMode.OVERLAY), new com.obric.oui.color.a(r10, BlendMode.PLUS_DARKER)};
    }

    public final b[] b(b[] r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "baseConfigs");
        int r12 = i0.a(r11, 0.1f);
        int r13 = Color.argb(102, Color.red(r12), Color.green(r12), Color.blue(r12));
        ArrayList r14 = new ArrayList(r10.length);
        int r15 = r10.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L9;
        b r17 = r10[r16];
        b r18 = r17.a();
        r18.l(f15225a.a(r12));
        j0 r19 = r17.j();
        if (r19 != null) goto L7;
        j0 r20 = null;
    L8:
        r18.s(r20);
        r14.add(r18);
        r16 = r16 + 1;
        goto L3
    L7:
        r20 = new j0(r19.c(), r13, r19.a());
        goto L8
    L9:
        Object[] r21 = r14.toArray(new b[0]);
        if (r21 == null) goto L14;
        return (b[]) r21;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
