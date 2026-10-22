package kotlin.reflect.jvm;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

/* JADX INFO: compiled from: ReflectJvmMapping.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010%\u001a\u0004\u0018\u00010&*\u00020'H\u0002\"/\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"-\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001e*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!\"\u001b\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n*\u00020\t8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"javaConstructor", "Ljava/lang/reflect/Constructor;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KFunction;", "getJavaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaMethod", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinFunction", "", "getKotlinFunction", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ReflectJvmMapping {

    /* JADX INFO: compiled from: ReflectJvmMapping.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[KotlinClassHeader.Kind.values().length];
            r0[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void getJavaConstructor$annotations(KFunction r0) {
    }

    public static final Field getJavaField(KProperty<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        KPropertyImpl<?> r2 = UtilKt.asKPropertyImpl(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getJavaField();
    }

    public static final Method getJavaGetter(KProperty<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return getJavaMethod(r1.getGetter());
    }

    public static final Method getJavaSetter(KMutableProperty<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return getJavaMethod(r1.getSetter());
    }

    public static final Method getJavaMethod(KFunction<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        KCallableImpl<?> r3 = UtilKt.asKCallableImpl(r2);
        if (r3 == null) goto L7;
        Caller<?> r4 = r3.getCaller();
        if (r4 == null) goto L7;
        Member r5 = r4.mo2075getMember();
    L9:
        if ((r5 instanceof Method) == true) goto L11;
        return null;
    L11:
        return (Method) r5;
    L7:
        r5 = null;
        goto L9
    }

    public static final <T> Constructor<T> getJavaConstructor(KFunction<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        KCallableImpl<?> r3 = UtilKt.asKCallableImpl(r2);
        if (r3 == null) goto L7;
        Caller<?> r4 = r3.getCaller();
        if (r4 == null) goto L7;
        Member r5 = r4.mo2075getMember();
    L9:
        if ((r5 instanceof Constructor) == true) goto L11;
        return null;
    L11:
        return (Constructor) r5;
    L7:
        r5 = null;
        goto L9
    }

    public static final Type getJavaType(KType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Type r0 = ((KTypeImpl) r1).getJavaType();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return TypesJVMKt.getJavaType(r1);
    }

    public static final KProperty<?> getKotlinProperty(Field r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Object r1 = null;
        if (r5.isSynthetic() == false) goto L5;
        return null;
    L5:
        KDeclarationContainer r0 = getKPackage(r5);
        if (r0 == null) goto L21;
        Collection<KCallable<?>> r2 = r0.getMembers();
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        Object r6 = r4.next();
        if ((r6 instanceof KProperty) == false) goto L9;
        r3.add(r6);
        goto L9
    L13:
        Iterator r7 = r3.iterator();
    L15:
        if (r7.hasNext() == false) goto L20;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(getJavaField((KProperty) r8), r5) == false) goto L15;
        r1 = r8;
    L20:
        return (KProperty) r1;
    L21:
        Class<?> r9 = r5.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r9, "declaringClass");
        Iterator r10 = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(r9)).iterator();
    L23:
        if (r10.hasNext() == false) goto L28;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(getJavaField((KProperty1) r11), r5) == false) goto L23;
        r1 = r11;
    L28:
        return (KProperty) r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final KDeclarationContainer getKPackage(Member r5) {
        ReflectKotlinClass.Factory r0 = ReflectKotlinClass.Factory;
        Class<?> r1 = r5.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r1, "declaringClass");
        ReflectKotlinClass r2 = r0.create(r1);
        String r3 = null;
        Object[] r4 = 0;
        if (r2 == null) goto L7;
        KotlinClassHeader r6 = r2.getClassHeader();
        if (r6 == null) goto L7;
        KotlinClassHeader.Kind r7 = r6.getKind();
    L8:
        if (r7 != null) goto L10;
        int r8 = -1;
    L11:
        int r9 = 2;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L17;
        if (r8 == 3) goto L17;
        return null;
    L17:
        Class<?> r10 = r5.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r10, "declaringClass");
        return new KPackageImpl(r10, r3, r9, r4 == true ? 1 : 0);
    L10:
        r8 = WhenMappings.$EnumSwitchMapping$0[r7.ordinal()];
    L7:
        r7 = null;
        goto L8
    }

    public static final KFunction<?> getKotlinFunction(Method r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Object r2 = null;
        if (Modifier.isStatic(r7.getModifiers()) == false) goto L41;
        KDeclarationContainer r0 = getKPackage(r7);
        if (r0 == null) goto L20;
        Collection<KCallable<?>> r1 = r0.getMembers();
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        Object r5 = r4.next();
        if ((r5 instanceof KFunction) == false) goto L8;
        r3.add(r5);
        goto L8
    L12:
        Iterator r6 = r3.iterator();
    L14:
        if (r6.hasNext() == false) goto L19;
        Object r8 = r6.next();
        if (Intrinsics.areEqual(getJavaMethod((KFunction) r8), r7) == false) goto L14;
        r2 = r8;
    L19:
        return (KFunction) r2;
    L20:
        Class<?> r9 = r7.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r9, "declaringClass");
        KClass<?> r10 = KClasses.getCompanionObject(JvmClassMappingKt.getKotlinClass(r9));
        if (r10 == null) goto L41;
        Iterator<T> r11 = KClasses.getFunctions(r10).iterator();
    L24:
        if (r11.hasNext() == false) goto L37;
        Object r12 = r11.next();
        Method r13 = getJavaMethod((KFunction) r12);
        if (r13 != null) goto L28;
    L34:
        boolean r14 = false;
    L35:
        if (r14 == false) goto L24;
    L38:
        KFunction<?> r15 = (KFunction) r12;
        if (r15 == null) goto L41;
        return r15;
    L28:
        if (Intrinsics.areEqual(r13.getName(), r7.getName()) == false) goto L34;
        if (Arrays.equals(r13.getParameterTypes(), r7.getParameterTypes()) == false) goto L34;
        if (Intrinsics.areEqual(r13.getReturnType(), r7.getReturnType()) == false) goto L34;
        r14 = true;
        goto L35
    L37:
        r12 = null;
    L41:
        Class<?> r16 = r7.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r16, "declaringClass");
        Iterator<T> r17 = KClasses.getFunctions(JvmClassMappingKt.getKotlinClass(r16)).iterator();
    L43:
        if (r17.hasNext() == false) goto L48;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(getJavaMethod((KFunction) r18), r7) == false) goto L43;
        r2 = r18;
    L48:
        return (KFunction) r2;
    }

    public static final <T> KFunction<T> getKotlinFunction(Constructor<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Class<T> r0 = r3.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r0, "declaringClass");
        Iterator<T> r1 = JvmClassMappingKt.getKotlinClass(r0).getConstructors().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        T r2 = r1.next();
        if (Intrinsics.areEqual(getJavaConstructor((KFunction) r2), r3) == false) goto L4;
    L10:
        return (KFunction) r2;
    L8:
        r2 = null;
        goto L10
    }
}
