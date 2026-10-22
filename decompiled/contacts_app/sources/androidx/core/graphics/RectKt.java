package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Rect.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0004\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\r\u0010\u0017\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f¨\u0006\u001d"}, d2 = {"and", "Landroid/graphics/Rect;", "r", "Landroid/graphics/RectF;", "component1", "", "", "component2", "component3", "component4", "contains", "", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "xy", "Landroid/graphics/Region;", "or", "plus", "times", "factor", "toRect", "toRectF", "toRegion", "transform", "m", "Landroid/graphics/Matrix;", "xor", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RectKt {
    public static final int component1(Rect r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.left;
    }

    public static final int component2(Rect r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.top;
    }

    public static final int component3(Rect r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.right;
    }

    public static final int component4(Rect r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.bottom;
    }

    public static final float component1(RectF r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.left;
    }

    public static final float component2(RectF r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.top;
    }

    public static final float component3(RectF r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.right;
    }

    public static final float component4(RectF r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.bottom;
    }

    public static final Rect plus(Rect r1, Rect r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "r");
        Rect r0 = new Rect(r1);
        r0.union(r2);
        return r0;
    }

    public static final RectF plus(RectF r1, RectF r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "r");
        RectF r0 = new RectF(r1);
        r0.union(r2);
        return r0;
    }

    public static final Rect plus(Rect r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Rect r0 = new Rect(r1);
        r0.offset(r2, r2);
        return r0;
    }

    public static final RectF plus(RectF r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        RectF r0 = new RectF(r1);
        r0.offset(r2, r2);
        return r0;
    }

    public static final Rect plus(Rect r1, Point r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "xy");
        Rect r0 = new Rect(r1);
        r0.offset(r2.x, r2.y);
        return r0;
    }

    public static final RectF plus(RectF r1, PointF r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "xy");
        RectF r0 = new RectF(r1);
        r0.offset(r2.x, r2.y);
        return r0;
    }

    public static final Region minus(Rect r1, Rect r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.DIFFERENCE);
        return r0;
    }

    public static final Region minus(RectF r2, RectF r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "r");
        Rect r1 = new Rect();
        r2.roundOut(r1);
        Region r0 = new Region(r1);
        Rect r4 = new Rect();
        r3.roundOut(r4);
        r0.op(r4, Region.Op.DIFFERENCE);
        return r0;
    }

    public static final Rect minus(Rect r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Rect r0 = new Rect(r1);
        int r3 = -r2;
        r0.offset(r3, r3);
        return r0;
    }

    public static final RectF minus(RectF r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        RectF r0 = new RectF(r1);
        float r3 = -r2;
        r0.offset(r3, r3);
        return r0;
    }

    public static final Rect minus(Rect r1, Point r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "xy");
        Rect r0 = new Rect(r1);
        r0.offset(-r2.x, -r2.y);
        return r0;
    }

    public static final RectF minus(RectF r1, PointF r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "xy");
        RectF r0 = new RectF(r1);
        r0.offset(-r2.x, -r2.y);
        return r0;
    }

    public static final Rect times(Rect r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Rect r0 = new Rect(r1);
        r0.top *= r2;
        r0.left *= r2;
        r0.right *= r2;
        r0.bottom *= r2;
        return r0;
    }

    public static final RectF times(RectF r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        RectF r0 = new RectF(r1);
        r0.top *= r2;
        r0.left *= r2;
        r0.right *= r2;
        r0.bottom *= r2;
        return r0;
    }

    public static final Rect and(Rect r1, Rect r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "r");
        Rect r0 = new Rect(r1);
        r0.intersect(r2);
        return r0;
    }

    public static final RectF and(RectF r1, RectF r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "r");
        RectF r0 = new RectF(r1);
        r0.intersect(r2);
        return r0;
    }

    public static final Region xor(Rect r1, Rect r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.XOR);
        return r0;
    }

    public static final Region xor(RectF r2, RectF r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "r");
        Rect r1 = new Rect();
        r2.roundOut(r1);
        Region r0 = new Region(r1);
        Rect r4 = new Rect();
        r3.roundOut(r4);
        r0.op(r4, Region.Op.XOR);
        return r0;
    }

    public static final boolean contains(Rect r1, Point r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "p");
        return r1.contains(r2.x, r2.y);
    }

    public static final boolean contains(RectF r1, PointF r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "p");
        return r1.contains(r2.x, r2.y);
    }

    public static final RectF toRectF(Rect r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new RectF(r1);
    }

    public static final Rect toRect(RectF r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Rect r0 = new Rect();
        r1.roundOut(r0);
        return r0;
    }

    public static final Region toRegion(Rect r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new Region(r1);
    }

    public static final Region toRegion(RectF r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Rect r1 = new Rect();
        r2.roundOut(r1);
        return new Region(r1);
    }

    public static final RectF transform(RectF r1, Matrix r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "m");
        r2.mapRect(r1);
        return r1;
    }

    public static final RectF times(RectF r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        float r3 = r2;
        RectF r0 = new RectF(r1);
        r0.top *= r3;
        r0.left *= r3;
        r0.right *= r3;
        r0.bottom *= r3;
        return r0;
    }

    public static final Rect or(Rect r1, Rect r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "r");
        Rect r0 = new Rect(r1);
        r0.union(r2);
        return r0;
    }

    public static final RectF or(RectF r1, RectF r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "r");
        RectF r0 = new RectF(r1);
        r0.union(r2);
        return r0;
    }
}
