package com.bytedance.android.shopping.store.hybrid.download;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.home.event.ECIsvComponentLoadEvent;
import com.bytedance.android.shopping.store.utils.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements k7a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f184842a = null;

    public b() {
    }

    static {
        f184842a = new b();
    }

    @Override // k7a.a
    public final void loadDynamicComponent(final String r110, final k7a.a.InterfaceC6515a r111) {
        String r100 = ISVDownloadManager.f184833a;
        final long r112 = System.currentTimeMillis();
        if (r110 == null) goto L25;
        if (r111 == null) goto L25;
        final Context r113 = ECAppInfoService.f48114e.getApplicationContext();
        if (r113 != null) goto L9;
        dm.a.a("ISVDownloadManager").b("loadDynamicComponent failed as app context is null", null);
        return;
    L9:
        Uri r101 = UriProtector.parse(r110);
        String r102 = UriProtector.getQueryParameter(r101, "version");
        if (r102 != null) goto L12;
        r102 = "1";
    L12:
        final ECIsvComponentLoadEvent r114 = new ECIsvComponentLoadEvent();
        String r103 = r101.buildUpon().clearQuery().build().toString();
        final String r104 = ISVDownloadManager.c(r103, r102);
        PolarisFileWrapper r105 = new PolarisFileWrapper(r113.getFilesDir(), "ecommerce");
        ISVDownloadManager.f184834b = r105.toString();
        if (r105.exists() == true) goto L15;
        r105.mkdir();
    L15:
        PolarisFileWrapper r106 = new PolarisFileWrapper(ISVDownloadManager.f184834b, "ec_isv");
        String r107 = UriProtector.getQueryParameter(r101, "log_isv_extra");
        if (r107 != null) goto L18;
        r107 = "";
    L18:
        r114.setLogIsvExtra(r107);
        final PolarisFileWrapper r108 = new PolarisFileWrapper(r106, r104 + ".js");
        r114.setCdnUrl(r103);
        if (ISVDownloadManager.d(r113, r108, r104, r102) == true) goto L24;
        r111.a(FilesKt.readBytes(r108), null);
        h r109 = ISVDownloadManager.f184835c;
        if (r109 == null) goto L23;
        Intrinsics.checkNotNullParameter(r104, "element");
        r109.f186930f.remove(r104);
        r109.f186930f.add(r104);
        r109.f186927c = true;
    L23:
        dm.a.a("ISVDownloadManager").i("loadDynamicComponent hit local file, url: " + r110 + ", timeCost: " + (System.currentTimeMillis() - r112));
        r114.setExpired(Boolean.FALSE);
        r114.setHitVersion(ISVDownloadManager.f184833a);
        r114.setTimeCost(Long.valueOf(System.currentTimeMillis() - r112));
        r114.post(null, null);
        return;
    L24:
        r114.setExpired(Boolean.TRUE);
        r114.setHitVersion(ISVDownloadManager.f184833a);
        final String r115 = r102;
        ISVDownloadManager.b(r103, r108, r113, new ISVDownloadManager$loadDynamicComponent$1(r104, r115, r113, r111, r108, r110, r112, r114), new ISVDownloadManager$loadDynamicComponent$2(r111, r110, r112, r114));
        return;
    L25:
        dm.a.a("ISVDownloadManager").b("loadDynamicComponent failed, url: " + r110 + ", handler: " + r111, null);
    }
}
