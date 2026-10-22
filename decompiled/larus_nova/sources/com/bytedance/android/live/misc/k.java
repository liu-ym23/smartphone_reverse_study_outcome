package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.browse.LiveBrowserService;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class k implements Callable {
    public /* synthetic */ k() {
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return new LiveBrowserService();
    }
}
