package com.bytedance.android.livesdkapi.interact.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/interact/data/LinkFeedTypeConstant;", "", "()V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkFeedTypeConstant {
    public static final Companion Companion = null;
    public static final int FEED_DOUYIN_CITY_FULL_SCREEN = 2;
    public static final int FEED_DOUYIN_CITY_HALF_SCREEN = 1;
    public static final int FEED_DOUYIN_DRAWER = 8;
    public static final int FEED_DOUYIN_FLOAT = 7;
    public static final int FEED_DOUYIN_FOLLOW = 3;
    public static final int FEED_DOUYIN_HUNTER = 9;
    public static final int FEED_DOUYIN_IM_CARD = 6;
    public static final int FEED_DOUYIN_RECOMMEND = 4;
    public static final int FEED_DOUYIN_SEARCH = 5;
    public static final int FEED_HOTSOON_CITY = 102;
    public static final int FEED_HOTSOON_FOLLOW = 101;
    public static final int FEED_UNKNOWN = -1;
    public static final int NOT_FEED = 0;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/interact/data/LinkFeedTypeConstant$Companion;", "", "()V", "FEED_DOUYIN_CITY_FULL_SCREEN", "", "FEED_DOUYIN_CITY_HALF_SCREEN", "FEED_DOUYIN_DRAWER", "FEED_DOUYIN_FLOAT", "FEED_DOUYIN_FOLLOW", "FEED_DOUYIN_HUNTER", "FEED_DOUYIN_IM_CARD", "FEED_DOUYIN_RECOMMEND", "FEED_DOUYIN_SEARCH", "FEED_HOTSOON_CITY", "FEED_HOTSOON_FOLLOW", "FEED_UNKNOWN", "NOT_FEED", "isDouyinFullScreen", "", "feedType", "isDouyinIMCardLive", "from", "isFeedType", "isHotsoonFollowAndCity", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public final boolean isDouyinFullScreen(int r100) {
            if (r100 != 3) goto L5;
        L10:
            return true;
        L5:
            if (r100 == 4) goto L10;
            if (r100 == 2) goto L10;
            return false;
        }

        public final boolean isDouyinIMCardLive(int r100) {
            if (r100 != 6) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isFeedType(int r100) {
            if (r100 == 0) goto L4;
            return true;
        L4:
            return false;
        }

        public final boolean isHotsoonFollowAndCity(int r100) {
            if (r100 != 101) goto L5;
        L8:
            return true;
        L5:
            if (r100 == 102) goto L8;
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LinkFeedTypeConstant() {
    }
}
