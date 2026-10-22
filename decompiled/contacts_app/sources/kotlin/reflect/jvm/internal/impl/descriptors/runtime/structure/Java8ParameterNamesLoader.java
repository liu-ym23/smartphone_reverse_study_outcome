package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes4.dex */
final class Java8ParameterNamesLoader {
    public static final Java8ParameterNamesLoader INSTANCE = null;
    private static Cache cache;

    /* JADX INFO: compiled from: ReflectJavaMember.kt */
    public static final class Cache {
        private final Method getName;
        private final Method getParameters;

        public Cache(Method r1, Method r2) {
            this.getParameters = r1;
            this.getName = r2;
        }

        public final Method getGetName() {
            return this.getName;
        }

        public final Method getGetParameters() {
            return this.getParameters;
        }
    }

    static {
        INSTANCE = new Java8ParameterNamesLoader();
    }

    private Java8ParameterNamesLoader() {
    }

    public final Cache buildCache(Member r4) {
        Intrinsics.checkNotNullParameter(r4, "member");
        Class<?> r3 = r4.getClass();
        Method r5 = r3.getMethod("getParameters", new Class[0]);     // Catch: NoSuchMethodException -> L6
        return new Cache(r5, ReflectClassUtilKt.getSafeClassLoader(r3).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
    L7:
        return new Cache(null, null);
    }

    public final List<String> loadParameterNames(Member r7) {
        Intrinsics.checkNotNullParameter(r7, "member");
        Cache r0 = cache;
        if (r0 != null) goto L15;
        monitor-enter(this);
        Java8ParameterNamesLoader r1 = INSTANCE;     // Catch: Throwable -> L12
        Cache r2 = cache;     // Catch: Throwable -> L12
        if (r2 != null) goto L9;
        r0 = r1.buildCache(r7);     // Catch: Throwable -> L12
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
        Method r6 = r0.getGetParameters();
        if (r6 != null) goto L18;
        return null;
    L18:
        Method r3 = r0.getGetName();
        if (r3 != null) goto L21;
        return null;
    L21:
        Object r8 = r6.invoke(r7, new Object[0]);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] r9 = (Object[]) r8;
        ArrayList r10 = new ArrayList(r9.length);
        int r4 = r9.length;
        int r5 = 0;
    L22:
        if (r5 >= r4) goto L25;
        Object r11 = r3.invoke(r9[r5], new Object[0]);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.String");
        r10.add((String) r11);
        r5 = r5 + 1;
        goto L22
    L25:
        return r10;
    }
}
