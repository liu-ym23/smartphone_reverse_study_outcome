package com.bytedance.android.live.core.tetris.layer.core.delegate;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import h70.b;
import i70.a;
import j70.d;
import j70.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\n\u001a\u00020\tH\u0017J\b\u0010\u000b\u001a\u00020\tH\u0017J\b\u0010\f\u001a\u00020\tH\u0017J\b\u0010\r\u001a\u00020\tH\u0017J\b\u0010\u000e\u001a\u00020\tH\u0017J\b\u0010\u000f\u001a\u00020\tH\u0017¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/delegate/LayerDelegate;", "Li70/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lh70/b;", "C", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/LifecycleObserver;", "", "Lcom/bytedance/android/live/core/tetris/layer/core/data/b;", "", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LayerDelegate<T extends i70.a, C extends h70.b> implements LifecycleOwnerCompat, LifecycleObserver, com.bytedance.android.live.core.tetris.layer.core.data.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f65643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.core.tetris.layer.core.data.b f65644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C f65645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<f, Element<?>> f65646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<d<h70.b>> f65647e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LifecycleRegistry f65648f;

    public void c(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public abstract void j(Element<?> r100);

    public abstract void k(Element<?> r100);

    public final T h() {
        T r100 = this.f65643a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(GXTemplateKey.GAIAX_LAYER);
    L5:
        return r100;
    }

    public final C i() {
        C r100 = this.f65645c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        return r100;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        this.f65648f.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f65648f.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.f65648f.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.f65648f.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.f65648f.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.f65648f.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public LayerDelegate() {
        this.f65646d = new LinkedHashMap();
        this.f65647e = new LinkedHashSet();
        this.f65648f = new LifecycleRegistry(this);
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return this.f65648f;
    }

    public void b(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if (this.f65646d.containsKey(r100.f65662d) == false) goto L6;
        c(r100);
        getLifecycle().addObserver(r100);
        j(r100);
        return;
    }

    public void e(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        getLifecycle().removeObserver(r100);
        r100.e();
        k(r100);
    }

    public final Element<?> f(f r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        return (Element) ((LinkedHashMap) this.f65646d).get(r100);
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Landroidx/lifecycle/ViewModel;>(Ljava/lang/Class<TT;>;)TT; */
    @Override // com.bytedance.android.live.core.tetris.layer.core.data.b
    public final ViewModel getViewModel(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        com.bytedance.android.live.core.tetris.layer.core.data.b r101 = this.f65644b;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("vmProvider");
    L6:
        return r101.getViewModel(r100);
    }

    public final void l(f r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        if (this.f65646d.containsKey(r100) == false) goto L21;
        Element<?> r101 = f(r100);
        Intrinsics.checkNotNull(r101);
        e(r101);
        this.f65646d.remove(r100);
        Iterator<T> r102 = this.f65647e.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        d r104 = (d) r103;
        C r105 = this.f65645c;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L11:
        if (Intrinsics.areEqual(r104.C(r105), r100) == false) goto L6;
    L14:
        d r106 = (d) r103;
        if (r106 == null) goto L22;
        this.f65647e.remove(r106);
        return;
    L22:
        return;
    L13:
        r103 = null;
        goto L14
    }

    public final <T> T g(f r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        Intrinsics.checkNotNullParameter(r101, "clz");
        T r102 = this.f65643a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(GXTemplateKey.GAIAX_LAYER);
    L5:
        Element<?> r103 = r102.f2(r100);
        if (r103 != null) goto L10;
        return null;
    L10:
        return (T) r103.f(r101);
    }
}
