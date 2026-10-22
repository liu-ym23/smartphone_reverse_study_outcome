package com.bytedance.android.livesdkapi.floatview;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/floatview/InnerFloatViewTAG;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "TAG_VIDEO_PREVIEW", "TAG_LINKMIC_APPLY_FLOAT", "TAG_LOTTERY_PREVIEW", "TAG_LINKMIC_ONLINE_FLOAT", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InnerFloatViewTAG extends Enum<InnerFloatViewTAG> {
    private static final /* synthetic */ InnerFloatViewTAG[] $VALUES = null;
    public static final InnerFloatViewTAG TAG_LINKMIC_APPLY_FLOAT = null;
    public static final InnerFloatViewTAG TAG_LINKMIC_ONLINE_FLOAT = null;
    public static final InnerFloatViewTAG TAG_LOTTERY_PREVIEW = null;
    public static final InnerFloatViewTAG TAG_VIDEO_PREVIEW = null;
    private final String tag;

    static {
        InnerFloatViewTAG r100 = new InnerFloatViewTAG("TAG_VIDEO_PREVIEW", 0, "video_preview_style");
        TAG_VIDEO_PREVIEW = r100;
        InnerFloatViewTAG r101 = new InnerFloatViewTAG("TAG_LINKMIC_APPLY_FLOAT", 1, "linkmic_apply_float");
        TAG_LINKMIC_APPLY_FLOAT = r101;
        InnerFloatViewTAG r102 = new InnerFloatViewTAG("TAG_LOTTERY_PREVIEW", 2, "lottery_preview_style");
        TAG_LOTTERY_PREVIEW = r102;
        InnerFloatViewTAG r103 = new InnerFloatViewTAG("TAG_LINKMIC_ONLINE_FLOAT", 3, "linkmic_online_float");
        TAG_LINKMIC_ONLINE_FLOAT = r103;
        $VALUES = new InnerFloatViewTAG[]{r100, r101, r102, r103};
    }

    public static InnerFloatViewTAG valueOf(String r100) {
        return (InnerFloatViewTAG) a.a(InnerFloatViewTAG.class, r100);
    }

    public static InnerFloatViewTAG[] values() {
        return (InnerFloatViewTAG[]) $VALUES.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    private InnerFloatViewTAG(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
