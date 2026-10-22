package com.bytedance.android.live.openplatform.api.utils;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getAppId");
        SchemaInfo.f83978s.getClass();
        SchemaInfo r101 = SchemaInfo.b.b(r100);
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.a();
    }

    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getStartPage");
        SchemaInfo.f83978s.getClass();
        SchemaInfo r101 = SchemaInfo.b.b(r100);
        if (r101 == null) goto L6;
        String r102 = r101.e();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public static final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getStartPagePath");
        SchemaInfo.f83978s.getClass();
        SchemaInfo r101 = SchemaInfo.b.b(r100);
        if (r101 == null) goto L6;
        String r102 = r101.f();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public static final boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMicroAppSchema");
        SchemaInfo.f83978s.getClass();
        SchemaInfo r101 = SchemaInfo.b.b(r100);
        if (r101 != null) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual((String) r101.f83985g.getValue(), BdpAppEventConstant.MICRO_APP) == false) goto L9;
        if ((!Intrinsics.areEqual(r101.a(), "null")) == false) goto L9;
        return true;
    }
}
