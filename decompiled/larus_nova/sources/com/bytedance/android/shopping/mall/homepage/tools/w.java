package com.bytedance.android.shopping.mall.homepage.tools;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class w {
    public static String a(CommonEnterFromParams r100) {
        CommonEnterFromOptions r101 = new CommonEnterFromOptions(false, 1, null);
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "options");
        if (r100.getOrder() == null) goto L5;
        String r102 = "order" + r100.getOrder() + '.';
    L6:
        String r103 = r100.getPageName() + '.' + (r100.getModuleKey() + r100.getModuleId()) + '.' + r102 + (r100.getComponentKey() + r100.getComponentId()) + '.' + (r100.getResourceKey() + r100.getResourceId());
        if (r101.getAddPreviousPage() == true) goto L9;
        return r103;
    L9:
        return r100.getPreviousPage() + '.' + r103;
    L5:
        r102 = "";
        goto L6
    }
}
