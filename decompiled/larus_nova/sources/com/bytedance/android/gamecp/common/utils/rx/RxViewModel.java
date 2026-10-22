package com.bytedance.android.gamecp.common.utils.rx;

import android.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.gamecp.common.utils.rx.rxlifecycle.LifecycleEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public class RxViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final List<Pair<LiveData, Observer>> liveDatas;
    private final BehaviorSubject<LifecycleEvent> mLifecycleBehavior;

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.compositeDisposable.clear();
        Iterator<Pair<LiveData, Observer>> r100 = this.liveDatas.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Pair<LiveData, Observer> r101 = r100.next();
        ((LiveData) r101.first).removeObserver((androidx.lifecycle.Observer) r101.second);
        goto L4
    L6:
        this.liveDatas.clear();
        this.mLifecycleBehavior.onNext(LifecycleEvent.DESTROY);
    }

    public RxViewModel() {
        this.compositeDisposable = new CompositeDisposable();
        this.mLifecycleBehavior = BehaviorSubject.create();
        this.liveDatas = new ArrayList();
    }
}
