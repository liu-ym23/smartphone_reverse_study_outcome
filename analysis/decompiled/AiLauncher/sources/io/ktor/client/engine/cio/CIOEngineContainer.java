package io.ktor.client.engine.cio;

import io.ktor.client.HttpClientEngineContainer;
import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;

@InternalAPI
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/client/engine/cio/CIOEngineContainer;", "Lio/ktor/client/HttpClientEngineContainer;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "Lio/ktor/client/engine/HttpClientEngineFactory;", "factory", "Lio/ktor/client/engine/HttpClientEngineFactory;", "getFactory", "()Lio/ktor/client/engine/HttpClientEngineFactory;", "ktor-client-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOEngineContainer implements HttpClientEngineContainer {
    private final HttpClientEngineFactory<?> factory = CIO.INSTANCE;

    @Override // io.ktor.client.HttpClientEngineContainer
    public HttpClientEngineFactory<?> getFactory() {
        return this.factory;
    }

    public String toString() {
        return "CIO";
    }
}
