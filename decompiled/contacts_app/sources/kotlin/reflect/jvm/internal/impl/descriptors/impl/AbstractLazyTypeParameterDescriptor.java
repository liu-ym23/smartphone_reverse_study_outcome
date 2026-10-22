package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.contacts.util.HanziToPinyin;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractLazyTypeParameterDescriptor extends AbstractTypeParameterDescriptor {
    private static /* synthetic */ void $$$reportNull$$$0(int r2) {
        Object[] r0 = new Object[3];
        switch(r2) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        r0[0] = "storageManager";
    L11:
        r0[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        r0[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
    L5:
        r0[0] = "supertypeLoopChecker";
        goto L11
    L6:
        r0[0] = "source";
        goto L11
    L7:
        r0[0] = "variance";
        goto L11
    L8:
        r0[0] = "name";
        goto L11
    L9:
        r0[0] = "annotations";
        goto L11
    L10:
        r0[0] = "containingDeclaration";
        goto L11
    }

    public AbstractLazyTypeParameterDescriptor(StorageManager r2, DeclarationDescriptor r3, Annotations r4, Name r5, Variance r6, boolean r7, int r8, SourceElement r9, SupertypeLoopChecker r10) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r4 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r5 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r6 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        if (r9 != null) goto L14;
        $$$reportNull$$$0(5);
    L14:
        if (r10 != null) goto L16;
        $$$reportNull$$$0(6);
    L16:
        super(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        Object[] r0 = new Object[3];
        String r2 = "";
        if (isReified() == false) goto L5;
        String r1 = "reified ";
    L6:
        r0[0] = r1;
        if (getVariance() == Variance.INVARIANT) goto L10;
        r2 = getVariance() + HanziToPinyin.Token.SEPARATOR;
    L10:
        r0[1] = r2;
        r0[2] = getName();
        return String.format("%s%s%s", r0);
    L5:
        r1 = "";
        goto L6
    }
}
