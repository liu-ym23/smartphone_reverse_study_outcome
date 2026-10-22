package ie;

import io.modelcontextprotocol.spec.HttpHeaders;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class l0 {

    /* renamed from: l, reason: collision with root package name */
    public static final char[] f6005l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f6006m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a, reason: collision with root package name */
    public String f6007a;

    /* renamed from: b, reason: collision with root package name */
    public ad.q f6008b;

    /* renamed from: c, reason: collision with root package name */
    public String f6009c;

    /* renamed from: d, reason: collision with root package name */
    public ad.p f6010d;

    /* renamed from: e, reason: collision with root package name */
    public ad.y f6011e;

    /* renamed from: f, reason: collision with root package name */
    public ne.b f6012f;

    /* renamed from: g, reason: collision with root package name */
    public ad.s f6013g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6014h;
    public p5.m i;

    /* renamed from: j, reason: collision with root package name */
    public n6.a f6015j;

    /* renamed from: k, reason: collision with root package name */
    public ad.c0 f6016k;

    public final void a(String str, String str2, boolean z10) {
        n6.a aVar = this.f6015j;
        if (z10) {
            aVar.getClass();
            str.getClass();
            ((ArrayList) aVar.f8776c).add(ad.b.b(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", 83));
            ((ArrayList) aVar.f8777f).add(ad.b.b(str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", 83));
            return;
        }
        aVar.getClass();
        str.getClass();
        ((ArrayList) aVar.f8776c).add(ad.b.b(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", 91));
        ((ArrayList) aVar.f8777f).add(ad.b.b(str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", 91));
    }

    public final void b(String str, String str2) {
        if (!HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str)) {
            this.f6012f.a(str, str2);
            return;
        }
        try {
            Pattern pattern = ad.s.f568d;
            this.f6013g = id.k.t(str2);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(w2.c.b("Malformed content type: ", str2), e10);
        }
    }

    public final void c(ad.n nVar, ad.c0 c0Var) {
        p5.m mVar = this.i;
        mVar.getClass();
        c0Var.getClass();
        if (nVar.a(HttpHeaders.CONTENT_TYPE) != null) {
            g5.f.s("Unexpected header: Content-Type");
            return;
        }
        if (nVar.a(HttpHeaders.CONTENT_LENGTH) != null) {
            g5.f.s("Unexpected header: Content-Length");
            return;
        }
        ad.t tVar = new ad.t();
        tVar.f573a = nVar;
        tVar.f574b = c0Var;
        VarHandle.storeStoreFence();
        ((ArrayList) mVar.f9743h).add(tVar);
    }

    public final void d(String str, String str2, boolean z10) {
        ad.p pVar;
        ad.q qVar = this.f6008b;
        String str3 = this.f6009c;
        if (str3 != null) {
            qVar.getClass();
            try {
                pVar = new ad.p();
                pVar.c(qVar, str3);
            } catch (IllegalArgumentException unused) {
                pVar = null;
            }
            this.f6010d = pVar;
            if (pVar == null) {
                StringBuilder sb2 = new StringBuilder("Malformed URL. Base: ");
                sb2.append(qVar);
                g5.f.j(sb2, ", Relative: ", this.f6009c);
                return;
            }
            this.f6009c = null;
        }
        ad.p pVar2 = this.f6010d;
        if (z10) {
            pVar2.getClass();
            str.getClass();
            if (pVar2.f556g == null) {
                pVar2.f556g = new ArrayList();
            }
            ArrayList arrayList = pVar2.f556g;
            arrayList.getClass();
            arrayList.add(ad.b.b(str, 0, 0, " \"'<>#&=", 211));
            ArrayList arrayList2 = pVar2.f556g;
            arrayList2.getClass();
            arrayList2.add(str2 != null ? ad.b.b(str2, 0, 0, " \"'<>#&=", 211) : null);
            return;
        }
        pVar2.getClass();
        str.getClass();
        if (pVar2.f556g == null) {
            pVar2.f556g = new ArrayList();
        }
        ArrayList arrayList3 = pVar2.f556g;
        arrayList3.getClass();
        arrayList3.add(ad.b.b(str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", 219));
        ArrayList arrayList4 = pVar2.f556g;
        arrayList4.getClass();
        arrayList4.add(str2 != null ? ad.b.b(str2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", 219) : null);
    }
}
