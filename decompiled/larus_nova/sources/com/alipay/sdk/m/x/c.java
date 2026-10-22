package com.alipay.sdk.m.x;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes28.dex */
public abstract class c extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25918c = "v1";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f25919d = "v2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f25920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f25921b;

    public abstract void a(String r100);

    public abstract boolean b();

    public abstract void c();

    public boolean a() {
        return "v1".equals(this.f25921b);
    }

    public static void a(WebView r100) {
        if (r100 == null) goto L8;
        r100.resumeTimers();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public c(Activity r100, String r101) {
        super(r100);
        this.f25920a = r100;
        this.f25921b = r101;
    }

    public void a(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L6;
        CookieSyncManager.createInstance(this.f25920a.getApplicationContext()).sync();
        CookieManager.getInstance().setCookie(r100, r101);
        CookieSyncManager.getInstance().sync();
        return;
    }
}
