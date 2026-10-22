package com.stepos.common.preference;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.preference.R$id;
import androidx.preference.TwoStatePreference;
import androidx.preference.l;
import com.stepos.common.R$layout;
import com.stepos.common.widget.Switch;

/* loaded from: classes3.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    private boolean isUserDarkStyle;
    private final a mListener;
    private CharSequence mSwitchOff;
    private CharSequence mSwitchOn;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (SwitchPreferenceCompat.this.callChangeListener(Boolean.valueOf(z10))) {
                SwitchPreferenceCompat.this.setChecked(z10);
            } else {
                compoundButton.setChecked(!z10);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mListener = new a();
        setLayoutResource(R$layout.stepos_preference);
        setWidgetLayoutResource(R$layout.mc_preference_widget_switch);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void syncSwitchView(View view) throws Resources.NotFoundException {
        boolean z10 = view instanceof SwitchCompat;
        if (z10) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Switch) {
            ((Switch) view).setOnCheckedChangeListener(this.mListener);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.mChecked);
        }
        if (z10) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.mSwitchOn);
            switchCompat.setTextOff(this.mSwitchOff);
            switchCompat.setOnCheckedChangeListener(this.mListener);
        }
    }

    private void syncViewIfAccessibilityEnabled(View view) throws Resources.NotFoundException {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            View viewFindViewById = view.findViewById(R$id.switchWidget);
            viewFindViewById.setEnabled(false);
            syncSwitchView(viewFindViewById);
            syncSummaryView(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) throws Resources.NotFoundException {
        super.onBindViewHolder(lVar);
        syncSwitchView((Switch) ((ViewGroup) lVar.itemView).findViewById(com.stepos.common.R$id.switchWidget));
        syncSummaryView(lVar);
    }

    @Override // androidx.preference.Preference
    public void performClick(View view) throws Resources.NotFoundException {
        super.performClick(view);
        syncViewIfAccessibilityEnabled(view);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
