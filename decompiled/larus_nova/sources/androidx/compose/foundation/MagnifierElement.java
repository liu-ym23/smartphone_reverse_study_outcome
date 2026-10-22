package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0099\u0001\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007\u0012\u001b\b\u0002\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0007\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0013\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016J\f\u0010#\u001a\u00020\u000b*\u00020$H\u0016R\u001f\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\b\u001a\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/foundation/MagnifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/MagnifierNode;", "sourceCenter", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "magnifierCenter", "onSizeChanged", "Landroidx/compose/ui/unit/DpSize;", "", GestureAction.zoom, "", "useTextDefault", "", "size", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "elevation", "clippingEnabled", "platformMagnifierFactory", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", FaceService.girlLabel, "create", "update", "node", "equals", "other", "", "hashCode", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MagnifierElement extends ModifierNodeElement<MagnifierNode> {
    public static final int $stable = 0;
    private final boolean clippingEnabled;
    private final float cornerRadius;
    private final float elevation;
    private final Function1<Density, Offset> magnifierCenter;
    private final Function1<DpSize, Unit> onSizeChanged;
    private final PlatformMagnifierFactory platformMagnifierFactory;
    private final long size;
    private final Function1<Density, Offset> sourceCenter;
    private final boolean useTextDefault;
    private final float zoom;

    public /* synthetic */ MagnifierElement(Function1 r100, Function1 r101, Function1 r102, float r103, boolean r104, long r105, float r106, float r107, boolean r110, PlatformMagnifierFactory r111, DefaultConstructorMarker r112) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public MagnifierNode create() {
        Function1<Density, Offset> r100 = this.sourceCenter;
        Function1<Density, Offset> r101 = this.magnifierCenter;
        float r102 = this.zoom;
        boolean r103 = this.useTextDefault;
        long r104 = this.size;
        float r105 = this.cornerRadius;
        float r106 = this.elevation;
        boolean r110 = this.clippingEnabled;
        return new MagnifierNode(r100, r101, this.onSizeChanged, r102, r103, r104, r105, r106, r110, this.platformMagnifierFactory, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int r100 = this.sourceCenter.hashCode() * 31;
        Function1<Density, Offset> r101 = this.magnifierCenter;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + Float.floatToIntBits(this.zoom)) * 31;
        int r105 = 1231;
        if (this.useTextDefault == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (((((((r104 + r106) * 31) + DpSize.m7644hashCodeimpl(this.size)) * 31) + Dp.m7550hashCodeimpl(this.cornerRadius)) * 31) + Dp.m7550hashCodeimpl(this.elevation)) * 31;
        if (this.clippingEnabled == true) goto L14;
        r105 = 1237;
    L14:
        int r108 = (r107 + r105) * 31;
        Function1<DpSize, Unit> r109 = this.onSizeChanged;
        if (r109 == null) goto L18;
        r102 = r109.hashCode();
    L18:
        return ((r108 + r102) * 31) + this.platformMagnifierFactory.hashCode();
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = 0;
        goto L6
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
        if ((r100 instanceof MagnifierElement) == true) goto L8;
        return false;
    L8:
        MagnifierElement r101 = (MagnifierElement) r100;
        if (this.sourceCenter == r101.sourceCenter) goto L12;
        return false;
    L12:
        if (this.magnifierCenter == r101.magnifierCenter) goto L15;
        return false;
    L15:
        if (this.zoom != r101.zoom) goto L17;
        boolean r102 = true;
    L18:
        if (r102 == true) goto L21;
        return false;
    L21:
        if (this.useTextDefault == r101.useTextDefault) goto L24;
        return false;
    L24:
        if (DpSize.m7639equalsimpl0(this.size, r101.size) == true) goto L27;
        return false;
    L27:
        if (Dp.m7549equalsimpl0(this.cornerRadius, r101.cornerRadius) == true) goto L30;
        return false;
    L30:
        if (Dp.m7549equalsimpl0(this.elevation, r101.elevation) == true) goto L33;
        return false;
    L33:
        if (this.clippingEnabled == r101.clippingEnabled) goto L36;
        return false;
    L36:
        if (this.onSizeChanged == r101.onSizeChanged) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.platformMagnifierFactory, r101.platformMagnifierFactory) == true) goto L41;
        return false;
    L41:
        return true;
    L17:
        r102 = false;
        goto L18
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName("magnifier");
        r100.getProperties().set("sourceCenter", this.sourceCenter);
        r100.getProperties().set("magnifierCenter", this.magnifierCenter);
        r100.getProperties().set(GestureAction.zoom, Float.valueOf(this.zoom));
        r100.getProperties().set("size", DpSize.m7630boximpl(this.size));
        r100.getProperties().set("cornerRadius", Dp.m7542boximpl(this.cornerRadius));
        r100.getProperties().set("elevation", Dp.m7542boximpl(this.elevation));
        r100.getProperties().set("clippingEnabled", Boolean.valueOf(this.clippingEnabled));
    }

    public void update(MagnifierNode r110) {
        r110.m297update5F03MCQ(this.sourceCenter, this.magnifierCenter, this.zoom, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, this.onSizeChanged, this.platformMagnifierFactory);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((MagnifierNode) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MagnifierElement(Function1<? super Density, Offset> r100, Function1<? super Density, Offset> r101, Function1<? super DpSize, Unit> r102, float r103, boolean r104, long r105, float r106, float r107, boolean r110, PlatformMagnifierFactory r111) {
        this.sourceCenter = r100;
        this.magnifierCenter = r101;
        this.onSizeChanged = r102;
        this.zoom = r103;
        this.useTextDefault = r104;
        this.size = r105;
        this.cornerRadius = r106;
        this.elevation = r107;
        this.clippingEnabled = r110;
        this.platformMagnifierFactory = r111;
    }

    public /* synthetic */ MagnifierElement(Function1 r110, Function1 r111, Function1 r112, float r210, boolean r211, long r212, float r213, float r214, boolean r215, PlatformMagnifierFactory r216, int r217, DefaultConstructorMarker r218) {
        if ((r217 & 2) == 0) goto L5;
        Function1 r100 = null;
    L7:
        if ((r217 & 4) == 0) goto L9;
        Function1 r101 = null;
    L11:
        if ((r217 & 8) == 0) goto L13;
        float r102 = Float.NaN;
    L15:
        if ((r217 & 16) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r217 & 32) == 0) goto L21;
        long r104 = DpSize.Companion.m7651getUnspecifiedMYxV2XQ();
    L23:
        if ((r217 & 64) == 0) goto L25;
        float r113 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L27:
        if ((r217 & 128) == 0) goto L29;
        float r114 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L31:
        if ((r217 & 256) == 0) goto L33;
        boolean r115 = true;
    L34:
        this(r110, r100, r101, r102, r103, r104, r113, r114, r115, r216, null);
        return;
    L33:
        r115 = r215;
        goto L34
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
