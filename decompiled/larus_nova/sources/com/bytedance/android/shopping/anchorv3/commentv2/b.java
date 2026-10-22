package com.bytedance.android.shopping.anchorv3.commentv2;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;

/* JADX INFO: loaded from: classes12.dex */
public final class b {
    public b() {
    }

    public static void a() {
        dm.a.a("CommentPreloadHelper").i("preloadTabSliceTmp, context is null? true");
        Context r100 = ECAppInfoService.f48114e.getApplicationContext();
        if (r100 == null) goto L7;
        dm.a.a("CommentPreloadHelper").i("preloadTabSliceTmp, ctx not null");
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.f51232l, "ec_comment", "ecommerce_comment_slice", wh.a.b(r100), CommentPreloadHelper$preloadTabSliceTmp$1.INSTANCE);
        return;
    }

    static {
    }
}
