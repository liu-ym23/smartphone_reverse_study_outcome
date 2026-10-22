package com.obric.android.agilelogger;

import fa.d;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public interface ILogCacheCallback {
    Queue<d> getCachedLog();

    void notifyCacheLogConsumed();
}
