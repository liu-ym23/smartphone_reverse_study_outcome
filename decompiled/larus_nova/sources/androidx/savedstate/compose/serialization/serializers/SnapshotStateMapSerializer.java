package androidx.savedstate.compose.serialization.serializers;

import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Map;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kuc.a;
import luc.f;
import luc.n;
import muc.e;
import nuc.a1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B#\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Landroidx/savedstate/compose/serialization/serializers/SnapshotStateMapSerializer;", "K", "V", "Lkotlinx/serialization/KSerializer;", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "base", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "()V", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "savedstate-compose"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotStateMapSerializer<K, V> implements d<SnapshotStateMap<K, V>> {
    private final d<Map<K, V>> base;
    private final f descriptor;

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    @Override // juc.d, juc.n, juc.c
    public f getDescriptor() {
        return this.descriptor;
    }

    @Override // juc.c
    public SnapshotStateMap<K, V> deserialize(e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Map<? extends K, ? extends V> r101 = (Map) r100.decodeSerializableValue(this.base);
        SnapshotStateMap<K, V> r102 = new SnapshotStateMap();
        r102.putAll(r101);
        return r102;
    }

    @Override // juc.c
    public /* bridge */ /* synthetic */ Object deserialize(e r100) {
        return deserialize(r100);
    }

    public SnapshotStateMapSerializer(d<K> r100, d<V> r101) {
        Intrinsics.checkNotNullParameter(r100, "keySerializer");
        Intrinsics.checkNotNullParameter(r101, "valueSerializer");
        a1 r102 = a.c(r100, r101);
        this.base = r102;
        this.descriptor = n.b("androidx.compose.runtime.SnapshotStateMap", r102.f520641c);
    }

    public void serialize(muc.f r100, SnapshotStateMap<K, V> r101) {
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.encodeSerializableValue(this.base, r101);
    }

    @Override // juc.n
    public /* bridge */ /* synthetic */ void serialize(muc.f r100, Object r101) {
        serialize(r100, (SnapshotStateMap) r101);
    }
}
