package com.bytedance.android.ecom.arch.slice.render.widget.fresco;

import com.facebook.drawee.components.DeferredReleaser;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class AsyncDeferredReleaser extends DeferredReleaser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f50908a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f50909b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<DeferredReleaser.Releasable> f50910c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Function0<Unit> f50911d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AsyncDeferredReleaser f50912e = null;

    static {
        f50908a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AsyncDeferredReleaser.class), "fixImageMemoryLeak", "getFixImageMemoryLeak()Z"))};
        f50912e = new AsyncDeferredReleaser();
        f50909b = LazyKt.lazy(AsyncDeferredReleaser$fixImageMemoryLeak$2.INSTANCE);
        f50910c = Collections.newSetFromMap(new ConcurrentHashMap());
        f50911d = AsyncDeferredReleaser$releaseRunnable$1.INSTANCE;
    }

    public static boolean b() {
        Lazy r100 = f50909b;
        KProperty r101 = f50908a[0];
        return ((Boolean) r100.getValue()).booleanValue();
    }

    public AsyncDeferredReleaser() {
    }

    public static final void a(AsyncDeferredReleaser r100) {
        r100.getClass();
        Iterator<DeferredReleaser.Releasable> r101 = f50910c.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().release();
        goto L4
    L6:
        f50910c.clear();
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    public final void cancelDeferredRelease(DeferredReleaser.Releasable r100) {
        if (b() == false) goto L15;
        monitor-enter(this);
        f50912e.getClass();     // Catch: Throwable -> L12
        Set<DeferredReleaser.Releasable> r101 = f50910c;     // Catch: Throwable -> L12
        if (r101 == null) goto L11;
        TypeIntrinsics.asMutableCollection(r101).remove(r100);     // Catch: Throwable -> L12
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L11:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        Set<DeferredReleaser.Releasable> r103 = f50910c;
        if (r103 == null) goto L20;
        TypeIntrinsics.asMutableCollection(r103).remove(r100);
        return;
    L20:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    public final void scheduleDeferredRelease(DeferredReleaser.Releasable r100) {
        if (b() == false) goto L17;
        monitor-enter(this);
        f50912e.getClass();     // Catch: Throwable -> L14
        Set<DeferredReleaser.Releasable> r101 = f50910c;     // Catch: Throwable -> L14
        if (r101.add(r100) == true) goto L9;
    L11:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L9:
        if (r101.size() != 1) goto L11;
        com.bytedance.android.ecom.arch.slice.render.util.h.c(AsyncDeferredReleaser$doScheduleRelease$1.INSTANCE);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        Set<DeferredReleaser.Releasable> r103 = f50910c;
        if (r103.add(r100) == true) goto L21;
        return;
    L21:
        if (r103.size() != 1) goto L26;
        com.bytedance.android.ecom.arch.slice.render.util.h.c(AsyncDeferredReleaser$doScheduleRelease$1.INSTANCE);
        return;
    }
}
