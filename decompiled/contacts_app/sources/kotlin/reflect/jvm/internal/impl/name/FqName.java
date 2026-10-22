package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class FqName {
    public static final FqName ROOT = null;
    private final FqNameUnsafe fqName;
    private transient FqName parent;

    private static /* synthetic */ void $$$reportNull$$$0(int r7) {
        switch(r7) {
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L3;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r7) {
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r7) {
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L15;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L15;
            case 12: goto L13;
            case 13: goto L12;
            default: goto L11;
        };
    L11:
        r3[0] = "names";
    L18:
        switch(r7) {
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L23;
            case 8: goto L19;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            default: goto L19;
        };
    L19:
        r3[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
    L26:
        switch(r7) {
            case 1: goto L31;
            case 2: goto L31;
            case 3: goto L31;
            case 4: goto L32;
            case 5: goto L32;
            case 6: goto L32;
            case 7: goto L32;
            case 8: goto L30;
            case 9: goto L32;
            case 10: goto L32;
            case 11: goto L32;
            case 12: goto L29;
            case 13: goto L28;
            default: goto L27;
        };
    L27:
        r3[2] = "fromSegments";
        goto L32
    L28:
        r3[2] = "topLevel";
        goto L32
    L29:
        r3[2] = "startsWith";
        goto L32
    L30:
        r3[2] = "child";
        goto L32
    L31:
        r3[2] = "<init>";
    L32:
        String r1 = String.format(r0, r3);
        switch(r7) {
            case 4: goto L36;
            case 5: goto L36;
            case 6: goto L36;
            case 7: goto L36;
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L36;
            case 11: goto L36;
            default: goto L37;
        };
    L37:
        throw new IllegalArgumentException(r1);
    L36:
        throw new IllegalStateException(r1);
    L20:
        r3[1] = "pathSegments";
        goto L26
    L21:
        r3[1] = "shortNameOrSpecial";
        goto L26
    L22:
        r3[1] = "shortName";
        goto L26
    L23:
        r3[1] = "parent";
        goto L26
    L24:
        r3[1] = "toUnsafe";
        goto L26
    L25:
        r3[1] = "asString";
        goto L26
    L12:
        r3[0] = "shortName";
        goto L18
    L13:
        r3[0] = "segment";
        goto L18
    L14:
        r3[0] = "name";
        goto L18
    L15:
        r3[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
        goto L18
    L16:
        r3[0] = "fqName";
        goto L18
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
        ROOT = new FqName("");
    }

    public FqName(String r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        this.fqName = new FqNameUnsafe(r2, this);
    }

    public FqName(FqNameUnsafe r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        this.fqName = r2;
    }

    private FqName(FqNameUnsafe r2, FqName r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        this.fqName = r2;
        this.parent = r3;
    }

    public String asString() {
        String r1 = this.fqName.asString();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r1;
    }

    public FqNameUnsafe toUnsafe() {
        FqNameUnsafe r1 = this.fqName;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r1;
    }

    public boolean isRoot() {
        return this.fqName.isRoot();
    }

    public FqName parent() {
        FqName r0 = this.parent;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        $$$reportNull$$$0(6);
    L6:
        return r0;
    L8:
        if (isRoot() == true) goto L12;
        FqName r1 = new FqName(this.fqName.parent());
        this.parent = r1;
        return r1;
    L12:
        throw new IllegalStateException("root");
    }

    public FqName child(Name r3) {
        if (r3 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return new FqName(this.fqName.child(r3), this);
    }

    public Name shortName() {
        Name r1 = this.fqName.shortName();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r1;
    }

    public Name shortNameOrSpecial() {
        Name r1 = this.fqName.shortNameOrSpecial();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r1;
    }

    public List<Name> pathSegments() {
        List<Name> r1 = this.fqName.pathSegments();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r1;
    }

    public boolean startsWith(Name r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(12);
    L5:
        return this.fqName.startsWith(r2);
    }

    public static FqName topLevel(Name r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return new FqName(FqNameUnsafe.topLevel(r1));
    }

    public String toString() {
        return this.fqName.toString();
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof FqName) == true) goto L9;
        return false;
    L9:
        if (this.fqName.equals(((FqName) r4).fqName) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }
}
