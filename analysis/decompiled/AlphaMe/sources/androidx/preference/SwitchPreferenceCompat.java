package androidx.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: S, reason: collision with root package name */
    public final C0329a f4126S;
    public final CharSequence T;

    /* renamed from: U, reason: collision with root package name */
    public final CharSequence f4127U;

    public SwitchPreferenceCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.switchPreferenceCompatStyle, 0);
        this.f4126S = new C0329a(this, 2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L.f4053m, R.attr.switchPreferenceCompatStyle, 0);
        this.f4129O = Z2.I.s(typedArrayObtainStyledAttributes, 7, 0);
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
        this.f4127U = string3 == null ? typedArrayObtainStyledAttributes.getString(4) : string3;
        h();
        this.f4132R = typedArrayObtainStyledAttributes.getBoolean(5, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B(View view) throws Resources.NotFoundException {
        boolean z4 = view instanceof SwitchCompat;
        if (z4) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f4128N);
        }
        if (z4) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.T);
            switchCompat.setTextOff(this.f4127U);
            switchCompat.setOnCheckedChangeListener(this.f4126S);
        }
    }

    @Override // androidx.preference.Preference
    public final void l(K k4) throws Resources.NotFoundException {
        super.l(k4);
        B(k4.a(R.id.switchWidget));
        A(k4.a(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void s(View view) throws Resources.NotFoundException {
        super.s(view);
        if (((AccessibilityManager) this.f4077a.getSystemService("accessibility")).isEnabled()) {
            B(view.findViewById(R.id.switchWidget));
            A(view.findViewById(android.R.id.summary));
        }
    }
}
