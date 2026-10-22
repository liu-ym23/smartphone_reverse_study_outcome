package com.ss.android.agilelogger;

import java.util.Queue;
import re.d;

/* JADX INFO: loaded from: classes4.dex */
public interface ILogCacheCallback {
    Queue<d> getCachedLog();

    void notifyCacheLogConsumed();
}
