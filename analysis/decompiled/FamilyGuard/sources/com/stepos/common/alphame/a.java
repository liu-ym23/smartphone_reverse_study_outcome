package com.stepos.common.alphame;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0172a();

    /* renamed from: a, reason: collision with root package name */
    private Object[] f13550a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f13551b;

    /* renamed from: com.stepos.common.alphame.a$a, reason: collision with other inner class name */
    class C0172a implements Parcelable.Creator<a> {
        C0172a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            try {
                a aVar = new a(new Object[0]);
                aVar.D(parcel);
                return aVar;
            } catch (Exception e6) {
                Log.e("AlphaMe", "Exception when create Args from parcel : " + e6.getMessage());
                return null;
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i5) {
            return new a[i5];
        }
    }

    public a(Object... objArr) {
        a(objArr);
    }

    public static byte B(Object obj) {
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
        if (obj instanceof a) {
            return (byte) 15;
        }
        Log.e("AlphaMe", "Unsupported type,please support it" + obj);
        throw new IllegalArgumentException("Unsupported type ");
    }

    private void a(Object... objArr) {
        if (objArr == null) {
            this.f13550a = new Object[]{null};
        } else {
            this.f13550a = objArr;
        }
        c();
    }

    private void c() {
        Object[] objArr = this.f13550a;
        int i5 = 0;
        if (objArr.length == 0) {
            this.f13551b = new byte[]{0};
            return;
        }
        byte[] bArr = this.f13551b;
        if (bArr == null || bArr.length != objArr.length) {
            this.f13551b = new byte[objArr.length];
        }
        while (true) {
            Object[] objArr2 = this.f13550a;
            if (i5 >= objArr2.length) {
                return;
            }
            this.f13551b[i5] = B(objArr2[i5]);
            i5++;
        }
    }

    public boolean A() {
        return this.f13550a.length == 0;
    }

    public void D(Parcel parcel) {
        byte[] bArrCreateByteArray = parcel.createByteArray();
        this.f13551b = bArrCreateByteArray;
        if (bArrCreateByteArray[0] == 0) {
            this.f13550a = new Object[0];
            return;
        }
        this.f13550a = new Object[bArrCreateByteArray.length];
        int i5 = 0;
        while (true) {
            byte[] bArr = this.f13551b;
            if (i5 >= bArr.length) {
                return;
            }
            switch (bArr[i5]) {
                case 1:
                    this.f13550a[i5] = null;
                    break;
                case 2:
                    this.f13550a[i5] = Boolean.valueOf(parcel.readInt() == 1);
                    break;
                case 3:
                    this.f13550a[i5] = Byte.valueOf(parcel.readByte());
                    break;
                case 4:
                    this.f13550a[i5] = Integer.valueOf(parcel.readInt());
                    break;
                case 5:
                    this.f13550a[i5] = Long.valueOf(parcel.readLong());
                    break;
                case 6:
                    this.f13550a[i5] = parcel.readString();
                    break;
                case 7:
                    this.f13550a[i5] = parcel.readStrongBinder();
                    break;
                case 8:
                    this.f13550a[i5] = parcel.createByteArray();
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    this.f13550a[i5] = parcel.createStringArray();
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    this.f13550a[i5] = parcel.createIntArray();
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    this.f13550a[i5] = parcel.createLongArray();
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                    ArrayList arrayList = new ArrayList();
                    parcel.readStringList(arrayList);
                    this.f13550a[i5] = arrayList;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                    this.f13550a[i5] = Float.valueOf(parcel.readFloat());
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    this.f13550a[i5] = parcel.createFloatArray();
                    break;
                case 15:
                    a aVar = new a(new Object[0]);
                    aVar.D(parcel);
                    this.f13550a[i5] = aVar;
                    break;
            }
            i5++;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object[] f() {
        return this.f13550a;
    }

    public String toString() {
        if (A()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(16);
        sb.append("[");
        for (int i5 = 0; i5 < this.f13550a.length; i5++) {
            if (i5 != 0) {
                sb.append(",");
            }
            sb.append(this.f13550a[i5]);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeByteArray(this.f13551b);
        int i6 = 0;
        if (this.f13551b[0] == 0) {
            this.f13550a = new Object[0];
            return;
        }
        while (true) {
            byte[] bArr = this.f13551b;
            if (i6 >= bArr.length) {
                return;
            }
            switch (bArr[i6]) {
                case 2:
                    parcel.writeInt(((Boolean) this.f13550a[i6]).booleanValue() ? 1 : 0);
                    break;
                case 3:
                    parcel.writeByte(((Byte) this.f13550a[i6]).byteValue());
                    break;
                case 4:
                    parcel.writeInt(((Integer) this.f13550a[i6]).intValue());
                    break;
                case 5:
                    parcel.writeLong(((Long) this.f13550a[i6]).longValue());
                    break;
                case 6:
                    parcel.writeString((String) this.f13550a[i6]);
                    break;
                case 7:
                    parcel.writeStrongBinder((IBinder) this.f13550a[i6]);
                    break;
                case 8:
                    parcel.writeByteArray((byte[]) this.f13550a[i6]);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    parcel.writeStringArray((String[]) this.f13550a[i6]);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    parcel.writeIntArray((int[]) this.f13550a[i6]);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    parcel.writeLongArray((long[]) this.f13550a[i6]);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                    parcel.writeStringList((ArrayList) this.f13550a[i6]);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                    parcel.writeFloat(((Float) this.f13550a[i6]).floatValue());
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    parcel.writeFloatArray((float[]) this.f13550a[i6]);
                    break;
                case 15:
                    ((a) this.f13550a[i6]).writeToParcel(parcel, i5);
                    break;
            }
            i6++;
        }
    }
}
