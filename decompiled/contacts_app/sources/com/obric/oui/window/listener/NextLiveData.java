package com.obric.oui.window.listener;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class NextLiveData<T> extends MutableLiveData<T> {
    private static final Handler sMainHandler = null;
    private int mLatestVersion;
    private final Map<Observer<? super T>, NextLiveData<T>.NextObserver<? super T>> nextObserverMap;

    private class NextObserver<R> implements Observer<R> {
        private int initVersion;
        private boolean notifyWhenObserve;
        private Observer<R> observer;
        final /* synthetic */ NextLiveData this$0;

        NextObserver(NextLiveData r1, int r2, Observer<R> r3, boolean r4) {
            this.this$0 = r1;
            this.initVersion = r2;
            this.observer = r3;
            this.notifyWhenObserve = r4;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(R r3) {
            if (this.notifyWhenObserve == false) goto L5;
        L7:
            this.observer.onChanged(r3);
            return;
        L5:
            if (this.initVersion < NextLiveData.access$000(this.this$0)) goto L7;
        }
    }

    public NextLiveData() {
        this.mLatestVersion = -1;
        this.nextObserverMap = new HashMap();
    }

    static /* synthetic */ int access$000(NextLiveData r0) {
        return r0.mLatestVersion;
    }

    static {
        sMainHandler = new Handler(Looper.getMainLooper());
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner r2, Observer<? super T> r3) {
        observe(r2, r3, false);
    }

    public void observe(LifecycleOwner r3, Observer<? super T> r4, boolean r5) {
        if (this.nextObserverMap.containsKey(r4) == false) goto L5;
        return;
    L5:
        NextLiveData<T>.NextObserver<? super T> r0 = new NextObserver(this, this.mLatestVersion, r4, r5);
        this.nextObserverMap.put(r4, r0);
        super.observe(r3, r0);
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(Observer<? super T> r2) {
        observeForever(r2, false);
    }

    public void observeForever(Observer<? super T> r3, boolean r4) {
        if (this.nextObserverMap.containsKey(r3) == false) goto L5;
        return;
    L5:
        NextLiveData<T>.NextObserver<? super T> r0 = new NextObserver(this, this.mLatestVersion, r3, r4);
        this.nextObserverMap.put(r3, r0);
        super.observeForever(r0);
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(Observer<? super T> r4) {
        NextLiveData<T>.NextObserver<? super T> r0 = this.nextObserverMap.remove(r4);
        if (r0 == null) goto L7;
        super.removeObserver(r0);
        return;
    L7:
        if ((r4 instanceof NextObserver) == false) goto L21;
        Iterator<Map.Entry<Observer<? super T>, NextLiveData<T>.NextObserver<? super T>>> r1 = this.nextObserverMap.entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<Observer<? super T>, NextLiveData<T>.NextObserver<? super T>> r2 = r1.next();
        if (r4.equals(r2.getValue()) == false) goto L10;
        Observer<? super T> r3 = r2.getKey();
        super.removeObserver(r4);
    L15:
        if (r3 == null) goto L22;
        this.nextObserverMap.remove(r3);
        return;
    L22:
        return;
    L14:
        r3 = null;
        goto L15
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T r2) {
        this.mLatestVersion++;
        super.setValue(r2);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(final T r3) {
        sMainHandler.post(new AnonymousClass1(this, r3));
    }
}
