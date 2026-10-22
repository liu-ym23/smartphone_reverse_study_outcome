package com.bytedance.android.shopping.anchorv4.components;

import com.bytedance.android.ec.core.utils.y0;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class k0 {
    public static final boolean a(AnchorV4Param r100) {
        String r101 = null;
        if (r100 == null) goto L7;
        V4NativeParams r102 = r100.getNativeParams();
        if (r102 == null) goto L7;
        Boolean r103 = Boolean.valueOf(r102.getDisableLiveWindow());
    L8:
        boolean r104 = !com.bytedance.android.shopping.extensions.k.i(r103);
        boolean r105 = y0.a();
        if (r100 == null) goto L13;
        V4NativeParams r106 = r100.getNativeParams();
        if (r106 == null) goto L13;
        String r107 = r106.getLiveRoomId();
    L14:
        boolean r108 = com.bytedance.android.shopping.extensions.k.c(r107);
        if (r100 == null) goto L19;
        V4NativeParams r109 = r100.getNativeParams();
        if (r109 == null) goto L19;
        r101 = r109.getSourcePage();
    L19:
        boolean r110 = Intrinsics.areEqual(r101, "live");
        if (r104 == false) goto L25;
        if (r105 == false) goto L25;
        if (r108 == true) goto L27;
        if (r110 == false) goto L25;
        return true;
    L27:
        return true;
    L25:
        return false;
    L13:
        r107 = null;
    L7:
        r103 = null;
        goto L8
    }
}
