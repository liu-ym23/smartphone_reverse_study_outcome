package M4;

import android.graphics.Matrix;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"LM4/m;", "", "<init>", "()V", "", "pagW", "pagH", "viewW", "viewH", "LL4/a;", "ratio", "LM4/m$a;", Const.INTENT_KEY_PKGNAME, "(FFFFLL4/a;)LM4/m$a;", "Lorg/libpag/PAGView;", "view", "Lorg/libpag/PAGFile;", Const.STR_FILE, "", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lorg/libpag/PAGView;Lorg/libpag/PAGFile;LL4/a;II)V", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f4635a = new m();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"LM4/m$a;", "", "", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "tx", "ty", "<init>", "(FFF)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "F", "()F", Const.INTENT_KEY_PKGNAME, "c", "agentsprite_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: M4.m$a, reason: from toString */
    public static final /* data */ class MatrixParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final float scale;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final float tx;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final float ty;

        public MatrixParams(float f10, float f11, float f12) {
            this.scale = f10;
            this.tx = f11;
            this.ty = f12;
        }

        /* renamed from: a, reason: from getter */
        public final float getScale() {
            return this.scale;
        }

        /* renamed from: b, reason: from getter */
        public final float getTx() {
            return this.tx;
        }

        /* renamed from: c, reason: from getter */
        public final float getTy() {
            return this.ty;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MatrixParams)) {
                return false;
            }
            MatrixParams matrixParams = (MatrixParams) other;
            return Float.compare(this.scale, matrixParams.scale) == 0 && Float.compare(this.tx, matrixParams.tx) == 0 && Float.compare(this.ty, matrixParams.ty) == 0;
        }

        public int hashCode() {
            return (((Float.hashCode(this.scale) * 31) + Float.hashCode(this.tx)) * 31) + Float.hashCode(this.ty);
        }

        public String toString() {
            return "MatrixParams(scale=" + this.scale + ", tx=" + this.tx + ", ty=" + this.ty + ")";
        }
    }

    public final void a(PAGView view, PAGFile file, L4.a ratio, int viewW, int viewH) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(ratio, "ratio");
        if (file == null) {
            return;
        }
        MatrixParams matrixParamsB = b(file.width(), file.height(), viewW, viewH, ratio);
        if (matrixParamsB == null) {
            view.setMatrix(new Matrix());
            view.setScaleMode(2);
            return;
        }
        view.setScaleMode(0);
        Matrix matrix = new Matrix();
        matrix.setScale(matrixParamsB.getScale(), matrixParamsB.getScale());
        matrix.postTranslate(matrixParamsB.getTx(), matrixParamsB.getTy());
        view.setMatrix(matrix);
    }

    public final MatrixParams b(float pagW, float pagH, float viewW, float viewH, L4.a ratio) {
        kotlin.jvm.internal.p.i(ratio, "ratio");
        if (ratio.a() || pagW <= 0.0f || pagH <= 0.0f || viewW <= 0.0f || viewH <= 0.0f) {
            return null;
        }
        float f10 = 0.33333334f * pagH;
        float f11 = pagH - f10;
        if (f11 <= 0.0f) {
            return null;
        }
        float fMin = Math.min(viewW / pagW, viewH / f11);
        return new MatrixParams(fMin, (viewW - (pagW * fMin)) / 2.0f, ((viewH - (f11 * fMin)) / 2.0f) - (f10 * fMin));
    }
}
