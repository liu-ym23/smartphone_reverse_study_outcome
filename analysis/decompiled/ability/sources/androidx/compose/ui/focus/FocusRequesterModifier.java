package androidx.compose.ui.focus;

import C7.c;
import S7.k;
import S7.n;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@c
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/focus/FocusRequesterModifier;", "Landroidx/compose/ui/Modifier$Element;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface FocusRequesterModifier extends Modifier.Element {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(FocusRequesterModifier focusRequesterModifier, k kVar) {
            return FocusRequesterModifier.super.all(kVar);
        }

        @Deprecated
        public static boolean any(FocusRequesterModifier focusRequesterModifier, k kVar) {
            return FocusRequesterModifier.super.any(kVar);
        }

        @Deprecated
        public static <R> R foldIn(FocusRequesterModifier focusRequesterModifier, R r5, n nVar) {
            return (R) FocusRequesterModifier.super.foldIn(r5, nVar);
        }

        @Deprecated
        public static <R> R foldOut(FocusRequesterModifier focusRequesterModifier, R r5, n nVar) {
            return (R) FocusRequesterModifier.super.foldOut(r5, nVar);
        }

        @Deprecated
        public static Modifier then(FocusRequesterModifier focusRequesterModifier, Modifier modifier) {
            return FocusRequesterModifier.super.then(modifier);
        }
    }

    FocusRequester getFocusRequester();
}
