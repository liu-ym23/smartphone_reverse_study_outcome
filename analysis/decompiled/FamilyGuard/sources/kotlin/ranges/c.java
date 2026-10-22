package kotlin.ranges;

/* loaded from: classes.dex */
public final class c extends kotlin.ranges.a {

    /* renamed from: e, reason: collision with root package name */
    public static final a f17955e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final c f17956f = new c(1, 0);

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    public c(char c6, char c7) {
        super(c6, c7, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (isEmpty() && ((c) obj).isEmpty()) {
            return true;
        }
        c cVar = (c) obj;
        return a() == cVar.a() && c() == cVar.c();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + c();
    }

    public boolean isEmpty() {
        return j4.k.i(a(), c()) > 0;
    }

    public String toString() {
        return a() + ".." + c();
    }
}
