package L4;

import java.io.Serializable;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class h implements Serializable, Comparable<h> {

    /* renamed from: a, reason: collision with root package name */
    private transient int f3944a;

    /* renamed from: b, reason: collision with root package name */
    private transient String f3945b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f3946c;

    /* renamed from: e, reason: collision with root package name */
    public static final a f3943e = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final h f3942d = M4.a.u();

    public static final class a {
        private a() {
        }

        public final h a(String str) {
            j4.k.h(str, "$receiver");
            return M4.a.d(str);
        }

        public final h b(String str) {
            j4.k.h(str, "$receiver");
            return M4.a.e(str);
        }

        public final h c(byte... bArr) {
            j4.k.h(bArr, "data");
            return M4.a.k(bArr);
        }

        public /* synthetic */ a(j4.g gVar) {
            this();
        }
    }

    public h(byte[] bArr) {
        j4.k.h(bArr, "data");
        this.f3946c = bArr;
    }

    public static final h e(String str) {
        return f3943e.a(str);
    }

    private final h g(String str) {
        byte[] bArrDigest = MessageDigest.getInstance(str).digest(this.f3946c);
        j4.k.c(bArrDigest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new h(bArrDigest);
    }

    public static final h h(String str) {
        return f3943e.b(str);
    }

    public static final h p(byte... bArr) {
        return f3943e.c(bArr);
    }

    public String C() {
        return M4.a.s(this);
    }

    public void E(e eVar) {
        j4.k.h(eVar, "buffer");
        byte[] bArr = this.f3946c;
        eVar.write(bArr, 0, bArr.length);
    }

    public String b() {
        return M4.a.b(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        j4.k.h(hVar, "other");
        return M4.a.c(this, hVar);
    }

    public boolean equals(Object obj) {
        return M4.a.f(this, obj);
    }

    public int hashCode() {
        return M4.a.i(this);
    }

    public final byte i(int i5) {
        return o(i5);
    }

    public final byte[] j() {
        return this.f3946c;
    }

    public final int k() {
        return this.f3944a;
    }

    public int l() {
        return M4.a.h(this);
    }

    public final String m() {
        return this.f3945b;
    }

    public String n() {
        return M4.a.j(this);
    }

    public byte o(int i5) {
        return M4.a.g(this, i5);
    }

    public boolean q(int i5, h hVar, int i6, int i7) {
        j4.k.h(hVar, "other");
        return M4.a.l(this, i5, hVar, i6, i7);
    }

    public boolean r(int i5, byte[] bArr, int i6, int i7) {
        j4.k.h(bArr, "other");
        return M4.a.m(this, i5, bArr, i6, i7);
    }

    public final void s(int i5) {
        this.f3944a = i5;
    }

    public final void t(String str) {
        this.f3945b = str;
    }

    public String toString() {
        return M4.a.r(this);
    }

    public h u() {
        return g("SHA-1");
    }

    public h v() {
        return g("SHA-256");
    }

    public final int w() {
        return l();
    }

    public final boolean x(h hVar) {
        j4.k.h(hVar, "prefix");
        return M4.a.n(this, hVar);
    }

    public h y() {
        return M4.a.p(this);
    }

    public byte[] z() {
        return M4.a.q(this);
    }
}
