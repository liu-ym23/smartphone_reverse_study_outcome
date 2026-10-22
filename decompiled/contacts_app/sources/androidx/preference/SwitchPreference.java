package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    private final Listener mListener;
    private CharSequence mSwitchOff;
    private CharSequence mSwitchOn;

    private class Listener implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ SwitchPreference this$0;

        Listener(SwitchPreference r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton r3, boolean r4) {
            if (this.this$0.callChangeListener(Boolean.valueOf(r4)) == true) goto L6;
            r3.setChecked(!r4);
            return;
        L6:
            this.this$0.setChecked(r4);
        }
    }

    public SwitchPreference(Context r2, AttributeSet r3, int r4, int r5) {
        super(r2, r3, r4, r5);
        this.mListener = new Listener(this);
        TypedArray r6 = r2.obtainStyledAttributes(r3, R.styleable.SwitchPreference, r4, r5);
        setSummaryOn(TypedArrayUtils.getString(r6, R.styleable.SwitchPreference_summaryOn, R.styleable.SwitchPreference_android_summaryOn));
        setSummaryOff(TypedArrayUtils.getString(r6, R.styleable.SwitchPreference_summaryOff, R.styleable.SwitchPreference_android_summaryOff));
        setSwitchTextOn(TypedArrayUtils.getString(r6, R.styleable.SwitchPreference_switchTextOn, R.styleable.SwitchPreference_android_switchTextOn));
        setSwitchTextOff(TypedArrayUtils.getString(r6, R.styleable.SwitchPreference_switchTextOff, R.styleable.SwitchPreference_android_switchTextOff));
        setDisableDependentsState(TypedArrayUtils.getBoolean(r6, R.styleable.SwitchPreference_disableDependentsState, R.styleable.SwitchPreference_android_disableDependentsState, false));
        r6.recycle();
    }

    public SwitchPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public SwitchPreference(Context r3, AttributeSet r4) {
        this(r3, r4, TypedArrayUtils.getAttr(r3, R.attr.switchPreferenceStyle, android.R.attr.switchPreferenceStyle));
    }

    public SwitchPreference(Context r2) {
        this(r2, null);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        syncSwitchView(r2.findViewById(android.R.id.switch_widget));
        syncSummaryView(r2);
    }

    public void setSwitchTextOn(CharSequence r1) {
        this.mSwitchOn = r1;
        notifyChanged();
    }

    public void setSwitchTextOff(CharSequence r1) {
        this.mSwitchOff = r1;
        notifyChanged();
    }

    public CharSequence getSwitchTextOn() {
        return this.mSwitchOn;
    }

    public void setSwitchTextOn(int r2) {
        setSwitchTextOn(getContext().getString(r2));
    }

    public CharSequence getSwitchTextOff() {
        return this.mSwitchOff;
    }

    public void setSwitchTextOff(int r2) {
        setSwitchTextOff(getContext().getString(r2));
    }

    @Override // androidx.preference.Preference
    protected void performClick(View r1) {
        super.performClick(r1);
        syncViewIfAccessibilityEnabled(r1);
    }

    private void syncViewIfAccessibilityEnabled(View r3) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled() == true) goto L5;
        return;
    L5:
        syncSwitchView(r3.findViewById(android.R.id.switch_widget));
        syncSummaryView(r3.findViewById(android.R.id.summary));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void syncSwitchView(View r4) {
        boolean r0 = r4 instanceof Switch;
        if (r0 == false) goto L6;
        ((Switch) r4).setOnCheckedChangeListener(null);
    L6:
        if ((r4 instanceof Checkable) == false) goto L8;
        ((Checkable) r4).setChecked(this.mChecked);
    L8:
        if (r0 == false) goto L11;
        Switch r5 = (Switch) r4;
        r5.setTextOn(this.mSwitchOn);
        r5.setTextOff(this.mSwitchOff);
        r5.setOnCheckedChangeListener(this.mListener);
        return;
    }
}
