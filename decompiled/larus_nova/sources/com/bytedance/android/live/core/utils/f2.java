package com.bytedance.android.live.core.utils;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.utils.LiveLoggerUtil;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Arrays;

/* JADX INFO: loaded from: classes45.dex */
public final class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f66134a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f66135b;

    public static void a() {
        Context r100 = s1.getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty("已完成加载,下滑切换直播间。") == true) goto L13;
        TextView r101 = (TextView) ((LayoutInflater) r100.getSystemService("layout_inflater")).inflate(R.layout.ttlive_view_live_toast, null);
        if (r101 != null) goto L10;
        return;
    L10:
        Toast r102 = new Toast(r100);
        r102.setView(r101);
        r102.setDuration(1000);
        r101.setText("已完成加载,下滑切换直播间。");
        r102.show();
        LiveLoggerUtil.f158753b.getClass();
        LiveLoggerUtil.a("已完成加载,下滑切换直播间。");
        return;
    }

    public static void g() {
        jc1.a.b();
        if (v.a() == false) goto L6;
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    }

    public static void f(String r100) {
        Context r101 = s1.getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        Toast.makeText(r101, r100, 0).show();
        LiveLoggerUtil.f158753b.getClass();
        LiveLoggerUtil.a(r100);
    }

    public static void b(int r100, int r101) {
        Context r102 = s1.getContext();
        if (r102 != null) goto L5;
        return;
    L5:
        c(r102.getString(r100), r101);
    }

    public static void c(final String r100, final int r101) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L6;
        UtilityKotlinExtentionsKt.s(0, false, false, new e2(r100, r101), 7);
        return;
    L6:
        Context r102 = s1.getContext();
        if (r102 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return;
    L12:
        if (jc1.k.f(IMiddlewareHostApp.class) == null) goto L14;
        ((IMiddlewareHostApp) jc1.k.f(IMiddlewareHostApp.class)).centerToast(r102, r100, r101);
        return;
    L14:
        Toast r103 = Toast.makeText(r102, r100, r101);
        r103.setGravity(17, 0, 0);
        r103.show();
        LiveLoggerUtil.f158753b.getClass();
        LiveLoggerUtil.a(r100);
    }

    public static void d(String r100, int r101) {
        Context r102 = s1.getContext();
        if (r102 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L19;
        TextView r103 = (TextView) ((LayoutInflater) r102.getSystemService("layout_inflater")).inflate(R.layout.ttlive_view_live_toast, null);
        if (r103 == null) goto L20;
        Toast r104 = new Toast(r102);
        r104.setGravity(17, 0, 0);
        r104.setView(r103);
        r104.setDuration(r101);
        r103.setText(r100);
        r104.show();     // Catch: NullPointerException -> L13
        LiveLoggerUtil.f158753b.getClass();     // Catch: NullPointerException -> L13
        LiveLoggerUtil.a(r100);     // Catch: NullPointerException -> L13
        return;
    L13:
        e = move-exception;
        ALogger.e("ToastUtil", "toastBySdk" + e.getMessage());
        return;
    L20:
        return;
    }

    public static void j(String r100, int r101) {
        Context r102 = s1.getContext();
        if (r102 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L13;
        Toast r103 = Toast.makeText(r102, r100, 0);
        if (r103 == null) goto L12;
        r103.setGravity(r101, 0, 0);
        r103.show();
        LiveLoggerUtil.f158753b.getClass();
        LiveLoggerUtil.a(r100);
        return;
    L12:
        return;
    }

    public static void h(Context r100, int r101, int r102) {
        if (r100 != null) goto L4;
        r100 = s1.getContext();
    L4:
        i(r100, r100.getString(r101), r102);
    }

    public static void i(Context r100, String r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        if (jc1.k.f(IMiddlewareHostApp.class) == null) goto L9;
        ((IMiddlewareHostApp) jc1.k.f(IMiddlewareHostApp.class)).systemToast(r100, r101, r102);
        return;
    L9:
        Toast.makeText(r100, r101, r102).show();
        LiveLoggerUtil.f158753b.getClass();
        LiveLoggerUtil.a(r101);
    }

    public static void e(Context r100, String r101, String r102, String r103) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r103) == true) goto L24;
        String r104 = r102.concat(r103);
        if (r104.equals(f66134a) == true) goto L10;
    L11:
        f66134a = r104;
        f66135b = System.currentTimeMillis();
        if (TextUtils.isEmpty(r101) == false) goto L14;
        View r105 = LayoutInflater.from(r100).inflate(R.layout.ttlive_saas_two_rows_text_toast, null);
    L18:
        if (r105 != null) goto L20;
        return;
    L20:
        TextView r106 = (TextView) r105.findViewById(R.id.toast_text);
        TextView r107 = (TextView) r105.findViewById(R.id.toast_subtext);
        r106.setText(r102);
        r107.setText(r103);
        Toast r108 = new Toast(r100);
        r108.setView(r105);
        r108.setGravity(17, 0, 0);
        r108.setDuration(0);
        r108.show();
        LiveLoggerUtil.f158753b.getClass();
        LiveLoggerUtil.a(r104);
        return;
    L14:
        View r109 = LayoutInflater.from(r100).inflate(R.layout.ttlive_saas_two_rows_text_img_toast, null);
        if (r109 == null) goto L17;
        HSImageView r110 = (HSImageView) r109.findViewById(R.id.toast_img);
        py.k r111 = (py.k) vh7.f.c(py.k.class);
        r111.setUrls(Arrays.asList(new String[]{r101}));
        ImageLoader.bindImage(r110, r111);
    L17:
        r105 = r109;
        goto L18
    L10:
        if ((System.currentTimeMillis() - f66135b) > 2500) goto L11;
        return;
    }
}
