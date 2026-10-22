package com.obric.oui.banner.configs;

import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.window.bean.WindowSizeClass;
import com.obric.oui.window.bean.WindowSizeWithPageSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridIndentBannerConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/banner/configs/GridIndentBannerConfigController;", "", "()V", "getGridIndentBannerConfig", "Lcom/obric/oui/banner/configs/GridIndentBannerConfig;", "windowSize", "Lcom/obric/oui/window/bean/WindowSizeClass;", "getIndentBannerSize", "Lkotlin/Pair;", "", "windowSizeWithPageSize", "Lcom/obric/oui/window/bean/WindowSizeWithPageSize;", "density", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GridIndentBannerConfigController {
    public static final GridIndentBannerConfigController INSTANCE = null;

    /* JADX INFO: compiled from: GridIndentBannerConfig.kt */
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
        INSTANCE = new GridIndentBannerConfigController();
    }

    private GridIndentBannerConfigController() {
    }

    @JvmStatic
    public static final GridIndentBannerConfig getGridIndentBannerConfig(WindowSizeClass r15) {
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
        return new GridIndentBannerConfig(17.0f, 0.25f, 326);
    L11:
        return new GridIndentBannerConfig(17.0f, 0.25f, 0, 4, null);
    L9:
        return new GridIndentBannerConfig(16.0f, 0.33333334f, 0, 4, null);
    }

    @JvmStatic
    public static final Pair<Integer, Integer> getIndentBannerSize(WindowSizeWithPageSize r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "windowSizeWithPageSize");
        WindowSizeClass r0 = r3.getWindowSizeClass();
        GridIndentBannerConfig r1 = getGridIndentBannerConfig(r0);
        int r5 = OUnitExtensionKt.dp2px(r3.getPageSize().getWidth(), r4) - (OUnitExtensionKt.dp2px(r0.getBaseGridConfig().getPageMargin().getMarginDp(), r4) * 2);
        return new Pair(Integer.valueOf(r5), Integer.valueOf(Math.min(r1.getMaxHeight(), (int) (r5 * r1.getBannerRatio()))));
    }
}
