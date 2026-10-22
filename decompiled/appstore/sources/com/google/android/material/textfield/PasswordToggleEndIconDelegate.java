package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import androidx.annotation.NonNull;
import c.a;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
class PasswordToggleEndIconDelegate extends EndIconDelegate {
    private final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener;
    private final TextInputLayout.OnEndIconChangedListener onEndIconChangedListener;
    private final TextWatcher textWatcher;

    public PasswordToggleEndIconDelegate(@NonNull TextInputLayout r10) {
        super(r10);
        this.textWatcher = new AnonymousClass1(this);
        this.onEditTextAttachedListener = new AnonymousClass2(this);
        this.onEndIconChangedListener = new AnonymousClass3(this);
    }

    public static /* synthetic */ boolean access$000(PasswordToggleEndIconDelegate r10) {
        return r10.hasPasswordTransformation();
    }

    public static /* synthetic */ TextWatcher access$100(PasswordToggleEndIconDelegate r10) {
        return r10.textWatcher;
    }

    private boolean hasPasswordTransformation() {
        EditText r10 = this.textInputLayout.getEditText();
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r10.getTransformationMethod() instanceof PasswordTransformationMethod) == false) goto L7;
        return true;
    }

    private static boolean isInputTypePassword(EditText r10) {
        if (r10 != null) goto L4;
    L12:
        return false;
    L4:
        if (r10.getInputType() != 16) goto L6;
    L11:
        return true;
    L6:
        if (r10.getInputType() == 128) goto L11;
        if (r10.getInputType() == 144) goto L11;
        if (r10.getInputType() != 224) goto L12;
        goto L11
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconDrawable(a.b(this.context, R.drawable.design_password_eye));
        TextInputLayout r10 = this.textInputLayout;
        r10.setEndIconContentDescription(r10.getResources().getText(R.string.password_toggle_content_description));
        this.textInputLayout.setEndIconOnClickListener(new AnonymousClass4(this));
        this.textInputLayout.addOnEditTextAttachedListener(this.onEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.onEndIconChangedListener);
        EditText r11 = this.textInputLayout.getEditText();
        if (isInputTypePassword(r11) == false) goto L6;
        r11.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    }
}
