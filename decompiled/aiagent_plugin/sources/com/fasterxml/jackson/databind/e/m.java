package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: AnnotatedMethodMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements Iterable<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Map<z, k> f12641a;

    public m() {
    }

    public m(Map<z, k> r3) {
        this.f12641a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public k a(String r2, Class<?>[] r3) {
        Map<z, k> r1 = this.f12641a;
        if (r1 != null) goto L7;
        return null;
    L7:
        return (k) ZeusTransformUtils.preCheckCast(r1.get(new z(r2, r3)), k.class, "com.obric.aiagent.plugin");
    }

    @Override // java.lang.Iterable
    public Iterator<k> iterator() {
        Map<z, k> r0 = this.f12641a;
        if (r0 != null) goto L7;
        return Collections.emptyIterator();
    L7:
        return r0.values().iterator();
    }
}
