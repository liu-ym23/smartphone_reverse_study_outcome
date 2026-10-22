package com.bytedance.android.gamecp.common.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.nova.R;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;

/* JADX INFO: loaded from: classes44.dex */
public final class y {

    public interface a {
        void a();

        void onLoadFailed();

        void onLoadSuccess();
    }

    public static boolean a(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof Activity) == false) goto L8;
        Activity r101 = (Activity) r100;
        if (r101.isDestroyed() == false) goto L18;
        return false;
    L18:
        return !r101.isFinishing();
    L8:
        if ((r100 instanceof Application) == false) goto L10;
    L13:
        return true;
    L10:
        if ((r100 instanceof ContextWrapper) == false) goto L13;
        return a(((ContextWrapper) r100).getBaseContext());
    }

    public static void b(HSImageView r100, ImageModel r101, int r102, int r103, a r104) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (a(r100.getContext()) == false) goto L24;
        Context r105 = r100.getContext();
        if (r105 == null) goto L21;
        q r106 = new q(r105);
        if (Lists.isEmpty(r101.getUrls()) == false) goto L11;
        String r107 = "";
    L12:
        r106.f57257f = UriProtector.parse(r107);
        r106.f57255d = true;
        int r108 = y0.b(4);
        if (r106.f57267p != null) goto L15;
        r106.f57267p = new RoundingParams();
    L15:
        r106.f57267p.setCornersRadius(r108);
        r106.f57258g = r101;
        r106.a(ImageView.ScaleType.CENTER_CROP);
        if (r102 <= 0) goto L19;
        if (r103 <= 0) goto L19;
        r106.f57259h = new ResizeOptions(r102, r103);
    L19:
        r106.f57261j = r106.f57252a.getResources().getDrawable(R.drawable.shape_bg_0dffffff_corner_4_stroke);
        r106.f57256e = new fu.j.b(r101, r104);
        r106.c(r100);
        return;
    L11:
        r107 = (String) ListProtector.get(r101.getUrls(), 0);
        goto L12
    L21:
        throw new IllegalArgumentException("appContext == null");
    }

    public static void c(HSImageView r100, String r101, int r102, int r103, int r104) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (a(r100.getContext()) == false) goto L21;
        Context r105 = r100.getContext();
        if (r105 == null) goto L18;
        q r106 = new q(r105);
        if (r101.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == true) goto L13;
        r101 = MSkiaImageRegionDecoder.FILE_PREFIX.concat(r101);
    L13:
        r106.f57257f = UriProtector.parse(r101);
        r106.a(ImageView.ScaleType.CENTER_CROP);
        int r107 = y0.b(r104);
        if (r106.f57267p != null) goto L16;
        r106.f57267p = new RoundingParams();
    L16:
        r106.f57267p.setCornersRadius(r107);
        r106.f57259h = new ResizeOptions(r102, r103);
        r106.f57255d = true;
        r106.f57256e = new fu.j.b(null, null);
        r106.c(r100);
        return;
    L18:
        throw new IllegalArgumentException("appContext == null");
    }
}
