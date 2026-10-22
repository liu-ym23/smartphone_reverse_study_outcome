package d5;

import android.os.Parcel;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.location.LocationRequestCompat;
import java.io.Serializable;

/* loaded from: classes3.dex */
public final class s {
    /* JADX WARN: Type inference failed for: r1v13, types: [float[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v14, types: [float[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v17, types: [double[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v18, types: [double[], java.io.Serializable] */
    public static Serializable a(Parcel parcel, int i) {
        switch (i) {
            case 100:
                return Integer.valueOf(parcel.readInt());
            case 101:
                return Long.valueOf(parcel.readLong());
            case 102:
                return Float.valueOf(parcel.readFloat());
            case v7.o.META_DATA_FIELD_NUMBER /* 103 */:
                return Double.valueOf(parcel.readDouble());
            case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                return Boolean.valueOf(parcel.readByte() != 0);
            case 105:
                String string = parcel.readString();
                return string == null ? "" : string;
            case 106:
                ?? CreateFloatArray = parcel.createFloatArray();
                return CreateFloatArray == 0 ? new float[0] : CreateFloatArray;
            case 107:
                ?? CreateIntArray = parcel.createIntArray();
                return CreateIntArray == 0 ? new int[0] : CreateIntArray;
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                ?? CreateDoubleArray = parcel.createDoubleArray();
                return CreateDoubleArray == 0 ? new double[0] : CreateDoubleArray;
            default:
                throw new IllegalArgumentException(B7.a.h(i, "Unknown primitive type: "));
        }
    }
}
