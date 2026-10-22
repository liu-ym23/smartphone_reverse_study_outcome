package com.obric.autogui.platforms.obric.e.a;

import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ThermalMonitorSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "O-P-ThermalSelector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f30129a = null;

    static {
        f30129a = new e();
    }

    private e() {
    }

    public final f a(d r9) {
        d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
        o.e(r10, "thermalLevelEmitter");
        String r0 = a();
        String r2 = b();
        String r3 = com.obric.autogui.common.a.d.f28974a.b(r0);
        int r8 = a(r2, r3);
        boolean r5 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L5;
    L8:
        r5 = false;
    L9:
        Loog.INSTANCE.i(TAG, "select: productName=" + r0 + ", shortOSVersion=" + r2 + ", powerManagerMinShortOSVersion=" + r3 + ", versionCompareResult=" + r8 + ", usePowerManager=" + r5);
        if (r5 == false) goto L13;
        return (f) ZeusTransformUtils.preCheckCast(new c(r10), f.class, "com.obric.aiagent.plugin");
    L13:
        return (f) ZeusTransformUtils.preCheckCast(new a(r10), f.class, "com.obric.aiagent.plugin");
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L8;
        if (r8 <= 0) goto L8;
        goto L8
    }

    private final String a() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        e r5 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = n.f(ObricProductSdk.INSTANCE.featureService().getObricProductName());     // Catch: Throwable -> L5
    L7:
        Throwable r2 = n.c(r6);
        if (r2 == null) goto L11;
        Loog.INSTANCE.e(TAG, "getCurrentProductName: get product name failed", r2);
    L11:
        if (n.b(r6) == false) goto L14;
        r6 = "";
    L14:
        return (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r3 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L7
    }

    private final String b() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        e r5 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = n.f(ObricProductSdk.INSTANCE.platformService().romInfo().getShortOSVersion());     // Catch: Throwable -> L5
    L7:
        Throwable r2 = n.c(r6);
        if (r2 == null) goto L11;
        Loog.INSTANCE.e(TAG, "getCurrentShortOSVersion: get short OS version failed", r2);
    L11:
        if (n.b(r6) == false) goto L14;
        r6 = "";
    L14:
        return (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r3 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L7
    }

    private final int a(String r9, String r10) {
        List<Integer> r11 = a(r9);
        List<Integer> r8 = a(r10);
        int r12 = Math.max(r11.size(), r8.size());
        int r2 = 0;
    L3:
        if (r2 >= r12) goto L29;
        if (r2 >= 0) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L12;
        Integer r5 = r11.get(r2);
    L13:
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r2 >= 0) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == false) goto L21;
        Integer r13 = r8.get(r2);
    L22:
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r6 > r14) goto L24;
        if (r6 < r14) goto L26;
        r2 = r2 + 1;
        goto L3
    L26:
        return -1;
    L24:
        return 1;
    L21:
        r13 = 0;
        goto L22
    L16:
        if (r2 >= r8.size()) goto L18;
        r7 = true;
        goto L19
    L12:
        r5 = 0;
        goto L13
    L7:
        if (r2 >= r11.size()) goto L9;
        r4 = true;
        goto L10
    L29:
        return 0;
    }

    private final List<Integer> a(String r8) {
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"."}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r7.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r1 = r10.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        r9.add(r1);
        goto L4
    L8:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r11.iterator();
    L10:
        if (r13.hasNext() == false) goto L22;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
        int r3 = r2.length();
        int r4 = 0;
        int r5 = 0;
    L12:
        if (r5 >= r3) goto L17;
        if (Character.isDigit(r2.charAt(r5)) == false) goto L15;
        r5 = r5 + 1;
        goto L12
    L15:
        r2 = r2.substring(0, r5);
        o.c(r2, "substring(...)");
    L17:
        Integer r6 = d.o.o.d(r2);
        if (r6 == null) goto L20;
        r4 = r6.intValue();
    L20:
        r12.add(Integer.valueOf(r4));
        goto L10
    L22:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
    }
}
