package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes2.dex */
public class ActionBarPolicy {
    private Context mContext;

    public boolean showsOverflowMenuButton() {
        return true;
    }

    public boolean enableHomeButtonByDefault() {
        if (this.mContext.getApplicationInfo().targetSdkVersion >= 14) goto L5;
        return true;
    L5:
        return false;
    }

    public int getEmbeddedMenuWidthLimit() {
        return INVOKEVIRTUAL_androidx_appcompat_view_ActionBarPolicy_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).widthPixels / 2;
    }

    public int getMaxActionButtons() {
        Configuration r100 = this.mContext.getResources().getConfiguration();
        int r101 = r100.screenWidthDp;
        int r102 = r100.screenHeightDp;
        if (r100.smallestScreenWidthDp > 600) goto L27;
        if (r101 <= 600) goto L6;
        return 5;
    L6:
        if (r101 <= 960) goto L8;
        if (r102 <= 720) goto L8;
        return 5;
    L8:
        if (r101 <= 720) goto L12;
        if (r102 <= 960) goto L12;
        return 5;
    L12:
        if (r101 < 500) goto L14;
        return 4;
    L14:
        if (r101 <= 640) goto L16;
        if (r102 <= 480) goto L16;
        return 4;
    L16:
        if (r101 <= 480) goto L20;
        if (r102 <= 640) goto L20;
        return 4;
    L20:
        if (r101 < 360) goto L23;
        return 3;
    L23:
        return 2;
    L27:
        return 5;
    }

    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int getTabContainerHeight() {
        TypedArray r100 = this.mContext.obtainStyledAttributes(null, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.backgroundStacked, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.customNavigationLayout, R.attr.displayOptions, R.attr.divider, R.attr.elevation, R.attr.height, R.attr.hideOnContentScroll, R.attr.homeAsUpIndicator, R.attr.homeLayout, R.attr.icon, R.attr.indeterminateProgressStyle, R.attr.itemPadding, R.attr.logo, R.attr.navigationMode, R.attr.popupTheme, R.attr.progressBarPadding, R.attr.progressBarStyle, R.attr.subtitle, R.attr.subtitleTextStyle, R.attr.title, R.attr.titleTextStyle}, R.attr.actionBarStyle, 0);
        int r101 = r100.getLayoutDimension(13, 0);
        Resources r102 = this.mContext.getResources();
        if (hasEmbeddedTabs() == true) goto L5;
        r101 = Math.min(r101, r102.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
    L5:
        r100.recycle();
        return r101;
    }

    public boolean hasEmbeddedTabs() {
        return this.mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    private ActionBarPolicy(Context r100) {
        this.mContext = r100;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_view_ActionBarPolicy_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static ActionBarPolicy get(Context r100) {
        return new ActionBarPolicy(r100);
    }
}
