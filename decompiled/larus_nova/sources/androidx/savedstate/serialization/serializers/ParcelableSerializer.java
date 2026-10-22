package androidx.savedstate.serialization.serializers;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import luc.f;
import luc.n;
import muc.e;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Landroidx/savedstate/serialization/serializers/ParcelableSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "Lkotlinx/serialization/KSerializer;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Landroid/os/Parcelable;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Landroid/os/Parcelable;", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ParcelableSerializer<T extends Parcelable> implements d<T> {
    private final f descriptor;

    public ParcelableSerializer() {
        this.descriptor = n.d("android.os.Parcelable", new f[0]);
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return this.descriptor;
    }

    @Override // juc.c
    public final T deserialize(e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        if ((r100 instanceof SavedStateDecoder) == false) goto L7;
        SavedStateDecoder r101 = (SavedStateDecoder) r100;
        T r102 = (T) SavedStateReader.m7877getParcelableimpl(SavedStateReader.m7831constructorimpl(r101.getSavedState$savedstate()), r101.getKey$savedstate(), Reflection.getOrCreateKotlinClass(Parcelable.class));
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type T of androidx.savedstate.serialization.serializers.ParcelableSerializer");
        return r102;
    L7:
        throw new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(this.descriptor.f(), r100).toString());
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public final void serialize(muc.f r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        if ((r100 instanceof SavedStateEncoder) == false) goto L7;
        SavedStateEncoder r102 = (SavedStateEncoder) r100;
        SavedStateWriter.m7941putParcelableimpl(SavedStateWriter.m7917constructorimpl(r102.getSavedState$savedstate()), r102.getKey$savedstate(), r101);
        return;
    L7:
        throw new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(this.descriptor.f(), r100).toString());
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (Parcelable) r101);
    }
}
