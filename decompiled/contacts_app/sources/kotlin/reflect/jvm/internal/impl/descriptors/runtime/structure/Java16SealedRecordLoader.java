package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes4.dex */
final class Java16SealedRecordLoader {
    public static final Java16SealedRecordLoader INSTANCE = null;
    private static Cache _cache;

    /* JADX INFO: compiled from: ReflectJavaClass.kt */
    public static final class Cache {
        private final Method getPermittedSubclasses;
        private final Method getRecordComponents;
        private final Method isRecord;
        private final Method isSealed;

        public Cache(Method r1, Method r2, Method r3, Method r4) {
            this.isSealed = r1;
            this.getPermittedSubclasses = r2;
            this.isRecord = r3;
            this.getRecordComponents = r4;
        }

        public final Method isSealed() {
            return this.isSealed;
        }

        public final Method getGetPermittedSubclasses() {
            return this.getPermittedSubclasses;
        }

        public final Method isRecord() {
            return this.isRecord;
        }

        public final Method getGetRecordComponents() {
            return this.getRecordComponents;
        }
    }

    static {
        INSTANCE = new Java16SealedRecordLoader();
    }

    private Java16SealedRecordLoader() {
    }

    private final Cache buildCache() {
        return new Cache(Class.class.getMethod("isSealed", new Class[0]), Class.class.getMethod("getPermittedSubclasses", new Class[0]), Class.class.getMethod("isRecord", new Class[0]), Class.class.getMethod("getRecordComponents", new Class[0]));
    L6:
        return new Cache(null, null, null, null);
    }

    private final Cache initCache() {
        Cache r0 = _cache;
        if (r0 != null) goto L6;
        Cache r1 = buildCache();
        _cache = r1;
        return r1;
    L6:
        return r0;
    }

    public final Boolean loadIsSealed(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Method r1 = initCache().isSealed();
        if (r1 != null) goto L6;
        return null;
    L6:
        Object r3 = r1.invoke(r2, new Object[0]);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) r3;
    }

    public final Class<?>[] loadGetPermittedSubclasses(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Method r1 = initCache().getGetPermittedSubclasses();
        if (r1 != null) goto L6;
        return null;
    L6:
        Object r3 = r1.invoke(r2, new Object[0]);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) r3;
    }

    public final Boolean loadIsRecord(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Method r1 = initCache().isRecord();
        if (r1 != null) goto L6;
        return null;
    L6:
        Object r3 = r1.invoke(r2, new Object[0]);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) r3;
    }

    public final Object[] loadGetRecordComponents(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Method r1 = initCache().getGetRecordComponents();
        if (r1 != null) goto L7;
        return null;
    L7:
        return (Object[]) r1.invoke(r2, new Object[0]);
    }
}
