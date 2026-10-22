package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0005R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R*\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0005R$\u0010&\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0005\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Landroidx/compose/animation/core/SpringSimulation;", "", "", "finalPosition", AppAgent.CONSTRUCT, "(F)V", "LC7/r;", "init", "()V", "lastDisplacement", "lastVelocity", "getAcceleration", "(FF)F", "", "timeElapsed", "Landroidx/compose/animation/core/Motion;", "updateValues-IJZedt4$animation_core_release", "(FFJ)J", "updateValues", "F", "getFinalPosition", "()F", "setFinalPosition", "", "naturalFreq", "D", "", "initialized", "Z", "gammaPlus", "gammaMinus", "dampedFreq", "value", "dampingRatio", "getDampingRatio", "setDampingRatio", "getStiffness", "setStiffness", "stiffness", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SpringSimulation {
    public static final int $stable = 8;
    private double dampedFreq;
    private float finalPosition;
    private double gammaMinus;
    private double gammaPlus;
    private boolean initialized;
    private double naturalFreq = Math.sqrt(50.0d);
    private float dampingRatio = 1.0f;

    public SpringSimulation(float f) {
        this.finalPosition = f;
    }

    private final void init() {
        if (this.initialized) {
            return;
        }
        if (this.finalPosition == SpringSimulationKt.getUNSET()) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        float f = this.dampingRatio;
        double d = f * f;
        if (f > 1.0f) {
            double d6 = this.naturalFreq;
            double d10 = d - 1;
            this.gammaPlus = (Math.sqrt(d10) * d6) + ((-f) * d6);
            double d11 = -this.dampingRatio;
            double d12 = this.naturalFreq;
            this.gammaMinus = (d11 * d12) - (Math.sqrt(d10) * d12);
        } else if (f >= 0.0f && f < 1.0f) {
            this.dampedFreq = Math.sqrt(1 - d) * this.naturalFreq;
        }
        this.initialized = true;
    }

    public final float getAcceleration(float lastDisplacement, float lastVelocity) {
        float f = lastDisplacement - this.finalPosition;
        double d = this.naturalFreq;
        return (float) (((-(d * d)) * f) - (((d * 2.0d) * this.dampingRatio) * lastVelocity));
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public final float getStiffness() {
        double d = this.naturalFreq;
        return (float) (d * d);
    }

    public final void setDampingRatio(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.dampingRatio = f;
        this.initialized = false;
    }

    public final void setFinalPosition(float f) {
        this.finalPosition = f;
    }

    public final void setStiffness(float f) {
        if (getStiffness() <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.naturalFreq = Math.sqrt(f);
        this.initialized = false;
    }

    /* renamed from: updateValues-IJZedt4$animation_core_release, reason: not valid java name */
    public final long m171updateValuesIJZedt4$animation_core_release(float lastDisplacement, float lastVelocity, long timeElapsed) {
        double dCos;
        double dExp;
        double dExp2;
        double dExp3;
        init();
        float f = lastDisplacement - this.finalPosition;
        double d = timeElapsed / 1000.0d;
        float f7 = this.dampingRatio;
        if (f7 > 1.0f) {
            double d6 = f;
            double d10 = this.gammaMinus;
            double d11 = lastVelocity;
            double d12 = this.gammaPlus;
            double d13 = d6 - (((d10 * d6) - d11) / (d10 - d12));
            double d14 = ((d6 * d10) - d11) / (d10 - d12);
            dExp = (Math.exp(this.gammaPlus * d) * d14) + (Math.exp(d10 * d) * d13);
            double d15 = this.gammaMinus;
            dExp2 = Math.exp(d15 * d) * d13 * d15;
            double d16 = this.gammaPlus;
            dExp3 = Math.exp(d16 * d) * d14 * d16;
        } else {
            if (f7 != 1.0f) {
                double d17 = 1 / this.dampedFreq;
                double d18 = this.naturalFreq;
                double d19 = f;
                double d20 = ((f7 * d18 * d19) + lastVelocity) * d17;
                double dExp4 = Math.exp((-f7) * d18 * d) * ((Math.sin(this.dampedFreq * d) * d20) + (Math.cos(this.dampedFreq * d) * d19));
                double d21 = this.naturalFreq;
                double d22 = (-d21) * dExp4 * this.dampingRatio;
                double dExp5 = Math.exp((-r7) * d21 * d);
                double d23 = this.dampedFreq;
                double dSin = Math.sin(d23 * d) * (-d23) * d19;
                double d24 = this.dampedFreq;
                dCos = (((Math.cos(d24 * d) * d20 * d24) + dSin) * dExp5) + d22;
                dExp = dExp4;
                return SpringSimulationKt.Motion((float) (dExp + this.finalPosition), (float) dCos);
            }
            double d25 = this.naturalFreq;
            double d26 = f;
            double d27 = (d25 * d26) + lastVelocity;
            double d28 = (d27 * d) + d26;
            dExp = Math.exp((-d25) * d) * d28;
            double dExp6 = Math.exp((-this.naturalFreq) * d) * d28;
            double d29 = this.naturalFreq;
            dExp2 = dExp6 * (-d29);
            dExp3 = Math.exp((-d29) * d) * d27;
        }
        dCos = dExp3 + dExp2;
        return SpringSimulationKt.Motion((float) (dExp + this.finalPosition), (float) dCos);
    }
}
