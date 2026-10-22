package com.bytedance.android.shopping.anchorv3.comment.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/model/RankTypeEnum;", "", "", "value", "I", "getValue", "()I", "GOOD", "MIDDLE", "BAD", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RankTypeEnum extends Enum<RankTypeEnum> {
    public static final RankTypeEnum BAD = null;
    public static final RankTypeEnum GOOD = null;
    public static final RankTypeEnum MIDDLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RankTypeEnum[] f164530a = null;
    private final int value;

    static {
        RankTypeEnum r100 = new RankTypeEnum("GOOD", 0, 1);
        GOOD = r100;
        RankTypeEnum r101 = new RankTypeEnum("MIDDLE", 1, 2);
        MIDDLE = r101;
        RankTypeEnum r102 = new RankTypeEnum("BAD", 2, 3);
        BAD = r102;
        f164530a = new RankTypeEnum[]{r100, r101, r102};
    }

    public static RankTypeEnum valueOf(String r100) {
        return (RankTypeEnum) a.a(RankTypeEnum.class, r100);
    }

    public static RankTypeEnum[] values() {
        return (RankTypeEnum[]) f164530a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RankTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
