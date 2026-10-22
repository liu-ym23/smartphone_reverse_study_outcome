package com.android.server;

import android.content.Context;
import com.android.server.utils.TimingsTraceAndSlog;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes.dex */
interface IObricSystemServer extends IObricBase {
    default void startMemoryManagerService(Context context, TimingsTraceAndSlog t) {
    }
}
