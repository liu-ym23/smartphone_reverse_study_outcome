package com.bytedance.android.live.strategy.api;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import sb1.b;

/* JADX INFO: loaded from: classes7.dex */
public class StrategyMutableLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile T f101919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f101920b;

    @Override // androidx.lifecycle.LiveData
    public final T getValue() {
        int r100 = b.f541208a;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return (T) super.getValue();
    L10:
        if (this.f101919a == null) goto L13;
        return this.f101919a;
    L13:
        return (T) super.getValue();
    L5:
        r101 = false;
        goto L6
    }

    public StrategyMutableLiveData() {
        this.f101919a = null;
        this.f101920b = null;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public final void setValue(T r100) {
        if (this.f101920b != null) goto L5;
    L7:
        this.f101919a = r100;
        int r101 = b.f541208a;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        super.setValue(r100);
        this.f101920b = r100;
        return;
    L13:
        super.postValue(r100);
        return;
    L10:
        r102 = false;
        goto L11
    L5:
        if (this.f101920b.equals(r100) == false) goto L7;
    }
}
