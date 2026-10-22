package com.bytedance.android.live.ktv.common.karaokestation.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/model/UpdateTabType;", "", "", "value", "I", "getValue", "()I", "DEFAULT", "DIRECT_CLICK", "INDIRECT_CLICK", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UpdateTabType extends Enum<UpdateTabType> {
    public static final UpdateTabType DEFAULT = null;
    public static final UpdateTabType DIRECT_CLICK = null;
    public static final UpdateTabType INDIRECT_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpdateTabType[] f69494a = null;
    private final int value;

    static {
        UpdateTabType r100 = new UpdateTabType("DEFAULT", 0, 0);
        DEFAULT = r100;
        UpdateTabType r101 = new UpdateTabType("DIRECT_CLICK", 1, 1);
        DIRECT_CLICK = r101;
        UpdateTabType r102 = new UpdateTabType("INDIRECT_CLICK", 2, 2);
        INDIRECT_CLICK = r102;
        f69494a = new UpdateTabType[]{r100, r101, r102};
    }

    public static UpdateTabType valueOf(String r100) {
        return (UpdateTabType) r27.a.a(UpdateTabType.class, r100);
    }

    public static UpdateTabType[] values() {
        return (UpdateTabType[]) f69494a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public UpdateTabType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
