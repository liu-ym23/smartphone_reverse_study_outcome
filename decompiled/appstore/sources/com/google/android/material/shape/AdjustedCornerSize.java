package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AdjustedCornerSize implements CornerSize {
    private final float adjustment;
    private final CornerSize other;

    public AdjustedCornerSize(float r10, @NonNull CornerSize r11) {
    L4:
        if ((r11 instanceof AdjustedCornerSize) == false) goto L6;
        r11 = ((AdjustedCornerSize) r11).other;
        r10 = r10 + ((AdjustedCornerSize) r11).adjustment;
        goto L4
    L6:
        this.other = r11;
        this.adjustment = r10;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AdjustedCornerSize) == true) goto L8;
        return false;
    L8:
        AdjustedCornerSize r11 = (AdjustedCornerSize) r10;
        if (this.other.equals(r11.other) == false) goto L14;
        if (this.adjustment != r11.adjustment) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@NonNull RectF r10) {
        return Math.max(0.0f, this.other.getCornerSize(r10) + this.adjustment);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.other, Float.valueOf(this.adjustment)});
    }
}
