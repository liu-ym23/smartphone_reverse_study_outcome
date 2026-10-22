package androidx.core.graphics;

import android.graphics.Matrix;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003\u001a\u001a\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u001a\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0001H\u0086\b¨\u0006\u0010"}, d2 = {"rotationMatrix", "Landroid/graphics/Matrix;", "degrees", "", GXTemplateKey.GAIAX_PX, "py", "scaleMatrix", "sx", "sy", "translationMatrix", MapBundleKey.MapObjKey.OBJ_TEXT, "ty", "times", "m", "values", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MatrixKt {
    public static final float[] values(Matrix r100) {
        float[] r101 = new float[9];
        r100.getValues(r101);
        return r101;
    }

    public static final Matrix scaleMatrix(float r100, float r101) {
        Matrix r102 = new Matrix();
        r102.setScale(r100, r101);
        return r102;
    }

    public static final Matrix times(Matrix r100, Matrix r101) {
        Matrix r102 = new Matrix(r100);
        r102.preConcat(r101);
        return r102;
    }

    public static final Matrix translationMatrix(float r100, float r101) {
        Matrix r102 = new Matrix();
        r102.setTranslate(r100, r101);
        return r102;
    }

    public static final Matrix rotationMatrix(float r100, float r101, float r102) {
        Matrix r103 = new Matrix();
        r103.setRotate(r100, r101, r102);
        return r103;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float r100, float r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 1.0f;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = 1.0f;
    L9:
        return scaleMatrix(r100, r101);
    }

    public static /* synthetic */ Matrix translationMatrix$default(float r100, float r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0.0f;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = 0.0f;
    L9:
        return translationMatrix(r100, r101);
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = 0.0f;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = 0.0f;
    L9:
        return rotationMatrix(r100, r101, r102);
    }
}
