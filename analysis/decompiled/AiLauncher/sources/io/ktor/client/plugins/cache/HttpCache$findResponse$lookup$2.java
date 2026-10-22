package io.ktor.client.plugins.cache;

import io.ktor.http.HeadersBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class HttpCache$findResponse$lookup$2 extends FunctionReferenceImpl implements InterfaceC5074l<String, List<? extends String>> {
    public HttpCache$findResponse$lookup$2(Object obj) {
        super(1, obj, HeadersBuilder.class, "getAll", "getAll(Ljava/lang/String;)Ljava/util/List;", 0);
    }

    @Override // p9.InterfaceC5074l
    public final List<String> invoke(String p02) {
        p.i(p02, "p0");
        return ((HeadersBuilder) this.receiver).getAll(p02);
    }
}
