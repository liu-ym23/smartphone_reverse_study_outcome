package reactor.core;

import a8.b;
import a8.e;
import com.fasterxml.jackson.databind.util.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import reactor.util.annotation.Nullable;
import reactor.util.function.Tuple2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@FunctionalInterface
/* loaded from: classes.dex */
public interface Scannable {
    public static final Pattern OPERATOR_NAME_UNRELATED_WORDS_PATTERN = Pattern.compile("Parallel|Flux|Mono|Publisher|Subscriber|Fuseable|Operator|Conditional");

    static Scannable from(@Nullable Object obj) {
        return obj == null ? Attr.NULL_SCAN : obj instanceof Scannable ? (Scannable) obj : Attr.UNAVAILABLE_SCAN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ String lambda$name$0(Scannable scannable) {
        return (String) scannable.scan(Attr.NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Stream lambda$tags$1(Scannable scannable) {
        return (Stream) scannable.scanOrDefault(Attr.TAGS, Stream.empty());
    }

    default Stream<? extends Scannable> actuals() {
        return Attr.recurse(this, Attr.ACTUAL);
    }

    default Stream<? extends Scannable> inners() {
        return Stream.empty();
    }

    default boolean isScanAvailable() {
        return true;
    }

    default String name() {
        String str = (String) scan(Attr.NAME);
        return str != null ? str : (String) parents().map(new b(28)).filter(new e(1)).findFirst().orElse(stepName());
    }

    default Stream<? extends Scannable> parents() {
        return Attr.recurse(this, Attr.PARENT);
    }

    @Nullable
    default <T> T scan(Attr<T> attr) {
        T tTryConvert = attr.tryConvert(scanUnsafe(attr));
        return tTryConvert == null ? attr.defaultValue() : tTryConvert;
    }

    default <T> T scanOrDefault(Attr<T> attr, T t10) {
        T tTryConvert = attr.tryConvert(scanUnsafe(attr));
        if (tTryConvert != null) {
            return tTryConvert;
        }
        Objects.requireNonNull(t10, "defaultValue");
        return t10;
    }

    @Nullable
    Object scanUnsafe(Attr attr);

    default String stepName() {
        String name = getClass().getName();
        int iIndexOf = name.indexOf(36);
        if (iIndexOf != -1) {
            name = name.substring(0, iIndexOf);
        }
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            name = name.substring(iLastIndexOf + 1);
        }
        String strReplaceAll = OPERATOR_NAME_UNRELATED_WORDS_PATTERN.matcher(name).replaceAll("");
        if (strReplaceAll.isEmpty()) {
            return strReplaceAll;
        }
        return strReplaceAll.substring(0, 1).toLowerCase() + strReplaceAll.substring(1);
    }

    default Stream<String> steps() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((Collection) parents().collect(Collectors.toList()));
        Collections.reverse(arrayList);
        arrayList.add(this);
        arrayList.addAll((Collection) actuals().collect(Collectors.toList()));
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int i = 0;
        while (i < arrayList.size()) {
            Scannable scannable = (Scannable) arrayList.get(i);
            Scannable scannable2 = i < arrayList.size() + (-1) ? (Scannable) arrayList.get(i + 1) : null;
            if (scannable2 == null || !((Boolean) scannable2.scan(Attr.ACTUAL_METADATA)).booleanValue()) {
                arrayList2.add(scannable.stepName());
            } else {
                arrayList2.add(scannable2.stepName());
                i++;
            }
            i++;
        }
        return arrayList2.stream();
    }

    default Stream<Tuple2<String, String>> tags() {
        LinkedList linkedList = new LinkedList();
        while (this != null && this.isScanAvailable()) {
            linkedList.add(0, this);
            this = (Scannable) this.scan(Attr.PARENT);
        }
        return linkedList.stream().flatMap(new b(27));
    }

    default Map<String, String> tagsDeduplicated() {
        return (Map) tags().collect(Collectors.toMap(new b(25), new b(26), new a(1), new com.fasterxml.jackson.core.util.a(3)));
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Attr<T> {
        public static final Attr<Scannable> ACTUAL = new Attr<>(null, new b(29));
        public static final Attr<Boolean> ACTUAL_METADATA;
        public static final Attr<Integer> BUFFERED;
        public static final Attr<Boolean> CANCELLED;
        public static final Attr<Integer> CAPACITY;
        public static final Attr<Boolean> DELAY_ERROR;
        public static final Attr<Throwable> ERROR;
        public static final Attr<Long> LARGE_BUFFERED;
        public static final Attr<String> LIFTER;
        public static final Attr<String> NAME;
        static final Scannable NULL_SCAN;
        public static final Attr<Scannable> PARENT;
        public static final Attr<Integer> PREFETCH;
        public static final Attr<Long> REQUESTED_FROM_DOWNSTREAM;
        public static final Attr<Scannable> RUN_ON;
        public static final Attr<RunStyle> RUN_STYLE;
        public static final Attr<Stream<Tuple2<String, String>>> TAGS;
        public static final Attr<Boolean> TERMINATED;
        static final Scannable UNAVAILABLE_SCAN;
        final T defaultValue;
        final Function<Object, ? extends T> safeConverter;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public enum RunStyle {
            UNKNOWN,
            ASYNC,
            SYNC
        }

        static {
            Boolean bool = Boolean.FALSE;
            ACTUAL_METADATA = new Attr<>(bool);
            BUFFERED = new Attr<>(0);
            CAPACITY = new Attr<>(0);
            CANCELLED = new Attr<>(bool);
            DELAY_ERROR = new Attr<>(bool);
            ERROR = new Attr<>(null);
            LARGE_BUFFERED = new Attr<>(null);
            NAME = new Attr<>(null);
            int i = 29;
            PARENT = new Attr<>(null, new b(i));
            RUN_ON = new Attr<>(null, new b(i));
            PREFETCH = new Attr<>(0);
            REQUESTED_FROM_DOWNSTREAM = new Attr<>(0L);
            TERMINATED = new Attr<>(bool);
            TAGS = new Attr<>(null);
            RUN_STYLE = new Attr<>(RunStyle.UNKNOWN);
            LIFTER = new Attr<>(null);
            UNAVAILABLE_SCAN = new Scannable() { // from class: reactor.core.Scannable.Attr.1
                @Override // reactor.core.Scannable
                public boolean isScanAvailable() {
                    return false;
                }

                @Override // reactor.core.Scannable
                public Object scanUnsafe(Attr attr) {
                    return null;
                }

                @Override // reactor.core.Scannable
                public String stepName() {
                    return "UNAVAILABLE_SCAN";
                }

                public String toString() {
                    return "UNAVAILABLE_SCAN";
                }
            };
            NULL_SCAN = new Scannable() { // from class: reactor.core.Scannable.Attr.2
                @Override // reactor.core.Scannable
                public boolean isScanAvailable() {
                    return false;
                }

                @Override // reactor.core.Scannable
                public Object scanUnsafe(Attr attr) {
                    return null;
                }

                @Override // reactor.core.Scannable
                public String stepName() {
                    return "NULL_SCAN";
                }

                public String toString() {
                    return "NULL_SCAN";
                }
            };
        }

        public Attr(@Nullable T t10, @Nullable Function<Object, ? extends T> function) {
            this.defaultValue = t10;
            this.safeConverter = function;
        }

        public static Stream<? extends Scannable> recurse(Scannable scannable, Attr<Scannable> attr) {
            Scannable scannableFrom = Scannable.from(scannable.scan(attr));
            return !scannableFrom.isScanAvailable() ? Stream.empty() : StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<Scannable>(attr) { // from class: reactor.core.Scannable.Attr.3

                /* renamed from: c, reason: collision with root package name */
                Scannable f10580c;
                final /* synthetic */ Attr val$key;

                {
                    this.val$key = attr;
                    this.f10580c = this.val$s;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    Scannable scannable2 = this.f10580c;
                    return scannable2 != null && scannable2.isScanAvailable();
                }

                @Override // java.util.Iterator
                public Scannable next() {
                    Scannable scannable2 = this.f10580c;
                    this.f10580c = Scannable.from(scannable2.scan(this.val$key));
                    return scannable2;
                }
            }, 0), false);
        }

        @Nullable
        public T defaultValue() {
            return this.defaultValue;
        }

        public boolean isConversionSafe() {
            return this.safeConverter != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public T tryConvert(@Nullable Object obj) {
            if (obj == 0) {
                return null;
            }
            Function<Object, ? extends T> function = this.safeConverter;
            return function == null ? obj : function.apply(obj);
        }

        public Attr(@Nullable T t10) {
            this(t10, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ String lambda$tagsDeduplicated$2(String str, String str2) {
        return str2;
    }
}
