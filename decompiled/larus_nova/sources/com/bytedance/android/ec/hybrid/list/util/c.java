package com.bytedance.android.ec.hybrid.list.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f47296a;

    public c() {
    }

    static {
        f47296a = -1;
    }

    public static int d(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp");
        double r101 = r100.doubleValue();
        Resources r102 = Resources.getSystem();
        return (int) (r101 * ((double) WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density));
    }

    public static int e(Context r100) {
        int r101 = f47296a;
        if (r101 <= 0) goto L6;
        return r101;
    L6:
        if (r100 != null) goto L21;
        return 0;
    L21:
        Object r102 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L16
        if (r102 == null) goto L15;
        Display r103 = ((WindowManager) r102).getDefaultDisplay();     // Catch: Exception -> L16
        Point r104 = new Point();     // Catch: Exception -> L16
        if (r103 == null) goto L17;
        r103.getRealSize(r104);     // Catch: Exception -> L16
        f47296a = r104.x;     // Catch: Exception -> L16
        goto L17
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L16
    L17:
        int r105 = f47296a;
        if (r105 > 0) goto L20;
        return 0;
    L20:
        return r105;
    }

    public static float f(Context r100) {
        int r101 = e(r100);
        if (r101 != 0) goto L6;
        return 1.0f;
    L6:
        Resources r102 = Resources.getSystem();
        return (r101 / WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
    }

    public static float b(Number r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp2btdp");
        float r102 = (r100.floatValue() * e(r101)) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
        Resources r103 = Resources.getSystem();
        return r102 / WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
    }

    public static int a(Number r100, Context r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$asPx");
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L6;
        Intrinsics.checkNotNullParameter(r100, "$this$nrpx");
        float r103 = r100.floatValue();
        float r104 = e(r101);
        Resources r105 = Resources.getSystem();
        return d(Float.valueOf((r103 * (r104 / WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density)) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS));
    L6:
        return d(r100);
    }

    public static int c(Number r100, Context r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$dp2btpx");
        if (r102 == false) goto L6;
        return Math.round((r100.floatValue() * e(r101)) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    L6:
        return (int) ((r100.floatValue() * e(r101)) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
    }
}
