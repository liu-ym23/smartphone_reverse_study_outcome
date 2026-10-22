package androidx.lifecycle;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SavedStateViewModelFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Class<?>> f2008a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Class<?>> f2009b = null;

    public static final /* synthetic */ List a() {
        return f2008a;
    }

    public static final /* synthetic */ List b() {
        return f2009b;
    }

    public static final <T extends aj> T a(Class<T> r3, Constructor<T> r4, Object... r5) {
        d.h.b.o.e(r3, "modelClass");
        d.h.b.o.e(r4, "constructor");
        d.h.b.o.e(r5, "params");
        return (T) ZeusTransformUtils.preCheckCast(r4.newInstance(Arrays.copyOf(r5, r5.length)), aj.class, "com.obric.aiagent.plugin");
    L11:
        e = move-exception;
        throw new RuntimeException("Failed to access " + r3, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L8:
        e = move-exception;
        throw new RuntimeException("A " + r3 + " cannot be instantiated.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L5:
        e = move-exception;
        throw new RuntimeException("An exception happened in constructor of " + r3, e.getCause());
    }

    static {
        f2008a = d.a.p.b(new Class[]{Application.class, ac.class});
        f2009b = d.a.p.a(ac.class);
    }

    public static final <T> Constructor<T> a(Class<T> r7, List<? extends Class<?>> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "modelClass");
        d.h.b.o.e(r9, "signature");
        Object[] r0 = r7.getConstructors();
        d.h.b.o.c(r0, "modelClass.constructors");
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L16;
        Constructor<T> r4 = (Constructor<T>) r0[r3];
        Class<?>[] r5 = r4.getParameterTypes();
        d.h.b.o.c(r5, "constructor.parameterTypes");
        List r6 = d.a.i.g((Object[]) ZeusTransformUtils.preCheckCast(r5, Object[].class, "com.obric.aiagent.plugin"));
        if (d.h.b.o.a(r9, r6) == true) goto L6;
        if (r9.size() != r6.size()) goto L15;
        if (r6.containsAll((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")) == false) goto L15;
        throw new UnsupportedOperationException("Class " + r7.getSimpleName() + " must have parameters in the proper order: " + r9);
    L15:
        r3 = r3 + 1;
        goto L3
    L6:
        d.h.b.o.a(r4, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
        return r4;
    L16:
        return null;
    }
}
