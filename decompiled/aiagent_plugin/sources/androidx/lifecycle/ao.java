package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ViewModelStore.kt */
/* JADX INFO: loaded from: classes.dex */
public class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, aj> f2037a;

    public ao() {
        this.f2037a = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    public final void a(String r2, aj r3) {
        d.h.b.o.e(r2, "key");
        d.h.b.o.e(r3, "viewModel");
        aj r1 = (aj) ZeusTransformUtils.preCheckCast(this.f2037a.put(r2, r3), aj.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.a();
        return;
    }

    public final aj a(String r2) {
        d.h.b.o.e(r2, "key");
        return (aj) ZeusTransformUtils.preCheckCast(this.f2037a.get(r2), aj.class, "com.obric.aiagent.plugin");
    }

    public final Set<String> a() {
        return (Set) ZeusTransformUtils.preCheckCast(new HashSet((Collection) ZeusTransformUtils.preCheckCast(this.f2037a.keySet(), Collection.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin");
    }

    public final void b() {
        Iterator<aj> r0 = this.f2037a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((aj) ZeusTransformUtils.preCheckCast(r0.next(), aj.class, "com.obric.aiagent.plugin")).d();
        goto L4
    L6:
        this.f2037a.clear();
    }
}
