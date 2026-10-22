package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
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
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.r;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {
    private final Chip chip;
    private final EditText editText;
    private TextView label;
    private final TextInputLayout textInputLayout;
    private TextWatcher watcher;

    /* JADX INFO: renamed from: com.google.android.material.timepicker.ChipTextInputComboView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class TextFormatter extends TextWatcherAdapter {
        private static final String DEFAULT_TEXT = "00";
        final /* synthetic */ ChipTextInputComboView this$0;

        private TextFormatter(ChipTextInputComboView r1) {
            this.this$0 = r1;
        }

        /* synthetic */ TextFormatter(ChipTextInputComboView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.aiagent.plugin");
            if (TextUtils.isEmpty(r4) == false) goto L6;
            ChipTextInputComboView.access$200(this.this$0).setText(ChipTextInputComboView.access$100(this.this$0, DEFAULT_TEXT));
            return;
        L6:
            ChipTextInputComboView.access$200(this.this$0).setText(ChipTextInputComboView.access$100(this.this$0, r4));
        }
    }

    static /* synthetic */ String access$100(ChipTextInputComboView r2, CharSequence r3) {
        return r2.formatText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ Chip access$200(ChipTextInputComboView r0) {
        return r0.chip;
    }

    public ChipTextInputComboView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public ChipTextInputComboView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public ChipTextInputComboView(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        super(r8, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin"), r7);
        LayoutInflater r9 = LayoutInflater.from(r8);
        Chip r10 = (Chip) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r9, ZeusTransformUtils.mapRes(R.layout.material_time_chip, "layout", "material_time_chip"), this, false, "com.obric.aiagent.plugin"), Chip.class, "com.obric.aiagent.plugin");
        this.chip = r10;
        r10.setAccessibilityClassName("android.view.View");
        TextInputLayout r11 = (TextInputLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r9, ZeusTransformUtils.mapRes(R.layout.material_time_input, "layout", "material_time_input"), this, false, "com.obric.aiagent.plugin"), TextInputLayout.class, "com.obric.aiagent.plugin");
        this.textInputLayout = r11;
        EditText r12 = r11.getEditText();
        this.editText = r12;
        r12.setVisibility(4);
        TextFormatter r2 = new TextFormatter(this, null);
        this.watcher = r2;
        r12.addTextChangedListener(r2);
        updateHintLocales();
        addView(r10);
        addView(r11);
        this.label = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.material_label, DbHelper.COL_ID, "material_label")), TextView.class, "com.obric.aiagent.plugin");
        r12.setSaveEnabled(false);
        r12.setLongClickable(false);
    }

    private void updateHintLocales() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        LocaleList r0 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().getLocales();
        this.editText.setImeHintLocales(r0);
        return;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.chip.isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r4) {
        this.chip.setChecked(r4);
        EditText r0 = this.editText;
        int r1 = 0;
        if (r4 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        Chip r3 = this.chip;
        if (r4 == false) goto L9;
        r1 = 8;
    L9:
        r3.setVisibility(r1);
        if (isChecked() == false) goto L15;
        r.b(this.editText);
        if (TextUtils.isEmpty(this.editText.getText()) == true) goto L16;
        EditText r5 = this.editText;
        r5.setSelection(r5.getText().length());
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r2 = 4;
        goto L6
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.chip.toggle();
    }

    public void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.chip.setText(formatText(r4));
        if (TextUtils.isEmpty(this.editText.getText()) == true) goto L6;
        this.editText.removeTextChangedListener(this.watcher);
        this.editText.setText(null);
        this.editText.addTextChangedListener(this.watcher);
        return;
    }

    private String formatText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        return TimeModel.formatText(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), r4);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        this.chip.setOnClickListener(r4);
    }

    @Override // android.view.View
    public void setTag(int r1, Object r2) {
        this.chip.setTag(r1, r2);
    }

    public void setHelperText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.label.setText(r4);
    }

    public void setCursorVisible(boolean r1) {
        this.editText.setCursorVisible(r1);
    }

    public void addInputFilter(InputFilter r5) {
        InputFilter r6 = (InputFilter) ZeusTransformUtils.wrapperContextForParams(r5, InputFilter.class, "com.obric.aiagent.plugin");
        InputFilter[] r0 = this.editText.getFilters();
        InputFilter[] r1 = (InputFilter[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r0, r0.length + 1), InputFilter[].class, "com.obric.aiagent.plugin");
        r1[r0.length] = r6;
        this.editText.setFilters(r1);
    }

    public TextInputLayout getTextInput() {
        return this.textInputLayout;
    }

    public void setChipDelegate(AccessibilityDelegateCompat r1) {
        ViewCompat.a(this.chip, r1);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        updateHintLocales();
    }
}
