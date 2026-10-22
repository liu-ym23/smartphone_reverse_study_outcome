package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ThemeUtils {
    static final int[] ACTIVATED_STATE_SET = null;
    static final int[] CHECKED_STATE_SET = null;
    static final int[] DISABLED_STATE_SET = null;
    static final int[] EMPTY_STATE_SET = null;
    static final int[] FOCUSED_STATE_SET = null;
    static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET = null;
    static final int[] PRESSED_STATE_SET = null;
    static final int[] SELECTED_STATE_SET = null;
    private static final String TAG = "ThemeUtils";
    private static final int[] TEMP_ARRAY = null;
    private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = null;

    static {
        TL_TYPED_VALUE = new ThreadLocal();
        DISABLED_STATE_SET = new int[]{-16842910};
        FOCUSED_STATE_SET = new int[]{R.attr.state_focused};
        ACTIVATED_STATE_SET = new int[]{R.attr.state_activated};
        PRESSED_STATE_SET = new int[]{R.attr.state_pressed};
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        SELECTED_STATE_SET = new int[]{R.attr.state_selected};
        NOT_PRESSED_OR_FOCUSED_STATE_SET = new int[]{-16842919, -16842908};
        EMPTY_STATE_SET = new int[0];
        TEMP_ARRAY = new int[1];
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r100 = TL_TYPED_VALUE;
        TypedValue r101 = r100.get();
        if (r101 != null) goto L6;
        TypedValue r102 = new TypedValue();
        r100.set(r102);
        return r102;
    L6:
        return r101;
    }

    private ThemeUtils() {
    }

    public static void checkAppCompatTheme(View r100, Context r101) {
        TypedArray r102 = r101.obtainStyledAttributes(new int[]{R.attr.windowIsFloating, R.attr.windowAnimationStyle, com.larus.nova.R.attr.actionBarDivider, com.larus.nova.R.attr.actionBarItemBackground, com.larus.nova.R.attr.actionBarPopupTheme, com.larus.nova.R.attr.actionBarSize, com.larus.nova.R.attr.actionBarSplitStyle, com.larus.nova.R.attr.actionBarStyle, com.larus.nova.R.attr.actionBarTabBarStyle, com.larus.nova.R.attr.actionBarTabStyle, com.larus.nova.R.attr.actionBarTabTextStyle, com.larus.nova.R.attr.actionBarTheme, com.larus.nova.R.attr.actionBarWidgetTheme, com.larus.nova.R.attr.actionButtonStyle, com.larus.nova.R.attr.actionDropDownStyle, com.larus.nova.R.attr.actionMenuTextAppearance, com.larus.nova.R.attr.actionMenuTextColor, com.larus.nova.R.attr.actionModeBackground, com.larus.nova.R.attr.actionModeCloseButtonStyle, com.larus.nova.R.attr.actionModeCloseContentDescription, com.larus.nova.R.attr.actionModeCloseDrawable, com.larus.nova.R.attr.actionModeCopyDrawable, com.larus.nova.R.attr.actionModeCutDrawable, com.larus.nova.R.attr.actionModeFindDrawable, com.larus.nova.R.attr.actionModePasteDrawable, com.larus.nova.R.attr.actionModePopupWindowStyle, com.larus.nova.R.attr.actionModeSelectAllDrawable, com.larus.nova.R.attr.actionModeShareDrawable, com.larus.nova.R.attr.actionModeSplitBackground, com.larus.nova.R.attr.actionModeStyle, com.larus.nova.R.attr.actionModeTheme, com.larus.nova.R.attr.actionModeWebSearchDrawable, com.larus.nova.R.attr.actionOverflowButtonStyle, com.larus.nova.R.attr.actionOverflowMenuStyle, com.larus.nova.R.attr.activityChooserViewStyle, com.larus.nova.R.attr.alertDialogButtonGroupStyle, com.larus.nova.R.attr.alertDialogCenterButtons, com.larus.nova.R.attr.alertDialogStyle, com.larus.nova.R.attr.alertDialogTheme, com.larus.nova.R.attr.autoCompleteTextViewStyle, com.larus.nova.R.attr.borderlessButtonStyle, com.larus.nova.R.attr.buttonBarButtonStyle, com.larus.nova.R.attr.buttonBarNegativeButtonStyle, com.larus.nova.R.attr.buttonBarNeutralButtonStyle, com.larus.nova.R.attr.buttonBarPositiveButtonStyle, com.larus.nova.R.attr.buttonBarStyle, com.larus.nova.R.attr.buttonStyle, com.larus.nova.R.attr.buttonStyleSmall, com.larus.nova.R.attr.checkboxStyle, com.larus.nova.R.attr.checkedTextViewStyle, com.larus.nova.R.attr.colorAccent, com.larus.nova.R.attr.colorBackgroundFloating, com.larus.nova.R.attr.colorButtonNormal, com.larus.nova.R.attr.colorControlActivated, com.larus.nova.R.attr.colorControlHighlight, com.larus.nova.R.attr.colorControlNormal, com.larus.nova.R.attr.colorError, com.larus.nova.R.attr.colorPrimary, com.larus.nova.R.attr.colorPrimaryDark, com.larus.nova.R.attr.colorSwitchThumbNormal, com.larus.nova.R.attr.controlBackground, com.larus.nova.R.attr.dialogCornerRadius, com.larus.nova.R.attr.dialogPreferredPadding, com.larus.nova.R.attr.dialogTheme, com.larus.nova.R.attr.dividerHorizontal, com.larus.nova.R.attr.dividerVertical, com.larus.nova.R.attr.dropDownListViewStyle, com.larus.nova.R.attr.dropdownListPreferredItemHeight, com.larus.nova.R.attr.editTextBackground, com.larus.nova.R.attr.editTextColor, com.larus.nova.R.attr.editTextStyle, com.larus.nova.R.attr.homeAsUpIndicator, com.larus.nova.R.attr.imageButtonStyle, com.larus.nova.R.attr.listChoiceBackgroundIndicator, com.larus.nova.R.attr.listChoiceIndicatorMultipleAnimated, com.larus.nova.R.attr.listChoiceIndicatorSingleAnimated, com.larus.nova.R.attr.listDividerAlertDialog, com.larus.nova.R.attr.listMenuViewStyle, com.larus.nova.R.attr.listPopupWindowStyle, com.larus.nova.R.attr.listPreferredItemHeight, com.larus.nova.R.attr.listPreferredItemHeightLarge, com.larus.nova.R.attr.listPreferredItemHeightSmall, com.larus.nova.R.attr.listPreferredItemPaddingEnd, com.larus.nova.R.attr.listPreferredItemPaddingLeft, com.larus.nova.R.attr.listPreferredItemPaddingRight, com.larus.nova.R.attr.listPreferredItemPaddingStart, com.larus.nova.R.attr.panelBackground, com.larus.nova.R.attr.panelMenuListTheme, com.larus.nova.R.attr.panelMenuListWidth, com.larus.nova.R.attr.popupMenuStyle, com.larus.nova.R.attr.popupWindowStyle, com.larus.nova.R.attr.radioButtonStyle, com.larus.nova.R.attr.ratingBarStyle, com.larus.nova.R.attr.ratingBarStyleIndicator, com.larus.nova.R.attr.ratingBarStyleSmall, com.larus.nova.R.attr.searchViewStyle, com.larus.nova.R.attr.seekBarStyle, com.larus.nova.R.attr.selectableItemBackground, com.larus.nova.R.attr.selectableItemBackgroundBorderless, com.larus.nova.R.attr.spinnerDropDownItemStyle, com.larus.nova.R.attr.spinnerStyle, com.larus.nova.R.attr.switchStyle, com.larus.nova.R.attr.textAppearanceLargePopupMenu, com.larus.nova.R.attr.textAppearanceListItem, com.larus.nova.R.attr.textAppearanceListItemSecondary, com.larus.nova.R.attr.textAppearanceListItemSmall, com.larus.nova.R.attr.textAppearancePopupMenuHeader, com.larus.nova.R.attr.textAppearanceSearchResultSubtitle, com.larus.nova.R.attr.textAppearanceSearchResultTitle, com.larus.nova.R.attr.textAppearanceSmallPopupMenu, com.larus.nova.R.attr.textColorAlertDialogListItem, com.larus.nova.R.attr.textColorSearchUrl, com.larus.nova.R.attr.toolbarNavigationButtonStyle, com.larus.nova.R.attr.toolbarStyle, com.larus.nova.R.attr.tooltipForegroundColor, com.larus.nova.R.attr.tooltipFrameBackground, com.larus.nova.R.attr.viewInflaterClass, com.larus.nova.R.attr.windowActionBar, com.larus.nova.R.attr.windowActionBarOverlay, com.larus.nova.R.attr.windowActionModeOverlay, com.larus.nova.R.attr.windowFixedHeightMajor, com.larus.nova.R.attr.windowFixedHeightMinor, com.larus.nova.R.attr.windowFixedWidthMajor, com.larus.nova.R.attr.windowFixedWidthMinor, com.larus.nova.R.attr.windowMinWidthMajor, com.larus.nova.R.attr.windowMinWidthMinor, com.larus.nova.R.attr.windowNoTitle});
    L8:
        th = move-exception;
        r102.recycle();
        throw th;
    L4:
        if (r102.hasValue(117) == true) goto L6;
        r100.getClass().toString();     // Catch: Throwable -> L8
    L6:
        r102.recycle();
    }

    public static ColorStateList createDisabledStateList(int r100, int r101) {
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, EMPTY_STATE_SET}, new int[]{r101, r100});
    }

    public static int getDisabledThemeAttrColor(Context r100, int r101) {
        ColorStateList r102 = getThemeAttrColorStateList(r100, r101);
        if (r102 != null) goto L5;
    L8:
        TypedValue r103 = getTypedValue();
        r100.getTheme().resolveAttribute(R.attr.disabledAlpha, r103, true);
        return getThemeAttrColor(r100, r101, r103.getFloat());
    L5:
        if (r102.isStateful() == false) goto L8;
        return r102.getColorForState(DISABLED_STATE_SET, r102.getDefaultColor());
    }

    public static int getThemeAttrColor(Context r100, int r101) {
        int[] r102 = TEMP_ARRAY;
        r102[0] = r101;
        TintTypedArray r103 = TintTypedArray.obtainStyledAttributes(r100, null, r102);
        int r104 = r103.getColor(0, 0);     // Catch: Throwable -> L6
        r103.recycle();
        return r104;
    L6:
        th = move-exception;
        r103.recycle();
        throw th;
    }

    public static ColorStateList getThemeAttrColorStateList(Context r100, int r101) {
        int[] r102 = TEMP_ARRAY;
        r102[0] = r101;
        TintTypedArray r103 = TintTypedArray.obtainStyledAttributes(r100, null, r102);
        ColorStateList r104 = r103.getColorStateList(0);     // Catch: Throwable -> L6
        r103.recycle();
        return r104;
    L6:
        th = move-exception;
        r103.recycle();
        throw th;
    }

    public static int getThemeAttrColor(Context r100, int r101, float r102) {
        int r103 = getThemeAttrColor(r100, r101);
        return ColorUtils.setAlphaComponent(r103, Math.round(Color.alpha(r103) * r102));
    }
}
