package com.bytedance.als;

import androidx.lifecycle.ViewModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Deprecated(message = "use ObjectContainer instead")
public final class ApiCenter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f38076c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, Object> f38077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ApiCenter f38078b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/als/ApiCenter$ApiCenterCompatViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "apiCenter", "Lcom/bytedance/als/ApiCenter;", "getApiCenter", "als_release"}, k = 1, mv = {1, 4, 1})
    public static final class ApiCenterCompatViewModel extends ViewModel {
        private final ApiCenter apiCenter;

        public ApiCenterCompatViewModel() {
            this.apiCenter = new ApiCenter(0);
        }

        public final ApiCenter getApiCenter() {
            return this.apiCenter;
        }
    }

    public static final class a {
    }

    static {
    }

    public ApiCenter(int r100) {
        this.f38078b = null;
        this.f38077a = new HashMap();
    }

    public final synchronized <T extends b> T a(Class<T> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "clazz");     // Catch: Throwable -> L30
        Object r101 = ((HashMap) this.f38077a).get(r100);     // Catch: Throwable -> L30
        if (r101 == null) goto L8;
        T r102 = (T) r101;     // Catch: Throwable -> L30
        monitor-exit(this);
        return r102;
    L8:
        Iterator r103 = ((HashMap) this.f38077a).keySet().iterator();     // Catch: Throwable -> L30
    L10:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();     // Catch: Throwable -> L30
        if (b(r100, (Class) r104) == false) goto L10;
    L15:
        Class r105 = (Class) r104;     // Catch: Throwable -> L30
        ApiCenter r106 = this.f38078b;     // Catch: Throwable -> L30
        if (r105 == null) goto L24;
        Object r107 = ((HashMap) this.f38077a).get(r105);     // Catch: Throwable -> L30
        if (r107 == null) goto L23;
        T r108 = (T) r107;     // Catch: Throwable -> L30
        monitor-exit(this);
        return r108;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type T");     // Catch: Throwable -> L30
    L24:
        if (r106 == null) goto L29;
        T r109 = (T) r106.a(r100);
        monitor-exit(this);
        return r109;
    L29:
        throw new IllegalStateException("not found " + r100);     // Catch: Throwable -> L30
    L14:
        r104 = null;
    L30:
        th = move-exception;
        throw th;
    }

    public static boolean b(Class r100, Class r101) {
        if (r100.isInterface() == false) goto L15;
        Class<?>[] r102 = r101.getInterfaces();
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        Class<?> r105 = r102[r104];
        if (Intrinsics.areEqual(r105, r100) == true) goto L8;
        if (b(r100, r105) == true) goto L11;
        r104 = r104 + 1;
        goto L5
    L11:
        return true;
    L8:
        return true;
    L13:
        return false;
    L15:
        if ((!Intrinsics.areEqual(r101, Object.class)) == false) goto L24;
        if (Intrinsics.areEqual(r101, r100) == true) goto L18;
        r101 = r101.getSuperclass();
        if (r101 != null) goto L15;
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    L18:
        return true;
    L24:
        return false;
    }
}
