package fc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o implements i<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i<Object> f8827a;

    public o(i<Object> iVar) {
        this.f8827a = iVar;
    }

    @Override // fc.i
    public final Iterator<Object> iterator() {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = this.f8827a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList.iterator();
    }
}
