package com.bytedance.android.livesdk.feed.viewmodel;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdk.feed.IFeedRepository;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes8.dex */
public class TabFeedViewModel extends FragmentFeedViewModel {
    private static final String DEFAULT_LABEL = "video";
    private static final String DY_DEFAULT_LABEL = "live_merge_null";
    protected com.bytedance.android.livesdk.feed.j feedTabRepository;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f124563id;
    private int mLastOffset;
    private int mLastPosition;
    private com.bytedance.android.livesdk.feed.m scrollTop;

    @Override // com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel
    public void mocRefresh(String r100) {
    }

    @Override // com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel
    public String event() {
        if (TextUtils.isEmpty(this.eventType) == false) goto L8;
        if (this.feedTabRepository.d(this.f124563id) == null) goto L8;
        this.eventType = this.feedTabRepository.d(this.f124563id).e();
    L8:
        if (TextUtils.isEmpty(this.eventType) == false) goto L11;
        this.eventType = DY_DEFAULT_LABEL;
    L11:
        return this.eventType;
    }

    @Override // com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel
    public String getUrl() {
        if (StringUtils.isEmpty(this.url) == false) goto L13;
        if (this.feedTabRepository.d(this.f124563id) == null) goto L13;
        if (this.feedTabRepository.d(this.f124563id).n() != null) goto L9;
        return "";
    L9:
        return this.feedTabRepository.d(this.f124563id).n();
    L13:
        return this.url;
    }

    @Override // com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel
    public boolean scrollTop() {
        com.bytedance.android.livesdk.feed.m r100 = this.scrollTop;
        feedDataKey();
        r100.a();
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.viewmodel.BaseFeedDataViewModel
    public FeedDataKey buildFeedDataKey() {
        return FeedDataKey.a(event(), getUrl(), this.f124563id);
    }

    public String pageKey() {
        return event();
    }

    public int getLastOffset() {
        return this.mLastOffset;
    }

    public int getLastPosition() {
        return this.mLastPosition;
    }

    public void setLastOffset(int r100) {
        this.mLastOffset = r100;
    }

    public void setLastPosition(int r100) {
        this.mLastPosition = r100;
    }

    public void setUrl(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        Uri r101 = UriProtector.parse(r100);
        this.url = r101.getPath() + "?" + r101.getQuery();
        return;
    }

    public TabFeedViewModel(IFeedRepository r100, com.bytedance.android.livesdk.feed.g r101, com.bytedance.android.livesdk.feed.j r102, hw1.a r103, com.bytedance.android.livesdk.feed.m r104, long r105) {
        super(r100, r101, r103);
        this.feedTabRepository = r102;
        this.f124563id = r105;
        this.scrollTop = r104;
    }
}
