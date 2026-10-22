package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u000fJ\u001d\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00052\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0016J\u001d\u0010\u0015\u001a\u00020\u00182\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001bR&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010%R\u0016\u0010'\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010%¨\u0006)"}, d2 = {"Landroidx/compose/ui/platform/LayerMatrixCache;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/Function2;", "Landroid/graphics/Matrix;", "LC7/r;", "getMatrix", AppAgent.CONSTRUCT, "(LS7/n;)V", "reset", "()V", "invalidate", TypedValues.AttributesType.S_TARGET, "Landroidx/compose/ui/graphics/Matrix;", "calculateMatrix-GrdbGEg", "(Ljava/lang/Object;)[F", "calculateMatrix", "calculateInverseMatrix-bWbORWo", "calculateInverseMatrix", "Landroidx/compose/ui/geometry/MutableRect;", "rect", "map", "(Ljava/lang/Object;Landroidx/compose/ui/geometry/MutableRect;)V", "mapInverse", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "map-R5De75A", "(Ljava/lang/Object;J)J", "mapInverse-R5De75A", "LS7/n;", "androidMatrixCache", "Landroid/graphics/Matrix;", "matrixCache", "[F", "inverseMatrixCache", "", "isDirty", "Z", "isInverseDirty", "isInverseValid", "isIdentity", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayerMatrixCache<T> {
    public static final int $stable = 8;
    private Matrix androidMatrixCache;
    private final S7.n getMatrix;
    private boolean isDirty;
    private boolean isInverseDirty;
    private float[] matrixCache = androidx.compose.ui.graphics.Matrix.m4380constructorimpl$default(null, 1, null);
    private float[] inverseMatrixCache = androidx.compose.ui.graphics.Matrix.m4380constructorimpl$default(null, 1, null);
    private boolean isInverseValid = true;
    private boolean isIdentity = true;

    public LayerMatrixCache(S7.n nVar) {
        this.getMatrix = nVar;
    }

    /* renamed from: calculateInverseMatrix-bWbORWo, reason: not valid java name */
    public final float[] m6020calculateInverseMatrixbWbORWo(T target) {
        float[] fArr = this.inverseMatrixCache;
        if (this.isInverseDirty) {
            this.isInverseValid = InvertMatrixKt.m6018invertToJiSxe2E(m6021calculateMatrixGrdbGEg(target), fArr);
            this.isInverseDirty = false;
        }
        if (this.isInverseValid) {
            return fArr;
        }
        return null;
    }

    /* renamed from: calculateMatrix-GrdbGEg, reason: not valid java name */
    public final float[] m6021calculateMatrixGrdbGEg(T target) {
        float[] fArr = this.matrixCache;
        if (!this.isDirty) {
            return fArr;
        }
        Matrix matrix = this.androidMatrixCache;
        if (matrix == null) {
            matrix = new Matrix();
            this.androidMatrixCache = matrix;
        }
        this.getMatrix.invoke(target, matrix);
        AndroidMatrixConversions_androidKt.m4008setFromtUYjHk(fArr, matrix);
        this.isDirty = false;
        this.isIdentity = MatrixKt.m4405isIdentity58bKbWc(fArr);
        return fArr;
    }

    public final void invalidate() {
        this.isDirty = true;
        this.isInverseDirty = true;
    }

    public final void map(T target, MutableRect rect) {
        float[] fArrM6021calculateMatrixGrdbGEg = m6021calculateMatrixGrdbGEg(target);
        if (this.isIdentity) {
            return;
        }
        androidx.compose.ui.graphics.Matrix.m4388mapimpl(fArrM6021calculateMatrixGrdbGEg, rect);
    }

    /* renamed from: map-R5De75A, reason: not valid java name */
    public final long m6022mapR5De75A(T target, long offset) {
        return !this.isIdentity ? androidx.compose.ui.graphics.Matrix.m4386mapMKHz9U(m6021calculateMatrixGrdbGEg(target), offset) : offset;
    }

    public final void mapInverse(T target, MutableRect rect) {
        float[] fArrM6020calculateInverseMatrixbWbORWo = m6020calculateInverseMatrixbWbORWo(target);
        if (fArrM6020calculateInverseMatrixbWbORWo == null) {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            if (this.isIdentity) {
                return;
            }
            androidx.compose.ui.graphics.Matrix.m4388mapimpl(fArrM6020calculateInverseMatrixbWbORWo, rect);
        }
    }

    /* renamed from: mapInverse-R5De75A, reason: not valid java name */
    public final long m6023mapInverseR5De75A(T target, long offset) {
        float[] fArrM6020calculateInverseMatrixbWbORWo = m6020calculateInverseMatrixbWbORWo(target);
        return fArrM6020calculateInverseMatrixbWbORWo == null ? Offset.INSTANCE.m3909getInfiniteF1C5BW0() : !this.isIdentity ? androidx.compose.ui.graphics.Matrix.m4386mapMKHz9U(fArrM6020calculateInverseMatrixbWbORWo, offset) : offset;
    }

    public final void reset() {
        this.isDirty = false;
        this.isInverseDirty = false;
        this.isIdentity = true;
        this.isInverseValid = true;
        androidx.compose.ui.graphics.Matrix.m4389resetimpl(this.matrixCache);
        androidx.compose.ui.graphics.Matrix.m4389resetimpl(this.inverseMatrixCache);
    }
}
