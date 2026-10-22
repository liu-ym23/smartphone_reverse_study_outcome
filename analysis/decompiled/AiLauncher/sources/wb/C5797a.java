package wb;

import La.D;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import okhttp3.Protocol;
import tb.C5528A;
import tb.C5530C;
import tb.InterfaceC5538e;
import tb.u;
import tb.w;
import ub.n;
import wb.C5798b;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lwb/a;", "Ltb/w;", "<init>", "()V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", Const.INTENT_KEY_APIKEY, "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: wb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5797a implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lwb/a$a;", "", "<init>", "()V", "Ltb/u;", "cachedHeaders", "networkHeaders", Const.INTENT_KEY_PKGNAME, "(Ltb/u;Ltb/u;)Ltb/u;", "", "fieldName", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Z", "c", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: wb.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final u b(u cachedHeaders, u networkHeaders) {
            u.a aVar = new u.a();
            int size = cachedHeaders.size();
            for (int i10 = 0; i10 < size; i10++) {
                String strF = cachedHeaders.f(i10);
                String strK = cachedHeaders.k(i10);
                if ((!D.L("Warning", strF, true) || !D.X(strK, "1", false, 2, null)) && (c(strF) || !d(strF) || networkHeaders.b(strF) == null)) {
                    aVar.d(strF, strK);
                }
            }
            int size2 = networkHeaders.size();
            for (int i11 = 0; i11 < size2; i11++) {
                String strF2 = networkHeaders.f(i11);
                if (!c(strF2) && d(strF2)) {
                    aVar.d(strF2, networkHeaders.k(i11));
                }
            }
            return aVar.f();
        }

        public final boolean c(String fieldName) {
            return D.L("Content-Length", fieldName, true) || D.L(e.f30849h, fieldName, true) || D.L("Content-Type", fieldName, true);
        }

        public final boolean d(String fieldName) {
            return (D.L(e.f30851j, fieldName, true) || D.L(e.f30858q, fieldName, true) || D.L("Proxy-Authenticate", fieldName, true) || D.L("Proxy-Authorization", fieldName, true) || D.L("TE", fieldName, true) || D.L("Trailers", fieldName, true) || D.L(e.f30846e, fieldName, true) || D.L("Upgrade", fieldName, true)) ? false : true;
        }

        public Companion() {
        }
    }

    @Override // tb.w
    public C5530C intercept(w.a chain) throws IOException {
        p.i(chain, "chain");
        InterfaceC5538e interfaceC5538eCall = chain.call();
        chain.j();
        C5798b c5798bB = new C5798b.C0549b(System.currentTimeMillis(), chain.getRequest(), null).b();
        C5528A c5528aB = c5798bB.getNetworkRequest();
        C5530C c5530cA = c5798bB.getCacheResponse();
        if (c5528aB == null && c5530cA == null) {
            C5530C c5530cC = new C5530C.a().q(chain.getRequest()).o(Protocol.HTTP_1_1).f(504).l("Unsatisfiable Request (only-if-cached)").r(-1L).p(System.currentTimeMillis()).c();
            chain.h().D(interfaceC5538eCall, c5530cC);
            return c5530cC;
        }
        if (c5528aB == null) {
            p.f(c5530cA);
            C5530C c5530cC2 = c5530cA.e0().d(ub.i.a(c5530cA)).c();
            chain.h().b(interfaceC5538eCall, c5530cC2);
            return c5530cC2;
        }
        if (c5530cA != null) {
            chain.h().a(interfaceC5538eCall, c5530cA);
        }
        C5530C c5530cI = chain.i(c5528aB);
        if (c5530cA != null) {
            if (c5530cI != null && c5530cI.getCode() == 304) {
                c5530cA.e0().j(INSTANCE.b(c5530cA.getHeaders(), c5530cI.getHeaders())).r(c5530cI.getSentRequestAtMillis()).p(c5530cI.getReceivedResponseAtMillis()).d(ub.i.a(c5530cA)).m(ub.i.a(c5530cI)).c();
                c5530cI.getBody().close();
                p.f(null);
                throw null;
            }
            n.f(c5530cA.getBody());
        }
        p.f(c5530cI);
        return c5530cI.e0().d(c5530cA != null ? ub.i.a(c5530cA) : null).m(ub.i.a(c5530cI)).c();
    }
}
