package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapsdkplatform.comapi.animation.BDAnimation;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public abstract class Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RepeatMode f30518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f30519b;
    public BDAnimation bdAnimation;
    public BmAnimation bmAnimation;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f30520c;

    public interface AnimationListener {
        void onAnimationCancel();

        void onAnimationEnd();

        void onAnimationRepeat();

        void onAnimationStart();
    }

    public static final enum RepeatMode extends Enum<RepeatMode> {
        public static final RepeatMode RESTART = null;
        public static final RepeatMode REVERSE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ RepeatMode[] f30521a = null;

        static {
            RepeatMode r100 = new RepeatMode("RESTART", 0);
            RESTART = r100;
            RepeatMode r101 = new RepeatMode("REVERSE", 1);
            REVERSE = r101;
            f30521a = new RepeatMode[]{r100, r101};
        }

        public static RepeatMode[] values() {
            return (RepeatMode[]) f30521a.clone();
        }

        public static RepeatMode valueOf(String r100) {
            return (RepeatMode) a.a(RepeatMode.class, r100);
        }

        private RepeatMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract void cancel();

    public abstract void setAnimationListener(AnimationListener r100);

    public abstract void setDuration(long r100);

    public abstract void setInterpolator(Interpolator r100);

    public Animation() {
    }

    public long getDuration() {
        return this.f30520c;
    }

    public int getRepeatCount() {
        return this.f30519b;
    }

    public RepeatMode getRepeatMode() {
        return this.f30518a;
    }
}
