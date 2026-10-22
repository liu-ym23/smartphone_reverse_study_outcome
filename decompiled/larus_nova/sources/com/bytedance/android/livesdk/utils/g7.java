package com.bytedance.android.livesdk.utils;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f158964a;

    static {
    }

    public static void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        r101.setDuration(200);
        boolean r102 = ((Boolean) SettingUtil.getValue("key_ttlive_sdk_setting", "live_enable_widget_gone_after_anchor_biz_panel", Boolean.TYPE, Boolean.TRUE)).booleanValue();
        f158964a = r102;
        if (r102 == false) goto L5;
        r101.addListener(new e7(r100));
    L5:
        UtilityKotlinExtentionsKt.t(r100);
    }

    public static void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f});
        r101.setDuration(200);
        if (f158964a == false) goto L5;
        r101.addListener(new f7(r100));
    L5:
        UtilityKotlinExtentionsKt.w(r100);
    }
}
