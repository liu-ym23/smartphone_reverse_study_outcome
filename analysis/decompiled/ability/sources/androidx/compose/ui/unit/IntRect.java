package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.dsl.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0001QB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010&J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0007J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0007J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0003H\u0007J\u0010\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0000H\u0007J\u000e\u0010.\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u0000J\u0015\u0010E\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$¢\u0006\u0004\bF\u0010GJ\b\u0010H\u001a\u00020IH\u0016J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J1\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010O\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010!R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\fR\u0011\u00101\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b2\u0010\fR\u0011\u00103\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b4\u0010\u001dR\u0011\u00105\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b6\u0010\u001dR\u0011\u00107\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b8\u0010\u001dR\u0011\u00109\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b:\u0010\u001dR\u0011\u0010;\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b<\u0010\u001dR\u0011\u0010=\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b>\u0010\u001dR\u0011\u0010?\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b@\u0010\u001dR\u0011\u0010A\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bB\u0010\u001dR\u0011\u0010C\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bD\u0010\u001d¨\u0006R"}, d2 = {"Landroidx/compose/ui/unit/IntRect;", "", "left", "", "top", "right", "bottom", AppAgent.CONSTRUCT, "(IIII)V", "getLeft$annotations", "()V", "getLeft", "()I", "getTop$annotations", "getTop", "getRight$annotations", "getRight", "getBottom$annotations", "getBottom", "width", "getWidth$annotations", "getWidth", "height", "getHeight$annotations", "getHeight", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g$annotations", "getSize-YbymL2g", "()J", "isEmpty", "", "isEmpty$annotations", "()Z", "translate", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/unit/IntOffset;", "translate--gyyYBs", "(J)Landroidx/compose/ui/unit/IntRect;", "translateX", "translateY", "inflate", "delta", "deflate", "intersect", "other", "overlaps", "minDimension", "getMinDimension", "maxDimension", "getMaxDimension", "topLeft", "getTopLeft-nOcc-ac", "topCenter", "getTopCenter-nOcc-ac", "topRight", "getTopRight-nOcc-ac", "centerLeft", "getCenterLeft-nOcc-ac", "center", "getCenter-nOcc-ac", "centerRight", "getCenterRight-nOcc-ac", "bottomLeft", "getBottomLeft-nOcc-ac", "bottomCenter", "getBottomCenter-nOcc-ac", "bottomRight", "getBottomRight-nOcc-ac", "contains", "contains--gyyYBs", "(J)Z", "toString", "", "component1", "component2", "component3", "component4", "copy", "equals", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class IntRect {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final IntRect Zero = new IntRect(0, 0, 0, 0);
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/unit/IntRect$Companion;", "", AppAgent.CONSTRUCT, "()V", "Zero", "Landroidx/compose/ui/unit/IntRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/unit/IntRect;", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        @Stable
        public static /* synthetic */ void getZero$annotations() {
        }

        public final IntRect getZero() {
            return IntRect.Zero;
        }

        private Companion() {
        }
    }

    public IntRect(int i, int i6, int i10, int i11) {
        this.left = i;
        this.top = i6;
        this.right = i10;
        this.bottom = i11;
    }

    public static /* synthetic */ IntRect copy$default(IntRect intRect, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = intRect.left;
        }
        if ((i12 & 2) != 0) {
            i6 = intRect.top;
        }
        if ((i12 & 4) != 0) {
            i10 = intRect.right;
        }
        if ((i12 & 8) != 0) {
            i11 = intRect.bottom;
        }
        return intRect.copy(i, i6, i10, i11);
    }

    @Stable
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Stable
    public static /* synthetic */ void getLeft$annotations() {
    }

    @Stable
    public static /* synthetic */ void getRight$annotations() {
    }

    @Stable
    /* renamed from: getSize-YbymL2g$annotations, reason: not valid java name */
    public static /* synthetic */ void m6991getSizeYbymL2g$annotations() {
    }

    @Stable
    public static /* synthetic */ void getTop$annotations() {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations() {
    }

    @Stable
    public static /* synthetic */ void isEmpty$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final int getLeft() {
        return this.left;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRight() {
        return this.right;
    }

    /* renamed from: component4, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    /* renamed from: contains--gyyYBs, reason: not valid java name */
    public final boolean m6992containsgyyYBs(long offset) {
        return IntOffset.m6972getXimpl(offset) >= this.left && IntOffset.m6972getXimpl(offset) < this.right && IntOffset.m6973getYimpl(offset) >= this.top && IntOffset.m6973getYimpl(offset) < this.bottom;
    }

    public final IntRect copy(int left, int top, int right, int bottom) {
        return new IntRect(left, top, right, bottom);
    }

    @Stable
    public final IntRect deflate(int delta) {
        return inflate(-delta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntRect)) {
            return false;
        }
        IntRect intRect = (IntRect) other;
        return this.left == intRect.left && this.top == intRect.top && this.right == intRect.right && this.bottom == intRect.bottom;
    }

    public final int getBottom() {
        return this.bottom;
    }

    /* renamed from: getBottomCenter-nOcc-ac, reason: not valid java name */
    public final long m6993getBottomCenternOccac() {
        return IntOffset.m6966constructorimpl((((getWidth() / 2) + this.left) << 32) | (this.bottom & 4294967295L));
    }

    /* renamed from: getBottomLeft-nOcc-ac, reason: not valid java name */
    public final long m6994getBottomLeftnOccac() {
        return IntOffset.m6966constructorimpl((this.left << 32) | (this.bottom & 4294967295L));
    }

    /* renamed from: getBottomRight-nOcc-ac, reason: not valid java name */
    public final long m6995getBottomRightnOccac() {
        return IntOffset.m6966constructorimpl((this.right << 32) | (this.bottom & 4294967295L));
    }

    /* renamed from: getCenter-nOcc-ac, reason: not valid java name */
    public final long m6996getCenternOccac() {
        return IntOffset.m6966constructorimpl((((getWidth() / 2) + this.left) << 32) | (((getHeight() / 2) + this.top) & 4294967295L));
    }

    /* renamed from: getCenterLeft-nOcc-ac, reason: not valid java name */
    public final long m6997getCenterLeftnOccac() {
        return IntOffset.m6966constructorimpl((this.left << 32) | (((getHeight() / 2) + this.top) & 4294967295L));
    }

    /* renamed from: getCenterRight-nOcc-ac, reason: not valid java name */
    public final long m6998getCenterRightnOccac() {
        return IntOffset.m6966constructorimpl((this.right << 32) | (((getHeight() / 2) + this.top) & 4294967295L));
    }

    public final int getHeight() {
        return this.bottom - this.top;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getMaxDimension() {
        return Math.max(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final int getMinDimension() {
        return Math.min(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final int getRight() {
        return this.right;
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m6999getSizeYbymL2g() {
        return IntSize.m7010constructorimpl((getWidth() << 32) | (getHeight() & 4294967295L));
    }

    public final int getTop() {
        return this.top;
    }

    /* renamed from: getTopCenter-nOcc-ac, reason: not valid java name */
    public final long m7000getTopCenternOccac() {
        return IntOffset.m6966constructorimpl((((getWidth() / 2) + this.left) << 32) | (this.top & 4294967295L));
    }

    /* renamed from: getTopLeft-nOcc-ac, reason: not valid java name */
    public final long m7001getTopLeftnOccac() {
        return IntOffset.m6966constructorimpl((this.left << 32) | (this.top & 4294967295L));
    }

    /* renamed from: getTopRight-nOcc-ac, reason: not valid java name */
    public final long m7002getTopRightnOccac() {
        return IntOffset.m6966constructorimpl((this.right << 32) | (this.top & 4294967295L));
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return Integer.hashCode(this.bottom) + a.a(this.right, a.a(this.top, Integer.hashCode(this.left) * 31, 31), 31);
    }

    @Stable
    public final IntRect inflate(int delta) {
        return new IntRect(this.left - delta, this.top - delta, this.right + delta, this.bottom + delta);
    }

    @Stable
    public final IntRect intersect(IntRect other) {
        return new IntRect(Math.max(this.left, other.left), Math.max(this.top, other.top), Math.min(this.right, other.right), Math.min(this.bottom, other.bottom));
    }

    public final boolean isEmpty() {
        return this.left >= this.right || this.top >= this.bottom;
    }

    public final boolean overlaps(IntRect other) {
        return this.right > other.left && other.right > this.left && this.bottom > other.top && other.bottom > this.top;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IntRect.fromLTRB(");
        sb.append(this.left);
        sb.append(", ");
        sb.append(this.top);
        sb.append(", ");
        sb.append(this.right);
        sb.append(", ");
        return B7.a.o(sb, this.bottom, ')');
    }

    @Stable
    public final IntRect translate(int translateX, int translateY) {
        return new IntRect(this.left + translateX, this.top + translateY, this.right + translateX, this.bottom + translateY);
    }

    @Stable
    /* renamed from: translate--gyyYBs, reason: not valid java name */
    public final IntRect m7003translategyyYBs(long offset) {
        return new IntRect(IntOffset.m6972getXimpl(offset) + this.left, IntOffset.m6973getYimpl(offset) + this.top, IntOffset.m6972getXimpl(offset) + this.right, IntOffset.m6973getYimpl(offset) + this.bottom);
    }
}
