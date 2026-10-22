package com.obric.livecard.api.impl;

import android.os.SystemClock;
import com.obric.livecard.api.IIslandStatusCallback;

/* JADX INFO: compiled from: IslandStatusCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class IslandStatusCallback extends IIslandStatusCallback.Stub {
    private final long tag;

    public IslandStatusCallback() {
        this.tag = SystemClock.elapsedRealtime();
    }

    public final long getTag() {
        return this.tag;
    }

    @Override // com.obric.livecard.api.IIslandStatusCallback
    public long getId() {
        return this.tag;
    }
}
