package com.obric.oui.banner.configs;

import com.obric.oui.window.bean.WindowSizeClass;
import com.obric.oui.window.bean.WindowSizeWithPageSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridFillBannerConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/banner/configs/GridFillBannerConfigController;", "", "()V", "getFillBannerHeight", "", "windowSizeWithPageSize", "Lcom/obric/oui/window/bean/WindowSizeWithPageSize;", "getGridFillBannerConfig", "Lcom/obric/oui/banner/configs/GridFillBannerConfig;", "windowSize", "Lcom/obric/oui/window/bean/WindowSizeClass;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GridFillBannerConfigController {
    public static final GridFillBannerConfigController INSTANCE = null;

    /* JADX INFO: compiled from: GridFillBannerConfig.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[WindowSizeClass.values().length];
            r0[WindowSizeClass.MINUS_ERROR_SIZE.ordinal()] = 1;
            r0[WindowSizeClass.FLOATING_WINDOW.ordinal()] = 2;
            r0[WindowSizeClass.SMALL_SPLIT_SCREEN.ordinal()] = 3;
            r0[WindowSizeClass.SMALLER_ANDROID_SCREEN.ordinal()] = 4;
            r0[WindowSizeClass.SMALL.ordinal()] = 5;
            r0[WindowSizeClass.STANDARD.ordinal()] = 6;
            r0[WindowSizeClass.NORMAL.ordinal()] = 7;
            r0[WindowSizeClass.LARGE.ordinal()] = 8;
            r0[WindowSizeClass.OVERSIZE.ordinal()] = 9;
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new GridFillBannerConfigController();
    }

    private GridFillBannerConfigController() {
    }

    @JvmStatic
    public static final GridFillBannerConfig getGridFillBannerConfig(WindowSizeClass r15) {
        Intrinsics.checkNotNullParameter(r15, "windowSize");
        switch(WhenMappings.$EnumSwitchMapping$0[r15.ordinal()]) {
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L11;
            case 9: goto L10;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L10:
        return new GridFillBannerConfig(17.0f, 0.25f, 342);
    L11:
        return new GridFillBannerConfig(17.0f, 0.25f, 0, 4, null);
    L9:
        return new GridFillBannerConfig(16.0f, 0.33333334f, 0, 4, null);
    }

    @JvmStatic
    public static final int getFillBannerHeight(WindowSizeWithPageSize r2) {
        Intrinsics.checkNotNullParameter(r2, "windowSizeWithPageSize");
        GridFillBannerConfig r0 = getGridFillBannerConfig(r2.getWindowSizeClass());
        return Math.min(r0.getMaxHeight(), (int) (r2.getPageSize().getWidthInPx() * r0.getBannerRatio()));
    }
}
