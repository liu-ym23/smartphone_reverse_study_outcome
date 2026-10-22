package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import c3.a;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.HashMap;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class StdArraySerializers {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, f<?>> f4408a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class CharArraySerializer extends StdSerializer<char[]> {
        public CharArraySerializer() {
            super(char[].class);
        }

        @Override // b3.f
        public final boolean d(h hVar, Object obj) {
            return ((char[]) obj).length == 0;
        }

        @Override // b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
            char[] cArr = (char[]) obj;
            boolean zQ = hVar.f3044a.q(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS);
            if (!zQ) {
                jsonGenerator.h1(cArr, 0, cArr.length);
                return;
            }
            int length = cArr.length;
            jsonGenerator.b1(cArr);
            int length2 = cArr.length;
            for (int i10 = 0; i10 < length2; i10++) {
                jsonGenerator.h1(cArr, i10, 1);
            }
            jsonGenerator.C0();
        }

        @Override // b3.f
        public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
            WritableTypeId writableTypeIdE;
            char[] cArr = (char[]) obj;
            boolean zQ = hVar.f3044a.q(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS);
            if (zQ) {
                writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.START_ARRAY, cArr));
                int length = cArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    jsonGenerator.h1(cArr, i10, 1);
                }
            } else {
                writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.VALUE_STRING, cArr));
                jsonGenerator.h1(cArr, 0, cArr.length);
            }
            eVar.f(jsonGenerator, writableTypeIdE);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class FloatArraySerializer extends TypedPrimitiveArraySerializer<float[]> {
        static {
            TypeFactory.f4468d.getClass();
            TypeFactory.m(Float.TYPE);
        }

        public FloatArraySerializer() {
            super(float[].class);
        }

        @Override // b3.f
        public final boolean d(h hVar, Object obj) {
            return ((float[]) obj).length == 0;
        }

        @Override // b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
            float[] fArr = (float[]) obj;
            int i10 = 0;
            if (fArr.length == 1 && p(hVar)) {
                int length = fArr.length;
                while (i10 < length) {
                    jsonGenerator.L0(fArr[i10]);
                    i10++;
                }
                return;
            }
            jsonGenerator.b1(fArr);
            int length2 = fArr.length;
            while (i10 < length2) {
                jsonGenerator.L0(fArr[i10]);
                i10++;
            }
            jsonGenerator.C0();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public final f<?> q(BeanProperty beanProperty, Boolean bool) {
            return new FloatArraySerializer(this, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public final void r(Object obj, JsonGenerator jsonGenerator, h hVar) {
            for (float f8 : (float[]) obj) {
                jsonGenerator.L0(f8);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class LongArraySerializer extends TypedPrimitiveArraySerializer<long[]> {
        static {
            TypeFactory.f4468d.getClass();
            TypeFactory.m(Long.TYPE);
        }

        public LongArraySerializer() {
            super(long[].class);
        }

        @Override // b3.f
        public final boolean d(h hVar, Object obj) {
            return ((long[]) obj).length == 0;
        }

        @Override // b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
            long[] jArr = (long[]) obj;
            int i10 = 0;
            if (jArr.length == 1 && p(hVar)) {
                int length = jArr.length;
                while (i10 < length) {
                    jsonGenerator.N0(jArr[i10]);
                    i10++;
                }
                return;
            }
            int length2 = jArr.length;
            jsonGenerator.getClass();
            JsonGenerator.o(jArr.length, length2);
            jsonGenerator.b1(jArr);
            while (i10 < length2) {
                jsonGenerator.N0(jArr[i10]);
                i10++;
            }
            jsonGenerator.C0();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public final f<?> q(BeanProperty beanProperty, Boolean bool) {
            return new LongArraySerializer(this, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public final void r(Object obj, JsonGenerator jsonGenerator, h hVar) {
            for (long j10 : (long[]) obj) {
                jsonGenerator.N0(j10);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class ShortArraySerializer extends TypedPrimitiveArraySerializer<short[]> {
        static {
            TypeFactory.f4468d.getClass();
            TypeFactory.m(Short.TYPE);
        }

        public ShortArraySerializer() {
            super(short[].class);
        }

        @Override // b3.f
        public final boolean d(h hVar, Object obj) {
            return ((short[]) obj).length == 0;
        }

        @Override // b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
            short[] sArr = (short[]) obj;
            int i10 = 0;
            if (sArr.length == 1 && p(hVar)) {
                int length = sArr.length;
                while (i10 < length) {
                    jsonGenerator.M0(sArr[i10]);
                    i10++;
                }
                return;
            }
            jsonGenerator.b1(sArr);
            int length2 = sArr.length;
            while (i10 < length2) {
                jsonGenerator.M0(sArr[i10]);
                i10++;
            }
            jsonGenerator.C0();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public final f<?> q(BeanProperty beanProperty, Boolean bool) {
            return new ShortArraySerializer(this, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public final void r(Object obj, JsonGenerator jsonGenerator, h hVar) {
            for (short s8 : (short[]) obj) {
                jsonGenerator.M0(s8);
            }
        }
    }

    static {
        HashMap<String, f<?>> map = new HashMap<>();
        f4408a = map;
        map.put(boolean[].class.getName(), new BooleanArraySerializer());
        map.put(byte[].class.getName(), new ByteArraySerializer());
        map.put(char[].class.getName(), new CharArraySerializer());
        map.put(short[].class.getName(), new ShortArraySerializer());
        map.put(int[].class.getName(), new IntArraySerializer());
        map.put(long[].class.getName(), new LongArraySerializer());
        map.put(float[].class.getName(), new FloatArraySerializer());
        map.put(double[].class.getName(), new DoubleArraySerializer());
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class BooleanArraySerializer extends ArraySerializerBase<boolean[]> {
        static {
            TypeFactory.f4468d.getClass();
            TypeFactory.m(Boolean.class);
        }

        public BooleanArraySerializer() {
            super(boolean[].class);
        }

        @Override // b3.f
        public final boolean d(h hVar, Object obj) {
            return ((boolean[]) obj).length == 0;
        }

        @Override // b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
            boolean[] zArr = (boolean[]) obj;
            int i10 = 0;
            if (zArr.length == 1 && p(hVar)) {
                int length = zArr.length;
                while (i10 < length) {
                    jsonGenerator.g0(zArr[i10]);
                    i10++;
                }
                return;
            }
            jsonGenerator.b1(zArr);
            int length2 = zArr.length;
            while (i10 < length2) {
                jsonGenerator.g0(zArr[i10]);
                i10++;
            }
            jsonGenerator.C0();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public final f<?> q(BeanProperty beanProperty, Boolean bool) {
            return new BooleanArraySerializer(this, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public final void r(boolean[] zArr, JsonGenerator jsonGenerator, h hVar) {
            for (boolean z : zArr) {
                jsonGenerator.g0(z);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public final ContainerSerializer<?> o(e eVar) {
            return this;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class DoubleArraySerializer extends ArraySerializerBase<double[]> {
        static {
            TypeFactory.f4468d.getClass();
            TypeFactory.m(Double.TYPE);
        }

        public DoubleArraySerializer() {
            super(double[].class);
        }

        @Override // b3.f
        public final boolean d(h hVar, Object obj) {
            return ((double[]) obj).length == 0;
        }

        @Override // b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
            double[] dArr = (double[]) obj;
            int i10 = 0;
            if (dArr.length == 1 && p(hVar)) {
                int length = dArr.length;
                while (i10 < length) {
                    jsonGenerator.K0(dArr[i10]);
                    i10++;
                }
                return;
            }
            int length2 = dArr.length;
            jsonGenerator.getClass();
            JsonGenerator.o(dArr.length, length2);
            jsonGenerator.b1(dArr);
            while (i10 < length2) {
                jsonGenerator.K0(dArr[i10]);
                i10++;
            }
            jsonGenerator.C0();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public final f<?> q(BeanProperty beanProperty, Boolean bool) {
            return new DoubleArraySerializer(this, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public final void r(double[] dArr, JsonGenerator jsonGenerator, h hVar) {
            for (double d8 : dArr) {
                jsonGenerator.K0(d8);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public final ContainerSerializer<?> o(e eVar) {
            return this;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @a
    public static class IntArraySerializer extends ArraySerializerBase<int[]> {
        static {
            TypeFactory.f4468d.getClass();
            TypeFactory.m(Integer.TYPE);
        }

        public IntArraySerializer() {
            super(int[].class);
        }

        @Override // b3.f
        public final boolean d(h hVar, Object obj) {
            return ((int[]) obj).length == 0;
        }

        @Override // b3.f
        public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
            int[] iArr = (int[]) obj;
            int i10 = 0;
            if (iArr.length == 1 && p(hVar)) {
                int length = iArr.length;
                while (i10 < length) {
                    jsonGenerator.M0(iArr[i10]);
                    i10++;
                }
                return;
            }
            int length2 = iArr.length;
            jsonGenerator.getClass();
            JsonGenerator.o(iArr.length, length2);
            jsonGenerator.b1(iArr);
            while (i10 < length2) {
                jsonGenerator.M0(iArr[i10]);
                i10++;
            }
            jsonGenerator.C0();
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public final f<?> q(BeanProperty beanProperty, Boolean bool) {
            return new IntArraySerializer(this, beanProperty, bool);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
        public final void r(int[] iArr, JsonGenerator jsonGenerator, h hVar) {
            for (int i10 : iArr) {
                jsonGenerator.M0(i10);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public final ContainerSerializer<?> o(e eVar) {
            return this;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class TypedPrimitiveArraySerializer<T> extends ArraySerializerBase<T> {
        @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
        public final ContainerSerializer<?> o(e eVar) {
            return this;
        }
    }
}
