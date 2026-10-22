package d.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.bb;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: _Strings.kt */
/* JADX INFO: loaded from: classes4.dex */
class aa extends z {

    /* JADX INFO: compiled from: _Strings.kt */
    static final class a extends d.h.b.p implements d.h.a.b<CharSequence, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38621a = null;

        static {
            f38621a = new a();
        }

        a() {
            super(1);
        }

        public final String a(CharSequence r2) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "it");
            return r1.toString();
        }

        @Override // d.h.a.b
        public /* synthetic */ String invoke(CharSequence r3) {
            return a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        }
    }

    public aa() {
    }

    public static final char h(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return r3.charAt(0);
    L10:
        throw new NoSuchElementException("Char sequence is empty.");
    L5:
        r0 = false;
        goto L6
    }

    public static final Character i(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        return Character.valueOf(r3.charAt(0));
    L5:
        r0 = false;
        goto L6
    }

    public static final char j(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return r3.charAt(o.e(r3));
    L10:
        throw new NoSuchElementException("Char sequence is empty.");
    L5:
        r0 = false;
        goto L6
    }

    public static final Character k(CharSequence r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        return Character.valueOf(r3.charAt(r3.length() - 1));
    L5:
        r0 = false;
        goto L6
    }

    public static final String c(String r1, int r2) {
        d.h.b.o.e(r1, "<this>");
        if (r2 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        String r3 = r1.substring(d.l.n.d(r2, r1.length()));
        d.h.b.o.c(r3, "substring(...)");
        return r3;
    L10:
        throw new IllegalArgumentException(("Requested character count " + r2 + " is less than zero.").toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final String d(String r2, int r3) {
        d.h.b.o.e(r2, "<this>");
        if (r3 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        return o.e(r2, d.l.n.c(r2.length() - r3, 0));
    L10:
        throw new IllegalArgumentException(("Requested character count " + r3 + " is less than zero.").toString());
    L5:
        r1 = false;
        goto L6
    }

    public static final String e(String r2, int r3) {
        d.h.b.o.e(r2, "<this>");
        if (r3 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        String r4 = r2.substring(0, d.l.n.d(r3, r2.length()));
        d.h.b.o.c(r4, "substring(...)");
        return r4;
    L10:
        throw new IllegalArgumentException(("Requested character count " + r3 + " is less than zero.").toString());
    L5:
        r1 = false;
        goto L6
    }

    public static final String f(String r1, int r2) {
        d.h.b.o.e(r1, "<this>");
        if (r2 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        int r3 = r1.length();
        String r4 = r1.substring(r3 - d.l.n.d(r2, r3));
        d.h.b.o.c(r4, "substring(...)");
        return r4;
    L10:
        throw new IllegalArgumentException(("Requested character count " + r2 + " is less than zero.").toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final List<String> b(CharSequence r2, int r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return o.a(r4, r3, r3, true);
    }

    public static final List<String> a(CharSequence r3, int r4, int r5, boolean r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "<this>");
        return o.a(r7, r4, r5, r6, (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f38621a, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final <R> List<R> a(CharSequence r7, int r8, int r9, boolean r10, d.h.a.b<? super CharSequence, ? extends R> r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r13 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, "<this>");
        d.h.b.o.e(r13, "transform");
        bb.a(r8, r9);
        int r0 = r12.length();
        int r2 = r0 / r9;
        if ((r0 % r9) != 0) goto L5;
        int r3 = 0;
    L6:
        ArrayList r4 = new ArrayList(r2 + r3);
        int r5 = 0;
    L7:
        if (r5 < 0) goto L10;
        if (r5 >= r0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L19;
        int r14 = r5 + r8;
        if (r14 < 0) goto L15;
        if (r14 > r0) goto L15;
    L17:
        r4.add(r13.invoke(r12.subSequence(r5, r14)));
        r5 = r5 + r9;
    L15:
        if (r10 == false) goto L19;
        r14 = r0;
    L19:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
    L10:
        r6 = false;
        goto L11
    L5:
        r3 = 1;
        goto L6
    }
}
