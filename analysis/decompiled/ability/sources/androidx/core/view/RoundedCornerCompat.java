package androidx.core.view;

import android.graphics.Point;
import android.view.RoundedCorner;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class RoundedCornerCompat {
    public static final int POSITION_BOTTOM_LEFT = 3;
    public static final int POSITION_BOTTOM_RIGHT = 2;
    public static final int POSITION_TOP_LEFT = 0;
    public static final int POSITION_TOP_RIGHT = 1;
    private final Point mCenter;
    private final int mPosition;
    private final int mRadius;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Position {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RoundedCornerCompat(int i, int i6, int i10, int i11) {
        this.mPosition = i;
        this.mRadius = i6;
        this.mCenter = new Point(i10, i11);
    }

    private String getPositionString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "Invalid" : "BottomLeft" : "BottomRight" : "TopRight" : "TopLeft";
    }

    private static int toCompatPosition(int i) {
        if (i == 0) {
            return 0;
        }
        int i6 = 1;
        if (i != 1) {
            i6 = 2;
            if (i != 2) {
                if (i == 3) {
                    return 3;
                }
                throw new IllegalArgumentException(B7.a.h(i, "Invalid position: "));
            }
        }
        return i6;
    }

    public static int toPlatformPosition(int i) {
        if (i == 0) {
            return 0;
        }
        int i6 = 1;
        if (i != 1) {
            i6 = 2;
            if (i != 2) {
                if (i == 3) {
                    return 3;
                }
                throw new IllegalArgumentException(B7.a.h(i, "Invalid position: "));
            }
        }
        return i6;
    }

    @RequiresApi(31)
    public static RoundedCorner toPlatformRoundedCorner(RoundedCornerCompat roundedCornerCompat) {
        if (roundedCornerCompat != null) {
            return new RoundedCorner(toPlatformPosition(roundedCornerCompat.getPosition()), roundedCornerCompat.getRadius(), roundedCornerCompat.getCenterX(), roundedCornerCompat.getCenterY());
        }
        return null;
    }

    @RequiresApi(31)
    public static RoundedCornerCompat toRoundedCornerCompat(RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            return new RoundedCornerCompat(toCompatPosition(roundedCorner.getPosition()), roundedCorner.getRadius(), roundedCorner.getCenter());
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RoundedCornerCompat) {
            RoundedCornerCompat roundedCornerCompat = (RoundedCornerCompat) obj;
            if (this.mPosition == roundedCornerCompat.mPosition && this.mRadius == roundedCornerCompat.mRadius && this.mCenter.equals(roundedCornerCompat.mCenter)) {
                return true;
            }
        }
        return false;
    }

    public Point getCenter() {
        return new Point(this.mCenter);
    }

    public int getCenterX() {
        return this.mCenter.x;
    }

    public int getCenterY() {
        return this.mCenter.y;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public int hashCode() {
        return this.mCenter.hashCode() + (((this.mPosition * 31) + this.mRadius) * 31);
    }

    public String toString() {
        return "RoundedCornerCompat{position=" + getPositionString(this.mPosition) + ", radius=" + this.mRadius + ", center=" + this.mCenter + '}';
    }

    private RoundedCornerCompat(int i, int i6, Point point) {
        this(i, i6, point.x, point.y);
    }
}
