package com.bytedance.android.live;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.view.LiveFrameLayout;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveDrawOverlayConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class ILiveCheckDraw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f58518a = null;

    static {
        f58518a = LazyKt.lazy(ILiveCheckDraw$drawCheckConfig$2.INSTANCE);
    }

    public static boolean a(View r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L48
        if (r100 != null) goto L6;
        return true;
    L6:
        Lazy r102 = f58518a;     // Catch: Throwable -> L48
        if (((LiveDrawOverlayConfig) r102.getValue()).getEnable() == true) goto L10;
        return true;
    L10:
        if (((LiveDrawOverlayConfig) r102.getValue()).getEnableEmptyCheck() == false) goto L33;
        if (Build.VERSION.SDK_INT >= 23) goto L15;
    L29:
        boolean r103 = false;
    L30:
        if (r103 == false) goto L33;
        return false;
    L15:
        if ((r100 instanceof ViewGroup) == false) goto L29;
        ViewGroup r104 = (ViewGroup) r100;     // Catch: Throwable -> L48
        if (r104.getChildCount() != 0) goto L29;
        if (r104.getBackground() != null) goto L29;
        if (r104.getForeground() != null) goto L29;
        if (r104.isFocused() == true) goto L29;
        Class<?> r105 = r104.getClass();     // Catch: Throwable -> L48
        if (r105 != FrameLayout.class) goto L27;
    L28:
        r103 = true;
        goto L30
    L27:
        if (r105 != LiveFrameLayout.class) goto L29;
    L33:
        if (((LiveDrawOverlayConfig) r102.getValue()).getEnableSizeCheck() == true) goto L35;
    L46:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L48
    L50:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L53;
        ALogger.e("ILiveCheckDraw", "enableDrawView error:".concat(String.valueOf(r107.getMessage())));
    L53:
        return true;
    L35:
        if (r100.getAnimation() == null) goto L38;
    L42:
        boolean r108 = false;
    L44:
        if (r108 == false) goto L46;
        return false;
    L38:
        if (r100.getWidth() != 0) goto L40;
    L43:
        r108 = true;
        goto L44
    L40:
        if (r100.getHeight() != 0) goto L42;
    L48:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L50
    }
}
