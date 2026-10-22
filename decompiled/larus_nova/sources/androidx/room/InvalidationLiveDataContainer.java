package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
class InvalidationLiveDataContainer {
    private final RoomDatabase mDatabase;
    final Set<LiveData> mLiveDataSet;

    public InvalidationLiveDataContainer(RoomDatabase r100) {
        this.mLiveDataSet = Collections.newSetFromMap(new IdentityHashMap());
        this.mDatabase = r100;
    }

    public void onActive(LiveData r100) {
        this.mLiveDataSet.add(r100);
    }

    public void onInactive(LiveData r100) {
        this.mLiveDataSet.remove(r100);
    }

    public <T> LiveData<T> create(String[] r100, boolean r101, Callable<T> r110) {
        return new RoomTrackingLiveData(this.mDatabase, this, r101, r110, r100);
    }
}
