package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CanvasCompat {
    private CanvasCompat() {
    }

    public static int saveLayerAlpha(@NonNull Canvas r10, @Nullable RectF r11, int r12) {
        return r10.saveLayerAlpha(r11, r12);
    }

    public static int saveLayerAlpha(@NonNull Canvas r10, float r11, float r12, float r13, float r14, int r15) {
        return r10.saveLayerAlpha(r11, r12, r13, r14, r15);
    }
}
