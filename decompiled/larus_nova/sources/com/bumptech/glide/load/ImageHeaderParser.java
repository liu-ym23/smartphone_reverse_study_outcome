package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public interface ImageHeaderParser {
    public static final int UNKNOWN_ORIENTATION = -1;

    public static final enum ImageType extends Enum<ImageType> {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ImageType GIF = null;
        public static final ImageType JPEG = null;
        public static final ImageType PNG = null;
        public static final ImageType PNG_A = null;
        public static final ImageType RAW = null;
        public static final ImageType UNKNOWN = null;
        public static final ImageType WEBP = null;
        public static final ImageType WEBP_A = null;
        private final boolean hasAlpha;

        static {
            ImageType r100 = new ImageType("GIF", 0, true);
            GIF = r100;
            ImageType r101 = new ImageType("JPEG", 1, false);
            JPEG = r101;
            ImageType r102 = new ImageType("RAW", 2, false);
            RAW = r102;
            ImageType r103 = new ImageType("PNG_A", 3, true);
            PNG_A = r103;
            ImageType r104 = new ImageType("PNG", 4, false);
            PNG = r104;
            ImageType r105 = new ImageType("WEBP_A", 5, true);
            WEBP_A = r105;
            ImageType r110 = new ImageType("WEBP", 6, false);
            WEBP = r110;
            ImageType r111 = new ImageType("UNKNOWN", 7, false);
            UNKNOWN = r111;
            $VALUES = new ImageType[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public static ImageType valueOf(String r100) {
            return (ImageType) a.a(ImageType.class, r100);
        }

        private ImageType(String r100, int r101, boolean r102) {
            super(r100, r101);
            this.hasAlpha = r102;
        }
    }

    int getOrientation(InputStream r100, ArrayPool r101) throws IOException;

    int getOrientation(ByteBuffer r100, ArrayPool r101) throws IOException;

    ImageType getType(InputStream r100) throws IOException;

    ImageType getType(ByteBuffer r100) throws IOException;
}
