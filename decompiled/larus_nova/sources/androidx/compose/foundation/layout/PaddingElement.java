package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BP\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\"\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)H\u0096\u0002J\f\u0010*\u001a\u00020\r*\u00020\fH\u0016R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006+"}, d2 = {"Landroidx/compose/foundation/layout/PaddingElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/PaddingNode;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM", "()F", "setStart-0680j_4", "(F)V", FaceService.girlLabel, "getTop-D9Ej5fM", "setTop-0680j_4", "getEnd-D9Ej5fM", "setEnd-0680j_4", "getBottom-D9Ej5fM", "setBottom-0680j_4", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "hashCode", "", "equals", "other", "", "inspectableProperties", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PaddingElement extends ModifierNodeElement<PaddingNode> {
    private float bottom;
    private float end;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private boolean rtlAware;
    private float start;
    private float top;

    public /* synthetic */ PaddingElement(float r100, float r101, float r102, float r103, boolean r104, Function1 r105, DefaultConstructorMarker r106) {
        this(r100, r101, r102, r103, r104, r105);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public PaddingNode create() {
        return new PaddingNode(this.start, this.top, this.end, this.bottom, this.rtlAware, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = ((((((Dp.m7550hashCodeimpl(this.start) * 31) + Dp.m7550hashCodeimpl(this.top)) * 31) + Dp.m7550hashCodeimpl(this.end)) * 31) + Dp.m7550hashCodeimpl(this.bottom)) * 31;
        if (this.rtlAware == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m716getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m717getEndD9Ej5fM() {
        return this.end;
    }

    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m718getStartD9Ej5fM() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m719getTopD9Ej5fM() {
        return this.top;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ Modifier.Node create() {
        return create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object r100) {
        if ((r100 instanceof PaddingElement) == false) goto L5;
        PaddingElement r101 = (PaddingElement) r100;
    L7:
        if (r101 != null) goto L10;
        return false;
    L10:
        if (Dp.m7549equalsimpl0(this.start, r101.start) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.top, r101.top) == true) goto L14;
        return false;
    L14:
        if (Dp.m7549equalsimpl0(this.end, r101.end) == true) goto L16;
        return false;
    L16:
        if (Dp.m7549equalsimpl0(this.bottom, r101.bottom) == true) goto L18;
        return false;
    L18:
        if (this.rtlAware != r101.rtlAware) goto L25;
        return true;
    L25:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        this.inspectorInfo.invoke(r100);
    }

    /* JADX INFO: renamed from: setBottom-0680j_4, reason: not valid java name */
    public final void m720setBottom0680j_4(float r100) {
        this.bottom = r100;
    }

    /* JADX INFO: renamed from: setEnd-0680j_4, reason: not valid java name */
    public final void m721setEnd0680j_4(float r100) {
        this.end = r100;
    }

    public final void setRtlAware(boolean r100) {
        this.rtlAware = r100;
    }

    /* JADX INFO: renamed from: setStart-0680j_4, reason: not valid java name */
    public final void m722setStart0680j_4(float r100) {
        this.start = r100;
    }

    /* JADX INFO: renamed from: setTop-0680j_4, reason: not valid java name */
    public final void m723setTop0680j_4(float r100) {
        this.top = r100;
    }

    public void update(PaddingNode r100) {
        r100.m742setStart0680j_4(this.start);
        r100.m743setTop0680j_4(this.top);
        r100.m741setEnd0680j_4(this.end);
        r100.m740setBottom0680j_4(this.bottom);
        r100.setRtlAware(this.rtlAware);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((PaddingNode) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PaddingElement(float r100, float r101, float r102, float r103, boolean r104, Function1<? super InspectorInfo, Unit> r105) {
        this.start = r100;
        this.top = r101;
        this.end = r102;
        this.bottom = r103;
        this.rtlAware = r104;
        this.inspectorInfo = r105;
        boolean r106 = false;
        if (r100 < 0.0f) goto L5;
    L8:
        boolean r107 = true;
    L9:
        float r108 = this.top;
        if (r108 < 0.0f) goto L12;
    L15:
        boolean r109 = true;
    L16:
        boolean r110 = r107 & r109;
        float r111 = this.end;
        if (r111 < 0.0f) goto L19;
    L22:
        boolean r112 = true;
    L23:
        boolean r113 = r110 & r112;
        float r114 = this.bottom;
        if (r114 < 0.0f) goto L26;
    L27:
        r106 = true;
    L29:
        if ((r113 & r106) == true) goto L32;
        InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        return;
    L32:
        return;
    L26:
        if (Float.isNaN(r114) == false) goto L29;
    L19:
        if (Float.isNaN(r111) == true) goto L22;
        r112 = false;
        goto L23
    L12:
        if (Float.isNaN(r108) == true) goto L15;
        r109 = false;
        goto L16
    L5:
        if (Float.isNaN(r100) == true) goto L8;
        r107 = false;
        goto L9
    }

    public /* synthetic */ PaddingElement(float r110, float r111, float r112, float r113, boolean r114, Function1 r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        float r100 = Dp.m7544constructorimpl(0);
    L7:
        if ((r116 & 2) == 0) goto L9;
        float r101 = Dp.m7544constructorimpl(0);
    L11:
        if ((r116 & 4) == 0) goto L13;
        float r102 = Dp.m7544constructorimpl(0);
    L15:
        if ((r116 & 8) == 0) goto L17;
        float r103 = Dp.m7544constructorimpl(0);
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
