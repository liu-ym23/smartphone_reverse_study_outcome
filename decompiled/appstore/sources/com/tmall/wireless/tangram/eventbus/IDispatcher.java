package com.tmall.wireless.tangram.eventbus;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IDispatcher {
    boolean enqueue(@NonNull Event r10);

    boolean enqueue(@NonNull List<Event> r10);

    void start();

    void stopSelf();
}
