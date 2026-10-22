package Mb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H&¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\tH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH&¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u001e\u0010\rJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\t2\u0006\u0010&\u001a\u00020)H&¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020,2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020,H&¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020,2\u0006\u00101\u001a\u00020\tH&¢\u0006\u0004\b2\u0010.J\u000f\u00103\u001a\u00020\u0017H&¢\u0006\u0004\b3\u0010\u0019J\u0017\u00106\u001a\u00020,2\u0006\u00105\u001a\u000204H&¢\u0006\u0004\b6\u00107J'\u0010;\u001a\u00020\t2\u0006\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH&¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u001fH&¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u001fH&¢\u0006\u0004\bA\u0010?J\u001f\u0010C\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u001fH&¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0000H&¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020GH&¢\u0006\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0005\u0082\u0001\u0002\u0003Lø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006MÀ\u0006\u0001"}, d2 = {"LMb/f;", "LMb/I;", "Ljava/nio/channels/ReadableByteChannel;", "LMb/d;", "u", "()LMb/d;", "", "k", "()Z", "", "byteCount", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)V", "request", "(J)Z", "", "readByte", "()B", "", "readShort", "()S", "l0", "", "readInt", "()I", "e1", "o0", "()J", "p1", "skip", "Lokio/ByteString;", "z0", "(J)Lokio/ByteString;", "LMb/x;", "options", "p0", "(LMb/x;)I", "sink", "O0", "(LMb/d;J)V", "LMb/G;", "c1", "(LMb/G;)J", "", "x0", "(J)Ljava/lang/String;", "h0", "()Ljava/lang/String;", "limit", "I", "U0", "Ljava/nio/charset/Charset;", HttpAuthHeader.Parameters.Charset, "S0", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "fromIndex", "toIndex", ExifInterface.LONGITUDE_EAST, "(BJJ)J", SingleFileBundle.KEY_BYTES, "C", "(Lokio/ByteString;)J", "targetBytes", "F", "offset", "P", "(JLokio/ByteString;)Z", "peek", "()LMb/f;", "Ljava/io/InputStream;", "r1", "()Ljava/io/InputStream;", Const.INTENT_KEY_APIKEY, "buffer", "LMb/D;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0968f extends I, ReadableByteChannel {
    long C(ByteString bytes) throws IOException;

    long E(byte b10, long fromIndex, long toIndex) throws IOException;

    long F(ByteString targetBytes) throws IOException;

    String I(long limit) throws IOException;

    void O0(C0966d sink, long byteCount) throws IOException;

    boolean P(long offset, ByteString bytes) throws IOException;

    String S0(Charset charset) throws IOException;

    int U0() throws IOException;

    C0966d a();

    long c1(G sink) throws IOException;

    int e1() throws IOException;

    String h0() throws IOException;

    void j(long byteCount) throws IOException;

    boolean k() throws IOException;

    short l0() throws IOException;

    long o0() throws IOException;

    int p0(x options) throws IOException;

    long p1() throws IOException;

    InterfaceC0968f peek();

    InputStream r1();

    byte readByte() throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    boolean request(long byteCount) throws IOException;

    void skip(long byteCount) throws IOException;

    C0966d u();

    String x0(long byteCount) throws IOException;

    ByteString z0(long byteCount) throws IOException;
}
