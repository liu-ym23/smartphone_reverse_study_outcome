package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes17.dex */
public class PatternPathMotion extends PathMotion {
    private Path mOriginalPatternPath;
    private final Path mPatternPath;
    private final Matrix mTempMatrix;

    public PatternPathMotion() {
        Path r100 = new Path();
        this.mPatternPath = r100;
        this.mTempMatrix = new Matrix();
        r100.lineTo(1.0f, 0.0f);
        this.mOriginalPatternPath = r100;
    }

    public Path getPatternPath() {
        return this.mOriginalPatternPath;
    }

    public PatternPathMotion(Path r100) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        setPatternPath(r100);
    }

    public void setPatternPath(Path r100) {
        PathMeasure r101 = new PathMeasure(r100, false);
        float[] r102 = new float[2];
        r101.getPosTan(r101.getLength(), r102, null);
        float r103 = r102[0];
        float r104 = r102[1];
        r101.getPosTan(0.0f, r102, null);
        float r105 = r102[0];
        float r106 = r102[1];
        if (r105 == r103) goto L5;
    L9:
        this.mTempMatrix.setTranslate(-r105, -r106);
        float r107 = r103 - r105;
        float r108 = r104 - r106;
        float r109 = 1.0f / distance(r107, r108);
        this.mTempMatrix.postScale(r109, r109);
        this.mTempMatrix.postRotate((float) Math.toDegrees(-Math.atan2(r108, r107)));
        r100.transform(this.mTempMatrix, this.mPatternPath);
        this.mOriginalPatternPath = r100;
        return;
    L5:
        if (r106 != r104) goto L9;
        throw new IllegalArgumentException("pattern must not end at the starting point");
    }

    public PatternPathMotion(Context r100, AttributeSet r101) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        TypedArray r102 = r100.obtainStyledAttributes(r101, Styleable.PATTERN_PATH_MOTION);
        String r103 = TypedArrayUtils.getNamedString(r102, (XmlPullParser) r101, "patternPathData", 0);     // Catch: Throwable -> L10
        if (r103 == null) goto L9;
        setPatternPath(PathParser.createPathFromPathData(r103));     // Catch: Throwable -> L10
        r102.recycle();
        return;
    L9:
        throw new RuntimeException("pathData must be supplied for patternPathMotion");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r102.recycle();
        throw th;
    }

    private static float distance(float r100, float r101) {
        return (float) Math.sqrt((r100 * r100) + (r101 * r101));
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float r100, float r101, float r102, float r103) {
        float r104 = r102 - r100;
        float r105 = r103 - r101;
        float r106 = distance(r104, r105);
        double r107 = Math.atan2(r105, r104);
        this.mTempMatrix.setScale(r106, r106);
        this.mTempMatrix.postRotate((float) Math.toDegrees(r107));
        this.mTempMatrix.postTranslate(r100, r101);
        Path r108 = new Path();
        this.mPatternPath.transform(this.mTempMatrix, r108);
        return r108;
    }
}
