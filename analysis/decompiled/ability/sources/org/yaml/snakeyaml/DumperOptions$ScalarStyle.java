package org.yaml.snakeyaml;

import com.fasterxml.jackson.core.JsonFactory;
import org.yaml.snakeyaml.error.YAMLException;

/* loaded from: classes4.dex */
public enum DumperOptions$ScalarStyle {
    DOUBLE_QUOTED(Character.valueOf(JsonFactory.DEFAULT_QUOTE_CHAR)),
    SINGLE_QUOTED('\''),
    LITERAL('|'),
    FOLDED('>'),
    JSON_SCALAR_STYLE('J'),
    PLAIN(null);


    /* renamed from: a, reason: collision with root package name */
    public final Character f5520a;

    DumperOptions$ScalarStyle(Character ch) {
        this.f5520a = ch;
    }

    public static DumperOptions$ScalarStyle a(Character ch) {
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
        throw new YAMLException("Unknown scalar style character: " + ch);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Scalar style: '" + this.f5520a + "'";
    }
}
