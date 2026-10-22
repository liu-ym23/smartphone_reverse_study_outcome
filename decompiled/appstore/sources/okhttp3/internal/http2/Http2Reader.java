package okhttp3.internal.http2;

import com.google.common.primitives.UnsignedBytes;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.coroutines.channels.Channel;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
final class Http2Reader implements Closeable {
    static final Logger logger = null;
    private final boolean client;
    private final ContinuationSource continuation;
    final Hpack.Reader hpackReader;
    private final BufferedSource source;

    public static final class ContinuationSource implements Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        public ContinuationSource(BufferedSource r10) {
            this.source = r10;
        }

        private void readContinuationHeader() throws IOException {
            int r10 = this.streamId;
            int r11 = Http2Reader.readMedium(this.source);
            this.left = r11;
            this.length = r11;
            byte r12 = (byte) (this.source.readByte() & UnsignedBytes.MAX_VALUE);
            this.flags = (byte) (this.source.readByte() & UnsignedBytes.MAX_VALUE);
            Logger r13 = Http2Reader.logger;
            if (r13.isLoggable(Level.FINE) == false) goto L5;
            r13.fine(Http2.frameLog(true, this.streamId, this.length, r12, this.flags));
        L5:
            int r14 = this.source.readInt() & Channel.UNLIMITED;
            this.streamId = r14;
            if (r12 != 9) goto L12;
            if (r14 != r10) goto L10;
            return;
        L10:
            throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
        L12:
            throw Http2.ioException("%s != TYPE_CONTINUATION", new Object[]{Byte.valueOf(r12)});
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Source
        public long read(Buffer r10, long r11) throws IOException {
        L2:
            int r12 = this.left;
            if (r12 != 0) goto L8;
            this.source.skip(this.padding);
            this.padding = 0;
            if ((this.flags & 4) != 0) goto L6;
            readContinuationHeader();
            goto L2
        L6:
            return -1;
        L8:
            long r13 = this.source.read(r10, Math.min(r11, r12));
            if (r13 != (-1)) goto L11;
            return -1;
        L11:
            this.left = (int) (((long) this.left) - r13);
            return r13;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    public interface Handler {
        void ackSettings();

        void alternateService(int r10, String r11, ByteString r12, String r13, int r14, long r15);

        void data(boolean r10, int r11, BufferedSource r12, int r13) throws IOException;

        void goAway(int r10, ErrorCode r11, ByteString r12);

        void headers(boolean r10, int r11, int r12, List<Header> r13);

        void ping(boolean r10, int r11, int r12);

        void priority(int r10, int r11, int r12, boolean r13);

        void pushPromise(int r10, int r11, List<Header> r12) throws IOException;

        void rstStream(int r10, ErrorCode r11);

        void settings(boolean r10, Settings r11);

        void windowUpdate(int r10, long r11);
    }

    static {
        logger = Logger.getLogger(Http2.class.getName());
    }

    public Http2Reader(BufferedSource r10, boolean r11) {
        this.source = r10;
        this.client = r11;
        ContinuationSource r12 = new ContinuationSource(r10);
        this.continuation = r12;
        this.hpackReader = new Hpack.Reader(4096, r12);
    }

    public static int lengthWithoutPadding(int r10, byte r11, short r12) throws IOException {
        if ((r11 & 8) == 0) goto L5;
        r10 = r10 - 1;
    L5:
        if (r12 > r10) goto L9;
        return (short) (r10 - r12);
    L9:
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[]{Short.valueOf(r12), Integer.valueOf(r10)});
    }

    private void readData(Handler r10, int r11, byte r12, int r13) throws IOException {
        short r14 = 0;
        if (r13 == 0) goto L18;
        if ((r12 & 1) == 0) goto L7;
        boolean r15 = true;
    L9:
        if ((r12 & 32) != 0) goto L16;
        if ((r12 & 8) == 0) goto L13;
        r14 = (short) (this.source.readByte() & UnsignedBytes.MAX_VALUE);
    L13:
        r10.data(r15, r13, this.source, lengthWithoutPadding(r11, r12, r14));
        this.source.skip(r14);
        return;
    L16:
        throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    L7:
        r15 = false;
        goto L9
    L18:
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void readGoAway(Handler r10, int r11, byte r12, int r13) throws IOException {
        if (r11 < 8) goto L17;
        if (r13 != 0) goto L15;
        int r14 = this.source.readInt();
        int r15 = this.source.readInt();
        int r16 = r11 - 8;
        ErrorCode r17 = ErrorCode.fromHttp2(r15);
        if (r17 == null) goto L13;
        ByteString r18 = ByteString.EMPTY;
        if (r16 <= 0) goto L10;
        r18 = this.source.readByteString(r16);
    L10:
        r10.goAway(r14, r17, r18);
        return;
    L13:
        throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", new Object[]{Integer.valueOf(r15)});
    L15:
        throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
    L17:
        throw Http2.ioException("TYPE_GOAWAY length < 8: %s", new Object[]{Integer.valueOf(r11)});
    }

    private List<Header> readHeaderBlock(int r10, short r11, byte r12, int r13) throws IOException {
        ContinuationSource r14 = this.continuation;
        r14.left = r10;
        r14.length = r10;
        r14.padding = r11;
        r14.flags = r12;
        r14.streamId = r13;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readHeaders(Handler r10, int r11, byte r12, int r13) throws IOException {
        short r14 = 0;
        if (r13 == 0) goto L17;
        if ((r12 & 1) == 0) goto L7;
        boolean r15 = true;
    L9:
        if ((r12 & 8) == 0) goto L12;
        r14 = (short) (this.source.readByte() & UnsignedBytes.MAX_VALUE);
    L12:
        if ((r12 & 32) == 0) goto L14;
        readPriority(r10, r13);
        r11 = r11 - 5;
    L14:
        r10.headers(r15, r13, -1, readHeaderBlock(lengthWithoutPadding(r11, r12, r14), r14, r12, r13));
        return;
    L7:
        r15 = false;
        goto L9
    L17:
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    public static int readMedium(BufferedSource r10) throws IOException {
        int r11 = ((r10.readByte() & UnsignedBytes.MAX_VALUE) << 16) | ((r10.readByte() & UnsignedBytes.MAX_VALUE) << 8);
        return (r10.readByte() & UnsignedBytes.MAX_VALUE) | r11;
    }

    private void readPing(Handler r10, int r11, byte r12, int r13) throws IOException {
        if (r11 != 8) goto L14;
        boolean r14 = false;
        if (r13 != 0) goto L12;
        int r15 = this.source.readInt();
        int r16 = this.source.readInt();
        if ((r12 & 1) == 0) goto L9;
        r14 = true;
    L9:
        r10.ping(r14, r15, r16);
        return;
    L12:
        throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
    L14:
        throw Http2.ioException("TYPE_PING length != 8: %s", new Object[]{Integer.valueOf(r11)});
    }

    private void readPriority(Handler r10, int r11, byte r12, int r13) throws IOException {
        if (r11 != 5) goto L10;
        if (r13 == 0) goto L8;
        readPriority(r10, r13);
        return;
    L8:
        throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
    L10:
        throw Http2.ioException("TYPE_PRIORITY length: %d != 5", new Object[]{Integer.valueOf(r11)});
    }

    private void readPushPromise(Handler r10, int r11, byte r12, int r13) throws IOException {
        short r14 = 0;
        if (r13 == 0) goto L10;
        if ((r12 & 8) == 0) goto L7;
        r14 = (short) (this.source.readByte() & UnsignedBytes.MAX_VALUE);
    L7:
        r10.pushPromise(r13, this.source.readInt() & Channel.UNLIMITED, readHeaderBlock(lengthWithoutPadding(r11 - 4, r12, r14), r14, r12, r13));
        return;
    L10:
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void readRstStream(Handler r10, int r11, byte r12, int r13) throws IOException {
        if (r11 != 4) goto L14;
        if (r13 == 0) goto L12;
        int r14 = this.source.readInt();
        ErrorCode r15 = ErrorCode.fromHttp2(r14);
        if (r15 == null) goto L10;
        r10.rstStream(r13, r15);
        return;
    L10:
        throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[]{Integer.valueOf(r14)});
    L12:
        throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
    L14:
        throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", new Object[]{Integer.valueOf(r11)});
    }

    private void readSettings(Handler r10, int r11, byte r12, int r13) throws IOException {
        if (r13 != 0) goto L46;
        if ((r12 & 1) == 0) goto L12;
        if (r11 != 0) goto L10;
        r10.ackSettings();
        return;
    L10:
        throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
    L12:
        if ((r11 % 6) != 0) goto L44;
        Settings r14 = new Settings();
        int r15 = 0;
    L14:
        if (r15 >= r11) goto L41;
        int r16 = this.source.readShort() & 65535;
        int r17 = this.source.readInt();
        if (r16 != 2) goto L18;
        if (r17 == 0) goto L40;
        if (r17 == 1) goto L40;
        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
    L40:
        r14.set(r16, r17);
        r15 = r15 + 6;
        goto L14
    L18:
        if (r16 == 3) goto L34;
        if (r16 != 4) goto L21;
        if (r17 < 0) goto L33;
        r16 = 7;
        goto L40
    L33:
        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
    L21:
        if (r16 != 5) goto L40;
        if (r17 < 16384) goto L29;
        if (r17 <= 16777215) goto L40;
    L29:
        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[]{Integer.valueOf(r17)});
    L34:
        r16 = 4;
        goto L40
    L41:
        r10.settings(false, r14);
        return;
    L44:
        throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", new Object[]{Integer.valueOf(r11)});
    L46:
        throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
    }

    private void readWindowUpdate(Handler r10, int r11, byte r12, int r13) throws IOException {
        if (r11 != 4) goto L11;
        long r14 = ((long) this.source.readInt()) & 2147483647L;
        if (r14 == 0) goto L9;
        r10.windowUpdate(r13, r14);
        return;
    L9:
        throw Http2.ioException("windowSizeIncrement was 0", new Object[]{Long.valueOf(r14)});
    L11:
        throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", new Object[]{Integer.valueOf(r11)});
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public boolean nextFrame(boolean r10, Handler r11) throws IOException {
        this.source.require(9);     // Catch: IOException -> L31
        int r12 = readMedium(this.source);
        if (r12 < 0) goto L30;
        if (r12 > 16384) goto L30;
        byte r13 = (byte) (this.source.readByte() & UnsignedBytes.MAX_VALUE);
        if (r10 == true) goto L10;
    L14:
        byte r14 = (byte) (this.source.readByte() & UnsignedBytes.MAX_VALUE);
        int r15 = this.source.readInt() & Channel.UNLIMITED;
        Logger r16 = logger;
        if (r16.isLoggable(Level.FINE) == false) goto L17;
        r16.fine(Http2.frameLog(true, r15, r12, r13, r14));
    L17:
        switch(r13) {
            case 0: goto L27;
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            default: goto L18;
        };
    L18:
        this.source.skip(r12);
    L28:
        return true;
    L19:
        readWindowUpdate(r11, r12, r14, r15);
        goto L28
    L20:
        readGoAway(r11, r12, r14, r15);
        goto L28
    L21:
        readPing(r11, r12, r14, r15);
        goto L28
    L22:
        readPushPromise(r11, r12, r14, r15);
        goto L28
    L23:
        readSettings(r11, r12, r14, r15);
        goto L28
    L24:
        readRstStream(r11, r12, r14, r15);
        goto L28
    L25:
        readPriority(r11, r12, r14, r15);
        goto L28
    L26:
        readHeaders(r11, r12, r14, r15);
        goto L28
    L27:
        readData(r11, r12, r14, r15);
        goto L28
    L10:
        if (r13 == 4) goto L14;
        throw Http2.ioException("Expected a SETTINGS frame but was %s", new Object[]{Byte.valueOf(r13)});
    L30:
        throw Http2.ioException("FRAME_SIZE_ERROR: %s", new Object[]{Integer.valueOf(r12)});
    L31:
        return false;
    }

    public void readConnectionPreface(Handler r10) throws IOException {
        if (this.client == true) goto L5;
        BufferedSource r11 = this.source;
        ByteString r12 = Http2.CONNECTION_PREFACE;
        ByteString r13 = r11.readByteString(r12.size());
        Logger r14 = logger;
        if (r14.isLoggable(Level.FINE) == false) goto L13;
        r14.fine(Util.format("<< CONNECTION %s", new Object[]{r13.hex()}));
    L13:
        if (r12.equals(r13) == false) goto L16;
        return;
    L16:
        throw Http2.ioException("Expected a connection header but was %s", new Object[]{r13.utf8()});
    L5:
        if (nextFrame(true, r10) == false) goto L8;
        return;
    L8:
        throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
    }

    private void readPriority(Handler r10, int r11) throws IOException {
        int r12 = this.source.readInt();
        if ((Integer.MIN_VALUE & r12) == 0) goto L5;
        boolean r13 = true;
    L6:
        r10.priority(r11, r12 & Channel.UNLIMITED, (this.source.readByte() & UnsignedBytes.MAX_VALUE) + 1, r13);
        return;
    L5:
        r13 = false;
        goto L6
    }
}
