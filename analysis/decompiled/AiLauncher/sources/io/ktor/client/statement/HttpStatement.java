package io.ktor.client.statement;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.wake.circle.F;
import com.zyql.ai.selector.config.PictureConfig;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J:\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086@¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\r\u001a\u00020\nH\u0086@¢\u0006\u0004\b\r\u0010\u000fJ\u0018\u0010\u0010\u001a\u00028\u0000\"\u0006\b\u0000\u0010\b\u0018\u0001H\u0086H¢\u0006\u0004\b\u0010\u0010\u000fJD\u0010\u0010\u001a\u00028\u0001\"\u0006\b\u0000\u0010\b\u0018\u0001\"\u0004\b\u0001\u0010\u00112$\b\u0004\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086H¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\nH\u0081@¢\u0006\u0004\b\u0012\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\nH\u0081@¢\u0006\u0004\b\u0013\u0010\u000fJ\u0014\u0010\u0015\u001a\u00020\u0014*\u00020\nH\u0081@¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR \u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lio/ktor/client/statement/HttpStatement;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/HttpClient;", "client", "<init>", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/HttpClient;)V", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Le9/c;", "block", "execute", "(Lp9/p;Le9/c;)Ljava/lang/Object;", "(Le9/c;)Ljava/lang/Object;", "body", "R", "fetchStreamingResponse", "fetchResponse", "LY8/t;", "cleanup", "(Lio/ktor/client/statement/HttpResponse;Le9/c;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "getClient$annotations", "()V", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpStatement {
    private final HttpRequestBuilder builder;
    private final HttpClient client;

    @InterfaceC4112d(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {F.GESTURE_WIDTH_DP}, m = "cleanup")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.statement.HttpStatement$cleanup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.cleanup(null, this);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {55, 58, 60, 60}, m = "execute")
    /* renamed from: io.ktor.client.statement.HttpStatement$execute$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42721<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C42721(InterfaceC4014c<? super C42721> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.execute(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {163, PictureConfig.PREVIEW_VIDEO_CODE, 167}, m = "fetchResponse")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.statement.HttpStatement$fetchResponse$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42731 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C42731(InterfaceC4014c<? super C42731> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.fetchResponse(this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {151}, m = "fetchStreamingResponse")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.statement.HttpStatement$fetchStreamingResponse$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42741 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C42741(InterfaceC4014c<? super C42741> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.fetchStreamingResponse(this);
        }
    }

    public HttpStatement(HttpRequestBuilder builder, HttpClient client) {
        p.i(builder, "builder");
        p.i(client, "client");
        this.builder = builder;
        this.client = client;
    }

    public static /* synthetic */ void getClient$annotations() {
    }

    public final /* synthetic */ <T> Object body(InterfaceC4014c<? super T> interfaceC4014c) throws Throwable {
        try {
            n.c(3);
            n.c(0);
            Object objFetchStreamingResponse = fetchStreamingResponse(null);
            n.c(1);
            HttpResponse httpResponse = (HttpResponse) objFetchStreamingResponse;
            try {
                n.c(3);
                HttpClientCall call = httpResponse.getCall();
                p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
                InterfaceC5745d interfaceC5745dB = t.b(Object.class);
                try {
                    p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
                } catch (Throwable unused) {
                }
                TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
                n.c(0);
                Object objBodyNullable = call.bodyNullable(typeInfo, null);
                n.c(1);
                p.o(1, ExifInterface.GPS_DIRECTION_TRUE);
                return objBodyNullable;
            } finally {
                n.b(1);
                HttpResponseKt.complete(httpResponse);
                n.a(1);
            }
        } catch (CancellationException e10) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object cleanup(io.ktor.client.statement.HttpResponse r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.statement.HttpStatement.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = (io.ktor.client.statement.HttpStatement.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = new io.ktor.client.statement.HttpStatement$cleanup$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L41
            if (r1 != r2) goto L39
            java.lang.Object r5 = r0.L$3
            Ua.x r5 = (Ua.InterfaceC1089x) r5
            java.lang.Object r5 = r0.L$2
            Ua.x r5 = (Ua.InterfaceC1089x) r5
            java.lang.Object r5 = r0.L$1
            Ua.x r5 = (Ua.InterfaceC1089x) r5
            java.lang.Object r5 = r0.L$0
            io.ktor.client.statement.HttpResponse r5 = (io.ktor.client.statement.HttpResponse) r5
            kotlin.C4849c.b(r4)
            goto L83
        L39:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L41:
            kotlin.C4849c.b(r4)
            kotlin.coroutines.d r4 = r5.getCoroutineContext()
            kotlinx.coroutines.g r4 = Ua.C1086v0.o(r4)
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob"
            kotlin.jvm.internal.p.g(r4, r1)
            Ua.x r4 = (Ua.InterfaceC1089x) r4
            r4.complete()
            boolean r1 = io.ktor.client.plugins.DoubleReceivePluginKt.isSaved(r5)
            if (r1 != 0) goto L63
            io.ktor.utils.io.ByteReadChannel r1 = r5.getRawContent()     // Catch: java.lang.Throwable -> L63
            io.ktor.utils.io.ByteReadChannelKt.cancel(r1)     // Catch: java.lang.Throwable -> L63
        L63:
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            java.lang.Object r5 = g9.h.a(r4)
            r0.L$1 = r5
            r0.L$2 = r4
            java.lang.Object r5 = g9.h.a(r4)
            r0.L$3 = r5
            r5 = 0
            r0.I$0 = r5
            r0.label = r2
            java.lang.Object r4 = r4.T0(r0)
            if (r4 != r6) goto L83
            return r6
        L83:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.cleanup(io.ktor.client.statement.HttpResponse, e9.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:58|(1:(1:(1:(1:(2:14|15)(3:16|17|59))(3:19|20|21))(5:22|54|23|40|(2:42|48)(1:43)))(3:27|28|29))(3:30|31|(2:33|48)(1:34))|35|56|36|(3:39|40|(0)(0))|48) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c6, code lost:
    
        r4 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c7, code lost:
    
        r5 = r2;
        r2 = r6;
        r6 = r10;
        r10 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object execute(p9.p<? super io.ktor.client.statement.HttpResponse, ? super e9.InterfaceC4014c<? super T>, ? extends java.lang.Object> r10, e9.InterfaceC4014c<? super T> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.execute(p9.p, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchResponse(e9.InterfaceC4014c<? super io.ktor.client.statement.HttpResponse> r10) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.client.statement.HttpStatement.C42731
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.client.statement.HttpStatement$fetchResponse$1 r0 = (io.ktor.client.statement.HttpStatement.C42731) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpStatement$fetchResponse$1 r0 = new io.ktor.client.statement.HttpStatement$fetchResponse$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5f
            if (r2 == r5) goto L53
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r9 = r0.L$2
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            java.lang.Object r1 = r0.L$1
            io.ktor.client.call.HttpClientCall r1 = (io.ktor.client.call.HttpClientCall) r1
            java.lang.Object r0 = r0.L$0
            io.ktor.client.request.HttpRequestBuilder r0 = (io.ktor.client.request.HttpRequestBuilder) r0
            kotlin.C4849c.b(r10)     // Catch: java.util.concurrent.CancellationException -> Lc8
            return r9
        L3b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L43:
            int r2 = r0.I$1
            int r4 = r0.I$0
            java.lang.Object r5 = r0.L$1
            io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.client.request.HttpRequestBuilder r6 = (io.ktor.client.request.HttpRequestBuilder) r6
            kotlin.C4849c.b(r10)     // Catch: java.util.concurrent.CancellationException -> Lc8
            goto La2
        L53:
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$0
            io.ktor.client.request.HttpRequestBuilder r6 = (io.ktor.client.request.HttpRequestBuilder) r6
            kotlin.C4849c.b(r10)     // Catch: java.util.concurrent.CancellationException -> Lc8
            goto L87
        L5f:
            kotlin.C4849c.b(r10)
            io.ktor.client.request.HttpRequestBuilder r10 = new io.ktor.client.request.HttpRequestBuilder     // Catch: java.util.concurrent.CancellationException -> Lc8
            r10.<init>()     // Catch: java.util.concurrent.CancellationException -> Lc8
            io.ktor.client.request.HttpRequestBuilder r2 = r9.builder     // Catch: java.util.concurrent.CancellationException -> Lc8
            io.ktor.client.request.HttpRequestBuilder r10 = r10.takeFromWithExecutionContext(r2)     // Catch: java.util.concurrent.CancellationException -> Lc8
            io.ktor.client.HttpClient r2 = r9.client     // Catch: java.util.concurrent.CancellationException -> Lc8
            java.lang.Object r6 = g9.h.a(r10)     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.L$0 = r6     // Catch: java.util.concurrent.CancellationException -> Lc8
            r6 = 0
            r0.I$0 = r6     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.I$1 = r6     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.label = r5     // Catch: java.util.concurrent.CancellationException -> Lc8
            java.lang.Object r2 = r2.execute$ktor_client_core(r10, r0)     // Catch: java.util.concurrent.CancellationException -> Lc8
            if (r2 != r1) goto L83
            goto Lc6
        L83:
            r5 = r6
            r6 = r10
            r10 = r2
            r2 = r5
        L87:
            io.ktor.client.call.HttpClientCall r10 = (io.ktor.client.call.HttpClientCall) r10     // Catch: java.util.concurrent.CancellationException -> Lc8
            java.lang.Object r7 = g9.h.a(r6)     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.L$0 = r7     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.L$1 = r10     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.I$0 = r5     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.I$1 = r2     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.label = r4     // Catch: java.util.concurrent.CancellationException -> Lc8
            java.lang.Object r4 = io.ktor.client.call.SavedCallKt.save(r10, r0)     // Catch: java.util.concurrent.CancellationException -> Lc8
            if (r4 != r1) goto L9e
            goto Lc6
        L9e:
            r8 = r5
            r5 = r10
            r10 = r4
            r4 = r8
        La2:
            io.ktor.client.call.HttpClientCall r10 = (io.ktor.client.call.HttpClientCall) r10     // Catch: java.util.concurrent.CancellationException -> Lc8
            io.ktor.client.statement.HttpResponse r10 = r10.getResponse()     // Catch: java.util.concurrent.CancellationException -> Lc8
            io.ktor.client.statement.HttpResponse r7 = r5.getResponse()     // Catch: java.util.concurrent.CancellationException -> Lc8
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.L$0 = r6     // Catch: java.util.concurrent.CancellationException -> Lc8
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.L$1 = r5     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.L$2 = r10     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.I$0 = r4     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.I$1 = r2     // Catch: java.util.concurrent.CancellationException -> Lc8
            r0.label = r3     // Catch: java.util.concurrent.CancellationException -> Lc8
            java.lang.Object r9 = r9.cleanup(r7, r0)     // Catch: java.util.concurrent.CancellationException -> Lc8
            if (r9 != r1) goto Lc7
        Lc6:
            return r1
        Lc7:
            return r10
        Lc8:
            r9 = move-exception
            java.lang.Throwable r9 = io.ktor.client.utils.ExceptionUtilsJvmKt.unwrapCancellationException(r9)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.fetchResponse(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchStreamingResponse(e9.InterfaceC4014c<? super io.ktor.client.statement.HttpResponse> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.client.statement.HttpStatement.C42741
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.client.statement.HttpStatement$fetchStreamingResponse$1 r0 = (io.ktor.client.statement.HttpStatement.C42741) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.statement.HttpStatement$fetchStreamingResponse$1 r0 = new io.ktor.client.statement.HttpStatement$fetchStreamingResponse$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.client.request.HttpRequestBuilder r4 = (io.ktor.client.request.HttpRequestBuilder) r4
            kotlin.C4849c.b(r5)     // Catch: java.util.concurrent.CancellationException -> L63
            goto L5c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            io.ktor.client.request.HttpRequestBuilder r5 = new io.ktor.client.request.HttpRequestBuilder     // Catch: java.util.concurrent.CancellationException -> L63
            r5.<init>()     // Catch: java.util.concurrent.CancellationException -> L63
            io.ktor.client.request.HttpRequestBuilder r2 = r4.builder     // Catch: java.util.concurrent.CancellationException -> L63
            io.ktor.client.request.HttpRequestBuilder r5 = r5.takeFromWithExecutionContext(r2)     // Catch: java.util.concurrent.CancellationException -> L63
            io.ktor.client.plugins.DoubleReceivePluginKt.skipSaveBody(r5)     // Catch: java.util.concurrent.CancellationException -> L63
            io.ktor.client.HttpClient r4 = r4.client     // Catch: java.util.concurrent.CancellationException -> L63
            java.lang.Object r2 = g9.h.a(r5)     // Catch: java.util.concurrent.CancellationException -> L63
            r0.L$0 = r2     // Catch: java.util.concurrent.CancellationException -> L63
            r2 = 0
            r0.I$0 = r2     // Catch: java.util.concurrent.CancellationException -> L63
            r0.I$1 = r2     // Catch: java.util.concurrent.CancellationException -> L63
            r0.label = r3     // Catch: java.util.concurrent.CancellationException -> L63
            java.lang.Object r5 = r4.execute$ktor_client_core(r5, r0)     // Catch: java.util.concurrent.CancellationException -> L63
            if (r5 != r1) goto L5c
            return r1
        L5c:
            io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5     // Catch: java.util.concurrent.CancellationException -> L63
            io.ktor.client.statement.HttpResponse r4 = r5.getResponse()     // Catch: java.util.concurrent.CancellationException -> L63
            return r4
        L63:
            r4 = move-exception
            java.lang.Throwable r4 = io.ktor.client.utils.ExceptionUtilsJvmKt.unwrapCancellationException(r4)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.fetchStreamingResponse(e9.c):java.lang.Object");
    }

    public final HttpClient getClient() {
        return this.client;
    }

    public String toString() {
        return "HttpStatement[" + this.builder.getUrl() + ']';
    }

    public final Object execute(InterfaceC4014c<? super HttpResponse> interfaceC4014c) {
        return fetchResponse(interfaceC4014c);
    }

    public final /* synthetic */ <T, R> Object body(p9.p<? super T, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super R> interfaceC4014c) throws Throwable {
        try {
            n.c(3);
            n.c(0);
            Object objFetchStreamingResponse = fetchStreamingResponse(null);
            n.c(1);
            HttpResponse httpResponse = (HttpResponse) objFetchStreamingResponse;
            try {
                n.c(3);
                HttpClientCall call = httpResponse.getCall();
                p.o(4, ExifInterface.GPS_DIRECTION_TRUE);
                InterfaceC5745d interfaceC5745dB = t.b(Object.class);
                try {
                    p.o(6, ExifInterface.GPS_DIRECTION_TRUE);
                } catch (Throwable unused) {
                }
                TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, null);
                n.c(0);
                Object objBodyNullable = call.bodyNullable(typeInfo, null);
                n.c(1);
                p.o(1, ExifInterface.GPS_DIRECTION_TRUE);
                n.c(3);
                return pVar.invoke(objBodyNullable, null);
            } finally {
                n.b(1);
                n.c(3);
                n.c(0);
                cleanup(httpResponse, null);
                n.c(1);
                n.a(1);
            }
        } catch (CancellationException e10) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e10);
        }
    }
}
