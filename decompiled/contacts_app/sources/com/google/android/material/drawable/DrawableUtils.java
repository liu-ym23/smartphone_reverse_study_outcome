package com.google.android.material.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class DrawableUtils {
    private DrawableUtils() {
    }

    public static void setTint(Drawable r1, int r2) {
        if (r2 == 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L7;
        DrawableCompat.setTint(r1, r2);
        return;
    L7:
        DrawableCompat.setTintList(r1, null);
        return;
    L4:
        r0 = false;
        goto L5
    }

    public static PorterDuffColorFilter updateTintFilter(Drawable r1, ColorStateList r2, PorterDuff.Mode r3) {
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r2.getColorForState(r1.getState(), 0), r3);
    L7:
        return null;
    }

    public static AttributeSet parseDrawableXml(Context r3, int r4, CharSequence r5) {
        XmlResourceParser r6 = r3.getResources().getXml(r4);     // Catch: Throwable -> L16
    L3:
        int r0 = r6.next();     // Catch: Throwable -> L16
        if (r0 == 2) goto L7;
        if (r0 != 1) goto L3;
    L7:
        if (r0 != 2) goto L15;
        if (TextUtils.equals(r6.getName(), r5) == false) goto L13;
        return Xml.asAttributeSet(r6);
    L13:
        throw new XmlPullParserException("Must have a <" + r5 + "> start tag");     // Catch: Throwable -> L16
    L15:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L16
    L16:
        e = move-exception;
        Resources.NotFoundException r7 = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(r4));
        r7.initCause(e);
        throw r7;
    }

    public static void setRippleDrawableRadius(RippleDrawable r0, int r1) {
        r0.setRadius(r1);
    }

    public static Drawable createTintableDrawableIfNeeded(Drawable r1, ColorStateList r2, PorterDuff.Mode r3) {
        return createTintableMutatedDrawableIfNeeded(r1, r2, r3, false);
    }

    public static Drawable createTintableMutatedDrawableIfNeeded(Drawable r1, ColorStateList r2, PorterDuff.Mode r3) {
        return createTintableMutatedDrawableIfNeeded(r1, r2, r3, false);
    }

    private static Drawable createTintableMutatedDrawableIfNeeded(Drawable r0, ColorStateList r1, PorterDuff.Mode r2, boolean r3) {
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r1 == null) goto L9;
        r0 = DrawableCompat.wrap(r0).mutate();
        if (r2 == null) goto L11;
        DrawableCompat.setTintMode(r0, r2);
    L11:
        return r0;
    L9:
        if (r3 == false) goto L11;
        r0.mutate();
        goto L11
    }

    public static Drawable compositeTwoLayeredDrawable(Drawable r5, Drawable r6) {
        if (r5 != null) goto L4;
        return r6;
    L4:
        if (r6 != null) goto L6;
        return r5;
    L6:
        LayerDrawable r0 = new LayerDrawable(new Drawable[]{r5, r6});
        if (r6.getIntrinsicWidth() != (-1)) goto L9;
    L20:
        int r7 = r5.getIntrinsicWidth();
        int r8 = r5.getIntrinsicHeight();
        int r9 = r7;
    L21:
        r0.setLayerSize(1, r9, r8);
        r0.setLayerGravity(1, 17);
        return r0;
    L9:
        if (r6.getIntrinsicHeight() == (-1)) goto L20;
        if (r6.getIntrinsicWidth() <= r5.getIntrinsicWidth()) goto L14;
    L16:
        float r1 = r6.getIntrinsicWidth() / r6.getIntrinsicHeight();
        if (r1 < (r5.getIntrinsicWidth() / r5.getIntrinsicHeight())) goto L19;
        r9 = r5.getIntrinsicWidth();
        r8 = (int) (r9 / r1);
        goto L21
    L19:
        r8 = r5.getIntrinsicHeight();
        r9 = (int) (r1 * r8);
        goto L21
    L14:
        if (r6.getIntrinsicHeight() > r5.getIntrinsicHeight()) goto L16;
        r9 = r6.getIntrinsicWidth();
        r8 = r6.getIntrinsicHeight();
        goto L21
    }

    public static int[] getCheckedState(int[] r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L12;
        int r1 = r3[r0];
        if (r1 == 16842912) goto L7;
        if (r1 == 0) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        int[] r4 = (int[]) r3.clone();
        r4[r0] = 16842912;
        return r4;
    L7:
        return r3;
    L12:
        int[] r2 = Arrays.copyOf(r3, r3.length + 1);
        r2[r3.length] = 16842912;
        return r2;
    }

    public static int[] getUncheckedState(int[] r6) {
        int[] r0 = new int[r6.length];
        int r1 = r6.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L8;
        int r4 = r6[r2];
        if (r4 == 16842912) goto L7;
        r0[r3] = r4;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    public static void setOutlineToPath(Outline r0, Path r1) {
        r0.setPath(r1);
    }
}
