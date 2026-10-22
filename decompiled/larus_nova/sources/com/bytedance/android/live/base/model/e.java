package com.bytedance.android.live.base.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e {
    public static final FlexImageModel a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toImageModel");
        FlexImageModel r101 = new FlexImageModel();
        r101.setUrls(r100.getUrlList());
        r101.setUri(r100.getUri());
        r101.topBorderHeight = r100.getTopBorderHeight();
        return r101;
    }
}
