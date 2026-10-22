package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DeclarationDescriptorNonRootImpl extends DeclarationDescriptorImpl implements DeclarationDescriptorNonRoot {
    private final DeclarationDescriptor containingDeclaration;
    private final SourceElement source;

    private static /* synthetic */ void $$$reportNull$$$0(int r9) {
        if (r9 == 4) goto L7;
        if (r9 == 5) goto L7;
        if (r9 == 6) goto L7;
        String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r9 == 4) goto L13;
        if (r9 == 5) goto L13;
        if (r9 == 6) goto L13;
        int r5 = 3;
    L14:
        Object[] r6 = new Object[r5];
        switch(r9) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L17;
            default: goto L16;
        };
    L16:
        r6[0] = "containingDeclaration";
    L22:
        if (r9 == 4) goto L28;
        if (r9 == 5) goto L27;
        if (r9 == 6) goto L26;
        r6[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
    L29:
        if (r9 == 4) goto L33;
        if (r9 == 5) goto L33;
        if (r9 == 6) goto L33;
        r6[2] = "<init>";
    L33:
        String r4 = String.format(r3, r6);
        if (r9 == 4) goto L39;
        if (r9 == 5) goto L39;
        if (r9 == 6) goto L39;
        throw new IllegalArgumentException(r4);
    L39:
        throw new IllegalStateException(r4);
    L26:
        r6[1] = "getSource";
        goto L29
    L27:
        r6[1] = "getContainingDeclaration";
        goto L29
    L28:
        r6[1] = "getOriginal";
        goto L29
    L17:
        r6[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        goto L22
    L18:
        r6[0] = "source";
        goto L22
    L19:
        r6[0] = "name";
        goto L22
    L20:
        r6[0] = "annotations";
    L13:
        r5 = 2;
    L7:
        r3 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    protected DeclarationDescriptorNonRootImpl(DeclarationDescriptor r2, Annotations r3, Name r4, SourceElement r5) {
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
        super(r3, r4);
        this.containingDeclaration = r2;
        this.source = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptorWithSource getOriginal() {
        DeclarationDescriptorWithSource r1 = (DeclarationDescriptorWithSource) super.getOriginal();
        if (r1 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r1;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor r1 = this.containingDeclaration;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement r1 = this.source;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r1;
    }
}
