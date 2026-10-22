package com.baidu.naviapi.open;

import android.content.Context;
import com.baidu.naviapi.platform.e;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum BNAInit extends Enum<BNAInit> {
    private static final /* synthetic */ BNAInit[] $VALUES = null;
    public static final BNAInit INSTANCE = null;

    static {
        BNAInit r100 = new BNAInit("INSTANCE", 0);
        INSTANCE = r100;
        $VALUES = new BNAInit[]{r100};
    }

    public static BNAInit[] values() {
        return (BNAInit[]) $VALUES.clone();
    }

    public static BNAInit valueOf(String r100) {
        return (BNAInit) a.a(BNAInit.class, r100);
    }

    public void active(IAuthResult r100) {
        e.b().a(r100);
    }

    public void setAgreePrivacy(boolean r100) {
        e.b().a(r100);
    }

    private BNAInit(String r100, int r101) {
        super(r100, r101);
    }

    public void init(Context r100, boolean r101) {
        e.b().a(r100, r101);
    }
}
