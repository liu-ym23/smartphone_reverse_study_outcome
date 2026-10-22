package android.view.animation;

/* loaded from: classes.dex */
public class StepOSTransformationExtImpl implements IStepOSTransformationExt {
    protected float mCornerRadius;
    protected boolean mHasCornerRadius;
    protected Transformation mHost;

    public void onAttach(Transformation host) {
        this.mHost = host;
    }

    public void setCornerRadius(float cornerRadius) {
        this.mCornerRadius = cornerRadius;
        this.mHasCornerRadius = true;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public boolean hasCornerRadius() {
        return this.mHasCornerRadius;
    }

    public void clear() {
        this.mCornerRadius = 0.0f;
        this.mHasCornerRadius = false;
    }

    public void setFrom(Transformation other) {
        if (other == null || other.mStepOSExt == null) {
            return;
        }
        this.mCornerRadius = other.mStepOSExt.getCornerRadius();
        this.mHasCornerRadius = other.mStepOSExt.hasCornerRadius();
    }

    public void composeFrom(Transformation other) {
        if (other == null || other.mStepOSExt == null) {
            return;
        }
        this.mCornerRadius = Math.max(other.mStepOSExt.getCornerRadius(), this.mCornerRadius);
        this.mHasCornerRadius = this.mHasCornerRadius || other.mStepOSExt.hasCornerRadius();
    }
}
