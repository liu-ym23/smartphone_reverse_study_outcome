package com.google.android.material.drawable;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DrawableUtils {
    private DrawableUtils() {
    }

    @NonNull
    public static AttributeSet parseDrawableXml(@NonNull Context r10, @XmlRes int r11, @NonNull CharSequence r12) {
        XmlResourceParser r13 = r10.getResources().getXml(r11);     // Catch: Throwable -> L12
    L3:
        int r14 = r13.next();     // Catch: Throwable -> L12
        if (r14 == 2) goto L7;
        if (r14 != 1) goto L3;
    L7:
        if (r14 != 2) goto L17;
        if (TextUtils.equals(r13.getName(), r12) == false) goto L15;
        return Xml.asAttributeSet(r13);
    L15:
        throw new XmlPullParserException("Must have a <" + r12 + "> start tag");     // Catch: Throwable -> L12
    L17:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L12
    L12:
        e = move-exception;
        Resources.NotFoundException r15 = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(r11));
        r15.initCause(e);
        throw r15;
    }

    @TargetApi(21)
    public static void setRippleDrawableRadius(@Nullable RippleDrawable r10, int r11) {
        r10.setRadius(r11);
    }

    @Nullable
    public static PorterDuffColorFilter updateTintFilter(@NonNull Drawable r10, @Nullable ColorStateList r11, @Nullable PorterDuff.Mode r12) {
        if (r11 == null) goto L7;
        if (r12 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r11.getColorForState(r10.getState(), 0), r12);
    L7:
        return null;
    }
}
