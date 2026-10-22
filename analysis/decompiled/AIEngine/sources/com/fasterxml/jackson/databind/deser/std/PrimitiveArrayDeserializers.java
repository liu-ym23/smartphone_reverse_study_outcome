package com.fasterxml.jackson.databind.deser.std;

import c3.a;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.deser.impl.NullsFailProvider;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import e3.c;
import e3.i;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import q3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class PrimitiveArrayDeserializers<T> extends StdDeserializer<T> implements c {

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f4044d;

    /* renamed from: e, reason: collision with root package name */
    public transient Object f4045e;
    public final i h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class BooleanDeser extends PrimitiveArrayDeserializers<boolean[]> {
        public BooleanDeser() {
            super(boolean[].class);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
            boolean zL;
            int i10;
            if (!jsonParser.l1()) {
                return m0(jsonParser, deserializationContext);
            }
            b bVarU = deserializationContext.u();
            if (bVarU.f11547a == null) {
                bVarU.f11547a = new b.a();
            }
            b.a aVar = bVarU.f11547a;
            boolean[] zArrD = aVar.d();
            int i11 = 0;
            while (true) {
                try {
                    JsonToken jsonTokenQ1 = jsonParser.q1();
                    if (jsonTokenQ1 == JsonToken.END_ARRAY) {
                        return (boolean[]) aVar.c(i11, zArrD);
                    }
                    try {
                        if (jsonTokenQ1 == JsonToken.VALUE_TRUE) {
                            zL = true;
                        } else {
                            if (jsonTokenQ1 != JsonToken.VALUE_FALSE) {
                                if (jsonTokenQ1 == JsonToken.VALUE_NULL) {
                                    i iVar = this.h;
                                    if (iVar != null) {
                                        iVar.a(deserializationContext);
                                    } else {
                                        Z(deserializationContext);
                                    }
                                } else {
                                    zL = L(jsonParser, deserializationContext);
                                }
                            }
                            zL = false;
                        }
                        zArrD[i11] = zL;
                        i11 = i10;
                    } catch (Exception e10) {
                        e = e10;
                        i11 = i10;
                        throw JsonMappingException.h(e, zArrD, aVar.f11569d + i11);
                    }
                    if (i11 >= zArrD.length) {
                        boolean[] zArr = (boolean[]) aVar.b(i11, zArrD);
                        i11 = 0;
                        zArrD = zArr;
                    }
                    i10 = i11 + 1;
                } catch (Exception e11) {
                    e = e11;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final boolean[] j0(boolean[] zArr, boolean[] zArr2) {
            boolean[] zArr3 = zArr;
            boolean[] zArr4 = zArr2;
            int length = zArr3.length;
            int length2 = zArr4.length;
            boolean[] zArrCopyOf = Arrays.copyOf(zArr3, length + length2);
            System.arraycopy(zArr4, 0, zArrCopyOf, length, length2);
            return zArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final boolean[] k0() {
            return new boolean[0];
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final boolean[] n0(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new boolean[]{L(jsonParser, deserializationContext)};
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final PrimitiveArrayDeserializers<?> o0(i iVar, Boolean bool) {
            return new BooleanDeser(this, iVar, bool);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class ByteDeser extends PrimitiveArrayDeserializers<byte[]> {
        public ByteDeser() {
            super(byte[].class);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
            byte bC0;
            int i10;
            JsonToken jsonTokenK = jsonParser.K();
            if (jsonTokenK == JsonToken.VALUE_STRING) {
                try {
                    return jsonParser.S(deserializationContext.f3663c.f3828b.f3795k);
                } catch (JsonParseException e10) {
                    String strB = e10.b();
                    if (strB.contains("base64")) {
                        deserializationContext.G(byte[].class, jsonParser.V0(), strB, new Object[0]);
                        throw null;
                    }
                }
            }
            if (jsonTokenK == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object objK0 = jsonParser.K0();
                if (objK0 == null) {
                    return null;
                }
                if (objK0 instanceof byte[]) {
                    return (byte[]) objK0;
                }
            }
            if (!jsonParser.l1()) {
                return this.m0(jsonParser, deserializationContext);
            }
            b bVarU = deserializationContext.u();
            if (bVarU.f11548b == null) {
                bVarU.f11548b = new b.C0128b();
            }
            b.C0128b c0128b = bVarU.f11548b;
            byte[] bArrD = c0128b.d();
            int i11 = 0;
            while (true) {
                try {
                    JsonToken jsonTokenQ1 = jsonParser.q1();
                    if (jsonTokenQ1 == JsonToken.END_ARRAY) {
                        return (byte[]) c0128b.c(i11, bArrD);
                    }
                    try {
                        if (jsonTokenQ1 == JsonToken.VALUE_NUMBER_INT) {
                            bC0 = jsonParser.c0();
                        } else if (jsonTokenQ1 == JsonToken.VALUE_NULL) {
                            i iVar = this.h;
                            if (iVar != null) {
                                iVar.a(deserializationContext);
                            } else {
                                this.Z(deserializationContext);
                                bC0 = 0;
                            }
                        } else {
                            bC0 = this.M(jsonParser, deserializationContext);
                        }
                        bArrD[i11] = bC0;
                        i11 = i10;
                    } catch (Exception e11) {
                        e = e11;
                        i11 = i10;
                        throw JsonMappingException.h(e, bArrD, c0128b.f11569d + i11);
                    }
                    if (i11 >= bArrD.length) {
                        byte[] bArr = (byte[]) c0128b.b(i11, bArrD);
                        i11 = 0;
                        bArrD = bArr;
                    }
                    i10 = i11 + 1;
                } catch (Exception e12) {
                    e = e12;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final byte[] j0(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = bArr;
            byte[] bArr4 = bArr2;
            int length = bArr3.length;
            int length2 = bArr4.length;
            byte[] bArrCopyOf = Arrays.copyOf(bArr3, length + length2);
            System.arraycopy(bArr4, 0, bArrCopyOf, length, length2);
            return bArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final byte[] k0() {
            return new byte[0];
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final byte[] n0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            JsonToken jsonTokenK = jsonParser.K();
            if (jsonTokenK == JsonToken.VALUE_NUMBER_INT) {
                return new byte[]{jsonParser.c0()};
            }
            if (jsonTokenK != JsonToken.VALUE_NULL) {
                deserializationContext.C(this.f4054a.getComponentType(), jsonParser);
                throw null;
            }
            i iVar = this.h;
            if (iVar != null) {
                iVar.a(deserializationContext);
                return (byte[]) j(deserializationContext);
            }
            Z(deserializationContext);
            return null;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers, b3.c
        public final LogicalType o() {
            return LogicalType.f4437n;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final PrimitiveArrayDeserializers<?> o0(i iVar, Boolean bool) {
            return new ByteDeser(this, iVar, bool);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class DoubleDeser extends PrimitiveArrayDeserializers<double[]> {
        public DoubleDeser() {
            super(double[].class);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
            i iVar;
            if (!jsonParser.l1()) {
                return m0(jsonParser, deserializationContext);
            }
            b bVarU = deserializationContext.u();
            if (bVarU.f11553g == null) {
                bVarU.f11553g = new b.c();
            }
            b.c cVar = bVarU.f11553g;
            double[] dArr = (double[]) cVar.d();
            int i10 = 0;
            while (true) {
                try {
                    JsonToken jsonTokenQ1 = jsonParser.q1();
                    if (jsonTokenQ1 == JsonToken.END_ARRAY) {
                        return (double[]) cVar.c(i10, dArr);
                    }
                    if (jsonTokenQ1 != JsonToken.VALUE_NULL || (iVar = this.h) == null) {
                        double dO = O(jsonParser, deserializationContext);
                        if (i10 >= dArr.length) {
                            double[] dArr2 = (double[]) cVar.b(i10, dArr);
                            i10 = 0;
                            dArr = dArr2;
                        }
                        int i11 = i10 + 1;
                        try {
                            dArr[i10] = dO;
                            i10 = i11;
                        } catch (Exception e10) {
                            e = e10;
                            i10 = i11;
                            throw JsonMappingException.h(e, dArr, cVar.f11569d + i10);
                        }
                    } else {
                        iVar.a(deserializationContext);
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final double[] j0(double[] dArr, double[] dArr2) {
            double[] dArr3 = dArr;
            double[] dArr4 = dArr2;
            int length = dArr3.length;
            int length2 = dArr4.length;
            double[] dArrCopyOf = Arrays.copyOf(dArr3, length + length2);
            System.arraycopy(dArr4, 0, dArrCopyOf, length, length2);
            return dArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final double[] k0() {
            return new double[0];
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final double[] n0(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new double[]{O(jsonParser, deserializationContext)};
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final PrimitiveArrayDeserializers<?> o0(i iVar, Boolean bool) {
            return new DoubleDeser(this, iVar, bool);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class FloatDeser extends PrimitiveArrayDeserializers<float[]> {
        public FloatDeser() {
            super(float[].class);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
            i iVar;
            if (!jsonParser.l1()) {
                return m0(jsonParser, deserializationContext);
            }
            b bVarU = deserializationContext.u();
            if (bVarU.f11552f == null) {
                bVarU.f11552f = new b.d();
            }
            b.d dVar = bVarU.f11552f;
            float[] fArr = (float[]) dVar.d();
            int i10 = 0;
            while (true) {
                try {
                    JsonToken jsonTokenQ1 = jsonParser.q1();
                    if (jsonTokenQ1 == JsonToken.END_ARRAY) {
                        return (float[]) dVar.c(i10, fArr);
                    }
                    if (jsonTokenQ1 != JsonToken.VALUE_NULL || (iVar = this.h) == null) {
                        float fP = P(jsonParser, deserializationContext);
                        if (i10 >= fArr.length) {
                            float[] fArr2 = (float[]) dVar.b(i10, fArr);
                            i10 = 0;
                            fArr = fArr2;
                        }
                        int i11 = i10 + 1;
                        try {
                            fArr[i10] = fP;
                            i10 = i11;
                        } catch (Exception e10) {
                            e = e10;
                            i10 = i11;
                            throw JsonMappingException.h(e, fArr, dVar.f11569d + i10);
                        }
                    } else {
                        iVar.a(deserializationContext);
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final float[] j0(float[] fArr, float[] fArr2) {
            float[] fArr3 = fArr;
            float[] fArr4 = fArr2;
            int length = fArr3.length;
            int length2 = fArr4.length;
            float[] fArrCopyOf = Arrays.copyOf(fArr3, length + length2);
            System.arraycopy(fArr4, 0, fArrCopyOf, length, length2);
            return fArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final float[] k0() {
            return new float[0];
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final float[] n0(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new float[]{P(jsonParser, deserializationContext)};
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final PrimitiveArrayDeserializers<?> o0(i iVar, Boolean bool) {
            return new FloatDeser(this, iVar, bool);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class IntDeser extends PrimitiveArrayDeserializers<int[]> {

        /* renamed from: j, reason: collision with root package name */
        public static final IntDeser f4046j = new IntDeser();

        public IntDeser() {
            super(int[].class);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
            int iM0;
            int i10;
            if (!jsonParser.l1()) {
                return m0(jsonParser, deserializationContext);
            }
            b bVarU = deserializationContext.u();
            if (bVarU.f11550d == null) {
                bVarU.f11550d = new b.e();
            }
            b.e eVar = bVarU.f11550d;
            int[] iArr = (int[]) eVar.d();
            int i11 = 0;
            while (true) {
                try {
                    JsonToken jsonTokenQ1 = jsonParser.q1();
                    if (jsonTokenQ1 == JsonToken.END_ARRAY) {
                        return (int[]) eVar.c(i11, iArr);
                    }
                    try {
                        if (jsonTokenQ1 == JsonToken.VALUE_NUMBER_INT) {
                            iM0 = jsonParser.M0();
                        } else if (jsonTokenQ1 == JsonToken.VALUE_NULL) {
                            i iVar = this.h;
                            if (iVar != null) {
                                iVar.a(deserializationContext);
                            } else {
                                Z(deserializationContext);
                                iM0 = 0;
                            }
                        } else {
                            iM0 = Q(jsonParser, deserializationContext);
                        }
                        iArr[i11] = iM0;
                        i11 = i10;
                    } catch (Exception e10) {
                        e = e10;
                        i11 = i10;
                        throw JsonMappingException.h(e, iArr, eVar.f11569d + i11);
                    }
                    if (i11 >= iArr.length) {
                        int[] iArr2 = (int[]) eVar.b(i11, iArr);
                        i11 = 0;
                        iArr = iArr2;
                    }
                    i10 = i11 + 1;
                } catch (Exception e11) {
                    e = e11;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final int[] j0(int[] iArr, int[] iArr2) {
            int[] iArr3 = iArr;
            int[] iArr4 = iArr2;
            int length = iArr3.length;
            int length2 = iArr4.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr3, length + length2);
            System.arraycopy(iArr4, 0, iArrCopyOf, length, length2);
            return iArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final int[] k0() {
            return new int[0];
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final int[] n0(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new int[]{Q(jsonParser, deserializationContext)};
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final PrimitiveArrayDeserializers<?> o0(i iVar, Boolean bool) {
            return new IntDeser(this, iVar, bool);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class LongDeser extends PrimitiveArrayDeserializers<long[]> {

        /* renamed from: j, reason: collision with root package name */
        public static final LongDeser f4047j = new LongDeser();

        public LongDeser() {
            super(long[].class);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
            long jN0;
            int i10;
            if (!jsonParser.l1()) {
                return m0(jsonParser, deserializationContext);
            }
            b bVarU = deserializationContext.u();
            if (bVarU.f11551e == null) {
                bVarU.f11551e = new b.f();
            }
            b.f fVar = bVarU.f11551e;
            long[] jArr = (long[]) fVar.d();
            int i11 = 0;
            while (true) {
                try {
                    JsonToken jsonTokenQ1 = jsonParser.q1();
                    if (jsonTokenQ1 == JsonToken.END_ARRAY) {
                        return (long[]) fVar.c(i11, jArr);
                    }
                    try {
                        if (jsonTokenQ1 == JsonToken.VALUE_NUMBER_INT) {
                            jN0 = jsonParser.N0();
                        } else if (jsonTokenQ1 == JsonToken.VALUE_NULL) {
                            i iVar = this.h;
                            if (iVar != null) {
                                iVar.a(deserializationContext);
                            } else {
                                Z(deserializationContext);
                                jN0 = 0;
                            }
                        } else {
                            jN0 = U(jsonParser, deserializationContext);
                        }
                        jArr[i11] = jN0;
                        i11 = i10;
                    } catch (Exception e10) {
                        e = e10;
                        i11 = i10;
                        throw JsonMappingException.h(e, jArr, fVar.f11569d + i11);
                    }
                    if (i11 >= jArr.length) {
                        long[] jArr2 = (long[]) fVar.b(i11, jArr);
                        i11 = 0;
                        jArr = jArr2;
                    }
                    i10 = i11 + 1;
                } catch (Exception e11) {
                    e = e11;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final long[] j0(long[] jArr, long[] jArr2) {
            long[] jArr3 = jArr;
            long[] jArr4 = jArr2;
            int length = jArr3.length;
            int length2 = jArr4.length;
            long[] jArrCopyOf = Arrays.copyOf(jArr3, length + length2);
            System.arraycopy(jArr4, 0, jArrCopyOf, length, length2);
            return jArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final long[] k0() {
            return new long[0];
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final long[] n0(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new long[]{U(jsonParser, deserializationContext)};
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final PrimitiveArrayDeserializers<?> o0(i iVar, Boolean bool) {
            return new LongDeser(this, iVar, bool);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class ShortDeser extends PrimitiveArrayDeserializers<short[]> {
        public ShortDeser() {
            super(short[].class);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
            short sV;
            int i10;
            if (!jsonParser.l1()) {
                return m0(jsonParser, deserializationContext);
            }
            b bVarU = deserializationContext.u();
            if (bVarU.f11549c == null) {
                bVarU.f11549c = new b.g();
            }
            b.g gVar = bVarU.f11549c;
            short[] sArrD = gVar.d();
            int i11 = 0;
            while (true) {
                try {
                    JsonToken jsonTokenQ1 = jsonParser.q1();
                    if (jsonTokenQ1 == JsonToken.END_ARRAY) {
                        return (short[]) gVar.c(i11, sArrD);
                    }
                    try {
                        if (jsonTokenQ1 == JsonToken.VALUE_NULL) {
                            i iVar = this.h;
                            if (iVar != null) {
                                iVar.a(deserializationContext);
                            } else {
                                Z(deserializationContext);
                                sV = 0;
                            }
                        } else {
                            sV = V(jsonParser, deserializationContext);
                        }
                        sArrD[i11] = sV;
                        i11 = i10;
                    } catch (Exception e10) {
                        e = e10;
                        i11 = i10;
                        throw JsonMappingException.h(e, sArrD, gVar.f11569d + i11);
                    }
                    if (i11 >= sArrD.length) {
                        short[] sArr = (short[]) gVar.b(i11, sArrD);
                        i11 = 0;
                        sArrD = sArr;
                    }
                    i10 = i11 + 1;
                } catch (Exception e11) {
                    e = e11;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final short[] j0(short[] sArr, short[] sArr2) {
            short[] sArr3 = sArr;
            short[] sArr4 = sArr2;
            int length = sArr3.length;
            int length2 = sArr4.length;
            short[] sArrCopyOf = Arrays.copyOf(sArr3, length + length2);
            System.arraycopy(sArr4, 0, sArrCopyOf, length, length2);
            return sArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final short[] k0() {
            return new short[0];
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final short[] n0(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new short[]{V(jsonParser, deserializationContext)};
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final PrimitiveArrayDeserializers<?> o0(i iVar, Boolean bool) {
            return new ShortDeser(this, iVar, bool);
        }
    }

    public PrimitiveArrayDeserializers(Class<T> cls) {
        super((Class<?>) cls);
        this.f4044d = null;
        this.h = null;
    }

    public static PrimitiveArrayDeserializers l0(Class cls) {
        if (cls == Integer.TYPE) {
            return IntDeser.f4046j;
        }
        if (cls == Long.TYPE) {
            return LongDeser.f4047j;
        }
        if (cls == Byte.TYPE) {
            return new ByteDeser();
        }
        if (cls == Short.TYPE) {
            return new ShortDeser();
        }
        if (cls == Float.TYPE) {
            return new FloatDeser();
        }
        if (cls == Double.TYPE) {
            return new DoubleDeser();
        }
        if (cls == Boolean.TYPE) {
            return new BooleanDeser();
        }
        if (cls == Character.TYPE) {
            return new CharDeser();
        }
        throw new IllegalStateException();
    }

    @Override // e3.c
    public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        Class<?> cls = this.f4054a;
        JsonFormat.Value valueD0 = StdDeserializer.d0(deserializationContext, beanProperty, cls);
        i nullsFailProvider = null;
        Boolean boolB = valueD0 != null ? valueD0.b(JsonFormat.Feature.f3434a) : null;
        Nulls nulls = beanProperty != null ? beanProperty.c().f3750j : null;
        if (nulls == Nulls.f3491a) {
            nullsFailProvider = NullsConstantProvider.f3924b;
        } else if (nulls == Nulls.f3492b) {
            nullsFailProvider = beanProperty == null ? new NullsFailProvider(null, deserializationContext.k(cls.getComponentType())) : new NullsFailProvider(beanProperty.b(), beanProperty.getType().k());
        }
        return (Objects.equals(boolB, this.f4044d) && nullsFailProvider == this.h) ? this : o0(nullsFailProvider, boolB);
    }

    @Override // b3.c
    public final T e(JsonParser jsonParser, DeserializationContext deserializationContext, T t8) {
        T tD = d(jsonParser, deserializationContext);
        return (t8 == null || Array.getLength(t8) == 0) ? tD : j0(t8, tD);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, k3.b bVar) {
        return bVar.c(jsonParser, deserializationContext);
    }

    @Override // b3.c
    public final AccessPattern i() {
        return AccessPattern.f4492b;
    }

    @Override // b3.c
    public final Object j(DeserializationContext deserializationContext) {
        Object obj = this.f4045e;
        if (obj != null) {
            return obj;
        }
        T tK0 = k0();
        this.f4045e = tK0;
        return tK0;
    }

    public abstract T j0(T t8, T t10);

    public abstract T k0();

    public final T m0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        if (jsonParser.i1(JsonToken.VALUE_STRING)) {
            return D(jsonParser, deserializationContext);
        }
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = this.f4044d;
        if (bool2 == bool || (bool2 == null && deserializationContext.J(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return n0(jsonParser, deserializationContext);
        }
        deserializationContext.C(this.f4054a, jsonParser);
        throw null;
    }

    public abstract T n0(JsonParser jsonParser, DeserializationContext deserializationContext);

    @Override // b3.c
    public LogicalType o() {
        return LogicalType.f4428a;
    }

    public abstract PrimitiveArrayDeserializers<?> o0(i iVar, Boolean bool);

    @Override // b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }

    public PrimitiveArrayDeserializers(PrimitiveArrayDeserializers<?> primitiveArrayDeserializers, i iVar, Boolean bool) {
        super(primitiveArrayDeserializers.f4054a);
        this.f4044d = bool;
        this.h = iVar;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static final class CharDeser extends PrimitiveArrayDeserializers<char[]> {
        public CharDeser() {
            super(char[].class);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            String strV0;
            if (jsonParser.i1(JsonToken.VALUE_STRING)) {
                char[] cArrW0 = jsonParser.W0();
                int iY0 = jsonParser.Y0();
                int iX0 = jsonParser.X0();
                char[] cArr = new char[iX0];
                System.arraycopy(cArrW0, iY0, cArr, 0, iX0);
                return cArr;
            }
            if (!jsonParser.l1()) {
                if (jsonParser.i1(JsonToken.VALUE_EMBEDDED_OBJECT)) {
                    Object objK0 = jsonParser.K0();
                    if (objK0 == null) {
                        return null;
                    }
                    if (objK0 instanceof char[]) {
                        return (char[]) objK0;
                    }
                    if (objK0 instanceof String) {
                        return ((String) objK0).toCharArray();
                    }
                    if (objK0 instanceof byte[]) {
                        return v2.a.f13372b.e((byte[]) objK0).toCharArray();
                    }
                }
                deserializationContext.C(this.f4054a, jsonParser);
                throw null;
            }
            StringBuilder sb2 = new StringBuilder(64);
            while (true) {
                JsonToken jsonTokenQ1 = jsonParser.q1();
                if (jsonTokenQ1 == JsonToken.END_ARRAY) {
                    return sb2.toString().toCharArray();
                }
                if (jsonTokenQ1 == JsonToken.VALUE_STRING) {
                    strV0 = jsonParser.V0();
                } else {
                    if (jsonTokenQ1 != JsonToken.VALUE_NULL) {
                        deserializationContext.C(Character.TYPE, jsonParser);
                        throw null;
                    }
                    i iVar = this.h;
                    if (iVar != null) {
                        iVar.a(deserializationContext);
                    } else {
                        Z(deserializationContext);
                        strV0 = "\u0000";
                    }
                }
                if (strV0.length() != 1) {
                    deserializationContext.P(this, "Cannot convert a JSON String of length %d into a char element of char array", Integer.valueOf(strV0.length()));
                    throw null;
                }
                sb2.append(strV0.charAt(0));
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final char[] j0(char[] cArr, char[] cArr2) {
            char[] cArr3 = cArr;
            char[] cArr4 = cArr2;
            int length = cArr3.length;
            int length2 = cArr4.length;
            char[] cArrCopyOf = Arrays.copyOf(cArr3, length + length2);
            System.arraycopy(cArr4, 0, cArrCopyOf, length, length2);
            return cArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final char[] k0() {
            return new char[0];
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final char[] n0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            deserializationContext.C(this.f4054a, jsonParser);
            throw null;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public final PrimitiveArrayDeserializers<?> o0(i iVar, Boolean bool) {
            return this;
        }
    }
}
