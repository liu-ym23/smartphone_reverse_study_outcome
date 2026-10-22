package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* renamed from: Y, reason: collision with root package name */
    private final a f11037Y;

    /* renamed from: Z, reason: collision with root package name */
    private CharSequence f11038Z;

    /* renamed from: a0, reason: collision with root package name */
    private CharSequence f11039a0;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
            if (SwitchPreference.this.d(Boolean.valueOf(z5))) {
                SwitchPreference.this.S0(z5);
            } else {
                compoundButton.setChecked(!z5);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f11037Y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f11188O0, i5, i6);
        V0(androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11204W0, s.f11190P0));
        U0(androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11202V0, s.f11192Q0));
        Z0(androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11208Y0, s.f11196S0));
        Y0(androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11206X0, s.f11198T0));
        T0(androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, s.f11200U0, s.f11194R0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a1(View view) {
        boolean z5 = view instanceof Switch;
        if (z5) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f11045T);
        }
        if (z5) {
            Switch r42 = (Switch) view;
            r42.setTextOn(this.f11038Z);
            r42.setTextOff(this.f11039a0);
            r42.setOnCheckedChangeListener(this.f11037Y);
        }
    }

    private void b1(View view) {
        if (((AccessibilityManager) l().getSystemService("accessibility")).isEnabled()) {
            a1(view.findViewById(R.id.switch_widget));
            W0(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void W(l lVar) {
        super.W(lVar);
        a1(lVar.a(R.id.switch_widget));
        X0(lVar);
    }

    public void Y0(CharSequence charSequence) {
        this.f11039a0 = charSequence;
        Q();
    }

    public void Z0(CharSequence charSequence) {
        this.f11038Z = charSequence;
        Q();
    }

    @Override // androidx.preference.Preference
    protected void j0(View view) {
        super.j0(view);
        b1(view);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.k.a(context, m.f11141l, R.attr.switchPreferenceStyle));
    }
}
