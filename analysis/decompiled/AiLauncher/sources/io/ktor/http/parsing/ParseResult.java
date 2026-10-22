package io.ktor.http.parsing;

import Z8.C1173v;
import Z8.F;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00042\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fR&\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/http/parsing/ParseResult;", "", "", "", "", "mapping", "<init>", "(Ljava/util/Map;)V", "key", "get", "(Ljava/lang/String;)Ljava/lang/String;", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "", "contains", "(Ljava/lang/String;)Z", "Ljava/util/Map;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ParseResult {
    private final Map<String, List<String>> mapping;

    /* JADX WARN: Multi-variable type inference failed */
    public ParseResult(Map<String, ? extends List<String>> mapping) {
        p.i(mapping, "mapping");
        this.mapping = mapping;
    }

    public final boolean contains(String key) {
        p.i(key, "key");
        return this.mapping.containsKey(key);
    }

    public final String get(String key) {
        p.i(key, "key");
        List<String> list = this.mapping.get(key);
        if (list != null) {
            return (String) F.s0(list);
        }
        return null;
    }

    public final List<String> getAll(String key) {
        p.i(key, "key");
        List<String> list = this.mapping.get(key);
        return list == null ? C1173v.m() : list;
    }
}
