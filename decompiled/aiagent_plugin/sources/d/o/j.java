package d.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes4.dex */
final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matcher f38639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f38640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f38641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f38642d;

    /* JADX INFO: compiled from: Regex.kt */
    public static final class a extends d.a.c<String> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f38643b;

        a(j r1) {
            this.f38643b = r1;
        }

        public int a(String r1) {
            return super.indexOf(r1);
        }

        public int b(String r1) {
            return super.lastIndexOf(r1);
        }

        public boolean c(String r1) {
            return super.contains(r1);
        }

        @Override // d.a.a, java.util.Collection
        public final boolean contains(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.a.c, java.util.List
        public /* synthetic */ Object get(int r1) {
            return a(r1);
        }

        @Override // d.a.c, java.util.List
        public final int indexOf(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return -1;
        L7:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.a.c, java.util.List
        public final int lastIndexOf(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return -1;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.a.a
        public int a() {
            return j.a(this.f38643b).groupCount() + 1;
        }

        public String a(int r1) {
            String r0 = j.a(this.f38643b).group(r1);
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    public static final class b extends d.a.a<f> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f38644a;

        /* JADX INFO: compiled from: Regex.kt */
        static final class a extends d.h.b.p implements d.h.a.b<Integer, f> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f38645a;

            a(b r1) {
                this.f38645a = r1;
                super(1);
            }

            public final f a(int r1) {
                return this.f38645a.a(r1);
            }

            @Override // d.h.a.b
            public /* synthetic */ f invoke(Integer r3) {
                return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
            }
        }

        @Override // d.a.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        b(j r1) {
            this.f38644a = r1;
        }

        public boolean a(f r1) {
            return super.contains(r1);
        }

        @Override // d.a.a, java.util.Collection
        public final boolean contains(Object r3) {
            if (r3 != null) goto L4;
            boolean r0 = true;
        L5:
            if (r0 == true) goto L9;
            return false;
        L9:
            return a((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin"));
        L4:
            r0 = ZeusTransformUtils.instanceOf(r3, f.class);
            goto L5
        }

        @Override // d.a.a
        public int a() {
            return j.a(this.f38644a).groupCount() + 1;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<f> iterator() {
            return d.n.m.d(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(this, Collection.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this), d.h.a.b.class, "com.obric.aiagent.plugin")).a();
        }

        @Override // d.o.g
        public f a(int r3) {
            d.l.j r0 = l.a(j.a(this.f38644a), r3);
            if (r0.f().intValue() < 0) goto L5;
            String r2 = j.a(this.f38644a).group(r3);
            d.h.b.o.c(r2, "group(...)");
            return new f(r2, r0);
        L5:
            return null;
        }
    }

    public j(Matcher r3, CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "matcher");
        d.h.b.o.e(r5, "input");
        this.f38639a = r3;
        this.f38640b = r5;
        this.f38641c = (g) ZeusTransformUtils.preCheckCast(new b(this), g.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ MatchResult a(j r0) {
        return r0.g();
    }

    @Override // d.o.i
    public i.b e() {
        return i.a.a(this);
    }

    private final MatchResult g() {
        return (MatchResult) ZeusTransformUtils.preCheckCast(this.f38639a, MatchResult.class, "com.obric.aiagent.plugin");
    }

    @Override // d.o.i
    public d.l.j a() {
        return l.a(g());
    }

    @Override // d.o.i
    public String b() {
        String r1 = g().group();
        d.h.b.o.c(r1, "group(...)");
        return r1;
    }

    @Override // d.o.i
    public g c() {
        return this.f38641c;
    }

    @Override // d.o.i
    public List<String> d() {
        if (this.f38642d != null) goto L5;
        this.f38642d = (List) ZeusTransformUtils.preCheckCast(new a(this), List.class, "com.obric.aiagent.plugin");
    L5:
        List<String> r3 = this.f38642d;
        d.h.b.o.a(r3);
        return r3;
    }

    @Override // d.o.i
    public i f() {
        int r0 = g().end();
        if (g().end() != g().start()) goto L5;
        int r1 = 1;
    L6:
        int r2 = r0 + r1;
        if (r2 > this.f38640b.length()) goto L9;
        Matcher r3 = this.f38639a.pattern().matcher(this.f38640b);
        d.h.b.o.c(r3, "matcher(...)");
        return l.a(r3, r2, this.f38640b);
    L9:
        return null;
    L5:
        r1 = 0;
        goto L6
    }
}
