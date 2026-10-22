package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: classes39.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context r100, Context r101, int r102) {
        return getDrawable(r100, r101, r102, null);
    }

    private static Drawable loadDrawableV4(Context r100, int r101, Resources.Theme r102) {
        return ResourcesCompat.getDrawable(r100.getResources(), r101, r102);
    }

    private static Drawable loadDrawableV7(Context r100, int r101, Resources.Theme r102) {
        if (r102 == null) goto L5;
        r100 = new ContextThemeWrapper(r100, r102);
    L5:
        return AppCompatResources.getDrawable(r100, r101);
    }

    public static Drawable getDrawable(Context r100, int r101, Resources.Theme r102) {
        return getDrawable(r100, r100, r101, r102);
    }

    private static Drawable getDrawable(Context r100, Context r101, int r102, Resources.Theme r103) {
    L7:
        e = move-exception;
        if (r100.getPackageName().equals(r101.getPackageName()) == false) goto L11;
        throw e;
    L11:
        return AppCompatResources.getDrawable(r101, r102);
    L13:
        shouldCallAppCompatResources = false;
        goto L14
    L3:
        if (shouldCallAppCompatResources == false) goto L14;
        return loadDrawableV7(r101, r102, r103);
    L14:
        if (r103 != null) goto L18;
        r103 = r101.getTheme();
    L18:
        return loadDrawableV4(r101, r102, r103);
    }
}
