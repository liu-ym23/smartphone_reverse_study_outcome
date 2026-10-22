package com.bytedance.android.livesdk.feed;

import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public interface f {

    public interface a {
        void a(String r100);
    }

    void a(String r100, List<FeedItem> r101, FeedExtra r102, boolean r103);

    void b(a r100);

    void c(com.bytedance.android.livesdk.feed.feed.d r100);

    ItemRepository d(FeedDataKey r100);

    void e(FeedDataKey r100, String r101);

    void f(com.bytedance.android.livesdk.feed.feed.d r100);

    void g(FeedDataKey r100, ItemRepository r101);

    boolean h(FeedDataKey r100, ItemRepository r101);

    void i(a r100);
}
