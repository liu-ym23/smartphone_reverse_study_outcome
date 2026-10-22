package ub;

import La.C0953c;
import com.autonavi.aps.amapapi.config.Const;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Pair;
import tb.x;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0007*\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\b*\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lokhttp3/b;", "", "", "socketEnabledCipherSuites", "c", "(Lokhttp3/b;[Ljava/lang/String;)[Ljava/lang/String;", "Ltb/x;", "Lkotlin/Pair;", "Ljava/nio/charset/Charset;", Const.INTENT_KEY_PKGNAME, "(Ltb/x;)Lkotlin/Pair;", Const.INTENT_KEY_APIKEY, "(Ltb/x;)Ljava/nio/charset/Charset;", "okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: ub.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5642b {
    public static final Charset a(x xVar) {
        Charset charsetD;
        return (xVar == null || (charsetD = x.d(xVar, null, 1, null)) == null) ? C0953c.UTF_8 : charsetD;
    }

    public static final Pair<Charset, x> b(x xVar) {
        Charset charset = C0953c.UTF_8;
        if (xVar != null) {
            Charset charsetD = x.d(xVar, null, 1, null);
            if (charsetD == null) {
                xVar = x.INSTANCE.b(xVar + "; charset=utf-8");
            } else {
                charset = charsetD;
            }
        }
        return Y8.j.a(charset, xVar);
    }

    public static final String[] c(okhttp3.b bVar, String[] socketEnabledCipherSuites) {
        kotlin.jvm.internal.p.i(bVar, "<this>");
        kotlin.jvm.internal.p.i(socketEnabledCipherSuites, "socketEnabledCipherSuites");
        return bVar.getCipherSuitesAsString() != null ? n.u(bVar.getCipherSuitesAsString(), socketEnabledCipherSuites, okhttp3.a.INSTANCE.c()) : socketEnabledCipherSuites;
    }
}
