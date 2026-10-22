package androidx.compose.ui.focus;

import C7.c;
import S7.k;
import S7.n;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@c
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/focus/FocusOrderModifier;", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/focus/FocusOrder;", "focusOrder", "LC7/r;", "populateFocusOrder", "(Landroidx/compose/ui/focus/FocusOrder;)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface FocusOrderModifier extends Modifier.Element {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(FocusOrderModifier focusOrderModifier, k kVar) {
            return FocusOrderModifier.super.all(kVar);
        }

        @Deprecated
        public static boolean any(FocusOrderModifier focusOrderModifier, k kVar) {
            return FocusOrderModifier.super.any(kVar);
        }

        @Deprecated
        public static <R> R foldIn(FocusOrderModifier focusOrderModifier, R r5, n nVar) {
            return (R) FocusOrderModifier.super.foldIn(r5, nVar);
        }

        @Deprecated
        public static <R> R foldOut(FocusOrderModifier focusOrderModifier, R r5, n nVar) {
            return (R) FocusOrderModifier.super.foldOut(r5, nVar);
        }

        @Deprecated
        public static Modifier then(FocusOrderModifier focusOrderModifier, Modifier modifier) {
            return FocusOrderModifier.super.then(modifier);
        }
    }

    void populateFocusOrder(FocusOrder focusOrder);
}
