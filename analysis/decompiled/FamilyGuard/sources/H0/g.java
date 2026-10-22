package H0;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
public class g implements InterfaceC1340f {

    /* renamed from: b, reason: collision with root package name */
    private final h f1975b;

    /* renamed from: c, reason: collision with root package name */
    private final URL f1976c;

    /* renamed from: d, reason: collision with root package name */
    private final String f1977d;

    /* renamed from: e, reason: collision with root package name */
    private String f1978e;

    /* renamed from: f, reason: collision with root package name */
    private URL f1979f;

    /* renamed from: g, reason: collision with root package name */
    private volatile byte[] f1980g;

    /* renamed from: h, reason: collision with root package name */
    private int f1981h;

    public g(URL url) {
        this(url, h.f1983b);
    }

    private byte[] d() {
        if (this.f1980g == null) {
            this.f1980g = c().getBytes(InterfaceC1340f.f24045a);
        }
        return this.f1980g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f1978e)) {
            String string = this.f1977d;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) X0.j.d(this.f1976c)).toString();
            }
            this.f1978e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f1978e;
    }

    private URL g() {
        if (this.f1979f == null) {
            this.f1979f = new URL(f());
        }
        return this.f1979f;
    }

    @Override // z0.InterfaceC1340f
    public void b(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f1977d;
        return str != null ? str : ((URL) X0.j.d(this.f1976c)).toString();
    }

    public Map<String, String> e() {
        return this.f1975b.a();
    }

    @Override // z0.InterfaceC1340f
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (c().equals(gVar.c()) && this.f1975b.equals(gVar.f1975b)) {
                return true;
            }
        }
        return false;
    }

    public String h() {
        return f();
    }

    @Override // z0.InterfaceC1340f
    public int hashCode() {
        if (this.f1981h == 0) {
            int iHashCode = c().hashCode();
            this.f1981h = iHashCode;
            this.f1981h = (iHashCode * 31) + this.f1975b.hashCode();
        }
        return this.f1981h;
    }

    public URL i() {
        return g();
    }

    public String toString() {
        return c();
    }

    public g(String str) {
        this(str, h.f1983b);
    }

    public g(URL url, h hVar) {
        this.f1976c = (URL) X0.j.d(url);
        this.f1977d = null;
        this.f1975b = (h) X0.j.d(hVar);
    }

    public g(String str, h hVar) {
        this.f1976c = null;
        this.f1977d = X0.j.b(str);
        this.f1975b = (h) X0.j.d(hVar);
    }
}
