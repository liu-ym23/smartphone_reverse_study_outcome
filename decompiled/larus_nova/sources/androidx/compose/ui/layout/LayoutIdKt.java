package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"layoutId", "Landroidx/compose/ui/Modifier;", "", "Landroidx/compose/ui/layout/Measurable;", "getLayoutId", "(Landroidx/compose/ui/layout/Measurable;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LayoutIdKt {
    public static final Object getLayoutId(Measurable r100) {
        Object r101 = r100.getParentData();
        if ((r101 instanceof LayoutIdParentData) == false) goto L5;
        LayoutIdParentData r102 = (LayoutIdParentData) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getLayoutId();
    L5:
        r102 = null;
        goto L6
    }

    public static final Modifier layoutId(Modifier r100, Object r101) {
        return r100.then(new LayoutIdElement(r101));
    }
}
