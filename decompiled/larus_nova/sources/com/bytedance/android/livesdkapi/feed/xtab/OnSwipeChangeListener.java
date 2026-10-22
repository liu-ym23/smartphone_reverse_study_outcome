package com.bytedance.android.livesdkapi.feed.xtab;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/xtab/OnSwipeChangeListener;", "", "onOverScroll", "", "overScrollDistance", "", "percent", "onRefreshFinish", "onRefreshStartManually", "onReleaseAndRefresh", "onReleaseAndScrollBack", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OnSwipeChangeListener {
    void onOverScroll(float r100, float r101);

    void onRefreshFinish();

    void onRefreshStartManually();

    void onReleaseAndRefresh();

    void onReleaseAndScrollBack();
}
