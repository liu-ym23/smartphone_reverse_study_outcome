package com.bytedance.android.livesdkapi.feed.xtab;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H&J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/xtab/ILiveXTabFragment;", "", "addScrollListener", "", "listener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getListView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshWithAnim", "setInnerSameFeed", "sameFeed", "", "setRefreshChangeListener", "Lcom/bytedance/android/livesdkapi/feed/xtab/OnRefreshChangeListener;", "setSwipeChangeListener", "swipeChangeListener", "Lcom/bytedance/android/livesdkapi/feed/xtab/OnSwipeChangeListener;", "setSwipeDistanceToTriggerSync", "height", "", "setupScrollView", "titleHeight", "tabHeight", "tryRefresh", "isTriggeredByNav", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveXTabFragment {
    void addScrollListener(RecyclerView.OnScrollListener r100);

    RecyclerView getListView();

    void refreshWithAnim();

    void setInnerSameFeed(boolean r100);

    void setRefreshChangeListener(OnRefreshChangeListener r100);

    void setSwipeChangeListener(OnSwipeChangeListener r100);

    void setSwipeDistanceToTriggerSync(int r100);

    void setupScrollView(int r100, int r101);

    boolean tryRefresh(boolean r100);
}
