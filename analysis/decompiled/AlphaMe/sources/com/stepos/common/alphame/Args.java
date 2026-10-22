package com.stepos.common.alphame;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Args implements Parcelable {
    public static final Parcelable.Creator<Args> CREATOR = new com.google.android.material.internal.f(2);

    /* renamed from: a, reason: collision with root package name */
    public Object[] f11220a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f11221b;

    public Args(Object... objArr) {
        int i4 = 0;
        this.f11220a = objArr;
        if (objArr.length == 0) {
            this.f11221b = new byte[]{0};
            return;
        }
        byte[] bArr = this.f11221b;
        if (bArr == null || bArr.length != objArr.length) {
            this.f11221b = new byte[objArr.length];
        }
        while (true) {
            Object[] objArr2 = this.f11220a;
            if (i4 >= objArr2.length) {
                return;
            }
            this.f11221b[i4] = h(objArr2[i4]);
            i4++;
        }
    }

    public static Class[] c(byte[] bArr) {
        Class cls;
        if (bArr == null || bArr.length == 0) {
            return new Class[0];
        }
        if (bArr.length == 1 && bArr[0] == 0) {
            return new Class[0];
        }
        Class[] clsArr = new Class[bArr.length];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            switch (bArr[i4]) {
                case 2:
                    cls = Boolean.TYPE;
                    break;
                case 3:
                    cls = Byte.TYPE;
                    break;
                case 4:
                    cls = Integer.TYPE;
                    break;
                case 5:
                    cls = Long.TYPE;
                    break;
                case 6:
                    cls = String.class;
                    break;
                case 7:
                    cls = IBinder.class;
                    break;
                case 8:
                    cls = byte[].class;
                    break;
                case 9:
                    cls = String[].class;
                    break;
                case 10:
                    cls = int[].class;
                    break;
                case 11:
                    cls = long[].class;
                    break;
                case 12:
                    cls = ArrayList.class;
                    break;
                case 13:
                    cls = Float.TYPE;
                    break;
                case 14:
                    cls = float[].class;
                    break;
                case 15:
                    cls = Args.class;
                    break;
                default:
                    cls = null;
                    break;
            }
            clsArr[i4] = cls;
        }
        return clsArr;
    }

    public static boolean f(byte b4, byte b5) {
        return !(b5 != 1 || b4 == 2 || b4 == 3 || b4 == 4 || b4 == 5 || b4 == 13) || b5 == b4;
    }

    public static boolean g(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i4 = 0; i4 < bArr.length; i4++) {
            if (!f(bArr[i4], bArr2[i4])) {
                return false;
            }
        }
        return true;
    }

    public static byte h(Object obj) {
        if (obj == null) {
            return (byte) 1;
        }
        if (obj instanceof Boolean) {
            return (byte) 2;
        }
        if (obj instanceof Byte) {
            return (byte) 3;
        }
        if (obj instanceof Integer) {
            return (byte) 4;
        }
        if (obj instanceof Long) {
            return (byte) 5;
        }
        if (obj instanceof String) {
            return (byte) 6;
        }
        if (obj instanceof IBinder) {
            return (byte) 7;
        }
        if (obj instanceof byte[]) {
            return (byte) 8;
        }
        if (obj instanceof int[]) {
            return (byte) 10;
        }
        if (obj instanceof long[]) {
            return (byte) 11;
        }
        if (obj instanceof String[]) {
            return (byte) 9;
        }
        if (obj instanceof ArrayList) {
            return (byte) 12;
        }
        if (obj instanceof Float) {
            return (byte) 13;
        }
        if (obj instanceof float[]) {
            return (byte) 14;
        }
        if (obj instanceof Args) {
            return (byte) 15;
        }
        Log.e("AlphaMe", "Unsupported type,please support it" + obj);
        throw new IllegalArgumentException("Unsupported type ");
    }

    public static String j(byte[] bArr) {
        StringBuilder sb = new StringBuilder(16);
        sb.append("(");
        for (int i4 = 0; i4 < bArr.length; i4++) {
            if (i4 != 0) {
                sb.append(",");
            }
            sb.append(k(bArr[i4]));
            sb.append(" param");
            sb.append(i4);
        }
        sb.append(")");
        return sb.toString();
    }

    public static String k(byte b4) {
        switch (b4) {
            case 0:
                return "void";
            case 1:
                return "null";
            case 2:
                return "boolean";
            case 3:
                return "byte";
            case 4:
                return "int";
            case 5:
                return "long";
            case 6:
                return "String";
            case 7:
                return "IBinder";
            case 8:
                return "byte[]";
            case 9:
                return "String[]";
            case 10:
                return "int[]";
            case 11:
                return "long[]";
            case 12:
                return "ArrayList<String>";
            case 13:
                return "float";
            case 14:
                return "float[]";
            case 15:
                return "Args";
            default:
                return "unkown";
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void i(Parcel parcel) {
        byte[] bArrCreateByteArray = parcel.createByteArray();
        this.f11221b = bArrCreateByteArray;
        if (bArrCreateByteArray[0] == 0) {
            this.f11220a = new Object[0];
            return;
        }
        this.f11220a = new Object[bArrCreateByteArray.length];
        int i4 = 0;
        while (true) {
            byte[] bArr = this.f11221b;
            if (i4 >= bArr.length) {
                return;
            }
            switch (bArr[i4]) {
                case 1:
                    this.f11220a[i4] = null;
                    break;
                case 2:
                    this.f11220a[i4] = Boolean.valueOf(parcel.readInt() == 1);
                    break;
                case 3:
                    this.f11220a[i4] = Byte.valueOf(parcel.readByte());
                    break;
                case 4:
                    this.f11220a[i4] = Integer.valueOf(parcel.readInt());
                    break;
                case 5:
                    this.f11220a[i4] = Long.valueOf(parcel.readLong());
                    break;
                case 6:
                    this.f11220a[i4] = parcel.readString();
                    break;
                case 7:
                    this.f11220a[i4] = parcel.readStrongBinder();
                    break;
                case 8:
                    this.f11220a[i4] = parcel.createByteArray();
                    break;
                case 9:
                    this.f11220a[i4] = parcel.createStringArray();
                    break;
                case 10:
                    this.f11220a[i4] = parcel.createIntArray();
                    break;
                case 11:
                    this.f11220a[i4] = parcel.createLongArray();
                    break;
                case 12:
                    ArrayList arrayList = new ArrayList();
                    parcel.readStringList(arrayList);
                    this.f11220a[i4] = arrayList;
                    break;
                case 13:
                    this.f11220a[i4] = Float.valueOf(parcel.readFloat());
                    break;
                case 14:
                    this.f11220a[i4] = parcel.createFloatArray();
                    break;
                case 15:
                    Args args = new Args(new Object[0]);
                    args.i(parcel);
                    this.f11220a[i4] = args;
                    break;
            }
            i4++;
        }
    }

    public final String toString() {
        if (this.f11220a.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(16);
        sb.append("[");
        for (int i4 = 0; i4 < this.f11220a.length; i4++) {
            if (i4 != 0) {
                sb.append(",");
            }
            sb.append(this.f11220a[i4]);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeByteArray(this.f11221b);
        int i5 = 0;
        if (this.f11221b[0] == 0) {
            this.f11220a = new Object[0];
            return;
        }
        while (true) {
            byte[] bArr = this.f11221b;
            if (i5 >= bArr.length) {
                return;
            }
            switch (bArr[i5]) {
                case 2:
                    parcel.writeInt(((Boolean) this.f11220a[i5]).booleanValue() ? 1 : 0);
                    break;
                case 3:
                    parcel.writeByte(((Byte) this.f11220a[i5]).byteValue());
                    break;
                case 4:
                    parcel.writeInt(((Integer) this.f11220a[i5]).intValue());
                    break;
                case 5:
                    parcel.writeLong(((Long) this.f11220a[i5]).longValue());
                    break;
                case 6:
                    parcel.writeString((String) this.f11220a[i5]);
                    break;
                case 7:
                    parcel.writeStrongBinder((IBinder) this.f11220a[i5]);
                    break;
                case 8:
                    parcel.writeByteArray((byte[]) this.f11220a[i5]);
                    break;
                case 9:
                    parcel.writeStringArray((String[]) this.f11220a[i5]);
                    break;
                case 10:
                    parcel.writeIntArray((int[]) this.f11220a[i5]);
                    break;
                case 11:
                    parcel.writeLongArray((long[]) this.f11220a[i5]);
                    break;
                case 12:
                    parcel.writeStringList((ArrayList) this.f11220a[i5]);
                    break;
                case 13:
                    parcel.writeFloat(((Float) this.f11220a[i5]).floatValue());
                    break;
                case 14:
                    parcel.writeFloatArray((float[]) this.f11220a[i5]);
                    break;
                case 15:
                    ((Args) this.f11220a[i5]).writeToParcel(parcel, i4);
                    break;
            }
            i5++;
        }
    }
}
