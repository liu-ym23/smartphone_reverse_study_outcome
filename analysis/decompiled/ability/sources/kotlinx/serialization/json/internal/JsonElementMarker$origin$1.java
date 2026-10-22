package kotlinx.serialization.json.internal;

import S7.n;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.k;
import z9.g;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final /* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements n {
    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        g p02 = (g) obj;
        int iIntValue = ((Number) obj2).intValue();
        k.f(p02, "p0");
        a aVar = (a) this.receiver;
        aVar.getClass();
        boolean z10 = !p02.i(iIntValue) && p02.g(iIntValue).b();
        aVar.b = z10;
        return Boolean.valueOf(z10);
    }
}
