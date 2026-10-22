package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.spec.McpTransportSession;
import java.util.Map;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public final /* synthetic */ class y implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4680a;

    public /* synthetic */ y(int i) {
        this.f4680a = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f4680a) {
            case 0:
                return HttpClientStreamableHttpTransport.lambda$createClosedSession$3((McpTransportSession) obj);
            case 1:
                return HttpClientStreamableHttpTransport.lambda$connect$0((Throwable) obj);
            case 2:
                return ServerParameters.lambda$getDefaultEnvironment$0((Map.Entry) obj);
            case 3:
                return ServerParameters.lambda$getDefaultEnvironment$1((Map.Entry) obj);
            default:
                return ServerParameters.lambda$getDefaultEnvironment$2((Map.Entry) obj);
        }
    }
}
