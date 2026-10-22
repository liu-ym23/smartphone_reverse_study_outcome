package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;
import com.baidu.platform.comapi.bmsdk.style.a;

/* loaded from: classes.dex */
public class BmImageUI extends BmBaseUI {
    public BmImageUI() {
        super(34, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBmpResId(long j4, int i4);

    private static native boolean nativeSetColor(long j4, int i4);

    private static native boolean nativeSetDrawableResource(long j4, long j5);

    private static native boolean nativeSetMaskResource(long j4, long j5);

    public boolean b(BmDrawableResource bmDrawableResource) {
        return bmDrawableResource != null ? nativeSetDrawableResource(this.nativeInstance, bmDrawableResource.getNativeInstance()) : nativeSetDrawableResource(this.nativeInstance, 0L);
    }

    public boolean c(BmDrawableResource bmDrawableResource) {
        return bmDrawableResource != null ? nativeSetMaskResource(this.nativeInstance, bmDrawableResource.getNativeInstance()) : nativeSetMaskResource(this.nativeInstance, 0L);
    }

    public boolean j(int i4) {
        return nativeSetColor(this.nativeInstance, a.a(i4));
    }
}
