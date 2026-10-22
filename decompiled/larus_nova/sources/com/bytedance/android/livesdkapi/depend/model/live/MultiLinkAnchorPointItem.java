package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/MultiLinkAnchorPointItem;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "LINKMIC_THEME", "LINKMIC_GAME", "LIVE_THEME", "LIVE_GAME", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkAnchorPointItem extends Enum<MultiLinkAnchorPointItem> {
    private static final /* synthetic */ MultiLinkAnchorPointItem[] $VALUES = null;
    public static final MultiLinkAnchorPointItem LINKMIC_GAME = null;
    public static final MultiLinkAnchorPointItem LINKMIC_THEME = null;
    public static final MultiLinkAnchorPointItem LIVE_GAME = null;
    public static final MultiLinkAnchorPointItem LIVE_THEME = null;
    public static final MultiLinkAnchorPointItem UNKNOWN = null;

    static {
        MultiLinkAnchorPointItem r100 = new MultiLinkAnchorPointItem("UNKNOWN", 0);
        UNKNOWN = r100;
        MultiLinkAnchorPointItem r101 = new MultiLinkAnchorPointItem("LINKMIC_THEME", 1);
        LINKMIC_THEME = r101;
        MultiLinkAnchorPointItem r102 = new MultiLinkAnchorPointItem("LINKMIC_GAME", 2);
        LINKMIC_GAME = r102;
        MultiLinkAnchorPointItem r103 = new MultiLinkAnchorPointItem("LIVE_THEME", 3);
        LIVE_THEME = r103;
        MultiLinkAnchorPointItem r104 = new MultiLinkAnchorPointItem("LIVE_GAME", 4);
        LIVE_GAME = r104;
        $VALUES = new MultiLinkAnchorPointItem[]{r100, r101, r102, r103, r104};
    }

    public static MultiLinkAnchorPointItem valueOf(String r100) {
        return (MultiLinkAnchorPointItem) a.a(MultiLinkAnchorPointItem.class, r100);
    }

    public static MultiLinkAnchorPointItem[] values() {
        return (MultiLinkAnchorPointItem[]) $VALUES.clone();
    }

    private MultiLinkAnchorPointItem(String r100, int r101) {
        super(r100, r101);
    }
}
