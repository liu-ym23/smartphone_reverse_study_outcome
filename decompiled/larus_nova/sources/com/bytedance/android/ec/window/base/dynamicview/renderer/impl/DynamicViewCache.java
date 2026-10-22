package com.bytedance.android.ec.window.base.dynamicview.renderer.impl;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/window/base/dynamicview/renderer/impl/DynamicViewCache;", "Landroidx/lifecycle/LifecycleEventObserver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DynamicViewCache implements LifecycleEventObserver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<LifecycleOwner, DynamicViewCache> f49266c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f49267d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, LinkedList<View>> f49268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f49269b;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.dynamicview.renderer.impl.DynamicViewCache$a$a, reason: collision with other inner class name */
        public static final class C0845a implements LifecycleEventObserver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0845a f49270a = null;

            static {
                f49270a = new C0845a();
            }

            public C0845a() {
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
                Intrinsics.checkNotNullParameter(r100, "source");
                Intrinsics.checkNotNullParameter(r101, "event");
                if (r101 != Lifecycle.Event.ON_DESTROY) goto L6;
                DynamicViewCache.f49266c.remove(r100);
                return;
            }
        }

        public a() {
        }

        public final synchronized DynamicViewCache a(LifecycleOwner r100) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");     // Catch: Throwable -> L10
            ConcurrentHashMap<LifecycleOwner, DynamicViewCache> r101 = DynamicViewCache.f49266c;     // Catch: Throwable -> L10
            DynamicViewCache r102 = r101.get(r100);     // Catch: Throwable -> L10
            if (r102 == null) goto L7;
            monitor-exit(this);
            return r102;
        L7:
            DynamicViewCache r103 = new DynamicViewCache(r100);     // Catch: Throwable -> L10
            r101.put(r100, r103);     // Catch: Throwable -> L10
            r100.getLifecycle().addObserver(C0845a.f49270a);     // Catch: Throwable -> L10
            monitor-exit(this);
            return r103;
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        f49267d = new a();
        f49266c = new ConcurrentHashMap();
    }

    public DynamicViewCache(LifecycleOwner r100) {
        this.f49269b = r100;
        r100.getLifecycle().addObserver(this);
        this.f49268a = new ConcurrentHashMap();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        this.f49268a.clear();
        return;
    }
}
