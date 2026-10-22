package com.jeffmony.async;

/* JADX INFO: loaded from: classes3.dex */
public interface DataTrackingEmitter extends DataEmitter {

    public interface DataTracker {
        void onData(int r10);
    }

    int getBytesRead();

    DataTracker getDataTracker();

    void setDataEmitter(DataEmitter r10);

    void setDataTracker(DataTracker r10);
}
