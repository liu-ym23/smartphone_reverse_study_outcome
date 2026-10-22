package kotlin.ranges;

/* loaded from: classes.dex */
public final class k extends i {

    /* renamed from: e, reason: collision with root package name */
    public static final a f17979e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final k f17980f = new k(1, 0);

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    public k(long j5, long j6) {
        super(j5, j6, 1L);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (isEmpty() && ((k) obj).isEmpty()) {
            return true;
        }
        k kVar = (k) obj;
        return a() == kVar.a() && c() == kVar.c();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (a() ^ (a() >>> 32))) + (c() ^ (c() >>> 32)));
    }

    public boolean isEmpty() {
        return a() > c();
    }

    public String toString() {
        return a() + ".." + c();
    }
}
