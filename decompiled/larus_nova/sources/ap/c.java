package ap;

import android.view.View;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, com.bytedance.android.ec.window.base.utils.window.c<? extends Object>> f15827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15828b;

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> extends com.bytedance.android.ec.window.base.utils.window.c<T> {
        public a(int r100) {
            super(r100);
        }
    }

    public c() {
        this.f15828b = 1;
        this.f15827a = new LinkedHashMap();
    }

    public final synchronized <T extends View> T a(Class<T> r100, Function0<? extends T> r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "clazz");     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r101, "resourceGenerator");     // Catch: Throwable -> L15
        if (this.f15827a.containsKey(r100) == true) goto L6;
    L12:
        a r102 = new a(this.f15828b);     // Catch: Throwable -> L15
        this.f15827a.put(r100, r102);     // Catch: Throwable -> L15
        T r103 = (T) r102.a(r101);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return r103;
    L6:
        if (((LinkedHashMap) this.f15827a).get(r100) == null) goto L12;
        Object r104 = ((LinkedHashMap) this.f15827a).get(r100);     // Catch: Throwable -> L15
        if (r104 == null) goto L11;
        r103 = (T) ((com.bytedance.android.ec.window.base.utils.window.c) r104).a(r101);     // Catch: Throwable -> L15
        goto L13
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.utils.window.WindowSimplePool<T>");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized List b(Class r100, Function0 r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "clazz");     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r101, "resourceGenerator");     // Catch: Throwable -> L10
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L10
        Scheduler r103 = Schedulers.computation();     // Catch: Throwable -> L10
        int r104 = 0;
    L5:
        if (r104 >= 6) goto L8;
        r102.add(r103.scheduleDirect(new d(this, r100, r101)));     // Catch: Throwable -> L10
        r104 = r104 + 1;
        goto L5
    L8:
        monitor-exit(this);
        return r102;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized <T extends View> void c(Class<T> r100, T r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "clazz");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r101, "resource");     // Catch: Throwable -> L11
        Object r102 = ((LinkedHashMap) this.f15827a).get(r100);     // Catch: Throwable -> L11
        if ((r102 instanceof com.bytedance.android.ec.window.base.utils.window.c) == true) goto L6;
        r102 = null;
    L6:
        com.bytedance.android.ec.window.base.utils.window.c r103 = (com.bytedance.android.ec.window.base.utils.window.c) r102;     // Catch: Throwable -> L11
        if (r103 == null) goto L9;
        r103.b(r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
