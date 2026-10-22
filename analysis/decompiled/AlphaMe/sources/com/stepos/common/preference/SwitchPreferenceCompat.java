package com.stepos.common.preference;

import Z2.I;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.preference.K;
import androidx.preference.L;
import androidx.preference.TwoStatePreference;
import com.stepos.alphame.R;
import com.stepos.common.widget.Switch;
import k2.C0678a;

/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: S, reason: collision with root package name */
    public final C0678a f11393S;
    public final CharSequence T;

    /* renamed from: U, reason: collision with root package name */
    public final CharSequence f11394U;

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4, 0);
        this.f11393S = new C0678a(this);
        this.f4068E = R.layout.stepos_preference;
        this.f4069F = R.layout.mc_preference_widget_switch;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B(View view) throws Resources.NotFoundException {
        boolean z4 = view instanceof SwitchCompat;
        if (z4) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        boolean z5 = view instanceof Switch;
        C0678a c0678a = this.f11393S;
        if (z5) {
            ((Switch) view).setOnCheckedChangeListener(c0678a);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f4128N);
        }
        if (z4) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.T);
            switchCompat.setTextOff(this.f11394U);
            switchCompat.setOnCheckedChangeListener(c0678a);
        }
    }

    @Override // androidx.preference.Preference
    public final void l(K k4) throws Resources.NotFoundException {
        super.l(k4);
        B((Switch) ((ViewGroup) k4.itemView).findViewById(R.id.switchWidget));
        A(k4.a(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void s(View view) throws Resources.NotFoundException {
        super.s(view);
        if (((AccessibilityManager) this.f4077a.getSystemService("accessibility")).isEnabled()) {
            View viewFindViewById = view.findViewById(R.id.switchWidget);
            viewFindViewById.setEnabled(false);
            B(viewFindViewById);
            A(view.findViewById(android.R.id.summary));
        }
    }

    public SwitchPreferenceCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f11393S = new C0678a(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L.f4053m, i4, i5);
        this.f4129O = I.s(typedArrayObtainStyledAttributes, 7, 0);
        if (this.f4128N) {
            h();
        }
        String string = typedArrayObtainStyledAttributes.getString(6);
        this.f4130P = string == null ? typedArrayObtainStyledAttributes.getString(1) : string;
        if (!this.f4128N) {
            h();
        }
        String string2 = typedArrayObtainStyledAttributes.getString(9);
        this.T = string2 == null ? typedArrayObtainStyledAttributes.getString(3) : string2;
        h();
        String string3 = typedArrayObtainStyledAttributes.getString(8);
        this.f11394U = string3 == null ? typedArrayObtainStyledAttributes.getString(4) : string3;
        h();
        this.f4132R = typedArrayObtainStyledAttributes.getBoolean(5, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchPreferenceCompat(Context context) {
        this(context, null);
    }
}
