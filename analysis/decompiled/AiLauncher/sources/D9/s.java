package D9;

import C9.o;
import Z8.A;
import Z8.C1173v;
import Z8.Z;
import ba.x;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes5.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f2313a;

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f2314b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set<String> f2315c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set<String> f2316d;

    /* renamed from: e, reason: collision with root package name */
    public static final Set<String> f2317e;

    /* renamed from: f, reason: collision with root package name */
    public static final Set<String> f2318f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set<String> f2319g;

    /* renamed from: h, reason: collision with root package name */
    public static final Set<String> f2320h;

    static {
        s sVar = new s();
        f2313a = sVar;
        x xVar = x.f15368a;
        f2314b = Z.p(xVar.f(CoreUtil.STR_DEX_COLLECTION_NAME, "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        f2315c = Z.o(Z.o(Z.o(Z.o(Z.o(Z.o(sVar.b(), xVar.f("List", "sort(Ljava/util/Comparator;)V", "reversed()Ljava/util/List;")), xVar.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), xVar.e("Double", "isInfinite()Z", "isNaN()Z")), xVar.e("Float", "isInfinite()Z", "isNaN()Z")), xVar.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), xVar.e("CharSequence", "isEmpty()Z"));
        f2316d = xVar.f("List", "getFirst()Ljava/lang/Object;", "getLast()Ljava/lang/Object;");
        f2317e = Z.o(Z.o(Z.o(Z.o(Z.o(Z.o(xVar.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), xVar.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), xVar.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), xVar.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), xVar.f(CoreUtil.STR_DEX_COLLECTION_NAME, "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), xVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;")), xVar.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        f2318f = Z.o(Z.o(xVar.f(CoreUtil.STR_DEX_COLLECTION_NAME, "removeIf(Ljava/util/function/Predicate;)Z"), xVar.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V", "addFirst(Ljava/lang/Object;)V", "addLast(Ljava/lang/Object;)V", "removeFirst()Ljava/lang/Object;", "removeLast()Ljava/lang/Object;")), xVar.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        Set<String> setA = sVar.a();
        String[] strArrB = xVar.b("D");
        Set setO = Z.o(setA, xVar.e("Float", (String[]) Arrays.copyOf(strArrB, strArrB.length)));
        String[] strArrB2 = xVar.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        f2319g = Z.o(setO, xVar.e("String", (String[]) Arrays.copyOf(strArrB2, strArrB2.length)));
        String[] strArrB3 = xVar.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f2320h = xVar.e("Throwable", (String[]) Arrays.copyOf(strArrB3, strArrB3.length));
    }

    public final Set<String> a() {
        x xVar = x.f15368a;
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.BYTE;
        List listP = C1173v.p(jvmPrimitiveType, jvmPrimitiveType2, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, jvmPrimitiveType2, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            String strB = ((JvmPrimitiveType) it.next()).getWrapperFqName().f().b();
            kotlin.jvm.internal.p.h(strB, "asString(...)");
            String[] strArrB = xVar.b("Ljava/lang/String;");
            A.E(linkedHashSet, xVar.e(strB, (String[]) Arrays.copyOf(strArrB, strArrB.length)));
        }
        return linkedHashSet;
    }

    public final Set<String> b() {
        x xVar = x.f15368a;
        List<JvmPrimitiveType> listP = C1173v.p(JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JvmPrimitiveType jvmPrimitiveType : listP) {
            String strB = jvmPrimitiveType.getWrapperFqName().f().b();
            kotlin.jvm.internal.p.h(strB, "asString(...)");
            A.E(linkedHashSet, xVar.e(strB, jvmPrimitiveType.getJavaKeywordName() + "Value()" + jvmPrimitiveType.getDesc()));
        }
        return linkedHashSet;
    }

    public final Set<String> c() {
        return f2316d;
    }

    public final Set<String> d() {
        return f2314b;
    }

    public final Set<String> e() {
        return f2319g;
    }

    public final Set<String> f() {
        return f2315c;
    }

    public final Set<String> g() {
        return f2318f;
    }

    public final Set<String> h() {
        return f2320h;
    }

    public final Set<String> i() {
        return f2317e;
    }

    public final boolean j(ga.d fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return kotlin.jvm.internal.p.d(fqName, o.a.f1910i) || C9.o.e(fqName);
    }

    public final boolean k(ga.d fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        if (j(fqName)) {
            return true;
        }
        ga.b bVarN = a.f2270a.n(fqName);
        if (bVarN == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(bVarN.a().a()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
