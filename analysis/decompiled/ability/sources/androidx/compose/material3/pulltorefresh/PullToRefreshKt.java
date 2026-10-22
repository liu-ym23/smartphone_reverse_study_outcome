package androidx.compose.material3.pulltorefresh;

import C7.r;
import S7.a;
import S7.k;
import S7.n;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import g1.AbstractC1451a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000z\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aw\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0019\b\u0002\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\r2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aN\u0010\u001b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aH\u0010\u001f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00122\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u000f\u0010 \u001a\u00020\u0007H\u0007¢\u0006\u0004\b \u0010!\u001a\u000f\u0010\"\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\"\u0010#\u001a(\u0010)\u001a\u00020\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00022\u0006\u0010&\u001a\u00020\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a>\u00103\u001a\u00020\u0003*\u00020*2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010+\u001a\u00020$2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u0017\u00104\u001a\u00020,2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b4\u00105\u001aF\u0010;\u001a\u00020\u0003*\u00020*2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020.2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010+\u001a\u00020$2\u0006\u0010-\u001a\u00020,2\u0006\u00100\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:\"\u0014\u0010<\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010=\"\u0014\u0010?\u001a\u00020>8\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u0010@\"\u0014\u0010A\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010=\"\u0014\u0010B\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010=\"\u001a\u0010C\u001a\u00020\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\bC\u0010=\u001a\u0004\bD\u0010E\"\u001a\u0010F\u001a\u00020\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010=\u001a\u0004\bG\u0010E\"\u0014\u0010H\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010=\"\u0014\u0010I\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010=\"\u0014\u0010J\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010=\"\u0014\u0010K\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\bK\u0010=\"\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020$0L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010N\"\u0014\u0010O\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010=\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Q²\u0006\f\u0010P\u001a\u00020$8\nX\u008a\u0084\u0002"}, d2 = {"", "isRefreshing", "Lkotlin/Function0;", "LC7/r;", "onRefresh", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "state", "Landroidx/compose/ui/Alignment;", "contentAlignment", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "indicator", "content", "PullToRefreshBox", "(ZLS7/a;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Alignment;LS7/o;LS7/o;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/unit/Dp;", "threshold", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/Color;", "containerColor", "elevation", "pullToRefreshIndicator-wUdLESc", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLandroidx/compose/ui/graphics/Shape;JF)Landroidx/compose/ui/Modifier;", "pullToRefreshIndicator", "enabled", "pullToRefresh-Z4HSEVQ", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLS7/a;)Landroidx/compose/ui/Modifier;", "pullToRefresh", "rememberPullToRefreshState", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "PullToRefreshState", "()Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "", "progress", TypedValues.Custom.S_COLOR, "CircularArrowProgressIndicator-RPmYEkk", "(LS7/a;JLandroidx/compose/runtime/Composer;I)V", "CircularArrowProgressIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "alpha", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", "values", "Landroidx/compose/ui/geometry/Rect;", "arcBounds", "strokeWidth", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "drawCircularIndicator", "ArrowValues", "(F)Landroidx/compose/material3/pulltorefresh/ArrowValues;", "Landroidx/compose/ui/graphics/Path;", "arrow", "bounds", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "drawArrow", "MaxProgressArc", "F", "", "CrossfadeDurationMs", "I", "StrokeWidth", "ArcRadius", "SpinnerSize", "getSpinnerSize", "()F", "SpinnerContainerSize", "getSpinnerContainerSize", "ArrowWidth", "ArrowHeight", "MinAlpha", "MaxAlpha", "Landroidx/compose/animation/core/TweenSpec;", "AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "DragMultiplier", "targetAlpha", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PullToRefreshKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float DragMultiplier = 0.5f;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float StrokeWidth = Dp.m6844constructorimpl((float) 2.5d);
    private static final float ArcRadius = Dp.m6844constructorimpl((float) 5.5d);
    private static final float SpinnerSize = Dp.m6844constructorimpl(16);
    private static final float SpinnerContainerSize = Dp.m6844constructorimpl(40);
    private static final float ArrowWidth = Dp.m6844constructorimpl(10);
    private static final float ArrowHeight = Dp.m6844constructorimpl(5);
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float f) {
        float fMax = (Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * 5) / 3;
        float fT = AbstractC1451a.t(Math.abs(f) - 1.0f, 0.0f, 2.0f);
        float fPow = (((0.4f * fMax) - 0.25f) + (fT - (((float) Math.pow(fT, 2)) / 4))) * 0.5f;
        float f7 = 360;
        return new ArrowValues(fPow, fPow * f7, ((0.8f * fMax) + fPow) * f7, Math.min(1.0f, fMax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: CircularArrowProgressIndicator-RPmYEkk, reason: not valid java name */
    public static final void m2768CircularArrowProgressIndicatorRPmYEkk(final a aVar, final long j5, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-569718810);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(aVar) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(j5) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-569718810, i6, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:561)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            Object obj = objRememberedValue;
            if (objRememberedValue == companion.getEmpty()) {
                Path Path = AndroidPath_androidKt.Path();
                Path.mo4030setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m4432getEvenOddRgk1Os());
                composerStartRestartGroup.updateRememberedValue(Path);
                obj = Path;
            }
            final Path path = (Path) obj;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new a() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$targetAlpha$2$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final Float invoke() {
                        return Float.valueOf(((Number) aVar.invoke()).floatValue() < 1.0f ? 0.3f : 1.0f);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowProgressIndicator_RPmYEkk$lambda$4((State) objRememberedValue2), AlphaTween, 0.0f, null, null, composerStartRestartGroup, 48, 28);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            int i10 = i6 & 14;
            boolean z10 = i10 == 4;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new k() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$1$1
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((SemanticsPropertyReceiver) obj2);
                        return r.f317a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(((Number) aVar.invoke()).floatValue(), new Y7.a(0.0f, 1.0f), 0));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierM745size3ABfNKs = SizeKt.m745size3ABfNKs(SemanticsModifierKt.semantics(companion2, true, (k) objRememberedValue3), SpinnerSize);
            boolean zChanged = (i10 == 4) | composerStartRestartGroup.changed(stateAnimateFloatAsState) | ((i6 & 112) == 32) | composerStartRestartGroup.changedInstance(path);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == companion.getEmpty()) {
                k kVar = new k() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((DrawScope) obj2);
                        return r.f317a;
                    }

                    public final void invoke(DrawScope drawScope) {
                        ArrowValues ArrowValues = PullToRefreshKt.ArrowValues(((Number) aVar.invoke()).floatValue());
                        float fFloatValue = stateAnimateFloatAsState.getValue().floatValue();
                        float rotation = ArrowValues.getRotation();
                        long j6 = j5;
                        Path path2 = path;
                        long jMo4706getCenterF1C5BW0 = drawScope.mo4706getCenterF1C5BW0();
                        DrawContext drawContext = drawScope.getDrawContext();
                        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
                        drawContext.getCanvas().save();
                        try {
                            drawContext.getTransform().mo4634rotateUv8p0NA(rotation, jMo4706getCenterF1C5BW0);
                            Rect rectM3934Rect3MmeM6k = RectKt.m3934Rect3MmeM6k(androidx.compose.ui.geometry.SizeKt.m3974getCenteruvyYCjk(drawScope.mo4707getSizeNHjbRc()), (drawScope.mo381toPx0680j_4(PullToRefreshKt.StrokeWidth) / 2.0f) + drawScope.mo381toPx0680j_4(PullToRefreshKt.ArcRadius));
                            PullToRefreshKt.m2773drawCircularIndicatorKzyDr3Q(drawScope, j6, fFloatValue, ArrowValues, rectM3934Rect3MmeM6k, PullToRefreshKt.StrokeWidth);
                            PullToRefreshKt.m2772drawArrowuDrxG_w(drawScope, path2, rectM3934Rect3MmeM6k, j6, fFloatValue, ArrowValues, PullToRefreshKt.StrokeWidth);
                        } finally {
                            androidx.appfunctions.metadata.a.A(drawContext, jMo4628getSizeNHjbRc);
                        }
                    }
                };
                composerStartRestartGroup.updateRememberedValue(kVar);
                objRememberedValue4 = kVar;
            }
            CanvasKt.Canvas(modifierM745size3ABfNKs, (k) objRememberedValue4, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$CircularArrowProgressIndicator$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i11) {
                    PullToRefreshKt.m2768CircularArrowProgressIndicatorRPmYEkk(aVar, j5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0104  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void PullToRefreshBox(final boolean r16, final S7.a r17, androidx.compose.ui.Modifier r18, androidx.compose.material3.pulltorefresh.PullToRefreshState r19, androidx.compose.ui.Alignment r20, S7.o r21, final S7.o r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshKt.PullToRefreshBox(boolean, S7.a, androidx.compose.ui.Modifier, androidx.compose.material3.pulltorefresh.PullToRefreshState, androidx.compose.ui.Alignment, S7.o, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }

    @ExperimentalMaterial3Api
    public static final PullToRefreshState PullToRefreshState() {
        return new PullToRefreshStateImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawArrow-uDrxG_w, reason: not valid java name */
    public static final void m2772drawArrowuDrxG_w(DrawScope drawScope, Path path, Rect rect, long j5, float f, ArrowValues arrowValues, float f7) {
        path.reset();
        path.moveTo(0.0f, 0.0f);
        float f9 = ArrowWidth;
        path.lineTo((drawScope.mo381toPx0680j_4(f9) * arrowValues.getScale()) / 2, drawScope.mo381toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        path.lineTo(drawScope.mo381toPx0680j_4(f9) * arrowValues.getScale(), 0.0f);
        path.mo4032translatek4lQ0M(OffsetKt.Offset((Offset.m3895getXimpl(rect.m3925getCenterF1C5BW0()) + (Math.min(rect.getWidth(), rect.getHeight()) / 2.0f)) - ((drawScope.mo381toPx0680j_4(f9) * arrowValues.getScale()) / 2.0f), Offset.m3896getYimpl(rect.m3925getCenterF1C5BW0()) - drawScope.mo381toPx0680j_4(f7)));
        float endAngle = arrowValues.getEndAngle() - drawScope.mo381toPx0680j_4(f7);
        long jMo4706getCenterF1C5BW0 = drawScope.mo4706getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4634rotateUv8p0NA(endAngle, jMo4706getCenterF1C5BW0);
            DrawScope.m4697drawPathLG529CI$default(drawScope, path, j5, f, new Stroke(drawScope.mo381toPx0680j_4(f7), 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
        } finally {
            androidx.appfunctions.metadata.a.A(drawContext, jMo4628getSizeNHjbRc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCircularIndicator-KzyDr3Q, reason: not valid java name */
    public static final void m2773drawCircularIndicatorKzyDr3Q(DrawScope drawScope, long j5, float f, ArrowValues arrowValues, Rect rect, float f7) {
        DrawScope.m4686drawArcyD3GUKo$default(drawScope, j5, arrowValues.getStartAngle(), arrowValues.getEndAngle() - arrowValues.getStartAngle(), false, rect.m3930getTopLeftF1C5BW0(), rect.m3928getSizeNHjbRc(), f, new Stroke(drawScope.mo381toPx0680j_4(f7), 0.0f, StrokeCap.INSTANCE.m4508getButtKaPHkGw(), 0, null, 26, null), null, 0, 768, null);
    }

    public static final float getSpinnerContainerSize() {
        return SpinnerContainerSize;
    }

    public static final float getSpinnerSize() {
        return SpinnerSize;
    }

    @ExperimentalMaterial3Api
    /* renamed from: pullToRefresh-Z4HSEVQ, reason: not valid java name */
    public static final Modifier m2774pullToRefreshZ4HSEVQ(Modifier modifier, boolean z10, PullToRefreshState pullToRefreshState, boolean z11, float f, a aVar) {
        return modifier.then(new PullToRefreshElement(z10, aVar, z11, pullToRefreshState, f, null));
    }

    /* renamed from: pullToRefresh-Z4HSEVQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2775pullToRefreshZ4HSEVQ$default(Modifier modifier, boolean z10, PullToRefreshState pullToRefreshState, boolean z11, float f, a aVar, int i, Object obj) {
        if ((i & 4) != 0) {
            z11 = true;
        }
        boolean z12 = z11;
        if ((i & 8) != 0) {
            f = PullToRefreshDefaults.INSTANCE.m2763getPositionalThresholdD9Ej5fM();
        }
        return m2774pullToRefreshZ4HSEVQ(modifier, z10, pullToRefreshState, z12, f, aVar);
    }

    @ExperimentalMaterial3Api
    /* renamed from: pullToRefreshIndicator-wUdLESc, reason: not valid java name */
    public static final Modifier m2776pullToRefreshIndicatorwUdLESc(Modifier modifier, final PullToRefreshState pullToRefreshState, final boolean z10, final float f, final Shape shape, long j5, final float f7) {
        return BackgroundKt.m238backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(DrawModifierKt.drawWithContent(SizeKt.m745size3ABfNKs(modifier, SpinnerContainerSize), new k() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$pullToRefreshIndicator$1
            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return r.f317a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                int iM4128getIntersectrtfAjoo = ClipOp.INSTANCE.m4128getIntersectrtfAjoo();
                DrawContext drawContext = contentDrawScope.getDrawContext();
                long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
                drawContext.getCanvas().save();
                try {
                    drawContext.getTransform().mo4631clipRectN_I0leg(-3.4028235E38f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE, iM4128getIntersectrtfAjoo);
                    contentDrawScope.drawContent();
                } finally {
                    androidx.appfunctions.metadata.a.A(drawContext, jMo4628getSizeNHjbRc);
                }
            }
        }), new k() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$pullToRefreshIndicator$2
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
                boolean z11 = pullToRefreshState.getDistanceFraction() > 0.0f || z10;
                graphicsLayerScope.setTranslationY((pullToRefreshState.getDistanceFraction() * graphicsLayerScope.mo375roundToPx0680j_4(f)) - Size.m3961getHeightimpl(graphicsLayerScope.getSize()));
                graphicsLayerScope.setShadowElevation(z11 ? graphicsLayerScope.mo381toPx0680j_4(f7) : 0.0f);
                graphicsLayerScope.setShape(shape);
                graphicsLayerScope.setClip(true);
            }
        }), j5, shape);
    }

    /* renamed from: pullToRefreshIndicator-wUdLESc$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2777pullToRefreshIndicatorwUdLESc$default(Modifier modifier, PullToRefreshState pullToRefreshState, boolean z10, float f, Shape shape, long j5, float f7, int i, Object obj) {
        if ((i & 4) != 0) {
            f = PullToRefreshDefaults.INSTANCE.m2763getPositionalThresholdD9Ej5fM();
        }
        float f9 = f;
        if ((i & 8) != 0) {
            shape = PullToRefreshDefaults.INSTANCE.getShape();
        }
        Shape shape2 = shape;
        if ((i & 16) != 0) {
            j5 = Color.INSTANCE.m4175getUnspecified0d7_KjU();
        }
        return m2776pullToRefreshIndicatorwUdLESc(modifier, pullToRefreshState, z10, f9, shape2, j5, (i & 32) != 0 ? PullToRefreshDefaults.INSTANCE.m2762getElevationD9Ej5fM() : f7);
    }

    @Composable
    @ExperimentalMaterial3Api
    public static final PullToRefreshState rememberPullToRefreshState(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(318623070, i, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:512)");
        }
        PullToRefreshStateImpl pullToRefreshStateImpl = (PullToRefreshStateImpl) RememberSaveableKt.m3591rememberSaveable(new Object[0], (Saver) PullToRefreshStateImpl.INSTANCE.getSaver(), (String) null, (a) new a() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt.rememberPullToRefreshState.1
            @Override // S7.a
            public final PullToRefreshStateImpl invoke() {
                return new PullToRefreshStateImpl();
            }
        }, composer, 3072, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return pullToRefreshStateImpl;
    }
}
