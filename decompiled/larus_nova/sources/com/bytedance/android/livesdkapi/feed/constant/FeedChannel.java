package com.bytedance.android.livesdkapi.feed.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/constant/FeedChannel;", "", "channelName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getChannelName", "()Ljava/lang/String;", "DEFAULT", "VOICE", "SHOW", "CITY", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FeedChannel extends Enum<FeedChannel> {
    private static final /* synthetic */ FeedChannel[] $VALUES = null;
    public static final FeedChannel CITY = null;
    public static final FeedChannel DEFAULT = null;
    public static final FeedChannel SHOW = null;
    public static final FeedChannel VOICE = null;
    private final String channelName;

    static {
        FeedChannel r100 = new FeedChannel("DEFAULT", 0, "default");
        DEFAULT = r100;
        FeedChannel r101 = new FeedChannel("VOICE", 1, "voice");
        VOICE = r101;
        FeedChannel r102 = new FeedChannel("SHOW", 2, "fm");
        SHOW = r102;
        FeedChannel r103 = new FeedChannel("CITY", 3, "city");
        CITY = r103;
        $VALUES = new FeedChannel[]{r100, r101, r102, r103};
    }

    public static FeedChannel valueOf(String r100) {
        return (FeedChannel) a.a(FeedChannel.class, r100);
    }

    public static FeedChannel[] values() {
        return (FeedChannel[]) $VALUES.clone();
    }

    public final String getChannelName() {
        return this.channelName;
    }

    private FeedChannel(String r100, int r101, String r102) {
        super(r100, r101);
        this.channelName = r102;
    }
}
