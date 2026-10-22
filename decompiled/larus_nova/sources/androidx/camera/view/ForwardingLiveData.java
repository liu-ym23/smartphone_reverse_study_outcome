package androidx.camera.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

/* JADX INFO: loaded from: classes2.dex */
final class ForwardingLiveData<T> extends MediatorLiveData<T> {
    private LiveData<T> mLiveDataSource;

    @Override // androidx.lifecycle.LiveData
    public T getValue() {
        LiveData<T> r100 = this.mLiveDataSource;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getValue();
    }

    public ForwardingLiveData() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSource(LiveData<T> r100) {
        LiveData<T> r101 = this.mLiveDataSource;
        if (r101 == null) goto L5;
        super.removeSource(r101);
    L5:
        this.mLiveDataSource = r100;
        super.addSource(r100, new j(this));
    }
}
