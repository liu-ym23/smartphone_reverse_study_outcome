package kotlin.ranges;

/* loaded from: classes.dex */
public final class h extends f {

    /* renamed from: e, reason: collision with root package name */
    public static final a f17969e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final h f17970f = new h(1, 0);

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        public final h a() {
            return h.f17970f;
        }

        private a() {
        }
    }

    public h(int i5, int i6) {
        super(i5, i6, 1);
    }

    @Override // kotlin.ranges.f
    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        if (isEmpty() && ((h) obj).isEmpty()) {
            return true;
        }
        h hVar = (h) obj;
        return a() == hVar.a() && c() == hVar.c();
    }

    @Override // kotlin.ranges.f
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + c();
    }

    @Override // kotlin.ranges.f
    public boolean isEmpty() {
        return a() > c();
    }

    public Integer m() {
        return Integer.valueOf(c());
    }

    public Integer n() {
        return Integer.valueOf(a());
    }

    @Override // kotlin.ranges.f
    public String toString() {
        return a() + ".." + c();
    }
}
