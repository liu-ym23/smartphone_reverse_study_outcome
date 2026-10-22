package androidx.datastore.preferences.protobuf;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f1218a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f1219b;

    static {
        Charset.forName("US-ASCII");
        f1218a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f1219b = bArr;
        ByteBuffer.wrap(bArr);
        g gVar = new g();
        gVar.i = Reader.READ_DONE;
        gVar.f1111c = bArr;
        gVar.f1112d = 0 + 0;
        gVar.f1114f = 0;
        gVar.f1115g = 0;
        VarHandle.storeStoreFence();
        try {
            gVar.e(0);
        } catch (z e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        g5.f.g(str);
    }

    public static int b(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }
}
