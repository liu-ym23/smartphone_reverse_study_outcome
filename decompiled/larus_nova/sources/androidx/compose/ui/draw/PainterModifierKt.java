package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"paint", "Landroidx/compose/ui/Modifier;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PainterModifierKt {
    public static final Modifier paint(Modifier r100, Painter r101, boolean r110, Alignment r111, ContentScale r112, float r113, ColorFilter r114) {
        return r100.then(new PainterElement(r101, r110, r111, r112, r113, r114));
    }

    public static /* synthetic */ Modifier paint$default(Modifier r100, Painter r101, boolean r102, Alignment r110, ContentScale r111, float r112, ColorFilter r113, int r114, Object r115) {
        if ((r114 & 2) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r114 & 4) == 0) goto L9;
        r110 = Alignment.Companion.getCenter();
    L9:
        Alignment r104 = r110;
        if ((r114 & 8) == 0) goto L12;
        r111 = ContentScale.Companion.getInside();
    L12:
        ContentScale r105 = r111;
        if ((r114 & 16) == 0) goto L15;
        float r106 = 1.0f;
    L17:
        if ((r114 & 32) == 0) goto L20;
        r113 = null;
    L20:
        return paint(r100, r101, r103, r104, r105, r106, r113);
    L15:
        r106 = r112;
        goto L17
    L5:
        r103 = r102;
        goto L7
    }
}
