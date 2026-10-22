package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.unit.Dp;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\u00020\u0001*\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0080@¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"animateElevation", "", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/unit/Dp;", PickerReporterConstants.KEY.TARGET, "from", "Landroidx/compose/foundation/interaction/Interaction;", RemoteMessageConst.TO, "animateElevation-rAjV9yQ", "(Landroidx/compose/animation/core/Animatable;FLandroidx/compose/foundation/interaction/Interaction;Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DefaultIncomingSpec", "Landroidx/compose/animation/core/TweenSpec;", "DefaultOutgoingSpec", "HoveredOutgoingSpec", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ElevationKt {
    private static final TweenSpec<Dp> DefaultIncomingSpec = null;
    private static final TweenSpec<Dp> DefaultOutgoingSpec = null;
    private static final TweenSpec<Dp> HoveredOutgoingSpec = null;

    static {
        DefaultIncomingSpec = new TweenSpec(120, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
        DefaultOutgoingSpec = new TweenSpec(150, 0, new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f), 2, null);
        HoveredOutgoingSpec = new TweenSpec(120, 0, new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f), 2, null);
    }

    public static final /* synthetic */ TweenSpec access$getDefaultIncomingSpec$p() {
        return DefaultIncomingSpec;
    }

    public static final /* synthetic */ TweenSpec access$getDefaultOutgoingSpec$p() {
        return DefaultOutgoingSpec;
    }

    public static final /* synthetic */ TweenSpec access$getHoveredOutgoingSpec$p() {
        return HoveredOutgoingSpec;
    }

    /* JADX INFO: renamed from: animateElevation-rAjV9yQ, reason: not valid java name */
    public static final Object m1641animateElevationrAjV9yQ(Animatable<Dp, ?> r100, float r101, Interaction r110, Interaction r111, Continuation<? super Unit> r112) {
        if (r111 == null) goto L5;
        AnimationSpec<Dp> r113 = ElevationDefaults.INSTANCE.incomingAnimationSpecForInteraction(r111);
    L4:
        AnimationSpec<Dp> r102 = r113;
        if (r102 == null) goto L14;
        Object r103 = Animatable.animateTo$default(r100, Dp.m7542boximpl(r101), r102, null, null, r112, 12, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r103;
    L13:
        return Unit.INSTANCE;
    L14:
        Object r104 = r100.snapTo(Dp.m7542boximpl(r101), r112);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r104;
    L18:
        return Unit.INSTANCE;
    L5:
        if (r110 == null) goto L7;
        r113 = ElevationDefaults.INSTANCE.outgoingAnimationSpecForInteraction(r110);
        goto L4
    L7:
        r113 = null;
        goto L4
    }

    /* JADX INFO: renamed from: animateElevation-rAjV9yQ$default, reason: not valid java name */
    public static /* synthetic */ Object m1642animateElevationrAjV9yQ$default(Animatable r100, float r101, Interaction r102, Interaction r103, Continuation r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        return m1641animateElevationrAjV9yQ(r100, r101, r102, r103, r104);
    }
}
