package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes3.dex */
abstract class EndIconDelegate {
    Context context;
    CheckableImageButton endIconView;
    TextInputLayout textInputLayout;

    public EndIconDelegate(@NonNull TextInputLayout r10) {
        this.textInputLayout = r10;
        this.context = r10.getContext();
        this.endIconView = r10.getEndIconView();
    }

    public abstract void initialize();

    public boolean isBoxBackgroundModeSupported(int r10) {
        return true;
    }

    public void onSuffixVisibilityChanged(boolean r10) {
    }

    public boolean shouldTintIconOnError() {
        return false;
    }
}
