package kotlin.reflect.jvm.internal.impl.name;

import com.bytedance.librarian.LibrarianImpl;

/* JADX INFO: loaded from: classes4.dex */
public final class ClassId {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean local;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 5) goto L9;
        if (r10 == 6) goto L9;
        if (r10 == 7) goto L9;
        if (r10 == 9) goto L9;
        switch(r10) {
            case 13: goto L9;
            case 14: goto L9;
            case 15: goto L9;
            case 16: goto L9;
            default: goto L8;
        };
    L8:
        String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L11:
        if (r10 == 5) goto L17;
        if (r10 == 6) goto L56;
        if (r10 == 7) goto L57;
        if (r10 == 9) goto L58;
        switch(r10) {
            case 13: goto L59;
            case 14: goto L59;
            case 15: goto L59;
            case 16: goto L59;
            default: goto L16;
        };
    L16:
        int r6 = 3;
    L18:
        Object[] r7 = new Object[r6];
        switch(r10) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L24;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L24;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L21;
            case 13: goto L24;
            case 14: goto L24;
            case 15: goto L24;
            case 16: goto L24;
            default: goto L20;
        };
    L20:
        r7[0] = "topLevelFqName";
    L29:
        if (r10 == 5) goto L40;
        if (r10 == 6) goto L39;
        if (r10 == 7) goto L38;
        if (r10 == 9) goto L37;
        switch(r10) {
            case 13: goto L36;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L35;
            default: goto L34;
        };
    L34:
        r7[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
    L41:
        switch(r10) {
            case 1: goto L46;
            case 2: goto L46;
            case 3: goto L46;
            case 4: goto L46;
            case 5: goto L47;
            case 6: goto L47;
            case 7: goto L47;
            case 8: goto L45;
            case 9: goto L47;
            case 10: goto L44;
            case 11: goto L43;
            case 12: goto L43;
            case 13: goto L47;
            case 14: goto L47;
            case 15: goto L47;
            case 16: goto L47;
            default: goto L42;
        };
    L42:
        r7[2] = "topLevel";
        goto L47
    L43:
        r7[2] = "fromString";
        goto L47
    L44:
        r7[2] = "startsWith";
        goto L47
    L45:
        r7[2] = "createNestedClassId";
        goto L47
    L46:
        r7[2] = "<init>";
    L47:
        String r5 = String.format(r4, r7);
        if (r10 == 5) goto L55;
        if (r10 == 6) goto L55;
        if (r10 == 7) goto L55;
        if (r10 == 9) goto L55;
        switch(r10) {
            case 13: goto L55;
            case 14: goto L55;
            case 15: goto L55;
            case 16: goto L55;
            default: goto L60;
        };
    L60:
        throw new IllegalArgumentException(r5);
    L55:
        throw new IllegalStateException(r5);
    L35:
        r7[1] = "asFqNameString";
        goto L41
    L36:
        r7[1] = "asString";
        goto L41
    L37:
        r7[1] = "asSingleFqName";
        goto L41
    L38:
        r7[1] = "getShortClassName";
        goto L41
    L39:
        r7[1] = "getRelativeClassName";
        goto L41
    L40:
        r7[1] = "getPackageFqName";
        goto L41
    L21:
        r7[0] = "string";
        goto L29
    L22:
        r7[0] = "segment";
        goto L29
    L23:
        r7[0] = "name";
        goto L29
    L24:
        r7[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        goto L29
    L25:
        r7[0] = "topLevelName";
        goto L29
    L26:
        r7[0] = "relativeClassName";
        goto L29
    L27:
        r7[0] = "packageFqName";
        goto L29
    L59:
        r6 = 2;
        goto L18
    L58:
        r6 = 2;
        goto L18
    L57:
        r6 = 2;
        goto L18
    L56:
        r6 = 2;
        goto L18
    L17:
        r6 = 2;
    L9:
        r4 = "@NotNull method %s.%s must not return null";
        goto L11
    }

    static {
    }

    public static ClassId topLevel(FqName r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new ClassId(r2.parent(), r2.shortName());
    }

    public ClassId(FqName r2, FqName r3, boolean r4) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(2);
    L6:
        this.packageFqName = r2;
        this.relativeClassName = r3;
        this.local = r4;
    }

    public ClassId(FqName r2, Name r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(4);
    L6:
        this(r2, FqName.topLevel(r3), false);
    }

    public FqName getPackageFqName() {
        FqName r1 = this.packageFqName;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r1;
    }

    public FqName getRelativeClassName() {
        FqName r1 = this.relativeClassName;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r1;
    }

    public Name getShortClassName() {
        Name r1 = this.relativeClassName.shortName();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r1;
    }

    public boolean isLocal() {
        return this.local;
    }

    public ClassId createNestedClassId(Name r4) {
        if (r4 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return new ClassId(getPackageFqName(), this.relativeClassName.child(r4), this.local);
    }

    public ClassId getOuterClassId() {
        FqName r0 = this.relativeClassName.parent();
        if (r0.isRoot() == false) goto L6;
        return null;
    L6:
        return new ClassId(getPackageFqName(), r0, this.local);
    }

    public boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public FqName asSingleFqName() {
        if (this.packageFqName.isRoot() == false) goto L9;
        FqName r3 = this.relativeClassName;
        if (r3 != null) goto L7;
        $$$reportNull$$$0(9);
    L7:
        return r3;
    L9:
        return new FqName(this.packageFqName.asString() + LibrarianImpl.Constants.DOT + this.relativeClassName.asString());
    }

    public static ClassId fromString(String r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return fromString(r1, false);
    }

    public static ClassId fromString(String r4, boolean r5) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        int r0 = r4.lastIndexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r0 != (-1)) goto L7;
        String r1 = "";
    L9:
        return new ClassId(new FqName(r1), new FqName(r4), r5);
    L7:
        String r2 = r4.substring(0, r0).replace('/', '.');
        r4 = r4.substring(r0 + 1);
        r1 = r2;
        goto L9
    }

    public String asString() {
        if (this.packageFqName.isRoot() == false) goto L8;
        String r4 = this.relativeClassName.asString();
        if (r4 != null) goto L7;
        $$$reportNull$$$0(13);
    L7:
        return r4;
    L8:
        String r5 = this.packageFqName.asString().replace('.', '/') + LibrarianImpl.Constants.SEPARATOR + this.relativeClassName.asString();
        if (r5 != null) goto L11;
        $$$reportNull$$$0(14);
    L11:
        return r5;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        ClassId r6 = (ClassId) r5;
        if (this.packageFqName.equals(r6.packageFqName) == false) goto L18;
        if (this.relativeClassName.equals(r6.relativeClassName) == false) goto L18;
        if (this.local != r6.local) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31) + Boolean.valueOf(this.local).hashCode();
    }

    public String toString() {
        if (this.packageFqName.isRoot() == false) goto L6;
        return LibrarianImpl.Constants.SEPARATOR + asString();
    L6:
        return asString();
    }
}
