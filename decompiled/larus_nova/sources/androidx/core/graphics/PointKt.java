package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\r\u001a\u00020\u0002*\u00020\u0004H\u0086\b\u001a\r\u0010\u000e\u001a\u00020\u0004*\u00020\u0002H\u0086\b\u001a\r\u0010\u000f\u001a\u00020\u0002*\u00020\u0002H\u0086\n\u001a\r\u0010\u000f\u001a\u00020\u0004*\u00020\u0004H\u0086\n¨\u0006\u0010"}, d2 = {"component1", "", "Landroid/graphics/Point;", "", "Landroid/graphics/PointF;", "component2", "div", "scalar", "minus", "p", "xy", "plus", "times", "toPoint", "toPointF", "unaryMinus", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PointKt {
    public static final float component1(PointF r100) {
        return r100.x;
    }

    public static final float component2(PointF r100) {
        return r100.y;
    }

    public static final Point toPoint(PointF r100) {
        return new Point((int) r100.x, (int) r100.y);
    }

    public static final PointF toPointF(Point r100) {
        return new PointF(r100);
    }

    public static final Point unaryMinus(Point r100) {
        return new Point(-r100.x, -r100.y);
    }

    public static final int component1(Point r100) {
        return r100.x;
    }

    public static final int component2(Point r100) {
        return r100.y;
    }

    public static final PointF unaryMinus(PointF r100) {
        return new PointF(-r100.x, -r100.y);
    }

    public static final Point div(Point r100, float r101) {
        return new Point(Math.round(r100.x / r101), Math.round(r100.y / r101));
    }

    public static final Point minus(Point r100, Point r101) {
        Point r102 = new Point(r100.x, r100.y);
        r102.offset(-r101.x, -r101.y);
        return r102;
    }

    public static final Point plus(Point r100, Point r101) {
        Point r102 = new Point(r100.x, r100.y);
        r102.offset(r101.x, r101.y);
        return r102;
    }

    public static final Point times(Point r100, float r101) {
        return new Point(Math.round(r100.x * r101), Math.round(r100.y * r101));
    }

    public static final PointF div(PointF r100, float r101) {
        return new PointF(r100.x / r101, r100.y / r101);
    }

    public static final PointF minus(PointF r100, PointF r101) {
        PointF r102 = new PointF(r100.x, r100.y);
        r102.offset(-r101.x, -r101.y);
        return r102;
    }

    public static final PointF plus(PointF r100, PointF r101) {
        PointF r102 = new PointF(r100.x, r100.y);
        r102.offset(r101.x, r101.y);
        return r102;
    }

    public static final PointF times(PointF r100, float r101) {
        return new PointF(r100.x * r101, r100.y * r101);
    }

    public static final Point minus(Point r100, int r101) {
        Point r102 = new Point(r100.x, r100.y);
        int r103 = -r101;
        r102.offset(r103, r103);
        return r102;
    }

    public static final Point plus(Point r100, int r101) {
        Point r102 = new Point(r100.x, r100.y);
        r102.offset(r101, r101);
        return r102;
    }

    public static final PointF minus(PointF r100, float r101) {
        PointF r102 = new PointF(r100.x, r100.y);
        float r103 = -r101;
        r102.offset(r103, r103);
        return r102;
    }

    public static final PointF plus(PointF r100, float r101) {
        PointF r102 = new PointF(r100.x, r100.y);
        r102.offset(r101, r101);
        return r102;
    }
}
