package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;

/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* renamed from: Y, reason: collision with root package name */
    private final a f10938Y;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
            if (CheckBoxPreference.this.d(Boolean.valueOf(z5))) {
                CheckBoxPreference.this.S0(z5);
            } else {
                compoundButton.setChecked(!z5);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y0(View view) {
        boolean z5 = view instanceof CompoundButton;
        if (z5) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f11045T);
        }
        if (z5) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f10938Y);
        }
    }

    private void Z0(View view) {
        if (((AccessibilityManager) l().getSystemService("accessibility")).isEnabled()) {
            Y0(view.findViewById(R.id.checkbox));
            W0(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void W(l lVar) {
        super.W(lVar);
        Y0(lVar.a(R.id.checkbox));
        X0(lVar);
    }

    @Override // androidx.preference.Preference
    protected void j0(View view) {
        super.j0(view);
        Z0(view);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f10938Y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f11217c, i5, i6);
        V0(androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11235i, s.f11220d));
        U0(androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11232h, s.f11223e));
        T0(androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, s.f11229g, s.f11226f, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.k.a(context, m.f11130a, R.attr.checkBoxPreferenceStyle));
    }
}
