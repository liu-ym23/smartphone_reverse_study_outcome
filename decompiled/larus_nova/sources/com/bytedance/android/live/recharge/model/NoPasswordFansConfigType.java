package com.bytedance.android.live.recharge.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/model/NoPasswordFansConfigType;", "", "", "value", "I", "getValue", "()I", "TYPE_DEFAULT", "TYPE_PAY_AND_JOIN", "TYPE_AUTO_SEND_PANEL_LIGHT_BOARD", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum NoPasswordFansConfigType extends Enum<NoPasswordFansConfigType> {
    public static final NoPasswordFansConfigType TYPE_AUTO_SEND_PANEL_LIGHT_BOARD = null;
    public static final NoPasswordFansConfigType TYPE_DEFAULT = null;
    public static final NoPasswordFansConfigType TYPE_PAY_AND_JOIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NoPasswordFansConfigType[] f89995a = null;
    private final int value;

    static {
        NoPasswordFansConfigType r100 = new NoPasswordFansConfigType("TYPE_DEFAULT", 0, 0);
        TYPE_DEFAULT = r100;
        NoPasswordFansConfigType r101 = new NoPasswordFansConfigType("TYPE_PAY_AND_JOIN", 1, 1);
        TYPE_PAY_AND_JOIN = r101;
        NoPasswordFansConfigType r102 = new NoPasswordFansConfigType("TYPE_AUTO_SEND_PANEL_LIGHT_BOARD", 2, 2);
        TYPE_AUTO_SEND_PANEL_LIGHT_BOARD = r102;
        f89995a = new NoPasswordFansConfigType[]{r100, r101, r102};
    }

    public static NoPasswordFansConfigType valueOf(String r100) {
        return (NoPasswordFansConfigType) r27.a.a(NoPasswordFansConfigType.class, r100);
    }

    public static NoPasswordFansConfigType[] values() {
        return (NoPasswordFansConfigType[]) f89995a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public NoPasswordFansConfigType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
