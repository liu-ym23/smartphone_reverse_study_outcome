package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.q;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class y0 extends z0<Object, Object> {
    @Override // androidx.datastore.preferences.protobuf.z0
    public final void g() {
        if (!this.f1910d) {
            for (int i10 = 0; i10 < this.f1908b.size(); i10++) {
                ((q.a) c(i10).getKey()).getClass();
            }
            Iterator<Map.Entry<Object, Object>> it = e().iterator();
            while (it.hasNext()) {
                ((q.a) it.next().getKey()).getClass();
            }
        }
        super.g();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return h((q.a) obj, obj2);
    }
}
