package android.view.compose.serialization.serializers;

import A9.e;
import A9.f;
import B9.H;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import x9.b;
import z2.l;
import z9.g;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003B#\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R&\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00130\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u00020\u00168\u0016X\u0096\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Landroidx/savedstate/compose/serialization/serializers/SnapshotStateMapSerializer;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lx9/b;", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "keySerializer", "valueSerializer", AppAgent.CONSTRUCT, "(Lx9/b;Lx9/b;)V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "", "base", "Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "getDescriptor$annotations", "()V", "savedstate-compose_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SnapshotStateMapSerializer<K, V> implements b {
    private final b base;
    private final g descriptor;

    public SnapshotStateMapSerializer(b keySerializer, b valueSerializer) {
        k.f(keySerializer, "keySerializer");
        k.f(valueSerializer, "valueSerializer");
        H h = new H(keySerializer, valueSerializer);
        this.base = h;
        this.descriptor = l.b("androidx.compose.runtime.SnapshotStateMap", h.c);
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    @Override // x9.f, x9.InterfaceC2123a
    public g getDescriptor() {
        return this.descriptor;
    }

    @Override // x9.InterfaceC2123a
    public SnapshotStateMap<K, V> deserialize(e decoder) {
        k.f(decoder, "decoder");
        Map<? extends K, ? extends V> map = (Map) decoder.decodeSerializableValue(this.base);
        SnapshotStateMap<K, V> snapshotStateMap = new SnapshotStateMap<>();
        snapshotStateMap.putAll(map);
        return snapshotStateMap;
    }

    @Override // x9.f
    public void serialize(f encoder, SnapshotStateMap<K, V> value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        encoder.encodeSerializableValue(this.base, value);
    }
}
