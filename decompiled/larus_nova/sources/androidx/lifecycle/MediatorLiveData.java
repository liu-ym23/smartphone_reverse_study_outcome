package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources;

    public static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<? super V> mObserver;
        int mVersion;

        public void plug() {
            this.mLiveData.observeForever(this);
        }

        public void unplug() {
            this.mLiveData.removeObserver(this);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(V r100) {
            if (this.mVersion == this.mLiveData.getVersion()) goto L6;
            this.mVersion = this.mLiveData.getVersion();
            this.mObserver.onChanged(r100);
            return;
        }

        public Source(LiveData<V> r100, Observer<? super V> r101) {
            this.mVersion = -1;
            this.mLiveData = r100;
            this.mObserver = r101;
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> r100 = this.mSources.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().getValue().plug();
        goto L4
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> r100 = this.mSources.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().getValue().unplug();
        goto L4
    }

    public MediatorLiveData() {
        this.mSources = new SafeIterableMap();
    }

    public MediatorLiveData(T r100) {
        super(r100);
        this.mSources = new SafeIterableMap();
    }

    public <S> void removeSource(LiveData<S> r100) {
        Source<?> r101 = this.mSources.remove(r100);
        if (r101 == null) goto L6;
        r101.unplug();
        return;
    }

    public <S> void addSource(LiveData<S> r100, Observer<? super S> r101) {
        if (r100 == null) goto L17;
        Source<?> r102 = new Source(r100, r101);
        Source<?> r103 = this.mSources.putIfAbsent(r100, r102);
        if (r103 != null) goto L6;
    L10:
        if (r103 == null) goto L13;
        return;
    L13:
        if (hasActiveObservers() == false) goto L18;
        r102.plug();
        return;
    L18:
        return;
    L6:
        if (r103.mObserver == r101) goto L10;
        throw new IllegalArgumentException("This source was already added with the different observer");
    L17:
        throw new NullPointerException("source cannot be null");
    }
}
