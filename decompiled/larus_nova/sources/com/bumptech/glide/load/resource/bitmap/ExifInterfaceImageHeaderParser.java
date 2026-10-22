package com.bumptech.glide.load.resource.bitmap;

import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
    public ExifInterfaceImageHeaderParser() {
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream r100) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer r100) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(InputStream r100, ArrayPool r101) throws IOException {
        int r102 = new ExifInterface(r100).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (r102 != 0) goto L6;
        return -1;
    L6:
        return r102;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(ByteBuffer r100, ArrayPool r101) throws IOException {
        return getOrientation(ByteBufferUtil.toStream(r100), r101);
    }
}
