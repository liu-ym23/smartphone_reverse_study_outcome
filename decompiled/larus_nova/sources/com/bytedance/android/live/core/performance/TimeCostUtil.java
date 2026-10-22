package com.bytedance.android.live.core.performance;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class TimeCostUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f65106a = 0;

    public static final enum Tag extends Enum<Tag> {
        public static final Tag CreateLive = null;
        public static final Tag CreateStartLivePreview = null;
        public static final Tag LiveFeedInit = null;
        public static final Tag LiveFeedPreview = null;
        public static final Tag LiveFeedScroll = null;
        public static final Tag LivePk = null;
        public static final Tag ScrollWatchLivePlay = null;
        public static final Tag ShowBEFViewGift = null;
        public static final Tag ShowBInteractionFirstWidget = null;
        public static final Tag ShowBarrage = null;
        public static final Tag ShowCInteractionFirstWidget = null;
        public static final Tag ShowVideoGift = null;
        public static final Tag StartLivePlay = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Tag[] f65107a = null;

        static {
            Tag r100 = new Tag("LiveFeedInit", 0);
            LiveFeedInit = r100;
            Tag r101 = new Tag("LiveFeedPreview", 1);
            LiveFeedPreview = r101;
            Tag r102 = new Tag("LiveFeedScroll", 2);
            LiveFeedScroll = r102;
            Tag r103 = new Tag("StartLivePlay", 3);
            StartLivePlay = r103;
            Tag r104 = new Tag("ScrollWatchLivePlay", 4);
            ScrollWatchLivePlay = r104;
            Tag r105 = new Tag("CreateStartLivePreview", 5);
            CreateStartLivePreview = r105;
            Tag r110 = new Tag("CreateLive", 6);
            CreateLive = r110;
            Tag r111 = new Tag("ShowBInteractionFirstWidget", 7);
            ShowBInteractionFirstWidget = r111;
            Tag r112 = new Tag("ShowVideoGift", 8);
            ShowVideoGift = r112;
            Tag r113 = new Tag("ShowBarrage", 9);
            ShowBarrage = r113;
            Tag r114 = new Tag("ShowCInteractionFirstWidget", 10);
            ShowCInteractionFirstWidget = r114;
            Tag r115 = new Tag("LivePk", 11);
            LivePk = r115;
            Tag r106 = new Tag("ShowBEFViewGift", 12);
            ShowBEFViewGift = r106;
            f65107a = new Tag[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        }

        public static Tag[] values() {
            return (Tag[]) f65107a.clone();
        }

        public static Tag valueOf(String r100) {
            return (Tag) r27.a.a(Tag.class, r100);
        }

        public Tag(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        new ConcurrentHashMap(200);
        new ConcurrentHashMap(200);
    }

    public static HashMap<String, String> a(String r100, String r101) {
        HashMap<String, String> r102 = new HashMap();
        r102.put(r100, r101);
        return r102;
    }
}
