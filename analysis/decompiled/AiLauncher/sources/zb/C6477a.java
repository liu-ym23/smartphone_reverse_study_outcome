package zb;

import La.D;
import Mb.n;
import Mb.u;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.AbstractC5529B;
import tb.C5528A;
import tb.C5530C;
import tb.C5545l;
import tb.w;
import tb.x;
import ub.q;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lzb/a;", "Ltb/w;", "<init>", "()V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", "", "Ltb/l;", "cookies", "", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/lang/String;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: zb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6477a implements w {
    public final String a(List<C5545l> cookies) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (Object obj : cookies) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            C5545l c5545l = (C5545l) obj;
            if (i10 > 0) {
                sb2.append("; ");
            }
            sb2.append(c5545l.getName());
            sb2.append('=');
            sb2.append(c5545l.getValue());
            i10 = i11;
        }
        return sb2.toString();
    }

    @Override // tb.w
    public C5530C intercept(w.a chain) throws IOException {
        p.i(chain, "chain");
        C5528A request = chain.getRequest();
        C5528A.a aVarI = request.i();
        AbstractC5529B body = request.getBody();
        if (body != null) {
            x media = body.getMedia();
            if (media != null) {
                aVarI.l("Content-Type", media.getMediaType());
            }
            long jA = body.a();
            if (jA != -1) {
                aVarI.l("Content-Length", String.valueOf(jA));
                aVarI.q(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30846e);
            } else {
                aVarI.l(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30846e, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30859r);
                aVarI.q("Content-Length");
            }
        }
        boolean z10 = false;
        if (request.e(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30852k) == null) {
            aVarI.l(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30852k, q.v(request.getUrl(), false, 1, null));
        }
        if (request.e(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j) == null) {
            aVarI.l(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30858q);
        }
        if (request.e("Accept-Encoding") == null && request.e("Range") == null) {
            aVarI.l("Accept-Encoding", "gzip");
            z10 = true;
        }
        List<C5545l> listA = chain.getCookieJar().a(request.getUrl());
        if (!listA.isEmpty()) {
            aVarI.l("Cookie", a(listA));
        }
        if (request.e(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30853l) == null) {
            aVarI.l(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30853l, "okhttp/5.4.0");
        }
        C5528A c5528aB = aVarI.b();
        C5530C c5530cI = chain.i(c5528aB);
        C6481e.g(chain.getCookieJar(), c5528aB.getUrl(), c5530cI.getHeaders());
        C5530C.a aVarQ = c5530cI.e0().q(c5528aB);
        if (z10 && D.L("gzip", C5530C.J(c5530cI, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h, null, 2, null), true) && C6481e.c(c5530cI)) {
            n nVar = new n(c5530cI.getBody().getSource());
            aVarQ.j(c5530cI.getHeaders().i().h(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h).h("Content-Length").f());
            aVarQ.b(new h(C5530C.J(c5530cI, "Content-Type", null, 2, null), -1L, u.c(nVar)));
        }
        return aVarQ.c();
    }
}
