package com.bumptech.glide.integration.webp;

import android.content.Context;
import androidx.collection.LruCache;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.util.Preconditions;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes39.dex */
public class WebpHeaderParser {
    public static final int MAX_WEBP_HEADER_SIZE = 21;
    public static final int MIN_WEBP_HEADER_SIZE = 16;
    private static final int RIFF_HEADER = 1380533830;
    private static final String TAG = "WebpHeaderParser";
    private static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
    private static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    private static final int WEBP_EXTENDED_ANIM_FLAG = 2;
    private static final int WEBP_HEADER = 1464156752;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;
    private static final int WEBP_VP8L_HEADER = 1448097868;
    private static final int WEBP_VP8X_HEADER = 1448097880;
    private static final int WEBP_VP8_HEADER = 1448097824;
    public static final boolean sIsExtendedWebpSupported = false;
    private static final LruCache<String, Boolean> sWebpCache = null;

    public static final class ByteArrayReader implements Reader {
        private final byte[] data;
        private final int offset;
        private int pos;
        private final int size;

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public int getByte() throws IOException {
            int r100 = this.pos;
            if (r100 < (this.offset + this.size)) goto L6;
            return -1;
        L6:
            byte[] r101 = this.data;
            this.pos = r100 + 1;
            return r101[r100];
        }

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public int getUInt16() throws IOException {
            return ((getByte() << 8) & 65280) | (getByte() & 255);
        }

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public short getUInt8() throws IOException {
            return (short) (getByte() & 255);
        }

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public long skip(long r100) throws IOException {
            int r101 = (int) Math.min((this.offset + this.size) - this.pos, r100);
            this.pos += r101;
            return r101;
        }

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public int read(byte[] r100, int r101) throws IOException {
            int r102 = Math.min((this.offset + this.size) - this.pos, r101);
            if (r102 != 0) goto L6;
            return -1;
        L6:
            System.arraycopy(this.data, this.pos, r100, 0, r102);
            return r102;
        }

        public ByteArrayReader(byte[] r100, int r101, int r102) {
            this.data = r100;
            this.offset = r101;
            this.size = r102;
            this.pos = r101;
        }
    }

    public static final class ByteBufferReader implements Reader {
        private final ByteBuffer byteBuffer;

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public int getByte() throws IOException {
            if (this.byteBuffer.remaining() >= 1) goto L7;
            return -1;
        L7:
            return this.byteBuffer.get();
        }

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public int getUInt16() throws IOException {
            return ((getByte() << 8) & 65280) | (getByte() & 255);
        }

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public short getUInt8() throws IOException {
            return (short) (getByte() & 255);
        }

        public ByteBufferReader(ByteBuffer r100) {
            this.byteBuffer = r100;
            r100.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public long skip(long r100) throws IOException {
            int r101 = (int) Math.min(this.byteBuffer.remaining(), r100);
            ByteBuffer r102 = this.byteBuffer;
            r102.position(r102.position() + r101);
            return r101;
        }

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public int read(byte[] r100, int r101) throws IOException {
            int r102 = Math.min(r101, this.byteBuffer.remaining());
            if (r102 != 0) goto L6;
            return -1;
        L6:
            this.byteBuffer.get(r100, 0, r102);
            return r102;
        }
    }

    public interface Reader {
        int getByte() throws IOException;

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] r100, int r101) throws IOException;

