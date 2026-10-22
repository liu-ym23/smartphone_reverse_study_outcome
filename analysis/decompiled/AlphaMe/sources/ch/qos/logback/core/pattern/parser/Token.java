package ch.qos.logback.core.pattern.parser;

import B0.g;

/* loaded from: classes.dex */
class Token {
    static final int COMPOSITE_KEYWORD = 1005;
    static final int CURLY_LEFT = 123;
    static final int CURLY_RIGHT = 125;
    static final int DOT = 46;
    static final int EOF = Integer.MAX_VALUE;
    static final int FORMAT_MODIFIER = 1002;
    static final int LITERAL = 1000;
    static final int MINUS = 45;
    static final int OPTION = 1006;
    static final int PERCENT = 37;
    static final int RIGHT_PARENTHESIS = 41;
    static final int SIMPLE_KEYWORD = 1004;
    private final int type;
    private final Object value;
    static Token EOF_TOKEN = new Token(Integer.MAX_VALUE, "EOF");
    static Token RIGHT_PARENTHESIS_TOKEN = new Token(41);
    static Token BARE_COMPOSITE_KEYWORD_TOKEN = new Token(1005, "BARE");
    static Token PERCENT_TOKEN = new Token(37);

    public Token(int i4) {
        this(i4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Token)) {
            return false;
        }
        Token token = (Token) obj;
        if (this.type != token.type) {
            return false;
        }
        Object obj2 = this.value;
        return obj2 == null ? token.value == null : obj2.equals(token.value);
    }

    public int getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int i4 = this.type * 29;
        Object obj = this.value;
        return i4 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        String str;
        int i4 = this.type;
        if (i4 == 37) {
            str = "%";
        } else if (i4 == 41) {
            str = "RIGHT_PARENTHESIS";
        } else if (i4 == 1000) {
            str = "LITERAL";
        } else if (i4 != 1002) {
            switch (i4) {
                case SIMPLE_KEYWORD /* 1004 */:
                    str = "SIMPLE_KEYWORD";
                    break;
                case 1005:
                    str = "COMPOSITE_KEYWORD";
                    break;
                case OPTION /* 1006 */:
                    str = "OPTION";
                    break;
                default:
                    str = "UNKNOWN";
                    break;
            }
        } else {
            str = "FormatModifier";
        }
        if (this.value == null) {
            return g.n("Token(", str, ")");
        }
        StringBuilder sbW = g.w("Token(", str, ", \"");
        sbW.append(this.value);
        sbW.append("\")");
        return sbW.toString();
    }

    public Token(int i4, Object obj) {
        this.type = i4;
        this.value = obj;
    }
}
