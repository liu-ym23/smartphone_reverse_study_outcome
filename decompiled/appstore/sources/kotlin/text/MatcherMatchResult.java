package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes4.dex */
public final class MatcherMatchResult implements MatchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matcher f21243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f21244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MatchGroupCollection f21245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f21246d;

    public static final class a extends kotlin.collections.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatcherMatchResult f21247a;

        public a(MatcherMatchResult r10) {
            this.f21247a = r10;
        }

        public /* bridge */ boolean a(String r10) {
            return super.contains(r10);
        }

        public String b(int r10) {
            String r11 = MatcherMatchResult.a(this.f21247a).group(r10);
            if (r11 != null) goto L6;
            return "";
        L6:
            return r11;
        }

        public /* bridge */ int c(String r10) {
            return super.indexOf(r10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return false;
        L7:
            return a((String) r10);
        }

        public /* bridge */ int d(String r10) {
            return super.lastIndexOf(r10);
        }

        @Override // kotlin.collections.b, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return b(r10);
        }

        @Override // kotlin.collections.AbstractCollection
        public int getSize() {
            return MatcherMatchResult.a(this.f21247a).groupCount() + 1;
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return -1;
        L7:
            return c((String) r10);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return -1;
        L7:
            return d((String) r10);
        }
    }

    public MatcherMatchResult(Matcher r10, CharSequence r11) {
        kotlin.jvm.internal.q.g(r10, "matcher");
        kotlin.jvm.internal.q.g(r11, "input");
        this.f21243a = r10;
        this.f21244b = r11;
        this.f21245c = new MatcherMatchResult$groups$1(this);
    }

    public static final /* synthetic */ java.util.regex.MatchResult a(MatcherMatchResult r10) {
        return r10.b();
    }

    public final java.util.regex.MatchResult b() {
        return this.f21243a;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult.b getDestructured() {
        return MatchResult.a.a(this);
    }

    @Override // kotlin.text.MatchResult
    public List getGroupValues() {
        if (this.f21246d != null) goto L5;
        this.f21246d = new a(this);
    L5:
        List r10 = this.f21246d;
        kotlin.jvm.internal.q.d(r10);
        return r10;
    }

    @Override // kotlin.text.MatchResult
    public MatchGroupCollection getGroups() {
        return this.f21245c;
    }

    @Override // kotlin.text.MatchResult
    public bg.c getRange() {
        return f.c(b());
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String r10 = b().group();
        kotlin.jvm.internal.q.f(r10, "group(...)");
        return r10;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        int r10 = b().end();
        if (b().end() != b().start()) goto L5;
        int r11 = 1;
    L6:
        int r12 = r10 + r11;
        if (r12 > this.f21244b.length()) goto L9;
        Matcher r13 = this.f21243a.pattern().matcher(this.f21244b);
        kotlin.jvm.internal.q.f(r13, "matcher(...)");
        return f.a(r13, r12, this.f21244b);
    L9:
        return null;
    L5:
        r11 = 0;
        goto L6
    }
}
