package com.stepos.widget.preference;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.widget.R;
import com.stepos.widget.list.PreferenceListItemBridgeState;
import com.stepos.widget.list.StepOSCardPosition;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.preference.StepOSPreferenceRowStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.d;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aW\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001aE\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a/\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/widget/list/StepOSListItem;", "row", "Lcom/stepos/widget/list/PreferenceListItemBridgeState;", "bridge", "Lcom/stepos/widget/preference/StepOSPreferenceRowState;", VoiceWakeupReceiver.EXTRA_STATE, "", "frameworkTitle", "frameworkSummary", "Landroid/graphics/drawable/Drawable;", "frameworkIcon", "", d.EXTRA_ENABLED, "manageItemClick", "LY8/t;", "bindPreferenceRow", "(Lcom/stepos/widget/list/StepOSListItem;Lcom/stepos/widget/list/PreferenceListItemBridgeState;Lcom/stepos/widget/preference/StepOSPreferenceRowState;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;ZZ)V", "applyRuntimeOverrides", "(Lcom/stepos/widget/list/StepOSListItem;Lcom/stepos/widget/preference/StepOSPreferenceRowState;)V", "applyIconChromeRules", "(Lcom/stepos/widget/list/StepOSListItem;Lcom/stepos/widget/list/PreferenceListItemBridgeState;)V", "bindFrameworkFields", "(Lcom/stepos/widget/list/StepOSListItem;Lcom/stepos/widget/list/PreferenceListItemBridgeState;Lcom/stepos/widget/preference/StepOSPreferenceRowState;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;)V", "applyTrailing", "(Lcom/stepos/widget/list/StepOSListItem;Lcom/stepos/widget/list/PreferenceListItemBridgeState;Lcom/stepos/widget/preference/StepOSPreferenceRowState;Z)V", "Lcom/stepos/widget/list/StepOSCardPosition;", "pos", "applyCard", "(Lcom/stepos/widget/list/StepOSListItem;Lcom/stepos/widget/list/StepOSCardPosition;)V", "StepOSWidget_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSPreferenceRowStateKt {
    private static final void applyCard(StepOSListItem stepOSListItem, StepOSCardPosition stepOSCardPosition) throws Resources.NotFoundException {
        if (stepOSCardPosition == StepOSCardPosition.NONE) {
            StepOSListItem.applyFlatChrome$default(stepOSListItem, false, 1, null);
            return;
        }
        float dimension = stepOSListItem.getResources().getDimension(R.dimen.stepos_corner_radius_level12);
        int dimensionPixelSize = stepOSListItem.getResources().getDimensionPixelSize(R.dimen.stepos_list_group_padding_vertical);
        StepOSListItem.applyCardChrome$default(stepOSListItem, stepOSCardPosition.cornerRadii(dimension), 0, stepOSCardPosition.showsDivider(), stepOSCardPosition.hasTopOutset() ? dimensionPixelSize : 0, stepOSCardPosition.hasBottomOutset() ? dimensionPixelSize : 0, 2, null);
    }

    private static final void applyIconChromeRules(StepOSListItem stepOSListItem, PreferenceListItemBridgeState preferenceListItemBridgeState) {
        int iconStyle = stepOSListItem.getIconStyle();
        boolean iconBackgroundExplicit = preferenceListItemBridgeState.getIconBackgroundExplicit();
        boolean iconTintExplicit = preferenceListItemBridgeState.getIconTintExplicit();
        if (iconStyle != 1) {
            if ((iconStyle != 2 && iconStyle != 3 && iconStyle != 4 && iconStyle != 5) || iconBackgroundExplicit) {
                return;
            }
        } else if (iconBackgroundExplicit || iconTintExplicit) {
            return;
        }
        stepOSListItem.setIconTint(null);
        stepOSListItem.setIconBackgroundColor(null);
    }

    private static final void applyRuntimeOverrides(StepOSListItem stepOSListItem, StepOSPreferenceRowState stepOSPreferenceRowState) {
        Integer iconStyle = stepOSPreferenceRowState.getIconStyle();
        if (iconStyle != null) {
            stepOSListItem.setIconStyle(iconStyle.intValue());
        }
        Boolean showBadge = stepOSPreferenceRowState.getShowBadge();
        if (showBadge != null) {
            stepOSListItem.setShowBadge(showBadge.booleanValue());
        }
        Integer badgeStyle = stepOSPreferenceRowState.getBadgeStyle();
        if (badgeStyle != null) {
            stepOSListItem.setBadgeStyle(badgeStyle.intValue());
        }
        Integer badgeTint = stepOSPreferenceRowState.getBadgeTint();
        if (badgeTint != null) {
            stepOSListItem.setBadgeTint(Integer.valueOf(badgeTint.intValue()));
        }
        Boolean showRightBadge = stepOSPreferenceRowState.getShowRightBadge();
        if (showRightBadge != null) {
            stepOSListItem.setShowRightBadge(showRightBadge.booleanValue());
        }
        Integer rightBadgeStyle = stepOSPreferenceRowState.getRightBadgeStyle();
        if (rightBadgeStyle != null) {
            stepOSListItem.setRightBadgeStyle(rightBadgeStyle.intValue());
        }
        Integer rightBadgeTint = stepOSPreferenceRowState.getRightBadgeTint();
        if (rightBadgeTint != null) {
            stepOSListItem.setRightBadgeTint(Integer.valueOf(rightBadgeTint.intValue()));
        }
        CharSequence titleEndText = stepOSPreferenceRowState.getTitleEndText();
        if (titleEndText != null) {
            stepOSListItem.setTitleEndText(titleEndText);
        }
        Integer lineMode = stepOSPreferenceRowState.getLineMode();
        if (lineMode != null) {
            stepOSListItem.setLineMode(lineMode.intValue());
        }
    }

    private static final void applyTrailing(StepOSListItem stepOSListItem, PreferenceListItemBridgeState preferenceListItemBridgeState, final StepOSPreferenceRowState stepOSPreferenceRowState, boolean z10) throws Resources.NotFoundException {
        int iResolvedTrailingType = stepOSPreferenceRowState.resolvedTrailingType(preferenceListItemBridgeState);
        if (iResolvedTrailingType != 4) {
            stepOSListItem.setTrailingView(null);
        }
        stepOSListItem.setTrailingType(iResolvedTrailingType);
        if (iResolvedTrailingType == 0) {
            stepOSListItem.setShowAccessory(false);
            stepOSListItem.setOnSwitchCheckedChangeListener(null);
            if (z10) {
                stepOSListItem.setOnItemClickListener(stepOSPreferenceRowState.getItemClickListener());
                return;
            }
            return;
        }
        if (iResolvedTrailingType == 2) {
            stepOSListItem.setShowAccessory(false);
            stepOSListItem.setOnSwitchCheckedChangeListener(null);
            Boolean switchChecked = stepOSPreferenceRowState.getSwitchChecked();
            if (switchChecked != null) {
                stepOSListItem.setSwitchChecked(switchChecked.booleanValue());
            }
            StepOSListItem.OnSwitchCheckedChangeListener switchCheckedChangeListener = stepOSPreferenceRowState.getSwitchCheckedChangeListener();
            if (switchCheckedChangeListener == null) {
                switchCheckedChangeListener = new StepOSListItem.OnSwitchCheckedChangeListener() { // from class: R7.a
                    @Override // com.stepos.widget.list.StepOSListItem.OnSwitchCheckedChangeListener
                    public final void onSwitchCheckedChanged(StepOSListItem stepOSListItem2, boolean z11) {
                        StepOSPreferenceRowStateKt.applyTrailing$lambda$10(stepOSPreferenceRowState, stepOSListItem2, z11);
                    }
                };
            }
            stepOSListItem.setOnSwitchCheckedChangeListener(switchCheckedChangeListener);
            if (z10) {
                stepOSListItem.setOnItemClickListener(null);
                return;
            }
            return;
        }
        if (iResolvedTrailingType == 3) {
            stepOSListItem.setShowAccessory(false);
            stepOSListItem.setOnSwitchCheckedChangeListener(null);
            if (stepOSPreferenceRowState.getButtonText() != null || stepOSPreferenceRowState.getButtonClickListener() != null) {
                stepOSListItem.setTrailingButton(stepOSPreferenceRowState.getButtonText(), stepOSPreferenceRowState.getButtonClickListener());
            }
            if (z10) {
                stepOSListItem.setOnItemClickListener(null);
                return;
            }
            return;
        }
        if (iResolvedTrailingType != 4) {
            stepOSListItem.setShowAccessory(true);
            stepOSListItem.setOnSwitchCheckedChangeListener(null);
            if (z10) {
                stepOSListItem.setOnItemClickListener(stepOSPreferenceRowState.getItemClickListener());
                return;
            }
            return;
        }
        stepOSListItem.setOnSwitchCheckedChangeListener(null);
        View trailingView = stepOSPreferenceRowState.getTrailingView();
        if (trailingView != null) {
            stepOSListItem.setTrailingView(trailingView);
        }
        if (z10) {
            stepOSListItem.setOnItemClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyTrailing$lambda$10(StepOSPreferenceRowState stepOSPreferenceRowState, StepOSListItem stepOSListItem, boolean z10) {
        p.i(stepOSListItem, "<unused var>");
        stepOSPreferenceRowState.setSwitchChecked(Boolean.valueOf(z10));
    }

    private static final void bindFrameworkFields(StepOSListItem stepOSListItem, PreferenceListItemBridgeState preferenceListItemBridgeState, StepOSPreferenceRowState stepOSPreferenceRowState, CharSequence charSequence, CharSequence charSequence2, Drawable drawable) {
        if (charSequence != null && charSequence.length() != 0) {
            stepOSListItem.setTitle(charSequence);
        }
        if (charSequence2 == null || charSequence2.length() == 0) {
            CharSequence subtitle = preferenceListItemBridgeState.getSubtitle();
            charSequence2 = (subtitle == null || subtitle.length() == 0) ? null : preferenceListItemBridgeState.getSubtitle();
        }
        stepOSListItem.setSubtitle(charSequence2);
        stepOSListItem.setValueText(stepOSPreferenceRowState.resolvedRightText(preferenceListItemBridgeState));
        if (drawable != null) {
            stepOSListItem.setIcon(drawable);
            stepOSListItem.setShowIcon(true);
        } else if (preferenceListItemBridgeState.getIconDrawableRes() != 0) {
            stepOSListItem.setShowIcon(preferenceListItemBridgeState.getIconVisible());
        } else {
            stepOSListItem.setIcon((Drawable) null);
            stepOSListItem.setShowIcon(false);
        }
    }

    public static final void bindPreferenceRow(StepOSListItem row, PreferenceListItemBridgeState bridge, StepOSPreferenceRowState state, CharSequence charSequence, CharSequence charSequence2, Drawable drawable, boolean z10, boolean z11) {
        p.i(row, "row");
        p.i(bridge, "bridge");
        p.i(state, "state");
        row.reset();
        row.applyPreferenceBridgeState$StepOSWidget_release(bridge);
        applyRuntimeOverrides(row, state);
        applyIconChromeRules(row, bridge);
        bindFrameworkFields(row, bridge, state, charSequence, charSequence2, drawable);
        row.syncIconAfterExternalDrawable$StepOSWidget_release();
        applyTrailing(row, bridge, state, z11);
        row.syncContentAfterBridge$StepOSWidget_release();
        row.setEnabled(z10);
        row.setPressScaleEnabled(false);
        applyCard(row, state.getCardPosition());
        row.setChecked(state.resolvedChecked(bridge));
    }
}
