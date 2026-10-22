package com.obric.matrix.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes4.dex */
public final enum NETWORK_METHOD extends Enum<NETWORK_METHOD> implements WireEnum {
    private static final /* synthetic */ NETWORK_METHOD[] $VALUES = null;
    public static final ProtoAdapter<NETWORK_METHOD> ADAPTER = null;
    public static final NETWORK_METHOD METHOD_GET = null;
    public static final NETWORK_METHOD METHOD_POST = null;
    private final int value;

    static {
        NETWORK_METHOD r10 = new NETWORK_METHOD("METHOD_GET", 0, 0);
        METHOD_GET = r10;
        NETWORK_METHOD r11 = new NETWORK_METHOD("METHOD_POST", 1, 1);
        METHOD_POST = r11;
        $VALUES = new NETWORK_METHOD[]{r10, r11};
        ADAPTER = new a();
    }

    private NETWORK_METHOD(String r10, int r11, int r12) {
        super(r10, r11);
        this.value = r12;
    }

    public static NETWORK_METHOD fromValue(int r10) {
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L8;
        return null;
    L8:
        return METHOD_POST;
    L10:
        return METHOD_GET;
    }

    public static NETWORK_METHOD valueOf(String r10) {
        return (NETWORK_METHOD) Enum.valueOf(NETWORK_METHOD.class, r10);
    }

    public static NETWORK_METHOD[] values() {
        return (NETWORK_METHOD[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
