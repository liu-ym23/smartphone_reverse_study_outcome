package androidx.savedstate.serialization.serializers;

import androidx.exifinterface.media.ExifInterface;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import luc.e;
import luc.f;
import luc.n;
import luc.o;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Landroidx/savedstate/serialization/serializers/MutableStateFlowSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/KSerializer;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "()V", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableStateFlowSerializer<T> implements d<z0<T>> {
    private final f descriptor;
    private final d<T> valueSerializer;

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    @Override // juc.d, juc.n, juc.c
    public f getDescriptor() {
        return this.descriptor;
    }

    public MutableStateFlowSerializer(d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "valueSerializer");
        this.valueSerializer = r100;
        o r101 = r100.getDescriptor().getKind();
        if ((r101 instanceof e) == false) goto L5;
        f r102 = n.a("kotlinx.coroutines.flow.MutableStateFlow", (e) r101);
    L6:
        this.descriptor = r102;
        return;
    L5:
        r102 = n.b("kotlinx.coroutines.flow.MutableStateFlow", r100.getDescriptor());
        goto L6
    }

    @Override // juc.c
    public z0<T> deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return j1.a(r100.decodeSerializableValue(this.valueSerializer));
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(muc.e r100) {
        return deserialize(r100);
    }

    public void serialize(muc.f r100, z0<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.encodeSerializableValue(this.valueSerializer, r101.getValue());
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (z0) r101);
    }
}
