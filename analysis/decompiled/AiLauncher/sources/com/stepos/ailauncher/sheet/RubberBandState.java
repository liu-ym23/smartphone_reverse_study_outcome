package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/sheet/Y;", "", "", "visualPull", "sizeX", "progress", "positionVelocity", "sizeVelocity", "", "reachedB", "<init>", "(FFFFFZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "F", "c", "()F", Const.INTENT_KEY_PKGNAME, "getProgress", "getPositionVelocity", "getSizeVelocity", "Z", Const.INTENT_KEY_APIKEY, "()Z", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.Y, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class RubberBandState {
    private final float positionVelocity;
    private final float progress;
    private final boolean reachedB;
    private final float sizeVelocity;
    private final float sizeX;
    private final float visualPull;

    public RubberBandState(float f10, float f11, float f12, float f13, float f14, boolean z10) {
        this.visualPull = f10;
        this.sizeX = f11;
        this.progress = f12;
        this.positionVelocity = f13;
        this.sizeVelocity = f14;
        this.reachedB = z10;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getReachedB() {
        return this.reachedB;
    }

    /* renamed from: b, reason: from getter */
    public final float getSizeX() {
        return this.sizeX;
    }

    /* renamed from: c, reason: from getter */
    public final float getVisualPull() {
        return this.visualPull;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RubberBandState)) {
            return false;
        }
        RubberBandState rubberBandState = (RubberBandState) other;
        return Float.compare(this.visualPull, rubberBandState.visualPull) == 0 && Float.compare(this.sizeX, rubberBandState.sizeX) == 0 && Float.compare(this.progress, rubberBandState.progress) == 0 && Float.compare(this.positionVelocity, rubberBandState.positionVelocity) == 0 && Float.compare(this.sizeVelocity, rubberBandState.sizeVelocity) == 0 && this.reachedB == rubberBandState.reachedB;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.visualPull) * 31) + Float.hashCode(this.sizeX)) * 31) + Float.hashCode(this.progress)) * 31) + Float.hashCode(this.positionVelocity)) * 31) + Float.hashCode(this.sizeVelocity)) * 31) + Boolean.hashCode(this.reachedB);
    }

    public String toString() {
        return "RubberBandState(visualPull=" + this.visualPull + ", sizeX=" + this.sizeX + ", progress=" + this.progress + ", positionVelocity=" + this.positionVelocity + ", sizeVelocity=" + this.sizeVelocity + ", reachedB=" + this.reachedB + ")";
    }
}
