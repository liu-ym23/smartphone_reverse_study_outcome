package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;

/* JADX INFO: loaded from: classes45.dex */
public final enum PieceType extends Enum<PieceType> {
    public static final PieceType GIFT = null;
    public static final PieceType HEART = null;
    public static final PieceType IMAGE = null;
    public static final PieceType PATTERN_REF = null;
    public static final PieceType STRING = null;
    public static final PieceType UNKNOWN = null;
    public static final PieceType USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PieceType[] f58854a = null;
    private int pieceType;
    private String tag;

    static {
        PieceType r100 = new PieceType("UNKNOWN", 0, 0, "");
        UNKNOWN = r100;
        PieceType r101 = new PieceType("STRING", 1, 1, "string");
        STRING = r101;
        PieceType r102 = new PieceType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 2, 11, "user");
        USER = r102;
        PieceType r103 = new PieceType("GIFT", 3, 12, PbRequest.SwitchType.GIFT);
        GIFT = r103;
        PieceType r104 = new PieceType("HEART", 4, 13, "heart");
        HEART = r104;
        PieceType r105 = new PieceType("PATTERN_REF", 5, 14, "pref");
        PATTERN_REF = r105;
        PieceType r106 = new PieceType("IMAGE", 6, 15, "image");
        IMAGE = r106;
        f58854a = new PieceType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static PieceType[] values() {
        return (PieceType[]) f58854a.clone();
    }

    public int getPieceType() {
        return this.pieceType;
    }

    public String getTag() {
        return this.tag;
    }

    public static PieceType valueOf(String r100) {
        return (PieceType) r27.a.a(PieceType.class, r100);
    }

    public PieceType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.pieceType = r102;
        this.tag = r103;
    }
}
