package kotlin.reflect.jvm.internal.impl.protobuf;

import ia.l;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f35881a;

    /* renamed from: b, reason: collision with root package name */
    public static final ByteBuffer f35882b;

    public interface a {
        int getNumber();
    }

    public interface b<T extends a> {
        T findValueByNumber(int i10);
    }

    static {
        byte[] bArr = new byte[0];
        f35881a = bArr;
        f35882b = ByteBuffer.wrap(bArr);
    }

    public static boolean a(byte[] bArr) {
        return l.e(bArr);
    }

    public static String b(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }
}
