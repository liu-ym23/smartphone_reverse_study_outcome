package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3493a;

    public ViewModelStore() {
        this.f3493a = new LinkedHashMap();
    }

    public final void a() {
        Iterator r10 = this.f3493a.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((k0) r10.next()).a();
        goto L4
    L6:
        this.f3493a.clear();
    }

    public final k0 b(String r10) {
        kotlin.jvm.internal.q.g(r10, "key");
        return (k0) this.f3493a.get(r10);
    }

    public final Set c() {
        return new HashSet(this.f3493a.keySet());
    }

    public final void d(String r10, k0 r11) {
        kotlin.jvm.internal.q.g(r10, "key");
        kotlin.jvm.internal.q.g(r11, "viewModel");
        k0 r12 = (k0) this.f3493a.put(r10, r11);
        if (r12 == null) goto L6;
        r12.d();
        return;
    }
}
