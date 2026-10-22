package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    @Deprecated
    Buffer buffer();

    boolean exhausted() throws IOException;

    Buffer getBuffer();

    long indexOf(byte r1) throws IOException;

    long indexOf(byte r1, long r2) throws IOException;

    long indexOf(byte r1, long r2, long r4) throws IOException;

    long indexOf(ByteString r1) throws IOException;

    long indexOf(ByteString r1, long r2) throws IOException;

    long indexOfElement(ByteString r1) throws IOException;

    long indexOfElement(ByteString r1, long r2) throws IOException;

    InputStream inputStream();

    BufferedSource peek();

    boolean rangeEquals(long r1, ByteString r3) throws IOException;

    boolean rangeEquals(long r1, ByteString r3, int r4, int r5) throws IOException;

    int read(byte[] r1) throws IOException;

    int read(byte[] r1, int r2, int r3) throws IOException;

    long readAll(Sink r1) throws IOException;

    byte readByte() throws IOException;

    byte[] readByteArray() throws IOException;

    byte[] readByteArray(long r1) throws IOException;

    ByteString readByteString() throws IOException;

    ByteString readByteString(long r1) throws IOException;

    long readDecimalLong() throws IOException;

    void readFully(Buffer r1, long r2) throws IOException;

    void readFully(byte[] r1) throws IOException;

    long readHexadecimalUnsignedLong() throws IOException;

    int readInt() throws IOException;

    int readIntLe() throws IOException;

    long readLong() throws IOException;

    long readLongLe() throws IOException;

    short readShort() throws IOException;

    short readShortLe() throws IOException;

    String readString(long r1, Charset r3) throws IOException;

    String readString(Charset r1) throws IOException;

    String readUtf8() throws IOException;

    String readUtf8(long r1) throws IOException;

    int readUtf8CodePoint() throws IOException;

    @Nullable
    String readUtf8Line() throws IOException;

    String readUtf8LineStrict() throws IOException;

    String readUtf8LineStrict(long r1) throws IOException;

    boolean request(long r1) throws IOException;

    void require(long r1) throws IOException;

    int select(Options r1) throws IOException;

    void skip(long r1) throws IOException;
}
