package com.stepos.widget.list;

import com.stepos.ailauncher.chat.trace.h;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b`\b\u0000\u0018\u0000 b2\u00020\u0001:\u0001bBù\u0002\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003¢\u0006\u0004\b1\u00102R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u00104R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u00104R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u00104R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u00104R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u00104R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00104R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u00104R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u00104R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00104R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u00104R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u00104R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u00104R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u00104R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u00104R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u00104R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00104R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00104R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u00104R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u00104R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u00104R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u00104R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00104R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u00104R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u00104R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u00104R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u00104R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u00104R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u00104R\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u00104R\u0011\u0010#\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u00104R\u0011\u0010$\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u00104R\u0011\u0010%\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u00104R\u0011\u0010&\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u00104R\u0011\u0010'\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bX\u00104R\u0011\u0010(\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bY\u00104R\u0011\u0010)\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u00104R\u0011\u0010*\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b[\u00104R\u0011\u0010+\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\\\u00104R\u0011\u0010,\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b]\u00104R\u0011\u0010-\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b^\u00104R\u0011\u0010.\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b_\u00104R\u0011\u0010/\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u00104R\u0011\u00100\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\ba\u00104¨\u0006c"}, d2 = {"Lcom/stepos/widget/list/ListItemAttrIndices;", "", "minHeight", "", "paddingHorizontal", "paddingVertical", "iconTextGap", "valueGap", "titleTextAppearance", "subtitleTextAppearance", "valueTextAppearance", "subtitleMaxLines", "adaptiveTextLayoutEnabled", "title", "titleEndText", "subtitle", "rightText", UxipConstants.f30680s, "iconBackground", "icon", "iconTint", "iconVisible", "iconStyle", "iconSize", "iconCornerRadius", "badgeStyle", "badgeTint", "showBadge", "rightBadgeStyle", "rightBadgeTint", "showRightBadge", "showAccessory", "rightIcon", "accessoryIcon", "accessoryTint", "accessorySize", "trailingType", "buttonText", "lineMode", "checked", "switchChecked", "pressScaleEnabled", h.APP_FOREGROUND, "showDivider", "dividerHeight", "dividerInsetStart", "dividerInsetEnd", "dividerColor", "titleStyle", "<init>", "(IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII)V", "getMinHeight", "()I", "getPaddingHorizontal", "getPaddingVertical", "getIconTextGap", "getValueGap", "getTitleTextAppearance", "getSubtitleTextAppearance", "getValueTextAppearance", "getSubtitleMaxLines", "getAdaptiveTextLayoutEnabled", "getTitle", "getTitleEndText", "getSubtitle", "getRightText", "getValue", "getIconBackground", "getIcon", "getIconTint", "getIconVisible", "getIconStyle", "getIconSize", "getIconCornerRadius", "getBadgeStyle", "getBadgeTint", "getShowBadge", "getRightBadgeStyle", "getRightBadgeTint", "getShowRightBadge", "getShowAccessory", "getRightIcon", "getAccessoryIcon", "getAccessoryTint", "getAccessorySize", "getTrailingType", "getButtonText", "getLineMode", "getChecked", "getSwitchChecked", "getPressScaleEnabled", "getForeground", "getShowDivider", "getDividerHeight", "getDividerInsetStart", "getDividerInsetEnd", "getDividerColor", "getTitleStyle", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ListItemAttrIndices {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ListItemAttrIndices LIST_ITEM = new ListItemAttrIndices(R.styleable.StepOSListItem_steposListItemMinHeight, R.styleable.StepOSListItem_steposListItemPaddingHorizontal, R.styleable.StepOSListItem_steposListItemPaddingVertical, R.styleable.StepOSListItem_steposListItemIconTextGap, R.styleable.StepOSListItem_steposListItemValueGap, R.styleable.StepOSListItem_steposListItemTitleTextAppearance, R.styleable.StepOSListItem_steposListItemSubtitleTextAppearance, R.styleable.StepOSListItem_steposListItemValueTextAppearance, R.styleable.StepOSListItem_steposListItemSubtitleMaxLines, R.styleable.StepOSListItem_steposListItemAdaptiveTextLayoutEnabled, R.styleable.StepOSListItem_steposListItemTitle, R.styleable.StepOSListItem_steposListItemTitleEndText, R.styleable.StepOSListItem_steposListItemSubtitle, R.styleable.StepOSListItem_steposListItemRightText, R.styleable.StepOSListItem_steposListItemValue, R.styleable.StepOSListItem_steposListItemIconBackground, R.styleable.StepOSListItem_steposListItemIcon, R.styleable.StepOSListItem_steposListItemIconTint, R.styleable.StepOSListItem_steposListItemIconVisible, R.styleable.StepOSListItem_steposListItemIconStyle, R.styleable.StepOSListItem_steposListItemIconSize, R.styleable.StepOSListItem_steposListItemIconCornerRadius, R.styleable.StepOSListItem_steposListItemBadgeStyle, R.styleable.StepOSListItem_steposListItemBadgeTint, R.styleable.StepOSListItem_steposListItemShowBadge, R.styleable.StepOSListItem_steposListItemRightBadgeStyle, R.styleable.StepOSListItem_steposListItemRightBadgeTint, R.styleable.StepOSListItem_steposListItemShowRightBadge, R.styleable.StepOSListItem_steposListItemShowAccessory, R.styleable.StepOSListItem_steposListItemRightIcon, R.styleable.StepOSListItem_steposListItemAccessoryIcon, R.styleable.StepOSListItem_steposListItemAccessoryTint, R.styleable.StepOSListItem_steposListItemAccessorySize, R.styleable.StepOSListItem_steposListItemTrailingType, R.styleable.StepOSListItem_steposListItemButtonText, R.styleable.StepOSListItem_steposListItemLineMode, R.styleable.StepOSListItem_steposListItemChecked, R.styleable.StepOSListItem_steposListItemSwitchChecked, R.styleable.StepOSListItem_steposListItemPressScaleEnabled, R.styleable.StepOSListItem_steposListItemForeground, R.styleable.StepOSListItem_steposListItemShowDivider, R.styleable.StepOSListItem_steposListItemDividerHeight, R.styleable.StepOSListItem_steposListItemDividerInsetStart, R.styleable.StepOSListItem_steposListItemDividerInsetEnd, R.styleable.StepOSListItem_steposListItemDividerColor, R.styleable.StepOSListItem_steposListItemTitleStyle);
    private static final ListItemAttrIndices PREFERENCE_BRIDGE = new ListItemAttrIndices(R.styleable.StepOSPreference_steposListItemMinHeight, R.styleable.StepOSPreference_steposListItemPaddingHorizontal, R.styleable.StepOSPreference_steposListItemPaddingVertical, R.styleable.StepOSPreference_steposListItemIconTextGap, R.styleable.StepOSPreference_steposListItemValueGap, R.styleable.StepOSPreference_steposListItemTitleTextAppearance, R.styleable.StepOSPreference_steposListItemSubtitleTextAppearance, R.styleable.StepOSPreference_steposListItemValueTextAppearance, R.styleable.StepOSPreference_steposListItemSubtitleMaxLines, R.styleable.StepOSPreference_steposListItemAdaptiveTextLayoutEnabled, R.styleable.StepOSPreference_steposListItemTitle, R.styleable.StepOSPreference_steposListItemTitleEndText, R.styleable.StepOSPreference_steposListItemSubtitle, R.styleable.StepOSPreference_steposListItemRightText, R.styleable.StepOSPreference_steposListItemValue, R.styleable.StepOSPreference_steposListItemIconBackground, R.styleable.StepOSPreference_steposListItemIcon, R.styleable.StepOSPreference_steposListItemIconTint, R.styleable.StepOSPreference_steposListItemIconVisible, R.styleable.StepOSPreference_steposListItemIconStyle, R.styleable.StepOSPreference_steposListItemIconSize, R.styleable.StepOSPreference_steposListItemIconCornerRadius, R.styleable.StepOSPreference_steposListItemBadgeStyle, R.styleable.StepOSPreference_steposListItemBadgeTint, R.styleable.StepOSPreference_steposListItemShowBadge, R.styleable.StepOSPreference_steposListItemRightBadgeStyle, R.styleable.StepOSPreference_steposListItemRightBadgeTint, R.styleable.StepOSPreference_steposListItemShowRightBadge, R.styleable.StepOSPreference_steposListItemShowAccessory, R.styleable.StepOSPreference_steposListItemRightIcon, R.styleable.StepOSPreference_steposListItemAccessoryIcon, R.styleable.StepOSPreference_steposListItemAccessoryTint, R.styleable.StepOSPreference_steposListItemAccessorySize, R.styleable.StepOSPreference_steposListItemTrailingType, R.styleable.StepOSPreference_steposListItemButtonText, R.styleable.StepOSPreference_steposListItemLineMode, R.styleable.StepOSPreference_steposListItemChecked, R.styleable.StepOSPreference_steposListItemSwitchChecked, R.styleable.StepOSPreference_steposListItemPressScaleEnabled, R.styleable.StepOSPreference_steposListItemForeground, R.styleable.StepOSPreference_steposListItemShowDivider, R.styleable.StepOSPreference_steposListItemDividerHeight, R.styleable.StepOSPreference_steposListItemDividerInsetStart, R.styleable.StepOSPreference_steposListItemDividerInsetEnd, R.styleable.StepOSPreference_steposListItemDividerColor, R.styleable.StepOSPreference_steposListItemTitleStyle);
    private final int accessoryIcon;
    private final int accessorySize;
    private final int accessoryTint;
    private final int adaptiveTextLayoutEnabled;
    private final int badgeStyle;
    private final int badgeTint;
    private final int buttonText;
    private final int checked;
    private final int dividerColor;
    private final int dividerHeight;
    private final int dividerInsetEnd;
    private final int dividerInsetStart;
    private final int foreground;
    private final int icon;
    private final int iconBackground;
    private final int iconCornerRadius;
    private final int iconSize;
    private final int iconStyle;
    private final int iconTextGap;
    private final int iconTint;
    private final int iconVisible;
    private final int lineMode;
    private final int minHeight;
    private final int paddingHorizontal;
    private final int paddingVertical;
    private final int pressScaleEnabled;
    private final int rightBadgeStyle;
    private final int rightBadgeTint;
    private final int rightIcon;
    private final int rightText;
    private final int showAccessory;
    private final int showBadge;
    private final int showDivider;
    private final int showRightBadge;
    private final int subtitle;
    private final int subtitleMaxLines;
    private final int subtitleTextAppearance;
    private final int switchChecked;
    private final int title;
    private final int titleEndText;
    private final int titleStyle;
    private final int titleTextAppearance;
    private final int trailingType;
    private final int value;
    private final int valueGap;
    private final int valueTextAppearance;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/stepos/widget/list/ListItemAttrIndices$Companion;", "", "<init>", "()V", "LIST_ITEM", "Lcom/stepos/widget/list/ListItemAttrIndices;", "getLIST_ITEM$StepOSWidget_release", "()Lcom/stepos/widget/list/ListItemAttrIndices;", "PREFERENCE_BRIDGE", "getPREFERENCE_BRIDGE$StepOSWidget_release", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final ListItemAttrIndices getLIST_ITEM$StepOSWidget_release() {
            return ListItemAttrIndices.LIST_ITEM;
        }

        public final ListItemAttrIndices getPREFERENCE_BRIDGE$StepOSWidget_release() {
            return ListItemAttrIndices.PREFERENCE_BRIDGE;
        }

        private Companion() {
        }
    }

    private ListItemAttrIndices(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41, int i42, int i43, int i44, int i45, int i46, int i47, int i48, int i49, int i50, int i51, int i52, int i53, int i54, int i55) {
        this.minHeight = i10;
        this.paddingHorizontal = i11;
        this.paddingVertical = i12;
        this.iconTextGap = i13;
        this.valueGap = i14;
        this.titleTextAppearance = i15;
        this.subtitleTextAppearance = i16;
        this.valueTextAppearance = i17;
        this.subtitleMaxLines = i18;
        this.adaptiveTextLayoutEnabled = i19;
        this.title = i20;
        this.titleEndText = i21;
        this.subtitle = i22;
        this.rightText = i23;
        this.value = i24;
        this.iconBackground = i25;
        this.icon = i26;
        this.iconTint = i27;
        this.iconVisible = i28;
        this.iconStyle = i29;
        this.iconSize = i30;
        this.iconCornerRadius = i31;
        this.badgeStyle = i32;
        this.badgeTint = i33;
        this.showBadge = i34;
        this.rightBadgeStyle = i35;
        this.rightBadgeTint = i36;
        this.showRightBadge = i37;
        this.showAccessory = i38;
        this.rightIcon = i39;
        this.accessoryIcon = i40;
        this.accessoryTint = i41;
        this.accessorySize = i42;
        this.trailingType = i43;
        this.buttonText = i44;
        this.lineMode = i45;
        this.checked = i46;
        this.switchChecked = i47;
        this.pressScaleEnabled = i48;
        this.foreground = i49;
        this.showDivider = i50;
        this.dividerHeight = i51;
        this.dividerInsetStart = i52;
        this.dividerInsetEnd = i53;
        this.dividerColor = i54;
        this.titleStyle = i55;
    }

    public final int getAccessoryIcon() {
        return this.accessoryIcon;
    }

    public final int getAccessorySize() {
        return this.accessorySize;
    }

    public final int getAccessoryTint() {
        return this.accessoryTint;
    }

    public final int getAdaptiveTextLayoutEnabled() {
        return this.adaptiveTextLayoutEnabled;
    }

    public final int getBadgeStyle() {
        return this.badgeStyle;
    }

    public final int getBadgeTint() {
        return this.badgeTint;
    }

    public final int getButtonText() {
        return this.buttonText;
    }

    public final int getChecked() {
        return this.checked;
    }

    public final int getDividerColor() {
        return this.dividerColor;
    }

    public final int getDividerHeight() {
        return this.dividerHeight;
    }

    public final int getDividerInsetEnd() {
        return this.dividerInsetEnd;
    }

    public final int getDividerInsetStart() {
        return this.dividerInsetStart;
    }

    public final int getForeground() {
        return this.foreground;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getIconBackground() {
        return this.iconBackground;
    }

    public final int getIconCornerRadius() {
        return this.iconCornerRadius;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public final int getIconStyle() {
        return this.iconStyle;
    }

    public final int getIconTextGap() {
        return this.iconTextGap;
    }

    public final int getIconTint() {
        return this.iconTint;
    }

    public final int getIconVisible() {
        return this.iconVisible;
    }

    public final int getLineMode() {
        return this.lineMode;
    }

    public final int getMinHeight() {
        return this.minHeight;
    }

    public final int getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    public final int getPaddingVertical() {
        return this.paddingVertical;
    }

    public final int getPressScaleEnabled() {
        return this.pressScaleEnabled;
    }

    public final int getRightBadgeStyle() {
        return this.rightBadgeStyle;
    }

    public final int getRightBadgeTint() {
        return this.rightBadgeTint;
    }

    public final int getRightIcon() {
        return this.rightIcon;
    }

    public final int getRightText() {
        return this.rightText;
    }

    public final int getShowAccessory() {
        return this.showAccessory;
    }

    public final int getShowBadge() {
        return this.showBadge;
    }

    public final int getShowDivider() {
        return this.showDivider;
    }

    public final int getShowRightBadge() {
        return this.showRightBadge;
    }

    public final int getSubtitle() {
        return this.subtitle;
    }

    public final int getSubtitleMaxLines() {
        return this.subtitleMaxLines;
    }

    public final int getSubtitleTextAppearance() {
        return this.subtitleTextAppearance;
    }

    public final int getSwitchChecked() {
        return this.switchChecked;
    }

    public final int getTitle() {
        return this.title;
    }

    public final int getTitleEndText() {
        return this.titleEndText;
    }

    public final int getTitleStyle() {
        return this.titleStyle;
    }

    public final int getTitleTextAppearance() {
        return this.titleTextAppearance;
    }

    public final int getTrailingType() {
        return this.trailingType;
    }

    public final int getValue() {
        return this.value;
    }

    public final int getValueGap() {
        return this.valueGap;
    }

    public final int getValueTextAppearance() {
        return this.valueTextAppearance;
    }
}
