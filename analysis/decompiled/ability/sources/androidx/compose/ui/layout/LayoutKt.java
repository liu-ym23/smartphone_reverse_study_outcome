package androidx.compose.ui.layout;

import C7.c;
import C7.r;
import S7.a;
import S7.n;
import S7.o;
import androidx.compose.foundation.b;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u001a:\u0010\t\u001a\u00020\u00012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0002¢\u0006\u0002\b\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0087\b¢\u0006\u0004\b\t\u0010\u000b\u001a@\u0010\t\u001a\u00020\u00012\u001c\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0002¢\u0006\u0002\b\u00030\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\t\u0010\u000f\u001a=\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0002¢\u0006\u0002\b\u00032\u001c\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0002¢\u0006\u0002\b\u00030\fH\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a.\u0010\u0017\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a.\u0010\u0018\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0017\u0010\u0016\u001a9\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0002¢\u0006\u0002\b\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u001c\u001a\u00020\u001b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "content", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "Layout", "(LS7/n;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "", "contents", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MultiContentMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "combineAsVirtualLayouts", "(Ljava/util/List;)LS7/n;", "Lkotlin/Function1;", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "modifierMaterializerOf", "(Landroidx/compose/ui/Modifier;)LS7/o;", "materializerOf", "materializerOfWithCompositionLocalInjection", "MultiMeasureLayout", "(Landroidx/compose/ui/Modifier;LS7/n;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "", "LargeDimension", "I", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutKt {
    public static final int LargeDimension = 32767;

    @Composable
    @UiComposable
    public static final void Layout(n nVar, Modifier modifier, MeasurePolicy measurePolicy, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        a constructor = companion.getConstructor();
        int i10 = ((i << 6) & 896) | 6;
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer);
        n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
        if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
            androidx.appfunctions.metadata.a.z(nVarG, iHashCode, composerM3474constructorimpl, iHashCode);
        }
        Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
        b.A(nVar, composer, (i10 >> 6) & 14);
    }

    @c
    @Composable
    @UiComposable
    public static final void MultiMeasureLayout(Modifier modifier, final n nVar, final MeasurePolicy measurePolicy, Composer composer, final int i, final int i6) {
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1663319424);
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
        if ((i6 & 4) != 0) {
            i10 |= 384;
        } else if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changed(measurePolicy) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i10 & 147) != 146, i10 & 1)) {
            if (i11 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1663319424, i10, -1, "androidx.compose.ui.layout.MultiMeasureLayout (Layout.kt:238)");
            }
            int iHashCode = Integer.hashCode(ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0));
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            a constructor$ui_release = LayoutNode.INSTANCE.getConstructor$ui_release();
            int i12 = ((i10 << 3) & 896) | 6;
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor$ui_release);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composerStartRestartGroup);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Updater.m3481setimpl(composerM3474constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m3481setimpl(composerM3474constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m3478initimpl(composerM3474constructorimpl, new S7.k() { // from class: androidx.compose.ui.layout.LayoutKt$MultiMeasureLayout$1$1
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((LayoutNode) obj);
                    return r.f317a;
                }

                public final void invoke(LayoutNode layoutNode) {
                    layoutNode.setCanMultiMeasure$ui_release(true);
                }
            });
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            n setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                androidx.appfunctions.metadata.a.z(setCompositeKeyHash, iHashCode, composerM3474constructorimpl, iHashCode);
            }
            if (androidx.appfunctions.metadata.a.C(nVar, composerStartRestartGroup, (i12 >> 6) & 14)) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i13) {
                    LayoutKt.MultiMeasureLayout(modifier2, nVar, measurePolicy, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
                }
            });
        }
    }

    public static final n combineAsVirtualLayouts(final List<? extends n> list) {
        return ComposableLambdaKt.composableLambdaInstance(1271844412, true, new n() { // from class: androidx.compose.ui.layout.LayoutKt.combineAsVirtualLayouts.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
            public final void invoke(Composer composer, int i) {
                if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1271844412, i, -1, "androidx.compose.ui.layout.combineAsVirtualLayouts.<anonymous> (Layout.kt:177)");
                }
                List<n> list2 = list;
                int size = list2.size();
                for (int i6 = 0; i6 < size; i6++) {
                    n nVar = list2.get(i6);
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    a virtualConstructor = companion.getVirtualConstructor();
                    if (composer.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(virtualConstructor);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer);
                    n setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                        androidx.appfunctions.metadata.a.z(setCompositeKeyHash, iHashCode, composerM3474constructorimpl, iHashCode);
                    }
                    nVar.invoke(composer, 0);
                    composer.endNode();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @c
    public static final o materializerOf(final Modifier modifier) {
        return ComposableLambdaKt.composableLambdaInstance(-2123382363, true, new o() { // from class: androidx.compose.ui.layout.LayoutKt$materializerOfWithCompositionLocalInjection$1
            {
                super(3);
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                m5574invokeDeg8D_g(((SkippableUpdater) obj).getComposer(), (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @Composable
            /* renamed from: invoke-Deg8D_g, reason: not valid java name */
            public final void m5574invokeDeg8D_g(Composer composer, Composer composer2, int i) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2123382363, i, -1, "androidx.compose.ui.layout.materializerOfWithCompositionLocalInjection.<anonymous> (Layout.kt:219)");
                }
                int iHashCode = Integer.hashCode(ComposablesKt.getCurrentCompositeKeyHash(composer2, 0));
                Modifier modifierMaterializeWithCompositionLocalInjectionInternal = ComposedModifierKt.materializeWithCompositionLocalInjectionInternal(composer2, modifier);
                composer.startReplaceableGroup(509942095);
                Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeWithCompositionLocalInjectionInternal, companion.getSetModifier());
                n setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                    androidx.appfunctions.metadata.a.z(setCompositeKeyHash, iHashCode, composerM3474constructorimpl, iHashCode);
                }
                composer.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    public static final o modifierMaterializerOf(final Modifier modifier) {
        return ComposableLambdaKt.composableLambdaInstance(-511438721, true, new o() { // from class: androidx.compose.ui.layout.LayoutKt.materializerOf.1
            {
                super(3);
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                m5573invokeDeg8D_g(((SkippableUpdater) obj).getComposer(), (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @Composable
            /* renamed from: invoke-Deg8D_g, reason: not valid java name */
            public final void m5573invokeDeg8D_g(Composer composer, Composer composer2, int i) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-511438721, i, -1, "androidx.compose.ui.layout.materializerOf.<anonymous> (Layout.kt:197)");
                }
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifier);
                composer.startReplaceableGroup(509942095);
                Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
                n setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                    androidx.appfunctions.metadata.a.z(setCompositeKeyHash, iHashCode, composerM3474constructorimpl, iHashCode);
                }
                composer.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @Composable
    @UiComposable
    public static final void Layout(Modifier modifier, MeasurePolicy measurePolicy, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        a constructor = companion.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer);
        Updater.m3481setimpl(composerM3474constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
        Updater.m3481setimpl(composerM3474constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
        n setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
            androidx.appfunctions.metadata.a.z(setCompositeKeyHash, iHashCode, composerM3474constructorimpl, iHashCode);
        }
        composer.endNode();
    }

    @Composable
    @UiComposable
    public static final void Layout(List<? extends n> list, Modifier modifier, MultiContentMeasurePolicy multiContentMeasurePolicy, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        n nVarCombineAsVirtualLayouts = combineAsVirtualLayouts(list);
        boolean z10 = (((i & 896) ^ 384) > 256 && composer.changed(multiContentMeasurePolicy)) || (i & 384) == 256;
        Object objRememberedValue = composer.rememberedValue();
        if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
            composer.updateRememberedValue(objRememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        a constructor = companion.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer);
        n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
        if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
            androidx.appfunctions.metadata.a.z(nVarG, iHashCode, composerM3474constructorimpl, iHashCode);
        }
        Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
        nVarCombineAsVirtualLayouts.invoke(composer, 0);
        composer.endNode();
    }
}
