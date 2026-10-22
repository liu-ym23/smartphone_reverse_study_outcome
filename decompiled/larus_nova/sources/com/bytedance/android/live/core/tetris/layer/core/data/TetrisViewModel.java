package com.bytedance.android.live.core.tetris.layer.core.data;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/data/TetrisViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "onCleared", "", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TetrisViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.compositeDisposable.clear();
        super.onCleared();
    }

    public TetrisViewModel() {
        this.compositeDisposable = new CompositeDisposable();
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }
}
