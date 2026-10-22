package io.ktor.server.engine;

import Z8.Z;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u00110\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0015¨\u0006 "}, d2 = {"Lio/ktor/server/engine/DelegateHeaders;", "Lio/ktor/http/Headers;", "original", "<init>", "(Lio/ktor/http/Headers;)V", "", "name", "", "values", "LY8/t;", "setHeader", "(Ljava/lang/String;Ljava/util/List;)V", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "", "names", "()Ljava/util/Set;", "", "entries", "", "isEmpty", "()Z", "Lio/ktor/http/Headers;", "Lio/ktor/http/HeadersBuilder;", "overridden", "Lio/ktor/http/HeadersBuilder;", "", "removed", "Ljava/util/Set;", "caseInsensitiveName", "Z", "getCaseInsensitiveName", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class DelegateHeaders implements Headers {
    private final boolean caseInsensitiveName;
    private final Headers original;
    private final HeadersBuilder overridden;
    private final Set<String> removed;

    public DelegateHeaders(Headers original) {
        kotlin.jvm.internal.p.i(original, "original");
        this.original = original;
        this.overridden = new HeadersBuilder(0, 1, null);
        this.removed = new LinkedHashSet();
        this.caseInsensitiveName = original.getCaseInsensitiveName();
    }

    @Override // io.ktor.util.StringValues
    public boolean contains(String str) {
        return Headers.DefaultImpls.contains(this, str);
    }

    @Override // io.ktor.util.StringValues
    public Set<Map.Entry<String, List<String>>> entries() {
        Set setO = Z.o(this.original.entries(), this.overridden.build().entries());
        ArrayList arrayList = new ArrayList();
        for (Object obj : setO) {
            if (!this.removed.contains(((Map.Entry) obj).getKey())) {
                arrayList.add(obj);
            }
        }
        return Z8.F.r1(arrayList);
    }

    @Override // io.ktor.util.StringValues
    public void forEach(p9.p<? super String, ? super List<String>, Y8.t> pVar) {
        Headers.DefaultImpls.forEach(this, pVar);
    }

    @Override // io.ktor.util.StringValues
    public String get(String str) {
        return Headers.DefaultImpls.get(this, str);
    }

    @Override // io.ktor.util.StringValues
    public List<String> getAll(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        if (this.removed.contains(name)) {
            return null;
        }
        return this.overridden.contains(name) ? this.overridden.getAll(name) : this.original.getAll(name);
    }

    @Override // io.ktor.util.StringValues
    public boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    @Override // io.ktor.util.StringValues
    public boolean isEmpty() {
        return names().isEmpty();
    }

    @Override // io.ktor.util.StringValues
    public Set<String> names() {
        return Z.m(Z.o(this.original.names(), this.overridden.names()), this.removed);
    }

    public final void setHeader(String name, List<String> values) {
        kotlin.jvm.internal.p.i(name, "name");
        if (values == null) {
            this.removed.add(name);
            this.overridden.remove(name);
        } else {
            this.overridden.appendAll(name, values);
            this.removed.remove(name);
        }
    }

    @Override // io.ktor.util.StringValues
    public boolean contains(String str, String str2) {
        return Headers.DefaultImpls.contains(this, str, str2);
    }
}
