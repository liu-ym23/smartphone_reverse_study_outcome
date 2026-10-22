package android.view.serialization;

import A9.e;
import M.a;
import Z7.d;
import android.os.Parcelable;
import android.view.serialization.serializers.CharSequenceArraySerializer;
import android.view.serialization.serializers.CharSequenceListSerializer;
import android.view.serialization.serializers.CharSequenceSerializer;
import android.view.serialization.serializers.DefaultJavaSerializableSerializer;
import android.view.serialization.serializers.DefaultParcelableSerializer;
import android.view.serialization.serializers.IBinderSerializer;
import android.view.serialization.serializers.ParcelableArraySerializer;
import android.view.serialization.serializers.ParcelableListSerializer;
import android.view.serialization.serializers.SparseParcelableArraySerializer;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import x9.InterfaceC2123a;
import z9.g;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a)\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\n\u001a\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b0\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/savedstate/serialization/SavedStateDecoder;", "Lx9/a;", "strategy", "decodeFormatSpecificTypesOnPlatform", "(Landroidx/savedstate/serialization/SavedStateDecoder;Lx9/a;)Ljava/lang/Object;", "referenceArraySerializer", "LZ7/d;", "", "", "getArrayKClass", "(Lx9/a;)LZ7/d;", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateDecoder_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T decodeFormatSpecificTypesOnPlatform(SavedStateDecoder savedStateDecoder, InterfaceC2123a strategy) {
        k.f(savedStateDecoder, "<this>");
        k.f(strategy, "strategy");
        g descriptor = strategy.getDescriptor();
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            return (T) CharSequenceSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
            return (T) DefaultParcelableSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
            return (T) DefaultJavaSerializableSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
            return (T) IBinderSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor()) || k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
            return (T) CharSequenceArraySerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor()) || k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
            return (T) CharSequenceListSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor())) {
            Parcelable[] parcelableArrDeserialize = ParcelableArraySerializer.INSTANCE.deserialize((e) savedStateDecoder);
            return (T) Arrays.copyOf(parcelableArrDeserialize, parcelableArrDeserialize.length, a.Z(getArrayKClass(strategy)));
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
            return (T) ParcelableArraySerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getParcelableListDescriptor()) || k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
            return (T) ParcelableListSerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) || k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor()) || k.b(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
            return (T) SparseParcelableArraySerializer.INSTANCE.deserialize((e) savedStateDecoder);
        }
        return null;
    }

    private static final d getArrayKClass(InterfaceC2123a interfaceC2123a) {
        Object objDeserialize = interfaceC2123a.deserialize(EmptyArrayDecoder.INSTANCE);
        k.c(objDeserialize);
        return m.f4928a.b(objDeserialize.getClass());
    }
}
