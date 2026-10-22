package androidx.work;

import h2.d;
import h2.j;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Data {

    /* renamed from: b, reason: collision with root package name */
    public static final Data f2768b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2769a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final LinkedHashMap f2770a = new LinkedHashMap();

        public final Data a() throws IOException {
            Data data = new Data(this.f2770a);
            b.b(data);
            return data;
        }

        public final void b(Object obj, String key) {
            Object[] objArr;
            g.f(key, "key");
            if (obj == null) {
                obj = null;
            } else {
                kotlin.jvm.internal.c cVarA = i.a(obj.getClass());
                if (!(cVarA.equals(i.a(Boolean.TYPE)) ? true : cVarA.equals(i.a(Byte.TYPE)) ? true : cVarA.equals(i.a(Integer.TYPE)) ? true : cVarA.equals(i.a(Long.TYPE)) ? true : cVarA.equals(i.a(Float.TYPE)) ? true : cVarA.equals(i.a(Double.TYPE)) ? true : cVarA.equals(i.a(String.class)) ? true : cVarA.equals(i.a(Boolean[].class)) ? true : cVarA.equals(i.a(Byte[].class)) ? true : cVarA.equals(i.a(Integer[].class)) ? true : cVarA.equals(i.a(Long[].class)) ? true : cVarA.equals(i.a(Float[].class)) ? true : cVarA.equals(i.a(Double[].class)) ? true : cVarA.equals(i.a(String[].class)))) {
                    int i10 = 0;
                    if (cVarA.equals(i.a(boolean[].class))) {
                        boolean[] zArr = (boolean[]) obj;
                        String str = d.f9266a;
                        int length = zArr.length;
                        objArr = new Boolean[length];
                        while (i10 < length) {
                            objArr[i10] = Boolean.valueOf(zArr[i10]);
                            i10++;
                        }
                    } else if (cVarA.equals(i.a(byte[].class))) {
                        byte[] bArr = (byte[]) obj;
                        String str2 = d.f9266a;
                        int length2 = bArr.length;
                        objArr = new Byte[length2];
                        while (i10 < length2) {
                            objArr[i10] = Byte.valueOf(bArr[i10]);
                            i10++;
                        }
                    } else if (cVarA.equals(i.a(int[].class))) {
                        int[] iArr = (int[]) obj;
                        String str3 = d.f9266a;
                        int length3 = iArr.length;
                        objArr = new Integer[length3];
                        while (i10 < length3) {
                            objArr[i10] = Integer.valueOf(iArr[i10]);
                            i10++;
                        }
                    } else if (cVarA.equals(i.a(long[].class))) {
                        long[] jArr = (long[]) obj;
                        String str4 = d.f9266a;
                        int length4 = jArr.length;
                        objArr = new Long[length4];
                        while (i10 < length4) {
                            objArr[i10] = Long.valueOf(jArr[i10]);
                            i10++;
                        }
                    } else if (cVarA.equals(i.a(float[].class))) {
                        float[] fArr = (float[]) obj;
                        String str5 = d.f9266a;
                        int length5 = fArr.length;
                        objArr = new Float[length5];
                        while (i10 < length5) {
                            objArr[i10] = Float.valueOf(fArr[i10]);
                            i10++;
                        }
                    } else {
                        if (!cVarA.equals(i.a(double[].class))) {
                            throw new IllegalArgumentException("Key " + key + " has invalid type " + cVarA);
                        }
                        double[] dArr = (double[]) obj;
                        String str6 = d.f9266a;
                        int length6 = dArr.length;
                        objArr = new Double[length6];
                        while (i10 < length6) {
                            objArr[i10] = Double.valueOf(dArr[i10]);
                            i10++;
                        }
                    }
                    obj = objArr;
                }
            }
            this.f2770a.put(key, obj);
        }

        public final void c(HashMap values) {
            g.f(values, "values");
            for (Map.Entry entry : values.entrySet()) {
                b(entry.getValue(), (String) entry.getKey());
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
        /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Serializable, java.lang.Double[]] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Serializable, java.lang.Float[]] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Serializable, java.lang.Long[]] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Serializable, java.lang.Integer[]] */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Serializable, java.lang.Byte[]] */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Serializable, java.lang.Boolean[]] */
        /* JADX WARN: Type inference failed for: r1v14, types: [java.io.Serializable, java.lang.String[]] */
        public static final Serializable a(DataInputStream dataInputStream, byte b10) throws IOException {
            if (b10 == 0) {
                return null;
            }
            if (b10 == 1) {
                return Boolean.valueOf(dataInputStream.readBoolean());
            }
            if (b10 == 2) {
                return Byte.valueOf(dataInputStream.readByte());
            }
            if (b10 == 3) {
                return Integer.valueOf(dataInputStream.readInt());
            }
            if (b10 == 4) {
                return Long.valueOf(dataInputStream.readLong());
            }
            if (b10 == 5) {
                return Float.valueOf(dataInputStream.readFloat());
            }
            if (b10 == 6) {
                return Double.valueOf(dataInputStream.readDouble());
            }
            if (b10 == 7) {
                return dataInputStream.readUTF();
            }
            int i10 = 0;
            if (b10 == 8) {
                int i11 = dataInputStream.readInt();
                ?? r02 = new Boolean[i11];
                while (i10 < i11) {
                    r02[i10] = Boolean.valueOf(dataInputStream.readBoolean());
                    i10++;
                }
                return r02;
            }
            if (b10 == 9) {
                int i12 = dataInputStream.readInt();
                ?? r03 = new Byte[i12];
                while (i10 < i12) {
                    r03[i10] = Byte.valueOf(dataInputStream.readByte());
                    i10++;
                }
                return r03;
            }
            if (b10 == 10) {
                int i13 = dataInputStream.readInt();
                ?? r04 = new Integer[i13];
                while (i10 < i13) {
                    r04[i10] = Integer.valueOf(dataInputStream.readInt());
                    i10++;
                }
                return r04;
            }
            if (b10 == 11) {
                int i14 = dataInputStream.readInt();
                ?? r05 = new Long[i14];
                while (i10 < i14) {
                    r05[i10] = Long.valueOf(dataInputStream.readLong());
                    i10++;
                }
                return r05;
            }
            if (b10 == 12) {
                int i15 = dataInputStream.readInt();
                ?? r06 = new Float[i15];
                while (i10 < i15) {
                    r06[i10] = Float.valueOf(dataInputStream.readFloat());
                    i10++;
                }
                return r06;
            }
            if (b10 == 13) {
                int i16 = dataInputStream.readInt();
                ?? r07 = new Double[i16];
                while (i10 < i16) {
                    r07[i10] = Double.valueOf(dataInputStream.readDouble());
                    i10++;
                }
                return r07;
            }
            if (b10 != 14) {
                throw new IllegalStateException(ai.onnxruntime.providers.a.a(b10, "Unsupported type "));
            }
            int i17 = dataInputStream.readInt();
            ?? r12 = new String[i17];
            while (i10 < i17) {
                String utf = dataInputStream.readUTF();
                if (g.b(utf, "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d")) {
                    utf = null;
                }
                r12[i10] = utf;
                i10++;
            }
            return r12;
        }

        public static byte[] b(Data data) throws IOException {
            g.f(data, "data");
            HashMap map = data.f2769a;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeShort(-21521);
                    dataOutputStream.writeShort(1);
                    dataOutputStream.writeInt(map.size());
                    for (Map.Entry entry : map.entrySet()) {
                        c(dataOutputStream, (String) entry.getKey(), entry.getValue());
                    }
                    dataOutputStream.flush();
                    if (dataOutputStream.size() > 10240) {
                        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    dataOutputStream.close();
                    g.e(byteArray, "{\n                ByteAr…          }\n            }");
                    return byteArray;
                } finally {
                }
            } catch (IOException e10) {
                j.d().c(d.f9266a, "Error in Data#toByteArray: ", e10);
                return new byte[0];
            }
        }

        public static final void c(DataOutputStream dataOutputStream, String str, Object obj) throws IOException {
            int i10;
            if (obj == null) {
                dataOutputStream.writeByte(0);
            } else if (obj instanceof Boolean) {
                dataOutputStream.writeByte(1);
                dataOutputStream.writeBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                dataOutputStream.writeByte(2);
                dataOutputStream.writeByte(((Number) obj).byteValue());
            } else if (obj instanceof Integer) {
                dataOutputStream.writeByte(3);
                dataOutputStream.writeInt(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                dataOutputStream.writeByte(4);
                dataOutputStream.writeLong(((Number) obj).longValue());
            } else if (obj instanceof Float) {
                dataOutputStream.writeByte(5);
                dataOutputStream.writeFloat(((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                dataOutputStream.writeByte(6);
                dataOutputStream.writeDouble(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                dataOutputStream.writeByte(7);
                dataOutputStream.writeUTF((String) obj);
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalArgumentException("Unsupported value type " + i.a(obj.getClass()).c());
                }
                Object[] objArr = (Object[]) obj;
                kotlin.jvm.internal.c cVarA = i.a(objArr.getClass());
                if (cVarA.equals(i.a(Boolean[].class))) {
                    i10 = 8;
                } else if (cVarA.equals(i.a(Byte[].class))) {
                    i10 = 9;
                } else if (cVarA.equals(i.a(Integer[].class))) {
                    i10 = 10;
                } else if (cVarA.equals(i.a(Long[].class))) {
                    i10 = 11;
                } else if (cVarA.equals(i.a(Float[].class))) {
                    i10 = 12;
                } else if (cVarA.equals(i.a(Double[].class))) {
                    i10 = 13;
                } else {
                    if (!cVarA.equals(i.a(String[].class))) {
                        throw new IllegalArgumentException("Unsupported value type " + i.a(objArr.getClass()).d());
                    }
                    i10 = 14;
                }
                dataOutputStream.writeByte(i10);
                dataOutputStream.writeInt(objArr.length);
                for (Object obj2 : objArr) {
                    if (i10 == 8) {
                        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
                        dataOutputStream.writeBoolean(bool != null ? bool.booleanValue() : false);
                    } else if (i10 == 9) {
                        Byte b10 = obj2 instanceof Byte ? (Byte) obj2 : null;
                        dataOutputStream.writeByte(b10 != null ? b10.byteValue() : (byte) 0);
                    } else if (i10 == 10) {
                        Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
                        dataOutputStream.writeInt(num != null ? num.intValue() : 0);
                    } else if (i10 == 11) {
                        Long l10 = obj2 instanceof Long ? (Long) obj2 : null;
                        dataOutputStream.writeLong(l10 != null ? l10.longValue() : 0L);
                    } else if (i10 == 12) {
                        Float f8 = obj2 instanceof Float ? (Float) obj2 : null;
                        dataOutputStream.writeFloat(f8 != null ? f8.floatValue() : 0.0f);
                    } else if (i10 == 13) {
                        Double d8 = obj2 instanceof Double ? (Double) obj2 : null;
                        dataOutputStream.writeDouble(d8 != null ? d8.doubleValue() : 0.0d);
                    } else if (i10 == 14) {
                        String str2 = obj2 instanceof String ? (String) obj2 : null;
                        if (str2 == null) {
                            str2 = "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d";
                        }
                        dataOutputStream.writeUTF(str2);
                    }
                }
            }
            dataOutputStream.writeUTF(str);
        }
    }

    static {
        Data data = new Data(new LinkedHashMap());
        b.b(data);
        f2768b = data;
    }

    public Data(Data other) {
        g.f(other, "other");
        this.f2769a = new HashMap(other.f2769a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.work.Data a(byte[] r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.a(byte[]):androidx.work.Data");
    }

    public final boolean b(String str) {
        Object obj = this.f2769a.get(str);
        return obj != null && String.class.isAssignableFrom(obj.getClass());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r7 != r8) goto L5
            goto L66
        L5:
            r1 = 0
            if (r8 == 0) goto L67
            java.lang.Class<androidx.work.Data> r2 = androidx.work.Data.class
            java.lang.Class r3 = r8.getClass()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L15
            goto L67
        L15:
            androidx.work.Data r8 = (androidx.work.Data) r8
            java.util.HashMap r8 = r8.f2769a
            java.util.HashMap r7 = r7.f2769a
            java.util.Set r2 = r7.keySet()
            java.util.Set r3 = r8.keySet()
            boolean r3 = kotlin.jvm.internal.g.b(r2, r3)
            if (r3 != 0) goto L2a
            goto L67
        L2a:
            java.util.Iterator r2 = r2.iterator()
        L2e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L66
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r7.get(r3)
            java.lang.Object r3 = r8.get(r3)
            if (r4 == 0) goto L5e
            if (r3 != 0) goto L47
            goto L5e
        L47:
            boolean r5 = r4 instanceof java.lang.Object[]
            if (r5 == 0) goto L59
            r5 = r4
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            boolean r6 = r3 instanceof java.lang.Object[]
            if (r6 == 0) goto L59
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            boolean r3 = androidx.datastore.preferences.protobuf.b1.m(r5, r3)
            goto L63
        L59:
            boolean r3 = r4.equals(r3)
            goto L63
        L5e:
            if (r4 != r3) goto L62
            r3 = r0
            goto L63
        L62:
            r3 = r1
        L63:
            if (r3 != 0) goto L2e
            goto L67
        L66:
            return r0
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iHashCode = 0;
        for (Map.Entry entry : this.f2769a.entrySet()) {
            Object value = entry.getValue();
            iHashCode += value instanceof Object[] ? Objects.hashCode(entry.getKey()) ^ Arrays.deepHashCode((Object[]) value) : entry.hashCode();
        }
        return iHashCode * 31;
    }

    public final String toString() {
        String str = "Data {" + kotlin.collections.a.z0(this.f2769a.entrySet(), null, null, null, new l<Map.Entry<? extends String, ? extends Object>, CharSequence>() { // from class: androidx.work.Data$toString$1$content$1
            @Override // zb.l
            public final CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
                Map.Entry<? extends String, ? extends Object> entry2 = entry;
                g.f(entry2, "<name for destructuring parameter 0>");
                String key = entry2.getKey();
                Object value = entry2.getValue();
                StringBuilder sbP = a0.a.p(key, " : ");
                if (value instanceof Object[]) {
                    value = Arrays.toString((Object[]) value);
                    g.e(value, "toString(this)");
                }
                sbP.append(value);
                return sbP.toString();
            }
        }, 31) + "}";
        g.e(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }

    public Data(LinkedHashMap values) {
        g.f(values, "values");
        this.f2769a = new HashMap(values);
    }
}
