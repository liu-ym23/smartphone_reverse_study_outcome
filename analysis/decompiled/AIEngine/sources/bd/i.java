package bd;

import androidx.datastore.preferences.protobuf.b1;
import com.tonyodev.fetch2core.server.FileRequest;
import gc.q;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Comparator;
import sd.w;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f3230a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public static final w f3231b;

    /* renamed from: c, reason: collision with root package name */
    public static final okhttp3.f f3232c;

    /* renamed from: d, reason: collision with root package name */
    public static final g f3233d;

    /* JADX WARN: Code restructure failed: missing block: B:68:0x012b, code lost:
    
        continue;
     */
    static {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bd.i.<clinit>():void");
    }

    public static final void a(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "length=", ", offset=");
            sbQ.append(j11);
            sbQ.append(", count=");
            sbQ.append(j11);
            throw new ArrayIndexOutOfBoundsException(sbQ.toString());
        }
    }

    public static final void b(Closeable closeable) {
        kotlin.jvm.internal.g.f(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final int c(String str, char c9, int i10, int i11) {
        kotlin.jvm.internal.g.f(str, "<this>");
        while (i10 < i11) {
            if (str.charAt(i10) == c9) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static final int d(String str, int i10, int i11, String str2) {
        kotlin.jvm.internal.g.f(str, "<this>");
        while (i10 < i11) {
            if (q.m0(str2, str.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int e(String str, char c9, int i10, int i11, int i12) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return c(str, c9, i10, i11);
    }

    public static final boolean f(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        kotlin.jvm.internal.g.f(strArr, "<this>");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                kotlin.jvm.internal.a aVarO = b1.O(strArr2);
                while (aVarO.hasNext()) {
                    if (comparator.compare(str, (String) aVarO.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final int g(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (kotlin.jvm.internal.g.g(cCharAt, 31) <= 0 || kotlin.jvm.internal.g.g(cCharAt, 127) >= 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int h(int i10, int i11, String str) {
        kotlin.jvm.internal.g.f(str, "<this>");
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static final int i(int i10, int i11, String str) {
        kotlin.jvm.internal.g.f(str, "<this>");
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

    public static final String[] j(String[] strArr, String[] other, Comparator<? super String> comparator) {
        kotlin.jvm.internal.g.f(strArr, "<this>");
        kotlin.jvm.internal.g.f(other, "other");
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

    public static final boolean k(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        return name.equalsIgnoreCase(FileRequest.FIELD_AUTHORIZATION) || name.equalsIgnoreCase("Cookie") || name.equalsIgnoreCase("Proxy-Authorization") || name.equalsIgnoreCase("Set-Cookie");
    }

    public static final int l(char c9) {
        if ('0' <= c9 && c9 < ':') {
            return c9 - '0';
        }
        if ('a' <= c9 && c9 < 'g') {
            return c9 - 'W';
        }
        if ('A' > c9 || c9 >= 'G') {
            return -1;
        }
        return c9 - '7';
    }

    public static final int m(sd.h hVar) {
        kotlin.jvm.internal.g.f(hVar, "<this>");
        return (hVar.readByte() & 255) | ((hVar.readByte() & 255) << 16) | ((hVar.readByte() & 255) << 8);
    }

    public static final int n(int i10, String str) throws NumberFormatException {
        if (str == null) {
            return i10;
        }
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
            return i10;
        }
    }

    public static final String o(int i10, int i11, String str) {
        int iH = h(i10, i11, str);
        String strSubstring = str.substring(iH, i(iH, i11, str));
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }
}
