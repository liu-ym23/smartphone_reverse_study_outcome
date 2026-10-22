package io.ktor.http;

import io.ktor.util.StringValues;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/http/HeadersSingleImpl;", "Lio/ktor/http/Headers;", "Lio/ktor/util/StringValuesSingleImpl;", "", "name", "", "values", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HeadersSingleImpl extends StringValues implements Headers {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadersSingleImpl(String name, List<String> values) {
        super(true, name, values);
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(values, "values");
    }

    @Override // io.ktor.util.StringValues
    public String toString() {
        return "Headers " + entries();
    }
}
