package com.bytedance.android.livesdk.feed;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface IFeedRepository extends ItemRepository<FeedItem> {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.feed.IFeedRepository$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ void $default$update(IFeedRepository r100, String r101) {
            ItemRepository.CC.$default$update(r100, r101);
        }
    }

    public @interface FEED_ACTION {
    }

    public @interface LoadMoreFrom {
    }

    public @interface RefreshFrom {
    }

    public interface a {
    }

    f Bf();

    PublishSubject CP();

    PublishSubject GZ();

    void I60(boolean r100);

    void Nd(BaseFeedDataViewModel.a r100);

    void clearDataCache();

    PublishSubject<Object> o10();

    void onLeave();

    com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, com.bytedance.android.livesdk.feed.feed.b> p60(String r100, Map<String, Object> r101);

    com.bytedance.android.livesdk.feed.feed.a<Listing<FeedItem>, com.bytedance.android.livesdk.feed.feed.b> query();

    void setReqFrom(String r100, String r101);

    @Override // com.bytedance.android.livesdk.feed.ItemRepository
    /* bridge */ /* synthetic */ void update(String r100);

    void vK(LifecycleOwner r100);
}
