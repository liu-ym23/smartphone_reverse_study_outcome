package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/RTChorusOperateType;", "", "", "value", "I", "getValue", "()I", "ORDER_SONG", "JOIN_CHORUS", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RTChorusOperateType extends Enum<RTChorusOperateType> {
    public static final RTChorusOperateType JOIN_CHORUS = null;
    public static final RTChorusOperateType ORDER_SONG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RTChorusOperateType[] f153610a = null;
    private final int value;

    static {
        RTChorusOperateType r100 = new RTChorusOperateType("ORDER_SONG", 0, 1);
        ORDER_SONG = r100;
        RTChorusOperateType r101 = new RTChorusOperateType("JOIN_CHORUS", 1, 2);
        JOIN_CHORUS = r101;
        f153610a = new RTChorusOperateType[]{r100, r101};
    }

    public static RTChorusOperateType valueOf(String r100) {
        return (RTChorusOperateType) r27.a.a(RTChorusOperateType.class, r100);
    }

    public static RTChorusOperateType[] values() {
        return (RTChorusOperateType[]) f153610a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RTChorusOperateType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
