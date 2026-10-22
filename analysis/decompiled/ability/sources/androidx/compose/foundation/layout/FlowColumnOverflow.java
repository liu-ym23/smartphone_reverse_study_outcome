package androidx.compose.foundation.layout;

import C7.r;
import S7.k;
import S7.n;
import S7.o;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@ExperimentalLayoutApi
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010Bk\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012!\b\u0002\u0010\f\u001a\u001b\u0012\u0004\u0012\u00020\b\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b\u0018\u00010\u0007\u0012!\b\u0002\u0010\r\u001a\u001b\u0012\u0004\u0012\u00020\b\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/layout/FlowColumnOverflow;", "Landroidx/compose/foundation/layout/FlowLayoutOverflow;", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "type", "", "minLinesToShowCollapse", "minCrossAxisSizeToShowCollapse", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "seeMoreGetter", "collapseGetter", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILS7/k;LS7/k;)V", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlowColumnOverflow extends FlowLayoutOverflow {
    public static final int $stable = 0;
    private static final FlowColumnOverflow Clip;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FlowColumnOverflow Visible;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\t2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJX\u0010\u0013\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00072\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00072\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\u00020\t8GX\u0087\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\u00020\t8GX\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u0015\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001a\u0010\u0017\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/FlowColumnOverflow$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowColumnOverflowScope;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "expandIndicator", "(LS7/o;)Landroidx/compose/foundation/layout/FlowColumnOverflow;", "collapseIndicator", "", "minColumnsToShowCollapse", "Landroidx/compose/ui/unit/Dp;", "minWidthToShowCollapse", "expandOrCollapseIndicator--jt2gSs", "(LS7/o;LS7/o;IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/layout/FlowColumnOverflow;", "expandOrCollapseIndicator", "Visible", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "getVisible", "()Landroidx/compose/foundation/layout/FlowColumnOverflow;", "getVisible$annotations", "Clip", "getClip", "getClip$annotations", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        @ExperimentalLayoutApi
        public static /* synthetic */ void getClip$annotations() {
        }

        @ExperimentalLayoutApi
        public static /* synthetic */ void getVisible$annotations() {
        }

        @ExperimentalLayoutApi
        public final FlowColumnOverflow expandIndicator(final o content) {
            return new FlowColumnOverflow(FlowLayoutOverflow.OverflowType.ExpandIndicator, 0, 0, new k() { // from class: androidx.compose.foundation.layout.FlowColumnOverflow$Companion$expandIndicator$seeMoreGetter$1
                {
                    super(1);
                }

                @Override // S7.k
                public final n invoke(final FlowLayoutOverflowState flowLayoutOverflowState) {
                    final o oVar = content;
                    return ComposableLambdaKt.composableLambdaInstance(19371081, true, new n() { // from class: androidx.compose.foundation.layout.FlowColumnOverflow$Companion$expandIndicator$seeMoreGetter$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // S7.n
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return r.f317a;
                        }

                        @Composable
                        public final void invoke(Composer composer, int i) {
                            if ((i & 3) == 2 && composer.getSkipping()) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(19371081, i, -1, "androidx.compose.foundation.layout.FlowColumnOverflow.Companion.expandIndicator.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:262)");
                            }
                            oVar.invoke(new FlowColumnOverflowScopeImpl(flowLayoutOverflowState), composer, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                }
            }, null, 22, null);
        }

        @Composable
        @ExperimentalLayoutApi
        /* renamed from: expandOrCollapseIndicator--jt2gSs, reason: not valid java name */
        public final FlowColumnOverflow m622expandOrCollapseIndicatorjt2gSs(final o oVar, final o oVar2, int i, float f, Composer composer, int i6, int i10) {
            boolean z10 = true;
            int i11 = (i10 & 4) != 0 ? 1 : i;
            if ((i10 & 8) != 0) {
                f = Dp.m6844constructorimpl(0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(972645562, i6, -1, "androidx.compose.foundation.layout.FlowColumnOverflow.Companion.expandOrCollapseIndicator (FlowLayoutOverflow.kt:304)");
            }
            int iMo375roundToPx0680j_4 = ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).mo375roundToPx0680j_4(f);
            boolean zChanged = ((((i6 & 896) ^ 384) > 256 && composer.changed(i11)) || (i6 & 384) == 256) | composer.changed(iMo375roundToPx0680j_4) | ((((i6 & 14) ^ 6) > 4 && composer.changed(oVar)) || (i6 & 6) == 4);
            if ((((i6 & 112) ^ 48) <= 32 || !composer.changed(oVar2)) && (i6 & 48) != 32) {
                z10 = false;
            }
            boolean z11 = zChanged | z10;
            Object objRememberedValue = composer.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                FlowColumnOverflow flowColumnOverflow = new FlowColumnOverflow(FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator, i11, iMo375roundToPx0680j_4, new k() { // from class: androidx.compose.foundation.layout.FlowColumnOverflow$Companion$expandOrCollapseIndicator$1$seeMoreGetter$1
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public final n invoke(final FlowLayoutOverflowState flowLayoutOverflowState) {
                        final o oVar3 = oVar;
                        return ComposableLambdaKt.composableLambdaInstance(617878374, true, new n() { // from class: androidx.compose.foundation.layout.FlowColumnOverflow$Companion$expandOrCollapseIndicator$1$seeMoreGetter$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // S7.n
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return r.f317a;
                            }

                            @Composable
                            public final void invoke(Composer composer2, int i12) {
                                if ((i12 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(617878374, i12, -1, "androidx.compose.foundation.layout.FlowColumnOverflow.Companion.expandOrCollapseIndicator.<anonymous>.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:316)");
                                }
                                oVar3.invoke(new FlowColumnOverflowScopeImpl(flowLayoutOverflowState), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                    }
                }, new k() { // from class: androidx.compose.foundation.layout.FlowColumnOverflow$Companion$expandOrCollapseIndicator$1$collapseGetter$1
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public final n invoke(final FlowLayoutOverflowState flowLayoutOverflowState) {
                        final o oVar3 = oVar2;
                        return ComposableLambdaKt.composableLambdaInstance(1004384103, true, new n() { // from class: androidx.compose.foundation.layout.FlowColumnOverflow$Companion$expandOrCollapseIndicator$1$collapseGetter$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // S7.n
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return r.f317a;
                            }

                            @Composable
                            public final void invoke(Composer composer2, int i12) {
                                if ((i12 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1004384103, i12, -1, "androidx.compose.foundation.layout.FlowColumnOverflow.Companion.expandOrCollapseIndicator.<anonymous>.<anonymous>.<anonymous> (FlowLayoutOverflow.kt:323)");
                                }
                                oVar3.invoke(new FlowColumnOverflowScopeImpl(flowLayoutOverflowState), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                    }
                }, null);
                composer.updateRememberedValue(flowColumnOverflow);
                objRememberedValue = flowColumnOverflow;
            }
            FlowColumnOverflow flowColumnOverflow2 = (FlowColumnOverflow) objRememberedValue;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return flowColumnOverflow2;
        }

        @ExperimentalLayoutApi
        public final FlowColumnOverflow getClip() {
            return FlowColumnOverflow.Clip;
        }

        @ExperimentalLayoutApi
        public final FlowColumnOverflow getVisible() {
            return FlowColumnOverflow.Visible;
        }

        private Companion() {
        }
    }

    static {
        int i = 0;
        k kVar = null;
        Visible = new FlowColumnOverflow(FlowLayoutOverflow.OverflowType.Visible, 0, i, null, kVar, 30, null);
        Clip = new FlowColumnOverflow(FlowLayoutOverflow.OverflowType.Clip, i, 0, kVar, null, 30, null);
    }

    public /* synthetic */ FlowColumnOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i6, k kVar, k kVar2, e eVar) {
        this(overflowType, i, i6, kVar, kVar2);
    }

    public /* synthetic */ FlowColumnOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i6, k kVar, k kVar2, int i10, e eVar) {
        this(overflowType, (i10 & 2) != 0 ? 0 : i, (i10 & 4) != 0 ? 0 : i6, (i10 & 8) != 0 ? null : kVar, (i10 & 16) != 0 ? null : kVar2);
    }

    private FlowColumnOverflow(FlowLayoutOverflow.OverflowType overflowType, int i, int i6, k kVar, k kVar2) {
        super(overflowType, i, i6, kVar, kVar2, null);
    }
}
