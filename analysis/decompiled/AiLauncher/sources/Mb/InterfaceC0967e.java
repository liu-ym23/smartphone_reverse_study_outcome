package Mb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&¢\u0006\u0004\b\t\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u000bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000bH&¢\u0006\u0004\b\u001f\u0010\u001dJ\u0017\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u000bH&¢\u0006\u0004\b!\u0010\u001dJ\u0017\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000bH&¢\u0006\u0004\b#\u0010\u001dJ\u0017\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0010H&¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0010H&¢\u0006\u0004\b'\u0010&J\u000f\u0010)\u001a\u00020(H&¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H&¢\u0006\u0004\b,\u0010-R\u0014\u00101\u001a\u00020.8&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\u0082\u0001\u0002.2ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00063À\u0006\u0001"}, d2 = {"LMb/e;", "LMb/G;", "Ljava/nio/channels/WritableByteChannel;", "Lokio/ByteString;", "byteString", "j1", "(Lokio/ByteString;)LMb/e;", "", "source", "write", "([B)LMb/e;", "", "offset", "byteCount", "([BII)LMb/e;", "LMb/I;", "", "V0", "(LMb/I;)J", "", "string", "L", "(Ljava/lang/String;)LMb/e;", "beginIndex", "endIndex", "R", "(Ljava/lang/String;II)LMb/e;", "codePoint", "z", "(I)LMb/e;", Const.INTENT_KEY_PKGNAME, "writeByte", "s", "writeShort", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "writeInt", "v", "s0", "(J)LMb/e;", "W0", "LY8/t;", "flush", "()V", "Ljava/io/OutputStream;", "o1", "()Ljava/io/OutputStream;", "LMb/d;", Const.INTENT_KEY_APIKEY, "()LMb/d;", "buffer", "LMb/C;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0967e extends G, WritableByteChannel {
    InterfaceC0967e L(String string) throws IOException;

    InterfaceC0967e R(String string, int beginIndex, int endIndex) throws IOException;

    long V0(I source) throws IOException;

    InterfaceC0967e W0(long v10) throws IOException;

    C0966d a();

    @Override // Mb.G, java.io.Flushable
    void flush() throws IOException;

    InterfaceC0967e j1(ByteString byteString) throws IOException;

    OutputStream o1();

    InterfaceC0967e s0(long v10) throws IOException;

    InterfaceC0967e write(byte[] source) throws IOException;

    InterfaceC0967e write(byte[] source, int offset, int byteCount) throws IOException;

    InterfaceC0967e writeByte(int b10) throws IOException;

    InterfaceC0967e writeInt(int i10) throws IOException;

    InterfaceC0967e writeShort(int s10) throws IOException;

    InterfaceC0967e z(int codePoint) throws IOException;
}
