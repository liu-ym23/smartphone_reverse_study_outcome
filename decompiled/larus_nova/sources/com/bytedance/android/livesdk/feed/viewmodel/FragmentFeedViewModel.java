package com.bytedance.android.livesdk.feed.viewmodel;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.livesdk.feed.IFeedRepository;

/* JADX INFO: loaded from: classes8.dex */
public class FragmentFeedViewModel extends BaseFeedDataViewModel {
    private boolean preload;
    private boolean shouldRefresh;
    private boolean started;
    private boolean userVisible;

    private void onLeave() {
        if (this.started == false) goto L9;
        IFeedRepository r100 = this.feedRepository;
        if (r100 == null) goto L10;
        r100.onLeave();
        return;
    L10:
        return;
    }

    private void realStart() {
        if (this.started == false) goto L5;
        return;
    L5:
        super.start();
        this.started = true;
        this.preload = false;
    }

    public void clearDataCache() {
        IFeedRepository r100 = this.feedRepository;
        if (r100 == null) goto L6;
        r100.clearDataCache();
        return;
    }

    public Extra extra() {
        IFeedRepository r100 = this.feedRepository;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.extra();
    }

    @Override // com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel
    public void start() {
        if (this.preload == false) goto L5;
    L6:
        realStart();
        return;
    L5:
        if (this.userVisible == true) goto L6;
    }

    public boolean getStarted() {
        return this.started;
    }

    public boolean shouldRefresh() {
        return this.shouldRefresh;
    }

    public void onFragmentUserVisibleHint(boolean r100) {
        this.userVisible = r100;
        if (r100 == true) goto L5;
        onLeave();
    L5:
        start();
    }

    public void setPreload(boolean r100) {
        this.preload = r100;
    }

    public void setShouldRefresh(boolean r100) {
        this.shouldRefresh = r100;
    }

    public void setStarted(boolean r100) {
        this.started = r100;
    }

    public FragmentFeedViewModel(IFeedRepository r100, com.bytedance.android.livesdk.feed.g r101, hw1.a r102) {
        super(r100, r101, r102);
    }
}
