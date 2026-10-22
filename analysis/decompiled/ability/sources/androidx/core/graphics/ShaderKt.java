package androidx.core.graphics;

import S7.k;
import android.graphics.Matrix;
import android.graphics.Shader;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/graphics/Shader;", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "LC7/r;", "block", "transform", "(Landroid/graphics/Shader;LS7/k;)V", "core-ktx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShaderKt {
    public static final void transform(Shader shader, k kVar) {
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        kVar.invoke(matrix);
        shader.setLocalMatrix(matrix);
    }
}
