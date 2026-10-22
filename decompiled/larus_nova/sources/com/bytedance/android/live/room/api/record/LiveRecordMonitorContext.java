package com.bytedance.android.live.room.api.record;

import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/api/record/LiveRecordMonitorContext;", "Lcom/bytedance/live/datacontext/DataContext;", "()V", "ignoreThisRecord", "", "recordStared", "", "ignore", "isIgnoreThisRecord", "isRecordStared", "markRecordStared", "start", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRecordMonitorContext extends DataContext {
    private boolean ignoreThisRecord;
    private boolean recordStared;

    public LiveRecordMonitorContext() {
        this.ignoreThisRecord = true;
    }

    public final boolean isIgnoreThisRecord() {
        return this.ignoreThisRecord;
    }

    public final boolean isRecordStared() {
        return this.recordStared;
    }

    public final void ignoreThisRecord(boolean r100) {
        this.ignoreThisRecord = r100;
    }

    public final void markRecordStared(boolean r100) {
        this.recordStared = r100;
    }
}
