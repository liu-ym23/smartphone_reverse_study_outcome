package ub;

import La.D;
import La.H;
import Mb.C0966d;
import Mb.InterfaceC0967e;
import Mb.InterfaceC0968f;
import Mb.x;
import Z8.C1172u;
import Z8.r;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aI\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010\u0003j\n\u0012\u0006\b\u0000\u0012\u00020\u0001`\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aE\u0010\t\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00010\u00002\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010\u0003j\n\u0012\u0006\b\u0000\u0012\u00020\u0001`\u0004H\u0000¢\u0006\u0004\b\t\u0010\n\u001a9\u0010\r\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u000b\u001a\u00020\u00012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003j\b\u0012\u0004\u0012\u00020\u0001`\u0004H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u000b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0013\u001a\u00020\f*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0015\u001a\u00020\f*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0015\u0010\u0014\u001a%\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u0019\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001a\u001a-\u0010\u001d\u001a\u00020\f*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0013\u0010\u001f\u001a\u00020\f*\u00020\u0001H\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0013\u0010$\u001a\u00020\f*\u00020\u001bH\u0000¢\u0006\u0004\b$\u0010%\u001a\u001c\u0010(\u001a\u00020\f*\u00020&2\u0006\u0010'\u001a\u00020\fH\u0080\u0004¢\u0006\u0004\b(\u0010)\u001a\u001c\u0010+\u001a\u00020\f*\u00020*2\u0006\u0010'\u001a\u00020\fH\u0080\u0004¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010.\u001a\u00020-*\u00020\f2\u0006\u0010'\u001a\u00020-H\u0080\u0004¢\u0006\u0004\b.\u0010/\u001a\u001b\u00103\u001a\u000202*\u0002002\u0006\u00101\u001a\u00020\fH\u0000¢\u0006\u0004\b3\u00104\u001a\u0013\u00106\u001a\u00020\f*\u000205H\u0000¢\u0006\u0004\b6\u00107\u001a\u001b\u00109\u001a\u00020\f*\u0002082\u0006\u0010(\u001a\u00020&H\u0000¢\u0006\u0004\b9\u0010:\u001a\u001d\u0010;\u001a\u00020\f*\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\fH\u0000¢\u0006\u0004\b;\u0010<\u001a\u0019\u0010>\u001a\u00020-*\u00020\u00012\u0006\u0010=\u001a\u00020-¢\u0006\u0004\b>\u0010?\u001a\u001d\u0010@\u001a\u00020\f*\u0004\u0018\u00010\u00012\u0006\u0010=\u001a\u00020\fH\u0000¢\u0006\u0004\b@\u0010<\u001a\u0015\u0010C\u001a\u000202*\u00060Aj\u0002`B¢\u0006\u0004\bC\u0010D\u001a'\u0010G\u001a\u000202\"\u0004\b\u0000\u00103*\b\u0012\u0004\u0012\u00028\u00000E2\u0006\u0010F\u001a\u00028\u0000H\u0000¢\u0006\u0004\bG\u0010H\u001a)\u0010N\u001a\u00020M*\u00060Ij\u0002`J2\u0010\u0010L\u001a\f\u0012\b\u0012\u00060Ij\u0002`J0KH\u0000¢\u0006\u0004\bN\u0010O\u001a'\u0010S\u001a\u0002022\u0006\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u00020-H\u0000¢\u0006\u0004\bS\u0010T\u001a7\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000K\"\u0004\b\u0000\u0010U2\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000V2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000VH\u0000¢\u0006\u0004\bW\u0010X\"\u0014\u0010[\u001a\u00020Y8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\bG\u0010Z\"\u001a\u0010`\u001a\u00020\\8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010]\u001a\u0004\b^\u0010_¨\u0006a"}, d2 = {"", "", "other", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "u", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "", "l", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", UxipConstants.f30680s, "", "m", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", Const.INTENT_KEY_BACKGROUND_COMMAND, "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "o", "(Ljava/lang/String;II)I", "q", "B", "(Ljava/lang/String;II)Ljava/lang/String;", "delimiters", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;II)I", "", "delimiter", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;CII)I", "n", "(Ljava/lang/String;)I", "name", "v", "(Ljava/lang/String;)Z", "w", "(C)I", "", "mask", Const.INTENT_KEY_PKGNAME, "(BI)I", "", "c", "(SI)I", "", Const.INTENT_KEY_UMID, "(IJ)J", "LMb/e;", "medium", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(LMb/e;I)V", "LMb/f;", "x", "(LMb/f;)I", "LMb/d;", "y", "(LMb/d;B)I", "s", "(Ljava/lang/String;I)I", "defaultValue", "z", "(Ljava/lang/String;J)J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/io/Closeable;", "Lokio/Closeable;", "f", "(Ljava/io/Closeable;)V", "", "element", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;Ljava/lang/Object;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "suppressed", "", "D", "(Ljava/lang/Exception;Ljava/util/List;)Ljava/lang/Throwable;", "arrayLength", "offset", "count", "e", "(JJJ)V", ExifInterface.GPS_DIRECTION_TRUE, "", "t", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/List;", "", "[B", "EMPTY_BYTE_ARRAY", "LMb/x;", "LMb/x;", "k", "()LMb/x;", "UNICODE_BOMS", "okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f42668a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public static final x f42669b;

    static {
        x.Companion companion = x.INSTANCE;
        ByteString.Companion companion2 = ByteString.INSTANCE;
        f42669b = companion.d(companion2.b("efbbbf"), companion2.b("feff"), companion2.b("fffe0000"), companion2.b("fffe"), companion2.b("0000feff"));
    }

    public static final int A(String str, int i10) throws NumberFormatException {
        if (str != null) {
            try {
                long j10 = Long.parseLong(str);
                if (j10 > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (j10 < 0) {
                    return 0;
                }
                return (int) j10;
            } catch (NumberFormatException unused) {
            }
        }
        return i10;
    }

    public static final String B(String str, int i10, int i11) {
        kotlin.jvm.internal.p.i(str, "<this>");
        int iO = o(str, i10, i11);
        String strSubstring = str.substring(iO, q(str, iO, i11));
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String C(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return B(str, i10, i11);
    }

    public static final Throwable D(Exception exc, List<? extends Exception> suppressed) {
        kotlin.jvm.internal.p.i(exc, "<this>");
        kotlin.jvm.internal.p.i(suppressed, "suppressed");
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            Y8.d.a(exc, it.next());
        }
        return exc;
    }

    public static final void E(InterfaceC0967e interfaceC0967e, int i10) throws IOException {
        kotlin.jvm.internal.p.i(interfaceC0967e, "<this>");
        interfaceC0967e.writeByte((i10 >>> 16) & 255);
        interfaceC0967e.writeByte((i10 >>> 8) & 255);
        interfaceC0967e.writeByte(i10 & 255);
    }

    public static final <E> void a(List<E> list, E e10) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (list.contains(e10)) {
            return;
        }
        list.add(e10);
    }

    public static final int b(byte b10, int i10) {
        return b10 & i10;
    }

    public static final int c(short s10, int i10) {
        return s10 & i10;
    }

    public static final long d(int i10, long j10) {
        return i10 & j10;
    }

    public static final void e(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("length=" + j10 + ", offset=" + j11 + ", count=" + j11);
        }
    }

    public static final void f(Closeable closeable) throws IOException {
        kotlin.jvm.internal.p.i(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final String[] g(String[] strArr, String value) {
        kotlin.jvm.internal.p.i(strArr, "<this>");
        kotlin.jvm.internal.p.i(value, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[r.f0(strArr2)] = value;
        return strArr2;
    }

    public static final int h(String str, char c10, int i10, int i11) {
        kotlin.jvm.internal.p.i(str, "<this>");
        while (i10 < i11) {
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static final int i(String str, String delimiters, int i10, int i11) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(delimiters, "delimiters");
        while (i10 < i11) {
            if (H.f0(delimiters, str.charAt(i10), false, 2, null)) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int j(String str, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return h(str, c10, i10, i11);
    }

    public static final x k() {
        return f42669b;
    }

    public static final boolean l(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        kotlin.jvm.internal.p.i(strArr, "<this>");
        kotlin.jvm.internal.p.i(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final int m(String[] strArr, String value, Comparator<String> comparator) {
        kotlin.jvm.internal.p.i(strArr, "<this>");
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(comparator, "comparator");
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], value) == 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int n(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (kotlin.jvm.internal.p.k(cCharAt, 31) <= 0 || kotlin.jvm.internal.p.k(cCharAt, 127) >= 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int o(String str, int i10, int i11) {
        kotlin.jvm.internal.p.i(str, "<this>");
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int p(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return o(str, i10, i11);
    }

    public static final int q(String str, int i10, int i11) {
        kotlin.jvm.internal.p.i(str, "<this>");
        int i12 = i11 - 1;
        if (i10 <= i12) {
            while (true) {
                char cCharAt = str.charAt(i12);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i12 + 1;
                }
                if (i12 == i10) {
                    break;
                }
                i12--;
            }
        }
        return i10;
    }

    public static /* synthetic */ int r(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return q(str, i10, i11);
    }

    public static final int s(String str, int i10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        int length = str.length();
        while (i10 < length) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i10;
            }
            i10++;
        }
        return str.length();
    }

    public static final <T> List<T> t(Iterable<? extends T> a10, Iterable<? extends T> b10) {
        kotlin.jvm.internal.p.i(a10, "a");
        kotlin.jvm.internal.p.i(b10, "b");
        Iterator<? extends T> it = a10.iterator();
        Iterator<? extends T> it2 = b10.iterator();
        List listC = C1172u.c();
        while (true) {
            if (!it.hasNext() && !it2.hasNext()) {
                return C1172u.a(listC);
            }
            if (it.hasNext()) {
                listC.add(it.next());
            }
            if (it2.hasNext()) {
                listC.add(it2.next());
            }
        }
    }

    public static final String[] u(String[] strArr, String[] other, Comparator<? super String> comparator) {
        kotlin.jvm.internal.p.i(strArr, "<this>");
        kotlin.jvm.internal.p.i(other, "other");
        kotlin.jvm.internal.p.i(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = other.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (comparator.compare(str, other[i10]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i10++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean v(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return D.L(name, "Authorization", true) || D.L(name, "Cookie", true) || D.L(name, "Proxy-Authorization", true) || D.L(name, "Set-Cookie", true);
    }

    public static final int w(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        if ('a' <= c10 && c10 < 'g') {
            return c10 - 'W';
        }
        if ('A' > c10 || c10 >= 'G') {
            return -1;
        }
        return c10 - '7';
    }

    public static final int x(InterfaceC0968f interfaceC0968f) throws IOException {
        kotlin.jvm.internal.p.i(interfaceC0968f, "<this>");
        return b(interfaceC0968f.readByte(), 255) | (b(interfaceC0968f.readByte(), 255) << 16) | (b(interfaceC0968f.readByte(), 255) << 8);
    }

    public static final int y(C0966d c0966d, byte b10) throws EOFException {
        kotlin.jvm.internal.p.i(c0966d, "<this>");
        int i10 = 0;
        while (!c0966d.k() && c0966d.Y(0L) == b10) {
            i10++;
            c0966d.readByte();
        }
        return i10;
    }

    public static final long z(String str, long j10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }
}
