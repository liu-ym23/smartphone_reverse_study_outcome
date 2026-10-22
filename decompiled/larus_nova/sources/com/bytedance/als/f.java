package com.bytedance.als;

import androidx.core.util.Pair;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes43.dex */
public class f<T> {
    private MutableLiveData<T> mLiveData;
    private final List<Pair<Observer<T>, LifecycleOwner>> mObserverList;
    private final Set<Observer<T>> mObserverSet;

    public class a implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Observer f38091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f38092b;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            f.access$000(this.f38092b, this.f38091a);
        }

        public a(f r100, Observer r101) {
            this.f38092b = r100;
            this.f38091a = r101;
        }
    }

    private void createLiveDataIfNotExistsOrAlreadyHasValue() {
        MutableLiveData<T> r100 = this.mLiveData;
        if (r100 != null) goto L5;
        this.mLiveData = new MutableLiveData();
        return;
    L5:
        if (r100.getValue() == null) goto L26;
        Iterator<Pair<Observer<T>, LifecycleOwner>> r101 = this.mObserverList.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        Pair<Observer<T>, LifecycleOwner> r102 = r101.next();
        this.mLiveData.removeObserver(r102.first);
        goto L8
    L10:
        this.mLiveData = new MutableLiveData();
        Iterator<Pair<Observer<T>, LifecycleOwner>> r103 = this.mObserverList.iterator();
    L12:
        if (r103.hasNext() == false) goto L27;
        Pair<Observer<T>, LifecycleOwner> r104 = r103.next();
        LifecycleOwner r105 = r104.second;
        if (r105 != null) goto L15;
        this.mLiveData.observeForever(r104.first);
        goto L12
    L15:
        this.mLiveData.observe(r105, r104.first);
        goto L12
    L27:
        return;
    }

    public T getValue() {
        MutableLiveData<T> r100 = this.mLiveData;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    public f() {
        this.mObserverSet = new HashSet();
        this.mObserverList = new ArrayList();
    }

    private void cleanObserver(Observer<T> r100) {
        this.mObserverSet.remove(r100);
        Iterator<Pair<Observer<T>, LifecycleOwner>> r101 = this.mObserverList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r101.next().first != r100) goto L4;
        r101.remove();
    L8:
        MutableLiveData<T> r102 = this.mLiveData;
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.hasObservers() == true) goto L18;
        this.mLiveData = null;
        return;
    }

    public void observeForever(Observer<T> r100) {
        if (this.mObserverSet.contains(r100) == true) goto L7;
        this.mObserverSet.add(r100);
        createLiveDataIfNotExistsOrAlreadyHasValue();
        this.mObserverList.add(Pair.create(r100, null));
        this.mLiveData.observeForever(r100);
        return;
    L7:
        throw new IllegalArgumentException("Can't add the same observer twice");
    }

    public void postValue(T r100) {
        MutableLiveData<T> r101 = this.mLiveData;
        if (r101 == null) goto L6;
        r101.postValue(r100);
        return;
    }

    public void removeObserver(Observer<T> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        MutableLiveData<T> r101 = this.mLiveData;
        if (r101 == null) goto L8;
        r101.removeObserver(r100);
        cleanObserver(r100);
        return;
    }

    public void setValue(T r100) {
        MutableLiveData<T> r101 = this.mLiveData;
        if (r101 == null) goto L6;
        r101.setValue(r100);
        return;
    }

    public static /* synthetic */ void access$000(f r100, Observer r101) {
        r100.cleanObserver(r101);
    }

    public void observe(LifecycleOwner r100, Observer<T> r101) {
        if (r100 == null) goto L13;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L8;
        return;
    L8:
        if (this.mObserverSet.contains(r101) == true) goto L12;
        this.mObserverSet.add(r101);
        createLiveDataIfNotExistsOrAlreadyHasValue();
        this.mObserverList.add(Pair.create(r101, r100));
        this.mLiveData.observe(r100, r101);
        r100.getLifecycle().addObserver(new a(this, r101));
        return;
    L12:
        throw new IllegalArgumentException("Can't add the same observer twice");
    }
}
