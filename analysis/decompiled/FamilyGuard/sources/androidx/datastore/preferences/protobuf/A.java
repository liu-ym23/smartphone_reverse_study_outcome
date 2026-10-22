package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f9905a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    static final Charset f9906b = Charset.forName("ISO-8859-1");

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f9907c;

    /* renamed from: d, reason: collision with root package name */
    public static final ByteBuffer f9908d;

    /* renamed from: e, reason: collision with root package name */
    public static final AbstractC0489i f9909e;

    public interface a extends i<Boolean> {
    }

    public interface b extends i<Double> {
    }

    public interface c {
        int a();
    }

    public interface d<T extends c> {
        T a(int i5);
    }

    public interface e {
        boolean a(int i5);
    }

    public interface f extends i<Float> {
    }

    public interface g extends i<Integer> {
    }

    public interface h extends i<Long> {
    }

    public interface i<E> extends List<E>, RandomAccess {
        void b();

        i<E> d(int i5);

        boolean l();
    }

    static {
        byte[] bArr = new byte[0];
        f9907c = bArr;
        f9908d = ByteBuffer.wrap(bArr);
        f9909e = AbstractC0489i.h(bArr);
    }

    static <T> T a(T t5) {
        t5.getClass();
        return t5;
    }

    static <T> T b(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z5) {
        return z5 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i5, int i6) {
        int i7 = i(i6, bArr, i5, i6);
        if (i7 == 0) {
            return 1;
        }
        return i7;
    }

    public static int f(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return t0.m(bArr);
    }

    static Object h(Object obj, Object obj2) {
        return ((S) obj).d().f((S) obj2).r();
    }

    static int i(int i5, byte[] bArr, int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            i5 = (i5 * 31) + bArr[i8];
        }
        return i5;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, f9905a);
    }
}
