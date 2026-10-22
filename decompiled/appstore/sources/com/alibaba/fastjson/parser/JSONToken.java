package com.alibaba.fastjson.parser;

/* JADX INFO: loaded from: classes.dex */
public class JSONToken {
    public static final int COLON = 17;
    public static final int COMMA = 16;
    public static final int EOF = 20;
    public static final int ERROR = 1;
    public static final int FALSE = 7;
    public static final int IDENTIFIER = 18;
    public static final int LBRACE = 12;
    public static final int LBRACKET = 14;
    public static final int LITERAL_FLOAT = 3;
    public static final int LITERAL_INT = 2;
    public static final int LITERAL_ISO8601_DATE = 5;
    public static final int LITERAL_STRING = 4;
    public static final int LPAREN = 10;
    public static final int NEW = 9;
    public static final int NULL = 8;
    public static final int RBRACE = 13;
    public static final int RBRACKET = 15;
    public static final int RPAREN = 11;
    public static final int SET = 21;
    public static final int TREE_SET = 22;
    public static final int TRUE = 6;
    public static final int UNDEFINED = 23;

    public JSONToken() {
    }

    public static String name(int r10) {
        switch(r10) {
            case 1: goto L47;
            case 2: goto L45;
            case 3: goto L43;
            case 4: goto L41;
            case 5: goto L39;
            case 6: goto L37;
            case 7: goto L35;
            case 8: goto L33;
            case 9: goto L31;
            case 10: goto L29;
            case 11: goto L27;
            case 12: goto L25;
            case 13: goto L23;
            case 14: goto L21;
            case 15: goto L19;
            case 16: goto L17;
            case 17: goto L15;
            case 18: goto L13;
            case 19: goto L3;
            case 20: goto L11;
            case 21: goto L9;
            case 22: goto L7;
            case 23: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "undefined";
    L7:
        return "TreeSet";
    L9:
        return "Set";
    L11:
        return "EOF";
    L13:
        return "ident";
    L15:
        return ":";
    L17:
        return ",";
    L19:
        return "]";
    L21:
        return "[";
    L23:
        return "}";
    L25:
        return "{";
    L27:
        return ")";
    L29:
        return "(";
    L31:
        return "new";
    L33:
        return "null";
    L35:
        return "false";
    L37:
        return "true";
    L39:
        return "iso8601";
    L41:
        return "string";
    L43:
        return "float";
    L45:
        return "int";
    L47:
        return "error";
    }
}
