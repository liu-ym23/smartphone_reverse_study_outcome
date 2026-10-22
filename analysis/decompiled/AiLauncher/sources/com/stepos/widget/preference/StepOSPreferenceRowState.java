package com.stepos.widget.preference;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.widget.list.PreferenceListItemBridgeState;
import com.stepos.widget.list.StepOSCardPosition;
import com.stepos.widget.list.StepOSListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u00052\u0006\u0010X\u001a\u00020YJ\u000e\u0010Z\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020YJ\u000e\u0010[\u001a\u00020\u00122\u0006\u0010X\u001a\u00020YJ\u000e\u0010\\\u001a\u00020\u00122\u0006\u0010X\u001a\u00020YJ\u000e\u0010]\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020YJ\u0015\u0010^\u001a\u0004\u0018\u00010\u000b2\u0006\u0010X\u001a\u00020Y¢\u0006\u0002\u0010_J\u000e\u0010`\u001a\u00020\u00122\u0006\u0010X\u001a\u00020YJ\u000e\u0010a\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020YJ\u0015\u0010b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010X\u001a\u00020Y¢\u0006\u0002\u0010_J\u000e\u0010c\u001a\u00020\u00122\u0006\u0010X\u001a\u00020YJ\u000e\u0010d\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020YJ\u000e\u0010e\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020YR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\u001e\u0010!\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u001e\u0010$\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR\u001e\u0010'\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR\u001e\u0010*\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R\u001c\u0010-\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001e\u00100\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR\u001e\u00103\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR\u001c\u00106\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tR\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V¨\u0006f"}, d2 = {"Lcom/stepos/widget/preference/StepOSPreferenceRowState;", "", "<init>", "()V", "rightText", "", "getRightText", "()Ljava/lang/CharSequence;", "setRightText", "(Ljava/lang/CharSequence;)V", "trailingType", "", "getTrailingType", "()Ljava/lang/Integer;", "setTrailingType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "switchChecked", "", "getSwitchChecked", "()Ljava/lang/Boolean;", "setSwitchChecked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "showBadge", "getShowBadge", "setShowBadge", "badgeStyle", "getBadgeStyle", "setBadgeStyle", "badgeTint", "getBadgeTint", "setBadgeTint", "showRightBadge", "getShowRightBadge", "setShowRightBadge", "rightBadgeStyle", "getRightBadgeStyle", "setRightBadgeStyle", "rightBadgeTint", "getRightBadgeTint", "setRightBadgeTint", "checked", "getChecked", "setChecked", "titleEndText", "getTitleEndText", "setTitleEndText", "lineMode", "getLineMode", "setLineMode", "iconStyle", "getIconStyle", "setIconStyle", "buttonText", "getButtonText", "setButtonText", "buttonClickListener", "Landroid/view/View$OnClickListener;", "getButtonClickListener", "()Landroid/view/View$OnClickListener;", "setButtonClickListener", "(Landroid/view/View$OnClickListener;)V", "trailingView", "Landroid/view/View;", "getTrailingView", "()Landroid/view/View;", "setTrailingView", "(Landroid/view/View;)V", "switchCheckedChangeListener", "Lcom/stepos/widget/list/StepOSListItem$OnSwitchCheckedChangeListener;", "getSwitchCheckedChangeListener", "()Lcom/stepos/widget/list/StepOSListItem$OnSwitchCheckedChangeListener;", "setSwitchCheckedChangeListener", "(Lcom/stepos/widget/list/StepOSListItem$OnSwitchCheckedChangeListener;)V", "itemClickListener", "Lcom/stepos/widget/list/StepOSListItem$OnItemClickListener;", "getItemClickListener", "()Lcom/stepos/widget/list/StepOSListItem$OnItemClickListener;", "setItemClickListener", "(Lcom/stepos/widget/list/StepOSListItem$OnItemClickListener;)V", "cardPosition", "Lcom/stepos/widget/list/StepOSCardPosition;", "getCardPosition", "()Lcom/stepos/widget/list/StepOSCardPosition;", "setCardPosition", "(Lcom/stepos/widget/list/StepOSCardPosition;)V", "resolvedRightText", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/widget/list/PreferenceListItemBridgeState;", "resolvedTrailingType", "resolvedSwitchChecked", "resolvedShowBadge", "resolvedBadgeStyle", "resolvedBadgeTint", "(Lcom/stepos/widget/list/PreferenceListItemBridgeState;)Ljava/lang/Integer;", "resolvedShowRightBadge", "resolvedRightBadgeStyle", "resolvedRightBadgeTint", "resolvedChecked", "resolvedLineMode", "resolvedIconStyle", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSPreferenceRowState {
    private Integer badgeStyle;
    private Integer badgeTint;
    private View.OnClickListener buttonClickListener;
    private CharSequence buttonText;
    private StepOSCardPosition cardPosition = StepOSCardPosition.NONE;
    private Boolean checked;
    private Integer iconStyle;
    private StepOSListItem.OnItemClickListener itemClickListener;
    private Integer lineMode;
    private Integer rightBadgeStyle;
    private Integer rightBadgeTint;
    private CharSequence rightText;
    private Boolean showBadge;
    private Boolean showRightBadge;
    private Boolean switchChecked;
    private StepOSListItem.OnSwitchCheckedChangeListener switchCheckedChangeListener;
    private CharSequence titleEndText;
    private Integer trailingType;
    private View trailingView;

    public final Integer getBadgeStyle() {
        return this.badgeStyle;
    }

    public final Integer getBadgeTint() {
        return this.badgeTint;
    }

    public final View.OnClickListener getButtonClickListener() {
        return this.buttonClickListener;
    }

    public final CharSequence getButtonText() {
        return this.buttonText;
    }

    public final StepOSCardPosition getCardPosition() {
        return this.cardPosition;
    }

    public final Boolean getChecked() {
        return this.checked;
    }

    public final Integer getIconStyle() {
        return this.iconStyle;
    }

    public final StepOSListItem.OnItemClickListener getItemClickListener() {
        return this.itemClickListener;
    }

    public final Integer getLineMode() {
        return this.lineMode;
    }

    public final Integer getRightBadgeStyle() {
        return this.rightBadgeStyle;
    }

    public final Integer getRightBadgeTint() {
        return this.rightBadgeTint;
    }

    public final CharSequence getRightText() {
        return this.rightText;
    }

    public final Boolean getShowBadge() {
        return this.showBadge;
    }

    public final Boolean getShowRightBadge() {
        return this.showRightBadge;
    }

    public final Boolean getSwitchChecked() {
        return this.switchChecked;
    }

    public final StepOSListItem.OnSwitchCheckedChangeListener getSwitchCheckedChangeListener() {
        return this.switchCheckedChangeListener;
    }

    public final CharSequence getTitleEndText() {
        return this.titleEndText;
    }

    public final Integer getTrailingType() {
        return this.trailingType;
    }

    public final View getTrailingView() {
        return this.trailingView;
    }

    public final int resolvedBadgeStyle(PreferenceListItemBridgeState b10) {
        p.i(b10, "b");
        Integer num = this.badgeStyle;
        return num != null ? num.intValue() : b10.getBadgeStyle();
    }

    public final Integer resolvedBadgeTint(PreferenceListItemBridgeState b10) {
        p.i(b10, "b");
        Integer num = this.badgeTint;
        if (num != null) {
            return num;
        }
        Integer numValueOf = Integer.valueOf(b10.getBadgeTint());
        if (b10.getBadgeTintSet()) {
            return numValueOf;
        }
        return null;
    }

    public final boolean resolvedChecked(PreferenceListItemBridgeState b10) {
        p.i(b10, "b");
        Boolean bool = this.checked;
        return bool != null ? bool.booleanValue() : b10.getChecked();
    }

    public final int resolvedIconStyle(PreferenceListItemBridgeState b10) {
        p.i(b10, "b");
        Integer num = this.iconStyle;
        return num != null ? num.intValue() : b10.getIconStyle();
    }

    public final int resolvedLineMode(PreferenceListItemBridgeState b10) {
        p.i(b10, "b");
        Integer num = this.lineMode;
        return num != null ? num.intValue() : b10.getLineMode();
    }

    public final int resolvedRightBadgeStyle(PreferenceListItemBridgeState b10) {
        p.i(b10, "b");
        Integer num = this.rightBadgeStyle;
        return num != null ? num.intValue() : b10.getRightBadgeStyle();
    }

    public final Integer resolvedRightBadgeTint(PreferenceListItemBridgeState b10) {
        p.i(b10, "b");
        Integer num = this.rightBadgeTint;
        if (num != null) {
            return num;
        }
        Integer numValueOf = Integer.valueOf(b10.getRightBadgeTint());
        if (b10.getRightBadgeTintSet()) {
            return numValueOf;
        }
        return null;
    }

    public final CharSequence resolvedRightText(PreferenceListItemBridgeState b10) {
        p.i(b10, "b");
        CharSequence charSequence = this.rightText;
        return charSequence == null ? b10.getRightText() : charSequence;
    }

    public final boolean resolvedShowBadge(PreferenceListItemBridgeState b10) {
        p.i(b10, "b");
        Boolean bool = this.showBadge;
        return bool != null ? bool.booleanValue() : b10.getShowBadge();
    }

    public final boolean resolvedShowRightBadge(PreferenceListItemBridgeState b10) {
        p.i(b10, "b");
        Boolean bool = this.showRightBadge;
        return bool != null ? bool.booleanValue() : b10.getShowRightBadge();
    }

    public final boolean resolvedSwitchChecked(PreferenceListItemBridgeState b10) {
        p.i(b10, "b");
        Boolean bool = this.switchChecked;
        return bool != null ? bool.booleanValue() : b10.getSwitchChecked();
    }

    public final int resolvedTrailingType(PreferenceListItemBridgeState b10) {
        p.i(b10, "b");
        Integer num = this.trailingType;
        return num != null ? num.intValue() : b10.getTrailingType();
    }

    public final void setBadgeStyle(Integer num) {
        this.badgeStyle = num;
    }

    public final void setBadgeTint(Integer num) {
        this.badgeTint = num;
    }

    public final void setButtonClickListener(View.OnClickListener onClickListener) {
        this.buttonClickListener = onClickListener;
    }

    public final void setButtonText(CharSequence charSequence) {
        this.buttonText = charSequence;
    }

    public final void setCardPosition(StepOSCardPosition stepOSCardPosition) {
        p.i(stepOSCardPosition, "<set-?>");
        this.cardPosition = stepOSCardPosition;
    }

    public final void setChecked(Boolean bool) {
        this.checked = bool;
    }

    public final void setIconStyle(Integer num) {
        this.iconStyle = num;
    }

    public final void setItemClickListener(StepOSListItem.OnItemClickListener onItemClickListener) {
        this.itemClickListener = onItemClickListener;
    }

    public final void setLineMode(Integer num) {
        this.lineMode = num;
    }

    public final void setRightBadgeStyle(Integer num) {
        this.rightBadgeStyle = num;
    }

    public final void setRightBadgeTint(Integer num) {
        this.rightBadgeTint = num;
    }

    public final void setRightText(CharSequence charSequence) {
        this.rightText = charSequence;
    }

    public final void setShowBadge(Boolean bool) {
        this.showBadge = bool;
    }

    public final void setShowRightBadge(Boolean bool) {
        this.showRightBadge = bool;
    }

    public final void setSwitchChecked(Boolean bool) {
        this.switchChecked = bool;
    }

    public final void setSwitchCheckedChangeListener(StepOSListItem.OnSwitchCheckedChangeListener onSwitchCheckedChangeListener) {
        this.switchCheckedChangeListener = onSwitchCheckedChangeListener;
    }

    public final void setTitleEndText(CharSequence charSequence) {
        this.titleEndText = charSequence;
    }

    public final void setTrailingType(Integer num) {
        this.trailingType = num;
    }

    public final void setTrailingView(View view) {
        this.trailingView = view;
    }
}
