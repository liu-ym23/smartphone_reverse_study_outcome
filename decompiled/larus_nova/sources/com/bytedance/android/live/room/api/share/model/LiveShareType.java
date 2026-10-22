package com.bytedance.android.live.room.api.share.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/api/share/model/LiveShareType;", "", "SHARE_IM", "SHARE_THIRD", "SHARE_DIALOG", "SHARE_LIVE", "SHARE_VIDEO2FANSGROUP", "SHARE_TEXT2FANSGROUP", "SHARE_ACTIVITY", "SHARE_DIRECT", "REPORT_DIALOG", "SHARE_JSB", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveShareType extends Enum<LiveShareType> {
    public static final LiveShareType REPORT_DIALOG = null;
    public static final LiveShareType SHARE_ACTIVITY = null;
    public static final LiveShareType SHARE_DIALOG = null;
    public static final LiveShareType SHARE_DIRECT = null;
    public static final LiveShareType SHARE_IM = null;
    public static final LiveShareType SHARE_JSB = null;
    public static final LiveShareType SHARE_LIVE = null;
    public static final LiveShareType SHARE_TEXT2FANSGROUP = null;
    public static final LiveShareType SHARE_THIRD = null;
    public static final LiveShareType SHARE_VIDEO2FANSGROUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveShareType[] f99153a = null;

    static {
        LiveShareType r100 = new LiveShareType("SHARE_IM", 0);
        SHARE_IM = r100;
        LiveShareType r101 = new LiveShareType("SHARE_THIRD", 1);
        SHARE_THIRD = r101;
        LiveShareType r102 = new LiveShareType("SHARE_DIALOG", 2);
        SHARE_DIALOG = r102;
        LiveShareType r103 = new LiveShareType("SHARE_LIVE", 3);
        SHARE_LIVE = r103;
        LiveShareType r104 = new LiveShareType("SHARE_VIDEO2FANSGROUP", 4);
        SHARE_VIDEO2FANSGROUP = r104;
        LiveShareType r105 = new LiveShareType("SHARE_TEXT2FANSGROUP", 5);
        SHARE_TEXT2FANSGROUP = r105;
        LiveShareType r106 = new LiveShareType("SHARE_ACTIVITY", 6);
        SHARE_ACTIVITY = r106;
        LiveShareType r107 = new LiveShareType("SHARE_DIRECT", 7);
        SHARE_DIRECT = r107;
        LiveShareType r108 = new LiveShareType("REPORT_DIALOG", 8);
        REPORT_DIALOG = r108;
        LiveShareType r109 = new LiveShareType("SHARE_JSB", 9);
        SHARE_JSB = r109;
        f99153a = new LiveShareType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public static LiveShareType valueOf(String r100) {
        return (LiveShareType) a.a(LiveShareType.class, r100);
    }

    public static LiveShareType[] values() {
        return (LiveShareType[]) f99153a.clone();
    }

    public LiveShareType(String r100, int r101) {
        super(r100, r101);
    }
}
