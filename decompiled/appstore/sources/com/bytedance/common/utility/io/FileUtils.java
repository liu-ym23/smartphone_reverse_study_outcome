package com.bytedance.common.utility.io;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes.dex */
public abstract class FileUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f6859a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f6860b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f6861c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f6862d = null;

    public static final enum ImageType extends Enum<ImageType> {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ImageType GIF = null;
        public static final ImageType JPG = null;
        public static final ImageType PNG = null;
        public static final ImageType UNKNOWN = null;

        static {
            ImageType r10 = new ImageType("UNKNOWN", 0);
            UNKNOWN = r10;
            ImageType r11 = new ImageType("JPG", 1);
            JPG = r11;
            ImageType r12 = new ImageType("PNG", 2);
            PNG = r12;
            ImageType r13 = new ImageType("GIF", 3);
            GIF = r13;
            $VALUES = new ImageType[]{r10, r11, r12, r13};
        }

        private ImageType(String r10, int r11) {
            super(r10, r11);
        }

        public static ImageType valueOf(String r10) {
            return (ImageType) Enum.valueOf(ImageType.class, r10);
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }
    }

    static {
        f6859a = new byte[]{71, 73, 70, 56, 55, 97};
        f6860b = new byte[]{71, 73, 70, 56, 57, 97};
        f6861c = new byte[]{-1, -40, -1};
        f6862d = new byte[]{-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
    }

    public static boolean a(String r10, String r11, String r12) {
        return com.bytedance.android.standard.tools.file.FileUtils.a(r10, r11, r12);
    }
}
