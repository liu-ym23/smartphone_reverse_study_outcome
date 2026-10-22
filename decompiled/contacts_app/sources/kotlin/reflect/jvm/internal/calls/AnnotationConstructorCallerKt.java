package kotlin.reflect.jvm.internal.calls;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001aI\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u0014²\u0006\u0014\u0010\u0015\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002²\u0006\u0014\u0010\u0016\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"createAnnotationInstance", ExifInterface.GPS_DIRECTION_TRUE, "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection", "hashCode", "toString"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AnnotationConstructorCallerKt {
    public static final /* synthetic */ boolean access$createAnnotationInstance$equals(Class r0, List r1, Map r2, Object r3) {
        return createAnnotationInstance$equals(r0, r1, r2, r3);
    }

    public static final /* synthetic */ int access$createAnnotationInstance$lambda$2(Lazy r0) {
        return createAnnotationInstance$lambda$2(r0);
    }

    public static final /* synthetic */ String access$createAnnotationInstance$lambda$3(Lazy r0) {
        return createAnnotationInstance$lambda$3(r0);
    }

    public static final /* synthetic */ Void access$throwIllegalArgumentType(int r0, String r1, Class r2) {
        return throwIllegalArgumentType(r0, r1, r2);
    }

    public static final /* synthetic */ Object access$transformKotlinToJvm(Object r0, Class r1) {
        return transformKotlinToJvm(r0, r1);
    }

    private static final Object transformKotlinToJvm(Object r6, Class<?> r7) {
        if ((r6 instanceof Class) == false) goto L6;
        return null;
    L6:
        if ((r6 instanceof KClass) == false) goto L9;
        r6 = JvmClassMappingKt.getJavaClass((KClass) r6);
    L21:
        if (r7.isInstance(r6) == true) goto L23;
        return null;
    L23:
        return r6;
    L9:
        if ((r6 instanceof Object[]) == false) goto L21;
        Object[] r0 = (Object[]) r6;
        if ((r0 instanceof Class[]) == false) goto L14;
        return null;
    L14:
        if ((r0 instanceof KClass[]) == false) goto L19;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
        KClass[] r8 = (KClass[]) r6;
        ArrayList r1 = new ArrayList(r8.length);
        int r2 = r8.length;
        int r4 = 0;
    L16:
        if (r4 >= r2) goto L18;
        r1.add(JvmClassMappingKt.getJavaClass(r8[r4]));
        r4 = r4 + 1;
        goto L16
    L18:
        r6 = r1.toArray(new Class[0]);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        goto L21
    L19:
        r6 = r0;
        goto L21
    }

    private static final Void throwIllegalArgumentType(int r3, String r4, Class<?> r5) {
        if (Intrinsics.areEqual(r5, Class.class) == false) goto L6;
        KClass r6 = Reflection.getOrCreateKotlinClass(KClass.class);
    L12:
        if (Intrinsics.areEqual(r6.getQualifiedName(), Reflection.getOrCreateKotlinClass(Object[].class).getQualifiedName()) == false) goto L14;
        StringBuilder r0 = new StringBuilder().append(r6.getQualifiedName()).append('<');
        Class<?> r7 = JvmClassMappingKt.getJavaClass(r6).getComponentType();
        Intrinsics.checkNotNullExpressionValue(r7, "kotlinClass.java.componentType");
        String r8 = r0.append(JvmClassMappingKt.getKotlinClass(r7).getQualifiedName()).append('>').toString();
    L16:
        throw new IllegalArgumentException("Argument #" + r3 + ' ' + r4 + " is not of the required type " + r8);
    L14:
        r8 = r6.getQualifiedName();
        goto L16
    L6:
        if (r5.isArray() == true) goto L8;
    L10:
        r6 = JvmClassMappingKt.getKotlinClass(r5);
        goto L12
    L8:
        if (Intrinsics.areEqual(r5.getComponentType(), Class.class) == false) goto L10;
        r6 = Reflection.getOrCreateKotlinClass(KClass[].class);
        goto L12
    }

    public static /* synthetic */ Object createAnnotationInstance$default(Class r1, Map r2, ArrayList r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L10;
        Set r6 = r2.keySet();
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        r7.add(r1.getDeclaredMethod((String) r8.next(), new Class[0]));
        goto L6
    L8:
        r3 = r7;
    L10:
        return createAnnotationInstance(r1, r2, r3);
    }

    private static final <T> boolean createAnnotationInstance$equals(Class<T> r4, List<Method> r5, Map<String, ? extends Object> r6, Object r7) {
        Class r1 = null;
        if ((r7 instanceof Annotation) == false) goto L5;
        Annotation r0 = (Annotation) r7;
    L6:
        if (r0 == null) goto L11;
        KClass r2 = JvmClassMappingKt.getAnnotationClass(r0);
        if (r2 == null) goto L11;
        r1 = JvmClassMappingKt.getJavaClass(r2);
    L11:
        if (Intrinsics.areEqual(r1, r4) == false) goto L66;
        List<Method> r8 = r5;
        if ((r8 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r9 = r8.iterator();
    L19:
        if (r9.hasNext() == false) goto L16;
        Method r10 = (Method) r9.next();
        Object r3 = r6.get(r10.getName());
        Object r11 = r10.invoke(r7, new Object[0]);
        if ((r3 instanceof boolean[]) == false) goto L24;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.BooleanArray");
        boolean r12 = Arrays.equals((boolean[]) r3, (boolean[]) r11);
    L48:
        if (r12 == true) goto L19;
        boolean r13 = false;
    L50:
        if (r13 == true) goto L52;
        return false;
    L52:
        return true;
    L24:
        if ((r3 instanceof char[]) == false) goto L27;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.CharArray");
        r12 = Arrays.equals((char[]) r3, (char[]) r11);
        goto L48
    L27:
        if ((r3 instanceof byte[]) == false) goto L30;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.ByteArray");
        r12 = Arrays.equals((byte[]) r3, (byte[]) r11);
        goto L48
    L30:
        if ((r3 instanceof short[]) == false) goto L33;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.ShortArray");
        r12 = Arrays.equals((short[]) r3, (short[]) r11);
        goto L48
    L33:
        if ((r3 instanceof int[]) == false) goto L36;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.IntArray");
        r12 = Arrays.equals((int[]) r3, (int[]) r11);
        goto L48
    L36:
        if ((r3 instanceof float[]) == false) goto L39;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.FloatArray");
        r12 = Arrays.equals((float[]) r3, (float[]) r11);
        goto L48
    L39:
        if ((r3 instanceof long[]) == false) goto L42;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.LongArray");
        r12 = Arrays.equals((long[]) r3, (long[]) r11);
        goto L48
    L42:
        if ((r3 instanceof double[]) == false) goto L45;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.DoubleArray");
        r12 = Arrays.equals((double[]) r3, (double[]) r11);
        goto L48
    L45:
        if ((r3 instanceof Object[]) == false) goto L47;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Array<*>");
        r12 = Arrays.equals((Object[]) r3, (Object[]) r11);
        goto L48
    L47:
        r12 = Intrinsics.areEqual(r3, r11);
    L16:
        r13 = true;
        goto L50
    L15:
        if (r8.isEmpty() == false) goto L17;
    L66:
        return false;
    L5:
        r0 = null;
        goto L6
    }

    public static final <T> T createAnnotationInstance(final Class<T> r9, final Map<String, ? extends Object> r10, final List<Method> r11) {
        Intrinsics.checkNotNullParameter(r9, "annotationClass");
        Intrinsics.checkNotNullParameter(r10, "values");
        Intrinsics.checkNotNullParameter(r11, "methods");
        final Lazy r5 = LazyKt.lazy(new AnnotationConstructorCallerKt$createAnnotationInstance$hashCode$2(r10));
        final Lazy r4 = LazyKt.lazy(new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(r9, r10));
        T r12 = (T) Proxy.newProxyInstance(r9.getClassLoader(), new Class[]{r9}, new AnnotationConstructorCallerKt$createAnnotationInstance$result$1(r9, r10, r4, r5, r11));
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return r12;
    }

    private static final int createAnnotationInstance$lambda$2(Lazy<Integer> r0) {
        return r0.getValue().intValue();
    }

    private static final String createAnnotationInstance$lambda$3(Lazy<String> r0) {
        return r0.getValue();
    }
}
