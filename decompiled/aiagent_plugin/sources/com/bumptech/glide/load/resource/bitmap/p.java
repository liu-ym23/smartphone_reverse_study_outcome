package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.ImageHeaderParser;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ExifInterfaceImageHeaderParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class p implements ImageHeaderParser {
    public p() {
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream r1) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer r1) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(InputStream r2, com.bumptech.glide.load.engine.a.b r3) {
        com.bumptech.glide.load.engine.a.b r1 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        int r4 = new androidx.exifinterface.media.a(r2).a("Orientation", 1);
        if (r4 != 0) goto L6;
        return -1;
    L6:
        return r4;
    }
}
