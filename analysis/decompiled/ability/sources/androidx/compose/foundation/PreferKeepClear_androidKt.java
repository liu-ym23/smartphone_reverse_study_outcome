package androidx.compose.foundation;

import S7.k;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a%\u0010\u0001\u001a\u00020\u0000*\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0001\u0010\u0007\u001a(\u0010\t\u001a\u00020\u00002\u0016\b\b\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\u0083\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/Modifier;", "preferKeepClear", "(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "rectProvider", "(Landroidx/compose/ui/Modifier;LS7/k;)Landroidx/compose/ui/Modifier;", "rect", "preferKeepClearT", "(LS7/k;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PreferKeepClear_androidKt {
    public static final Modifier preferKeepClear(Modifier modifier) {
        return modifier.then(new PreferKeepClearElement(null));
    }

    @RequiresApi(33)
    private static final Modifier preferKeepClearT(k kVar) {
        return new PreferKeepClearElement(kVar);
    }

    public static final Modifier preferKeepClear(Modifier modifier, k kVar) {
        return modifier.then(new PreferKeepClearElement(kVar));
    }
}
