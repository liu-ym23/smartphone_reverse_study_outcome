package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* JADX INFO: compiled from: KCallableImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J%\u00106\u001a\u00028\u00002\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0016¢\u0006\u0002\u0010:J#\u0010;\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0002¢\u0006\u0002\u0010=J#\u0010>\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0016¢\u0006\u0002\u0010=J3\u0010?\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<2\f\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u00010AH\u0000¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020,H\u0002J\n\u0010F\u001a\u0004\u0018\u00010GH\u0002R(\u0010\u0005\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b \t*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \t*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000e0\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 \t*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010$R\u0014\u0010%\u001a\u00020#8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b%\u0010$R\u0012\u0010&\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010$R\u0014\u0010(\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0013R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0013R\u0016\u00102\u001a\u0004\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006H"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultEmptyArray", "type", "extractContinuationArgument", "Ljava/lang/reflect/Type;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;
    private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;

    public abstract Caller<?> getCaller();

    public abstract KDeclarationContainerImpl getContainer();

    public abstract Caller<?> getDefaultCaller();

    public abstract CallableMemberDescriptor getDescriptor();

    public abstract boolean isBound();

    public KCallableImpl() {
        ReflectProperties.LazySoftVal<List<Annotation>> r0 = ReflectProperties.lazySoft(new KCallableImpl$_annotations$1(this));
        Intrinsics.checkNotNullExpressionValue(r0, "lazySoft { descriptor.computeAnnotations() }");
        this._annotations = r0;
        ReflectProperties.LazySoftVal<ArrayList<KParameter>> r1 = ReflectProperties.lazySoft(new KCallableImpl$_parameters$1(this));
        Intrinsics.checkNotNullExpressionValue(r1, "lazySoft {\n        val d…ze()\n        result\n    }");
        this._parameters = r1;
        ReflectProperties.LazySoftVal<KTypeImpl> r2 = ReflectProperties.lazySoft(new KCallableImpl$_returnType$1(this));
        Intrinsics.checkNotNullExpressionValue(r2, "lazySoft {\n        KType…eturnType\n        }\n    }");
        this._returnType = r2;
        ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> r3 = ReflectProperties.lazySoft(new KCallableImpl$_typeParameters$1(this));
        Intrinsics.checkNotNullExpressionValue(r3, "lazySoft {\n        descr…this, descriptor) }\n    }");
        this._typeParameters = r3;
    }

    public static final /* synthetic */ Type access$extractContinuationArgument(KCallableImpl r0) {
        return r0.extractContinuationArgument();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        List<Annotation> r1 = this._annotations.invoke();
        Intrinsics.checkNotNullExpressionValue(r1, "_annotations()");
        return r1;
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        ArrayList<KParameter> r1 = this._parameters.invoke();
        Intrinsics.checkNotNullExpressionValue(r1, "_parameters()");
        return r1;
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        KTypeImpl r1 = this._returnType.invoke();
        Intrinsics.checkNotNullExpressionValue(r1, "_returnType()");
        return r1;
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> r1 = this._typeParameters.invoke();
        Intrinsics.checkNotNullExpressionValue(r1, "_typeParameters()");
        return r1;
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        DescriptorVisibility r1 = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(r1, "descriptor.visibility");
        return UtilKt.toKVisibility(r1);
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        if (getDescriptor().getModality() != Modality.FINAL) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        if (getDescriptor().getModality() != Modality.OPEN) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        if (getDescriptor().getModality() != Modality.ABSTRACT) goto L5;
        return true;
    L5:
        return false;
    }

    protected final boolean isAnnotationConstructor() {
        if (Intrinsics.areEqual(getName(), "<init>") == true) goto L5;
    L7:
        return false;
    L5:
        if (getContainer().getJClass().isAnnotation() == false) goto L7;
        return true;
    }

    @Override // kotlin.reflect.KCallable
    public R call(Object... r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        return (R) getCaller().call(r2);
    L5:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    }

    @Override // kotlin.reflect.KCallable
    public R callBy(Map<KParameter, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        if (isAnnotationConstructor() == false) goto L6;
        return callAnnotationConstructor(r2);
    L6:
        return callDefaultMethod$kotlin_reflection(r2, null);
    }

    public final R callDefaultMethod$kotlin_reflection(Map<KParameter, ? extends Object> r12, Continuation<?> r13) {
        Intrinsics.checkNotNullParameter(r12, "args");
        List<KParameter> r0 = getParameters();
        ArrayList r1 = new ArrayList(r0.size());
        ArrayList r2 = new ArrayList(1);
        Iterator<KParameter> r3 = r0.iterator();
        int r5 = 0;
        boolean r6 = false;
        int r7 = 0;
    L3:
        Object r9 = null;
        if (r3.hasNext() == false) goto L28;
        KParameter r8 = r3.next();
        if (r5 == 0) goto L11;
        if ((r5 % 32) != 0) goto L11;
        r2.add(Integer.valueOf(r7));
        r7 = 0;
    L11:
        if (r12.containsKey(r8) == false) goto L14;
        r1.add(r12.get(r8));
    L24:
        if (r8.getKind() != KParameter.Kind.VALUE) goto L3;
        r5 = r5 + 1;
        goto L3
    L14:
        if (r8.isOptional() == false) goto L21;
        if (UtilKt.isInlineClassType(r8.getType()) == true) goto L19;
        r9 = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(r8.getType()));
    L19:
        r1.add(r9);
        r7 = (1 << (r5 % 32)) | r7;
        r6 = true;
        goto L24
    L21:
        if (r8.isVararg() == false) goto L27;
        r1.add(defaultEmptyArray(r8.getType()));
        goto L24
    L27:
        throw new IllegalArgumentException("No argument provided for a required parameter: " + r8);
    L28:
        if (r13 == null) goto L31;
        r1.add(r13);
    L31:
        if (r6 == true) goto L34;
        Object[] r14 = r1.toArray(new Object[0]);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return call(Arrays.copyOf(r14, r14.length));
    L34:
        r2.add(Integer.valueOf(r7));
        Caller<?> r15 = getDefaultCaller();
        if (r15 == null) goto L43;
        r1.addAll(r2);
        r1.add(null);
        Object[] r11 = r1.toArray(new Object[0]);     // Catch: IllegalAccessException -> L39
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: IllegalAccessException -> L39
        return (R) r15.call(r11);
    L39:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    L43:
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
    }

    private final R callAnnotationConstructor(Map<KParameter, ? extends Object> r5) {
        List<KParameter> r0 = getParameters();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L21;
        KParameter r3 = (KParameter) r2.next();
        if (r5.containsKey(r3) == false) goto L13;
        Object r4 = r5.get(r3);
        if (r4 != null) goto L18;
        throw new IllegalArgumentException("Annotation argument value cannot be null (" + r3 + ')');
    L18:
        r1.add(r4);
        goto L4
    L13:
        if (r3.isOptional() == false) goto L16;
        r4 = null;
        goto L18
    L16:
        if (r3.isVararg() == false) goto L20;
        r4 = defaultEmptyArray(r3.getType());
        goto L18
    L20:
        throw new IllegalArgumentException("No argument provided for a required parameter: " + r3);
    L21:
        ArrayList r6 = r1;
        Caller<?> r7 = getDefaultCaller();
        if (r7 == null) goto L29;
        Object[] r8 = r6.toArray(new Object[0]);     // Catch: IllegalAccessException -> L25
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: IllegalAccessException -> L25
        return (R) r7.call(r8);
    L25:
        e = move-exception;
        throw new IllegalCallableAccessException(e);
    L29:
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
    }

    private final Object defaultEmptyArray(KType r3) {
        Class r2 = JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(r3));
        if (r2.isArray() == false) goto L7;
        Object r4 = Array.newInstance(r2.getComponentType(), 0);
        Intrinsics.checkNotNullExpressionValue(r4, "type.jvmErasure.java.run…\"\n            )\n        }");
        return r4;
    L7:
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + r2.getSimpleName() + ", because it is not an array type");
    }

    private final Type extractContinuationArgument() {
        CallableMemberDescriptor r0 = getDescriptor();
        if ((r0 instanceof FunctionDescriptor) == false) goto L5;
        FunctionDescriptor r1 = (FunctionDescriptor) r0;
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
    L11:
        if (r2 == false) goto L30;
        Object r4 = CollectionsKt.lastOrNull(getCaller().getParameterTypes());
        if ((r4 instanceof ParameterizedType) == false) goto L15;
        ParameterizedType r5 = (ParameterizedType) r4;
    L16:
        if (r5 == null) goto L18;
        Type r3 = r5.getRawType();
    L20:
        if (Intrinsics.areEqual(r3, Continuation.class) == false) goto L31;
        Type[] r6 = r5.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(r6, "continuationType.actualTypeArguments");
        Object r7 = ArraysKt.single(r6);
        if ((r7 instanceof WildcardType) == false) goto L24;
        WildcardType r8 = (WildcardType) r7;
    L25:
        if (r8 == null) goto L32;
        Type[] r9 = r8.getLowerBounds();
        if (r9 != null) goto L29;
        return null;
    L29:
        return (Type) ArraysKt.first(r9);
    L32:
        return null;
    L24:
        r8 = null;
        goto L25
    L31:
        return null;
    L18:
        r3 = null;
        goto L20
    L15:
        r5 = null;
        goto L16
    L30:
        return null;
    L9:
        if (r1.isSuspend() != true) goto L11;
        r2 = true;
        goto L11
    L5:
        r1 = null;
        goto L6
    }
}
