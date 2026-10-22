package pb;

import androidx.exifinterface.media.ExifInterface;
import io.ktor.http.ContentDisposition;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010&\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022B\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00060\u0003B#\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00100\u000f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0015\u001a\u00020\f*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J;\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010\u001d\u001a\u00020\u001c*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u001b\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010$\u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lpb/O;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lpb/m0;", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Lkotlinx/serialization/KSerializer;", "kSerializer", "vSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "", "v", "(Ljava/util/Map;)I", "", "", "u", "(Ljava/util/Map;)Ljava/util/Iterator;", "r", "()Ljava/util/HashMap;", "s", "(Ljava/util/HashMap;)I", "x", "(Ljava/util/HashMap;)Ljava/util/Map;", "w", "(Ljava/util/Map;)Ljava/util/HashMap;", ContentDisposition.Parameters.Size, "LY8/t;", "t", "(Ljava/util/HashMap;I)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "c", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class O<K, V> extends AbstractC5109m0<K, V, Map<K, ? extends V>, HashMap<K, V>> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final SerialDescriptor descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(KSerializer<K> kSerializer, KSerializer<V> vSerializer) {
        super(kSerializer, vSerializer, null);
        kotlin.jvm.internal.p.i(kSerializer, "kSerializer");
        kotlin.jvm.internal.p.i(vSerializer, "vSerializer");
        this.descriptor = new N(kSerializer.getDescriptor(), vSerializer.getDescriptor());
    }

    @Override // pb.AbstractC5109m0, kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // pb.AbstractC5084a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public HashMap<K, V> b() {
        return new HashMap<>();
    }

    @Override // pb.AbstractC5084a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public int c(HashMap<K, V> map) {
        kotlin.jvm.internal.p.i(map, "<this>");
        return map.size() * 2;
    }

    @Override // pb.AbstractC5084a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void d(HashMap<K, V> map, int i10) {
        kotlin.jvm.internal.p.i(map, "<this>");
    }

    @Override // pb.AbstractC5084a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public Iterator<Map.Entry<K, V>> e(Map<K, ? extends V> map) {
        kotlin.jvm.internal.p.i(map, "<this>");
        return map.entrySet().iterator();
    }

    @Override // pb.AbstractC5084a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public int f(Map<K, ? extends V> map) {
        kotlin.jvm.internal.p.i(map, "<this>");
        return map.size();
    }

    @Override // pb.AbstractC5084a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public HashMap<K, V> l(Map<K, ? extends V> map) {
        kotlin.jvm.internal.p.i(map, "<this>");
        HashMap<K, V> map2 = map instanceof HashMap ? (HashMap) map : null;
        return map2 == null ? new HashMap<>(map) : map2;
    }

    @Override // pb.AbstractC5084a
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Map<K, V> m(HashMap<K, V> map) {
        kotlin.jvm.internal.p.i(map, "<this>");
        return map;
    }
}
