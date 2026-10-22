package com.bumptech.glide.load;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface ImageHeaderParser {

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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f3348a;

        public static ImageType valueOf(String r2) {
            return (ImageType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ImageType.class, r2), ImageType.class, "com.obric.aiagent.plugin");
        }

        public static ImageType[] values() {
            return (ImageType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ImageType[].class, "com.obric.aiagent.plugin");
        }

        static {
            ImageType r0 = new ImageType("GIF", 0, true);
            GIF = r0;
            ImageType r1 = new ImageType("JPEG", 1, false);
            JPEG = r1;
            ImageType r4 = new ImageType("RAW", 2, false);
            RAW = r4;
            ImageType r5 = new ImageType("PNG_A", 3, true);
            PNG_A = r5;
            ImageType r7 = new ImageType("PNG", 4, false);
            PNG = r7;
            ImageType r9 = new ImageType("WEBP_A", 5, true);
            WEBP_A = r9;
            ImageType r11 = new ImageType("WEBP", 6, false);
            WEBP = r11;
            ImageType r13 = new ImageType("UNKNOWN", 7, false);
            UNKNOWN = r13;
            $VALUES = new ImageType[]{r0, r1, r4, r5, r7, r9, r11, r13};
        }

        private ImageType(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.f3348a = r3;
        }

        public boolean hasAlpha() {
            return this.f3348a;
        }
    }

    int a(InputStream r1, com.bumptech.glide.load.engine.a.b r2);

    ImageType getType(InputStream r1);

    ImageType getType(ByteBuffer r1);
}
