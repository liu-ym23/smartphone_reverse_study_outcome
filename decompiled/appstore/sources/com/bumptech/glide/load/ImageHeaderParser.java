package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
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
            ImageType r10 = new ImageType("GIF", 0, true);
            GIF = r10;
            ImageType r11 = new ImageType("JPEG", 1, false);
            JPEG = r11;
            ImageType r12 = new ImageType("RAW", 2, false);
            RAW = r12;
            ImageType r13 = new ImageType("PNG_A", 3, true);
            PNG_A = r13;
            ImageType r14 = new ImageType("PNG", 4, false);
            PNG = r14;
            ImageType r15 = new ImageType("WEBP_A", 5, true);
            WEBP_A = r15;
            ImageType r16 = new ImageType("WEBP", 6, false);
            WEBP = r16;
            ImageType r17 = new ImageType("UNKNOWN", 7, false);
            UNKNOWN = r17;
            $VALUES = new ImageType[]{r10, r11, r12, r13, r14, r15, r16, r17};
        }

        private ImageType(String r10, int r11, boolean r12) {
            super(r10, r11);
            this.hasAlpha = r12;
        }

        public static ImageType valueOf(String r10) {
            return (ImageType) Enum.valueOf(ImageType.class, r10);
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    int getOrientation(@NonNull InputStream r10, @NonNull ArrayPool r11) throws IOException;

    int getOrientation(@NonNull ByteBuffer r10, @NonNull ArrayPool r11) throws IOException;

    @NonNull
    ImageType getType(@NonNull InputStream r10) throws IOException;

    @NonNull
    ImageType getType(@NonNull ByteBuffer r10) throws IOException;
}
