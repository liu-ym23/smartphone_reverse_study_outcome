package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/sheet/W;", "", "", "startA", "commitB", "widthA", "widthB", "coefficient", "dimension", "<init>", "(FFFFFF)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", Const.INTENT_KEY_UMID, "()F", Const.INTENT_KEY_PKGNAME, "e", "f", Const.INTENT_KEY_APIKEY, "c", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.W, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class RubberBandConfig {
    private final float coefficient;
    private final float commitB;
    private final float dimension;
    private final float startA;
    private final float widthA;
    private final float widthB;

    public RubberBandConfig(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.startA = f10;
        this.commitB = f11;
        this.widthA = f12;
        this.widthB = f13;
        this.coefficient = f14;
        this.dimension = f15;
        if (f11 <= f10) {
            throw new IllegalArgumentException("commitB must be greater than startA");
        }
        if (f14 <= 0.0f) {
            throw new IllegalArgumentException("coefficient must be greater than 0");
        }
        if (f15 <= 0.0f) {
            throw new IllegalArgumentException("dimension must be greater than 0");
        }
    }

    /* renamed from: a, reason: from getter */
    public final float getCoefficient() {
        return this.coefficient;
    }

    /* renamed from: b, reason: from getter */
    public final float getCommitB() {
        return this.commitB;
    }

    /* renamed from: c, reason: from getter */
    public final float getDimension() {
        return this.dimension;
    }

    /* renamed from: d, reason: from getter */
    public final float getStartA() {
        return this.startA;
    }

    /* renamed from: e, reason: from getter */
    public final float getWidthA() {
        return this.widthA;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RubberBandConfig)) {
            return false;
        }
        RubberBandConfig rubberBandConfig = (RubberBandConfig) other;
        return Float.compare(this.startA, rubberBandConfig.startA) == 0 && Float.compare(this.commitB, rubberBandConfig.commitB) == 0 && Float.compare(this.widthA, rubberBandConfig.widthA) == 0 && Float.compare(this.widthB, rubberBandConfig.widthB) == 0 && Float.compare(this.coefficient, rubberBandConfig.coefficient) == 0 && Float.compare(this.dimension, rubberBandConfig.dimension) == 0;
    }

    /* renamed from: f, reason: from getter */
    public final float getWidthB() {
        return this.widthB;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.startA) * 31) + Float.hashCode(this.commitB)) * 31) + Float.hashCode(this.widthA)) * 31) + Float.hashCode(this.widthB)) * 31) + Float.hashCode(this.coefficient)) * 31) + Float.hashCode(this.dimension);
    }

    public String toString() {
        return "RubberBandConfig(startA=" + this.startA + ", commitB=" + this.commitB + ", widthA=" + this.widthA + ", widthB=" + this.widthB + ", coefficient=" + this.coefficient + ", dimension=" + this.dimension + ")";
    }

    public /* synthetic */ RubberBandConfig(float f10, float f11, float f12, float f13, float f14, float f15, int i10, kotlin.jvm.internal.i iVar) {
        this(f10, f11, f12, f13, (i10 & 16) != 0 ? 0.85f : f14, (i10 & 32) != 0 ? 2466.0f : f15);
    }
}
