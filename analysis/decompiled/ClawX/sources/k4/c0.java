package k4;

import com.stepos.stepclaw.SecurePrefs;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: k, reason: collision with root package name */
    public static final h0 f3591k = v.b("http://localhost");

    /* renamed from: a, reason: collision with root package name */
    public String f3592a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3593b;

    /* renamed from: c, reason: collision with root package name */
    public int f3594c;
    public e0 d;

    /* renamed from: e, reason: collision with root package name */
    public String f3595e;

    /* renamed from: f, reason: collision with root package name */
    public String f3596f;

    /* renamed from: g, reason: collision with root package name */
    public String f3597g;

    /* renamed from: h, reason: collision with root package name */
    public List f3598h;

    /* renamed from: i, reason: collision with root package name */
    public p f3599i;

    /* renamed from: j, reason: collision with root package name */
    public androidx.emoji2.text.m f3600j;

    public c0() {
        a0.f3587b.getClass();
        this.f3592a = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        this.f3593b = false;
        this.f3594c = 0;
        this.d = null;
        this.f3595e = null;
        this.f3596f = null;
        Set set = b.f3588a;
        Charset charset = x5.a.f6276a;
        kotlin.jvm.internal.p.e(charset, "charset");
        StringBuilder sb = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        kotlin.jvm.internal.p.d(charsetEncoderNewEncoder, "newEncoder(...)");
        int length = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID.length();
        j6.a aVar = new j6.a();
        x.e.x(charsetEncoderNewEncoder, aVar, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, 0, length);
        b.f(aVar, new c5.a(8, sb));
        this.f3597g = sb.toString();
        this.f3598h = new ArrayList(c5.o.n0(c5.s.f1092a, 10));
        p pVar = new p(1);
        this.f3599i = pVar;
        this.f3600j = new androidx.emoji2.text.m(pVar);
    }

    public final void a() {
        if (this.f3592a.length() <= 0 && !kotlin.jvm.internal.p.a(c().f3606a, "file")) {
            h0 h0Var = f3591k;
            this.f3592a = h0Var.f3613a;
            if (this.d == null) {
                this.d = h0Var.f3617f;
            }
            if (this.f3594c == 0) {
                d(h0Var.f3614b);
            }
        }
    }

    public final h0 b() {
        a();
        e0 e0Var = this.d;
        String str = this.f3592a;
        int i8 = this.f3594c;
        List list = this.f3598h;
        ArrayList arrayList = new ArrayList(c5.o.n0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(b.c((String) it.next()));
        }
        a0 a0VarO = z.o((p) this.f3600j.f621a);
        String strD = b.d(this.f3597g, 0, 0, 15);
        String str2 = this.f3595e;
        String strC = str2 != null ? b.c(str2) : null;
        String str3 = this.f3596f;
        String strC2 = str3 != null ? b.c(str3) : null;
        a();
        StringBuilder sb = new StringBuilder(256);
        z.a(this, sb);
        String string = sb.toString();
        kotlin.jvm.internal.p.d(string, "toString(...)");
        return new h0(e0Var, str, i8, arrayList, a0VarO, strD, strC, strC2, string);
    }

    public final e0 c() {
        e0 e0Var = this.d;
        if (e0Var != null) {
            return e0Var;
        }
        e0 e0Var2 = e0.f3605c;
        return e0.f3605c;
    }

    public final void d(int i8) {
        if (i8 < 0 || i8 >= 65536) {
            throw new IllegalArgumentException(a8.b.j(i8, "Port must be between 0 and 65535, or 0 if not set. Provided: ").toString());
        }
        this.f3594c = i8;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(256);
        z.a(this, sb);
        String string = sb.toString();
        kotlin.jvm.internal.p.d(string, "toString(...)");
        return string;
    }
}
