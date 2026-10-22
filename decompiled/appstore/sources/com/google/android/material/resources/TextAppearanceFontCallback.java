package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class TextAppearanceFontCallback {
    public TextAppearanceFontCallback() {
    }

    public abstract void onFontRetrievalFailed(int r10);

    public abstract void onFontRetrieved(Typeface r10, boolean r11);
}
