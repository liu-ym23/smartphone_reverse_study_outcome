package com.android.ttcjpaysdk.base.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/CJPayScreenUtils;", "", "()V", "screenHeight", "", "screenWidth", "getScreenWidth", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "initScreenSize", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayScreenUtils {
    public static final CJPayScreenUtils INSTANCE = null;
    private static int screenHeight;
    private static int screenWidth;

    private CJPayScreenUtils() {
    }

    static {
        INSTANCE = new CJPayScreenUtils();
        screenHeight = -1;
        screenWidth = -1;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private final void initScreenSize(Context r100) {
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L13
        if ((r101 instanceof WindowManager) == false) goto L5;
        WindowManager r102 = (WindowManager) r101;     // Catch: Exception -> L13
    L6:
        if (r102 == null) goto L11;
        Display r103 = r102.getDefaultDisplay();     // Catch: Exception -> L13
        Point r104 = new Point();     // Catch: Exception -> L13
        if (r103 != null) goto L10;
        return;
    L10:
        r103.getRealSize(r104);     // Catch: Exception -> L13
        screenHeight = r104.y;     // Catch: Exception -> L13
        screenWidth = r104.x;     // Catch: Exception -> L13
        return;
    L11:
        DisplayMetrics r105 = INVOKEVIRTUAL_com_android_ttcjpaysdk_base_utils_CJPayScreenUtils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());     // Catch: Exception -> L13
        screenHeight = r105.heightPixels;     // Catch: Exception -> L13
        screenWidth = r105.widthPixels;     // Catch: Exception -> L13
        return;
    L5:
        r102 = null;
    L13:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayScreenUtils#initScreenSize", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayScreenUtils#initScreenSize", e);
    }

    public final int getScreenWidth(Context r100) {
        int r101 = screenWidth;
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        if (r100 != null) goto L8;
        return 0;
    L8:
        initScreenSize(r100);
        int r102 = screenWidth;
        if (r102 > 0) goto L11;
        return 0;
    L11:
        return r102;
    }
}
