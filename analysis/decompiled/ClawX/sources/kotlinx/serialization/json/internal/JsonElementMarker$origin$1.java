package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.n;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class JsonElementMarker$origin$1 extends n implements p {
    public JsonElementMarker$origin$1(Object obj) {
        super(2, obj, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    public final Boolean invoke(SerialDescriptor p02, int i8) {
        kotlin.jvm.internal.p.e(p02, "p0");
        return Boolean.valueOf(((JsonElementMarker) this.receiver).readIfAbsent(p02, i8));
    }

    @Override // p5.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((SerialDescriptor) obj, ((Number) obj2).intValue());
    }
}
