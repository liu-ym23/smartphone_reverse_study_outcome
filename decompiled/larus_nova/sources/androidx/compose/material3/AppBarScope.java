package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\fJN\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u00102\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\u0011J9\u0010\u0012\u001a\u00020\u00032\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u00072\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0002\b\u0007H&¢\u0006\u0002\u0010\u0016\u0082\u0001\u0005\u0017\u0018\u0019\u001a\u001bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/AppBarScope;", "", "clickableItem", "", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "icon", "Landroidx/compose/runtime/Composable;", "label", "", "enabled", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Z)V", "toggleableItem", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Z)V", "customItem", "appbarContent", "menuContent", "Landroidx/compose/material3/AppBarMenuState;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "Landroidx/compose/material3/AppBarColumnScope;", "Landroidx/compose/material3/AppBarColumnScopeImpl;", "Landroidx/compose/material3/AppBarRowScope;", "Landroidx/compose/material3/AppBarRowScopeImpl;", "Landroidx/compose/material3/AppBarScopeImpl;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AppBarScope {

    /* JADX INFO: renamed from: androidx.compose.material3.AppBarScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void clickableItem$default(AppBarScope r100, Function0 r101, Function2 r102, String r103, boolean r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L6;
            r104 = true;
        L6:
            r100.clickableItem(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clickableItem");
        }

        public static /* synthetic */ void toggleableItem$default(AppBarScope r100, boolean r101, Function1 r102, Function2 r103, String r110, boolean r111, int r112, Object r113) {
            if (r113 != null) goto L10;
            if ((r112 & 16) == 0) goto L6;
            boolean r104 = true;
        L7:
            r100.toggleableItem(r101, r102, r103, r110, r104);
            return;
        L6:
            r104 = r111;
            goto L7
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toggleableItem");
        }
    }

    void clickableItem(Function0<Unit> r100, Function2<? super Composer, ? super Integer, Unit> r101, String r102, boolean r103);

    void customItem(Function2<? super Composer, ? super Integer, Unit> r100, Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit> r101);

    void toggleableItem(boolean r100, Function1<? super Boolean, Unit> r101, Function2<? super Composer, ? super Integer, Unit> r102, String r103, boolean r104);
}
