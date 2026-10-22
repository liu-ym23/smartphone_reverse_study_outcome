package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BP\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\f\u0010\u0015\u001a\u00020\r*\u00020\fH\u0016J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/SizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/SizeNode;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", FaceService.girlLabel, "create", "update", "node", "inspectableProperties", "equals", "other", "", "hashCode", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SizeElement extends ModifierNodeElement<SizeNode> {
    private final boolean enforceIncoming;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ SizeElement(float r100, float r101, float r102, float r103, boolean r104, Function1 r105, DefaultConstructorMarker r106) {
        this(r100, r101, r102, r103, r104, r105);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public SizeNode create() {
        return new SizeNode(this.minWidth, this.minHeight, this.maxWidth, this.maxHeight, this.enforceIncoming, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = ((((((Dp.m7550hashCodeimpl(this.minWidth) * 31) + Dp.m7550hashCodeimpl(this.minHeight)) * 31) + Dp.m7550hashCodeimpl(this.maxWidth)) * 31) + Dp.m7550hashCodeimpl(this.maxHeight)) * 31;
        if (this.enforceIncoming == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
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
        if ((r100 instanceof SizeElement) == true) goto L8;
        return false;
    L8:
        SizeElement r101 = (SizeElement) r100;
        if (Dp.m7549equalsimpl0(this.minWidth, r101.minWidth) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.minHeight, r101.minHeight) == true) goto L15;
        return false;
    L15:
        if (Dp.m7549equalsimpl0(this.maxWidth, r101.maxWidth) == true) goto L18;
        return false;
    L18:
        if (Dp.m7549equalsimpl0(this.maxHeight, r101.maxHeight) == true) goto L21;
        return false;
    L21:
        if (this.enforceIncoming == r101.enforceIncoming) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        this.inspectorInfo.invoke(r100);
    }

    public void update(SizeNode r100) {
        r100.m794setMinWidth0680j_4(this.minWidth);
        r100.m793setMinHeight0680j_4(this.minHeight);
        r100.m792setMaxWidth0680j_4(this.maxWidth);
        r100.m791setMaxHeight0680j_4(this.maxHeight);
        r100.setEnforceIncoming(this.enforceIncoming);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((SizeNode) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SizeElement(float r100, float r101, float r102, float r103, boolean r104, Function1<? super InspectorInfo, Unit> r105) {
        this.minWidth = r100;
        this.minHeight = r101;
        this.maxWidth = r102;
        this.maxHeight = r103;
        this.enforceIncoming = r104;
        this.inspectorInfo = r105;
    }

    public /* synthetic */ SizeElement(float r110, float r111, float r112, float r113, boolean r114, Function1 r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        float r100 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L7:
        if ((r116 & 2) == 0) goto L9;
        float r101 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L11:
        if ((r116 & 4) == 0) goto L13;
        float r102 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L15:
        if ((r116 & 8) == 0) goto L17;
        float r103 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L18:
        this(r100, r101, r102, r103, r114, r115, null);
        return;
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
