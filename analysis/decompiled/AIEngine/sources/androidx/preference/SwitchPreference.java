package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    public final a W;
    public final String X;
    public final String Y;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Boolean boolValueOf = Boolean.valueOf(z);
            SwitchPreference switchPreference = SwitchPreference.this;
            if (switchPreference.a(boolValueOf)) {
                switchPreference.B(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchPreference(Context context, AttributeSet attributeSet) {
        int iA = m0.g.a(context, R.attr.switchPreferenceStyle, android.R.attr.switchPreferenceStyle);
        super(context, attributeSet, iA);
        this.W = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f2437l, iA, 0);
        String string = typedArrayObtainStyledAttributes.getString(10);
        this.S = string == null ? typedArrayObtainStyledAttributes.getString(0) : string;
        if (this.R) {
            j();
        }
        String string2 = typedArrayObtainStyledAttributes.getString(9);
        this.T = string2 == null ? typedArrayObtainStyledAttributes.getString(1) : string2;
        if (!this.R) {
            j();
        }
        String string3 = typedArrayObtainStyledAttributes.getString(12);
        this.X = string3 == null ? typedArrayObtainStyledAttributes.getString(3) : string3;
        j();
        String string4 = typedArrayObtainStyledAttributes.getString(11);
        this.Y = string4 == null ? typedArrayObtainStyledAttributes.getString(4) : string4;
        j();
        this.V = typedArrayObtainStyledAttributes.getBoolean(5, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.R);
        }
        if (z) {
            Switch r42 = (Switch) view;
            r42.setTextOn(this.X);
            r42.setTextOff(this.Y);
            r42.setOnCheckedChangeListener(this.W);
        }
    }

    @Override // androidx.preference.Preference
    public final void n(h hVar) {
        super.n(hVar);
        D(hVar.a(android.R.id.switch_widget));
        C(hVar.a(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void u(View view) {
        super.u(view);
        if (((AccessibilityManager) this.f2347a.getSystemService("accessibility")).isEnabled()) {
            D(view.findViewById(android.R.id.switch_widget));
            C(view.findViewById(android.R.id.summary));
        }
    }
}
