package bx1;

import com.bytedance.android.livesdkapi.feed.constant.FeedType;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21280a = null;

    static {
        int[] r100 = new int[FeedType.values().length];
        f21280a = r100;
        r100[FeedType.COMMON_FEED.ordinal()] = 1;
        r100[FeedType.HOT_FEED.ordinal()] = 2;
        r100[FeedType.FOLLOW_FEED.ordinal()] = 3;
    }
}
