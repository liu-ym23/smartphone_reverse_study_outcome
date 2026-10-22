package com.bytedance.android.ec.model.sku;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/model/sku/Position;", "Ljava/io/Serializable;", "x", "", "y", "(DD)V", "getX", "()D", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class Position implements Serializable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private final double f47964x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private final double f47965y;

    public Position() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 3, null);
    }

    public static /* synthetic */ Position copy$default(Position r100, double r101, double r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f47964x;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f47965y;
    L9:
        return r100.copy(r101, r102);
    }

    public final double component1() {
        return this.f47964x;
    }

    public final double component2() {
        return this.f47965y;
    }

    public final Position copy(double r100, double r101) {
        return new Position(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Position) == false) goto L10;
        Position r101 = (Position) r100;
        if (Double.compare(this.f47964x, r101.f47964x) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.f47965y, r101.f47965y) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.f47964x);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f47965y);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "Position(x=" + this.f47964x + ", y=" + this.f47965y + ")";
    }

    public final double getX() {
        return this.f47964x;
    }

    public final double getY() {
        return this.f47965y;
    }

    public Position(double r100, double r101) {
        this.f47964x = r100;
        this.f47965y = r101;
    }

    public /* synthetic */ Position(double r100, double r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0.0d;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0.0d;
    L8:
        this(r100, r101);
    }
}
