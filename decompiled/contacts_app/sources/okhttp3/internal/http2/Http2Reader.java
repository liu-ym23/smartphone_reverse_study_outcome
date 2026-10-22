package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UShort;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes5.dex */
final class Http2Reader implements Closeable {
    static final Logger logger = null;
    private final boolean client;
    private final ContinuationSource continuation;
    final Hpack.Reader hpackReader;
    private final BufferedSource source;

    static final class ContinuationSource implements Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        ContinuationSource(BufferedSource r1) {
            this.source = r1;
        }

        @Override // okio.Source
        public long read(Buffer r7, long r8) throws IOException {
        L2:
            int r0 = this.left;
            if (r0 != 0) goto L8;
            this.source.skip(this.padding);
            this.padding = 0;
            if ((this.flags & 4) != 0) goto L6;
            readContinuationHeader();
            goto L2
        L6:
            return -1;
        L8:
            long r9 = this.source.read(r7, Math.min(r8, r0));
            if (r9 != (-1)) goto L11;
            return -1;
        L11:
            this.left = (int) (((long) this.left) - r9);
            return r9;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }

        private void readContinuationHeader() throws IOException {
            int r0 = this.streamId;
            int r1 = Http2Reader.readMedium(this.source);
            this.left = r1;
            this.length = r1;
            byte r2 = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            if (Http2Reader.logger.isLoggable(Level.FINE) == false) goto L5;
            Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, r2, this.flags));
        L5:
            int r3 = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = r3;
            if (r2 != 9) goto L12;
            if (r3 != r0) goto L10;
            return;
        L10:
            throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
        L12:
            throw Http2.ioException("%s != TYPE_CONTINUATION", new Object[]{Byte.valueOf(r2)});
        }
    }

    interface Handler {
        void ackSettings();

        void alternateService(int r1, String r2, ByteString r3, String r4, int r5, long r6);

        void data(boolean r1, int r2, BufferedSource r3, int r4) throws IOException;

        void goAway(int r1, ErrorCode r2, ByteString r3);

        void headers(boolean r1, int r2, int r3, List<Header> r4);

        void ping(boolean r1, int r2, int r3);

        void priority(int r1, int r2, int r3, boolean r4);

        void pushPromise(int r1, int r2, List<Header> r3) throws IOException;

        void rstStream(int r1, ErrorCode r2);

        void settings(boolean r1, Settings r2);

        void windowUpdate(int r1, long r2);
    }

    static {
        logger = Logger.getLogger(Http2.class.getName());
    }

    Http2Reader(BufferedSource r2, boolean r3) {
        this.source = r2;
        this.client = r3;
        ContinuationSource r4 = new ContinuationSource(r2);
        this.continuation = r4;
        this.hpackReader = new Hpack.Reader(4096, r4);
    }

    public void readConnectionPreface(Handler r6) throws IOException {
        if (this.client == true) goto L5;
        ByteString r5 = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
        Logger r7 = logger;
        if (r7.isLoggable(Level.FINE) == false) goto L13;
        r7.fine(Util.format("<< CONNECTION %s", new Object[]{r5.hex()}));
    L13:
        if (Http2.CONNECTION_PREFACE.equals(r5) == false) goto L16;
        return;
    L16:
        throw Http2.ioException("Expected a connection header but was %s", new Object[]{r5.utf8()});
    L5:
        if (nextFrame(true, r6) == false) goto L8;
        return;
    L8:
        throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
    }

    public boolean nextFrame(boolean r7, Handler r8) throws IOException {
        this.source.require(9);     // Catch: IOException -> L32
        int r1 = readMedium(this.source);
        if (r1 < 0) goto L31;
        if (r1 > 16384) goto L31;
        byte r3 = (byte) (this.source.readByte() & 255);
        if (r7 == true) goto L11;
    L15:
        byte r9 = (byte) (this.source.readByte() & 255);
        int r0 = this.source.readInt() & Integer.MAX_VALUE;
        Logger r4 = logger;
        if (r4.isLoggable(Level.FINE) == false) goto L18;
        r4.fine(Http2.frameLog(true, r0, r1, r3, r9));
    L18:
        switch(r3) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            default: goto L19;
        };
    L19:
        this.source.skip(r1);
    L29:
        return true;
    L20:
        readWindowUpdate(r8, r1, r9, r0);
        goto L29
    L21:
        readGoAway(r8, r1, r9, r0);
        goto L29
    L22:
        readPing(r8, r1, r9, r0);
        goto L29
    L23:
        readPushPromise(r8, r1, r9, r0);
        goto L29
    L24:
        readSettings(r8, r1, r9, r0);
        goto L29
    L25:
        readRstStream(r8, r1, r9, r0);
        goto L29
    L26:
        readPriority(r8, r1, r9, r0);
        goto L29
    L27:
        readHeaders(r8, r1, r9, r0);
        goto L29
    L28:
        readData(r8, r1, r9, r0);
        goto L29
    L11:
        if (r3 == 4) goto L15;
        throw Http2.ioException("Expected a SETTINGS frame but was %s", new Object[]{Byte.valueOf(r3)});
    L31:
        throw Http2.ioException("FRAME_SIZE_ERROR: %s", new Object[]{Integer.valueOf(r1)});
    L32:
        return false;
    }

    private void readHeaders(Handler r4, int r5, byte r6, int r7) throws IOException {
        short r0 = 0;
        if (r7 == 0) goto L17;
        if ((r6 & 1) == 0) goto L7;
        boolean r1 = true;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r0 = (short) (this.source.readByte() & 255);
    L12:
        if ((r6 & 32) == 0) goto L14;
        readPriority(r4, r7);
        r5 = r5 - 5;
    L14:
        r4.headers(r1, r7, -1, readHeaderBlock(lengthWithoutPadding(r5, r6, r0), r0, r6, r7));
        return;
    L7:
        r1 = false;
        goto L9
    L17:
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    private List<Header> readHeaderBlock(int r2, short r3, byte r4, int r5) throws IOException {
        ContinuationSource r0 = this.continuation;
        r0.left = r2;
        r0.length = r2;
        this.continuation.padding = r3;
        this.continuation.flags = r4;
        this.continuation.streamId = r5;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readData(Handler r5, int r6, byte r7, int r8) throws IOException {
        short r0 = 0;
        if (r8 == 0) goto L21;
        boolean r2 = true;
        if ((r7 & 1) == 0) goto L7;
        boolean r1 = true;
    L9:
        if ((r7 & 32) != 0) goto L12;
        r2 = false;
    L12:
        if (r2 == true) goto L19;
        if ((r7 & 8) == 0) goto L16;
        r0 = (short) (this.source.readByte() & 255);
    L16:
        r5.data(r1, r8, this.source, lengthWithoutPadding(r6, r7, r0));
        this.source.skip(r0);
        return;
    L19:
        throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    L7:
        r1 = false;
        goto L9
    L21:
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void readPriority(Handler r2, int r3, byte r4, int r5) throws IOException {
        if (r3 != 5) goto L10;
        if (r5 == 0) goto L8;
        readPriority(r2, r5);
        return;
    L8:
        throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
    L10:
        throw Http2.ioException("TYPE_PRIORITY length: %d != 5", new Object[]{Integer.valueOf(r3)});
    }

    private void readPriority(Handler r5, int r6) throws IOException {
        int r0 = this.source.readInt();
        if ((Integer.MIN_VALUE & r0) == 0) goto L5;
        boolean r1 = true;
    L6:
        r5.priority(r6, r0 & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void readRstStream(Handler r3, int r4, byte r5, int r6) throws IOException {
        if (r4 != 4) goto L14;
        if (r6 == 0) goto L12;
        int r2 = this.source.readInt();
        ErrorCode r7 = ErrorCode.fromHttp2(r2);
        if (r7 == null) goto L10;
        r3.rstStream(r6, r7);
        return;
    L10:
        throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[]{Integer.valueOf(r2)});
    L12:
        throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
    L14:
        throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", new Object[]{Integer.valueOf(r4)});
    }

    private void readSettings(Handler r7, int r8, byte r9, int r10) throws IOException {
        if (r10 != 0) goto L46;
        if ((r9 & 1) == 0) goto L12;
        if (r8 != 0) goto L10;
        r7.ackSettings();
        return;
    L10:
        throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
    L12:
        if ((r8 % 6) != 0) goto L44;
        Settings r11 = new Settings();
        int r1 = 0;
    L14:
        if (r1 >= r8) goto L41;
        int r2 = this.source.readShort() & UShort.MAX_VALUE;
        int r3 = this.source.readInt();
        if (r2 != 2) goto L18;
        if (r3 == 0) goto L40;
        if (r3 == 1) goto L40;
        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
    L40:
        r11.set(r2, r3);
        r1 = r1 + 6;
        goto L14
    L18:
        if (r2 == 3) goto L34;
        if (r2 != 4) goto L21;
        if (r3 < 0) goto L33;
        r2 = 7;
        goto L40
    L33:
        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
    L21:
        if (r2 != 5) goto L40;
        if (r3 < 16384) goto L29;
        if (r3 <= 16777215) goto L40;
    L29:
        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[]{Integer.valueOf(r3)});
    L34:
        r2 = 4;
        goto L40
    L41:
        r7.settings(false, r11);
        return;
    L44:
        throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", new Object[]{Integer.valueOf(r8)});
    L46:
        throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
    }

    private void readPushPromise(Handler r4, int r5, byte r6, int r7) throws IOException {
        short r0 = 0;
        if (r7 == 0) goto L10;
        if ((r6 & 8) == 0) goto L7;
        r0 = (short) (this.source.readByte() & 255);
    L7:
        r4.pushPromise(r7, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(r5 - 4, r6, r0), r0, r6, r7));
        return;
    L10:
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void readPing(Handler r4, int r5, byte r6, int r7) throws IOException {
        boolean r1 = false;
        if (r5 != 8) goto L13;
        if (r7 != 0) goto L11;
        int r8 = this.source.readInt();
        int r3 = this.source.readInt();
        if ((r6 & 1) == 0) goto L8;
        r1 = true;
    L8:
        r4.ping(r1, r8, r3);
        return;
    L11:
        throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
    L13:
        throw Http2.ioException("TYPE_PING length != 8: %s", new Object[]{Integer.valueOf(r5)});
    }

    private void readGoAway(Handler r4, int r5, byte r6, int r7) throws IOException {
        if (r5 < 8) goto L17;
        if (r7 != 0) goto L15;
        int r8 = this.source.readInt();
        int r2 = this.source.readInt();
        int r9 = r5 - 8;
        ErrorCode r1 = ErrorCode.fromHttp2(r2);
        if (r1 == null) goto L13;
        ByteString r10 = ByteString.EMPTY;
        if (r9 <= 0) goto L10;
        r10 = this.source.readByteString(r9);
    L10:
        r4.goAway(r8, r1, r10);
        return;
    L13:
        throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", new Object[]{Integer.valueOf(r2)});
    L15:
        throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
    L17:
        throw Http2.ioException("TYPE_GOAWAY length < 8: %s", new Object[]{Integer.valueOf(r5)});
    }

    private void readWindowUpdate(Handler r5, int r6, byte r7, int r8) throws IOException {
        if (r6 != 4) goto L11;
        long r9 = ((long) this.source.readInt()) & 2147483647L;
        if (r9 == 0) goto L9;
        r5.windowUpdate(r8, r9);
        return;
    L9:
        throw Http2.ioException("windowSizeIncrement was 0", new Object[]{Long.valueOf(r9)});
    L11:
        throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", new Object[]{Integer.valueOf(r6)});
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    static int readMedium(BufferedSource r2) throws IOException {
        int r0 = ((r2.readByte() & 255) << 16) | ((r2.readByte() & 255) << 8);
        return (r2.readByte() & 255) | r0;
    }

    static int lengthWithoutPadding(int r1, byte r2, short r3) throws IOException {
        if ((r2 & 8) == 0) goto L5;
        r1 = r1 - 1;
    L5:
        if (r3 > r1) goto L9;
        return (short) (r1 - r3);
    L9:
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[]{Short.valueOf(r3), Integer.valueOf(r1)});
    }
}
