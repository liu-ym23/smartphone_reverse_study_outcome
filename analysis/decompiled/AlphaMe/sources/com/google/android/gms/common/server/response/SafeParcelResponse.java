package com.google.android.gms.common.server.response;

import B0.f;
import a1.C0154a;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.fragment.app.A;
import androidx.room.AbstractC0351g;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.stepos.statsrpk.c;
import e1.AbstractC0551a;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import s.AbstractC0831a;
import t0.J;

@VisibleForTesting
@KeepForSdk
@SafeParcelable.Class(creator = "SafeParcelResponseCreator")
/* loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new C0154a(25);

    /* renamed from: a, reason: collision with root package name */
    public final int f9916a;

    /* renamed from: b, reason: collision with root package name */
    public final Parcel f9917b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9918c;

    /* renamed from: d, reason: collision with root package name */
    public final zan f9919d;

    /* renamed from: e, reason: collision with root package name */
    public final String f9920e;

    /* renamed from: f, reason: collision with root package name */
    public int f9921f;

    /* renamed from: g, reason: collision with root package name */
    public int f9922g;

    public SafeParcelResponse(int i4, Parcel parcel, zan zanVar) {
        this.f9916a = i4;
        c.l(parcel);
        this.f9917b = parcel;
        this.f9918c = 2;
        this.f9919d = zanVar;
        this.f9920e = zanVar == null ? null : zanVar.f9931c;
        this.f9921f = 2;
    }

    public static void p(StringBuilder sb, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse$Field) entry.getValue()).f9911g, entry);
        }
        sb.append('{');
        int iD0 = f.D0(parcel);
        boolean z4 = false;
        while (parcel.dataPosition() < iD0) {
            int i4 = parcel.readInt();
            Map.Entry entry2 = (Map.Entry) sparseArray.get((char) i4);
            if (entry2 != null) {
                if (z4) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse$Field fastJsonResponse$Field = (FastJsonResponse$Field) entry2.getValue();
                AbstractC0831a.h(sb, "\"", str, "\":");
                StringToIntConverter stringToIntConverter = fastJsonResponse$Field.f9915k;
                BigInteger bigInteger = null;
                BigInteger bigInteger2 = null;
                Parcel[] parcelArr = null;
                String[] strArrCreateStringArray = null;
                boolean[] zArrCreateBooleanArray = null;
                BigDecimal[] bigDecimalArr = null;
                double[] dArrCreateDoubleArray = null;
                float[] fArrCreateFloatArray = null;
                long[] jArrCreateLongArray = null;
                BigInteger[] bigIntegerArr = null;
                Parcel parcelObtain = null;
                int i5 = fastJsonResponse$Field.f9908d;
                if (stringToIntConverter != null) {
                    switch (i5) {
                        case 0:
                            r(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.k(fastJsonResponse$Field, Integer.valueOf(f.o0(parcel, i4))));
                            break;
                        case 1:
                            int iQ0 = f.q0(parcel, i4);
                            int iDataPosition = parcel.dataPosition();
                            if (iQ0 != 0) {
                                byte[] bArrCreateByteArray = parcel.createByteArray();
                                parcel.setDataPosition(iDataPosition + iQ0);
                                bigInteger2 = new BigInteger(bArrCreateByteArray);
                            }
                            r(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.k(fastJsonResponse$Field, bigInteger2));
                            break;
                        case 2:
                            r(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.k(fastJsonResponse$Field, Long.valueOf(f.p0(parcel, i4))));
                            break;
                        case 3:
                            r(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.k(fastJsonResponse$Field, Float.valueOf(f.l0(parcel, i4))));
                            break;
                        case 4:
                            r(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.k(fastJsonResponse$Field, Double.valueOf(f.k0(parcel, i4))));
                            break;
                        case 5:
                            r(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.k(fastJsonResponse$Field, f.j(parcel, i4)));
                            break;
                        case 6:
                            r(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.k(fastJsonResponse$Field, Boolean.valueOf(f.i0(parcel, i4))));
                            break;
                        case 7:
                            r(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.k(fastJsonResponse$Field, f.q(parcel, i4)));
                            break;
                        case 8:
                        case 9:
                            r(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.k(fastJsonResponse$Field, f.l(parcel, i4)));
                            break;
                        case 10:
                            Bundle bundleK = f.k(parcel, i4);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleK.keySet()) {
                                String string = bundleK.getString(str2);
                                c.l(string);
                                map2.put(str2, string);
                            }
                            r(sb, fastJsonResponse$Field, FastSafeParcelableJsonResponse.k(fastJsonResponse$Field, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException(AbstractC0351g.m("Unknown field out type = ", i5));
                    }
                } else {
                    boolean z5 = fastJsonResponse$Field.f9909e;
                    String str3 = fastJsonResponse$Field.f9913i;
                    if (z5) {
                        sb.append("[");
                        switch (i5) {
                            case 0:
                                int[] iArrO = f.o(parcel, i4);
                                int length = iArrO.length;
                                for (int i6 = 0; i6 < length; i6++) {
                                    if (i6 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(Integer.toString(iArrO[i6]));
                                }
                                break;
                            case 1:
                                int iQ02 = f.q0(parcel, i4);
                                int iDataPosition2 = parcel.dataPosition();
                                if (iQ02 != 0) {
                                    int i7 = parcel.readInt();
                                    bigIntegerArr = new BigInteger[i7];
                                    for (int i8 = 0; i8 < i7; i8++) {
                                        bigIntegerArr[i8] = new BigInteger(parcel.createByteArray());
                                    }
                                    parcel.setDataPosition(iDataPosition2 + iQ02);
                                }
                                int length2 = bigIntegerArr.length;
                                for (int i9 = 0; i9 < length2; i9++) {
                                    if (i9 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(bigIntegerArr[i9]);
                                }
                                break;
                            case 2:
                                int iQ03 = f.q0(parcel, i4);
                                int iDataPosition3 = parcel.dataPosition();
                                if (iQ03 != 0) {
                                    jArrCreateLongArray = parcel.createLongArray();
                                    parcel.setDataPosition(iDataPosition3 + iQ03);
                                }
                                int length3 = jArrCreateLongArray.length;
                                for (int i10 = 0; i10 < length3; i10++) {
                                    if (i10 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(Long.toString(jArrCreateLongArray[i10]));
                                }
                                break;
                            case 3:
                                int iQ04 = f.q0(parcel, i4);
                                int iDataPosition4 = parcel.dataPosition();
                                if (iQ04 != 0) {
                                    fArrCreateFloatArray = parcel.createFloatArray();
                                    parcel.setDataPosition(iDataPosition4 + iQ04);
                                }
                                int length4 = fArrCreateFloatArray.length;
                                for (int i11 = 0; i11 < length4; i11++) {
                                    if (i11 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(Float.toString(fArrCreateFloatArray[i11]));
                                }
                                break;
                            case 4:
                                int iQ05 = f.q0(parcel, i4);
                                int iDataPosition5 = parcel.dataPosition();
                                if (iQ05 != 0) {
                                    dArrCreateDoubleArray = parcel.createDoubleArray();
                                    parcel.setDataPosition(iDataPosition5 + iQ05);
                                }
                                int length5 = dArrCreateDoubleArray.length;
                                for (int i12 = 0; i12 < length5; i12++) {
                                    if (i12 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(Double.toString(dArrCreateDoubleArray[i12]));
                                }
                                break;
                            case 5:
                                int iQ06 = f.q0(parcel, i4);
                                int iDataPosition6 = parcel.dataPosition();
                                if (iQ06 != 0) {
                                    int i13 = parcel.readInt();
                                    bigDecimalArr = new BigDecimal[i13];
                                    for (int i14 = 0; i14 < i13; i14++) {
                                        bigDecimalArr[i14] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
                                    }
                                    parcel.setDataPosition(iDataPosition6 + iQ06);
                                }
                                int length6 = bigDecimalArr.length;
                                for (int i15 = 0; i15 < length6; i15++) {
                                    if (i15 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(bigDecimalArr[i15]);
                                }
                                break;
                            case 6:
                                int iQ07 = f.q0(parcel, i4);
                                int iDataPosition7 = parcel.dataPosition();
                                if (iQ07 != 0) {
                                    zArrCreateBooleanArray = parcel.createBooleanArray();
                                    parcel.setDataPosition(iDataPosition7 + iQ07);
                                }
                                int length7 = zArrCreateBooleanArray.length;
                                for (int i16 = 0; i16 < length7; i16++) {
                                    if (i16 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append(Boolean.toString(zArrCreateBooleanArray[i16]));
                                }
                                break;
                            case 7:
                                int iQ08 = f.q0(parcel, i4);
                                int iDataPosition8 = parcel.dataPosition();
                                if (iQ08 != 0) {
                                    strArrCreateStringArray = parcel.createStringArray();
                                    parcel.setDataPosition(iDataPosition8 + iQ08);
                                }
                                int length8 = strArrCreateStringArray.length;
                                for (int i17 = 0; i17 < length8; i17++) {
                                    if (i17 != 0) {
                                        sb.append(",");
                                    }
                                    sb.append("\"");
                                    sb.append(strArrCreateStringArray[i17]);
                                    sb.append("\"");
                                }
                                break;
                            case 8:
                            case 9:
                            case 10:
                                throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                            case 11:
                                int iQ09 = f.q0(parcel, i4);
                                int iDataPosition9 = parcel.dataPosition();
                                if (iQ09 != 0) {
                                    int i18 = parcel.readInt();
                                    Parcel[] parcelArr2 = new Parcel[i18];
                                    for (int i19 = 0; i19 < i18; i19++) {
                                        int i20 = parcel.readInt();
                                        if (i20 != 0) {
                                            int iDataPosition10 = parcel.dataPosition();
                                            Parcel parcelObtain2 = Parcel.obtain();
                                            parcelObtain2.appendFrom(parcel, iDataPosition10, i20);
                                            parcelArr2[i19] = parcelObtain2;
                                            parcel.setDataPosition(iDataPosition10 + i20);
                                        } else {
                                            parcelArr2[i19] = null;
                                        }
                                    }
                                    parcel.setDataPosition(iDataPosition9 + iQ09);
                                    parcelArr = parcelArr2;
                                }
                                int length9 = parcelArr.length;
                                for (int i21 = 0; i21 < length9; i21++) {
                                    if (i21 > 0) {
                                        sb.append(",");
                                    }
                                    parcelArr[i21].setDataPosition(0);
                                    c.l(str3);
                                    c.l(fastJsonResponse$Field.f9914j);
                                    Map map3 = (Map) fastJsonResponse$Field.f9914j.f9930b.get(str3);
                                    c.l(map3);
                                    p(sb, map3, parcelArr[i21]);
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out.");
                        }
                        sb.append("]");
                    } else {
                        switch (i5) {
                            case 0:
                                sb.append(f.o0(parcel, i4));
                                break;
                            case 1:
                                int iQ010 = f.q0(parcel, i4);
                                int iDataPosition11 = parcel.dataPosition();
                                if (iQ010 != 0) {
                                    byte[] bArrCreateByteArray2 = parcel.createByteArray();
                                    parcel.setDataPosition(iDataPosition11 + iQ010);
                                    bigInteger = new BigInteger(bArrCreateByteArray2);
                                }
                                sb.append(bigInteger);
                                break;
                            case 2:
                                sb.append(f.p0(parcel, i4));
                                break;
                            case 3:
                                sb.append(f.l0(parcel, i4));
                                break;
                            case 4:
                                sb.append(f.k0(parcel, i4));
                                break;
                            case 5:
                                sb.append(f.j(parcel, i4));
                                break;
                            case 6:
                                sb.append(f.i0(parcel, i4));
                                break;
                            case 7:
                                String strQ = f.q(parcel, i4);
                                sb.append("\"");
                                sb.append(AbstractC0551a.a(strQ));
                                sb.append("\"");
                                break;
                            case 8:
                                byte[] bArrL = f.l(parcel, i4);
                                sb.append("\"");
                                sb.append(bArrL != null ? Base64.encodeToString(bArrL, 0) : null);
                                sb.append("\"");
                                break;
                            case 9:
                                byte[] bArrL2 = f.l(parcel, i4);
                                sb.append("\"");
                                sb.append(bArrL2 != null ? Base64.encodeToString(bArrL2, 10) : null);
                                sb.append("\"");
                                break;
                            case 10:
                                Bundle bundleK2 = f.k(parcel, i4);
                                Set<String> setKeySet = bundleK2.keySet();
                                sb.append("{");
                                boolean z6 = true;
                                for (String str4 : setKeySet) {
                                    if (!z6) {
                                        sb.append(",");
                                    }
                                    AbstractC0831a.h(sb, "\"", str4, "\":\"");
                                    sb.append(AbstractC0551a.a(bundleK2.getString(str4)));
                                    sb.append("\"");
                                    z6 = false;
                                }
                                sb.append("}");
                                break;
                            case 11:
                                int iQ011 = f.q0(parcel, i4);
                                int iDataPosition12 = parcel.dataPosition();
                                if (iQ011 != 0) {
                                    parcelObtain = Parcel.obtain();
                                    parcelObtain.appendFrom(parcel, iDataPosition12, iQ011);
                                    parcel.setDataPosition(iDataPosition12 + iQ011);
                                }
                                parcelObtain.setDataPosition(0);
                                c.l(str3);
                                c.l(fastJsonResponse$Field.f9914j);
                                Map map4 = (Map) fastJsonResponse$Field.f9914j.f9930b.get(str3);
                                c.l(map4);
                                p(sb, map4, parcelObtain);
                                break;
                            default:
                                throw new IllegalStateException("Unknown field type out");
                        }
                    }
                }
                z4 = true;
            }
        }
        if (parcel.dataPosition() != iD0) {
            throw new A(AbstractC0351g.m("Overread allowed size end=", iD0), parcel);
        }
        sb.append('}');
    }

    public static final void q(StringBuilder sb, int i4, Object obj) {
        switch (i4) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                c.l(obj);
                sb.append(AbstractC0551a.a(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                byte[] bArr = (byte[]) obj;
                sb.append(bArr != null ? Base64.encodeToString(bArr, 0) : null);
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                byte[] bArr2 = (byte[]) obj;
                sb.append(bArr2 != null ? Base64.encodeToString(bArr2, 10) : null);
                sb.append("\"");
                return;
            case 10:
                c.l(obj);
                f.E0(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(AbstractC0351g.m("Unknown type = ", i4));
        }
    }

    public static final void r(StringBuilder sb, FastJsonResponse$Field fastJsonResponse$Field, Object obj) {
        boolean z4 = fastJsonResponse$Field.f9907c;
        int i4 = fastJsonResponse$Field.f9906b;
        if (!z4) {
            q(sb, i4, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 != 0) {
                sb.append(",");
            }
            q(sb, i4, arrayList.get(i5));
        }
        sb.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final Map c() {
        zan zanVar = this.f9919d;
        if (zanVar == null) {
            return null;
        }
        String str = this.f9920e;
        c.l(str);
        return (Map) zanVar.f9930b.get(str);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final Object g() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final boolean i() {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final Parcel o() {
        int i4 = this.f9921f;
        Parcel parcel = this.f9917b;
        if (i4 == 0) {
            int iZ = J.Z(parcel, 20293);
            this.f9922g = iZ;
            J.b0(parcel, iZ);
            this.f9921f = 2;
        } else if (i4 == 1) {
            J.b0(parcel, this.f9922g);
            this.f9921f = 2;
        }
        return parcel;
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final String toString() {
        zan zanVar = this.f9919d;
        c.m(zanVar, "Cannot convert to JSON on client side.");
        Parcel parcelO = o();
        parcelO.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        String str = this.f9920e;
        c.l(str);
        Map map = (Map) zanVar.f9930b.get(str);
        c.l(map);
        p(sb, map, parcelO);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9916a);
        Parcel parcelO = o();
        if (parcelO != null) {
            int iZ2 = J.Z(parcel, 2);
            parcel.appendFrom(parcelO, 0, parcelO.dataSize());
            J.b0(parcel, iZ2);
        }
        J.T(parcel, 3, this.f9918c != 0 ? this.f9919d : null, i4);
        J.b0(parcel, iZ);
    }
}
