package com.obric.oui.material;

import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: MaterialOwner.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {
    public static final void a(View r1, boolean r2, boolean r3) {
        d.h.b.o.e(r1, "<this>");
        if (r3 == false) goto L5;
        k.a(r1, r2);
        return;
    L5:
        k.b(r1, r2);
    }

    public static final void a(View r1, boolean r2, int r3) {
        d.h.b.o.e(r1, "<this>");
        if (r2 == false) goto L5;
        l.a(r1, r3, 1);
        return;
    L5:
        l.a(r1, 0, 1);
    }

    public static final void a(Iterable<? extends g> r3, boolean r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.aiagent.plugin")).applyContentMaterial(r4);
        goto L4
    }

    public static final void a(Iterable<? extends g> r3, View r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.aiagent.plugin")).setBackdropTarget(r4);
        goto L4
    }

    public static final void b(Iterable<? extends g> r3, boolean r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.aiagent.plugin")).updateBackdropTargetType(r4);
        goto L4
    }

    public static final void a(Iterable<? extends g> r3, int r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.aiagent.plugin")).updateBackdropSrcType(r4);
        goto L4
    }

    public static final void a(ViewGroup[] r9, boolean r10) {
        d.h.b.o.e(r9, "<this>");
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        ViewGroup r3 = r9[r2];
        int r4 = r3.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L14;
        int r6 = r5 + 1;
        View r7 = r3.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r7, g.class) == false) goto L9;
        g r8 = (g) ZeusTransformUtils.preCheckCast(r7, g.class, "com.obric.aiagent.plugin");
    L10:
        if (r8 == null) goto L13;
        r8.applyContentMaterial(r10);
    L13:
        r5 = r6;
        goto L5
    L9:
        r8 = null;
        goto L10
    L14:
        r2 = r2 + 1;
        goto L3
    }

    public static final void a(ViewGroup[] r9, View r10) {
        d.h.b.o.e(r9, "<this>");
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        ViewGroup r3 = r9[r2];
        int r4 = r3.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L14;
        int r6 = r5 + 1;
        View r7 = r3.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r7, g.class) == false) goto L9;
        g r8 = (g) ZeusTransformUtils.preCheckCast(r7, g.class, "com.obric.aiagent.plugin");
    L10:
        if (r8 == null) goto L13;
        r8.setBackdropTarget(r10);
    L13:
        r5 = r6;
        goto L5
    L9:
        r8 = null;
        goto L10
    L14:
        r2 = r2 + 1;
        goto L3
    }

    public static final void b(ViewGroup[] r9, boolean r10) {
        d.h.b.o.e(r9, "<this>");
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        ViewGroup r3 = r9[r2];
        int r4 = r3.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L14;
        int r6 = r5 + 1;
        View r7 = r3.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r7, g.class) == false) goto L9;
        g r8 = (g) ZeusTransformUtils.preCheckCast(r7, g.class, "com.obric.aiagent.plugin");
    L10:
        if (r8 == null) goto L13;
        r8.updateBackdropTargetType(r10);
    L13:
        r5 = r6;
        goto L5
    L9:
        r8 = null;
        goto L10
    L14:
        r2 = r2 + 1;
        goto L3
    }

    public static final void a(ViewGroup[] r9, int r10) {
        d.h.b.o.e(r9, "<this>");
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        ViewGroup r3 = r9[r2];
        int r4 = r3.getChildCount();
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L14;
        int r6 = r5 + 1;
        View r7 = r3.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r7, g.class) == false) goto L9;
        g r8 = (g) ZeusTransformUtils.preCheckCast(r7, g.class, "com.obric.aiagent.plugin");
    L10:
        if (r8 == null) goto L13;
        r8.updateBackdropSrcType(r10);
    L13:
        r5 = r6;
        goto L5
    L9:
        r8 = null;
        goto L10
    L14:
        r2 = r2 + 1;
        goto L3
    }
}
