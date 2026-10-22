package com.bumptech.glide.load;

import D0.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);


        /* renamed from: a, reason: collision with root package name */
        private final boolean f12019a;

        ImageType(boolean z5) {
            this.f12019a = z5;
        }

        public boolean hasAlpha() {
            return this.f12019a;
        }
    }

    ImageType a(ByteBuffer byteBuffer);

    ImageType b(InputStream inputStream);

    int c(InputStream inputStream, b bVar);
}
