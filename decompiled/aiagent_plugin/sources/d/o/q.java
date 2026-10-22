package d.o;

import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Indent.kt */
/* JADX INFO: loaded from: classes4.dex */
class q extends p {

    /* JADX INFO: compiled from: Indent.kt */
    static final class a extends d.h.b.p implements d.h.a.b<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38659a = null;

        static {
            f38659a = new a();
        }

        a() {
            super(1);
        }

        public final String a(String r1) {
            d.h.b.o.e(r1, "line");
            return r1;
        }

        @Override // d.h.a.b
        public /* synthetic */ String invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: Indent.kt */
    static final class b extends d.h.b.p implements d.h.a.b<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f38660a;

        b(String r1) {
            this.f38660a = r1;
            super(1);
        }

        public final String a(String r2) {
            d.h.b.o.e(r2, "line");
            return this.f38660a + r2;
        }

        @Override // d.h.a.b
        public /* synthetic */ String invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    public q() {
    }

    public static /* synthetic */ String a(String r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "|";
    L6:
        return o.a(r0, r1);
    }

    public static final String a(String r1, String r2) {
        d.h.b.o.e(r1, "<this>");
        d.h.b.o.e(r2, "marginPrefix");
        return o.a(r1, "", r2);
    }

    public static final String a(String r19, String r20, String r21) {
        d.h.b.o.e(r19, "<this>");
        d.h.b.o.e(r20, "newIndent");
        d.h.b.o.e(r21, "marginPrefix");
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L40;
        List<String> r1 = o.g((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"));
        int r8 = r19.length() + (r20.length() * r1.size());
        d.h.a.b<String, String> r9 = c(r20);
        int r10 = d.a.p.b(r1);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r0.iterator();
        int r2 = 0;
    L6:
        if (r12.hasNext() == false) goto L37;
        Object r3 = r12.next();
        int r14 = r2 + 1;
        if (r2 >= 0) goto L10;
        d.a.p.c();
    L10:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
        if (r2 == 0) goto L14;
        if (r2 == r10) goto L14;
    L16:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
        int r5 = r4.length();
        int r6 = 0;
    L18:
        if (r6 >= r5) goto L23;
        if ((!d.o.a.a(r4.charAt(r6))) == true) goto L21;
        r6 = r6 + 1;
        goto L18
    L21:
        int r7 = r6;
    L24:
        if (r7 != (-1)) goto L26;
    L25:
        String r13 = null;
    L29:
        if (r13 == null) goto L34;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r9.invoke(r13), String.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L34;
        r15 = r16;
    L34:
        if (r15 == null) goto L36;
        r11.add(r15);
    L36:
        r2 = r14;
        goto L6
    L26:
        int r18 = r7;
        if (o.a(r15, r21, r7, false, 4, null) == false) goto L25;
        int r17 = r18 + r21.length();
        d.h.b.o.a(r15, "null cannot be cast to non-null type java.lang.String");
        r13 = r15.substring(r17);
        d.h.b.o.c(r13, "substring(...)");
        goto L29
    L23:
        r7 = -1;
    L14:
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L16;
        r15 = null;
        goto L34
    L37:
        String r22 = ((StringBuilder) ZeusTransformUtils.preCheckCast(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(r8), Appendable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, BDImageUploader.MessageIsPreHeatResultUsed, null), StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        d.h.b.o.c(r22, "toString(...)");
        return r22;
    L40:
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static final String a(String r1) {
        d.h.b.o.e(r1, "<this>");
        return o.b(r1, "");
    }

    public static final String b(String r12, String r13) {
        d.h.b.o.e(r12, "<this>");
        d.h.b.o.e(r13, "newIndent");
        List<String> r0 = o.g((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"));
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r6, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        r7.add(Integer.valueOf(b((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"))));
        goto L10
    L12:
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(d.a.p.w((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Integer.class, "com.obric.aiagent.plugin");
        int r10 = 0;
        if (r9 == null) goto L15;
        int r11 = r9.intValue();
    L16:
        int r14 = r12.length() + (r13.length() * r0.size());
        d.h.a.b<String, String> r15 = c(r13);
        int r16 = d.a.p.b(r0);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r1.iterator();
    L18:
        if (r18.hasNext() == false) goto L37;
        Object r19 = r18.next();
        int r20 = r10 + 1;
        if (r10 >= 0) goto L22;
        d.a.p.c();
    L22:
        String r21 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.aiagent.plugin");
        if (r10 == 0) goto L26;
        if (r10 == r16) goto L26;
    L28:
        String r22 = o.c(r21, r11);
        if (r22 == null) goto L34;
        String r23 = (String) ZeusTransformUtils.preCheckCast(r15.invoke(r22), String.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L34;
        r21 = r23;
    L34:
        if (r21 == null) goto L36;
        r17.add(r21);
    L36:
        r10 = r20;
    L26:
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L28;
        r21 = null;
        goto L34
    L37:
        String r110 = ((StringBuilder) ZeusTransformUtils.preCheckCast(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(r14), Appendable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, BDImageUploader.MessageIsPreHeatResultUsed, null), StringBuilder.class, "com.obric.aiagent.plugin")).toString();
        d.h.b.o.c(r110, "toString(...)");
        return r110;
    L15:
        r11 = 0;
        goto L16
    }

    private static final int b(String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        int r1 = r0.length();
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        if ((!d.o.a.a(r0.charAt(r2))) == true) goto L10;
        r2 = r2 + 1;
    L10:
        if (r2 == (-1)) goto L12;
        return r2;
    L12:
        return r5.length();
    L9:
        r2 = -1;
        goto L10
    }

    private static final d.h.a.b<String, String> c(String r2) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f38659a, d.h.a.b.class, "com.obric.aiagent.plugin");
    L9:
        return (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r2), d.h.a.b.class, "com.obric.aiagent.plugin");
    L5:
        r0 = false;
        goto L6
    }
}
