package androidx.compose.ui.graphics;

import android.graphics.Shader;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f2\u000e\u0010\r\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/TransformShader;", "", "<init>", "()V", "aMatrix", "Landroid/graphics/Matrix;", "obtainMatrix", "transform", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-Q8lPUPs", "([F)V", "value", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "shader", "getShader", "()Landroid/graphics/Shader;", "setShader", "(Landroid/graphics/Shader;)V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TransformShader {
    private android.graphics.Matrix aMatrix;
    private Shader shader;

    public TransformShader() {
    }

    private final android.graphics.Matrix obtainMatrix() {
        android.graphics.Matrix r100 = this.aMatrix;
        if (r100 != null) goto L6;
        android.graphics.Matrix r101 = new android.graphics.Matrix();
        this.aMatrix = r101;
        return r101;
    L6:
        return r100;
    }

    public final Shader getShader() {
        return this.shader;
    }

    public final void setShader(Shader r100) {
        android.graphics.Matrix r101 = this.aMatrix;
        if (r101 == null) goto L6;
        if (r100 == null) goto L6;
        r100.setLocalMatrix(r101);
    L6:
        this.shader = r100;
    }

    /* JADX INFO: renamed from: transform-Q8lPUPs, reason: not valid java name */
    public final void m5245transformQ8lPUPs(float[] r100) {
        if (r100 != null) goto L4;
        android.graphics.Matrix r101 = null;
        this.aMatrix = null;
    L5:
        Shader r102 = this.shader;
        if (r102 == null) goto L9;
        r102.setLocalMatrix(r101);
        return;
    L9:
        return;
    L4:
        android.graphics.Matrix r103 = obtainMatrix();
        AndroidMatrixConversions_androidKt.m4695setFromEL8BTi8(r103, r100);
        r101 = r103;
        goto L5
    }
}
