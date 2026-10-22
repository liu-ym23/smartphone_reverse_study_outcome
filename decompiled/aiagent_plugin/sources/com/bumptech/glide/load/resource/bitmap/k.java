package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: DefaultImageHeaderParser.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements ImageHeaderParser {
    private static final String TAG = "DfltImageHeaderParser";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f3802a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f3803b = null;

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f3804a;

        a(ByteBuffer r1) {
            this.f3804a = r1;
            r1.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public short a() {
            if (this.f3804a.remaining() < 1) goto L7;
            return (short) (this.f3804a.get() & 255);
        L7:
            throw new c.a();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public int b() {
            int r0 = a() << 8;
            return a() | r0;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public int a(byte[] r2, int r3) {
            int r4 = Math.min(r3, this.f3804a.remaining());
            if (r4 != 0) goto L6;
            return -1;
        L6:
            this.f3804a.get(r2, 0, r4);
            return r4;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public long a(long r3) {
            int r4 = (int) Math.min(this.f3804a.remaining(), r3);
            ByteBuffer r2 = this.f3804a;
            r2.position(r2.position() + r4);
            return r4;
        }
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f3805a;

        b(byte[] r2, int r3) {
            this.f3805a = (ByteBuffer) ZeusTransformUtils.preCheckCast(ByteBuffer.wrap(r2).order(ByteOrder.BIG_ENDIAN).limit(r3), ByteBuffer.class, "com.obric.aiagent.plugin");
        }

        void a(ByteOrder r1) {
            this.f3805a.order(r1);
        }

        int a() {
            return this.f3805a.remaining();
        }

        int a(int r2) {
            if (a(r2, 4) == true) goto L7;
            return -1;
        L7:
            return this.f3805a.getInt(r2);
        }

        short b(int r2) {
            if (a(r2, 2) == true) goto L7;
            return -1;
        L7:
            return this.f3805a.getShort(r2);
        }

        private boolean a(int r1, int r2) {
            if ((this.f3805a.remaining() - r1) < r2) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private interface c {

        /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
        public static final class a extends IOException {
            a() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a(byte[] r1, int r2);

        long a(long r1);

        short a();

        int b();
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f3806a;

        d(InputStream r1) {
            this.f3806a = r1;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public short a() {
            int r1 = this.f3806a.read();
            if (r1 == (-1)) goto L7;
            return (short) r1;
        L7:
            throw new c.a();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public int b() {
            int r0 = a() << 8;
            return a() | r0;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public int a(byte[] r5, int r6) {
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r0 >= r6) goto L8;
            r1 = this.f3806a.read(r5, r0, r6 - r0);
            if (r1 == (-1)) goto L8;
            r0 = r0 + r1;
        L8:
            if (r0 != 0) goto L13;
            if (r1 != (-1)) goto L13;
            throw new c.a();
        L13:
            return r0;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.c
        public long a(long r8) {
            if (r8 >= 0) goto L5;
            return 0;
        L5:
            long r2 = r8;
        L7:
            if (r2 <= 0) goto L16;
            long r4 = this.f3806a.skip(r2);
            if (r4 > 0) goto L10;
            if (this.f3806a.read() == (-1)) goto L16;
            r4 = 1;
        L10:
            r2 = r2 - r4;
        L16:
            return r8 - r2;
        }
    }

    private static int a(int r0, int r1) {
        return (r0 + 2) + (r1 * 12);
    }

    private static boolean a(int r2) {
        if ((r2 & 65496) != 65496) goto L5;
    L10:
        return true;
    L5:
        if (r2 == 19789) goto L10;
        if (r2 == 18761) goto L10;
        return false;
    }

    public k() {
    }

    static {
        f3802a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
        f3803b = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream r4) {
        return getType(new d((InputStream) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r4), InputStream.class, "com.obric.aiagent.plugin")));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer r4) {
        return getType(new a((ByteBuffer) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r4), ByteBuffer.class, "com.obric.aiagent.plugin")));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(InputStream r4, com.bumptech.glide.load.engine.a.b r5) {
        com.bumptech.glide.load.engine.a.b r6 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        return a(new d((InputStream) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r4), InputStream.class, "com.obric.aiagent.plugin")), (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r6), com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin"));
    }

    private ImageHeaderParser.ImageType getType(c r5) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
        int r6 = r4.b();     // Catch: c.a -> L49
        if (r6 == 65496) goto L6;
        int r7 = (r6 << 8) | r4.a();     // Catch: c.a -> L49
        if (r7 == 4671814) goto L10;
        int r8 = (r7 << 8) | r4.a();     // Catch: c.a -> L49
        if (r8 != (-1991225785)) goto L22;
        r4.a(21);     // Catch: c.a -> L49
        if (r4.a() < 3) goto L18;
        return ImageHeaderParser.ImageType.PNG_A;
    L18:
        return ImageHeaderParser.ImageType.PNG;
    L20:
        return ImageHeaderParser.ImageType.PNG;
    L22:
        if (r8 != 1380533830) goto L24;
        r4.a(4);     // Catch: c.a -> L49
        if (((r4.b() << 16) | r4.b()) != 1464156752) goto L28;
        int r9 = (r4.b() << 16) | r4.b();     // Catch: c.a -> L49
        if ((r9 & (-256)) != 1448097792) goto L32;
        int r10 = r9 & 255;     // Catch: c.a -> L49
        if (r10 != 88) goto L41;
        r4.a(4);     // Catch: c.a -> L49
        if ((r4.a() & 16) == 0) goto L39;
        return ImageHeaderParser.ImageType.WEBP_A;
    L39:
        return ImageHeaderParser.ImageType.WEBP;
    L41:
        if (r10 != 76) goto L48;
        r4.a(4);     // Catch: c.a -> L49
        if ((r4.a() & 8) == 0) goto L46;
        return ImageHeaderParser.ImageType.WEBP_A;
    L46:
        return ImageHeaderParser.ImageType.WEBP;
    L48:
        return ImageHeaderParser.ImageType.WEBP;
    L32:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L28:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L24:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L10:
        return ImageHeaderParser.ImageType.GIF;
    L6:
        return ImageHeaderParser.ImageType.JPEG;
    L50:
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    private int a(c r8, com.bumptech.glide.load.engine.a.b r9) {
        c r10 = (c) ZeusTransformUtils.wrapperContextForParams(r8, c.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.b r11 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        int r3 = r10.b();     // Catch: c.a -> L23
        if (a(r3) == false) goto L7;
        int r4 = a(r10);     // Catch: c.a -> L23
        if (r4 == (-1)) goto L13;
        byte[] r0 = (byte[]) ZeusTransformUtils.preCheckCast(r11.a(r4, byte[].class), byte[].class, "com.obric.aiagent.plugin");     // Catch: c.a -> L23
        int r7 = a(r10, r0, r4);     // Catch: Throwable -> L20
        r11.a(r0);     // Catch: c.a -> L23
        return r7;
    L20:
        th = move-exception;
        r11.a(r0);     // Catch: c.a -> L23
        throw th;     // Catch: c.a -> L23
    L13:
        if (a(TAG, 3) == false) goto L15;
        a(TAG, "Failed to parse exif segment length, or exif segment not found");     // Catch: c.a -> L23
    L15:
        return -1;
    L7:
        if (a(TAG, 3) == false) goto L9;
        a(TAG, "Parser doesn't handle magic number: " + r3);     // Catch: c.a -> L23
    L9:
        return -1;
    L23:
        return -1;
    }

    private int a(c r4, byte[] r5, int r6) {
        int r7 = ((c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin")).a(r5, r6);
        if (r7 == r6) goto L9;
        if (a(TAG, 3) == false) goto L7;
        a(TAG, "Unable to read exif segment data, length: " + r6 + ", actually read: " + r7);
    L7:
        return -1;
    L9:
        if (a(r5, r6) == false) goto L13;
        return a(new b(r5, r6));
    L13:
        if (a(TAG, 3) == false) goto L15;
        a(TAG, "Missing jpeg exif preamble");
    L15:
        return -1;
    }

    private boolean a(byte[] r4, int r5) {
        if (r4 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == false) goto L17;
        int r0 = 0;
    L10:
        byte[] r1 = f3802a;
        if (r0 >= r1.length) goto L17;
        if (r4[r0] != r1[r0]) goto L20;
        r0 = r0 + 1;
        goto L10
    L20:
        return false;
    L17:
        return r6;
    L5:
        if (r5 <= f3802a.length) goto L7;
        r6 = true;
        goto L8
    }

    private int a(c r9) {
        c r8 = (c) ZeusTransformUtils.wrapperContextForParams(r9, c.class, "com.obric.aiagent.plugin");
    L3:
        short r10 = r8.a();
        if (r10 != 255) goto L6;
        short r11 = r8.a();
        if (r11 == 218) goto L11;
        if (r11 == 217) goto L15;
        int r0 = r8.b() - 2;
        if (r11 == 225) goto L26;
        long r4 = r0;
        long r6 = r8.a(r4);
        if (r6 == r4) goto L3;
        if (a(TAG, 3) == false) goto L25;
        a(TAG, "Unable to skip enough data, type: " + r11 + ", wanted to skip: " + r0 + ", but actually skipped: " + r6);
    L25:
        return -1;
    L26:
        return r0;
    L15:
        if (a(TAG, 3) == false) goto L17;
        a(TAG, "Found MARKER_EOI in exif segment");
    L17:
        return -1;
    L11:
        return -1;
    L6:
        if (a(TAG, 3) == false) goto L8;
        a(TAG, "Unknown segmentId=" + r10);
    L8:
        return -1;
    }

    private static int a(b r12) {
        short r1 = r12.b(6);
        if (r1 != 18761) goto L5;
        ByteOrder r2 = ByteOrder.LITTLE_ENDIAN;
    L12:
        r12.a(r2);
        int r3 = r12.a(10) + 6;
        short r0 = r12.b(r3);
        int r4 = 0;
    L13:
        if (r4 >= r0) goto L56;
        int r5 = a(r3, r4);
        short r6 = r12.b(r5);
        if (r6 != 274) goto L55;
        short r7 = r12.b(r5 + 2);
        if (r7 < 1) goto L53;
        if (r7 > 12) goto L53;
        int r8 = r12.a(r5 + 4);
        if (r8 >= 0) goto L28;
        if (a(TAG, 3) == false) goto L55;
        a(TAG, "Negative tiff component count");
        goto L55
    L28:
        if (a(TAG, 3) == false) goto L30;
        a(TAG, "Got tagIndex=" + r4 + " tagType=" + r6 + " formatCode=" + r7 + " componentCount=" + r8);
    L30:
        int r9 = r8 + f3803b[r7];
        if (r9 > 4) goto L33;
        int r10 = r5 + 8;
        if (r10 < 0) goto L50;
        if (r10 > r12.a()) goto L50;
        if (r9 < 0) goto L47;
        if ((r9 + r10) > r12.a()) goto L47;
        return r12.b(r10);
    L47:
        if (a(TAG, 3) == false) goto L55;
        a(TAG, "Illegal number of bytes for TI tag data tagType=" + r6);
    L50:
        if (a(TAG, 3) == false) goto L55;
        a(TAG, "Illegal tagValueOffset=" + r10 + " tagType=" + r6);
        goto L55
    L33:
        if (a(TAG, 3) == false) goto L55;
        a(TAG, "Got byte count > 4, not orientation, continuing, formatCode=" + r7);
    L53:
        if (a(TAG, 3) == false) goto L55;
        a(TAG, "Got invalid format code = " + r7);
    L55:
        r4 = r4 + 1;
        goto L13
    L56:
        return -1;
    L5:
        if (r1 != 19789) goto L7;
        r2 = ByteOrder.BIG_ENDIAN;
        goto L12
    L7:
        if (a(TAG, 3) == false) goto L9;
        a(TAG, "Unknown endianness = " + r1);
    L9:
        r2 = ByteOrder.BIG_ENDIAN;
        goto L12
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
