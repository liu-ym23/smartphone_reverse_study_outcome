package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.a;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {
    private final Chip chip;
    private final EditText editText;
    private TextView label;
    private final TextInputLayout textInputLayout;
    private TextWatcher watcher;

    /* JADX INFO: renamed from: com.google.android.material.timepicker.ChipTextInputComboView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class TextFormatter extends TextWatcherAdapter {
        private static final String DEFAULT_TEXT = "00";
        final /* synthetic */ ChipTextInputComboView this$0;

        private TextFormatter(ChipTextInputComboView r10) {
            this.this$0 = r10;
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            if (TextUtils.isEmpty(r10) == false) goto L6;
            ChipTextInputComboView.access$200(this.this$0).setText(ChipTextInputComboView.access$100(this.this$0, "00"));
            return;
        L6:
            ChipTextInputComboView.access$200(this.this$0).setText(ChipTextInputComboView.access$100(this.this$0, r10));
        }

        public /* synthetic */ TextFormatter(ChipTextInputComboView r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public ChipTextInputComboView(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ String access$100(ChipTextInputComboView r10, CharSequence r11) {
        return r10.formatText(r11);
    }

    public static /* synthetic */ Chip access$200(ChipTextInputComboView r10) {
        return r10.chip;
    }

    private String formatText(CharSequence r10) {
        return TimeModel.formatText(getResources(), r10);
    }

    private void updateHintLocales() {
        LocaleList r10 = getContext().getResources().getConfiguration().getLocales();
        this.editText.setImeHintLocales(r10);
    }

    public void addInputFilter(InputFilter r10) {
        InputFilter[] r11 = this.editText.getFilters();
        InputFilter[] r12 = (InputFilter[]) Arrays.copyOf(r11, r11.length + 1);
        r12[r11.length] = r10;
        this.editText.setFilters(r12);
    }

    public TextInputLayout getTextInput() {
        return this.textInputLayout;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.chip.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        updateHintLocales();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        this.chip.setChecked(r10);
        EditText r11 = this.editText;
        int r12 = 0;
        if (r10 == false) goto L5;
        int r13 = 0;
    L6:
        r11.setVisibility(r13);
        Chip r14 = this.chip;
        if (r10 == false) goto L9;
        r12 = 8;
    L9:
        r14.setVisibility(r12);
        if (isChecked() == false) goto L15;
        this.editText.requestFocus();
        if (TextUtils.isEmpty(this.editText.getText()) == true) goto L16;
        EditText r15 = this.editText;
        r15.setSelection(r15.getText().length());
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r13 = 4;
        goto L6
    }

    public void setChipDelegate(a r10) {
        ViewCompat.p0(this.chip, r10);
    }

    public void setCursorVisible(boolean r10) {
        this.editText.setCursorVisible(r10);
    }

    public void setHelperText(CharSequence r10) {
        this.label.setText(r10);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener r10) {
        this.chip.setOnClickListener(r10);
    }

    @Override // android.view.View
    public void setTag(int r10, Object r11) {
        this.chip.setTag(r10, r11);
    }

    public void setText(CharSequence r10) {
        this.chip.setText(formatText(r10));
        if (TextUtils.isEmpty(this.editText.getText()) == true) goto L6;
        this.editText.removeTextChangedListener(this.watcher);
        this.editText.setText(null);
        this.editText.addTextChangedListener(this.watcher);
        return;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.chip.toggle();
    }

    public ChipTextInputComboView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ChipTextInputComboView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        LayoutInflater r13 = LayoutInflater.from(r10);
        Chip r14 = (Chip) r13.inflate(R.layout.material_time_chip, this, false);
        this.chip = r14;
        TextInputLayout r15 = (TextInputLayout) r13.inflate(R.layout.material_time_input, this, false);
        this.textInputLayout = r15;
        EditText r16 = r15.getEditText();
        this.editText = r16;
        r16.setVisibility(4);
        TextFormatter r17 = new TextFormatter(this, null);
        this.watcher = r17;
        r16.addTextChangedListener(r17);
        updateHintLocales();
        addView(r14);
        addView(r15);
        this.label = (TextView) findViewById(R.id.material_label);
        r16.setSaveEnabled(false);
    }
}
