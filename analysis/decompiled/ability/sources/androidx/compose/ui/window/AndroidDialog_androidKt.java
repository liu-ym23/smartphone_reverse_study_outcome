package androidx.compose.ui.window;

import C7.r;
import S7.k;
import S7.n;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a:\u0010\u0007\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a,\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0005H\u0003¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e²\u0006\u0017\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00058\nX\u008a\u0084\u0002"}, d2 = {"Lkotlin/Function0;", "LC7/r;", "onDismissRequest", "Landroidx/compose/ui/window/DialogProperties;", "properties", "Landroidx/compose/runtime/Composable;", "content", "Dialog", "(LS7/a;Landroidx/compose/ui/window/DialogProperties;LS7/n;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/Modifier;", "modifier", "DialogLayout", "(Landroidx/compose/ui/Modifier;LS7/n;Landroidx/compose/runtime/Composer;II)V", "currentContent", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidDialog_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Dialog(final S7.a r21, androidx.compose.ui.window.DialogProperties r22, final S7.n r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidDialog_androidKt.Dialog(S7.a, androidx.compose.ui.window.DialogProperties, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n Dialog$lambda$0(State<? extends n> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void DialogLayout(final Modifier modifier, final n nVar, Composer composer, final int i, final int i6) {
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(1090521195);
        int i11 = i6 & 1;
        if (i11 != 0) {
            i10 = i | 6;
        } else if ((i & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i6 & 2) != 0) {
            i10 |= 48;
        } else if ((i & 48) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i10 & 19) != 18, i10 & 1)) {
            if (i11 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1090521195, i10, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:665)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                        final ArrayList arrayList = new ArrayList(list.size());
                        int size = list.size();
                        int iM6799getMinWidthimpl = 0;
                        int iM6798getMinHeightimpl = 0;
                        for (int i12 = 0; i12 < size; i12++) {
                            Placeable placeableMo5549measureBRTryo0 = list.get(i12).mo5549measureBRTryo0(j5);
                            iM6799getMinWidthimpl = Math.max(iM6799getMinWidthimpl, placeableMo5549measureBRTryo0.getWidth());
                            iM6798getMinHeightimpl = Math.max(iM6798getMinHeightimpl, placeableMo5549measureBRTryo0.getHeight());
                            arrayList.add(placeableMo5549measureBRTryo0);
                        }
                        if (list.isEmpty()) {
                            iM6799getMinWidthimpl = Constraints.m6799getMinWidthimpl(j5);
                            iM6798getMinHeightimpl = Constraints.m6798getMinHeightimpl(j5);
                        }
                        return MeasureScope.layout$default(measureScope, iM6799getMinWidthimpl, iM6798getMinHeightimpl, null, new k() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return r.f317a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                List<Placeable> list2 = arrayList;
                                int size2 = list2.size();
                                for (int i13 = 0; i13 < size2; i13++) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, list2.get(i13), 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            int i12 = ((i10 >> 3) & 14) | 384 | ((i10 << 3) & 112);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            S7.a constructor = companion.getConstructor();
            int i13 = ((i12 << 6) & 896) | 6;
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                androidx.appfunctions.metadata.a.z(nVarG, iHashCode, composerM3474constructorimpl, iHashCode);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            if (androidx.appfunctions.metadata.a.C(nVar, composerStartRestartGroup, (i13 >> 6) & 14)) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt.DialogLayout.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i14) {
                    AndroidDialog_androidKt.DialogLayout(modifier, nVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
                }
            });
        }
    }
}
