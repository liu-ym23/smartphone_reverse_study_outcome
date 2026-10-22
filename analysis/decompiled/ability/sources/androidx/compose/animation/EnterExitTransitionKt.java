package androidx.compose.animation;

import C7.r;
import S7.k;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0080\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0003\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0080\u0004¢\u0006\u0004\b\u0003\u0010\u0006\u001a)\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\u000e\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a3\u0010\u0017\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u0011H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a6\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a6\u0010\"\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001aI\u0010(\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020%2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0007¢\u0006\u0004\b(\u0010)\u001aI\u0010,\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\b\b\u0002\u0010*\u001a\u00020#2\b\b\u0002\u0010&\u001a\u00020%2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0007¢\u0006\u0004\b,\u0010-\u001aI\u00101\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\b\b\u0002\u0010$\u001a\u00020.2\b\b\u0002\u0010&\u001a\u00020%2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0\u0011H\u0007¢\u0006\u0004\b1\u00102\u001aI\u00105\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\b\b\u0002\u0010$\u001a\u0002032\b\b\u0002\u0010&\u001a\u00020%2\u0014\b\u0002\u00104\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0\u0011H\u0007¢\u0006\u0004\b5\u00106\u001aI\u00108\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\b\b\u0002\u0010*\u001a\u00020.2\b\b\u0002\u0010&\u001a\u00020%2\u0014\b\u0002\u00107\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0\u0011H\u0007¢\u0006\u0004\b8\u00109\u001aI\u0010;\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\b\b\u0002\u0010*\u001a\u0002032\b\b\u0002\u0010&\u001a\u00020%2\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0\u0011H\u0007¢\u0006\u0004\b;\u0010<\u001a5\u0010>\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0\u0011H\u0007¢\u0006\u0004\b>\u0010\u0015\u001a5\u0010@\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0014\b\u0002\u0010?\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0\u0011H\u0007¢\u0006\u0004\b@\u0010\u0015\u001a5\u0010B\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0014\b\u0002\u0010A\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0\u0011H\u0007¢\u0006\u0004\bB\u0010\u0018\u001a5\u0010D\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0014\b\u0002\u0010C\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/0\u0011H\u0007¢\u0006\u0004\bD\u0010\u0018\u001a\u0013\u0010E\u001a\u00020#*\u00020.H\u0002¢\u0006\u0004\bE\u0010F\u001a\u0013\u0010E\u001a\u00020#*\u000203H\u0002¢\u0006\u0004\bE\u0010G\u001a.\u0010K\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010H*\u00020\u0001*\u00020\u00002\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000IH\u0080\u0002¢\u0006\u0004\bK\u0010L\u001a.\u0010K\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010H*\u00020\u0001*\u00020\u00052\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000IH\u0080\u0002¢\u0006\u0004\bK\u0010M\u001aA\u0010W\u001a\u00020V*\b\u0012\u0004\u0012\u00020O0N2\u0006\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u00052\u000e\b\u0002\u0010S\u001a\b\u0012\u0004\u0012\u00020%0R2\u0006\u0010U\u001a\u00020TH\u0001¢\u0006\u0004\bW\u0010X\u001a!\u0010Y\u001a\u00020\u0000*\b\u0012\u0004\u0012\u00020O0N2\u0006\u0010P\u001a\u00020\u0000H\u0001¢\u0006\u0004\bY\u0010Z\u001a!\u0010[\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020O0N2\u0006\u0010Q\u001a\u00020\u0005H\u0001¢\u0006\u0004\b[\u0010\\\u001a1\u0010^\u001a\u00020]*\b\u0012\u0004\u0012\u00020O0N2\u0006\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010U\u001a\u00020TH\u0003¢\u0006\u0004\b^\u0010_\" \u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020a0`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010c\"\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\b0d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010f\"\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00100d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010f\"\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00120d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006k²\u0006\u000e\u0010i\u001a\u00020\u00008\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010j\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/animation/EnterTransition;", "Landroidx/compose/animation/TransitionEffect;", "effect", "withEffect", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/TransitionEffect;)Landroidx/compose/animation/EnterTransition;", "Landroidx/compose/animation/ExitTransition;", "(Landroidx/compose/animation/ExitTransition;Landroidx/compose/animation/TransitionEffect;)Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "animationSpec", "initialAlpha", "fadeIn", "(Landroidx/compose/animation/core/FiniteAnimationSpec;F)Landroidx/compose/animation/EnterTransition;", "targetAlpha", "fadeOut", "(Landroidx/compose/animation/core/FiniteAnimationSpec;F)Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "initialOffset", "slideIn", "(Landroidx/compose/animation/core/FiniteAnimationSpec;LS7/k;)Landroidx/compose/animation/EnterTransition;", "targetOffset", "slideOut", "(Landroidx/compose/animation/core/FiniteAnimationSpec;LS7/k;)Landroidx/compose/animation/ExitTransition;", "initialScale", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleIn", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "scaleOut", "Landroidx/compose/ui/Alignment;", "expandFrom", "", "clip", "initialSize", "expandIn", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment;ZLS7/k;)Landroidx/compose/animation/EnterTransition;", "shrinkTowards", "targetSize", "shrinkOut", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment;ZLS7/k;)Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/ui/Alignment$Horizontal;", "", "initialWidth", "expandHorizontally", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment$Horizontal;ZLS7/k;)Landroidx/compose/animation/EnterTransition;", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "expandVertically", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment$Vertical;ZLS7/k;)Landroidx/compose/animation/EnterTransition;", "targetWidth", "shrinkHorizontally", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment$Horizontal;ZLS7/k;)Landroidx/compose/animation/ExitTransition;", "targetHeight", "shrinkVertically", "(Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/ui/Alignment$Vertical;ZLS7/k;)Landroidx/compose/animation/ExitTransition;", "initialOffsetX", "slideInHorizontally", "initialOffsetY", "slideInVertically", "targetOffsetX", "slideOutHorizontally", "targetOffsetY", "slideOutVertically", "toAlignment", "(Landroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/ui/Alignment;", "(Landroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/ui/Alignment;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/TransitionEffectKey;", "key", "get", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "(Landroidx/compose/animation/ExitTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "Lkotlin/Function0;", "isEnabled", "", "label", "Landroidx/compose/ui/Modifier;", "createModifier", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;LS7/a;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "trackActiveEnter", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "trackActiveExit", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "createGraphicsLayerBlock", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/animation/core/AnimationVector2D;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/animation/core/SpringSpec;", "DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "DefaultOffsetAnimationSpec", "DefaultSizeAnimationSpec", "activeEnter", "activeExit", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EnterExitTransitionKt {
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(new k() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m75invoke__ExYCQ(((TransformOrigin) obj).getPackedValue());
        }

        /* renamed from: invoke-__ExYCQ, reason: not valid java name */
        public final AnimationVector2D m75invoke__ExYCQ(long j5) {
            return new AnimationVector2D(TransformOrigin.m4541getPivotFractionXimpl(j5), TransformOrigin.m4542getPivotFractionYimpl(j5));
        }
    }, new k() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return TransformOrigin.m4533boximpl(m76invokeLIALnN8((AnimationVector2D) obj));
        }

        /* renamed from: invoke-LIALnN8, reason: not valid java name */
        public final long m76invokeLIALnN8(AnimationVector2D animationVector2D) {
            return TransformOriginKt.TransformOrigin(animationVector2D.getV1(), animationVector2D.getV2());
        }
    });
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6963boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7007boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);

    /* JADX WARN: Removed duplicated region for block: B:43:0x011c A[PHI: r1
      0x011c: PHI (r1v11 androidx.compose.animation.EnterTransition) = (r1v9 androidx.compose.animation.EnterTransition), (r1v12 androidx.compose.animation.EnterTransition) binds: [B:42:0x011a, B:38:0x0113] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0137 A[PHI: r2
      0x0137: PHI (r2v10 androidx.compose.animation.ExitTransition) = (r2v8 androidx.compose.animation.ExitTransition), (r2v11 androidx.compose.animation.ExitTransition) binds: [B:52:0x0135, B:48:0x012e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0185  */
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final androidx.compose.animation.GraphicsLayerBlockForEnterExit createGraphicsLayerBlock(androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r20, androidx.compose.animation.EnterTransition r21, androidx.compose.animation.ExitTransition r22, java.lang.String r23, androidx.compose.runtime.Composer r24, int r25) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createGraphicsLayerBlock(androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.animation.GraphicsLayerBlockForEnterExit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final S7.k createGraphicsLayerBlock$lambda$13$lambda$12(androidx.compose.animation.core.Transition.DeferredAnimation r3, androidx.compose.animation.core.Transition.DeferredAnimation r4, androidx.compose.animation.core.Transition r5, final androidx.compose.animation.EnterTransition r6, final androidx.compose.animation.ExitTransition r7, androidx.compose.animation.core.Transition.DeferredAnimation r8) {
        /*
            r0 = 0
            if (r3 == 0) goto L12
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1
            r1.<init>()
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2 r2 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2
            r2.<init>()
            androidx.compose.runtime.State r3 = r3.animate(r1, r2)
            goto L13
        L12:
            r3 = r0
        L13:
            if (r4 == 0) goto L24
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1
            r1.<init>()
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2 r2 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2
            r2.<init>()
            androidx.compose.runtime.State r4 = r4.animate(r1, r2)
            goto L25
        L24:
            r4 = r0
        L25:
            java.lang.Object r5 = r5.getCurrentState()
            androidx.compose.animation.EnterExitState r1 = androidx.compose.animation.EnterExitState.PreEnter
            if (r5 != r1) goto L4d
            androidx.compose.animation.TransitionData r5 = r6.getData()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L40
        L37:
            long r1 = r5.m100getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r5 = androidx.compose.ui.graphics.TransformOrigin.m4533boximpl(r1)
            goto L6b
        L40:
            androidx.compose.animation.TransitionData r5 = r7.getData()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L4b
            goto L37
        L4b:
            r5 = r0
            goto L6b
        L4d:
            androidx.compose.animation.TransitionData r5 = r7.getData()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L60
        L57:
            long r1 = r5.m100getTransformOriginSzJe1aQ()
            androidx.compose.ui.graphics.TransformOrigin r5 = androidx.compose.ui.graphics.TransformOrigin.m4533boximpl(r1)
            goto L6b
        L60:
            androidx.compose.animation.TransitionData r5 = r6.getData()
            androidx.compose.animation.Scale r5 = r5.getScale()
            if (r5 == 0) goto L4b
            goto L57
        L6b:
            if (r8 == 0) goto L78
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1 r0 = new S7.k() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
                static {
                    /*
                        androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1 r0 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1) androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.INSTANCE androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.<init>():void");
                }

                @Override // S7.k
                public final androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.graphics.TransformOrigin> invoke(androidx.compose.animation.core.Transition.Segment<androidx.compose.animation.EnterExitState> r2) {
                    /*
                        r1 = this;
                        r1 = 0
                        r2 = 7
                        r0 = 0
                        androidx.compose.animation.core.SpringSpec r1 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r0, r0, r1, r2, r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.invoke(androidx.compose.animation.core.Transition$Segment):androidx.compose.animation.core.FiniteAnimationSpec");
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        androidx.compose.animation.core.Transition$Segment r1 = (androidx.compose.animation.core.Transition.Segment) r1
                        androidx.compose.animation.core.FiniteAnimationSpec r0 = r0.invoke(r1)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2 r1 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2
            r1.<init>()
            androidx.compose.runtime.State r0 = r8.animate(r0, r1)
        L78:
            androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1 r5 = new androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1
            r5.<init>()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createGraphicsLayerBlock$lambda$13$lambda$12(androidx.compose.animation.core.Transition$DeferredAnimation, androidx.compose.animation.core.Transition$DeferredAnimation, androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, androidx.compose.animation.core.Transition$DeferredAnimation):S7.k");
    }

    @Composable
    public static final Modifier createModifier(Transition<EnterExitState> transition, EnterTransition enterTransition, ExitTransition exitTransition, S7.a aVar, String str, Composer composer, int i, int i6) {
        Transition.DeferredAnimation deferredAnimation;
        Transition.DeferredAnimation deferredAnimation2;
        ChangeSize changeSize;
        final S7.a aVar2 = (i6 & 4) != 0 ? new S7.a() { // from class: androidx.compose.animation.EnterExitTransitionKt.createModifier.1
            @Override // S7.a
            public final Boolean invoke() {
                return Boolean.TRUE;
            }
        } : aVar;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(28261782, i, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:869)");
        }
        int i10 = i & 14;
        EnterTransition enterTransitionTrackActiveEnter = trackActiveEnter(transition, enterTransition, composer, i & 126);
        int i11 = i >> 3;
        ExitTransition exitTransitionTrackActiveExit = trackActiveExit(transition, exitTransition, composer, (i11 & 112) | i10);
        boolean z10 = true;
        boolean z11 = (enterTransitionTrackActiveEnter.getData().getSlide() == null && exitTransitionTrackActiveExit.getData().getSlide() == null) ? false : true;
        boolean z12 = (enterTransitionTrackActiveEnter.getData().getChangeSize() == null && exitTransitionTrackActiveExit.getData().getChangeSize() == null) ? false : true;
        Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation = null;
        if (z11) {
            composer.startReplaceGroup(-821375963);
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = str + " slide";
                composer.updateRememberedValue(objRememberedValue);
            }
            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation2 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter, (String) objRememberedValue, composer, i10 | 384, 0);
            composer.endReplaceGroup();
            deferredAnimation = deferredAnimationCreateDeferredAnimation2;
        } else {
            composer.startReplaceGroup(-821278096);
            composer.endReplaceGroup();
            deferredAnimation = null;
        }
        if (z12) {
            composer.startReplaceGroup(-821202177);
            TwoWayConverter<IntSize, AnimationVector2D> vectorConverter2 = VectorConvertersKt.getVectorConverter(IntSize.INSTANCE);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = str + " shrink/expand";
                composer.updateRememberedValue(objRememberedValue2);
            }
            Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation3 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter2, (String) objRememberedValue2, composer, i10 | 384, 0);
            composer.endReplaceGroup();
            deferredAnimation2 = deferredAnimationCreateDeferredAnimation3;
        } else {
            composer.startReplaceGroup(-821099041);
            composer.endReplaceGroup();
            deferredAnimation2 = null;
        }
        if (z12) {
            composer.startReplaceGroup(-821034002);
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter3 = VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = str + " InterruptionHandlingOffset";
                composer.updateRememberedValue(objRememberedValue3);
            }
            deferredAnimationCreateDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter3, (String) objRememberedValue3, composer, i10 | 384, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-820883777);
            composer.endReplaceGroup();
        }
        ChangeSize changeSize2 = enterTransitionTrackActiveEnter.getData().getChangeSize();
        final boolean z13 = ((changeSize2 == null || changeSize2.getClip()) && ((changeSize = exitTransitionTrackActiveExit.getData().getChangeSize()) == null || changeSize.getClip()) && z12) ? false : true;
        GraphicsLayerBlockForEnterExit graphicsLayerBlockForEnterExitCreateGraphicsLayerBlock = createGraphicsLayerBlock(transition, enterTransitionTrackActiveEnter, exitTransitionTrackActiveExit, str, composer, i10 | (i11 & 7168));
        Modifier.Companion companion = Modifier.INSTANCE;
        boolean zChanged = composer.changed(z13);
        if ((((i & 7168) ^ 3072) <= 2048 || !composer.changed(aVar2)) && (i & 3072) != 2048) {
            z10 = false;
        }
        boolean z14 = zChanged | z10;
        Object objRememberedValue4 = composer.rememberedValue();
        if (z14 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new k() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((GraphicsLayerScope) obj);
                    return r.f317a;
                }

                public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                    graphicsLayerScope.setClip(!z13 && ((Boolean) aVar2.invoke()).booleanValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        Modifier modifierThen = GraphicsLayerModifierKt.graphicsLayer(companion, (k) objRememberedValue4).then(new EnterExitTransitionElement(transition, deferredAnimation2, deferredAnimationCreateDeferredAnimation, deferredAnimation, enterTransitionTrackActiveEnter, exitTransitionTrackActiveExit, aVar2, graphicsLayerBlockForEnterExitCreateGraphicsLayerBlock));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return modifierThen;
    }

    @Stable
    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z10, final k kVar) {
        return expandIn(finiteAnimationSpec, toAlignment(horizontal), z10, new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandHorizontally.2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.m7007boximpl(m78invokemzRDjE0(((IntSize) obj).m7019unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m78invokemzRDjE0(long j5) {
                return IntSizeKt.IntSize(((Number) kVar.invoke(Integer.valueOf(IntSize.m7015getWidthimpl(j5)))).intValue(), IntSize.m7014getHeightimpl(j5));
            }
        });
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z10, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7007boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i & 4) != 0) {
            z10 = true;
        }
        if ((i & 8) != 0) {
            kVar = new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandHorizontally.1
                public final Integer invoke(int i6) {
                    return 0;
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z10, kVar);
    }

    @Stable
    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z10, k kVar) {
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, kVar, finiteAnimationSpec, z10), null, false, null, 59, null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z10, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7007boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z10 = true;
        }
        if ((i & 8) != 0) {
            kVar = new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandIn.1
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return IntSize.m7007boximpl(m79invokemzRDjE0(((IntSize) obj2).m7019unboximpl()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m79invokemzRDjE0(long j5) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return expandIn(finiteAnimationSpec, alignment, z10, kVar);
    }

    @Stable
    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z10, final k kVar) {
        return expandIn(finiteAnimationSpec, toAlignment(vertical), z10, new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandVertically.2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.m7007boximpl(m80invokemzRDjE0(((IntSize) obj).m7019unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m80invokemzRDjE0(long j5) {
                return IntSizeKt.IntSize(IntSize.m7015getWidthimpl(j5), ((Number) kVar.invoke(Integer.valueOf(IntSize.m7014getHeightimpl(j5)))).intValue());
            }
        });
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z10, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7007boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i & 4) != 0) {
            z10 = true;
        }
        if ((i & 8) != 0) {
            kVar = new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.expandVertically.1
                public final Integer invoke(int i6) {
                    return 0;
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return expandVertically(finiteAnimationSpec, vertical, z10, kVar);
    }

    @Stable
    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        return new EnterTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    @Stable
    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        return new ExitTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), null, null, null, false, null, 62, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final <T extends TransitionEffect> T get(EnterTransition enterTransition, TransitionEffectKey<T> transitionEffectKey) {
        TransitionEffect transitionEffect = enterTransition.getData().getEffectsMap().get(transitionEffectKey);
        if (transitionEffect instanceof TransitionEffect) {
            return (T) transitionEffect;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Stable
    /* renamed from: scaleIn-L8ZKh-E, reason: not valid java name */
    public static final EnterTransition m71scaleInL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j5) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(f, j5, finiteAnimationSpec, null), false, 0 == true ? 1 : 0, 55, null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m72scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j5 = TransformOrigin.INSTANCE.m4546getCenterSzJe1aQ();
        }
        return m71scaleInL8ZKhE(finiteAnimationSpec, f, j5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Stable
    /* renamed from: scaleOut-L8ZKh-E, reason: not valid java name */
    public static final ExitTransition m73scaleOutL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j5) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(f, j5, finiteAnimationSpec, null), false, 0 == true ? 1 : 0, 55, null));
    }

    /* renamed from: scaleOut-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m74scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j5 = TransformOrigin.INSTANCE.m4546getCenterSzJe1aQ();
        }
        return m73scaleOutL8ZKhE(finiteAnimationSpec, f, j5);
    }

    @Stable
    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z10, final k kVar) {
        return shrinkOut(finiteAnimationSpec, toAlignment(horizontal), z10, new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally.2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.m7007boximpl(m81invokemzRDjE0(((IntSize) obj).m7019unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m81invokemzRDjE0(long j5) {
                return IntSizeKt.IntSize(((Number) kVar.invoke(Integer.valueOf(IntSize.m7015getWidthimpl(j5)))).intValue(), IntSize.m7014getHeightimpl(j5));
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z10, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7007boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.INSTANCE.getEnd();
        }
        if ((i & 4) != 0) {
            z10 = true;
        }
        if ((i & 8) != 0) {
            kVar = new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkHorizontally.1
                public final Integer invoke(int i6) {
                    return 0;
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z10, kVar);
    }

    @Stable
    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z10, k kVar) {
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, kVar, finiteAnimationSpec, z10), null, false, null, 59, null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z10, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7007boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.INSTANCE.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z10 = true;
        }
        if ((i & 8) != 0) {
            kVar = new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkOut.1
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return IntSize.m7007boximpl(m82invokemzRDjE0(((IntSize) obj2).m7019unboximpl()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m82invokemzRDjE0(long j5) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return shrinkOut(finiteAnimationSpec, alignment, z10, kVar);
    }

    @Stable
    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z10, final k kVar) {
        return shrinkOut(finiteAnimationSpec, toAlignment(vertical), z10, new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkVertically.2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.m7007boximpl(m83invokemzRDjE0(((IntSize) obj).m7019unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m83invokemzRDjE0(long j5) {
                return IntSizeKt.IntSize(IntSize.m7015getWidthimpl(j5), ((Number) kVar.invoke(Integer.valueOf(IntSize.m7014getHeightimpl(j5)))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z10, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m7007boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.INSTANCE.getBottom();
        }
        if ((i & 4) != 0) {
            z10 = true;
        }
        if ((i & 8) != 0) {
            kVar = new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.shrinkVertically.1
                public final Integer invoke(int i6) {
                    return 0;
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z10, kVar);
    }

    @Stable
    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, k kVar) {
        return new EnterTransitionImpl(new TransitionData(null, new Slide(kVar, finiteAnimationSpec), null, null, false, null, 61, null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6963boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        return slideIn(finiteAnimationSpec, kVar);
    }

    @Stable
    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final k kVar) {
        return slideIn(finiteAnimationSpec, new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInHorizontally.2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.m6963boximpl(m84invokemHKZG7I(((IntSize) obj).m7019unboximpl()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m84invokemHKZG7I(long j5) {
                return IntOffsetKt.IntOffset(((Number) kVar.invoke(Integer.valueOf(IntSize.m7015getWidthimpl(j5)))).intValue(), 0);
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6963boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            kVar = new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInHorizontally.1
                public final Integer invoke(int i6) {
                    return Integer.valueOf((-i6) / 2);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return slideInHorizontally(finiteAnimationSpec, kVar);
    }

    @Stable
    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final k kVar) {
        return slideIn(finiteAnimationSpec, new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInVertically.2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.m6963boximpl(m85invokemHKZG7I(((IntSize) obj).m7019unboximpl()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m85invokemHKZG7I(long j5) {
                return IntOffsetKt.IntOffset(0, ((Number) kVar.invoke(Integer.valueOf(IntSize.m7014getHeightimpl(j5)))).intValue());
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6963boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            kVar = new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideInVertically.1
                public final Integer invoke(int i6) {
                    return Integer.valueOf((-i6) / 2);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return slideInVertically(finiteAnimationSpec, kVar);
    }

    @Stable
    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, k kVar) {
        return new ExitTransitionImpl(new TransitionData(null, new Slide(kVar, finiteAnimationSpec), null, null, false, null, 61, null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6963boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        return slideOut(finiteAnimationSpec, kVar);
    }

    @Stable
    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final k kVar) {
        return slideOut(finiteAnimationSpec, new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutHorizontally.2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.m6963boximpl(m86invokemHKZG7I(((IntSize) obj).m7019unboximpl()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m86invokemHKZG7I(long j5) {
                return IntOffsetKt.IntOffset(((Number) kVar.invoke(Integer.valueOf(IntSize.m7015getWidthimpl(j5)))).intValue(), 0);
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6963boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            kVar = new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutHorizontally.1
                public final Integer invoke(int i6) {
                    return Integer.valueOf((-i6) / 2);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return slideOutHorizontally(finiteAnimationSpec, kVar);
    }

    @Stable
    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final k kVar) {
        return slideOut(finiteAnimationSpec, new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutVertically.2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.m6963boximpl(m87invokemHKZG7I(((IntSize) obj).m7019unboximpl()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m87invokemHKZG7I(long j5) {
                return IntOffsetKt.IntOffset(0, ((Number) kVar.invoke(Integer.valueOf(IntSize.m7014getHeightimpl(j5)))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m6963boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 1, null);
        }
        if ((i & 2) != 0) {
            kVar = new k() { // from class: androidx.compose.animation.EnterExitTransitionKt.slideOutVertically.1
                public final Integer invoke(int i6) {
                    return Integer.valueOf((-i6) / 2);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return slideOutVertically(finiteAnimationSpec, kVar);
    }

    private static final Alignment toAlignment(Alignment.Horizontal horizontal) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return kotlin.jvm.internal.k.b(horizontal, companion.getStart()) ? companion.getCenterStart() : kotlin.jvm.internal.k.b(horizontal, companion.getEnd()) ? companion.getCenterEnd() : companion.getCenter();
    }

    @Composable
    public static final EnterTransition trackActiveEnter(Transition<EnterExitState> transition, EnterTransition enterTransition, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21614502, i, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:910)");
        }
        boolean z10 = (((i & 14) ^ 6) > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(enterTransition, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                mutableState.setValue(enterTransition);
            } else {
                mutableState.setValue(EnterTransition.INSTANCE.getNone());
            }
        } else if (transition.getTargetState() == EnterExitState.Visible) {
            mutableState.setValue(trackActiveEnter$lambda$5(mutableState).plus(enterTransition));
        }
        EnterTransition enterTransitionTrackActiveEnter$lambda$5 = trackActiveEnter$lambda$5(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return enterTransitionTrackActiveEnter$lambda$5;
    }

    private static final EnterTransition trackActiveEnter$lambda$5(MutableState<EnterTransition> mutableState) {
        return mutableState.getValue();
    }

    @Composable
    public static final ExitTransition trackActiveExit(Transition<EnterExitState> transition, ExitTransition exitTransition, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1363864804, i, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:930)");
        }
        boolean z10 = (((i & 14) ^ 6) > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(exitTransition, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                mutableState.setValue(exitTransition);
            } else {
                mutableState.setValue(ExitTransition.INSTANCE.getNone());
            }
        } else if (transition.getTargetState() != EnterExitState.Visible) {
            mutableState.setValue(trackActiveExit$lambda$8(mutableState).plus(exitTransition));
        }
        ExitTransition exitTransitionTrackActiveExit$lambda$8 = trackActiveExit$lambda$8(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return exitTransitionTrackActiveExit$lambda$8;
    }

    private static final ExitTransition trackActiveExit$lambda$8(MutableState<ExitTransition> mutableState) {
        return mutableState.getValue();
    }

    public static final EnterTransition withEffect(EnterTransition enterTransition, TransitionEffect transitionEffect) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, null, false, kotlin.collections.a.Q(new Pair(transitionEffect.getKey$animation_release(), transitionEffect)), 31, null));
    }

    public static final <T extends TransitionEffect> T get(ExitTransition exitTransition, TransitionEffectKey<T> transitionEffectKey) {
        TransitionEffect transitionEffect = exitTransition.getData().getEffectsMap().get(transitionEffectKey);
        if (transitionEffect instanceof TransitionEffect) {
            return (T) transitionEffect;
        }
        return null;
    }

    private static final Alignment toAlignment(Alignment.Vertical vertical) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return kotlin.jvm.internal.k.b(vertical, companion.getTop()) ? companion.getTopCenter() : kotlin.jvm.internal.k.b(vertical, companion.getBottom()) ? companion.getBottomCenter() : companion.getCenter();
    }

    public static final ExitTransition withEffect(ExitTransition exitTransition, TransitionEffect transitionEffect) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, null, false, kotlin.collections.a.Q(new Pair(transitionEffect.getKey$animation_release(), transitionEffect)), 31, null));
    }
}
