package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: androidx.datastore.preferences.protobuf.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1359w {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f13642a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f13643b = Charset.forName("ISO-8859-1");

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f13644c;

    /* renamed from: d, reason: collision with root package name */
    public static final ByteBuffer f13645d;

    /* renamed from: e, reason: collision with root package name */
    public static final AbstractC1345h f13646e;

    /* renamed from: androidx.datastore.preferences.protobuf.w$a */
    public interface a extends i<Boolean> {
    }

    /* renamed from: androidx.datastore.preferences.protobuf.w$b */
    public interface b extends i<Double> {
    }

    /* renamed from: androidx.datastore.preferences.protobuf.w$c */
    public interface c {
        int getNumber();
    }

    /* renamed from: androidx.datastore.preferences.protobuf.w$d */
    public interface d<T extends c> {
        T findValueByNumber(int i10);
    }

    /* renamed from: androidx.datastore.preferences.protobuf.w$e */
    public interface e {
        boolean isInRange(int i10);
    }

    /* renamed from: androidx.datastore.preferences.protobuf.w$f */
    public interface f extends i<Float> {
    }

    /* renamed from: androidx.datastore.preferences.protobuf.w$g */
    public interface g extends i<Integer> {
    }

    /* renamed from: androidx.datastore.preferences.protobuf.w$h */
    public interface h extends i<Long> {
    }

    /* renamed from: androidx.datastore.preferences.protobuf.w$i */
    public interface i<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        i<E> mutableCopyWithCapacity(int i10);
    }

    static {
        byte[] bArr = new byte[0];
        f13644c = bArr;
        f13645d = ByteBuffer.wrap(bArr);
        f13646e = AbstractC1345h.h(bArr);
    }

    public static <T> T a(T t10) {
        t10.getClass();
        return t10;
    }

    public static <T> T b(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static int e(byte[] bArr, int i10, int i11) {
        int i12 = i(i11, bArr, i10, i11);
        if (i12 == 0) {
            return 1;
        }
        return i12;
    }

    public static int f(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return Utf8.m(bArr);
    }

    public static Object h(Object obj, Object obj2) {
        return ((K) obj).toBuilder().l((K) obj2).buildPartial();
    }

    public static int i(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, f13642a);
    }
}
