package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ShadowOffset;", "Ljava/io/Serializable;", "x", "", "y", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getX", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getY", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/ShadowOffset;", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShadowOffset implements Serializable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private final Double f169033x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private final Double f169034y;

    /* JADX WARN: Multi-variable type inference failed */
    public ShadowOffset() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ShadowOffset copy$default(ShadowOffset r100, Double r101, Double r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f169033x;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f169034y;
    L9:
        return r100.copy(r101, r102);
    }

    public final Double component1() {
        return this.f169033x;
    }

    public final Double component2() {
        return this.f169034y;
    }

    public final ShadowOffset copy(Double r100, Double r101) {
        return new ShadowOffset(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShadowOffset) == false) goto L10;
        ShadowOffset r101 = (ShadowOffset) r100;
        if (Intrinsics.areEqual(this.f169033x, r101.f169033x) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f169034y, r101.f169034y) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Double r100 = this.f169033x;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Double r104 = this.f169034y;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ShadowOffset(x=" + this.f169033x + ", y=" + this.f169034y + ")";
    }

    public final Double getX() {
        return this.f169033x;
    }

    public final Double getY() {
        return this.f169034y;
    }

    public ShadowOffset(Double r100, Double r101) {
        this.f169033x = r100;
        this.f169034y = r101;
    }

    public /* synthetic */ ShadowOffset(Double r100, Double r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
