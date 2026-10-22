package com.bytedance.android.shopping.feed.pitaya.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/feed/pitaya/data/TriggerModeType;", "", "", "type", "I", "getType", "()I", "OTHER_USER", "NEW_USER", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TriggerModeType extends Enum<TriggerModeType> {
    public static final TriggerModeType NEW_USER = null;
    public static final TriggerModeType OTHER_USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TriggerModeType[] f175128a = null;
    private final int type;

    static {
        TriggerModeType r100 = new TriggerModeType("OTHER_USER", 0, 0);
        OTHER_USER = r100;
        TriggerModeType r101 = new TriggerModeType("NEW_USER", 1, 1);
        NEW_USER = r101;
        f175128a = new TriggerModeType[]{r100, r101};
    }

    public static TriggerModeType valueOf(String r100) {
        return (TriggerModeType) a.a(TriggerModeType.class, r100);
    }

    public static TriggerModeType[] values() {
        return (TriggerModeType[]) f175128a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public TriggerModeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
