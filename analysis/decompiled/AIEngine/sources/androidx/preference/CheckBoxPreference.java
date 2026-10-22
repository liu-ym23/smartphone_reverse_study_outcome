package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    public final a W;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Boolean boolValueOf = Boolean.valueOf(z);
            CheckBoxPreference checkBoxPreference = CheckBoxPreference.this;
            if (checkBoxPreference.a(boolValueOf)) {
                checkBoxPreference.B(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        int iA = m0.g.a(context, R.attr.checkBoxPreferenceStyle, android.R.attr.checkBoxPreferenceStyle);
        super(context, attributeSet, iA);
        this.W = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f2428b, iA, 0);
        String string = typedArrayObtainStyledAttributes.getString(5);
        this.S = string == null ? typedArrayObtainStyledAttributes.getString(0) : string;
        if (this.R) {
            j();
        }
        String string2 = typedArrayObtainStyledAttributes.getString(4);
        this.T = string2 == null ? typedArrayObtainStyledAttributes.getString(1) : string2;
        if (!this.R) {
            j();
        }
        this.V = typedArrayObtainStyledAttributes.getBoolean(3, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.R);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.W);
        }
    }

    @Override // androidx.preference.Preference
    public final void n(h hVar) {
        super.n(hVar);
        D(hVar.a(android.R.id.checkbox));
        C(hVar.a(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void u(View view) {
        super.u(view);
        if (((AccessibilityManager) this.f2347a.getSystemService("accessibility")).isEnabled()) {
            D(view.findViewById(android.R.id.checkbox));
            C(view.findViewById(android.R.id.summary));
        }
    }
}
