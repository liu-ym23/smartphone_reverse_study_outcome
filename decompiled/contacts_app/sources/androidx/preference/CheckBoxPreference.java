package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    private final Listener mListener;

    private class Listener implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ CheckBoxPreference this$0;

        Listener(CheckBoxPreference r1) {
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

    public CheckBoxPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public CheckBoxPreference(Context r2, AttributeSet r3, int r4, int r5) {
        super(r2, r3, r4, r5);
        this.mListener = new Listener(this);
        TypedArray r6 = r2.obtainStyledAttributes(r3, R.styleable.CheckBoxPreference, r4, r5);
        setSummaryOn(TypedArrayUtils.getString(r6, R.styleable.CheckBoxPreference_summaryOn, R.styleable.CheckBoxPreference_android_summaryOn));
        setSummaryOff(TypedArrayUtils.getString(r6, R.styleable.CheckBoxPreference_summaryOff, R.styleable.CheckBoxPreference_android_summaryOff));
        setDisableDependentsState(TypedArrayUtils.getBoolean(r6, R.styleable.CheckBoxPreference_disableDependentsState, R.styleable.CheckBoxPreference_android_disableDependentsState, false));
        r6.recycle();
    }

    public CheckBoxPreference(Context r3, AttributeSet r4) {
        this(r3, r4, TypedArrayUtils.getAttr(r3, R.attr.checkBoxPreferenceStyle, android.R.attr.checkBoxPreferenceStyle));
    }

    public CheckBoxPreference(Context r2) {
        this(r2, null);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        syncCheckboxView(r2.findViewById(android.R.id.checkbox));
        syncSummaryView(r2);
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
        syncCheckboxView(r3.findViewById(android.R.id.checkbox));
        syncSummaryView(r3.findViewById(android.R.id.summary));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void syncCheckboxView(View r4) {
        boolean r0 = r4 instanceof CompoundButton;
        if (r0 == false) goto L6;
        ((CompoundButton) r4).setOnCheckedChangeListener(null);
    L6:
        if ((r4 instanceof Checkable) == false) goto L8;
        ((Checkable) r4).setChecked(this.mChecked);
    L8:
        if (r0 == false) goto L11;
        ((CompoundButton) r4).setOnCheckedChangeListener(this.mListener);
        return;
    }
}
