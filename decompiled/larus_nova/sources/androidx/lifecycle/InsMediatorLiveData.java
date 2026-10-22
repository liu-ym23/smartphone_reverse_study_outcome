package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
public class InsMediatorLiveData<T> extends MutableLiveData<T> {
    private final SafeIterableMap<LiveData<?>, InsMediatorLiveData<T>.Source<?>> mSources;

    public class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Function1<? super V, T> mObserver;
        final LiveData<T> mTarget;
        int mVersion;
        final /* synthetic */ InsMediatorLiveData this$0;

        public T getValueImmediately() {
            LiveData<V> r100 = this.mLiveData;
            if ((r100 instanceof InsMediatorLiveData) == false) goto L7;
            return this.mObserver.invoke((Object) ((InsMediatorLiveData) r100).getValueImmediately());
        L7:
            return this.mObserver.invoke(r100.getValue());
        }

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
            this.mTarget.setValue(this.mObserver.invoke(r100));
            return;
        }

        public Source(InsMediatorLiveData r100, LiveData<V> r101, LiveData<T> r102, Function1<? super V, T> r103) {
            this.this$0 = r100;
            this.mVersion = -1;
            this.mLiveData = r101;
            this.mTarget = r102;
            this.mObserver = r103;
        }
    }

    public T getValueImmediately() {
        Map.Entry<LiveData<?>, InsMediatorLiveData<T>.Source<?>> r100 = this.mSources.newest();
        if (r100 != null) goto L7;
        return getValue();
    L7:
        return r100.getValue().getValueImmediately();
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, InsMediatorLiveData<T>.Source<?>>> r100 = this.mSources.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().getValue().plug();
        goto L4
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, InsMediatorLiveData<T>.Source<?>>> r100 = this.mSources.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().getValue().unplug();
        goto L4
    }

    public InsMediatorLiveData() {
        this.mSources = new SafeIterableMap();
    }

    public InsMediatorLiveData(T r100) {
        super(r100);
        this.mSources = new SafeIterableMap();
    }

    public <S> void removeSource(LiveData<S> r100) {
        InsMediatorLiveData<T>.Source<?> r101 = this.mSources.remove(r100);
        if (r101 == null) goto L6;
        r101.unplug();
        return;
    }

    public <S> void setSource(LiveData<S> r100, Function1<? super S, T> r101) {
        if (r100 == null) goto L21;
        if (this.mSources.newest() != null) goto L19;
        InsMediatorLiveData<T>.Source<?> r102 = new Source(this, r100, this, r101);
        InsMediatorLiveData<T>.Source<?> r103 = this.mSources.putIfAbsent(r100, r102);
        if (r103 != null) goto L8;
    L12:
        if (r103 == null) goto L15;
        return;
    L15:
        if (hasActiveObservers() == false) goto L22;
        r102.plug();
        return;
    L22:
        return;
    L8:
        if (r103.mObserver == r101) goto L12;
        throw new IllegalArgumentException("This source was already added with the different observer");
    L19:
        throw new IllegalArgumentException("already has source");
    L21:
        throw new NullPointerException("source cannot be null");
    }
}
