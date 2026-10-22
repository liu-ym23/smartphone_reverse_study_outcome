package com.bytedance.android.shopping.prepurchase.arch.container.state;

import androidx.lifecycle.InsMediatorLiveData;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MapToInsMediatorLiveDataKt;
import androidx.lifecycle.Observer;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes13.dex */
public class ObservableData<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e, LifecycleOwner> f180826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<g<? super T>, Observer<? super T>> f180827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveData<T> f180828c;

    public static final class a implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableData f180829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e f180830b;

        public a(ObservableData r100, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r101) {
            this.f180829a = r100;
            this.f180830b = r101;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
        public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "event");
            if (r100.getLifecycle().b() != Lifecycle.State.DESTROYED) goto L6;
            this.f180829a.f180826a.remove(this.f180830b);
            return;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.c
    public final T a() {
        LiveData<T> r100 = this.f180828c;
        if ((r100 instanceof InsMediatorLiveData) == false) goto L7;
        return (T) ((InsMediatorLiveData) r100).getValueImmediately();
    L7:
        return r100.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.c
    @Deprecated(message = "改方法继承了 LiveData 的 bug，详见[getValueImmediately]", replaceWith = @ReplaceWith(expression = "getValueImmediately()", imports = {}))
    public final T getValue() {
        return this.f180828c.getValue();
    }

    public ObservableData(LiveData<T> r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f180828c = r100;
        this.f180826a = new LinkedHashMap();
        this.f180827b = new LinkedHashMap();
    }

    public final LifecycleOwner c(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r100) {
        LinkedHashMap r101 = (LinkedHashMap) this.f180826a;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L6;
        r100.getLifecycle().a(new a(this, r100));
        r102 = f.a(r100);
        r101.put(r100, r102);
    L6:
        return (LifecycleOwner) r102;
    }

    public final ObservableData d(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "transform");
        return new ObservableData(MapToInsMediatorLiveDataKt.mapToInsMediatorLiveData(this.f180828c, r100));
    }

    public final void e(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r100, final g<? super T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        LifecycleOwner r102 = c(r100);
        Observer<T> r103 = new ObservableData$observe$androidObserver$1(r101);
        this.f180827b.put(r101, r103);
        this.f180828c.observe(r102, r103);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.e
    public final void b(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r100, i<T> r101, final g<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        LifecycleOwner r103 = c(r100);
        b r104 = new b(r101, r102);
        this.f180827b.put(r102, r104);
        if (r101.f180841c == false) goto L5;
        this.f180828c.observeForever(r104);
        r103.getLifecycle().addObserver(new ObservableData$selectObserve$1(this, r102));
        return;
    L5:
        this.f180828c.observe(r103, r104);
    }

    public final <A, B, C> ObservableData<m<A, B, C>> f(final KProperty1<T, ? extends A> r100, final KProperty1<T, ? extends B> r101, final KProperty1<T, ? extends C> r102) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r101, "prop2");
        Intrinsics.checkNotNullParameter(r102, "prop3");
        return new ObservableData(MapToInsMediatorLiveDataKt.mapToInsMediatorLiveData(this.f180828c, new ObservableData$selectObserve$liveData$3(r100, r101, r102)));
    }
}
