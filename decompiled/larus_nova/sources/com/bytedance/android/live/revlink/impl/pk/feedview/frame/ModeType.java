package com.bytedance.android.live.revlink.impl.pk.feedview.frame;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/feedview/frame/ModeType;", "", "PK", "Vote", "BreakThough", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ModeType extends Enum<ModeType> {
    public static final ModeType BreakThough = null;
    public static final ModeType PK = null;
    public static final ModeType Vote = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModeType[] f96480a = null;

    static {
        ModeType r100 = new ModeType("PK", 0);
        PK = r100;
        ModeType r101 = new ModeType("Vote", 1);
        Vote = r101;
        ModeType r102 = new ModeType("BreakThough", 2);
        BreakThough = r102;
        f96480a = new ModeType[]{r100, r101, r102};
    }

    public static ModeType valueOf(String r100) {
        return (ModeType) a.a(ModeType.class, r100);
    }

    public static ModeType[] values() {
        return (ModeType[]) f96480a.clone();
    }

    public ModeType(String r100, int r101) {
        super(r100, r101);
    }
}
