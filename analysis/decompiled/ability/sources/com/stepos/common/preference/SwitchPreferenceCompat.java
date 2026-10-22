package com.stepos.common.preference;

import Y4.a;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.TwoStatePreference;
import com.stepos.ability.R;
import com.stepos.common.widget.Switch;

/* loaded from: classes3.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: a, reason: collision with root package name */
    public final a f3600a;

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3600a = new a(this, 0);
        setLayoutResource(R.layout.stepos_preference);
        setWidgetLayoutResource(R.layout.mc_preference_widget_switch);
    }

    @Override // androidx.preference.Preference
    public final void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) throws Resources.NotFoundException {
        super.onBindViewHolder(preferenceViewHolder);
        syncSwitchView((Switch) ((ViewGroup) preferenceViewHolder.itemView).findViewById(R.id.switchWidget));
        syncSummaryView(preferenceViewHolder);
    }

    @Override // androidx.preference.Preference
    public final void performClick(View view) throws Resources.NotFoundException {
        super.performClick(view);
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            View viewFindViewById = view.findViewById(androidx.preference.R.id.switchWidget);
            viewFindViewById.setEnabled(false);
            syncSwitchView(viewFindViewById);
            syncSummaryView(view.findViewById(android.R.id.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void syncSwitchView(View view) throws Resources.NotFoundException {
        boolean z10 = view instanceof SwitchCompat;
        if (z10) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        boolean z11 = view instanceof Switch;
        a aVar = this.f3600a;
        if (z11) {
            ((Switch) view).setOnCheckedChangeListener(aVar);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.mChecked);
        }
        if (z10) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(null);
            switchCompat.setTextOff(null);
            switchCompat.setOnCheckedChangeListener(aVar);
        }
    }
}
