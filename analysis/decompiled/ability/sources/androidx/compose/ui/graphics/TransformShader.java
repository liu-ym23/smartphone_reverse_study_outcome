package androidx.compose.ui.graphics;

import android.graphics.Shader;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR:\u0010\u0012\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00102\u000e\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00108\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/graphics/TransformShader;", "", AppAgent.CONSTRUCT, "()V", "Landroid/graphics/Matrix;", "obtainMatrix", "()Landroid/graphics/Matrix;", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "LC7/r;", "transform-Q8lPUPs", "([F)V", "transform", "aMatrix", "Landroid/graphics/Matrix;", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "value", "shader", "Landroid/graphics/Shader;", "getShader", "()Landroid/graphics/Shader;", "setShader", "(Landroid/graphics/Shader;)V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransformShader {
    private android.graphics.Matrix aMatrix;
    private Shader shader;

    private final android.graphics.Matrix obtainMatrix() {
        android.graphics.Matrix matrix = this.aMatrix;
        if (matrix != null) {
            return matrix;
        }
        android.graphics.Matrix matrix2 = new android.graphics.Matrix();
        this.aMatrix = matrix2;
        return matrix2;
    }

    public final Shader getShader() {
        return this.shader;
    }

    public final void setShader(Shader shader) {
        android.graphics.Matrix matrix = this.aMatrix;
        if (matrix != null && shader != null) {
            shader.setLocalMatrix(matrix);
        }
        this.shader = shader;
    }

    /* renamed from: transform-Q8lPUPs, reason: not valid java name */
    public final void m4547transformQ8lPUPs(float[] matrix) {
        android.graphics.Matrix matrix2;
        if (matrix == null) {
            matrix2 = null;
            this.aMatrix = null;
        } else {
            android.graphics.Matrix matrixObtainMatrix = obtainMatrix();
            AndroidMatrixConversions_androidKt.m4007setFromEL8BTi8(matrixObtainMatrix, matrix);
            matrix2 = matrixObtainMatrix;
        }
        Shader shader = this.shader;
        if (shader != null) {
            shader.setLocalMatrix(matrix2);
        }
    }
}
