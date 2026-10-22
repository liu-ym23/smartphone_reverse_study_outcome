package com.bumptech.glide.module;

import android.content.Context;
import com.bumptech.glide.GlideBuilder;

/* JADX INFO: loaded from: classes39.dex */
public abstract class AppGlideModule extends LibraryGlideModule implements AppliesOptions {
    public void applyOptions(Context r100, GlideBuilder r101) {
    }

    public boolean isManifestParsingEnabled() {
        return true;
    }

    public AppGlideModule() {
    }
}
