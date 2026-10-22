package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* renamed from: S, reason: collision with root package name */
    public final C0329a f4005S;

    /* JADX WARN: Illegal instructions before constructor call */
    public CheckBoxPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int iM = Z2.I.m(context, R.attr.checkBoxPreferenceStyle, android.R.attr.checkBoxPreferenceStyle);
        super(context, attributeSet, iM, 0);
        this.f4005S = new C0329a(this, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L.f4042b, iM, 0);
        this.f4129O = Z2.I.s(typedArrayObtainStyledAttributes, 5, 0);
        if (this.f4128N) {
            h();
        }
        String string = typedArrayObtainStyledAttributes.getString(4);
        this.f4130P = string == null ? typedArrayObtainStyledAttributes.getString(1) : string;
        if (!this.f4128N) {
            h();
        }
        this.f4132R = typedArrayObtainStyledAttributes.getBoolean(3, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B(View view) {
        boolean z4 = view instanceof CompoundButton;
        if (z4) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f4128N);
        }
        if (z4) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f4005S);
        }
    }

    @Override // androidx.preference.Preference
    public final void l(K k4) {
        super.l(k4);
        B(k4.a(android.R.id.checkbox));
        A(k4.a(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void s(View view) {
        super.s(view);
        if (((AccessibilityManager) this.f4077a.getSystemService("accessibility")).isEnabled()) {
            B(view.findViewById(android.R.id.checkbox));
            A(view.findViewById(android.R.id.summary));
        }
    }
}
