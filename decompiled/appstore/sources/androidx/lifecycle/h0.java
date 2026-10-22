package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f3538a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f3539b = null;

    static {
        f3538a = kotlin.collections.t.l(new Class[]{Application.class, b0.class});
        f3539b = kotlin.collections.s.e(b0.class);
    }

    public static final /* synthetic */ List a() {
        return f3538a;
    }

    public static final /* synthetic */ List b() {
        return f3539b;
    }

    public static final Constructor c(Class r10, List r11) {
        kotlin.jvm.internal.q.g(r10, "modelClass");
        kotlin.jvm.internal.q.g(r11, "signature");
        Constructor<?>[] r12 = r10.getConstructors();
        kotlin.jvm.internal.q.f(r12, "modelClass.constructors");
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L16;
        Constructor<?> r15 = r12[r14];
        Class<?>[] r16 = r15.getParameterTypes();
        kotlin.jvm.internal.q.f(r16, "constructor.parameterTypes");
        List r17 = kotlin.collections.n.K(r16);
        if (kotlin.jvm.internal.q.b(r11, r17) == true) goto L6;
        if (r11.size() != r17.size()) goto L15;
        if (r17.containsAll(r11) == false) goto L15;
        throw new UnsupportedOperationException("Class " + r10.getSimpleName() + " must have parameters in the proper order: " + r11);
    L15:
        r14 = r14 + 1;
        goto L3
    L6:
        kotlin.jvm.internal.q.e(r15, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
        return r15;
    L16:
        return null;
    }

    public static final k0 d(Class r10, Constructor r11, Object... r12) {
        kotlin.jvm.internal.q.g(r10, "modelClass");
        kotlin.jvm.internal.q.g(r11, "constructor");
        kotlin.jvm.internal.q.g(r12, "params");
        return (k0) r11.newInstance(Arrays.copyOf(r12, r12.length));
    L9:
        e = move-exception;
        throw new RuntimeException("Failed to access " + r10, e);
    L7:
        e = move-exception;
        throw new RuntimeException("A " + r10 + " cannot be instantiated.", e);
    L5:
        e = move-exception;
        throw new RuntimeException("An exception happened in constructor of " + r10, e.getCause());
    }
}
