package com.bytedance.android.live.impl;

import com.bytedance.android.live.feature.api.IFeatureService;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {
    static {
    }

    public static Object a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chName");
        IFeatureService r101 = (IFeatureService) k.f(IFeatureService.class);
        if (r101 == null) goto L8;
        z90.a r102 = r101.getFeatureManager();
        if (r102 == null) goto L8;
        Object r103 = r102.getFeature(r100, null);
        if (r103 == null) goto L8;
    L10:
        if (r100.hashCode() != (-585881751)) goto L18;
        if (r100.equals("device_score") == false) goto L18;
        if (Intrinsics.areEqual(r103, 0) == false) goto L18;
        return null;
    L18:
        return r103;
    L8:
        r103 = null;
        goto L10
    }

    public static Object b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "chName");
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        IFeatureService r102 = (IFeatureService) k.f(IFeatureService.class);
        if (r102 == null) goto L11;
        z90.a r103 = r102.getFeatureManager();
        if (r103 == null) goto L12;
        Object r104 = r103.b(r100, r101, null);
        if (r104 != null) goto L10;
        return null;
    L10:
        return r104;
    L12:
        return null;
    L11:
        return null;
    }
}
