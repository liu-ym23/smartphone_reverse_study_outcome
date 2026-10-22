package com.bytedance.android.livesdkapi.depend.live;

import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
public final enum EntryType extends Enum<EntryType> {
    private static final /* synthetic */ EntryType[] $VALUES = null;
    public static final EntryType FEED = null;
    public static final EntryType FEED_SHORTCUT = null;
    public static final EntryType FEED_WITH_PREVIEW = null;
    public static final EntryType LIVE_END = null;
    public static final EntryType MOMENT = null;
    public static final EntryType OTHER = null;
    public static final EntryType PUSH = null;
    public static final EntryType SLIDE = null;
    public static final EntryType WEB = null;
    public final String typeName;

    static {
        EntryType r100 = new EntryType("FEED_WITH_PREVIEW", 0, "feed_with_preview");
        FEED_WITH_PREVIEW = r100;
        EntryType r101 = new EntryType("FEED", 1, "feed");
        FEED = r101;
        EntryType r102 = new EntryType("FEED_SHORTCUT", 2, "feed_shortcut");
        FEED_SHORTCUT = r102;
        EntryType r103 = new EntryType("MOMENT", 3, "moment");
        MOMENT = r103;
        EntryType r104 = new EntryType("SLIDE", 4, "slide");
        SLIDE = r104;
        EntryType r105 = new EntryType("LIVE_END", 5, "live_end");
        LIVE_END = r105;
        EntryType r110 = new EntryType(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID, 6, "push");
        PUSH = r110;
        EntryType r111 = new EntryType("WEB", 7, "web");
        WEB = r111;
        EntryType r112 = new EntryType(FlowDoraWifiScene.OTHER, 8, "other");
        OTHER = r112;
        $VALUES = new EntryType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static EntryType[] values() {
        return (EntryType[]) $VALUES.clone();
    }

    public static EntryType valueOf(String r100) {
        return (EntryType) a.a(EntryType.class, r100);
    }

    private EntryType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
