package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4960m;
import nb.C4948a;
import nb.C4958k;
import p9.InterfaceC5074l;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003:\u0001\u0017B#\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\n\u001a\u00028\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u000b\u001a\u00028\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0018"}, d2 = {"Lpb/k0;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lpb/a0;", "", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "key", UxipConstants.f30680s, "k", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "c", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/Map$Entry;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_APIKEY, "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.k0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5105k0<K, V> extends AbstractC5085a0<K, V, Map.Entry<? extends K, ? extends V>> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final SerialDescriptor descriptor;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00028\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00028\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lpb/k0$a;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "key", UxipConstants.f30680s, "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "getValue", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: pb.k0$a, reason: from toString */
    public static final /* data */ class MapEntry<K, V> implements Map.Entry<K, V>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final K key;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final V value;

        public MapEntry(K k10, V v10) {
            this.key = k10;
            this.value = v10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MapEntry)) {
                return false;
            }
            MapEntry mapEntry = (MapEntry) other;
            return kotlin.jvm.internal.p.d(this.key, mapEntry.key) && kotlin.jvm.internal.p.d(this.value, mapEntry.value);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.key;
            int iHashCode = (k10 == null ? 0 : k10.hashCode()) * 31;
            V v10 = this.value;
            return iHashCode + (v10 != null ? v10.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public String toString() {
            return "MapEntry(key=" + this.key + ", value=" + this.value + ')';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5105k0(final KSerializer<K> keySerializer, final KSerializer<V> valueSerializer) {
        super(keySerializer, valueSerializer, null);
        kotlin.jvm.internal.p.i(keySerializer, "keySerializer");
        kotlin.jvm.internal.p.i(valueSerializer, "valueSerializer");
        this.descriptor = C4958k.g("kotlin.collections.Map.Entry", AbstractC4960m.c.f37295a, new SerialDescriptor[0], new InterfaceC5074l() { // from class: pb.j0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C5105k0.h(keySerializer, valueSerializer, (C4948a) obj);
            }
        });
    }

    public static final Y8.t h(KSerializer kSerializer, KSerializer kSerializer2, C4948a buildSerialDescriptor) {
        kotlin.jvm.internal.p.i(buildSerialDescriptor, "$this$buildSerialDescriptor");
        C4948a.b(buildSerialDescriptor, "key", kSerializer.getDescriptor(), null, false, 12, null);
        C4948a.b(buildSerialDescriptor, UxipConstants.f30680s, kSerializer2.getDescriptor(), null, false, 12, null);
        return Y8.t.f7040a;
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // pb.AbstractC5085a0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public K b(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.p.i(entry, "<this>");
        return entry.getKey();
    }

    @Override // pb.AbstractC5085a0
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public V d(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.p.i(entry, "<this>");
        return entry.getValue();
    }

    @Override // pb.AbstractC5085a0
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> f(K key, V value) {
        return new MapEntry(key, value);
    }
}
