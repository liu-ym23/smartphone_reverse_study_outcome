package androidx.compose.foundation.text;

import C7.r;
import S7.n;
import android.content.res.Resources;
import androidx.compose.foundation.contextmenu.ContextMenuArea_androidKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a*\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a2\u0010\u0006\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0004\b\u0006\u0010\f\u001a*\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\r2\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0004\b\u0006\u0010\u000e\u001a<\u0010\u0015\u001a\u00020\u0003*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0080\b¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "manager", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "ContextMenuArea", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;LS7/n;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "selectionState", "", "enabled", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;ZLS7/n;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/selection/SelectionManager;", "(Landroidx/compose/foundation/text/selection/SelectionManager;LS7/n;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "state", "Landroidx/compose/foundation/text/TextContextMenuItems;", "label", "operation", "TextItem", "(Landroidx/compose/foundation/contextmenu/ContextMenuScope;Landroidx/compose/foundation/contextmenu/ContextMenuState;Landroidx/compose/foundation/text/TextContextMenuItems;ZLS7/a;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextMenu_androidKt {

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements n {
        final /* synthetic */ TextContextMenuItems $label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TextContextMenuItems textContextMenuItems) {
            super(2);
            this.$label = textContextMenuItems;
        }

        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((Composer) obj, ((Number) obj2).intValue());
        }

        @Composable
        public final String invoke(Composer composer, int i) throws Resources.NotFoundException {
            composer.startReplaceGroup(-1451087197);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1451087197, i, -1, "androidx.compose.foundation.text.TextItem.<anonymous> (ContextMenu.android.kt:98)");
            }
            String strResolvedString = this.$label.resolvedString(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return strResolvedString;
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void ContextMenuArea(final TextFieldSelectionManager textFieldSelectionManager, n nVar, Composer composer, final int i) {
        int i6;
        final n nVar2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1985516685);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            nVar2 = nVar;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1985516685, i6, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:35)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new ContextMenuState(null, 1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ContextMenuState contextMenuState = (ContextMenuState) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new S7.a() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$1$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1016invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1016invoke() {
                        ContextMenuState_androidKt.close(contextMenuState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            nVar2 = nVar;
            ContextMenuArea_androidKt.ContextMenuArea(contextMenuState, (S7.a) objRememberedValue2, TextFieldSelectionManager_androidKt.contextMenuBuilder(textFieldSelectionManager, contextMenuState), null, textFieldSelectionManager.getEnabled(), nVar2, composerStartRestartGroup, ((i6 << 12) & 458752) | 54, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt.ContextMenuArea.2
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
                    ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, nVar2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void TextItem(ContextMenuScope contextMenuScope, final ContextMenuState contextMenuState, TextContextMenuItems textContextMenuItems, boolean z10, final S7.a aVar) {
        ContextMenuScope.item$default(contextMenuScope, new AnonymousClass1(textContextMenuItems), null, z10, null, new S7.a() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt.TextItem.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m1019invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1019invoke() {
                aVar.invoke();
                ContextMenuState_androidKt.close(contextMenuState);
            }
        }, 10, null);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void ContextMenuArea(final TextFieldSelectionState textFieldSelectionState, boolean z10, n nVar, Composer composer, final int i) {
        int i6;
        final boolean z11;
        final n nVar2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2103477555);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(z10) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            z11 = z10;
            nVar2 = nVar;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2103477555, i6, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:51)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new ContextMenuState(null, 1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ContextMenuState contextMenuState = (ContextMenuState) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new S7.a() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$3$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1017invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1017invoke() {
                        ContextMenuState_androidKt.close(contextMenuState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            int i10 = i6 << 9;
            z11 = z10;
            nVar2 = nVar;
            ContextMenuArea_androidKt.ContextMenuArea(contextMenuState, (S7.a) objRememberedValue2, TextFieldSelectionState_androidKt.contextMenuBuilder(textFieldSelectionState, contextMenuState), null, z11, nVar2, composerStartRestartGroup, (57344 & i10) | 54 | (i10 & 458752), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt.ContextMenuArea.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i11) {
                    ContextMenu_androidKt.ContextMenuArea(textFieldSelectionState, z11, nVar2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void ContextMenuArea(final SelectionManager selectionManager, n nVar, Composer composer, final int i) {
        int i6;
        final n nVar2;
        Composer composerStartRestartGroup = composer.startRestartGroup(605522716);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(selectionManager) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            nVar2 = nVar;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(605522716, i6, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:66)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new ContextMenuState(null, 1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ContextMenuState contextMenuState = (ContextMenuState) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new S7.a() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$5$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1018invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1018invoke() {
                        ContextMenuState_androidKt.close(contextMenuState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            nVar2 = nVar;
            ContextMenuArea_androidKt.ContextMenuArea(contextMenuState, (S7.a) objRememberedValue2, SelectionManager_androidKt.contextMenuBuilder(selectionManager, contextMenuState), null, false, nVar2, composerStartRestartGroup, ((i6 << 12) & 458752) | 54, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt.ContextMenuArea.6
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
                    ContextMenu_androidKt.ContextMenuArea(selectionManager, nVar2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
