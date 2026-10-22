package com.stepos.common.preference;

import H1.h;
import H1.i;
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
import androidx.preference.TwoStatePreference;
import androidx.preference.l;
import androidx.preference.o;
import com.stepos.common.widget.Switch;

/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: Y, reason: collision with root package name */
    private final a f13685Y;

    /* renamed from: Z, reason: collision with root package name */
    private CharSequence f13686Z;

    /* renamed from: a0, reason: collision with root package name */
    private CharSequence f13687a0;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
            if (SwitchPreferenceCompat.this.d(Boolean.valueOf(z5))) {
                SwitchPreferenceCompat.this.S0(z5);
            } else {
                compoundButton.setChecked(!z5);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f13685Y = new a();
        z0(i.f2305S);
        L0(i.f2315f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y0(View view) throws Resources.NotFoundException {
        boolean z5 = view instanceof SwitchCompat;
        if (z5) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Switch) {
            ((Switch) view).setOnCheckedChangeListener(this.f13685Y);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f11045T);
        }
        if (z5) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f13686Z);
            switchCompat.setTextOff(this.f13687a0);
            switchCompat.setOnCheckedChangeListener(this.f13685Y);
        }
    }

    private void Z0(View view) throws Resources.NotFoundException {
        if (((AccessibilityManager) l().getSystemService("accessibility")).isEnabled()) {
            View viewFindViewById = view.findViewById(o.f11148f);
            viewFindViewById.setEnabled(false);
            Y0(viewFindViewById);
            W0(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void W(l lVar) throws Resources.NotFoundException {
        super.W(lVar);
        Y0((Switch) ((ViewGroup) lVar.itemView).findViewById(h.f2266o0));
        X0(lVar);
    }

    @Override // androidx.preference.Preference
    protected void j0(View view) throws Resources.NotFoundException {
        super.j0(view);
        Z0(view);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
