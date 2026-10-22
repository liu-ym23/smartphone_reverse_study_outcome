package vd;

import com.fasterxml.jackson.core.JsonFactory;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public enum b {
    DOUBLE_QUOTED(Character.valueOf(JsonFactory.DEFAULT_QUOTE_CHAR)),
    SINGLE_QUOTED('\''),
    LITERAL('|'),
    FOLDED('>'),
    JSON_SCALAR_STYLE('J'),
    PLAIN(null);


    /* renamed from: c, reason: collision with root package name */
    public final Character f14905c;

    b(Character ch) {
        this.f14905c = ch;
    }

    public static b a(Character ch) {
        char cCharValue = ch.charValue();
        if (cCharValue == '\"') {
            return DOUBLE_QUOTED;
        }
        if (cCharValue == '\'') {
            return SINGLE_QUOTED;
        }
        if (cCharValue == '>') {
            return FOLDED;
        }
        if (cCharValue == '|') {
            return LITERAL;
        }
        throw new yd.c("Unknown scalar style character: " + ch);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Scalar style: '" + this.f14905c + "'";
    }
}
