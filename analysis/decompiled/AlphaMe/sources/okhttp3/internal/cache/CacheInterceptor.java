package okhttp3.internal.cache;

import f1.AbstractC0557a;
import h3.C0599h;
import h3.G;
import h3.H;
import h3.L;
import h3.a0;
import h3.b0;
import h3.f0;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import k3.C0683E;
import k3.C0694i;
import k3.InterfaceC0680B;
import k3.InterfaceC0696k;
import k3.u;
import k3.z;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor;", "Lh3/L;", "Lokhttp3/internal/cache/CacheRequest;", "cacheRequest", "Lh3/b0;", "response", "cacheWritingResponse", "(Lokhttp3/internal/cache/CacheRequest;Lh3/b0;)Lh3/b0;", "Lh3/K;", "chain", "intercept", "(Lh3/K;)Lh3/b0;", "Lh3/h;", "cache", "Lh3/h;", "getCache$okhttp", "()Lh3/h;", "<init>", "(Lh3/h;)V", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class CacheInterceptor implements L {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final C0599h cache;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "Lh3/b0;", "response", "stripBody", "(Lh3/b0;)Lh3/b0;", "Lh3/H;", "cachedHeaders", "networkHeaders", "combine", "(Lh3/H;Lh3/H;)Lh3/H;", "", "fieldName", "", "isEndToEnd", "(Ljava/lang/String;)Z", "isContentSpecificHeader", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final H combine(H cachedHeaders, H networkHeaders) {
            G g4 = new G();
            int size = cachedHeaders.size();
            int i4 = 0;
            int i5 = 0;
            while (i5 < size) {
                int i6 = i5 + 1;
                String strC = cachedHeaders.c(i5);
                String strF = cachedHeaders.f(i5);
                if ((!StringsKt__StringsJVMKt.equals("Warning", strC, true) || !StringsKt.y(strF, "1")) && (isContentSpecificHeader(strC) || !isEndToEnd(strC) || networkHeaders.a(strC) == null)) {
                    g4.c(strC, strF);
                }
                i5 = i6;
            }
            int size2 = networkHeaders.size();
            while (i4 < size2) {
                int i7 = i4 + 1;
                String strC2 = networkHeaders.c(i4);
                if (!isContentSpecificHeader(strC2) && isEndToEnd(strC2)) {
                    g4.c(strC2, networkHeaders.f(i4));
                }
                i4 = i7;
            }
            return g4.d();
        }

        private final boolean isContentSpecificHeader(String fieldName) {
            return StringsKt__StringsJVMKt.equals("Content-Length", fieldName, true) || StringsKt__StringsJVMKt.equals("Content-Encoding", fieldName, true) || StringsKt__StringsJVMKt.equals("Content-Type", fieldName, true);
        }

        private final boolean isEndToEnd(String fieldName) {
            return (StringsKt__StringsJVMKt.equals("Connection", fieldName, true) || StringsKt__StringsJVMKt.equals("Keep-Alive", fieldName, true) || StringsKt__StringsJVMKt.equals("Proxy-Authenticate", fieldName, true) || StringsKt__StringsJVMKt.equals("Proxy-Authorization", fieldName, true) || StringsKt__StringsJVMKt.equals("TE", fieldName, true) || StringsKt__StringsJVMKt.equals("Trailers", fieldName, true) || StringsKt__StringsJVMKt.equals("Transfer-Encoding", fieldName, true) || StringsKt__StringsJVMKt.equals("Upgrade", fieldName, true)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final b0 stripBody(b0 response) {
            if ((response == null ? null : response.f12870g) == null) {
                return response;
            }
            a0 a0VarE = response.e();
            a0VarE.f12856g = null;
            return a0VarE.a();
        }
    }

    public CacheInterceptor(@Nullable C0599h c0599h) {
        this.cache = c0599h;
    }

    private final b0 cacheWritingResponse(final CacheRequest cacheRequest, b0 response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        z zVarBody = cacheRequest.body();
        f0 f0Var = response.f12870g;
        Intrinsics.checkNotNull(f0Var);
        final InterfaceC0696k source = f0Var.getSource();
        final u uVarG = AbstractC0557a.g(zVarBody);
        InterfaceC0680B interfaceC0680B = new InterfaceC0680B() { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1
            private boolean cacheRequestClosed;

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }

            @Override // k3.InterfaceC0680B
            public long read(@NotNull C0694i sink, long byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                try {
                    long j4 = source.read(sink, byteCount);
                    if (j4 == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            uVarG.close();
                        }
                        return -1L;
                    }
                    sink.e(sink.f13357b - j4, uVarG.f(), j4);
                    uVarG.x();
                    return j4;
                } catch (IOException e4) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e4;
                }
            }

            @Override // k3.InterfaceC0680B
            @NotNull
            /* renamed from: timeout */
            public C0683E getTimeout() {
                return source.getTimeout();
            }
        };
        String strB = b0.b(response, "Content-Type");
        long contentLength = response.f12870g.getContentLength();
        a0 a0VarE = response.e();
        a0VarE.f12856g = new RealResponseBody(strB, contentLength, AbstractC0557a.h(interfaceC0680B));
        return a0VarE.a();
    }

    @Nullable
    /* renamed from: getCache$okhttp, reason: from getter */
    public final C0599h getCache() {
        return this.cache;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0247  */
    @Override // h3.L
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h3.b0 intercept(@org.jetbrains.annotations.NotNull h3.K r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 637
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheInterceptor.intercept(h3.K):h3.b0");
    }
}
