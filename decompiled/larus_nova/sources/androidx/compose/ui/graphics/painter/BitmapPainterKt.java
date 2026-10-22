package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"BitmapPainter", "Landroidx/compose/ui/graphics/painter/BitmapPainter;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "BitmapPainter-QZhYCtY", "(Landroidx/compose/ui/graphics/ImageBitmap;JJI)Landroidx/compose/ui/graphics/painter/BitmapPainter;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BitmapPainterKt {
    /* JADX INFO: renamed from: BitmapPainter-QZhYCtY, reason: not valid java name */
    public static final BitmapPainter m5532BitmapPainterQZhYCtY(ImageBitmap r100, long r101, long r110, int r111) {
        BitmapPainter r102 = new BitmapPainter(r100, r101, r110, null);
        r102.m5531setFilterQualityvDHp3xo$ui_graphics_release(r111);
        return r102;
    }

    /* JADX INFO: renamed from: BitmapPainter-QZhYCtY$default, reason: not valid java name */
    public static /* synthetic */ BitmapPainter m5533BitmapPainterQZhYCtY$default(ImageBitmap r100, long r101, long r102, int r110, int r111, Object r112) {
        if ((r111 & 2) == 0) goto L5;
        r101 = IntOffset.Companion.m7687getZeronOccac();
    L5:
        long r103 = r101;
        if ((r111 & 4) == 0) goto L8;
        int r104 = r100.getWidth();
        long r105 = ((long) r104) << 32;
        r102 = IntSize.m7714constructorimpl((((long) r100.getHeight()) & BodyPartID.bodyIdMax) | r105);
    L8:
        long r106 = r102;
        if ((r111 & 8) == 0) goto L12;
        r110 = FilterQuality.Companion.m4927getLowfv9h1I();
    L12:
        return m5532BitmapPainterQZhYCtY(r100, r103, r106, r110);
    }
}
