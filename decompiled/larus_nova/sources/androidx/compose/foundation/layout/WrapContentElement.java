package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cBA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\f\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/WrapContentNode;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "", "alignmentCallback", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "align", "", "inspectorName", "", "<init>", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;Ljava/lang/Object;Ljava/lang/String;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "hashCode", "", "Companion", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class WrapContentElement extends ModifierNodeElement<WrapContentNode> {
    public static final Companion Companion = null;
    private final Object align;
    private final Function2<IntSize, LayoutDirection, IntOffset> alignmentCallback;
    private final Direction direction;
    private final String inspectorName;
    private final boolean unbounded;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentElement$Companion;", "", "<init>", "()V", "width", "Landroidx/compose/foundation/layout/WrapContentElement;", "align", "Landroidx/compose/ui/Alignment$Horizontal;", "unbounded", "", "height", "Landroidx/compose/ui/Alignment$Vertical;", "size", "Landroidx/compose/ui/Alignment;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ IntOffset a(Alignment.Vertical r100, IntSize r101, LayoutDirection r102) {
            return height$lambda$1(r100, r101, r102);
        }

        public static /* synthetic */ IntOffset b(Alignment r100, IntSize r101, LayoutDirection r102) {
            return size$lambda$2(r100, r101, r102);
        }

        public static /* synthetic */ IntOffset c(Alignment.Horizontal r100, IntSize r101, LayoutDirection r102) {
            return width$lambda$0(r100, r101, r102);
        }

        public final WrapContentElement height(final Alignment.Vertical r100, boolean r101) {
            return new WrapContentElement(Direction.Vertical, r101, new u2(r100), r100, "wrapContentHeight");
        }

        public final WrapContentElement size(final Alignment r100, boolean r101) {
            return new WrapContentElement(Direction.Both, r101, new t2(r100), r100, "wrapContentSize");
        }

        public final WrapContentElement width(final Alignment.Horizontal r100, boolean r101) {
            return new WrapContentElement(Direction.Horizontal, r101, new s2(r100), r100, "wrapContentWidth");
        }

        private static final IntOffset height$lambda$1(Alignment.Vertical r100, IntSize r101, LayoutDirection r102) {
            int r103 = r100.align(0, (int) (r101.m7723unboximpl() & BodyPartID.bodyIdMax));
            return IntOffset.m7667boximpl(IntOffset.m7670constructorimpl((((long) 0) << 32) | (BodyPartID.bodyIdMax & ((long) r103))));
        }

        private static final IntOffset size$lambda$2(Alignment r100, IntSize r101, LayoutDirection r102) {
            return IntOffset.m7667boximpl(r100.mo4305alignKFBX0sM(IntSize.Companion.m7724getZeroYbymL2g(), r101.m7723unboximpl(), r102));
        }

        private static final IntOffset width$lambda$0(Alignment.Horizontal r100, IntSize r101, LayoutDirection r102) {
            return IntOffset.m7667boximpl(IntOffset.m7670constructorimpl((((long) r100.align(0, (int) (r101.m7723unboximpl() >> 32), r102)) << 32) | (((long) 0) & BodyPartID.bodyIdMax)));
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public WrapContentNode create() {
        return new WrapContentNode(this.direction, this.unbounded, this.alignmentCallback);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = this.direction.hashCode() * 31;
        if (this.unbounded == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.align.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ Modifier.Node create() {
        return create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (WrapContentElement.class == r100.getClass()) goto L11;
        return false;
    L11:
        WrapContentElement r101 = (WrapContentElement) r100;
        if (this.direction == r101.direction) goto L15;
        return false;
    L15:
        if (this.unbounded == r101.unbounded) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.align, r101.align) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName(this.inspectorName);
        r100.getProperties().set("align", this.align);
        r100.getProperties().set("unbounded", Boolean.valueOf(this.unbounded));
    }

    public void update(WrapContentNode r100) {
        r100.setDirection(this.direction);
        r100.setUnbounded(this.unbounded);
        r100.setAlignmentCallback(this.alignmentCallback);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((WrapContentNode) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WrapContentElement(Direction r100, boolean r101, Function2<? super IntSize, ? super LayoutDirection, IntOffset> r102, Object r103, String r104) {
        this.direction = r100;
        this.unbounded = r101;
        this.alignmentCallback = r102;
        this.align = r103;
        this.inspectorName = r104;
    }
}
