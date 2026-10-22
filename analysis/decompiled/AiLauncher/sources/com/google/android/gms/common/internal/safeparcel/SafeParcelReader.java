package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static int A(Parcel parcel, int i10) {
        H(parcel, i10, 4);
        return parcel.readInt();
    }

    public static long B(Parcel parcel, int i10) {
        H(parcel, i10, 8);
        return parcel.readLong();
    }

    public static Long C(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        if (iD == 0) {
            return null;
        }
        G(parcel, i10, iD, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int D(Parcel parcel, int i10) {
        return (i10 & (-65536)) != -65536 ? (char) (i10 >> 16) : parcel.readInt();
    }

    public static void E(Parcel parcel, int i10) {
        parcel.setDataPosition(parcel.dataPosition() + D(parcel, i10));
    }

    public static int F(Parcel parcel) {
        int iY = y(parcel);
        int iD = D(parcel, iY);
        int iU = u(iY);
        int iDataPosition = parcel.dataPosition();
        if (iU != 20293) {
            throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iY))), parcel);
        }
        int i10 = iD + iDataPosition;
        if (i10 >= iDataPosition && i10 <= parcel.dataSize()) {
            return i10;
        }
        throw new ParseException("Size read is invalid start=" + iDataPosition + " end=" + i10, parcel);
    }

    public static void G(Parcel parcel, int i10, int i11, int i12) {
        if (i11 == i12) {
            return;
        }
        throw new ParseException("Expected size " + i12 + " got " + i11 + " (0x" + Integer.toHexString(i11) + ")", parcel);
    }

    public static void H(Parcel parcel, int i10, int i11) {
        int iD = D(parcel, i10);
        if (iD == i11) {
            return;
        }
        throw new ParseException("Expected size " + i11 + " got " + iD + " (0x" + Integer.toHexString(iD) + ")", parcel);
    }

    public static BigDecimal a(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i11 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iD);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i11);
    }

    public static BigDecimal[] b(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            bigDecimalArr[i12] = new BigDecimal(new BigInteger(bArrCreateByteArray), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + iD);
        return bigDecimalArr;
    }

    public static BigInteger c(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iD);
        return new BigInteger(bArrCreateByteArray);
    }

    public static BigInteger[] d(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bigIntegerArr[i12] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(iDataPosition + iD);
        return bigIntegerArr;
    }

    public static boolean[] e(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(iDataPosition + iD);
        return zArrCreateBooleanArray;
    }

    public static Bundle f(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iD);
        return bundle;
    }

    public static byte[] g(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iD);
        return bArrCreateByteArray;
    }

    public static double[] h(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        double[] dArrCreateDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(iDataPosition + iD);
        return dArrCreateDoubleArray;
    }

    public static float[] i(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        float[] fArrCreateFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(iDataPosition + iD);
        return fArrCreateFloatArray;
    }

    public static int[] j(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iD);
        return iArrCreateIntArray;
    }

    public static long[] k(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iDataPosition + iD);
        return jArrCreateLongArray;
    }

    public static Parcel l(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(parcel, iDataPosition, iD);
        parcel.setDataPosition(iDataPosition + iD);
        return parcelObtain;
    }

    public static Parcel[] m(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        Parcel[] parcelArr = new Parcel[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = parcel.readInt();
            if (i13 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i13);
                parcelArr[i12] = parcelObtain;
                parcel.setDataPosition(iDataPosition2 + i13);
            } else {
                parcelArr[i12] = null;
            }
        }
        parcel.setDataPosition(iDataPosition + iD);
        return parcelArr;
    }

    public static <T extends Parcelable> T n(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iD);
        return tCreateFromParcel;
    }

    public static String o(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iD);
        return string;
    }

    public static String[] p(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iD);
        return strArrCreateStringArray;
    }

    public static ArrayList<String> q(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iD);
        return arrayListCreateStringArrayList;
    }

    public static <T> T[] r(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iD);
        return tArr;
    }

    public static <T> ArrayList<T> s(Parcel parcel, int i10, Parcelable.Creator<T> creator) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iD);
        return arrayListCreateTypedArrayList;
    }

    public static void t(Parcel parcel, int i10) {
        if (parcel.dataPosition() == i10) {
            return;
        }
        throw new ParseException("Overread allowed size end=" + i10, parcel);
    }

    public static int u(int i10) {
        return (char) i10;
    }

    public static boolean v(Parcel parcel, int i10) {
        H(parcel, i10, 4);
        return parcel.readInt() != 0;
    }

    public static double w(Parcel parcel, int i10) {
        H(parcel, i10, 8);
        return parcel.readDouble();
    }

    public static float x(Parcel parcel, int i10) {
        H(parcel, i10, 4);
        return parcel.readFloat();
    }

    public static int y(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder z(Parcel parcel, int i10) {
        int iD = D(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iD == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iD);
        return strongBinder;
    }
}
