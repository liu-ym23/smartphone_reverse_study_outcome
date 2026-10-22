package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import com.bytedance.librarian.LibrarianImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
public class JvmClassName {
    private FqName fqName;
    private final String internalName;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 3) goto L8;
        if (r10 == 6) goto L8;
        if (r10 == 7) goto L8;
        if (r10 == 8) goto L8;
        String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r10 == 3) goto L15;
        if (r10 == 6) goto L15;
        if (r10 == 7) goto L15;
        if (r10 == 8) goto L15;
        int r6 = 3;
    L16:
        Object[] r7 = new Object[r6];
        switch(r10) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L19;
            case 7: goto L19;
            case 8: goto L19;
            default: goto L18;
        };
    L18:
        r7[0] = "internalName";
    L23:
        if (r10 == 3) goto L31;
        if (r10 == 6) goto L30;
        if (r10 == 7) goto L29;
        if (r10 == 8) goto L28;
        r7[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
    L32:
        switch(r10) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L37;
            case 7: goto L37;
            case 8: goto L37;
            default: goto L33;
        };
    L33:
        r7[2] = "byInternalName";
        goto L37
    L34:
        r7[2] = "<init>";
        goto L37
    L35:
        r7[2] = "byFqNameWithoutInnerClasses";
        goto L37
    L36:
        r7[2] = "byClassId";
    L37:
        String r5 = String.format(r4, r7);
        if (r10 == 3) goto L44;
        if (r10 == 6) goto L44;
        if (r10 == 7) goto L44;
        if (r10 == 8) goto L44;
        throw new IllegalArgumentException(r5);
    L44:
        throw new IllegalStateException(r5);
    L28:
        r7[1] = "getInternalName";
        goto L32
    L29:
        r7[1] = "getPackageFqName";
        goto L32
    L30:
        r7[1] = "getFqNameForClassNameWithoutDollars";
        goto L32
    L31:
        r7[1] = "byFqNameWithoutInnerClasses";
        goto L32
    L19:
        r7[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        goto L23
    L20:
        r7[0] = "fqName";
        goto L23
    L21:
        r7[0] = "classId";
    L15:
        r6 = 2;
    L8:
        r4 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    public static JvmClassName byInternalName(String r1) {
        if (r1 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return new JvmClassName(r1);
    }

    public static JvmClassName byClassId(ClassId r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        FqName r0 = r5.getPackageFqName();
        String r6 = r5.getRelativeClassName().asString().replace('.', Typography.dollar);
        if (r0.isRoot() == false) goto L8;
        return new JvmClassName(r6);
    L8:
        return new JvmClassName(r0.asString().replace('.', '/') + LibrarianImpl.Constants.SEPARATOR + r6);
    }

    public static JvmClassName byFqNameWithoutInnerClasses(FqName r4) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        JvmClassName r0 = new JvmClassName(r4.asString().replace('.', '/'));
        r0.fqName = r4;
        return r0;
    }

    private JvmClassName(String r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        this.internalName = r2;
    }

    public FqName getFqNameForTopLevelClassMaybeWithDollars() {
        return new FqName(this.internalName.replace('/', '.'));
    }

    public FqName getPackageFqName() {
        int r0 = this.internalName.lastIndexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r0 != (-1)) goto L9;
        FqName r3 = FqName.ROOT;
        if (r3 != null) goto L7;
        $$$reportNull$$$0(7);
    L7:
        return r3;
    L9:
        return new FqName(this.internalName.substring(0, r0).replace('/', '.'));
    }

    public String getInternalName() {
        String r1 = this.internalName;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r1;
    }

    public String toString() {
        return this.internalName;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return this.internalName.equals(((JvmClassName) r3).internalName);
    }

    public int hashCode() {
        return this.internalName.hashCode();
    }
}
