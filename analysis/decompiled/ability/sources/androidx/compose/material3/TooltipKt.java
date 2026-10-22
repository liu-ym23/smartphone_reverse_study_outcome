package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.o;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.BasicTooltipDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.jvm.internal.f;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u001ai\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u001c\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a!\u0010 \u001a\u00020\t*\u00020\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eH\u0000¢\u0006\u0004\b \u0010!\"\u001a\u0010#\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u001a\u0010'\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010&\"\u001a\u0010)\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u001a\u0010+\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b+\u0010$\u001a\u0004\b,\u0010&\"\u0014\u0010-\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010$\"\u0014\u0010.\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010$\"\u001a\u00100\u001a\u00020/8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u001a\u00104\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b4\u0010$\u001a\u0004\b5\u0010&\"\u001a\u00106\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b6\u0010$\u001a\u0004\b7\u0010&\"\u001a\u00108\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b8\u0010$\u001a\u0004\b9\u0010&\"\u0014\u0010:\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010$\"\u0014\u0010;\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010$\"\u001a\u0010<\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b<\u0010$\u001a\u0004\b=\u0010&\"\u001a\u0010>\u001a\u00020\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010$\u001a\u0004\b?\u0010&\"\u0014\u0010A\u001a\u00020@8\u0000X\u0080T¢\u0006\u0006\n\u0004\bA\u0010B\"\u0014\u0010C\u001a\u00020@8\u0000X\u0080T¢\u0006\u0006\n\u0004\bC\u0010B¨\u0006G²\u0006\f\u0010E\u001a\u00020D8\nX\u008a\u0084\u0002²\u0006\f\u0010F\u001a\u00020D8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/window/PopupPositionProvider;", "positionProvider", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "tooltip", "Landroidx/compose/material3/TooltipState;", "state", "Landroidx/compose/ui/Modifier;", "modifier", "", "focusable", "enableUserInput", "Lkotlin/Function0;", "content", "TooltipBox", "(Landroidx/compose/ui/window/PopupPositionProvider;LS7/o;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLS7/n;Landroidx/compose/runtime/Composer;II)V", "initialIsVisible", "isPersistent", "Landroidx/compose/foundation/MutatorMutex;", "mutatorMutex", "rememberTooltipState", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "TooltipState", "(ZZLandroidx/compose/foundation/MutatorMutex;)Landroidx/compose/material3/TooltipState;", "subheadExists", "actionExists", "textVerticalPadding", "(Landroidx/compose/ui/Modifier;ZZ)Landroidx/compose/ui/Modifier;", "Landroidx/compose/animation/core/Transition;", "transition", "animateTooltip", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/Transition;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "SpacingBetweenTooltipAndAnchor", "F", "getSpacingBetweenTooltipAndAnchor", "()F", "TooltipMinHeight", "getTooltipMinHeight", "TooltipMinWidth", "getTooltipMinWidth", "PlainTooltipMaxWidth", "getPlainTooltipMaxWidth", "PlainTooltipVerticalPadding", "PlainTooltipHorizontalPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "PlainTooltipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getPlainTooltipContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "RichTooltipMaxWidth", "getRichTooltipMaxWidth", "RichTooltipHorizontalPadding", "getRichTooltipHorizontalPadding", "HeightToSubheadFirstLine", "getHeightToSubheadFirstLine", "HeightFromSubheadToTextFirstLine", "TextBottomPadding", "ActionLabelMinHeight", "getActionLabelMinHeight", "ActionLabelBottomPadding", "getActionLabelBottomPadding", "", "TooltipFadeInDuration", "I", "TooltipFadeOutDuration", "", "scale", "alpha", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TooltipKt {
    private static final float ActionLabelBottomPadding;
    private static final float ActionLabelMinHeight;
    private static final float HeightFromSubheadToTextFirstLine;
    private static final float HeightToSubheadFirstLine;
    private static final PaddingValues PlainTooltipContentPadding;
    private static final float PlainTooltipHorizontalPadding;
    private static final float PlainTooltipVerticalPadding;
    private static final float RichTooltipHorizontalPadding;
    private static final float RichTooltipMaxWidth;
    private static final float SpacingBetweenTooltipAndAnchor;
    private static final float TextBottomPadding;
    public static final int TooltipFadeInDuration = 150;
    public static final int TooltipFadeOutDuration = 75;
    private static final float TooltipMinHeight;
    private static final float TooltipMinWidth = Dp.m6844constructorimpl(40);
    private static final float PlainTooltipMaxWidth = Dp.m6844constructorimpl(200);

    static {
        float f = 4;
        SpacingBetweenTooltipAndAnchor = Dp.m6844constructorimpl(f);
        float f7 = 24;
        TooltipMinHeight = Dp.m6844constructorimpl(f7);
        float fM6844constructorimpl = Dp.m6844constructorimpl(f);
        PlainTooltipVerticalPadding = fM6844constructorimpl;
        float f9 = 8;
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(f9);
        PlainTooltipHorizontalPadding = fM6844constructorimpl2;
        PlainTooltipContentPadding = PaddingKt.m694PaddingValuesYgX7TsA(fM6844constructorimpl2, fM6844constructorimpl);
        RichTooltipMaxWidth = Dp.m6844constructorimpl(320);
        float f10 = 16;
        RichTooltipHorizontalPadding = Dp.m6844constructorimpl(f10);
        HeightToSubheadFirstLine = Dp.m6844constructorimpl(28);
        HeightFromSubheadToTextFirstLine = Dp.m6844constructorimpl(f7);
        TextBottomPadding = Dp.m6844constructorimpl(f10);
        ActionLabelMinHeight = Dp.m6844constructorimpl(36);
        ActionLabelBottomPadding = Dp.m6844constructorimpl(f9);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011d  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TooltipBox(final androidx.compose.ui.window.PopupPositionProvider r17, final S7.o r18, final androidx.compose.material3.TooltipState r19, androidx.compose.ui.Modifier r20, boolean r21, boolean r22, final S7.n r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipKt.TooltipBox(androidx.compose.ui.window.PopupPositionProvider, S7.o, androidx.compose.material3.TooltipState, androidx.compose.ui.Modifier, boolean, boolean, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    @ExperimentalMaterial3Api
    public static final TooltipState TooltipState(boolean z10, boolean z11, MutatorMutex mutatorMutex) {
        return new TooltipStateImpl(z10, z11, mutatorMutex);
    }

    public static /* synthetic */ TooltipState TooltipState$default(boolean z10, boolean z11, MutatorMutex mutatorMutex, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = false;
        }
        if ((i & 2) != 0) {
            z11 = true;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return TooltipState(z10, z11, mutatorMutex);
    }

    public static final Modifier animateTooltip(Modifier modifier, final Transition<Boolean> transition) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("animateTooltip");
                inspectorInfo.getProperties().set("transition", transition);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new o() { // from class: androidx.compose.material3.TooltipKt.animateTooltip.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            private static final float invoke$lambda$1(State<Float> state) {
                return state.getValue().floatValue();
            }

            private static final float invoke$lambda$3(State<Float> state) {
                return state.getValue().floatValue();
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(-1498516085);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1498516085, i, -1, "androidx.compose.material3.animateTooltip.<anonymous> (Tooltip.kt:584)");
                }
                Transition<Boolean> transition2 = transition;
                TooltipKt$animateTooltip$2$scale$2 tooltipKt$animateTooltip$2$scale$2 = new o() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$scale$2
                    @Override // S7.o
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke((Transition.Segment<Boolean>) obj, (Composer) obj2, ((Number) obj3).intValue());
                    }

                    @Composable
                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i6) {
                        composer2.startReplaceGroup(386845748);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(386845748, i6, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:587)");
                        }
                        TweenSpec tweenSpecTween$default = segment.isTransitioningTo(Boolean.FALSE, Boolean.TRUE) ? AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearOutSlowInEasing(), 2, null) : AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearOutSlowInEasing(), 2, null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceGroup();
                        return tweenSpecTween$default;
                    }
                };
                f fVar = f.f4924a;
                TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(fVar);
                boolean zBooleanValue = transition2.getCurrentState().booleanValue();
                composer.startReplaceGroup(-1553362193);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:603)");
                }
                float f = zBooleanValue ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Float fValueOf = Float.valueOf(f);
                boolean zBooleanValue2 = transition2.getTargetState().booleanValue();
                composer.startReplaceGroup(-1553362193);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1553362193, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:603)");
                }
                float f7 = zBooleanValue2 ? 1.0f : 0.8f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition2, fValueOf, Float.valueOf(f7), (FiniteAnimationSpec) tooltipKt$animateTooltip$2$scale$2.invoke((Object) transition2.getSegment(), (Object) composer, (Object) 0), vectorConverter, "tooltip transition: scaling", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                Transition<Boolean> transition3 = transition;
                TooltipKt$animateTooltip$2$alpha$2 tooltipKt$animateTooltip$2$alpha$2 = new o() { // from class: androidx.compose.material3.TooltipKt$animateTooltip$2$alpha$2
                    @Override // S7.o
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke((Transition.Segment<Boolean>) obj, (Composer) obj2, ((Number) obj3).intValue());
                    }

                    @Composable
                    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i6) {
                        composer2.startReplaceGroup(-281714272);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-281714272, i6, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:609)");
                        }
                        TweenSpec tweenSpecTween$default = segment.isTransitioningTo(Boolean.FALSE, Boolean.TRUE) ? AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearEasing(), 2, null) : AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearEasing(), 2, null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2.endReplaceGroup();
                        return tweenSpecTween$default;
                    }
                };
                TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(fVar);
                boolean zBooleanValue3 = transition3.getCurrentState().booleanValue();
                composer.startReplaceGroup(2073045083);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:619)");
                }
                float f9 = zBooleanValue3 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Float fValueOf2 = Float.valueOf(f9);
                boolean zBooleanValue4 = transition3.getTargetState().booleanValue();
                composer.startReplaceGroup(2073045083);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2073045083, 0, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:619)");
                }
                float f10 = zBooleanValue4 ? 1.0f : 0.0f;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                Modifier modifierM4301graphicsLayerAp8cVGQ = GraphicsLayerModifierKt.m4301graphicsLayerAp8cVGQ(modifier2, (131067 & 1) != 0 ? 1.0f : invoke$lambda$1(stateCreateTransitionAnimation), (131067 & 2) != 0 ? 1.0f : invoke$lambda$1(stateCreateTransitionAnimation), (131067 & 4) == 0 ? invoke$lambda$3(TransitionKt.createTransitionAnimation(transition3, fValueOf2, Float.valueOf(f10), (FiniteAnimationSpec) tooltipKt$animateTooltip$2$alpha$2.invoke((Object) transition3.getSegment(), (Object) composer, (Object) 0), vectorConverter2, "tooltip transition: alpha", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE)) : 1.0f, (131067 & 8) != 0 ? 0.0f : 0.0f, (131067 & 16) != 0 ? 0.0f : 0.0f, (131067 & 32) != 0 ? 0.0f : 0.0f, (131067 & 64) != 0 ? 0.0f : 0.0f, (131067 & 128) != 0 ? 0.0f : 0.0f, (131067 & 256) == 0 ? 0.0f : 0.0f, (131067 & 512) != 0 ? 8.0f : 0.0f, (131067 & 1024) != 0 ? TransformOrigin.INSTANCE.m4546getCenterSzJe1aQ() : 0L, (131067 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : null, (131067 & 4096) != 0 ? false : false, (131067 & 8192) != 0 ? null : null, (131067 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (32768 & 131067) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (131067 & 65536) != 0 ? CompositingStrategy.INSTANCE.m4228getAutoNrFUSI() : 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM4301graphicsLayerAp8cVGQ;
            }
        });
    }

    public static final float getActionLabelBottomPadding() {
        return ActionLabelBottomPadding;
    }

    public static final float getActionLabelMinHeight() {
        return ActionLabelMinHeight;
    }

    public static final float getHeightToSubheadFirstLine() {
        return HeightToSubheadFirstLine;
    }

    public static final PaddingValues getPlainTooltipContentPadding() {
        return PlainTooltipContentPadding;
    }

    public static final float getPlainTooltipMaxWidth() {
        return PlainTooltipMaxWidth;
    }

    public static final float getRichTooltipHorizontalPadding() {
        return RichTooltipHorizontalPadding;
    }

    public static final float getRichTooltipMaxWidth() {
        return RichTooltipMaxWidth;
    }

    public static final float getSpacingBetweenTooltipAndAnchor() {
        return SpacingBetweenTooltipAndAnchor;
    }

    public static final float getTooltipMinHeight() {
        return TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipMinWidth;
    }

    @Composable
    @ExperimentalMaterial3Api
    public static final TooltipState rememberTooltipState(boolean z10, boolean z11, MutatorMutex mutatorMutex, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            z10 = false;
        }
        if ((i6 & 2) != 0) {
            z11 = false;
        }
        if ((i6 & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1413230530, i, -1, "androidx.compose.material3.rememberTooltipState (Tooltip.kt:436)");
        }
        boolean z12 = ((((i & 112) ^ 48) > 32 && composer.changed(z11)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(mutatorMutex)) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new TooltipStateImpl(z10, z11, mutatorMutex);
            composer.updateRememberedValue(objRememberedValue);
        }
        TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return tooltipStateImpl;
    }

    @Stable
    public static final Modifier textVerticalPadding(Modifier modifier, boolean z10, boolean z11) {
        return (z10 || z11) ? PaddingKt.m704paddingqDBjuR0$default(AlignmentLineKt.m555paddingFromBaselineVpY3zN4$default(modifier, HeightFromSubheadToTextFirstLine, 0.0f, 2, null), 0.0f, 0.0f, 0.0f, TextBottomPadding, 7, null) : PaddingKt.m702paddingVpY3zN4$default(modifier, 0.0f, PlainTooltipVerticalPadding, 1, null);
    }
}
