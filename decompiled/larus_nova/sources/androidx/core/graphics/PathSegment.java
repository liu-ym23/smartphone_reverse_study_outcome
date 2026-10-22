package androidx.core.graphics;

import android.graphics.PointF;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes17.dex */
public final class PathSegment {
    private final PointF mEnd;
    private final float mEndFraction;
    private final PointF mStart;
    private final float mStartFraction;

    public int hashCode() {
        int r100 = this.mStart.hashCode() * 31;
        float r101 = this.mStartFraction;
        int r102 = 0;
        if (r101 == 0.0f) goto L5;
        int r103 = Float.floatToIntBits(r101);
    L6:
        int r104 = (((r100 + r103) * 31) + this.mEnd.hashCode()) * 31;
        float r105 = this.mEndFraction;
        if (r105 == 0.0f) goto L10;
        r102 = Float.floatToIntBits(r105);
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "PathSegment{start=" + this.mStart + ", startFraction=" + this.mStartFraction + ", end=" + this.mEnd + ", endFraction=" + this.mEndFraction + '}';
    }

    public PointF getEnd() {
        return this.mEnd;
    }

    public float getEndFraction() {
        return this.mEndFraction;
    }

    public PointF getStart() {
        return this.mStart;
    }

    public float getStartFraction() {
        return this.mStartFraction;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PathSegment) == true) goto L8;
        return false;
    L8:
        PathSegment r101 = (PathSegment) r100;
        if (Float.compare(this.mStartFraction, r101.mStartFraction) == 0) goto L11;
    L17:
        return false;
    L11:
        if (Float.compare(this.mEndFraction, r101.mEndFraction) != 0) goto L17;
        if (this.mStart.equals(r101.mStart) == false) goto L17;
        if (this.mEnd.equals(r101.mEnd) == false) goto L17;
        return true;
    }

    public PathSegment(PointF r100, float r101, PointF r102, float r103) {
        this.mStart = (PointF) Preconditions.checkNotNull(r100, "start == null");
        this.mStartFraction = r101;
        this.mEnd = (PointF) Preconditions.checkNotNull(r102, "end == null");
        this.mEndFraction = r103;
    }
}
