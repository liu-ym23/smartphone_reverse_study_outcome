package com.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: CompositeCron.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Pattern f3072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<b> f3073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.a.c.a.c f3074c;

    public static /* synthetic */ boolean lambda$lubazpRIfurVbRzRXm5rbkvWU2c(a r0, b r1) {
        return r0.a(r1);
    }

    public a(List<b> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f3072a = Pattern.compile("\\|");
        this.f3073b = Collections.unmodifiableList(r6);
        com.a.e.a.a(r6, "List of Cron cannot be null or empty");
        boolean r0 = false;
        this.f3074c = ((b) ZeusTransformUtils.preCheckCast(r6.get(0), b.class, "com.obric.aiagent.plugin")).c();
        if (r6.size() != r6.stream().filter(new $$Lambda$a$lubazpRIfurVbRzRXm5rbkvWU2c(this)).count()) goto L5;
        r0 = true;
    L5:
        com.a.e.a.a(r0, "All Cron objects must have same definition for CompositeCron");
    }

    private /* synthetic */ boolean a(b r3) {
        return ((b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin")).c().equals(this.f3074c);
    }

    public List<b> a() {
        return this.f3073b;
    }

    @Override // com.a.c.b
    public com.a.c.b.a a(com.a.c.b.b r1) {
        throw new UnsupportedOperationException("Currently not supported for CompositeCron");
    }

    @Override // com.a.c.b
    public Map<com.a.c.b.b, com.a.c.b.a> b() {
        throw new UnsupportedOperationException("Currently not supported for CompositeCron");
    }

    @Override // com.a.c.b
    public com.a.c.a.c c() {
        return this.f3074c;
    }

    @Override // com.a.c.b
    public b d() {
        Iterator<b> r0 = this.f3073b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.aiagent.plugin")).d();
        goto L4
    L6:
        return this;
    }
}
