package io.ktor.client;

import Ka.t;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.utils.io.KtorDsl;
import java.util.Iterator;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0005\u001a\u00020\u00042\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\"\u001e\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00078\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u0012\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/Function1;", "Lio/ktor/client/HttpClientConfig;", "LY8/t;", "block", "Lio/ktor/client/HttpClient;", "HttpClient", "(Lp9/l;)Lio/ktor/client/HttpClient;", "Lio/ktor/client/engine/HttpClientEngineFactory;", "FACTORY", "Lio/ktor/client/engine/HttpClientEngineFactory;", "getFACTORY$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpClientJvmKt {
    private static final HttpClientEngineFactory<?> FACTORY;

    static {
        HttpClientEngineFactory<?> factory;
        Iterator it = ServiceLoader.load(HttpClientEngineContainer.class, HttpClientEngineContainer.class.getClassLoader()).iterator();
        p.h(it, "iterator(...)");
        HttpClientEngineContainer httpClientEngineContainer = (HttpClientEngineContainer) SequencesKt___SequencesKt.K(t.h(it));
        if (httpClientEngineContainer == null || (factory = httpClientEngineContainer.getFactory()) == null) {
            throw new IllegalStateException("Failed to find HTTP client engine implementation: consider adding client engine dependency. See https://ktor.io/docs/http-client-engines.html");
        }
        FACTORY = factory;
    }

    @KtorDsl
    public static final HttpClient HttpClient(InterfaceC5074l<? super HttpClientConfig<?>, Y8.t> block) {
        p.i(block, "block");
        return HttpClientKt.HttpClient(FACTORY, block);
    }

    public static /* synthetic */ HttpClient HttpClient$default(InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.i
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return HttpClientJvmKt.HttpClient$lambda$0((HttpClientConfig) obj2);
                }
            };
        }
        return HttpClient(interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t HttpClient$lambda$0(HttpClientConfig httpClientConfig) {
        p.i(httpClientConfig, "<this>");
        return Y8.t.f7040a;
    }

    private static /* synthetic */ void getFACTORY$annotations() {
    }
}
