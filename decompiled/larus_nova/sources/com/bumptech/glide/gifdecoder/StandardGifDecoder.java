package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = null;
    private int[] act;
    private Bitmap.Config bitmapConfig;
    private final GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.header = null;
        byte[] r100 = this.mainPixels;
        if (r100 == null) goto L5;
        this.bitmapProvider.release(r100);
    L5:
        int[] r101 = this.mainScratch;
        if (r101 == null) goto L8;
        this.bitmapProvider.release(r101);
    L8:
        Bitmap r102 = this.previousImage;
        if (r102 == null) goto L11;
        this.bitmapProvider.release(r102);
    L11:
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] r103 = this.block;
        if (r103 == null) goto L15;
        this.bitmapProvider.release(r103);
        return;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized Bitmap getNextFrame() {
        monitor-enter(this);
    L50:
        th = move-exception;
        throw th;
    L4:
        if (this.header.frameCount <= 0) goto L8;
        if (this.framePointer < 0) goto L8;
    L11:
        int r100 = this.status;     // Catch: Throwable -> L50
        if (r100 == 1) goto L46;
        if (r100 == 2) goto L46;
        this.status = 0;     // Catch: Throwable -> L50
        if (this.block != null) goto L19;
        this.block = this.bitmapProvider.obtainByteArray(255);     // Catch: Throwable -> L50
    L19:
        GifFrame r101 = (GifFrame) ListProtector.get(this.header.frames, this.framePointer);     // Catch: Throwable -> L50
        int r102 = this.framePointer - 1;     // Catch: Throwable -> L50
        if (r102 < 0) goto L22;
        GifFrame r103 = (GifFrame) ListProtector.get(this.header.frames, r102);     // Catch: Throwable -> L50
    L23:
        int[] r104 = r101.lct;     // Catch: Throwable -> L50
        if (r104 != null) goto L27;
        r104 = this.header.gct;     // Catch: Throwable -> L50
    L27:
        this.act = r104;     // Catch: Throwable -> L50
        if (r104 != null) goto L36;
        if (Log.isLoggable(TAG, 3) == true) goto L32;
    L32:
        this.status = 1;     // Catch: Throwable -> L50
        monitor-exit(this);
        return null;
    L36:
        if (r101.transparency == false) goto L42;
        System.arraycopy(r104, 0, this.pct, 0, r104.length);     // Catch: Throwable -> L50
        int[] r105 = this.pct;     // Catch: Throwable -> L50
        this.act = r105;     // Catch: Throwable -> L50
        r105[r101.transIndex] = 0;     // Catch: Throwable -> L50
        if (r101.dispose != 2) goto L42;
        if (this.framePointer != 0) goto L42;
        this.isFirstFrameTransparent = Boolean.TRUE;     // Catch: Throwable -> L50
    L42:
        Bitmap r106 = setPixels(r101, r103);     // Catch: Throwable -> L50
        monitor-exit(this);
        return r106;
    L22:
        r103 = null;
    L46:
        if (Log.isLoggable(TAG, 3) == true) goto L48;
    L48:
        monitor-exit(this);
        return null;
    L8:
        if (Log.isLoggable(TAG, 3) == false) goto L10;
        int r107 = this.header.frameCount;     // Catch: Throwable -> L50
    L10:
        this.status = 1;     // Catch: Throwable -> L50
        goto L11
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    static {
        TAG = "StandardGifDecoder";
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser != null) goto L6;
        this.parser = new GifHeaderParser();
    L6:
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        Boolean r100 = this.isFirstFrameTransparent;
        if (r100 != null) goto L5;
    L8:
        Bitmap.Config r101 = Bitmap.Config.ARGB_8888;
    L9:
        Bitmap r102 = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, r101);
        r102.setHasAlpha(true);
        return r102;
    L5:
        if (r100.booleanValue() == true) goto L8;
        r101 = this.bitmapConfig;
        goto L9
    }

    private int readByte() {
        return this.rawData.get() & UByte.MAX_VALUE;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return (this.rawData.limit() + this.mainPixels.length) + (this.mainScratch.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.header.height;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getLoopCount() {
        int r100 = this.header.loopCount;
        if (r100 != (-1)) goto L6;
        return 1;
    L6:
        return r100;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        if (this.header.frameCount <= 0) goto L9;
        int r100 = this.framePointer;
        if (r100 >= 0) goto L8;
        return 0;
    L8:
        return getDelay(r100);
    L9:
        return 0;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        int r100 = this.header.loopCount;
        if (r100 != (-1)) goto L5;
        return 1;
    L5:
        if (r100 != 0) goto L9;
        return 0;
    L9:
        return r100 + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.header.width;
    }

    private int readBlock() {
        int r100 = readByte();
        if (r100 > 0) goto L5;
        return r100;
    L5:
        ByteBuffer r101 = this.rawData;
        r101.get(this.block, 0, Math.min(r100, r101.remaining()));
        return r100;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public ByteBuffer getData() {
        return this.rawData;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.status;
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider r100) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = r100;
        this.header = new GifHeader();
    }

    private void copyCopyIntoScratchRobust(GifFrame r210) {
        int[] r100 = this.mainScratch;
        int r101 = r210.f33679ih;
        int r102 = this.sampleSize;
        int r103 = r101 / r102;
        int r104 = r210.f33682iy / r102;
        int r105 = r210.f33680iw / r102;
        int r106 = r210.f33681ix / r102;
        if (this.framePointer != 0) goto L5;
        boolean r107 = true;
    L6:
        int r110 = this.downsampledWidth;
        int r111 = this.downsampledHeight;
        byte[] r112 = this.mainPixels;
        int[] r113 = this.act;
        Boolean r114 = this.isFirstFrameTransparent;
        int r115 = 8;
        int r108 = 0;
        int r116 = 0;
        int r117 = 1;
    L7:
        if (r116 >= r103) goto L56;
        Boolean r118 = r114;
        if (r210.interlace == false) goto L23;
        if (r108 < r103) goto L21;
        int r119 = r117 + 1;
        int r211 = r103;
        if (r119 != 2) goto L14;
        r117 = r119;
        r108 = 4;
    L22:
        int r109 = r108 + r115;
    L24:
        int r120 = r108 + r104;
        if (r102 != 1) goto L27;
        boolean r121 = true;
    L28:
        if (r120 >= r111) goto L53;
        int r122 = r120 * r110;
        int r212 = r122 + r106;
        int r123 = r212 + r105;
        int r124 = r122 + r110;
        if (r124 >= r123) goto L32;
        r123 = r124;
    L32:
        int r213 = r109;
        int r125 = (r116 * r102) * r210.f33680iw;
        if (r121 == false) goto L43;
        int r126 = r212;
    L35:
        if (r126 >= r123) goto L54;
        int r127 = r104;
        int r128 = r113[r112[r125] & UByte.MAX_VALUE];
        if (r128 == 0) goto L39;
        r100[r126] = r128;
    L42:
        r125 = r125 + r102;
        r126 = r126 + 1;
        r104 = r127;
        goto L35
    L39:
        if (r107 == false) goto L42;
        if (r118 != null) goto L42;
        r118 = Boolean.TRUE;
    L54:
        int r129 = r104;
        int r214 = r105;
    L55:
        r114 = r118;
        r116 = r116 + 1;
        r104 = r129;
        r103 = r211;
        r105 = r214;
        r108 = r213;
        goto L7
    L43:
        r129 = r104;
        int r130 = ((r123 - r212) * r102) + r125;
        int r131 = r212;
    L44:
        r214 = r105;
        if (r131 >= r123) goto L55;
        int r132 = averageColorsNear(r125, r130, r210.f33680iw);
        if (r132 == 0) goto L49;
        r100[r131] = r132;
    L52:
        r125 = r125 + r102;
        r131 = r131 + 1;
        r105 = r214;
        goto L44
    L49:
        if (r107 == false) goto L52;
        if (r118 != null) goto L52;
        r118 = Boolean.TRUE;
        goto L52
    L53:
        r213 = r109;
        goto L54
    L27:
        r121 = false;
        goto L28
    L14:
        if (r119 != 3) goto L16;
        r117 = r119;
        r108 = 2;
        r115 = 4;
        goto L22
    L16:
        if (r119 == 4) goto L18;
        r117 = r119;
        goto L22
    L18:
        r117 = r119;
        r108 = 1;
        r115 = 2;
        goto L22
    L21:
        r211 = r103;
        goto L22
    L23:
        r211 = r103;
        r109 = r108;
        r108 = r116;
        goto L24
    L56:
        Boolean r133 = r114;
        if (this.isFirstFrameTransparent != null) goto L75;
        if (r133 != null) goto L60;
        boolean r134 = false;
    L61:
        this.isFirstFrameTransparent = Boolean.valueOf(r134);
        return;
    L60:
        r134 = r133.booleanValue();
        goto L61
    L75:
        return;
    L5:
        r107 = false;
        goto L6
    }

    private void copyIntoScratchFast(GifFrame r110) {
        GifFrame r100 = r110;
        int[] r101 = this.mainScratch;
        int r102 = r100.f33679ih;
        int r103 = r100.f33682iy;
        int r104 = r100.f33680iw;
        int r105 = r100.f33681ix;
        if (this.framePointer != 0) goto L5;
        boolean r106 = true;
    L6:
        int r111 = this.downsampledWidth;
        byte[] r112 = this.mainPixels;
        int[] r113 = this.act;
        int r114 = 0;
        byte r115 = -1;
    L7:
        if (r114 >= r102) goto L21;
        int r116 = (r114 + r103) * r111;
        int r117 = r116 + r105;
        int r107 = r117 + r104;
        int r108 = r116 + r111;
        if (r108 >= r107) goto L11;
        r107 = r108;
    L11:
        int r109 = r100.f33680iw * r114;
        int r118 = r117;
    L12:
        if (r118 >= r107) goto L20;
        byte r119 = r112[r109];
        int r120 = r102;
        int r121 = r119 & UByte.MAX_VALUE;
        if (r121 == r115) goto L19;
        int r122 = r113[r121];
        if (r122 == 0) goto L18;
        r101[r118] = r122;
        goto L19
    L18:
        r115 = r119;
    L19:
        r109 = r109 + 1;
        r118 = r118 + 1;
        r102 = r120;
        goto L12
    L20:
        r114 = r114 + 1;
        r100 = r110;
        goto L7
    L21:
        Boolean r123 = this.isFirstFrameTransparent;
        if (r123 == null) goto L26;
        if (r123.booleanValue() == false) goto L26;
    L30:
        boolean r124 = true;
    L32:
        this.isFirstFrameTransparent = Boolean.valueOf(r124);
        return;
    L26:
        if (this.isFirstFrameTransparent != null) goto L31;
        if (r106 == false) goto L31;
        if (r115 != (-1)) goto L30;
    L31:
        r124 = false;
        goto L32
    L5:
        r106 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void decodeBitmapData(GifFrame r210) {
        StandardGifDecoder this = this;
        if (r210 == null) goto L5;
        this.rawData.position(r210.bufferFrameStart);
    L5:
        if (r210 != null) goto L7;
        GifHeader r100 = this.header;
        int r101 = r100.width;
        int r102 = r100.height;
    L8:
        int r103 = r101 * r102;
        byte[] r104 = this.mainPixels;
        if (r104 != null) goto L11;
    L12:
        this.mainPixels = this.bitmapProvider.obtainByteArray(r103);
    L13:
        byte[] r105 = this.mainPixels;
        if (this.prefix != null) goto L16;
        this.prefix = new short[4096];
    L16:
        short[] r106 = this.prefix;
        if (this.suffix != null) goto L19;
        this.suffix = new byte[4096];
    L19:
        byte[] r107 = this.suffix;
        if (this.pixelStack != null) goto L22;
        this.pixelStack = new byte[4097];
    L22:
        byte[] r108 = this.pixelStack;
        int r109 = readByte();
        int r110 = 1 << r109;
        int r111 = r110 + 1;
        int r112 = r110 + 2;
        int r113 = r109 + 1;
        int r114 = (1 << r113) - 1;
        int r115 = 0;
        int r116 = 0;
    L23:
        if (r116 >= r110) goto L25;
        r106[r116] = 0;
        r107[r116] = (byte) r116;
        r116 = r116 + 1;
        goto L23
    L25:
        byte[] r117 = this.block;
        int r211 = r113;
        int r212 = r112;
        int r213 = r114;
        int r118 = 0;
        int r119 = 0;
        int r120 = 0;
        int r121 = 0;
        int r214 = 0;
        int r215 = -1;
        int r216 = 0;
        int r217 = 0;
    L26:
        if (r115 >= r103) goto L59;
        if (r118 != 0) goto L32;
        r118 = readBlock();
        if (r118 <= 0) goto L30;
        r119 = 0;
        goto L32
    L30:
        this.status = 3;
    L32:
        r121 = r121 + ((r117[r119] & UByte.MAX_VALUE) << r120);
        r119 = r119 + 1;
        r118 = r118 - 1;
        int r122 = r120 + 8;
        r212 = r212;
        r211 = r211;
        r215 = r215;
        r113 = r113;
        r216 = r216;
    L33:
        if (r122 < r211) goto L58;
        int r218 = r112;
        int r123 = r121 & r213;
        r121 = r121 >> r211;
        r122 = r122 - r211;
        if (r123 == r110) goto L36;
        if (r123 == r111) goto L38;
        if (r215 == (-1)) goto L41;
        if (r123 < r212) goto L44;
        r108[r217] = (byte) r216;
        r217 = r217 + 1;
        short r124 = r215;
    L45:
        if (r124 < r110) goto L47;
        r108[r217] = r107[r124];
        r217 = r217 + 1;
        r124 = r106[r124];
        goto L45
    L47:
        r216 = r107[r124] & UByte.MAX_VALUE;
        byte r125 = (byte) r216;
        r105[r214] = r125;
    L48:
        r214 = r214 + 1;
        r115 = r115 + 1;
        if (r217 <= 0) goto L51;
        r217 = r217 - 1;
        r105[r214] = r108[r217];
        goto L48
    L51:
        byte[] r219 = r108;
        if (r212 >= 4096) goto L57;
        r106[r212] = (short) r215;
        r107[r212] = r125;
        r212 = r212 + 1;
        if ((r212 & r213) != 0) goto L57;
        if (r212 >= 4096) goto L57;
        r211 = r211 + 1;
        r213 = r213 + r212;
    L57:
        r215 = r123;
        r112 = r218;
        r122 = r122;
        r108 = r219;
        goto L33
    L44:
        r124 = r123;
        goto L45
    L41:
        r105[r214] = r107[r123];
        r214 = r214 + 1;
        r115 = r115 + 1;
        r215 = r123;
        r216 = r215;
        r112 = r218;
        r122 = r122;
        goto L33
    L38:
        r120 = r122;
        r112 = r218;
        goto L26
    L36:
        r213 = r114;
        r211 = r113;
        r212 = r218;
        r112 = r212;
        r215 = -1;
        goto L33
    L58:
        r120 = r122;
    L59:
        Arrays.fill(r105, r214, r103, (byte) 0);
        return;
    L11:
        if (r104.length >= r103) goto L13;
    L7:
        r101 = r210.f33680iw;
        r102 = r210.f33679ih;
        goto L8
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int r100) {
        if (r100 < 0) goto L6;
        GifHeader r101 = this.header;
        if (r100 >= r101.frameCount) goto L6;
        return ((GifFrame) ListProtector.get(r101.frames, r100)).delay;
    L6:
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(byte[] r100) {
        monitor-enter(this);
        GifHeader r101 = getHeaderParser().setData(r100).parseHeader();     // Catch: Throwable -> L9
        this.header = r101;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        setData(r101, r100);     // Catch: Throwable -> L9
    L6:
        int r102 = this.status;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(Bitmap.Config r100) {
        if (r100 != Bitmap.Config.ARGB_8888) goto L5;
    L9:
        this.bitmapConfig = r100;
        return;
    L5:
        if (r100 == Bitmap.Config.RGB_565) goto L9;
        throw new IllegalArgumentException("Unsupported format: " + r100 + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    private Bitmap setPixels(GifFrame r110, GifFrame r111) {
        int[] r100 = this.mainScratch;
        int r101 = 0;
        if (r111 != null) goto L9;
        Bitmap r102 = this.previousImage;
        if (r102 == null) goto L7;
        this.bitmapProvider.release(r102);
    L7:
        this.previousImage = null;
        Arrays.fill(r100, 0);
    L9:
        if (r111 != null) goto L11;
    L15:
        if (r111 == null) goto L38;
        int r103 = r111.dispose;
        if (r103 <= 0) goto L38;
        if (r103 == 2) goto L21;
        if (r103 != 3) goto L38;
        Bitmap r104 = this.previousImage;
        if (r104 == null) goto L38;
        int r105 = this.downsampledWidth;
        r104.getPixels(r100, 0, r105, 0, 0, r105, this.downsampledHeight);
        goto L38
    L21:
        if (r110.transparency == true) goto L28;
        GifHeader r106 = this.header;
        int r107 = r106.bgColor;
        if (r110.lct != null) goto L25;
    L27:
        r101 = r107;
        goto L28
    L25:
        if (r106.bgIndex != r110.transIndex) goto L27;
    L28:
        int r108 = r111.f33679ih;
        int r109 = this.sampleSize;
        int r112 = r108 / r109;
        int r113 = r111.f33682iy / r109;
        int r114 = r111.f33680iw / r109;
        int r115 = r111.f33681ix / r109;
        int r116 = this.downsampledWidth;
        int r117 = (r113 * r116) + r115;
        int r118 = (r112 * r116) + r117;
    L29:
        if (r117 >= r118) goto L38;
        int r119 = r117 + r114;
        int r120 = r117;
    L31:
        if (r120 >= r119) goto L33;
        r100[r120] = r101;
        r120 = r120 + 1;
        goto L31
    L33:
        r117 = r117 + this.downsampledWidth;
    L38:
        decodeBitmapData(r110);
        if (r110.interlace == false) goto L41;
    L44:
        copyCopyIntoScratchRobust(r110);
    L46:
        if (this.savePrevious == false) goto L54;
        int r121 = r110.dispose;
        if (r121 == 0) goto L51;
        if (r121 != 1) goto L54;
    L51:
        if (this.previousImage != null) goto L53;
        this.previousImage = getNextBitmap();
    L53:
        Bitmap r122 = this.previousImage;
        int r123 = this.downsampledWidth;
        r122.setPixels(r100, 0, r123, 0, 0, r123, this.downsampledHeight);
    L54:
        Bitmap r124 = getNextBitmap();
        int r125 = this.downsampledWidth;
        r124.setPixels(r100, 0, r125, 0, 0, r125, this.downsampledHeight);
        return r124;
    L41:
        if (this.sampleSize != 1) goto L44;
        copyIntoScratchFast(r110);
        goto L46
    L11:
        if (r111.dispose != 3) goto L15;
        if (this.previousImage != null) goto L15;
        Arrays.fill(r100, 0);
        goto L15
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(InputStream r100, int r101) {
        if (r100 != null) goto L4;
        this.status = 2;
    L15:
        if (r100 == null) goto L18;
        r100.close();     // Catch: IOException -> L19
    L18:
        return this.status;
    L4:
        if (r101 <= 0) goto L6;
        int r102 = r101 + 4096;
    L20:
        ByteArrayOutputStream r103 = new ByteArrayOutputStream(r102);     // Catch: IOException -> L13
        byte[] r104 = new byte[16384];     // Catch: IOException -> L13
    L8:
        int r105 = r100.read(r104, 0, 16384);     // Catch: IOException -> L13
        if (r105 == (-1)) goto L11;
        r103.write(r104, 0, r105);     // Catch: IOException -> L13
        goto L8
    L11:
        r103.flush();     // Catch: IOException -> L13
        read(r103.toByteArray());     // Catch: IOException -> L13
        goto L15
    L6:
        r102 = 16384;
        goto L20
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(GifHeader r100, byte[] r101) {
        monitor-enter(this);
        setData(r100, ByteBuffer.wrap(r101));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(GifHeader r100, ByteBuffer r101) {
        monitor-enter(this);
        setData(r100, r101, 1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider r100, GifHeader r101, ByteBuffer r102) {
        this(r100, r101, r102, 1);
    }

    private int averageColorsNear(int r110, int r111, int r112) {
        int r100 = r110;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r100 >= (this.sampleSize + r110)) goto L12;
        byte[] r106 = this.mainPixels;
        if (r100 >= r106.length) goto L12;
        if (r100 >= r111) goto L12;
        int r107 = r106[r100] & UByte.MAX_VALUE;
        int r108 = this.act[r107];
        if (r108 == 0) goto L11;
        r101 = r101 + ((r108 >> 24) & 255);
        r102 = r102 + ((r108 >> 16) & 255);
        r103 = r103 + ((r108 >> 8) & 255);
        r104 = r104 + (r108 & 255);
        r105 = r105 + 1;
    L11:
        r100 = r100 + 1;
    L12:
        int r113 = r110 + r112;
        int r114 = r113;
    L14:
        if (r114 >= (this.sampleSize + r113)) goto L22;
        byte[] r109 = this.mainPixels;
        if (r114 >= r109.length) goto L22;
        if (r114 >= r111) goto L22;
        int r115 = r109[r114] & UByte.MAX_VALUE;
        int r116 = this.act[r115];
        if (r116 == 0) goto L21;
        r101 = r101 + ((r116 >> 24) & 255);
        r102 = r102 + ((r116 >> 16) & 255);
        r103 = r103 + ((r116 >> 8) & 255);
        r104 = r104 + (r116 & 255);
        r105 = r105 + 1;
    L21:
        r114 = r114 + 1;
    L22:
        if (r105 != 0) goto L25;
        return 0;
    L25:
        return ((((r101 / r105) << 24) | ((r102 / r105) << 16)) | ((r103 / r105) << 8)) | (r104 / r105);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(GifHeader r100, ByteBuffer r101, int r102) {
        monitor-enter(this);
        if (r102 <= 0) goto L17;
        int r103 = Integer.highestOneBit(r102);     // Catch: Throwable -> L14
        this.status = 0;     // Catch: Throwable -> L14
        this.header = r100;     // Catch: Throwable -> L14
        this.framePointer = -1;     // Catch: Throwable -> L14
        ByteBuffer r104 = r101.asReadOnlyBuffer();     // Catch: Throwable -> L14
        this.rawData = r104;     // Catch: Throwable -> L14
        r104.position(0);     // Catch: Throwable -> L14
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L14
        this.savePrevious = false;     // Catch: Throwable -> L14
        Iterator<GifFrame> r105 = r100.frames.iterator();     // Catch: Throwable -> L14
    L7:
        if (r105.hasNext() == false) goto L11;
        if (r105.next().dispose != 3) goto L7;
        this.savePrevious = true;     // Catch: Throwable -> L14
    L11:
        this.sampleSize = r103;     // Catch: Throwable -> L14
        int r106 = r100.width;     // Catch: Throwable -> L14
        this.downsampledWidth = r106 / r103;     // Catch: Throwable -> L14
        int r107 = r100.height;     // Catch: Throwable -> L14
        this.downsampledHeight = r107 / r103;     // Catch: Throwable -> L14
        this.mainPixels = this.bitmapProvider.obtainByteArray(r106 * r107);     // Catch: Throwable -> L14
        this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L17:
        throw new IllegalArgumentException("Sample size must be >=0, not: " + r102);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public StandardGifDecoder(GifDecoder.BitmapProvider r100, GifHeader r101, ByteBuffer r102, int r103) {
        this(r100);
        setData(r101, r102, r103);
    }
}
