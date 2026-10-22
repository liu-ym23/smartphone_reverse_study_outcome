package kotlin.reflect.jvm.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.jvm.ReflectLambdaKt;

/* JADX INFO: loaded from: classes4.dex */
public class ReflectionFactoryImpl extends ReflectionFactory {
    @Override // kotlin.jvm.internal.ReflectionFactory
    public void setUpperBounds(KTypeParameter r1, List<KType> r2) {
    }

    public ReflectionFactoryImpl() {
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass createKotlinClass(Class r1) {
        return new KClassImpl(r1);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass createKotlinClass(Class r1, String r2) {
        return new KClassImpl(r1);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KDeclarationContainer getOrCreateKotlinPackage(Class r1, String r2) {
        return new KPackageImpl(r1, r2);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass getOrCreateKotlinClass(Class r1) {
        return KClassCacheKt.getOrCreateKotlinClass(r1);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KClass getOrCreateKotlinClass(Class r1, String r2) {
        return KClassCacheKt.getOrCreateKotlinClass(r1);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public String renderLambdaToString(Lambda r1) {
        return renderLambdaToString(r1);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public String renderLambdaToString(FunctionBase r2) {
        KFunction r0 = ReflectLambdaKt.reflect(r2);
        if (r0 == null) goto L9;
        KFunctionImpl r1 = UtilKt.asKFunctionImpl(r0);
        if (r1 == null) goto L9;
        return ReflectionObjectRenderer.INSTANCE.renderLambda(r1.getDescriptor());
    L9:
        return super.renderLambdaToString(r2);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KFunction function(FunctionReference r4) {
        return new KFunctionImpl(getOwner(r4), r4.getName(), r4.getSignature(), r4.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty0 property0(PropertyReference0 r4) {
        return new KProperty0Impl(getOwner(r4), r4.getName(), r4.getSignature(), r4.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 r4) {
        return new KMutableProperty0Impl(getOwner(r4), r4.getName(), r4.getSignature(), r4.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty1 property1(PropertyReference1 r4) {
        return new KProperty1Impl(getOwner(r4), r4.getName(), r4.getSignature(), r4.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 r4) {
        return new KMutableProperty1Impl(getOwner(r4), r4.getName(), r4.getSignature(), r4.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KProperty2 property2(PropertyReference2 r3) {
        return new KProperty2Impl(getOwner(r3), r3.getName(), r3.getSignature());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 r3) {
        return new KMutableProperty2Impl(getOwner(r3), r3.getName(), r3.getSignature());
    }

    private static KDeclarationContainerImpl getOwner(CallableReference r1) {
        KDeclarationContainer r2 = r1.getOwner();
        if ((r2 instanceof KDeclarationContainerImpl) == false) goto L6;
        return (KDeclarationContainerImpl) r2;
    L6:
        return EmptyContainerForLocal.INSTANCE;
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType typeOf(KClassifier r1, List<KTypeProjection> r2, boolean r3) {
        return KClassifiers.createType(r1, r2, r3, Collections.emptyList());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KTypeParameter typeParameter(Object r1, String r2, KVariance r3, boolean r4) {
        if ((r1 instanceof KClass) == false) goto L6;
        List<KTypeParameter> r0 = ((KClass) r1).getTypeParameters();
    L8:
        Iterator<KTypeParameter> r5 = r0.iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        KTypeParameter r6 = r5.next();
        if (r6.getName().equals(r2) == false) goto L10;
        return r6;
    L15:
        throw new IllegalArgumentException("Type parameter " + r2 + " is not found in container: " + r1);
    L6:
        if ((r1 instanceof KCallable) == false) goto L17;
        r0 = ((KCallable) r1).getTypeParameters();
        goto L8
    L17:
        throw new IllegalArgumentException("Type parameter container must be a class or a callable: " + r1);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType platformType(KType r1, KType r2) {
        return TypeOfImplKt.createPlatformKType(r1, r2);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType mutableCollectionType(KType r1) {
        return TypeOfImplKt.createMutableCollectionKType(r1);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public KType nothingType(KType r1) {
        return TypeOfImplKt.createNothingType(r1);
    }

    public static void clearCaches() {
        KClassCacheKt.clearKClassCache();
        ModuleByClassLoaderKt.clearModuleByClassLoaderCache();
    }
}
