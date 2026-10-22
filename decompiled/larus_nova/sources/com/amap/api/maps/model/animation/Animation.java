package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.amap.api.mapcore.util.a9;
import com.amap.api.mapcore.util.v3;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.amap.mapcore.animation.GLAnimation;

/* JADX INFO: loaded from: classes28.dex */
public abstract class Animation {
    public static final int FILL_MODE_BACKWARDS = 1;
    public static final int FILL_MODE_FORWARDS = 0;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    protected String animationType;
    private long duration;
    private int fillMode;
    public GLAnimation glAnimation;
    private Interpolator interpolator;
    private boolean mFillAfter;
    private boolean mFillBefore;
    private boolean mFillEnabled;
    private AnimationListener mListener;
    private int mRepeatCount;
    private int mRepeatMode;
    private AnimationUpdateFlags updateFlags;

    public interface AnimationListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public static class AnimationUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean durationUpdate;
        protected boolean fillModeUpdate;
        protected boolean interpolatorUpdate;
        protected boolean mFillAfterUpdate;
        protected boolean mFillBeforeUpdate;
        protected boolean mFillEnabledUpdate;
        protected boolean mListenerUpdate;
        protected boolean mRepeatCountUpdate;
        protected boolean mRepeatModeUpdate;

        public AnimationUpdateFlags() {
            this.mListenerUpdate = false;
            this.durationUpdate = false;
            this.interpolatorUpdate = false;
            this.fillModeUpdate = false;
            this.mFillEnabledUpdate = false;
            this.mFillAfterUpdate = false;
            this.mFillBeforeUpdate = false;
            this.mRepeatCountUpdate = false;
            this.mRepeatModeUpdate = false;
        }

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.mListenerUpdate = false;
            this.durationUpdate = false;
            this.interpolatorUpdate = false;
            this.fillModeUpdate = false;
            this.mFillEnabledUpdate = false;
            this.mFillAfterUpdate = false;
            this.mFillBeforeUpdate = false;
            this.mRepeatCountUpdate = false;
            this.mRepeatModeUpdate = false;
        }
    }

    public static /* synthetic */ class a {
    }

    public class b implements AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a9 f28670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a9 f28671b;

        public class a extends a9 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AnimationListener f28672b;

            @Override // com.amap.api.mapcore.util.a9
            public void runTask() {
                AnimationListener r100 = this.f28672b;     // Catch: Throwable -> L6
                if (r100 == null) goto L11;
                r100.onAnimationStart();     // Catch: Throwable -> L6
                return;
            L11:
                return;
            L6:
                th = move-exception;
                th.printStackTrace();
            }

            public a(b r100, Animation r101, AnimationListener r102) {
                this.f28672b = r102;
            }
        }

        /* JADX INFO: renamed from: com.amap.api.maps.model.animation.Animation$b$b, reason: collision with other inner class name */
        public class C0515b extends a9 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AnimationListener f28673b;

            @Override // com.amap.api.mapcore.util.a9
            public void runTask() {
                AnimationListener r100 = this.f28673b;     // Catch: Throwable -> L6
                if (r100 == null) goto L11;
                r100.onAnimationEnd();     // Catch: Throwable -> L6
                return;
            L11:
                return;
            L6:
                th = move-exception;
                th.printStackTrace();
            }

            public C0515b(b r100, Animation r101, AnimationListener r102) {
                this.f28673b = r102;
            }
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public void onAnimationEnd() {
            v3.b().a(this.f28671b);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public void onAnimationStart() {
            v3.b().a(this.f28670a);
        }

        private b(Animation r100, AnimationListener r101) {
            this.f28670a = new a(this, r100, r101);
            this.f28671b = new C0515b(this, r100, r101);
        }

        public /* synthetic */ b(Animation r100, AnimationListener r101, a r102) {
            this(r100, r101);
        }
    }

    public abstract String getAnimationType();

    public int getRepeatCount() {
        GLAnimation r100 = this.glAnimation;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getRepeatCount();
    }

    public int getRepeatMode() {
        GLAnimation r100 = this.glAnimation;
        if (r100 != null) goto L5;
        return 1;
    L5:
        return r100.getRepeatMode();
    }

    public void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public Animation() {
        this.fillMode = 0;
        this.duration = 500;
        this.interpolator = null;
        this.animationType = "typeAnimtionBase";
        this.mFillBefore = true;
        this.mFillAfter = false;
        this.mFillEnabled = false;
        this.mRepeatCount = 0;
        this.mRepeatMode = 1;
        this.glAnimation = null;
        this.updateFlags = new AnimationUpdateFlags();
        this.glAnimation = new GLAnimation();
        this.animationType = getAnimationType();
    }

    public int getFillMode() {
        return this.fillMode;
    }

    public AnimationUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public void setAnimationListener(AnimationListener r100) {
        this.mListener = new b(this, r100, null);
        this.glAnimation.setAnimationListener(r100);
        this.updateFlags.mListenerUpdate = true;
    }

    public void setDuration(long r100) {
        this.duration = r100;
        GLAnimation r101 = this.glAnimation;
        if (r101 == null) goto L5;
        r101.setDuration(r100);
    L5:
        this.updateFlags.durationUpdate = true;
    }

    public void setFillMode(int r100) {
        this.fillMode = r100;
        if (r100 != 0) goto L14;
        this.mFillAfter = true;
        GLAnimation r101 = this.glAnimation;
        if (r101 == null) goto L7;
        r101.setFillAfter(true);
    L7:
        this.updateFlags.mFillAfterUpdate = true;
        this.mFillBefore = false;
        GLAnimation r102 = this.glAnimation;
        if (r102 == null) goto L10;
        r102.setFillBefore(false);
    L10:
        this.updateFlags.mFillBeforeUpdate = true;
        this.mFillEnabled = false;
        GLAnimation r103 = this.glAnimation;
        if (r103 == null) goto L13;
        r103.setFillEnabled(false);
    L13:
        this.updateFlags.mFillEnabledUpdate = true;
    L24:
        this.updateFlags.fillModeUpdate = true;
        return;
    L14:
        this.mFillAfter = false;
        GLAnimation r104 = this.glAnimation;
        if (r104 == null) goto L17;
        r104.setFillAfter(false);
    L17:
        this.updateFlags.mFillAfterUpdate = true;
        this.mFillEnabled = true;
        GLAnimation r105 = this.glAnimation;
        if (r105 == null) goto L20;
        r105.setFillEnabled(true);
    L20:
        this.updateFlags.mFillEnabledUpdate = true;
        this.mFillBefore = true;
        GLAnimation r106 = this.glAnimation;
        if (r106 == null) goto L23;
        r106.setFillBefore(true);
    L23:
        this.updateFlags.mFillBeforeUpdate = true;
        goto L24
    }

    public void setInterpolator(Interpolator r100) {
        this.interpolator = r100;
        GLAnimation r101 = this.glAnimation;
        if (r101 == null) goto L5;
        r101.setInterpolator(r100);
    L5:
        this.updateFlags.interpolatorUpdate = true;
    }

    public void setRepeatCount(int r100) {
        this.mRepeatCount = r100;
        GLAnimation r101 = this.glAnimation;
        if (r101 == null) goto L5;
        r101.setRepeatCount(r100);
    L5:
        this.updateFlags.mRepeatCountUpdate = true;
    }

    public void setRepeatMode(int r100) {
        this.mRepeatMode = r100;
        GLAnimation r101 = this.glAnimation;
        if (r101 == null) goto L5;
        r101.setRepeatMode(r100);
    L5:
        this.updateFlags.mRepeatModeUpdate = true;
    }
}
