package X0;

import H0.l;
import android.graphics.Bitmap;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f5799a = "0123456789abcdef".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f5800b = new char[64];

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5801a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f5801a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5801a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5801a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5801a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5801a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a() {
        if (!p()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void b() {
        if (!q()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj instanceof l ? ((l) obj).a(obj2) : obj.equals(obj2);
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static String e(byte[] bArr, char[] cArr) {
        for (int i5 = 0; i5 < bArr.length; i5++) {
            byte b6 = bArr[i5];
            int i6 = i5 * 2;
            char[] cArr2 = f5799a;
            cArr[i6] = cArr2[(b6 & 255) >>> 4];
            cArr[i6 + 1] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }

    public static <T> Queue<T> f(int i5) {
        return new ArrayDeque(i5);
    }

    public static int g(int i5, int i6, Bitmap.Config config) {
        return i5 * i6 * i(config);
    }

    public static int h(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    private static int i(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i5 = a.f5801a[config.ordinal()];
        int i6 = 1;
        if (i5 != 1) {
            i6 = 2;
            if (i5 != 2 && i5 != 3) {
                return i5 != 4 ? 4 : 8;
            }
        }
        return i6;
    }

    public static <T> List<T> j(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t5 : collection) {
            if (t5 != null) {
                arrayList.add(t5);
            }
        }
        return arrayList;
    }

    public static int k(float f5) {
        return l(f5, 17);
    }

    public static int l(float f5, int i5) {
        return m(Float.floatToIntBits(f5), i5);
    }

    public static int m(int i5, int i6) {
        return (i6 * 31) + i5;
    }

    public static int n(Object obj, int i5) {
        return m(obj == null ? 0 : obj.hashCode(), i5);
    }

    public static int o(boolean z5, int i5) {
        return m(z5 ? 1 : 0, i5);
    }

    public static boolean p() {
        return !q();
    }

    public static boolean q() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean r(int i5) {
        return i5 > 0 || i5 == Integer.MIN_VALUE;
    }

    public static boolean s(int i5, int i6) {
        return r(i5) && r(i6);
    }

    public static String t(byte[] bArr) {
        String strE;
        char[] cArr = f5800b;
        synchronized (cArr) {
            strE = e(bArr, cArr);
        }
        return strE;
    }
}
