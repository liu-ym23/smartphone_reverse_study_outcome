package com.obric.autoaction.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.Iterator;

/* JADX INFO: compiled from: ComponentBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final ViewGroup a(c r6, int r7, d.h.a.b<? super a, x> r8) {
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r6, "<this>");
        o.e(r9, "block");
        View r10 = ZeusTransformUtils.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, null, "com.obric.aiagent.plugin");
        o.a(r10, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r11 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10, ViewGroup.class, "com.obric.aiagent.plugin");
        a r0 = new a(r6);
        r9.invoke(r0);
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L46;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r12.next(), d.class, "com.obric.aiagent.plugin");
        f r3 = (f) ZeusTransformUtils.preCheckCast(d.h.a.a(r1.getType()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), f.class, "com.obric.aiagent.plugin");
        r3.a(r6);
        o.a(r3);
        r6.a(r3);
        if (ZeusTransformUtils.instanceOf(r1, k.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r1, m.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r1, j.class) == true) goto L4;
        throw new d.k();
    L19:
        Integer r2 = ((m) ZeusTransformUtils.preCheckCast(r1, m.class, "com.obric.aiagent.plugin")).a();
        if (r2 == null) goto L24;
        ViewGroup r4 = (ViewGroup) ZeusTransformUtils.preCheckCast(r11.findViewById(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue()), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L24;
    L27:
        if (r4 == null) goto L40;
        if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L31;
        g r5 = (g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin");
    L32:
        if (r5 == null) goto L34;
        View r13 = r5.a(r4, r6);
    L35:
        if (r13 == null) goto L37;
        r4.addView(r13);
    L37:
        if (r5 == null) goto L4;
        o.a(r13);
        r5.a(r13, r6);
        goto L4
    L34:
        r13 = null;
        goto L35
    L31:
        r5 = null;
        goto L32
    L40:
        throw new IllegalArgumentException("Cannot find container for slot component");
    L24:
        if (ZeusTransformUtils.instanceOf(r11, ViewGroup.class) == false) goto L26;
        r4 = r11;
        goto L27
    L26:
        r4 = null;
        goto L27
    L7:
        View r14 = r11.findViewById(((k) ZeusTransformUtils.preCheckCast(r1, k.class, "com.obric.aiagent.plugin")).a());
        if (r14 == null) goto L16;
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L12;
        h r15 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
    L13:
        if (r15 == null) goto L4;
        r15.a(r14, r6);
        goto L4
    L12:
        r15 = null;
        goto L13
    L16:
        throw new IllegalArgumentException("UIComponent viewId " + ((k) ZeusTransformUtils.preCheckCast(r1, k.class, "com.obric.aiagent.plugin")).a() + " not found");
    L46:
        return r11;
    }
}
