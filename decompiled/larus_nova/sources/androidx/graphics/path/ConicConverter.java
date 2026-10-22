package androidx.graphics.path;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0004J1\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0082 J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/graphics/path/ConicConverter;", "", "()V", "currentQuadratic", "", "getCurrentQuadratic", "()I", "setCurrentQuadratic", "(I)V", "<set-?>", "quadraticCount", "getQuadraticCount", "quadraticData", "", "convert", "", "points", "weight", "", "tolerance", "offset", "internalConicToQuadratics", "conicPoints", "quadraticPoints", "nextQuadratic", "", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConicConverter {
    private int currentQuadratic;
    private int quadraticCount;
    private float[] quadraticData;

    private final native int internalConicToQuadratics(float[] r100, int r101, float[] r102, float r103, float r104);

    public ConicConverter() {
        this.quadraticData = new float[130];
    }

    public final int getCurrentQuadratic() {
        return this.currentQuadratic;
    }

    public final int getQuadraticCount() {
        return this.quadraticCount;
    }

    public final void setCurrentQuadratic(int r100) {
        this.currentQuadratic = r100;
    }

    public final boolean nextQuadratic(float[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "points");
        int r102 = this.currentQuadratic;
        if (r102 >= this.quadraticCount) goto L6;
        int r103 = (r102 * 2) * 2;
        float[] r104 = this.quadraticData;
        r100[r101 + 0] = r104[r103];
        r100[r101 + 1] = r104[r103 + 1];
        r100[r101 + 2] = r104[r103 + 2];
        r100[r101 + 3] = r104[r103 + 3];
        r100[r101 + 4] = r104[r103 + 4];
        r100[r101 + 5] = r104[r103 + 5];
        this.currentQuadratic = r102 + 1;
        return true;
    L6:
        return false;
    }

    public final void convert(float[] r100, float r110, float r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "points");
        int r101 = internalConicToQuadratics(r100, r112, this.quadraticData, r110, r111);
        this.quadraticCount = r101;
        int r102 = ((r101 * 2) * 2) + 2;
        if (r102 <= this.quadraticData.length) goto L5;
        float[] r103 = new float[r102];
        this.quadraticData = r103;
        this.quadraticCount = internalConicToQuadratics(r100, r112, r103, r110, r111);
    L5:
        this.currentQuadratic = 0;
    }

    public static /* synthetic */ boolean nextQuadratic$default(ConicConverter r100, float[] r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.nextQuadratic(r101, r102);
    }

    public static /* synthetic */ void convert$default(ConicConverter r100, float[] r101, float r102, float r103, int r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = 0;
    L5:
        r100.convert(r101, r102, r103, r104);
    }
}
