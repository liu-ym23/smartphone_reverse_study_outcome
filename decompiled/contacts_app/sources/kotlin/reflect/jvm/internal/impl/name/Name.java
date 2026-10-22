package kotlin.reflect.jvm.internal.impl.name;

import obric.widget.search.data.SearchConfigTypeData;

/* JADX INFO: loaded from: classes4.dex */
public final class Name implements Comparable<Name> {
    private final String name;
    private final boolean special;

    private static /* synthetic */ void $$$reportNull$$$0(int r9) {
        if (r9 == 1) goto L8;
        if (r9 == 2) goto L8;
        if (r9 == 3) goto L8;
        if (r9 == 4) goto L8;
        String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r9 == 1) goto L14;
        if (r9 == 2) goto L14;
        if (r9 == 3) goto L14;
        if (r9 == 4) goto L14;
        int r5 = 3;
    L15:
        Object[] r6 = new Object[r5];
        if (r9 == 1) goto L21;
        if (r9 == 2) goto L21;
        if (r9 == 3) goto L21;
        if (r9 == 4) goto L21;
        r6[0] = "name";
    L22:
        if (r9 == 1) goto L29;
        if (r9 == 2) goto L28;
        if (r9 == 3) goto L27;
        if (r9 == 4) goto L27;
        r6[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
    L30:
        switch(r9) {
            case 1: goto L36;
            case 2: goto L36;
            case 3: goto L36;
            case 4: goto L36;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L33;
            case 8: goto L32;
            default: goto L31;
        };
    L31:
        r6[2] = "<init>";
        goto L36
    L32:
        r6[2] = "guessByFirstCharacter";
        goto L36
    L33:
        r6[2] = "special";
        goto L36
    L34:
        r6[2] = "isValidIdentifier";
        goto L36
    L35:
        r6[2] = SearchConfigTypeData.KEY_IDENTIFIER;
    L36:
        String r7 = String.format(r4, r6);
        if (r9 == 1) goto L43;
        if (r9 == 2) goto L43;
        if (r9 == 3) goto L43;
        if (r9 == 4) goto L43;
        throw new IllegalArgumentException(r7);
    L43:
        throw new IllegalStateException(r7);
    L27:
        r6[1] = "asStringStripSpecialMarkers";
        goto L30
    L28:
        r6[1] = "getIdentifier";
        goto L30
    L29:
        r6[1] = "asString";
    L21:
        r6[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
    L14:
        r5 = 2;
    L8:
        r4 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Name r1) {
        return compareTo2(r1);
    }

    private Name(String r2, boolean r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.name = r2;
        this.special = r3;
    }

    public String asString() {
        String r1 = this.name;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r1;
    }

    public String getIdentifier() {
        if (this.special == true) goto L9;
        String r3 = asString();
        if (r3 != null) goto L7;
        $$$reportNull$$$0(2);
    L7:
        return r3;
    L9:
        throw new IllegalStateException("not identifier: " + this);
    }

    public boolean isSpecial() {
        return this.special;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Name r1) {
        return this.name.compareTo(r1.name);
    }

    public static Name identifier(String r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return new Name(r2, false);
    }

    public static boolean isValidIdentifier(String r4) {
        if (r4 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        if (r4.isEmpty() == false) goto L7;
    L23:
        return false;
    L7:
        if (r4.startsWith("<") == true) goto L23;
        int r0 = 0;
    L11:
        if (r0 >= r4.length()) goto L21;
        char r2 = r4.charAt(r0);
        if (r2 == '.') goto L20;
        if (r2 == '/') goto L20;
        if (r2 == '\\') goto L20;
        r0 = r0 + 1;
    L20:
        return false;
    L21:
        return true;
    }

    public static Name special(String r3) {
        if (r3 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        if (r3.startsWith("<") == false) goto L9;
        return new Name(r3, true);
    L9:
        throw new IllegalArgumentException("special name must start with '<': " + r3);
    }

    public static Name guessByFirstCharacter(String r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        if (r1.startsWith("<") == false) goto L9;
        return special(r1);
    L9:
        return identifier(r1);
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Name) == true) goto L8;
        return false;
    L8:
        Name r6 = (Name) r5;
        if (this.special == r6.special) goto L12;
        return false;
    L12:
        if (this.name.equals(r6.name) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + (this.special ? 1 : 0);
    }
}
