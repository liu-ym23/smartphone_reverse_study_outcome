package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.g;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialComponentsViewInflater extends g {
    public MaterialComponentsViewInflater() {
    }

    @Override // androidx.appcompat.app.g
    @NonNull
    public AppCompatAutoCompleteTextView createAutoCompleteTextView(@NonNull Context r10, @Nullable AttributeSet r11) {
        return new MaterialAutoCompleteTextView(r10, r11);
    }

    @Override // androidx.appcompat.app.g
    @NonNull
    public AppCompatButton createButton(@NonNull Context r10, @NonNull AttributeSet r11) {
        return new MaterialButton(r10, r11);
    }

    @Override // androidx.appcompat.app.g
    @NonNull
    public AppCompatCheckBox createCheckBox(Context r10, AttributeSet r11) {
        return new MaterialCheckBox(r10, r11);
    }

    @Override // androidx.appcompat.app.g
    @NonNull
    public AppCompatRadioButton createRadioButton(Context r10, AttributeSet r11) {
        return new MaterialRadioButton(r10, r11);
    }

    @Override // androidx.appcompat.app.g
    @NonNull
    public AppCompatTextView createTextView(Context r10, AttributeSet r11) {
        return new MaterialTextView(r10, r11);
    }
}
