package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.C4948a;
import nb.C4958k;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003B#\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\n\u001a\u00028\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u000b\u001a\u00028\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lpb/z0;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lpb/a0;", "Lkotlin/Pair;", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "key", UxipConstants.f30680s, "k", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "c", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lkotlin/Pair;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.z0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5134z0<K, V> extends AbstractC5085a0<K, V, Pair<? extends K, ? extends V>> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final SerialDescriptor descriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5134z0(final KSerializer<K> keySerializer, final KSerializer<V> valueSerializer) {
        super(keySerializer, valueSerializer, null);
        kotlin.jvm.internal.p.i(keySerializer, "keySerializer");
        kotlin.jvm.internal.p.i(valueSerializer, "valueSerializer");
        this.descriptor = C4958k.d("kotlin.Pair", new SerialDescriptor[0], new InterfaceC5074l() { // from class: pb.y0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C5134z0.h(keySerializer, valueSerializer, (C4948a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t h(KSerializer kSerializer, KSerializer kSerializer2, C4948a buildClassSerialDescriptor) {
        kotlin.jvm.internal.p.i(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        C4948a.b(buildClassSerialDescriptor, AMapLocationStaticsEntity.FIRST_LOCATE, kSerializer.getDescriptor(), null, false, 12, null);
        C4948a.b(buildClassSerialDescriptor, "second", kSerializer2.getDescriptor(), null, false, 12, null);
        return Y8.t.f7040a;
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // pb.AbstractC5085a0
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public K b(Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.p.i(pair, "<this>");
        return pair.e();
    }

    @Override // pb.AbstractC5085a0
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public V d(Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.p.i(pair, "<this>");
        return pair.f();
    }

    @Override // pb.AbstractC5085a0
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Pair<K, V> f(K key, V value) {
        return Y8.j.a(key, value);
    }
}
