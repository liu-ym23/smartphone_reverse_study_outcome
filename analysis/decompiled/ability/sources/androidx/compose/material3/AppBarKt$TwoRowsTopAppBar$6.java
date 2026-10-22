package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\u000b¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "invoke", "(Landroidx/compose/runtime/Composer;I)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class AppBarKt$TwoRowsTopAppBar$6 extends Lambda implements n {
    final /* synthetic */ n $actionsRow;
    final /* synthetic */ float $bottomTitleAlpha;
    final /* synthetic */ float $collapsedHeight;
    final /* synthetic */ TopAppBarColors $colors;
    final /* synthetic */ float $expandedHeight;
    final /* synthetic */ boolean $hideBottomRowSemantics;
    final /* synthetic */ boolean $hideTopRowSemantics;
    final /* synthetic */ n $navigationIcon;
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;
    final /* synthetic */ n $smallTitle;
    final /* synthetic */ TextStyle $smallTitleTextStyle;
    final /* synthetic */ n $title;
    final /* synthetic */ Ref$IntRef $titleBottomPaddingPx;
    final /* synthetic */ TextStyle $titleTextStyle;
    final /* synthetic */ float $topTitleAlpha;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBarKt$TwoRowsTopAppBar$6(WindowInsets windowInsets, float f, TopAppBarColors topAppBarColors, n nVar, TextStyle textStyle, float f7, boolean z10, n nVar2, n nVar3, float f9, TopAppBarScrollBehavior topAppBarScrollBehavior, n nVar4, TextStyle textStyle2, float f10, Ref$IntRef ref$IntRef, boolean z11) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$collapsedHeight = f;
        this.$colors = topAppBarColors;
        this.$smallTitle = nVar;
        this.$smallTitleTextStyle = textStyle;
        this.$topTitleAlpha = f7;
        this.$hideTopRowSemantics = z10;
        this.$navigationIcon = nVar2;
        this.$actionsRow = nVar3;
        this.$expandedHeight = f9;
        this.$scrollBehavior = topAppBarScrollBehavior;
        this.$title = nVar4;
        this.$titleTextStyle = textStyle2;
        this.$bottomTitleAlpha = f10;
        this.$titleBottomPaddingPx = ref$IntRef;
        this.$hideBottomRowSemantics = z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$3$lambda$0() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$3$lambda$2$lambda$1(TopAppBarScrollBehavior topAppBarScrollBehavior) {
        TopAppBarState state;
        if (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) {
            return 0.0f;
        }
        return state.getHeightOffset();
    }

    @Override // S7.n
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return r.f317a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(Composer composer, int i) {
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1350062619, i, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:2043)");
        }
        WindowInsets windowInsets = this.$windowInsets;
        float f = this.$collapsedHeight;
        TopAppBarColors topAppBarColors = this.$colors;
        n nVar = this.$smallTitle;
        TextStyle textStyle = this.$smallTitleTextStyle;
        float f7 = this.$topTitleAlpha;
        boolean z10 = this.$hideTopRowSemantics;
        n nVar2 = this.$navigationIcon;
        n nVar3 = this.$actionsRow;
        float f9 = this.$expandedHeight;
        TopAppBarScrollBehavior topAppBarScrollBehavior = this.$scrollBehavior;
        n nVar4 = this.$title;
        TextStyle textStyle2 = this.$titleTextStyle;
        float f10 = this.$bottomTitleAlpha;
        Ref$IntRef ref$IntRef = this.$titleBottomPaddingPx;
        boolean z11 = this.$hideBottomRowSemantics;
        Modifier.Companion companion = Modifier.INSTANCE;
        Arrangement arrangement = Arrangement.INSTANCE;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        S7.a constructor = companion2.getConstructor();
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
        n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, measurePolicyColumnMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
        if (composerM3474constructorimpl.getInserting() || !k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
        }
        Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        AppBarKt.m1516TopAppBarLayoutkXwM9vE(SizeKt.m733heightInVpY3zN4$default(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(companion, windowInsets)), 0.0f, f, 1, null), new b(), topAppBarColors.getNavigationIconContentColor(), topAppBarColors.getTitleContentColor(), topAppBarColors.getActionIconContentColor(), nVar, textStyle, f7, arrangement.getCenter(), arrangement.getStart(), 0, z10, nVar2, nVar3, composer, 905969712, 3078);
        int i6 = 1;
        Modifier modifierM733heightInVpY3zN4$default = SizeKt.m733heightInVpY3zN4$default(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(companion, WindowInsetsKt.m771onlybOOhFvg(windowInsets, WindowInsetsSides.INSTANCE.m793getHorizontalJoeWqyM()))), 0.0f, Dp.m6844constructorimpl(f9 - f), 1, null);
        boolean zChanged = composer.changed(topAppBarScrollBehavior);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a(topAppBarScrollBehavior, i6);
            composer.updateRememberedValue(objRememberedValue);
        }
        long jM2627getNavigationIconContentColor0d7_KjU = topAppBarColors.getNavigationIconContentColor();
        long jM2629getTitleContentColor0d7_KjU = topAppBarColors.getTitleContentColor();
        long jM2625getActionIconContentColor0d7_KjU = topAppBarColors.getActionIconContentColor();
        Arrangement.Vertical bottom = arrangement.getBottom();
        Arrangement.Horizontal start = arrangement.getStart();
        int i10 = ref$IntRef.f4918a;
        ComposableSingletons$AppBarKt composableSingletons$AppBarKt = ComposableSingletons$AppBarKt.INSTANCE;
        AppBarKt.m1516TopAppBarLayoutkXwM9vE(modifierM733heightInVpY3zN4$default, (ScrolledOffset) objRememberedValue, jM2627getNavigationIconContentColor0d7_KjU, jM2629getTitleContentColor0d7_KjU, jM2625getActionIconContentColor0d7_KjU, nVar4, textStyle2, f10, bottom, start, i10, z11, composableSingletons$AppBarKt.m1693getLambda17$material3_release(), composableSingletons$AppBarKt.m1694getLambda18$material3_release(), composer, 905969664, 3456);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
