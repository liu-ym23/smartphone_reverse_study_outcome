package io.ktor.client.engine.cio;

import Y8.t;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/client/engine/cio/CIO;", "Lio/ktor/client/engine/HttpClientEngineFactory;", "Lio/ktor/client/engine/cio/CIOEngineConfig;", "<init>", "()V", "Lkotlin/Function1;", "LY8/t;", "block", "Lio/ktor/client/engine/HttpClientEngine;", "create", "(Lp9/l;)Lio/ktor/client/engine/HttpClientEngine;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "ktor-client-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CIO implements HttpClientEngineFactory<CIOEngineConfig> {
    public static final CIO INSTANCE = new CIO();

    private CIO() {
    }

    @Override // io.ktor.client.engine.HttpClientEngineFactory
    public HttpClientEngine create(InterfaceC5074l<? super CIOEngineConfig, t> block) {
        p.i(block, "block");
        CIOEngineConfig cIOEngineConfig = new CIOEngineConfig();
        block.invoke(cIOEngineConfig);
        return new CIOEngine(cIOEngineConfig);
    }

    public boolean equals(Object other) {
        return this == other || (other instanceof CIO);
    }

    public int hashCode() {
        return 1717340481;
    }

    public String toString() {
        return "CIO";
    }
}
