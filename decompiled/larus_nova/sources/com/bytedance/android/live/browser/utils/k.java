package com.bytedance.android.live.browser.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f64311a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<Context, i> f64312b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f64313c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f64314d;

    static {
        f64311a = new l();
        f64312b = new WeakHashMap();
        f64313c = new String[]{IHostShare.ShareType.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "snap", "截屏"};
    }

    public static void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f64314d == false) goto L5;
        return;
    L5:
        int r101 = Build.VERSION.SDK_INT;
        boolean r102 = false;
        if (r101 < 33) goto L13;
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L13;
        if (ContextCompat.checkSelfPermission(r100, BaseConstants.PERMISSION_READ_MEDIA_IMAGES) != 0) goto L13;
    L14:
        boolean r103 = true;
    L16:
        if (r103 == true) goto L18;
        return;
    L18:
        l r104 = f64311a;
        r104.getClass();
        r104.f64315a = new WeakReference(r100);
        ContentResolver r105 = r100.getApplicationContext().getContentResolver();     // Catch: Exception -> L24
        Uri r106 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L24
        if (r101 <= 28) goto L22;
        r102 = true;
    L22:
        r105.registerContentObserver(r106, r102, r104);     // Catch: Exception -> L24
        f64314d = true;     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        ALogger.e("ScreenShotHelper", "registerScreenCaptureObserver Error" + e.getMessage());
        return;
    L13:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.READ_EXTERNAL_STORAGE") == 0) goto L14;
        r103 = false;
        goto L16
    }

    public static void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f64314d == false) goto L12;
        f64314d = false;
        l r101 = f64311a;
        r101.getClass();
        r100.getApplicationContext().getContentResolver().unregisterContentObserver(r101);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        ALogger.e("ScreenShotHelper", "unRegisterScreenCaptureObserver Error" + e.getMessage());
        return;
    }
}
