package io.ktor.http;

import Z8.C1168p;
import Z8.C1172u;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.Headers;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001d\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0001\u0010\u0006\u001a#\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\u0001\u0010\t\u001aE\u0010\u0001\u001a\u00020\u000026\u0010\f\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u000b0\n\"\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u000b¢\u0006\u0004\b\u0001\u0010\r\u001a!\u0010\u0012\u001a\u00020\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/http/Headers;", "headersOf", "()Lio/ktor/http/Headers;", "", "name", UxipConstants.f30680s, "(Ljava/lang/String;Ljava/lang/String;)Lio/ktor/http/Headers;", "", "values", "(Ljava/lang/String;Ljava/util/List;)Lio/ktor/http/Headers;", "", "Lkotlin/Pair;", "pairs", "([Lkotlin/Pair;)Lio/ktor/http/Headers;", "Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "LY8/t;", "builder", "headers", "(Lp9/l;)Lio/ktor/http/Headers;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HeadersKt {
    public static final Headers headers(InterfaceC5074l<? super HeadersBuilder, Y8.t> builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        Headers.Companion companion = Headers.INSTANCE;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        builder.invoke(headersBuilder);
        return headersBuilder.build();
    }

    public static final Headers headersOf() {
        return Headers.INSTANCE.getEmpty();
    }

    public static final Headers headersOf(String name, String value) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        return new HeadersSingleImpl(name, C1172u.e(value));
    }

    public static final Headers headersOf(String name, List<String> values) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(values, "values");
        return new HeadersSingleImpl(name, values);
    }

    public static final Headers headersOf(Pair<String, ? extends List<String>>... pairs) {
        kotlin.jvm.internal.p.i(pairs, "pairs");
        return new HeadersImpl(kotlin.collections.a.y(C1168p.d(pairs)));
    }
}
