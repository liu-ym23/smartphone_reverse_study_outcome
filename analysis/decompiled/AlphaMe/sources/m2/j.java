package m2;

import android.graphics.Path;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public float[] f13575a;

    public final void a(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        float[] fArr = this.f13575a;
        path.cubicTo(fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]);
        path.cubicTo(fArr[8], fArr[9], fArr[10], fArr[11], fArr[12], fArr[13]);
    }

    public final void b() {
        float[] fArr = this.f13575a;
        float f4 = fArr[0];
        float f5 = fArr[1];
        fArr[0] = fArr[12];
        fArr[1] = fArr[13];
        fArr[12] = f4;
        fArr[13] = f5;
        float f6 = fArr[2];
        float f7 = fArr[3];
        fArr[2] = fArr[10];
        fArr[3] = fArr[11];
        fArr[10] = f6;
        fArr[11] = f7;
        float f8 = fArr[4];
        float f9 = fArr[5];
        fArr[4] = fArr[8];
        fArr[5] = fArr[9];
        fArr[8] = f8;
        fArr[9] = f9;
    }
}
