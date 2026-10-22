package com.bytedance.android.ec.window.base.utils.window;

import androidx.lifecycle.LifecycleOwner;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class WindowAutoCleanResourceCache<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<LifecycleOwner, Map<Class<?>, WindowAutoCleanResourceCache<?>>> f49785c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final WindowAutoCleanResourceCache$Companion$lifecycleDestroyedObserver$1 f49786d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<T> f49787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, Unit> f49788b;

    public static final class a {
        public static WindowAutoCleanResourceCache a(Class r100, LifecycleOwner r101, Function1 r102) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            Intrinsics.checkNotNullParameter(r101, "owner");
            Intrinsics.checkNotNullParameter(r102, "cleaner");
            ConcurrentHashMap<LifecycleOwner, Map<Class<?>, WindowAutoCleanResourceCache<?>>> r103 = WindowAutoCleanResourceCache.f49785c;
            Map<Class<?>, WindowAutoCleanResourceCache<?>> r104 = r103.get(r101);
            if (r104 == null) goto L5;
            WindowAutoCleanResourceCache<?> r105 = r104.get(r100);
        L6:
            if (r105 == null) goto L8;
            return r105;
        L8:
            r101.getLifecycle().addObserver(WindowAutoCleanResourceCache.f49786d);
            WindowAutoCleanResourceCache<?> r106 = new WindowAutoCleanResourceCache(r102);
            Map<Class<?>, WindowAutoCleanResourceCache<?>> r107 = r103.get(r101);
            if (r107 != null) goto L11;
            r107 = new LinkedHashMap();
        L11:
            boolean r108 = r107.isEmpty();
            r107.put(r100, r106);
            if (r108 == false) goto L14;
            r103.put(r101, r107);
        L14:
            return r106;
        L5:
            r105 = null;
            goto L6
        }
    }

    public WindowAutoCleanResourceCache() {
        throw null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.ec.window.base.utils.window.WindowAutoCleanResourceCache$Companion$lifecycleDestroyedObserver$1] */
    static {
        f49785c = new ConcurrentHashMap();
        f49786d = new WindowAutoCleanResourceCache$Companion$lifecycleDestroyedObserver$1();
    }

    public WindowAutoCleanResourceCache(Function1 r100) {
        this.f49788b = r100;
        this.f49787a = Collections.synchronizedSet(new LinkedHashSet());
    }

    public final T a(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "generator");
        if ((!this.f49787a.isEmpty()) == false) goto L7;
        T r101 = (T) CollectionsKt.firstOrNull(this.f49787a);
        if (r101 == null) goto L7;
        return r101;
    L7:
        T r102 = r100.invoke();
        this.f49787a.add(r102);
        return r102;
    }
}
