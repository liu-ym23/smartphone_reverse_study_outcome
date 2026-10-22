package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;

/* JADX INFO: compiled from: PatternPathMotion.java */
/* JADX INFO: loaded from: classes.dex */
public class p extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Path f2849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f2850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f2851c;

    public p() {
        Path r0 = new Path();
        this.f2850b = r0;
        this.f2851c = new Matrix();
        r0.lineTo(1.0f, 0.0f);
        this.f2849a = r0;
    }

    public p(Path r2) {
        this.f2850b = new Path();
        this.f2851c = new Matrix();
        a(r2);
    }

    public void a(Path r9) {
        PathMeasure r0 = new PathMeasure(r9, false);
        float[] r3 = new float[2];
        r0.getPosTan(r0.getLength(), r3, null);
        float r2 = r3[0];
        float r6 = r3[1];
        r0.getPosTan(0.0f, r3, null);
        float r1 = r3[0];
        float r4 = r3[1];
        if (r1 == r2) goto L5;
    L9:
        this.f2851c.setTranslate(-r1, -r4);
        float r5 = r2 - r1;
        float r7 = r6 - r4;
        float r8 = 1.0f / a(r5, r7);
        this.f2851c.postScale(r8, r8);
        this.f2851c.postRotate((float) Math.toDegrees(-Math.atan2(r7, r5)));
        r9.transform(this.f2851c, this.f2850b);
        this.f2849a = r9;
        return;
    L5:
        if (r4 != r6) goto L9;
        throw new IllegalArgumentException("pattern must not end at the starting point");
    }

    @Override // androidx.transition.o
    public Path a(float r4, float r5, float r6, float r7) {
        float r8 = r6 - r4;
        float r9 = r7 - r5;
        float r0 = a(r8, r9);
        double r10 = Math.atan2(r9, r8);
        this.f2851c.setScale(r0, r0);
        this.f2851c.postRotate((float) Math.toDegrees(r10));
        this.f2851c.postTranslate(r4, r5);
        Path r11 = new Path();
        this.f2850b.transform(this.f2851c, r11);
        return r11;
    }

    private static float a(float r0, float r1) {
        return (float) Math.sqrt((r0 * r0) + (r1 * r1));
    }
}
