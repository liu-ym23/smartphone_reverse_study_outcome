package com.bytedance.android.livesdk.livecommerce.room.smallwindow.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/smallwindow/enums/LabelType;", "", "", "type", "I", "getType", "()I", "LOTTERY", "RED_PACK", "EXPLAIN", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LabelType extends Enum<LabelType> {
    public static final LabelType EXPLAIN = null;
    public static final LabelType LOTTERY = null;
    public static final LabelType RED_PACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LabelType[] f151871a = null;
    private final int type;

    static {
        LabelType r100 = new LabelType("LOTTERY", 0, 1);
        LOTTERY = r100;
        LabelType r101 = new LabelType("RED_PACK", 1, 2);
        RED_PACK = r101;
        LabelType r102 = new LabelType("EXPLAIN", 2, 3);
        EXPLAIN = r102;
        f151871a = new LabelType[]{r100, r101, r102};
    }

    public static LabelType valueOf(String r100) {
        return (LabelType) a.a(LabelType.class, r100);
    }

    public static LabelType[] values() {
        return (LabelType[]) f151871a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public LabelType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
