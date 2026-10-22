package com.bytedance.android.livesdkapi.base;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class BaseNextLiveData<T> extends MutableLiveData<T> {
    private int mLatestVersion;
    private Map<androidx.lifecycle.Observer<T>, BaseNextLiveData<T>.NextObserver<T>> nextObserverMap;

    public class NextObserver<E> implements androidx.lifecycle.Observer<E> {
        private int initVersion;
        private final boolean notifyWhenObserve;
        private androidx.lifecycle.Observer<? super E> observer;
        final /* synthetic */ BaseNextLiveData this$0;

        @Override // androidx.lifecycle.Observer
        public void onChanged(E r100) {
            if (this.notifyWhenObserve == false) goto L5;
        L7:
            this.observer.onChanged(r100);
            return;
        L5:
            if (this.initVersion < BaseNextLiveData.access$000(this.this$0)) goto L7;
        }

        public NextObserver(BaseNextLiveData r100, int r101, androidx.lifecycle.Observer<? super E> r102, boolean r103) {
            this.this$0 = r100;
            this.initVersion = r101;
            this.observer = r102;
            this.notifyWhenObserve = r103;
        }
    }

    public BaseNextLiveData() {
        this.mLatestVersion = -1;
        this.nextObserverMap = new HashMap();
    }

    public static /* synthetic */ int access$000(BaseNextLiveData r100) {
        return r100.mLatestVersion;
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(androidx.lifecycle.Observer<? super T> r100) {
        observeForever(r100, false);
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(androidx.lifecycle.Observer<? super T> r100) {
        BaseNextLiveData<T>.NextObserver<T> r101 = this.nextObserverMap.remove(r100);
        if (r101 == null) goto L6;
        super.removeObserver(r101);
        return;
    L6:
        super.removeObserver(r100);
        if ((r100 instanceof NextObserver) == false) goto L21;
        Iterator<Map.Entry<androidx.lifecycle.Observer<T>, BaseNextLiveData<T>.NextObserver<T>>> r102 = this.nextObserverMap.entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<androidx.lifecycle.Observer<T>, BaseNextLiveData<T>.NextObserver<T>> r103 = r102.next();
        if (r100.equals(r103.getValue()) == false) goto L10;
        androidx.lifecycle.Observer<T> r104 = r103.getKey();
    L15:
        if (r104 == null) goto L22;
        this.nextObserverMap.remove(r104);
        return;
    L22:
        return;
    L14:
        r104 = null;
        goto L15
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T r100) {
        this.mLatestVersion++;
        super.setValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner r100, androidx.lifecycle.Observer<? super T> r101) {
        observe(r100, r101, false);
    }

    public void observeForever(androidx.lifecycle.Observer<? super T> r100, boolean r101) {
        if (this.nextObserverMap.containsKey(r100) == false) goto L5;
        return;
    L5:
        BaseNextLiveData<T>.NextObserver<T> r102 = new NextObserver(this, this.mLatestVersion, r100, r101);
        this.nextObserverMap.put(r100, r102);
        super.observeForever(r102);
    }

    public void observe(LifecycleOwner r100, androidx.lifecycle.Observer<? super T> r101, boolean r102) {
        if (this.nextObserverMap.containsKey(r101) == false) goto L5;
        return;
    L5:
        BaseNextLiveData<T>.NextObserver<T> r103 = new NextObserver(this, this.mLatestVersion, r101, r102);
        this.nextObserverMap.put(r101, r103);
        super.observe(r100, r103);
    }
}
