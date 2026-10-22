package com.alibaba.gaiax.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002J\f\u0010\u0010\u001a\u00020\u0006*\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/alibaba/gaiax/utils/GXScreenUtils;", "", "()V", "dm", "Landroid/util/DisplayMetrics;", "screenHeight", "", "screenWidth", "getScreenHeightDP", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getScreenHeightPx", "getScreenWidthDP", "getScreenWidthPx", "initScreen", "", "convertPixelsToDp", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXScreenUtils {
    public static final GXScreenUtils INSTANCE = null;

    /* JADX INFO: renamed from: dm, reason: collision with root package name */
    private static final DisplayMetrics f24985dm = null;
    private static float screenHeight;
    private static float screenWidth;

    private GXScreenUtils() {
    }

    static {
        INSTANCE = new GXScreenUtils();
        f24985dm = new DisplayMetrics();
    }

    public static View INVOKEVIRTUAL_com_alibaba_gaiax_utils_GXScreenUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_alibaba_gaiax_utils_GXScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final float convertPixelsToDp(float r100) {
        return r100 / (INVOKEVIRTUAL_com_alibaba_gaiax_utils_GXScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()).densityDpi / 160);
    }

    private final void initScreen(Context r100) {
        if ((r100 instanceof Activity) == false) goto L31;
        Activity r101 = (Activity) r100;
        screenWidth = INVOKEVIRTUAL_com_alibaba_gaiax_utils_GXScreenUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101.getWindow()).getMeasuredWidth();
        float r102 = INVOKEVIRTUAL_com_alibaba_gaiax_utils_GXScreenUtils_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101.getWindow()).getMeasuredHeight();
        screenHeight = r102;
        boolean r103 = true;
        if (screenWidth != 0.0f) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L16;
        if (r102 != 0.0f) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L16;
        return;
    L12:
        r105 = false;
    L16:
        if (Build.VERSION.SDK_INT >= 24) goto L18;
    L30:
        Display r106 = r101.getWindowManager().getDefaultDisplay();
        DisplayMetrics r107 = f24985dm;
        r106.getMetrics(r107);
        screenWidth = r107.widthPixels;
        screenHeight = r107.heightPixels;
        return;
    L18:
        if (r101.isInMultiWindowMode() == false) goto L30;
        screenWidth = Math.round(((double) (r101.getResources().getConfiguration().screenWidthDp * INVOKEVIRTUAL_com_alibaba_gaiax_utils_GXScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101.getResources()).density)) + 0.5d);
        float r108 = Math.round(((double) (r101.getResources().getConfiguration().screenHeightDp * INVOKEVIRTUAL_com_alibaba_gaiax_utils_GXScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r101.getResources()).density)) + 0.5d);
        screenHeight = r108;
        if (screenWidth != 0.0f) goto L22;
        boolean r109 = true;
    L23:
        if (r109 == true) goto L30;
        if (r108 == 0.0f) goto L28;
        r103 = false;
    L28:
        if (r103 == true) goto L30;
        return;
    L22:
        r109 = false;
        goto L23
    L7:
        r104 = false;
        goto L8
    L31:
        Object r110 = r100.getApplicationContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        if ((r110 instanceof WindowManager) == false) goto L34;
        WindowManager r111 = (WindowManager) r110;
    L35:
        if (r111 == null) goto L42;
        Display r112 = r111.getDefaultDisplay();
        if (r112 == null) goto L39;
        r112.getMetrics(f24985dm);
    L39:
        DisplayMetrics r113 = f24985dm;
        screenWidth = r113.widthPixels;
        screenHeight = r113.heightPixels;
        return;
    L42:
        return;
    L34:
        r111 = null;
        goto L35
    }

    public final float getScreenHeightDP(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        initScreen(r100);
        return convertPixelsToDp(screenHeight);
    }

    public final float getScreenHeightPx(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        initScreen(r100);
        return screenHeight;
    }

    public final float getScreenWidthDP(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        initScreen(r100);
        return convertPixelsToDp(screenWidth);
    }

    public final float getScreenWidthPx(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        initScreen(r100);
        return screenWidth;
    }
}
