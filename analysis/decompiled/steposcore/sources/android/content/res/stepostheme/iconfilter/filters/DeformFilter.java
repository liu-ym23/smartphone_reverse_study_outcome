package android.content.res.stepostheme.iconfilter.filters;

import android.content.res.stepostheme.iconfilter.utils.ShapeUtils;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;

/* loaded from: classes.dex */
public class DeformFilter extends BaseFilter {
    private Matrix mDeformMatrix;
    private int mTransToX;
    private int mTransToY;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private float mSkewX = 0.0f;
    private float mSkewY = 0.0f;
    private float mRotateDegree = 0.0f;
    private boolean isAvailable = true;
    private PaintFlagsDrawFilter pfd = new PaintFlagsDrawFilter(0, 3);
    private Paint mPaint = new Paint();

    public DeformFilter() {
        this.mPaint.setAntiAlias(true);
    }

    public void setPoint(Point point1, Point point2, Point point3, Point point4) {
        if (point1 == null) {
            point1 = new Point(0, 0);
        }
        if (point2 == null) {
            point2 = new Point(90, 0);
        }
        if (point3 == null) {
            point3 = new Point(90, 90);
        }
        if (point4 == null) {
            point4 = new Point(0, 90);
        }
        boolean zIsCanFormParallelogram = ShapeUtils.isCanFormParallelogram(point1, point2, point3, point4);
        this.isAvailable = zIsCanFormParallelogram;
        if (zIsCanFormParallelogram) {
            this.mTransToX = point1.x;
            this.mTransToY = point1.y;
            this.mScaleX = (point2.x - point1.x) / 90.0f;
            this.mScaleY = (point4.y - point1.y) / 90.0f;
            if (this.mScaleX == 0.0f) {
                this.mSkewY = 0.0f;
                this.mSkewX = 0.0f;
                this.mScaleX = (point2.y - point1.y) / 90.0f;
                this.mScaleY = (point1.x - point4.x) / 90.0f;
                int i = point1.y;
                int i2 = point2.y;
                this.mRotateDegree = 90.0f;
            } else {
                this.mRotateDegree = 0.0f;
                this.mSkewX = ((point1.x - point4.x) * 1.0f) / (point1.y - point4.y);
                this.mSkewY = ((point1.y - point2.y) * 1.0f) / (point1.x - point2.x);
            }
            createDeformMatrix();
        }
    }

    private void createDeformMatrix() {
        this.mDeformMatrix = new Matrix();
        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(this.mScaleX, this.mScaleY, 0.0f, 0.0f);
        if (this.mRotateDegree != 0.0f) {
            Matrix rotateMatrix = new Matrix();
            rotateMatrix.setRotate(this.mRotateDegree, 0.0f, 0.0f);
            this.mDeformMatrix.setConcat(scaleMatrix, rotateMatrix);
        } else {
            Matrix skewMatrix = new Matrix();
            skewMatrix.setSkew(this.mSkewX, this.mSkewY);
            this.mDeformMatrix.setConcat(scaleMatrix, skewMatrix);
        }
    }

    @Override // android.content.res.stepostheme.iconfilter.filters.BaseFilter
    public Bitmap filter(Bitmap bitmap) {
        if (!this.isAvailable) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.set(this.mDeformMatrix);
        matrix.postTranslate((this.mTransToX / 90.0f) * width, (this.mTransToY / 90.0f) * height);
        Bitmap dstBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(dstBitmap);
        canvas.setDrawFilter(this.pfd);
        canvas.drawBitmap(bitmap, matrix, this.mPaint);
        return dstBitmap;
    }
}
