package com.android.ttcjpaysdk.thirdparty.verify.params;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum VerifyBizScene extends Enum<VerifyBizScene> {
    private static final /* synthetic */ VerifyBizScene[] $VALUES = null;
    public static final VerifyBizScene BALANCE = null;

    private static /* synthetic */ VerifyBizScene[] $values() {
        return new VerifyBizScene[]{BALANCE};
    }

    static {
        BALANCE = new VerifyBizScene("BALANCE", 0);
        $VALUES = $values();
    }

    public static VerifyBizScene[] values() {
        return (VerifyBizScene[]) $VALUES.clone();
    }

    public static VerifyBizScene valueOf(String r100) {
        return (VerifyBizScene) a.a(VerifyBizScene.class, r100);
    }

    private VerifyBizScene(String r100, int r101) {
        super(r100, r101);
    }
}
