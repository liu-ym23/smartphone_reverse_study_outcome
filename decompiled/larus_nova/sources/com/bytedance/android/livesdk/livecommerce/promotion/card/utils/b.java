package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f150307a = 0;

    public b() {
    }

    static {
        new Handler(Looper.getMainLooper());
    }

    @JvmStatic
    public static final int c(float r100) {
        Resources r101 = Resources.getSystem();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public static float[] d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        return new float[]{r101[0] + (r100.getWidth() / 2), r101[1] + (r100.getHeight() / 2)};
    }

    public static void a(int r100, int r101, String r102, TextView r103) {
        Intrinsics.checkNotNullParameter(r102, "showText");
        Intrinsics.checkNotNullParameter(r103, "textView");
        if (r100 < 1) goto L9;
    L4:
        Paint r104 = new Paint();
        float r105 = r100;
        r104.setTextSize(c(r105));
        if ((r101 + 0) > r104.measureText(r102)) goto L6;
        if (r100 == 1) goto L9;
        r100 = r100 - 1;
        goto L4
    L6:
        r103.setTextSize(1, r105);
        return;
    L9:
        r103.setTextSize(1);
    }

    public static void b(int r100, int r101, int r102, String r103, TextView r104, int r105) {
        Intrinsics.checkNotNullParameter(r103, "showText");
        Intrinsics.checkNotNullParameter(r104, "textView");
        if (r100 < r101) goto L10;
    L4:
        Paint r106 = new Paint();
        float r107 = r100;
        r106.setTextSize(c(r107));
        if ((r102 - r105) > r106.measureText(r103)) goto L6;
        if (r100 == r101) goto L10;
        r100 = r100 - 1;
        goto L4
    L6:
        r104.setTextSize(r107);
        return;
    L10:
        r104.setTextSize(r101);
    }
}
