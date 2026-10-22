package androidx.compose.ui.unit;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0001QB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010&J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0007J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0007J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0007J\u0010\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0000H\u0007J\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u0000J\u0015\u0010E\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$¢\u0006\u0004\bF\u0010GJ\b\u0010H\u001a\u00020IH\u0016J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J1\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010O\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010!R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\fR\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\fR\u0011\u00103\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b4\u0010\u001dR\u0011\u00105\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b6\u0010\u001dR\u0011\u00107\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b8\u0010\u001dR\u0011\u00109\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b:\u0010\u001dR\u0011\u0010;\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b<\u0010\u001dR\u0011\u0010=\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b>\u0010\u001dR\u0011\u0010?\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b@\u0010\u001dR\u0011\u0010A\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bB\u0010\u001dR\u0011\u0010C\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bD\u0010\u001d¨\u0006R"}, d2 = {"Landroidx/compose/ui/unit/IntRect;", "", "left", "", "top", "right", "bottom", "<init>", "(IIII)V", "getLeft$annotations", "()V", "getLeft", "()I", "getTop$annotations", "getTop", "getRight$annotations", "getRight", "getBottom$annotations", "getBottom", "width", "getWidth$annotations", "getWidth", "height", "getHeight$annotations", "getHeight", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g$annotations", "getSize-YbymL2g", "()J", "isEmpty", "", "isEmpty$annotations", "()Z", "translate", "offset", "Landroidx/compose/ui/unit/IntOffset;", "translate--gyyYBs", "(J)Landroidx/compose/ui/unit/IntRect;", "translateX", "translateY", WidgetCostModule.TYPE_INFLATE, "delta", "deflate", "intersect", "other", "overlaps", "minDimension", "getMinDimension", "maxDimension", "getMaxDimension", "topLeft", "getTopLeft-nOcc-ac", "topCenter", "getTopCenter-nOcc-ac", "topRight", "getTopRight-nOcc-ac", "centerLeft", "getCenterLeft-nOcc-ac", "center", "getCenter-nOcc-ac", "centerRight", "getCenterRight-nOcc-ac", "bottomLeft", "getBottomLeft-nOcc-ac", "bottomCenter", "getBottomCenter-nOcc-ac", "bottomRight", "getBottomRight-nOcc-ac", "contains", "contains--gyyYBs", "(J)Z", "toString", "", "component1", "component2", "component3", "component4", "copy", "equals", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IntRect {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final IntRect Zero = null;
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/unit/IntRect$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/unit/IntRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/unit/IntRect;", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getZero$annotations() {
        }

        public final IntRect getZero() {
            return IntRect.access$getZero$cp();
        }
    }

    public static /* synthetic */ IntRect copy$default(IntRect r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.left;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.top;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.right;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bottom;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public static /* synthetic */ void getBottom$annotations() {
    }

    public static /* synthetic */ void getHeight$annotations() {
    }

    public static /* synthetic */ void getLeft$annotations() {
    }

    public static /* synthetic */ void getRight$annotations() {
    }

    /* JADX INFO: renamed from: getSize-YbymL2g$annotations, reason: not valid java name */
    public static /* synthetic */ void m7695getSizeYbymL2g$annotations() {
    }

    public static /* synthetic */ void getTop$annotations() {
    }

    public static /* synthetic */ void getWidth$annotations() {
    }

    public static /* synthetic */ void isEmpty$annotations() {
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.top;
    }

    public final int component3() {
        return this.right;
    }

    public final int component4() {
        return this.bottom;
    }

    public final IntRect copy(int r100, int r101, int r102, int r103) {
        return new IntRect(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IntRect) == true) goto L8;
        return false;
    L8:
        IntRect r101 = (IntRect) r100;
        if (this.left == r101.left) goto L12;
        return false;
    L12:
        if (this.top == r101.top) goto L15;
        return false;
    L15:
        if (this.right == r101.right) goto L18;
        return false;
    L18:
        if (this.bottom == r101.bottom) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    static {
        Companion = new Companion(null);
        Zero = new IntRect(0, 0, 0, 0);
    }

    /* JADX INFO: renamed from: getBottomCenter-nOcc-ac, reason: not valid java name */
    public final long m7697getBottomCenternOccac() {
        int r100 = this.left + (getWidth() / 2);
        long r101 = ((long) r100) << 32;
        return IntOffset.m7670constructorimpl((((long) this.bottom) & BodyPartID.bodyIdMax) | r101);
    }

    /* JADX INFO: renamed from: getBottomLeft-nOcc-ac, reason: not valid java name */
    public final long m7698getBottomLeftnOccac() {
        int r100 = this.left;
        long r101 = ((long) r100) << 32;
        return IntOffset.m7670constructorimpl((((long) this.bottom) & BodyPartID.bodyIdMax) | r101);
    }

    /* JADX INFO: renamed from: getBottomRight-nOcc-ac, reason: not valid java name */
    public final long m7699getBottomRightnOccac() {
        int r100 = this.right;
        long r101 = ((long) r100) << 32;
        return IntOffset.m7670constructorimpl((((long) this.bottom) & BodyPartID.bodyIdMax) | r101);
    }

    /* JADX INFO: renamed from: getCenter-nOcc-ac, reason: not valid java name */
    public final long m7700getCenternOccac() {
        int r100 = this.left + (getWidth() / 2);
        int r101 = this.top + (getHeight() / 2);
        long r102 = ((long) r100) << 32;
        return IntOffset.m7670constructorimpl((((long) r101) & BodyPartID.bodyIdMax) | r102);
    }

    /* JADX INFO: renamed from: getCenterLeft-nOcc-ac, reason: not valid java name */
    public final long m7701getCenterLeftnOccac() {
        int r100 = this.left;
        int r101 = this.top + (getHeight() / 2);
        long r102 = ((long) r100) << 32;
        return IntOffset.m7670constructorimpl((((long) r101) & BodyPartID.bodyIdMax) | r102);
    }

    /* JADX INFO: renamed from: getCenterRight-nOcc-ac, reason: not valid java name */
    public final long m7702getCenterRightnOccac() {
        int r100 = this.right;
        int r101 = this.top + (getHeight() / 2);
        long r102 = ((long) r100) << 32;
        return IntOffset.m7670constructorimpl((((long) r101) & BodyPartID.bodyIdMax) | r102);
    }

    public final int getHeight() {
        return this.bottom - this.top;
    }

    /* JADX INFO: renamed from: getTopCenter-nOcc-ac, reason: not valid java name */
    public final long m7704getTopCenternOccac() {
        int r100 = this.left + (getWidth() / 2);
        long r101 = ((long) r100) << 32;
        return IntOffset.m7670constructorimpl((((long) this.top) & BodyPartID.bodyIdMax) | r101);
    }

    /* JADX INFO: renamed from: getTopLeft-nOcc-ac, reason: not valid java name */
    public final long m7705getTopLeftnOccac() {
        int r100 = this.left;
        long r101 = ((long) r100) << 32;
        return IntOffset.m7670constructorimpl((((long) this.top) & BodyPartID.bodyIdMax) | r101);
    }

    /* JADX INFO: renamed from: getTopRight-nOcc-ac, reason: not valid java name */
    public final long m7706getTopRightnOccac() {
        int r100 = this.right;
        long r101 = ((long) r100) << 32;
        return IntOffset.m7670constructorimpl((((long) this.top) & BodyPartID.bodyIdMax) | r101);
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    public final boolean isEmpty() {
        if (this.left < this.right) goto L5;
    L8:
        return true;
    L5:
        if (this.top >= this.bottom) goto L8;
        return false;
    }

    public String toString() {
        return "IntRect.fromLTRB(" + this.left + ", " + this.top + ", " + this.right + ", " + this.bottom + ')';
    }

    public final int getMaxDimension() {
        return Math.max(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final int getMinDimension() {
        return Math.min(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m7703getSizeYbymL2g() {
        int r100 = getWidth();
        long r101 = ((long) r100) << 32;
        return IntSize.m7714constructorimpl((((long) getHeight()) & BodyPartID.bodyIdMax) | r101);
    }

    public static final /* synthetic */ IntRect access$getZero$cp() {
        return Zero;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: contains--gyyYBs, reason: not valid java name */
    public final boolean m7696containsgyyYBs(long r100) {
        if (IntOffset.m7676getXimpl(r100) >= this.left) goto L5;
    L11:
        return false;
    L5:
        if (IntOffset.m7676getXimpl(r100) >= this.right) goto L11;
        if (IntOffset.m7677getYimpl(r100) < this.top) goto L11;
        if (IntOffset.m7677getYimpl(r100) >= this.bottom) goto L11;
        return true;
    }

    public final IntRect deflate(int r100) {
        return inflate(-r100);
    }

    public final IntRect inflate(int r100) {
        return new IntRect(this.left - r100, this.top - r100, this.right + r100, this.bottom + r100);
    }

    public final IntRect intersect(IntRect r100) {
        return new IntRect(Math.max(this.left, r100.left), Math.max(this.top, r100.top), Math.min(this.right, r100.right), Math.min(this.bottom, r100.bottom));
    }

    public final boolean overlaps(IntRect r100) {
        if (this.right > r100.left) goto L5;
    L14:
        return false;
    L5:
        if (r100.right <= this.left) goto L14;
        if (this.bottom <= r100.top) goto L14;
        if (r100.bottom <= this.top) goto L14;
        return true;
    }

    /* JADX INFO: renamed from: translate--gyyYBs, reason: not valid java name */
    public final IntRect m7707translategyyYBs(long r100) {
        return new IntRect(this.left + IntOffset.m7676getXimpl(r100), this.top + IntOffset.m7677getYimpl(r100), this.right + IntOffset.m7676getXimpl(r100), this.bottom + IntOffset.m7677getYimpl(r100));
    }

    public final IntRect translate(int r100, int r101) {
        return new IntRect(this.left + r100, this.top + r101, this.right + r100, this.bottom + r101);
    }

    public IntRect(int r100, int r101, int r102, int r103) {
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
    }
}
