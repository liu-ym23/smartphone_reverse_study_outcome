package com.obric.structure.omvvm.core.viewmodel;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.obric.structure.omvvm.core.Q;
import com.obric.structure.omvvm.core.performance.QVsyncFrameCaller;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public class QArchLiveData<T> extends MutableLiveData<T> {
    private static boolean sBindScatterOpt;
    private static Handler sMainHandler;
    private static boolean sPostScatter;
    private int mLatestVersion;
    private Map<Observer, QArchLiveData<T>.NextObserver<T>> nextObserverMap;
    private Function1<T, Void> onValueSet;

    private class NextObserver<R> implements Observer<R>, LifecycleEventObserver {
        private int initVersion;
        private LifecycleOwner mOwner;
        private boolean notifyWhenObserve;
        private Observer<? super R> observer;
        final /* synthetic */ QArchLiveData this$0;

        static /* synthetic */ Observer access$000(NextObserver r0) {
            return r0.observer;
        }

        NextObserver(QArchLiveData r1, int r2, Observer<? super R> r3, boolean r4, LifecycleOwner r5) {
            this.this$0 = r1;
            this.initVersion = r2;
            this.observer = r3;
            this.notifyWhenObserve = r4;
            if (Q.fixQLiveDataMemLeak() == false) goto L8;
            this.mOwner = r5;
            if (r5 == null) goto L9;
            r5.getLifecycle().addObserver(this);
            return;
        L9:
            return;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(R r3) {
            if (this.notifyWhenObserve == false) goto L5;
        L7:
            this.observer.onChanged(r3);
            return;
        L5:
            if (this.initVersion < QArchLiveData.access$100(this.this$0)) goto L7;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r1, Lifecycle.Event r2) {
            LifecycleOwner r3 = this.mOwner;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L9;
            QArchLiveData.access$200(this.this$0, this.observer);
            return;
        }

        void detachObserver() {
            LifecycleOwner r0 = this.mOwner;
            if (r0 == null) goto L6;
            r0.getLifecycle().removeObserver(this);
            return;
        }
    }

    static /* synthetic */ int access$100(QArchLiveData r0) {
        return r0.mLatestVersion;
    }

    static /* synthetic */ NextObserver access$200(QArchLiveData r0, Observer r1) {
        return r0.removeNextObserver(r1);
    }

    static {
        sMainHandler = new Handler(Looper.getMainLooper());
        sBindScatterOpt = false;
        sPostScatter = true;
    }

    public void setOnValueSet(Function1<T, Void> r1) {
        this.onValueSet = r1;
    }

    private void notifyOnValueSet(T r1) {
        Function1<T, Void> r0 = this.onValueSet;
        if (r0 == null) goto L6;
        r0.invoke(r1);
        return;
    }

    public QArchLiveData(T r1) {
        super(r1);
        this.mLatestVersion = -1;
        this.nextObserverMap = new HashMap();
    }

    public QArchLiveData() {
        this.mLatestVersion = -1;
        this.nextObserverMap = new HashMap();
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner r2, Observer<? super T> r3) {
        observe(r2, r3, false);
    }

    public void observe(LifecycleOwner r9, Observer<? super T> r10, boolean r11) {
        if (this.nextObserverMap.containsKey(r10) == false) goto L6;
        return;
    L6:
        if (Q.fixQLiveDataMemLeak() == true) goto L8;
    L10:
        QArchLiveData<T>.NextObserver<T> r0 = new NextObserver(this, this.mLatestVersion, r10, r11, r9);
        this.nextObserverMap.put(r10, r0);
        super.observe(r9, r0);
        return;
    L8:
        if (r9.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L10;
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(Observer<? super T> r2) {
        observeForever(r2, false);
    }

    public void observeForever(Observer<? super T> r8, boolean r9) {
        if (this.nextObserverMap.containsKey(r8) == false) goto L5;
        return;
    L5:
        QArchLiveData<T>.NextObserver<T> r0 = new NextObserver(this, this.mLatestVersion, r8, r9, null);
        this.nextObserverMap.put(r8, r0);
        super.observeForever(r0);
    }

    private QArchLiveData<T>.NextObserver<T> removeNextObserver(Observer r1) {
        QArchLiveData<T>.NextObserver<T> r0 = this.nextObserverMap.remove(r1);
        if (r0 == null) goto L5;
        r0.detachObserver();
    L5:
        return r0;
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(Observer<? super T> r4) {
        QArchLiveData<T>.NextObserver<T> r0 = removeNextObserver(r4);
        if (r0 == null) goto L6;
        super.removeObserver(r0);
        return;
    L6:
        boolean r1 = r4 instanceof NextObserver;
        if (r1 == false) goto L14;
        Observer r2 = NextObserver.access$000((NextObserver) r4);
        if (r2 == null) goto L14;
        QArchLiveData<T>.NextObserver<T> r3 = removeNextObserver(r2);
        if (r3 == null) goto L14;
        super.removeObserver(r3);
        return;
    L14:
        if (r1 == false) goto L28;
        Iterator<Map.Entry<Observer, QArchLiveData<T>.NextObserver<T>>> r5 = this.nextObserverMap.entrySet().iterator();
    L17:
        if (r5.hasNext() == false) goto L21;
        Map.Entry<Observer, QArchLiveData<T>.NextObserver<T>> r6 = r5.next();
        if (r4.equals(r6.getValue()) == false) goto L17;
        Observer r7 = r6.getKey();
        super.removeObserver(r4);
    L22:
        if (r7 == null) goto L29;
        removeNextObserver(r7);
        return;
    L29:
        return;
    L21:
        r7 = null;
        goto L22
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T r2) {
        this.mLatestVersion++;
        super.setValue(r2);
        notifyOnValueSet(r2);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(final T r3) {
        if (sBindScatterOpt == false) goto L5;
        postValueScatter(r3);
        return;
    L5:
        sMainHandler.post(new QArchLiveData$$ExternalSyntheticLambda0(this, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$postValue$0$com-obric-structure-omvvm-core-viewmodel-QArchLiveData, reason: not valid java name */
    /* synthetic */ void m775x3e6cc662(Object r1) {
        setValue(r1);
    }

    public void postValueDelay(final T r3, long r4) {
        if (sBindScatterOpt == false) goto L5;
        postValueScatter(r3, r4);
        return;
    L5:
        sMainHandler.postDelayed(new QArchLiveData$$ExternalSyntheticLambda1(this, r3), r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$postValueDelay$1$com-obric-structure-omvvm-core-viewmodel-QArchLiveData, reason: not valid java name */
    /* synthetic */ void m776xc1851fe6(Object r1) {
        setValue(r1);
    }

    public void postValueScatter(T r3) {
        postValueScatter(r3, 0);
    }

    /* JADX INFO: renamed from: lambda$postValueScatter$3$com-obric-structure-omvvm-core-viewmodel-QArchLiveData, reason: not valid java name */
    /* synthetic */ void m778x6bcf2fc9(final Object r3) {
        QVsyncFrameCaller.INSTANCE.postBind(new QArchLiveData$$ExternalSyntheticLambda2(this, r3), sPostScatter);
    }

    public void postValueScatter(final T r3, long r4) {
        sMainHandler.postDelayed(new QArchLiveData$$ExternalSyntheticLambda3(this, r3), r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$postValueScatter$2$com-obric-structure-omvvm-core-viewmodel-QArchLiveData, reason: not valid java name */
    /* synthetic */ Unit m777x6a98dcea(Object r1) {
        setValue(r1);
        notifyOnValueSet(r1);
        return Unit.INSTANCE;
    }

    public static void setBindScatterOpt(boolean r0) {
        sBindScatterOpt = r0;
    }

    public static void setIsPostScatter(boolean r0) {
        sPostScatter = r0;
    }
}
