package com.bytedance.android.livesdk.feed;

import com.bytedance.android.livesdk.feed.tab.monitor.FeedTabMonitor;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface j {
    Observable<List<com.bytedance.android.livesdk.feed.feed.e>> a(FeedTabMonitor.Action r100);

    boolean b(long r100);

    List<com.bytedance.android.livesdk.feed.feed.e> c();

    com.bytedance.android.livesdk.feed.feed.e d(long r100);

    Observable<List<com.bytedance.android.livesdk.feed.feed.e>> e();

    com.bytedance.android.livesdk.feed.feed.f getExtra();
}
