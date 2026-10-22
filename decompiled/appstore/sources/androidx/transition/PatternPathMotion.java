package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class PatternPathMotion extends PathMotion {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f4981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f4982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f4983c;

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(@NonNull Context r10, @NonNull AttributeSet r11) {
        this.f4982b = new Path();
        this.f4983c = new Matrix();
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.f5004k);
        String r13 = n.g.e(r12, (XmlPullParser) r11, "patternPathData", 0);     // Catch: Throwable -> L8
        if (r13 == null) goto L11;
        b(androidx.core.graphics.g.d(r13));     // Catch: Throwable -> L8
        r12.recycle();
        return;
    L11:
        throw new RuntimeException("pathData must be supplied for patternPathMotion");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    public static float a(float r10, float r11) {
        return (float) Math.sqrt((r10 * r10) + (r11 * r11));
    }

    public void b(Path r10) {
        PathMeasure r11 = new PathMeasure(r10, false);
        float[] r12 = new float[2];
        r11.getPosTan(r11.getLength(), r12, null);
        float r13 = r12[0];
        float r14 = r12[1];
        r11.getPosTan(0.0f, r12, null);
        float r15 = r12[0];
        float r16 = r12[1];
        if (r15 == r13) goto L5;
    L9:
        this.f4983c.setTranslate(-r15, -r16);
        float r17 = r13 - r15;
        float r18 = r14 - r16;
        float r19 = 1.0f / a(r17, r18);
        this.f4983c.postScale(r19, r19);
        this.f4983c.postRotate((float) Math.toDegrees(-Math.atan2(r18, r17)));
        r10.transform(this.f4983c, this.f4982b);
        this.f4981a = r10;
        return;
    L5:
        if (r16 != r14) goto L9;
        throw new IllegalArgumentException("pattern must not end at the starting point");
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float r10, float r11, float r12, float r13) {
        float r14 = r12 - r10;
        float r15 = r13 - r11;
        float r16 = a(r14, r15);
        double r17 = Math.atan2(r15, r14);
        this.f4983c.setScale(r16, r16);
        this.f4983c.postRotate((float) Math.toDegrees(r17));
        this.f4983c.postTranslate(r10, r11);
        Path r18 = new Path();
        this.f4982b.transform(this.f4983c, r18);
        return r18;
    }

    public PatternPathMotion(Path r10) {
        this.f4982b = new Path();
        this.f4983c = new Matrix();
        b(r10);
    }
}
