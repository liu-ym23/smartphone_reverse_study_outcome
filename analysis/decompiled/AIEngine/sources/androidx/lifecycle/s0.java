package androidx.lifecycle;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2318a = new LinkedHashMap();

    public final void a() {
        LinkedHashMap linkedHashMap = this.f2318a;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((q0) it.next()).a();
        }
        linkedHashMap.clear();
    }
}
