package Mb;

import La.C0953c;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0000¢\u0006\u0004\b\b\u0010\t*\n\u0010\u000b\"\u00020\n2\u00020\n*\n\u0010\f\"\u00020\u00062\u00020\u0006*\n\u0010\u000e\"\u00020\r2\u00020\r*\n\u0010\u0010\"\u00020\u000f2\u00020\u000f*\n\u0010\u0012\"\u00020\u00112\u00020\u0011*\n\u0010\u0014\"\u00020\u00132\u00020\u0013*\n\u0010\u0016\"\u00020\u00152\u00020\u0015*\n\u0010\u0018\"\u00020\u00172\u00020\u0017*\n\u0010\u001a\"\u00020\u00192\u00020\u0019¨\u0006\u001b"}, d2 = {"", "", "c", "([B)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)[B", "Ljava/util/concurrent/locks/ReentrantLock;", "Lokio/Lock;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/lang/ArrayIndexOutOfBoundsException;", "ArrayIndexOutOfBoundsException", "Lock", "Ljava/io/IOException;", "IOException", "Ljava/net/ProtocolException;", "ProtocolException", "Ljava/io/EOFException;", "EOFException", "Ljava/io/FileNotFoundException;", "FileNotFoundException", "Ljava/io/Closeable;", "Closeable", "Ljava/util/zip/Deflater;", "Deflater", "Ljava/util/zip/Inflater;", "Inflater", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class M {
    public static final byte[] a(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        byte[] bytes = str.getBytes(C0953c.UTF_8);
        kotlin.jvm.internal.p.h(bytes, "getBytes(...)");
        return bytes;
    }

    public static final ReentrantLock b() {
        return new ReentrantLock();
    }

    public static final String c(byte[] bArr) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        return new String(bArr, C0953c.UTF_8);
    }
}
