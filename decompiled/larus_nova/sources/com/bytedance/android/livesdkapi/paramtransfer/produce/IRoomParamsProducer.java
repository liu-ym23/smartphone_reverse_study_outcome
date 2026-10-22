package com.bytedance.android.livesdkapi.paramtransfer.produce;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/paramtransfer/produce/IRoomParamsProducer;", "", "getBrand", "", "produce", "", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomParamsProducer {
    public static final String BRAND_FEED_COMMON_PRODUCER = "feed_common_params";
    public static final Companion Companion = null;
    public static final String KEY_CLICK = "click";
    public static final String KEY_COMMON = "common";
    public static final String KEY_FIRST_SHOW = "first_show";
    public static final String TAG = "RoomParamsProducer";
    public static final String TAG_DETAIL_SEARCH_CLICK = "TAG_DETAIL_SEARCH_CLICK";
    public static final String TAG_DETAIL_SEARCH_DRAW = "TAG_DETAIL_SEARCH_DRAW";
    public static final String TAG_DRAWER_IN_ROOM = "TAG_DRAWER_IN_ROOM";
    public static final String TAG_FEED_EXTEND = "TAG_FEED_EXTEND";
    public static final String TAG_FEED_HEADER = "TAG_FEED_HEADER";
    public static final String TAG_FEED_PREVIEW = "TAG_FEED_PREVIEW";
    public static final String TAG_FOLLOW_SKYLIGHT = "TAG_FOLLOW_SKYLIGHT";
    public static final String TAG_HOMEPAGE_SQUARE = "TAG_HOMEPAGE_SQUARE";
    public static final String TAG_IM_LIST = "TAG_IM_LIST";
    public static final String TAG_IM_MESSAGE_LIST = "TAG_IM_MESSAGE_LIST";
    public static final String TAG_JUMP_IN_ROOM = "TAG_JUMP_IN_ROOM";
    public static final String TAG_LIVE_CHANNEL_SKYLIGHT = "TAG_LIVE_CHANNEL_SKYLIGHT";
    public static final String TAG_LIVE_MERGE = "TAG_LIVE_MERGE";
    public static final String TAG_PROFILE_HEADER = "TAG_PROFILE_HEADER";
    public static final String TAG_PROFILE_RELATION_HEADER = "TAG_PROFILE_RELATION_HEADER";
    public static final String TAG_SEARCH_MIX_HEADER = "TAG_SEARCH_MIX_HEADER";
    public static final String TAG_VIDEO_FEED_COVER_HEADER = "TAG_VIDEO_FEED_COVER_HEADER";
    public static final String TYPE_AD = "ad";
    public static final String TYPE_COMMUNITY = "comminity";
    public static final String TYPE_ECOM = "ecom";
    public static final String TYPE_ENTER = "enter";
    public static final String TYPE_EVENT = "event";
    public static final String TYPE_EXTRA = "extra";
    public static final String TYPE_GAMECP = "gamecp";
    public static final String TYPE_LIFE = "life";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/paramtransfer/produce/IRoomParamsProducer$Companion;", "", "()V", "BRAND_FEED_COMMON_PRODUCER", "", "KEY_CLICK", "KEY_COMMON", "KEY_FIRST_SHOW", "TAG", "TAG_DETAIL_SEARCH_CLICK", "TAG_DETAIL_SEARCH_DRAW", "TAG_DRAWER_IN_ROOM", "TAG_FEED_EXTEND", "TAG_FEED_HEADER", "TAG_FEED_PREVIEW", "TAG_FOLLOW_SKYLIGHT", "TAG_HOMEPAGE_SQUARE", "TAG_IM_LIST", "TAG_IM_MESSAGE_LIST", "TAG_JUMP_IN_ROOM", "TAG_LIVE_CHANNEL_SKYLIGHT", "TAG_LIVE_MERGE", "TAG_PROFILE_HEADER", "TAG_PROFILE_RELATION_HEADER", "TAG_SEARCH_MIX_HEADER", "TAG_VIDEO_FEED_COVER_HEADER", "TYPE_AD", "TYPE_COMMUNITY", "TYPE_ECOM", "TYPE_ENTER", "TYPE_EVENT", "TYPE_EXTRA", "TYPE_GAMECP", "TYPE_LIFE", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String BRAND_FEED_COMMON_PRODUCER = "feed_common_params";
        public static final String KEY_CLICK = "click";
        public static final String KEY_COMMON = "common";
        public static final String KEY_FIRST_SHOW = "first_show";
        public static final String TAG = "RoomParamsProducer";
        public static final String TAG_DETAIL_SEARCH_CLICK = "TAG_DETAIL_SEARCH_CLICK";
        public static final String TAG_DETAIL_SEARCH_DRAW = "TAG_DETAIL_SEARCH_DRAW";
        public static final String TAG_DRAWER_IN_ROOM = "TAG_DRAWER_IN_ROOM";
        public static final String TAG_FEED_EXTEND = "TAG_FEED_EXTEND";
        public static final String TAG_FEED_HEADER = "TAG_FEED_HEADER";
        public static final String TAG_FEED_PREVIEW = "TAG_FEED_PREVIEW";
        public static final String TAG_FOLLOW_SKYLIGHT = "TAG_FOLLOW_SKYLIGHT";
        public static final String TAG_HOMEPAGE_SQUARE = "TAG_HOMEPAGE_SQUARE";
        public static final String TAG_IM_LIST = "TAG_IM_LIST";
        public static final String TAG_IM_MESSAGE_LIST = "TAG_IM_MESSAGE_LIST";
        public static final String TAG_JUMP_IN_ROOM = "TAG_JUMP_IN_ROOM";
        public static final String TAG_LIVE_CHANNEL_SKYLIGHT = "TAG_LIVE_CHANNEL_SKYLIGHT";
        public static final String TAG_LIVE_MERGE = "TAG_LIVE_MERGE";
        public static final String TAG_PROFILE_HEADER = "TAG_PROFILE_HEADER";
        public static final String TAG_PROFILE_RELATION_HEADER = "TAG_PROFILE_RELATION_HEADER";
        public static final String TAG_SEARCH_MIX_HEADER = "TAG_SEARCH_MIX_HEADER";
        public static final String TAG_VIDEO_FEED_COVER_HEADER = "TAG_VIDEO_FEED_COVER_HEADER";
        public static final String TYPE_AD = "ad";
        public static final String TYPE_COMMUNITY = "comminity";
        public static final String TYPE_ECOM = "ecom";
        public static final String TYPE_ENTER = "enter";
        public static final String TYPE_EVENT = "event";
        public static final String TYPE_EXTRA = "extra";
        public static final String TYPE_GAMECP = "gamecp";
        public static final String TYPE_LIFE = "life";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    String getBrand();

    void produce();
}
