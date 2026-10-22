package io.ktor.client.plugins.observer;

import Y8.t;
import e9.InterfaceC4014c;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a=\u0010\b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00002&\u0010\u0007\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001j\u0002`\u0006¢\u0006\u0004\b\b\u0010\t\"#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\u0012\n\u0004\b\b\u0010\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e*B\u0010\u0011\"\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¨\u0006\u0012"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Le9/c;", "LY8/t;", "", "Lio/ktor/client/plugins/observer/ResponseHandler;", "block", "ResponseObserver", "(Lio/ktor/client/HttpClientConfig;Lp9/p;)V", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/observer/ResponseObserverConfig;", "Lio/ktor/client/plugins/api/ClientPlugin;", "getResponseObserver", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getResponseObserver$annotations", "()V", "ResponseHandler", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResponseObserverKt {
    private static final ClientPlugin<ResponseObserverConfig> ResponseObserver = CreatePluginUtilsKt.createClientPlugin("ResponseObserver", AnonymousClass1.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.client.plugins.observer.d
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return ResponseObserverKt.ResponseObserver$lambda$0((ClientPluginBuilder) obj);
        }
    });

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements InterfaceC5063a<ResponseObserverConfig> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0, ResponseObserverConfig.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p9.InterfaceC5063a
        public final ResponseObserverConfig invoke() {
            return new ResponseObserverConfig();
        }
    }

    public static final void ResponseObserver(HttpClientConfig<?> httpClientConfig, final p<? super HttpResponse, ? super InterfaceC4014c<? super t>, ? extends Object> block) {
        kotlin.jvm.internal.p.i(httpClientConfig, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        httpClientConfig.install(ResponseObserver, new InterfaceC5074l() { // from class: io.ktor.client.plugins.observer.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ResponseObserverKt.ResponseObserver$lambda$1(block, (ResponseObserverConfig) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t ResponseObserver$lambda$0(ClientPluginBuilder createClientPlugin) {
        kotlin.jvm.internal.p.i(createClientPlugin, "$this$createClientPlugin");
        p<HttpResponse, InterfaceC4014c<? super t>, Object> responseHandler$ktor_client_core = ((ResponseObserverConfig) createClientPlugin.getPluginConfig()).getResponseHandler$ktor_client_core();
        createClientPlugin.on(AfterReceiveHook.INSTANCE, new ResponseObserverKt$ResponseObserver$2$1(((ResponseObserverConfig) createClientPlugin.getPluginConfig()).getFilter$ktor_client_core(), createClientPlugin, responseHandler$ktor_client_core, null));
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t ResponseObserver$lambda$1(p pVar, ResponseObserverConfig install) {
        kotlin.jvm.internal.p.i(install, "$this$install");
        install.setResponseHandler$ktor_client_core(pVar);
        return t.f7040a;
    }

    public static final ClientPlugin<ResponseObserverConfig> getResponseObserver() {
        return ResponseObserver;
    }

    public static /* synthetic */ void getResponseObserver$annotations() {
    }
}
