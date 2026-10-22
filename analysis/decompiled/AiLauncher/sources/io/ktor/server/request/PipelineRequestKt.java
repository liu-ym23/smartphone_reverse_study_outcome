package io.ktor.server.request;

import Z8.C1173v;
import Z8.C1174w;
import io.ktor.http.CodecsKt;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/server/request/ApplicationRequest;", "Lio/ktor/http/Parameters;", "parameters", "encodeParameters", "(Lio/ktor/server/request/ApplicationRequest;Lio/ktor/http/Parameters;)Lio/ktor/http/Parameters;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PipelineRequestKt {
    public static final Parameters encodeParameters(ApplicationRequest applicationRequest, Parameters parameters) {
        List listM;
        p.i(applicationRequest, "<this>");
        p.i(parameters, "parameters");
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        for (String str : applicationRequest.getRawQueryParameters().names()) {
            List<String> all = parameters.getAll(str);
            if (all != null) {
                List<String> list = all;
                listM = new ArrayList(C1174w.x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    listM.add(CodecsKt.decodeURLQueryComponent$default((String) it.next(), 0, 0, true, null, 11, null));
                }
            } else {
                listM = null;
            }
            if (listM == null) {
                listM = C1173v.m();
            }
            parametersBuilderParametersBuilder$default.appendAll(CodecsKt.decodeURLQueryComponent$default(str, 0, 0, false, null, 15, null), listM);
        }
        return parametersBuilderParametersBuilder$default.build();
    }
}
