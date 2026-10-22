package d.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pattern f38647b;

    /* JADX INFO: compiled from: Regex.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private final int a(int r1) {
            if ((r1 & 2) != 0) goto L5;
            return r1;
        L5:
            return r1 | 64;
        }

        private a() {
        }

        public static final /* synthetic */ int a(a r0, int r1) {
            return r0.a(r1);
        }

        public final String a(String r1) {
            d.h.b.o.e(r1, "literal");
            String r0 = Pattern.quote(r1);
            d.h.b.o.c(r0, "quote(...)");
            return r0;
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    static final class b extends d.h.b.p implements d.h.a.a<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f38648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CharSequence f38649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f38650c;

        b(k r3, CharSequence r4, int r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
            this.f38648a = r3;
            this.f38649b = r6;
            this.f38650c = r5;
            super(0);
        }

        public final i a() {
            return this.f38648a.a(this.f38649b, this.f38650c);
        }

        @Override // d.h.a.a
        public /* synthetic */ i invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    /* synthetic */ class c extends d.h.b.l implements d.h.a.b<i, i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f38651a = null;

        static {
            f38651a = new c();
        }

        c() {
            super(1, i.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        public final i a(i r2) {
            i r1 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "p0");
            return r1.f();
        }

        @Override // d.h.a.b
        public /* synthetic */ i invoke(i r3) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f38646a = new a(null);
    }

    public k(Pattern r2) {
        d.h.b.o.e(r2, "nativePattern");
        this.f38647b = r2;
    }

    public k(String r2) {
        d.h.b.o.e(r2, "pattern");
        Pattern r3 = Pattern.compile(r2);
        d.h.b.o.c(r3, "compile(...)");
        this(r3);
    }

    public k(String r2, m r3) {
        d.h.b.o.e(r2, "pattern");
        d.h.b.o.e(r3, "option");
        Pattern r4 = Pattern.compile(r2, a.a(f38646a, r3.a()));
        d.h.b.o.c(r4, "compile(...)");
        this(r4);
    }

    public final boolean a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "input");
        return this.f38647b.matcher(r4).matches();
    }

    public final boolean b(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "input");
        return this.f38647b.matcher(r4).find();
    }

    public static /* synthetic */ i a(k r1, CharSequence r2, int r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        return r1.a(r6, r3);
    }

    public final i a(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "input");
        Matcher r2 = this.f38647b.matcher(r5);
        d.h.b.o.c(r2, "matcher(...)");
        return l.a(r2, r4, r5);
    }

    public static /* synthetic */ d.n.j b(k r1, CharSequence r2, int r3, int r4, Object r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        return r1.b(r6, r3);
    }

    public final d.n.j<i> b(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "input");
        if (r4 < 0) goto L9;
        if (r4 > r5.length()) goto L9;
        return d.n.m.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(this, r5, r4), d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(c.f38651a, d.h.a.b.class, "com.obric.aiagent.plugin"));
    L9:
        throw new IndexOutOfBoundsException("Start index out of bounds: " + r4 + ", input length: " + r5.length());
    }

    public final i c(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "input");
        Matcher r2 = this.f38647b.matcher(r4);
        d.h.b.o.c(r2, "matcher(...)");
        return l.a(r2, r4);
    }

    public final String a(CharSequence r3, String r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "input");
        d.h.b.o.e(r4, "replacement");
        String r2 = this.f38647b.matcher(r5).replaceAll(r4);
        d.h.b.o.c(r2, "replaceAll(...)");
        return r2;
    }

    public final String a(CharSequence r6, d.h.a.b<? super i, ? extends CharSequence> r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "input");
        d.h.b.o.e(r9, "transform");
        int r0 = 0;
        i r5 = a(this, r8, 0, 2, null);
        if (r5 == null) goto L5;
        int r2 = r8.length();
        StringBuilder r3 = new StringBuilder(r2);
    L7:
        r3.append(r8, r0, r5.a().f().intValue());
        r3.append((CharSequence) ZeusTransformUtils.preCheckCast(r9.invoke(r5), CharSequence.class, "com.obric.aiagent.plugin"));
        r0 = r5.a().i().intValue() + 1;
        r5 = r5.f();
        if (r0 >= r2) goto L10;
        if (r5 != null) goto L7;
    L10:
        if (r0 >= r2) goto L12;
        r3.append(r8, r0, r2);
    L12:
        String r10 = r3.toString();
        d.h.b.o.c(r10, "toString(...)");
        return r10;
    L5:
        return r8.toString();
    }

    public final List<String> c(CharSequence r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "input");
        o.a(r6);
        Matcher r4 = this.f38647b.matcher(r7);
        if (r6 == 1) goto L20;
        if (r4.find() == false) goto L20;
        int r3 = 10;
        if (r6 <= 0) goto L10;
        r3 = d.l.n.d(r6, 10);
    L10:
        ArrayList r2 = new ArrayList(r3);
        int r8 = 0;
        int r9 = r6 - 1;
    L11:
        r2.add(r7.subSequence(r8, r4.start()).toString());
        r8 = r4.end();
        if (r9 < 0) goto L16;
        if (r2.size() != r9) goto L16;
    L17:
        r2.add(r7.subSequence(r8, r7.length()).toString());
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    L16:
        if (r4.find() == true) goto L11;
    L20:
        return d.a.p.a(r7.toString());
    }

    public String toString() {
        String r1 = this.f38647b.toString();
        d.h.b.o.c(r1, "toString(...)");
        return r1;
    }
}
