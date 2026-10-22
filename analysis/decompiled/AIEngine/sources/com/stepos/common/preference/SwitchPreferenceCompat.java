package com.stepos.common.preference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.preference.TwoStatePreference;
import androidx.preference.h;
import com.stepos.aiengine.R;
import com.stepos.common.widget.Switch;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    public final a W;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Boolean boolValueOf = Boolean.valueOf(z);
            SwitchPreferenceCompat switchPreferenceCompat = SwitchPreferenceCompat.this;
            if (switchPreferenceCompat.a(boolValueOf)) {
                switchPreferenceCompat.B(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.W = new a();
        this.I = R.layout.stepos_preference;
        this.J = R.layout.mc_preference_widget_switch;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D(View view) throws Resources.NotFoundException {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        boolean z3 = view instanceof Switch;
        a aVar = this.W;
        if (z3) {
            ((Switch) view).setOnCheckedChangeListener(aVar);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.R);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(null);
            switchCompat.setTextOff(null);
            switchCompat.setOnCheckedChangeListener(aVar);
        }
    }

    @Override // androidx.preference.Preference
    public final void n(h hVar) throws Resources.NotFoundException {
        super.n(hVar);
        D((Switch) ((ViewGroup) hVar.itemView).findViewById(R.id.switchWidget));
        C(hVar.a(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void u(View view) throws Resources.NotFoundException {
        super.u(view);
        if (((AccessibilityManager) this.f2347a.getSystemService("accessibility")).isEnabled()) {
            View viewFindViewById = view.findViewById(R.id.switchWidget);
            viewFindViewById.setEnabled(false);
            D(viewFindViewById);
            C(view.findViewById(android.R.id.summary));
        }
    }
}
