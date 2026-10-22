package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CancelableFontCallback extends TextAppearanceFontCallback {
    private final ApplyFont applyFont;
    private boolean cancelled;
    private final Typeface fallbackFont;

    public interface ApplyFont {
        void apply(Typeface r10);
    }

    public CancelableFontCallback(ApplyFont r10, Typeface r11) {
        this.fallbackFont = r11;
        this.applyFont = r10;
    }

    private void updateIfNotCancelled(Typeface r10) {
        if (this.cancelled == true) goto L6;
        this.applyFont.apply(r10);
        return;
    }

    public void cancel() {
        this.cancelled = true;
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrievalFailed(int r10) {
        updateIfNotCancelled(this.fallbackFont);
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrieved(Typeface r10, boolean r11) {
        updateIfNotCancelled(r10);
    }
}
