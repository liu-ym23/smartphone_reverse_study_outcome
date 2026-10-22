package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.a;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    private Typeface font;

    @Nullable
    public final String fontFamily;

    @FontRes
    private final int fontFamilyResourceId;
    private boolean fontResolved;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;

    @Nullable
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;

    @Nullable
    public final ColorStateList textColor;

    @Nullable
    public final ColorStateList textColorHint;

    @Nullable
    public final ColorStateList textColorLink;
    public float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(@NonNull Context r10, @StyleRes int r11) {
        this.fontResolved = false;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.TextAppearance);
        this.textSize = r12.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.textColor = MaterialResources.getColorStateList(r10, r12, R.styleable.TextAppearance_android_textColor);
        this.textColorHint = MaterialResources.getColorStateList(r10, r12, R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(r10, r12, R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = r12.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = r12.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int r13 = MaterialResources.getIndexWithValue(r12, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = r12.getResourceId(r13, 0);
        this.fontFamily = r12.getString(r13);
        this.textAllCaps = r12.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(r10, r12, R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = r12.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = r12.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = r12.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        r12.recycle();
        TypedArray r14 = r10.obtainStyledAttributes(r11, R.styleable.MaterialTextAppearance);
        int r15 = R.styleable.MaterialTextAppearance_android_letterSpacing;
        this.hasLetterSpacing = r14.hasValue(r15);
        this.letterSpacing = r14.getFloat(r15, 0.0f);
        r14.recycle();
    }

    public static /* synthetic */ Typeface access$000(TextAppearance r10) {
        return r10.font;
    }

    public static /* synthetic */ Typeface access$002(TextAppearance r10, Typeface r11) {
        r10.font = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$102(TextAppearance r10, boolean r11) {
        r10.fontResolved = r11;
        return r11;
    }

    private void createFallbackFont() {
        if (this.font != null) goto L8;
        String r10 = this.fontFamily;
        if (r10 == null) goto L8;
        this.font = Typeface.create(r10, this.textStyle);
    L8:
        if (this.font != null) goto L21;
        int r11 = this.typeface;
        if (r11 != 1) goto L12;
        this.font = Typeface.SANS_SERIF;
    L19:
        this.font = Typeface.create(this.font, this.textStyle);
        return;
    L12:
        if (r11 != 2) goto L14;
        this.font = Typeface.SERIF;
        goto L19
    L14:
        if (r11 == 3) goto L16;
        this.font = Typeface.DEFAULT;
        goto L19
    L16:
        this.font = Typeface.MONOSPACE;
        goto L19
    }

    private boolean shouldLoadFontSynchronously(Context r10) {
        if (TextAppearanceConfig.shouldLoadFontSynchronously() == false) goto L5;
        return true;
    L5:
        int r11 = this.fontFamilyResourceId;
        if (r11 == 0) goto L8;
        Typeface r12 = a.c(r10, r11);
    L9:
        if (r12 != null) goto L13;
        return false;
    L13:
        return true;
    L8:
        r12 = null;
        goto L9
    }

    public Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
    }

    @NonNull
    @VisibleForTesting
    public Typeface getFont(@NonNull Context r10) {
        if (this.fontResolved == false) goto L7;
        return this.font;
    L7:
        if (r10.isRestricted() == false) goto L17;
    L14:
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    L17:
        Typeface r11 = a.h(r10, this.fontFamilyResourceId);     // Catch: Exception -> L12 Throwable -> L16
        this.font = r11;     // Catch: Exception -> L12 Throwable -> L16
        if (r11 == null) goto L14;
        this.font = Typeface.create(r11, this.textStyle);     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        Log.d(TAG, "Error loading font " + this.fontFamily, e);
        goto L14
    }

    public void getFontAsync(@NonNull Context r10, @NonNull final TextAppearanceFontCallback r11) {
        if (shouldLoadFontSynchronously(r10) == false) goto L5;
        getFont(r10);
    L6:
        int r12 = this.fontFamilyResourceId;
        if (r12 != 0) goto L10;
        this.fontResolved = true;
    L10:
        if (this.fontResolved == false) goto L19;
        r11.onFontRetrieved(this.font, true);
        return;
    L19:
        a.j(r10, r12, new AnonymousClass1(this, r11), null);     // Catch: Exception -> L15 Resources.NotFoundException -> L17
    L22:
        return;
    L17:
        this.fontResolved = true;
        r11.onFontRetrievalFailed(1);
        return;
    L15:
        e = move-exception;
        Log.d(TAG, "Error loading font " + this.fontFamily, e);
        this.fontResolved = true;
        r11.onFontRetrievalFailed(-3);
        return;
    L5:
        createFallbackFont();
        goto L6
    }

    public void updateDrawState(@NonNull Context r10, @NonNull TextPaint r11, @NonNull TextAppearanceFontCallback r12) {
        updateMeasureState(r10, r11, r12);
        ColorStateList r13 = this.textColor;
        if (r13 == null) goto L5;
        int r14 = r13.getColorForState(r11.drawableState, r13.getDefaultColor());
    L6:
        r11.setColor(r14);
        float r15 = this.shadowRadius;
        float r16 = this.shadowDx;
        float r17 = this.shadowDy;
        ColorStateList r18 = this.shadowColor;
        if (r18 == null) goto L9;
        int r19 = r18.getColorForState(r11.drawableState, r18.getDefaultColor());
    L10:
        r11.setShadowLayer(r15, r16, r17, r19);
        return;
    L9:
        r19 = 0;
        goto L10
    L5:
        r14 = -16777216;
        goto L6
    }

    public void updateMeasureState(@NonNull Context r10, @NonNull TextPaint r11, @NonNull TextAppearanceFontCallback r12) {
        if (shouldLoadFontSynchronously(r10) == false) goto L5;
        updateTextPaintMeasureState(r11, getFont(r10));
        return;
    L5:
        getFontAsync(r10, r11, r12);
    }

    public void updateTextPaintMeasureState(@NonNull TextPaint r10, @NonNull Typeface r11) {
        r10.setTypeface(r11);
        int r12 = this.textStyle;
        int r13 = (~r11.getStyle()) & r12;
        if ((r13 & 1) == 0) goto L5;
        boolean r14 = true;
    L6:
        r10.setFakeBoldText(r14);
        if ((r13 & 2) == 0) goto L9;
        float r15 = -0.25f;
    L10:
        r10.setTextSkewX(r15);
        r10.setTextSize(this.textSize);
        if (this.hasLetterSpacing == false) goto L14;
        r10.setLetterSpacing(this.letterSpacing);
        return;
    L14:
        return;
    L9:
        r15 = 0.0f;
        goto L10
    L5:
        r14 = false;
        goto L6
    }

    public void getFontAsync(@NonNull Context r10, @NonNull final TextPaint r11, @NonNull final TextAppearanceFontCallback r12) {
        updateTextPaintMeasureState(r11, getFallbackFont());
        getFontAsync(r10, new AnonymousClass2(this, r11, r12));
    }
}
