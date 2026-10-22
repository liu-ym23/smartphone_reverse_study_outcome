package com.google.android.material.timepicker;

import a1.C0413f;
import a1.C0415h;
import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.n;
import com.google.android.material.internal.r;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: a, reason: collision with root package name */
    private final Chip f13437a;

    /* renamed from: b, reason: collision with root package name */
    private final TextInputLayout f13438b;

    /* renamed from: c, reason: collision with root package name */
    private final EditText f13439c;

    /* renamed from: d, reason: collision with root package name */
    private TextWatcher f13440d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f13441e;

    private class b extends n {
        private b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f13437a.setText(ChipTextInputComboView.this.c("00"));
                return;
            }
            String strC = ChipTextInputComboView.this.c(editable);
            Chip chip = ChipTextInputComboView.this.f13437a;
            if (TextUtils.isEmpty(strC)) {
                strC = ChipTextInputComboView.this.c("00");
            }
            chip.setText(strC);
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(CharSequence charSequence) {
        return e.a(getResources(), charSequence);
    }

    private void d() {
        this.f13439c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f13437a.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        this.f13437a.setChecked(z5);
        this.f13439c.setVisibility(z5 ? 0 : 4);
        this.f13437a.setVisibility(z5 ? 8 : 0);
        if (isChecked()) {
            r.j(this.f13439c, false);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f13437a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i5, Object obj) {
        this.f13437a.setTag(i5, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f13437a.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(C0415h.f6873g, (ViewGroup) this, false);
        this.f13437a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(C0415h.f6874h, (ViewGroup) this, false);
        this.f13438b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f13439c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f13440d = bVar;
        editText.addTextChangedListener(bVar);
        d();
        addView(chip);
        addView(textInputLayout);
        this.f13441e = (TextView) findViewById(C0413f.f6851n);
        editText.setId(View.generateViewId());
        this.f13441e.setLabelFor(editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
