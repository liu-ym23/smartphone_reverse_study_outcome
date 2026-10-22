package com.bytedance.android.livesdk.feed;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
public interface IFeedActionCallback {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/feed/IFeedActionCallback$FeedAction;", "", "TAB_CLICK", "SET_SWITCH_TAB_LISTENER", "FIRST_CARD_SHOWN", "DISLIKE_ROOM", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FeedAction extends Enum<FeedAction> {
        public static final FeedAction DISLIKE_ROOM = null;
        public static final FeedAction FIRST_CARD_SHOWN = null;
        public static final FeedAction SET_SWITCH_TAB_LISTENER = null;
        public static final FeedAction TAB_CLICK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeedAction[] f123441a = null;

        static {
            FeedAction r100 = new FeedAction("TAB_CLICK", 0);
            TAB_CLICK = r100;
            FeedAction r101 = new FeedAction("SET_SWITCH_TAB_LISTENER", 1);
            SET_SWITCH_TAB_LISTENER = r101;
            FeedAction r102 = new FeedAction("FIRST_CARD_SHOWN", 2);
            FIRST_CARD_SHOWN = r102;
            FeedAction r103 = new FeedAction("DISLIKE_ROOM", 3);
            DISLIKE_ROOM = r103;
            f123441a = new FeedAction[]{r100, r101, r102, r103};
        }

        public static FeedAction valueOf(String r100) {
            return (FeedAction) r27.a.a(FeedAction.class, r100);
        }

        public static FeedAction[] values() {
            return (FeedAction[]) f123441a.clone();
        }

        public FeedAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    void WS(FeedAction r100, Object r101);
}
