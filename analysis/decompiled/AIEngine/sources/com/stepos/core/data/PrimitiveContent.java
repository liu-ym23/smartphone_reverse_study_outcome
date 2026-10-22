package com.stepos.core.data;

import ai.onnxruntime.providers.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.data.base.Content;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PrimitiveContent<T> extends Content {
    private final T value;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<PrimitiveContent<?>> CREATOR = new Parcelable.Creator<PrimitiveContent<?>>() { // from class: com.stepos.core.data.PrimitiveContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrimitiveContent<?> createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return PrimitiveContent.Companion.createFromParcel(parcel, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrimitiveContent<?>[] newArray(int i10) {
            return new PrimitiveContent[i10];
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final Object readValue(Parcel parcel, int i10) {
            switch (i10) {
                case 100:
                    return Integer.valueOf(parcel.readInt());
                case 101:
                    return Long.valueOf(parcel.readLong());
                case 102:
                    return Float.valueOf(parcel.readFloat());
                case Content.Types.TYPE_DOUBLE /* 103 */:
                    return Double.valueOf(parcel.readDouble());
                case Content.Types.TYPE_BOOLEAN /* 104 */:
                    return Boolean.valueOf(parcel.readByte() != 0);
                case Content.Types.TYPE_STRING /* 105 */:
                    String string = parcel.readString();
                    return string == null ? "" : string;
                case Content.Types.TYPE_FLOAT_ARRAY /* 106 */:
                    float[] fArrCreateFloatArray = parcel.createFloatArray();
                    return fArrCreateFloatArray == null ? new float[0] : fArrCreateFloatArray;
                case Content.Types.TYPE_INT_ARRAY /* 107 */:
                    int[] iArrCreateIntArray = parcel.createIntArray();
                    return iArrCreateIntArray == null ? new int[0] : iArrCreateIntArray;
                case Content.Types.TYPE_DOUBLE_ARRAY /* 108 */:
                    double[] dArrCreateDoubleArray = parcel.createDoubleArray();
                    return dArrCreateDoubleArray == null ? new double[0] : dArrCreateDoubleArray;
                default:
                    throw new IllegalArgumentException(a.a(i10, "Unknown primitive type: "));
            }
        }

        public final <T> PrimitiveContent<T> createFromParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            PrimitiveContent<T> primitiveContent = new PrimitiveContent<>(readValue(parcel, i10), i10);
            ((Content) primitiveContent).params = contentParamsCreateFromParcel;
            return primitiveContent;
        }

        public final PrimitiveContent<Boolean> ofBoolean(boolean z) {
            return new PrimitiveContent<>(Boolean.valueOf(z), Content.Types.TYPE_BOOLEAN);
        }

        public final PrimitiveContent<Double> ofDouble(double d8) {
            return new PrimitiveContent<>(Double.valueOf(d8), Content.Types.TYPE_DOUBLE);
        }

        public final PrimitiveContent<double[]> ofDoubleArray(double[] value) {
            g.f(value, "value");
            return new PrimitiveContent<>(value, Content.Types.TYPE_DOUBLE_ARRAY);
        }

        public final PrimitiveContent<float[]> ofEmbedding(float[] value) {
            g.f(value, "value");
            return ofFloatArray(value);
        }

        public final PrimitiveContent<Float> ofFloat(float f8) {
            return new PrimitiveContent<>(Float.valueOf(f8), 102);
        }

        public final PrimitiveContent<float[]> ofFloatArray(float[] value) {
            g.f(value, "value");
            return new PrimitiveContent<>(value, Content.Types.TYPE_FLOAT_ARRAY);
        }

        public final PrimitiveContent<Integer> ofInt(int i10) {
            return new PrimitiveContent<>(Integer.valueOf(i10), 100);
        }

        public final PrimitiveContent<int[]> ofIntArray(int[] value) {
            g.f(value, "value");
            return new PrimitiveContent<>(value, Content.Types.TYPE_INT_ARRAY);
        }

        public final PrimitiveContent<Long> ofLong(long j10) {
            return new PrimitiveContent<>(Long.valueOf(j10), 101);
        }

        public final PrimitiveContent<String> ofString(String value) {
            g.f(value, "value");
            return new PrimitiveContent<>(value, Content.Types.TYPE_STRING);
        }

        public final <T> PrimitiveContent<T> readFieldsFromParcel(Parcel parcel, int i10) {
            g.f(parcel, "parcel");
            return new PrimitiveContent<>(readValue(parcel, i10), i10);
        }

        private Companion() {
        }
    }

    public PrimitiveContent(T t8, int i10) {
        super(i10);
        this.value = t8;
    }

    public static final <T> PrimitiveContent<T> readFieldsFromParcel(Parcel parcel, int i10) {
        return Companion.readFieldsFromParcel(parcel, i10);
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final T getValue() {
        return this.value;
    }

    public String toString() {
        return "PrimitiveContent(type=" + this.type + ", value=" + this.value + ")";
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        super.writeToParcel(parcel, i10);
        switch (this.type) {
            case 100:
                T t8 = this.value;
                g.d(t8, "null cannot be cast to non-null type kotlin.Int");
                parcel.writeInt(((Integer) t8).intValue());
                break;
            case 101:
                T t10 = this.value;
                g.d(t10, "null cannot be cast to non-null type kotlin.Long");
                parcel.writeLong(((Long) t10).longValue());
                break;
            case 102:
                T t11 = this.value;
                g.d(t11, "null cannot be cast to non-null type kotlin.Float");
                parcel.writeFloat(((Float) t11).floatValue());
                break;
            case Content.Types.TYPE_DOUBLE /* 103 */:
                T t12 = this.value;
                g.d(t12, "null cannot be cast to non-null type kotlin.Double");
                parcel.writeDouble(((Double) t12).doubleValue());
                break;
            case Content.Types.TYPE_BOOLEAN /* 104 */:
                T t13 = this.value;
                g.d(t13, "null cannot be cast to non-null type kotlin.Boolean");
                parcel.writeByte(((Boolean) t13).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case Content.Types.TYPE_STRING /* 105 */:
                T t14 = this.value;
                g.d(t14, "null cannot be cast to non-null type kotlin.String");
                parcel.writeString((String) t14);
                break;
            case Content.Types.TYPE_FLOAT_ARRAY /* 106 */:
                T t15 = this.value;
                g.d(t15, "null cannot be cast to non-null type kotlin.FloatArray");
                parcel.writeFloatArray((float[]) t15);
                break;
            case Content.Types.TYPE_INT_ARRAY /* 107 */:
                T t16 = this.value;
                g.d(t16, "null cannot be cast to non-null type kotlin.IntArray");
                parcel.writeIntArray((int[]) t16);
                break;
            case Content.Types.TYPE_DOUBLE_ARRAY /* 108 */:
                T t17 = this.value;
                g.d(t17, "null cannot be cast to non-null type kotlin.DoubleArray");
                parcel.writeDoubleArray((double[]) t17);
                break;
        }
    }
}
