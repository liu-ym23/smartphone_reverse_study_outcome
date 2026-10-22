package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJL\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0014H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmap;", "", "width", "", "getWidth", "()I", "height", "getHeight", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "hasAlpha", "", "getHasAlpha", "()Z", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getConfig-_sVssgQ", "readPixels", "", "buffer", "", "startX", "startY", "bufferOffset", "stride", "prepareToDraw", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ImageBitmap {
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.ImageBitmap$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            Companion r100 = ImageBitmap.Companion;
        }

        public static /* synthetic */ void readPixels$default(ImageBitmap r100, int[] r101, int r102, int r103, int r110, int r111, int r112, int r113, int r114, Object r115) {
            if (r115 != null) goto L30;
            int r104 = 0;
            if ((r114 & 2) == 0) goto L6;
            int r105 = 0;
        L8:
            if ((r114 & 4) == 0) goto L10;
            int r106 = 0;
        L12:
            if ((r114 & 8) == 0) goto L14;
            int r107 = r100.getWidth();
        L16:
            if ((r114 & 16) == 0) goto L18;
            int r108 = r100.getHeight();
        L20:
            if ((r114 & 32) != 0) goto L24;
            r104 = r112;
        L24:
            if ((r114 & 64) == 0) goto L26;
            int r109 = r107;
        L27:
            r100.readPixels(r101, r105, r106, r107, r108, r104, r109);
            return;
        L26:
            r109 = r113;
            goto L27
        L18:
            r108 = r111;
            goto L20
        L14:
            r107 = r110;
            goto L16
        L10:
            r106 = r103;
            goto L12
        L6:
            r105 = r102;
            goto L8
        L30:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readPixels");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/graphics/ImageBitmap$Companion;", "", "<init>", "()V", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void readPixels$default(ImageBitmap r100, int[] r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, Object r109) {
            CC.readPixels$default(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    ColorSpace getColorSpace();

    /* JADX INFO: renamed from: getConfig-_sVssgQ */
    int mo4692getConfig_sVssgQ();

    boolean getHasAlpha();

    int getHeight();

    int getWidth();

    void prepareToDraw();

    void readPixels(int[] r100, int r101, int r102, int r103, int r104, int r105, int r106);
}
