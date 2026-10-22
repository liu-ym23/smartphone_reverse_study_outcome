package com.autonavi.amap.mapcore.animation;

import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class GLAnimationSet extends GLAnimation {
    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
    private static final int PROPERTY_DURATION_MASK = 32;
    private static final int PROPERTY_FILL_AFTER_MASK = 1;
    private static final int PROPERTY_FILL_BEFORE_MASK = 2;
    private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
    private static final int PROPERTY_REPEAT_MODE_MASK = 4;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
    private static final int PROPERTY_START_OFFSET_MASK = 8;
    private ArrayList<GLAnimation> mAnimations;
    private boolean mDirty;
    private int mFlags;
    private boolean mHasAlpha;
    private long mLastEnd;
    private GLTransformation mTempTransformation;

    private void init() {
        this.mStartTime = 0;
    }

    public void cleanAnimation() {
        this.mAnimations.clear();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long computeDurationHint() {
        int r100 = this.mAnimations.size();
        ArrayList<GLAnimation> r101 = this.mAnimations;
        int r102 = r100 - 1;
        long r103 = 0;
    L3:
        if (r102 < 0) goto L8;
        long r104 = ((GLAnimation) ListProtector.get(r101, r102)).computeDurationHint();
        if (r104 <= r103) goto L7;
        r103 = r104;
    L7:
        r102 = r102 - 1;
        goto L3
    L8:
        return r103;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getDuration() {
        ArrayList<GLAnimation> r100 = this.mAnimations;
        int r101 = r100.size();
        int r102 = 0;
        if ((this.mFlags & 32) != 32) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L14;
        long r104 = 0;
    L9:
        if (r102 >= r101) goto L12;
        r104 = Math.max(r104, ((GLAnimation) ListProtector.get(r100, r102)).getDuration());
        r102 = r102 + 1;
        goto L9
    L12:
        return r104;
    L14:
        return this.mDuration;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getStartTime() {
        int r100 = this.mAnimations.size();
        ArrayList<GLAnimation> r101 = this.mAnimations;
        long r102 = Long.MAX_VALUE;
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L5;
        r102 = Math.min(r102, ((GLAnimation) ListProtector.get(r101, r103)).getStartTime());
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean hasAlpha() {
        if (this.mDirty == false) goto L11;
        int r100 = 0;
        this.mHasAlpha = false;
        this.mDirty = false;
        int r101 = this.mAnimations.size();
        ArrayList<GLAnimation> r102 = this.mAnimations;
    L5:
        if (r100 >= r101) goto L11;
        if (((GLAnimation) ListProtector.get(r102, r100)).hasAlpha() == true) goto L8;
        r100 = r100 + 1;
        goto L5
    L8:
        this.mHasAlpha = true;
    L11:
        return this.mHasAlpha;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void initialize() {
        super.initialize();
        int r100 = this.mFlags;
        boolean r101 = true;
        if ((r100 & 32) != 32) goto L5;
        boolean r102 = true;
    L7:
        if ((r100 & 1) != 1) goto L9;
        boolean r103 = true;
    L11:
        if ((r100 & 2) != 2) goto L13;
        boolean r104 = true;
    L15:
        if ((r100 & 4) != 4) goto L17;
        boolean r105 = true;
    L19:
        if ((r100 & 16) != 16) goto L21;
        boolean r106 = true;
    L23:
        if ((r100 & 8) == 8) goto L26;
        r101 = false;
    L26:
        if (r106 == false) goto L28;
        ensureInterpolator();
    L28:
        ArrayList<GLAnimation> r107 = this.mAnimations;
        int r108 = r107.size();
        long r110 = this.mDuration;
        boolean r111 = this.mFillAfter;
        boolean r112 = this.mFillBefore;
        int r113 = this.mRepeatMode;
        Interpolator r114 = this.mInterpolator;
        boolean r115 = r101;
        long r109 = this.mStartOffset;
        int r116 = 0;
    L29:
        if (r116 >= r108) goto L45;
        ArrayList<GLAnimation> r117 = r107;
        GLAnimation r118 = (GLAnimation) ListProtector.get(r107, r116);
        if (r102 == false) goto L33;
        r118.setDuration(r110);
    L33:
        if (r103 == false) goto L35;
        r118.setFillAfter(r111);
    L35:
        if (r104 == false) goto L37;
        r118.setFillBefore(r112);
    L37:
        if (r105 == false) goto L39;
        r118.setRepeatMode(r113);
    L39:
        if (r106 == false) goto L41;
        r118.setInterpolator(r114);
    L41:
        if (r115 == false) goto L44;
        r118.setStartOffset(r118.getStartOffset() + r109);
    L44:
        r118.initialize();
        r116 = r116 + 1;
        r103 = r103;
        r107 = r117;
        r104 = r104;
        goto L29
    L45:
        return;
    L21:
        r106 = false;
        goto L23
    L17:
        r105 = false;
        goto L19
    L13:
        r104 = false;
        goto L15
    L9:
        r103 = false;
        goto L11
    L5:
        r102 = false;
        goto L7
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeBounds() {
        if ((this.mFlags & 128) != 128) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeTransformationMatrix() {
        if ((this.mFlags & 64) != 64) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public GLAnimationSet clone() throws CloneNotSupportedException {
        GLAnimationSet r100 = (GLAnimationSet) super.clone();
        r100.mTempTransformation = new GLTransformation();
        r100.mAnimations = new ArrayList();
        int r101 = this.mAnimations.size();
        ArrayList<GLAnimation> r102 = this.mAnimations;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r100.mAnimations.add(((GLAnimation) ListProtector.get(r102, r103)).clone());
        r103 = r103 + 1;
        goto L3
    L5:
        return r100;
    }

    public List<GLAnimation> getAnimations() {
        return this.mAnimations;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void reset() {
        super.reset();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public /* bridge */ /* synthetic */ GLAnimation clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo8139clone() throws CloneNotSupportedException {
        return clone();
    }

    public GLAnimationSet(boolean r100) {
        this.mFlags = 0;
        this.mAnimations = new ArrayList();
        this.mTempTransformation = new GLTransformation();
        setFlag(16, r100);
        init();
    }

    public void addAnimation(Animation r100) {
        this.mAnimations.add(r100.glAnimation);
        boolean r101 = false;
        if ((this.mFlags & 64) != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L11;
        if (r100.glAnimation.willChangeTransformationMatrix() == false) goto L11;
        this.mFlags |= 64;
    L11:
        if ((this.mFlags & 128) != 0) goto L13;
        r101 = true;
    L13:
        if (r101 == false) goto L18;
        if (r100.glAnimation.willChangeBounds() == false) goto L18;
        this.mFlags |= 128;
    L18:
        if ((this.mFlags & 32) != 32) goto L21;
        this.mLastEnd = this.mStartOffset + this.mDuration;
    L24:
        this.mDirty = true;
        return;
    L21:
        if (this.mAnimations.size() != 1) goto L23;
        long r103 = r100.glAnimation.getStartOffset() + r100.glAnimation.getDuration();
        this.mDuration = r103;
        this.mLastEnd = this.mStartOffset + r103;
        goto L24
    L23:
        long r104 = Math.max(this.mLastEnd, r100.glAnimation.getStartOffset() + r100.glAnimation.getDuration());
        this.mLastEnd = r104;
        this.mDuration = r104 - this.mStartOffset;
        goto L24
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void restrictDuration(long r100) {
        super.restrictDuration(r100);
        ArrayList<GLAnimation> r101 = this.mAnimations;
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((GLAnimation) ListProtector.get(r101, r103)).restrictDuration(r100);
        r103 = r103 + 1;
        goto L3
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void scaleCurrentDuration(float r100) {
        ArrayList<GLAnimation> r101 = this.mAnimations;
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((GLAnimation) ListProtector.get(r101, r103)).scaleCurrentDuration(r100);
        r103 = r103 + 1;
        goto L3
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setDuration(long r100) {
        this.mFlags |= 32;
        super.setDuration(r100);
        this.mLastEnd = this.mStartOffset + this.mDuration;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillAfter(boolean r100) {
        this.mFlags |= 1;
        super.setFillAfter(r100);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillBefore(boolean r100) {
        this.mFlags |= 2;
        super.setFillBefore(r100);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setRepeatMode(int r100) {
        this.mFlags |= 4;
        super.setRepeatMode(r100);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartOffset(long r100) {
        this.mFlags |= 8;
        super.setStartOffset(r100);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartTime(long r100) {
        super.setStartTime(r100);
        int r101 = this.mAnimations.size();
        ArrayList<GLAnimation> r102 = this.mAnimations;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        ((GLAnimation) ListProtector.get(r102, r103)).setStartTime(r100);
        r103 = r103 + 1;
        goto L3
    }

    private void setFlag(int r100, boolean r101) {
        if (r101 == false) goto L4;
        this.mFlags = r100 | this.mFlags;
        return;
    L4:
        int r102 = this.mFlags;
        this.mFlags = (~r100) & r102;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean getTransformation(long r110, GLTransformation r111) {
        if (this.mInitialized == true) goto L5;
        initialize();
    L5:
        int r100 = this.mAnimations.size();
        ArrayList<GLAnimation> r101 = this.mAnimations;
        GLTransformation r102 = this.mTempTransformation;
        r111.clear();
        int r103 = r100 - 1;
        boolean r104 = false;
        boolean r105 = false;
        boolean r106 = true;
    L6:
        if (r103 < 0) goto L25;
        GLAnimation r107 = (GLAnimation) ListProtector.get(r101, r103);
        r102.clear();
        if (r107.getTransformation(r110, r111, getScaleFactor()) == true) goto L12;
        if (r105 == true) goto L12;
        r105 = false;
    L13:
        if (r104 == false) goto L15;
    L18:
        r104 = true;
    L20:
        if (r107.hasEnded() == false) goto L23;
        if (r106 == false) goto L23;
        r106 = true;
    L24:
        r103 = r103 - 1;
    L23:
        r106 = false;
        goto L24
    L15:
        if (r107.hasStarted() == true) goto L18;
        r104 = false;
    L12:
        r105 = true;
        goto L13
    L25:
        if (r104 == false) goto L33;
    L39:
        th = move-exception;
        th.printStackTrace();
    L41:
        return r105;
    L27:
        if (this.mStarted == true) goto L33;
        Animation.AnimationListener r112 = this.mListener;     // Catch: Throwable -> L39
        if (r112 == null) goto L31;
        r112.onAnimationStart();     // Catch: Throwable -> L39
    L31:
        this.mStarted = true;     // Catch: Throwable -> L39
    L33:
        if (r106 == this.mEnded) goto L41;
        Animation.AnimationListener r113 = this.mListener;     // Catch: Throwable -> L39
        if (r113 == null) goto L37;
        r113.onAnimationEnd();     // Catch: Throwable -> L39
    L37:
        this.mEnded = r106;     // Catch: Throwable -> L39
        goto L41
    }
}
