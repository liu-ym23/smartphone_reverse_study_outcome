package zb;

import com.autonavi.aps.amapapi.config.Const;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import tb.C5528A;
import tb.v;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lzb/i;", "", "<init>", "()V", "Ltb/A;", "request", "Ljava/net/Proxy$Type;", "proxyType", "", Const.INTENT_KEY_APIKEY, "(Ltb/A;Ljava/net/Proxy$Type;)Ljava/lang/String;", "Ltb/v;", "url", "c", "(Ltb/v;)Ljava/lang/String;", "", Const.INTENT_KEY_PKGNAME, "(Ltb/A;Ljava/net/Proxy$Type;)Z", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f45464a = new i();

    public final String a(C5528A request, Proxy.Type proxyType) {
        p.i(request, "request");
        p.i(proxyType, "proxyType");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(request.getMethod());
        sb2.append(' ');
        i iVar = f45464a;
        if (iVar.b(request, proxyType)) {
            sb2.append(request.getUrl());
        } else {
            sb2.append(iVar.c(request.getUrl()));
        }
        sb2.append(" HTTP/1.1");
        return sb2.toString();
    }

    public final boolean b(C5528A request, Proxy.Type proxyType) {
        return !request.g() && proxyType == Proxy.Type.HTTP;
    }

    public final String c(v url) {
        p.i(url, "url");
        String strC = url.c();
        String strE = url.e();
        if (strE == null) {
            return strC;
        }
        return strC + '?' + strE;
    }
}
