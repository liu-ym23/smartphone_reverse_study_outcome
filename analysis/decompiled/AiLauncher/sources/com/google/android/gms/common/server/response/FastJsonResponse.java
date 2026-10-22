package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.common.internal.C1668i;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p2.C5047a;
import s2.h;
import s2.i;

/* loaded from: classes2.dex */
public abstract class FastJsonResponse {

    public interface a<I, O> {
        int zaa();

        int zab();

        Object zac(Object obj);

        Object zad(Object obj);
    }

    public static final Object zaD(Field field, Object obj) {
        return field.zak != null ? field.zaf(obj) : obj;
    }

    private final void zaE(Field field, Object obj) {
        int i10 = field.zac;
        Object objZae = field.zae(obj);
        String str = field.zae;
        switch (i10) {
            case 0:
                if (objZae != null) {
                    setIntegerInternal(field, str, ((Integer) objZae).intValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 1:
                zaf(field, str, (BigInteger) objZae);
                return;
            case 2:
                if (objZae != null) {
                    setLongInternal(field, str, ((Long) objZae).longValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 3:
            default:
                throw new IllegalStateException("Unsupported type for conversion: " + i10);
            case 4:
                if (objZae != null) {
                    zan(field, str, ((Double) objZae).doubleValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 5:
                zab(field, str, (BigDecimal) objZae);
                return;
            case 6:
                if (objZae != null) {
                    setBooleanInternal(field, str, ((Boolean) objZae).booleanValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 7:
                setStringInternal(field, str, (String) objZae);
                return;
            case 8:
            case 9:
                if (objZae != null) {
                    setDecodedBytesInternal(field, str, (byte[]) objZae);
                    return;
                } else {
                    zaG(str);
                    return;
                }
        }
    }

    private static final void zaF(StringBuilder sb2, Field field, Object obj) {
        int i10 = field.zaa;
        if (i10 == 11) {
            Class cls = field.zag;
            C1669j.k(cls);
            sb2.append(((FastJsonResponse) cls.cast(obj)).toString());
        } else {
            if (i10 != 7) {
                sb2.append(obj);
                return;
            }
            sb2.append("\"");
            sb2.append(h.a((String) obj));
            sb2.append("\"");
        }
    }

    private static final void zaG(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            Log.e("FastJsonResponse", "Output field (" + str + ") has a null value, but expected a primitive");
        }
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field field, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field field, String str, T t10) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public abstract Map<String, Field<?, ?>> getFieldMappings();

    public Object getFieldValue(Field field) {
        String str = field.zae;
        if (field.zag == null) {
            return getValueObject(str);
        }
        C1669j.p(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", field.zae);
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), null).invoke(this, null);
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    public abstract Object getValueObject(String str);

    public boolean isFieldSet(Field field) {
        if (field.zac != 11) {
            return isPrimitiveFieldSet(field.zae);
        }
        if (field.zad) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public abstract boolean isPrimitiveFieldSet(String str);

    public void setBooleanInternal(Field<?, ?> field, String str, boolean z10) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    public void setDecodedBytesInternal(Field<?, ?> field, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    public void setIntegerInternal(Field<?, ?> field, String str, int i10) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    public void setLongInternal(Field<?, ?> field, String str, long j10) {
        throw new UnsupportedOperationException("Long not supported");
    }

    public void setStringInternal(Field<?, ?> field, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    public void setStringMapInternal(Field<?, ?> field, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    public void setStringsInternal(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb2 = new StringBuilder(100);
        for (String str : fieldMappings.keySet()) {
            Field<?, ?> field = fieldMappings.get(str);
            if (isFieldSet(field)) {
                Object objZaD = zaD(field, getFieldValue(field));
                if (sb2.length() == 0) {
                    sb2.append(Const.STR_MART_JSON_BEGIN);
                } else {
                    sb2.append(Const.STR_MART_COMMA);
                }
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                if (objZaD != null) {
                    switch (field.zac) {
                        case 8:
                            sb2.append("\"");
                            sb2.append(s2.b.a((byte[]) objZaD));
                            sb2.append("\"");
                            break;
                        case 9:
                            sb2.append("\"");
                            sb2.append(s2.b.b((byte[]) objZaD));
                            sb2.append("\"");
                            break;
                        case 10:
                            i.a(sb2, (HashMap) objZaD);
                            break;
                        default:
                            if (field.zab) {
                                ArrayList arrayList = (ArrayList) objZaD;
                                sb2.append("[");
                                int size = arrayList.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    if (i10 > 0) {
                                        sb2.append(Const.STR_MART_COMMA);
                                    }
                                    Object obj = arrayList.get(i10);
                                    if (obj != null) {
                                        zaF(sb2, field, obj);
                                    }
                                }
                                sb2.append("]");
                                break;
                            } else {
                                zaF(sb2, field, objZaD);
                                break;
                            }
                    }
                } else {
                    sb2.append("null");
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.append("}");
        } else {
            sb2.append("{}");
        }
        return sb2.toString();
    }

    public final void zaA(Field field, String str) {
        if (field.zak != null) {
            zaE(field, str);
        } else {
            setStringInternal(field, field.zae, str);
        }
    }

    public final void zaB(Field field, Map map) {
        if (field.zak != null) {
            zaE(field, map);
        } else {
            setStringMapInternal(field, field.zae, map);
        }
    }

    public final void zaC(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            setStringsInternal(field, field.zae, arrayList);
        }
    }

    public final void zaa(Field field, BigDecimal bigDecimal) {
        if (field.zak != null) {
            zaE(field, bigDecimal);
        } else {
            zab(field, field.zae, bigDecimal);
        }
    }

    public void zab(Field field, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final void zac(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zad(field, field.zae, arrayList);
        }
    }

    public void zad(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final void zae(Field field, BigInteger bigInteger) {
        if (field.zak != null) {
            zaE(field, bigInteger);
        } else {
            zaf(field, field.zae, bigInteger);
        }
    }

    public void zaf(Field field, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final void zag(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zah(field, field.zae, arrayList);
        }
    }

    public void zah(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final void zai(Field field, boolean z10) {
        if (field.zak != null) {
            zaE(field, Boolean.valueOf(z10));
        } else {
            setBooleanInternal(field, field.zae, z10);
        }
    }

    public final void zaj(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zak(field, field.zae, arrayList);
        }
    }

    public void zak(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zal(Field field, byte[] bArr) {
        if (field.zak != null) {
            zaE(field, bArr);
        } else {
            setDecodedBytesInternal(field, field.zae, bArr);
        }
    }

    public final void zam(Field field, double d10) {
        if (field.zak != null) {
            zaE(field, Double.valueOf(d10));
        } else {
            zan(field, field.zae, d10);
        }
    }

    public void zan(Field field, String str, double d10) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final void zao(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zap(field, field.zae, arrayList);
        }
    }

    public void zap(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final void zaq(Field field, float f10) {
        if (field.zak != null) {
            zaE(field, Float.valueOf(f10));
        } else {
            zar(field, field.zae, f10);
        }
    }

    public void zar(Field field, String str, float f10) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final void zas(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zat(field, field.zae, arrayList);
        }
    }

    public void zat(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final void zau(Field field, int i10) {
        if (field.zak != null) {
            zaE(field, Integer.valueOf(i10));
        } else {
            setIntegerInternal(field, field.zae, i10);
        }
    }

    public final void zav(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zaw(field, field.zae, arrayList);
        }
    }

    public void zaw(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final void zax(Field field, long j10) {
        if (field.zak != null) {
            zaE(field, Long.valueOf(j10));
        } else {
            setLongInternal(field, field.zae, j10);
        }
    }

    public final void zay(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zaz(field, field.zae, arrayList);
        }
    }

    public void zaz(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final com.google.android.gms.common.server.response.a CREATOR = new com.google.android.gms.common.server.response.a();
        protected final int zaa;
        protected final boolean zab;
        protected final int zac;
        protected final boolean zad;
        protected final String zae;
        protected final int zaf;
        protected final Class zag;
        protected final String zah;
        private final int zai;
        private zan zaj;
        private final a zak;

        public Field(int i10, int i11, boolean z10, int i12, boolean z11, String str, int i13, String str2, zaa zaaVar) {
            this.zai = i10;
            this.zaa = i11;
            this.zab = z10;
            this.zac = i12;
            this.zad = z11;
            this.zae = str;
            this.zaf = i13;
            if (str2 == null) {
                this.zag = null;
                this.zah = null;
            } else {
                this.zag = SafeParcelResponse.class;
                this.zah = str2;
            }
            if (zaaVar == null) {
                this.zak = null;
            } else {
                this.zak = zaaVar.zab();
            }
        }

        public static Field<byte[], byte[]> forBase64(String str, int i10) {
            return new Field<>(8, false, 8, false, str, i10, null, null);
        }

        public static Field<Boolean, Boolean> forBoolean(String str, int i10) {
            return new Field<>(6, false, 6, false, str, i10, null, null);
        }

        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String str, int i10, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i10, cls, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String str, int i10, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i10, cls, null);
        }

        public static Field<Double, Double> forDouble(String str, int i10) {
            return new Field<>(4, false, 4, false, str, i10, null, null);
        }

        public static Field<Float, Float> forFloat(String str, int i10) {
            return new Field<>(3, false, 3, false, str, i10, null, null);
        }

        public static Field<Integer, Integer> forInteger(String str, int i10) {
            return new Field<>(0, false, 0, false, str, i10, null, null);
        }

        public static Field<Long, Long> forLong(String str, int i10) {
            return new Field<>(2, false, 2, false, str, i10, null, null);
        }

        public static Field<String, String> forString(String str, int i10) {
            return new Field<>(7, false, 7, false, str, i10, null, null);
        }

        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(String str, int i10) {
            return new Field<>(10, false, 10, false, str, i10, null, null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> forStrings(String str, int i10) {
            return new Field<>(7, true, 7, true, str, i10, null, null);
        }

        public static Field withConverter(String str, int i10, a<?, ?> aVar, boolean z10) {
            aVar.zaa();
            aVar.zab();
            return new Field(7, z10, 0, false, str, i10, null, aVar);
        }

        public int getSafeParcelableFieldId() {
            return this.zaf;
        }

        public final String toString() {
            C1668i.a aVarA = C1668i.c(this).a("versionCode", Integer.valueOf(this.zai)).a("typeIn", Integer.valueOf(this.zaa)).a("typeInArray", Boolean.valueOf(this.zab)).a("typeOut", Integer.valueOf(this.zac)).a("typeOutArray", Boolean.valueOf(this.zad)).a("outputFieldName", this.zae).a("safeParcelFieldId", Integer.valueOf(this.zaf)).a("concreteTypeName", zag());
            Class cls = this.zag;
            if (cls != null) {
                aVarA.a("concreteType.class", cls.getCanonicalName());
            }
            a aVar = this.zak;
            if (aVar != null) {
                aVarA.a("converterName", aVar.getClass().getCanonicalName());
            }
            return aVarA.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            int i11 = this.zai;
            int iA = C5047a.a(parcel);
            C5047a.p(parcel, 1, i11);
            C5047a.p(parcel, 2, this.zaa);
            C5047a.g(parcel, 3, this.zab);
            C5047a.p(parcel, 4, this.zac);
            C5047a.g(parcel, 5, this.zad);
            C5047a.x(parcel, 6, this.zae, false);
            C5047a.p(parcel, 7, getSafeParcelableFieldId());
            C5047a.x(parcel, 8, zag(), false);
            C5047a.w(parcel, 9, zaa(), i10, false);
            C5047a.b(parcel, iA);
        }

        public final zaa zaa() {
            a aVar = this.zak;
            if (aVar == null) {
                return null;
            }
            return zaa.zaa(aVar);
        }

        public final Field zab() {
            return new Field(this.zai, this.zaa, this.zab, this.zac, this.zad, this.zae, this.zaf, this.zah, zaa());
        }

        public final FastJsonResponse zad() throws IllegalAccessException, InstantiationException {
            C1669j.k(this.zag);
            Class cls = this.zag;
            if (cls != SafeParcelResponse.class) {
                return (FastJsonResponse) cls.newInstance();
            }
            C1669j.k(this.zah);
            C1669j.l(this.zaj, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
            return new SafeParcelResponse(this.zaj, this.zah);
        }

        public final Object zae(Object obj) {
            C1669j.k(this.zak);
            return C1669j.k(this.zak.zac(obj));
        }

        public final Object zaf(Object obj) {
            C1669j.k(this.zak);
            return this.zak.zad(obj);
        }

        public final String zag() {
            String str = this.zah;
            if (str == null) {
                return null;
            }
            return str;
        }

        public final Map zah() {
            C1669j.k(this.zah);
            C1669j.k(this.zaj);
            return (Map) C1669j.k(this.zaj.zab(this.zah));
        }

        public final void zai(zan zanVar) {
            this.zaj = zanVar;
        }

        public final boolean zaj() {
            return this.zak != null;
        }

        public Field(int i10, boolean z10, int i11, boolean z11, String str, int i12, Class cls, a aVar) {
            this.zai = 1;
            this.zaa = i10;
            this.zab = z10;
            this.zac = i11;
            this.zad = z11;
            this.zae = str;
            this.zaf = i12;
            this.zag = cls;
            if (cls == null) {
                this.zah = null;
            } else {
                this.zah = cls.getCanonicalName();
            }
            this.zak = aVar;
        }
    }
}
