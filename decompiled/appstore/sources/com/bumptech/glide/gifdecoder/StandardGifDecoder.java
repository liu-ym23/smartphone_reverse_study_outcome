package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class StandardGifDecoder implements GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;

    @ColorInt
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = "StandardGifDecoder";

    @ColorInt
    private int[] act;

    @NonNull
    private Bitmap.Config bitmapConfig;
    private final GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private GifHeader header;

    @Nullable
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;

    @ColorInt
    private int[] mainScratch;
    private GifHeaderParser parser;

    @ColorInt
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    static {
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider r10, GifHeader r11, ByteBuffer r12) {
        this(r10, r11, r12, 1);
    }

    @ColorInt
    private int averageColorsNear(int r10, int r11, int r12) {
        int r13 = r10;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
    L4:
        if (r13 >= (this.sampleSize + r10)) goto L12;
        byte[] r19 = this.mainPixels;
        if (r13 >= r19.length) goto L12;
        if (r13 >= r11) goto L12;
        int r20 = this.act[r19[r13] & UnsignedBytes.MAX_VALUE];
        if (r20 == 0) goto L11;
        r14 = r14 + ((r20 >> 24) & 255);
        r15 = r15 + ((r20 >> 16) & 255);
        r16 = r16 + ((r20 >> 8) & 255);
        r17 = r17 + (r20 & 255);
        r18 = r18 + 1;
    L11:
        r13 = r13 + 1;
    L12:
        int r110 = r10 + r12;
        int r111 = r110;
    L14:
        if (r111 >= (this.sampleSize + r110)) goto L22;
        byte[] r21 = this.mainPixels;
        if (r111 >= r21.length) goto L22;
        if (r111 >= r11) goto L22;
        int r22 = this.act[r21[r111] & UnsignedBytes.MAX_VALUE];
        if (r22 == 0) goto L21;
        r14 = r14 + ((r22 >> 24) & 255);
        r15 = r15 + ((r22 >> 16) & 255);
        r16 = r16 + ((r22 >> 8) & 255);
        r17 = r17 + (r22 & 255);
        r18 = r18 + 1;
    L21:
        r111 = r111 + 1;
    L22:
        if (r18 != 0) goto L25;
        return 0;
    L25:
        return ((((r14 / r18) << 24) | ((r15 / r18) << 16)) | ((r16 / r18) << 8)) | (r17 / r18);
    }

    private void copyCopyIntoScratchRobust(GifFrame r24) {
        int[] r10 = this.mainScratch;
        int r11 = r24.ih;
        int r12 = this.sampleSize;
        int r13 = r11 / r12;
        int r14 = r24.iy / r12;
        int r15 = r24.iw / r12;
        int r16 = r24.ix / r12;
        if (this.framePointer != 0) goto L5;
        boolean r17 = true;
    L6:
        int r18 = this.downsampledWidth;
        int r19 = this.downsampledHeight;
        byte[] r110 = this.mainPixels;
        int[] r111 = this.act;
        Boolean r112 = this.isFirstFrameTransparent;
        int r113 = 8;
        int r20 = 0;
        int r114 = 0;
        int r115 = 1;
    L7:
        if (r114 >= r13) goto L57;
        Boolean r116 = r112;
        if (r24.interlace == false) goto L23;
        if (r20 < r13) goto L21;
        int r117 = r115 + 1;
        int r21 = r13;
        if (r117 != 2) goto L14;
        r20 = 4;
    L17:
        r115 = r117;
    L22:
        int r22 = r20 + r113;
    L24:
        int r23 = r20 + r14;
        if (r12 != 1) goto L27;
        boolean r118 = true;
    L28:
        if (r23 >= r19) goto L55;
        int r25 = r23 * r18;
        int r26 = r25 + r16;
        int r119 = r26 + r15;
        int r27 = r25 + r18;
        if (r27 >= r119) goto L32;
        r119 = r27;
    L32:
        int r28 = r22;
        int r29 = (r114 * r12) * r24.iw;
        if (r118 == false) goto L45;
        int r30 = r26;
    L35:
        if (r30 >= r119) goto L43;
        int r120 = r14;
        int r31 = r111[r110[r29] & UnsignedBytes.MAX_VALUE];
        if (r31 == 0) goto L39;
        r10[r30] = r31;
    L42:
        r29 = r29 + r12;
        r30 = r30 + 1;
        r14 = r120;
        goto L35
    L39:
        if (r17 == false) goto L42;
        if (r116 != null) goto L42;
        r116 = Boolean.TRUE;
    L43:
        int r121 = r14;
        int r210 = r15;
    L44:
        r112 = r116;
        r114 = r114 + 1;
        r14 = r121;
        r13 = r21;
        r15 = r210;
        r20 = r28;
        goto L7
    L45:
        r121 = r14;
        int r32 = ((r119 - r26) * r12) + r29;
        int r33 = r26;
    L46:
        r210 = r15;
        if (r33 >= r119) goto L44;
        int r34 = averageColorsNear(r29, r32, r24.iw);
        if (r34 == 0) goto L51;
        r10[r33] = r34;
    L54:
        r29 = r29 + r12;
        r33 = r33 + 1;
        r15 = r210;
        goto L46
    L51:
        if (r17 == false) goto L54;
        if (r116 != null) goto L54;
        r116 = Boolean.TRUE;
        goto L54
    L55:
        r28 = r22;
        goto L43
    L27:
        r118 = false;
        goto L28
    L14:
        if (r117 != 3) goto L16;
        r113 = 4;
        r115 = r117;
        r20 = 2;
        goto L22
    L16:
        if (r117 != 4) goto L17;
        r115 = r117;
        r20 = 1;
        r113 = 2;
        goto L22
    L21:
        r21 = r13;
        goto L22
    L23:
        r21 = r13;
        r22 = r20;
        r20 = r114;
        goto L24
    L57:
        Boolean r122 = r112;
        if (this.isFirstFrameTransparent != null) goto L75;
        if (r122 != null) goto L61;
        boolean r123 = false;
    L62:
        this.isFirstFrameTransparent = Boolean.valueOf(r123);
        return;
    L61:
        r123 = r122.booleanValue();
        goto L62
    L75:
        return;
    L5:
        r17 = false;
        goto L6
    }

    private void copyIntoScratchFast(GifFrame r19) {
        GifFrame r10 = r19;
        int[] r11 = this.mainScratch;
        int r12 = r10.ih;
        int r13 = r10.iy;
        int r14 = r10.iw;
        int r15 = r10.ix;
        if (this.framePointer != 0) goto L5;
        boolean r16 = true;
    L6:
        int r17 = this.downsampledWidth;
        byte[] r18 = this.mainPixels;
        int[] r110 = this.act;
        int r111 = 0;
        byte r112 = -1;
    L7:
        if (r111 >= r12) goto L22;
        int r113 = (r111 + r13) * r17;
        int r114 = r113 + r15;
        int r20 = r114 + r14;
        int r21 = r113 + r17;
        if (r21 >= r20) goto L11;
        r20 = r21;
    L11:
        int r22 = r10.iw * r111;
        int r115 = r114;
    L12:
        if (r115 >= r20) goto L20;
        byte r23 = r18[r22];
        int r116 = r12;
        int r24 = r23 & UnsignedBytes.MAX_VALUE;
        if (r24 == r112) goto L19;
        int r25 = r110[r24];
        if (r25 == 0) goto L18;
        r11[r115] = r25;
        goto L19
    L18:
        r112 = r23;
    L19:
        r22 = r22 + 1;
        r115 = r115 + 1;
        r12 = r116;
        goto L12
    L20:
        r111 = r111 + 1;
        r10 = r19;
        goto L7
    L22:
        if (this.isFirstFrameTransparent != null) goto L27;
        if (r16 == false) goto L27;
        if (r112 == (-1)) goto L27;
        boolean r26 = true;
    L28:
        this.isFirstFrameTransparent = Boolean.valueOf(r26);
        return;
    L27:
        r26 = false;
        goto L28
    L5:
        r16 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void decodeBitmapData(GifFrame r29) {
        StandardGifDecoder this = this;
        if (r29 == null) goto L5;
        this.rawData.position(r29.bufferFrameStart);
    L5:
        if (r29 != null) goto L8;
        GifHeader r10 = this.header;
        int r11 = r10.width;
        int r12 = r10.height;
    L7:
        int r13 = r11 * r12;
        byte[] r14 = this.mainPixels;
        if (r14 != null) goto L12;
    L13:
        this.mainPixels = this.bitmapProvider.obtainByteArray(r13);
    L14:
        byte[] r15 = this.mainPixels;
        if (this.prefix != null) goto L17;
        this.prefix = new short[4096];
    L17:
        short[] r16 = this.prefix;
        if (this.suffix != null) goto L20;
        this.suffix = new byte[4096];
    L20:
        byte[] r17 = this.suffix;
        if (this.pixelStack != null) goto L23;
        this.pixelStack = new byte[4097];
    L23:
        byte[] r18 = this.pixelStack;
        int r19 = readByte();
        int r20 = 1 << r19;
        int r110 = r20 + 1;
        int r111 = r20 + 2;
        int r21 = r19 + 1;
        int r112 = (1 << r21) - 1;
        int r113 = 0;
        int r114 = 0;
    L24:
        if (r114 >= r20) goto L26;
        r16[r114] = 0;
        r17[r114] = (byte) r114;
        r114 = r114 + 1;
        goto L24
    L26:
        byte[] r115 = this.block;
        int r23 = r21;
        int r22 = r111;
        int r24 = r112;
        int r116 = 0;
        int r117 = 0;
        int r118 = 0;
        int r119 = 0;
        int r25 = 0;
        int r26 = 0;
        int r27 = 0;
        int r28 = -1;
    L27:
        if (r113 >= r13) goto L61;
        if (r116 != 0) goto L34;
        r116 = readBlock();
        if (r116 <= 0) goto L31;
        r117 = 0;
        goto L34
    L31:
        this.status = 3;
    L34:
        r119 = r119 + ((r115[r117] & UnsignedBytes.MAX_VALUE) << r118);
        r117 = r117 + 1;
        r116 = r116 - 1;
        int r30 = r118 + 8;
        r22 = r22;
        r23 = r23;
        r28 = r28;
        r21 = r21;
        r26 = r26;
    L35:
        if (r30 < r23) goto L60;
        int r210 = r111;
        int r120 = r119 & r24;
        r119 = r119 >> r23;
        r30 = r30 - r23;
        if (r120 == r20) goto L38;
        if (r120 == r110) goto L40;
        if (r28 == (-1)) goto L43;
        if (r120 < r22) goto L46;
        r18[r27] = (byte) r26;
        r27 = r27 + 1;
        short r31 = r28;
    L47:
        if (r31 < r20) goto L49;
        r18[r27] = r17[r31];
        r27 = r27 + 1;
        r31 = r16[r31];
        goto L47
    L49:
        r26 = r17[r31] & UnsignedBytes.MAX_VALUE;
        byte r32 = (byte) r26;
        r15[r25] = r32;
    L50:
        r25 = r25 + 1;
        r113 = r113 + 1;
        if (r27 <= 0) goto L53;
        r27 = r27 - 1;
        r15[r25] = r18[r27];
        goto L50
    L53:
        byte[] r211 = r18;
        if (r22 >= 4096) goto L59;
        r16[r22] = (short) r28;
        r17[r22] = r32;
        r22 = r22 + 1;
        if ((r22 & r24) != 0) goto L59;
        if (r22 >= 4096) goto L59;
        r23 = r23 + 1;
        r24 = r24 + r22;
    L59:
        r28 = r120;
        r111 = r210;
        r30 = r30;
        r18 = r211;
        goto L35
    L46:
        r31 = r120;
        goto L47
    L43:
        r15[r25] = r17[r120];
        r25 = r25 + 1;
        r113 = r113 + 1;
        r28 = r120;
        r26 = r28;
        r111 = r210;
        r30 = r30;
        goto L35
    L40:
        r118 = r30;
        r111 = r210;
        goto L27
    L38:
        r24 = r112;
        r23 = r21;
        r22 = r210;
        r111 = r22;
        r28 = -1;
        goto L35
    L60:
        r118 = r30;
    L61:
        Arrays.fill(r15, r25, r13, (byte) 0);
        return;
    L12:
        if (r14.length >= r13) goto L14;
    L8:
        r11 = r29.iw;
        r12 = r29.ih;
        goto L7
    }

    @NonNull
    private GifHeaderParser getHeaderParser() {
        if (this.parser != null) goto L6;
        this.parser = new GifHeaderParser();
    L6:
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        Boolean r10 = this.isFirstFrameTransparent;
        if (r10 != null) goto L5;
    L8:
        Bitmap.Config r11 = Bitmap.Config.ARGB_8888;
    L9:
        Bitmap r12 = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, r11);
        r12.setHasAlpha(true);
        return r12;
    L5:
        if (r10.booleanValue() == true) goto L8;
        r11 = this.bitmapConfig;
        goto L9
    }

    private int readBlock() {
        int r10 = readByte();
        if (r10 > 0) goto L5;
        return r10;
    L5:
        ByteBuffer r11 = this.rawData;
        r11.get(this.block, 0, Math.min(r10, r11.remaining()));
        return r10;
    }

    private int readByte() {
        return this.rawData.get() & UnsignedBytes.MAX_VALUE;
    }

    private Bitmap setPixels(GifFrame r10, GifFrame r11) {
        int[] r12 = this.mainScratch;
        int r13 = 0;
        if (r11 != null) goto L9;
        Bitmap r14 = this.previousImage;
        if (r14 == null) goto L7;
        this.bitmapProvider.release(r14);
    L7:
        this.previousImage = null;
        Arrays.fill(r12, 0);
    L9:
        if (r11 != null) goto L11;
    L15:
        if (r11 == null) goto L41;
        int r15 = r11.dispose;
        if (r15 <= 0) goto L41;
        if (r15 == 2) goto L21;
        if (r15 != 3) goto L41;
        Bitmap r16 = this.previousImage;
        if (r16 == null) goto L41;
        int r17 = this.downsampledWidth;
        r16.getPixels(r12, 0, r17, 0, 0, r17, this.downsampledHeight);
        goto L41
    L21:
        if (r10.transparency == true) goto L29;
        GifHeader r18 = this.header;
        int r19 = r18.bgColor;
        if (r10.lct != null) goto L25;
    L27:
        r13 = r19;
    L31:
        int r20 = r11.ih;
        int r21 = this.sampleSize;
        int r22 = r20 / r21;
        int r23 = r11.iy / r21;
        int r24 = r11.iw / r21;
        int r110 = r11.ix / r21;
        int r25 = this.downsampledWidth;
        int r26 = (r23 * r25) + r110;
        int r27 = (r22 * r25) + r26;
    L32:
        if (r26 >= r27) goto L41;
        int r111 = r26 + r24;
        int r28 = r26;
    L34:
        if (r28 >= r111) goto L36;
        r12[r28] = r13;
        r28 = r28 + 1;
        goto L34
    L36:
        r26 = r26 + this.downsampledWidth;
        goto L32
    L25:
        if (r18.bgIndex != r10.transIndex) goto L27;
    L29:
        if (this.framePointer != 0) goto L31;
        this.isFirstFrameTransparent = Boolean.TRUE;
    L41:
        decodeBitmapData(r10);
        if (r10.interlace == false) goto L44;
    L47:
        copyCopyIntoScratchRobust(r10);
    L49:
        if (this.savePrevious == false) goto L57;
        int r112 = r10.dispose;
        if (r112 == 0) goto L54;
        if (r112 != 1) goto L57;
    L54:
        if (this.previousImage != null) goto L56;
        this.previousImage = getNextBitmap();
    L56:
        Bitmap r29 = this.previousImage;
        int r30 = this.downsampledWidth;
        r29.setPixels(r12, 0, r30, 0, 0, r30, this.downsampledHeight);
    L57:
        Bitmap r113 = getNextBitmap();
        int r31 = this.downsampledWidth;
        r113.setPixels(r12, 0, r31, 0, 0, r31, this.downsampledHeight);
        return r113;
    L44:
        if (this.sampleSize != 1) goto L47;
        copyIntoScratchFast(r10);
        goto L49
    L11:
        if (r11.dispose != 3) goto L15;
        if (this.previousImage != null) goto L15;
        Arrays.fill(r12, 0);
        goto L15
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.header = null;
        byte[] r10 = this.mainPixels;
        if (r10 == null) goto L5;
        this.bitmapProvider.release(r10);
    L5:
        int[] r11 = this.mainScratch;
        if (r11 == null) goto L8;
        this.bitmapProvider.release(r11);
    L8:
        Bitmap r12 = this.previousImage;
        if (r12 == null) goto L11;
        this.bitmapProvider.release(r12);
    L11:
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] r13 = this.block;
        if (r13 == null) goto L15;
        this.bitmapProvider.release(r13);
        return;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return (this.rawData.limit() + this.mainPixels.length) + (this.mainScratch.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.rawData;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int r10) {
        if (r10 < 0) goto L6;
        GifHeader r11 = this.header;
        if (r10 >= r11.frameCount) goto L6;
        return r11.frames.get(r10).delay;
    L6:
        return -1;
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
    @Deprecated
    public int getLoopCount() {
        int r10 = this.header.loopCount;
        if (r10 != (-1)) goto L6;
        return 1;
    L6:
        return r10;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        if (this.header.frameCount <= 0) goto L9;
        int r10 = this.framePointer;
        if (r10 >= 0) goto L8;
        return 0;
    L8:
        return getDelay(r10);
    L9:
        return 0;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    public synchronized Bitmap getNextFrame() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.header.frameCount > 0) goto L6;
    L10:
        String r10 = TAG;     // Catch: Throwable -> L8
        if (Log.isLoggable(r10, 3) == false) goto L13;
        Log.d(r10, "Unable to decode frame, frameCount=" + this.header.frameCount + ", framePointer=" + this.framePointer);     // Catch: Throwable -> L8
    L13:
        this.status = 1;     // Catch: Throwable -> L8
    L14:
        int r11 = this.status;     // Catch: Throwable -> L8
        if (r11 != 1) goto L17;
    L44:
        String r12 = TAG;     // Catch: Throwable -> L8
        if (Log.isLoggable(r12, 3) == false) goto L47;
        Log.d(r12, "Unable to decode frame, status=" + this.status);     // Catch: Throwable -> L8
    L47:
        monitor-exit(this);
        return null;
    L17:
        if (r11 == 2) goto L44;
        this.status = 0;     // Catch: Throwable -> L8
        if (this.block != null) goto L22;
        this.block = this.bitmapProvider.obtainByteArray(255);     // Catch: Throwable -> L8
    L22:
        GifFrame r13 = this.header.frames.get(this.framePointer);     // Catch: Throwable -> L8
        int r14 = this.framePointer - 1;     // Catch: Throwable -> L8
        if (r14 < 0) goto L25;
        GifFrame r15 = this.header.frames.get(r14);     // Catch: Throwable -> L8
    L26:
        int[] r16 = r13.lct;     // Catch: Throwable -> L8
        if (r16 != null) goto L30;
        r16 = this.header.gct;     // Catch: Throwable -> L8
    L30:
        this.act = r16;     // Catch: Throwable -> L8
        if (r16 != null) goto L39;
        String r17 = TAG;     // Catch: Throwable -> L8
        if (Log.isLoggable(r17, 3) == false) goto L35;
        Log.d(r17, "No valid color table found for frame #" + this.framePointer);     // Catch: Throwable -> L8
    L35:
        this.status = 1;     // Catch: Throwable -> L8
        monitor-exit(this);
        return null;
    L39:
        if (r13.transparency == false) goto L41;
        System.arraycopy(r16, 0, this.pct, 0, r16.length);     // Catch: Throwable -> L8
        int[] r18 = this.pct;     // Catch: Throwable -> L8
        this.act = r18;     // Catch: Throwable -> L8
        r18[r13.transIndex] = 0;     // Catch: Throwable -> L8
    L41:
        Bitmap r19 = setPixels(r13, r15);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r19;
    L25:
        r15 = null;
        goto L26
    L6:
        if (this.framePointer >= 0) goto L14;
        goto L14
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        int r10 = this.header.loopCount;
        if (r10 != (-1)) goto L5;
        return 1;
    L5:
        if (r10 != 0) goto L9;
        return 0;
    L9:
        return r10 + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.header.width;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(@Nullable InputStream r10, int r11) {
        if (r10 != null) goto L4;
        this.status = 2;
    L17:
        if (r10 == null) goto L23;
        r10.close();     // Catch: IOException -> L20
    L20:
        e = move-exception;
        Log.w(TAG, "Error closing stream", e);
    L23:
        return this.status;
    L4:
        if (r11 <= 0) goto L6;
        int r12 = r11 + 4096;
    L24:
        ByteArrayOutputStream r13 = new ByteArrayOutputStream(r12);     // Catch: IOException -> L11
        byte[] r14 = new byte[16384];     // Catch: IOException -> L11
    L8:
        int r15 = r10.read(r14, 0, 16384);     // Catch: IOException -> L11
        if (r15 == (-1)) goto L13;
        r13.write(r14, 0, r15);     // Catch: IOException -> L11
        goto L8
    L13:
        r13.flush();     // Catch: IOException -> L11
        read(r13.toByteArray());     // Catch: IOException -> L11
    L11:
        e = move-exception;
        Log.w(TAG, "Error reading data from stream", e);
        goto L17
    L6:
        r12 = 16384;
        goto L24
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader r10, @NonNull byte[] r11) {
        monitor-enter(this);
        setData(r10, ByteBuffer.wrap(r11));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(@NonNull Bitmap.Config r10) {
        Bitmap.Config r11 = Bitmap.Config.ARGB_8888;
        if (r10 == r11) goto L9;
        Bitmap.Config r12 = Bitmap.Config.RGB_565;
        if (r10 == r12) goto L9;
        throw new IllegalArgumentException("Unsupported format: " + r10 + ", must be one of " + r11 + " or " + r12);
    L9:
        this.bitmapConfig = r10;
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider r10, GifHeader r11, ByteBuffer r12, int r13) {
        this(r10);
        setData(r11, r12, r13);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader r10, @NonNull ByteBuffer r11) {
        monitor-enter(this);
        setData(r10, r11, 1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider r10) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = r10;
        this.header = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader r10, @NonNull ByteBuffer r11, int r12) {
        monitor-enter(this);
        if (r12 <= 0) goto L16;
        int r13 = Integer.highestOneBit(r12);     // Catch: Throwable -> L10
        this.status = 0;     // Catch: Throwable -> L10
        this.header = r10;     // Catch: Throwable -> L10
        this.framePointer = -1;     // Catch: Throwable -> L10
        ByteBuffer r14 = r11.asReadOnlyBuffer();     // Catch: Throwable -> L10
        this.rawData = r14;     // Catch: Throwable -> L10
        r14.position(0);     // Catch: Throwable -> L10
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L10
        this.savePrevious = false;     // Catch: Throwable -> L10
        Iterator<GifFrame> r15 = r10.frames.iterator();     // Catch: Throwable -> L10
    L6:
        if (r15.hasNext() == false) goto L12;
        if (r15.next().dispose != 3) goto L6;
        this.savePrevious = true;     // Catch: Throwable -> L10
    L12:
        this.sampleSize = r13;     // Catch: Throwable -> L10
        int r16 = r10.width;     // Catch: Throwable -> L10
        this.downsampledWidth = r16 / r13;     // Catch: Throwable -> L10
        int r17 = r10.height;     // Catch: Throwable -> L10
        this.downsampledHeight = r17 / r13;     // Catch: Throwable -> L10
        this.mainPixels = this.bitmapProvider.obtainByteArray(r16 * r17);     // Catch: Throwable -> L10
        this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L16:
        throw new IllegalArgumentException("Sample size must be >=0, not: " + r12);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] r10) {
        monitor-enter(this);
        GifHeader r11 = getHeaderParser().setData(r10).parseHeader();     // Catch: Throwable -> L6
        this.header = r11;     // Catch: Throwable -> L6
        if (r10 == null) goto L8;
        setData(r11, r10);     // Catch: Throwable -> L6
    L8:
        int r12 = this.status;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }
}
