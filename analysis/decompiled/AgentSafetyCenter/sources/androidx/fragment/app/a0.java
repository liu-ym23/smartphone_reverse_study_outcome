package androidx.fragment.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f1248a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f1249b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f1250c;

    /* renamed from: d, reason: collision with root package name */
    public y f1251d;

    public final void a() {
        Iterator it = this.f1249b.values().iterator();
        while (it.hasNext()) {
            w2.c.d(it.next());
        }
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f1249b.values().iterator();
        while (it.hasNext()) {
            w2.c.d(it.next());
        }
        return arrayList;
    }

    public final List c() {
        ArrayList arrayList;
        if (this.f1248a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f1248a) {
            arrayList = new ArrayList(this.f1248a);
        }
        return arrayList;
    }
}
