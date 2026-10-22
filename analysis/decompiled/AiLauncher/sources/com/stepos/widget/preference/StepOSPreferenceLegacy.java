package com.stepos.widget.preference;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.list.PreferenceListItemBridgeState;
import com.stepos.widget.list.StepOSCardPosition;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.preference.StepOSPreference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001b\u0010\u0013J!\u0010\u001e\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010$¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u000b¢\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00112\u0006\u0010-\u001a\u00020*H\u0014¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 H\u0015¢\u0006\u0004\b0\u0010#R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R(\u0010:\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010\u0013R$\u0010?\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010B\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010\u0019\"\u0004\bA\u0010\u0017R$\u0010E\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bC\u0010\u0019\"\u0004\bD\u0010\u0017R$\u0010H\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u0010<\"\u0004\bG\u0010>R*\u0010M\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010P\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\u0019\"\u0004\bO\u0010\u0017R$\u0010S\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010<\"\u0004\bR\u0010>R*\u0010V\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010J\"\u0004\bU\u0010LR$\u0010Y\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010<\"\u0004\bX\u0010>R$\u0010\\\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010<\"\u0004\b[\u0010>¨\u0006]"}, d2 = {"Lcom/stepos/widget/preference/StepOSPreferenceLegacy;", "Landroid/preference/Preference;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Lcom/stepos/widget/preference/StepOSPreference$CardPosition;", "Lcom/stepos/widget/list/StepOSCardPosition;", "toShared", "(Lcom/stepos/widget/preference/StepOSPreference$CardPosition;)Lcom/stepos/widget/list/StepOSCardPosition;", "", UxipConstants.f30680s, "LY8/t;", "setValue", "(Ljava/lang/CharSequence;)V", "", "checked", "setRowChecked", "(Z)V", "isRowChecked", "()Z", "text", "setTitleEndText", "Landroid/view/View$OnClickListener;", "listener", "setTrailingButton", "(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)V", "Landroid/view/View;", "view", "setTrailingView", "(Landroid/view/View;)V", "Lcom/stepos/widget/list/StepOSListItem$OnSwitchCheckedChangeListener;", "setOnSwitchCheckedChangeListener", "(Lcom/stepos/widget/list/StepOSListItem$OnSwitchCheckedChangeListener;)V", "pos", "setCardPosition", "(Lcom/stepos/widget/preference/StepOSPreference$CardPosition;)V", "Lcom/stepos/widget/list/StepOSListItem;", "findListItem", "(Landroid/view/View;)Lcom/stepos/widget/list/StepOSListItem;", "row", "onBindListItem", "(Lcom/stepos/widget/list/StepOSListItem;)V", "onBindView", "Lcom/stepos/widget/list/PreferenceListItemBridgeState;", "bridge", "Lcom/stepos/widget/list/PreferenceListItemBridgeState;", "Lcom/stepos/widget/preference/StepOSPreferenceRowState;", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/widget/preference/StepOSPreferenceRowState;", "getRightText", "()Ljava/lang/CharSequence;", "setRightText", "rightText", "getTrailingType", "()I", "setTrailingType", "(I)V", "trailingType", "getSwitchChecked", "setSwitchChecked", "switchChecked", "getShowBadge", "setShowBadge", "showBadge", "getBadgeStyle", "setBadgeStyle", "badgeStyle", "getBadgeTint", "()Ljava/lang/Integer;", "setBadgeTint", "(Ljava/lang/Integer;)V", "badgeTint", "getShowRightBadge", "setShowRightBadge", "showRightBadge", "getRightBadgeStyle", "setRightBadgeStyle", "rightBadgeStyle", "getRightBadgeTint", "setRightBadgeTint", "rightBadgeTint", "getLineMode", "setLineMode", "lineMode", "getIconStyle", "setIconStyle", "iconStyle", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSPreferenceLegacy extends Preference {
    private final PreferenceListItemBridgeState bridge;
    private final StepOSPreferenceRowState state;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StepOSPreference.CardPosition.values().length];
            try {
                iArr[StepOSPreference.CardPosition.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StepOSPreference.CardPosition.SINGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StepOSPreference.CardPosition.FIRST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StepOSPreference.CardPosition.MIDDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StepOSPreference.CardPosition.LAST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSPreferenceLegacy(Context context) {
        this(context, null, 0, 0, 14, null);
        p.i(context, "context");
    }

    private final StepOSCardPosition toShared(StepOSPreference.CardPosition cardPosition) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[cardPosition.ordinal()];
        if (i10 == 1) {
            return StepOSCardPosition.NONE;
        }
        if (i10 == 2) {
            return StepOSCardPosition.SINGLE;
        }
        if (i10 == 3) {
            return StepOSCardPosition.FIRST;
        }
        if (i10 == 4) {
            return StepOSCardPosition.MIDDLE;
        }
        if (i10 == 5) {
            return StepOSCardPosition.LAST;
        }
        throw new NoWhenBranchMatchedException();
    }

    public StepOSListItem findListItem(View view) {
        p.i(view, "view");
        StepOSListItem stepOSListItem = view instanceof StepOSListItem ? (StepOSListItem) view : null;
        return stepOSListItem == null ? (StepOSListItem) view.findViewById(R.id.stepos_preference_bridge_row) : stepOSListItem;
    }

    public final int getBadgeStyle() {
        return this.state.resolvedBadgeStyle(this.bridge);
    }

    public final Integer getBadgeTint() {
        return this.state.resolvedBadgeTint(this.bridge);
    }

    public final int getIconStyle() {
        return this.state.resolvedIconStyle(this.bridge);
    }

    public final int getLineMode() {
        return this.state.resolvedLineMode(this.bridge);
    }

    public final int getRightBadgeStyle() {
        return this.state.resolvedRightBadgeStyle(this.bridge);
    }

    public final Integer getRightBadgeTint() {
        return this.state.resolvedRightBadgeTint(this.bridge);
    }

    public final CharSequence getRightText() {
        return this.state.resolvedRightText(this.bridge);
    }

    public final boolean getShowBadge() {
        return this.state.resolvedShowBadge(this.bridge);
    }

    public final boolean getShowRightBadge() {
        return this.state.resolvedShowRightBadge(this.bridge);
    }

    public final boolean getSwitchChecked() {
        return this.state.resolvedSwitchChecked(this.bridge);
    }

    public final int getTrailingType() {
        return this.state.resolvedTrailingType(this.bridge);
    }

    public final boolean isRowChecked() {
        return this.state.resolvedChecked(this.bridge);
    }

    public void onBindListItem(StepOSListItem row) {
        p.i(row, "row");
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        p.i(view, "view");
        super.onBindView(view);
        StepOSListItem stepOSListItemFindListItem = findListItem(view);
        if (stepOSListItemFindListItem == null) {
            return;
        }
        StepOSPreferenceRowStateKt.bindPreferenceRow(stepOSListItemFindListItem, this.bridge, this.state, getTitle(), getSummary(), getIcon(), isEnabled(), false);
        onBindListItem(stepOSListItemFindListItem);
    }

    public final void setBadgeStyle(int i10) {
        this.state.setBadgeStyle(Integer.valueOf(i10));
        notifyChanged();
    }

    public final void setBadgeTint(Integer num) {
        this.state.setBadgeTint(num);
        notifyChanged();
    }

    public final void setCardPosition(StepOSPreference.CardPosition pos) {
        p.i(pos, "pos");
        this.state.setCardPosition(toShared(pos));
        notifyChanged();
    }

    public final void setIconStyle(int i10) {
        this.state.setIconStyle(Integer.valueOf(i10));
        notifyChanged();
    }

    public final void setLineMode(int i10) {
        this.state.setLineMode(Integer.valueOf(i10));
        notifyChanged();
    }

    public final void setOnSwitchCheckedChangeListener(StepOSListItem.OnSwitchCheckedChangeListener listener) {
        this.state.setSwitchCheckedChangeListener(listener);
        notifyChanged();
    }

    public final void setRightBadgeStyle(int i10) {
        this.state.setRightBadgeStyle(Integer.valueOf(i10));
        notifyChanged();
    }

    public final void setRightBadgeTint(Integer num) {
        this.state.setRightBadgeTint(num);
        notifyChanged();
    }

    public final void setRightText(CharSequence charSequence) {
        this.state.setRightText(charSequence);
        notifyChanged();
    }

    public final void setRowChecked(boolean checked) {
        this.state.setChecked(Boolean.valueOf(checked));
        notifyChanged();
    }

    public final void setShowBadge(boolean z10) {
        this.state.setShowBadge(Boolean.valueOf(z10));
        notifyChanged();
    }

    public final void setShowRightBadge(boolean z10) {
        this.state.setShowRightBadge(Boolean.valueOf(z10));
        notifyChanged();
    }

    public final void setSwitchChecked(boolean z10) {
        this.state.setSwitchChecked(Boolean.valueOf(z10));
        notifyChanged();
    }

    public final void setTitleEndText(CharSequence text) {
        this.state.setTitleEndText(text);
        notifyChanged();
    }

    public final void setTrailingButton(CharSequence text, View.OnClickListener listener) {
        this.state.setButtonText(text);
        this.state.setButtonClickListener(listener);
        this.state.setTrailingType(3);
        notifyChanged();
    }

    public final void setTrailingType(int i10) {
        this.state.setTrailingType(Integer.valueOf(i10));
        notifyChanged();
    }

    public final void setTrailingView(View view) {
        this.state.setTrailingView(view);
        this.state.setTrailingType(4);
        notifyChanged();
    }

    public final void setValue(CharSequence value) {
        setRightText(value);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSPreferenceLegacy(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSPreferenceLegacy(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSPreferenceLegacy(Context context, AttributeSet attributeSet, int i10, int i11, int i12, i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposPreferenceStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_Preference : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSPreferenceLegacy(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        p.i(context, "context");
        this.bridge = PreferenceListItemBridgeState.INSTANCE.parse$StepOSWidget_release(context, attributeSet, i10, i11);
        this.state = new StepOSPreferenceRowState();
        setLayoutResource(R.layout.stepos_preference_bridge);
    }
}
