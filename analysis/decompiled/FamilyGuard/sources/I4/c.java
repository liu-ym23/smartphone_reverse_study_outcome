package I4;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final L4.h f2988d = L4.h.h(":");

    /* renamed from: e, reason: collision with root package name */
    public static final L4.h f2989e = L4.h.h(":status");

    /* renamed from: f, reason: collision with root package name */
    public static final L4.h f2990f = L4.h.h(":method");

    /* renamed from: g, reason: collision with root package name */
    public static final L4.h f2991g = L4.h.h(":path");

    /* renamed from: h, reason: collision with root package name */
    public static final L4.h f2992h = L4.h.h(":scheme");

    /* renamed from: i, reason: collision with root package name */
    public static final L4.h f2993i = L4.h.h(":authority");

    /* renamed from: a, reason: collision with root package name */
    public final L4.h f2994a;

    /* renamed from: b, reason: collision with root package name */
    public final L4.h f2995b;

    /* renamed from: c, reason: collision with root package name */
    final int f2996c;

    public c(String str, String str2) {
        this(L4.h.h(str), L4.h.h(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f2994a.equals(cVar.f2994a) && this.f2995b.equals(cVar.f2995b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f2994a.hashCode()) * 31) + this.f2995b.hashCode();
    }

    public String toString() {
        return D4.e.q("%s: %s", this.f2994a.C(), this.f2995b.C());
    }

    public c(L4.h hVar, String str) {
        this(hVar, L4.h.h(str));
    }

    public c(L4.h hVar, L4.h hVar2) {
        this.f2994a = hVar;
        this.f2995b = hVar2;
        this.f2996c = hVar.w() + 32 + hVar2.w();
    }
}
