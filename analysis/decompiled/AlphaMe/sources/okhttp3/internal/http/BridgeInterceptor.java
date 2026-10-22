package okhttp3.internal.http;

import f1.AbstractC0557a;
import h3.C0612v;
import h3.G;
import h3.InterfaceC0613w;
import h3.J;
import h3.K;
import h3.L;
import h3.M;
import h3.U;
import h3.V;
import h3.Z;
import h3.a0;
import h3.b0;
import h3.f0;
import java.io.IOException;
import java.util.List;
import k3.q;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import y1.f;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/http/BridgeInterceptor;", "Lh3/L;", "", "Lh3/v;", "cookies", "", "cookieHeader", "(Ljava/util/List;)Ljava/lang/String;", "Lh3/K;", "chain", "Lh3/b0;", "intercept", "(Lh3/K;)Lh3/b0;", "Lh3/w;", "cookieJar", "Lh3/w;", "<init>", "(Lh3/w;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class BridgeInterceptor implements L {

    @NotNull
    private final InterfaceC0613w cookieJar;

    public BridgeInterceptor(@NotNull InterfaceC0613w cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    private final String cookieHeader(List<C0612v> cookies) {
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        for (Object obj : cookies) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            C0612v c0612v = (C0612v) obj;
            if (i4 > 0) {
                sb.append("; ");
            }
            sb.append(c0612v.f12978a);
            sb.append('=');
            sb.append(c0612v.f12979b);
            i4 = i5;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // h3.L
    @NotNull
    public b0 intercept(@NotNull K chain) throws NumberFormatException, IOException {
        f0 f0Var;
        Intrinsics.checkNotNullParameter(chain, "chain");
        V request = chain.request();
        U uC = request.c();
        Z z4 = request.f12829d;
        if (z4 != null) {
            M mContentType = z4.contentType();
            if (mContentType != null) {
                uC.c("Content-Type", mContentType.f12734a);
            }
            long jContentLength = z4.contentLength();
            if (jContentLength != -1) {
                uC.c("Content-Length", String.valueOf(jContentLength));
                uC.e("Transfer-Encoding");
            } else {
                uC.c("Transfer-Encoding", "chunked");
                uC.e("Content-Length");
            }
        }
        String strB = request.b("Host");
        boolean z5 = false;
        J url = request.f12826a;
        if (strB == null) {
            uC.c("Host", Util.toHostHeader$default(url, false, 1, null));
        }
        if (request.b("Connection") == null) {
            uC.c("Connection", "Keep-Alive");
        }
        if (request.b("Accept-Encoding") == null && request.b("Range") == null) {
            uC.c("Accept-Encoding", "gzip");
            z5 = true;
        }
        ((f) this.cookieJar).getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        List<C0612v> listEmptyList = CollectionsKt.emptyList();
        if (!listEmptyList.isEmpty()) {
            uC.c("Cookie", cookieHeader(listEmptyList));
        }
        if (request.b("User-Agent") == null) {
            uC.c("User-Agent", Util.userAgent);
        }
        b0 b0VarProceed = chain.proceed(uC.b());
        HttpHeaders.receiveHeaders(this.cookieJar, url, b0VarProceed.f12869f);
        a0 a0VarE = b0VarProceed.e();
        Intrinsics.checkNotNullParameter(request, "request");
        a0VarE.f12850a = request;
        if (z5 && StringsKt__StringsJVMKt.equals("gzip", b0.b(b0VarProceed, "Content-Encoding"), true) && HttpHeaders.promisesBody(b0VarProceed) && (f0Var = b0VarProceed.f12870g) != null) {
            q qVar = new q(f0Var.getSource());
            G gD = b0VarProceed.f12869f.d();
            gD.f("Content-Encoding");
            gD.f("Content-Length");
            a0VarE.c(gD.d());
            a0VarE.f12856g = new RealResponseBody(b0.b(b0VarProceed, "Content-Type"), -1L, AbstractC0557a.h(qVar));
        }
        return a0VarE.a();
    }
}
