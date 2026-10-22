package androidx.datastore.preferences.protobuf;

import com.stepos.activeview.utils.Constants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class D {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f3396a = Charset.forName(Constants.UTF_8_CODE);

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f3397b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f3397b = bArr;
        ByteBuffer.wrap(bArr);
        if ((0 - 0) + 0 <= Integer.MAX_VALUE) {
            return;
        }
        try {
            throw F.f();
        } catch (F e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static int b(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }

    public static A c(Object obj, Object obj2) {
        A a4 = (A) ((AbstractC0247b) obj);
        AbstractC0277y abstractC0277y = (AbstractC0277y) a4.d(5);
        abstractC0277y.c();
        AbstractC0277y.d(abstractC0277y.f3552b, a4);
        AbstractC0247b abstractC0247b = (AbstractC0247b) obj2;
        if (!abstractC0277y.f3551a.getClass().isInstance(abstractC0247b)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        abstractC0277y.c();
        AbstractC0277y.d(abstractC0277y.f3552b, (A) abstractC0247b);
        return abstractC0277y.b();
    }
}
