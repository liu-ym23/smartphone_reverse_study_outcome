package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p2.C5047a;
import s2.C5438a;
import s2.h;
import s2.i;

/* loaded from: classes2.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new e();
    private final int zaa;
    private final Parcel zab;
    private final int zac;
    private final zan zad;
    private final String zae;
    private int zaf;
    private int zag;

    public SafeParcelResponse(int i10, Parcel parcel, zan zanVar) {
        this.zaa = i10;
        this.zab = (Parcel) C1669j.k(parcel);
        this.zac = 2;
        this.zad = zanVar;
        this.zae = zanVar == null ? null : zanVar.zaa();
        this.zaf = 2;
    }

    public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T t10) {
        String str = (String) C1669j.k(t10.getClass().getCanonicalName());
        zan zanVar = new zan(t10.getClass());
        zaF(zanVar, t10);
        zanVar.zac();
        zanVar.zad();
        return new SafeParcelResponse(t10, zanVar, str);
    }

    private static void zaF(zan zanVar, FastJsonResponse fastJsonResponse) {
        Class<?> cls = fastJsonResponse.getClass();
        if (zanVar.zaf(cls)) {
            return;
        }
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        zanVar.zae(cls, fieldMappings);
        Iterator<String> it = fieldMappings.keySet().iterator();
        while (it.hasNext()) {
            FastJsonResponse.Field<?, ?> field = fieldMappings.get(it.next());
            Class cls2 = field.zag;
            if (cls2 != null) {
                try {
                    zaF(zanVar, (FastJsonResponse) cls2.newInstance());
                } catch (IllegalAccessException e10) {
                    throw new IllegalStateException("Could not access object of type ".concat(String.valueOf(((Class) C1669j.k(field.zag)).getCanonicalName())), e10);
                } catch (InstantiationException e11) {
                    throw new IllegalStateException("Could not instantiate an object of type ".concat(String.valueOf(((Class) C1669j.k(field.zag)).getCanonicalName())), e11);
                }
            }
        }
    }

    private final void zaG(FastJsonResponse.Field field) {
        if (field.zaf == -1) {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
        Parcel parcel = this.zab;
        if (parcel == null) {
            throw new IllegalStateException("Internal Parcel object is null.");
        }
        int i10 = this.zaf;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
            }
        } else {
            this.zag = C5047a.a(parcel);
            this.zaf = 1;
        }
    }

    private final void zaH(StringBuilder sb2, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry.getValue()).getSafeParcelableFieldId(), entry);
        }
        sb2.append('{');
        int iF = SafeParcelReader.F(parcel);
        boolean z10 = false;
        while (parcel.dataPosition() < iF) {
            int iY = SafeParcelReader.y(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.u(iY));
            if (entry2 != null) {
                if (z10) {
                    sb2.append(Const.STR_MART_COMMA);
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                if (field.zaj()) {
                    int i10 = field.zac;
                    switch (i10) {
                        case 0:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, Integer.valueOf(SafeParcelReader.A(parcel, iY))));
                            break;
                        case 1:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.c(parcel, iY)));
                            break;
                        case 2:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, Long.valueOf(SafeParcelReader.B(parcel, iY))));
                            break;
                        case 3:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, Float.valueOf(SafeParcelReader.x(parcel, iY))));
                            break;
                        case 4:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, Double.valueOf(SafeParcelReader.w(parcel, iY))));
                            break;
                        case 5:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.a(parcel, iY)));
                            break;
                        case 6:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, Boolean.valueOf(SafeParcelReader.v(parcel, iY))));
                            break;
                        case 7:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.o(parcel, iY)));
                            break;
                        case 8:
                        case 9:
                            zaJ(sb2, field, FastJsonResponse.zaD(field, SafeParcelReader.g(parcel, iY)));
                            break;
                        case 10:
                            Bundle bundleF = SafeParcelReader.f(parcel, iY);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleF.keySet()) {
                                map2.put(str2, (String) C1669j.k(bundleF.getString(str2)));
                            }
                            zaJ(sb2, field, FastJsonResponse.zaD(field, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            throw new IllegalArgumentException("Unknown field out type = " + i10);
                    }
                } else if (field.zad) {
                    sb2.append("[");
                    switch (field.zac) {
                        case 0:
                            C5438a.e(sb2, SafeParcelReader.j(parcel, iY));
                            break;
                        case 1:
                            C5438a.g(sb2, SafeParcelReader.d(parcel, iY));
                            break;
                        case 2:
                            C5438a.f(sb2, SafeParcelReader.k(parcel, iY));
                            break;
                        case 3:
                            C5438a.d(sb2, SafeParcelReader.i(parcel, iY));
                            break;
                        case 4:
                            C5438a.c(sb2, SafeParcelReader.h(parcel, iY));
                            break;
                        case 5:
                            C5438a.g(sb2, SafeParcelReader.b(parcel, iY));
                            break;
                        case 6:
                            C5438a.h(sb2, SafeParcelReader.e(parcel, iY));
                            break;
                        case 7:
                            C5438a.i(sb2, SafeParcelReader.p(parcel, iY));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] parcelArrM = SafeParcelReader.m(parcel, iY);
                            int length = parcelArrM.length;
                            for (int i11 = 0; i11 < length; i11++) {
                                if (i11 > 0) {
                                    sb2.append(Const.STR_MART_COMMA);
                                }
                                parcelArrM[i11].setDataPosition(0);
                                zaH(sb2, field.zah(), parcelArrM[i11]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb2.append("]");
                } else {
                    switch (field.zac) {
                        case 0:
                            sb2.append(SafeParcelReader.A(parcel, iY));
                            break;
                        case 1:
                            sb2.append(SafeParcelReader.c(parcel, iY));
                            break;
                        case 2:
                            sb2.append(SafeParcelReader.B(parcel, iY));
                            break;
                        case 3:
                            sb2.append(SafeParcelReader.x(parcel, iY));
                            break;
                        case 4:
                            sb2.append(SafeParcelReader.w(parcel, iY));
                            break;
                        case 5:
                            sb2.append(SafeParcelReader.a(parcel, iY));
                            break;
                        case 6:
                            sb2.append(SafeParcelReader.v(parcel, iY));
                            break;
                        case 7:
                            String strO = SafeParcelReader.o(parcel, iY);
                            sb2.append("\"");
                            sb2.append(h.a(strO));
                            sb2.append("\"");
                            break;
                        case 8:
                            byte[] bArrG = SafeParcelReader.g(parcel, iY);
                            sb2.append("\"");
                            sb2.append(s2.b.a(bArrG));
                            sb2.append("\"");
                            break;
                        case 9:
                            byte[] bArrG2 = SafeParcelReader.g(parcel, iY);
                            sb2.append("\"");
                            sb2.append(s2.b.b(bArrG2));
                            sb2.append("\"");
                            break;
                        case 10:
                            Bundle bundleF2 = SafeParcelReader.f(parcel, iY);
                            Set<String> setKeySet = bundleF2.keySet();
                            sb2.append(Const.STR_MART_JSON_BEGIN);
                            boolean z11 = true;
                            for (String str3 : setKeySet) {
                                if (!z11) {
                                    sb2.append(Const.STR_MART_COMMA);
                                }
                                sb2.append("\"");
                                sb2.append(str3);
                                sb2.append("\":\"");
                                sb2.append(h.a(bundleF2.getString(str3)));
                                sb2.append("\"");
                                z11 = false;
                            }
                            sb2.append("}");
                            break;
                        case 11:
                            Parcel parcelL = SafeParcelReader.l(parcel, iY);
                            parcelL.setDataPosition(0);
                            zaH(sb2, field.zah(), parcelL);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z10 = true;
            }
        }
        if (parcel.dataPosition() == iF) {
            sb2.append('}');
            return;
        }
        throw new SafeParcelReader.ParseException("Overread allowed size end=" + iF, parcel);
    }

    private static final void zaI(StringBuilder sb2, int i10, Object obj) {
        switch (i10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb2.append(obj);
                return;
            case 7:
                sb2.append("\"");
                sb2.append(h.a(C1669j.k(obj).toString()));
                sb2.append("\"");
                return;
            case 8:
                sb2.append("\"");
                sb2.append(s2.b.a((byte[]) obj));
                sb2.append("\"");
                return;
            case 9:
                sb2.append("\"");
                sb2.append(s2.b.b((byte[]) obj));
                sb2.append("\"");
                return;
            case 10:
                i.a(sb2, (HashMap) C1669j.k(obj));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i10);
        }
    }

    private static final void zaJ(StringBuilder sb2, FastJsonResponse.Field field, Object obj) {
        if (!field.zab) {
            zaI(sb2, field.zaa, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb2.append("[");
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 != 0) {
                sb2.append(Const.STR_MART_COMMA);
            }
            zaI(sb2, field.zaa, arrayList.get(i10));
        }
        sb2.append("]");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field field, String str, ArrayList<T> arrayList) {
        zaG(field);
        ArrayList arrayList2 = new ArrayList();
        ((ArrayList) C1669j.k(arrayList)).size();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList2.add(((SafeParcelResponse) arrayList.get(i10)).zaE());
        }
        C5047a.v(this.zab, field.getSafeParcelableFieldId(), arrayList2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field field, String str, T t10) {
        zaG(field);
        C5047a.u(this.zab, field.getSafeParcelableFieldId(), ((SafeParcelResponse) t10).zaE(), true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zan zanVar = this.zad;
        if (zanVar == null) {
            return null;
        }
        return zanVar.zab((String) C1669j.k(this.zae));
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setBooleanInternal(FastJsonResponse.Field<?, ?> field, String str, boolean z10) {
        zaG(field);
        C5047a.g(this.zab, field.getSafeParcelableFieldId(), z10);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        zaG(field);
        C5047a.j(this.zab, field.getSafeParcelableFieldId(), bArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i10) {
        zaG(field);
        C5047a.p(this.zab, field.getSafeParcelableFieldId(), i10);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setLongInternal(FastJsonResponse.Field<?, ?> field, String str, long j10) {
        zaG(field);
        C5047a.r(this.zab, field.getSafeParcelableFieldId(), j10);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        zaG(field);
        C5047a.x(this.zab, field.getSafeParcelableFieldId(), str2, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringMapInternal(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        zaG(field);
        Bundle bundle = new Bundle();
        for (String str2 : ((Map) C1669j.k(map)).keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        C5047a.i(this.zab, field.getSafeParcelableFieldId(), bundle, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        zaG(field);
        int size = ((ArrayList) C1669j.k(arrayList)).size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = arrayList.get(i10);
        }
        C5047a.y(this.zab, field.getSafeParcelableFieldId(), strArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final String toString() {
        C1669j.l(this.zad, "Cannot convert to JSON on client side.");
        Parcel parcelZaE = zaE();
        parcelZaE.setDataPosition(0);
        StringBuilder sb2 = new StringBuilder(100);
        zaH(sb2, (Map) C1669j.k(this.zad.zab((String) C1669j.k(this.zae))), parcelZaE);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int i11 = this.zaa;
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, i11);
        C5047a.u(parcel, 2, zaE(), false);
        int i12 = this.zac;
        C5047a.w(parcel, 3, i12 != 0 ? i12 != 1 ? this.zad : this.zad : null, i10, false);
        C5047a.b(parcel, iA);
    }

    public final Parcel zaE() {
        int i10 = this.zaf;
        if (i10 == 0) {
            int iA = C5047a.a(this.zab);
            this.zag = iA;
            C5047a.b(this.zab, iA);
            this.zaf = 2;
        } else if (i10 == 1) {
            C5047a.b(this.zab, this.zag);
            this.zaf = 2;
        }
        return this.zab;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zab(FastJsonResponse.Field field, String str, BigDecimal bigDecimal) {
        zaG(field);
        C5047a.c(this.zab, field.getSafeParcelableFieldId(), bigDecimal, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zad(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) C1669j.k(arrayList)).size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i10 = 0; i10 < size; i10++) {
            bigDecimalArr[i10] = (BigDecimal) arrayList.get(i10);
        }
        C5047a.d(this.zab, field.getSafeParcelableFieldId(), bigDecimalArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaf(FastJsonResponse.Field field, String str, BigInteger bigInteger) {
        zaG(field);
        C5047a.e(this.zab, field.getSafeParcelableFieldId(), bigInteger, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zah(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) C1669j.k(arrayList)).size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i10 = 0; i10 < size; i10++) {
            bigIntegerArr[i10] = (BigInteger) arrayList.get(i10);
        }
        C5047a.f(this.zab, field.getSafeParcelableFieldId(), bigIntegerArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zak(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) C1669j.k(arrayList)).size();
        boolean[] zArr = new boolean[size];
        for (int i10 = 0; i10 < size; i10++) {
            zArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue();
        }
        C5047a.h(this.zab, field.getSafeParcelableFieldId(), zArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zan(FastJsonResponse.Field field, String str, double d10) {
        zaG(field);
        C5047a.k(this.zab, field.getSafeParcelableFieldId(), d10);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zap(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) C1669j.k(arrayList)).size();
        double[] dArr = new double[size];
        for (int i10 = 0; i10 < size; i10++) {
            dArr[i10] = ((Double) arrayList.get(i10)).doubleValue();
        }
        C5047a.l(this.zab, field.getSafeParcelableFieldId(), dArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zar(FastJsonResponse.Field field, String str, float f10) {
        zaG(field);
        C5047a.m(this.zab, field.getSafeParcelableFieldId(), f10);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zat(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) C1669j.k(arrayList)).size();
        float[] fArr = new float[size];
        for (int i10 = 0; i10 < size; i10++) {
            fArr[i10] = ((Float) arrayList.get(i10)).floatValue();
        }
        C5047a.n(this.zab, field.getSafeParcelableFieldId(), fArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaw(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) C1669j.k(arrayList)).size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = ((Integer) arrayList.get(i10)).intValue();
        }
        C5047a.q(this.zab, field.getSafeParcelableFieldId(), iArr, true);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final void zaz(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        int size = ((ArrayList) C1669j.k(arrayList)).size();
        long[] jArr = new long[size];
        for (int i10 = 0; i10 < size; i10++) {
            jArr[i10] = ((Long) arrayList.get(i10)).longValue();
        }
        C5047a.s(this.zab, field.getSafeParcelableFieldId(), jArr, true);
    }

    private SafeParcelResponse(SafeParcelable safeParcelable, zan zanVar, String str) {
        this.zaa = 1;
        Parcel parcelObtain = Parcel.obtain();
        this.zab = parcelObtain;
        safeParcelable.writeToParcel(parcelObtain, 0);
        this.zac = 1;
        this.zad = (zan) C1669j.k(zanVar);
        this.zae = (String) C1669j.k(str);
        this.zaf = 2;
    }

    public SafeParcelResponse(zan zanVar, String str) {
        this.zaa = 1;
        this.zab = Parcel.obtain();
        this.zac = 0;
        this.zad = (zan) C1669j.k(zanVar);
        this.zae = (String) C1669j.k(str);
        this.zaf = 0;
    }
}
