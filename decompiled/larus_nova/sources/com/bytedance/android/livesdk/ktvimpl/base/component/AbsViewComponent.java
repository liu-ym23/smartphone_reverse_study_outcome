package com.bytedance.android.livesdk.ktvimpl.base.component;

import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0017J\b\u0010\u0006\u001a\u00020\u0004H\u0017J\b\u0010\u0007\u001a\u00020\u0004H\u0017J\b\u0010\b\u001a\u00020\u0004H\u0017¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/component/AbsViewComponent;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "", "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsViewComponent implements LifecycleObserver, ViewModelStoreOwnerCompat, LifecycleOwnerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f142401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f142402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f142403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f142404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LifecycleOwner f142405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f142406f;

    public void b() {
    }

    public abstract ViewGroup c();

    public void e() {
    }

    public abstract void f();

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat, androidx.lifecycle.ViewModelStoreOwner
    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.CC.$default$getViewModelStore(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f142401a.setCurrentState(Lifecycle.State.DESTROYED);
        ViewGroup r100 = this.f142404d;
        if (r100 == null) goto L5;
        this.f142406f.removeView(r100);
    L5:
        this.f142405e.getLifecycle().removeObserver(this);
        ((ViewModelStore) this.f142403c.getValue()).clear();
        ((CompositeDisposable) this.f142402b.getValue()).clear();
    }

    @Override // com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat
    public final ViewModelStore tf() {
        return (ViewModelStore) this.f142403c.getValue();
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return this.f142401a;
    }

    public final void a(ViewGroup.LayoutParams r100) {
        f();
        ViewGroup r101 = c();
        if (r101 == null) goto L6;
        this.f142404d = r101;
        this.f142406f.addView(r101, r100);
        this.f142401a.setCurrentState(Lifecycle.State.STARTED);
        e();
        b();
        return;
    }

    public AbsViewComponent(LifecycleOwner r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "containerView");
        this.f142405e = r100;
        this.f142406f = r101;
        LifecycleRegistry r102 = new LifecycleRegistry(this);
        this.f142401a = r102;
        this.f142402b = LazyKt.lazy(AbsViewComponent$compositeDisposable$2.INSTANCE);
        this.f142403c = LazyKt.lazy(AbsViewComponent$viewModelStorage$2.INSTANCE);
        r100.getLifecycle().addObserver(this);
        r102.setCurrentState(Lifecycle.State.CREATED);
    }
}
