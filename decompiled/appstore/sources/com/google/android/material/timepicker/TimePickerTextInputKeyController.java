package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes3.dex */
class TimePickerTextInputKeyController implements TextView.OnEditorActionListener, View.OnKeyListener {
    private final ChipTextInputComboView hourLayoutComboView;
    private boolean keyListenerRunning;
    private final ChipTextInputComboView minuteLayoutComboView;
    private final TimeModel time;

    public TimePickerTextInputKeyController(ChipTextInputComboView r10, ChipTextInputComboView r11, TimeModel r12) {
        this.keyListenerRunning = false;
        this.hourLayoutComboView = r10;
        this.minuteLayoutComboView = r11;
        this.time = r12;
    }

    private void moveSelection(int r10) {
        ChipTextInputComboView r11 = this.minuteLayoutComboView;
        boolean r12 = false;
        if (r10 != 12) goto L5;
        boolean r13 = true;
    L6:
        r11.setChecked(r13);
        ChipTextInputComboView r14 = this.hourLayoutComboView;
        if (r10 != 10) goto L9;
        r12 = true;
    L9:
        r14.setChecked(r12);
        this.time.selection = r10;
        return;
    L5:
        r13 = false;
        goto L6
    }

    private boolean onHourKeyPress(int r10, KeyEvent r11, EditText r12) {
        Editable r13 = r12.getText();
        if (r13 != null) goto L6;
        return false;
    L6:
        if (r10 >= 7) goto L8;
    L17:
        return false;
    L8:
        if (r10 > 16) goto L17;
        if (r11.getAction() != 1) goto L17;
        if (r12.getSelectionStart() != 2) goto L17;
        if (r13.length() != 2) goto L17;
        moveSelection(12);
        return true;
    }

    private boolean onMinuteKeyPress(int r10, KeyEvent r11, EditText r12) {
        if (r10 == 67) goto L5;
        return false;
    L5:
        if (r11.getAction() == 0) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r12.getText()) == false) goto L13;
        moveSelection(10);
        return true;
    L13:
        return false;
    }

    public void bind() {
        TextInputLayout r10 = this.hourLayoutComboView.getTextInput();
        TextInputLayout r11 = this.minuteLayoutComboView.getTextInput();
        EditText r12 = r10.getEditText();
        EditText r13 = r11.getEditText();
        r12.setImeOptions(268435461);
        r13.setImeOptions(268435462);
        r12.setOnEditorActionListener(this);
        r12.setOnKeyListener(this);
        r13.setOnKeyListener(this);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView r10, int r11, KeyEvent r12) {
        if (r11 != 5) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L8;
        moveSelection(12);
    L8:
        return r13;
    L5:
        r13 = false;
        goto L6
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r10, int r11, KeyEvent r12) {
        if (this.keyListenerRunning == false) goto L5;
        return false;
    L5:
        this.keyListenerRunning = true;
        EditText r13 = (EditText) r10;
        if (this.time.selection != 12) goto L8;
        boolean r14 = onMinuteKeyPress(r11, r12, r13);
    L9:
        this.keyListenerRunning = false;
        return r14;
    L8:
        r14 = onHourKeyPress(r11, r12, r13);
        goto L9
    }
}
