package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes17.dex */
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    private void initPath(Path r110) {
        int r100 = 0;
        PathMeasure r101 = new PathMeasure(r110, false);
        float r111 = r101.getLength();
        int r102 = Math.min(3000, ((int) (r111 / 0.002f)) + 1);
        if (r102 <= 0) goto L30;
        this.mX = new float[r102];
        this.mY = new float[r102];
        float[] r103 = new float[2];
        int r104 = 0;
    L5:
        if (r104 >= r102) goto L8;
        r101.getPosTan((r104 * r111) / (r102 - 1), r103, null);
        this.mX[r104] = r103[0];
        this.mY[r104] = r103[1];
        r104 = r104 + 1;
        goto L5
    L8:
        if (Math.abs(this.mX[0]) <= 1.0E-5d) goto L10;
    L27:
        StringBuilder r105 = new StringBuilder("The Path must start at (0,0) and end at (1,1) start: ");
        r105.append(this.mX[0]);
        r105.append(",");
        r105.append(this.mY[0]);
        r105.append(" end:");
        int r106 = r102 - 1;
        r105.append(this.mX[r106]);
        r105.append(",");
        r105.append(this.mY[r106]);
        throw new IllegalArgumentException(r105.toString());
    L10:
        if (Math.abs(this.mY[0]) > 1.0E-5d) goto L27;
        int r107 = r102 - 1;
        if (Math.abs(this.mX[r107] - 1.0f) > 1.0E-5d) goto L27;
        if (Math.abs(this.mY[r107] - 1.0f) > 1.0E-5d) goto L27;
        float r112 = 0.0f;
        int r108 = 0;
    L16:
        if (r100 >= r102) goto L23;
        float[] r109 = this.mX;
        int r113 = r108 + 1;
        float r114 = r109[r108];
        if (r114 < r112) goto L21;
        r109[r100] = r114;
        r100 = r100 + 1;
        r112 = r114;
        r108 = r113;
        goto L16
    L21:
        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + r114);
    L23:
        if (r101.nextContour() == true) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
    L30:
        throw new IllegalArgumentException("The Path has a invalid length " + r111);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r100) {
        if (r100 > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r100 < 1.0f) goto L8;
        return 1.0f;
    L8:
        int r101 = this.mX.length - 1;
        int r102 = 0;
    L10:
        if ((r101 - r102) <= 1) goto L15;
        int r103 = (r102 + r101) / 2;
        if (r100 < this.mX[r103]) goto L13;
        r102 = r103;
        goto L10
    L13:
        r101 = r103;
        goto L10
    L15:
        float[] r104 = this.mX;
        float r105 = r104[r101];
        float r106 = r104[r102];
        float r107 = r105 - r106;
        if (r107 == 0.0f) goto L18;
        float r108 = (r100 - r106) / r107;
        float[] r109 = this.mY;
        float r110 = r109[r102];
        return r110 + (r108 * (r109[r101] - r110));
    L18:
        return this.mY[r102];
    }

    private void initQuad(float r100, float r101) {
        Path r102 = new Path();
        r102.moveTo(0.0f, 0.0f);
        r102.quadTo(r100, r101, 1.0f, 1.0f);
        initPath(r102);
    }

    private void parseInterpolatorFromTypeArray(TypedArray r100, XmlPullParser r101) {
        if (TypedArrayUtils.hasAttribute(r101, "pathData") == false) goto L10;
        String r102 = TypedArrayUtils.getNamedString(r100, r101, "pathData", 4);
        Path r103 = PathParser.createPathFromPathData(r102);
        if (r103 == null) goto L8;
        initPath(r103);
        return;
    L8:
        throw new InflateException("The path is null, which is created from " + r102);
    L10:
        if (TypedArrayUtils.hasAttribute(r101, "controlX1") == false) goto L24;
        if (TypedArrayUtils.hasAttribute(r101, "controlY1") == false) goto L22;
        float r104 = TypedArrayUtils.getNamedFloat(r100, r101, "controlX1", 0, 0.0f);
        float r105 = TypedArrayUtils.getNamedFloat(r100, r101, "controlY1", 1, 0.0f);
        boolean r106 = TypedArrayUtils.hasAttribute(r101, "controlX2");
        if (r106 != TypedArrayUtils.hasAttribute(r101, "controlY2")) goto L20;
        if (r106 == true) goto L17;
        initQuad(r104, r105);
        return;
    L17:
        initCubic(r104, r105, TypedArrayUtils.getNamedFloat(r100, r101, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(r100, r101, "controlY2", 3, 0.0f));
        return;
    L20:
        throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
    L22:
        throw new InflateException("pathInterpolator requires the controlY1 attribute");
    L24:
        throw new InflateException("pathInterpolator requires the controlX1 attribute");
    }

    public PathInterpolatorCompat(Context r100, AttributeSet r101, XmlPullParser r102) {
        this(r100.getResources(), r100.getTheme(), r101, r102);
    }

    public PathInterpolatorCompat(Resources r100, Resources.Theme r101, AttributeSet r102, XmlPullParser r103) {
        TypedArray r104 = TypedArrayUtils.obtainAttributes(r100, r101, r102, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(r104, r103);
        r104.recycle();
    }

    private void initCubic(float r100, float r110, float r111, float r112) {
        Path r101 = new Path();
        r101.moveTo(0.0f, 0.0f);
        r101.cubicTo(r100, r110, r111, r112, 1.0f, 1.0f);
        initPath(r101);
    }
}
