package com.obric.structure.omvvm.core.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.obric.structure.omvvm.core.observer.QAsyncObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QAsyncLiveData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\u0017\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0017\u0010\u0012\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/structure/omvvm/core/viewmodel/QAsyncLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "liveData", "Lcom/obric/structure/omvvm/core/viewmodel/QArchLiveData;", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Lcom/obric/structure/omvvm/core/observer/QAsyncObserver;", "observeForever", "postValue", "t", "(Ljava/lang/Object;)V", "removeObserver", "removeObservers", "setValue", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class QAsyncLiveData<T> {
    private QArchLiveData<T> liveData;

    public QAsyncLiveData() {
        this.liveData = new QArchLiveData();
    }

    public void observe(LifecycleOwner r2, QAsyncObserver<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.liveData.observe(r2, r3);
    }

    public void observeForever(QAsyncObserver<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.liveData.observeForever(r2);
    }

    public void removeObserver(QAsyncObserver<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.liveData.removeObserver(r2);
    }

    public void removeObservers(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        this.liveData.removeObservers(r2);
    }

    public void setValue(T r1) {
        this.liveData.setValue(r1);
    }

    public void postValue(T r1) {
        this.liveData.postValue(r1);
    }
}
