package com.bytedance.android.ec.core.imagex.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bytedance.android.ec.core.imagex.ImageExperiments;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Drawable f44645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Drawable f44646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Drawable f44647c;

    public d() {
    }

    static {
    }

    public static Drawable b(Context r100, int r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r101 < 98) goto L19;
        Drawable r102 = f44645a;
        if (r102 != null) goto L54;
        Context r103 = r100.getApplicationContext();
        if (r103 == null) goto L50;
        Resources r104 = r103.getResources();
        if (r104 == null) goto L51;
        Drawable r105 = r104.getDrawable(R.drawable.ec_icon_goods_image_placeholder_l);
        if (r105 == null) goto L52;
        f44645a = r105;
    L53:
        return r105;
    L52:
        return null;
    L51:
        return null;
    L50:
        return null;
    L54:
        return r102;
    L19:
        if (r101 < 60) goto L30;
        if (r101 >= 98) goto L30;
        r102 = f44646b;
        if (r102 != null) goto L54;
        Context r106 = r100.getApplicationContext();
        if (r106 == null) goto L55;
        Resources r107 = r106.getResources();
        if (r107 == null) goto L56;
        r105 = r107.getDrawable(R.drawable.ec_icon_goods_image_placeholder_m);
        if (r105 == null) goto L57;
        f44646b = r105;
        goto L53
    L57:
        return null;
    L56:
        return null;
    L55:
        return null;
    L30:
        if (r101 <= 0) goto L41;
        if (r101 >= 60) goto L41;
        r102 = f44647c;
        if (r102 != null) goto L54;
        Context r108 = r100.getApplicationContext();
        if (r108 == null) goto L58;
        Resources r109 = r108.getResources();
        if (r109 == null) goto L59;
        r105 = r109.getDrawable(R.drawable.ec_icon_goods_image_placeholder_s);
        if (r105 == null) goto L60;
        f44647c = r105;
        goto L53
    L60:
        return null;
    L59:
        return null;
    L58:
        return null;
    L41:
        r102 = f44645a;
        if (r102 != null) goto L54;
        Context r110 = r100.getApplicationContext();
        if (r110 == null) goto L61;
        Resources r111 = r110.getResources();
        if (r111 == null) goto L62;
        r105 = r111.getDrawable(R.drawable.ec_icon_goods_image_placeholder_l);
        if (r105 == null) goto L63;
        f44645a = r105;
        goto L53
    L63:
        return null;
    L62:
        return null;
    L61:
        return null;
    }

    public static boolean a(Uri r100, com.bytedance.android.ec.core.imagex.r r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.f44412o.getValue()).booleanValue() == true) goto L12;
    L14:
        return false;
    L12:
        if ((r101 instanceof com.bytedance.android.ec.core.imagex.u) == false) goto L14;
        return ((com.bytedance.android.ec.core.imagex.u) r101).j(r100);
    }
}
