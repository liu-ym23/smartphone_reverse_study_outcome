package com.bytedance.android.live.core.tetris.layer.core.element;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.componentx.component.b;
import com.bytedance.android.live.core.tetris.componentx.utils.ObservableLifecycleRegistry;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import j70.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p70.d;
import v70.c;
import z70.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005J\b\u0010\u0007\u001a\u00020\u0006H\u0017J\b\u0010\b\u001a\u00020\u0006H\u0017J\b\u0010\t\u001a\u00020\u0006H\u0017J\b\u0010\n\u001a\u00020\u0006H\u0017J\b\u0010\u000b\u001a\u00020\u0006H\u0017J\b\u0010\f\u001a\u00020\u0006H\u0017¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/Element;", "", "Content", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/LifecycleObserver;", "Lz70/a;", "", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class Element<Content> implements LifecycleOwnerCompat, LifecycleObserver, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f65659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f65660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f65661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f65662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f65663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Content f65664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, String> f65665g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LayerEventDispatcher f65666h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p70.b f65667i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ObservableLifecycleRegistry f65668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h70.b f65669k;

    public abstract View c(Context r100, ViewGroup r101);

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public abstract Content i();

    public abstract o70.a j();

    public void k() {
    }

    public abstract void onViewCreated(View r100);

    public final c h() {
        View r100 = this.f65660b;
        if (r100 != null) goto L6;
        return null;
    L6:
        Intrinsics.checkNotNull(r100);
        return new c(r100);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        this.f65668j.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        onViewCreated(this.f65660b);
        LayerEventDispatcher r100 = this.f65666h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "element");
        r100.a(j());
        this.f65664f = i();
        ALogger.i("【widget】", "onContentReady " + this + " -> " + this.f65664f);
        Content r101 = this.f65664f;
        if (r101 != null) goto L8;
    L24:
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L8:
        if ((r101 instanceof d) == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L24;
        Iterator<T> r102 = ((d) r101).ud().iterator();
    L14:
        if (r102.hasNext() == false) goto L24;
        p70.c r103 = (p70.c) r102.next();
        p70.b r104 = this.f65667i;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("processorChains");
    L18:
        p70.a r105 = r104.a(r103.b());
        if (r105 == null) goto L14;
        Intrinsics.checkNotNullParameter(r103, "p");
        if (((ArrayList) r105.f527975a).contains(r103) == true) goto L14;
        ((ArrayList) r105.f527975a).add(r103);
        goto L14
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f65668j.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.f65668j.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.f65668j.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.f65668j.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.f65668j.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public final void e() {
        k();
        Lifecycle.State r100 = getLifecycle().getCurrentState();
        int r101 = k70.a.f501979a[r100.ordinal()];
        if (r101 != 3) goto L5;
        onDestroy();
    L12:
        LayerEventDispatcher r102 = this.f65666h;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
    L15:
        r102.getClass();
        Intrinsics.checkNotNullParameter(this, "element");
        o70.a r103 = j();
        if (r103 == null) goto L23;
        Iterator<T> r104 = r103.Mg().iterator();
    L19:
        if (r104.hasNext() == false) goto L29;
        Class r105 = (Class) r104.next();
        HashSet<o70.a> r106 = r102.f65767a.get(r105);
        if (r106 == null) goto L19;
        r106.remove(r103);
        goto L19
    L29:
        return;
    L23:
        return;
    L5:
        if (r101 != 4) goto L7;
        onStop();
        onDestroy();
        goto L12
    L7:
        if (r101 != 5) goto L12;
        onPause();
        onStop();
        onDestroy();
        goto L12
    }

    public Lifecycle g() {
        return this.f65668j;
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return this.f65668j;
    }

    public Element(h70.b r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        this.f65669k = r100;
        this.f65659a = true;
        f r101 = f.f497555c;
        f r102 = f.f497555c;
        this.f65662d = r102;
        this.f65663e = r102;
        this.f65668j = new ObservableLifecycleRegistry(this);
    }

    public final <T> T f(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        T r101 = this.f65664f;
        if (r101 != null) goto L5;
    L10:
        return null;
    L5:
        if (r100.isAssignableFrom(r101.getClass()) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L10;
        return r101;
    }

    @Override // z70.a
    public final void setExtraInfo(Map<String, String> r100) {
        Map<String, String> r101 = this.f65665g;
        if (r101 != null) goto L5;
        this.f65665g = r100;
        return;
    L5:
        r101.putAll(r100);
    }
}
