package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies;

/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "visitFunctionDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class CreateKCallableVisitor extends DeclarationDescriptorVisitorEmptyBodies<KCallableImpl<?>, Unit> {
    private final KDeclarationContainerImpl container;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public /* bridge */ /* synthetic */ Object visitFunctionDescriptor(FunctionDescriptor r1, Object r2) {
        return visitFunctionDescriptor(r1, (Unit) r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public /* bridge */ /* synthetic */ Object visitPropertyDescriptor(PropertyDescriptor r1, Object r2) {
        return visitPropertyDescriptor(r1, (Unit) r2);
    }

    public CreateKCallableVisitor(KDeclarationContainerImpl r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.container = r2;
    }

    public KCallableImpl<?> visitPropertyDescriptor(PropertyDescriptor r4, Unit r5) {
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        Intrinsics.checkNotNullParameter(r5, "data");
        int r0 = 0;
        if (r4.getDispatchReceiverParameter() == null) goto L5;
        int r6 = 1;
    L7:
        if (r4.getExtensionReceiverParameter() == null) goto L9;
        r0 = 1;
    L9:
        int r7 = r6 + r0;
        if (r4.isVar() == false) goto L20;
        if (r7 == 0) goto L19;
        if (r7 == 1) goto L17;
        if (r7 != 2) goto L26;
        return new KMutableProperty2Impl(this.container, r4);
    L26:
        throw new KotlinReflectionInternalError("Unsupported property: " + r4);
    L17:
        return new KMutableProperty1Impl(this.container, r4);
    L19:
        return new KMutableProperty0Impl(this.container, r4);
    L20:
        if (r7 == 0) goto L30;
        if (r7 == 1) goto L28;
        if (r7 != 2) goto L26;
        return new KProperty2Impl(this.container, r4);
    L28:
        return new KProperty1Impl(this.container, r4);
    L30:
        return new KProperty0Impl(this.container, r4);
    L5:
        r6 = 0;
        goto L7
    }

    public KCallableImpl<?> visitFunctionDescriptor(FunctionDescriptor r2, Unit r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        Intrinsics.checkNotNullParameter(r3, "data");
        return new KFunctionImpl(this.container, r2);
    }
}
