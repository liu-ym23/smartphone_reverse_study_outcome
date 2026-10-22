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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B8\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\f\u0010!\u001a\u00020\u000b*\u00020\nH\u0016R\u0013\u0010\u0003\u001a\u00020\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u00020\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Landroidx/compose/foundation/layout/OffsetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/OffsetNode;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(FFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getX-D9Ej5fM", "()F", FaceService.girlLabel, "getY-D9Ej5fM", "getRtlAware", "()Z", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "equals", "other", "", "hashCode", "", "toString", "", "inspectableProperties", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OffsetElement extends ModifierNodeElement<OffsetNode> {
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final boolean rtlAware;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final float f5975x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final float f5976y;

    public /* synthetic */ OffsetElement(float r100, float r101, boolean r102, Function1 r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public OffsetNode create() {
        return new OffsetNode(this.f5975x, this.f5976y, this.rtlAware, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = ((Dp.m7550hashCodeimpl(this.f5975x) * 31) + Dp.m7550hashCodeimpl(this.f5976y)) * 31;
        if (this.rtlAware == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "OffsetModifierElement(x=" + Dp.m7555toStringimpl(this.f5975x) + ", y=" + Dp.m7555toStringimpl(this.f5976y) + ", rtlAware=" + this.rtlAware + ')';
    }

    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public final float m686getXD9Ej5fM() {
        return this.f5975x;
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public final float m687getYD9Ej5fM() {
        return this.f5976y;
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
        if ((r100 instanceof OffsetElement) == false) goto L8;
        OffsetElement r101 = (OffsetElement) r100;
    L10:
        if (r101 != null) goto L13;
        return false;
    L13:
        if (Dp.m7549equalsimpl0(this.f5975x, r101.f5975x) == true) goto L15;
    L19:
        return false;
    L15:
        if (Dp.m7549equalsimpl0(this.f5976y, r101.f5976y) == false) goto L19;
        if (this.rtlAware != r101.rtlAware) goto L19;
        return true;
    L8:
        r101 = null;
        goto L10
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        this.inspectorInfo.invoke(r100);
    }

    public void update(OffsetNode r100) {
        r100.m696updateMdfbLM(this.f5975x, this.f5976y, this.rtlAware);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((OffsetNode) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private OffsetElement(float r100, float r101, boolean r102, Function1<? super InspectorInfo, Unit> r103) {
        this.f5975x = r100;
        this.f5976y = r101;
        this.rtlAware = r102;
        this.inspectorInfo = r103;
    }
}
