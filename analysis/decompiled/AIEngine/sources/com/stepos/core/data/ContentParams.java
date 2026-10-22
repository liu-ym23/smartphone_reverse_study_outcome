package com.stepos.core.data;

import ai.onnxruntime.providers.a;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.b;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ContentParams implements Parcelable {
    private static final byte TYPE_BOOLEAN = 4;
    private static final byte TYPE_DOUBLE = 3;
    private static final byte TYPE_FLOAT = 2;
    private static final byte TYPE_FLOAT_ARRAY = 7;
    private static final byte TYPE_INT = 0;
    private static final byte TYPE_INT_ARRAY = 6;
    private static final byte TYPE_LONG = 1;
    private static final byte TYPE_STRING = 5;
    private final Map<String, ParamValue> params;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ContentParams> CREATOR = new Parcelable.Creator<ContentParams>() { // from class: com.stepos.core.data.ContentParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentParams createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new ContentParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContentParams[] newArray(int i10) {
            return new ContentParams[i10];
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Builder {
        private final Map<String, ParamValue> params = new LinkedHashMap();

        public final ContentParams build() {
            return new ContentParams(b.n0(this.params), null);
        }

        public final Builder putBoolean(String key, boolean z) {
            g.f(key, "key");
            this.params.put(key, new ParamValue.BooleanValue(z));
            return this;
        }

        public final Builder putDouble(String key, double d8) {
            g.f(key, "key");
            this.params.put(key, new ParamValue.DoubleValue(d8));
            return this;
        }

        public final Builder putFloat(String key, float f8) {
            g.f(key, "key");
            this.params.put(key, new ParamValue.FloatValue(f8));
            return this;
        }

        public final Builder putFloatArray(String key, float[] value) {
            g.f(key, "key");
            g.f(value, "value");
            this.params.put(key, new ParamValue.FloatArrayValue(value));
            return this;
        }

        public final Builder putInt(String key, int i10) {
            g.f(key, "key");
            this.params.put(key, new ParamValue.IntValue(i10));
            return this;
        }

        public final Builder putIntArray(String key, int[] value) {
            g.f(key, "key");
            g.f(value, "value");
            this.params.put(key, new ParamValue.IntArrayValue(value));
            return this;
        }

        public final Builder putLong(String key, long j10) {
            g.f(key, "key");
            this.params.put(key, new ParamValue.LongValue(j10));
            return this;
        }

        public final Builder putString(String key, String value) {
            g.f(key, "key");
            g.f(value, "value");
            this.params.put(key, new ParamValue.StringValue(value));
            return this;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, ParamValue> readParamsFromParcel(Parcel parcel) {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return fromByteArray(bArr).params;
        }

        public final ContentParams empty() {
            return new ContentParams(b.d0(), null);
        }

        public final ContentParams fromByteArray(byte[] bytes) {
            ParamValue floatArrayValue;
            g.f(bytes, "bytes");
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i10 = byteBufferOrder.getInt();
            for (int i11 = 0; i11 < i10; i11++) {
                byte b10 = byteBufferOrder.get();
                byte[] bArr = new byte[byteBufferOrder.getShort()];
                byteBufferOrder.get(bArr);
                Charset UTF_8 = StandardCharsets.UTF_8;
                g.e(UTF_8, "UTF_8");
                String str = new String(bArr, UTF_8);
                if (b10 == 0) {
                    floatArrayValue = new ParamValue.IntValue(byteBufferOrder.getInt());
                } else if (b10 == 1) {
                    floatArrayValue = new ParamValue.LongValue(byteBufferOrder.getLong());
                } else if (b10 == 2) {
                    floatArrayValue = new ParamValue.FloatValue(byteBufferOrder.getFloat());
                } else if (b10 == 3) {
                    floatArrayValue = new ParamValue.DoubleValue(byteBufferOrder.getDouble());
                } else if (b10 == 4) {
                    floatArrayValue = new ParamValue.BooleanValue(byteBufferOrder.get() != 0);
                } else if (b10 == 5) {
                    byte[] bArr2 = new byte[byteBufferOrder.getInt()];
                    byteBufferOrder.get(bArr2);
                    g.e(UTF_8, "UTF_8");
                    floatArrayValue = new ParamValue.StringValue(new String(bArr2, UTF_8));
                } else if (b10 == 6) {
                    int i12 = byteBufferOrder.getInt();
                    int[] iArr = new int[i12];
                    for (int i13 = 0; i13 < i12; i13++) {
                        iArr[i13] = byteBufferOrder.getInt();
                    }
                    floatArrayValue = new ParamValue.IntArrayValue(iArr);
                } else {
                    if (b10 != 7) {
                        throw new IllegalArgumentException(a.a(b10, "Unknown param type: "));
                    }
                    int i14 = byteBufferOrder.getInt();
                    float[] fArr = new float[i14];
                    for (int i15 = 0; i15 < i14; i15++) {
                        fArr[i15] = byteBufferOrder.getFloat();
                    }
                    floatArrayValue = new ParamValue.FloatArrayValue(fArr);
                }
                linkedHashMap.put(str, floatArrayValue);
            }
            return new ContentParams(linkedHashMap, null);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class ParamValue {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class BooleanValue extends ParamValue {
            private final boolean value;

            public BooleanValue(boolean z) {
                super(null);
                this.value = z;
            }

            public static /* synthetic */ BooleanValue copy$default(BooleanValue booleanValue, boolean z, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    z = booleanValue.value;
                }
                return booleanValue.copy(z);
            }

            public final boolean component1() {
                return this.value;
            }

            public final BooleanValue copy(boolean z) {
                return new BooleanValue(z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof BooleanValue) && this.value == ((BooleanValue) obj).value;
            }

            public final boolean getValue() {
                return this.value;
            }

            public int hashCode() {
                return Boolean.hashCode(this.value);
            }

            public String toString() {
                return "BooleanValue(value=" + this.value + ")";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class DoubleValue extends ParamValue {
            private final double value;

            public DoubleValue(double d8) {
                super(null);
                this.value = d8;
            }

            public static /* synthetic */ DoubleValue copy$default(DoubleValue doubleValue, double d8, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    d8 = doubleValue.value;
                }
                return doubleValue.copy(d8);
            }

            public final double component1() {
                return this.value;
            }

            public final DoubleValue copy(double d8) {
                return new DoubleValue(d8);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof DoubleValue) && Double.compare(this.value, ((DoubleValue) obj).value) == 0;
            }

            public final double getValue() {
                return this.value;
            }

            public int hashCode() {
                return Double.hashCode(this.value);
            }

            public String toString() {
                return "DoubleValue(value=" + this.value + ")";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class FloatArrayValue extends ParamValue {
            private final float[] value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FloatArrayValue(float[] value) {
                super(null);
                g.f(value, "value");
                this.value = value;
            }

            public static /* synthetic */ FloatArrayValue copy$default(FloatArrayValue floatArrayValue, float[] fArr, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    fArr = floatArrayValue.value;
                }
                return floatArrayValue.copy(fArr);
            }

            public final float[] component1() {
                return this.value;
            }

            public final FloatArrayValue copy(float[] value) {
                g.f(value, "value");
                return new FloatArrayValue(value);
            }

            public boolean equals(Object obj) {
                return (obj instanceof FloatArrayValue) && Arrays.equals(this.value, ((FloatArrayValue) obj).value);
            }

            public final float[] getValue() {
                return this.value;
            }

            public int hashCode() {
                return Arrays.hashCode(this.value);
            }

            public String toString() {
                return a0.a.k("FloatArrayValue(value=", Arrays.toString(this.value), ")");
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class FloatValue extends ParamValue {
            private final float value;

            public FloatValue(float f8) {
                super(null);
                this.value = f8;
            }

            public static /* synthetic */ FloatValue copy$default(FloatValue floatValue, float f8, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    f8 = floatValue.value;
                }
                return floatValue.copy(f8);
            }

            public final float component1() {
                return this.value;
            }

            public final FloatValue copy(float f8) {
                return new FloatValue(f8);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof FloatValue) && Float.compare(this.value, ((FloatValue) obj).value) == 0;
            }

            public final float getValue() {
                return this.value;
            }

            public int hashCode() {
                return Float.hashCode(this.value);
            }

            public String toString() {
                return "FloatValue(value=" + this.value + ")";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class IntArrayValue extends ParamValue {
            private final int[] value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public IntArrayValue(int[] value) {
                super(null);
                g.f(value, "value");
                this.value = value;
            }

            public static /* synthetic */ IntArrayValue copy$default(IntArrayValue intArrayValue, int[] iArr, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    iArr = intArrayValue.value;
                }
                return intArrayValue.copy(iArr);
            }

            public final int[] component1() {
                return this.value;
            }

            public final IntArrayValue copy(int[] value) {
                g.f(value, "value");
                return new IntArrayValue(value);
            }

            public boolean equals(Object obj) {
                return (obj instanceof IntArrayValue) && Arrays.equals(this.value, ((IntArrayValue) obj).value);
            }

            public final int[] getValue() {
                return this.value;
            }

            public int hashCode() {
                return Arrays.hashCode(this.value);
            }

            public String toString() {
                return a0.a.k("IntArrayValue(value=", Arrays.toString(this.value), ")");
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class IntValue extends ParamValue {
            private final int value;

            public IntValue(int i10) {
                super(null);
                this.value = i10;
            }

            public static /* synthetic */ IntValue copy$default(IntValue intValue, int i10, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    i10 = intValue.value;
                }
                return intValue.copy(i10);
            }

            public final int component1() {
                return this.value;
            }

            public final IntValue copy(int i10) {
                return new IntValue(i10);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof IntValue) && this.value == ((IntValue) obj).value;
            }

            public final int getValue() {
                return this.value;
            }

            public int hashCode() {
                return Integer.hashCode(this.value);
            }

            public String toString() {
                return ai.onnxruntime.a.g(this.value, "IntValue(value=", ")");
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class LongValue extends ParamValue {
            private final long value;

            public LongValue(long j10) {
                super(null);
                this.value = j10;
            }

            public static /* synthetic */ LongValue copy$default(LongValue longValue, long j10, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    j10 = longValue.value;
                }
                return longValue.copy(j10);
            }

            public final long component1() {
                return this.value;
            }

            public final LongValue copy(long j10) {
                return new LongValue(j10);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof LongValue) && this.value == ((LongValue) obj).value;
            }

            public final long getValue() {
                return this.value;
            }

            public int hashCode() {
                return Long.hashCode(this.value);
            }

            public String toString() {
                return ai.onnxruntime.a.h(this.value, "LongValue(value=", ")");
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class StringValue extends ParamValue {
            private final String value;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StringValue(String value) {
                super(null);
                g.f(value, "value");
                this.value = value;
            }

            public static /* synthetic */ StringValue copy$default(StringValue stringValue, String str, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = stringValue.value;
                }
                return stringValue.copy(str);
            }

            public final String component1() {
                return this.value;
            }

            public final StringValue copy(String value) {
                g.f(value, "value");
                return new StringValue(value);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof StringValue) && g.b(this.value, ((StringValue) obj).value);
            }

            public final String getValue() {
                return this.value;
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                return a0.a.k("StringValue(value=", this.value, ")");
            }
        }

        public /* synthetic */ ParamValue(e eVar) {
            this();
        }

        private ParamValue() {
        }
    }

    public /* synthetic */ ContentParams(Map map, e eVar) {
        this((Map<String, ? extends ParamValue>) map);
    }

    public static final ContentParams empty() {
        return Companion.empty();
    }

    public static final ContentParams fromByteArray(byte[] bArr) {
        return Companion.fromByteArray(bArr);
    }

    public static /* synthetic */ boolean getBoolean$default(ContentParams contentParams, String str, boolean z, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        return contentParams.getBoolean(str, z);
    }

    public static /* synthetic */ double getDouble$default(ContentParams contentParams, String str, double d8, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            d8 = 0.0d;
        }
        return contentParams.getDouble(str, d8);
    }

    public static /* synthetic */ float getFloat$default(ContentParams contentParams, String str, float f8, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f8 = 0.0f;
        }
        return contentParams.getFloat(str, f8);
    }

    public static /* synthetic */ int getInt$default(ContentParams contentParams, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return contentParams.getInt(str, i10);
    }

    public static /* synthetic */ long getLong$default(ContentParams contentParams, String str, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        return contentParams.getLong(str, j10);
    }

    public static /* synthetic */ String getString$default(ContentParams contentParams, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return contentParams.getString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$2(Map.Entry it) {
        g.f(it, "it");
        return it.getKey() + "=" + it.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int calculateByteSize() {
        /*
            r8 = this;
            java.util.Map<java.lang.String, com.stepos.core.data.ContentParams$ParamValue> r8 = r8.params
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
            r0 = 4
            r1 = r0
        Lc:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L8f
            java.lang.Object r2 = r8.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            com.stepos.core.data.ContentParams$ParamValue r2 = (com.stepos.core.data.ContentParams.ParamValue) r2
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r5 = "UTF_8"
            kotlin.jvm.internal.g.e(r4, r5)
            byte[] r3 = r3.getBytes(r4)
            java.lang.String r6 = "getBytes(...)"
            kotlin.jvm.internal.g.e(r3, r6)
            int r3 = r3.length
            int r3 = r3 + 3
            int r3 = r3 + r1
            boolean r1 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.IntValue
            if (r1 == 0) goto L3e
        L3c:
            r7 = r0
            goto L86
        L3e:
            boolean r1 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.LongValue
            r7 = 8
            if (r1 == 0) goto L45
            goto L86
        L45:
            boolean r1 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.FloatValue
            if (r1 == 0) goto L4a
            goto L3c
        L4a:
            boolean r1 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.DoubleValue
            if (r1 == 0) goto L4f
            goto L86
        L4f:
            boolean r1 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.BooleanValue
            if (r1 == 0) goto L55
            r7 = 1
            goto L86
        L55:
            boolean r1 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.StringValue
            if (r1 == 0) goto L6d
            com.stepos.core.data.ContentParams$ParamValue$StringValue r2 = (com.stepos.core.data.ContentParams.ParamValue.StringValue) r2
            java.lang.String r1 = r2.getValue()
            kotlin.jvm.internal.g.e(r4, r5)
            byte[] r1 = r1.getBytes(r4)
            kotlin.jvm.internal.g.e(r1, r6)
            int r1 = r1.length
        L6a:
            int r7 = r1 + 4
            goto L86
        L6d:
            boolean r1 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.IntArrayValue
            if (r1 == 0) goto L7a
            com.stepos.core.data.ContentParams$ParamValue$IntArrayValue r2 = (com.stepos.core.data.ContentParams.ParamValue.IntArrayValue) r2
            int[] r1 = r2.getValue()
            int r1 = r1.length
        L78:
            int r1 = r1 * r0
            goto L6a
        L7a:
            boolean r1 = r2 instanceof com.stepos.core.data.ContentParams.ParamValue.FloatArrayValue
            if (r1 == 0) goto L89
            com.stepos.core.data.ContentParams$ParamValue$FloatArrayValue r2 = (com.stepos.core.data.ContentParams.ParamValue.FloatArrayValue) r2
            float[] r1 = r2.getValue()
            int r1 = r1.length
            goto L78
        L86:
            int r1 = r3 + r7
            goto Lc
        L89:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L8f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.data.ContentParams.calculateByteSize():int");
    }

    public final boolean containsKey(String key) {
        g.f(key, "key");
        return this.params.containsKey(key);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getBoolean(String key, boolean z) {
        g.f(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.BooleanValue booleanValue = paramValue instanceof ParamValue.BooleanValue ? (ParamValue.BooleanValue) paramValue : null;
        return booleanValue != null ? booleanValue.getValue() : z;
    }

    public final double getDouble(String key, double d8) {
        g.f(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.DoubleValue doubleValue = paramValue instanceof ParamValue.DoubleValue ? (ParamValue.DoubleValue) paramValue : null;
        return doubleValue != null ? doubleValue.getValue() : d8;
    }

    public final float getFloat(String key, float f8) {
        g.f(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.FloatValue floatValue = paramValue instanceof ParamValue.FloatValue ? (ParamValue.FloatValue) paramValue : null;
        return floatValue != null ? floatValue.getValue() : f8;
    }

    public final float[] getFloatArray(String key) {
        g.f(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.FloatArrayValue floatArrayValue = paramValue instanceof ParamValue.FloatArrayValue ? (ParamValue.FloatArrayValue) paramValue : null;
        if (floatArrayValue != null) {
            return floatArrayValue.getValue();
        }
        return null;
    }

    public final int getInt(String key, int i10) {
        g.f(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.IntValue intValue = paramValue instanceof ParamValue.IntValue ? (ParamValue.IntValue) paramValue : null;
        return intValue != null ? intValue.getValue() : i10;
    }

    public final int[] getIntArray(String key) {
        g.f(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.IntArrayValue intArrayValue = paramValue instanceof ParamValue.IntArrayValue ? (ParamValue.IntArrayValue) paramValue : null;
        if (intArrayValue != null) {
            return intArrayValue.getValue();
        }
        return null;
    }

    public final long getLong(String key, long j10) {
        g.f(key, "key");
        ParamValue paramValue = this.params.get(key);
        ParamValue.LongValue longValue = paramValue instanceof ParamValue.LongValue ? (ParamValue.LongValue) paramValue : null;
        return longValue != null ? longValue.getValue() : j10;
    }

    public final String getString(String key, String str) {
        String value;
        g.f(key, "key");
        g.f(str, "default");
        ParamValue paramValue = this.params.get(key);
        ParamValue.StringValue stringValue = paramValue instanceof ParamValue.StringValue ? (ParamValue.StringValue) paramValue : null;
        return (stringValue == null || (value = stringValue.getValue()) == null) ? str : value;
    }

    public final boolean isEmpty() {
        return this.params.isEmpty();
    }

    public final Set<String> keys() {
        return this.params.keySet();
    }

    public final int size() {
        return this.params.size();
    }

    public final byte[] toByteArray() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(calculateByteSize()).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(this.params.size());
        for (Map.Entry<String, ParamValue> entry : this.params.entrySet()) {
            String key = entry.getKey();
            ParamValue value = entry.getValue();
            Charset UTF_8 = StandardCharsets.UTF_8;
            g.e(UTF_8, "UTF_8");
            byte[] bytes = key.getBytes(UTF_8);
            g.e(bytes, "getBytes(...)");
            int i10 = 0;
            if (value instanceof ParamValue.IntValue) {
                byteBufferOrder.put(TYPE_INT);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putInt(((ParamValue.IntValue) value).getValue());
            } else if (value instanceof ParamValue.LongValue) {
                byteBufferOrder.put(TYPE_LONG);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putLong(((ParamValue.LongValue) value).getValue());
            } else if (value instanceof ParamValue.FloatValue) {
                byteBufferOrder.put(TYPE_FLOAT);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putFloat(((ParamValue.FloatValue) value).getValue());
            } else if (value instanceof ParamValue.DoubleValue) {
                byteBufferOrder.put(TYPE_DOUBLE);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putDouble(((ParamValue.DoubleValue) value).getValue());
            } else if (value instanceof ParamValue.BooleanValue) {
                byteBufferOrder.put(TYPE_BOOLEAN);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.put(((ParamValue.BooleanValue) value).getValue() ? (byte) 1 : (byte) 0);
            } else if (value instanceof ParamValue.StringValue) {
                String value2 = ((ParamValue.StringValue) value).getValue();
                g.e(UTF_8, "UTF_8");
                byte[] bytes2 = value2.getBytes(UTF_8);
                g.e(bytes2, "getBytes(...)");
                byteBufferOrder.put(TYPE_STRING);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                byteBufferOrder.putInt(bytes2.length);
                byteBufferOrder.put(bytes2);
            } else if (value instanceof ParamValue.IntArrayValue) {
                byteBufferOrder.put(TYPE_INT_ARRAY);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                ParamValue.IntArrayValue intArrayValue = (ParamValue.IntArrayValue) value;
                byteBufferOrder.putInt(intArrayValue.getValue().length);
                int[] value3 = intArrayValue.getValue();
                int length = value3.length;
                while (i10 < length) {
                    byteBufferOrder.putInt(value3[i10]);
                    i10++;
                }
                n nVar = n.f10413a;
            } else {
                if (!(value instanceof ParamValue.FloatArrayValue)) {
                    throw new NoWhenBranchMatchedException();
                }
                byteBufferOrder.put(TYPE_FLOAT_ARRAY);
                byteBufferOrder.putShort((short) bytes.length);
                byteBufferOrder.put(bytes);
                ParamValue.FloatArrayValue floatArrayValue = (ParamValue.FloatArrayValue) value;
                byteBufferOrder.putInt(floatArrayValue.getValue().length);
                float[] value4 = floatArrayValue.getValue();
                int length2 = value4.length;
                while (i10 < length2) {
                    byteBufferOrder.putFloat(value4[i10]);
                    i10++;
                }
                n nVar2 = n.f10413a;
            }
        }
        byte[] bArrArray = byteBufferOrder.array();
        g.e(bArrArray, "array(...)");
        byte[] bArrCopyOf = Arrays.copyOf(bArrArray, byteBufferOrder.position());
        g.e(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public String toString() {
        return a0.a.k("ContentParams(", kotlin.collections.a.z0(this.params.entrySet(), null, null, null, new o6.a(13), 31), ")");
    }

    public final ContentParams withInt(String key, int i10) {
        g.f(key, "key");
        return new ContentParams((Map<String, ? extends ParamValue>) b.k0(this.params, new Pair(key, new ParamValue.IntValue(i10))));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        byte[] byteArray = toByteArray();
        parcel.writeInt(byteArray.length);
        parcel.writeByteArray(byteArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ContentParams(Map<String, ? extends ParamValue> map) {
        this.params = map;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentParams(Parcel parcel) {
        this((Map<String, ? extends ParamValue>) Companion.readParamsFromParcel(parcel));
        g.f(parcel, "parcel");
    }
}
