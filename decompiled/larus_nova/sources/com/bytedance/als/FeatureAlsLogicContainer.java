package com.bytedance.als;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u0010\b\u001a\u00020\u0003H\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/als/FeatureAlsLogicContainer;", "Lcom/bytedance/als/a;", "Landroidx/lifecycle/LifecycleObserver;", "", "onActivityCreated", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", "onDestroyView", "als_release"}, k = 1, mv = {1, 4, 1})
public final class FeatureAlsLogicContainer extends a implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f38081a;

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        Iterator r100 = CollectionsKt.toList(null).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        a((LogicComponent) r100.next(), Lifecycle.State.STARTED);
        goto L4
    L6:
        Lifecycle.Event.Companion r101 = Lifecycle.Event.Companion;
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        Iterator r100 = CollectionsKt.toList(null).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        a((LogicComponent) r100.next(), Lifecycle.State.RESUMED);
        goto L4
    L6:
        Lifecycle.Event.Companion r101 = Lifecycle.Event.Companion;
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        Iterator r100 = CollectionsKt.toList(null).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        a((LogicComponent) r100.next(), Lifecycle.State.STARTED);
        goto L4
    L6:
        Lifecycle.Event.Companion r101 = Lifecycle.Event.Companion;
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        Iterator r100 = CollectionsKt.toList(null).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        a((LogicComponent) r100.next(), Lifecycle.State.CREATED);
        goto L4
    L6:
        Lifecycle.Event.Companion r101 = Lifecycle.Event.Companion;
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onActivityCreated() {
        if (this.f38081a == false) goto L9;
        this.f38081a = true;
        Iterator r100 = CollectionsKt.toList(null).iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        a((LogicComponent) r100.next(), Lifecycle.State.CREATED);
        goto L6
    L8:
        throw null;
    L9:
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroyView() {
        HashMap r100 = new HashMap();
        Iterator r101 = CollectionsKt.toList(null).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        LogicComponent<?> r102 = (LogicComponent) r101.next();
        a(r102, Lifecycle.State.DESTROYED);
        r100.put(r102.getClass(), MapsKt.toMap(r102.f38084b.f467099a));
        goto L4
    L6:
        int r103 = d6.a.f467098a;
        Intrinsics.checkNotNullParameter(r100, "map");
        Lifecycle.Event.Companion r104 = Lifecycle.Event.Companion;
        throw null;
    }

    public final void a(LogicComponent<?> r100, Lifecycle.State r101) {
        int r102 = d.f38089a[r101.ordinal()];
        if (r102 != 1) goto L5;
        Lifecycle.State r103 = r100.getLifecycle().getCurrentState();
        Lifecycle.State r104 = Lifecycle.State.CREATED;
        if (r103.compareTo(r104) >= 0) goto L46;
        r100.b();
        return;
    L46:
        if (r100.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) <= 0) goto L49;
        r100.e();
    L49:
        if (r100.getLifecycle().getCurrentState().compareTo(r104) <= 0) goto L59;
        r100.h();
        return;
    L59:
        return;
    L5:
        if (r102 != 2) goto L7;
        Lifecycle.State r105 = r100.getLifecycle().getCurrentState();
        Lifecycle.State r106 = Lifecycle.State.STARTED;
        if (r105.compareTo(r106) >= 0) goto L40;
        if (r100.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L38;
        r100.b();
    L38:
        r100.g();
        return;
    L40:
        if (r100.getLifecycle().getCurrentState().compareTo(r106) <= 0) goto L56;
        r100.e();
        return;
    L56:
        return;
    L7:
        if (r102 == 3) goto L25;
        if (r102 == 4) goto L12;
        return;
    L12:
        if (r100.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L15;
        r100.e();
    L15:
        if (r100.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) < 0) goto L18;
        r100.h();
    L18:
        if (r100.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L52;
        r100.c();
        if ((!Intrinsics.areEqual(r100.i(), b.class)) == true) goto L23;
        return;
    L23:
        throw null;
    L52:
        return;
    L25:
        if (r100.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L27;
        return;
    L27:
        if (r100.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L30;
        r100.b();
    L30:
        if (r100.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) >= 0) goto L32;
        r100.g();
    L32:
        r100.f();
    }
}
