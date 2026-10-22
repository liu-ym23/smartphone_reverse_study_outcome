package ab;

import com.stepos.account.oauth.OAuthConstants;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class z implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public final w f684f;

    /* renamed from: g, reason: collision with root package name */
    public final u f685g;

    /* renamed from: h, reason: collision with root package name */
    public final String f686h;

    /* renamed from: i, reason: collision with root package name */
    public final int f687i;

    /* renamed from: j, reason: collision with root package name */
    public final l f688j;

    /* renamed from: k, reason: collision with root package name */
    public final n f689k;

    /* renamed from: l, reason: collision with root package name */
    public final b0 f690l;

    /* renamed from: m, reason: collision with root package name */
    public final z f691m;

    /* renamed from: n, reason: collision with root package name */
    public final z f692n;

    /* renamed from: o, reason: collision with root package name */
    public final z f693o;

    /* renamed from: p, reason: collision with root package name */
    public final long f694p;

    /* renamed from: q, reason: collision with root package name */
    public final long f695q;

    /* renamed from: r, reason: collision with root package name */
    public final c1.o f696r;

    public z(w wVar, u uVar, String str, int i2, l lVar, n nVar, b0 b0Var, z zVar, z zVar2, z zVar3, long j2, long j4, c1.o oVar) {
        q7.k.e(wVar, "request");
        q7.k.e(uVar, "protocol");
        q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        this.f684f = wVar;
        this.f685g = uVar;
        this.f686h = str;
        this.f687i = i2;
        this.f688j = lVar;
        this.f689k = nVar;
        this.f690l = b0Var;
        this.f691m = zVar;
        this.f692n = zVar2;
        this.f693o = zVar3;
        this.f694p = j2;
        this.f695q = j4;
        this.f696r = oVar;
    }

    public static String a(z zVar, String str) {
        zVar.getClass();
        String strA = zVar.f689k.a(str);
        if (strA == null) {
            return null;
        }
        return strA;
    }

    public final boolean b() {
        int i2 = this.f687i;
        return 200 <= i2 && i2 < 300;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        b0 b0Var = this.f690l;
        if (b0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        b0Var.close();
    }

    public final y d() {
        y yVar = new y();
        yVar.f671a = this.f684f;
        yVar.f672b = this.f685g;
        yVar.f673c = this.f687i;
        yVar.f674d = this.f686h;
        yVar.f675e = this.f688j;
        yVar.f676f = this.f689k.h();
        yVar.f677g = this.f690l;
        yVar.f678h = this.f691m;
        yVar.f679i = this.f692n;
        yVar.f680j = this.f693o;
        yVar.f681k = this.f694p;
        yVar.f682l = this.f695q;
        yVar.f683m = this.f696r;
        return yVar;
    }

    public final String toString() {
        return "Response{protocol=" + this.f685g + ", code=" + this.f687i + ", message=" + this.f686h + ", url=" + this.f684f.f661a + '}';
    }
}
