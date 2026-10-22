package com.obric.oui.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes3.dex */
public class CLToken extends CLElement {
    int mIndex;
    char[] mTokenFalse;
    char[] mTokenNull;
    char[] mTokenTrue;
    Type mType;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.parser.CLToken$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$constraintlayout$core$parser$CLToken$Type = null;

        static {
            int[] r0 = new int[Type.values().length];
            $SwitchMap$com$obric$oui$constraintlayout$core$parser$CLToken$Type = r0;
            r0[Type.TRUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$oui$constraintlayout$core$parser$CLToken$Type[Type.FALSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$oui$constraintlayout$core$parser$CLToken$Type[Type.NULL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$oui$constraintlayout$core$parser$CLToken$Type[Type.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type FALSE = null;
        public static final Type NULL = null;
        public static final Type TRUE = null;
        public static final Type UNKNOWN = null;

        static {
            Type r0 = new Type("UNKNOWN", 0);
            UNKNOWN = r0;
            Type r1 = new Type("TRUE", 1);
            TRUE = r1;
            Type r3 = new Type("FALSE", 2);
            FALSE = r3;
            Type r5 = new Type("NULL", 3);
            NULL = r5;
            $VALUES = new Type[]{r0, r1, r3, r5};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public boolean getBoolean() throws CLParsingException {
        if (this.mType != Type.TRUE) goto L7;
        return true;
    L7:
        if (this.mType != Type.FALSE) goto L11;
        return false;
    L11:
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public boolean isNull() throws CLParsingException {
        if (this.mType != Type.NULL) goto L7;
        return true;
    L7:
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    public CLToken(char[] r1) {
        super(r1);
        this.mIndex = 0;
        this.mType = Type.UNKNOWN;
        this.mTokenTrue = "true".toCharArray();
        this.mTokenFalse = "false".toCharArray();
        this.mTokenNull = "null".toCharArray();
    }

    public static CLElement allocate(char[] r1) {
        return new CLToken(r1);
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        if (CLParser.sDebug == false) goto L7;
        return "<" + content() + ">";
    L7:
        return content();
    }

    @Override // com.obric.oui.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int r1, int r2) {
        StringBuilder r3 = new StringBuilder();
        addIndent(r3, r1);
        r3.append(content());
        return r3.toString();
    }

    public Type getType() {
        return this.mType;
    }

    public boolean validate(char r6, long r7) {
        int r0 = AnonymousClass1.$SwitchMap$com$obric$oui$constraintlayout$core$parser$CLToken$Type[this.mType.ordinal()];
        boolean r2 = false;
        if (r0 != 1) goto L5;
        char[] r1 = this.mTokenTrue;
        int r3 = this.mIndex;
        if (r1[r3] != r6) goto L38;
        r2 = true;
    L38:
        if (r2 == true) goto L40;
    L42:
        this.mIndex++;
        return r2;
    L40:
        if ((r3 + 1) != r1.length) goto L42;
        setEnd(r7);
        goto L42
    L5:
        if (r0 != 2) goto L7;
        char[] r4 = this.mTokenFalse;
        int r5 = this.mIndex;
        if (r4[r5] != r6) goto L31;
        r2 = true;
    L31:
        if (r2 == false) goto L42;
        if ((r5 + 1) != r4.length) goto L42;
        setEnd(r7);
        goto L42
    L7:
        if (r0 != 3) goto L9;
        char[] r8 = this.mTokenNull;
        int r9 = this.mIndex;
        if (r8[r9] != r6) goto L24;
        r2 = true;
    L24:
        if (r2 == false) goto L42;
        if ((r9 + 1) != r8.length) goto L42;
        setEnd(r7);
        goto L42
    L9:
        if (r0 != 4) goto L42;
        char[] r10 = this.mTokenTrue;
        int r11 = this.mIndex;
        if (r10[r11] != r6) goto L16;
        this.mType = Type.TRUE;
    L14:
        r2 = true;
        goto L42
    L16:
        if (this.mTokenFalse[r11] != r6) goto L19;
        this.mType = Type.FALSE;
        goto L14
    L19:
        if (this.mTokenNull[r11] != r6) goto L42;
        this.mType = Type.NULL;
        goto L14
    }
}
