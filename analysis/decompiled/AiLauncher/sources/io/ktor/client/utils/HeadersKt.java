package io.ktor.client.utils;

import Y8.t;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "LY8/t;", "block", "Lio/ktor/http/Headers;", "buildHeaders", "(Lp9/l;)Lio/ktor/http/Headers;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HeadersKt {
    public static final Headers buildHeaders(InterfaceC5074l<? super HeadersBuilder, t> block) {
        p.i(block, "block");
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        block.invoke(headersBuilder);
        return headersBuilder.build();
    }

    public static /* synthetic */ Headers buildHeaders$default(InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: io.ktor.client.utils.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return HeadersKt.buildHeaders$lambda$0((HeadersBuilder) obj2);
                }
            };
        }
        return buildHeaders(interfaceC5074l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t buildHeaders$lambda$0(HeadersBuilder headersBuilder) {
        p.i(headersBuilder, "<this>");
        return t.f7040a;
    }
}
