package com.alibaba.fastjson.asm;

import ch.qos.logback.core.CoreConstants;

/* loaded from: classes.dex */
public class Type {
    private final char[] buf;
    private final int len;
    private final int off;
    protected final int sort;
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);

    private Type(int i4, char[] cArr, int i5, int i6) {
        this.sort = i4;
        this.buf = cArr;
        this.off = i5;
        this.len = i6;
    }

    public static Type[] getArgumentTypes(String str) {
        char[] charArray = str.toCharArray();
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        while (true) {
            int i7 = i5 + 1;
            char c4 = charArray[i5];
            if (c4 == ')') {
                break;
            }
            if (c4 == 'L') {
                while (true) {
                    i5 = i7 + 1;
                    if (charArray[i7] == ';') {
                        break;
                    }
                    i7 = i5;
                }
                i6++;
            } else {
                if (c4 != '[') {
                    i6++;
                }
                i5 = i7;
            }
        }
        Type[] typeArr = new Type[i6];
        int i8 = 0;
        while (charArray[i4] != ')') {
            Type type = getType(charArray, i4);
            typeArr[i8] = type;
            i4 += type.len + (type.sort == 10 ? 2 : 0);
            i8++;
        }
        return typeArr;
    }

    public static int getArgumentsAndReturnSizes(String str) {
        int i4;
        int i5 = 1;
        int i6 = 1;
        int i7 = 1;
        while (true) {
            i4 = i6 + 1;
            char cCharAt = str.charAt(i6);
            if (cCharAt == ')') {
                break;
            }
            if (cCharAt == 'L') {
                while (true) {
                    i6 = i4 + 1;
                    if (str.charAt(i4) == ';') {
                        break;
                    }
                    i4 = i6;
                }
                i7++;
            } else {
                i7 = (cCharAt == 'D' || cCharAt == 'J') ? i7 + 2 : i7 + 1;
                i6 = i4;
            }
        }
        char cCharAt2 = str.charAt(i4);
        int i8 = i7 << 2;
        if (cCharAt2 == 'V') {
            i5 = 0;
        } else if (cCharAt2 == 'D' || cCharAt2 == 'J') {
            i5 = 2;
        }
        return i8 | i5;
    }

    private int getDimensions() {
        int i4 = 1;
        while (this.buf[this.off + i4] == '[') {
            i4++;
        }
        return i4;
    }

    public static Type getType(String str) {
        return getType(str.toCharArray(), 0);
    }

    public String getClassName() {
        switch (this.sort) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuffer stringBuffer = new StringBuffer(getType(this.buf, this.off + getDimensions()).getClassName());
                for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                    stringBuffer.append("[]");
                }
                return stringBuffer.toString();
            default:
                return new String(this.buf, this.off, this.len).replace('/', CoreConstants.DOT);
        }
    }

    public String getDescriptor() {
        return new String(this.buf, this.off, this.len);
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }

    private static Type getType(char[] cArr, int i4) {
        char c4;
        char c5 = cArr[i4];
        if (c5 == 'F') {
            return FLOAT_TYPE;
        }
        if (c5 == 'S') {
            return SHORT_TYPE;
        }
        if (c5 == 'V') {
            return VOID_TYPE;
        }
        if (c5 == 'I') {
            return INT_TYPE;
        }
        if (c5 == 'J') {
            return LONG_TYPE;
        }
        if (c5 == 'Z') {
            return BOOLEAN_TYPE;
        }
        if (c5 != '[') {
            switch (c5) {
                case 'B':
                    return BYTE_TYPE;
                case 'C':
                    return CHAR_TYPE;
                case 'D':
                    return DOUBLE_TYPE;
                default:
                    int i5 = 1;
                    while (cArr[i4 + i5] != ';') {
                        i5++;
                    }
                    return new Type(10, cArr, i4 + 1, i5 - 1);
            }
        }
        int i6 = 1;
        while (true) {
            c4 = cArr[i4 + i6];
            if (c4 != '[') {
                break;
            }
            i6++;
        }
        if (c4 == 'L') {
            do {
                i6++;
            } while (cArr[i4 + i6] != ';');
        }
        return new Type(9, cArr, i4, i6 + 1);
    }
}
