package com.bytedance.android.ec.model.live.ligo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/model/live/ligo/DynamicType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "LYNX", "NATIVE", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum DynamicType extends Enum<DynamicType> {
    public static final DynamicType LYNX = null;
    public static final DynamicType NATIVE = null;
    public static final DynamicType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DynamicType[] f47888a = null;
    private final int value;

    static {
        DynamicType r100 = new DynamicType("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        DynamicType r101 = new DynamicType("LYNX", 1, 1);
        LYNX = r101;
        DynamicType r102 = new DynamicType("NATIVE", 2, 2);
        NATIVE = r102;
        f47888a = new DynamicType[]{r100, r101, r102};
    }

    public static DynamicType valueOf(String r100) {
        return (DynamicType) a.a(DynamicType.class, r100);
    }

    public static DynamicType[] values() {
        return (DynamicType[]) f47888a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public DynamicType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
