package androidx.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
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
            SwitchPreferenceCompat switchPreferenceCompat = SwitchPreferenceCompat.this;
            if (switchPreferenceCompat.a(boolValueOf)) {
                switchPreferenceCompat.B(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.switchPreferenceCompatStyle);
        this.W = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f2438m, R.attr.switchPreferenceCompatStyle, 0);
        String string = typedArrayObtainStyledAttributes.getString(7);
        this.S = string == null ? typedArrayObtainStyledAttributes.getString(0) : string;
        if (this.R) {
            j();
        }
        String string2 = typedArrayObtainStyledAttributes.getString(6);
        this.T = string2 == null ? typedArrayObtainStyledAttributes.getString(1) : string2;
        if (!this.R) {
            j();
        }
        String string3 = typedArrayObtainStyledAttributes.getString(9);
        this.X = string3 == null ? typedArrayObtainStyledAttributes.getString(3) : string3;
        j();
        String string4 = typedArrayObtainStyledAttributes.getString(8);
        this.Y = string4 == null ? typedArrayObtainStyledAttributes.getString(4) : string4;
        j();
        this.V = typedArrayObtainStyledAttributes.getBoolean(5, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D(View view) throws Resources.NotFoundException {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.R);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.X);
            switchCompat.setTextOff(this.Y);
            switchCompat.setOnCheckedChangeListener(this.W);
        }
    }

    @Override // androidx.preference.Preference
    public void n(h hVar) throws Resources.NotFoundException {
        super.n(hVar);
        D(hVar.a(R.id.switchWidget));
        C(hVar.a(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void u(View view) throws Resources.NotFoundException {
        super.u(view);
        if (((AccessibilityManager) this.f2347a.getSystemService("accessibility")).isEnabled()) {
            D(view.findViewById(R.id.switchWidget));
            C(view.findViewById(android.R.id.summary));
        }
    }
}
