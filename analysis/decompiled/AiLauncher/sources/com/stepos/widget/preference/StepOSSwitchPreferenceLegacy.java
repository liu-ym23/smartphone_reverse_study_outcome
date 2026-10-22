package com.stepos.widget.preference;

import Y8.t;
import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.list.PreferenceListItemBridgeState;
import com.stepos.widget.list.StepOSCardPosition;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.preference.StepOSPreference;
import com.stepos.widget.preference.StepOSSwitchPreferenceLegacy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001b\u0010\u0013J\u0015\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b$\u0010\u000fJ\u000f\u0010%\u001a\u00020\u0014H\u0016¢\u0006\u0004\b%\u0010\u0019J\u000f\u0010&\u001a\u00020\rH\u0014¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\r2\u0006\u0010!\u001a\u00020 H\u0015¢\u0006\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R$\u00106\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00148G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0019\"\u0004\b7\u0010\u0017R(\u0010;\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010\u0013R$\u0010>\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\u0019\"\u0004\b=\u0010\u0017R$\u0010C\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR*\u0010H\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010K\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010\u0019\"\u0004\bJ\u0010\u0017R$\u0010N\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010@\"\u0004\bM\u0010BR*\u0010Q\u001a\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010E\"\u0004\bP\u0010GR$\u0010T\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010@\"\u0004\bS\u0010BR$\u0010W\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010@\"\u0004\bV\u0010B¨\u0006X"}, d2 = {"Lcom/stepos/widget/preference/StepOSSwitchPreferenceLegacy;", "Landroid/preference/SwitchPreference;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Lcom/stepos/widget/list/StepOSListItem;", "row", "LY8/t;", "dispatchSwitchClick", "(Lcom/stepos/widget/list/StepOSListItem;)V", "", UxipConstants.f30680s, "setValue", "(Ljava/lang/CharSequence;)V", "", "checked", "setRowChecked", "(Z)V", "isRowChecked", "()Z", "text", "setTitleEndText", "Lcom/stepos/widget/preference/StepOSPreference$CardPosition;", "pos", "setCardPosition", "(Lcom/stepos/widget/preference/StepOSPreference$CardPosition;)V", "Landroid/view/View;", "view", "findListItem", "(Landroid/view/View;)Lcom/stepos/widget/list/StepOSListItem;", "onBindListItem", "isEnabled", "onClick", "()V", "onBindView", "(Landroid/view/View;)V", "Lcom/stepos/widget/list/PreferenceListItemBridgeState;", "bridge", "Lcom/stepos/widget/list/PreferenceListItemBridgeState;", "Lcom/stepos/widget/preference/StepOSPreferenceRowState;", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/widget/preference/StepOSPreferenceRowState;", "Lcom/stepos/widget/preference/SwitchPreferenceHapticBinding;", "switchHaptics", "Lcom/stepos/widget/preference/SwitchPreferenceHapticBinding;", "Lcom/stepos/widget/preference/SwitchPreferenceClickDispatch;", "switchClickDispatch", "Lcom/stepos/widget/preference/SwitchPreferenceClickDispatch;", "isSwitchHapticFeedbackEnabled", "setSwitchHapticFeedbackEnabled", "getRightText", "()Ljava/lang/CharSequence;", "setRightText", "rightText", "getShowBadge", "setShowBadge", "showBadge", "getBadgeStyle", "()I", "setBadgeStyle", "(I)V", "badgeStyle", "getBadgeTint", "()Ljava/lang/Integer;", "setBadgeTint", "(Ljava/lang/Integer;)V", "badgeTint", "getShowRightBadge", "setShowRightBadge", "showRightBadge", "getRightBadgeStyle", "setRightBadgeStyle", "rightBadgeStyle", "getRightBadgeTint", "setRightBadgeTint", "rightBadgeTint", "getLineMode", "setLineMode", "lineMode", "getIconStyle", "setIconStyle", "iconStyle", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSSwitchPreferenceLegacy extends SwitchPreference {
    private final PreferenceListItemBridgeState bridge;
    private final StepOSPreferenceRowState state;
    private final SwitchPreferenceClickDispatch switchClickDispatch;
    private final SwitchPreferenceHapticBinding switchHaptics;

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
    public StepOSSwitchPreferenceLegacy(Context context) {
        this(context, null, 0, 0, 14, null);
        p.i(context, "context");
    }

    private final void dispatchSwitchClick(final StepOSListItem row) {
        Intent intent;
        PreferenceGroup parent = getParent();
        while (parent != null && !(parent instanceof PreferenceScreen)) {
            parent = parent.getParent();
        }
        final PreferenceScreen preferenceScreen = parent instanceof PreferenceScreen ? (PreferenceScreen) parent : null;
        if (preferenceScreen != null) {
            final ListAdapter rootAdapter = preferenceScreen.getRootAdapter();
            int count = rootAdapter.getCount();
            for (final int i10 = 0; i10 < count; i10++) {
                if (rootAdapter.getItem(i10) == this) {
                    this.switchClickDispatch.dispatch(new InterfaceC5063a() { // from class: R7.g
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return StepOSSwitchPreferenceLegacy.dispatchSwitchClick$lambda$1(preferenceScreen, row, i10, rootAdapter);
                        }
                    });
                    return;
                }
            }
        }
        Preference.OnPreferenceClickListener onPreferenceClickListener = getOnPreferenceClickListener();
        if ((onPreferenceClickListener == null || !onPreferenceClickListener.onPreferenceClick(this)) && (intent = getIntent()) != null) {
            getContext().startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t dispatchSwitchClick$lambda$1(PreferenceScreen preferenceScreen, StepOSListItem stepOSListItem, int i10, ListAdapter listAdapter) {
        preferenceScreen.onItemClick(null, stepOSListItem, i10, listAdapter.getItemId(i10));
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindView$lambda$3(StepOSSwitchPreferenceLegacy stepOSSwitchPreferenceLegacy, StepOSListItem item, boolean z10) {
        p.i(item, "item");
        if (z10 == stepOSSwitchPreferenceLegacy.isChecked()) {
            return;
        }
        boolean z11 = item.isSwitchChangeFromUser$StepOSWidget_release() && stepOSSwitchPreferenceLegacy.isEnabled();
        if (!stepOSSwitchPreferenceLegacy.callChangeListener(Boolean.valueOf(z10))) {
            item.setSwitchChecked(stepOSSwitchPreferenceLegacy.isChecked());
            return;
        }
        stepOSSwitchPreferenceLegacy.setChecked(z10);
        if (z11) {
            stepOSSwitchPreferenceLegacy.dispatchSwitchClick(item);
        }
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

    @Override // android.preference.Preference
    public boolean isEnabled() {
        SwitchPreferenceClickDispatch switchPreferenceClickDispatch = this.switchClickDispatch;
        return (switchPreferenceClickDispatch != null && switchPreferenceClickDispatch.getSkipNextOnClick()) || super.isEnabled();
    }

    public final boolean isRowChecked() {
        return this.state.resolvedChecked(this.bridge);
    }

    public final boolean isSwitchHapticFeedbackEnabled() {
        return this.switchHaptics.getIsEnabled();
    }

    public void onBindListItem(StepOSListItem row) {
        p.i(row, "row");
    }

    @Override // android.preference.SwitchPreference, android.preference.Preference
    public void onBindView(View view) {
        p.i(view, "view");
        super.onBindView(view);
        StepOSListItem stepOSListItemFindListItem = findListItem(view);
        if (stepOSListItemFindListItem == null) {
            return;
        }
        this.state.setTrailingType(2);
        this.state.setSwitchChecked(Boolean.valueOf(isChecked()));
        this.state.setSwitchCheckedChangeListener(new StepOSListItem.OnSwitchCheckedChangeListener() { // from class: R7.f
            @Override // com.stepos.widget.list.StepOSListItem.OnSwitchCheckedChangeListener
            public final void onSwitchCheckedChanged(StepOSListItem stepOSListItem, boolean z10) {
                StepOSSwitchPreferenceLegacy.onBindView$lambda$3(this.f5557a, stepOSListItem, z10);
            }
        });
        StepOSPreferenceRowStateKt.bindPreferenceRow(stepOSListItemFindListItem, this.bridge, this.state, getTitle(), getSummary(), getIcon(), isEnabled(), false);
        stepOSListItemFindListItem.setDescendantFocusability(393216);
        stepOSListItemFindListItem.setPressFeedbackEnabled(false);
        this.switchHaptics.bind(stepOSListItemFindListItem);
        onBindListItem(stepOSListItemFindListItem);
    }

    @Override // android.preference.TwoStatePreference, android.preference.Preference
    public void onClick() {
        if (this.switchClickDispatch.consumeOnClick()) {
            return;
        }
        boolean zIsChecked = isChecked();
        super.onClick();
        if (zIsChecked != isChecked()) {
            this.switchHaptics.performRowClickFeedback();
        }
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
        StepOSCardPosition stepOSCardPosition;
        p.i(pos, "pos");
        StepOSPreferenceRowState stepOSPreferenceRowState = this.state;
        int i10 = WhenMappings.$EnumSwitchMapping$0[pos.ordinal()];
        if (i10 == 1) {
            stepOSCardPosition = StepOSCardPosition.NONE;
        } else if (i10 == 2) {
            stepOSCardPosition = StepOSCardPosition.SINGLE;
        } else if (i10 == 3) {
            stepOSCardPosition = StepOSCardPosition.FIRST;
        } else if (i10 == 4) {
            stepOSCardPosition = StepOSCardPosition.MIDDLE;
        } else {
            if (i10 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            stepOSCardPosition = StepOSCardPosition.LAST;
        }
        stepOSPreferenceRowState.setCardPosition(stepOSCardPosition);
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

    public final void setSwitchHapticFeedbackEnabled(boolean z10) {
        this.switchHaptics.setEnabled(z10);
    }

    public final void setTitleEndText(CharSequence text) {
        this.state.setTitleEndText(text);
        notifyChanged();
    }

    public final void setValue(CharSequence value) {
        setRightText(value);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSwitchPreferenceLegacy(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSwitchPreferenceLegacy(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSSwitchPreferenceLegacy(Context context, AttributeSet attributeSet, int i10, int i11, int i12, i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposPreferenceStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_Preference : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSSwitchPreferenceLegacy(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        p.i(context, "context");
        this.bridge = PreferenceListItemBridgeState.INSTANCE.parse$StepOSWidget_release(context, attributeSet, i10, i11);
        StepOSPreferenceRowState stepOSPreferenceRowState = new StepOSPreferenceRowState();
        stepOSPreferenceRowState.setTrailingType(2);
        this.state = stepOSPreferenceRowState;
        this.switchHaptics = new SwitchPreferenceHapticBinding();
        this.switchClickDispatch = new SwitchPreferenceClickDispatch();
        setLayoutResource(R.layout.stepos_preference_bridge);
    }
}
