package com.android.server.display.auto;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationInfo {
    float accelerateScale;
    float amount;
    float animStartValue;
    float animatedValue;
    float currentAnimationNits;
    int displayId;
    int edrType;
    float hdrTarget;
    boolean isHdrAnimator;
    boolean isPrimaryDispaly;
    boolean isUp;
    float rate;
    int rateType;
    boolean sameInterrupt;
    float sdrTarget;
    int seq;
    float startAnimationNits;
    float startValue;
    float stopAnimationNits;
    float timeDelta;
    float transitionPoint;

    public static class Builder {
        float accelerateScale;
        float amount;
        float animStartValue;
        float animatedValue;
        float currentAnimationNits;
        int displayId;
        int edrType;
        float hdrTarget;
        boolean isHdrAnimator;
        boolean isPrimaryDispaly;
        boolean isUp;
        float rate;
        int rateType;
        boolean sameInterrupt;
        float sdrTarget;
        int seq;
        float startAnimationNits;
        float startValue;
        float stopAnimationNits;
        float timeDelta;
        float transitionPoint;

        public Builder() {
        }

        public static Builder from(AnimationInfo info) {
            Builder builder = new Builder();
            builder.setDisplayId(info.getDisplayId());
            builder.setRateType(info.getRateType());
            builder.setEdrType(info.getEdrType());
            builder.setSeq(info.getSeq());
            builder.setStartValue(info.getStartValue());
            builder.setAnimStartValue(info.getAnimStartValue());
            builder.setAnimatedValue(info.getAnimatedValue());
            builder.setSdrTarget(info.getSdrTarget());
            builder.setHdrTarget(info.getHdrTarget());
            builder.setTransitionPoint(info.getTransitionPoint());
            builder.setTimeDelta(info.getTimeDelta());
            builder.setRate(info.getRate());
            builder.setAmount(info.getAmount());
            builder.setCurrentAnimationNits(info.getCurrentAnimationNits());
            builder.setStartAnimationNits(info.getStartAnimationNits());
            builder.setStopAnimationNits(info.getStopAnimationNits());
            builder.setAccelerateScale(info.getAccelerateScale());
            builder.setIsUp(info.isUp());
            builder.setIsSameInterrupt(info.isSameInterrupt());
            builder.setIsHdrAnimator(info.isHdrAnimator());
            builder.setIsPrimaryDisplay(info.isPrimaryDisplay());
            return builder;
        }

        public AnimationInfo build() {
            return new AnimationInfo(this, null);
        }

        public Builder setDisplayId(int displayId) {
            this.displayId = displayId;
            return this;
        }

        public int getDisplayId() {
            return this.displayId;
        }

        public Builder setRateType(int rateType) {
            this.rateType = rateType;
            return this;
        }

        public int getRateType() {
            return this.rateType;
        }

        public Builder setEdrType(int edrType) {
            this.edrType = edrType;
            return this;
        }

        public int getEdrType() {
            return this.edrType;
        }

        public Builder setSeq(int seq) {
            this.seq = seq;
            return this;
        }

        public int getSeq() {
            return this.seq;
        }

        public Builder setStartValue(float startValue) {
            this.startValue = startValue;
            return this;
        }

        public float getStartValue() {
            return this.startValue;
        }

        public Builder setAnimStartValue(float animStartValue) {
            this.animStartValue = animStartValue;
            return this;
        }

        public float getAnimStartValue() {
            return this.animStartValue;
        }

        public Builder setAnimatedValue(float animatedValue) {
            this.animatedValue = animatedValue;
            return this;
        }

        public float getAnimatedValue() {
            return this.animatedValue;
        }

        public Builder setSdrTarget(float sdrTarget) {
            this.sdrTarget = sdrTarget;
            return this;
        }

        public float getSdrTarget() {
            return this.sdrTarget;
        }

        public Builder setHdrTarget(float hdrTarget) {
            this.hdrTarget = hdrTarget;
            return this;
        }

        public float getHdrTarget() {
            return this.hdrTarget;
        }

        public Builder setTransitionPoint(float transitionPoint) {
            this.transitionPoint = transitionPoint;
            return this;
        }

        public float getTransitionPoint() {
            return this.transitionPoint;
        }

        public Builder setTimeDelta(float timeDelta) {
            this.timeDelta = timeDelta;
            return this;
        }

        public float getTimeDelta() {
            return this.timeDelta;
        }

        public Builder setRate(float rate) {
            this.rate = rate;
            return this;
        }

        public float getRate() {
            return this.rate;
        }

        public Builder setAmount(float amount) {
            this.amount = amount;
            return this;
        }

        public float getAmount() {
            return this.amount;
        }

        public Builder setCurrentAnimationNits(float currentAnimationNits) {
            this.currentAnimationNits = currentAnimationNits;
            return this;
        }

        public float getCurrentAnimationNits() {
            return this.currentAnimationNits;
        }

        public Builder setStartAnimationNits(float startAnimationNits) {
            this.startAnimationNits = startAnimationNits;
            return this;
        }

        public float getStartAnimationNits() {
            return this.startAnimationNits;
        }

        public Builder setStopAnimationNits(float stopAnimationNits) {
            this.stopAnimationNits = stopAnimationNits;
            return this;
        }

        public float getStopAnimationNits() {
            return this.stopAnimationNits;
        }

        public Builder setAccelerateScale(float accelerateScale) {
            this.accelerateScale = accelerateScale;
            return this;
        }

        public float getAccelerateScale() {
            return this.accelerateScale;
        }

        public Builder setIsUp(boolean isUp) {
            this.isUp = isUp;
            return this;
        }

        public boolean isUp() {
            return this.isUp;
        }

        public Builder setIsSameInterrupt(boolean sameInterrupt) {
            this.sameInterrupt = sameInterrupt;
            return this;
        }

        public boolean isSameInterrupt() {
            return this.sameInterrupt;
        }

        public Builder setIsHdrAnimator(boolean isHdrAnimator) {
            this.isHdrAnimator = isHdrAnimator;
            return this;
        }

        public boolean isHdrAnimator() {
            return this.isHdrAnimator;
        }

        public Builder setIsPrimaryDisplay(boolean isPrimaryDispaly) {
            this.isPrimaryDispaly = isPrimaryDispaly;
            return this;
        }

        public boolean isPrimaryDisplay() {
            return this.isPrimaryDispaly;
        }
    }

    /* synthetic */ AnimationInfo(Builder r1, AnimationInfoIA r2) {
        this(r1);
    }

    private AnimationInfo(Builder builder) {
        this.displayId = builder.getDisplayId();
        this.rateType = builder.getRateType();
        this.edrType = builder.getEdrType();
        this.seq = builder.getSeq();
        this.startValue = builder.getStartValue();
        this.animStartValue = builder.getAnimStartValue();
        this.animatedValue = builder.getAnimatedValue();
        this.sdrTarget = builder.getSdrTarget();
        this.hdrTarget = builder.getHdrTarget();
        this.transitionPoint = builder.getTransitionPoint();
        this.timeDelta = builder.getTimeDelta();
        this.rate = builder.getRate();
        this.amount = builder.getAmount();
        this.currentAnimationNits = builder.getCurrentAnimationNits();
        this.startAnimationNits = builder.getStartAnimationNits();
        this.stopAnimationNits = builder.getStopAnimationNits();
        this.accelerateScale = builder.getAccelerateScale();
        this.isUp = builder.isUp();
        this.sameInterrupt = builder.isSameInterrupt();
        this.isHdrAnimator = builder.isHdrAnimator();
        this.isPrimaryDispaly = builder.isPrimaryDisplay();
    }

    public int getDisplayId() {
        return this.displayId;
    }

    public int getRateType() {
        return this.rateType;
    }

    public int getEdrType() {
        return this.edrType;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getSeq() {
        return this.seq;
    }

    public float getStartValue() {
        return this.startValue;
    }

    public float getAnimStartValue() {
        return this.animStartValue;
    }

    public float getAnimatedValue() {
        return this.animatedValue;
    }

    public float getSdrTarget() {
        return this.sdrTarget;
    }

    public float getHdrTarget() {
        return this.hdrTarget;
    }

    public float getTransitionPoint() {
        return this.transitionPoint;
    }

    public void setTransitionPoint(float transitionPoint) {
        this.transitionPoint = transitionPoint;
    }

    public float getTimeDelta() {
        return this.timeDelta;
    }

    public float getRate() {
        return this.rate;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setCurrentAnimationNits(float currentAnimationNits) {
        this.currentAnimationNits = currentAnimationNits;
    }

    public float getCurrentAnimationNits() {
        return this.currentAnimationNits;
    }

    public void setStartAnimationNits(float startAnimationNits) {
        this.startAnimationNits = startAnimationNits;
    }

    public float getStartAnimationNits() {
        return this.startAnimationNits;
    }

    public void setStopAnimationNits(float stopAnimationNits) {
        this.stopAnimationNits = stopAnimationNits;
    }

    public float getStopAnimationNits() {
        return this.stopAnimationNits;
    }

    public void setAccelerateScale(float accelerateScale) {
        this.accelerateScale = accelerateScale;
    }

    public float getAccelerateScale() {
        return this.accelerateScale;
    }

    public void setIsUp(boolean isUp) {
        this.isUp = isUp;
    }

    public boolean isUp() {
        return this.isUp;
    }

    public void setIsSameInterrupt(boolean sameInterrupt) {
        this.sameInterrupt = sameInterrupt;
    }

    public boolean isSameInterrupt() {
        return this.sameInterrupt;
    }

    public boolean isHdrAnimator() {
        return this.isHdrAnimator;
    }

    public boolean isPrimaryDisplay() {
        return this.isPrimaryDispaly;
    }

    public String toString() {
        return "{displayId=" + this.displayId + ", rateType=" + this.rateType + ", edrType=" + this.edrType + ", seq=" + this.seq + ", startValue=" + this.startValue + ", animStartValue=" + this.animStartValue + ", animatedValue=" + this.animatedValue + ", sdrTarget=" + this.sdrTarget + ", hdrTarget=" + this.hdrTarget + ", transitionPoint=" + this.transitionPoint + ", timeDelta=" + this.timeDelta + ", rate=" + this.rate + ", amount=" + this.amount + ", currentAnimationNits=" + this.currentAnimationNits + ", startAnimationNits=" + this.startAnimationNits + ", stopAnimationNits=" + this.stopAnimationNits + ", accelerateScale=" + this.accelerateScale + ", isUp=" + this.isUp + ", sameInterrupt=" + this.sameInterrupt + ", isHdrAnimator=" + this.isHdrAnimator + ", isPrimaryDisplay=" + this.isPrimaryDispaly + '}';
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof AnimationInfo) == true) goto L8;
        return false;
    L8:
        AnimationInfo that = (AnimationInfo) o;
        if (this.displayId != that.displayId) goto L52;
        if (this.rateType != that.rateType) goto L52;
        if (this.edrType != that.edrType) goto L52;
        if (this.seq != that.seq) goto L52;
        if (Float.compare(that.startValue, this.startValue) != 0) goto L52;
        if (Float.compare(that.animStartValue, this.animStartValue) != 0) goto L52;
        if (Float.compare(that.animatedValue, this.animatedValue) != 0) goto L52;
        if (Float.compare(that.sdrTarget, this.sdrTarget) != 0) goto L52;
        if (Float.compare(that.hdrTarget, this.hdrTarget) != 0) goto L52;
        if (Float.compare(that.transitionPoint, this.transitionPoint) != 0) goto L52;
        if (Float.compare(that.timeDelta, this.timeDelta) != 0) goto L52;
        if (Float.compare(that.rate, this.rate) != 0) goto L52;
        if (Float.compare(that.amount, this.amount) != 0) goto L52;
        if (Float.compare(that.currentAnimationNits, this.currentAnimationNits) != 0) goto L52;
        if (Float.compare(that.startAnimationNits, this.startAnimationNits) != 0) goto L52;
        if (Float.compare(that.stopAnimationNits, this.stopAnimationNits) != 0) goto L52;
        if (Float.compare(that.accelerateScale, this.accelerateScale) != 0) goto L52;
        if (this.isUp != that.isUp) goto L52;
        if (this.sameInterrupt != that.sameInterrupt) goto L52;
        if (this.isHdrAnimator != that.isHdrAnimator) goto L52;
        if (this.isPrimaryDispaly != that.isPrimaryDispaly) goto L52;
        return true;
    L52:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.displayId), Integer.valueOf(this.rateType), Integer.valueOf(this.edrType), Integer.valueOf(this.seq), Float.valueOf(this.startValue), Float.valueOf(this.animStartValue), Float.valueOf(this.animatedValue), Float.valueOf(this.sdrTarget), Float.valueOf(this.hdrTarget), Float.valueOf(this.transitionPoint), Float.valueOf(this.timeDelta), Float.valueOf(this.rate), Float.valueOf(this.amount), Float.valueOf(this.currentAnimationNits), Float.valueOf(this.startAnimationNits), Float.valueOf(this.stopAnimationNits), Float.valueOf(this.accelerateScale), Boolean.valueOf(this.isUp), Boolean.valueOf(this.sameInterrupt), Boolean.valueOf(this.isHdrAnimator), Boolean.valueOf(this.isPrimaryDispaly)});
    }

    public static Builder builder() {
        return new Builder();
    }
}
