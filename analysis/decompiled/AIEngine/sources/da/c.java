package da;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {
    public static void a(StringBuilder sb2, Object obj) {
        if (obj == null) {
            sb2.append("null");
            return;
        }
        if ((obj instanceof Number) || (obj instanceof Boolean)) {
            sb2.append(obj.toString());
            return;
        }
        boolean z = true;
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                b(sb2, obj.toString());
                return;
            }
            sb2.append('[');
            for (Object obj2 : (List) obj) {
                if (!z) {
                    sb2.append(',');
                }
                a(sb2, obj2);
                z = false;
            }
            sb2.append(']');
            return;
        }
        sb2.append('{');
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                if (!z) {
                    sb2.append(',');
                }
                b(sb2, String.valueOf(key));
                sb2.append(':');
                a(sb2, value);
                z = false;
            }
        }
        sb2.append('}');
    }

    public static void b(StringBuilder sb2, String str) {
        sb2.append('\"');
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\t') {
                sb2.append("\\t");
            } else if (cCharAt == '\n') {
                sb2.append("\\n");
            } else if (cCharAt == '\r') {
                sb2.append("\\r");
            } else if (cCharAt == '\"') {
                sb2.append("\\\"");
            } else if (cCharAt == '\\') {
                sb2.append("\\\\");
            } else if (g.g(cCharAt, 32) < 0) {
                sb2.append(String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(cCharAt)}, 1)));
            } else {
                sb2.append(cCharAt);
            }
        }
        sb2.append('\"');
    }

    public static final void c(Ref$BooleanRef ref$BooleanRef, StringBuilder sb2, String str, Object obj) {
        if (obj == null) {
            return;
        }
        if (!ref$BooleanRef.f10073a) {
            sb2.append(',');
        }
        ref$BooleanRef.f10073a = false;
        b(sb2, str);
        sb2.append(':');
        a(sb2, obj);
    }
}
