package kotlin.reflect.full;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.TraceStatsConsts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* JADX INFO: compiled from: KClasses.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u001a+\u0010S\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010U\u001a!\u0010V\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u0002H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010W\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010X\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a\u001c\u0010Y\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010Z\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a-\u0010[\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010U\",\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"(\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\"$\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013\",\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\",\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"B\u0010\u001b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\",\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\">\u0010#\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\",\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\"\u0010+\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010.\",\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u001c\u00102\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00105\"\u001c\u00106\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00105\",\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"B\u0010:\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\",\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\">\u0010@\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006\"6\u0010C\u001a\n\u0012\u0004\u0012\u0002H\u001d\u0018\u00010\u0015\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bD\u0010\u0004\u001a\u0004\bE\u0010F\",\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\",\u0010J\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030K0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006\",\u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020O*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010R¨\u0006\\"}, d2 = {"allSuperclasses", "", "Lkotlin/reflect/KClass;", "getAllSuperclasses$annotations", "(Lkotlin/reflect/KClass;)V", "getAllSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "allSupertypes", "Lkotlin/reflect/KType;", "getAllSupertypes$annotations", "getAllSupertypes", "companionObject", "getCompanionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "", "getCompanionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "declaredFunctions", "Lkotlin/reflect/KFunction;", "getDeclaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberExtensionFunctions", "getDeclaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "declaredMemberExtensionProperties", "Lkotlin/reflect/KProperty2;", ExifInterface.GPS_DIRECTION_TRUE, "getDeclaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "declaredMemberFunctions", "getDeclaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberProperties", "Lkotlin/reflect/KProperty1;", "getDeclaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMembers", "Lkotlin/reflect/KCallable;", "getDeclaredMembers$annotations", "getDeclaredMembers", "defaultType", "getDefaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "functions", "getFunctions$annotations", "getFunctions", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "memberExtensionFunctions", "getMemberExtensionFunctions$annotations", "getMemberExtensionFunctions", "memberExtensionProperties", "getMemberExtensionProperties$annotations", "getMemberExtensionProperties", "memberFunctions", "getMemberFunctions$annotations", "getMemberFunctions", "memberProperties", "getMemberProperties$annotations", "getMemberProperties", "primaryConstructor", "getPrimaryConstructor$annotations", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "staticFunctions", "getStaticFunctions$annotations", "getStaticFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "getStaticProperties$annotations", "getStaticProperties", "superclasses", "", "getSuperclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "createInstance", "isSubclassOf", TraceStatsConsts.STATS_BASE_MODULE, "isSuperclassOf", "derived", "safeCast", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KClasses {
    public static /* synthetic */ void getAllSuperclasses$annotations(KClass r0) {
    }

    public static /* synthetic */ void getAllSupertypes$annotations(KClass r0) {
    }

    public static /* synthetic */ void getCompanionObject$annotations(KClass r0) {
    }

    public static /* synthetic */ void getCompanionObjectInstance$annotations(KClass r0) {
    }

    public static /* synthetic */ void getDeclaredFunctions$annotations(KClass r0) {
    }

    public static /* synthetic */ void getDeclaredMemberExtensionFunctions$annotations(KClass r0) {
    }

    public static /* synthetic */ void getDeclaredMemberExtensionProperties$annotations(KClass r0) {
    }

    public static /* synthetic */ void getDeclaredMemberFunctions$annotations(KClass r0) {
    }

    public static /* synthetic */ void getDeclaredMemberProperties$annotations(KClass r0) {
    }

    public static /* synthetic */ void getDeclaredMembers$annotations(KClass r0) {
    }

    @Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    public static /* synthetic */ void getDefaultType$annotations(KClass r0) {
    }

    public static /* synthetic */ void getFunctions$annotations(KClass r0) {
    }

    public static /* synthetic */ void getMemberExtensionFunctions$annotations(KClass r0) {
    }

    public static /* synthetic */ void getMemberExtensionProperties$annotations(KClass r0) {
    }

    public static /* synthetic */ void getMemberFunctions$annotations(KClass r0) {
    }

    public static /* synthetic */ void getMemberProperties$annotations(KClass r0) {
    }

    public static /* synthetic */ void getPrimaryConstructor$annotations(KClass r0) {
    }

    public static /* synthetic */ void getStaticFunctions$annotations(KClass r0) {
    }

    public static /* synthetic */ void getStaticProperties$annotations(KClass r0) {
    }

    public static /* synthetic */ void getSuperclasses$annotations(KClass r0) {
    }

    public static final <T> KFunction<T> getPrimaryConstructor(KClass<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Iterator<T> r4 = ((KClassImpl) r3).getConstructors().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        T r0 = r4.next();
        KFunction r1 = (KFunction) r0;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
        FunctionDescriptor r2 = ((KFunctionImpl) r1).getDescriptor();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
        if (((ConstructorDescriptor) r2).isPrimary() == false) goto L4;
    L10:
        return (KFunction) r0;
    L8:
        r0 = null;
        goto L10
    }

    public static final KClass<?> getCompanionObject(KClass<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Iterator<T> r4 = r3.getNestedClasses().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        KClass r1 = (KClass) r0;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
        if (((KClassImpl) r1).getDescriptor().isCompanionObject() == false) goto L4;
    L10:
        return (KClass) r0;
    L8:
        r0 = null;
        goto L10
    }

    public static final Object getCompanionObjectInstance(KClass<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        KClass<?> r2 = getCompanionObject(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getObjectInstance();
    }

    public static final KType getDefaultType(final KClass<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        SimpleType r1 = ((KClassImpl) r3).getDescriptor().getDefaultType();
        Intrinsics.checkNotNullExpressionValue(r1, "this as KClassImpl<*>).descriptor.defaultType");
        return new KTypeImpl(r1, new KClasses$defaultType$1(r3));
    }

    public static final Collection<KCallable<?>> getDeclaredMembers(KClass<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return ((KClassImpl.Data) ((KClassImpl) r1).getData().invoke()).getDeclaredMembers();
    }

    public static final Collection<KFunction<?>> getFunctions(KClass<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Collection<KCallable<?>> r4 = r3.getMembers();
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Object r1 = r5.next();
        if ((r1 instanceof KFunction) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return r0;
    }

    public static final Collection<KFunction<?>> getStaticFunctions(KClass<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Collection<KCallableImpl<?>> r4 = ((KClassImpl.Data) ((KClassImpl) r3).getData().invoke()).getAllStaticMembers();
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Object r1 = r5.next();
        if ((r1 instanceof KFunction) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return r0;
    }

    public static final Collection<KFunction<?>> getMemberFunctions(KClass<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Collection<KCallableImpl<?>> r5 = ((KClassImpl.Data) ((KClassImpl) r4).getData().invoke()).getAllNonStaticMembers();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        KCallableImpl r2 = (KCallableImpl) r1;
        if (isNotExtension(r2) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if ((r2 instanceof KFunction) == false) goto L10;
        r3 = true;
        goto L11
    L14:
        return r0;
    }

    public static final Collection<KFunction<?>> getMemberExtensionFunctions(KClass<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Collection<KCallableImpl<?>> r5 = ((KClassImpl.Data) ((KClassImpl) r4).getData().invoke()).getAllNonStaticMembers();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        KCallableImpl r2 = (KCallableImpl) r1;
        if (isExtension(r2) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if ((r2 instanceof KFunction) == false) goto L10;
        r3 = true;
        goto L11
    L14:
        return r0;
    }

    public static final Collection<KFunction<?>> getDeclaredFunctions(KClass<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Collection<KCallableImpl<?>> r4 = ((KClassImpl.Data) ((KClassImpl) r3).getData().invoke()).getDeclaredMembers();
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Object r1 = r5.next();
        if ((r1 instanceof KFunction) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return r0;
    }

    public static final Collection<KFunction<?>> getDeclaredMemberFunctions(KClass<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Collection<KCallableImpl<?>> r5 = ((KClassImpl.Data) ((KClassImpl) r4).getData().invoke()).getDeclaredNonStaticMembers();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        KCallableImpl r2 = (KCallableImpl) r1;
        if (isNotExtension(r2) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if ((r2 instanceof KFunction) == false) goto L10;
        r3 = true;
        goto L11
    L14:
        return r0;
    }

    public static final Collection<KFunction<?>> getDeclaredMemberExtensionFunctions(KClass<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Collection<KCallableImpl<?>> r5 = ((KClassImpl.Data) ((KClassImpl) r4).getData().invoke()).getDeclaredNonStaticMembers();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        KCallableImpl r2 = (KCallableImpl) r1;
        if (isExtension(r2) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if ((r2 instanceof KFunction) == false) goto L10;
        r3 = true;
        goto L11
    L14:
        return r0;
    }

    public static final Collection<KProperty0<?>> getStaticProperties(KClass<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Collection<KCallableImpl<?>> r5 = ((KClassImpl.Data) ((KClassImpl) r4).getData().invoke()).getAllStaticMembers();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        Object r1 = r6.next();
        KCallableImpl r2 = (KCallableImpl) r1;
        if (isNotExtension(r2) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if ((r2 instanceof KProperty0) == false) goto L10;
        r3 = true;
        goto L11
    L14:
        return r0;
    }

    public static final <T> Collection<KProperty1<T, ?>> getMemberProperties(KClass<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Collection<KCallableImpl<?>> r5 = ((KClassImpl) r4).getData().invoke().getAllNonStaticMembers();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        T r1 = r6.next();
        KCallableImpl r2 = (KCallableImpl) r1;
        if (isNotExtension(r2) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if ((r2 instanceof KProperty1) == false) goto L10;
        r3 = true;
        goto L11
    L14:
        return r0;
    }

    public static final <T> Collection<KProperty2<T, ?, ?>> getMemberExtensionProperties(KClass<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Collection<KCallableImpl<?>> r5 = ((KClassImpl) r4).getData().invoke().getAllNonStaticMembers();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        T r1 = r6.next();
        KCallableImpl r2 = (KCallableImpl) r1;
        if (isExtension(r2) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if ((r2 instanceof KProperty2) == false) goto L10;
        r3 = true;
        goto L11
    L14:
        return r0;
    }

    public static final <T> Collection<KProperty1<T, ?>> getDeclaredMemberProperties(KClass<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Collection<KCallableImpl<?>> r5 = ((KClassImpl) r4).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        T r1 = r6.next();
        KCallableImpl r2 = (KCallableImpl) r1;
        if (isNotExtension(r2) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if ((r2 instanceof KProperty1) == false) goto L10;
        r3 = true;
        goto L11
    L14:
        return r0;
    }

    public static final <T> Collection<KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(KClass<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Collection<KCallableImpl<?>> r5 = ((KClassImpl) r4).getData().invoke().getDeclaredNonStaticMembers();
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        T r1 = r6.next();
        KCallableImpl r2 = (KCallableImpl) r1;
        if (isExtension(r2) == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        if ((r2 instanceof KProperty2) == false) goto L10;
        r3 = true;
        goto L11
    L14:
        return r0;
    }

    private static final boolean isExtension(KCallableImpl<?> r0) {
        if (r0.getDescriptor().getExtensionReceiverParameter() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean isNotExtension(KCallableImpl<?> r0) {
        return !isExtension(r0);
    }

    public static final List<KClass<?>> getSuperclasses(KClass<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        List<KType> r4 = r3.getSupertypes();
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        KClassifier r1 = ((KType) r5.next()).getClassifier();
        if ((r1 instanceof KClass) == false) goto L8;
        KClass r2 = (KClass) r1;
    L9:
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        r2 = null;
        goto L9
    L12:
        return r0;
    }

    public static final Collection<KType> getAllSupertypes(KClass<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Object r4 = DFS.dfs(r3.getSupertypes(), KClasses$allSupertypes$1.INSTANCE, new DFS.VisitedWithSet(), new KClasses$allSupertypes$2());
        Intrinsics.checkNotNullExpressionValue(r4, "dfs(\n        supertypes,…        }\n        }\n    )");
        return (Collection) r4;
    }

    public static final Collection<KClass<?>> getAllSuperclasses(KClass<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Collection<KType> r5 = getAllSupertypes(r4);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        KType r1 = (KType) r6.next();
        KClassifier r2 = r1.getClassifier();
        if ((r2 instanceof KClass) == false) goto L8;
        KClass r3 = (KClass) r2;
    L9:
        if (r3 == null) goto L12;
        r0.add(r3);
        goto L4
    L12:
        throw new KotlinReflectionInternalError("Supertype not a class: " + r1);
    L8:
        r3 = null;
        goto L9
    L14:
        return r0;
    }

    public static final boolean isSubclassOf(KClass<?> r2, final KClass<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, TraceStatsConsts.STATS_BASE_MODULE);
        if (Intrinsics.areEqual(r2, r3) == true) goto L8;
        List r4 = CollectionsKt.listOf(r2);
        final AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        Boolean r5 = DFS.ifAny(r4, new KClasses$sam$org_jetbrains_kotlin_utils_DFS_Neighbors$0(r0), new AnonymousClass2(r3));
        Intrinsics.checkNotNullExpressionValue(r5, "base: KClass<*>): Boolea…erclasses) { it == base }");
        if (r5.booleanValue() == true) goto L8;
        return false;
    L8:
        return true;
    }

    public static final boolean isSuperclassOf(KClass<?> r1, KClass<?> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "derived");
        return isSubclassOf(r2, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(KClass<T> r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.isInstance(r3) == false) goto L7;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.cast");
        return r3;
    L7:
        throw new TypeCastException("Value cannot be cast to " + r2.getQualifiedName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T safeCast(KClass<T> r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isInstance(r2) == false) goto L5;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.safeCast");
        return r2;
    L5:
        return null;
    }

    public static final <T> T createInstance(KClass<T> r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Iterator<T> r0 = r9.getConstructors().iterator();
        T r1 = null;
        T r4 = null;
        boolean r3 = false;
    L4:
        if (r0.hasNext() == false) goto L20;
        T r5 = r0.next();
        List<KParameter> r6 = ((KFunction) r5).getParameters();
        if ((r6 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L9;
        if (((KParameter) r7.next()).isOptional() == true) goto L12;
        boolean r8 = false;
    L16:
        if (r8 == false) goto L4;
        if (r3 == true) goto L23;
        r4 = r5;
        r3 = true;
    L23:
        KFunction r2 = (KFunction) r1;
        if (r2 == null) goto L28;
        return (T) r2.callBy(MapsKt.emptyMap());
    L28:
        throw new IllegalArgumentException("Class should have a single no-arg constructor: " + r9);
    L9:
        r8 = true;
        goto L16
    L8:
        if (r6.isEmpty() == false) goto L10;
    L20:
        if (r3 == false) goto L23;
        r1 = r4;
        goto L23
    }
}
