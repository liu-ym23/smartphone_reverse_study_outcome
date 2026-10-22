package com.android.contacts.speeddial;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes2.dex */
public class MobileTextWatcher implements TextWatcher {
    private EditText mEditor;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    MobileTextWatcher(EditText r1) {
        this.mEditor = r1;
    }

    private String getFormatedMobile(String r4) {
        StringBuilder r3 = new StringBuilder();
        int r0 = r4.length();
        if (r0 != 4) goto L5;
    L15:
        int r1 = 0;
    L16:
        if (r1 >= r0) goto L22;
        r3.append(r4.charAt(r1));
        if (r1 != (r0 - 2)) goto L20;
        r3.append(HanziToPinyin.Token.SEPARATOR);
    L20:
        r1 = r1 + 1;
        goto L16
    L22:
        return r3.toString();
    L5:
        if (r0 == 9) goto L15;
        if (r4.startsWith("+86") == true) goto L9;
        return null;
    L9:
        if (r0 == 8) goto L15;
        if (r0 == 13) goto L15;
        return null;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        String r5 = r1.toString();
        if (r5.endsWith(HanziToPinyin.Token.SEPARATOR) == false) goto L5;
        String r6 = r5.substring(0, r5.length() - 1);
        setTextNoNotify(r6);
        this.mEditor.setSelection(r6.length());
        return;
    L5:
        String r7 = getFormatedMobile(r5);
        if (r7 == null) goto L10;
        setTextNoNotify(r7);
        this.mEditor.setSelection(r7.length());
        return;
    }

    private void setTextNoNotify(String r2) {
        this.mEditor.removeTextChangedListener(this);
        this.mEditor.setText(r2);
        this.mEditor.addTextChangedListener(this);
    }
}
