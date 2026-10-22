package com.bytedance.android.ec.sdk.plugin;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class PluginLoader {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f48147d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f48148e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f48149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<g> f48150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<h> f48151c;

    public static final class a {
        public a() {
        }
    }

    public final class b {
        public b() {
        }
    }

    static {
        f48148e = new a();
        f48147d = LazyKt.lazy(PluginLoader$Companion$INSTANCE$2.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, com.bytedance.android.ec.sdk.plugin.PluginLoader$loadLocked$$inlined$synchronized$lambda$3] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, com.bytedance.android.ec.sdk.plugin.PluginLoader$loadLocked$$inlined$synchronized$lambda$2] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, com.bytedance.android.ec.sdk.plugin.PluginLoader$loadLocked$$inlined$synchronized$lambda$1] */
    public final void b() {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = null;
        monitor-enter(this);
        int r101 = this.f48149a;     // Catch: Throwable -> L28
        if (r101 == (-1)) goto L27;
        if (r101 == 0) goto L19;
        if (r101 != 1) goto L10;
        monitor-exit(this);
        return;
    L10:
        if (r101 != 2) goto L12;
        r100.element = new PluginLoader$loadLocked$$inlined$synchronized$lambda$2(this, r100);     // Catch: Throwable -> L28
    L20:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(this);
        Function0 r103 = (Function0) r100.element;
        if (r103 == null) goto L32;
        Unit r104 = (Unit) r103.invoke();
        return;
    L32:
        return;
    L12:
        if (r101 != 3) goto L20;
        r100.element = new PluginLoader$loadLocked$$inlined$synchronized$lambda$1(this, r100);     // Catch: Throwable -> L28
        goto L20
    L19:
        this.f48149a = 1;     // Catch: Throwable -> L28
        r100.element = new PluginLoader$loadLocked$$inlined$synchronized$lambda$3(this, r100);     // Catch: Throwable -> L28
        goto L20
    L27:
        throw new IllegalStateException("Django: ==> plugin not init");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public final void c() {
        CopyOnWriteArraySet<g> r100 = this.f48150b;
        monitor-enter(r100);
        int r101 = 0;
        Object[] r102 = r100.toArray(new g[0]);     // Catch: Throwable -> L19
        if (r102 == null) goto L18;
        r100.clear();     // Catch: Throwable -> L19
        monitor-exit(r100);
        int r103 = r102.length;
    L10:
        if (r101 >= r103) goto L12;
        ((g) r102[r101]).a(true);
        r101 = r101 + 1;
        goto L10
    L12:
        Iterator<h> r104 = this.f48151c.iterator();
    L14:
        if (r104.hasNext() == false) goto L16;
        r104.next().a();
        goto L14
    L16:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public PluginLoader() {
        this.f48149a = -1;
        new b();
        this.f48150b = new CopyOnWriteArraySet();
        this.f48151c = new CopyOnWriteArraySet();
    }

    public static final void a(PluginLoader r100) {
        CopyOnWriteArraySet<g> r101 = r100.f48150b;
        monitor-enter(r101);
        Object[] r102 = r101.toArray(new g[0]);     // Catch: Throwable -> L19
        if (r102 == null) goto L18;
        r101.clear();     // Catch: Throwable -> L19
        monitor-exit(r101);
        int r103 = r102.length;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L12;
        ((g) r102[r104]).a(false);
        r104 = r104 + 1;
        goto L10
    L12:
        Iterator<h> r105 = r100.f48151c.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        r105.next().a();
        goto L14
    L16:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }
}
