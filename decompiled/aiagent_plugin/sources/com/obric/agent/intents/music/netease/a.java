package com.obric.agent.intents.music.netease;

import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.o.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: BundleExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ String a(Bundle r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        return a(r0, r1);
    }

    public static final String a(Bundle r8, int r9) {
        if (r8 != null) goto L5;
        return "Bundle is null";
    L5:
        String r0 = o.a((CharSequence) ZeusTransformUtils.preCheckCast("  ", CharSequence.class, "com.obric.aiagent.plugin"), r9);
        int r10 = r9 + 1;
        String r1 = o.a((CharSequence) ZeusTransformUtils.preCheckCast("  ", CharSequence.class, "com.obric.aiagent.plugin"), r10);
        StringBuilder r3 = new StringBuilder("Bundle {\n");
        Iterator<String> r4 = r8.keySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin");
        r3.append(r1 + r5 + " = " + a(r8.get(r5), r10) + '\n');
        goto L7
    L9:
        r3.append(r0 + '}');
        String r11 = r3.toString();
        d.h.b.o.c(r11, "toString(...)");
        return r11;
    }

    private static final String a(Object r3, int r4) {
        if (r3 != null) goto L5;
        return "null";
    L5:
        if (ZeusTransformUtils.instanceOf(r3, Bundle.class) == false) goto L8;
        return a((Bundle) ZeusTransformUtils.preCheckCast(r3, Bundle.class, "com.obric.aiagent.plugin"), r4);
    L8:
        if (ZeusTransformUtils.instanceOf(r3, ArrayList.class) == false) goto L11;
        return a((ArrayList) ZeusTransformUtils.preCheckCast(r3, ArrayList.class, "com.obric.aiagent.plugin"), r4);
    L11:
        if ((r3 instanceof Object[]) == false) goto L14;
        return a((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.aiagent.plugin"), r4);
    L14:
        if ((r3 instanceof int[]) == false) goto L17;
        StringBuilder r5 = new StringBuilder();
        String r6 = Arrays.toString((int[]) ZeusTransformUtils.preCheckCast(r3, int[].class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r6, "toString(...)");
        return r5.append(r6).append(" (IntArray)").toString();
    L17:
        if ((r3 instanceof long[]) == false) goto L20;
        StringBuilder r7 = new StringBuilder();
        String r8 = Arrays.toString((long[]) ZeusTransformUtils.preCheckCast(r3, long[].class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r8, "toString(...)");
        return r7.append(r8).append(" (LongArray)").toString();
    L20:
        if ((r3 instanceof float[]) == false) goto L23;
        StringBuilder r9 = new StringBuilder();
        String r10 = Arrays.toString((float[]) ZeusTransformUtils.preCheckCast(r3, float[].class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r10, "toString(...)");
        return r9.append(r10).append(" (FloatArray)").toString();
    L23:
        if ((r3 instanceof double[]) == false) goto L26;
        StringBuilder r11 = new StringBuilder();
        String r12 = Arrays.toString((double[]) ZeusTransformUtils.preCheckCast(r3, double[].class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r12, "toString(...)");
        return r11.append(r12).append(" (DoubleArray)").toString();
    L26:
        if ((r3 instanceof boolean[]) == false) goto L29;
        StringBuilder r13 = new StringBuilder();
        String r14 = Arrays.toString((boolean[]) ZeusTransformUtils.preCheckCast(r3, boolean[].class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r14, "toString(...)");
        return r13.append(r14).append(" (BooleanArray)").toString();
    L29:
        return r3 + " (" + r3.getClass().getSimpleName() + ')';
    }

    private static final String a(ArrayList<?> r8, int r9) {
        if (r8.isEmpty() == false) goto L6;
        return "ArrayList (empty)";
    L6:
        String r0 = o.a((CharSequence) ZeusTransformUtils.preCheckCast("  ", CharSequence.class, "com.obric.aiagent.plugin"), r9);
        int r10 = r9 + 1;
        String r1 = o.a((CharSequence) ZeusTransformUtils.preCheckCast("  ", CharSequence.class, "com.obric.aiagent.plugin"), r10);
        StringBuilder r3 = new StringBuilder("ArrayList [\n");
        int r2 = 0;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        Object r4 = r11.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L12;
        p.c();
    L12:
        r3.append(r1 + '[' + r2 + "] = " + a(r4, r10) + '\n');
        r2 = r5;
        goto L8
    L13:
        r3.append(r0 + ']');
        String r12 = r3.toString();
        d.h.b.o.c(r12, "toString(...)");
        return r12;
    }

    private static final String a(Object[] r10, int r11) {
        int r1 = 0;
        if (r10.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "Array (empty)";
    L9:
        String r2 = o.a((CharSequence) ZeusTransformUtils.preCheckCast("  ", CharSequence.class, "com.obric.aiagent.plugin"), r11);
        int r12 = r11 + 1;
        String r3 = o.a((CharSequence) ZeusTransformUtils.preCheckCast("  ", CharSequence.class, "com.obric.aiagent.plugin"), r12);
        StringBuilder r4 = new StringBuilder("Array [\n");
        int r5 = r10.length;
        int r6 = 0;
    L10:
        if (r1 >= r5) goto L12;
        r4.append(r3 + '[' + r6 + "] = " + a(r10[r1], r12) + '\n');
        r1 = r1 + 1;
        r6 = r6 + 1;
        goto L10
    L12:
        r4.append(r2 + ']');
        String r13 = r4.toString();
        d.h.b.o.c(r13, "toString(...)");
        return r13;
    L5:
        r0 = false;
        goto L6
    }
}
