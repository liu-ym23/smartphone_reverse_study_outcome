package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* renamed from: S, reason: collision with root package name */
    public final C0329a f4124S;
    public final CharSequence T;

    /* renamed from: U, reason: collision with root package name */
    public final CharSequence f4125U;

    /* JADX WARN: Illegal instructions before constructor call */
    public SwitchPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int iM = Z2.I.m(context, R.attr.switchPreferenceStyle, android.R.attr.switchPreferenceStyle);
        super(context, attributeSet, iM, 0);
        this.f4124S = new C0329a(this, 1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L.f4052l, iM, 0);
        this.f4129O = Z2.I.s(typedArrayObtainStyledAttributes, 10, 0);
        if (this.f4128N) {
            h();
        }
        String string = typedArrayObtainStyledAttributes.getString(9);
        this.f4130P = string == null ? typedArrayObtainStyledAttributes.getString(1) : string;
        if (!this.f4128N) {
            h();
        }
        String string2 = typedArrayObtainStyledAttributes.getString(12);
        this.T = string2 == null ? typedArrayObtainStyledAttributes.getString(3) : string2;
        h();
        String string3 = typedArrayObtainStyledAttributes.getString(11);
        this.f4125U = string3 == null ? typedArrayObtainStyledAttributes.getString(4) : string3;
        h();
        this.f4132R = typedArrayObtainStyledAttributes.getBoolean(5, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B(View view) {
        boolean z4 = view instanceof Switch;
        if (z4) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f4128N);
        }
        if (z4) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.T);
            r4.setTextOff(this.f4125U);
            r4.setOnCheckedChangeListener(this.f4124S);
        }
    }

    @Override // androidx.preference.Preference
    public final void l(K k4) {
        super.l(k4);
        B(k4.a(android.R.id.switch_widget));
        A(k4.a(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void s(View view) {
        super.s(view);
        if (((AccessibilityManager) this.f4077a.getSystemService("accessibility")).isEnabled()) {
            B(view.findViewById(android.R.id.switch_widget));
            A(view.findViewById(android.R.id.summary));
        }
    }
}
