package com.bytedance.android.livesdkapi.feed.tabviewmodel;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class NextLiveData<T> extends MutableLiveData<T> {
    private static Handler sMainHandler;
    private int mLatestVersion;
    private Map<Observer<? super T>, NextLiveData<T>.NextObserver<? super T>> nextObserverMap;

    public class NextObserver<R> implements Observer<R> {
        private int initVersion;
        private boolean notifyWhenObserve;
        private Observer<R> observer;
        final /* synthetic */ NextLiveData this$0;

        @Override // androidx.lifecycle.Observer
        public void onChanged(R r100) {
            if (this.notifyWhenObserve == false) goto L5;
        L7:
            this.observer.onChanged(r100);
            return;
        L5:
            if (this.initVersion < NextLiveData.access$000(this.this$0)) goto L7;
        }

        public NextObserver(NextLiveData r100, int r101, Observer<R> r102, boolean r103) {
            this.this$0 = r100;
            this.initVersion = r101;
            this.observer = r102;
            this.notifyWhenObserve = r103;
        }
    }

    static {
        sMainHandler = new Handler(Looper.getMainLooper());
    }

    public NextLiveData() {
        this.mLatestVersion = -1;
        this.nextObserverMap = new HashMap();
    }

    public static /* synthetic */ int access$000(NextLiveData r100) {
        return r100.mLatestVersion;
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(Observer<? super T> r100) {
        observeForever(r100, false);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(final T r100) {
        sMainHandler.post(new AnonymousClass1(this, r100));
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(Observer<? super T> r100) {
        NextLiveData<T>.NextObserver<? super T> r101 = this.nextObserverMap.remove(r100);
        if (r101 == null) goto L7;
        super.removeObserver(r101);
        return;
    L7:
        if ((r100 instanceof NextObserver) == false) goto L21;
        Iterator<Map.Entry<Observer<? super T>, NextLiveData<T>.NextObserver<? super T>>> r102 = this.nextObserverMap.entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<Observer<? super T>, NextLiveData<T>.NextObserver<? super T>> r103 = r102.next();
        if (r100.equals(r103.getValue()) == false) goto L10;
        Observer<? super T> r104 = r103.getKey();
        super.removeObserver(r100);
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
    public void observe(LifecycleOwner r100, Observer<? super T> r101) {
        observe(r100, r101, false);
    }

    public void observeForever(Observer<? super T> r100, boolean r101) {
        if (this.nextObserverMap.containsKey(r100) == false) goto L5;
        return;
    L5:
        NextLiveData<T>.NextObserver<? super T> r102 = new NextObserver(this, this.mLatestVersion, r100, r101);
        this.nextObserverMap.put(r100, r102);
        super.observeForever(r102);
    }

    public void observe(LifecycleOwner r100, Observer<? super T> r101, boolean r102) {
        if (this.nextObserverMap.containsKey(r101) == false) goto L5;
        return;
    L5:
        NextLiveData<T>.NextObserver<? super T> r103 = new NextObserver(this, this.mLatestVersion, r101, r102);
        this.nextObserverMap.put(r101, r103);
        super.observe(r100, r103);
    }
}
