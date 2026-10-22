package com.obric.appstore.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.obric.appstore.StoreBaseApplication;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f11069a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static DecimalFormatSymbols f11070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ApplicationInfo f11071c;

    static {
        f11069a = new d();
    }

    public d() {
    }

    public static /* synthetic */ void a() {
        g();
    }

    public static /* synthetic */ String d(d r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = "";
    L6:
        return r10.c(r11, r12);
    }

    public static final void g() {
        StoreBaseApplication r10 = pa.a.f23414a.a();     // Catch: Throwable -> L7
        Intent r11 = r10.getPackageManager().getLaunchIntentForPackage(r10.getPackageName());     // Catch: Throwable -> L7
        if (r11 != null) goto L5;
        return;
    L5:
        r11.addFlags(67108864);     // Catch: Throwable -> L7
        r11.addFlags(268435456);     // Catch: Throwable -> L7
        r10.startActivity(r11);     // Catch: Throwable -> L7
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public final ApplicationInfo b() {
        if (f11071c != null) goto L6;
        StoreBaseApplication r10 = pa.a.f23414a.a();     // Catch: Throwable -> L7
        f11071c = r10.getPackageManager().getApplicationInfo(r10.getPackageName(), 128);     // Catch: Throwable -> L7
    L6:
        return f11071c;
    }

    public final String c(String r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "metaKey");
        kotlin.jvm.internal.q.g(r11, "default");
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return r11;
    L5:
        ApplicationInfo r12 = b();
        if (r12 == null) goto L8;
        Bundle r13 = r12.metaData;
    L9:
        if (r13 != null) goto L11;
        return r11;
    L11:
        String r14 = r13.getString(r10);
        if (r14 != null) goto L15;
        return r11;
    L15:
        return r14;
    L8:
        r13 = null;
        goto L9
    }

    public final int e(Context r10, float r11, boolean r12) {
        kotlin.jvm.internal.q.g(r10, "context");
        if (f11070b != null) goto L5;
        f11070b = new DecimalFormatSymbols(Locale.ENGLISH);
    L5:
        String r13 = new DecimalFormat("0.0", f11070b).format(Float.valueOf(bg.h.f(r11, 5.0f)));
        kotlin.jvm.internal.q.f(r13, "format(...)");
        float r14 = Float.parseFloat(r13);
        float r15 = 10;
        int r16 = (int) ((r11 * r15) % r15);
        if (r16 < 0) goto L10;
        if (r16 >= 3) goto L10;
        String r17 = String.valueOf((int) r14);
    L17:
        if (r12 == false) goto L19;
        String r18 = "yellow_star_dark_" + r17;
    L21:
        return r10.getResources().getIdentifier(r18, "drawable", r10.getPackageName());
    L19:
        r18 = "yellow_star_base_" + r17;
    L10:
        if (3 > r16) goto L13;
        if (r16 >= 8) goto L13;
        r17 = ((int) r14) + "_5";
    L13:
        if (8 > r16) goto L16;
        if (r16 >= 10) goto L16;
        r17 = String.valueOf(((int) r14) + 1);
    L16:
        r17 = null;
        goto L17
    }

    public final void f(Activity r10) {
        if (r10 != null) goto L7;
        return;
    L7:
        r10.getWindow().getDecorView().postDelayed(new c(), AnimationConstants.DURATION_2000L);     // Catch: Throwable -> L6
        return;
    }
}
