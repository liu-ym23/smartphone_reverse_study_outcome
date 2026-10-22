package com.bytedance.ai.applet.components.page;

import android.net.Uri;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.devtoolwrapper.ScreenshotMode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static final RenderUrlData a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Uri r101 = UriProtector.parse(r100);
        String r102 = r101.getHost();
        if (r102 == null) goto L17;
        int r103 = r102.hashCode();
        if (r103 == (-1772600516)) goto L14;
        if (r103 != 1224424441) goto L17;
        if (r102.equals("webview") == false) goto L17;
        RenderType r104 = RenderType.WEB;
    L18:
        RenderType r105 = r104;
        String r106 = UriProtector.getQueryParameter(r101, "url");
        if (r106 != null) goto L21;
        r106 = "";
    L21:
        String r107 = r106;
        if (r107.length() != 0) goto L24;
        boolean r108 = true;
    L25:
        if (r108 == true) goto L41;
        boolean r109 = Intrinsics.areEqual(UriProtector.getQueryParameter(r101, AppConstants.TRANS_STATUS_BAR), "1");
        boolean r110 = Intrinsics.areEqual(UriProtector.getQueryParameter(r101, "hide_nav_bar"), "1");
        Uri r111 = UriProtector.parse(r107);
        LinkedHashMap r112 = new LinkedHashMap();
        Iterator<String> r113 = UriProtector.getQueryParameterNames(r101).iterator();
    L28:
        if (r113.hasNext() == false) goto L32;
        String r114 = r113.next();
        String r115 = UriProtector.getQueryParameter(r101, r114);
        if (r115 == null) goto L28;
        r112.put(r114, r115);
        goto L28
    L32:
        Iterator<String> r116 = UriProtector.getQueryParameterNames(r111).iterator();
    L34:
        if (r116.hasNext() == false) goto L39;
        String r117 = r116.next();
        String r118 = UriProtector.getQueryParameter(r111, r117);
        if (r118 == null) goto L34;
        r112.put(r117, r118);
        goto L34
    L39:
        return new RenderUrlData(r105, r109, r110, r107, r112);
    L41:
        throw new IllegalArgumentException("url is empty");
    L24:
        r108 = false;
        goto L25
    L14:
        if (r102.equals(ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == false) goto L17;
        r104 = RenderType.LYNX;
    L17:
        r104 = RenderType.WEB;
        goto L18
    }
}
