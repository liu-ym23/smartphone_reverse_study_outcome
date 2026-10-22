package androidx.lifecycle;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashMap f1366a;

    public final void a() {
        LinkedHashMap linkedHashMap = this.f1366a;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((y0) it.next()).b();
        }
        linkedHashMap.clear();
    }
}
