package com.bumptech.glide.module;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.GlideBuilder;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppGlideModule extends LibraryGlideModule implements AppliesOptions {
    public AppGlideModule() {
    }

    public void applyOptions(@NonNull Context r10, @NonNull GlideBuilder r11) {
    }

    public boolean isManifestParsingEnabled() {
        return true;
    }
}
