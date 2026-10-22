package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f139339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f139340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f139341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ba2.e f139342d;

    public final Context getContext() {
        return this.f139341c;
    }

    public c(Context r100, ba2.e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "detector");
        this.f139341c = r100;
        this.f139342d = r101;
        Resources r102 = r100.getResources();
        int r103 = 0;
        if (r102 == null) goto L7;
        DisplayMetrics r104 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        if (r104 == null) goto L7;
        int r105 = r104.heightPixels;
    L8:
        int r106 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r106 <= 0) goto L11;
        r103 = r100.getResources().getDimensionPixelSize(r106);
    L11:
        this.f139339a = (r105 + r103) / 2;
        this.f139340b = 0.3f;
        return;
    L7:
        r105 = 0;
        goto L8
    }
}
