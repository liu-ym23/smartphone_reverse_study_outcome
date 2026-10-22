package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KAnnotatedElements.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J \u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/full/Java8RepeatableContainerLoader;", "", "()V", "cache", "Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;", "getCache", "()Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;", "setCache", "(Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;)V", "buildCache", "loadRepeatableContainer", "Ljava/lang/Class;", "", "klass", "Cache", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class Java8RepeatableContainerLoader {
    public static final Java8RepeatableContainerLoader INSTANCE = null;
    private static Cache cache;

    /* JADX INFO: compiled from: KAnnotatedElements.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u001b\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/full/Java8RepeatableContainerLoader$Cache;", "", "repeatableClass", "Ljava/lang/Class;", "", "valueMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/lang/reflect/Method;)V", "getRepeatableClass", "()Ljava/lang/Class;", "getValueMethod", "()Ljava/lang/reflect/Method;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Cache {
        private final Class<? extends Annotation> repeatableClass;
        private final Method valueMethod;

        public Cache(Class<? extends Annotation> r1, Method r2) {
            this.repeatableClass = r1;
            this.valueMethod = r2;
        }

        public final Class<? extends Annotation> getRepeatableClass() {
            return this.repeatableClass;
        }

        public final Method getValueMethod() {
            return this.valueMethod;
        }
    }

    static {
        INSTANCE = new Java8RepeatableContainerLoader();
    }

    private Java8RepeatableContainerLoader() {
    }

    private final Cache buildCache() {
        Class<?> r3 = Class.forName("java.lang.annotation.Repeatable");     // Catch: ClassNotFoundException -> L5
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");     // Catch: ClassNotFoundException -> L5
        return new Cache(r3, r3.getMethod("value", new Class[0]));
    L6:
        return new Cache(null, null);
    }

    public final Class<? extends Annotation> loadRepeatableContainer(Class<? extends Annotation> r3) {
        Intrinsics.checkNotNullParameter(r3, "klass");
        Cache r0 = cache;
        if (r0 != null) goto L15;
        monitor-enter(this);
        Java8RepeatableContainerLoader r1 = INSTANCE;     // Catch: Throwable -> L12
        Cache r2 = cache;     // Catch: Throwable -> L12
        if (r2 != null) goto L9;
        r0 = r1.buildCache();     // Catch: Throwable -> L12
        cache = r0;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        goto L15
    L9:
        r0 = r2;
    L12:
        th = move-exception;
        throw th;
    L15:
        Class r4 = r0.getRepeatableClass();
        if (r4 != null) goto L18;
        return null;
    L18:
        Annotation r5 = r3.getAnnotation(r4);
        if (r5 != null) goto L21;
        return null;
    L21:
        Method r6 = r0.getValueMethod();
        if (r6 != null) goto L24;
        return null;
    L24:
        Object r7 = r6.invoke(r5, new Object[0]);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");
        return (Class) r7;
    }
}
