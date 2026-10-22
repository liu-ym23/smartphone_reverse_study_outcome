package androidx.recyclerview.widget;

import android.view.View;
import com.obric.sva.sdk.data.ISmModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
class ViewBoundsCheck {
    static final int CVE_PVE_POS = 12;
    static final int CVE_PVS_POS = 8;
    static final int CVS_PVE_POS = 4;
    static final int CVS_PVS_POS = 0;
    static final int EQ = 2;
    static final int FLAG_CVE_EQ_PVE = 8192;
    static final int FLAG_CVE_EQ_PVS = 512;
    static final int FLAG_CVE_GT_PVE = 4096;
    static final int FLAG_CVE_GT_PVS = 256;
    static final int FLAG_CVE_LT_PVE = 16384;
    static final int FLAG_CVE_LT_PVS = 1024;
    static final int FLAG_CVS_EQ_PVE = 32;
    static final int FLAG_CVS_EQ_PVS = 2;
    static final int FLAG_CVS_GT_PVE = 16;
    static final int FLAG_CVS_GT_PVS = 1;
    static final int FLAG_CVS_LT_PVE = 64;
    static final int FLAG_CVS_LT_PVS = 4;
    static final int GT = 1;
    static final int LT = 4;
    static final int MASK = 7;
    BoundFlags mBoundFlags;
    final Callback mCallback;

    public static class BoundFlags {
        int mBoundFlags;
        int mChildEnd;
        int mChildStart;
        int mRvEnd;
        int mRvStart;

        public int compare(int r100, int r101) {
            if (r100 <= r101) goto L5;
            return 1;
        L5:
            if (r100 != r101) goto L8;
            return 2;
        L8:
            return 4;
        }

        public void resetFlags() {
            this.mBoundFlags = 0;
        }

        public boolean boundsMatch() {
            int r100 = this.mBoundFlags;
            if ((r100 & 7) != 0) goto L5;
        L7:
            int r101 = this.mBoundFlags;
            if ((r101 & 112) != 0) goto L10;
        L12:
            int r102 = this.mBoundFlags;
            if ((r102 & ISmModel.VERSION_0700) != 0) goto L15;
        L17:
            int r103 = this.mBoundFlags;
            if ((r103 & 28672) != 0) goto L20;
            return true;
        L20:
            if ((r103 & (compare(this.mChildEnd, this.mRvEnd) << 12)) != 0) goto L24;
            return false;
        L24:
            return true;
        L15:
            if ((r102 & (compare(this.mChildEnd, this.mRvStart) << 8)) != 0) goto L17;
            return false;
        L10:
            if ((r101 & (compare(this.mChildStart, this.mRvEnd) << 4)) != 0) goto L12;
            return false;
        L5:
            if ((r100 & (compare(this.mChildStart, this.mRvStart) << 0)) != 0) goto L7;
            return false;
        }

        public BoundFlags() {
            this.mBoundFlags = 0;
        }

        public void addFlags(int r100) {
            this.mBoundFlags = r100 | this.mBoundFlags;
        }

        public void setBounds(int r100, int r101, int r102, int r103) {
            this.mRvStart = r100;
            this.mRvEnd = r101;
            this.mChildStart = r102;
            this.mChildEnd = r103;
        }
    }

    public interface Callback {
        View getChildAt(int r100);

        int getChildEnd(View r100);

        int getChildStart(View r100);

        int getParentEnd();

        int getParentStart();
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    public ViewBoundsCheck(Callback r100) {
        this.mCallback = r100;
        this.mBoundFlags = new BoundFlags();
    }

    public boolean isViewWithinBoundFlags(View r100, int r101) {
        this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(r100), this.mCallback.getChildEnd(r100));
        if (r101 == 0) goto L6;
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(r101);
        return this.mBoundFlags.boundsMatch();
    L6:
        return false;
    }

    public View findOneViewWithinBoundFlags(int r100, int r110, int r111, int r112) {
        int r101 = this.mCallback.getParentStart();
        int r102 = this.mCallback.getParentEnd();
        if (r110 <= r100) goto L5;
        int r103 = 1;
    L6:
        View r104 = null;
    L7:
        if (r100 == r110) goto L18;
        View r105 = this.mCallback.getChildAt(r100);
        int r106 = this.mCallback.getChildStart(r105);
        int r107 = this.mCallback.getChildEnd(r105);
        this.mBoundFlags.setBounds(r101, r102, r106, r107);
        if (r111 == 0) goto L13;
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(r111);
        if (this.mBoundFlags.boundsMatch() == false) goto L13;
        return r105;
    L13:
        if (r112 == 0) goto L17;
        this.mBoundFlags.resetFlags();
        this.mBoundFlags.addFlags(r112);
        if (this.mBoundFlags.boundsMatch() == false) goto L17;
        r104 = r105;
    L17:
        r100 = r100 + r103;
        goto L7
    L18:
        return r104;
    L5:
        r103 = -1;
        goto L6
    }
}
