package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes2.dex */
abstract class EndIconDelegate {
    final Context context;
    final CheckableImageButton endIconView;
    final EndCompoundLayout endLayout;
    final TextInputLayout textInputLayout;

    void afterEditTextChanged(Editable r1) {
    }

    void beforeEditTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    int getIconContentDescriptionResId() {
        return 0;
    }

    int getIconDrawableResId() {
        return 0;
    }

    View.OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return null;
    }

    View.OnClickListener getOnIconClickListener() {
        return null;
    }

    View.OnFocusChangeListener getOnIconViewFocusChangeListener() {
        return null;
    }

    AccessibilityManagerCompat.TouchExplorationStateChangeListener getTouchExplorationStateChangeListener() {
        return null;
    }

    boolean isBoxBackgroundModeSupported(int r1) {
        return true;
    }

    boolean isIconActivable() {
        return false;
    }

    boolean isIconActivated() {
        return false;
    }

    boolean isIconCheckable() {
        return false;
    }

    boolean isIconChecked() {
        return false;
    }

    void onEditTextAttached(EditText r1) {
    }

    void onInitializeAccessibilityNodeInfo(View r1, AccessibilityNodeInfoCompat r2) {
    }

    void onPopulateAccessibilityEvent(View r1, AccessibilityEvent r2) {
    }

    void onSuffixVisibilityChanged(boolean r1) {
    }

    void setUp() {
    }

    boolean shouldTintIconOnError() {
        return false;
    }

    void tearDown() {
    }

    EndIconDelegate(EndCompoundLayout r2) {
        this.textInputLayout = r2.textInputLayout;
        this.endLayout = r2;
        this.context = r2.getContext();
        this.endIconView = r2.getEndIconView();
    }

    final void refreshIconState() {
        this.endLayout.refreshIconState(false);
    }
}
