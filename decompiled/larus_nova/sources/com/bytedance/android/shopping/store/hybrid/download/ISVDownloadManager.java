package com.bytedance.android.shopping.store.hybrid.download;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.ec.store.utils.d;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.event.ECIsvComponentPredownloadEvent;
import com.bytedance.android.shopping.store.utils.e;
import com.bytedance.android.shopping.store.utils.h;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class ISVDownloadManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f184833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f184834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f184835c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final JSONObject f184836d = null;

    public ISVDownloadManager() {
    }

    static {
        f184833a = "";
        f184834b = "";
        JSONObject r100 = new JSONObject();
        r100.put(DownloadSettingKeys.NET_LIB_STRATEGY, 5);
        f184836d = r100;
        Context r101 = ECAppInfoService.f48114e.getApplicationContext();
        if (r101 == null) goto L9;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101.getFilesDir(), "ecommerce");
        f184834b = r102.toString();
        if (r102.exists() == true) goto L7;
        r102.mkdir();
    L7:
        f184835c = new h(f184834b + "/ec_isv");
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.bytedance.android.btm.api.model.PageFinder, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public static void e(List r110) {
        Intrinsics.checkNotNullParameter(r110, "preLoadInfoList");
        final Context r100 = ECAppInfoService.f48114e.getApplicationContext();
        ?? r111 = 0;
        String r112 = "ISVDownloadManager";
        if (r100 != null) goto L6;
        dm.a.a("ISVDownloadManager").b("preDownload failed as app context is null", null);
        return;
    L6:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), "ecommerce");
        f184834b = r101.toString();
        if (r101.exists() == true) goto L9;
        r101.mkdir();
    L9:
        PolarisFileWrapper r113 = new PolarisFileWrapper(f184834b, "ec_isv");
        Iterator r102 = r110.iterator();
    L11:
        if (r102.hasNext() == false) goto L17;
        c r103 = (c) r102.next();
        final long r114 = System.currentTimeMillis();
        final String r115 = r103.f184843a;
        final String r104 = r103.f184844b;
        final ECIsvComponentPredownloadEvent r105 = new ECIsvComponentPredownloadEvent();
        r105.setCdnUrl(r115);
        r105.setVersion(r104);
        String r106 = UriProtector.parse(r115).buildUpon().clearQuery().build().toString();
        final String r107 = c(r106, r104);
        PolarisFileWrapper r108 = new PolarisFileWrapper(r113, r107 + ".js");
        if (d(r100, r108, r107, r104) == true) goto L15;
        dm.a.a(r112).i("already preDownload, skip url: " + r115);
        r105.setHasCache(1);
        r105.setSuccess(Boolean.TRUE);
        r105.setTimeCost(Long.valueOf(System.currentTimeMillis() - r114));
        r105.post(r111, r111);
    L16:
        r102 = r102;
        r112 = r112;
        r113 = r113;
        r111 = 0;
        goto L11
    L15:
        r105.setHasCache(0);
        final PolarisFileWrapper r109 = r113;
        b(r106, r108, r100, new ISVDownloadManager$preDownload$$inlined$forEach$lambda$1(r107, r104, r115, r114, r105, r109, r100), new ISVDownloadManager$preDownload$1$2(r115, r114, r105));
        goto L16
    }

    public static String c(String r100, String r101) {
        byte[] r102 = (r100 + r101).getBytes();     // Catch: Exception -> L13
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r103.update(r102);     // Catch: Exception -> L10
        byte[] r104 = r103.digest();     // Catch: Exception -> L10
        char[] r105 = new char[32];     // Catch: Exception -> L10
        int r106 = 0;
        int r107 = 0;
    L6:
        if (r106 >= 16) goto L8;
        byte r108 = r104[r106];     // Catch: Exception -> L10
        int r109 = r107 + 1;     // Catch: Exception -> L10
        char[] r110 = d.f48666a;     // Catch: Exception -> L10
        r105[r107] = r110[(r108 >>> 4) & 15];     // Catch: Exception -> L10
        r107 = r109 + 1;     // Catch: Exception -> L10
        r105[r109] = r110[r108 & 15];     // Catch: Exception -> L10
        r106 = r106 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
    L21:
        return new String(r105);
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Exception -> L13
    L15:
        return null;
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L15
    }

    public static final void a(String r100, String r101, Context r102) {
        SharedPrefHelper r103 = SharedPrefHelper.c(r102, "ec_isv_predownload");
        JSONObject r104 = new JSONObject();
        r104.put("version", r101);
        r104.put("time", System.currentTimeMillis());
        r103.l(r100, r104.toString());
        r103.a();
        h r105 = f184835c;
        if (r105 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "element");
        r105.f186930f.remove(r100);
        r105.f186930f.add(r100);
        r105.f186927c = true;
        return;
    }

    public static boolean d(Context r100, PolarisFileWrapper r101, String r102, String r103) {
        if (r101.exists() == true) goto L5;
        return true;
    L5:
        SharedPrefHelper r104 = SharedPrefHelper.c(r100, "ec_isv_predownload");
        String r105 = r104.j(r102, SliceInitService.DEFAULT_SWITCH);
        r104.a();
        if (r105 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
    L29:
        return true;
    L14:
        if (r105.equals(SliceInitService.DEFAULT_SWITCH) == true) goto L29;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L24
        String r108 = new JSONObject(r105).optString("version", "");     // Catch: Throwable -> L24
        if (k.c(r108) == true) goto L20;
        r108 = null;
    L20:
        if (r108 == null) goto L22;
        f184833a = r108;     // Catch: Throwable -> L24
        boolean r109 = Intrinsics.areEqual(r108, r103);     // Catch: Throwable -> L24
    L27:
        if (r109 == false) goto L29;
        return false;
    L22:
        Result.m9449constructorimpl(null);     // Catch: Throwable -> L24
    L26:
        r109 = false;
    L24:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L8:
        if (r105.length() == 0) goto L11;
        r106 = false;
        goto L12
    }

    public static void b(String r100, PolarisFileWrapper r101, Context r102, Function1 r110, Function1 r111) {
        int r103 = e.f186924a;
        Intrinsics.checkNotNullParameter(r101, "$this$deleteIfExists");
        if (r101.exists() == false) goto L5;
        r101.delete();
    L5:
        a r104 = new a(r101, r110, r111, r100, r102);
        Downloader.with(r102).url(r100).name(r101.getName()).savePath(r101.getParent()).addListenerToSameTask(true).deleteCacheIfCheckFailed(true).retryCount(3).autoSetHashCodeForSameTask(true).ttnetProtectTimeout(20000).expiredRedownload(true).expiredHttpCheck(true).downloadSetting(f184836d).force(true).subThreadListener(r104).download();
    }
}
