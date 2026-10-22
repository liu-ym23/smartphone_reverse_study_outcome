package com.bytedance.android.live.core.tetris.layer.core.tetris;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.service.ServiceElement;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import h70.b;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import is2.k;
import j70.e;
import j70.f;
import j70.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k70.c;
import k70.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t70.h;
import t70.i;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\b\u0012\u0004\u0012\u00028\u00000\u0007B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\t\u001a\u00020\bH\u0017J\b\u0010\n\u001a\u00020\bH\u0017J\b\u0010\u000b\u001a\u00020\bH\u0017J\b\u0010\f\u001a\u00020\bH\u0017J\b\u0010\r\u001a\u00020\bH\u0017J\b\u0010\u000e\u001a\u00020\bH\u0017¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "Lh70/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/LifecycleObserver;", "Lz70/a;", "Lt70/b;", "Ld70/a;", "", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "<init>", "()V", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class Tetris<T extends b> implements LifecycleOwnerCompat, LifecycleObserver, z70.a, t70.b, d70.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Element<?>> f65787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f65788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f65789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f65790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.live.core.tetris.layer.core.data.b f65791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p70.b f65792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LifecycleRegistry f65793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f65794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, String> f65795i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k f65796j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<String, Function1<ViewGroup, Unit>> f65797k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PropertyOwner<Integer> f65798l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompositeDisposable f65799m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f f65800n;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Tetris f65801a;

        public a(Tetris r100) {
            this.f65801a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Integer) r100).intValue() <= 0) goto L6;
            this.f65801a.O();
            return;
        }
    }

    public abstract View G(t70.k r100);

    public abstract void O();

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public final void J() {
        Iterator r100 = ((ArrayList) this.f65787a).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Element<?> r101 = (Element) r100.next();
        d r102 = this.f65790d;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L8:
        r102.a(r101);
        getLifecycle().removeObserver(r101);
        r101.e();
        goto L4
    L9:
        Lifecycle.State r103 = getLifecycle().getCurrentState();
        int r104 = h.f544866a[r103.ordinal()];
        if (r104 != 3) goto L12;
        onDestroy();
    L19:
        ((ArrayList) this.f65787a).clear();
        return;
    L12:
        if (r104 != 4) goto L14;
        onStop();
        onDestroy();
        goto L19
    L14:
        if (r104 != 5) goto L19;
        onPause();
        onStop();
        onDestroy();
        goto L19
    }

    public final T K() {
        T r100 = this.f65789c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        return r100;
    }

    public final View L() {
        View r100 = this.f65794h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tetrisView");
    L5:
        return r100;
    }

    @Override // d70.a
    public final T getComponentContext() {
        T r100 = this.f65789c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        return r100;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        this.f65793g.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(this.f65798l).subscribe(new a(this)), this.f65799m);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f65793g.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.f65795i = null;
        k r100 = this.f65796j;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f65799m.clear();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.f65793g.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.f65793g.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.f65793g.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.f65793g.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public Tetris() {
        this.f65787a = new ArrayList();
        this.f65793g = new LifecycleRegistry(this);
        this.f65797k = new HashMap();
        this.f65798l = new PropertyOwner(1);
        this.f65799m = new CompositeDisposable();
    }

    @Override // d70.a
    public final f getElementType() {
        return this.f65800n;
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return this.f65793g;
    }

    @Override // t70.b
    public final Map<String, String> w() {
        return this.f65795i;
    }

    @Override // t70.a
    public final HashMap<String, Function1<ViewGroup, Unit>> x() {
        return this.f65797k;
    }

    public final Element E(o r100) {
        Intrinsics.checkNotNullParameter(r100, "elementAttribute");
        c r101 = this.f65788b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L5:
        Element<?> r102 = r101.a(f.f497555c, r100);
        if ((r102 instanceof ServiceElement) == false) goto L13;
        ((ArrayList) this.f65787a).add(r102);
        getLifecycle().addObserver(r102);
        d r103 = this.f65790d;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L10:
        r103.b(r102);
        return r102;
    L13:
        throw new IllegalStateException(r100 + " should be defined for ServiceElement.");
    }

    public void H(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        ((ArrayList) this.f65787a).remove(r100);
        d r101 = this.f65790d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L5:
        r101.b(r100);
        r100.e();
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Landroidx/lifecycle/ViewModel;>(Ljava/lang/Class<TT;>;)TT; */
    public final ViewModel M(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        com.bytedance.android.live.core.tetris.layer.core.data.b r101 = this.f65791e;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("vmProvider");
    L6:
        return r101.getViewModel(r100);
    }

    @Override // t70.a
    public final void h(int r100) {
        this.f65798l.a(Integer.valueOf(r100));
    }

    @Override // d70.a
    public final void setComponentContext(T r100) {
        if (r100 == null) goto L5;
        this.f65789c = r100;
        return;
    }

    @Override // d70.a
    public final void setElementType(f r100) {
        this.f65800n = r100;
    }

    @Override // z70.a
    public final void setExtraInfo(Map<String, String> r100) {
        Map<String, String> r101 = this.f65795i;
        if (r101 != null) goto L5;
        this.f65795i = r100;
        return;
    L5:
        r101.putAll(r100);
    }

    public final Element F(o r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "elementAttribute");
        Intrinsics.checkNotNullParameter(r101, "elementView");
        c r102 = this.f65788b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L5:
        Element<?> r103 = r102.a(f.f497555c, r100);
        ((ArrayList) this.f65787a).add(r103);
        Map<String, String> r104 = this.f65795i;
        if (r104 == null) goto L8;
        r103.setExtraInfo(r104);
    L8:
        ViewGroup r105 = r101;
        if (r103.f65659a == false) goto L18;
        T r106 = this.f65789c;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L13:
        View r107 = r103.c(r106.getContext(), r101);
        if (r107 == null) goto L17;
        r101.addView(r107);
        r105 = r107;
        goto L18
    L17:
        throw new IllegalStateException("buildView here shouldn't be null.");
    L18:
        r103.f65660b = r105;
        getLifecycle().addObserver(r103);
        d r108 = this.f65790d;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L21:
        r108.b(r103);
        return r103;
    }

    public final void N(Element<?> r100, ViewGroup r101) {
        T r102 = this.f65789c;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L5:
        View r103 = r100.c(r102.getContext(), r101);
        if (r103 == null) goto L16;
        if (r103.getId() != (-1)) goto L10;
        r103.setId(ViewCompat.generateViewId());
    L10:
        r101.addView(r103);
        r100.f65660b = r103;
        getLifecycle().addObserver(r100);
        d r104 = this.f65790d;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L13:
        r104.b(r100);
        z70.c.a("dsl template element added, func_id = " + r100.f65662d.f497559b);
        return;
    L16:
        throw new IllegalStateException("buildView here shouldn't be null.");
    }

    @Override // t70.b
    public final Element<?> b(a80.a<b> r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        c r102 = this.f65788b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L5:
        T r103 = this.f65789c;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L8:
        Element<?> r104 = r102.a(r100.o(r103), r100.p());
        ((ArrayList) this.f65787a).add(r104);
        Map<String, String> r105 = r100.f2138a;
        if (r105 == null) goto L11;
        r104.setExtraInfo(r105);
    L11:
        N(r104, r101);
        return r104;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t70.b
    public final Element c(j70.h r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        c r102 = this.f65788b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L5:
        T r103 = this.f65789c;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L8:
        Element<?> r104 = r102.a(r100.C(r103), (e) r100);
        N(r104, r101);
        return r104;
    }

    @Override // t70.b
    public final void y(Class<? extends Widget> r100, ViewGroup r101, boolean r102, Object[] r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "widgetClass");
        Intrinsics.checkNotNullParameter(r101, "elementView");
        i r105 = new i(r102, r104, r100);
        if (r103 == null) goto L5;
        r105.d(r103);
    L5:
        F(r105, r101);
    }
}
