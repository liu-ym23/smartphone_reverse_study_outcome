package androidx.compose.foundation.contextmenu;

import C7.r;
import S7.a;
import S7.n;
import S7.o;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\n\u0010\u0003J_\u0010\u0018\u001a\u00020\u00062\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u001b\b\u0002\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014¢\u0006\u0002\b\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0004\b\u0018\u0010\u0019R+\u0010\u001b\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0014¢\u0006\u0002\b\u000e0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "colors", "LC7/r;", "Content$foundation_release", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/runtime/Composer;I)V", "Content", "clear$foundation_release", "clear", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "label", "Landroidx/compose/ui/Modifier;", "modifier", "", "enabled", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Color;", "leadingIcon", "onClick", "item", "(LS7/n;Landroidx/compose/ui/Modifier;ZLS7/o;LS7/a;)V", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "composables", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextMenuScope {
    public static final int $stable = 0;
    private final SnapshotStateList<o> composables = SnapshotStateKt.mutableStateListOf();

    public static /* synthetic */ void item$default(ContextMenuScope contextMenuScope, n nVar, Modifier modifier, boolean z10, o oVar, a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        Modifier modifier2 = modifier;
        if ((i & 4) != 0) {
            z10 = true;
        }
        boolean z11 = z10;
        if ((i & 8) != 0) {
            oVar = null;
        }
        contextMenuScope.item(nVar, modifier2, z11, oVar, aVar);
    }

    @Composable
    public final void Content$foundation_release(final ContextMenuColors contextMenuColors, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1320309496);
        int i6 = (i & 6) == 0 ? (composerStartRestartGroup.changed(contextMenuColors) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1320309496, i6, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.Content (ContextMenuUi.android.kt:233)");
            }
            SnapshotStateList<o> snapshotStateList = this.composables;
            int size = snapshotStateList.size();
            for (int i10 = 0; i10 < size; i10++) {
                snapshotStateList.get(i10).invoke(contextMenuColors, composerStartRestartGroup, Integer.valueOf(i6 & 14));
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.foundation.contextmenu.ContextMenuScope$Content$2
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
                    this.$tmp0_rcvr.Content$foundation_release(contextMenuColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public final void clear$foundation_release() {
        this.composables.clear();
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public final void item(final n label, final Modifier modifier, final boolean enabled, final o leadingIcon, final a onClick) {
        this.composables.add(ComposableLambdaKt.composableLambdaInstance(262103052, true, new o() { // from class: androidx.compose.foundation.contextmenu.ContextMenuScope.item.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((ContextMenuColors) obj, (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(ContextMenuColors contextMenuColors, Composer composer, int i) {
                if ((i & 6) == 0) {
                    i |= composer.changed(contextMenuColors) ? 4 : 2;
                }
                if ((i & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(262103052, i, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.item.<anonymous> (ContextMenuUi.android.kt:275)");
                }
                String str = (String) label.invoke(composer, 0);
                if (m.s0(str)) {
                    throw new IllegalStateException("Label must not be blank");
                }
                ContextMenuUi_androidKt.ContextMenuItem(str, enabled, contextMenuColors, modifier, leadingIcon, onClick, composer, (i << 6) & 896, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }
}
