package com.alibaba.fastjson.parser;

import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes28.dex */
public class JSONToken {
    public static final int COLON = 17;
    public static final int COMMA = 16;
    public static final int DOT = 25;
    public static final int EOF = 20;
    public static final int ERROR = 1;
    public static final int FALSE = 7;
    public static final int FIELD_NAME = 19;
    public static final int HEX = 26;
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
    public static final int SEMI = 24;
    public static final int SET = 21;
    public static final int TREE_SET = 22;
    public static final int TRUE = 6;
    public static final int UNDEFINED = 23;

    public JSONToken() {
    }

    public static String name(int r100) {
        switch(r100) {
            case 1: goto L55;
            case 2: goto L53;
            case 3: goto L51;
            case 4: goto L49;
            case 5: goto L47;
            case 6: goto L45;
            case 7: goto L43;
            case 8: goto L41;
            case 9: goto L39;
            case 10: goto L37;
            case 11: goto L35;
            case 12: goto L33;
            case 13: goto L31;
            case 14: goto L29;
            case 15: goto L27;
            case 16: goto L25;
            case 17: goto L23;
            case 18: goto L21;
            case 19: goto L19;
            case 20: goto L17;
            case 21: goto L15;
            case 22: goto L13;
            case 23: goto L11;
            case 24: goto L9;
            case 25: goto L7;
            case 26: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "hex";
    L7:
        return ".";
    L9:
        return i.f25853b;
    L11:
        return "undefined";
    L13:
        return "TreeSet";
    L15:
        return "Set";
    L17:
        return "EOF";
    L19:
        return "fieldName";
    L21:
        return "ident";
    L23:
        return ":";
    L25:
        return ",";
    L27:
        return "]";
    L29:
        return "[";
    L31:
        return i.f25855d;
    L33:
        return "{";
    L35:
        return ")";
    L37:
        return "(";
    L39:
        return "new";
    L41:
        return "null";
    L43:
        return "false";
    L45:
        return "true";
    L47:
        return "iso8601";
    L49:
        return "string";
    L51:
        return "float";
    L53:
        return "int";
    L55:
        return "error";
    }
}
