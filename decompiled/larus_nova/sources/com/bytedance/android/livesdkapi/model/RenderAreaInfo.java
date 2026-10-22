package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "", "x", "", "y", "w", "h", "(FFFF)V", "getH", "()F", "isGame", "", "()Z", "setGame", "(Z)V", "getW", "getX", "getY", "equals", "other", "hashCode", "", "isValidHorizontalArea", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RenderAreaInfo {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f162637h;
    private boolean isGame;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final float f162638w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f162639x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f162640y;

    public RenderAreaInfo() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f162639x) * 31) + Float.floatToIntBits(this.f162640y)) * 31) + Float.floatToIntBits(this.f162638w)) * 31) + Float.floatToIntBits(this.f162637h);
    }

    public final boolean isValidHorizontalArea() {
        float r100 = this.f162639x;
        if (r100 >= (-1.0f)) goto L5;
        return false;
    L5:
        if (r100 > 1.0f) goto L21;
        float r101 = this.f162640y;
        if (r101 >= (-1.0f)) goto L9;
        return false;
    L9:
        if (r101 > 1.0f) goto L23;
        float r102 = this.f162638w;
        float r103 = 0;
        if (r102 <= r103) goto L24;
        float r104 = 1;
        if (r102 > r104) goto L25;
        float r105 = this.f162637h;
        if (r105 > r103) goto L17;
        return false;
    L17:
        if (r105 > r104) goto L27;
        return true;
    L27:
        return false;
    L25:
        return false;
    L24:
        return false;
    L23:
        return false;
    L21:
        return false;
    }

    public String toString() {
        return "RenderAreaInfo(x=" + this.f162639x + ", y=" + this.f162640y + ", w=" + this.f162638w + ", h=" + this.f162637h + ')';
    }

    public final float getH() {
        return this.f162637h;
    }

    public final float getW() {
        return this.f162638w;
    }

    public final float getX() {
        return this.f162639x;
    }

    public final float getY() {
        return this.f162640y;
    }

    public final boolean isGame() {
        return this.isGame;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(RenderAreaInfo.class, r101)) == false) goto L13;
        return false;
    L13:
        if ((r100 instanceof RenderAreaInfo) == true) goto L15;
        return false;
    L15:
        RenderAreaInfo r102 = (RenderAreaInfo) r100;
        if (this.f162639x == r102.f162639x) goto L19;
        return false;
    L19:
        if (this.f162640y == r102.f162640y) goto L22;
        return false;
    L22:
        if (this.f162638w == r102.f162638w) goto L25;
        return false;
    L25:
        if (this.f162637h == r102.f162637h) goto L27;
        return false;
    L27:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setGame(boolean r100) {
        this.isGame = r100;
    }

    public RenderAreaInfo(float r100, float r101, float r102, float r103) {
        this.f162639x = r100;
        this.f162640y = r101;
        this.f162638w = r102;
        this.f162637h = r103;
    }

    public /* synthetic */ RenderAreaInfo(float r100, float r101, float r102, float r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0.0f;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0.0f;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0.0f;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0.0f;
    L14:
        this(r100, r101, r102, r103);
    }
}
