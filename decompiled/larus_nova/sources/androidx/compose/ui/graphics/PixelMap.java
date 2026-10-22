package androidx.compose.ui.graphics;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ$\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u00052\b\b\u0001\u0010\u0015\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/graphics/PixelMap;", "", "buffer", "", "width", "", "height", "bufferOffset", "stride", "<init>", "([IIIII)V", "getBuffer", "()[I", "getWidth", "()I", "getHeight", "getBufferOffset", "getStride", MonitorConstants.CONNECT_TYPE_GET, "Landroidx/compose/ui/graphics/Color;", "x", "y", "get-WaAFU9c", "(II)J", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PixelMap {
    private final int[] buffer;
    private final int bufferOffset;
    private final int height;
    private final int stride;
    private final int width;

    public final int[] getBuffer() {
        return this.buffer;
    }

    public final int getBufferOffset() {
        return this.bufferOffset;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getStride() {
        return this.stride;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: get-WaAFU9c, reason: not valid java name */
    public final long m5145getWaAFU9c(int r100, int r101) {
        return ColorKt.Color(this.buffer[(this.bufferOffset + (r101 * this.stride)) + r100]);
    }

    public PixelMap(int[] r100, int r101, int r102, int r103, int r104) {
        this.buffer = r100;
        this.width = r101;
        this.height = r102;
        this.bufferOffset = r103;
        this.stride = r104;
    }
}
