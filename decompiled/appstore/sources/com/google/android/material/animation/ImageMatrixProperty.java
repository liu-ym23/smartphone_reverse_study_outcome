package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class ImageMatrixProperty extends Property<ImageView, Matrix> {
    private final Matrix matrix;

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        this.matrix = new Matrix();
    }

    @Override // android.util.Property
    @NonNull
    public /* bridge */ /* synthetic */ Matrix get(@NonNull ImageView r10) {
        return get2(r10);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(@NonNull ImageView r10, @NonNull Matrix r11) {
        set2(r10, r11);
    }

    @NonNull
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Matrix get2(@NonNull ImageView r10) {
        this.matrix.set(r10.getImageMatrix());
        return this.matrix;
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(@NonNull ImageView r10, @NonNull Matrix r11) {
        r10.setImageMatrix(r11);
    }
}
