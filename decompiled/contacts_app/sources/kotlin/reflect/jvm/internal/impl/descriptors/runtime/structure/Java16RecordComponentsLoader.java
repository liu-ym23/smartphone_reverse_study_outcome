package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReflectJavaRecordComponent.kt */
/* JADX INFO: loaded from: classes4.dex */
final class Java16RecordComponentsLoader {
    public static final Java16RecordComponentsLoader INSTANCE = null;
    private static Cache _cache;

    /* JADX INFO: compiled from: ReflectJavaRecordComponent.kt */
    public static final class Cache {
        private final Method getAccessor;
        private final Method getType;

        public Cache(Method r1, Method r2) {
            this.getType = r1;
            this.getAccessor = r2;
        }

        public final Method getGetType() {
            return this.getType;
        }

        public final Method getGetAccessor() {
            return this.getAccessor;
        }
    }

    static {
        INSTANCE = new Java16RecordComponentsLoader();
    }

    private Java16RecordComponentsLoader() {
    }

    private final Cache buildCache(Object r4) {
        Class<?> r3 = r4.getClass();
        return new Cache(r3.getMethod("getType", new Class[0]), r3.getMethod("getAccessor", new Class[0]));
    L6:
        return new Cache(null, null);
    }

    private final Cache initCache(Object r2) {
        Cache r0 = _cache;
        if (r0 != null) goto L6;
        Cache r1 = buildCache(r2);
        _cache = r1;
        return r1;
    L6:
        return r0;
    }

    public final Class<?> loadGetType(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "recordComponent");
        Method r1 = initCache(r2).getGetType();
        if (r1 != null) goto L6;
        return null;
    L6:
        Object r3 = r1.invoke(r2, new Object[0]);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) r3;
    }

    public final Method loadGetAccessor(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "recordComponent");
        Method r1 = initCache(r2).getGetAccessor();
        if (r1 != null) goto L6;
        return null;
    L6:
        Object r3 = r1.invoke(r2, new Object[0]);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) r3;
    }
}
