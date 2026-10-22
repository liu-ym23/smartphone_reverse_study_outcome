package k4;

import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f3630a = c5.l.k0(new Character[]{'(', ')', '<', '>', '@', Character.valueOf(AbstractJsonLexerKt.COMMA), ';', Character.valueOf(AbstractJsonLexerKt.COLON), Character.valueOf(AbstractJsonLexerKt.STRING_ESC), Character.valueOf(AbstractJsonLexerKt.STRING), '/', Character.valueOf(AbstractJsonLexerKt.BEGIN_LIST), Character.valueOf(AbstractJsonLexerKt.END_LIST), '?', '=', Character.valueOf(AbstractJsonLexerKt.BEGIN_OBJ), Character.valueOf(AbstractJsonLexerKt.END_OBJ), ' ', '\t', '\n', '\r'});

    public static final boolean a(String str) {
        if (str.length() != 0) {
            if (str.length() >= 2 && x5.n.m1(str) == '\"' && x5.n.u1(str) == '\"') {
                int i8 = 1;
                do {
                    int iQ1 = x5.n.q1(str, AbstractJsonLexerKt.STRING, i8, 4);
                    if (iQ1 == x5.n.n1(str)) {
                        break;
                    }
                    int i9 = 0;
                    for (int i10 = iQ1 - 1; str.charAt(i10) == '\\'; i10--) {
                        i9++;
                    }
                    if (i9 % 2 != 0) {
                        i8 = iQ1 + 1;
                    }
                } while (i8 < str.length());
                return false;
            }
            int length = str.length();
            for (int i11 = 0; i11 < length; i11++) {
                if (!f3630a.contains(Character.valueOf(str.charAt(i11)))) {
                }
            }
            return false;
        }
        return true;
    }

    public static final String b(String str) {
        kotlin.jvm.internal.p.e(str, "<this>");
        StringBuilder sb = new StringBuilder("\"");
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt != '\\') {
                sb.append(cCharAt);
            } else {
                sb.append("\\\\");
            }
        }
        sb.append("\"");
        return sb.toString();
    }
}
