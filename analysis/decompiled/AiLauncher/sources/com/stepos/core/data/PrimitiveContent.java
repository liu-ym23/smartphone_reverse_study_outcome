package com.stepos.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.core.data.base.Content;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u0016*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0016B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/core/data/PrimitiveContent;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/core/data/base/Content;", UxipConstants.f30680s, "", "type", "<init>", "(Ljava/lang/Object;I)V", "Landroid/os/Parcel;", "parcel", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "Companion", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PrimitiveContent<T> extends Content {
    private final T value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<PrimitiveContent<?>> CREATOR = new Parcelable.Creator<PrimitiveContent<?>>() { // from class: com.stepos.core.data.PrimitiveContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrimitiveContent<?> createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return PrimitiveContent.INSTANCE.createFromParcel(parcel, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrimitiveContent<?>[] newArray(int size) {
            return new PrimitiveContent[size];
        }
    };

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\u0007\u001a\u00020\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0007\u001a\u00020\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u0007\u001a\u00020\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0006\u0010\u0007\u001a\u00020\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\u0007\u001a\u00020\u0011J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u0007\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00052\u0006\u0010\u0007\u001a\u00020\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u0007\u001a\u00020\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u0007\u001a\u00020\u0013J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0005\"\u0004\b\u0001\u0010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0007J\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0005\"\u0004\b\u0001\u0010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006J\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002R\u001a\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050!8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/stepos/core/data/PrimitiveContent$Companion;", "", "<init>", "()V", "ofInt", "Lcom/stepos/core/data/PrimitiveContent;", "", UxipConstants.f30680s, "ofLong", "", "ofFloat", "", "ofDouble", "", "ofBoolean", "", "ofString", "", "ofFloatArray", "", "ofIntArray", "", "ofDoubleArray", "", "ofEmbedding", "readFieldsFromParcel", ExifInterface.GPS_DIRECTION_TRUE, "parcel", "Landroid/os/Parcel;", "type", "createFromParcel", "readValue", "CREATOR", "Landroid/os/Parcelable$Creator;", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private final Object readValue(Parcel parcel, int type) {
            switch (type) {
                case 100:
                    return Integer.valueOf(parcel.readInt());
                case 101:
                    return Long.valueOf(parcel.readLong());
                case 102:
                    return Float.valueOf(parcel.readFloat());
                case 103:
                    return Double.valueOf(parcel.readDouble());
                case 104:
                    return Boolean.valueOf(parcel.readByte() != 0);
                case 105:
                    String string = parcel.readString();
                    return string == null ? "" : string;
                case 106:
                    float[] fArrCreateFloatArray = parcel.createFloatArray();
                    return fArrCreateFloatArray == null ? new float[0] : fArrCreateFloatArray;
                case 107:
                    int[] iArrCreateIntArray = parcel.createIntArray();
                    return iArrCreateIntArray == null ? new int[0] : iArrCreateIntArray;
                case 108:
                    double[] dArrCreateDoubleArray = parcel.createDoubleArray();
                    return dArrCreateDoubleArray == null ? new double[0] : dArrCreateDoubleArray;
                default:
                    throw new IllegalArgumentException("Unknown primitive type: " + type);
            }
        }

        public final <T> PrimitiveContent<T> createFromParcel(Parcel parcel, int type) {
            p.i(parcel, "parcel");
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            PrimitiveContent<T> primitiveContent = new PrimitiveContent<>(readValue(parcel, type), type);
            ((Content) primitiveContent).params = contentParamsCreateFromParcel;
            return primitiveContent;
        }

        public final PrimitiveContent<Boolean> ofBoolean(boolean value) {
            return new PrimitiveContent<>(Boolean.valueOf(value), 104);
        }

        public final PrimitiveContent<Double> ofDouble(double value) {
            return new PrimitiveContent<>(Double.valueOf(value), 103);
        }

        public final PrimitiveContent<double[]> ofDoubleArray(double[] value) {
            p.i(value, "value");
            return new PrimitiveContent<>(value, 108);
        }

        public final PrimitiveContent<float[]> ofEmbedding(float[] value) {
            p.i(value, "value");
            return ofFloatArray(value);
        }

        public final PrimitiveContent<Float> ofFloat(float value) {
            return new PrimitiveContent<>(Float.valueOf(value), 102);
        }

        public final PrimitiveContent<float[]> ofFloatArray(float[] value) {
            p.i(value, "value");
            return new PrimitiveContent<>(value, 106);
        }

        public final PrimitiveContent<Integer> ofInt(int value) {
            return new PrimitiveContent<>(Integer.valueOf(value), 100);
        }

        public final PrimitiveContent<int[]> ofIntArray(int[] value) {
            p.i(value, "value");
            return new PrimitiveContent<>(value, 107);
        }

        public final PrimitiveContent<Long> ofLong(long value) {
            return new PrimitiveContent<>(Long.valueOf(value), 101);
        }

        public final PrimitiveContent<String> ofString(String value) {
            p.i(value, "value");
            return new PrimitiveContent<>(value, 105);
        }

        public final <T> PrimitiveContent<T> readFieldsFromParcel(Parcel parcel, int type) {
            p.i(parcel, "parcel");
            return new PrimitiveContent<>(readValue(parcel, type), type);
        }

        private Companion() {
        }
    }

    public PrimitiveContent(T t10, int i10) {
        super(i10);
        this.value = t10;
    }

    public static final <T> PrimitiveContent<T> readFieldsFromParcel(Parcel parcel, int i10) {
        return INSTANCE.readFieldsFromParcel(parcel, i10);
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
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        switch (this.type) {
            case 100:
                T t10 = this.value;
                p.g(t10, "null cannot be cast to non-null type kotlin.Int");
                parcel.writeInt(((Integer) t10).intValue());
                break;
            case 101:
                T t11 = this.value;
                p.g(t11, "null cannot be cast to non-null type kotlin.Long");
                parcel.writeLong(((Long) t11).longValue());
                break;
            case 102:
                T t12 = this.value;
                p.g(t12, "null cannot be cast to non-null type kotlin.Float");
                parcel.writeFloat(((Float) t12).floatValue());
                break;
            case 103:
                T t13 = this.value;
                p.g(t13, "null cannot be cast to non-null type kotlin.Double");
                parcel.writeDouble(((Double) t13).doubleValue());
                break;
            case 104:
                T t14 = this.value;
                p.g(t14, "null cannot be cast to non-null type kotlin.Boolean");
                parcel.writeByte(((Boolean) t14).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 105:
                T t15 = this.value;
                p.g(t15, "null cannot be cast to non-null type kotlin.String");
                parcel.writeString((String) t15);
                break;
            case 106:
                T t16 = this.value;
                p.g(t16, "null cannot be cast to non-null type kotlin.FloatArray");
                parcel.writeFloatArray((float[]) t16);
                break;
            case 107:
                T t17 = this.value;
                p.g(t17, "null cannot be cast to non-null type kotlin.IntArray");
                parcel.writeIntArray((int[]) t17);
                break;
            case 108:
                T t18 = this.value;
                p.g(t18, "null cannot be cast to non-null type kotlin.DoubleArray");
                parcel.writeDoubleArray((double[]) t18);
                break;
        }
    }
}
