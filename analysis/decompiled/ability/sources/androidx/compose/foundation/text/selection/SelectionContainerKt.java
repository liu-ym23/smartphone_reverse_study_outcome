package androidx.compose.foundation.text.selection;

import C7.r;
import H4.o;
import S7.k;
import S7.n;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\u00032\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001aL\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00030\f2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0004\b\u0006\u0010\u000f¨\u0006\u0010²\u0006\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "SelectionContainer", "(Landroidx/compose/ui/Modifier;LS7/n;Landroidx/compose/runtime/Composer;II)V", "DisableSelection", "(LS7/n;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/selection/Selection;", "selection", "Lkotlin/Function1;", "onSelectionChange", "children", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/Selection;LS7/k;LS7/n;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionContainerKt {
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void DisableSelection(final n nVar, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(336063542);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(nVar) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i6 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(336063542, i6, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:67)");
            }
            CompositionLocalKt.CompositionLocalProvider(SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null), nVar, composerStartRestartGroup, ((i6 << 3) & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt.DisableSelection.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    SelectionContainerKt.DisableSelection(nVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void SelectionContainer(final Modifier modifier, n nVar, Composer composer, final int i, final int i6) {
        int i10;
        final n nVar2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1075498320);
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
        if ((i10 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            nVar2 = nVar;
        } else {
            if (i11 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1075498320, i10, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:48)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            int i12 = i10;
            Selection selectionSelectionContainer$lambda$1 = SelectionContainer$lambda$1(mutableState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new k() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Selection) obj);
                        return r.f317a;
                    }

                    public final void invoke(Selection selection) {
                        mutableState.setValue(selection);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            int i13 = (i12 & 14) | 384 | ((i12 << 6) & 7168);
            Modifier modifier2 = modifier;
            nVar2 = nVar;
            SelectionContainer(modifier2, selectionSelectionContainer$lambda$1, (k) objRememberedValue2, nVar2, composerStartRestartGroup, i13, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer.2
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
                    SelectionContainerKt.SelectionContainer(modifier, nVar2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
                }
            });
        }
    }

    private static final Selection SelectionContainer$lambda$1(MutableState<Selection> mutableState) {
        return mutableState.getValue();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void SelectionContainer(final Modifier modifier, final Selection selection, final k kVar, final n nVar, Composer composer, final int i, final int i6) {
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(2078139907);
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
            i10 |= composerStartRestartGroup.changed(selection) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i10 |= 384;
        } else if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(kVar) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i10 |= 3072;
        } else if ((i & 3072) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar) ? 2048 : 1024;
        }
        if ((i10 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i11 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2078139907, i10, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:90)");
            }
            final SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) RememberSaveableKt.m3591rememberSaveable(new Object[0], (Saver) SelectionRegistrarImpl.INSTANCE.getSaver(), (String) null, (S7.a) new S7.a() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$registrarImpl$1
                @Override // S7.a
                public final SelectionRegistrarImpl invoke() {
                    return new SelectionRegistrarImpl();
                }
            }, composerStartRestartGroup, 3072, 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new SelectionManager(selectionRegistrarImpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final SelectionManager selectionManager = (SelectionManager) objRememberedValue;
            selectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
            selectionManager.setClipboardManager((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
            selectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
            selectionManager.setOnSelectionChange(kVar);
            selectionManager.setSelection(selection);
            ContextMenu_androidKt.ContextMenuArea(selectionManager, ComposableLambdaKt.rememberComposableLambda(-123806316, true, new n() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer2, int i12) {
                    if ((i12 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-123806316, i12, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous> (SelectionContainer.kt:104)");
                    }
                    ProvidedValue<SelectionRegistrar> providedValueProvides = SelectionRegistrarKt.getLocalSelectionRegistrar().provides(selectionRegistrarImpl);
                    final Modifier modifier2 = modifier;
                    final SelectionManager selectionManager2 = selectionManager;
                    final n nVar2 = nVar;
                    CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(935424596, true, new n() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer.3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // S7.n
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return r.f317a;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(Composer composer3, int i13) {
                            if ((i13 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(935424596, i13, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:107)");
                            }
                            Modifier modifierThen = modifier2.then(selectionManager2.getModifier());
                            final n nVar3 = nVar2;
                            final SelectionManager selectionManager3 = selectionManager2;
                            SimpleLayoutKt.SimpleLayout(modifierThen, ComposableLambdaKt.rememberComposableLambda(1375295262, true, new n() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer.3.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // S7.n
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return r.f317a;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(Composer composer4, int i14) {
                                    if ((i14 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1375295262, i14, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:108)");
                                    }
                                    nVar3.invoke(composer4, 0);
                                    if (selectionManager3.isInTouchMode() && selectionManager3.getHasFocus() && !selectionManager3.isTriviallyCollapsedSelection$foundation_release()) {
                                        composer4.startReplaceGroup(-882227523);
                                        Selection selection2 = selectionManager3.getSelection();
                                        if (selection2 == null) {
                                            composer4.startReplaceGroup(-882188681);
                                        } else {
                                            composer4.startReplaceGroup(-882188680);
                                            final SelectionManager selectionManager4 = selectionManager3;
                                            composer4.startReplaceGroup(1495564482);
                                            List listN = o.N(Boolean.TRUE, Boolean.FALSE);
                                            int size = listN.size();
                                            for (int i15 = 0; i15 < size; i15++) {
                                                boolean zBooleanValue = ((Boolean) listN.get(i15)).booleanValue();
                                                boolean zChanged = composer4.changed(zBooleanValue);
                                                Object objRememberedValue2 = composer4.rememberedValue();
                                                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue2 = selectionManager4.handleDragObserver(zBooleanValue);
                                                    composer4.updateRememberedValue(objRememberedValue2);
                                                }
                                                TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue2;
                                                boolean zChanged2 = composer4.changed(zBooleanValue);
                                                Object objRememberedValue3 = composer4.rememberedValue();
                                                if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue3 = zBooleanValue ? new S7.a() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1$1$1$1$positionProvider$1$1
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // S7.a
                                                        public /* bridge */ /* synthetic */ Object invoke() {
                                                            return Offset.m3884boximpl(m1384invokeF1C5BW0());
                                                        }

                                                        /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                                                        public final long m1384invokeF1C5BW0() {
                                                            Offset offsetM1420getStartHandlePosition_m7T9E = selectionManager4.m1420getStartHandlePosition_m7T9E();
                                                            return offsetM1420getStartHandlePosition_m7T9E != null ? offsetM1420getStartHandlePosition_m7T9E.m3905unboximpl() : Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
                                                        }
                                                    } : new S7.a() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1$1$1$1$positionProvider$1$2
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // S7.a
                                                        public /* bridge */ /* synthetic */ Object invoke() {
                                                            return Offset.m3884boximpl(m1385invokeF1C5BW0());
                                                        }

                                                        /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                                                        public final long m1385invokeF1C5BW0() {
                                                            Offset offsetM1419getEndHandlePosition_m7T9E = selectionManager4.m1419getEndHandlePosition_m7T9E();
                                                            return offsetM1419getEndHandlePosition_m7T9E != null ? offsetM1419getEndHandlePosition_m7T9E.m3905unboximpl() : Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
                                                        }
                                                    };
                                                    composer4.updateRememberedValue(objRememberedValue3);
                                                }
                                                S7.a aVar = (S7.a) objRememberedValue3;
                                                ResolvedTextDirection direction = zBooleanValue ? selection2.getStart().getDirection() : selection2.getEnd().getDirection();
                                                SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 = new SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0(aVar);
                                                boolean handlesCrossed = selection2.getHandlesCrossed();
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                boolean zChangedInstance = composer4.changedInstance(textDragObserver);
                                                Object objRememberedValue4 = composer4.rememberedValue();
                                                if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue4 = new SelectionContainerKt$SelectionContainer$3$1$1$1$1$1$1(textDragObserver, null);
                                                    composer4.updateRememberedValue(objRememberedValue4);
                                                }
                                                AndroidSelectionHandles_androidKt.m1372SelectionHandlepzduO1o(selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0, zBooleanValue, direction, handlesCrossed, 0L, companion2.then(new SuspendPointerInputElement(textDragObserver, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((n) objRememberedValue4), 6, null)), composer4, 0, 16);
                                            }
                                            composer4.endReplaceGroup();
                                        }
                                        composer4.endReplaceGroup();
                                        composer4.endReplaceGroup();
                                    } else {
                                        composer4.startReplaceGroup(-880741817);
                                        composer4.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 48, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(selectionManager);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new k() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$1
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final SelectionManager selectionManager2 = selectionManager;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                selectionManager2.onRelease();
                                selectionManager2.setHasFocus(false);
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.DisposableEffect(selectionManager, (k) objRememberedValue2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i12) {
                    SelectionContainerKt.SelectionContainer(modifier2, selection, kVar, nVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
                }
            });
        }
    }
}
