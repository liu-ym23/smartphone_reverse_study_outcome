package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes10.dex */
public final class ECDisplayUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ScreenType f153036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Point[] f153037b;

    public static final enum ScreenType extends Enum<ScreenType> {
        public static final ScreenType FULL_SCREEN = null;
        public static final ScreenType NORMAL_SCREEN = null;
        public static final ScreenType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScreenType[] f153038a = null;

        static {
            ScreenType r100 = new ScreenType("FULL_SCREEN", 0);
            FULL_SCREEN = r100;
            ScreenType r101 = new ScreenType("NORMAL_SCREEN", 1);
            NORMAL_SCREEN = r101;
            ScreenType r102 = new ScreenType("UNKNOWN", 2);
            UNKNOWN = r102;
            f153038a = new ScreenType[]{r100, r101, r102};
        }

        public static ScreenType[] values() {
            return (ScreenType[]) f153038a.clone();
        }

        public static ScreenType valueOf(String r100) {
            return (ScreenType) r27.a.a(ScreenType.class, r100);
        }

        public ScreenType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f153036a = ScreenType.UNKNOWN;
        f153037b = new Point[2];
    }

    public static int a(Context r100) {
        com.bytedance.android.ec.core.opt.ab.d.a();
        ScreenType r101 = f153036a;
        ScreenType r102 = ScreenType.UNKNOWN;
        char r103 = 0;
        if (r101 == r102) goto L8;
        if (f153036a == ScreenType.FULL_SCREEN) goto L27;
    L28:
        boolean r104 = false;
    L29:
        if (r104 == false) goto L31;
        if (r100 != null) goto L35;
    L37:
        if (r100 == null) goto L50;
        if (th.a.f(r100).getConfiguration().orientation == 1) goto L43;
        r103 = 1;
    L43:
        if (f153037b[r103] != null) goto L52;
        WindowManager r105 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r105 == null) goto L51;
        Display r106 = r105.getDefaultDisplay();
        Point r107 = new Point();
        r106.getRealSize(r107);
        f153037b[r103] = r107;
        goto L52
    L51:
        return b(r100);
    L52:
        return f153037b[r103].y;
    L50:
        return b(r100);
    L35:
        if (ECSdk.c() == false) goto L37;
        com.bytedance.android.ec.core.opt.ab.d.a();
        goto L37
    L31:
        return b(r100);
    L27:
        r104 = true;
        goto L29
    L8:
        if (Build.VERSION.SDK_INT <= 21) goto L23;
        if (r100 == null) goto L11;
        WindowManager r108 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
    L12:
        if (r108 == null) goto L23;
        Display r109 = r108.getDefaultDisplay();
        Point r110 = new Point();
        r109.getRealSize(r110);
        int r111 = r110.x;
        int r112 = r110.y;
        if (r111 >= r112) goto L16;
        float r113 = r111;
        float r114 = r112;
    L18:
        if ((r114 / r113) < 1.97f) goto L20;
        ScreenType r115 = ScreenType.FULL_SCREEN;
    L21:
        f153036a = r115;
        goto L23
    L20:
        r115 = ScreenType.NORMAL_SCREEN;
        goto L21
    L16:
        float r116 = r112;
        r114 = r111;
        r113 = r116;
        goto L18
    L11:
        r108 = null;
    L23:
        if (f153036a != r102) goto L26;
        f153036a = ScreenType.NORMAL_SCREEN;
    L26:
        if (f153036a != ScreenType.FULL_SCREEN) goto L28;
        goto L27
    }

    public static int b(Context r100) {
        if (r100 == null) goto L5;
        Resources r101 = r100.getResources();
        return WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).heightPixels;
    L5:
        return 0;
    }

    public static boolean c(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getResources().getConfiguration().orientation != 2) goto L9;
        return true;
    L9:
        return false;
    }
}
