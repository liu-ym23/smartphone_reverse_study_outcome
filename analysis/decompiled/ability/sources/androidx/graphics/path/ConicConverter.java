package androidx.graphics.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0082 ¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/graphics/path/ConicConverter;", "", AppAgent.CONSTRUCT, "()V", "", "conicPoints", "", TypedValues.CycleType.S_WAVE_OFFSET, "quadraticPoints", "", "weight", "tolerance", "internalConicToQuadratics", "([FI[FFF)I", "points", "", "nextQuadratic", "([FI)Z", "LC7/r;", "convert", "([FFFI)V", "<set-?>", "quadraticCount", "I", "getQuadraticCount", "()I", "currentQuadratic", "getCurrentQuadratic", "setCurrentQuadratic", "(I)V", "quadraticData", "[F", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConicConverter {
    private int currentQuadratic;
    private int quadraticCount;
    private float[] quadraticData = new float[130];

    public static /* synthetic */ void convert$default(ConicConverter conicConverter, float[] fArr, float f, float f7, int i, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            i = 0;
        }
        conicConverter.convert(fArr, f, f7, i);
    }

    private final native int internalConicToQuadratics(float[] conicPoints, int offset, float[] quadraticPoints, float weight, float tolerance);

    public static /* synthetic */ boolean nextQuadratic$default(ConicConverter conicConverter, float[] fArr, int i, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        return conicConverter.nextQuadratic(fArr, i);
    }

    public final void convert(float[] points, float weight, float tolerance, int offset) {
        k.f(points, "points");
        int iInternalConicToQuadratics = internalConicToQuadratics(points, offset, this.quadraticData, weight, tolerance);
        this.quadraticCount = iInternalConicToQuadratics;
        int i = (iInternalConicToQuadratics * 4) + 2;
        if (i > this.quadraticData.length) {
            float[] fArr = new float[i];
            this.quadraticData = fArr;
            this.quadraticCount = internalConicToQuadratics(points, offset, fArr, weight, tolerance);
        }
        this.currentQuadratic = 0;
    }

    public final int getCurrentQuadratic() {
        return this.currentQuadratic;
    }

    public final int getQuadraticCount() {
        return this.quadraticCount;
    }

    public final boolean nextQuadratic(float[] points, int offset) {
        k.f(points, "points");
        int i = this.currentQuadratic;
        if (i >= this.quadraticCount) {
            return false;
        }
        int i6 = i * 4;
        float[] fArr = this.quadraticData;
        points[offset] = fArr[i6];
        points[offset + 1] = fArr[i6 + 1];
        points[offset + 2] = fArr[i6 + 2];
        points[offset + 3] = fArr[i6 + 3];
        points[offset + 4] = fArr[i6 + 4];
        points[offset + 5] = fArr[i6 + 5];
        this.currentQuadratic = i + 1;
        return true;
    }

    public final void setCurrentQuadratic(int i) {
        this.currentQuadratic = i;
    }
}
