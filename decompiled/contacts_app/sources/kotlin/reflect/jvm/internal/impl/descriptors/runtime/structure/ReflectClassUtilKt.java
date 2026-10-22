package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import androidx.exifinterface.media.ExifInterface;
import com.android.vcard.VCardConstants;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: reflectClassUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectClassUtilKt {
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES = null;
    private static final List<KClass<? extends Object>> PRIMITIVE_CLASSES = null;
    private static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER = null;
    private static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE = null;

    public static final ClassLoader getSafeClassLoader(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ClassLoader r2 = r1.getClassLoader();
        if (r2 != null) goto L6;
        ClassLoader r3 = ClassLoader.getSystemClassLoader();
        Intrinsics.checkNotNullExpressionValue(r3, "getSystemClassLoader()");
        return r3;
    L6:
        return r2;
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Enum.class.isAssignableFrom(r1);
    }

    static {
        int r3 = 0;
        List<KClass<? extends Object>> r1 = CollectionsKt.listOf(new KClass[]{Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE)});
        PRIMITIVE_CLASSES = r1;
        List<KClass<? extends Object>> r2 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        KClass r12 = (KClass) r5.next();
        r4.add(TuplesKt.to(JvmClassMappingKt.getJavaObjectType(r12), JvmClassMappingKt.getJavaPrimitiveType(r12)));
        goto L4
    L6:
        WRAPPER_TO_PRIMITIVE = MapsKt.toMap(r4);
        List<KClass<? extends Object>> r6 = PRIMITIVE_CLASSES;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        KClass r13 = (KClass) r8.next();
        r7.add(TuplesKt.to(JvmClassMappingKt.getJavaPrimitiveType(r13), JvmClassMappingKt.getJavaObjectType(r13)));
        goto L8
    L10:
        PRIMITIVE_TO_WRAPPER = MapsKt.toMap(r7);
        List r0 = CollectionsKt.listOf(new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r10 = r0.iterator();
    L12:
        if (r10.hasNext() == false) goto L17;
        Object r11 = r10.next();
        int r14 = r3 + 1;
        if (r3 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        r9.add(TuplesKt.to((Class) r11, Integer.valueOf(r3)));
        r3 = r14;
        goto L12
    L17:
        FUNCTION_CLASSES = MapsKt.toMap(r9);
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return WRAPPER_TO_PRIMITIVE.get(r1);
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return PRIMITIVE_TO_WRAPPER.get(r1);
    }

    public static final Integer getFunctionClassArity(Class<?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return FUNCTION_CLASSES.get(r1);
    }

    public static final ClassId getClassId(Class<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.isPrimitive() == true) goto L29;
        if (r3.isArray() == true) goto L27;
        if (r3.getEnclosingMethod() == null) goto L9;
    L24:
        FqName r0 = new FqName(r3.getName());
        return new ClassId(r0.parent(), FqName.topLevel(r0.shortName()), true);
    L9:
        if (r3.getEnclosingConstructor() != null) goto L24;
        String r1 = r3.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r1, "simpleName");
        if (r1.length() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L24;
        Class<?> r4 = r3.getDeclaringClass();
        if (r4 == null) goto L22;
        ClassId r5 = getClassId(r4);
        if (r5 == null) goto L22;
        ClassId r6 = r5.createNestedClassId(Name.identifier(r3.getSimpleName()));
        if (r6 == null) goto L22;
    L23:
        Intrinsics.checkNotNullExpressionValue(r6, "declaringClass?.classId?…Id.topLevel(FqName(name))");
        return r6;
    L22:
        r6 = ClassId.topLevel(new FqName(r3.getName()));
        goto L23
    L13:
        r2 = false;
        goto L14
    L27:
        throw new IllegalArgumentException("Can't compute ClassId for array type: " + r3);
    L29:
        throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + r3);
    }

    public static final String getDesc(Class<?> r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r9.isPrimitive() == false) goto L39;
        String r0 = r9.getName();
        if (r0 == null) goto L37;
        switch(r0.hashCode()) {
            case -1325958191: goto L34;
            case 104431: goto L31;
            case 3039496: goto L28;
            case 3052374: goto L25;
            case 3327612: goto L22;
            case 3625364: goto L19;
            case 64711720: goto L16;
            case 97526364: goto L13;
            case 109413500: goto L10;
            default: goto L37;
        };
    L10:
        if (r0.equals("short") == false) goto L37;
        return ExifInterface.LATITUDE_SOUTH;
    L13:
        if (r0.equals("float") == false) goto L37;
        return "F";
    L16:
        if (r0.equals("boolean") == false) goto L37;
        return "Z";
    L19:
        if (r0.equals("void") == false) goto L37;
        return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
    L22:
        if (r0.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L37;
        return "J";
    L25:
        if (r0.equals("char") == false) goto L37;
        return "C";
    L28:
        if (r0.equals("byte") == false) goto L37;
        return VCardConstants.PARAM_ENCODING_B;
    L31:
        if (r0.equals("int") == false) goto L37;
        return "I";
    L34:
        if (r0.equals("double") == false) goto L37;
        return "D";
    L37:
        throw new IllegalArgumentException("Unsupported primitive type: " + r9);
    L39:
        if (r9.isArray() == false) goto L41;
        String r2 = r9.getName();
        Intrinsics.checkNotNullExpressionValue(r2, "name");
        return StringsKt.replace$default(r2, '.', '/', false, 4, null);
    L41:
        StringBuilder r1 = new StringBuilder("L");
        String r3 = r9.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "name");
        return r1.append(StringsKt.replace$default(r3, '.', '/', false, 4, null)).append(';').toString();
    }

    public static final List<Type> getParameterizedTypeArguments(Type r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof ParameterizedType) == false) goto L5;
        ParameterizedType r0 = (ParameterizedType) r2;
        if (r0.getOwnerType() != null) goto L11;
        Type[] r3 = r0.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(r3, "actualTypeArguments");
        return ArraysKt.toList(r3);
    L11:
        return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.generateSequence(r2, ReflectClassUtilKt$parameterizedTypeArguments$1.INSTANCE), ReflectClassUtilKt$parameterizedTypeArguments$2.INSTANCE));
    L5:
        return CollectionsKt.emptyList();
    }
}
