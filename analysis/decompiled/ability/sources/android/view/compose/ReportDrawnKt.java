package android.view.compose;

import C7.r;
import S7.a;
import S7.k;
import S7.n;
import android.view.FullyDrawnReporter;
import android.view.FullyDrawnReporterOwner;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u000f\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\f\u001a\u00020\u00032\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlin/Function0;", "", "predicate", "LC7/r;", "ReportDrawnWhen", "(LS7/a;Landroidx/compose/runtime/Composer;I)V", "ReportDrawn", "(Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function1;", "LH7/c;", "", "block", "ReportDrawnAfter", "(LS7/k;Landroidx/compose/runtime/Composer;I)V", "activity-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ReportDrawnKt {
    @Composable
    public static final void ReportDrawn(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1357012904);
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1357012904, i, -1, "androidx.activity.compose.ReportDrawn (ReportDrawn.kt:135)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a(4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ReportDrawnWhen((a) objRememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.activity.compose.j
                @Override // S7.n
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return ReportDrawnKt.ReportDrawn$lambda$8(i, (Composer) obj, iIntValue);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ReportDrawn$lambda$7$lambda$6() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r ReportDrawn$lambda$8(int i, Composer composer, int i6) {
        ReportDrawn(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return r.f317a;
    }

    @Composable
    public static final void ReportDrawnAfter(final k kVar, Composer composer, final int i) {
        int i6;
        FullyDrawnReporter fullyDrawnReporter;
        Composer composerStartRestartGroup = composer.startRestartGroup(945311272);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(kVar) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i6 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(945311272, i6, -1, "androidx.activity.compose.ReportDrawnAfter (ReportDrawn.kt:148)");
            }
            FullyDrawnReporterOwner current = LocalFullyDrawnReporterOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
            if (current == null || (fullyDrawnReporter = current.getFullyDrawnReporter()) == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final int i10 = 0;
                    scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.activity.compose.k
                        @Override // S7.n
                        public final Object invoke(Object obj, Object obj2) {
                            int i11 = i10;
                            Composer composer2 = (Composer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            switch (i11) {
                                case 0:
                                    return ReportDrawnKt.ReportDrawnAfter$lambda$9(kVar, i, composer2, iIntValue);
                                default:
                                    return ReportDrawnKt.ReportDrawnAfter$lambda$11(kVar, i, composer2, iIntValue);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(fullyDrawnReporter) | composerStartRestartGroup.changedInstance(kVar);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new ReportDrawnKt$ReportDrawnAfter$1$1(fullyDrawnReporter, kVar, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(kVar, fullyDrawnReporter, (n) objRememberedValue, composerStartRestartGroup, i6 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            final int i11 = 1;
            scopeUpdateScopeEndRestartGroup2.updateScope(new n() { // from class: androidx.activity.compose.k
                @Override // S7.n
                public final Object invoke(Object obj, Object obj2) {
                    int i112 = i11;
                    Composer composer2 = (Composer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    switch (i112) {
                        case 0:
                            return ReportDrawnKt.ReportDrawnAfter$lambda$9(kVar, i, composer2, iIntValue);
                        default:
                            return ReportDrawnKt.ReportDrawnAfter$lambda$11(kVar, i, composer2, iIntValue);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r ReportDrawnAfter$lambda$11(k kVar, int i, Composer composer, int i6) {
        ReportDrawnAfter(kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r ReportDrawnAfter$lambda$9(k kVar, int i, Composer composer, int i6) {
        ReportDrawnAfter(kVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return r.f317a;
    }

    @Composable
    public static final void ReportDrawnWhen(final a aVar, Composer composer, int i) {
        int i6;
        final FullyDrawnReporter fullyDrawnReporter;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2047119994);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(aVar) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i6 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2047119994, i6, -1, "androidx.activity.compose.ReportDrawnWhen (ReportDrawn.kt:116)");
            }
            FullyDrawnReporterOwner current = LocalFullyDrawnReporterOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
            if (current == null || (fullyDrawnReporter = current.getFullyDrawnReporter()) == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new h(aVar, i, 0));
                    return;
                }
                return;
            }
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(fullyDrawnReporter) | ((i6 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new k() { // from class: androidx.activity.compose.i
                    @Override // S7.k
                    public final Object invoke(Object obj) {
                        return ReportDrawnKt.ReportDrawnWhen$lambda$4$lambda$3(fullyDrawnReporter, aVar, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.DisposableEffect(fullyDrawnReporter, aVar, (k) objRememberedValue, composerStartRestartGroup, (i6 << 3) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new h(aVar, i, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r ReportDrawnWhen$lambda$0(a aVar, int i, Composer composer, int i6) {
        ReportDrawnWhen(aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ReportDrawnWhen$lambda$4$lambda$3(FullyDrawnReporter fullyDrawnReporter, a aVar, DisposableEffectScope disposableEffectScope) {
        if (fullyDrawnReporter.isFullyDrawnReported()) {
            return new DisposableEffectResult() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawnWhen$lambda$4$lambda$3$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                }
            };
        }
        final ReportDrawnComposition reportDrawnComposition = new ReportDrawnComposition(fullyDrawnReporter, aVar);
        return new DisposableEffectResult() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawnWhen$lambda$4$lambda$3$$inlined$onDispose$2
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                reportDrawnComposition.removeReporter();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r ReportDrawnWhen$lambda$5(a aVar, int i, Composer composer, int i6) {
        ReportDrawnWhen(aVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return r.f317a;
    }
}
