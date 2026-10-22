package com.bytedance.android.window.shop.repository.tab.entity;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g0 extends f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WindowLayoutType f189564j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.window.shop.c f189565k;

    public g0(WindowLayoutType r100, com.bytedance.android.window.shop.c r101) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        Intrinsics.checkNotNullParameter(r101, "shopWindowItemType");
        super(AVMDLDataLoader.KeyIsEnablePreconnect);
        this.f189564j = r100;
        this.f189565k = r101;
    }
}
