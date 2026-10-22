package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ImageMatrixProperty extends Property<ImageView, Matrix> {
    private final Matrix matrix;

    @Override // android.util.Property
    public /* synthetic */ Matrix get(ImageView r3) {
        return get2((ImageView) ZeusTransformUtils.preCheckCast(r3, ImageView.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.util.Property
    public /* synthetic */ void set(ImageView r3, Matrix r4) {
        set2((ImageView) ZeusTransformUtils.preCheckCast(r3, ImageView.class, "com.obric.aiagent.plugin"), (Matrix) ZeusTransformUtils.preCheckCast(r4, Matrix.class, "com.obric.aiagent.plugin"));
    }

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        this.matrix = new Matrix();
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(ImageView r1, Matrix r2) {
        r1.setImageMatrix(r2);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Matrix get2(ImageView r2) {
        this.matrix.set(r2.getImageMatrix());
        return this.matrix;
    }
}
