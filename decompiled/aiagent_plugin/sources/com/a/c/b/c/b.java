package com.a.c.b.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: And.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<e> f3121a;

    public b() {
        this.f3121a = new ArrayList();
    }

    @Override // com.a.c.b.c.e
    public b a(e r2) {
        this.f3121a.add(r2);
        return this;
    }

    @Override // com.a.c.b.c.e
    public e a(com.a.c.b.c.a.a r3) {
        return ((com.a.c.b.c.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.a.c.b.c.a.a.class, "com.obric.aiagent.plugin")).a(this);
    }

    @Override // com.a.c.b.c.e
    public String a() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= (this.f3121a.size() - 1)) goto L7;
        r0.append(((e) ZeusTransformUtils.preCheckCast(this.f3121a.get(r1), e.class, "com.obric.aiagent.plugin")).a());
        r0.append(",");
        r1 = r1 + 1;
        goto L4
    L7:
        if (this.f3121a.size() <= 0) goto L10;
        List<e> r5 = this.f3121a;
        r0.append(((e) ZeusTransformUtils.preCheckCast(r5.get(r5.size() - 1), e.class, "com.obric.aiagent.plugin")).a());
    L10:
        return r0.toString();
    }

    public List<e> b() {
        return Collections.unmodifiableList(this.f3121a);
    }
}
