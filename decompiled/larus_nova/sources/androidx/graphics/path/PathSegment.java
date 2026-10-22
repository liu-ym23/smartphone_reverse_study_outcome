package androidx.graphics.path;

import android.graphics.PointF;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Landroidx/graphics/path/PathSegment;", "", "type", "Landroidx/graphics/path/PathSegment$Type;", "points", "", "Landroid/graphics/PointF;", "weight", "", "(Landroidx/graphics/path/PathSegment$Type;[Landroid/graphics/PointF;F)V", "getPoints", "()[Landroid/graphics/PointF;", "[Landroid/graphics/PointF;", "getType", "()Landroidx/graphics/path/PathSegment$Type;", "getWeight", "()F", "equals", "", "other", "hashCode", "", "toString", "", "Type", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathSegment {
    private final PointF[] points;
    private final Type type;
    private final float weight;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/graphics/path/PathSegment$Type;", "", "(Ljava/lang/String;I)V", "Move", "Line", "Quadratic", "Conic", "Cubic", "Close", "Done", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type Close = null;
        public static final Type Conic = null;
        public static final Type Cubic = null;
        public static final Type Done = null;
        public static final Type Line = null;
        public static final Type Move = null;
        public static final Type Quadratic = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{Move, Line, Quadratic, Conic, Cubic, Close, Done};
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            Move = new Type("Move", 0);
            Line = new Type("Line", 1);
            Quadratic = new Type("Quadratic", 2);
            Conic = new Type("Conic", 3);
            Cubic = new Type("Cubic", 4);
            Close = new Type("Close", 5);
            Done = new Type("Done", 6);
            $VALUES = $values();
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + Arrays.hashCode(this.points)) * 31) + Float.floatToIntBits(this.weight);
    }

    public String toString() {
        return "PathSegment(type=" + this.type + ", points=" + Arrays.toString(this.points) + ", weight=" + this.weight + ')';
    }

    public final PointF[] getPoints() {
        return this.points;
    }

    public final Type getType() {
        return this.type;
    }

    public final float getWeight() {
        return this.weight;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(PathSegment.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.graphics.path.PathSegment");
        PathSegment r102 = (PathSegment) r100;
        if (this.type == r102.type) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.points, r102.points) == true) goto L19;
        return false;
    L19:
        if (this.weight != r102.weight) goto L21;
        boolean r103 = true;
    L22:
        if (r103 == true) goto L24;
        return false;
    L24:
        return true;
    L21:
        r103 = false;
        goto L22
    L8:
        r101 = null;
        goto L10
    }

    public PathSegment(Type r100, PointF[] r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "points");
        this.type = r100;
        this.points = r101;
        this.weight = r102;
    }
}
