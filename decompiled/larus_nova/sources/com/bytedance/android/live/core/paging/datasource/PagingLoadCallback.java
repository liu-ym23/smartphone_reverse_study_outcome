package com.bytedance.android.live.core.paging.datasource;

import android.util.Pair;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface PagingLoadCallback<V> {
    Observable<Pair<List<V>, FeedExtra>> createObservable(boolean r100, Long r101, int r102);
}
