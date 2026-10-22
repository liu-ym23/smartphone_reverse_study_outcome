package com.stepos.core.data;

import L.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.core.data.base.Content;
import d5.s;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import v7.o;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u0016*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/stepos/core/data/PrimitiveContent;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/core/data/base/Content;", "value", "", "type", AppAgent.CONSTRUCT, "(Ljava/lang/Object;I)V", "Landroid/os/Parcel;", "parcel", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "Companion", "d5/s", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PrimitiveContent<T> extends Content {
    private final T value;
    public static final s Companion = new s();
    public static final Parcelable.Creator<PrimitiveContent<?>> CREATOR = new g(18);

    public PrimitiveContent(T t9, int i) {
        super(i);
        this.value = t9;
    }

    public static final <T> PrimitiveContent<T> readFieldsFromParcel(Parcel parcel, int i) {
        Companion.getClass();
        k.f(parcel, "parcel");
        return new PrimitiveContent<>(s.a(parcel, i), i);
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
        k.f(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        switch (this.type) {
            case 100:
                T t9 = this.value;
                k.d(t9, "null cannot be cast to non-null type kotlin.Int");
                parcel.writeInt(((Integer) t9).intValue());
                break;
            case 101:
                T t10 = this.value;
                k.d(t10, "null cannot be cast to non-null type kotlin.Long");
                parcel.writeLong(((Long) t10).longValue());
                break;
            case 102:
                T t11 = this.value;
                k.d(t11, "null cannot be cast to non-null type kotlin.Float");
                parcel.writeFloat(((Float) t11).floatValue());
                break;
            case o.META_DATA_FIELD_NUMBER /* 103 */:
                T t12 = this.value;
                k.d(t12, "null cannot be cast to non-null type kotlin.Double");
                parcel.writeDouble(((Double) t12).doubleValue());
                break;
            case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                T t13 = this.value;
                k.d(t13, "null cannot be cast to non-null type kotlin.Boolean");
                parcel.writeByte(((Boolean) t13).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 105:
                T t14 = this.value;
                k.d(t14, "null cannot be cast to non-null type kotlin.String");
                parcel.writeString((String) t14);
                break;
            case 106:
                T t15 = this.value;
                k.d(t15, "null cannot be cast to non-null type kotlin.FloatArray");
                parcel.writeFloatArray((float[]) t15);
                break;
            case 107:
                T t16 = this.value;
                k.d(t16, "null cannot be cast to non-null type kotlin.IntArray");
                parcel.writeIntArray((int[]) t16);
                break;
            case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                T t17 = this.value;
                k.d(t17, "null cannot be cast to non-null type kotlin.DoubleArray");
                parcel.writeDoubleArray((double[]) t17);
                break;
        }
    }
}
