package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l implements TextView.OnEditorActionListener, View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final ChipTextInputComboView f5400a;

    /* renamed from: b, reason: collision with root package name */
    public final ChipTextInputComboView f5401b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeModel f5402c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5403d = false;

    public l(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.f5400a = chipTextInputComboView;
        this.f5401b = chipTextInputComboView2;
        this.f5402c = timeModel;
    }

    public final void a(int i10) {
        this.f5401b.setChecked(i10 == 12);
        this.f5400a.setChecked(i10 == 10);
        this.f5402c.selection = i10;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        boolean z = i10 == 5;
        if (z) {
            a(12);
        }
        return z;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (this.f5403d) {
            return false;
        }
        boolean z = true;
        this.f5403d = true;
        EditText editText = (EditText) view;
        if (this.f5402c.selection != 12) {
            Editable text = editText.getText();
            if (text == null) {
                z = false;
            } else if (i10 >= 7 && i10 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2) {
                a(12);
            } else {
                if (i10 >= 7 && i10 <= 16 && editText.getSelectionStart() == 0 && editText.length() == 2) {
                    editText.getText().clear();
                }
                z = false;
            }
        } else if (i10 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText())) {
            a(10);
        } else {
            if (i10 >= 7 && i10 <= 16 && editText.getSelectionStart() == 0 && editText.length() == 2) {
                editText.getText().clear();
            }
            z = false;
        }
        this.f5403d = false;
        return z;
    }
}
