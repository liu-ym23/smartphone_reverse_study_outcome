package androidx.camera.core.impl;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public interface Observable<T> {

    public interface Observer<T> {
        void onError(Throwable r100);

        void onNewData(T r100);
    }

    void addObserver(Executor r100, Observer<? super T> r101);

    ListenableFuture<T> fetchData();

    void removeObserver(Observer<? super T> r100);
}
