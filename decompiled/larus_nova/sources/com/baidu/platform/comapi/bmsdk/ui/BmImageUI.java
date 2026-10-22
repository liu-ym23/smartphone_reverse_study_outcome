package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;
import com.baidu.platform.comapi.bmsdk.style.a;

/* JADX INFO: loaded from: classes39.dex */
public class BmImageUI extends BmBaseUI {
    private static native long nativeCreate();

    private static native boolean nativeSetBmpResId(long r100, int r101);

    private static native boolean nativeSetColor(long r100, int r101);

    private static native boolean nativeSetDrawableResource(long r100, long r101);

    private static native boolean nativeSetMaskResource(long r100, long r101);

    public BmImageUI() {
        super(34, nativeCreate());
    }

    public boolean b(BmDrawableResource r100) {
        if (r100 == null) goto L6;
        return nativeSetDrawableResource(this.nativeInstance, r100.getNativeInstance());
    L6:
        return nativeSetDrawableResource(this.nativeInstance, 0);
    }

    public boolean c(BmDrawableResource r100) {
        if (r100 == null) goto L6;
        return nativeSetMaskResource(this.nativeInstance, r100.getNativeInstance());
    L6:
        return nativeSetMaskResource(this.nativeInstance, 0);
    }

    public boolean j(int r100) {
        return nativeSetColor(this.nativeInstance, a.a(r100));
    }
}
