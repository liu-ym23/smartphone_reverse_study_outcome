package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B3\u0012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\b\u0005¢\u0006\u0004\b\t\u0010\nJ\r\u0010\r\u001a\u00020\u0004H\u0017¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\u0011R\u001b\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR!\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\b\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/CustomAppBarItem;", "Landroidx/compose/material3/AppBarItem;", "appbarContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "menuContent", "Lkotlin/Function1;", "Landroidx/compose/material3/AppBarMenuState;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function3;", "AppbarContent", "(Landroidx/compose/runtime/Composer;I)V", "MenuContent", "state", "(Landroidx/compose/material3/AppBarMenuState;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CustomAppBarItem implements AppBarItem {
    public static final int $stable = 0;
    private final Function2<Composer, Integer, Unit> appbarContent;
    private final Function3<AppBarMenuState, Composer, Integer, Unit> menuContent;

    private static final Unit AppbarContent$lambda$0(CustomAppBarItem r100, int r101, Composer r102, int r103) {
        r100.AppbarContent(r102, RecomposeScopeImplKt.updateChangedFlags(r101 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit MenuContent$lambda$1(CustomAppBarItem r100, AppBarMenuState r101, int r102, Composer r103, int r104) {
        r100.MenuContent(r101, r103, RecomposeScopeImplKt.updateChangedFlags(r102 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(CustomAppBarItem r100, int r101, Composer r102, int r103) {
        return AppbarContent$lambda$0(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit b(CustomAppBarItem r100, AppBarMenuState r101, int r102, Composer r103, int r104) {
        return MenuContent$lambda$1(r100, r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomAppBarItem(Function2<? super Composer, ? super Integer, Unit> r100, Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit> r101) {
        this.appbarContent = r100;
        this.menuContent = r101;
    }

    @Override // androidx.compose.material3.AppBarItem
    public void AppbarContent(Composer r100, final int r101) {
        Composer r102 = r100.startRestartGroup(1121775917);
        if ((r101 & 6) == 0) goto L5;
        int r103 = r101;
    L11:
        if ((r103 & 3) == 2) goto L13;
        boolean r104 = true;
    L15:
        if (r102.shouldExecute(r104, r103 & 1) == true) goto L17;
        r102.skipToGroupEnd();
    L23:
        ScopeUpdateScope r105 = r102.endRestartGroup();
        if (r105 == null) goto L27;
        r105.updateScope(new i4(this, r101));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(1121775917, r103, -1, "androidx.compose.material3.CustomAppBarItem.AppbarContent (AppBarDsl.kt:228)");
    L19:
        this.appbarContent.invoke(r102, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r104 = false;
        goto L15
    L5:
        if (r102.changed(this) == false) goto L7;
        int r106 = 4;
    L8:
        r103 = r106 | r101;
        goto L11
    L7:
        r106 = 2;
        goto L8
    }

    @Override // androidx.compose.material3.AppBarItem
    public void MenuContent(final AppBarMenuState r100, Composer r101, final int r102) {
        Composer r103 = r101.startRestartGroup(-1853735176);
        if ((r102 & 6) == 0) goto L5;
        int r104 = r102;
    L11:
        if ((r102 & 48) != 0) goto L18;
        if (r103.changed(this) == false) goto L15;
        int r105 = 32;
    L16:
        r104 = r104 | r105;
        goto L18
    L15:
        r105 = 16;
    L18:
        if ((r104 & 19) == 18) goto L20;
        boolean r106 = true;
    L22:
        if (r103.shouldExecute(r106, r104 & 1) == true) goto L24;
        r103.skipToGroupEnd();
    L30:
        ScopeUpdateScope r107 = r103.endRestartGroup();
        if (r107 == null) goto L34;
        r107.updateScope(new j4(this, r100, r102));
        return;
    L34:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-1853735176, r104, -1, "androidx.compose.material3.CustomAppBarItem.MenuContent (AppBarDsl.kt:233)");
    L26:
        this.menuContent.invoke(r100, r103, Integer.valueOf(r104 & 14));
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
        goto L30
    L20:
        r106 = false;
        goto L22
    L5:
        if (r103.changed(r100) == false) goto L7;
        int r108 = 4;
    L8:
        r104 = r108 | r102;
        goto L11
    L7:
        r108 = 2;
        goto L8
    }
}
