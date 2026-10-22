package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* loaded from: classes.dex */
public class BmLineStyleOption extends BmObject {
    private BmLineStyleOption() {
        super(52, nativeCreate());
    }

    private static native boolean nativeBuildStyleOption(long j4, int i4, long j5);

    private static native long nativeCreate();

    public BmLineStyleOption(int i4, BmLineStyle bmLineStyle) {
        super(52, nativeCreate());
        nativeBuildStyleOption(this.nativeInstance, i4, bmLineStyle != null ? bmLineStyle.getNativeInstance() : 0L);
    }
}
