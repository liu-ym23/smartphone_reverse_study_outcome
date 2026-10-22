package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StringsKt__IndentKt extends h {
    public static final Function1 b(final String r10) {
        if (r10.length() != 0) goto L6;
        return StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
    L6:
        return new StringsKt__IndentKt$getIndentFunction$2(r10);
    }

    public static final int c(String r10) {
        int r11 = r10.length();
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L9;
        if (a.c(r10.charAt(r12)) == false) goto L10;
        r12 = r12 + 1;
    L10:
        if (r12 == (-1)) goto L12;
        return r12;
    L12:
        return r10.length();
    L9:
        r12 = -1;
        goto L10
    }

    public static final String d(String r14, String r15) {
        kotlin.jvm.internal.q.g(r14, "<this>");
        kotlin.jvm.internal.q.g(r15, "newIndent");
        List r10 = StringsKt__StringsKt.Z(r14);
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (o.r((String) r13) == true) goto L4;
        r11.add(r13);
        goto L4
    L8:
        ArrayList r16 = new ArrayList(u.r(r11, 10));
        Iterator r17 = r11.iterator();
    L10:
        if (r17.hasNext() == false) goto L12;
        r16.add(Integer.valueOf(c((String) r17.next())));
        goto L10
    L12:
        Integer r18 = (Integer) b0.l0(r16);
        int r19 = 0;
        if (r18 == null) goto L15;
        int r20 = r18.intValue();
    L16:
        int r110 = r14.length() + (r15.length() * r10.size());
        Function1 r111 = b(r15);
        int r21 = t.k(r10);
        ArrayList r22 = new ArrayList();
        Iterator r23 = r10.iterator();
    L18:
        if (r23.hasNext() == false) goto L37;
        Object r24 = r23.next();
        int r25 = r19 + 1;
        if (r19 >= 0) goto L22;
        t.q();
    L22:
        String r26 = (String) r24;
        if (r19 == 0) goto L26;
        if (r19 == r21) goto L26;
    L28:
        String r27 = q.C0(r26, r20);
        if (r27 == null) goto L34;
        String r28 = (String) r111.invoke(r27);
        if (r28 == null) goto L34;
        r26 = r28;
    L34:
        if (r26 == null) goto L36;
        r22.add(r26);
    L36:
        r19 = r25;
    L26:
        if (o.r(r26) == false) goto L28;
        r26 = null;
        goto L34
    L37:
        String r112 = ((StringBuilder) b0.f0(r22, new StringBuilder(r110), "\n", null, null, 0, null, null, 124, null)).toString();
        kotlin.jvm.internal.q.f(r112, "toString(...)");
        return r112;
    L15:
        r20 = 0;
        goto L16
    }

    public static String e(String r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return d(r10, "");
    }
}
