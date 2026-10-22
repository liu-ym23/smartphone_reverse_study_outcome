package com.obric.oui.material;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OMaterialExtBase.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k {
    public static final boolean a(View r2) {
        d.h.b.o.e(r2, "<this>");
        return l.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public static final boolean a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        return l.a(r3);
    }

    public static final int b(View r2) {
        d.h.b.o.e(r2, "<this>");
        return l.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public static final void a(View r1, boolean r2) {
        d.h.b.o.e(r1, "<this>");
        l.a(r1, r2);
    }

    public static final void b(View r1, boolean r2) {
        d.h.b.o.e(r1, "<this>");
        l.b(r1, r2);
    }

    public static /* synthetic */ void a(View r0, c[] r1, boolean r2, int r3, Integer r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = 2;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = null;
    L11:
        a(r0, r1, r2, r3, r4);
    }

    public static final void a(View r2, c[] r3, boolean r4, int r5, Integer r6) {
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r3, "materials");
        if (r6 == null) goto L5;
        b(r2, r3[r6.intValue() - 1], r4, r5);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        a("OUIMaterial", "error!! View.materials: error level=" + r6 + ", " + e);
        return;
    L5:
        if (r3.length != 1) goto L8;
        a(r2, r3[0], r4, r5);
        return;
    L8:
        a(r2, r3, r4, r5);
        a(r2, r3[Math.min(r3.length - 1, Math.max(0, b(r2) - 1))]);
    }

    public static /* synthetic */ void a(View r0, c[] r1, boolean r2, Integer r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        a(r0, r1, r2, r3);
    }

    public static final void a(View r8, c[] r9, boolean r10, Integer r11) {
        d.h.b.o.e(r8, "<this>");
        d.h.b.o.e(r9, "materials");
        boolean r0 = true;
        if (r11 == null) goto L5;
        a(r8, r9[r11.intValue() - 1], r10, 3);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        a("OUIMaterial", "error!! View.materialsFromWindow: error level=" + r11 + ", " + e);
        return;
    L5:
        if (r9.length == 0) goto L8;
        r0 = false;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        a(r8, r9, r10, 3, null, 8, null);
    }

    public static final void a(View r1, c[] r2, boolean r3, int r4) {
        d.h.b.o.e(r1, "<this>");
        d.h.b.o.e(r2, "materials");
        if (r3 == false) goto L5;
        r1.setBackgroundColor(0);
    L5:
        l.a(r1, r4, r2, ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin").getDisplayMetrics().density);
    }

    public static /* synthetic */ void a(View r0, c r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 2;
    L8:
        a(r0, r1, r2, r3);
    }

    public static final void a(View r1, c r2, boolean r3, int r4) {
        d.h.b.o.e(r1, "<this>");
        d.h.b.o.e(r2, "material");
        b(r1, r2, r3, r4);
    }

    public static final void b(View r1, c r2, boolean r3, int r4) {
        d.h.b.o.e(r1, "<this>");
        d.h.b.o.e(r2, "material");
        a(r1, r2);
        if (l.a() == true) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
        r1.setBackgroundColor(0);
    L7:
        l.a(r1, r4, r2, ZeusTransformUtils.getResources(r1, "com.obric.aiagent.plugin").getDisplayMetrics().density);
    }

    private static final void a(View r5, c r6) {
        if (ZeusTransformUtils.instanceOf(r5, com.obric.oui.common.style.b.class) == true) goto L5;
        return;
    L5:
        if (((com.obric.oui.common.style.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.common.style.b.class, "com.obric.aiagent.plugin")).isEnableShadowWidthRadius() == false) goto L21;
        com.obric.oui.shadow.a[] r7 = r6.i();
        if (r7 != null) goto L12;
        ((com.obric.oui.common.style.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.common.style.b.class, "com.obric.aiagent.plugin")).a(null, null);
        return;
    L12:
        if (r7.length <= 1) goto L15;
        float r0 = ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getDisplayMetrics().density;
        ((com.obric.oui.common.style.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.common.style.b.class, "com.obric.aiagent.plugin")).a(com.obric.oui.common.style.j.f34539a.a(r7[0], r0), com.obric.oui.common.style.j.f34539a.a(r7[1], r0));
        return;
    L15:
        if (r7.length != 1) goto L20;
        float r2 = ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getDisplayMetrics().density;
        ((com.obric.oui.common.style.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.common.style.b.class, "com.obric.aiagent.plugin")).a(com.obric.oui.common.style.j.f34539a.a(r7[0], r2), null);
        return;
    L20:
        return;
    }

    public static final void c(View r1, boolean r2) {
        d.h.b.o.e(r1, "<this>");
        if (r2 == false) goto L5;
        l.b(r1, 2);
        return;
    L5:
        l.b(r1, 3);
    }

    public static final void a(View r1, int r2) {
        d.h.b.o.e(r1, "<this>");
        if (r2 == (-1)) goto L6;
        l.b(r1, r2);
        return;
    }

    public static final void a(View r1, View r2) {
        d.h.b.o.e(r1, "<this>");
        l.a(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
