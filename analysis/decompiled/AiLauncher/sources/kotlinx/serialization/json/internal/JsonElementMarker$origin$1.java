package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.p;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements p<SerialDescriptor, Integer, Boolean> {
    public JsonElementMarker$origin$1(Object obj) {
        super(2, obj, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Boolean invoke(SerialDescriptor serialDescriptor, Integer num) {
        return l(serialDescriptor, num.intValue());
    }

    public final Boolean l(SerialDescriptor p02, int i10) {
        kotlin.jvm.internal.p.i(p02, "p0");
        return Boolean.valueOf(((JsonElementMarker) this.receiver).e(p02, i10));
    }
}
