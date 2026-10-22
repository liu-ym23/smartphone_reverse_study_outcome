package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Disposable f68877a;

    public static void b() {
        if (LiveEffectSettings.LIVE_ENABLE_STICKER_BEAUTY_TEMPLATE.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        Disposable r100 = f68877a;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isDisposed() == true) goto L12;
        r100.dispose();
        f68877a = null;
        return;
    }

    static {
    }

    public static void a(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "eventPage");
        Intrinsics.checkNotNullParameter(r101, "modelName");
        Intrinsics.checkNotNullParameter(r102, "modelId");
        Intrinsics.checkNotNullParameter(r103, ReportConstant.COMMON_ACTION_TYPE);
        HashMap r104 = new HashMap();
        r104.put("live_type", "video_live");
        r104.put("model_name", r101);
        r104.put("model_id", r102);
        r104.put("action_type", r103);
        c.a("livesdk_beauty_model_popup_window_click", r104, r100);
    }
}
