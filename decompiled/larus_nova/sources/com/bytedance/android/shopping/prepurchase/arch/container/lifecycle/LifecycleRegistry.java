package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class LifecycleRegistry extends Lifecycle {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleRegistry$owner$1 f180809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<d, LifecycleObserver> f180810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f180811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f180812e;

    public final androidx.lifecycle.LifecycleRegistry e() {
        return (androidx.lifecycle.LifecycleRegistry) this.f180811d.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle
    public final Lifecycle.State b() {
        androidx.lifecycle.Lifecycle.State r100 = e().getCurrentState();
        int r101 = g.f180822a[r100.ordinal()];
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L23;
        if (r101 == 3) goto L22;
        if (r101 == 4) goto L21;
        if (r101 != 5) goto L14;
        return Lifecycle.State.RESUMED;
    L14:
        throw new NoWhenBranchMatchedException();
    L21:
        return Lifecycle.State.STARTED;
    L22:
        return Lifecycle.State.CREATED;
    L23:
        return Lifecycle.State.INITIALIZED;
    L19:
        return Lifecycle.State.DESTROYED;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.LifecycleRegistry$owner$1] */
    public LifecycleRegistry(e r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f180812e = r100;
        this.f180809b = new LifecycleRegistry$owner$1(this);
        this.f180810c = new LinkedHashMap();
        this.f180811d = LazyKt.lazy(new LifecycleRegistry$lifecycleRegistry$2(this));
    }

    public static void d(String r100) {
        Handler r101 = com.bytedance.android.shopping.prepurchase.arch.utils.a.f181012a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException(("Method " + r100 + " must be called on the main thread").toString());
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle
    public final void a(final d r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        d("addObserver");
        LifecycleEventObserver r101 = new LifecycleRegistry$addObserver$realObserver$1(this, r100);
        this.f180810c.put(r100, r101);
        e().addObserver(r101);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle
    public final void c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        d("removeObserver");
        LifecycleObserver r101 = this.f180810c.remove(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        e().removeObserver(r101);
    }

    public final void f(Lifecycle.Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        androidx.lifecycle.LifecycleRegistry r101 = e();
        switch(g.f180824c[r100.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        androidx.lifecycle.Lifecycle.Event r102 = androidx.lifecycle.Lifecycle.Event.ON_ANY;
    L13:
        r101.handleLifecycleEvent(r102);
        return;
    L7:
        r102 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY;
        goto L13
    L8:
        r102 = androidx.lifecycle.Lifecycle.Event.ON_STOP;
        goto L13
    L9:
        r102 = androidx.lifecycle.Lifecycle.Event.ON_PAUSE;
        goto L13
    L10:
        r102 = androidx.lifecycle.Lifecycle.Event.ON_RESUME;
        goto L13
    L11:
        r102 = androidx.lifecycle.Lifecycle.Event.ON_START;
        goto L13
    L12:
        r102 = androidx.lifecycle.Lifecycle.Event.ON_CREATE;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
