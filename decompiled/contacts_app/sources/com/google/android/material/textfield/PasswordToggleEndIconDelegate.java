package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
class PasswordToggleEndIconDelegate extends EndIconDelegate {
    private EditText editText;
    private int iconResId;
    private final View.OnClickListener onIconClickListener;

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean isIconCheckable() {
        return true;
    }

    /* JADX INFO: renamed from: lambda$new$0$com-google-android-material-textfield-PasswordToggleEndIconDelegate, reason: not valid java name */
    /* synthetic */ void m283x4cc26475(View r3) {
        EditText r4 = this.editText;
        if (r4 != null) goto L5;
        return;
    L5:
        int r5 = r4.getSelectionEnd();
        if (hasPasswordTransformation() == false) goto L8;
        this.editText.setTransformationMethod(null);
    L9:
        if (r5 < 0) goto L11;
        this.editText.setSelection(r5);
    L11:
        refreshIconState();
        return;
    L8:
        this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        goto L9
    }

    PasswordToggleEndIconDelegate(EndCompoundLayout r1, int r2) {
        super(r1);
        this.iconResId = R.drawable.design_password_eye;
        this.onIconClickListener = new PasswordToggleEndIconDelegate$$ExternalSyntheticLambda0(this);
        if (r2 == 0) goto L6;
        this.iconResId = r2;
        return;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void setUp() {
        if (isInputTypePassword(this.editText) == false) goto L6;
        this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void tearDown() {
        EditText r1 = this.editText;
        if (r1 == null) goto L6;
        r1.setTransformationMethod(PasswordTransformationMethod.getInstance());
        return;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    int getIconDrawableResId() {
        return this.iconResId;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    int getIconContentDescriptionResId() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean isIconChecked() {
        return !hasPasswordTransformation();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void onEditTextAttached(EditText r1) {
        this.editText = r1;
        refreshIconState();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void beforeEditTextChanged(CharSequence r1, int r2, int r3, int r4) {
        refreshIconState();
    }

    private boolean hasPasswordTransformation() {
        EditText r0 = this.editText;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r0.getTransformationMethod() instanceof PasswordTransformationMethod) == false) goto L7;
        return true;
    }

    private static boolean isInputTypePassword(EditText r2) {
        if (r2 != null) goto L4;
    L12:
        return false;
    L4:
        if (r2.getInputType() != 16) goto L6;
    L11:
        return true;
    L6:
        if (r2.getInputType() == 128) goto L11;
        if (r2.getInputType() == 144) goto L11;
        if (r2.getInputType() != 224) goto L12;
        goto L11
    }
}
