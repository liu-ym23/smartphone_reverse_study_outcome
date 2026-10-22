package com.bytedance.android.live.revlink.link.domain.streammix;

import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final boolean a(IRegion r100, IRegion r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r100.getInteractId(), r101.getInteractId()) == true) goto L10;
        return false;
    L10:
        if (r100.getStatus() == r101.getStatus()) goto L12;
        return false;
    L12:
        if (r100.C1() != r101.C1()) goto L27;
        z41.g r102 = z41.g.f569928o;
        r102.getClass();
        if (((Boolean) z41.g.f569917d.getValue(r102, z41.g.f569914a[2])).booleanValue() == true) goto L16;
    L23:
        return true;
    L16:
        if (r100.getX() == r101.getX()) goto L18;
        return false;
    L18:
        if (r100.getY() == r101.getY()) goto L20;
        return false;
    L20:
        if (r100.getWidth() == r101.getWidth()) goto L22;
        return false;
    L22:
        if (r100.getHeight() == r101.getHeight()) goto L23;
        return false;
    L27:
        return false;
    }

    public static final boolean b(m11.b r100, m11.b r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r100.c(), r101.c()) == true) goto L10;
        return false;
    L10:
        if (r100.d() == r101.d()) goto L12;
        return false;
    L12:
        if (r100.e() == r101.e()) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(r100.b(), r101.b()) == false) goto L20;
        return true;
    L20:
        return false;
    }
}
