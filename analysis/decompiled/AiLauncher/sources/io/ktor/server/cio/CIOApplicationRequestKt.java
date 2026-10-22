package io.ktor.server.cio;

import Y8.t;
import Z8.F;
import io.ktor.http.Parameters;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import p9.p;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/http/Parameters;", "toQueryParameters", "(Lio/ktor/http/Parameters;)Lio/ktor/http/Parameters;", "ktor-server-cio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOApplicationRequestKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Parameters toQueryParameters(final Parameters parameters) {
        return new Parameters() { // from class: io.ktor.server.cio.CIOApplicationRequestKt.toQueryParameters.1
            @Override // io.ktor.util.StringValues
            public boolean contains(String str) {
                return Parameters.DefaultImpls.contains(this, str);
            }

            @Override // io.ktor.util.StringValues
            public Set<Map.Entry<String, List<String>>> entries() {
                return parameters.entries();
            }

            @Override // io.ktor.util.StringValues
            public void forEach(p<? super String, ? super List<String>, t> pVar) {
                Parameters.DefaultImpls.forEach(this, pVar);
            }

            @Override // io.ktor.util.StringValues
            public String get(String name) {
                kotlin.jvm.internal.p.i(name, "name");
                List<String> all = getAll(name);
                if (all == null) {
                    return null;
                }
                return all.isEmpty() ? "" : (String) F.q0(all);
            }

            @Override // io.ktor.util.StringValues
            public List<String> getAll(String name) {
                kotlin.jvm.internal.p.i(name, "name");
                return parameters.getAll(name);
            }

            @Override // io.ktor.util.StringValues
            public boolean getCaseInsensitiveName() {
                return parameters.getCaseInsensitiveName();
            }

            @Override // io.ktor.util.StringValues
            public boolean isEmpty() {
                return parameters.isEmpty();
            }

            @Override // io.ktor.util.StringValues
            public Set<String> names() {
                return parameters.names();
            }

            @Override // io.ktor.util.StringValues
            public boolean contains(String str, String str2) {
                return Parameters.DefaultImpls.contains(this, str, str2);
            }
        };
    }
}
