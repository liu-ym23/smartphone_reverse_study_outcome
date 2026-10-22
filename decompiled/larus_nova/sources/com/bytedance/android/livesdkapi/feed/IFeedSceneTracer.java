package com.bytedance.android.livesdkapi.feed;

/* JADX INFO: loaded from: classes12.dex */
public interface IFeedSceneTracer {
    public static final String CITY_FEED_SCENE = "city_feed_scene";
    public static final String FOLLOW_FEED_SCENE = "follow_feed_scene";
    public static final String LIVE_FEED_SCENE = "live_feed_scene";

    void end(String r100);

    void realStart(String r100);

    void start(String r100);
}
