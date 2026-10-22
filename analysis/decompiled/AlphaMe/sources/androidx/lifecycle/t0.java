package androidx.lifecycle;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3982a = new LinkedHashMap();

    public final void a() {
        LinkedHashMap linkedHashMap = this.f3982a;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((n0) it.next()).clear();
        }
        linkedHashMap.clear();
    }
}
