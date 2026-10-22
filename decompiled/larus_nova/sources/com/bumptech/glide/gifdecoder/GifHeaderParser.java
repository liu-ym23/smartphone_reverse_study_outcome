package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
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

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte) 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    private boolean err() {
        if (this.header.status == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int read() {
        return this.rawData.get() & UByte.MAX_VALUE;
    L4:
        this.header.status = 1;
        return 0;
    }

    private void readBitmap() {
        this.header.currentFrame.f33681ix = readShort();
        this.header.currentFrame.f33682iy = readShort();
        this.header.currentFrame.f33680iw = readShort();
        this.header.currentFrame.f33679ih = readShort();
        int r100 = read();
        boolean r101 = false;
        if ((r100 & 128) == 0) goto L5;
        boolean r102 = true;
    L6:
        int r103 = (int) Math.pow(2.0d, (r100 & 7) + 1);
        GifFrame r104 = this.header.currentFrame;
        if ((r100 & 64) == 0) goto L9;
        r101 = true;
    L9:
        r104.interlace = r101;
        if (r102 == false) goto L12;
        r104.lct = readColorTable(r103);
    L13:
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (err() == false) goto L16;
        return;
    L16:
        GifHeader r105 = this.header;
        r105.frameCount++;
        r105.frames.add(r105.currentFrame);
        return;
    L12:
        r104.lct = null;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    private void readHeader() {
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
    L4:
        if (r101 >= 6) goto L7;
        r100.append((char) read());
        r101 = r101 + 1;
        goto L4
    L7:
        if (r100.toString().startsWith("GIF") == true) goto L10;
        this.header.status = 1;
        return;
    L10:
        readLSD();
        if (this.header.gctFlag == true) goto L13;
        return;
    L13:
        if (err() == true) goto L18;
        GifHeader r102 = this.header;
        r102.gct = readColorTable(r102.gctSize);
        GifHeader r103 = this.header;
        r103.bgColor = r103.gct[r103.bgIndex];
        return;
    }

    private void readLSD() {
        this.header.width = readShort();
        this.header.height = readShort();
        int r100 = read();
        GifHeader r101 = this.header;
        if ((r100 & 128) == 0) goto L5;
        boolean r102 = true;
    L6:
        r101.gctFlag = r102;
        r101.gctSize = (int) Math.pow(2.0d, (r100 & 7) + 1);
        this.header.bgIndex = read();
        this.header.pixelAspect = read();
        return;
    L5:
        r102 = false;
        goto L6
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    public GifHeader parseHeader() {
        if (this.rawData == null) goto L16;
        if (err() == true) goto L7;
        readHeader();
        if (err() == true) goto L14;
        readContents();
        GifHeader r100 = this.header;
        if (r100.frameCount >= 0) goto L14;
        r100.status = 1;
    L14:
        return this.header;
    L7:
        return this.header;
    L16:
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public GifHeaderParser() {
        this.block = new byte[256];
        this.blockSize = 0;
    }

    private void readBlock() {
        int r100 = read();
        this.blockSize = r100;
        if (r100 <= 0) goto L17;
        int r101 = 0;
    L14:
        int r102 = this.blockSize;     // Catch: Exception -> L9
        if (r101 >= r102) goto L18;
        int r103 = r102 - r101;     // Catch: Exception -> L9
        this.rawData.get(this.block, r101, r103);     // Catch: Exception -> L9
        r101 = r101 + r103;
        goto L14
    L18:
        return;
    L10:
        if (Log.isLoggable(TAG, 3) == true) goto L12;
    L12:
        this.header.status = 1;
        return;
    }

    private void readContents() {
        readContents(Integer.MAX_VALUE);
    }

    private void readGraphicControlExt() {
        read();
        int r100 = read();
        GifFrame r101 = this.header.currentFrame;
        int r102 = (r100 & 28) >> 2;
        r101.dispose = r102;
        boolean r103 = true;
        if (r102 != 0) goto L6;
        r101.dispose = 1;
    L6:
        if ((r100 & 1) != 0) goto L9;
        r103 = false;
    L9:
        r101.transparency = r103;
        int r104 = readShort();
        if (r104 >= 2) goto L12;
        r104 = 10;
    L12:
        GifFrame r105 = this.header.currentFrame;
        r105.delay = r104 * 10;
        r105.transIndex = read();
        read();
    }

    private void readNetscapeExt() {
    L2:
        readBlock();
        byte[] r100 = this.block;
        if (r100[0] != 1) goto L6;
        int r101 = r100[1] & UByte.MAX_VALUE;
        int r102 = r100[2] & UByte.MAX_VALUE;
        int r103 = (r102 << 8) | r101;
        this.header.loopCount = r103;
    L6:
        if (this.blockSize <= 0) goto L9;
        if (err() == false) goto L2;
        return;
    }

    private void skip() {
    L2:
        int r100 = read();
        int r101 = Math.min(this.rawData.position() + r100, this.rawData.limit());
        this.rawData.position(r101);
        if (r100 > 0) goto L2;
    }

    private void skipImageData() {
        read();
        skip();
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

    private int[] readColorTable(int r110) {
        byte[] r100 = new byte[r110 * 3];
        int[] r101 = null;
        this.rawData.get(r100);     // Catch: BufferUnderflowException -> L7
        r101 = new int[256];     // Catch: BufferUnderflowException -> L7
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r110) goto L8;
        int r104 = r103 + 1;     // Catch: BufferUnderflowException -> L7
        int r105 = r100[r103] & UByte.MAX_VALUE;     // Catch: BufferUnderflowException -> L7
        int r106 = r104 + 1;     // Catch: BufferUnderflowException -> L7
        int r107 = r100[r104] & UByte.MAX_VALUE;     // Catch: BufferUnderflowException -> L7
        int r108 = r106 + 1;     // Catch: BufferUnderflowException -> L7
        int r109 = r102 + 1;     // Catch: BufferUnderflowException -> L7
        int r111 = ((r105 << 16) | (-16777216)) | (r107 << 8);     // Catch: BufferUnderflowException -> L7
        r101[r102] = r111 | (r100[r106] & UByte.MAX_VALUE);     // Catch: BufferUnderflowException -> L7
        r103 = r108;
        r102 = r109;
    L8:
        return r101;
    L7:
        this.header.status = 1;
        goto L8
    }

    private void readContents(int r100) {
        boolean r101 = false;
    L3:
        if (r101 == true) goto L40;
        if (err() == true) goto L71;
        if (this.header.frameCount > r100) goto L72;
        int r102 = read();
        if (r102 != 33) goto L11;
        int r103 = read();
        if (r103 != 1) goto L23;
        skip();
        goto L3
    L23:
        if (r103 != 249) goto L25;
        GifHeader r104 = this.header;
        r104.currentFrame = new GifFrame();
        readGraphicControlExt();
        goto L3
    L25:
        if (r103 != 254) goto L27;
        skip();
        goto L3
    L27:
        if (r103 != 255) goto L28;
        readBlock();
        StringBuilder r105 = new StringBuilder();
        int r106 = 0;
    L31:
        if (r106 >= 11) goto L34;
        r105.append((char) this.block[r106]);
        r106 = r106 + 1;
        goto L31
    L34:
        if (r105.toString().equals("NETSCAPE2.0") == true) goto L35;
        skip();
        goto L3
    L35:
        readNetscapeExt();
        goto L3
    L28:
        skip();
        goto L3
    L11:
        if (r102 != 44) goto L13;
        GifHeader r107 = this.header;
        if (r107.currentFrame != null) goto L19;
        r107.currentFrame = new GifFrame();
    L19:
        readBitmap();
        goto L3
    L13:
        if (r102 != 59) goto L14;
        r101 = true;
        goto L3
    L14:
        this.header.status = 1;
        goto L3
    L72:
        return;
    L71:
        return;
    }

    public GifHeaderParser setData(ByteBuffer r100) {
        reset();
        ByteBuffer r101 = r100.asReadOnlyBuffer();
        this.rawData = r101;
        r101.position(0);
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public GifHeaderParser setData(byte[] r100) {
        if (r100 == null) goto L4;
        setData(ByteBuffer.wrap(r100));
    L5:
        return this;
    L4:
        this.rawData = null;
        this.header.status = 2;
        goto L5
    }
}
