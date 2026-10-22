package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: compiled from: KParameterImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0013\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\"H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KParameterImpl implements KParameter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private final ReflectProperties.LazySoftVal annotations$delegate;
    private final KCallableImpl<?> callable;
    private final ReflectProperties.LazySoftVal descriptor$delegate;
    private final int index;
    private final KParameter.Kind kind;

    public KParameterImpl(KCallableImpl<?> r2, int r3, KParameter.Kind r4, Function0<? extends ParameterDescriptor> r5) {
        Intrinsics.checkNotNullParameter(r2, "callable");
        Intrinsics.checkNotNullParameter(r4, "kind");
        Intrinsics.checkNotNullParameter(r5, "computeDescriptor");
        this.callable = r2;
        this.index = r3;
        this.kind = r4;
        this.descriptor$delegate = ReflectProperties.lazySoft(r5);
        this.annotations$delegate = ReflectProperties.lazySoft(new KParameterImpl$annotations$2(this));
    }

    public static final /* synthetic */ ParameterDescriptor access$getDescriptor(KParameterImpl r0) {
        return r0.getDescriptor();
    }

    public final KCallableImpl<?> getCallable() {
        return this.callable;
    }

    @Override // kotlin.reflect.KParameter
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.KParameter
    public KParameter.Kind getKind() {
        return this.kind;
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KParameterImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KParameterImpl.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    private final ParameterDescriptor getDescriptor() {
        T r3 = this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(r3, "<get-descriptor>(...)");
        return (ParameterDescriptor) r3;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        T r3 = this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(r3, "<get-annotations>(...)");
        return (List) r3;
    }

    @Override // kotlin.reflect.KParameter
    public String getName() {
        ParameterDescriptor r2 = getDescriptor();
        if ((r2 instanceof ValueParameterDescriptor) == false) goto L5;
        ValueParameterDescriptor r3 = (ValueParameterDescriptor) r2;
    L6:
        if (r3 != null) goto L9;
        return null;
    L9:
        if (r3.getContainingDeclaration().hasSynthesizedParameterNames() == false) goto L11;
        return null;
    L11:
        Name r4 = r3.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "valueParameter.name");
        if (r4.isSpecial() == false) goto L15;
        return null;
    L15:
        return r4.asString();
    L5:
        r3 = null;
        goto L6
    }

    @Override // kotlin.reflect.KParameter
    public KType getType() {
        KotlinType r1 = getDescriptor().getType();
        Intrinsics.checkNotNullExpressionValue(r1, "descriptor.type");
        return new KTypeImpl(r1, new KParameterImpl$type$1(this));
    }

    @Override // kotlin.reflect.KParameter
    public boolean isOptional() {
        ParameterDescriptor r1 = getDescriptor();
        if ((r1 instanceof ValueParameterDescriptor) == false) goto L5;
        ValueParameterDescriptor r2 = (ValueParameterDescriptor) r1;
    L6:
        if (r2 != null) goto L10;
        return false;
    L10:
        return DescriptorUtilsKt.declaresOrInheritsDefaultValue(r2);
    L5:
        r2 = null;
        goto L6
    }

    @Override // kotlin.reflect.KParameter
    public boolean isVararg() {
        ParameterDescriptor r1 = getDescriptor();
        if ((r1 instanceof ValueParameterDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ValueParameterDescriptor) r1).getVarargElementType() == null) goto L7;
        return true;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof KParameterImpl) == false) goto L9;
        KParameterImpl r4 = (KParameterImpl) r3;
        if (Intrinsics.areEqual(this.callable, r4.callable) == false) goto L9;
        if (getIndex() != r4.getIndex()) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return (this.callable.hashCode() * 31) + Integer.valueOf(getIndex()).hashCode();
    }

    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderParameter(this);
    }
}
