package com.alibaba.fastjson;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public abstract class JSONValidator implements Cloneable, Closeable {

    /* JADX INFO: renamed from: ch, reason: collision with root package name */
    protected char f24928ch;
    protected int count;
    protected boolean eof;
    protected int pos;
    protected boolean supportMultiValue;
    protected Type type;
    private Boolean validateResult;

    public static class ReaderValidator extends JSONValidator {
        private static final ThreadLocal<char[]> bufLocal = null;
        private char[] buf;
        private int end;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        final Reader f24929r;
        private int readCount;

        static {
            bufLocal = new ThreadLocal();
        }

        @Override // com.alibaba.fastjson.JSONValidator, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.f24929r.close();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            int r100 = this.pos;
            if (r100 >= this.end) goto L6;
            char[] r101 = this.buf;
            int r102 = r100 + 1;
            this.pos = r102;
            this.f24928ch = r101[r102];
            return;
        L6:
            if (this.eof == true) goto L20;
            Reader r103 = this.f24929r;     // Catch: IOException -> L15
            char[] r104 = this.buf;     // Catch: IOException -> L15
            int r105 = r103.read(r104, 0, r104.length);     // Catch: IOException -> L15
            this.readCount++;     // Catch: IOException -> L15
            if (r105 <= 0) goto L11;
            this.f24928ch = this.buf[0];
            this.pos = 0;
            this.end = r105 - 1;
            return;
        L11:
            if (r105 != (-1)) goto L13;
            this.pos = 0;
            this.end = 0;
            this.buf = null;
            this.f24928ch = 0;
            this.eof = true;
            return;
        L13:
            this.pos = 0;
            this.end = 0;
            this.buf = null;
            this.f24928ch = 0;
            this.eof = true;
            throw new JSONException("read error");
        L16:
            throw new JSONException("read error");
        }

        public ReaderValidator(Reader r100) {
            this.end = -1;
            this.readCount = 0;
            this.f24929r = r100;
            ThreadLocal<char[]> r101 = bufLocal;
            char[] r102 = r101.get();
            this.buf = r102;
            if (r102 == null) goto L5;
            r101.set(null);
        L6:
            next();
            skipWhiteSpace();
            return;
        L5:
            this.buf = new char[8192];
            goto L6
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type Array = null;
        public static final Type Object = null;
        public static final Type Value = null;

        static {
            Type r100 = new Type("Object", 0);
            Object = r100;
            Type r101 = new Type("Array", 1);
            Array = r101;
            Type r102 = new Type("Value", 2);
            Value = r102;
            $VALUES = new Type[]{r100, r101, r102};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class UTF16Validator extends JSONValidator {
        private final String str;

        @Override // com.alibaba.fastjson.JSONValidator
        public final void fieldName() {
            int r100 = this.pos;
        L3:
            r100 = r100 + 1;
            if (r100 >= this.str.length()) goto L11;
            char r101 = this.str.charAt(r100);
            if (r101 == '\\') goto L11;
            if (r101 != '\"') goto L3;
            int r102 = r100 + 1;
            this.f24928ch = this.str.charAt(r102);
            this.pos = r102;
            return;
        L11:
            next();
        L12:
            char r103 = this.f24928ch;
            if (r103 == '\\') goto L14;
            if (r103 == '\"') goto L19;
            if (this.eof == true) goto L38;
            next();
            goto L12
        L38:
            return;
        L19:
            next();
            return;
        L14:
            next();
            if (this.f24928ch == 'u') goto L16;
            next();
            goto L12
        L16:
            next();
            next();
            next();
            next();
            next();
            goto L12
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            int r100 = this.pos + 1;
            this.pos = r100;
            if (r100 < this.str.length()) goto L5;
            this.f24928ch = 0;
            this.eof = true;
            return;
        L5:
            this.f24928ch = this.str.charAt(this.pos);
        }

        public UTF16Validator(String r100) {
            this.str = r100;
            next();
            skipWhiteSpace();
        }
    }

    public static class UTF8InputStreamValidator extends JSONValidator {
        private static final ThreadLocal<byte[]> bufLocal = null;
        private byte[] buf;
        private int end;

        /* JADX INFO: renamed from: is, reason: collision with root package name */
        private final InputStream f24930is;
        private int readCount;

        static {
            bufLocal = new ThreadLocal();
        }

        @Override // com.alibaba.fastjson.JSONValidator, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            bufLocal.set(this.buf);
            this.f24930is.close();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            int r100 = this.pos;
            if (r100 >= this.end) goto L6;
            byte[] r101 = this.buf;
            int r102 = r100 + 1;
            this.pos = r102;
            this.f24928ch = (char) r101[r102];
            return;
        L6:
            if (this.eof == true) goto L20;
            InputStream r103 = this.f24930is;     // Catch: IOException -> L15
            byte[] r104 = this.buf;     // Catch: IOException -> L15
            int r105 = r103.read(r104, 0, r104.length);     // Catch: IOException -> L15
            this.readCount++;     // Catch: IOException -> L15
            if (r105 <= 0) goto L11;
            this.f24928ch = (char) this.buf[0];
            this.pos = 0;
            this.end = r105 - 1;
            return;
        L11:
            if (r105 != (-1)) goto L13;
            this.pos = 0;
            this.end = 0;
            this.buf = null;
            this.f24928ch = 0;
            this.eof = true;
            return;
        L13:
            this.pos = 0;
            this.end = 0;
            this.buf = null;
            this.f24928ch = 0;
            this.eof = true;
            throw new JSONException("read error");
        L16:
            throw new JSONException("read error");
        }

        public UTF8InputStreamValidator(InputStream r100) {
            this.end = -1;
            this.readCount = 0;
            this.f24930is = r100;
            ThreadLocal<byte[]> r101 = bufLocal;
            byte[] r102 = r101.get();
            this.buf = r102;
            if (r102 == null) goto L5;
            r101.set(null);
        L6:
            next();
            skipWhiteSpace();
            return;
        L5:
            this.buf = new byte[8192];
            goto L6
        }
    }

    public static class UTF8Validator extends JSONValidator {
        private final byte[] bytes;

        @Override // com.alibaba.fastjson.JSONValidator
        public void next() {
            int r100 = this.pos + 1;
            this.pos = r100;
            byte[] r101 = this.bytes;
            if (r100 < r101.length) goto L5;
            this.f24928ch = 0;
            this.eof = true;
            return;
        L5:
            this.f24928ch = (char) r101[r100];
        }

        public UTF8Validator(byte[] r100) {
            this.bytes = r100;
            next();
            skipWhiteSpace();
        }
    }

    public static final boolean isWhiteSpace(char r100) {
        if (r100 != ' ') goto L5;
    L16:
        return true;
    L5:
        if (r100 == '\t') goto L16;
        if (r100 == '\r') goto L16;
        if (r100 == '\n') goto L16;
        if (r100 == '\f') goto L16;
        if (r100 == '\b') goto L16;
        return false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public abstract void next();

    private boolean any() {
        char r100 = this.f24928ch;
        if (r100 != '\"') goto L5;
        next();
    L160:
        if (this.eof == true) goto L161;
        char r101 = this.f24928ch;
        if (r101 == '\\') goto L164;
        if (r101 == '\"') goto L169;
        next();
        goto L160
    L169:
        next();
        this.type = Type.Value;
        return true;
    L164:
        next();
        if (this.f24928ch == 'u') goto L166;
        next();
        goto L160
    L166:
        next();
        next();
        next();
        next();
        next();
        goto L160
    L161:
        return false;
    L5:
        if (r100 == '+') goto L119;
        if (r100 == '-') goto L119;
        if (r100 != '[') goto L10;
        next();
        skipWhiteSpace();
        if (this.f24928ch != ']') goto L109;
        next();
        this.type = Type.Array;
        return true;
    L109:
        if (any() == false) goto L110;
        skipWhiteSpace();
        char r102 = this.f24928ch;
        if (r102 != ',') goto L114;
        next();
        skipWhiteSpace();
        goto L109
    L114:
        if (r102 != ']') goto L117;
        next();
        this.type = Type.Array;
        return true;
    L117:
        return false;
    L110:
        return false;
    L10:
        if (r100 != 'f') goto L12;
        next();
        if (this.f24928ch == 'a') goto L84;
        return false;
    L84:
        next();
        if (this.f24928ch == 'l') goto L87;
        return false;
    L87:
        next();
        if (this.f24928ch == 's') goto L90;
        return false;
    L90:
        next();
        if (this.f24928ch == 'e') goto L93;
        return false;
    L93:
        next();
        if (isWhiteSpace(this.f24928ch) == true) goto L102;
        char r103 = this.f24928ch;
        if (r103 == ',') goto L102;
        if (r103 == ']') goto L102;
        if (r103 == '}') goto L102;
        if (r103 == 0) goto L102;
        return false;
    L102:
        this.type = Type.Value;
        return true;
    L12:
        if (r100 != 'n') goto L14;
        next();
        if (this.f24928ch == 'u') goto L64;
        return false;
    L64:
        next();
        if (this.f24928ch == 'l') goto L67;
        return false;
    L67:
        next();
        if (this.f24928ch == 'l') goto L70;
        return false;
    L70:
        next();
        if (isWhiteSpace(this.f24928ch) == true) goto L79;
        char r104 = this.f24928ch;
        if (r104 == ',') goto L79;
        if (r104 == ']') goto L79;
        if (r104 == '}') goto L79;
        if (r104 == 0) goto L79;
        return false;
    L79:
        this.type = Type.Value;
        return true;
    L14:
        if (r100 != 't') goto L16;
        next();
        if (this.f24928ch == 'r') goto L44;
        return false;
    L44:
        next();
        if (this.f24928ch == 'u') goto L47;
        return false;
    L47:
        next();
        if (this.f24928ch == 'e') goto L50;
        return false;
    L50:
        next();
        if (isWhiteSpace(this.f24928ch) == true) goto L59;
        char r105 = this.f24928ch;
        if (r105 == ',') goto L59;
        if (r105 == ']') goto L59;
        if (r105 == '}') goto L59;
        if (r105 == 0) goto L59;
        return false;
    L59:
        this.type = Type.Value;
        return true;
    L16:
        if (r100 == '{') goto L19;
        switch(r100) {
            case 48: goto L119;
            case 49: goto L119;
            case 50: goto L119;
            case 51: goto L119;
            case 52: goto L119;
            case 53: goto L119;
            case 54: goto L119;
            case 55: goto L119;
            case 56: goto L119;
            case 57: goto L119;
            default: goto L18;
        };
    L18:
        return false;
    L19:
        next();
    L21:
        if (isWhiteSpace(this.f24928ch) == false) goto L24;
        next();
        goto L21
    L24:
        if (this.f24928ch != '}') goto L28;
        next();
        this.type = Type.Object;
        return true;
    L28:
        if (this.f24928ch != '\"') goto L40;
        fieldName();
        skipWhiteSpace();
        if (this.f24928ch != ':') goto L40;
        next();
        skipWhiteSpace();
        if (any() == false) goto L33;
        skipWhiteSpace();
        char r106 = this.f24928ch;
        if (r106 != ',') goto L37;
        next();
        skipWhiteSpace();
        goto L28
    L37:
        if (r106 != '}') goto L40;
        next();
        this.type = Type.Object;
        return true;
    L33:
        return false;
    L40:
        return false;
    L119:
        if (r100 == '-') goto L121;
        if (r100 == '+') goto L121;
    L125:
        next();
        char r107 = this.f24928ch;
        if (r107 < '0') goto L129;
        if (r107 <= '9') goto L125;
    L129:
        if (r107 != '.') goto L139;
        next();
        char r108 = this.f24928ch;
        if (r108 < '0') goto L138;
        if (r108 > '9') goto L138;
    L134:
        char r109 = this.f24928ch;
        if (r109 < '0') goto L139;
        if (r109 > '9') goto L139;
        next();
    L138:
        return false;
    L139:
        char r110 = this.f24928ch;
        if (r110 != 'e') goto L142;
    L143:
        next();
        char r111 = this.f24928ch;
        if (r111 == '-') goto L146;
        if (r111 == '+') goto L146;
    L147:
        char r112 = this.f24928ch;
        if (r112 < '0') goto L157;
        if (r112 > '9') goto L157;
        next();
    L151:
        char r113 = this.f24928ch;
        if (r113 < '0') goto L155;
        if (r113 > '9') goto L155;
        next();
    L155:
        this.type = Type.Value;
        return true;
    L157:
        return false;
    L146:
        next();
        goto L147
    L142:
        if (r110 != 'E') goto L155;
    L121:
        next();
        skipWhiteSpace();
        char r114 = this.f24928ch;
        if (r114 < '0') goto L157;
        if (r114 <= '9') goto L125;
        goto L157
    }

    public Type getType() {
        if (this.type != null) goto L6;
        validate();
    L6:
        return this.type;
    }

    public void skipWhiteSpace() {
    L3:
        if (isWhiteSpace(this.f24928ch) == false) goto L5;
        next();
        goto L3
    }

    public boolean validate() {
        Boolean r100 = this.validateResult;
        if (r100 == null) goto L7;
        return r100.booleanValue();
    L7:
        if (any() == false) goto L8;
        skipWhiteSpace();
        this.count++;
        if (this.eof == true) goto L12;
        if (this.supportMultiValue == false) goto L20;
        skipWhiteSpace();
        if (this.eof == false) goto L7;
        this.validateResult = Boolean.TRUE;
        return true;
    L20:
        this.validateResult = Boolean.FALSE;
        return false;
    L12:
        this.validateResult = Boolean.TRUE;
        return true;
    L8:
        this.validateResult = Boolean.FALSE;
        return false;
    }

    public JSONValidator() {
        this.pos = -1;
        this.count = 0;
        this.supportMultiValue = false;
    }

    public void fieldName() {
        next();
    L3:
        char r100 = this.f24928ch;
        if (r100 == '\\') goto L5;
        if (r100 == '\"') goto L11;
        next();
        goto L3
    L11:
        next();
        return;
    L5:
        next();
        if (this.f24928ch == 'u') goto L7;
        next();
        goto L3
    L7:
        next();
        next();
        next();
        next();
        next();
        goto L3
    }

    public boolean string() {
        next();
    L4:
        if (this.eof == true) goto L16;
        char r100 = this.f24928ch;
        if (r100 == '\\') goto L7;
        if (r100 == '\"') goto L13;
        next();
        goto L4
    L13:
        next();
        return true;
    L7:
        next();
        if (this.f24928ch == 'u') goto L9;
        next();
        goto L4
    L9:
        next();
        next();
        next();
        next();
        next();
        goto L4
    L16:
        return false;
    }

    public boolean isSupportMultiValue() {
        return this.supportMultiValue;
    }

    public static JSONValidator from(Reader r100) {
        return new ReaderValidator(r100);
    }

    public static JSONValidator fromUtf8(InputStream r100) {
        return new UTF8InputStreamValidator(r100);
    }

    public JSONValidator setSupportMultiValue(boolean r100) {
        this.supportMultiValue = r100;
        return this;
    }

    public static JSONValidator from(String r100) {
        return new UTF16Validator(r100);
    }

    public static JSONValidator fromUtf8(byte[] r100) {
        return new UTF8Validator(r100);
    }
}
