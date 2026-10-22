package com.bytedance.android.livesdk.player.event;

import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class PlayerNextLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f155170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Observer, NextObserver> f155171b;

    public class NextObserver<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f155172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Observer<? super T> f155173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f155174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PlayerNextLiveData f155175d;

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T r100) {
            if (this.f155174c == false) goto L5;
        L7:
            this.f155173b.onChanged(r100);
            return;
        L5:
            if (this.f155172a < this.f155175d.f155170a) goto L7;
        }

        public NextObserver(PlayerNextLiveData r100, int r101, Observer<? super T> r102, boolean r103) {
            this.f155175d = r100;
            this.f155172a = r101;
            this.f155173b = r102;
            this.f155174c = r103;
        }
    }

    public PlayerNextLiveData() {
        this.f155170a = -1;
        this.f155171b = new HashMap();
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(Observer<? super T> r100) {
        observeForever(r100, false);
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(Observer<? super T> r100) {
        NextObserver r101 = (NextObserver) ((HashMap) this.f155171b).remove(r100);
        if (r101 == null) goto L6;
        super.removeObserver(r101);
        return;
    L6:
        super.removeObserver(r100);
        if ((r100 instanceof NextObserver) == false) goto L21;
        Iterator r102 = ((HashMap) this.f155171b).entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (r100.equals(r103.getValue()) == false) goto L10;
        Observer r104 = (Observer) r103.getKey();
    L15:
        if (r104 == null) goto L22;
        ((HashMap) this.f155171b).remove(r104);
        return;
    L22:
        return;
    L14:
        r104 = null;
        goto L15
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        this.f155170a++;
        super.setValue(r100);
        return;
    L5:
        postValue(r100);
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner r100, Observer<? super T> r101) {
        observe(r100, r101, false);
    }

    public void observeForever(Observer<? super T> r100, boolean r101) {
        if (((HashMap) this.f155171b).containsKey(r100) == false) goto L5;
        return;
    L5:
        NextObserver r102 = new NextObserver(this, this.f155170a, r100, false);
        ((HashMap) this.f155171b).put(r100, r102);
        super.observeForever(r102);
    }

    public void observe(LifecycleOwner r100, Observer<? super T> r101, boolean r102) {
        if (((HashMap) this.f155171b).containsKey(r101) == false) goto L5;
        return;
    L5:
        NextObserver r103 = new NextObserver(this, this.f155170a, r101, r102);
        ((HashMap) this.f155171b).put(r101, r103);
        super.observe(r100, r103);
    }
}
