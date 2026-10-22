package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.contacts.util.HanziToPinyin;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DeclarationDescriptorImpl extends AnnotatedImpl implements DeclarationDescriptor {
    private final Name name;

    private static /* synthetic */ void $$$reportNull$$$0(int r9) {
        if (r9 == 2) goto L8;
        if (r9 == 3) goto L8;
        if (r9 == 5) goto L8;
        if (r9 == 6) goto L8;
        String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r9 == 2) goto L14;
        if (r9 == 3) goto L14;
        if (r9 == 5) goto L14;
        if (r9 == 6) goto L14;
        int r5 = 3;
    L15:
        Object[] r6 = new Object[r5];
        switch(r9) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L19;
            case 6: goto L19;
            default: goto L17;
        };
    L17:
        r6[0] = "annotations";
    L22:
        if (r9 == 2) goto L29;
        if (r9 == 3) goto L28;
        if (r9 == 5) goto L27;
        if (r9 == 6) goto L27;
        r6[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
    L30:
        if (r9 == 2) goto L38;
        if (r9 == 3) goto L38;
        if (r9 == 4) goto L37;
        if (r9 == 5) goto L38;
        if (r9 == 6) goto L38;
        r6[2] = "<init>";
        goto L38
    L37:
        r6[2] = "toString";
    L38:
        String r7 = String.format(r4, r6);
        if (r9 == 2) goto L45;
        if (r9 == 3) goto L45;
        if (r9 == 5) goto L45;
        if (r9 == 6) goto L45;
        throw new IllegalArgumentException(r7);
    L45:
        throw new IllegalStateException(r7);
    L27:
        r6[1] = "toString";
        goto L30
    L28:
        r6[1] = "getOriginal";
        goto L30
    L29:
        r6[1] = "getName";
        goto L30
    L18:
        r6[0] = "descriptor";
        goto L22
    L19:
        r6[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        goto L22
    L20:
        r6[0] = "name";
    L14:
        r5 = 2;
    L8:
        r4 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public DeclarationDescriptor getOriginal() {
        return this;
    }

    public DeclarationDescriptorImpl(Annotations r2, Name r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        super(r2);
        this.name = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public Name getName() {
        Name r1 = this.name;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return r1;
    }

    public String toString() {
        return toString(this);
    }

    public static String toString(DeclarationDescriptor r2) {
        if (r2 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        String r3 = DescriptorRenderer.DEBUG_TEXT.render(r2) + "[" + r2.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(r2)) + "]";     // Catch: Throwable -> L8
        if (r3 != null) goto L7;
        $$$reportNull$$$0(5);
    L7:
        return r3;
    L8:
        String r4 = r2.getClass().getSimpleName() + HanziToPinyin.Token.SEPARATOR + r2.getName();
        if (r4 != null) goto L11;
        $$$reportNull$$$0(6);
    L11:
        return r4;
    }
}
