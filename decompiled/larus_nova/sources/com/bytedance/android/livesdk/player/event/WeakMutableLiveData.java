package com.bytedance.android.livesdk.player.event;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.player.utils.b;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/player/event/WeakMutableLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "ConvertObserver", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WeakMutableLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Observer<? super T>, ConvertObserver<T>> f155176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<WeakReference<T>> f155177b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/player/event/WeakMutableLiveData$ConvertObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", "Ljava/lang/ref/WeakReference;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ConvertObserver<T> implements Observer<WeakReference<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f155178a;

        public ConvertObserver(Observer<? super T> r100) {
            Intrinsics.checkNotNullParameter(r100, "observer");
            this.f155178a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            WeakReference r101 = (WeakReference) r100;
            if (r101 == null) goto L8;
            Object r102 = r101.get();
            if (r102 == null) goto L9;
            this.f155178a.onChanged(r102);
            return;
        L9:
            return;
        }
    }

    public WeakMutableLiveData() {
        this(true);
    }

    @Override // androidx.lifecycle.LiveData
    public final T getValue() {
        b.c("WeakMutableLiveData", "getValue");
        WeakReference<T> r100 = this.f155177b.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // androidx.lifecycle.LiveData
    public final boolean hasActiveObservers() {
        b.c("WeakMutableLiveData", "hasActiveObservers");
        return this.f155177b.hasActiveObservers();
    }

    @Override // androidx.lifecycle.LiveData
    public final boolean hasObservers() {
        b.c("WeakMutableLiveData", "hasObservers");
        return this.f155177b.hasObservers();
    }

    public WeakMutableLiveData(boolean r100) {
        this.f155176a = new LinkedHashMap();
        if (r100 == false) goto L5;
        MutableLiveData<WeakReference<T>> r101 = new WeakMutableLiveData$realLiveData$1(this);
    L6:
        this.f155177b = r101;
        return;
    L5:
        r101 = new WeakMutableLiveData$realLiveData$2(this);
        goto L6
    }

    @Override // androidx.lifecycle.LiveData
    public final void observeForever(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        b.c("WeakMutableLiveData", "observeForever: " + r100);
        if (this.f155176a.containsKey(r100) == false) goto L5;
        return;
    L5:
        ConvertObserver<T> r101 = new ConvertObserver(r100);
        this.f155176a.put(r100, r101);
        this.f155177b.observeForever(r101);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void postValue(T r100) {
        b.c("WeakMutableLiveData", "postValue: " + r100);
        if (r100 != null) goto L5;
        this.f155177b.postValue(null);
        return;
    L5:
        this.f155177b.postValue(new WeakReference(r100));
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObserver(Observer<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        b.c("WeakMutableLiveData", "removeObserver: " + r100);
        ConvertObserver<T> r101 = this.f155176a.remove(r100);
        if (r101 == null) goto L6;
        this.f155177b.removeObserver(r101);
        return;
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObservers(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        b.c("WeakMutableLiveData", "removeObservers");
        this.f155177b.removeObservers(r100);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        b.c("WeakMutableLiveData", "setValue: " + r100);
        if (r100 != null) goto L5;
        this.f155177b.setValue(null);
        return;
    L5:
        this.f155177b.setValue(new WeakReference(r100));
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<? super T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        b.c("WeakMutableLiveData", "observe: " + r101);
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        return;
    L6:
        if (this.f155176a.containsKey(r101) == false) goto L8;
        return;
    L8:
        ConvertObserver<T> r102 = new ConvertObserver(r101);
        this.f155176a.put(r101, r102);
        this.f155177b.observe(r100, r102);
    }
}
