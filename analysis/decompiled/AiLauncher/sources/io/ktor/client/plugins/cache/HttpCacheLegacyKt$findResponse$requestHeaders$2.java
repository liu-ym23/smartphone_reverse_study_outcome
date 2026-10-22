package io.ktor.client.plugins.cache;

import io.ktor.http.Headers;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class HttpCacheLegacyKt$findResponse$requestHeaders$2 extends FunctionReferenceImpl implements InterfaceC5074l<String, List<? extends String>> {
    public HttpCacheLegacyKt$findResponse$requestHeaders$2(Object obj) {
        super(1, obj, Headers.class, "getAll", "getAll(Ljava/lang/String;)Ljava/util/List;", 0);
    }

    @Override // p9.InterfaceC5074l
    public final List<String> invoke(String p02) {
        p.i(p02, "p0");
        return ((Headers) this.receiver).getAll(p02);
    }
}
