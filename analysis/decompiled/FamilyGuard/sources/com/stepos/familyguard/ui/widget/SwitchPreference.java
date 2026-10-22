package com.stepos.familyguard.ui.widget;

import H1.m;
import android.content.Context;
import android.os.Parcelable;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.preference.TwoStatePreference;
import androidx.preference.l;
import com.stepos.common.widget.Switch;
import com.stepos.familyguard.R;
import java.lang.reflect.Field;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* renamed from: d0, reason: collision with root package name */
    private static Field f15214d0;

    /* renamed from: Y, reason: collision with root package name */
    boolean f15215Y;

    /* renamed from: Z, reason: collision with root package name */
    boolean f15216Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f15217a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f15218b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f15219c0;

    public SwitchPreference(Context context, AttributeSet attributeSet, int i5) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet, i5);
        this.f15215Y = true;
        this.f15216Z = false;
        this.f15217a0 = true;
        try {
            if (f15214d0 == null) {
                Field declaredField = Preference.class.getDeclaredField("mRecycleEnabled");
                f15214d0 = declaredField;
                declaredField.setAccessible(true);
            }
            f15214d0.set(this, Boolean.TRUE);
        } catch (Exception unused) {
        }
        context.obtainStyledAttributes(attributeSet, m.U6, i5, 0).recycle();
    }

    @Override // androidx.preference.TwoStatePreference
    public void S0(boolean z5) {
        Z0(z5, true);
    }

    @Override // androidx.preference.Preference
    public void W(l lVar) {
        super.W(lVar);
        View view = lVar.itemView;
        KeyEvent.Callback callbackFindViewById = view.findViewById(R.id.switchWidget);
        if (callbackFindViewById != null && (callbackFindViewById instanceof Checkable)) {
            CharSequence charSequenceI = I();
            String str = BuildConfig.FLAVOR;
            if (charSequenceI != null) {
                str = BuildConfig.FLAVOR + ((Object) I()) + ",";
            }
            if (G() != null) {
                str = str + ((Object) G()) + ",";
            }
            if (callbackFindViewById instanceof Switch) {
                Switch r02 = (Switch) callbackFindViewById;
                r02.setOnCheckedChangeListener(null);
                View viewFindViewById = view.findViewById(android.R.id.widget_frame);
                if (viewFindViewById != null) {
                    viewFindViewById.setContentDescription(R0() ? r02.f14332g : r02.f14333h);
                }
                r02.setContentDescription(str);
                r02.setClickable(false);
                r02.setFocusable(false);
                if (this.f15215Y && this.f15216Z) {
                    r02.setCheckedWithHapticFeedback(R0());
                } else {
                    r02.p(R0(), false);
                }
            } else if (callbackFindViewById instanceof CompoundButton) {
                CompoundButton compoundButton = (CompoundButton) callbackFindViewById;
                compoundButton.setOnCheckedChangeListener(null);
                compoundButton.setClickable(false);
                compoundButton.setFocusable(false);
                compoundButton.setContentDescription(str);
                boolean zR0 = R0();
                if (compoundButton.isChecked() != zR0) {
                    boolean z5 = this.f15215Y && this.f15216Z;
                    Log.d("SwitchPreference", "bind StepOSSwitch key=" + s() + " " + compoundButton.isChecked() + "->" + zR0 + " allowAnim=" + z5);
                    compoundButton.setChecked(zR0);
                    if (z5) {
                        compoundButton.performHapticFeedback(3);
                    } else {
                        compoundButton.jumpDrawablesToCurrentState();
                    }
                }
            } else {
                ((Checkable) callbackFindViewById).setChecked(R0());
            }
            this.f15215Y = true;
            this.f15216Z = false;
        }
        TextView textView = (TextView) view.findViewById(android.R.id.title);
        this.f15218b0 = textView;
        if (textView != null) {
            textView.setSingleLine(this.f15217a0);
        }
        W0(view);
    }

    @Override // androidx.preference.TwoStatePreference
    protected void W0(View view) {
        boolean z5;
        TextView textView = (TextView) view.findViewById(android.R.id.summary);
        if (textView != null) {
            CharSequence charSequenceG = G();
            if (TextUtils.isEmpty(charSequenceG)) {
                z5 = true;
            } else {
                textView.setText(charSequenceG);
                z5 = false;
            }
            int i5 = z5 ? 8 : 0;
            if (i5 != textView.getVisibility()) {
                textView.setVisibility(i5);
            }
        }
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    protected void X() {
        this.f15219c0 = true;
        this.f15216Z = true;
        try {
            super.X();
        } finally {
            this.f15219c0 = false;
        }
    }

    public boolean Y0() {
        return this.f15219c0;
    }

    public void Z0(boolean z5, boolean z6) {
        super.S0(z5);
        this.f15215Y = z6;
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    protected Parcelable f0() {
        boolean zN = N();
        E0(true);
        Parcelable parcelableF0 = super.f0();
        E0(zN);
        return parcelableF0;
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.StepOSCommon_SwitchPreferenceStyle);
    }

    public SwitchPreference(Context context) {
        this(context, null);
    }
}
