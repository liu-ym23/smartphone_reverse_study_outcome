package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextDrawableHelper {

    @Nullable
    private WeakReference<TextDrawableDelegate> delegate;
    private final TextAppearanceFontCallback fontCallback;

    @Nullable
    private TextAppearance textAppearance;
    private final TextPaint textPaint;
    private float textWidth;
    private boolean textWidthDirty;

    public interface TextDrawableDelegate {
        @NonNull
        int[] getState();

        boolean onStateChange(int[] r10);

        void onTextSizeChange();
    }

    public TextDrawableHelper(@Nullable TextDrawableDelegate r10) {
        this.textPaint = new TextPaint(1);
        this.fontCallback = new AnonymousClass1(this);
        this.textWidthDirty = true;
        this.delegate = new WeakReference(null);
        setDelegate(r10);
    }

    public static /* synthetic */ boolean access$002(TextDrawableHelper r10, boolean r11) {
        r10.textWidthDirty = r11;
        return r11;
    }

    public static /* synthetic */ WeakReference access$100(TextDrawableHelper r10) {
        return r10.delegate;
    }

    private float calculateTextWidth(@Nullable CharSequence r10) {
        if (r10 != null) goto L6;
        return 0.0f;
    L6:
        return this.textPaint.measureText(r10, 0, r10.length());
    }

    @Nullable
    public TextAppearance getTextAppearance() {
        return this.textAppearance;
    }

    @NonNull
    public TextPaint getTextPaint() {
        return this.textPaint;
    }

    public float getTextWidth(String r10) {
        if (this.textWidthDirty == false) goto L5;
        float r11 = calculateTextWidth(r10);
        this.textWidth = r11;
        this.textWidthDirty = false;
        return r11;
    L5:
        return this.textWidth;
    }

    public boolean isTextWidthDirty() {
        return this.textWidthDirty;
    }

    public void setDelegate(@Nullable TextDrawableDelegate r10) {
        this.delegate = new WeakReference(r10);
    }

    public void setTextAppearance(@Nullable TextAppearance r10, Context r11) {
        if (this.textAppearance == r10) goto L14;
        this.textAppearance = r10;
        if (r10 == null) goto L10;
        r10.updateMeasureState(r11, this.textPaint, this.fontCallback);
        TextDrawableDelegate r12 = this.delegate.get();
        if (r12 == null) goto L9;
        TextPaint r13 = this.textPaint;
        r13.drawableState = r12.getState();
    L9:
        r10.updateDrawState(r11, this.textPaint, this.fontCallback);
        this.textWidthDirty = true;
    L10:
        TextDrawableDelegate r14 = this.delegate.get();
        if (r14 == null) goto L15;
        r14.onTextSizeChange();
        r14.onStateChange(r14.getState());
        return;
    L15:
        return;
    }

    public void setTextWidthDirty(boolean r10) {
        this.textWidthDirty = r10;
    }

    public void updateTextPaintDrawState(Context r10) {
        this.textAppearance.updateDrawState(r10, this.textPaint, this.fontCallback);
    }
}
