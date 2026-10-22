package com.bytedance.android.live.base.model.feed;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class a {

    @SerializedName("live_feed_preload_in_room")
    private int feedPreloadInRoom;

    @SerializedName("live_feed_preload_new_feed")
    private int feedPreloadNewFeed;

    @SerializedName("live_feed_preload_style_one")
    private int feedPreloadStyleOne;

    @SerializedName("live_feed_preload_style_two")
    private int feedPreloadStyleTwo;

    public final int c() {
        return (this.feedPreloadStyleTwo - 1) * 2;
    }

    public a() {
        this.feedPreloadNewFeed = 2;
    }

    public final int a() {
        return this.feedPreloadInRoom;
    }

    public final int b() {
        return this.feedPreloadStyleOne;
    }
}
