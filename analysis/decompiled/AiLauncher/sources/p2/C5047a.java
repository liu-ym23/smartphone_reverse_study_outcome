package p2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* renamed from: p2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5047a {
    public static <T extends Parcelable> void A(Parcel parcel, int i10, T[] tArr, int i11, boolean z10) {
        if (tArr == null) {
            if (z10) {
                E(parcel, i10, 0);
                return;
            }
            return;
        }
        int iC = C(parcel, i10);
        parcel.writeInt(tArr.length);
        for (T t10 : tArr) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                F(parcel, t10, i11);
            }
        }
        D(parcel, iC);
    }

    public static <T extends Parcelable> void B(Parcel parcel, int i10, List<T> list, boolean z10) {
        if (list == null) {
            if (z10) {
                E(parcel, i10, 0);
                return;
            }
            return;
        }
        int iC = C(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            T t10 = list.get(i11);
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                F(parcel, t10, 0);
            }
        }
        D(parcel, iC);
    }

    public static int C(Parcel parcel, int i10) {
        parcel.writeInt(i10 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void D(Parcel parcel, int i10) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(iDataPosition - i10);
        parcel.setDataPosition(iDataPosition);
    }

    public static void E(Parcel parcel, int i10, int i11) {
        parcel.writeInt(i10 | (i11 << 16));
    }

    public static void F(Parcel parcel, Parcelable parcelable, int i10) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i10);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    public static int a(Parcel parcel) {
        return C(parcel, 20293);
    }

    public static void b(Parcel parcel, int i10) {
        D(parcel, i10);
    }

    public static void c(Parcel parcel, int i10, BigDecimal bigDecimal, boolean z10) {
        if (bigDecimal == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            D(parcel, iC);
        }
    }

    public static void d(Parcel parcel, int i10, BigDecimal[] bigDecimalArr, boolean z10) {
        if (bigDecimalArr == null) {
            if (z10) {
                E(parcel, i10, 0);
                return;
            }
            return;
        }
        int iC = C(parcel, i10);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i11 = 0; i11 < length; i11++) {
            parcel.writeByteArray(bigDecimalArr[i11].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i11].scale());
        }
        D(parcel, iC);
    }

    public static void e(Parcel parcel, int i10, BigInteger bigInteger, boolean z10) {
        if (bigInteger == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeByteArray(bigInteger.toByteArray());
            D(parcel, iC);
        }
    }

    public static void f(Parcel parcel, int i10, BigInteger[] bigIntegerArr, boolean z10) {
        if (bigIntegerArr == null) {
            if (z10) {
                E(parcel, i10, 0);
                return;
            }
            return;
        }
        int iC = C(parcel, i10);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        D(parcel, iC);
    }

    public static void g(Parcel parcel, int i10, boolean z10) {
        E(parcel, i10, 4);
        parcel.writeInt(z10 ? 1 : 0);
    }

    public static void h(Parcel parcel, int i10, boolean[] zArr, boolean z10) {
        if (zArr == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeBooleanArray(zArr);
            D(parcel, iC);
        }
    }

    public static void i(Parcel parcel, int i10, Bundle bundle, boolean z10) {
        if (bundle == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeBundle(bundle);
            D(parcel, iC);
        }
    }

    public static void j(Parcel parcel, int i10, byte[] bArr, boolean z10) {
        if (bArr == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeByteArray(bArr);
            D(parcel, iC);
        }
    }

    public static void k(Parcel parcel, int i10, double d10) {
        E(parcel, i10, 8);
        parcel.writeDouble(d10);
    }

    public static void l(Parcel parcel, int i10, double[] dArr, boolean z10) {
        if (dArr == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeDoubleArray(dArr);
            D(parcel, iC);
        }
    }

    public static void m(Parcel parcel, int i10, float f10) {
        E(parcel, i10, 4);
        parcel.writeFloat(f10);
    }

    public static void n(Parcel parcel, int i10, float[] fArr, boolean z10) {
        if (fArr == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeFloatArray(fArr);
            D(parcel, iC);
        }
    }

    public static void o(Parcel parcel, int i10, IBinder iBinder, boolean z10) {
        if (iBinder == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeStrongBinder(iBinder);
            D(parcel, iC);
        }
    }

    public static void p(Parcel parcel, int i10, int i11) {
        E(parcel, i10, 4);
        parcel.writeInt(i11);
    }

    public static void q(Parcel parcel, int i10, int[] iArr, boolean z10) {
        if (iArr == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeIntArray(iArr);
            D(parcel, iC);
        }
    }

    public static void r(Parcel parcel, int i10, long j10) {
        E(parcel, i10, 8);
        parcel.writeLong(j10);
    }

    public static void s(Parcel parcel, int i10, long[] jArr, boolean z10) {
        if (jArr == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeLongArray(jArr);
            D(parcel, iC);
        }
    }

    public static void t(Parcel parcel, int i10, Long l10, boolean z10) {
        if (l10 != null) {
            E(parcel, i10, 8);
            parcel.writeLong(l10.longValue());
        } else if (z10) {
            E(parcel, i10, 0);
        }
    }

    public static void u(Parcel parcel, int i10, Parcel parcel2, boolean z10) {
        if (parcel2 == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            D(parcel, iC);
        }
    }

    public static void v(Parcel parcel, int i10, List<Parcel> list, boolean z10) {
        if (list == null) {
            if (z10) {
                E(parcel, i10, 0);
                return;
            }
            return;
        }
        int iC = C(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            Parcel parcel2 = list.get(i11);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        D(parcel, iC);
    }

    public static void w(Parcel parcel, int i10, Parcelable parcelable, int i11, boolean z10) {
        if (parcelable == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcelable.writeToParcel(parcel, i11);
            D(parcel, iC);
        }
    }

    public static void x(Parcel parcel, int i10, String str, boolean z10) {
        if (str == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeString(str);
            D(parcel, iC);
        }
    }

    public static void y(Parcel parcel, int i10, String[] strArr, boolean z10) {
        if (strArr == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeStringArray(strArr);
            D(parcel, iC);
        }
    }

    public static void z(Parcel parcel, int i10, List<String> list, boolean z10) {
        if (list == null) {
            if (z10) {
                E(parcel, i10, 0);
            }
        } else {
            int iC = C(parcel, i10);
            parcel.writeStringList(list);
            D(parcel, iC);
        }
    }
}
