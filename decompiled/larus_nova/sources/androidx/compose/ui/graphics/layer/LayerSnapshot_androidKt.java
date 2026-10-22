package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap;
import android.media.Image;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/media/Image;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LayerSnapshot_androidKt {
    public static final /* synthetic */ Bitmap access$toBitmap(Image r100) {
        return toBitmap(r100);
    }

    private static final Bitmap toBitmap(Image r100) {
        Image.Plane[] r101 = r100.getPlanes();
        Intrinsics.checkNotNull(r101);
        int r102 = 0;
        Image.Plane r103 = r101[0];
        int r104 = r100.getWidth() * r100.getHeight();
        int[] r105 = new int[r104];
        r103.getBuffer().asIntBuffer().get(r105);
    L3:
        if (r102 >= r104) goto L6;
        int r106 = r105[r102];
        r105[r102] = ColorKt.m4881toArgb8_81llA(ColorKt.Color(r106 & 255, (r106 >> 8) & 255, (r106 >> 16) & 255, (r106 >> 24) & 255));
        r102 = r102 + 1;
        goto L3
    L6:
        return Bitmap.createBitmap(r105, r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
    }
}
