package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J@\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u0016H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/compose/ui/graphics/AndroidImageBitmap;", "Landroidx/compose/ui/graphics/ImageBitmap;", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "<init>", "(Landroid/graphics/Bitmap;)V", "getBitmap$ui_graphics_release", "()Landroid/graphics/Bitmap;", "width", "", "getWidth", "()I", "height", "getHeight", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getConfig-_sVssgQ", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "readPixels", "", "buffer", "", "startX", "startY", "bufferOffset", "stride", "hasAlpha", "", "getHasAlpha", "()Z", "prepareToDraw", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidImageBitmap implements ImageBitmap {
    private final Bitmap bitmap;

    @Override // androidx.compose.ui.graphics.ImageBitmap
    public ColorSpace getColorSpace() {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        Api26Bitmap r100 = Api26Bitmap.INSTANCE;
        return Api26Bitmap.composeColorSpace$ui_graphics_release(this.bitmap);
    L6:
        return ColorSpaces.INSTANCE.getSrgb();
    }

    @Override // androidx.compose.ui.graphics.ImageBitmap
    /* JADX INFO: renamed from: getConfig-_sVssgQ, reason: not valid java name */
    public int mo4692getConfig_sVssgQ() {
        Bitmap.Config r100 = this.bitmap.getConfig();
        Intrinsics.checkNotNull(r100);
        return AndroidImageBitmap_androidKt.toImageConfig(r100);
    }

    @Override // androidx.compose.ui.graphics.ImageBitmap
    public boolean getHasAlpha() {
        return this.bitmap.hasAlpha();
    }

    @Override // androidx.compose.ui.graphics.ImageBitmap
    public int getHeight() {
        return this.bitmap.getHeight();
    }

    @Override // androidx.compose.ui.graphics.ImageBitmap
    public int getWidth() {
        return this.bitmap.getWidth();
    }

    @Override // androidx.compose.ui.graphics.ImageBitmap
    public void prepareToDraw() {
        this.bitmap.prepareToDraw();
    }

    public final Bitmap getBitmap$ui_graphics_release() {
        return this.bitmap;
    }

    public AndroidImageBitmap(Bitmap r100) {
        this.bitmap = r100;
    }

    @Override // androidx.compose.ui.graphics.ImageBitmap
    public void readPixels(int[] r110, int r111, int r112, int r113, int r114, int r115, int r116) {
        Bitmap r100 = AndroidImageBitmap_androidKt.asAndroidBitmap(this);
        boolean r101 = false;
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L8:
        r100.getPixels(r110, r115, r116, r111, r112, r113, r114);
        if (r101 == false) goto L12;
        r100.recycle();
        return;
    L12:
        return;
    L5:
        if (r100.getConfig() != Bitmap.Config.HARDWARE) goto L8;
        r100 = r100.copy(Bitmap.Config.ARGB_8888, false);
        r101 = true;
        goto L8
    }
}
