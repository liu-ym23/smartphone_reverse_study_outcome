package androidx.compose.animation.core;

import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J'\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\u0005R$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0005¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/core/SpringSimulation;", "", "finalPosition", "", "<init>", "(F)V", "getFinalPosition", "()F", "setFinalPosition", "naturalFreq", "", "value", "stiffness", "getStiffness", "setStiffness", "dampingRatio", "getDampingRatio", "setDampingRatio", "getAcceleration", "lastDisplacement", "lastVelocity", "updateValues", "Landroidx/compose/animation/core/Motion;", "timeElapsed", "", "updateValues-IJZedt4$animation_core", "(FFJ)J", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SpringSimulation {
    public static final int $stable = 8;
    private float dampingRatio;
    private float finalPosition;
    private double naturalFreq;

    public final float getStiffness() {
        double r100 = this.naturalFreq;
        return (float) (r100 * r100);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public SpringSimulation(float r100) {
        this.finalPosition = r100;
        this.naturalFreq = Math.sqrt(50.0d);
        this.dampingRatio = 1.0f;
    }

    public final void setDampingRatio(float r100) {
        if (r100 >= 0.0f) goto L5;
        PreconditionsKt.throwIllegalArgumentException("Damping ratio must be non-negative");
    L5:
        this.dampingRatio = r100;
    }

    public final void setFinalPosition(float r100) {
        this.finalPosition = r100;
    }

    public final void setStiffness(float r100) {
        if (getStiffness() > 0.0f) goto L5;
        PreconditionsKt.throwIllegalArgumentException("Spring stiffness constant must be positive.");
    L5:
        this.naturalFreq = Math.sqrt(r100);
    }

    public final float getAcceleration(float r100, float r101) {
        float r102 = r100 - this.finalPosition;
        double r103 = this.naturalFreq;
        double r104 = r103 * r103;
        double r105 = (r103 * 2.0d) * ((double) this.dampingRatio);
        return (float) (((-r104) * ((double) r102)) - (r105 * ((double) r101)));
    }

    /* JADX INFO: renamed from: updateValues-IJZedt4$animation_core, reason: not valid java name */
    public final long m170updateValuesIJZedt4$animation_core(float r210, float r211, long r212) {
        float r100 = r210 - this.finalPosition;
        double r101 = r212 / 1000.0d;
        float r102 = this.dampingRatio;
        double r103 = ((double) r102) * ((double) r102);
        double r110 = this.naturalFreq;
        double r104 = ((double) (-r102)) * r110;
        if (r102 <= 1.0f) goto L6;
        double r111 = r110 * Math.sqrt(r103 - ((double) 1));
        double r105 = r104 + r111;
        double r106 = r104 - r111;
        double r112 = r100;
        double r113 = ((r106 * r112) - ((double) r211)) / (r106 - r105);
        double r114 = r112 - r113;
        double r107 = r106 * r101;
        double r108 = r101 * r105;
        double r115 = (Math.exp(r107) * r114) + (Math.exp(r108) * r113);
        double r116 = ((r114 * r106) * Math.exp(r107)) + ((r113 * r105) * Math.exp(r108));
    L12:
        long r109 = Float.floatToRawIntBits((float) (r115 + ((double) this.finalPosition)));
        return Motion.m161constructorimpl((((long) Float.floatToRawIntBits((float) r116)) & BodyPartID.bodyIdMax) | (r109 << 32));
    L6:
        if (r102 != 1.0f) goto L8;
        boolean r117 = true;
    L9:
        if (r117 == false) goto L11;
        double r118 = r100;
        double r119 = ((double) r211) + (r110 * r118);
        double r120 = (-r110) * r101;
        double r121 = r118 + (r101 * r119);
        r115 = r121 * Math.exp(r120);
        r116 = ((r121 * Math.exp(r120)) * (-this.naturalFreq)) + (r119 * Math.exp(r120));
        goto L12
    L11:
        double r122 = 1;
        double r123 = r110 * Math.sqrt(r122 - r103);
        double r124 = r100;
        double r125 = (r122 / r123) * (((-r104) * r124) + ((double) r211));
        double r126 = r123 * r101;
        double r127 = r101 * r104;
        double r128 = Math.exp(r127) * ((Math.cos(r126) * r124) + (Math.sin(r126) * r125));
        r116 = (r104 * r128) + (Math.exp(r127) * ((((-r123) * r124) * Math.sin(r126)) + ((r123 * r125) * Math.cos(r126))));
        r115 = r128;
        goto L12
    L8:
        r117 = false;
        goto L9
    }
}
