package io.ktor.client.plugins.api;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import p9.q;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002*\u0012&\u0012$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJA\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2(\u0010\f\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/api/Send;", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function3;", "Lio/ktor/client/plugins/api/Send$Sender;", "Lio/ktor/client/request/HttpRequestBuilder;", "Le9/c;", "Lio/ktor/client/call/HttpClientCall;", "", "<init>", "()V", "Lio/ktor/client/HttpClient;", "client", "handler", "LY8/t;", W4.b.STEP_INSTALL, "(Lio/ktor/client/HttpClient;Lp9/q;)V", "Sender", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Send implements ClientHook<q<? super Sender, ? super HttpRequestBuilder, ? super InterfaceC4014c<? super HttpClientCall>, ? extends Object>> {
    public static final Send INSTANCE = new Send();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/api/Send$Sender;", "LUa/M;", "Lio/ktor/client/plugins/Sender;", "httpSendSender", "Lkotlin/coroutines/d;", "coroutineContext", "<init>", "(Lio/ktor/client/plugins/Sender;Lkotlin/coroutines/d;)V", "Lio/ktor/client/request/HttpRequestBuilder;", "requestBuilder", "Lio/ktor/client/call/HttpClientCall;", "proceed", "(Lio/ktor/client/request/HttpRequestBuilder;Le9/c;)Ljava/lang/Object;", "Lio/ktor/client/plugins/Sender;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Sender implements M {
        private final kotlin.coroutines.d coroutineContext;
        private final io.ktor.client.plugins.Sender httpSendSender;

        public Sender(io.ktor.client.plugins.Sender httpSendSender, kotlin.coroutines.d coroutineContext) {
            p.i(httpSendSender, "httpSendSender");
            p.i(coroutineContext, "coroutineContext");
            this.httpSendSender = httpSendSender;
            this.coroutineContext = coroutineContext;
        }

        @Override // Ua.M
        public kotlin.coroutines.d getCoroutineContext() {
            return this.coroutineContext;
        }

        public final Object proceed(HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpClientCall> interfaceC4014c) {
            return this.httpSendSender.execute(httpRequestBuilder, interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/Sender;", "request", "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.ktor.client.plugins.api.Send$install$1", f = "CommonHooks.kt", l = {52}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.plugins.api.Send$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements q<io.ktor.client.plugins.Sender, HttpRequestBuilder, InterfaceC4014c<? super HttpClientCall>, Object> {
        final /* synthetic */ HttpClient $client;
        final /* synthetic */ q<Sender, HttpRequestBuilder, InterfaceC4014c<? super HttpClientCall>, Object> $handler;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(q<? super Sender, ? super HttpRequestBuilder, ? super InterfaceC4014c<? super HttpClientCall>, ? extends Object> qVar, HttpClient httpClient, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = qVar;
            this.$client = httpClient;
        }

        @Override // p9.q
        public final Object invoke(io.ktor.client.plugins.Sender sender, HttpRequestBuilder httpRequestBuilder, InterfaceC4014c<? super HttpClientCall> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, this.$client, interfaceC4014c);
            anonymousClass1.L$0 = sender;
            anonymousClass1.L$1 = httpRequestBuilder;
            return anonymousClass1.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            io.ktor.client.plugins.Sender sender = (io.ktor.client.plugins.Sender) this.L$0;
            HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$1;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            q<Sender, HttpRequestBuilder, InterfaceC4014c<? super HttpClientCall>, Object> qVar = this.$handler;
            Sender sender2 = new Sender(sender, this.$client.getCoroutineContext());
            this.L$0 = h.a(sender);
            this.L$1 = h.a(httpRequestBuilder);
            this.label = 1;
            Object objInvoke = qVar.invoke(sender2, httpRequestBuilder, this);
            return objInvoke == objG ? objG : objInvoke;
        }
    }

    private Send() {
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, q<? super Sender, ? super HttpRequestBuilder, ? super InterfaceC4014c<? super HttpClientCall>, ? extends Object> handler) {
        p.i(client, "client");
        p.i(handler, "handler");
        ((HttpSend) HttpClientPluginKt.plugin(client, HttpSend.INSTANCE)).intercept(new AnonymousClass1(handler, client, null));
    }
}
