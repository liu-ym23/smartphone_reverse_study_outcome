package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\u000b¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "invoke", "(Landroidx/compose/runtime/Composer;I)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class AppBarKt$SingleRowTopAppBar$3 extends Lambda implements n {
    final /* synthetic */ n $actionsRow;
    final /* synthetic */ boolean $centeredTitle;
    final /* synthetic */ TopAppBarColors $colors;
    final /* synthetic */ float $expandedHeight;
    final /* synthetic */ n $navigationIcon;
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;
    final /* synthetic */ n $title;
    final /* synthetic */ TextStyle $titleTextStyle;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBarKt$SingleRowTopAppBar$3(WindowInsets windowInsets, float f, TopAppBarScrollBehavior topAppBarScrollBehavior, TopAppBarColors topAppBarColors, n nVar, TextStyle textStyle, boolean z10, n nVar2, n nVar3) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$expandedHeight = f;
        this.$scrollBehavior = topAppBarScrollBehavior;
        this.$colors = topAppBarColors;
        this.$title = nVar;
        this.$titleTextStyle = textStyle;
        this.$centeredTitle = z10;
        this.$navigationIcon = nVar2;
        this.$actionsRow = nVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float invoke$lambda$1$lambda$0(TopAppBarScrollBehavior topAppBarScrollBehavior) {
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
            ComposerKt.traceEventStart(-1943739546, i, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1927)");
        }
        Modifier modifierM733heightInVpY3zN4$default = SizeKt.m733heightInVpY3zN4$default(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, this.$windowInsets)), 0.0f, this.$expandedHeight, 1, null);
        boolean zChanged = composer.changed(this.$scrollBehavior);
        TopAppBarScrollBehavior topAppBarScrollBehavior = this.$scrollBehavior;
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a(topAppBarScrollBehavior, 0);
            composer.updateRememberedValue(objRememberedValue);
        }
        ScrolledOffset scrolledOffset = (ScrolledOffset) objRememberedValue;
        long jM2627getNavigationIconContentColor0d7_KjU = this.$colors.getNavigationIconContentColor();
        long jM2629getTitleContentColor0d7_KjU = this.$colors.getTitleContentColor();
        long jM2625getActionIconContentColor0d7_KjU = this.$colors.getActionIconContentColor();
        n nVar = this.$title;
        TextStyle textStyle = this.$titleTextStyle;
        Arrangement arrangement = Arrangement.INSTANCE;
        AppBarKt.m1516TopAppBarLayoutkXwM9vE(modifierM733heightInVpY3zN4$default, scrolledOffset, jM2627getNavigationIconContentColor0d7_KjU, jM2629getTitleContentColor0d7_KjU, jM2625getActionIconContentColor0d7_KjU, nVar, textStyle, 1.0f, arrangement.getCenter(), this.$centeredTitle ? arrangement.getCenter() : arrangement.getStart(), 0, false, this.$navigationIcon, this.$actionsRow, composer, 113246208, 3126);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
