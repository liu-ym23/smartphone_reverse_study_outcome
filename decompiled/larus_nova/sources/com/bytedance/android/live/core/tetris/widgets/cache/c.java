package com.bytedance.android.live.core.tetris.widgets.cache;

import com.bytedance.android.live.core.log.ALogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile c f65962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C1093c f65963g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f65964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f65965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f65966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f65967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f65968e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f65969a;

        public a() {
            this.f65969a = new b(0);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f65971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CachePoolModel f65972c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f65973d;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (this.f65970a == r101.f65970a) goto L8;
            return false;
        L8:
            if (this.f65971b == r101.f65971b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f65972c, r101.f65972c) == true) goto L12;
            return false;
        L12:
            if (this.f65973d == r101.f65973d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            int r100 = this.f65970a * 31;
            boolean r101 = this.f65971b;
            ?? r102 = 1;
            ?? r103 = r101;
            if (r101 == false) goto L5;
            r103 = 1;
        L5:
            int r104 = (r100 + r103) * 31;
            CachePoolModel r105 = this.f65972c;
            if (r105 == null) goto L8;
            int r106 = r105.hashCode();
        L9:
            int r107 = (r104 + r106) * 31;
            boolean r108 = this.f65973d;
            if (r108 == true) goto L14;
            r102 = r108;
        L14:
            return r107 + r102;
        L8:
            r106 = 0;
            goto L9
        }

        public final String toString() {
            return "CacheConfig(reusableCacheMaxSize=" + this.f65970a + ", enableCache=" + this.f65971b + ", cachePoolModel=" + this.f65972c + ", lowEndDeviceMode=" + this.f65973d + ")";
        }

        public b(int r100) {
            CachePoolModel r101 = CachePoolModel.SINGLE_POOL_MODEL;
            Intrinsics.checkNotNullParameter(r101, "cachePoolModel");
            this.f65970a = 4;
            this.f65971b = true;
            this.f65972c = r101;
            this.f65973d = false;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.widgets.cache.c$c, reason: collision with other inner class name */
    public static final class C1093c {
        public final c a() {
            c r100 = c.f65962f;
            if (r100 != null) goto L15;
            monitor-enter(this);
            r100 = c.f65962f;     // Catch: Throwable -> L9
            if (r100 != null) goto L11;
            c r101 = c.f65962f;     // Catch: Throwable -> L9
            a r102 = new a();     // Catch: Throwable -> L9
            f r103 = new f();     // Catch: Throwable -> L9
            c r104 = new c(r102.f65969a, r103);     // Catch: Throwable -> L9
            c.f65962f = r104;     // Catch: Throwable -> L9
            r100 = r104;
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r100;
        }

        public C1093c() {
        }
    }

    static {
        f65963g = new C1093c();
    }

    public final com.bytedance.android.live.core.tetris.widgets.cache.a a() {
        return (com.bytedance.android.live.core.tetris.widgets.cache.a) this.f65964a.getValue();
    }

    public final e b() {
        return (e) this.f65965b.getValue();
    }

    public final void c() {
        int r100 = com.bytedance.android.live.core.tetris.widgets.cache.b.f65961a;
        Intrinsics.checkNotNullParameter("缓存清理回收", "txt");
        ALogger.i("ComponentCacheLog", "缓存清理回收");
        if (a() == null) goto L6;
        a().a();
    L6:
        if (b() == null) goto L9;
        b().a();
    L9:
        if (((g) this.f65966c.getValue()) == null) goto L26;
        g r101 = (g) this.f65966c.getValue();
        Map<Class<?>, LinkedList<com.bytedance.android.live.core.tetris.widgets.a>> r102 = r101.f65977a;
        if (r102 == null) goto L25;
        Collection r103 = ((LinkedHashMap) r102).values();
        if (r103 == null) goto L25;
        Iterator r104 = r103.iterator();
    L16:
        if (r104.hasNext() == false) goto L25;
        LinkedList r105 = (LinkedList) r104.next();
        if (r105 == null) goto L16;
        Iterator r106 = r105.iterator();
    L21:
        if (r106.hasNext() == false) goto L16;
        com.bytedance.android.live.core.tetris.widgets.a r107 = (com.bytedance.android.live.core.tetris.widgets.a) r106.next();
        if (r107 == null) goto L21;
        r107.clearAfterDestroyed();
    L25:
        ((LinkedHashMap) r101.f65977a).clear();
    L26:
        d r108 = this.f65968e;
        if (r108 == null) goto L39;
        r108.onDestory();
        return;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueID");
        com.bytedance.android.live.core.tetris.widgets.cache.b.a("onRoomDetached", new String[]{r100});
        com.bytedance.android.live.core.tetris.widgets.cache.a r101 = a();
        if (r101 == null) goto L5;
        r101.b("before onRoomDetached ActiveCache");
    L5:
        e r102 = b();
        if (r102 == null) goto L8;
        r102.b("before onRoomDetached ReusableCache");
    L8:
        this.f65968e.c(this, r100);
        com.bytedance.android.live.core.tetris.widgets.cache.a r103 = a();
        if (r103 == null) goto L11;
        r103.b("after onRoomDetached ActiveCache");
    L11:
        e r104 = b();
        if (r104 == null) goto L15;
        r104.b("after onRoomDetached ReusableCache");
        return;
    }

    public c(b r100, f r101) {
        this.f65967d = r100;
        this.f65968e = r101;
        this.f65964a = LazyKt.lazy(ComponentCacheManager$activeCache$2.INSTANCE);
        this.f65965b = LazyKt.lazy(new ComponentCacheManager$LRUWidgetCache$2(this));
        this.f65966c = LazyKt.lazy(new ComponentCacheManager$sizedWidgetCache$2(this));
    }
}
