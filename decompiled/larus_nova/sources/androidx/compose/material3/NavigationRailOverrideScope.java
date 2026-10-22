package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u0001Bi\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R+\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR)\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\b\f¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/NavigationRailOverrideScope;", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "<init>", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getModifier", "()Landroidx/compose/ui/Modifier;", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getHeader", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getWindowInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "getContent", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationRailOverrideScope {
    public static final int $stable = 0;
    private final long containerColor;
    private final Function3<ColumnScope, Composer, Integer, Unit> content;
    private final long contentColor;
    private final Function3<ColumnScope, Composer, Integer, Unit> header;
    private final Modifier modifier;
    private final WindowInsets windowInsets;

    public /* synthetic */ NavigationRailOverrideScope(Modifier r100, long r101, long r102, Function3 r103, WindowInsets r104, Function3 r105, DefaultConstructorMarker r106) {
        this(r100, r101, r102, r103, r104, r105);
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m2482getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name */
    public final long m2483getContentColor0d7_KjU() {
        return this.contentColor;
    }

    public final Function3<ColumnScope, Composer, Integer, Unit> getHeader() {
        return this.header;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final WindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private NavigationRailOverrideScope(Modifier r100, long r101, long r102, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r103, WindowInsets r104, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r105) {
        this.modifier = r100;
        this.containerColor = r101;
        this.contentColor = r102;
        this.header = r103;
        this.windowInsets = r104;
        this.content = r105;
    }

    public /* synthetic */ NavigationRailOverrideScope(Modifier r110, long r111, long r112, Function3 r113, WindowInsets r114, Function3 r115, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        Modifier r100 = Modifier.Companion;
    L6:
        this(r100, r111, r112, r113, r114, r115, null);
        return;
    L5:
        r100 = r110;
        goto L6
    }
}
