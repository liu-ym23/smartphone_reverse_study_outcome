package io.ktor.server.engine;

import java.lang.reflect.Method;
import kotlin.Metadata;
import w9.InterfaceC5748g;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LY8/e;", "", "methodName", "(LY8/e;)Ljava/lang/String;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerHostUtilsKt {
    public static final String methodName(Y8.e<?> eVar) {
        Method methodE;
        kotlin.jvm.internal.p.i(eVar, "<this>");
        InterfaceC5748g interfaceC5748g = eVar instanceof InterfaceC5748g ? (InterfaceC5748g) eVar : null;
        if (interfaceC5748g == null || (methodE = y9.d.e(interfaceC5748g)) == null) {
            return eVar.getClass().getName() + ".invoke";
        }
        return methodE.getDeclaringClass().getName() + '.' + methodE.getName();
    }
}
