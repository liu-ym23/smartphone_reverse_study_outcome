package com.bytedance.android.ec.core.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livehostapi.business.IHostShare;
import java.util.WeakHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f45607a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<Context, b1> f45608b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHashMap<Context, v83.a> f45609c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f45610d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f45611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i0 f45612f = null;

    public static final class a implements v83.a {
        public a() {
        }
    }

    public i0() {
    }

    static {
        f45612f = new i0();
        f45607a = new j0();
        f45608b = new WeakHashMap();
        f45609c = new WeakHashMap();
        f45610d = new String[]{IHostShare.ShareType.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "screenshots"};
    }

    public static void a(Context r100) {
        boolean r101 = ECServiceManager.f42805a;
        if (((s83.g) ECServiceManager.c(s83.g.class)).B() == false) goto L13;
        if (r100 != null) goto L6;
        return;
    L6:
        a r102 = new a();
        f45609c.put(r100, r102);
        ((s83.g) ECServiceManager.c(s83.g.class)).i0(r102);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        ECExceptionMonitor.f(e, "registerScreenCaptureObserver error");
        return;
    L13:
        if (f45611e == true) goto L31;
        if (r100 == null) goto L32;
        j0 r103 = f45607a;
        r103.f45615a = r100;
        ContentResolver r104 = r100.getApplicationContext().getContentResolver();     // Catch: Exception -> L23
        Uri r105 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Exception -> L23
        if (Build.VERSION.SDK_INT <= 28) goto L20;
        boolean r106 = true;
    L21:
        r104.registerContentObserver(r105, r106, r103);     // Catch: Exception -> L23
        f45611e = true;     // Catch: Exception -> L23
        return;
    L20:
        r106 = false;
    L23:
        e = move-exception;
        ECExceptionMonitor.f(e, "screen_capture_observer_error");
        return;
    L32:
        return;
    }

    public static void b(Context r100) {
        boolean r101 = ECServiceManager.f42805a;
        if (((s83.g) ECServiceManager.c(s83.g.class)).B() == false) goto L13;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        WeakHashMap<Context, v83.a> r103 = f45609c;     // Catch: Throwable -> L9
        v83.a r104 = r103.get(r100);     // Catch: Throwable -> L9
        if (r104 == null) goto L7;
        ((s83.g) ECServiceManager.c(s83.g.class)).o(r104);     // Catch: Throwable -> L9
    L7:
        r103.put(r100, null);     // Catch: Throwable -> L9
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L13:
        if (f45611e == false) goto L25;
        f45611e = false;
        j0 r106 = f45607a;
        r106.f45615a = null;
        if (r100 == null) goto L26;
        Context r107 = r100.getApplicationContext();
        if (r107 == null) goto L27;
        ContentResolver r108 = r107.getContentResolver();
        if (r108 == null) goto L28;
        r108.unregisterContentObserver(r106);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }
}
