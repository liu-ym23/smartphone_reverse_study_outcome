package androidx.compose.material3;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\fB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/RippleNodeFactory;", "Landroidx/compose/foundation/IndicationNodeFactory;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "colorProducer", "Landroidx/compose/ui/graphics/ColorProducer;", "color", "Landroidx/compose/ui/graphics/Color;", "<init>", "(ZFLandroidx/compose/ui/graphics/ColorProducer;J)V", "(ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(ZFJLkotlin/jvm/internal/DefaultConstructorMarker;)V", FaceService.girlLabel, "J", "create", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "equals", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RippleNodeFactory implements IndicationNodeFactory {
    private final boolean bounded;
    private final long color;
    private final ColorProducer colorProducer;
    private final float radius;

    public /* synthetic */ RippleNodeFactory(boolean r100, float r101, long r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public /* synthetic */ RippleNodeFactory(boolean r100, float r101, ColorProducer r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    @Override // androidx.compose.foundation.Indication
    public final /* synthetic */ IndicationInstance rememberUpdatedInstance(InteractionSource r100, Composer r101, int r102) {
        return Indication.CC.$default$rememberUpdatedInstance(this, r100, r101, r102);
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public int hashCode() {
        if (this.bounded == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + Dp.m7550hashCodeimpl(this.radius)) * 31;
        ColorProducer r102 = this.colorProducer;
        if (r102 == null) goto L9;
        int r103 = r102.hashCode();
    L11:
        return ((r101 + r103) * 31) + Color.m4834hashCodeimpl(this.color);
    L9:
        r103 = 0;
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public static final /* synthetic */ long access$getColor$p(RippleNodeFactory r100) {
        return r100.color;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public DelegatableNode create(InteractionSource r100) {
        ColorProducer r101 = this.colorProducer;
        if (r101 != null) goto L5;
        r101 = new RippleNodeFactory$create$colorProducer$1(this);
    L5:
        boolean r102 = this.bounded;
        float r103 = this.radius;
        return new DelegatingThemeAwareRippleNode(r100, r102, r103, r101, null);
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RippleNodeFactory) == true) goto L8;
        return false;
    L8:
        RippleNodeFactory r101 = (RippleNodeFactory) r100;
        if (this.bounded == r101.bounded) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.radius, r101.radius) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.colorProducer, r101.colorProducer) == true) goto L18;
        return false;
    L18:
        return Color.m4828equalsimpl0(this.color, r101.color);
    }

    private RippleNodeFactory(boolean r100, float r101, ColorProducer r110) {
        this(r100, r101, r110, Color.Companion.m4863getUnspecified0d7_KjU());
    }

    private RippleNodeFactory(boolean r100, float r101, long r102) {
        this(r100, r101, null, r102);
    }

    private RippleNodeFactory(boolean r100, float r101, ColorProducer r102, long r103) {
        this.bounded = r100;
        this.radius = r101;
        this.colorProducer = r102;
        this.color = r103;
    }
}
