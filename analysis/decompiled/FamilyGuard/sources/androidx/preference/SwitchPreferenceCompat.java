package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;

/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: Y, reason: collision with root package name */
    private final a f11041Y;

    /* renamed from: Z, reason: collision with root package name */
    private CharSequence f11042Z;

    /* renamed from: a0, reason: collision with root package name */
    private CharSequence f11043a0;

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

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f11041Y = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f11210Z0, i5, i6);
        V0(androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11234h1, s.f11213a1));
        U0(androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11231g1, s.f11216b1));
        Z0(androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11240j1, s.f11222d1));
        Y0(androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11237i1, s.f11225e1));
        T0(androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, s.f11228f1, s.f11219c1, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a1(View view) throws Resources.NotFoundException {
        boolean z5 = view instanceof SwitchCompat;
        if (z5) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f11045T);
        }
        if (z5) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f11042Z);
            switchCompat.setTextOff(this.f11043a0);
            switchCompat.setOnCheckedChangeListener(this.f11041Y);
        }
    }

    private void b1(View view) throws Resources.NotFoundException {
        if (((AccessibilityManager) l().getSystemService("accessibility")).isEnabled()) {
            a1(view.findViewById(o.f11148f));
            W0(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void W(l lVar) throws Resources.NotFoundException {
        super.W(lVar);
        a1(lVar.a(o.f11148f));
        X0(lVar);
    }

    public void Y0(CharSequence charSequence) {
        this.f11043a0 = charSequence;
        Q();
    }

    public void Z0(CharSequence charSequence) {
        this.f11042Z = charSequence;
        Q();
    }

    @Override // androidx.preference.Preference
    protected void j0(View view) throws Resources.NotFoundException {
        super.j0(view);
        b1(view);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f11140k);
    }
}
