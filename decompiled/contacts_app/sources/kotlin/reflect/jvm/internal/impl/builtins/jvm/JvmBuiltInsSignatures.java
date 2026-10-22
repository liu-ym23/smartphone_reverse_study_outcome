package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: compiled from: JvmBuiltInsSignatures.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class JvmBuiltInsSignatures {
    private static final Set<String> DROP_LIST_METHOD_SIGNATURES = null;
    private static final Set<String> HIDDEN_CONSTRUCTOR_SIGNATURES = null;
    private static final Set<String> HIDDEN_METHOD_SIGNATURES = null;
    public static final JvmBuiltInsSignatures INSTANCE = null;
    private static final Set<String> MUTABLE_METHOD_SIGNATURES = null;
    private static final Set<String> VISIBLE_CONSTRUCTOR_SIGNATURES = null;
    private static final Set<String> VISIBLE_METHOD_SIGNATURES = null;

    private JvmBuiltInsSignatures() {
    }

    public final Set<String> getDROP_LIST_METHOD_SIGNATURES() {
        return DROP_LIST_METHOD_SIGNATURES;
    }

    static {
        JvmBuiltInsSignatures r0 = new JvmBuiltInsSignatures();
        INSTANCE = r0;
        DROP_LIST_METHOD_SIGNATURES = SetsKt.plus(SignatureBuildingComponents.INSTANCE.inJavaUtil("Collection", new String[]{"toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"}), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        SignatureBuildingComponents r1 = SignatureBuildingComponents.INSTANCE;
        HIDDEN_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(r0.buildPrimitiveValueMethodsSet(), r1.inJavaUtil("List", new String[]{"sort(Ljava/util/Comparator;)V"})), r1.inJavaLang("String", new String[]{"codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;"})), r1.inJavaLang("Double", new String[]{"isInfinite()Z", "isNaN()Z"})), r1.inJavaLang("Float", new String[]{"isInfinite()Z", "isNaN()Z"})), r1.inJavaLang("Enum", new String[]{"getDeclaringClass()Ljava/lang/Class;", "finalize()V"})), r1.inJavaLang("CharSequence", new String[]{"isEmpty()Z"}));
        SignatureBuildingComponents r2 = SignatureBuildingComponents.INSTANCE;
        VISIBLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(r2.inJavaLang("CharSequence", new String[]{"codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"}), r2.inJavaUtil("Iterator", new String[]{"forEachRemaining(Ljava/util/function/Consumer;)V"})), r2.inJavaLang("Iterable", new String[]{"forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;"})), r2.inJavaLang("Throwable", new String[]{"setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V"})), r2.inJavaUtil("Collection", new String[]{"spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z"})), r2.inJavaUtil("List", new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V"})), r2.inJavaUtil("Map", new String[]{"getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"}));
        SignatureBuildingComponents r3 = SignatureBuildingComponents.INSTANCE;
        MUTABLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(r3.inJavaUtil("Collection", new String[]{"removeIf(Ljava/util/function/Predicate;)Z"}), r3.inJavaUtil("List", new String[]{"replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V"})), r3.inJavaUtil("Map", new String[]{"computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"}));
        SignatureBuildingComponents r4 = SignatureBuildingComponents.INSTANCE;
        Set<String> r5 = r0.buildPrimitiveStringConstructorsSet();
        String[] r6 = r4.constructors(new String[]{"D"});
        Set r7 = SetsKt.plus(r5, r4.inJavaLang("Float", (String[]) Arrays.copyOf(r6, r6.length)));
        String[] r8 = r4.constructors(new String[]{"[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;"});
        HIDDEN_CONSTRUCTOR_SIGNATURES = SetsKt.plus(r7, r4.inJavaLang("String", (String[]) Arrays.copyOf(r8, r8.length)));
        SignatureBuildingComponents r9 = SignatureBuildingComponents.INSTANCE;
        String[] r10 = r9.constructors(new String[]{"Ljava/lang/String;Ljava/lang/Throwable;ZZ"});
        VISIBLE_CONSTRUCTOR_SIGNATURES = r9.inJavaLang("Throwable", (String[]) Arrays.copyOf(r10, r10.length));
    }

    public final Set<String> getHIDDEN_METHOD_SIGNATURES() {
        return HIDDEN_METHOD_SIGNATURES;
    }

    public final Set<String> getVISIBLE_METHOD_SIGNATURES() {
        return VISIBLE_METHOD_SIGNATURES;
    }

    public final Set<String> getMUTABLE_METHOD_SIGNATURES() {
        return MUTABLE_METHOD_SIGNATURES;
    }

    public final Set<String> getHIDDEN_CONSTRUCTOR_SIGNATURES() {
        return HIDDEN_CONSTRUCTOR_SIGNATURES;
    }

    public final Set<String> getVISIBLE_CONSTRUCTOR_SIGNATURES() {
        return VISIBLE_CONSTRUCTOR_SIGNATURES;
    }

    public final boolean isSerializableInJava(FqNameUnsafe r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        if (isArrayOrPrimitiveArray(r2) == false) goto L6;
        return true;
    L6:
        ClassId r1 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r2);
        if (r1 != null) goto L13;
        return false;
    L13:
        return Serializable.class.isAssignableFrom(Class.forName(r1.asSingleFqName().asString()));
    L12:
        return false;
    }

    public final boolean isArrayOrPrimitiveArray(FqNameUnsafe r1) {
        Intrinsics.checkNotNullParameter(r1, "fqName");
        if (Intrinsics.areEqual(r1, StandardNames.FqNames.array) == false) goto L5;
    L8:
        return true;
    L5:
        if (StandardNames.isPrimitiveArray(r1) == true) goto L8;
        return false;
    }

    private final Set<String> buildPrimitiveValueMethodsSet() {
        SignatureBuildingComponents r9 = SignatureBuildingComponents.INSTANCE;
        List r0 = CollectionsKt.listOf(new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR});
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        JvmPrimitiveType r4 = (JvmPrimitiveType) r2.next();
        String r5 = r4.getWrapperFqName().shortName().asString();
        Intrinsics.checkNotNullExpressionValue(r5, "it.wrapperFqName.shortName().asString()");
        CollectionsKt.addAll(r1, r9.inJavaLang(r5, new String[]{r4.getJavaKeywordName() + "Value()" + r4.getDesc()}));
        goto L4
    L7:
        return r1;
    }

    private final Set<String> buildPrimitiveStringConstructorsSet() {
        SignatureBuildingComponents r5 = SignatureBuildingComponents.INSTANCE;
        List r0 = CollectionsKt.listOf(new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.BYTE, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, JvmPrimitiveType.BYTE, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT});
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        String r3 = ((JvmPrimitiveType) r2.next()).getWrapperFqName().shortName().asString();
        Intrinsics.checkNotNullExpressionValue(r3, "it.wrapperFqName.shortName().asString()");
        String[] r4 = r5.constructors(new String[]{"Ljava/lang/String;"});
        CollectionsKt.addAll(r1, r5.inJavaLang(r3, (String[]) Arrays.copyOf(r4, r4.length)));
        goto L4
    L7:
        return r1;
    }
}
