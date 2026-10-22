package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0004\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\r\u0010\u0017\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f¨\u0006\u001d"}, d2 = {"and", "Landroid/graphics/Rect;", "r", "Landroid/graphics/RectF;", "component1", "", "", "component2", "component3", "component4", "contains", "", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "xy", "Landroid/graphics/Region;", SRStrategy.KEY_ORIGIN_RESOLUTION, "plus", "times", "factor", "toRect", "toRectF", "toRegion", "transform", "m", "Landroid/graphics/Matrix;", "xor", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RectKt {
    public static final float component1(RectF r100) {
        return r100.left;
    }

    public static final float component2(RectF r100) {
        return r100.top;
    }

    public static final float component3(RectF r100) {
        return r100.right;
    }

    public static final float component4(RectF r100) {
        return r100.bottom;
    }

    public static final Rect toRect(RectF r100) {
        Rect r101 = new Rect();
        r100.roundOut(r101);
        return r101;
    }

    public static final RectF toRectF(Rect r100) {
        return new RectF(r100);
    }

    public static final Region toRegion(RectF r100) {
        Rect r101 = new Rect();
        r100.roundOut(r101);
        return new Region(r101);
    }

    public static final int component1(Rect r100) {
        return r100.left;
    }

    public static final int component2(Rect r100) {
        return r100.top;
    }

    public static final int component3(Rect r100) {
        return r100.right;
    }

    public static final int component4(Rect r100) {
        return r100.bottom;
    }

    public static final Region toRegion(Rect r100) {
        return new Region(r100);
    }

    public static final Rect and(Rect r100, Rect r101) {
        Rect r102 = new Rect(r100);
        r102.intersect(r101);
        return r102;
    }

    public static final boolean contains(Rect r100, Point r101) {
        return r100.contains(r101.x, r101.y);
    }

    public static final Region minus(RectF r100, RectF r101) {
        Rect r102 = new Rect();
        r100.roundOut(r102);
        Region r103 = new Region(r102);
        Rect r104 = new Rect();
        r101.roundOut(r104);
        r103.op(r104, Region.Op.DIFFERENCE);
        return r103;
    }

    public static final Rect or(Rect r100, Rect r101) {
        Rect r102 = new Rect(r100);
        r102.union(r101);
        return r102;
    }

    public static final Rect plus(Rect r100, Point r101) {
        Rect r102 = new Rect(r100);
        r102.offset(r101.x, r101.y);
        return r102;
    }

    public static final RectF times(RectF r100, int r101) {
        float r102 = r101;
        RectF r103 = new RectF(r100);
        r103.top *= r102;
        r103.left *= r102;
        r103.right *= r102;
        r103.bottom *= r102;
        return r103;
    }

    public static final RectF transform(RectF r100, Matrix r101) {
        r101.mapRect(r100);
        return r100;
    }

    public static final Region xor(RectF r100, RectF r101) {
        Rect r102 = new Rect();
        r100.roundOut(r102);
        Region r103 = new Region(r102);
        Rect r104 = new Rect();
        r101.roundOut(r104);
        r103.op(r104, Region.Op.XOR);
        return r103;
    }

    public static final RectF and(RectF r100, RectF r101) {
        RectF r102 = new RectF(r100);
        r102.intersect(r101);
        return r102;
    }

    public static final boolean contains(RectF r100, PointF r101) {
        return r100.contains(r101.x, r101.y);
    }

    public static final Rect minus(Rect r100, Point r101) {
        Rect r102 = new Rect(r100);
        r102.offset(-r101.x, -r101.y);
        return r102;
    }

    public static final RectF or(RectF r100, RectF r101) {
        RectF r102 = new RectF(r100);
        r102.union(r101);
        return r102;
    }

    public static final RectF plus(RectF r100, PointF r101) {
        RectF r102 = new RectF(r100);
        r102.offset(r101.x, r101.y);
        return r102;
    }

    public static final Rect times(Rect r100, int r101) {
        Rect r102 = new Rect(r100);
        r102.top *= r101;
        r102.left *= r101;
        r102.right *= r101;
        r102.bottom *= r101;
        return r102;
    }

    public static final Region xor(Rect r100, Rect r101) {
        Region r102 = new Region(r100);
        r102.op(r101, Region.Op.XOR);
        return r102;
    }

    public static final RectF minus(RectF r100, PointF r101) {
        RectF r102 = new RectF(r100);
        r102.offset(-r101.x, -r101.y);
        return r102;
    }

    public static final Rect plus(Rect r100, int r101) {
        Rect r102 = new Rect(r100);
        r102.offset(r101, r101);
        return r102;
    }

    public static final RectF times(RectF r100, float r101) {
        RectF r102 = new RectF(r100);
        r102.top *= r101;
        r102.left *= r101;
        r102.right *= r101;
        r102.bottom *= r101;
        return r102;
    }

    public static final Region minus(Rect r100, Rect r101) {
        Region r102 = new Region(r100);
        r102.op(r101, Region.Op.DIFFERENCE);
        return r102;
    }

    public static final Rect plus(Rect r100, Rect r101) {
        Rect r102 = new Rect(r100);
        r102.union(r101);
        return r102;
    }

    public static final Rect minus(Rect r100, int r101) {
        Rect r102 = new Rect(r100);
        int r103 = -r101;
        r102.offset(r103, r103);
        return r102;
    }

    public static final RectF plus(RectF r100, float r101) {
        RectF r102 = new RectF(r100);
        r102.offset(r101, r101);
        return r102;
    }

    public static final RectF minus(RectF r100, float r101) {
        RectF r102 = new RectF(r100);
        float r103 = -r101;
        r102.offset(r103, r103);
        return r102;
    }

    public static final RectF plus(RectF r100, RectF r101) {
        RectF r102 = new RectF(r100);
        r102.union(r101);
        return r102;
    }
}
