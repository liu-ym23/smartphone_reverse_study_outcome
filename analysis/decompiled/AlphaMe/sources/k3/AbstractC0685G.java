package k3;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l3.AbstractC0766b;
import s.AbstractC0831a;

/* renamed from: k3.G, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0685G {

    /* renamed from: a, reason: collision with root package name */
    public static final C0692g f13339a = new C0692g();

    public static final boolean a(byte[] a4, int i4, int i5, byte[] b4, int i6) {
        Intrinsics.checkNotNullParameter(a4, "a");
        Intrinsics.checkNotNullParameter(b4, "b");
        for (int i7 = 0; i7 < i6; i7++) {
            if (a4[i7 + i4] != b4[i7 + i5]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j4, long j5, long j6) {
        if ((j5 | j6) < 0 || j5 > j4 || j4 - j5 < j6) {
            StringBuilder sbE = AbstractC0831a.e("size=", j4, " offset=");
            sbE.append(j5);
            sbE.append(" byteCount=");
            sbE.append(j6);
            throw new ArrayIndexOutOfBoundsException(sbE.toString());
        }
    }

    public static final String c(byte b4) {
        char[] cArr = AbstractC0766b.f13506a;
        return StringsKt.concatToString(new char[]{cArr[(b4 >> 4) & 15], cArr[b4 & 15]});
    }
}
