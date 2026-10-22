package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.chip.Chip;

/* loaded from: classes3.dex */
public final class a extends com.google.android.material.internal.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChipTextInputComboView f2710a;

    public a(ChipTextInputComboView chipTextInputComboView) {
        this.f2710a = chipTextInputComboView;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ChipTextInputComboView chipTextInputComboView = this.f2710a;
        Chip chip = chipTextInputComboView.f2703a;
        if (TextUtils.isEmpty(editable)) {
            chip.setText(TimeModel.formatText(chipTextInputComboView.getResources(), "00"));
            return;
        }
        int i = ChipTextInputComboView.c;
        String text = TimeModel.formatText(chipTextInputComboView.getResources(), editable);
        if (TextUtils.isEmpty(text)) {
            text = TimeModel.formatText(chipTextInputComboView.getResources(), "00");
        }
        chip.setText(text);
    }
}
