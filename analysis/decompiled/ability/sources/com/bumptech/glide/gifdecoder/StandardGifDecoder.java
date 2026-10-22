package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes2.dex */
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

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    @ColorInt
    private int averageColorsNear(int i, int i6, int i10) {
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = i; i16 < this.sampleSize + i; i16++) {
            byte[] bArr = this.mainPixels;
            if (i16 >= bArr.length || i16 >= i6) {
                break;
            }
            int i17 = this.act[bArr[i16] & 255];
            if (i17 != 0) {
                i11 += (i17 >> 24) & 255;
                i12 += (i17 >> 16) & 255;
                i13 += (i17 >> 8) & 255;
                i14 += i17 & 255;
                i15++;
            }
        }
        int i18 = i + i10;
        for (int i19 = i18; i19 < this.sampleSize + i18; i19++) {
            byte[] bArr2 = this.mainPixels;
            if (i19 >= bArr2.length || i19 >= i6) {
                break;
            }
            int i20 = this.act[bArr2[i19] & 255];
            if (i20 != 0) {
                i11 += (i20 >> 24) & 255;
                i12 += (i20 >> 16) & 255;
                i13 += (i20 >> 8) & 255;
                i14 += i20 & 255;
                i15++;
            }
        }
        if (i15 == 0) {
            return 0;
        }
        return ((i11 / i15) << 24) | ((i12 / i15) << 16) | ((i13 / i15) << 8) | (i14 / i15);
    }

    private void copyCopyIntoScratchRobust(GifFrame gifFrame) {
        int i;
        int i6;
        int i10;
        int i11;
        int[] iArr = this.mainScratch;
        int i12 = gifFrame.ih;
        int i13 = this.sampleSize;
        int i14 = i12 / i13;
        int i15 = gifFrame.iy / i13;
        int i16 = gifFrame.iw / i13;
        int i17 = gifFrame.ix / i13;
        boolean z10 = this.framePointer == 0;
        int i18 = this.downsampledWidth;
        int i19 = this.downsampledHeight;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        Boolean bool = this.isFirstFrameTransparent;
        int i20 = 8;
        int i21 = 0;
        int i22 = 0;
        int i23 = 1;
        while (i22 < i14) {
            int[] iArr3 = iArr;
            if (gifFrame.interlace) {
                if (i21 >= i14) {
                    int i24 = i23 + 1;
                    i = i14;
                    if (i24 == 2) {
                        i23 = i24;
                        i21 = 4;
                    } else if (i24 == 3) {
                        i23 = i24;
                        i20 = 4;
                        i21 = 2;
                    } else if (i24 != 4) {
                        i23 = i24;
                    } else {
                        i23 = i24;
                        i21 = 1;
                        i20 = 2;
                    }
                } else {
                    i = i14;
                }
                i6 = i21 + i20;
            } else {
                i = i14;
                i6 = i21;
                i21 = i22;
            }
            int i25 = i21 + i15;
            boolean z11 = i13 == 1;
            if (i25 < i19) {
                int i26 = i25 * i18;
                int i27 = i26 + i17;
                int i28 = i27 + i16;
                int i29 = i26 + i18;
                if (i29 < i28) {
                    i28 = i29;
                }
                i10 = i6;
                int i30 = i22 * i13 * gifFrame.iw;
                if (z11) {
                    int i31 = i27;
                    while (i31 < i28) {
                        int i32 = i31;
                        int i33 = iArr2[bArr[i30] & 255];
                        if (i33 != 0) {
                            iArr3[i32] = i33;
                        } else if (z10 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i30 += i13;
                        i31 = i32 + 1;
                    }
                } else {
                    int i34 = ((i28 - i27) * i13) + i30;
                    i11 = i13;
                    int i35 = i27;
                    while (i35 < i28) {
                        int i36 = i28;
                        int iAverageColorsNear = averageColorsNear(i30, i34, gifFrame.iw);
                        if (iAverageColorsNear != 0) {
                            iArr3[i35] = iAverageColorsNear;
                        } else if (z10 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i30 += i11;
                        i35++;
                        i28 = i36;
                    }
                    i22++;
                    i13 = i11;
                    iArr = iArr3;
                    i14 = i;
                    i21 = i10;
                }
            } else {
                i10 = i6;
            }
            i11 = i13;
            i22++;
            i13 = i11;
            iArr = iArr3;
            i14 = i;
            i21 = i10;
        }
        if (this.isFirstFrameTransparent == null) {
            this.isFirstFrameTransparent = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    private void copyIntoScratchFast(GifFrame gifFrame) {
        GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.mainScratch;
        int i = gifFrame2.ih;
        int i6 = gifFrame2.iy;
        int i10 = gifFrame2.iw;
        int i11 = gifFrame2.ix;
        boolean z10 = this.framePointer == 0;
        int i12 = this.downsampledWidth;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        int i13 = 0;
        byte b = -1;
        while (i13 < i) {
            int i14 = (i13 + i6) * i12;
            int i15 = i14 + i11;
            int i16 = i15 + i10;
            int i17 = i14 + i12;
            if (i17 < i16) {
                i16 = i17;
            }
            int i18 = gifFrame2.iw * i13;
            int i19 = i15;
            while (i19 < i16) {
                byte b5 = bArr[i18];
                int[] iArr3 = iArr;
                int i20 = b5 & 255;
                if (i20 != b) {
                    int i21 = iArr2[i20];
                    if (i21 != 0) {
                        iArr3[i19] = i21;
                    } else {
                        b = b5;
                    }
                }
                i18++;
                i19++;
                iArr = iArr3;
            }
            i13++;
            gifFrame2 = gifFrame;
        }
        Boolean bool = this.isFirstFrameTransparent;
        this.isFirstFrameTransparent = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.isFirstFrameTransparent == null && z10 && b != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v15, types: [short] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i;
        int i6;
        byte[] bArr;
        short s5;
        StandardGifDecoder standardGifDecoder = this;
        if (gifFrame != null) {
            standardGifDecoder.rawData.position(gifFrame.bufferFrameStart);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = standardGifDecoder.header;
            i = gifHeader.width;
            i6 = gifHeader.height;
        } else {
            i = gifFrame.iw;
            i6 = gifFrame.ih;
        }
        int i10 = i * i6;
        byte[] bArr2 = standardGifDecoder.mainPixels;
        if (bArr2 == null || bArr2.length < i10) {
            standardGifDecoder.mainPixels = standardGifDecoder.bitmapProvider.obtainByteArray(i10);
        }
        byte[] bArr3 = standardGifDecoder.mainPixels;
        if (standardGifDecoder.prefix == null) {
            standardGifDecoder.prefix = new short[4096];
        }
        short[] sArr = standardGifDecoder.prefix;
        if (standardGifDecoder.suffix == null) {
            standardGifDecoder.suffix = new byte[4096];
        }
        byte[] bArr4 = standardGifDecoder.suffix;
        if (standardGifDecoder.pixelStack == null) {
            standardGifDecoder.pixelStack = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        byte[] bArr5 = standardGifDecoder.pixelStack;
        int i11 = standardGifDecoder.readByte();
        int i12 = 1 << i11;
        int i13 = i12 + 1;
        int i14 = i12 + 2;
        int i15 = i11 + 1;
        int i16 = (1 << i15) - 1;
        byte b = 0;
        for (int i17 = 0; i17 < i12; i17++) {
            sArr[i17] = 0;
            bArr4[i17] = (byte) i17;
        }
        byte[] bArr6 = standardGifDecoder.block;
        int i18 = i15;
        int i19 = i14;
        int i20 = i16;
        int i21 = 0;
        int block = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = -1;
        while (true) {
            if (i21 >= i10) {
                break;
            }
            if (block == 0) {
                block = standardGifDecoder.readBlock();
                if (block <= 0) {
                    standardGifDecoder.status = 3;
                    break;
                }
                i22 = b;
            }
            i24 += (bArr6[i22] & 255) << i23;
            i22++;
            block--;
            int i29 = i23 + 8;
            int i30 = i19;
            int i31 = i18;
            int i32 = i28;
            short[] sArr2 = sArr;
            int i33 = i26;
            while (true) {
                bArr = bArr4;
                if (i29 < i31) {
                    i19 = i30;
                    i26 = i33;
                    break;
                }
                int i34 = i24 & i20;
                i24 >>= i31;
                i29 -= i31;
                if (i34 == i12) {
                    i31 = i15;
                    i30 = i14;
                    i20 = i16;
                    bArr4 = bArr;
                    i32 = -1;
                } else {
                    if (i34 == i13) {
                        i26 = i33;
                        i19 = i30;
                        break;
                    }
                    byte[] bArr7 = bArr5;
                    if (i32 == -1) {
                        bArr3[i25] = bArr[i34];
                        i25++;
                        i21++;
                        i32 = i34;
                        i33 = i32;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                    } else {
                        if (i34 >= i30) {
                            bArr7[i27] = (byte) i33;
                            i27++;
                            s5 = i32;
                        } else {
                            s5 = i34;
                        }
                        while (s5 >= i12) {
                            bArr7[i27] = bArr[s5];
                            i27++;
                            s5 = sArr2[s5];
                        }
                        int i35 = bArr[s5] & 255;
                        byte b5 = (byte) i35;
                        bArr3[i25] = b5;
                        while (true) {
                            i25++;
                            i21++;
                            if (i27 <= 0) {
                                break;
                            }
                            i27--;
                            bArr3[i25] = bArr7[i27];
                        }
                        if (i30 < 4096) {
                            sArr2[i30] = (short) i32;
                            bArr[i30] = b5;
                            i30++;
                            if ((i30 & i20) == 0 && i30 < 4096) {
                                i31++;
                                i20 += i30;
                            }
                        }
                        i32 = i34;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                        i33 = i35;
                    }
                }
            }
            i23 = i29;
            sArr = sArr2;
            bArr4 = bArr;
            b = 0;
            i28 = i32;
            i18 = i31;
            standardGifDecoder = this;
        }
        Arrays.fill(bArr3, i25, i10, b);
    }

    @NonNull
    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        Boolean bool = this.isFirstFrameTransparent;
        Bitmap bitmapObtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.bitmapConfig);
        bitmapObtain.setHasAlpha(true);
        return bitmapObtain;
    }

    private int readBlock() {
        int i = readByte();
        if (i <= 0) {
            return i;
        }
        ByteBuffer byteBuffer = this.rawData;
        byteBuffer.get(this.block, 0, Math.min(i, byteBuffer.remaining()));
        return i;
    }

    private int readByte() {
        return this.rawData.get() & 255;
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int i;
        int i6;
        Bitmap bitmap;
        int[] iArr = this.mainScratch;
        int i10 = 0;
        if (gifFrame2 == null) {
            Bitmap bitmap2 = this.previousImage;
            if (bitmap2 != null) {
                this.bitmapProvider.release(bitmap2);
            }
            this.previousImage = null;
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.dispose == 3 && this.previousImage == null) {
            Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i6 = gifFrame2.dispose) > 0) {
            if (i6 == 2) {
                if (!gifFrame.transparency) {
                    GifHeader gifHeader = this.header;
                    int i11 = gifHeader.bgColor;
                    if (gifFrame.lct == null || gifHeader.bgIndex != gifFrame.transIndex) {
                        i10 = i11;
                    }
                }
                int i12 = gifFrame2.ih;
                int i13 = this.sampleSize;
                int i14 = i12 / i13;
                int i15 = gifFrame2.iy / i13;
                int i16 = gifFrame2.iw / i13;
                int i17 = gifFrame2.ix / i13;
                int i18 = this.downsampledWidth;
                int i19 = (i15 * i18) + i17;
                int i20 = (i14 * i18) + i19;
                while (i19 < i20) {
                    int i21 = i19 + i16;
                    for (int i22 = i19; i22 < i21; i22++) {
                        iArr[i22] = i10;
                    }
                    i19 += this.downsampledWidth;
                }
            } else if (i6 == 3 && (bitmap = this.previousImage) != null) {
                int i23 = this.downsampledWidth;
                bitmap.getPixels(iArr, 0, i23, 0, 0, i23, this.downsampledHeight);
            }
        }
        decodeBitmapData(gifFrame);
        if (gifFrame.interlace || this.sampleSize != 1) {
            copyCopyIntoScratchRobust(gifFrame);
        } else {
            copyIntoScratchFast(gifFrame);
        }
        if (this.savePrevious && ((i = gifFrame.dispose) == 0 || i == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            Bitmap bitmap3 = this.previousImage;
            int i24 = this.downsampledWidth;
            bitmap3.setPixels(iArr, 0, i24, 0, 0, i24, this.downsampledHeight);
        }
        Bitmap nextBitmap = getNextBitmap();
        int i25 = this.downsampledWidth;
        nextBitmap.setPixels(iArr, 0, i25, 0, 0, i25, this.downsampledHeight);
        return nextBitmap;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            this.bitmapProvider.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            this.bitmapProvider.release(iArr);
        }
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.bitmapProvider.release(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return (this.mainScratch.length * 4) + this.rawData.limit() + this.mainPixels.length;
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
    public int getDelay(int i) {
        if (i < 0) {
            return -1;
        }
        GifHeader gifHeader = this.header;
        if (i < gifHeader.frameCount) {
            return gifHeader.frames.get(i).delay;
        }
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
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        int i;
        if (this.header.frameCount <= 0 || (i = this.framePointer) < 0) {
            return 0;
        }
        return getDelay(i);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Nullable
    public synchronized Bitmap getNextFrame() {
        try {
            if (this.header.frameCount <= 0 || this.framePointer < 0) {
                String str = TAG;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, frameCount=" + this.header.frameCount + ", framePointer=" + this.framePointer);
                }
                this.status = 1;
            }
            int i = this.status;
            if (i != 1 && i != 2) {
                this.status = 0;
                if (this.block == null) {
                    this.block = this.bitmapProvider.obtainByteArray(255);
                }
                GifFrame gifFrame = this.header.frames.get(this.framePointer);
                int i6 = this.framePointer - 1;
                GifFrame gifFrame2 = i6 >= 0 ? this.header.frames.get(i6) : null;
                int[] iArr = gifFrame.lct;
                if (iArr == null) {
                    iArr = this.header.gct;
                }
                this.act = iArr;
                if (iArr == null) {
                    String str2 = TAG;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.framePointer);
                    }
                    this.status = 1;
                    return null;
                }
                if (gifFrame.transparency) {
                    System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                    int[] iArr2 = this.pct;
                    this.act = iArr2;
                    iArr2[gifFrame.transIndex] = 0;
                    if (gifFrame.dispose == 2 && this.framePointer == 0) {
                        this.isFirstFrameTransparent = Boolean.TRUE;
                    }
                }
                return setPixels(gifFrame, gifFrame2);
            }
            String str3 = TAG;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, status=" + this.status);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getTotalIterationCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.header.width;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(@Nullable InputStream inputStream, int i) throws IOException {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i6 = inputStream.read(bArr, 0, 16384);
                    if (i6 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i6);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e6) {
                Log.w(TAG, "Error closing stream", e6);
            }
        }
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.bitmapConfig = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        setData(gifHeader, byteBuffer, i);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@NonNull GifDecoder.BitmapProvider bitmapProvider) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@NonNull GifHeader gifHeader, @NonNull ByteBuffer byteBuffer, int i) {
        try {
            if (i > 0) {
                int iHighestOneBit = Integer.highestOneBit(i);
                this.status = 0;
                this.header = gifHeader;
                this.framePointer = -1;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.rawData = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.rawData.order(ByteOrder.LITTLE_ENDIAN);
                this.savePrevious = false;
                Iterator<GifFrame> it = gifHeader.frames.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().dispose == 3) {
                        this.savePrevious = true;
                        break;
                    }
                }
                this.sampleSize = iHighestOneBit;
                int i6 = gifHeader.width;
                this.downsampledWidth = i6 / iHighestOneBit;
                int i10 = gifHeader.height;
                this.downsampledHeight = i10 / iHighestOneBit;
                this.mainPixels = this.bitmapProvider.obtainByteArray(i6 * i10);
                this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        try {
            GifHeader header = getHeaderParser().setData(bArr).parseHeader();
            this.header = header;
            if (bArr != null) {
                setData(header, bArr);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.status;
    }
}
