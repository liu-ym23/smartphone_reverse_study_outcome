package com.byted.cast.sdk.gl.grafika;

import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public class GeneratedTexture {
    private static final int BLACK = 0;
    private static final int BLUE = 16711680;
    private static final int BYTES_PER_PIXEL = 4;
    private static final int CYAN = 16776960;
    private static final int FORMAT = 6408;
    private static final int GREEN = 65280;
    private static final int[] GRID = null;
    private static final int HALF = Integer.MIN_VALUE;
    private static final int LOW = 1073741824;
    private static final int MAGENTA = 16711935;
    private static final int OPAQUE = -16777216;
    private static final int RED = 255;
    private static final int TEX_SIZE = 64;
    private static final int TRANSP = 0;
    private static final int WHITE = 16777215;
    private static final int YELLOW = 65535;
    private static final ByteBuffer sCoarseImageData = null;
    private static final ByteBuffer sFineImageData = null;

    /* JADX INFO: renamed from: com.byted.cast.sdk.gl.grafika.GeneratedTexture$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$byted$cast$sdk$gl$grafika$GeneratedTexture$Image = null;

        static {
            int[] r100 = new int[Image.values().length];
            $SwitchMap$com$byted$cast$sdk$gl$grafika$GeneratedTexture$Image = r100;
            r100[Image.COARSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$byted$cast$sdk$gl$grafika$GeneratedTexture$Image[Image.FINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum Image extends Enum<Image> {
        private static final /* synthetic */ Image[] $VALUES = null;
        public static final Image COARSE = null;
        public static final Image FINE = null;

        static {
            Image r100 = new Image("COARSE", 0);
            COARSE = r100;
            Image r101 = new Image("FINE", 1);
            FINE = r101;
            $VALUES = new Image[]{r100, r101};
        }

        public static Image[] values() {
            return (Image[]) $VALUES.clone();
        }

        public static Image valueOf(String r100) {
            return (Image) a.a(Image.class, r100);
        }

        private Image(String r100, int r101) {
            super(r100, r101);
        }
    }

    public GeneratedTexture() {
    }

    static {
        GRID = new int[]{FakePickerAvatarCreator.BLUE, FakePickerAvatarCreator.CYAN, FakePickerAvatarCreator.GREEN, FakePickerAvatarCreator.MAGENTA, -1, 1073742079, 1073807104, FakePickerAvatarCreator.CYAN, FakePickerAvatarCreator.MAGENTA, 65280, -2147483393, -16777216, -256, FakePickerAvatarCreator.MAGENTA, -256, -65536};
        sCoarseImageData = generateCoarseData();
        sFineImageData = generateFineData();
    }

    private static ByteBuffer generateCoarseData() {
        byte[] r100 = new byte[16384];
        int r101 = 0;
    L3:
        if (r101 >= 16384) goto L11;
        int r102 = r101 / 4;
        int r103 = GRID[(((r102 / 64) / 16) * 4) + ((r102 % 64) / 16)];
        if (r101 != 0) goto L8;
    L6:
        r103 = -1;
    L10:
        int r104 = r103 & 255;
        int r105 = (r103 >> 8) & 255;
        int r106 = (r103 >> 16) & 255;
        int r107 = (r103 >> 24) & 255;
        float r108 = r107 / 255.0f;
        r100[r101] = (byte) (r104 * r108);
        r100[r101 + 1] = (byte) (r105 * r108);
        r100[r101 + 2] = (byte) (r106 * r108);
        r100[r101 + 3] = (byte) r107;
        r101 = r101 + 4;
        goto L3
    L8:
        if (r101 != 16380) goto L10;
    L11:
        ByteBuffer r109 = ByteBuffer.allocateDirect(16384);
        r109.put(r100);
        r109.position(0);
        return r109;
    }

    private static ByteBuffer generateFineData() {
        byte[] r100 = new byte[16384];
        checkerPattern(r100, 0, 0, 32, 32, FakePickerAvatarCreator.BLUE, -65536, 1);
        checkerPattern(r100, 32, 32, 64, 64, FakePickerAvatarCreator.BLUE, FakePickerAvatarCreator.GREEN, 2);
        checkerPattern(r100, 0, 32, 32, 64, -65536, FakePickerAvatarCreator.GREEN, 4);
        checkerPattern(r100, 32, 0, 64, 32, -1, -16777216, 8);
        ByteBuffer r101 = ByteBuffer.allocateDirect(16384);
        r101.put(r100);
        r101.position(0);
        return r101;
    }

    public static int createTestTexture(Image r100) {
        int r101 = AnonymousClass1.$SwitchMap$com$byted$cast$sdk$gl$grafika$GeneratedTexture$Image[r100.ordinal()];
        if (r101 != 1) goto L5;
        ByteBuffer r102 = sCoarseImageData;
    L11:
        return GlUtil.createImageTexture(r102, 64, 64, FORMAT);
    L5:
        if (r101 != 2) goto L8;
        r102 = sFineImageData;
        goto L11
    L8:
        throw new RuntimeException("unknown image");
    }

    private static void checkerPattern(byte[] r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117) {
        int r100 = r112;
    L3:
        if (r100 >= r114) goto L12;
        int r101 = (r100 * 64) * 4;
        int r102 = r111;
    L5:
        if (r102 >= r113) goto L11;
        int r103 = (r102 * 4) + r101;
        if (((r100 & r117) ^ (r102 & r117)) != 0) goto L9;
        int r104 = r115;
    L10:
        int r105 = r104 & 255;
        int r106 = (r104 >> 8) & 255;
        int r107 = (r104 >> 16) & 255;
        int r108 = (r104 >> 24) & 255;
        float r118 = r108 / 255.0f;
        r110[r103] = (byte) (r105 * r118);
        r110[r103 + 1] = (byte) (r106 * r118);
        r110[r103 + 2] = (byte) (r107 * r118);
        r110[r103 + 3] = (byte) r108;
        r102 = r102 + 1;
        goto L5
    L9:
        r104 = r116;
        goto L10
    L11:
        r100 = r100 + 1;
        goto L3
    }
}
