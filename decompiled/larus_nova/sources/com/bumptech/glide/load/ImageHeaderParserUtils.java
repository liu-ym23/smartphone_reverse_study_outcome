package com.bumptech.glide.load;

import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public final class ImageHeaderParserUtils {
    private static final int MARK_READ_LIMIT = 5242880;

    public interface OrientationReader {
        int getOrientation(ImageHeaderParser r100) throws IOException;
    }

    public interface TypeReader {
        ImageHeaderParser.ImageType getType(ImageHeaderParser r100) throws IOException;
    }

    private ImageHeaderParserUtils() {
    }

    private static int getOrientationInternal(List<ImageHeaderParser> r100, OrientationReader r101) throws IOException {
        int r102 = r100.size();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L9;
        int r104 = r101.getOrientation((ImageHeaderParser) ListProtector.get(r100, r103));
        if (r104 != (-1)) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        return r104;
    L9:
        return -1;
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> r100, final ByteBuffer r101) throws IOException {
        if (r101 != null) goto L6;
        return ImageHeaderParser.ImageType.UNKNOWN;
    L6:
        return getTypeInternal(r100, new AnonymousClass2(r101));
    }

    private static ImageHeaderParser.ImageType getTypeInternal(List<ImageHeaderParser> r100, TypeReader r101) throws IOException {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        ImageHeaderParser.ImageType r104 = r101.getType((ImageHeaderParser) ListProtector.get(r100, r103));
        if (r104 != ImageHeaderParser.ImageType.UNKNOWN) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static int getOrientation(List<ImageHeaderParser> r100, final InputStream r101, final ArrayPool r102) throws IOException {
        if (r101 != null) goto L6;
        return -1;
    L6:
        if (r101.markSupported() == true) goto L8;
        r101 = new RecyclableBufferedInputStream(r101, r102);
    L8:
        r101.mark(5242880);
        return getOrientationInternal(r100, new AnonymousClass4(r101, r102));
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> r100, final InputStream r101, ArrayPool r102) throws IOException {
        if (r101 != null) goto L6;
        return ImageHeaderParser.ImageType.UNKNOWN;
    L6:
        if (r101.markSupported() == true) goto L8;
        r101 = new RecyclableBufferedInputStream(r101, r102);
    L8:
        r101.mark(5242880);
        return getTypeInternal(r100, new AnonymousClass1(r101));
    }

    public static int getOrientation(List<ImageHeaderParser> r100, final ParcelFileDescriptorRewinder r101, final ArrayPool r102) throws IOException {
        return getOrientationInternal(r100, new AnonymousClass5(r101, r102));
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> r100, final ParcelFileDescriptorRewinder r101, final ArrayPool r102) throws IOException {
        return getTypeInternal(r100, new AnonymousClass3(r101, r102));
    }
}
