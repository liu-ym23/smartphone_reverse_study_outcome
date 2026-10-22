package androidx.savedstate.compose.serialization.serializers;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import juc.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kuc.a;
import luc.f;
import luc.n;
import muc.e;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Landroidx/savedstate/compose/serialization/serializers/SnapshotStateListSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/KSerializer;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "elementSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "base", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "()V", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "savedstate-compose"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotStateListSerializer<T> implements d<SnapshotStateList<T>> {
    private final d<List<T>> base;
    private final f descriptor;
    private final d<T> elementSerializer;

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    @Override // juc.d, juc.n, juc.c
    public f getDescriptor() {
        return this.descriptor;
    }

    public SnapshotStateListSerializer(d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "elementSerializer");
        this.elementSerializer = r100;
        nuc.f r101 = a.b(r100);
        this.base = r101;
        this.descriptor = n.b("androidx.compose.runtime.SnapshotStateList", r101.f520671b);
    }

    @Override // juc.c
    public SnapshotStateList<T> deserialize(e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        List r101 = (List) r100.decodeSerializableValue(this.base);
        SnapshotStateList<T> r102 = new SnapshotStateList();
        r102.addAll(CollectionsKt.toList(r101));
        return r102;
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public void serialize(muc.f r100, SnapshotStateList<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.encodeSerializableValue(this.base, r101);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (SnapshotStateList) r101);
    }
}
