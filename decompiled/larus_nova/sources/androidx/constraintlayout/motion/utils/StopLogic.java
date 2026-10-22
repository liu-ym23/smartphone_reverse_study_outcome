package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* JADX INFO: loaded from: classes17.dex */
public class StopLogic extends MotionInterpolator {
    private boolean mBackwards;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        if (this.mBackwards == false) goto L6;
        return -getVelocity(this.mLastPosition);
    L6:
        return getVelocity(this.mLastPosition);
    }

    public StopLogic() {
        this.mBackwards = false;
    }

    private float calcY(float r100) {
        float r101 = this.mStage1Duration;
        if (r100 > r101) goto L6;
        float r102 = this.mStage1Velocity;
        return (r102 * r100) + ((((this.mStage2Velocity - r102) * r100) * r100) / (r101 * 2.0f));
    L6:
        int r103 = this.mNumberOfStages;
        if (r103 == 1) goto L9;
        float r104 = r100 - r101;
        float r105 = this.mStage2Duration;
        if (r104 >= r105) goto L15;
        float r106 = this.mStage1EndPosition;
        float r107 = this.mStage2Velocity;
        return (r106 + (r107 * r104)) + ((((this.mStage3Velocity - r107) * r104) * r104) / (r105 * 2.0f));
    L15:
        if (r103 == 2) goto L17;
        float r108 = r104 - r105;
        float r109 = this.mStage3Duration;
        if (r108 >= r109) goto L23;
        float r110 = this.mStage2EndPosition;
        float r111 = this.mStage3Velocity;
        return (r110 + (r111 * r108)) - (((r111 * r108) * r108) / (r109 * 2.0f));
    L23:
        return this.mStage3EndPosition;
    L17:
        return this.mStage2EndPosition;
    L9:
        return this.mStage1EndPosition;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float r100) {
        float r101 = calcY(r100);
        this.mLastPosition = r100;
        if (this.mBackwards == false) goto L6;
        return this.mStartPosition - r101;
    L6:
        return this.mStartPosition + r101;
    }

    public float getVelocity(float r100) {
        float r101 = this.mStage1Duration;
        if (r100 > r101) goto L6;
        float r102 = this.mStage1Velocity;
        return r102 + (((this.mStage2Velocity - r102) * r100) / r101);
    L6:
        int r103 = this.mNumberOfStages;
        if (r103 != 1) goto L10;
        return 0.0f;
    L10:
        float r104 = r100 - r101;
        float r105 = this.mStage2Duration;
        if (r104 >= r105) goto L15;
        float r106 = this.mStage2Velocity;
        return r106 + (((this.mStage3Velocity - r106) * r104) / r105);
    L15:
        if (r103 == 2) goto L17;
        float r107 = r104 - r105;
        float r108 = this.mStage3Duration;
        if (r107 >= r108) goto L23;
        float r109 = this.mStage3Velocity;
        return r109 - ((r107 * r109) / r108);
    L23:
        return this.mStage3EndPosition;
    L17:
        return this.mStage2EndPosition;
    }

    public void debug(String r100, String r101, float r102) {
        int r103 = this.mNumberOfStages;
        float r104 = this.mStage1Duration;
        if (r103 > 1) goto L6;
    L6:
        if (r103 > 2) goto L9;
    L9:
        if (r102 <= r104) goto L11;
        if (r103 == 1) goto L14;
        float r105 = r102 - r104;
        float r106 = this.mStage2Duration;
        if (r105 < r106) goto L18;
        if (r103 != 2) goto L23;
        return;
    L23:
        if ((r105 - r106) >= this.mStage3Duration) goto L27;
        return;
    L27:
        return;
    L18:
        return;
    L14:
        return;
    }

    private void setup(float r100, float r110, float r111, float r112, float r113) {
        if (r100 != 0.0f) goto L5;
        r100 = 1.0E-4f;
    L5:
        this.mStage1Velocity = r100;
        float r101 = r100 / r111;
        float r102 = (r101 * r100) / 2.0f;
        if (r100 >= 0.0f) goto L14;
        float r114 = (float) Math.sqrt((r110 - ((((-r100) / r111) * r100) / 2.0f)) * r111);
        if (r114 >= r112) goto L11;
        this.mType = "backward accelerate, decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = r100;
        this.mStage2Velocity = r114;
        this.mStage3Velocity = 0.0f;
        float r115 = (r114 - r100) / r111;
        this.mStage1Duration = r115;
        this.mStage2Duration = r114 / r111;
        this.mStage1EndPosition = ((r100 + r114) * r115) / 2.0f;
        this.mStage2EndPosition = r110;
        this.mStage3EndPosition = r110;
        return;
    L11:
        this.mType = "backward accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = r100;
        this.mStage2Velocity = r112;
        this.mStage3Velocity = r112;
        float r116 = (r112 - r100) / r111;
        this.mStage1Duration = r116;
        float r117 = r112 / r111;
        this.mStage3Duration = r117;
        float r103 = ((r100 + r112) * r116) / 2.0f;
        float r118 = (r117 * r112) / 2.0f;
        this.mStage2Duration = ((r110 - r103) - r118) / r112;
        this.mStage1EndPosition = r103;
        this.mStage2EndPosition = r110 - r118;
        this.mStage3EndPosition = r110;
        return;
    L14:
        if (r102 < r110) goto L17;
        this.mType = "hard stop";
        this.mNumberOfStages = 1;
        this.mStage1Velocity = r100;
        this.mStage2Velocity = 0.0f;
        this.mStage1EndPosition = r110;
        this.mStage1Duration = (2.0f * r110) / r100;
        return;
    L17:
        float r104 = r110 - r102;
        float r105 = r104 / r100;
        if ((r105 + r101) >= r113) goto L21;
        this.mType = "cruse decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = r100;
        this.mStage2Velocity = r100;
        this.mStage3Velocity = 0.0f;
        this.mStage1EndPosition = r104;
        this.mStage2EndPosition = r110;
        this.mStage1Duration = r105;
        this.mStage2Duration = r101;
        return;
    L21:
        float r119 = (float) Math.sqrt((r111 * r110) + ((r100 * r100) / 2.0f));
        float r106 = (r119 - r100) / r111;
        this.mStage1Duration = r106;
        float r107 = r119 / r111;
        this.mStage2Duration = r107;
        if (r119 >= r112) goto L25;
        this.mType = "accelerate decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = r100;
        this.mStage2Velocity = r119;
        this.mStage3Velocity = 0.0f;
        this.mStage1Duration = r106;
        this.mStage2Duration = r107;
        this.mStage1EndPosition = ((r100 + r119) * r106) / 2.0f;
        this.mStage2EndPosition = r110;
        return;
    L25:
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = r100;
        this.mStage2Velocity = r112;
        this.mStage3Velocity = r112;
        float r120 = (r112 - r100) / r111;
        this.mStage1Duration = r120;
        float r121 = r112 / r111;
        this.mStage3Duration = r121;
        float r108 = ((r100 + r112) * r120) / 2.0f;
        float r122 = (r121 * r112) / 2.0f;
        this.mStage2Duration = ((r110 - r108) - r122) / r112;
        this.mStage1EndPosition = r108;
        this.mStage2EndPosition = r110 - r122;
        this.mStage3EndPosition = r110;
    }

    public void config(float r100, float r101, float r102, float r110, float r111, float r112) {
        this.mStartPosition = r100;
        if (r100 <= r101) goto L5;
        boolean r103 = true;
    L6:
        this.mBackwards = r103;
        if (r103 == false) goto L9;
        setup(-r102, r100 - r101, r111, r112, r110);
        return;
    L9:
        setup(r102, r101 - r100, r111, r112, r110);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
