package com.bytedance.android.marketing.sdk.impl.utils;

import android.net.Uri;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.devtoolwrapper.ScreenshotMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class g {
    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == true) goto L17;
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L13
        String r102 = UriProtector.getQueryParameter(r101, "url");     // Catch: Exception -> L13
        if (r102 != null) goto L8;
        r102 = UriProtector.getQueryParameter(r101, "surl");     // Catch: Exception -> L13
    L8:
        if (r102 == null) goto L11;
        return r102;
    L11:
        return "";
    L17:
        return r100;
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        String r102 = UriProtector.parse(r100).getHost();
        if (Intrinsics.areEqual(r102, ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == false) goto L14;
        return true;
    L14:
        if (Intrinsics.areEqual(r102, "lynxview_popup") == false) goto L16;
        return true;
    L16:
        if (Intrinsics.areEqual(r102, "webview") == false) goto L18;
        return true;
    L18:
        if (Intrinsics.areEqual(r102, AppConstants.HOST_WEBVIEW_DIALOG) == true) goto L25;
        return false;
    L25:
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
