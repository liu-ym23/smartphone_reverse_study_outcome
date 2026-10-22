package io.ktor.server.application;

import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "expectedTypeName", "", "subject", "Lio/ktor/server/application/InvalidBodyException;", "noBinaryDataException", "(Ljava/lang/String;Ljava/lang/Object;)Lio/ktor/server/application/InvalidBodyException;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PluginExceptionsKt {
    public static final InvalidBodyException noBinaryDataException(String expectedTypeName, Object obj) {
        String strT;
        p.i(expectedTypeName, "expectedTypeName");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected ");
        sb2.append(expectedTypeName);
        sb2.append(" type but ");
        if (obj == null || (strT = t.b(obj.getClass()).t()) == null) {
            strT = "null";
        }
        sb2.append(strT);
        sb2.append(" found");
        return new InvalidBodyException(sb2.toString());
    }
}
