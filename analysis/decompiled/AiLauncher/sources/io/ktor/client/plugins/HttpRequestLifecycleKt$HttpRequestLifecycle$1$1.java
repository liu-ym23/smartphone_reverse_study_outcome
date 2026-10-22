package io.ktor.client.plugins;

import Ua.InterfaceC1089x;
import Ua.L0;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "request", "Lkotlin/Function1;", "Le9/c;", "LY8/t;", "", "proceed", "<anonymous>", "(Lio/ktor/client/request/HttpRequestBuilder;Lp9/l;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.plugins.HttpRequestLifecycleKt$HttpRequestLifecycle$1$1", f = "HttpRequestLifecycle.kt", l = {29}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class HttpRequestLifecycleKt$HttpRequestLifecycle$1$1 extends SuspendLambda implements p9.q<HttpRequestBuilder, InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object>, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ ClientPluginBuilder<Y8.t> $this_createClientPlugin;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestLifecycleKt$HttpRequestLifecycle$1$1(ClientPluginBuilder<Y8.t> clientPluginBuilder, InterfaceC4014c<? super HttpRequestLifecycleKt$HttpRequestLifecycle$1$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$this_createClientPlugin = clientPluginBuilder;
    }

    @Override // p9.q
    public final Object invoke(HttpRequestBuilder httpRequestBuilder, InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        HttpRequestLifecycleKt$HttpRequestLifecycle$1$1 httpRequestLifecycleKt$HttpRequestLifecycle$1$1 = new HttpRequestLifecycleKt$HttpRequestLifecycle$1$1(this.$this_createClientPlugin, interfaceC4014c);
        httpRequestLifecycleKt$HttpRequestLifecycle$1$1.L$0 = httpRequestBuilder;
        httpRequestLifecycleKt$HttpRequestLifecycle$1$1.L$1 = interfaceC5074l;
        return httpRequestLifecycleKt$HttpRequestLifecycle$1$1.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th;
        InterfaceC1089x interfaceC1089x;
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$0;
        InterfaceC5074l interfaceC5074l = (InterfaceC5074l) this.L$1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC1089x = (InterfaceC1089x) this.L$2;
            try {
                C4849c.b(obj);
                interfaceC1089x.complete();
                return Y8.t.f7040a;
            } catch (Throwable th2) {
                th = th2;
                try {
                    interfaceC1089x.e(th);
                    throw th;
                } catch (Throwable th3) {
                    interfaceC1089x.complete();
                    throw th3;
                }
            }
        }
        C4849c.b(obj);
        InterfaceC1089x interfaceC1089xA = L0.a(httpRequestBuilder.getExecutionContext());
        d.b bVar = this.$this_createClientPlugin.getClient().getCoroutineContext().get(kotlinx.coroutines.g.INSTANCE);
        kotlin.jvm.internal.p.f(bVar);
        HttpRequestLifecycleKt.attachToClientEngineJob(interfaceC1089xA, (kotlinx.coroutines.g) bVar);
        try {
            httpRequestBuilder.setExecutionContext$ktor_client_core(interfaceC1089xA);
            this.L$0 = g9.h.a(httpRequestBuilder);
            this.L$1 = g9.h.a(interfaceC5074l);
            this.L$2 = interfaceC1089xA;
            this.label = 1;
            if (interfaceC5074l.invoke(this) == objG) {
                return objG;
            }
            interfaceC1089x = interfaceC1089xA;
            interfaceC1089x.complete();
            return Y8.t.f7040a;
        } catch (Throwable th4) {
            th = th4;
            interfaceC1089x = interfaceC1089xA;
            interfaceC1089x.e(th);
            throw th;
        }
    }
}
