package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f5342e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Chip f5343a;

    /* renamed from: b, reason: collision with root package name */
    public final TextInputLayout f5344b;

    /* renamed from: c, reason: collision with root package name */
    public final EditText f5345c;

    /* renamed from: d, reason: collision with root package name */
    public final a f5346d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends com.google.android.material.internal.h {
        public a() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
            Chip chip = chipTextInputComboView.f5343a;
            if (TextUtils.isEmpty(editable)) {
                chip.setText(TimeModel.formatText(chipTextInputComboView.getResources(), "00"));
                return;
            }
            int i10 = ChipTextInputComboView.f5342e;
            String text = TimeModel.formatText(chipTextInputComboView.getResources(), editable);
            if (TextUtils.isEmpty(text)) {
                text = TimeModel.formatText(chipTextInputComboView.getResources(), "00");
            }
            chip.setText(text);
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.f5343a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.f5344b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f5345c = editText;
        editText.setVisibility(4);
        a aVar = new a();
        this.f5346d = aVar;
        editText.addTextChangedListener(aVar);
        editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        addView(chip);
        addView(textInputLayout);
        TextView textView = (TextView) findViewById(R.id.material_label);
        editText.setId(View.generateViewId());
        textView.setLabelFor(editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f5343a.isChecked();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f5345c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public final void setChecked(boolean z) {
        Chip chip = this.f5343a;
        chip.setChecked(z);
        int i10 = z ? 0 : 4;
        EditText editText = this.f5345c;
        editText.setVisibility(i10);
        chip.setVisibility(z ? 8 : 0);
        if (chip.isChecked()) {
            editText.requestFocus();
            editText.post(new com.google.android.material.datepicker.f(1, editText));
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f5343a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public final void setTag(int i10, Object obj) {
        this.f5343a.setTag(i10, obj);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.f5343a.toggle();
    }
}
