package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0005\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\"\u0018\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "LY8/t;", "block", "defaultRequest", "(Lio/ktor/client/HttpClientConfig;Lp9/l;)V", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultRequestKt {
    private static final vc.c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.DefaultRequest");

    public static final void defaultRequest(HttpClientConfig<?> httpClientConfig, final InterfaceC5074l<? super DefaultRequest.DefaultRequestBuilder, Y8.t> block) {
        kotlin.jvm.internal.p.i(httpClientConfig, "<this>");
        kotlin.jvm.internal.p.i(block, "block");
        httpClientConfig.install(DefaultRequest.INSTANCE, new InterfaceC5074l() { // from class: io.ktor.client.plugins.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DefaultRequestKt.defaultRequest$lambda$0(block, (DefaultRequest.DefaultRequestBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t defaultRequest$lambda$0(InterfaceC5074l interfaceC5074l, DefaultRequest.DefaultRequestBuilder install) {
        kotlin.jvm.internal.p.i(install, "$this$install");
        interfaceC5074l.invoke(install);
        return Y8.t.f7040a;
    }
}
