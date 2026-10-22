package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.a;
import g.b;

/* JADX INFO: loaded from: classes.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    static {
    }

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context r10, Context r11, @DrawableRes int r12) {
        return getDrawable(r10, r11, r12, null);
    }

    private static Drawable loadDrawableV4(Context r10, @DrawableRes int r11, @Nullable Resources.Theme r12) {
        return a.f(r10.getResources(), r11, r12);
    }

    private static Drawable loadDrawableV7(Context r10, @DrawableRes int r11, @Nullable Resources.Theme r12) {
        if (r12 == null) goto L5;
        r10 = new b(r10, r12);
    L5:
        return c.a.b(r10, r11);
    }

    public static Drawable getDrawable(Context r10, @DrawableRes int r11, @Nullable Resources.Theme r12) {
        return getDrawable(r10, r10, r11, r12);
    }

    private static Drawable getDrawable(Context r10, Context r11, @DrawableRes int r12, @Nullable Resources.Theme r13) {
    L6:
        e = move-exception;
        if (r10.getPackageName().equals(r11.getPackageName()) == false) goto L10;
        throw e;
    L10:
        return ContextCompat.d(r11, r12);
    L12:
        shouldCallAppCompatResources = false;
        goto L13
    L3:
        if (shouldCallAppCompatResources == false) goto L13;
        return loadDrawableV7(r11, r12, r13);
    L13:
        if (r13 != null) goto L17;
        r13 = r11.getTheme();
    L17:
        return loadDrawableV4(r11, r12, r13);
    }
}
