package com.google.android.material.resources;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class TextAppearanceConfig {
    private static boolean shouldLoadFontSynchronously;

    public TextAppearanceConfig() {
    }

    public static void setShouldLoadFontSynchronously(boolean r10) {
        shouldLoadFontSynchronously = r10;
    }

    public static boolean shouldLoadFontSynchronously() {
        return shouldLoadFontSynchronously;
    }
}
