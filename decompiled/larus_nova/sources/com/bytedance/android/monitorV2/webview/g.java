package com.bytedance.android.monitorV2.webview;

import android.webkit.WebView;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f163350a = 0;

    static {
    }

    public static void a(String r100, WebView r101, NativeCommon r102) {
        Intrinsics.checkNotNullParameter(r102, "nativeCommon");
        String r103 = r102.url;
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L13;
        sz2.a r106 = sz2.a.f543906a;
        String r107 = sz2.a.i(r100, r101, "url");
        if (r107 == null) goto L13;
        r102.url = r107;
    L13:
        String r108 = r102.nativePage;
        if (r108 != null) goto L16;
    L19:
        boolean r109 = true;
    L20:
        if (r109 == false) goto L24;
        sz2.a r110 = sz2.a.f543906a;
        String r111 = sz2.a.i(r100, r101, "native_page");
        if (r111 == null) goto L24;
        r102.nativePage = r111;
    L24:
        String r112 = r102.containerType;
        if (r112 != null) goto L27;
    L30:
        if (r104 == false) goto L35;
        sz2.a r113 = sz2.a.f543906a;
        String r114 = sz2.a.i(r100, r101, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE);
        if (r114 == null) goto L36;
        r102.containerType = r114;
        return;
    L36:
        return;
    L35:
        return;
    L27:
        if (r112.length() == 0) goto L30;
        r104 = false;
        goto L30
    L16:
        if (r108.length() == 0) goto L19;
        r109 = false;
        goto L20
    L5:
        if (r103.length() == 0) goto L8;
        r105 = false;
        goto L9
    }
}
