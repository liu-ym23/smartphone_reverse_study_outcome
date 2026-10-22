package com.bytedance.android.livesdk.gift.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/ComboHintType;", "", "", "type", "I", "getType", "()I", "FIRST_TIME", "COMMON", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ComboHintType extends Enum<ComboHintType> {
    public static final ComboHintType COMMON = null;
    public static final ComboHintType FIRST_TIME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComboHintType[] f126364a = null;
    private final int type;

    static {
        ComboHintType r100 = new ComboHintType("FIRST_TIME", 0, 1);
        FIRST_TIME = r100;
        ComboHintType r101 = new ComboHintType("COMMON", 1, 2);
        COMMON = r101;
        f126364a = new ComboHintType[]{r100, r101};
    }

    public static ComboHintType valueOf(String r100) {
        return (ComboHintType) r27.a.a(ComboHintType.class, r100);
    }

    public static ComboHintType[] values() {
        return (ComboHintType[]) f126364a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ComboHintType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
