package org.c.a.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: DirectiveToken.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h<T> extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f40504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<T> f40505b;

    public h(String r3, List<T> r4, org.c.a.c.a r5, org.c.a.c.a r6) {
        List<T> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        super(r5, r6);
        this.f40504a = r3;
        if (r7 != null) goto L5;
    L9:
        this.f40505b = r7;
        return;
    L5:
        if (r7.size() == 2) goto L9;
        throw new org.c.a.c.c("Two strings must be provided instead of " + String.valueOf(r7.size()));
    }

    public String a() {
        return this.f40504a;
    }

    public List<T> c() {
        return this.f40505b;
    }

    @Override // org.c.a.l.v
    public v.a b() {
        return v.a.g;
    }
}
