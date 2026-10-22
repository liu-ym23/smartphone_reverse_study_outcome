package com.byted.cast.sdk.view;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes43.dex */
public class MeasureHelper {
    private int mCurrentAspectRatio;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private WeakReference<View> mWeakView;

    public static String getAspectRatioText(int r100) {
        if (r100 != 0) goto L4;
        return "Aspect / Fit parent";
    L4:
        if (r100 != 1) goto L6;
        return "Aspect / Fill parent";
    L6:
        if (r100 != 2) goto L8;
        return "Aspect / Wrap content";
    L8:
        if (r100 != 3) goto L10;
        return "Free / Fill parent";
    L10:
        if (r100 != 4) goto L12;
        return "16:9 / Fit parent";
    L12:
        if (r100 == 5) goto L14;
        return "N/A";
    L14:
        return "4:3 / Fit parent";
    }

    public View getView() {
        WeakReference<View> r100 = this.mWeakView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public MeasureHelper(View r100) {
        this.mCurrentAspectRatio = 0;
        this.mWeakView = new WeakReference(r100);
    }

    public void setAspectRatio(int r100) {
        this.mCurrentAspectRatio = r100;
    }

    public void setVideoRotation(int r100) {
        this.mVideoRotationDegree = r100;
    }

    public void doMeasure(int r110, int r111) {
        int r100 = this.mVideoRotationDegree;
        if (r100 == 90) goto L5;
        if (r100 == 270) goto L5;
    L6:
        int r101 = View.getDefaultSize(this.mVideoWidth, r110);
        int r102 = View.getDefaultSize(this.mVideoHeight, r111);
        if (this.mCurrentAspectRatio != 3) goto L10;
    L83:
        this.mMeasuredWidth = r110;
        this.mMeasuredHeight = r111;
        return;
    L10:
        if (this.mVideoWidth > 0) goto L12;
    L82:
        r110 = r101;
        r111 = r102;
        goto L83
    L12:
        if (this.mVideoHeight <= 0) goto L82;
        int r103 = View.MeasureSpec.getMode(r110);
        r110 = View.MeasureSpec.getSize(r110);
        int r104 = View.MeasureSpec.getMode(r111);
        r111 = View.MeasureSpec.getSize(r111);
        if (r103 != Integer.MIN_VALUE) goto L53;
        if (r104 != Integer.MIN_VALUE) goto L53;
        float r105 = r110;
        float r106 = r111;
        float r107 = r105 / r106;
        int r108 = this.mCurrentAspectRatio;
        if (r108 == 4) goto L30;
        if (r108 == 5) goto L24;
        float r109 = this.mVideoWidth / this.mVideoHeight;
        int r112 = this.mVideoSarNum;
        if (r112 <= 0) goto L37;
        int r113 = this.mVideoSarDen;
        if (r113 <= 0) goto L37;
        r109 = (r109 * r112) / r113;
    L37:
        if (r109 <= r107) goto L39;
        boolean r114 = true;
    L40:
        if (r108 == 0) goto L49;
        if (r108 == 1) goto L47;
        if (r108 == 4) goto L49;
        if (r108 == 5) goto L49;
        if (r114 == false) goto L46;
        r110 = Math.min(this.mVideoWidth, r110);
        r111 = (int) (r110 / r109);
        goto L83
    L46:
        int r115 = Math.min(this.mVideoHeight, r111);
        r111 = r115;
        r110 = (int) (r115 * r109);
        goto L83
    L47:
        if (r114 == true) goto L51;
    L50:
        r111 = (int) (r105 / r109);
    L51:
        r110 = (int) (r106 * r109);
    L49:
        if (r114 == false) goto L51;
    L39:
        r114 = false;
        goto L40
    L24:
        int r116 = this.mVideoRotationDegree;
        if (r116 == 90) goto L29;
        if (r116 == 270) goto L29;
        r109 = 1.3333334f;
    L29:
        r109 = 0.75f;
        goto L37
    L30:
        int r117 = this.mVideoRotationDegree;
        if (r117 == 90) goto L35;
        if (r117 == 270) goto L35;
        r109 = 1.7777778f;
    L35:
        r109 = 0.5625f;
    L53:
        if (r103 != 1073741824) goto L61;
        if (r104 != 1073741824) goto L61;
        int r118 = this.mVideoWidth;
        int r119 = r118 * r111;
        int r120 = this.mVideoHeight;
        if (r119 >= (r110 * r120)) goto L59;
        r110 = (r118 * r111) / r120;
        goto L83
    L59:
        if ((r118 * r111) <= (r110 * r120)) goto L83;
        r111 = (r120 * r110) / r118;
    L61:
        if (r103 != 1073741824) goto L67;
        int r121 = (this.mVideoHeight * r110) / this.mVideoWidth;
        if (r104 != Integer.MIN_VALUE) goto L66;
        if (r121 > r111) goto L83;
    L66:
        r111 = r121;
        goto L83
    L67:
        if (r104 != 1073741824) goto L73;
        int r122 = (this.mVideoWidth * r111) / this.mVideoHeight;
        if (r103 != Integer.MIN_VALUE) goto L72;
        if (r122 > r110) goto L83;
    L72:
        r110 = r122;
        goto L83
    L73:
        int r123 = this.mVideoWidth;
        int r124 = this.mVideoHeight;
        if (r104 != Integer.MIN_VALUE) goto L77;
        if (r124 <= r111) goto L77;
        int r125 = (r111 * r123) / r124;
    L78:
        if (r103 != Integer.MIN_VALUE) goto L81;
        if (r125 <= r110) goto L81;
        r111 = (r124 * r110) / r123;
    L81:
        r110 = r125;
    L77:
        r125 = r123;
        r111 = r124;
    L5:
        r111 = r110;
        r110 = r111;
        goto L6
    }

    public void setVideoSampleAspectRatio(int r100, int r101) {
        this.mVideoSarNum = r100;
        this.mVideoSarDen = r101;
    }

    public void setVideoSize(int r100, int r101) {
        this.mVideoWidth = r100;
        this.mVideoHeight = r101;
    }
}
