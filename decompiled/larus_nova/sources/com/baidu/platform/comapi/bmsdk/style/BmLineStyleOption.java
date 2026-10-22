package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* JADX INFO: loaded from: classes39.dex */
public class BmLineStyleOption extends BmObject {
    private static native boolean nativeBuildStyleOption(long r100, int r101, long r102);

    private static native long nativeCreate();

    private BmLineStyleOption() {
        super(52, nativeCreate());
    }

    public BmLineStyleOption(int r100, BmLineStyle r101) {
        super(52, nativeCreate());
        long r102 = this.nativeInstance;
        if (r101 == null) goto L5;
        long r103 = r101.getNativeInstance();
    L6:
        nativeBuildStyleOption(r102, r100, r103);
        return;
    L5:
        r103 = 0;
        goto L6
    }
}
