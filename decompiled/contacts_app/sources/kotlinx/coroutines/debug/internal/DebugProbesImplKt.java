package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: compiled from: DebugProbesImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"repr", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DebugProbesImplKt {
    public static final /* synthetic */ String access$repr(String r0) {
        return repr(r0);
    }

    private static final String repr(String r5) {
        StringBuilder r0 = new StringBuilder("\"");
        int r1 = r5.length();
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L25;
        char r4 = r5.charAt(r2);
        if (r4 != '\"') goto L9;
        r0.append("\\\"");
    L24:
        r2 = r2 + 1;
        goto L4
    L9:
        if (r4 != '\\') goto L12;
        r0.append("\\\\");
        goto L24
    L12:
        if (r4 != '\b') goto L15;
        r0.append("\\b");
        goto L24
    L15:
        if (r4 != '\n') goto L18;
        r0.append("\\n");
        goto L24
    L18:
        if (r4 != '\r') goto L21;
        r0.append("\\r");
        goto L24
    L21:
        if (r4 != '\t') goto L23;
        r0.append("\\t");
        goto L24
    L23:
        r0.append(r4);
        goto L24
    L25:
        r0.append(Typography.quote);
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "StringBuilder().apply(builderAction).toString()");
        return r6;
    }
}
