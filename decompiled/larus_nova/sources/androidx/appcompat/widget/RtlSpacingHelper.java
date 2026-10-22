package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes2.dex */
class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mEnd;
    private int mExplicitLeft;
    private int mExplicitRight;
    private boolean mIsRelative;
    private boolean mIsRtl;
    private int mLeft;
    private int mRight;
    private int mStart;

    public int getEnd() {
        if (this.mIsRtl == false) goto L6;
        return this.mLeft;
    L6:
        return this.mRight;
    }

    public int getStart() {
        if (this.mIsRtl == false) goto L6;
        return this.mRight;
    L6:
        return this.mLeft;
    }

    public RtlSpacingHelper() {
        this.mLeft = 0;
        this.mRight = 0;
        this.mStart = Integer.MIN_VALUE;
        this.mEnd = Integer.MIN_VALUE;
        this.mExplicitLeft = 0;
        this.mExplicitRight = 0;
        this.mIsRtl = false;
        this.mIsRelative = false;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public void setDirection(boolean r100) {
        if (r100 != this.mIsRtl) goto L5;
        return;
    L5:
        this.mIsRtl = r100;
        if (this.mIsRelative == true) goto L8;
        this.mLeft = this.mExplicitLeft;
        this.mRight = this.mExplicitRight;
        return;
    L8:
        if (r100 == false) goto L18;
        int r101 = this.mEnd;
        if (r101 != Integer.MIN_VALUE) goto L13;
        r101 = this.mExplicitLeft;
    L13:
        this.mLeft = r101;
        int r102 = this.mStart;
        if (r102 != Integer.MIN_VALUE) goto L17;
        r102 = this.mExplicitRight;
    L17:
        this.mRight = r102;
        return;
    L18:
        int r103 = this.mStart;
        if (r103 != Integer.MIN_VALUE) goto L22;
        r103 = this.mExplicitLeft;
    L22:
        this.mLeft = r103;
        int r104 = this.mEnd;
        if (r104 != Integer.MIN_VALUE) goto L26;
        r104 = this.mExplicitRight;
    L26:
        this.mRight = r104;
    }

    public void setAbsolute(int r100, int r101) {
        this.mIsRelative = false;
        if (r100 == Integer.MIN_VALUE) goto L5;
        this.mExplicitLeft = r100;
        this.mLeft = r100;
    L5:
        if (r101 == Integer.MIN_VALUE) goto L8;
        this.mExplicitRight = r101;
        this.mRight = r101;
        return;
    }

    public void setRelative(int r100, int r101) {
        this.mStart = r100;
        this.mEnd = r101;
        this.mIsRelative = true;
        if (this.mIsRtl == false) goto L8;
        if (r101 == Integer.MIN_VALUE) goto L6;
        this.mLeft = r101;
    L6:
        if (r100 == Integer.MIN_VALUE) goto L13;
        this.mRight = r100;
        return;
    L13:
        return;
    L8:
        if (r100 == Integer.MIN_VALUE) goto L10;
        this.mLeft = r100;
    L10:
        if (r101 == Integer.MIN_VALUE) goto L15;
        this.mRight = r101;
        return;
    }
}
