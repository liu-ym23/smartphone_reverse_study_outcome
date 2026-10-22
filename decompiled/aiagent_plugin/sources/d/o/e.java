package d.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes4.dex */
final class e implements d.n.j<d.l.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f38627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f38628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f38629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.m<CharSequence, Integer, d.m<Integer, Integer>> f38630d;

    /* JADX INFO: compiled from: Strings.kt */
    public static final class a implements d.h.b.a.a, Iterator<d.l.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f38631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f38632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f38633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f38634d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private d.l.j f38635e;
        private int f;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(e r3) {
            this.f38631a = r3;
            this.f38632b = -1;
            int r4 = d.l.n.a(e.a(r3), 0, e.b(r3).length());
            this.f38633c = r4;
            this.f38634d = r4;
        }

        @Override // java.util.Iterator
        public /* synthetic */ d.l.j next() {
            return a();
        }

        private final void b() {
            int r1 = 0;
            if (this.f38634d >= 0) goto L6;
            this.f38632b = 0;
            this.f38635e = null;
            return;
        L6:
            if (e.c(this.f38631a) <= 0) goto L10;
            int r0 = this.f + 1;
            this.f = r0;
            if (r0 < e.c(this.f38631a)) goto L10;
        L11:
            this.f38635e = new d.l.j(this.f38633c, o.e(e.b(this.f38631a)));
            this.f38634d = -1;
        L19:
            this.f38632b = 1;
            return;
        L10:
            if (this.f38634d > e.b(this.f38631a).length()) goto L11;
            d.m r2 = (d.m) ZeusTransformUtils.preCheckCast(e.d(this.f38631a).invoke(e.b(this.f38631a), Integer.valueOf(this.f38634d)), d.m.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L15;
            this.f38635e = new d.l.j(this.f38633c, o.e(e.b(this.f38631a)));
            this.f38634d = -1;
            goto L19
        L15:
            int r3 = ((Number) ZeusTransformUtils.preCheckCast(r2.c(), Number.class, "com.obric.aiagent.plugin")).intValue();
            int r4 = ((Number) ZeusTransformUtils.preCheckCast(r2.d(), Number.class, "com.obric.aiagent.plugin")).intValue();
            this.f38635e = d.l.n.b(this.f38633c, r3);
            int r5 = r3 + r4;
            this.f38633c = r5;
            if (r4 != 0) goto L18;
            r1 = 1;
        L18:
            this.f38634d = r5 + r1;
            goto L19
        }

        public d.l.j a() {
            if (this.f38632b != (-1)) goto L6;
            b();
        L6:
            if (this.f38632b == 0) goto L10;
            d.l.j r0 = this.f38635e;
            d.h.b.o.a(r0, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f38635e = null;
            this.f38632b = -1;
            return r0;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38632b != (-1)) goto L6;
            b();
        L6:
            if (this.f38632b == 1) goto L10;
            return false;
        L10:
            return true;
        }
    }

    public e(CharSequence r3, int r4, int r5, d.h.a.m<? super CharSequence, ? super Integer, d.m<Integer, Integer>> r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        d.h.a.m<CharSequence, Integer, d.m<Integer, Integer>> r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "input");
        d.h.b.o.e(r8, "getNextMatch");
        this.f38627a = r7;
        this.f38628b = r4;
        this.f38629c = r5;
        this.f38630d = r8;
    }

    public static final /* synthetic */ int a(e r0) {
        return r0.f38628b;
    }

    public static final /* synthetic */ CharSequence b(e r0) {
        return r0.f38627a;
    }

    public static final /* synthetic */ int c(e r0) {
        return r0.f38629c;
    }

    public static final /* synthetic */ d.h.a.m d(e r0) {
        return r0.f38630d;
    }

    @Override // d.n.j
    public Iterator<d.l.j> a() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new a(this), Iterator.class, "com.obric.aiagent.plugin");
    }
}
