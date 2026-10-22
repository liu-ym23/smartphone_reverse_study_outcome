package com.obric.oui.material;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: TokenParser.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f35506a = null;

    static {
        f35506a = new n();
    }

    private n() {
    }

    public final <T> T a(String r4, Map<String, ? extends T> r5) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "tokens");
        if (r4 != null) goto L5;
    L4:
        String r6 = null;
    L9:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L12;
    L15:
        boolean r1 = true;
    L16:
        if (r1 == false) goto L19;
        return null;
    L19:
        return (T) r3.get(r6);
    L12:
        if (r0.length() == 0) goto L15;
        r1 = false;
        goto L16
    L5:
        Locale r2 = Locale.ROOT;
        d.h.b.o.c(r2, "ROOT");
        String r7 = r4.toLowerCase(r2);
        d.h.b.o.c(r7, "this as java.lang.String).toLowerCase(locale)");
        if (r7 == null) goto L4;
        r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        goto L9
    }

    public final <T> void a(Map<String, T> r8, Map<String, ? extends T> r9, boolean r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "tokenMap");
        d.h.b.o.e(r12, "customTokens");
        if (r12.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10 == false) goto L16;
        Iterator r7 = r12.entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L25;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.aiagent.plugin");
        Object r15 = r13.getValue();
        Locale r5 = Locale.ROOT;
        d.h.b.o.c(r5, "ROOT");
        String r16 = r14.toLowerCase(r5);
        d.h.b.o.c(r16, "this as java.lang.String).toLowerCase(locale)");
        String r17 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L9;
        r11.put(r17, r15);
        goto L9
    L13:
        r6 = false;
        goto L14
    L25:
        return;
    L16:
        Iterator r18 = r12.entrySet().iterator();
    L18:
        if (r18.hasNext() == false) goto L36;
        Map.Entry r19 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.getKey(), String.class, "com.obric.aiagent.plugin");
        Object r110 = r19.getValue();
        Locale r21 = Locale.ROOT;
        d.h.b.o.c(r21, "ROOT");
        String r22 = r20.toLowerCase(r21);
        d.h.b.o.c(r22, "this as java.lang.String).toLowerCase(locale)");
        String r23 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L22;
        boolean r24 = true;
    L23:
        if (r24 == false) goto L18;
        a(r11, r23, r110);
        goto L18
    L22:
        r24 = false;
        goto L23
    }

    private final <K, V> void a(Map<K, V> r2, K r3, V r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r1.containsKey(r3) == true) goto L6;
        r1.put(r3, r4);
        return;
    }
}
