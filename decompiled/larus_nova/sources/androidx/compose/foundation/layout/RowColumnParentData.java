package androidx.compose.foundation.layout;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnParentData;", "", "weight", "", LynxVideoManagerLite.FILL, "", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "flowLayoutData", "Landroidx/compose/foundation/layout/FlowLayoutData;", "<init>", "(FZLandroidx/compose/foundation/layout/CrossAxisAlignment;Landroidx/compose/foundation/layout/FlowLayoutData;)V", "getWeight", "()F", "setWeight", "(F)V", "getFill", "()Z", "setFill", "(Z)V", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "setCrossAxisAlignment", "(Landroidx/compose/foundation/layout/CrossAxisAlignment;)V", "getFlowLayoutData", "()Landroidx/compose/foundation/layout/FlowLayoutData;", "setFlowLayoutData", "(Landroidx/compose/foundation/layout/FlowLayoutData;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RowColumnParentData {
    public static final int $stable = 8;
    private CrossAxisAlignment crossAxisAlignment;
    private boolean fill;
    private FlowLayoutData flowLayoutData;
    private float weight;

    public RowColumnParentData() {
        this(0.0f, false, null, null, 15, null);
    }

    public static /* synthetic */ RowColumnParentData copy$default(RowColumnParentData r100, float r101, boolean r102, CrossAxisAlignment r103, FlowLayoutData r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.weight;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.fill;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.crossAxisAlignment;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.flowLayoutData;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final float component1() {
        return this.weight;
    }

    public final boolean component2() {
        return this.fill;
    }

    public final CrossAxisAlignment component3() {
        return this.crossAxisAlignment;
    }

    public final FlowLayoutData component4() {
        return this.flowLayoutData;
    }

    public final RowColumnParentData copy(float r100, boolean r101, CrossAxisAlignment r102, FlowLayoutData r103) {
        return new RowColumnParentData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RowColumnParentData) == true) goto L8;
        return false;
    L8:
        RowColumnParentData r101 = (RowColumnParentData) r100;
        if (Float.compare(this.weight, r101.weight) == 0) goto L12;
        return false;
    L12:
        if (this.fill == r101.fill) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.crossAxisAlignment, r101.crossAxisAlignment) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.flowLayoutData, r101.flowLayoutData) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = Float.floatToIntBits(this.weight) * 31;
        if (this.fill == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        CrossAxisAlignment r103 = this.crossAxisAlignment;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        FlowLayoutData r107 = this.flowLayoutData;
        if (r107 == null) goto L15;
        r104 = r107.hashCode();
    L15:
        return r106 + r104;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "RowColumnParentData(weight=" + this.weight + ", fill=" + this.fill + ", crossAxisAlignment=" + this.crossAxisAlignment + ", flowLayoutData=" + this.flowLayoutData + ')';
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final FlowLayoutData getFlowLayoutData() {
        return this.flowLayoutData;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final void setCrossAxisAlignment(CrossAxisAlignment r100) {
        this.crossAxisAlignment = r100;
    }

    public final void setFill(boolean r100) {
        this.fill = r100;
    }

    public final void setFlowLayoutData(FlowLayoutData r100) {
        this.flowLayoutData = r100;
    }

    public final void setWeight(float r100) {
        this.weight = r100;
    }

    public RowColumnParentData(float r100, boolean r101, CrossAxisAlignment r102, FlowLayoutData r103) {
        this.weight = r100;
        this.fill = r101;
        this.crossAxisAlignment = r102;
        this.flowLayoutData = r103;
    }

    public /* synthetic */ RowColumnParentData(float r100, boolean r101, CrossAxisAlignment r102, FlowLayoutData r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0.0f;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
