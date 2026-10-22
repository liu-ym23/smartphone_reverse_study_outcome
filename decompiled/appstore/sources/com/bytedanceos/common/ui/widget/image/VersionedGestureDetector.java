package com.bytedanceos.common.ui.widget.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes2.dex */
public abstract class VersionedGestureDetector {
    OnGestureListener mListener;

    public static class CupcakeDetector extends VersionedGestureDetector {
        private boolean mIsDragging;
        float mLastTouchX;
        float mLastTouchY;
        final float mMinimumVelocity;
        final float mTouchSlop;
        private VelocityTracker mVelocityTracker;

        public CupcakeDetector(Context r10) {
            ViewConfiguration r11 = ViewConfiguration.get(r10);
            this.mMinimumVelocity = r11.getScaledMinimumFlingVelocity();
            this.mTouchSlop = r11.getScaledTouchSlop();
        }

        public float getActiveX(MotionEvent r10) {
            return r10.getX();
        }

        public float getActiveY(MotionEvent r10) {
            return r10.getY();
        }

        @Override // com.bytedanceos.common.ui.widget.image.VersionedGestureDetector
        public boolean isScaling() {
            return false;
        }

        @Override // com.bytedanceos.common.ui.widget.image.VersionedGestureDetector
        public boolean onTouchEvent(MotionEvent r10) {
            int r11 = r10.getAction();
            boolean r12 = false;
            if (r11 != 0) goto L5;
            VelocityTracker r13 = VelocityTracker.obtain();
            this.mVelocityTracker = r13;
            r13.addMovement(r10);
            this.mLastTouchX = getActiveX(r10);
            this.mLastTouchY = getActiveY(r10);
            this.mIsDragging = false;
        L36:
            return true;
        L5:
            if (r11 == 1) goto L26;
            if (r11 != 2) goto L9;
            float r14 = getActiveX(r10);
            float r15 = getActiveY(r10);
            float r16 = r14 - this.mLastTouchX;
            float r17 = r15 - this.mLastTouchY;
            if (this.mIsDragging == true) goto L21;
            if (FloatMath.sqrt((r16 * r16) + (r17 * r17)) < this.mTouchSlop) goto L19;
            r12 = true;
        L19:
            this.mIsDragging = r12;
        L21:
            if (this.mIsDragging == false) goto L36;
            this.mListener.onDrag(r16, r17);
            this.mLastTouchX = r14;
            this.mLastTouchY = r15;
            VelocityTracker r18 = this.mVelocityTracker;
            if (r18 == null) goto L36;
            r18.addMovement(r10);
            goto L36
        L9:
            if (r11 != 3) goto L36;
            VelocityTracker r19 = this.mVelocityTracker;
            if (r19 == null) goto L36;
            r19.recycle();
            this.mVelocityTracker = null;
            goto L36
        L26:
            if (this.mIsDragging == true) goto L28;
        L32:
            VelocityTracker r20 = this.mVelocityTracker;
            if (r20 == null) goto L36;
            r20.recycle();
            this.mVelocityTracker = null;
            goto L36
        L28:
            if (this.mVelocityTracker == null) goto L32;
            this.mLastTouchX = getActiveX(r10);
            this.mLastTouchY = getActiveY(r10);
            this.mVelocityTracker.addMovement(r10);
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float r21 = this.mVelocityTracker.getXVelocity();
            float r22 = this.mVelocityTracker.getYVelocity();
            if (Math.max(Math.abs(r21), Math.abs(r22)) < this.mMinimumVelocity) goto L32;
            this.mListener.onFling(this.mLastTouchX, this.mLastTouchY, -r21, -r22);
            goto L32
        }
    }

    @TargetApi(5)
    public static class EclairDetector extends CupcakeDetector {
        private static final int INVALID_POINTER_ID = -1;
        private int mActivePointerId;
        private int mActivePointerIndex;

        public EclairDetector(Context r10) {
            super(r10);
            this.mActivePointerId = -1;
            this.mActivePointerIndex = 0;
        }

        @Override // com.bytedanceos.common.ui.widget.image.VersionedGestureDetector.CupcakeDetector
        public float getActiveX(MotionEvent r10) {
            return r10.getX(this.mActivePointerIndex);
        L5:
            return r10.getX();
        }

        @Override // com.bytedanceos.common.ui.widget.image.VersionedGestureDetector.CupcakeDetector
        public float getActiveY(MotionEvent r10) {
            return r10.getY(this.mActivePointerIndex);
        L5:
            return r10.getY();
        }

        @Override // com.bytedanceos.common.ui.widget.image.VersionedGestureDetector.CupcakeDetector, com.bytedanceos.common.ui.widget.image.VersionedGestureDetector
        public boolean onTouchEvent(MotionEvent r10) {
            int r11 = r10.getAction() & PrivateKeyType.INVALID;
            int r12 = 0;
            if (r11 == 0) goto L18;
            int r13 = 1;
            if (r11 != 1) goto L7;
        L17:
            this.mActivePointerId = -1;
        L19:
            int r14 = this.mActivePointerId;
            if (r14 == (-1)) goto L22;
            r12 = r14;
        L22:
            this.mActivePointerIndex = r10.findPointerIndex(r12);
            return super.onTouchEvent(r10);
        L7:
            if (r11 == 3) goto L17;
            if (r11 != 6) goto L19;
            int r15 = (r10.getAction() & 65280) >> 8;
            if (r10.getPointerId(r15) != this.mActivePointerId) goto L19;
            if (r15 == 0) goto L16;
            r13 = 0;
        L16:
            this.mActivePointerId = r10.getPointerId(r13);
            this.mLastTouchX = r10.getX(r13);
            this.mLastTouchY = r10.getY(r13);
            goto L19
        L18:
            this.mActivePointerId = r10.getPointerId(0);
            goto L19
        }
    }

    @TargetApi(8)
    public static class FroyoDetector extends EclairDetector {
        private final ScaleGestureDetector mDetector;
        private final ScaleGestureDetector.OnScaleGestureListener mScaleListener;

        public FroyoDetector(Context r10) {
            super(r10);
            ScaleGestureDetector.OnScaleGestureListener r11 = new AnonymousClass1(this);
            this.mScaleListener = r11;
            this.mDetector = new ScaleGestureDetector(r10, r11);
        }

        @Override // com.bytedanceos.common.ui.widget.image.VersionedGestureDetector.CupcakeDetector, com.bytedanceos.common.ui.widget.image.VersionedGestureDetector
        public boolean isScaling() {
            return this.mDetector.isInProgress();
        }

        @Override // com.bytedanceos.common.ui.widget.image.VersionedGestureDetector.EclairDetector, com.bytedanceos.common.ui.widget.image.VersionedGestureDetector.CupcakeDetector, com.bytedanceos.common.ui.widget.image.VersionedGestureDetector
        public boolean onTouchEvent(MotionEvent r10) {
            this.mDetector.onTouchEvent(r10);
            return super.onTouchEvent(r10);
        }
    }

    public interface OnGestureListener {
        void onDrag(float r10, float r11);

        void onFling(float r10, float r11, float r12, float r13);

        void onScale(float r10, float r11, float r12);
    }

    public VersionedGestureDetector() {
    }

    public static VersionedGestureDetector newInstance(Context r10, OnGestureListener r11) {
        FroyoDetector r12 = new FroyoDetector(r10);
        r12.mListener = r11;
        return r12;
    }

    public abstract boolean isScaling();

    public abstract boolean onTouchEvent(MotionEvent r10);
}