        long skip(long r100) throws IOException;
    }

    public static final class StreamReader implements Reader {

        /* JADX INFO: renamed from: is, reason: collision with root package name */
        private final InputStream f33687is;

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public int getByte() throws IOException {
            return this.f33687is.read();
        }

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public int getUInt16() throws IOException {
            return ((this.f33687is.read() << 8) & 65280) | (this.f33687is.read() & 255);
        }

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public short getUInt8() throws IOException {
            return (short) (this.f33687is.read() & 255);
        }

        public StreamReader(InputStream r100) {
            this.f33687is = r100;
        }

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public long skip(long r100) throws IOException {
            if (r100 >= 0) goto L5;
            return 0;
        L5:
            long r101 = r100;
        L7:
            if (r101 <= 0) goto L16;
            long r102 = this.f33687is.skip(r101);
            if (r102 > 0) goto L10;
            if (this.f33687is.read() == (-1)) goto L16;
            r102 = 1;
        L10:
            r101 = r101 - r102;
        L16:
            return r100 - r101;
        }

        @Override // com.bumptech.glide.integration.webp.WebpHeaderParser.Reader
        public int read(byte[] r100, int r101) throws IOException {
            int r102 = r101;
        L3:
            if (r102 <= 0) goto L8;
            int r103 = this.f33687is.read(r100, r101 - r102, r102);
            if (r103 == (-1)) goto L8;
            r102 = r102 - r103;
        L8:
            return r101 - r102;
        }
    }

    public static final enum WebpImageType extends Enum<WebpImageType> {
        private static final /* synthetic */ WebpImageType[] $VALUES = null;
        public static final WebpImageType NONE_WEBP = null;
        public static final WebpImageType WEBP_EXTENDED = null;
        public static final WebpImageType WEBP_EXTENDED_ANIMATED = null;
        public static final WebpImageType WEBP_EXTENDED_WITH_ALPHA = null;
        public static final WebpImageType WEBP_LOSSLESS = null;
        public static final WebpImageType WEBP_LOSSLESS_WITH_ALPHA = null;
        public static final WebpImageType WEBP_SIMPLE = null;
        private final boolean hasAlpha;
        private final boolean hasAnimation;

        static {
            WebpImageType r100 = new WebpImageType("WEBP_SIMPLE", 0, false, false);
            WEBP_SIMPLE = r100;
            WebpImageType r101 = new WebpImageType("WEBP_LOSSLESS", 1, false, false);
            WEBP_LOSSLESS = r101;
            WebpImageType r102 = new WebpImageType("WEBP_LOSSLESS_WITH_ALPHA", 2, true, false);
            WEBP_LOSSLESS_WITH_ALPHA = r102;
            WebpImageType r103 = new WebpImageType("WEBP_EXTENDED", 3, false, false);
            WEBP_EXTENDED = r103;
            WebpImageType r104 = new WebpImageType("WEBP_EXTENDED_WITH_ALPHA", 4, true, false);
            WEBP_EXTENDED_WITH_ALPHA = r104;
            WebpImageType r105 = new WebpImageType("WEBP_EXTENDED_ANIMATED", 5, false, true);
            WEBP_EXTENDED_ANIMATED = r105;
            WebpImageType r110 = new WebpImageType("NONE_WEBP", 6, false, false);
            NONE_WEBP = r110;
            $VALUES = new WebpImageType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static WebpImageType[] values() {
            return (WebpImageType[]) $VALUES.clone();
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public boolean hasAnimation() {
            return this.hasAnimation;
        }

        public static WebpImageType valueOf(String r100) {
            return (WebpImageType) r27.a.a(WebpImageType.class, r100);
        }

        private WebpImageType(String r100, int r101, boolean r102, boolean r103) {
            super(r100, r101);
            this.hasAlpha = r102;
            this.hasAnimation = r103;
        }
    }

    public WebpHeaderParser() {
    }

    public static boolean isExtendedWebpSupported() {
        return true;
    }

    static {
        sIsExtendedWebpSupported = isExtendedWebpSupported();
        sWebpCache = new LruCache(100);
    }

    private static WebpImageType getType(Reader r100) throws IOException {
        if ((((r100.getUInt16() << 16) & (-65536)) | (r100.getUInt16() & 65535)) != RIFF_HEADER) goto L5;
        r100.skip(4);
        if ((((r100.getUInt16() << 16) & (-65536)) | (r100.getUInt16() & 65535)) != WEBP_HEADER) goto L9;
        int r101 = ((r100.getUInt16() << 16) & (-65536)) | (r100.getUInt16() & 65535);
        if (r101 != WEBP_VP8_HEADER) goto L15;
        return WebpImageType.WEBP_SIMPLE;
    L15:
        if (r101 != WEBP_VP8L_HEADER) goto L22;
        r100.skip(4);
        if ((r100.getByte() & 8) == 0) goto L20;
        return WebpImageType.WEBP_LOSSLESS_WITH_ALPHA;
    L20:
        return WebpImageType.WEBP_LOSSLESS;
    L22:
        if (r101 != WEBP_VP8X_HEADER) goto L34;
        r100.skip(4);
        int r102 = r100.getByte();
        if ((r102 & 2) == 0) goto L28;
        return WebpImageType.WEBP_EXTENDED_ANIMATED;
    L28:
        if ((r102 & 16) == 0) goto L32;
        return WebpImageType.WEBP_EXTENDED_WITH_ALPHA;
    L32:
        return WebpImageType.WEBP_EXTENDED;
    L34:
        return WebpImageType.NONE_WEBP;
    L9:
        return WebpImageType.NONE_WEBP;
    L5:
        return WebpImageType.NONE_WEBP;
    }

    public static boolean isAnimatedWebpType(byte[] r100) {
        return isAnimatedWebpType(getType(r100));
    L4:
        e = move-exception;
        Log.e(TAG, "isAnimatedWebpType error:" + e.toString());
        return false;
    }

    public static boolean isNonSimpleWebpType(WebpImageType r100) {
        if (r100 != WebpImageType.NONE_WEBP) goto L5;
    L7:
        return false;
    L5:
        if (r100 == WebpImageType.WEBP_SIMPLE) goto L7;
        return true;
    }

    public static boolean isStaticWebpType(WebpImageType r100) {
        if (r100 != WebpImageType.WEBP_SIMPLE) goto L5;
    L14:
        return true;
    L5:
        if (r100 == WebpImageType.WEBP_LOSSLESS) goto L14;
        if (r100 == WebpImageType.WEBP_LOSSLESS_WITH_ALPHA) goto L14;
        if (r100 == WebpImageType.WEBP_EXTENDED) goto L14;
        if (r100 == WebpImageType.WEBP_EXTENDED_WITH_ALPHA) goto L14;
        return false;
    }

    public static WebpImageType getType(ByteBuffer r100) throws IOException {
        if (r100 != null) goto L6;
        return WebpImageType.NONE_WEBP;
    L6:
        return getType(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(r100)));
    }

    public static boolean isAnimatedWebpType(WebpImageType r100) {
        if (r100 != WebpImageType.WEBP_EXTENDED_ANIMATED) goto L5;
        return true;
    L5:
        return false;
    }

    public static WebpImageType getType(byte[] r100) throws IOException {
        return getType(r100, 0, r100.length);
    }

    public static WebpImageType getType(InputStream r100, ArrayPool r101) throws IOException {
        if (r100 != null) goto L6;
        return WebpImageType.NONE_WEBP;
    L6:
        if (r100.markSupported() == true) goto L8;
        r100 = new RecyclableBufferedInputStream(r100, r101);
    L8:
        r100.mark(21);
        WebpImageType r102 = getType(new StreamReader((InputStream) Preconditions.checkNotNull(r100)));     // Catch: Throwable -> L12
        r100.reset();
        return r102;
    L12:
        th = move-exception;
        r100.reset();
        throw th;
    }

    public static boolean isAnimatedWebpType(Context r100, File r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.canRead() == false) goto L20;
        String r102 = r101.getPath();
        LruCache<String, Boolean> r103 = sWebpCache;
        Boolean r104 = r103.get(r102);
        if (r104 != null) goto L10;
        Boolean r105 = Boolean.valueOf(isAnimatedWebpType(getType(new PolarisFileInputStreamWrapper(r101), Glide.get(r100).getArrayPool())));     // Catch: Exception -> L13
        r103.put(r102, r105);     // Catch: Exception -> L13
    L14:
        Log.i(TAG, "isAnimatedWebpType:" + r105 + ", file:" + r102);
        return r105.booleanValue();
    L13:
        r105 = Boolean.FALSE;
        Log.e(TAG, "isAnimatedWebpType error:" + r102);
        goto L14
    L10:
        return r104.booleanValue();
    L20:
        return false;
    }

    public static WebpImageType getType(byte[] r100, int r101, int r102) throws IOException {
        return getType(new ByteArrayReader(r100, r101, r102));
    }
}
