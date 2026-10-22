package com.bytedance.android.shopping.anchorv4.log;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.shopping.extensions.j;
import com.larus.nova.R;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Rect f167065a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f167066b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f167067c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f167068d = 0;

    static {
        f167065a = new Rect();
        f167066b = dg4.b.b();
        f167067c = j.a(R.dimen.commerce_anchor_v3_bottom_nav_area_height);
        Resources r100 = uf4.a.a().getResources();
        int r101 = r100.getIdentifier("config_showNavigationBar", "bool", "android");
        int r102 = 0;
        if (r101 <= 0) goto L5;
        boolean r103 = r100.getBoolean(r101);
    L32:
        Class r104 = dg4.b.a();     // Catch: Exception -> L23
        Object r105 = r104.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r104, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L23
        if ((r105 instanceof String) == true) goto L9;
        r105 = null;
    L9:
        String r106 = (String) r105;     // Catch: Exception -> L23
        if (r106 == null) goto L25;
        int r107 = r106.hashCode();     // Catch: Exception -> L23
        if (r107 == 48) goto L21;
        if (r107 != 49) goto L25;
        if (r106.equals("1") == false) goto L25;
        r103 = false;
        goto L25
    L21:
        if (r106.equals("0") == false) goto L25;
        r103 = true;
    L25:
        if (r103 == false) goto L30;
        Resources r108 = uf4.a.a().getResources();
        int r109 = r108.getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r109 <= 0) goto L30;
        r102 = r108.getDimensionPixelSize(r109);
    L30:
        f167068d = r102;
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L5:
        r103 = false;
        goto L32
    }

    public static boolean a(View r100) {
        int r101 = f167067c;
        if (r100 == null) goto L27;
        Rect r102 = f167065a;
        boolean r103 = r100.getGlobalVisibleRect(r102);
        int r104 = (f167066b - r101) - f167068d;
        int r105 = r102.top;
        if (1 > r105) goto L10;
        if (r104 <= r105) goto L10;
        boolean r106 = true;
    L11:
        int r107 = r102.bottom;
        if (1 > r107) goto L16;
        if (r104 <= r107) goto L16;
        boolean r108 = true;
    L18:
        if (r100.getParent() == null) goto L24;
        if (r103 == false) goto L25;
        if (r106 == true) goto L22;
        if (r108 == true) goto L22;
        return false;
    L22:
        return true;
    L25:
        return false;
    L24:
        return false;
    L16:
        r108 = false;
    L10:
        r106 = false;
        goto L11
    L27:
        return false;
    }
}
