package io.ktor.client.plugins;

import Ua.U;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.utils.io.KtorDsl;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.random.Random;

@KtorDsl
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u0003J'\u0010\u000e\u001a\u00020\b2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\u0004\b\u001a\u0010\u0018J!\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b \u0010\u001fJ1\u0010#\u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\u00162\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b#\u0010$J+\u0010&\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u0016¢\u0006\u0004\b&\u0010'J?\u0010,\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u0016¢\u0006\u0004\b,\u0010-J1\u0010/\u001a\u00020\b2\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0.\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\u0004\b/\u0010\u000fR:\u00100\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00128\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R:\u00106\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00160\u00128\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b6\u00101\u001a\u0004\b7\u00103\"\u0004\b8\u00105R4\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\n8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b#\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u000fR>\u0010/\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0.\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u00109\u001a\u0004\b=\u0010;\"\u0004\b>\u0010\u000fRH\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\n2\u0018\u0010?\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u00109\u001a\u0004\b@\u0010;R\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010\u001fR+\u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\bE\u00103R+\u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\bF\u00103¨\u0006G"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetryConfig;", "", "<init>", "()V", "", "randomizationMs", "randomMs", "(J)J", "LY8/t;", "noRetry", "Lkotlin/Function2;", "Lio/ktor/client/plugins/HttpRetryModifyRequestContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "modifyRequest", "(Lp9/p;)V", "", "maxRetries", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRetryShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "", "retryIf", "(ILp9/q;)V", "", "retryOnExceptionIf", "retryOnTimeout", "retryOnException", "(IZ)V", "retryOnServerErrors", "(I)V", "retryOnExceptionOrServerErrors", "respectRetryAfterHeader", "Lio/ktor/client/plugins/HttpRetryDelayContext;", "delayMillis", "(ZLp9/p;)V", "millis", "constantDelay", "(JJZ)V", "", "base", "baseDelayMs", "maxDelayMs", "exponentialDelay", "(DJJJZ)V", "Le9/c;", "delay", "shouldRetry", "Lp9/q;", "getShouldRetry$ktor_client_core", "()Lp9/q;", "setShouldRetry$ktor_client_core", "(Lp9/q;)V", "shouldRetryOnException", "getShouldRetryOnException$ktor_client_core", "setShouldRetryOnException$ktor_client_core", "Lp9/p;", "getDelayMillis$ktor_client_core", "()Lp9/p;", "setDelayMillis$ktor_client_core", "getDelay$ktor_client_core", "setDelay$ktor_client_core", UxipConstants.f30680s, "getModifyRequest", "I", "getMaxRetries", "()I", "setMaxRetries", "getRetryIf", "getRetryOnExceptionIf", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpRequestRetryConfig {
    public p9.p<? super HttpRetryDelayContext, ? super Integer, Long> delayMillis;
    private int maxRetries;
    public p9.q<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> shouldRetry;
    public p9.q<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> shouldRetryOnException;
    private p9.p<? super Long, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> delay = new AnonymousClass1(null);
    private p9.p<? super HttpRetryModifyRequestContext, ? super HttpRequestBuilder, Y8.t> modifyRequest = new p9.p() { // from class: io.ktor.client.plugins.v
        @Override // p9.p
        public final Object invoke(Object obj, Object obj2) {
            return HttpRequestRetryConfig.modifyRequest$lambda$0((HttpRetryModifyRequestContext) obj, (HttpRequestBuilder) obj2);
        }
    };

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "LY8/t;", "<anonymous>", "(J)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.plugins.HttpRequestRetryConfig$delay$1", f = "HttpRequestRetry.kt", l = {42}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.HttpRequestRetryConfig$delay$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Long, InterfaceC4014c<? super Y8.t>, Object> {
        /* synthetic */ long J$0;
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
            anonymousClass1.J$0 = ((Number) obj).longValue();
            return anonymousClass1;
        }

        public final Object invoke(long j10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(Long.valueOf(j10), interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            long j10 = this.J$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                this.J$0 = j10;
                this.label = 1;
                if (U.a(j10, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(Long l10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return invoke(l10.longValue(), interfaceC4014c);
        }
    }

    public HttpRequestRetryConfig() {
        retryOnExceptionOrServerErrors(3);
        exponentialDelay$default(this, 0.0d, 0L, 0L, 0L, false, 31, null);
    }

    public static /* synthetic */ void constantDelay$default(HttpRequestRetryConfig httpRequestRetryConfig, long j10, long j11, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 1000;
        }
        if ((i10 & 2) != 0) {
            j11 = 1000;
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        httpRequestRetryConfig.constantDelay(j10, j11, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long constantDelay$lambda$7(long j10, HttpRequestRetryConfig httpRequestRetryConfig, long j11, HttpRetryDelayContext delayMillis, int i10) {
        kotlin.jvm.internal.p.i(delayMillis, "$this$delayMillis");
        return j10 + httpRequestRetryConfig.randomMs(j11);
    }

    public static /* synthetic */ void delayMillis$default(HttpRequestRetryConfig httpRequestRetryConfig, boolean z10, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        httpRequestRetryConfig.delayMillis(z10, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long delayMillis$lambda$6(boolean z10, p9.p pVar, HttpRetryDelayContext httpRetryDelayContext, int i10) {
        Headers headers;
        String str;
        Long lY;
        kotlin.jvm.internal.p.i(httpRetryDelayContext, "<this>");
        if (!z10) {
            return ((Number) pVar.invoke(httpRetryDelayContext, Integer.valueOf(i10))).longValue();
        }
        HttpResponse response = httpRetryDelayContext.getResponse();
        Long lValueOf = (response == null || (headers = response.getHeaders()) == null || (str = headers.get(HttpHeaders.INSTANCE.getRetryAfter())) == null || (lY = La.C.y(str)) == null) ? null : Long.valueOf(lY.longValue() * 1000);
        return Math.max(((Number) pVar.invoke(httpRetryDelayContext, Integer.valueOf(i10))).longValue(), lValueOf != null ? lValueOf.longValue() : 0L);
    }

    public static /* synthetic */ void exponentialDelay$default(HttpRequestRetryConfig httpRequestRetryConfig, double d10, long j10, long j11, long j12, boolean z10, int i10, Object obj) {
        httpRequestRetryConfig.exponentialDelay((i10 & 1) != 0 ? 2.0d : d10, (i10 & 2) != 0 ? 1000L : j10, (i10 & 4) != 0 ? 60000L : j11, (i10 & 8) == 0 ? j12 : 1000L, (i10 & 16) != 0 ? true : z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long exponentialDelay$lambda$8(double d10, long j10, long j11, HttpRequestRetryConfig httpRequestRetryConfig, long j12, HttpRetryDelayContext delayMillis, int i10) {
        kotlin.jvm.internal.p.i(delayMillis, "$this$delayMillis");
        return Math.min((long) (Math.pow(d10, i10 - 1) * j10), j11) + httpRequestRetryConfig.randomMs(j12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t modifyRequest$lambda$0(HttpRetryModifyRequestContext httpRetryModifyRequestContext, HttpRequestBuilder it) {
        kotlin.jvm.internal.p.i(httpRetryModifyRequestContext, "<this>");
        kotlin.jvm.internal.p.i(it, "it");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean noRetry$lambda$1(HttpRetryShouldRetryContext httpRetryShouldRetryContext, HttpRequest httpRequest, HttpResponse httpResponse) {
        kotlin.jvm.internal.p.i(httpRetryShouldRetryContext, "<this>");
        kotlin.jvm.internal.p.i(httpRequest, "<unused var>");
        kotlin.jvm.internal.p.i(httpResponse, "<unused var>");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean noRetry$lambda$2(HttpRetryShouldRetryContext httpRetryShouldRetryContext, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        kotlin.jvm.internal.p.i(httpRetryShouldRetryContext, "<this>");
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<unused var>");
        kotlin.jvm.internal.p.i(th, "<unused var>");
        return false;
    }

    private final long randomMs(long randomizationMs) {
        if (randomizationMs == 0) {
            return 0L;
        }
        return Random.INSTANCE.j(randomizationMs);
    }

    public static /* synthetic */ void retryIf$default(HttpRequestRetryConfig httpRequestRetryConfig, int i10, p9.q qVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -1;
        }
        httpRequestRetryConfig.retryIf(i10, qVar);
    }

    public static /* synthetic */ void retryOnException$default(HttpRequestRetryConfig httpRequestRetryConfig, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -1;
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        httpRequestRetryConfig.retryOnException(i10, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retryOnException$lambda$3(boolean z10, HttpRetryShouldRetryContext retryOnExceptionIf, HttpRequestBuilder httpRequestBuilder, Throwable cause) {
        kotlin.jvm.internal.p.i(retryOnExceptionIf, "$this$retryOnExceptionIf");
        kotlin.jvm.internal.p.i(httpRequestBuilder, "<unused var>");
        kotlin.jvm.internal.p.i(cause, "cause");
        return HttpRequestRetryKt.isTimeoutException(cause) ? z10 : !(cause instanceof CancellationException);
    }

    public static /* synthetic */ void retryOnExceptionIf$default(HttpRequestRetryConfig httpRequestRetryConfig, int i10, p9.q qVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -1;
        }
        httpRequestRetryConfig.retryOnExceptionIf(i10, qVar);
    }

    public static /* synthetic */ void retryOnExceptionOrServerErrors$default(HttpRequestRetryConfig httpRequestRetryConfig, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -1;
        }
        httpRequestRetryConfig.retryOnExceptionOrServerErrors(i10);
    }

    public static /* synthetic */ void retryOnServerErrors$default(HttpRequestRetryConfig httpRequestRetryConfig, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -1;
        }
        httpRequestRetryConfig.retryOnServerErrors(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retryOnServerErrors$lambda$5(HttpRetryShouldRetryContext retryIf, HttpRequest httpRequest, HttpResponse response) {
        kotlin.jvm.internal.p.i(retryIf, "$this$retryIf");
        kotlin.jvm.internal.p.i(httpRequest, "<unused var>");
        kotlin.jvm.internal.p.i(response, "response");
        int value = response.getStatus().getValue();
        return 500 <= value && value < 600;
    }

    public final void constantDelay(final long millis, final long randomizationMs, boolean respectRetryAfterHeader) {
        if (millis <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (randomizationMs < 0) {
            throw new IllegalStateException("Check failed.");
        }
        delayMillis(respectRetryAfterHeader, new p9.p() { // from class: io.ktor.client.plugins.w
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(HttpRequestRetryConfig.constantDelay$lambda$7(millis, this, randomizationMs, (HttpRetryDelayContext) obj, ((Integer) obj2).intValue()));
            }
        });
    }

    public final void delay(p9.p<? super Long, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(block, "block");
        this.delay = block;
    }

    public final void delayMillis(final boolean respectRetryAfterHeader, final p9.p<? super HttpRetryDelayContext, ? super Integer, Long> block) {
        kotlin.jvm.internal.p.i(block, "block");
        setDelayMillis$ktor_client_core(new p9.p() { // from class: io.ktor.client.plugins.x
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(HttpRequestRetryConfig.delayMillis$lambda$6(respectRetryAfterHeader, block, (HttpRetryDelayContext) obj, ((Integer) obj2).intValue()));
            }
        });
    }

    public final void exponentialDelay(final double base, final long baseDelayMs, final long maxDelayMs, final long randomizationMs, boolean respectRetryAfterHeader) {
        if (base <= 0.0d) {
            throw new IllegalStateException("Check failed.");
        }
        if (baseDelayMs <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (maxDelayMs <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (randomizationMs < 0) {
            throw new IllegalStateException("Check failed.");
        }
        delayMillis(respectRetryAfterHeader, new p9.p() { // from class: io.ktor.client.plugins.y
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(HttpRequestRetryConfig.exponentialDelay$lambda$8(base, baseDelayMs, maxDelayMs, this, randomizationMs, (HttpRetryDelayContext) obj, ((Integer) obj2).intValue()));
            }
        });
    }

    public final p9.p<Long, InterfaceC4014c<? super Y8.t>, Object> getDelay$ktor_client_core() {
        return this.delay;
    }

    public final p9.p<HttpRetryDelayContext, Integer, Long> getDelayMillis$ktor_client_core() {
        p9.p pVar = this.delayMillis;
        if (pVar != null) {
            return pVar;
        }
        kotlin.jvm.internal.p.A("delayMillis");
        return null;
    }

    public final int getMaxRetries() {
        return this.maxRetries;
    }

    public final p9.p<HttpRetryModifyRequestContext, HttpRequestBuilder, Y8.t> getModifyRequest() {
        return this.modifyRequest;
    }

    public final p9.q<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean> getRetryIf() {
        if (this.shouldRetry != null) {
            return getShouldRetry$ktor_client_core();
        }
        return null;
    }

    public final p9.q<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> getRetryOnExceptionIf() {
        if (this.shouldRetryOnException != null) {
            return getShouldRetryOnException$ktor_client_core();
        }
        return null;
    }

    public final p9.q<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean> getShouldRetry$ktor_client_core() {
        p9.q qVar = this.shouldRetry;
        if (qVar != null) {
            return qVar;
        }
        kotlin.jvm.internal.p.A("shouldRetry");
        return null;
    }

    public final p9.q<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> getShouldRetryOnException$ktor_client_core() {
        p9.q qVar = this.shouldRetryOnException;
        if (qVar != null) {
            return qVar;
        }
        kotlin.jvm.internal.p.A("shouldRetryOnException");
        return null;
    }

    public final void modifyRequest(p9.p<? super HttpRetryModifyRequestContext, ? super HttpRequestBuilder, Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        this.modifyRequest = block;
    }

    public final void noRetry() {
        this.maxRetries = 0;
        setShouldRetry$ktor_client_core(new p9.q() { // from class: io.ktor.client.plugins.t
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(HttpRequestRetryConfig.noRetry$lambda$1((HttpRetryShouldRetryContext) obj, (HttpRequest) obj2, (HttpResponse) obj3));
            }
        });
        setShouldRetryOnException$ktor_client_core(new p9.q() { // from class: io.ktor.client.plugins.u
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(HttpRequestRetryConfig.noRetry$lambda$2((HttpRetryShouldRetryContext) obj, (HttpRequestBuilder) obj2, (Throwable) obj3));
            }
        });
    }

    public final void retryIf(int maxRetries, p9.q<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> block) {
        kotlin.jvm.internal.p.i(block, "block");
        if (maxRetries != -1) {
            this.maxRetries = maxRetries;
        }
        setShouldRetry$ktor_client_core(block);
    }

    public final void retryOnException(int maxRetries, final boolean retryOnTimeout) {
        retryOnExceptionIf(maxRetries, new p9.q() { // from class: io.ktor.client.plugins.s
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(HttpRequestRetryConfig.retryOnException$lambda$3(retryOnTimeout, (HttpRetryShouldRetryContext) obj, (HttpRequestBuilder) obj2, (Throwable) obj3));
            }
        });
    }

    public final void retryOnExceptionIf(int maxRetries, p9.q<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> block) {
        kotlin.jvm.internal.p.i(block, "block");
        if (maxRetries != -1) {
            this.maxRetries = maxRetries;
        }
        setShouldRetryOnException$ktor_client_core(block);
    }

    public final void retryOnExceptionOrServerErrors(int maxRetries) {
        retryOnServerErrors(maxRetries);
        retryOnException$default(this, maxRetries, false, 2, null);
    }

    public final void retryOnServerErrors(int maxRetries) {
        retryIf(maxRetries, new p9.q() { // from class: io.ktor.client.plugins.z
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(HttpRequestRetryConfig.retryOnServerErrors$lambda$5((HttpRetryShouldRetryContext) obj, (HttpRequest) obj2, (HttpResponse) obj3));
            }
        });
    }

    public final void setDelay$ktor_client_core(p9.p<? super Long, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
        kotlin.jvm.internal.p.i(pVar, "<set-?>");
        this.delay = pVar;
    }

    public final void setDelayMillis$ktor_client_core(p9.p<? super HttpRetryDelayContext, ? super Integer, Long> pVar) {
        kotlin.jvm.internal.p.i(pVar, "<set-?>");
        this.delayMillis = pVar;
    }

    public final void setMaxRetries(int i10) {
        this.maxRetries = i10;
    }

    public final void setShouldRetry$ktor_client_core(p9.q<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> qVar) {
        kotlin.jvm.internal.p.i(qVar, "<set-?>");
        this.shouldRetry = qVar;
    }

    public final void setShouldRetryOnException$ktor_client_core(p9.q<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> qVar) {
        kotlin.jvm.internal.p.i(qVar, "<set-?>");
        this.shouldRetryOnException = qVar;
    }
}
