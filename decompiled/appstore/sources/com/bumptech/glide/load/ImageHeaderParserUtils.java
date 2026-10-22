package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ImageHeaderParserUtils {
    private static final int MARK_POSITION = 5242880;

    private ImageHeaderParserUtils() {
    }

    public static int getOrientation(@NonNull List<ImageHeaderParser> r10, @Nullable InputStream r11, @NonNull ArrayPool r12) throws IOException {
        if (r11 != null) goto L6;
        return -1;
    L6:
        if (r11.markSupported() == true) goto L8;
        r11 = new RecyclableBufferedInputStream(r11, r12);
    L8:
        r11.mark(MARK_POSITION);
        int r13 = r10.size();
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L19;
        int r15 = r10.get(r14).getOrientation(r11, r12);     // Catch: Throwable -> L16
        if (r15 != (-1)) goto L13;
        r11.reset();
        r14 = r14 + 1;
        goto L9
    L13:
        r11.reset();
        return r15;
    L16:
        th = move-exception;
        r11.reset();
        throw th;
    L19:
        return -1;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> r10, @Nullable InputStream r11, @NonNull ArrayPool r12) throws IOException {
        if (r11 != null) goto L6;
        return ImageHeaderParser.ImageType.UNKNOWN;
    L6:
        if (r11.markSupported() == true) goto L8;
        r11 = new RecyclableBufferedInputStream(r11, r12);
    L8:
        r11.mark(MARK_POSITION);
        int r13 = r10.size();
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L20;
        ImageHeaderParser.ImageType r15 = r10.get(r14).getType(r11);     // Catch: Throwable -> L16
        if (r15 != ImageHeaderParser.ImageType.UNKNOWN) goto L13;
        r11.reset();
        r14 = r14 + 1;
        goto L9
    L13:
        r11.reset();
        return r15;
    L16:
        th = move-exception;
        r11.reset();
        throw th;
    L20:
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> r10, @Nullable ByteBuffer r11) throws IOException {
        if (r11 == null) goto L4;
        int r12 = r10.size();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L12;
        ImageHeaderParser.ImageType r14 = r10.get(r13).getType(r11);
        if (r14 != ImageHeaderParser.ImageType.UNKNOWN) goto L9;
        r13 = r13 + 1;
        goto L6
    L9:
        return r14;
    L12:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L4:
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
