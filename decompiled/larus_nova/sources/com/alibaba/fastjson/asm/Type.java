package com.alibaba.fastjson.asm;

import com.larus.bmhome.view.screenmenu.widget.ItemStyle;

/* JADX INFO: loaded from: classes28.dex */
public class Type {
    public static final Type BOOLEAN_TYPE = null;
    public static final Type BYTE_TYPE = null;
    public static final Type CHAR_TYPE = null;
    public static final Type DOUBLE_TYPE = null;
    public static final Type FLOAT_TYPE = null;
    public static final Type INT_TYPE = null;
    public static final Type LONG_TYPE = null;
    public static final Type SHORT_TYPE = null;
    public static final Type VOID_TYPE = null;
    private final char[] buf;
    private final int len;
    private final int off;
    protected final int sort;

    private int getDimensions() {
        int r100 = 1;
    L4:
        if (this.buf[this.off + r100] != '[') goto L6;
        r100 = r100 + 1;
        goto L4
    L6:
        return r100;
    }

    static {
        VOID_TYPE = new Type(0, null, 1443168256, 1);
        BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
        CHAR_TYPE = new Type(2, null, 1124075009, 1);
        BYTE_TYPE = new Type(3, null, 1107297537, 1);
        SHORT_TYPE = new Type(4, null, 1392510721, 1);
        INT_TYPE = new Type(5, null, 1224736769, 1);
        FLOAT_TYPE = new Type(6, null, 1174536705, 1);
        LONG_TYPE = new Type(7, null, 1241579778, 1);
        DOUBLE_TYPE = new Type(8, null, 1141048066, 1);
    }

    public String getClassName() {
        switch(this.sort) {
            case 0: goto L27;
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r100 = new StringBuilder(getType(this.buf, this.off + getDimensions()).getClassName());
        int r101 = getDimensions();
    L7:
        if (r101 <= 0) goto L10;
        r100.append("[]");
        r101 = r101 - 1;
        goto L7
    L10:
        return r100.toString();
    L11:
        return ItemStyle.ITEM_STYLE_DOUBLE;
    L13:
        return "long";
    L15:
        return "float";
    L17:
        return "int";
    L19:
        return "short";
    L21:
        return "byte";
    L23:
        return "char";
    L25:
        return "boolean";
    L27:
        return "void";
    L5:
        return new String(this.buf, this.off, this.len).replace('/', '.');
    }

    public String getDescriptor() {
        return new String(this.buf, this.off, this.len);
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }

    public static Type[] getArgumentTypes(String r100) {
        char[] r101 = r100.toCharArray();
        int r102 = 1;
        int r103 = 1;
        int r104 = 0;
    L3:
        int r105 = r103 + 1;
        char r106 = r101[r103];
        if (r106 == ')') goto L5;
        if (r106 == 'L') goto L16;
        if (r106 == '[') goto L23;
        r104 = r104 + 1;
    L23:
        r103 = r105;
    L16:
        r103 = r105 + 1;
        if (r101[r105] == ';') goto L19;
        r105 = r103;
        goto L16
    L19:
        r104 = r104 + 1;
        goto L3
    L5:
        Type[] r107 = new Type[r104];
        int r108 = 0;
    L7:
        if (r101[r102] == ')') goto L13;
        Type r109 = getType(r101, r102);
        r107[r108] = r109;
        int r110 = r109.len;
        if (r109.sort != 10) goto L11;
        int r111 = 2;
    L12:
        r102 = r102 + (r110 + r111);
        r108 = r108 + 1;
        goto L7
    L11:
        r111 = 0;
        goto L12
    L13:
        return r107;
    }

    public static int getArgumentsAndReturnSizes(String r100) {
        int r101 = 1;
        int r102 = 1;
        int r103 = 1;
    L3:
        int r104 = r102 + 1;
        char r105 = r100.charAt(r102);
        if (r105 == ')') goto L5;
        if (r105 == 'L') goto L15;
        if (r105 == 'D') goto L23;
        if (r105 == 'J') goto L23;
        r103 = r103 + 1;
    L24:
        r102 = r104;
    L23:
        r103 = r103 + 2;
    L15:
        r102 = r104 + 1;
        if (r100.charAt(r104) == ';') goto L18;
        r104 = r102;
        goto L15
    L18:
        r103 = r103 + 1;
        goto L3
    L5:
        char r106 = r100.charAt(r104);
        int r107 = r103 << 2;
        if (r106 != 'V') goto L8;
        r101 = 0;
    L12:
        return r107 | r101;
    L8:
        if (r106 == 'D') goto L10;
        if (r106 != 'J') goto L12;
    L10:
        r101 = 2;
        goto L12
    }

    public static Type getType(String r100) {
        return getType(r100.toCharArray(), 0);
    }

    private static Type getType(char[] r100, int r101) {
        char r102 = r100[r101];
        if (r102 == 'F') goto L51;
        if (r102 == 'S') goto L49;
        if (r102 == 'V') goto L47;
        if (r102 == 'I') goto L45;
        if (r102 == 'J') goto L43;
        if (r102 == 'Z') goto L41;
        if (r102 == '[') goto L29;
        switch(r102) {
            case 66: goto L28;
            case 67: goto L26;
            case 68: goto L24;
            default: goto L17;
        };
    L17:
        int r103 = 1;
    L19:
        if (r100[r101 + r103] == ';') goto L22;
        r103 = r103 + 1;
        goto L19
    L22:
        return new Type(10, r100, r101 + 1, r103 - 1);
    L24:
        return DOUBLE_TYPE;
    L26:
        return CHAR_TYPE;
    L28:
        return BYTE_TYPE;
    L29:
        int r104 = 1;
    L30:
        char r105 = r100[r101 + r104];
        if (r105 != '[') goto L34;
        r104 = r104 + 1;
        goto L30
    L34:
        if (r105 != 'L') goto L39;
    L35:
        r104 = r104 + 1;
        if (r100[r101 + r104] != ';') goto L35;
    L39:
        return new Type(9, r100, r101, r104 + 1);
    L41:
        return BOOLEAN_TYPE;
    L43:
        return LONG_TYPE;
    L45:
        return INT_TYPE;
    L47:
        return VOID_TYPE;
    L49:
        return SHORT_TYPE;
    L51:
        return FLOAT_TYPE;
    }

    private Type(int r100, char[] r101, int r102, int r103) {
        this.sort = r100;
        this.buf = r101;
        this.off = r102;
        this.len = r103;
    }
}
