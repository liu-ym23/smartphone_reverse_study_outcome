package com.fasterxml.jackson.databind.c;

import com.fasterxml.jackson.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: PropertyBindingException.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Class<?> f12554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f12555e;
    protected final Collection<Object> g;
    protected transient String h;

    public g(k r3, String r4, com.fasterxml.jackson.a.i r5, Class<?> r6, String r7, Collection<Object> r8) {
        Collection<Object> r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.aiagent.plugin");
        super(r3, r4, r5);
        this.f12554d = r6;
        this.f12555e = r7;
        this.g = r9;
    }

    @Override // com.fasterxml.jackson.a.l
    public String e() {
        String r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (this.g == null) goto L27;
        StringBuilder r1 = new StringBuilder(100);
        int r2 = this.g.size();
        if (r2 != 1) goto L9;
        r1.append(" (one known property: \"");
        r1.append(String.valueOf(this.g.iterator().next()));
        r1.append('\"');
    L18:
        r1.append("])");
        String r3 = r1.toString();
        this.h = r3;
        return r3;
    L9:
        r1.append(" (").append(r2).append(" known properties: ");
        Iterator<Object> r4 = this.g.iterator();
    L11:
        if (r4.hasNext() == false) goto L18;
        r1.append('\"');
        r1.append(String.valueOf(r4.next()));
        r1.append('\"');
        if (r1.length() > 1000) goto L14;
        if (r4.hasNext() == false) goto L11;
        r1.append(", ");
        goto L11
    L14:
        r1.append(" [truncated]");
        goto L18
    L27:
        return r0;
    }
}
