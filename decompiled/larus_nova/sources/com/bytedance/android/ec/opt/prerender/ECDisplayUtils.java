package com.bytedance.android.ec.opt.prerender;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes44.dex */
public final class ECDisplayUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ScreenType f48064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Point[] f48065b;

    public static final enum ScreenType extends Enum<ScreenType> {
        public static final ScreenType FULL_SCREEN = null;
        public static final ScreenType NORMAL_SCREEN = null;
        public static final ScreenType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScreenType[] f48066a = null;

        static {
            ScreenType r100 = new ScreenType("FULL_SCREEN", 0);
            FULL_SCREEN = r100;
            ScreenType r101 = new ScreenType("NORMAL_SCREEN", 1);
            NORMAL_SCREEN = r101;
            ScreenType r102 = new ScreenType("UNKNOWN", 2);
            UNKNOWN = r102;
            f48066a = new ScreenType[]{r100, r101, r102};
        }

        public static ScreenType[] values() {
            return (ScreenType[]) f48066a.clone();
        }

        public static ScreenType valueOf(String r100) {
            return (ScreenType) r27.a.a(ScreenType.class, r100);
        }

        public ScreenType(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f48064a = ScreenType.UNKNOWN;
        f48065b = new Point[2];
    }

    public static int a(Context r100) {
        if (r100 == null) goto L5;
        Resources r101 = r100.getResources();
        return WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).heightPixels;
    L5:
        return 0;
    }
}
