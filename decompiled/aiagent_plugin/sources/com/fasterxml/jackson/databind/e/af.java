package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: SimpleMixInResolver.java */
/* JADX INFO: loaded from: classes2.dex */
public class af implements u.a, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final u.a f12596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Map<com.fasterxml.jackson.databind.k.b, Class<?>> f12597b;

    public af(u.a r3) {
        this.f12596a = (u.a) ZeusTransformUtils.wrapperContextForParams(r3, u.a.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.e.u.a
    public Class<?> j(Class<?> r2) {
        u.a r0 = this.f12596a;
        if (r0 != null) goto L5;
        Class<?> r1 = null;
    L6:
        if (r1 != null) goto L11;
        Map<com.fasterxml.jackson.databind.k.b, Class<?>> r3 = this.f12597b;
        if (r3 != null) goto L10;
        return r1;
    L10:
        return (Class) ZeusTransformUtils.preCheckCast(r3.get(new com.fasterxml.jackson.databind.k.b(r2)), Class.class, "com.obric.aiagent.plugin");
    L11:
        return r1;
    L5:
        r1 = r0.j(r2);
        goto L6
    }

    public boolean a() {
        if (this.f12597b != null) goto L12;
        u.a r1 = this.f12596a;
        if (r1 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r1, af.class) == true) goto L11;
        return true;
    L11:
        return ((af) ZeusTransformUtils.preCheckCast(this.f12596a, af.class, "com.obric.aiagent.plugin")).a();
    L12:
        return true;
    }
}
