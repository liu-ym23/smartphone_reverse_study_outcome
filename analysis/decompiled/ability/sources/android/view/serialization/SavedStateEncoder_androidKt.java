package android.view.serialization;

import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import x9.f;
import z9.g;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a/\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/savedstate/serialization/SavedStateEncoder;", "Lx9/f;", "strategy", "value", "", "encodeFormatSpecificTypesOnPlatform", "(Landroidx/savedstate/serialization/SavedStateEncoder;Lx9/f;Ljava/lang/Object;)Z", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavedStateEncoder_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean encodeFormatSpecificTypesOnPlatform(SavedStateEncoder savedStateEncoder, f strategy, T t9) {
        k.f(savedStateEncoder, "<this>");
        k.f(strategy, "strategy");
        g descriptor = strategy.getDescriptor();
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceDescriptor())) {
            CharSequenceSerializer charSequenceSerializer = CharSequenceSerializer.INSTANCE;
            k.d(t9, "null cannot be cast to non-null type kotlin.CharSequence");
            charSequenceSerializer.serialize((A9.f) savedStateEncoder, (CharSequence) t9);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableDescriptor())) {
            DefaultParcelableSerializer defaultParcelableSerializer = DefaultParcelableSerializer.INSTANCE;
            k.d(t9, "null cannot be cast to non-null type android.os.Parcelable");
            defaultParcelableSerializer.serialize((A9.f) savedStateEncoder, (SavedStateEncoder) t9);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicJavaSerializableDescriptor())) {
            DefaultJavaSerializableSerializer defaultJavaSerializableSerializer = DefaultJavaSerializableSerializer.INSTANCE;
            k.d(t9, "null cannot be cast to non-null type java.io.Serializable");
            defaultJavaSerializableSerializer.serialize((A9.f) savedStateEncoder, (SavedStateEncoder) t9);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicIBinderDescriptor())) {
            IBinderSerializer iBinderSerializer = IBinderSerializer.INSTANCE;
            k.d(t9, "null cannot be cast to non-null type android.os.IBinder");
            iBinderSerializer.serialize((A9.f) savedStateEncoder, (IBinder) t9);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceArrayDescriptor()) || k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceArrayDescriptor())) {
            CharSequenceArraySerializer charSequenceArraySerializer = CharSequenceArraySerializer.INSTANCE;
            k.d(t9, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
            charSequenceArraySerializer.serialize((A9.f) savedStateEncoder, (CharSequence[]) t9);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getCharSequenceListDescriptor()) || k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicCharSequenceListDescriptor())) {
            CharSequenceListSerializer charSequenceListSerializer = CharSequenceListSerializer.INSTANCE;
            k.d(t9, "null cannot be cast to non-null type kotlin.collections.List<kotlin.CharSequence>");
            charSequenceListSerializer.serialize((A9.f) savedStateEncoder, (List<? extends CharSequence>) t9);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getParcelableArrayDescriptor()) || k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableArrayDescriptor())) {
            ParcelableArraySerializer parcelableArraySerializer = ParcelableArraySerializer.INSTANCE;
            k.d(t9, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
            parcelableArraySerializer.serialize((A9.f) savedStateEncoder, (Parcelable[]) t9);
            return true;
        }
        if (k.b(descriptor, SavedStateCodecUtils_androidKt.getParcelableListDescriptor()) || k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicParcelableListDescriptor())) {
            ParcelableListSerializer parcelableListSerializer = ParcelableListSerializer.INSTANCE;
            k.d(t9, "null cannot be cast to non-null type kotlin.collections.List<android.os.Parcelable>");
            parcelableListSerializer.serialize((A9.f) savedStateEncoder, (List<? extends Parcelable>) t9);
            return true;
        }
        if (!k.b(descriptor, SavedStateCodecUtils_androidKt.getSparseParcelableArrayDescriptor()) && !k.b(descriptor, SavedStateCodecUtils_androidKt.getPolymorphicSparseParcelableArrayDescriptor()) && !k.b(descriptor, SavedStateCodecUtils_androidKt.getNullablePolymorphicSparseParcelableArrayDescriptor())) {
            return false;
        }
        SparseParcelableArraySerializer sparseParcelableArraySerializer = SparseParcelableArraySerializer.INSTANCE;
        k.d(t9, "null cannot be cast to non-null type android.util.SparseArray<android.os.Parcelable>");
        sparseParcelableArraySerializer.serialize((A9.f) savedStateEncoder, (SparseArray<Parcelable>) t9);
        return true;
    }
}
