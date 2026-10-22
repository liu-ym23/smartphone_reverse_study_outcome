package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.primitives.UnsignedBytes;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class GifHeaderParser {
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int DESCRIPTOR_MASK_INTERLACE_FLAG = 64;
    private static final int DESCRIPTOR_MASK_LCT_FLAG = 128;
    private static final int DESCRIPTOR_MASK_LCT_SIZE = 7;
    private static final int EXTENSION_INTRODUCER = 33;
    private static final int GCE_DISPOSAL_METHOD_SHIFT = 2;
    private static final int GCE_MASK_DISPOSAL_METHOD = 28;
    private static final int GCE_MASK_TRANSPARENT_COLOR_FLAG = 1;
    private static final int IMAGE_SEPARATOR = 44;
    private static final int LABEL_APPLICATION_EXTENSION = 255;
    private static final int LABEL_COMMENT_EXTENSION = 254;
    private static final int LABEL_GRAPHIC_CONTROL_EXTENSION = 249;
    private static final int LABEL_PLAIN_TEXT_EXTENSION = 1;
    private static final int LSD_MASK_GCT_FLAG = 128;
    private static final int LSD_MASK_GCT_SIZE = 7;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_BLOCK_SIZE = 256;
    static final int MIN_FRAME_DELAY = 2;
    private static final String TAG = "GifHeaderParser";
    private static final int TRAILER = 59;
    private final byte[] block;
    private int blockSize;
    private GifHeader header;
    private ByteBuffer rawData;

    public GifHeaderParser() {
        this.block = new byte[256];
        this.blockSize = 0;
    }

    private boolean err() {
        if (this.header.status == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int read() {
        return this.rawData.get() & UnsignedBytes.MAX_VALUE;
    L4:
        this.header.status = 1;
        return 0;
    }

    private void readBitmap() {
        this.header.currentFrame.ix = readShort();
        this.header.currentFrame.iy = readShort();
        this.header.currentFrame.iw = readShort();
        this.header.currentFrame.ih = readShort();
        int r10 = read();
        boolean r11 = false;
        if ((r10 & 128) == 0) goto L5;
        boolean r12 = true;
    L6:
        int r13 = (int) Math.pow(2.0d, (r10 & 7) + 1);
        GifFrame r14 = this.header.currentFrame;
        if ((r10 & 64) == 0) goto L9;
        r11 = true;
    L9:
        r14.interlace = r11;
        if (r12 == false) goto L12;
        r14.lct = readColorTable(r13);
    L13:
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (err() == false) goto L16;
        return;
    L16:
        GifHeader r15 = this.header;
        r15.frameCount++;
        r15.frames.add(r15.currentFrame);
        return;
    L12:
        r14.lct = null;
        goto L13
    L5:
        r12 = false;
        goto L6
    }

    private void readBlock() {
        int r10 = read();
        this.blockSize = r10;
        if (r10 <= 0) goto L18;
        int r11 = 0;
        int r12 = 0;
    L15:
        int r13 = this.blockSize;     // Catch: Exception -> L9
        if (r11 >= r13) goto L19;
        r12 = r13 - r11;     // Catch: Exception -> L9
        this.rawData.get(this.block, r11, r12);     // Catch: Exception -> L9
        r11 = r11 + r12;
        goto L15
    L19:
        return;
    L9:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L13;
        Log.d(TAG, "Error Reading Block n: " + r11 + " count: " + r12 + " blockSize: " + this.blockSize, e);
    L13:
        this.header.status = 1;
        return;
    }

    @Nullable
    private int[] readColorTable(int r10) {
        byte[] r11 = new byte[r10 * 3];
        int[] r12 = null;
        this.rawData.get(r11);     // Catch: BufferUnderflowException -> L7
        r12 = new int[256];     // Catch: BufferUnderflowException -> L7
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10) goto L12;
        int r15 = r11[r14] & UnsignedBytes.MAX_VALUE;     // Catch: BufferUnderflowException -> L7
        int r16 = r14 + 2;     // Catch: BufferUnderflowException -> L7
        int r17 = r11[r14 + 1] & UnsignedBytes.MAX_VALUE;     // Catch: BufferUnderflowException -> L7
        r14 = r14 + 3;     // Catch: BufferUnderflowException -> L7
        int r18 = r13 + 1;     // Catch: BufferUnderflowException -> L7
        r12[r13] = ((r17 << 8) | ((r15 << 16) | (-16777216))) | (r11[r16] & UnsignedBytes.MAX_VALUE);     // Catch: BufferUnderflowException -> L7
        r13 = r18;
    L12:
        return r12;
    L7:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L11;
        Log.d(TAG, "Format Error Reading Color Table", e);
    L11:
        this.header.status = 1;
        goto L12
    }

    private void readContents() {
        readContents(Channel.UNLIMITED);
    }

    private void readGraphicControlExt() {
        read();
        int r10 = read();
        GifFrame r11 = this.header.currentFrame;
        int r12 = (r10 & 28) >> 2;
        r11.dispose = r12;
        boolean r13 = true;
        if (r12 != 0) goto L6;
        r11.dispose = 1;
    L6:
        if ((r10 & 1) != 0) goto L9;
        r13 = false;
    L9:
        r11.transparency = r13;
        int r14 = readShort();
        if (r14 >= 2) goto L12;
        r14 = 10;
    L12:
        GifFrame r15 = this.header.currentFrame;
        r15.delay = r14 * 10;
        r15.transIndex = read();
        read();
    }

    private void readHeader() {
        StringBuilder r10 = new StringBuilder();
        int r11 = 0;
    L4:
        if (r11 >= 6) goto L7;
        r10.append((char) read());
        r11 = r11 + 1;
        goto L4
    L7:
        if (r10.toString().startsWith("GIF") == true) goto L10;
        this.header.status = 1;
        return;
    L10:
        readLSD();
        if (this.header.gctFlag == true) goto L13;
        return;
    L13:
        if (err() == true) goto L18;
        GifHeader r12 = this.header;
        r12.gct = readColorTable(r12.gctSize);
        GifHeader r13 = this.header;
        r13.bgColor = r13.gct[r13.bgIndex];
        return;
    }

    private void readLSD() {
        this.header.width = readShort();
        this.header.height = readShort();
        int r10 = read();
        GifHeader r11 = this.header;
        if ((r10 & 128) == 0) goto L5;
        boolean r12 = true;
    L6:
        r11.gctFlag = r12;
        r11.gctSize = (int) Math.pow(2.0d, (r10 & 7) + 1);
        this.header.bgIndex = read();
        this.header.pixelAspect = read();
        return;
    L5:
        r12 = false;
        goto L6
    }

    private void readNetscapeExt() {
    L2:
        readBlock();
        byte[] r10 = this.block;
        if (r10[0] != 1) goto L6;
        int r11 = r10[1] & UnsignedBytes.MAX_VALUE;
        int r12 = r10[2] & UnsignedBytes.MAX_VALUE;
        int r13 = (r12 << 8) | r11;
        this.header.loopCount = r13;
    L6:
        if (this.blockSize <= 0) goto L9;
        if (err() == false) goto L2;
        return;
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte) 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    private void skip() {
    L2:
        int r10 = read();
        int r11 = Math.min(this.rawData.position() + r10, this.rawData.limit());
        this.rawData.position(r11);
        if (r10 > 0) goto L2;
    }

    private void skipImageData() {
        read();
        skip();
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    public boolean isAnimated() {
        readHeader();
        if (err() == true) goto L6;
        readContents(2);
    L6:
        if (this.header.frameCount > 1) goto L10;
        return false;
    L10:
        return true;
    }

    @NonNull
    public GifHeader parseHeader() {
        if (this.rawData == null) goto L16;
        if (err() == true) goto L7;
        readHeader();
        if (err() == true) goto L14;
        readContents();
        GifHeader r10 = this.header;
        if (r10.frameCount >= 0) goto L14;
        r10.status = 1;
    L14:
        return this.header;
    L7:
        return this.header;
    L16:
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public GifHeaderParser setData(@NonNull ByteBuffer r10) {
        reset();
        ByteBuffer r11 = r10.asReadOnlyBuffer();
        this.rawData = r11;
        r11.position(0);
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    private void readContents(int r10) {
        boolean r11 = false;
    L3:
        if (r11 == true) goto L40;
        if (err() == true) goto L71;
        if (this.header.frameCount > r10) goto L72;
        int r12 = read();
        if (r12 != 33) goto L11;
        int r13 = read();
        if (r13 != 1) goto L23;
        skip();
        goto L3
    L23:
        if (r13 != LABEL_GRAPHIC_CONTROL_EXTENSION) goto L25;
        this.header.currentFrame = new GifFrame();
        readGraphicControlExt();
        goto L3
    L25:
        if (r13 != LABEL_COMMENT_EXTENSION) goto L27;
        skip();
        goto L3
    L27:
        if (r13 != 255) goto L28;
        readBlock();
        StringBuilder r14 = new StringBuilder();
        int r15 = 0;
    L31:
        if (r15 >= 11) goto L34;
        r14.append((char) this.block[r15]);
        r15 = r15 + 1;
        goto L31
    L34:
        if (r14.toString().equals("NETSCAPE2.0") == true) goto L35;
        skip();
        goto L3
    L35:
        readNetscapeExt();
        goto L3
    L28:
        skip();
        goto L3
    L11:
        if (r12 != 44) goto L13;
        GifHeader r16 = this.header;
        if (r16.currentFrame != null) goto L19;
        r16.currentFrame = new GifFrame();
    L19:
        readBitmap();
        goto L3
    L13:
        if (r12 != 59) goto L14;
        r11 = true;
        goto L3
    L14:
        this.header.status = 1;
        goto L3
    L72:
        return;
    L71:
        return;
    }

    public GifHeaderParser setData(@Nullable byte[] r10) {
        if (r10 == null) goto L4;
        setData(ByteBuffer.wrap(r10));
    L5:
        return this;
    L4:
        this.rawData = null;
        this.header.status = 2;
        goto L5
    }
}
