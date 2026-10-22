package com.obric.oui.material;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f15302a = null;

    static {
        f15302a = new p();
    }

    public p() {
    }

    public final Object a(String r10, Map r11) {
        kotlin.jvm.internal.q.g(r11, "tokens");
        if (r10 != null) goto L5;
    L4:
        String r12 = null;
    L9:
        if (r12 != null) goto L11;
        return null;
    L11:
        if (r12.length() != 0) goto L14;
        return null;
    L14:
        return r11.get(r12);
    L5:
        Locale r13 = Locale.ROOT;
        kotlin.jvm.internal.q.f(r13, "ROOT");
        String r14 = r10.toLowerCase(r13);
        kotlin.jvm.internal.q.f(r14, "this as java.lang.String).toLowerCase(locale)");
        if (r14 == null) goto L4;
        r12 = StringsKt__StringsKt.z0(r14).toString();
        goto L9
    }

    public final void b(Map r10, Object r11, Object r12) {
        if (r10.containsKey(r11) == true) goto L6;
        r10.put(r11, r12);
        return;
    }

    public final void c(Map r10, Map r11, boolean r12) {
        kotlin.jvm.internal.q.g(r10, "tokenMap");
        kotlin.jvm.internal.q.g(r11, "customTokens");
        if (r11.isEmpty() == false) goto L6;
        return;
    L6:
        if (r12 == false) goto L13;
        Iterator r13 = r11.entrySet().iterator();
    L9:
        if (r13.hasNext() == false) goto L19;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        Object r16 = r14.getValue();
        Locale r17 = Locale.ROOT;
        kotlin.jvm.internal.q.f(r17, "ROOT");
        String r18 = r15.toLowerCase(r17);
        kotlin.jvm.internal.q.f(r18, "this as java.lang.String).toLowerCase(locale)");
        String r19 = StringsKt__StringsKt.z0(r18).toString();
        if (r19.length() <= 0) goto L9;
        r10.put(r19, r16);
        goto L9
    L19:
        return;
    L13:
        Iterator r20 = r11.entrySet().iterator();
    L15:
        if (r20.hasNext() == false) goto L30;
        Map.Entry r21 = (Map.Entry) r20.next();
        String r22 = (String) r21.getKey();
        Object r23 = r21.getValue();
        Locale r24 = Locale.ROOT;
        kotlin.jvm.internal.q.f(r24, "ROOT");
        String r25 = r22.toLowerCase(r24);
        kotlin.jvm.internal.q.f(r25, "this as java.lang.String).toLowerCase(locale)");
        String r26 = StringsKt__StringsKt.z0(r25).toString();
        if (r26.length() <= 0) goto L15;
        b(r10, r26, r23);
        goto L15
    }
}
