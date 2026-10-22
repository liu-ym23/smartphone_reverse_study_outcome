package io.ktor.client;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.utils.io.KtorDsl;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0007\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineConfig;", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/client/engine/HttpClientEngineFactory;", "engineFactory", "Lkotlin/Function1;", "Lio/ktor/client/HttpClientConfig;", "LY8/t;", "block", "Lio/ktor/client/HttpClient;", "HttpClient", "(Lio/ktor/client/engine/HttpClientEngineFactory;Lp9/l;)Lio/ktor/client/HttpClient;", "Lio/ktor/client/engine/HttpClientEngine;", C3081a.KEY_ENGINE, "(Lio/ktor/client/engine/HttpClientEngine;Lp9/l;)Lio/ktor/client/HttpClient;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpClientKt {
    @KtorDsl
    public static final <T extends HttpClientEngineConfig> HttpClient HttpClient(HttpClientEngineFactory<? extends T> engineFactory, InterfaceC5074l<? super HttpClientConfig<T>, t> block) {
        p.i(engineFactory, "engineFactory");
        p.i(block, "block");
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        block.invoke(httpClientConfig);
        final HttpClientEngine httpClientEngineCreate = engineFactory.create(httpClientConfig.getEngineConfig$ktor_client_core());
        HttpClient httpClient = new HttpClient(httpClientEngineCreate, httpClientConfig, true);
        d.b bVar = httpClient.getCoroutineContext().get(kotlinx.coroutines.g.INSTANCE);
        p.f(bVar);
        ((kotlinx.coroutines.g) bVar).J(new InterfaceC5074l() { // from class: io.ktor.client.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpClientKt.HttpClient$lambda$1(httpClientEngineCreate, (Throwable) obj);
            }
        });
        return httpClient;
    }

    public static /* synthetic */ HttpClient HttpClient$default(HttpClientEngineFactory httpClientEngineFactory, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.j
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return HttpClientKt.HttpClient$lambda$0((HttpClientConfig) obj2);
                }
            };
        }
        return HttpClient(httpClientEngineFactory, interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t HttpClient$lambda$0(HttpClientConfig httpClientConfig) {
        p.i(httpClientConfig, "<this>");
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t HttpClient$lambda$1(HttpClientEngine httpClientEngine, Throwable th) throws IOException {
        httpClientEngine.close();
        return t.f7040a;
    }

    @KtorDsl
    public static final HttpClient HttpClient(HttpClientEngine engine, InterfaceC5074l<? super HttpClientConfig<?>, t> block) {
        p.i(engine, "engine");
        p.i(block, "block");
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        block.invoke(httpClientConfig);
        return new HttpClient(engine, httpClientConfig, false);
    }
}
