package androidx.compose.ui.draw;

import S7.k;
import S7.n;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "LC7/r;", "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DrawModifier extends Modifier.Element {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(DrawModifier drawModifier, k kVar) {
            return DrawModifier.super.all(kVar);
        }

        @Deprecated
        public static boolean any(DrawModifier drawModifier, k kVar) {
            return DrawModifier.super.any(kVar);
        }

        @Deprecated
        public static <R> R foldIn(DrawModifier drawModifier, R r5, n nVar) {
            return (R) DrawModifier.super.foldIn(r5, nVar);
        }

        @Deprecated
        public static <R> R foldOut(DrawModifier drawModifier, R r5, n nVar) {
            return (R) DrawModifier.super.foldOut(r5, nVar);
        }

        @Deprecated
        public static Modifier then(DrawModifier drawModifier, Modifier modifier) {
            return DrawModifier.super.then(modifier);
        }
    }

    void draw(ContentDrawScope contentDrawScope);
}
