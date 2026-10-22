package e8;

import d7.i0;
import d7.s;
import d7.x;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet f3176a = i0.Z(x8.e.g("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");

    /* renamed from: b, reason: collision with root package name */
    public static final LinkedHashSet f3177b;

    /* renamed from: c, reason: collision with root package name */
    public static final LinkedHashSet f3178c;

    /* renamed from: d, reason: collision with root package name */
    public static final LinkedHashSet f3179d;

    /* renamed from: e, reason: collision with root package name */
    public static final LinkedHashSet f3180e;

    /* renamed from: f, reason: collision with root package name */
    public static final LinkedHashSet f3181f;

    static {
        List<m9.c> listU0 = s.u0(m9.c.BOOLEAN, m9.c.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (m9.c cVar : listU0) {
            String strB = cVar.e().f().b();
            q7.k.d(strB, "it.wrapperFqName.shortName().asString()");
            x.D0(linkedHashSet, x8.e.f(strB, cVar.f6469g + "Value()" + cVar.c()));
        }
        f3177b = i0.Y(i0.Y(i0.Y(i0.Y(i0.Y(i0.Y(linkedHashSet, x8.e.g("List", "sort(Ljava/util/Comparator;)V")), x8.e.f("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), x8.e.f("Double", "isInfinite()Z", "isNaN()Z")), x8.e.f("Float", "isInfinite()Z", "isNaN()Z")), x8.e.f("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), x8.e.f("CharSequence", "isEmpty()Z"));
        f3178c = i0.Y(i0.Y(i0.Y(i0.Y(i0.Y(i0.Y(x8.e.f("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), x8.e.g("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), x8.e.f("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), x8.e.f("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), x8.e.g("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), x8.e.g("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), x8.e.g("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        f3179d = i0.Y(i0.Y(x8.e.g("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), x8.e.g("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), x8.e.g("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        m9.c cVar2 = m9.c.BOOLEAN;
        m9.c cVar3 = m9.c.BYTE;
        List listU02 = s.u0(cVar2, cVar3, m9.c.DOUBLE, m9.c.FLOAT, cVar3, m9.c.INT, m9.c.LONG, m9.c.SHORT);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it = listU02.iterator();
        while (it.hasNext()) {
            String strB2 = ((m9.c) it.next()).e().f().b();
            q7.k.d(strB2, "it.wrapperFqName.shortName().asString()");
            String[] strArrA = x8.e.a("Ljava/lang/String;");
            x.D0(linkedHashSet2, x8.e.f(strB2, (String[]) Arrays.copyOf(strArrA, strArrA.length)));
        }
        String[] strArrA2 = x8.e.a("D");
        LinkedHashSet linkedHashSetY = i0.Y(linkedHashSet2, x8.e.f("Float", (String[]) Arrays.copyOf(strArrA2, strArrA2.length)));
        String[] strArrA3 = x8.e.a("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        f3180e = i0.Y(linkedHashSetY, x8.e.f("String", (String[]) Arrays.copyOf(strArrA3, strArrA3.length)));
        String[] strArrA4 = x8.e.a("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        f3181f = x8.e.f("Throwable", (String[]) Arrays.copyOf(strArrA4, strArrA4.length));
    }
}
