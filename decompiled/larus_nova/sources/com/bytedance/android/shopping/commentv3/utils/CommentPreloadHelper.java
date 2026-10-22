package com.bytedance.android.shopping.commentv3.utils;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
public final class CommentPreloadHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f172916a = null;

    static {
        f172916a = new AtomicBoolean(false);
    }

    public static void a() {
        if (f172916a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        SliceRender r100 = SliceRender.f50121o;
        CommentPreloadHelper$injectCustomWidget$1 r101 = CommentPreloadHelper$injectCustomWidget$1.INSTANCE;
        r100.getClass();
        ElementTypes.b("ECCommentVideo", r101);
    }

    public static void b(Context r100) {
        if (r100 != null) goto L4;
        r100 = ECAppInfoService.f48114e.getApplicationContext();
    L4:
        if (r100 != null) goto L7;
        dm.a.a("CommentPreloadHelper_v3").i("preloadSliceTemplate, ctx is null");
        return;
    L7:
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.f51232l, "ec_comment", "ecommerce_comment_slice", wh.a.b(r100), CommentPreloadHelper$preloadSliceTemplate$1.INSTANCE);
    }
}
