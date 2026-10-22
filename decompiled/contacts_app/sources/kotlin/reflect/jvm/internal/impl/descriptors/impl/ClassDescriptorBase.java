package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ClassDescriptorBase extends AbstractClassDescriptor {
    private final DeclarationDescriptor containingDeclaration;
    private final boolean isExternal;
    private final SourceElement source;

    private static /* synthetic */ void $$$reportNull$$$0(int r9) {
        if (r9 == 4) goto L6;
        if (r9 == 5) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r9 == 4) goto L11;
        if (r9 == 5) goto L11;
        int r5 = 3;
    L12:
        Object[] r6 = new Object[r5];
        if (r9 == 1) goto L22;
        if (r9 == 2) goto L21;
        if (r9 == 3) goto L20;
        if (r9 == 4) goto L19;
        if (r9 == 5) goto L19;
        r6[0] = "storageManager";
    L23:
        if (r9 == 4) goto L27;
        if (r9 == 5) goto L26;
        r6[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
    L28:
        if (r9 == 4) goto L31;
        if (r9 == 5) goto L31;
        r6[2] = "<init>";
    L31:
        String r3 = String.format(r2, r6);
        if (r9 == 4) goto L36;
        if (r9 == 5) goto L36;
        throw new IllegalArgumentException(r3);
    L36:
        throw new IllegalStateException(r3);
    L26:
        r6[1] = "getSource";
        goto L28
    L27:
        r6[1] = "getContainingDeclaration";
    L19:
        r6[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        goto L23
    L20:
        r6[0] = "source";
        goto L23
    L21:
        r6[0] = "name";
        goto L23
    L22:
        r6[0] = "containingDeclaration";
    L11:
        r5 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    protected ClassDescriptorBase(StorageManager r2, DeclarationDescriptor r3, Name r4, SourceElement r5, boolean r6) {
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
        super(r2, r4);
        this.containingDeclaration = r3;
        this.source = r5;
        this.isExternal = r6;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor r1 = this.containingDeclaration;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement r1 = this.source;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r1;
    }
}
