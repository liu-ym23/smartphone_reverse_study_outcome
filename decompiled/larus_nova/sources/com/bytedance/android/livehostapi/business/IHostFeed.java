package com.bytedance.android.livehostapi.business;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livesdk.feed.feed.e;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@ServiceLookup("com.bytedance.android.livesdk.feed.tab.FeedUrlService")
public interface IHostFeed extends IService {
    public static final String KEY_FEED_STYLE = "feed_style";
    public static final String KEY_FEED_URL = "feed_url";

    Fragment createDrawerFeedFragment(IDrawerFeedAction r100, boolean r101);

    Fragment createSingleDrawerFeedFragment();

    Fragment createVsDrawerFeedFragment(IDrawerFeedAction r100);

    Map<String, Object> getFeedTab(long r100);

    List<e> getNewDrawerTabList();

    List<e> getTabList();

    void preloadDrawerFeed(FragmentActivity r100, boolean r101);

    void requestTabApi();

    boolean shouldDrawerMultiTab();
}
