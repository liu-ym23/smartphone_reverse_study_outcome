package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.g;
import rc.e;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public /* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements p<e, Integer, Boolean> {
    @Override // zb.p
    public final Boolean invoke(e eVar, Integer num) {
        e p02 = eVar;
        int iIntValue = num.intValue();
        g.f(p02, "p0");
        JsonElementMarker jsonElementMarker = (JsonElementMarker) this.receiver;
        jsonElementMarker.getClass();
        boolean z = !p02.j(iIntValue) && p02.h(iIntValue).b();
        jsonElementMarker.f10126b = z;
        return Boolean.valueOf(z);
    }
}
